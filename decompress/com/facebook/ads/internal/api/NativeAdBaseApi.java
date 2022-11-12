// 
// Decompiled by Procyon v0.6.0
// 

package com.facebook.ads.internal.api;

import android.view.View$OnTouchListener;
import com.facebook.ads.ExtraHints;
import android.graphics.drawable.Drawable;
import com.facebook.ads.NativeAdBase;
import androidx.annotation.Keep;

@Keep
public interface NativeAdBaseApi
{
    NativeAdBase.NativeAdLoadConfigBuilder buildLoadAdConfig(final NativeAdBase p0);
    
    void destroy();
    
    void downloadMedia();
    
    String getAdBodyText();
    
    String getAdCallToAction();
    
    NativeAdImageApi getAdChoicesIcon();
    
    String getAdChoicesImageUrl();
    
    String getAdChoicesLinkUrl();
    
    String getAdChoicesText();
    
    NativeAdImageApi getAdCoverImage();
    
    String getAdHeadline();
    
    NativeAdImageApi getAdIcon();
    
    String getAdLinkDescription();
    
    String getAdSocialContext();
    
    @Deprecated
    NativeAdRatingApi getAdStarRating();
    
    String getAdTranslation();
    
    String getAdUntrimmedBodyText();
    
    String getAdvertiserName();
    
    float getAspectRatio();
    
    String getId();
    
    String getPlacementId();
    
    Drawable getPreloadedIconViewDrawable();
    
    String getPromotedTranslation();
    
    String getSponsoredTranslation();
    
    boolean hasCallToAction();
    
    boolean isAdInvalidated();
    
    boolean isAdLoaded();
    
    void loadAd();
    
    void loadAd(final NativeAdBase.NativeLoadAdConfig p0);
    
    void onCtaBroadcast();
    
    void setExtraHints(final ExtraHints p0);
    
    void setOnTouchListener(final View$OnTouchListener p0);
    
    void unregisterView();
}
