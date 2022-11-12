// 
// Decompiled by Procyon v0.6.0
// 

package com.facebook.ads.internal.api;

import com.facebook.ads.NativeAdsManager;
import com.facebook.ads.NativeAdListener;
import com.facebook.ads.NativeAd;
import com.facebook.ads.NativeAdBase;
import com.facebook.proguard.annotations.DoNotStripAny;
import androidx.annotation.Keep;

@Keep
@DoNotStripAny
public interface NativeAdsManagerApi
{
    void disableAutoRefresh();
    
    int getUniqueNativeAdCount();
    
    boolean isLoaded();
    
    void loadAds();
    
    void loadAds(final NativeAdBase.MediaCacheFlag p0);
    
    NativeAd nextNativeAd();
    
    NativeAd nextNativeAd(final NativeAdListener p0);
    
    void setExtraHints(final String p0);
    
    void setListener(final NativeAdsManager.Listener p0);
}
