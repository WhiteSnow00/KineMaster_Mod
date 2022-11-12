// 
// Decompiled by Procyon v0.6.0
// 

package com.android.billingclient.api;

import java.util.List;
import com.google.android.gms.internal.play_billing.zzu;

public final class w implements Runnable
{
    public final p a;
    
    public w(final p a) {
        this.a = a;
    }
    
    @Override
    public final void run() {
        this.a.a(p0.n, (List<Purchase>)zzu.zzl());
    }
}
