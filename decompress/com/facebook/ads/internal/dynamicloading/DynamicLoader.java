// 
// Decompiled by Procyon v0.6.0
// 

package com.facebook.ads.internal.dynamicloading;

import com.facebook.ads.internal.api.InitApi;
import com.facebook.ads.internal.api.RewardedVideoAdApi;
import com.facebook.ads.RewardedVideoAd;
import com.facebook.ads.internal.api.RewardedInterstitialAdApi;
import com.facebook.ads.RewardedInterstitialAd;
import com.facebook.ads.internal.api.NativeComponentTagApi;
import com.facebook.ads.internal.api.NativeBannerAdViewApi;
import com.facebook.ads.internal.api.NativeBannerAdApi;
import com.facebook.ads.NativeBannerAd;
import com.facebook.ads.internal.api.NativeAdsManagerApi;
import com.facebook.ads.internal.api.NativeAdViewTypeApi;
import com.facebook.ads.internal.api.NativeAdViewAttributesApi;
import com.facebook.ads.internal.api.NativeAdViewApi;
import com.facebook.ads.internal.api.NativeAdScrollViewApi;
import com.facebook.ads.NativeAdViewAttributes;
import com.facebook.ads.NativeAdView;
import com.facebook.ads.NativeAdsManager;
import com.facebook.ads.NativeAdScrollView;
import com.facebook.ads.internal.api.NativeAdRatingApi;
import com.facebook.ads.internal.api.NativeAdLayoutApi;
import com.facebook.ads.internal.api.NativeAdImageApi;
import org.json.JSONObject;
import com.facebook.ads.internal.api.NativeAdApi;
import com.facebook.ads.internal.api.NativeAdBaseApi;
import com.facebook.ads.NativeAd;
import com.facebook.ads.internal.api.MediaViewVideoRendererApi;
import com.facebook.ads.internal.api.MediaViewApi;
import com.facebook.ads.internal.api.InterstitialAdApi;
import com.facebook.ads.InterstitialAd;
import com.facebook.ads.internal.api.DefaultMediaViewVideoRendererApi;
import com.facebook.ads.internal.api.BidderTokenProviderApi;
import com.facebook.ads.internal.api.AudienceNetworkAdsApi;
import com.facebook.ads.internal.api.AudienceNetworkActivityApi;
import com.facebook.ads.AudienceNetworkActivity;
import com.facebook.ads.internal.api.AdViewApi;
import com.facebook.ads.AdView;
import com.facebook.ads.internal.api.AdViewParentApi;
import com.facebook.ads.AdSize;
import com.facebook.ads.internal.api.AdSizeApi;
import com.facebook.ads.internal.api.AdSettingsApi;
import com.facebook.ads.internal.api.AdOptionsViewApi;
import com.facebook.ads.AdOptionsView;
import com.facebook.ads.NativeAdLayout;
import com.facebook.ads.NativeAdBase;
import android.content.Context;
import com.facebook.ads.internal.api.AdCompanionViewApi;
import androidx.annotation.Keep;

@Keep
public interface DynamicLoader
{
    AdCompanionViewApi createAdCompanionViewApi();
    
    AdOptionsViewApi createAdOptionsView(final Context p0, final NativeAdBase p1, final NativeAdLayout p2, final AdOptionsView.Orientation p3, final int p4, final AdOptionsView p5);
    
    AdOptionsViewApi createAdOptionsView(final Context p0, final NativeAdBase p1, final NativeAdLayout p2, final AdOptionsView p3);
    
    AdSettingsApi createAdSettingsApi();
    
    AdSizeApi createAdSizeApi(final int p0);
    
    AdViewApi createAdViewApi(final Context p0, final String p1, final AdSize p2, final AdViewParentApi p3, final AdView p4);
    
    AdViewApi createAdViewApi(final Context p0, final String p1, final String p2, final AdViewParentApi p3, final AdView p4) throws Exception;
    
    AudienceNetworkActivityApi createAudienceNetworkActivity(final AudienceNetworkActivity p0, final AudienceNetworkActivityApi p1);
    
    AudienceNetworkAdsApi createAudienceNetworkAdsApi();
    
    BidderTokenProviderApi createBidderTokenProviderApi();
    
    DefaultMediaViewVideoRendererApi createDefaultMediaViewVideoRendererApi();
    
    InterstitialAdApi createInterstitialAd(final Context p0, final String p1, final InterstitialAd p2);
    
    MediaViewApi createMediaViewApi();
    
    MediaViewVideoRendererApi createMediaViewVideoRendererApi();
    
    NativeAdApi createNativeAdApi(final NativeAd p0, final NativeAdBaseApi p1);
    
    NativeAdApi createNativeAdApi(final NativeAdBase p0, final NativeAd p1, final NativeAdBaseApi p2);
    
    NativeAdBaseApi createNativeAdBaseApi(final Context p0, final String p1);
    
    NativeAdBaseApi createNativeAdBaseApi(final NativeAdBaseApi p0);
    
    NativeAdBase createNativeAdBaseFromBidPayload(final Context p0, final String p1, final String p2) throws Exception;
    
    NativeAdImageApi createNativeAdImageApi(final JSONObject p0);
    
    NativeAdLayoutApi createNativeAdLayoutApi();
    
    NativeAdRatingApi createNativeAdRatingApi(final JSONObject p0);
    
    NativeAdScrollViewApi createNativeAdScrollViewApi(final NativeAdScrollView p0, final Context p1, final NativeAdsManager p2, final NativeAdScrollView.AdViewProvider p3, final int p4, final NativeAdView.Type p5, final NativeAdViewAttributes p6, final int p7);
    
    NativeAdViewApi createNativeAdViewApi();
    
    NativeAdViewAttributesApi createNativeAdViewAttributesApi();
    
    NativeAdViewTypeApi createNativeAdViewTypeApi(final int p0);
    
    NativeAdsManagerApi createNativeAdsManagerApi(final Context p0, final String p1, final int p2);
    
    NativeBannerAdApi createNativeBannerAdApi(final NativeBannerAd p0, final NativeAdBaseApi p1);
    
    NativeBannerAdViewApi createNativeBannerAdViewApi();
    
    NativeComponentTagApi createNativeComponentTagApi();
    
    RewardedInterstitialAdApi createRewardedInterstitialAd(final Context p0, final String p1, final RewardedInterstitialAd p2);
    
    RewardedVideoAdApi createRewardedVideoAd(final Context p0, final String p1, final RewardedVideoAd p2);
    
    InitApi getInitApi();
    
    void maybeInitInternally(final Context p0);
}
