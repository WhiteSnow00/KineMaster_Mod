// 
// Decompiled by Procyon v0.6.0
// 

package com.facebook.ads;

import androidx.annotation.Keep;

@Keep
public interface MediaViewListener
{
    void onComplete(final MediaView p0);
    
    void onEnterFullscreen(final MediaView p0);
    
    void onExitFullscreen(final MediaView p0);
    
    void onFullscreenBackground(final MediaView p0);
    
    void onFullscreenForeground(final MediaView p0);
    
    void onPause(final MediaView p0);
    
    void onPlay(final MediaView p0);
    
    void onVolumeChange(final MediaView p0, final float p1);
}
