// 
// Decompiled by Procyon v0.6.0
// 

package com.android.billingclient.api;

import com.google.android.gms.internal.play_billing.zzb;
import android.os.Bundle;
import android.os.ResultReceiver;

final class zzak extends ResultReceiver
{
    final j a;
    
    public final void onReceiveResult(final int n, final Bundle bundle) {
        this.a.a(zzb.zzj(bundle, "BillingClient"));
    }
}
