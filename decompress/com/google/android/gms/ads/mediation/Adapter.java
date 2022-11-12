// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.gms.ads.mediation;

import com.google.android.gms.ads.AdError;
import java.util.List;
import android.content.Context;

public abstract class Adapter implements MediationExtrasReceiver
{
    public abstract VersionInfo getSDKVersionInfo();
    
    public abstract VersionInfo getVersionInfo();
    
    public abstract void initialize(final Context p0, final InitializationCompleteCallback p1, final List<MediationConfiguration> p2);
    
    public void loadBannerAd(final MediationBannerAdConfiguration mediationBannerAdConfiguration, final MediationAdLoadCallback<MediationBannerAd, MediationBannerAdCallback> mediationAdLoadCallback) {
        mediationAdLoadCallback.a(new AdError(7, this.getClass().getSimpleName().concat(" does not support banner ads."), "com.google.android.gms.ads"));
    }
    
    public void loadInterscrollerAd(final MediationBannerAdConfiguration mediationBannerAdConfiguration, final MediationAdLoadCallback<MediationInterscrollerAd, MediationBannerAdCallback> mediationAdLoadCallback) {
        mediationAdLoadCallback.a(new AdError(7, this.getClass().getSimpleName().concat(" does not support interscroller ads."), "com.google.android.gms.ads"));
    }
    
    public void loadInterstitialAd(final MediationInterstitialAdConfiguration mediationInterstitialAdConfiguration, final MediationAdLoadCallback<MediationInterstitialAd, MediationInterstitialAdCallback> mediationAdLoadCallback) {
        mediationAdLoadCallback.a(new AdError(7, this.getClass().getSimpleName().concat(" does not support interstitial ads."), "com.google.android.gms.ads"));
    }
    
    public void loadNativeAd(final MediationNativeAdConfiguration mediationNativeAdConfiguration, final MediationAdLoadCallback<UnifiedNativeAdMapper, MediationNativeAdCallback> mediationAdLoadCallback) {
        mediationAdLoadCallback.a(new AdError(7, this.getClass().getSimpleName().concat(" does not support native ads."), "com.google.android.gms.ads"));
    }
    
    public void loadRewardedAd(final MediationRewardedAdConfiguration mediationRewardedAdConfiguration, final MediationAdLoadCallback<MediationRewardedAd, MediationRewardedAdCallback> mediationAdLoadCallback) {
        mediationAdLoadCallback.a(new AdError(7, this.getClass().getSimpleName().concat(" does not support rewarded ads."), "com.google.android.gms.ads"));
    }
    
    public void loadRewardedInterstitialAd(final MediationRewardedAdConfiguration mediationRewardedAdConfiguration, final MediationAdLoadCallback<MediationRewardedAd, MediationRewardedAdCallback> mediationAdLoadCallback) {
        mediationAdLoadCallback.a(new AdError(7, this.getClass().getSimpleName().concat(" does not support rewarded interstitial ads."), "com.google.android.gms.ads"));
    }
}
