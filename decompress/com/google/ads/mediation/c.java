// 
// Decompiled by Procyon v0.6.0
// 

package com.google.ads.mediation;

import com.google.android.gms.ads.FullScreenContentCallback;
import com.google.android.gms.ads.interstitial.InterstitialAd;
import com.google.android.gms.ads.AdError;
import com.google.android.gms.ads.mediation.MediationInterstitialAdapter;
import com.google.android.gms.ads.LoadAdError;
import com.google.android.gms.ads.mediation.MediationInterstitialListener;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.ads.interstitial.InterstitialAdLoadCallback;

@VisibleForTesting
final class c extends InterstitialAdLoadCallback
{
    @VisibleForTesting
    final AbstractAdViewAdapter a;
    @VisibleForTesting
    final MediationInterstitialListener b;
    
    public c(final AbstractAdViewAdapter a, final MediationInterstitialListener b) {
        this.a = a;
        this.b = b;
    }
    
    @Override
    public final void onAdFailedToLoad(final LoadAdError loadAdError) {
        this.b.onAdFailedToLoad((MediationInterstitialAdapter)this.a, loadAdError);
    }
    
    @Override
    public final /* bridge */ void onAdLoaded(final Object o) {
        final InterstitialAd mInterstitialAd = (InterstitialAd)o;
        final AbstractAdViewAdapter a = this.a;
        (a.mInterstitialAd = mInterstitialAd).setFullScreenContentCallback(new d(a, this.b));
        this.b.onAdLoaded((MediationInterstitialAdapter)this.a);
    }
}
