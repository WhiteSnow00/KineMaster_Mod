// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.exoplayer2.extractor.ts;

import com.google.android.exoplayer2.extractor.ExtractorOutput;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.drm.DrmInitData;
import com.google.android.exoplayer2.audio.DtsUtil;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.extractor.TrackOutput;
import com.google.android.exoplayer2.util.ParsableByteArray;

public final class DtsReader implements ElementaryStreamReader
{
    private final ParsableByteArray a;
    private final String b;
    private String c;
    private TrackOutput d;
    private int e;
    private int f;
    private int g;
    private long h;
    private Format i;
    private int j;
    private long k;
    
    public DtsReader(final String b) {
        this.a = new ParsableByteArray(new byte[18]);
        this.e = 0;
        this.k = -9223372036854775807L;
        this.b = b;
    }
    
    private boolean a(final ParsableByteArray parsableByteArray, final byte[] array, final int n) {
        final int min = Math.min(parsableByteArray.a(), n - this.f);
        parsableByteArray.j(array, this.f, min);
        final int f = this.f + min;
        this.f = f;
        return f == n;
    }
    
    private void g() {
        final byte[] d = this.a.d();
        if (this.i == null) {
            final Format g = DtsUtil.g(d, this.c, this.b, null);
            this.i = g;
            this.d.d(g);
        }
        this.j = DtsUtil.a(d);
        this.h = (int)(DtsUtil.f(d) * 1000000L / this.i.K);
    }
    
    private boolean h(final ParsableByteArray parsableByteArray) {
        while (parsableByteArray.a() > 0) {
            final int g = this.g << 8;
            this.g = g;
            final int g2 = g | parsableByteArray.D();
            this.g = g2;
            if (DtsUtil.d(g2)) {
                final byte[] d = this.a.d();
                final int g3 = this.g;
                d[0] = (byte)(g3 >> 24 & 0xFF);
                d[1] = (byte)(g3 >> 16 & 0xFF);
                d[2] = (byte)(g3 >> 8 & 0xFF);
                d[3] = (byte)(g3 & 0xFF);
                this.f = 4;
                this.g = 0;
                return true;
            }
        }
        return false;
    }
    
    @Override
    public void b(final ParsableByteArray parsableByteArray) {
        Assertions.i(this.d);
        while (parsableByteArray.a() > 0) {
            final int e = this.e;
            if (e != 0) {
                if (e != 1) {
                    if (e != 2) {
                        throw new IllegalStateException();
                    }
                    final int min = Math.min(parsableByteArray.a(), this.j - this.f);
                    this.d.c(parsableByteArray, min);
                    final int f = this.f + min;
                    this.f = f;
                    final int j = this.j;
                    if (f != j) {
                        continue;
                    }
                    final long k = this.k;
                    if (k != -9223372036854775807L) {
                        this.d.e(k, 1, j, 0, null);
                        this.k += this.h;
                    }
                    this.e = 0;
                }
                else {
                    if (!this.a(parsableByteArray, this.a.d(), 18)) {
                        continue;
                    }
                    this.g();
                    this.a.P(0);
                    this.d.c(this.a, 18);
                    this.e = 2;
                }
            }
            else {
                if (!this.h(parsableByteArray)) {
                    continue;
                }
                this.e = 1;
            }
        }
    }
    
    @Override
    public void c() {
        this.e = 0;
        this.f = 0;
        this.g = 0;
        this.k = -9223372036854775807L;
    }
    
    @Override
    public void d(final ExtractorOutput extractorOutput, final TsPayloadReader.TrackIdGenerator trackIdGenerator) {
        trackIdGenerator.a();
        this.c = trackIdGenerator.b();
        this.d = extractorOutput.e(trackIdGenerator.c(), 1);
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
