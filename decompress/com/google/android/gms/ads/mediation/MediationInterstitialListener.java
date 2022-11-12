// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.gms.ads.mediation;

import com.google.android.gms.ads.AdError;

@Deprecated
public interface MediationInterstitialListener
{
    void onAdClicked(final MediationInterstitialAdapter p0);
    
    void onAdClosed(final MediationInterstitialAdapter p0);
    
    @Deprecated
    void onAdFailedToLoad(final MediationInterstitialAdapter p0, final int p1);
    
    void onAdFailedToLoad(final MediationInterstitialAdapter p0, final AdError p1);
    
    void onAdLeftApplication(final MediationInterstitialAdapter p0);
    
    void onAdLoaded(final MediationInterstitialAdapter p0);
    
    void onAdOpened(final MediationInterstitialAdapter p0);
}
