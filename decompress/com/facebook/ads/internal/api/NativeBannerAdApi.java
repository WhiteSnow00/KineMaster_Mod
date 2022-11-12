// 
// Decompiled by Procyon v0.6.0
// 

package com.facebook.ads.internal.api;

import com.facebook.ads.MediaView;
import java.util.List;
import android.widget.ImageView;
import android.view.View;
import androidx.annotation.Keep;

@Keep
public interface NativeBannerAdApi
{
    void registerViewForInteraction(final View p0, final ImageView p1);
    
    void registerViewForInteraction(final View p0, final ImageView p1, final List<View> p2);
    
    void registerViewForInteraction(final View p0, final MediaView p1);
    
    void registerViewForInteraction(final View p0, final MediaView p1, final List<View> p2);
}
