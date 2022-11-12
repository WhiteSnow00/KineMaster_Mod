// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.exoplayer2.mediacodec;

import com.google.android.exoplayer2.util.Assertions;
import java.nio.ByteBuffer;
import com.google.android.exoplayer2.decoder.DecoderInputBuffer;

final class g extends DecoderInputBuffer
{
    private long j;
    private int p;
    private int w;
    
    public g() {
        super(2);
        this.w = 32;
    }
    
    private boolean z(final DecoderInputBuffer decoderInputBuffer) {
        if (!this.E()) {
            return true;
        }
        if (this.p >= this.w) {
            return false;
        }
        if (decoderInputBuffer.m() != this.m()) {
            return false;
        }
        final ByteBuffer d = decoderInputBuffer.d;
        if (d != null) {
            final ByteBuffer d2 = super.d;
            if (d2 != null && d2.position() + d.remaining() > 3072000) {
                return false;
            }
        }
        return true;
    }
    
    public long A() {
        return super.f;
    }
    
    public long B() {
        return this.j;
    }
    
    public int C() {
        return this.p;
    }
    
    public boolean E() {
        return this.p > 0;
    }
    
    public void G(final int w) {
        Assertions.a(w > 0);
        this.w = w;
    }
    
    @Override
    public void h() {
        super.h();
        this.p = 0;
    }
    
    public boolean y(final DecoderInputBuffer decoderInputBuffer) {
        Assertions.a(decoderInputBuffer.u() ^ true);
        Assertions.a(decoderInputBuffer.l() ^ true);
        Assertions.a(decoderInputBuffer.n() ^ true);
        if (!this.z(decoderInputBuffer)) {
            return false;
        }
        if (this.p++ == 0) {
            super.f = decoderInputBuffer.f;
            if (decoderInputBuffer.p()) {
                this.q(1);
            }
        }
        if (decoderInputBuffer.m()) {
            this.q(Integer.MIN_VALUE);
        }
        final ByteBuffer d = decoderInputBuffer.d;
        if (d != null) {
            this.s(d.remaining());
            super.d.put(d);
        }
        this.j = decoderInputBuffer.f;
        return true;
    }
}
