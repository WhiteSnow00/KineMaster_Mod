// 
// Decompiled by Procyon v0.6.0
// 

package com.facebook.ads.internal.api;

import com.facebook.ads.MediaViewVideoRenderer;
import android.view.View;
import com.facebook.ads.VideoStartReason;
import androidx.annotation.Keep;

@Keep
public interface MediaViewVideoRendererApi extends AdComponentViewApiProvider
{
    void destroy();
    
    void disengageSeek(final VideoStartReason p0);
    
    void engageSeek();
    
    int getCurrentTimeMs();
    
    int getDuration();
    
    View getVideoView();
    
    float getVolume();
    
    void initialize(final AdViewConstructorParams p0, final MediaViewVideoRenderer p1);
    
    void pause(final boolean p0);
    
    void play(final VideoStartReason p0);
    
    void seekTo(final int p0);
    
    void setVolume(final float p0);
    
    boolean shouldAutoplay();
}
