// 
// Decompiled by Procyon v0.6.0
// 

package com.facebook.ads;

import java.util.List;
import com.facebook.ads.internal.util.common.Preconditions;
import android.widget.ImageView;
import android.view.View;
import com.facebook.ads.internal.dynamicloading.DynamicLoaderFactory;
import com.facebook.ads.internal.api.NativeAdBaseApi;
import android.content.Context;
import com.facebook.ads.internal.api.NativeBannerAdApi;
import androidx.annotation.Keep;

@Keep
public class NativeBannerAd extends NativeAdBase
{
    private final NativeBannerAdApi mNativeBannerAdApi;
    
    public NativeBannerAd(final Context context, final NativeAdBaseApi nativeAdBaseApi) {
        super(nativeAdBaseApi);
        this.mNativeBannerAdApi = DynamicLoaderFactory.makeLoader(context).createNativeBannerAdApi(this, super.mNativeAdBaseApi);
    }
    
    public NativeBannerAd(final Context context, final String s) {
        super(context, s);
        this.mNativeBannerAdApi = DynamicLoaderFactory.makeLoader(context).createNativeBannerAdApi(this, super.mNativeAdBaseApi);
    }
    
    public void registerViewForInteraction(final View view, final ImageView imageView) {
        Preconditions.checkIsOnMainThread();
        this.mNativeBannerAdApi.registerViewForInteraction(view, imageView);
    }
    
    public void registerViewForInteraction(final View view, final ImageView imageView, final List<View> list) {
        Preconditions.checkIsOnMainThread();
        this.mNativeBannerAdApi.registerViewForInteraction(view, imageView, list);
    }
    
    public void registerViewForInteraction(final View view, final MediaView mediaView) {
        Preconditions.checkIsOnMainThread();
        this.mNativeBannerAdApi.registerViewForInteraction(view, mediaView);
    }
    
    public void registerViewForInteraction(final View view, final MediaView mediaView, final List<View> list) {
        Preconditions.checkIsOnMainThread();
        this.mNativeBannerAdApi.registerViewForInteraction(view, mediaView, list);
    }
}
