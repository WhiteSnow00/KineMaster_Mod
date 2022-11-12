// 
// Decompiled by Procyon v0.6.0
// 

package com.facebook.ads.internal.api;

import com.facebook.ads.MediaViewVideoRenderer;
import com.facebook.ads.MediaViewListener;
import com.facebook.ads.MediaView;
import android.view.View;
import androidx.annotation.Keep;

@Keep
public interface MediaViewApi extends AdComponentViewApiProvider
{
    void destroy();
    
    View getAdContentsView();
    
    int getMediaHeight();
    
    int getMediaWidth();
    
    void initialize(final AdViewConstructorParams p0, final MediaView p1);
    
    void setListener(final MediaViewListener p0);
    
    void setVideoRenderer(final MediaViewVideoRenderer p0);
}
