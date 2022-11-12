// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.gms.ads.mediation;

import com.google.android.gms.ads.formats.NativeCustomTemplateAd;
import com.google.android.gms.ads.AdError;

@Deprecated
public interface MediationNativeListener
{
    void onAdClicked(final MediationNativeAdapter p0);
    
    void onAdClosed(final MediationNativeAdapter p0);
    
    @Deprecated
    void onAdFailedToLoad(final MediationNativeAdapter p0, final int p1);
    
    void onAdFailedToLoad(final MediationNativeAdapter p0, final AdError p1);
    
    void onAdImpression(final MediationNativeAdapter p0);
    
    void onAdLeftApplication(final MediationNativeAdapter p0);
    
    void onAdLoaded(final MediationNativeAdapter p0, final UnifiedNativeAdMapper p1);
    
    void onAdOpened(final MediationNativeAdapter p0);
    
    void onVideoEnd(final MediationNativeAdapter p0);
    
    void zzc(final MediationNativeAdapter p0, final NativeCustomTemplateAd p1);
    
    void zze(final MediationNativeAdapter p0, final NativeCustomTemplateAd p1, final String p2);
}
