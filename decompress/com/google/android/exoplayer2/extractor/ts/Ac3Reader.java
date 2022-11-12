// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.exoplayer2.extractor.ts;

import com.google.android.exoplayer2.extractor.ExtractorOutput;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.Util;
import com.google.android.exoplayer2.audio.Ac3Util;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.extractor.TrackOutput;
import com.google.android.exoplayer2.util.ParsableByteArray;
import com.google.android.exoplayer2.util.ParsableBitArray;

public final class Ac3Reader implements ElementaryStreamReader
{
    private final ParsableBitArray a;
    private final ParsableByteArray b;
    private final String c;
    private String d;
    private TrackOutput e;
    private int f;
    private int g;
    private boolean h;
    private long i;
    private Format j;
    private int k;
    private long l;
    
    public Ac3Reader() {
        this(null);
    }
    
    public Ac3Reader(final String c) {
        final ParsableBitArray a = new ParsableBitArray(new byte[128]);
        this.a = a;
        this.b = new ParsableByteArray(a.a);
        this.f = 0;
        this.l = -9223372036854775807L;
        this.c = c;
    }
    
    private boolean a(final ParsableByteArray parsableByteArray, final byte[] array, final int n) {
        final int min = Math.min(parsableByteArray.a(), n - this.g);
        parsableByteArray.j(array, this.g, min);
        final int g = this.g + min;
        this.g = g;
        return g == n;
    }
    
    private void g() {
        this.a.p(0);
        final Ac3Util.SyncFrameInfo e = Ac3Util.e(this.a);
        final Format j = this.j;
        if (j == null || e.d != j.J || e.c != j.K || !Util.c(e.a, j.w)) {
            final Format e2 = new Format.Builder().S(this.d).e0(e.a).H(e.d).f0(e.c).V(this.c).E();
            this.j = e2;
            this.e.d(e2);
        }
        this.k = e.e;
        this.i = e.f * 1000000L / this.j.K;
    }
    
    private boolean h(final ParsableByteArray parsableByteArray) {
        while (true) {
            final int a = parsableByteArray.a();
            final boolean b = false;
            boolean h = false;
            if (a <= 0) {
                return false;
            }
            if (!this.h) {
                if (parsableByteArray.D() == 11) {
                    h = true;
                }
                this.h = h;
            }
            else {
                final int d = parsableByteArray.D();
                if (d == 119) {
                    this.h = false;
                    return true;
                }
                boolean h2 = b;
                if (d == 11) {
                    h2 = true;
                }
                this.h = h2;
            }
        }
    }
    
    @Override
    public void b(final ParsableByteArray parsableByteArray) {
        Assertions.i(this.e);
        while (parsableByteArray.a() > 0) {
            final int f = this.f;
            if (f != 0) {
                if (f != 1) {
                    if (f != 2) {
                        continue;
                    }
                    final int min = Math.min(parsableByteArray.a(), this.k - this.g);
                    this.e.c(parsableByteArray, min);
                    final int g = this.g + min;
                    this.g = g;
                    final int k = this.k;
                    if (g != k) {
                        continue;
                    }
                    final long l = this.l;
                    if (l != -9223372036854775807L) {
                        this.e.e(l, 1, k, 0, null);
                        this.l += this.i;
                    }
                    this.f = 0;
                }
                else {
                    if (!this.a(parsableByteArray, this.b.d(), 128)) {
                        continue;
                    }
                    this.g();
                    this.b.P(0);
                    this.e.c(this.b, 128);
                    this.f = 2;
                }
            }
            else {
                if (!this.h(parsableByteArray)) {
                    continue;
                }
                this.f = 1;
                this.b.d()[0] = 11;
                this.b.d()[1] = 119;
                this.g = 2;
            }
        }
    }
    
    @Override
    public void c() {
        this.f = 0;
        this.g = 0;
        this.h = false;
        this.l = -9223372036854775807L;
    }
    
    @Override
    public void d(final ExtractorOutput extractorOutput, final TsPayloadReader.TrackIdGenerator trackIdGenerator) {
        trackIdGenerator.a();
        this.d = trackIdGenerator.b();
        this.e = extractorOutput.e(trackIdGenerator.c(), 1);
    }
    
    @Override
    public void e() {
    }
    
    @Override
    public void f(final long l, final int n) {
        if (l != -9223372036854775807L) {
            this.l = l;
        }
    }
}
