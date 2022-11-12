// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.exoplayer2.source.hls;

import com.google.android.exoplayer2.decoder.DecoderInputBuffer;
import com.google.android.exoplayer2.FormatHolder;
import com.google.android.exoplayer2.util.Assertions;
import java.io.IOException;
import com.google.android.exoplayer2.source.SampleStream;

final class c implements SampleStream
{
    private final int a;
    private final HlsSampleStreamWrapper b;
    private int c;
    
    public c(final HlsSampleStreamWrapper b, final int a) {
        this.b = b;
        this.a = a;
        this.c = -1;
    }
    
    private boolean c() {
        final int c = this.c;
        return c != -1 && c != -3 && c != -2;
    }
    
    @Override
    public void a() throws IOException {
        final int c = this.c;
        if (c != -2) {
            if (c == -1) {
                this.b.T();
            }
            else if (c != -3) {
                this.b.U(c);
            }
            return;
        }
        throw new SampleQueueMappingException(this.b.p().b(this.a).c(0).w);
    }
    
    public void b() {
        Assertions.a(this.c == -1);
        this.c = this.b.u(this.a);
    }
    
    public void d() {
        if (this.c != -1) {
            this.b.o0(this.a);
            this.c = -1;
        }
    }
    
    @Override
    public int e(final FormatHolder formatHolder, final DecoderInputBuffer decoderInputBuffer, final int n) {
        final int c = this.c;
        int d0 = -3;
        if (c == -3) {
            decoderInputBuffer.g(4);
            return -4;
        }
        if (this.c()) {
            d0 = this.b.d0(this.c, formatHolder, decoderInputBuffer, n);
        }
        return d0;
    }
    
    @Override
    public boolean isReady() {
        return this.c == -3 || (this.c() && this.b.P(this.c));
    }
    
    @Override
    public int l(final long n) {
        int n2;
        if (this.c()) {
            n2 = this.b.n0(this.c, n);
        }
        else {
            n2 = 0;
        }
        return n2;
    }
}
