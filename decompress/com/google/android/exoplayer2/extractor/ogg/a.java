// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.exoplayer2.extractor.ogg;

import com.google.android.exoplayer2.extractor.SeekPoint;
import java.io.EOFException;
import com.google.android.exoplayer2.extractor.ExtractorUtil;
import com.google.android.exoplayer2.extractor.SeekMap;
import com.google.android.exoplayer2.util.Util;
import java.io.IOException;
import com.google.android.exoplayer2.extractor.ExtractorInput;
import com.google.android.exoplayer2.util.Assertions;

final class a implements e
{
    private final d a;
    private final long b;
    private final long c;
    private final g d;
    private int e;
    private long f;
    private long g;
    private long h;
    private long i;
    private long j;
    private long k;
    private long l;
    
    public a(final g d, final long b, final long c, final long n, final long f, final boolean b2) {
        Assertions.a(b >= 0L && c > b);
        this.d = d;
        this.b = b;
        this.c = c;
        if (n != c - b && !b2) {
            this.e = 0;
        }
        else {
            this.f = f;
            this.e = 4;
        }
        this.a = new d();
    }
    
    static g d(final a a) {
        return a.d;
    }
    
    static long e(final a a) {
        return a.b;
    }
    
    static long f(final a a) {
        return a.c;
    }
    
    static long g(final a a) {
        return a.f;
    }
    
    private long i(final ExtractorInput extractorInput) throws IOException {
        if (this.i == this.j) {
            return -1L;
        }
        final long position = extractorInput.getPosition();
        if (!this.a.d(extractorInput, this.j)) {
            final long i = this.i;
            if (i != position) {
                return i;
            }
            throw new IOException("No ogg page can be found.");
        }
        else {
            this.a.a(extractorInput, false);
            extractorInput.h();
            final long h = this.h;
            final d a = this.a;
            final long c = a.c;
            final long n = h - c;
            final int n2 = a.h + a.i;
            if (0L <= n && n < 72000L) {
                return -1L;
            }
            final long n3 = lcmp(n, 0L);
            if (n3 < 0) {
                this.j = position;
                this.l = c;
            }
            else {
                this.i = extractorInput.getPosition() + n2;
                this.k = this.a.c;
            }
            final long j = this.j;
            final long k = this.i;
            if (j - k < 100000L) {
                return this.j = k;
            }
            final long n4 = n2;
            long n5;
            if (n3 <= 0) {
                n5 = 2L;
            }
            else {
                n5 = 1L;
            }
            final long position2 = extractorInput.getPosition();
            final long l = this.j;
            final long m = this.i;
            return Util.r(position2 - n4 * n5 + n * (l - m) / (this.l - this.k), m, l - 1L);
        }
    }
    
    private void k(final ExtractorInput extractorInput) throws IOException {
        while (true) {
            this.a.c(extractorInput);
            this.a.a(extractorInput, false);
            final d a = this.a;
            if (a.c > this.h) {
                break;
            }
            extractorInput.o(a.h + a.i);
            this.i = extractorInput.getPosition();
            this.k = this.a.c;
        }
        extractorInput.h();
    }
    
    @Override
    public long a(final ExtractorInput extractorInput) throws IOException {
        final int e = this.e;
        if (e != 0) {
            if (e != 1) {
                if (e != 2) {
                    if (e != 3) {
                        if (e == 4) {
                            return -1L;
                        }
                        throw new IllegalStateException();
                    }
                }
                else {
                    final long i = this.i(extractorInput);
                    if (i != -1L) {
                        return i;
                    }
                    this.e = 3;
                }
                this.k(extractorInput);
                this.e = 4;
                return -(this.k + 2L);
            }
        }
        else {
            final long position = extractorInput.getPosition();
            this.g = position;
            this.e = 1;
            final long n = this.c - 65307L;
            if (n > position) {
                return n;
            }
        }
        this.f = this.j(extractorInput);
        this.e = 4;
        return this.g;
    }
    
    @Override
    public /* bridge */ SeekMap b() {
        return this.h();
    }
    
    @Override
    public void c(final long n) {
        this.h = Util.r(n, 0L, this.f - 1L);
        this.e = 2;
        this.i = this.b;
        this.j = this.c;
        this.k = 0L;
        this.l = this.f;
    }
    
    public b h() {
        final long f = this.f;
        b b = null;
        if (f != 0L) {
            b = new b(null);
        }
        return b;
    }
    
    long j(final ExtractorInput extractorInput) throws IOException {
        this.a.b();
        if (this.a.c(extractorInput)) {
            this.a.a(extractorInput, false);
            final d a = this.a;
            extractorInput.o(a.h + a.i);
            long n = this.a.c;
            while (true) {
                final d a2 = this.a;
                if ((a2.b & 0x4) == 0x4 || !a2.c(extractorInput) || extractorInput.getPosition() >= this.c || !this.a.a(extractorInput, true)) {
                    break;
                }
                final d a3 = this.a;
                if (!ExtractorUtil.e(extractorInput, a3.h + a3.i)) {
                    break;
                }
                n = this.a.c;
            }
            return n;
        }
        throw new EOFException();
    }
    
    private final class b implements SeekMap
    {
        final a a;
        
        private b(final a a) {
            this.a = a;
        }
        
        b(final a a, final a$a object) {
            this(a);
        }
        
        @Override
        public SeekPoints f(final long n) {
            return new SeekPoints(new SeekPoint(n, Util.r(com.google.android.exoplayer2.extractor.ogg.a.e(this.a) + com.google.android.exoplayer2.extractor.ogg.a.d(this.a).c(n) * (com.google.android.exoplayer2.extractor.ogg.a.f(this.a) - com.google.android.exoplayer2.extractor.ogg.a.e(this.a)) / com.google.android.exoplayer2.extractor.ogg.a.g(this.a) - 30000L, com.google.android.exoplayer2.extractor.ogg.a.e(this.a), com.google.android.exoplayer2.extractor.ogg.a.f(this.a) - 1L)));
        }
        
        @Override
        public boolean h() {
            return true;
        }
        
        @Override
        public long i() {
            return com.google.android.exoplayer2.extractor.ogg.a.d(this.a).b(com.google.android.exoplayer2.extractor.ogg.a.g(this.a));
        }
    }
}
