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
public class NativeAdView
{
    public static View render(final Context context, final NativeAd nativeAd) {
        Preconditions.checkNotNull(context, "context must be not null");
        Preconditions.checkNotNull(nativeAd, "nativeAd must be not null");
        return DynamicLoaderFactory.makeLoader(context).createNativeAdViewApi().render(context, nativeAd);
    }
    
    @Deprecated
    public static View render(final Context context, final NativeAd nativeAd, final Type type) {
        Preconditions.checkNotNull(context, "context must be not null");
        Preconditions.checkNotNull(nativeAd, "nativeAd must be not null");
        return DynamicLoaderFactory.makeLoader(context).createNativeAdViewApi().render(context, nativeAd, type);
    }
    
    @Deprecated
    public static View render(final Context context, final NativeAd nativeAd, final Type type, final NativeAdViewAttributes nativeAdViewAttributes) {
        Preconditions.checkNotNull(context, "context must be not null");
        Preconditions.checkNotNull(nativeAd, "nativeAd must be not null");
        Preconditions.checkNotNull(type, "type must be not null");
        return DynamicLoaderFactory.makeLoader(context).createNativeAdViewApi().render(context, nativeAd, type, nativeAdViewAttributes);
    }
    
    public static View render(final Context context, final NativeAd nativeAd, final NativeAdViewAttributes nativeAdViewAttributes) {
        Preconditions.checkNotNull(context, "context must be not null");
        Preconditions.checkNotNull(nativeAd, "nativeAd must be not null");
        return DynamicLoaderFactory.makeLoader(context).createNativeAdViewApi().render(context, nativeAd, nativeAdViewAttributes);
    }
    
    @Deprecated
    @Keep
    public enum Type
    {
        private static final Type[] $VALUES;
        
        @Deprecated
        HEIGHT_300(2), 
        @Deprecated
        HEIGHT_400(3);
        
        private final int mEnumCode;
        private NativeAdViewTypeApi mNativeAdViewTypeApi;
        
        @Deprecated
        private Type(final int mEnumCode) {
            this.mEnumCode = mEnumCode;
        }
        
        private NativeAdViewTypeApi getNativeAdViewTypeApi(final int n) {
            if (this.mNativeAdViewTypeApi == null) {
                this.mNativeAdViewTypeApi = DynamicLoaderFactory.makeLoaderUnsafe().createNativeAdViewTypeApi(n);
            }
            return this.mNativeAdViewTypeApi;
        }
        
        public int getEnumCode() {
            return this.mEnumCode;
        }
        
        @Deprecated
        public int getHeight() {
            return this.getNativeAdViewTypeApi(this.mEnumCode).getHeight();
        }
        
        @Deprecated
        public int getValue() {
            return this.getNativeAdViewTypeApi(this.mEnumCode).getValue();
        }
        
        @Deprecated
        public int getWidth() {
            return this.getNativeAdViewTypeApi(this.mEnumCode).getWidth();
        }
    }
}
