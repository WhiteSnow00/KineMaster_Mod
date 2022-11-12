// 
// Decompiled by Procyon v0.6.0
// 

package com.facebook.ads.internal.api;

import com.facebook.ads.MediaViewVideoRenderer;
import android.content.Context;
import androidx.annotation.Keep;

@Keep
public interface DefaultMediaViewVideoRendererApi
{
    public static final int MEDIA_VIEW_RENDERER_CHILD_TYPE_BACKGROUND_PLAYBACK = 1;
    public static final int MEDIA_VIEW_RENDERER_CHILD_TYPE_DEFAULT = 0;
    
    void initialize(final Context p0, final MediaViewVideoRenderer p1, final MediaViewVideoRendererApi p2, final int p3);
    
    void onPrepared();
}
