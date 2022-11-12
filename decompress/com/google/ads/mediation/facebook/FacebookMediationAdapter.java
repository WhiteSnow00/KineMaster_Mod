// 
// Decompiled by Procyon v0.6.0
// 

package com.google.ads.mediation.facebook;

import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Retention;
import com.google.android.gms.ads.mediation.MediationRewardedAdCallback;
import com.google.android.gms.ads.mediation.MediationRewardedAd;
import com.google.android.gms.ads.mediation.MediationRewardedAdConfiguration;
import com.google.android.gms.ads.mediation.MediationNativeAdCallback;
import com.google.android.gms.ads.mediation.UnifiedNativeAdMapper;
import com.google.android.gms.ads.mediation.MediationNativeAdConfiguration;
import com.google.android.gms.ads.mediation.MediationInterstitialAdCallback;
import com.google.android.gms.ads.mediation.MediationInterstitialAd;
import com.google.android.gms.ads.mediation.MediationInterstitialAdConfiguration;
import com.google.android.gms.ads.mediation.MediationBannerAdCallback;
import com.google.android.gms.ads.mediation.MediationBannerAd;
import com.google.android.gms.ads.mediation.MediationAdLoadCallback;
import com.google.android.gms.ads.mediation.MediationBannerAdConfiguration;
import java.util.Iterator;
import android.text.TextUtils;
import java.util.ArrayList;
import com.google.android.gms.ads.mediation.MediationConfiguration;
import java.util.List;
import com.google.android.gms.ads.mediation.InitializationCompleteCallback;
import android.content.Context;
import android.util.Log;
import com.google.android.gms.ads.mediation.VersionInfo;
import com.facebook.ads.BidderTokenProvider;
import com.google.android.gms.ads.mediation.rtb.SignalCallbacks;
import com.google.android.gms.ads.mediation.rtb.RtbSignalData;
import com.facebook.ads.AdSettings;
import com.google.android.gms.ads.mediation.MediationAdConfiguration;
import android.os.Bundle;
import com.facebook.ads.AdError;
import com.google.ads.mediation.facebook.rtb.FacebookRtbNativeAd;
import com.google.ads.mediation.facebook.rtb.FacebookRtbInterstitialAd;
import com.google.ads.mediation.facebook.rtb.FacebookRtbBannerAd;
import com.google.android.gms.ads.mediation.rtb.RtbAdapter;

public class FacebookMediationAdapter extends RtbAdapter
{
    public static final int ERROR_ADVIEW_CONSTRUCTOR_EXCEPTION = 111;
    public static final int ERROR_BANNER_SIZE_MISMATCH = 102;
    public static final int ERROR_CREATE_NATIVE_AD_FROM_BID_PAYLOAD = 109;
    public static final String ERROR_DOMAIN = "com.google.ads.mediation.facebook";
    public static final int ERROR_FACEBOOK_INITIALIZATION = 104;
    public static final int ERROR_FAILED_TO_PRESENT_AD = 110;
    public static final int ERROR_INVALID_SERVER_PARAMETERS = 101;
    public static final int ERROR_MAPPING_NATIVE_ASSETS = 108;
    public static final int ERROR_NULL_CONTEXT = 107;
    public static final int ERROR_REQUIRES_ACTIVITY_CONTEXT = 103;
    public static final int ERROR_REQUIRES_UNIFIED_NATIVE_ADS = 105;
    public static final int ERROR_WRONG_NATIVE_TYPE = 106;
    public static final String FACEBOOK_SDK_ERROR_DOMAIN = "com.facebook.ads";
    public static final String PLACEMENT_PARAMETER = "pubid";
    public static final String RTB_PLACEMENT_PARAMETER = "placement_id";
    public static final String TAG;
    private FacebookRtbBannerAd banner;
    private FacebookRtbInterstitialAd interstitial;
    private FacebookRtbNativeAd nativeAd;
    private FacebookRewardedAd rewardedAd;
    private FacebookRewardedInterstitialAd rewardedInterstitialAd;
    
    static {
        TAG = FacebookAdapter.class.getSimpleName();
    }
    
    public static com.google.android.gms.ads.AdError getAdError(final AdError adError) {
        return new com.google.android.gms.ads.AdError(adError.getErrorCode(), adError.getErrorMessage(), "com.facebook.ads");
    }
    
    public static String getPlacementID(final Bundle bundle) {
        String s;
        if ((s = bundle.getString("placement_id")) == null) {
            s = bundle.getString("pubid");
        }
        return s;
    }
    
    public static void setMixedAudience(final MediationAdConfiguration mediationAdConfiguration) {
        if (mediationAdConfiguration.e() == 1) {
            AdSettings.setMixedAudience(true);
        }
        else if (mediationAdConfiguration.e() == 0) {
            AdSettings.setMixedAudience(false);
        }
    }
    
    @Override
    public void collectSignals(final RtbSignalData rtbSignalData, final SignalCallbacks signalCallbacks) {
        signalCallbacks.a(BidderTokenProvider.getBidderToken(rtbSignalData.a()));
    }
    
    @Override
    public VersionInfo getSDKVersionInfo() {
        final String[] split = "6.11.0".split("\\.");
        if (split.length >= 3) {
            return new VersionInfo(Integer.parseInt(split[0]), Integer.parseInt(split[1]), Integer.parseInt(split[2]));
        }
        Log.w(FacebookMediationAdapter.TAG, String.format("Unexpected SDK version format: %s.Returning 0.0.0 for SDK version.", "6.11.0"));
        return new VersionInfo(0, 0, 0);
    }
    
    @Override
    public VersionInfo getVersionInfo() {
        final String[] split = "6.11.0.1".split("\\.");
        if (split.length >= 4) {
            return new VersionInfo(Integer.parseInt(split[0]), Integer.parseInt(split[1]), Integer.parseInt(split[2]) * 100 + Integer.parseInt(split[3]));
        }
        Log.w(FacebookMediationAdapter.TAG, String.format("Unexpected adapter version format: %s.Returning 0.0.0 for adapter version.", "6.11.0.1"));
        return new VersionInfo(0, 0, 0);
    }
    
    @Override
    public void initialize(final Context context, final InitializationCompleteCallback initializationCompleteCallback, final List<MediationConfiguration> list) {
        final ArrayList list2 = new ArrayList();
        final Iterator<MediationConfiguration> iterator = list.iterator();
        while (iterator.hasNext()) {
            final String placementID = getPlacementID(iterator.next().a());
            if (!TextUtils.isEmpty((CharSequence)placementID)) {
                list2.add(placementID);
            }
        }
        if (list2.isEmpty()) {
            initializationCompleteCallback.a("Initialization failed. No placement IDs found.");
            return;
        }
        a.a().c(context, list2, (a.a)new a.a(this, initializationCompleteCallback) {
            final InitializationCompleteCallback a;
            final FacebookMediationAdapter b;
            
            @Override
            public void a(final com.google.android.gms.ads.AdError adError) {
                this.a.a(adError.c());
            }
            
            @Override
            public void b() {
                this.a.b();
            }
        });
    }
    
    @Override
    public void loadBannerAd(final MediationBannerAdConfiguration mediationBannerAdConfiguration, final MediationAdLoadCallback<MediationBannerAd, MediationBannerAdCallback> mediationAdLoadCallback) {
        (this.banner = new FacebookRtbBannerAd(mediationBannerAdConfiguration, mediationAdLoadCallback)).c();
    }
    
    @Override
    public void loadInterstitialAd(final MediationInterstitialAdConfiguration mediationInterstitialAdConfiguration, final MediationAdLoadCallback<MediationInterstitialAd, MediationInterstitialAdCallback> mediationAdLoadCallback) {
        (this.interstitial = new FacebookRtbInterstitialAd(mediationInterstitialAdConfiguration, mediationAdLoadCallback)).b();
    }
    
    @Override
    public void loadNativeAd(final MediationNativeAdConfiguration mediationNativeAdConfiguration, final MediationAdLoadCallback<UnifiedNativeAdMapper, MediationNativeAdCallback> mediationAdLoadCallback) {
        (this.nativeAd = new FacebookRtbNativeAd(mediationNativeAdConfiguration, mediationAdLoadCallback)).U();
    }
    
    @Override
    public void loadRewardedAd(final MediationRewardedAdConfiguration mediationRewardedAdConfiguration, final MediationAdLoadCallback<MediationRewardedAd, MediationRewardedAdCallback> mediationAdLoadCallback) {
        (this.rewardedAd = new FacebookRewardedAd(mediationRewardedAdConfiguration, mediationAdLoadCallback)).f();
    }
    
    @Override
    public void loadRewardedInterstitialAd(final MediationRewardedAdConfiguration mediationRewardedAdConfiguration, final MediationAdLoadCallback<MediationRewardedAd, MediationRewardedAdCallback> mediationAdLoadCallback) {
        Log.w(FacebookMediationAdapter.TAG, "Facebook waterfall mediation is deprecated and will be removed in a future adapter version. Please update to serve bidding ads instead. See https://fb.me/bNFn7qt6Z0sKtF for more information.");
        (this.rewardedInterstitialAd = new FacebookRewardedInterstitialAd(mediationRewardedAdConfiguration, mediationAdLoadCallback)).f();
    }
    
    @Override
    public void loadRtbRewardedInterstitialAd(final MediationRewardedAdConfiguration mediationRewardedAdConfiguration, final MediationAdLoadCallback<MediationRewardedAd, MediationRewardedAdCallback> mediationAdLoadCallback) {
        (this.rewardedInterstitialAd = new FacebookRewardedInterstitialAd(mediationRewardedAdConfiguration, mediationAdLoadCallback)).f();
    }
    
    @Retention(RetentionPolicy.SOURCE)
    public @interface AdapterError {
    }
}
