// 
// Decompiled by Procyon v0.6.0
// 

package com.facebook.ads.internal.api;

import java.util.List;
import android.widget.ImageView;
import com.facebook.ads.MediaView;
import android.view.View;
import com.facebook.ads.VideoAutoplayBehavior;
import com.facebook.ads.NativeAd;
import androidx.annotation.Keep;

@Keep
public interface NativeAdApi
{
    NativeAd.AdCreativeType getAdCreativeType();
    
    VideoAutoplayBehavior getVideoAutoplayBehavior();
    
    void registerViewForInteraction(final View p0, final MediaView p1);
    
    void registerViewForInteraction(final View p0, final MediaView p1, final ImageView p2);
    
    void registerViewForInteraction(final View p0, final MediaView p1, final ImageView p2, final List<View> p3);
    
    void registerViewForInteraction(final View p0, final MediaView p1, final MediaView p2);
    
    void registerViewForInteraction(final View p0, final MediaView p1, final MediaView p2, final List<View> p3);
    
    void registerViewForInteraction(final View p0, final MediaView p1, final List<View> p2);
}
