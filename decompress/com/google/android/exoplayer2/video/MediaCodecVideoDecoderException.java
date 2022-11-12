// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.exoplayer2.video;

import android.view.Surface;
import com.google.android.exoplayer2.mediacodec.MediaCodecInfo;
import com.google.android.exoplayer2.mediacodec.MediaCodecDecoderException;

public class MediaCodecVideoDecoderException extends MediaCodecDecoderException
{
    public final boolean isSurfaceValid;
    public final int surfaceIdentityHashCode;
    
    public MediaCodecVideoDecoderException(final Throwable t, final MediaCodecInfo mediaCodecInfo, final Surface surface) {
        super(t, mediaCodecInfo);
        this.surfaceIdentityHashCode = System.identityHashCode(surface);
        this.isSurfaceValid = (surface == null || surface.isValid());
    }
}
