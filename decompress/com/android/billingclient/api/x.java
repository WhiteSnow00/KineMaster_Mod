// 
// Decompiled by Procyon v0.6.0
// 

package com.android.billingclient.api;

import com.google.android.gms.internal.play_billing.zzb;
import java.util.concurrent.Future;

public final class x implements Runnable
{
    public final Future a;
    public final Runnable b;
    
    public x(final Future a, final Runnable b) {
        this.a = a;
        this.b = b;
    }
    
    @Override
    public final void run() {
        final Future a = this.a;
        final Runnable b = this.b;
        if (!a.isDone() && !a.isCancelled()) {
            a.cancel(true);
            zzb.zzo("BillingClient", "Async task is taking too long, cancel it!");
            if (b != null) {
                b.run();
            }
        }
    }
}
