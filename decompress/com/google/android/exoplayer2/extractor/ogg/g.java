// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.exoplayer2.extractor.ogg;

import com.google.android.exoplayer2.util.ParsableByteArray;
import com.google.android.exoplayer2.extractor.SeekMap;
import com.google.android.exoplayer2.extractor.PositionHolder;
import com.google.android.exoplayer2.Format;
import java.io.IOException;
import com.google.android.exoplayer2.extractor.ExtractorInput;
import com.google.android.exoplayer2.util.Util;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.extractor.ExtractorOutput;
import com.google.android.exoplayer2.extractor.TrackOutput;

abstract class g
{
    private final com.google.android.exoplayer2.extractor.ogg.c a;
    private TrackOutput b;
    private ExtractorOutput c;
    private e d;
    private long e;
    private long f;
    private long g;
    private int h;
    private int i;
    private b j;
    private long k;
    private boolean l;
    private boolean m;
    
    public g() {
        this.a = new com.google.android.exoplayer2.extractor.ogg.c();
        this.j = new b();
    }
    
    private void a() {
        Assertions.i(this.b);
        Util.j(this.c);
    }
    
    private boolean h(final ExtractorInput extractorInput) throws IOException {
        while (this.a.d(extractorInput)) {
            this.k = extractorInput.getPosition() - this.f;
            if (!this.i(this.a.c(), this.f, this.j)) {
                return true;
            }
            this.f = extractorInput.getPosition();
        }
        this.h = 3;
        return false;
    }
    
    private int j(final ExtractorInput extractorInput) throws IOException {
        if (!this.h(extractorInput)) {
            return -1;
        }
        final Format a = this.j.a;
        this.i = a.K;
        if (!this.m) {
            this.b.d(a);
            this.m = true;
        }
        final e b = this.j.b;
        if (b != null) {
            this.d = b;
        }
        else if (extractorInput.getLength() == -1L) {
            this.d = new c(null);
        }
        else {
            final d b2 = this.a.b();
            this.d = new a(this, this.f, extractorInput.getLength(), b2.h + b2.i, b2.c, (b2.b & 0x4) != 0x0);
        }
        this.h = 2;
        this.a.f();
        return 0;
    }
    
    private int k(final ExtractorInput extractorInput, final PositionHolder positionHolder) throws IOException {
        final long a = this.d.a(extractorInput);
        if (a >= 0L) {
            positionHolder.a = a;
            return 1;
        }
        if (a < -1L) {
            this.e(-(a + 2L));
        }
        if (!this.l) {
            this.c.l(Assertions.i(this.d.b()));
            this.l = true;
        }
        if (this.k <= 0L && !this.a.d(extractorInput)) {
            this.h = 3;
            return -1;
        }
        this.k = 0L;
        final ParsableByteArray c = this.a.c();
        final long f = this.f(c);
        if (f >= 0L) {
            final long g = this.g;
            if (g + f >= this.e) {
                final long b = this.b(g);
                this.b.c(c, c.f());
                this.b.e(b, 1, c.f(), 0, null);
                this.e = -1L;
            }
        }
        this.g += f;
        return 0;
    }
    
    protected long b(final long n) {
        return n * 1000000L / this.i;
    }
    
    protected long c(final long n) {
        return this.i * n / 1000000L;
    }
    
    void d(final ExtractorOutput c, final TrackOutput b) {
        this.c = c;
        this.b = b;
        this.l(true);
    }
    
    protected void e(final long g) {
        this.g = g;
    }
    
    protected abstract long f(final ParsableByteArray p0);
    
    final int g(final ExtractorInput extractorInput, final PositionHolder positionHolder) throws IOException {
        this.a();
        final int h = this.h;
        if (h == 0) {
            return this.j(extractorInput);
        }
        if (h == 1) {
            extractorInput.o((int)this.f);
            this.h = 2;
            return 0;
        }
        if (h == 2) {
            Util.j(this.d);
            return this.k(extractorInput, positionHolder);
        }
        if (h == 3) {
            return -1;
        }
        throw new IllegalStateException();
    }
    
    protected abstract boolean i(final ParsableByteArray p0, final long p1, final b p2) throws IOException;
    
    protected void l(final boolean b) {
        if (b) {
            this.j = new b();
            this.f = 0L;
            this.h = 0;
        }
        else {
            this.h = 1;
        }
        this.e = -1L;
        this.g = 0L;
    }
    
    final void m(final long n, final long n2) {
        this.a.e();
        if (n == 0L) {
            this.l(this.l ^ true);
        }
        else if (this.h != 0) {
            this.e = this.c(n2);
            Util.j(this.d).c(this.e);
            this.h = 2;
        }
    }
    
    static class b
    {
        Format a;
        e b;
    }
    
    private static final class c implements e
    {
        private c() {
        }
        
        c(final g$a object) {
            this();
        }
        
        @Override
        public long a(final ExtractorInput extractorInput) {
            return -1L;
        }
        
        @Override
        public SeekMap b() {
            return new SeekMap.Unseekable(-9223372036854775807L);
        }
        
        @Override
        public void c(final long n) {
        }
    }
}
