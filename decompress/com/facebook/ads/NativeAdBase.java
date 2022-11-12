// 
// Decompiled by Procyon v0.6.0
// 

package com.facebook.ads;

import com.facebook.ads.internal.api.NativeAdRatingApi;
import android.view.View;
import org.json.JSONObject;
import com.facebook.ads.internal.api.NativeAdImageApi;
import android.view.View$OnTouchListener;
import android.graphics.drawable.Drawable;
import com.facebook.ads.internal.bench.Benchmark;
import com.facebook.ads.internal.dynamicloading.DynamicLoaderFactory;
import android.content.Context;
import com.facebook.ads.internal.api.NativeAdBaseApi;
import com.facebook.infer.annotation.Nullsafe$Mode;
import com.facebook.infer.annotation.Nullsafe;
import androidx.annotation.Keep;

@Keep
@Nullsafe(Nullsafe$Mode.LOCAL)
public abstract class NativeAdBase implements Ad
{
    final NativeAdBaseApi mNativeAdBaseApi;
    
    @Benchmark
    NativeAdBase(final Context context, final NativeAdBase nativeAdBase) {
        this.mNativeAdBaseApi = DynamicLoaderFactory.makeLoader(context).createNativeAdBaseApi(nativeAdBase.mNativeAdBaseApi);
    }
    
    @Benchmark
    public NativeAdBase(final Context context, final String s) {
        this.mNativeAdBaseApi = DynamicLoaderFactory.makeLoader(context).createNativeAdBaseApi(context, s);
    }
    
    @Benchmark
    public NativeAdBase(final NativeAdBaseApi mNativeAdBaseApi) {
        this.mNativeAdBaseApi = mNativeAdBaseApi;
    }
    
    @Benchmark
    public static NativeAdBase fromBidPayload(final Context context, final String s, final String s2) throws Exception {
        return DynamicLoaderFactory.makeLoader(context).createNativeAdBaseFromBidPayload(context, s, s2);
    }
    
    @Benchmark(failAtMillis = 5, warnAtMillis = 1)
    public NativeAdLoadConfigBuilder buildLoadAdConfig() {
        return this.mNativeAdBaseApi.buildLoadAdConfig(this);
    }
    
    @Override
    public void destroy() {
        this.mNativeAdBaseApi.destroy();
    }
    
    @Benchmark
    public void downloadMedia() {
        this.mNativeAdBaseApi.downloadMedia();
    }
    
    @Benchmark(failAtMillis = 5, warnAtMillis = 1)
    public String getAdBodyText() {
        return this.mNativeAdBaseApi.getAdBodyText();
    }
    
    @Benchmark(failAtMillis = 5, warnAtMillis = 1)
    public String getAdCallToAction() {
        return this.mNativeAdBaseApi.getAdCallToAction();
    }
    
    @Benchmark(failAtMillis = 5, warnAtMillis = 1)
    public Image getAdChoicesIcon() {
        Image image;
        if (this.mNativeAdBaseApi.getAdChoicesIcon() == null) {
            image = null;
        }
        else {
            image = new Image(this.mNativeAdBaseApi.getAdChoicesIcon());
        }
        return image;
    }
    
    @Benchmark(failAtMillis = 5, warnAtMillis = 1)
    public String getAdChoicesImageUrl() {
        return this.mNativeAdBaseApi.getAdChoicesImageUrl();
    }
    
    @Benchmark(failAtMillis = 5, warnAtMillis = 1)
    public String getAdChoicesLinkUrl() {
        return this.mNativeAdBaseApi.getAdChoicesLinkUrl();
    }
    
    @Benchmark(failAtMillis = 5, warnAtMillis = 1)
    public String getAdChoicesText() {
        return this.mNativeAdBaseApi.getAdChoicesText();
    }
    
    @Benchmark(failAtMillis = 5, warnAtMillis = 1)
    public Image getAdCoverImage() {
        Image image;
        if (this.mNativeAdBaseApi.getAdCoverImage() == null) {
            image = null;
        }
        else {
            image = new Image(this.mNativeAdBaseApi.getAdCoverImage());
        }
        return image;
    }
    
    @Benchmark(failAtMillis = 5, warnAtMillis = 1)
    public String getAdHeadline() {
        return this.mNativeAdBaseApi.getAdHeadline();
    }
    
    @Benchmark(failAtMillis = 5, warnAtMillis = 1)
    public Image getAdIcon() {
        Image image;
        if (this.mNativeAdBaseApi.getAdIcon() == null) {
            image = null;
        }
        else {
            image = new Image(this.mNativeAdBaseApi.getAdIcon());
        }
        return image;
    }
    
    @Benchmark(failAtMillis = 5, warnAtMillis = 1)
    public String getAdLinkDescription() {
        return this.mNativeAdBaseApi.getAdLinkDescription();
    }
    
    @Benchmark(failAtMillis = 5, warnAtMillis = 1)
    public String getAdSocialContext() {
        return this.mNativeAdBaseApi.getAdSocialContext();
    }
    
    @Deprecated
    @Benchmark(failAtMillis = 5, warnAtMillis = 1)
    public Rating getAdStarRating() {
        Rating rating;
        if (this.mNativeAdBaseApi.getAdStarRating() == null) {
            rating = null;
        }
        else {
            rating = new Rating(this.mNativeAdBaseApi.getAdStarRating());
        }
        return rating;
    }
    
    @Benchmark(failAtMillis = 5, warnAtMillis = 1)
    public String getAdTranslation() {
        return this.mNativeAdBaseApi.getAdTranslation();
    }
    
    @Benchmark(failAtMillis = 5, warnAtMillis = 1)
    public String getAdUntrimmedBodyText() {
        return this.mNativeAdBaseApi.getAdUntrimmedBodyText();
    }
    
    @Deprecated
    @Benchmark(failAtMillis = 5, warnAtMillis = 1)
    public NativeAdViewAttributes getAdViewAttributes() {
        return new NativeAdViewAttributes();
    }
    
    @Benchmark(failAtMillis = 5, warnAtMillis = 1)
    public String getAdvertiserName() {
        return this.mNativeAdBaseApi.getAdvertiserName();
    }
    
    @Benchmark(failAtMillis = 5, warnAtMillis = 1)
    public float getAspectRatio() {
        return this.mNativeAdBaseApi.getAspectRatio();
    }
    
    @Benchmark(failAtMillis = 5, warnAtMillis = 1)
    public String getId() {
        return this.mNativeAdBaseApi.getId();
    }
    
    @Benchmark(failAtMillis = 5, warnAtMillis = 1)
    public NativeAdBaseApi getInternalNativeAd() {
        return this.mNativeAdBaseApi;
    }
    
    @Override
    public String getPlacementId() {
        return this.mNativeAdBaseApi.getPlacementId();
    }
    
    @Benchmark(failAtMillis = 5, warnAtMillis = 1)
    public Drawable getPreloadedIconViewDrawable() {
        return this.mNativeAdBaseApi.getPreloadedIconViewDrawable();
    }
    
    @Benchmark(failAtMillis = 5, warnAtMillis = 1)
    public String getPromotedTranslation() {
        return this.mNativeAdBaseApi.getPromotedTranslation();
    }
    
    @Benchmark(failAtMillis = 5, warnAtMillis = 1)
    public String getSponsoredTranslation() {
        return this.mNativeAdBaseApi.getSponsoredTranslation();
    }
    
    @Benchmark(failAtMillis = 5, warnAtMillis = 1)
    public boolean hasCallToAction() {
        return this.mNativeAdBaseApi.hasCallToAction();
    }
    
    @Override
    public boolean isAdInvalidated() {
        return this.mNativeAdBaseApi.isAdInvalidated();
    }
    
    @Benchmark(failAtMillis = 5, warnAtMillis = 1)
    public boolean isAdLoaded() {
        return this.mNativeAdBaseApi.isAdLoaded();
    }
    
    @Deprecated
    @Benchmark(failAtMillis = 5, warnAtMillis = 1)
    public boolean isNativeConfigEnabled() {
        return false;
    }
    
    @Override
    public void loadAd() {
        this.mNativeAdBaseApi.loadAd();
    }
    
    @Benchmark
    public void loadAd(final NativeLoadAdConfig nativeLoadAdConfig) {
        this.mNativeAdBaseApi.loadAd(nativeLoadAdConfig);
    }
    
    @Benchmark(failAtMillis = 5, warnAtMillis = 1)
    public void onCtaBroadcast() {
        this.mNativeAdBaseApi.onCtaBroadcast();
    }
    
    @Deprecated
    @Override
    public void setExtraHints(final ExtraHints extraHints) {
        this.mNativeAdBaseApi.setExtraHints(extraHints);
    }
    
    @Benchmark(failAtMillis = 5, warnAtMillis = 1)
    public void setOnTouchListener(final View$OnTouchListener onTouchListener) {
        this.mNativeAdBaseApi.setOnTouchListener(onTouchListener);
    }
    
    @Benchmark
    public void unregisterView() {
        this.mNativeAdBaseApi.unregisterView();
    }
    
    @Keep
    public static class Image
    {
        private final NativeAdImageApi mNativeAdImageApi;
        
        @Benchmark
        Image(final NativeAdImageApi mNativeAdImageApi) {
            this.mNativeAdImageApi = mNativeAdImageApi;
        }
        
        @Benchmark
        public static Image fromJSONObject(final JSONObject jsonObject) {
            final NativeAdImageApi nativeAdImageApi = DynamicLoaderFactory.makeLoaderUnsafe().createNativeAdImageApi(jsonObject);
            Image image;
            if (nativeAdImageApi == null) {
                image = null;
            }
            else {
                image = new Image(nativeAdImageApi);
            }
            return image;
        }
        
        @Benchmark(failAtMillis = 5, warnAtMillis = 1)
        public int getHeight() {
            return this.mNativeAdImageApi.getHeight();
        }
        
        @Benchmark(failAtMillis = 5, warnAtMillis = 1)
        public String getUrl() {
            return this.mNativeAdImageApi.getUrl();
        }
        
        @Benchmark(failAtMillis = 5, warnAtMillis = 1)
        public int getWidth() {
            return this.mNativeAdImageApi.getWidth();
        }
    }
    
    @Keep
    public enum MediaCacheFlag
    {
        private static final MediaCacheFlag[] $VALUES;
        
        ALL, 
        NONE;
    }
    
    @Keep
    public interface NativeAdLoadConfigBuilder extends LoadConfigBuilder
    {
        public static final int UNKNOWN_IMAGE_SIZE = -1;
        
        @Benchmark(failAtMillis = 5, warnAtMillis = 1)
        default /* bridge */ LoadAdConfig build() {
            return this.build();
        }
        
        @Benchmark(failAtMillis = 5, warnAtMillis = 1)
        NativeLoadAdConfig build();
        
        NativeAdLoadConfigBuilder withAdListener(final NativeAdListener p0);
        
        default /* bridge */ LoadConfigBuilder withBid(final String s) {
            return this.withBid(s);
        }
        
        NativeAdLoadConfigBuilder withBid(final String p0);
        
        @Benchmark(failAtMillis = 5, warnAtMillis = 1)
        NativeAdLoadConfigBuilder withMediaCacheFlag(final MediaCacheFlag p0);
        
        @Benchmark(failAtMillis = 5, warnAtMillis = 1)
        NativeAdLoadConfigBuilder withPreloadedIconView(final int p0, final int p1);
    }
    
    @Keep
    public enum NativeComponentTag
    {
        private static final NativeComponentTag[] $VALUES;
        
        AD_BODY, 
        AD_CALL_TO_ACTION, 
        AD_CHOICES_ICON, 
        AD_COVER_IMAGE, 
        AD_ICON, 
        AD_MEDIA, 
        AD_OPTIONS_VIEW, 
        AD_SOCIAL_CONTEXT, 
        AD_SUBTITLE, 
        AD_TITLE;
        
        public static void tagView(final View view, final NativeComponentTag nativeComponentTag) {
            DynamicLoaderFactory.makeLoader(view.getContext()).createNativeComponentTagApi().tagView(view, nativeComponentTag);
        }
    }
    
    @Keep
    public interface NativeLoadAdConfig extends LoadAdConfig
    {
    }
    
    @Keep
    public static class Rating
    {
        private final NativeAdRatingApi mNativeAdRatingApi;
        
        @Benchmark
        Rating(final NativeAdRatingApi mNativeAdRatingApi) {
            this.mNativeAdRatingApi = mNativeAdRatingApi;
        }
        
        @Benchmark
        public static Rating fromJSONObject(final JSONObject jsonObject) {
            final NativeAdRatingApi nativeAdRatingApi = DynamicLoaderFactory.makeLoaderUnsafe().createNativeAdRatingApi(jsonObject);
            Rating rating;
            if (nativeAdRatingApi == null) {
                rating = null;
            }
            else {
                rating = new Rating(nativeAdRatingApi);
            }
            return rating;
        }
        
        @Benchmark(failAtMillis = 5, warnAtMillis = 1)
        public double getScale() {
            return this.mNativeAdRatingApi.getScale();
        }
        
        @Benchmark(failAtMillis = 5, warnAtMillis = 1)
        public double getValue() {
            return this.mNativeAdRatingApi.getValue();
        }
    }
}
