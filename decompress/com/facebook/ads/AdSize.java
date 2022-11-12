// 
// Decompiled by Procyon v0.6.0
// 

package com.facebook.ads;

import com.facebook.ads.internal.dynamicloading.DynamicLoaderFactory;
import com.facebook.ads.internal.api.AdSizeApi;
import androidx.annotation.Keep;
import java.io.Serializable;

@Keep
public class AdSize implements Serializable
{
    @Deprecated
    public static final AdSize BANNER_320_50;
    public static final AdSize BANNER_HEIGHT_50;
    public static final AdSize BANNER_HEIGHT_90;
    public static final AdSize INTERSTITIAL;
    public static final AdSize RECTANGLE_HEIGHT_250;
    private final int UNDEFINED;
    private AdSizeApi mAdSizeApi;
    private final int mInitHeight;
    private final int mInitSizeType;
    private final int mInitWidth;
    
    static {
        BANNER_320_50 = new AdSize(4);
        INTERSTITIAL = new AdSize(100);
        BANNER_HEIGHT_50 = new AdSize(5);
        BANNER_HEIGHT_90 = new AdSize(6);
        RECTANGLE_HEIGHT_250 = new AdSize(7);
    }
    
    private AdSize(final int mInitSizeType) {
        this.UNDEFINED = -1;
        this.mInitSizeType = mInitSizeType;
        this.mInitWidth = -1;
        this.mInitHeight = -1;
    }
    
    public AdSize(final int mInitWidth, final int mInitHeight) {
        this.UNDEFINED = -1;
        this.mInitSizeType = -1;
        this.mInitWidth = mInitWidth;
        this.mInitHeight = mInitHeight;
    }
    
    public static AdSize fromWidthAndHeight(final int n, final int n2) {
        final AdSize interstitial = AdSize.INTERSTITIAL;
        if (interstitial.getHeight() == n2 && interstitial.getWidth() == n) {
            return interstitial;
        }
        final AdSize banner_320_50 = AdSize.BANNER_320_50;
        if (banner_320_50.getHeight() == n2 && banner_320_50.getWidth() == n) {
            return banner_320_50;
        }
        final AdSize banner_HEIGHT_50 = AdSize.BANNER_HEIGHT_50;
        if (banner_HEIGHT_50.getHeight() == n2 && banner_HEIGHT_50.getWidth() == n) {
            return banner_HEIGHT_50;
        }
        final AdSize banner_HEIGHT_51 = AdSize.BANNER_HEIGHT_90;
        if (banner_HEIGHT_51.getHeight() == n2 && banner_HEIGHT_51.getWidth() == n) {
            return banner_HEIGHT_51;
        }
        final AdSize rectangle_HEIGHT_250 = AdSize.RECTANGLE_HEIGHT_250;
        if (rectangle_HEIGHT_250.getHeight() == n2 && rectangle_HEIGHT_250.getWidth() == n) {
            return rectangle_HEIGHT_250;
        }
        throw new IllegalArgumentException("Can't create AdSize using this width and height.");
    }
    
    private AdSizeApi getAdSizeApi(final int n) {
        if (this.mAdSizeApi == null) {
            this.mAdSizeApi = DynamicLoaderFactory.makeLoaderUnsafe().createAdSizeApi(n);
        }
        return this.mAdSizeApi;
    }
    
    @Override
    public boolean equals(final Object o) {
        boolean b = true;
        if (this == o) {
            return true;
        }
        if (o == null || this.getClass() != o.getClass()) {
            return false;
        }
        final AdSize adSize = (AdSize)o;
        if (this.getWidth() != adSize.getWidth()) {
            return false;
        }
        if (this.getHeight() != adSize.getHeight()) {
            b = false;
        }
        return b;
    }
    
    public int getHeight() {
        final int mInitSizeType = this.mInitSizeType;
        if (mInitSizeType != -1) {
            return this.getAdSizeApi(mInitSizeType).getHeight();
        }
        return this.mInitHeight;
    }
    
    public int getWidth() {
        final int mInitSizeType = this.mInitSizeType;
        if (mInitSizeType != -1) {
            return this.getAdSizeApi(mInitSizeType).getWidth();
        }
        return this.mInitWidth;
    }
    
    @Override
    public int hashCode() {
        return this.getWidth() * 31 + this.getHeight();
    }
}
