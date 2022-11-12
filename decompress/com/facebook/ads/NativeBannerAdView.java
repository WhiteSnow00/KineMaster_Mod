// 
// Decompiled by Procyon v0.6.0
// 

package com.facebook.ads;

import com.facebook.ads.internal.api.NativeAdViewTypeApi;
import com.facebook.ads.internal.dynamicloading.DynamicLoaderFactory;
import com.facebook.ads.internal.util.common.Preconditions;
import android.view.View;
import android.content.Context;
import androidx.annotation.Keep;

@Keep
public class NativeBannerAdView
{
    public static View render(final Context context, final NativeBannerAd nativeBannerAd, final Type type) {
        Preconditions.checkNotNull(context, "context must be not null");
        Preconditions.checkNotNull(nativeBannerAd, "nativeBannerAd must be not null");
        Preconditions.checkNotNull(type, "type must be not null");
        return DynamicLoaderFactory.makeLoader(context).createNativeBannerAdViewApi().render(context, nativeBannerAd, type, null);
    }
    
    public static View render(final Context context, final NativeBannerAd nativeBannerAd, final Type type, final NativeAdViewAttributes nativeAdViewAttributes) {
        Preconditions.checkNotNull(context, "context must be not null");
        Preconditions.checkNotNull(nativeBannerAd, "nativeBannerAd must be not null");
        Preconditions.checkNotNull(type, "type must be not null");
        return DynamicLoaderFactory.makeLoader(context).createNativeBannerAdViewApi().render(context, nativeBannerAd, type, nativeAdViewAttributes);
    }
    
    @Keep
    public enum Type
    {
        private static final Type[] $VALUES;
        
        HEIGHT_100(0), 
        HEIGHT_120(1), 
        HEIGHT_50(4);
        
        private final int mEnumCode;
        private NativeAdViewTypeApi mNativeAdViewTypeApi;
        
        private Type(final int mEnumCode) {
            this.mEnumCode = mEnumCode;
        }
        
        private NativeAdViewTypeApi getNativeAdViewTypeApi() {
            if (this.mNativeAdViewTypeApi == null) {
                this.mNativeAdViewTypeApi = DynamicLoaderFactory.makeLoaderUnsafe().createNativeAdViewTypeApi(this.mEnumCode);
            }
            return this.mNativeAdViewTypeApi;
        }
        
        public int getEnumCode() {
            return this.mEnumCode;
        }
        
        public int getHeight() {
            return this.getNativeAdViewTypeApi().getHeight();
        }
        
        public int getValue() {
            return this.getNativeAdViewTypeApi().getValue();
        }
        
        public int getWidth() {
            return this.getNativeAdViewTypeApi().getWidth();
        }
    }
}
