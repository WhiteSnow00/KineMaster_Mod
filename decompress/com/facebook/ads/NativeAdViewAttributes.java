// 
// Decompiled by Procyon v0.6.0
// 

package com.facebook.ads;

import android.graphics.Typeface;
import android.content.Context;
import com.facebook.ads.internal.dynamicloading.DynamicLoaderFactory;
import com.facebook.ads.internal.api.NativeAdViewAttributesApi;
import androidx.annotation.Keep;

@Keep
public class NativeAdViewAttributes
{
    private final NativeAdViewAttributesApi mNativeAdViewAttributesApi;
    
    @Deprecated
    public NativeAdViewAttributes() {
        this.mNativeAdViewAttributesApi = DynamicLoaderFactory.makeLoaderUnsafe().createNativeAdViewAttributesApi();
    }
    
    public NativeAdViewAttributes(final Context context) {
        this.mNativeAdViewAttributesApi = DynamicLoaderFactory.makeLoader(context).createNativeAdViewAttributesApi();
    }
    
    @Deprecated
    public boolean getAutoplay() {
        return AdSettings.isVideoAutoplay();
    }
    
    @Deprecated
    public boolean getAutoplayOnMobile() {
        return AdSettings.isVideoAutoplayOnMobile();
    }
    
    @Deprecated
    public int getBackgroundColor() {
        return 0;
    }
    
    @Deprecated
    public int getButtonBorderColor() {
        return 0;
    }
    
    @Deprecated
    public int getButtonColor() {
        return 0;
    }
    
    @Deprecated
    public int getButtonTextColor() {
        return 0;
    }
    
    @Deprecated
    public int getDescriptionTextColor() {
        return 0;
    }
    
    @Deprecated
    public int getDescriptionTextSize() {
        return 0;
    }
    
    public NativeAdViewAttributesApi getInternalAttributes() {
        return this.mNativeAdViewAttributesApi;
    }
    
    @Deprecated
    public int getTitleTextColor() {
        return 0;
    }
    
    @Deprecated
    public int getTitleTextSize() {
        return 0;
    }
    
    @Deprecated
    public Typeface getTypeface() {
        return null;
    }
    
    @Deprecated
    public NativeAdViewAttributes setAutoplay(final boolean b) {
        return this;
    }
    
    @Deprecated
    public NativeAdViewAttributes setAutoplayOnMobile(final boolean b) {
        return this;
    }
    
    public NativeAdViewAttributes setBackgroundColor(final int backgroundColor) {
        this.mNativeAdViewAttributesApi.setBackgroundColor(backgroundColor);
        return this;
    }
    
    public NativeAdViewAttributes setButtonBorderColor(final int ctaBorderColor) {
        this.mNativeAdViewAttributesApi.setCTABorderColor(ctaBorderColor);
        return this;
    }
    
    public NativeAdViewAttributes setButtonColor(final int ctaBackgroundColor) {
        this.mNativeAdViewAttributesApi.setCTABackgroundColor(ctaBackgroundColor);
        return this;
    }
    
    public NativeAdViewAttributes setButtonTextColor(final int ctaTextColor) {
        this.mNativeAdViewAttributesApi.setCTATextColor(ctaTextColor);
        return this;
    }
    
    public NativeAdViewAttributes setDescriptionTextColor(final int secondaryTextColor) {
        this.mNativeAdViewAttributesApi.setSecondaryTextColor(secondaryTextColor);
        return this;
    }
    
    public NativeAdViewAttributes setTitleTextColor(final int primaryTextColor) {
        this.mNativeAdViewAttributesApi.setPrimaryTextColor(primaryTextColor);
        return this;
    }
    
    public NativeAdViewAttributes setTypeface(final Typeface typeface) {
        this.mNativeAdViewAttributesApi.setTypeface(typeface);
        return this;
    }
}
