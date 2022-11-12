// 
// Decompiled by Procyon v0.6.0
// 

package com.facebook.ads;

import com.facebook.ads.internal.dynamicloading.DynamicLoaderFactory;
import com.facebook.ads.internal.util.common.Preconditions;
import android.content.Context;
import com.facebook.ads.internal.api.NativeAdsManagerApi;
import androidx.annotation.Keep;

@Keep
public class NativeAdsManager
{
    private final NativeAdsManagerApi mNativeAdsManagerApi;
    
    public NativeAdsManager(final Context context, final String s, final int n) {
        Preconditions.checkNotNull(context, "Context can not be null");
        Preconditions.checkIsTrue(n > -1, "Number of requested ads should be not be negative");
        this.mNativeAdsManagerApi = DynamicLoaderFactory.makeLoader(context).createNativeAdsManagerApi(context, s, n);
    }
    
    public void disableAutoRefresh() {
        this.mNativeAdsManagerApi.disableAutoRefresh();
    }
    
    public int getUniqueNativeAdCount() {
        return this.mNativeAdsManagerApi.getUniqueNativeAdCount();
    }
    
    public boolean isLoaded() {
        return this.mNativeAdsManagerApi.isLoaded();
    }
    
    public void loadAds() {
        this.mNativeAdsManagerApi.loadAds();
    }
    
    public void loadAds(final NativeAdBase.MediaCacheFlag mediaCacheFlag) {
        this.mNativeAdsManagerApi.loadAds(mediaCacheFlag);
    }
    
    public NativeAd nextNativeAd() {
        return this.mNativeAdsManagerApi.nextNativeAd();
    }
    
    public NativeAd nextNativeAd(final NativeAdListener nativeAdListener) {
        return this.mNativeAdsManagerApi.nextNativeAd(nativeAdListener);
    }
    
    public void setExtraHints(final String extraHints) {
        this.mNativeAdsManagerApi.setExtraHints(extraHints);
    }
    
    public void setListener(final Listener listener) {
        this.mNativeAdsManagerApi.setListener(listener);
    }
    
    @Keep
    public interface Listener
    {
        void onAdError(final AdError p0);
        
        void onAdsLoaded();
    }
}
