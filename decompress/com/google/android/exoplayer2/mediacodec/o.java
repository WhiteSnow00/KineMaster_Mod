// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.exoplayer2.mediacodec;

import android.media.MediaCodec;
import android.media.MediaCodec$OnFrameRenderedListener;

public final class o implements MediaCodec$OnFrameRenderedListener
{
    public final SynchronousMediaCodecAdapter a;
    public final MediaCodecAdapter.OnFrameRenderedListener b;
    
    public o(final SynchronousMediaCodecAdapter a, final MediaCodecAdapter.OnFrameRenderedListener b) {
        this.a = a;
        this.b = b;
    }
    
    public final void onFrameRendered(final MediaCodec mediaCodec, final long n, final long n2) {
        SynchronousMediaCodecAdapter.o(this.a, this.b, mediaCodec, n, n2);
    }
}
