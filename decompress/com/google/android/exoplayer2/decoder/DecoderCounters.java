// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.exoplayer2.decoder;

import com.google.android.exoplayer2.util.Util;

public final class DecoderCounters
{
    public int a;
    public int b;
    public int c;
    public int d;
    public int e;
    public int f;
    public int g;
    public int h;
    public int i;
    public int j;
    public long k;
    public int l;
    
    private void b(final long n, final int n2) {
        this.k += n;
        this.l += n2;
    }
    
    public void a(final long n) {
        this.b(n, 1);
    }
    
    public void c() {
        monitorenter(this);
        monitorexit(this);
    }
    
    @Override
    public String toString() {
        return Util.C("DecoderCounters {\n decoderInits=%s,\n decoderReleases=%s\n queuedInputBuffers=%s\n skippedInputBuffers=%s\n renderedOutputBuffers=%s\n skippedOutputBuffers=%s\n droppedBuffers=%s\n droppedInputBuffers=%s\n maxConsecutiveDroppedBuffers=%s\n droppedToKeyframeEvents=%s\n totalVideoFrameProcessingOffsetUs=%s\n videoFrameProcessingOffsetCount=%s\n}", this.a, this.b, this.c, this.d, this.e, this.f, this.g, this.h, this.i, this.j, this.k, this.l);
    }
}
