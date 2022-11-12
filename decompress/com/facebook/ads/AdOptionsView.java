// 
// Decompiled by Procyon v0.6.0
// 

package com.facebook.ads;

import com.facebook.ads.internal.api.AdComponentViewApiProvider;
import com.facebook.ads.internal.dynamicloading.DynamicLoaderFactory;
import android.content.Context;
import com.facebook.ads.internal.api.AdOptionsViewApi;
import androidx.annotation.Keep;
import com.facebook.ads.internal.api.AdComponentFrameLayout;

@Keep
public class AdOptionsView extends AdComponentFrameLayout
{
    private final AdOptionsViewApi mAdOptionsViewApi;
    
    public AdOptionsView(final Context context, final NativeAdBase nativeAdBase, final NativeAdLayout nativeAdLayout) {
        super(context);
        this.attachAdComponentViewApi(this.mAdOptionsViewApi = DynamicLoaderFactory.makeLoader(context).createAdOptionsView(context, nativeAdBase, nativeAdLayout, this));
    }
    
    public AdOptionsView(final Context context, final NativeAdBase nativeAdBase, final NativeAdLayout nativeAdLayout, final Orientation orientation, final int n) {
        super(context);
        this.attachAdComponentViewApi(this.mAdOptionsViewApi = DynamicLoaderFactory.makeLoader(context).createAdOptionsView(context, nativeAdBase, nativeAdLayout, orientation, n, this));
    }
    
    public void setIconColor(final int iconColor) {
        this.mAdOptionsViewApi.setIconColor(iconColor);
    }
    
    public void setIconSizeDp(final int iconSizeDp) {
        this.mAdOptionsViewApi.setIconSizeDp(iconSizeDp);
    }
    
    public void setSingleIcon(final boolean singleIcon) {
        this.mAdOptionsViewApi.setSingleIcon(singleIcon);
    }
    
    @Keep
    public enum Orientation
    {
        private static final Orientation[] $VALUES;
        
        HORIZONTAL, 
        VERTICAL;
    }
}
