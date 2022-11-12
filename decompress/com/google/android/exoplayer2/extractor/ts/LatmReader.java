// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.exoplayer2.extractor.ts;

import com.google.android.exoplayer2.extractor.ExtractorOutput;
import com.google.android.exoplayer2.util.Assertions;
import java.util.Collections;
import com.google.android.exoplayer2.audio.AacUtil;
import com.google.android.exoplayer2.ParserException;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.extractor.TrackOutput;
import com.google.android.exoplayer2.util.ParsableBitArray;
import com.google.android.exoplayer2.util.ParsableByteArray;

public final class LatmReader implements ElementaryStreamReader
{
    private final String a;
    private final ParsableByteArray b;
    private final ParsableBitArray c;
    private TrackOutput d;
    private String e;
    private Format f;
    private int g;
    private int h;
    private int i;
    private int j;
    private long k;
    private boolean l;
    private int m;
    private int n;
    private int o;
    private boolean p;
    private long q;
    private int r;
    private long s;
    private int t;
    private String u;
    
    public LatmReader(final String a) {
        this.a = a;
        final ParsableByteArray b = new ParsableByteArray(1024);
        this.b = b;
        this.c = new ParsableBitArray(b.d());
        this.k = -9223372036854775807L;
    }
    
    private static long a(final ParsableBitArray parsableBitArray) {
        return parsableBitArray.h((parsableBitArray.h(2) + 1) * 8);
    }
    
    private void g(final ParsableBitArray parsableBitArray) throws ParserException {
        if (!parsableBitArray.g()) {
            this.l = true;
            this.l(parsableBitArray);
        }
        else if (!this.l) {
            return;
        }
        if (this.m != 0) {
            throw ParserException.createForMalformedContainer(null, null);
        }
        if (this.n == 0) {
            this.k(parsableBitArray, this.j(parsableBitArray));
            if (this.p) {
                parsableBitArray.r((int)this.q);
            }
            return;
        }
        throw ParserException.createForMalformedContainer(null, null);
    }
    
    private int h(final ParsableBitArray parsableBitArray) throws ParserException {
        final int b = parsableBitArray.b();
        final AacUtil.Config e = AacUtil.e(parsableBitArray, true);
        this.u = e.c;
        this.r = e.a;
        this.t = e.b;
        return b - parsableBitArray.b();
    }
    
    private void i(final ParsableBitArray parsableBitArray) {
        final int h = parsableBitArray.h(3);
        this.o = h;
        if (h != 0) {
            if (h != 1) {
                if (h != 3 && h != 4 && h != 5) {
                    if (h != 6 && h != 7) {
                        throw new IllegalStateException();
                    }
                    parsableBitArray.r(1);
                }
                else {
                    parsableBitArray.r(6);
                }
            }
            else {
                parsableBitArray.r(9);
            }
        }
        else {
            parsableBitArray.r(8);
        }
    }
    
    private int j(final ParsableBitArray parsableBitArray) throws ParserException {
        if (this.o == 0) {
            int n = 0;
            int i;
            do {
                i = parsableBitArray.h(8);
                n += i;
            } while (i == 255);
            return n;
        }
        throw ParserException.createForMalformedContainer(null, null);
    }
    
    private void k(final ParsableBitArray parsableBitArray, final int n) {
        final int e = parsableBitArray.e();
        if ((e & 0x7) == 0x0) {
            this.b.P(e >> 3);
        }
        else {
            parsableBitArray.i(this.b.d(), 0, n * 8);
            this.b.P(0);
        }
        this.d.c(this.b, n);
        final long k = this.k;
        if (k != -9223372036854775807L) {
            this.d.e(k, 1, n, 0, null);
            this.k += this.s;
        }
    }
    
    private void l(final ParsableBitArray parsableBitArray) throws ParserException {
        final int h = parsableBitArray.h(1);
        int h2;
        if (h == 1) {
            h2 = parsableBitArray.h(1);
        }
        else {
            h2 = 0;
        }
        this.m = h2;
        if (h2 != 0) {
            throw ParserException.createForMalformedContainer(null, null);
        }
        if (h == 1) {
            a(parsableBitArray);
        }
        if (!parsableBitArray.g()) {
            throw ParserException.createForMalformedContainer(null, null);
        }
        this.n = parsableBitArray.h(6);
        final int h3 = parsableBitArray.h(4);
        final int h4 = parsableBitArray.h(3);
        if (h3 == 0 && h4 == 0) {
            if (h == 0) {
                final int e = parsableBitArray.e();
                final int h5 = this.h(parsableBitArray);
                parsableBitArray.p(e);
                final byte[] array = new byte[(h5 + 7) / 8];
                parsableBitArray.i(array, 0, h5);
                final Format e2 = new Format.Builder().S(this.e).e0("audio/mp4a-latm").I(this.u).H(this.t).f0(this.r).T(Collections.singletonList(array)).V(this.a).E();
                if (!e2.equals(this.f)) {
                    this.f = e2;
                    this.s = 1024000000L / e2.K;
                    this.d.d(e2);
                }
            }
            else {
                parsableBitArray.r((int)a(parsableBitArray) - this.h(parsableBitArray));
            }
            this.i(parsableBitArray);
            final boolean g = parsableBitArray.g();
            this.p = g;
            this.q = 0L;
            if (g) {
                if (h == 1) {
                    this.q = a(parsableBitArray);
                }
                else {
                    boolean g2;
                    do {
                        g2 = parsableBitArray.g();
                        this.q = (this.q << 8) + parsableBitArray.h(8);
                    } while (g2);
                }
            }
            if (parsableBitArray.g()) {
                parsableBitArray.r(8);
            }
            return;
        }
        throw ParserException.createForMalformedContainer(null, null);
    }
    
    private void m(final int n) {
        this.b.L(n);
        this.c.n(this.b.d());
    }
    
    @Override
    public void b(final ParsableByteArray parsableByteArray) throws ParserException {
        Assertions.i(this.d);
        while (parsableByteArray.a() > 0) {
            final int g = this.g;
            if (g != 0) {
                if (g != 1) {
                    if (g != 2) {
                        if (g != 3) {
                            throw new IllegalStateException();
                        }
                        final int min = Math.min(parsableByteArray.a(), this.i - this.h);
                        parsableByteArray.j(this.c.a, this.h, min);
                        if ((this.h += min) != this.i) {
                            continue;
                        }
                        this.c.p(0);
                        this.g(this.c);
                        this.g = 0;
                    }
                    else {
                        if ((this.i = ((this.j & 0xFFFFFF1F) << 8 | parsableByteArray.D())) > this.b.d().length) {
                            this.m(this.i);
                        }
                        this.h = 0;
                        this.g = 3;
                    }
                }
                else {
                    final int d = parsableByteArray.D();
                    if ((d & 0xE0) == 0xE0) {
                        this.j = d;
                        this.g = 2;
                    }
                    else {
                        if (d == 86) {
                            continue;
                        }
                        this.g = 0;
                    }
                }
            }
            else {
                if (parsableByteArray.D() != 86) {
                    continue;
                }
                this.g = 1;
            }
        }
    }
    
    @Override
    public void c() {
        this.g = 0;
        this.k = -9223372036854775807L;
        this.l = false;
    }
    
    @Override
    public void d(final ExtractorOutput extractorOutput, final TsPayloadReader.TrackIdGenerator trackIdGenerator) {
        trackIdGenerator.a();
        this.d = extractorOutput.e(trackIdGenerator.c(), 1);
        this.e = trackIdGenerator.b();
    }
    
    @Override
    public void e() {
    }
    
    @Override
    public void f(final long k, final int n) {
        if (k != -9223372036854775807L) {
            this.k = k;
        }
    }
}
