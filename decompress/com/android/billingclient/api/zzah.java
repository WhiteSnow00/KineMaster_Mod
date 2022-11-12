// 
// Decompiled by Procyon v0.6.0
// 

package com.android.billingclient.api;

import com.google.android.gms.internal.play_billing.zzb;
import android.os.Bundle;
import android.os.ResultReceiver;

final class zzah extends ResultReceiver
{
    final l a;
    
    public final void onReceiveResult(final int n, final Bundle bundle) {
        final g.a c = g.c();
        c.c(n);
        c.b(zzb.zzk(bundle, "BillingClient"));
        this.a.a(c.a());
    }
}
