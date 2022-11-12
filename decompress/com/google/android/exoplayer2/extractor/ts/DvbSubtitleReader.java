// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.exoplayer2.extractor.ts;

import java.util.Collections;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.extractor.ExtractorOutput;
import com.google.android.exoplayer2.util.ParsableByteArray;
import com.google.android.exoplayer2.extractor.TrackOutput;
import java.util.List;

public final class DvbSubtitleReader implements ElementaryStreamReader
{
    private final List<TsPayloadReader.DvbSubtitleInfo> a;
    private final TrackOutput[] b;
    private boolean c;
    private int d;
    private int e;
    private long f;
    
    public DvbSubtitleReader(final List<TsPayloadReader.DvbSubtitleInfo> a) {
        this.a = a;
        this.b = new TrackOutput[a.size()];
        this.f = -9223372036854775807L;
    }
    
    private boolean a(final ParsableByteArray parsableByteArray, final int n) {
        if (parsableByteArray.a() == 0) {
            return false;
        }
        if (parsableByteArray.D() != n) {
            this.c = false;
        }
        --this.d;
        return this.c;
    }
    
    @Override
    public void b(final ParsableByteArray parsableByteArray) {
        if (this.c) {
            if (this.d == 2 && !this.a(parsableByteArray, 32)) {
                return;
            }
            final int d = this.d;
            int i = 0;
            if (d == 1 && !this.a(parsableByteArray, 0)) {
                return;
            }
            final int e = parsableByteArray.e();
            final int a = parsableByteArray.a();
            for (TrackOutput[] b = this.b; i < b.length; ++i) {
                final TrackOutput trackOutput = b[i];
                parsableByteArray.P(e);
                trackOutput.c(parsableByteArray, a);
            }
            this.e += a;
        }
    }
    
    @Override
    public void c() {
        this.c = false;
        this.f = -9223372036854775807L;
    }
    
    @Override
    public void d(final ExtractorOutput extractorOutput, final TsPayloadReader.TrackIdGenerator trackIdGenerator) {
        for (int i = 0; i < this.b.length; ++i) {
            final TsPayloadReader.DvbSubtitleInfo dvbSubtitleInfo = this.a.get(i);
            trackIdGenerator.a();
            final TrackOutput e = extractorOutput.e(trackIdGenerator.c(), 3);
            e.d(new Format.Builder().S(trackIdGenerator.b()).e0("application/dvbsubs").T(Collections.singletonList(dvbSubtitleInfo.c)).V(dvbSubtitleInfo.a).E());
            this.b[i] = e;
        }
    }
    
    @Override
    public void e() {
        if (this.c) {
            if (this.f != -9223372036854775807L) {
                final TrackOutput[] b = this.b;
                for (int length = b.length, i = 0; i < length; ++i) {
                    b[i].e(this.f, 1, this.e, 0, null);
                }
            }
            this.c = false;
        }
    }
    
    @Override
    public void f(final long f, final int n) {
        if ((n & 0x4) == 0x0) {
            return;
        }
        this.c = true;
        if (f != -9223372036854775807L) {
            this.f = f;
        }
        this.e = 0;
        this.d = 2;
    }
}
