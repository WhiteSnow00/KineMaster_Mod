// 
// Decompiled by Procyon v0.6.0
// 

package com.facebook.ads;

import java.util.List;
import android.widget.ImageView;
import com.facebook.ads.internal.util.common.Preconditions;
import android.view.View;
import com.facebook.ads.internal.api.NativeAdBaseApi;
import com.facebook.ads.internal.dynamicloading.DynamicLoaderFactory;
import android.content.Context;
import com.facebook.ads.internal.api.NativeAdApi;
import androidx.annotation.Keep;

@Keep
public class NativeAd extends NativeAdBase
{
    private NativeAdApi mNativeAdApi;
    
    public NativeAd(final Context context, final NativeAdBase nativeAdBase) {
        super(context, nativeAdBase);
        this.mNativeAdApi = DynamicLoaderFactory.makeLoader(context).createNativeAdApi(nativeAdBase, this, super.mNativeAdBaseApi);
    }
    
    public NativeAd(final Context context, final NativeAdBaseApi nativeAdBaseApi) {
        super(nativeAdBaseApi);
        this.mNativeAdApi = DynamicLoaderFactory.makeLoader(context).createNativeAdApi(this, super.mNativeAdBaseApi);
    }
    
    public NativeAd(final Context context, final String s) {
        super(context, s);
        this.mNativeAdApi = DynamicLoaderFactory.makeLoader(context).createNativeAdApi(this, super.mNativeAdBaseApi);
    }
    
    public AdCreativeType getAdCreativeType() {
        return this.mNativeAdApi.getAdCreativeType();
    }
    
    public NativeAdApi getNativeAdApi() {
        return this.mNativeAdApi;
    }
    
    @Deprecated
    VideoAutoplayBehavior getVideoAutoplayBehavior() {
        return this.mNativeAdApi.getVideoAutoplayBehavior();
    }
    
    public void registerViewForInteraction(final View view, final MediaView mediaView) {
        Preconditions.checkIsOnMainThread();
        this.mNativeAdApi.registerViewForInteraction(view, mediaView);
    }
    
    public void registerViewForInteraction(final View view, final MediaView mediaView, final ImageView imageView) {
        Preconditions.checkIsOnMainThread();
        this.mNativeAdApi.registerViewForInteraction(view, mediaView, imageView);
    }
    
    public void registerViewForInteraction(final View view, final MediaView mediaView, final ImageView imageView, final List<View> list) {
        Preconditions.checkIsOnMainThread();
        this.mNativeAdApi.registerViewForInteraction(view, mediaView, imageView, list);
    }
    
    public void registerViewForInteraction(final View view, final MediaView mediaView, final MediaView mediaView2) {
        Preconditions.checkIsOnMainThread();
        this.mNativeAdApi.registerViewForInteraction(view, mediaView, mediaView2);
    }
    
    public void registerViewForInteraction(final View view, final MediaView mediaView, final MediaView mediaView2, final List<View> list) {
        Preconditions.checkIsOnMainThread();
        this.mNativeAdApi.registerViewForInteraction(view, mediaView, mediaView2, list);
    }
    
    public void registerViewForInteraction(final View view, final MediaView mediaView, final List<View> list) {
        Preconditions.checkIsOnMainThread();
        this.mNativeAdApi.registerViewForInteraction(view, mediaView, list);
    }
    
    @Keep
    public enum AdCreativeType
    {
        private static final AdCreativeType[] $VALUES;
        
        CAROUSEL, 
        IMAGE, 
        UNKNOWN, 
        VIDEO;
    }
}
