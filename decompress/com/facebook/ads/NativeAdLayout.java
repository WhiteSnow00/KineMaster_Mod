// 
// Decompiled by Procyon v0.6.0
// 

package com.facebook.ads;

import com.facebook.ads.internal.dynamicloading.DynamicLoaderFactory;
import com.facebook.ads.internal.api.AdComponentViewApiProvider;
import android.util.AttributeSet;
import android.content.Context;
import com.facebook.ads.internal.api.NativeAdLayoutApi;
import androidx.annotation.Keep;
import com.facebook.ads.internal.api.AdComponentFrameLayout;

@Keep
public class NativeAdLayout extends AdComponentFrameLayout
{
    private NativeAdLayoutApi mNativeAdLayoutApi;
    
    public NativeAdLayout(final Context context) {
        super(context);
        this.initializeSelf(context);
    }
    
    public NativeAdLayout(final Context context, final AttributeSet set) {
        super(context, set);
        this.initializeSelf(context);
    }
    
    public NativeAdLayout(final Context context, final AttributeSet set, final int n) {
        super(context, set, n);
        this.initializeSelf(context);
    }
    
    public NativeAdLayout(final Context context, final NativeAdLayoutApi mNativeAdLayoutApi) {
        super(context);
        this.attachAdComponentViewApi(this.mNativeAdLayoutApi = mNativeAdLayoutApi);
        this.mNativeAdLayoutApi.initialize(this);
    }
    
    private void initializeSelf(final Context context) {
        this.attachAdComponentViewApi(this.mNativeAdLayoutApi = DynamicLoaderFactory.makeLoader(context).createNativeAdLayoutApi());
        this.mNativeAdLayoutApi.initialize(this);
    }
    
    public NativeAdLayoutApi getNativeAdLayoutApi() {
        return this.mNativeAdLayoutApi;
    }
    
    public void setMaxWidth(final int maxWidth) {
        this.mNativeAdLayoutApi.setMaxWidth(maxWidth);
    }
    
    public void setMinWidth(final int minWidth) {
        this.mNativeAdLayoutApi.setMinWidth(minWidth);
    }
}
