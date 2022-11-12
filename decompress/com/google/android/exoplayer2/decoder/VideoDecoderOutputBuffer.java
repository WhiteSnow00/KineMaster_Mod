// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.exoplayer2.decoder;

import java.nio.ByteBuffer;

public class VideoDecoderOutputBuffer extends DecoderOutputBuffer
{
    public int d;
    public int e;
    public int f;
    public ByteBuffer[] g;
    public int[] h;
    public int i;
    private final Owner<VideoDecoderOutputBuffer> j;
    
    @Override
    public void r() {
        this.j.a(this);
    }
}
