// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.gms.ads.mediation;

import com.google.android.gms.ads.AdError;

@Deprecated
public interface MediationBannerListener
{
    void onAdClicked(final MediationBannerAdapter p0);
    
    void onAdClosed(final MediationBannerAdapter p0);
    
    void onAdFailedToLoad(final MediationBannerAdapter p0, final AdError p1);
    
    void onAdLeftApplication(final MediationBannerAdapter p0);
    
    void onAdLoaded(final MediationBannerAdapter p0);
    
    void onAdOpened(final MediationBannerAdapter p0);
    
    void zzd(final MediationBannerAdapter p0, final String p1, final String p2);
}
