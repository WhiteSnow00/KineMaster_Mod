// 
// Decompiled by Procyon v0.6.0
// 

package com.facebook.ads;

import android.view.View;
import com.facebook.ads.internal.dynamicloading.DynamicLoaderFactory;
import android.content.Context;
import com.facebook.ads.internal.api.NativeAdScrollViewApi;
import androidx.annotation.Keep;
import android.widget.LinearLayout;

@Keep
public class NativeAdScrollView extends LinearLayout
{
    public static final int DEFAULT_INSET = 20;
    public static final int DEFAULT_MAX_ADS = 10;
    private final NativeAdScrollViewApi mNativeAdScrollViewApi;
    
    public NativeAdScrollView(final Context context, final NativeAdsManager nativeAdsManager, final int n) {
        this(context, nativeAdsManager, null, n, null, null, 10);
    }
    
    public NativeAdScrollView(final Context context, final NativeAdsManager nativeAdsManager, final int n, final NativeAdViewAttributes nativeAdViewAttributes) {
        this(context, nativeAdsManager, null, n, null, nativeAdViewAttributes, 10);
    }
    
    public NativeAdScrollView(final Context context, final NativeAdsManager nativeAdsManager, final int n, final NativeAdViewAttributes nativeAdViewAttributes, final int n2) {
        this(context, nativeAdsManager, null, n, null, nativeAdViewAttributes, n2);
    }
    
    public NativeAdScrollView(final Context context, final NativeAdsManager nativeAdsManager, final AdViewProvider adViewProvider) {
        this(context, nativeAdsManager, adViewProvider, 0, null, null, 10);
    }
    
    public NativeAdScrollView(final Context context, final NativeAdsManager nativeAdsManager, final AdViewProvider adViewProvider, final int n) {
        this(context, nativeAdsManager, adViewProvider, 0, null, null, n);
    }
    
    private NativeAdScrollView(final Context context, final NativeAdsManager nativeAdsManager, final AdViewProvider adViewProvider, final int n, final NativeAdView.Type type, final NativeAdViewAttributes nativeAdViewAttributes, final int n2) {
        super(context);
        this.mNativeAdScrollViewApi = DynamicLoaderFactory.makeLoader(context).createNativeAdScrollViewApi(this, context, nativeAdsManager, adViewProvider, n, type, nativeAdViewAttributes, n2);
    }
    
    @Deprecated
    public NativeAdScrollView(final Context context, final NativeAdsManager nativeAdsManager, final NativeAdView.Type type) {
        this(context, nativeAdsManager, null, 0, type, null, 10);
    }
    
    @Deprecated
    public NativeAdScrollView(final Context context, final NativeAdsManager nativeAdsManager, final NativeAdView.Type type, final NativeAdViewAttributes nativeAdViewAttributes) {
        this(context, nativeAdsManager, null, 0, type, nativeAdViewAttributes, 10);
    }
    
    @Deprecated
    public NativeAdScrollView(final Context context, final NativeAdsManager nativeAdsManager, final NativeAdView.Type type, final NativeAdViewAttributes nativeAdViewAttributes, final int n) {
        this(context, nativeAdsManager, null, 0, type, nativeAdViewAttributes, n);
    }
    
    public void setInset(final int inset) {
        this.mNativeAdScrollViewApi.setInset(inset);
    }
    
    @Keep
    public interface AdViewProvider
    {
        View createView(final NativeAd p0, final int p1);
        
        void destroyView(final NativeAd p0, final View p1);
    }
}
