// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.gms.ads.mediation.rtb;

import com.google.android.gms.ads.mediation.MediationRewardedAdCallback;
import com.google.android.gms.ads.mediation.MediationRewardedAd;
import com.google.android.gms.ads.mediation.MediationRewardedAdConfiguration;
import com.google.android.gms.ads.mediation.MediationNativeAdCallback;
import com.google.android.gms.ads.mediation.UnifiedNativeAdMapper;
import com.google.android.gms.ads.mediation.MediationNativeAdConfiguration;
import com.google.android.gms.ads.mediation.MediationInterstitialAdCallback;
import com.google.android.gms.ads.mediation.MediationInterstitialAd;
import com.google.android.gms.ads.mediation.MediationInterstitialAdConfiguration;
import com.google.android.gms.ads.AdError;
import com.google.android.gms.ads.mediation.MediationInterscrollerAd;
import com.google.android.gms.ads.mediation.MediationBannerAdCallback;
import com.google.android.gms.ads.mediation.MediationBannerAd;
import com.google.android.gms.ads.mediation.MediationAdLoadCallback;
import com.google.android.gms.ads.mediation.MediationBannerAdConfiguration;
import javax.annotation.ParametersAreNonnullByDefault;
import com.google.android.gms.ads.mediation.Adapter;

@ParametersAreNonnullByDefault
public abstract class RtbAdapter extends Adapter
{
    public abstract void collectSignals(final RtbSignalData p0, final SignalCallbacks p1);
    
    public void loadRtbBannerAd(final MediationBannerAdConfiguration mediationBannerAdConfiguration, final MediationAdLoadCallback<MediationBannerAd, MediationBannerAdCallback> mediationAdLoadCallback) {
        this.loadBannerAd(mediationBannerAdConfiguration, mediationAdLoadCallback);
    }
    
    public void loadRtbInterscrollerAd(final MediationBannerAdConfiguration mediationBannerAdConfiguration, final MediationAdLoadCallback<MediationInterscrollerAd, MediationBannerAdCallback> mediationAdLoadCallback) {
        mediationAdLoadCallback.a(new AdError(7, this.getClass().getSimpleName().concat(" does not support interscroller ads."), "com.google.android.gms.ads"));
    }
    
    public void loadRtbInterstitialAd(final MediationInterstitialAdConfiguration mediationInterstitialAdConfiguration, final MediationAdLoadCallback<MediationInterstitialAd, MediationInterstitialAdCallback> mediationAdLoadCallback) {
        this.loadInterstitialAd(mediationInterstitialAdConfiguration, mediationAdLoadCallback);
    }
    
    public void loadRtbNativeAd(final MediationNativeAdConfiguration mediationNativeAdConfiguration, final MediationAdLoadCallback<UnifiedNativeAdMapper, MediationNativeAdCallback> mediationAdLoadCallback) {
        this.loadNativeAd(mediationNativeAdConfiguration, mediationAdLoadCallback);
    }
    
    public void loadRtbRewardedAd(final MediationRewardedAdConfiguration mediationRewardedAdConfiguration, final MediationAdLoadCallback<MediationRewardedAd, MediationRewardedAdCallback> mediationAdLoadCallback) {
        this.loadRewardedAd(mediationRewardedAdConfiguration, mediationAdLoadCallback);
    }
    
    public void loadRtbRewardedInterstitialAd(final MediationRewardedAdConfiguration mediationRewardedAdConfiguration, final MediationAdLoadCallback<MediationRewardedAd, MediationRewardedAdCallback> mediationAdLoadCallback) {
        this.loadRewardedInterstitialAd(mediationRewardedAdConfiguration, mediationAdLoadCallback);
    }
}
