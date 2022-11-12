// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.exoplayer2.extractor.ts;

import com.google.android.exoplayer2.extractor.ExtractorOutput;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.audio.Ac4Util;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.extractor.TrackOutput;
import com.google.android.exoplayer2.util.ParsableByteArray;
import com.google.android.exoplayer2.util.ParsableBitArray;

public final class Ac4Reader implements ElementaryStreamReader
{
    private final ParsableBitArray a;
    private final ParsableByteArray b;
    private final String c;
    private String d;
    private TrackOutput e;
    private int f;
    private int g;
    private boolean h;
    private boolean i;
    private long j;
    private Format k;
    private int l;
    private long m;
    
    public Ac4Reader() {
        this(null);
    }
    
    public Ac4Reader(final String c) {
        final ParsableBitArray a = new ParsableBitArray(new byte[16]);
        this.a = a;
        this.b = new ParsableByteArray(a.a);
        this.f = 0;
        this.g = 0;
        this.h = false;
        this.i = false;
        this.m = -9223372036854775807L;
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
        final Ac4Util.SyncFrameInfo d = Ac4Util.d(this.a);
        final Format k = this.k;
        if (k == null || d.c != k.J || d.b != k.K || !"audio/ac4".equals(k.w)) {
            final Format e = new Format.Builder().S(this.d).e0("audio/ac4").H(d.c).f0(d.b).V(this.c).E();
            this.k = e;
            this.e.d(e);
        }
        this.l = d.d;
        this.j = d.e * 1000000L / this.k.K;
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
                if (parsableByteArray.D() == 172) {
                    h = true;
                }
                this.h = h;
            }
            else {
                final int d = parsableByteArray.D();
                this.h = (d == 172);
                if (d == 64 || d == 65) {
                    boolean i = b;
                    if (d == 65) {
                        i = true;
                    }
                    this.i = i;
                    return true;
                }
                continue;
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
                    final int min = Math.min(parsableByteArray.a(), this.l - this.g);
                    this.e.c(parsableByteArray, min);
                    final int g = this.g + min;
                    this.g = g;
                    final int l = this.l;
                    if (g != l) {
                        continue;
                    }
                    final long m = this.m;
                    if (m != -9223372036854775807L) {
                        this.e.e(m, 1, l, 0, null);
                        this.m += this.j;
                    }
                    this.f = 0;
                }
                else {
                    if (!this.a(parsableByteArray, this.b.d(), 16)) {
                        continue;
                    }
                    this.g();
                    this.b.P(0);
                    this.e.c(this.b, 16);
                    this.f = 2;
                }
            }
            else {
                if (!this.h(parsableByteArray)) {
                    continue;
                }
                this.f = 1;
                this.b.d()[0] = -84;
                final byte[] d = this.b.d();
                int n;
                if (this.i) {
                    n = 65;
                }
                else {
                    n = 64;
                }
                d[1] = (byte)n;
                this.g = 2;
            }
        }
    }
    
    @Override
    public void c() {
        this.f = 0;
        this.g = 0;
        this.h = false;
        this.i = false;
        this.m = -9223372036854775807L;
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
    public void f(final long m, final int n) {
        if (m != -9223372036854775807L) {
            this.m = m;
        }
    }
}
