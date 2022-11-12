// 
// Decompiled by Procyon v0.6.0
// 

package com.google.ads.mediation;

import com.google.android.gms.ads.mediation.MediationInterstitialAdapter;
import com.google.android.gms.ads.mediation.MediationInterstitialListener;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.ads.FullScreenContentCallback;

@VisibleForTesting
final class d extends FullScreenContentCallback
{
    @VisibleForTesting
    final AbstractAdViewAdapter a;
    @VisibleForTesting
    final MediationInterstitialListener b;
    
    public d(final AbstractAdViewAdapter a, final MediationInterstitialListener b) {
        this.a = a;
        this.b = b;
    }
    
    @Override
    public final void onAdDismissedFullScreenContent() {
        this.b.onAdClosed((MediationInterstitialAdapter)this.a);
    }
    
    @Override
    public final void onAdShowedFullScreenContent() {
        this.b.onAdOpened((MediationInterstitialAdapter)this.a);
    }
}
