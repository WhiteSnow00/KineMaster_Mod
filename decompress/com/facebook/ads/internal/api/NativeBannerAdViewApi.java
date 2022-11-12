// 
// Decompiled by Procyon v0.6.0
// 

package com.facebook.ads.internal.api;

import com.facebook.ads.NativeAdViewAttributes;
import android.view.View;
import com.facebook.ads.NativeBannerAdView;
import com.facebook.ads.NativeBannerAd;
import android.content.Context;
import androidx.annotation.Keep;

@Keep
public interface NativeBannerAdViewApi
{
    View render(final Context p0, final NativeBannerAd p1, final NativeBannerAdView.Type p2);
    
    View render(final Context p0, final NativeBannerAd p1, final NativeBannerAdView.Type p2, final NativeAdViewAttributes p3);
}
