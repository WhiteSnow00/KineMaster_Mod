// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.exoplayer2.mediacodec;

import android.media.MediaCodec;
import android.media.MediaCodec$OnFrameRenderedListener;

public final class a implements MediaCodec$OnFrameRenderedListener
{
    public final AsynchronousMediaCodecAdapter a;
    public final MediaCodecAdapter.OnFrameRenderedListener b;
    
    public a(final AsynchronousMediaCodecAdapter a, final MediaCodecAdapter.OnFrameRenderedListener b) {
        this.a = a;
        this.b = b;
    }
    
    public final void onFrameRendered(final MediaCodec mediaCodec, final long n, final long n2) {
        AsynchronousMediaCodecAdapter.o(this.a, this.b, mediaCodec, n, n2);
    }
}
