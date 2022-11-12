// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.exoplayer2.extractor.ts;

import com.google.android.exoplayer2.extractor.ExtractorOutput;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.extractor.TrackOutput;
import com.google.android.exoplayer2.audio.MpegAudioUtil;
import com.google.android.exoplayer2.util.ParsableByteArray;

public final class MpegAudioReader implements ElementaryStreamReader
{
    private final ParsableByteArray a;
    private final MpegAudioUtil.Header b;
    private final String c;
    private TrackOutput d;
    private String e;
    private int f;
    private int g;
    private boolean h;
    private boolean i;
    private long j;
    private int k;
    private long l;
    
    public MpegAudioReader() {
        this(null);
    }
    
    public MpegAudioReader(final String c) {
        this.f = 0;
        final ParsableByteArray a = new ParsableByteArray(4);
        this.a = a;
        a.d()[0] = -1;
        this.b = new MpegAudioUtil.Header();
        this.l = -9223372036854775807L;
        this.c = c;
    }
    
    private void a(final ParsableByteArray parsableByteArray) {
        final byte[] d = parsableByteArray.d();
        int i;
        int f;
        for (i = parsableByteArray.e(), f = parsableByteArray.f(); i < f; ++i) {
            final boolean j = (d[i] & 0xFF) == 0xFF;
            final boolean b = this.i && (d[i] & 0xE0) == 0xE0;
            this.i = j;
            if (b) {
                parsableByteArray.P(i + 1);
                this.i = false;
                this.a.d()[1] = d[i];
                this.g = 2;
                this.f = 1;
                return;
            }
        }
        parsableByteArray.P(f);
    }
    
    private void g(final ParsableByteArray parsableByteArray) {
        final int min = Math.min(parsableByteArray.a(), this.k - this.g);
        this.d.c(parsableByteArray, min);
        final int g = this.g + min;
        this.g = g;
        final int k = this.k;
        if (g < k) {
            return;
        }
        final long l = this.l;
        if (l != -9223372036854775807L) {
            this.d.e(l, 1, k, 0, null);
            this.l += this.j;
        }
        this.g = 0;
        this.f = 0;
    }
    
    private void h(final ParsableByteArray parsableByteArray) {
        final int min = Math.min(parsableByteArray.a(), 4 - this.g);
        parsableByteArray.j(this.a.d(), this.g, min);
        final int g = this.g + min;
        this.g = g;
        if (g < 4) {
            return;
        }
        this.a.P(0);
        if (!this.b.a(this.a.n())) {
            this.g = 0;
            this.f = 1;
            return;
        }
        final MpegAudioUtil.Header b = this.b;
        this.k = b.c;
        if (!this.h) {
            this.j = b.g * 1000000L / b.d;
            this.d.d(new Format.Builder().S(this.e).e0(this.b.b).W(4096).H(this.b.e).f0(this.b.d).V(this.c).E());
            this.h = true;
        }
        this.a.P(0);
        this.d.c(this.a, 4);
        this.f = 2;
    }
    
    @Override
    public void b(final ParsableByteArray parsableByteArray) {
        Assertions.i(this.d);
        while (parsableByteArray.a() > 0) {
            final int f = this.f;
            if (f != 0) {
                if (f != 1) {
                    if (f != 2) {
                        throw new IllegalStateException();
                    }
                    this.g(parsableByteArray);
                }
                else {
                    this.h(parsableByteArray);
                }
            }
            else {
                this.a(parsableByteArray);
            }
        }
    }
    
    @Override
    public void c() {
        this.f = 0;
        this.g = 0;
        this.i = false;
        this.l = -9223372036854775807L;
    }
    
    @Override
    public void d(final ExtractorOutput extractorOutput, final TsPayloadReader.TrackIdGenerator trackIdGenerator) {
        trackIdGenerator.a();
        this.e = trackIdGenerator.b();
        this.d = extractorOutput.e(trackIdGenerator.c(), 1);
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
