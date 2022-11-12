// 
// Decompiled by Procyon v0.6.0
// 

package com.facebook.ads.internal.api;

import com.facebook.ads.NativeAdViewAttributes;
import com.facebook.ads.NativeAdView;
import android.view.View;
import com.facebook.ads.NativeAd;
import android.content.Context;
import androidx.annotation.Keep;

@Keep
public interface NativeAdViewApi
{
    View render(final Context p0, final NativeAd p1);
    
    @Deprecated
    View render(final Context p0, final NativeAd p1, final NativeAdView.Type p2);
    
    @Deprecated
    View render(final Context p0, final NativeAd p1, final NativeAdView.Type p2, final NativeAdViewAttributes p3);
    
    View render(final Context p0, final NativeAd p1, final NativeAdViewAttributes p2);
}
