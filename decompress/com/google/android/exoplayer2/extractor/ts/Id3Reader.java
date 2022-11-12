// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.exoplayer2.extractor.ts;

import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.extractor.ExtractorOutput;
import com.google.android.exoplayer2.util.Log;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.extractor.TrackOutput;
import com.google.android.exoplayer2.util.ParsableByteArray;

public final class Id3Reader implements ElementaryStreamReader
{
    private final ParsableByteArray a;
    private TrackOutput b;
    private boolean c;
    private long d;
    private int e;
    private int f;
    
    public Id3Reader() {
        this.a = new ParsableByteArray(10);
        this.d = -9223372036854775807L;
    }
    
    @Override
    public void b(final ParsableByteArray parsableByteArray) {
        Assertions.i(this.b);
        if (!this.c) {
            return;
        }
        final int a = parsableByteArray.a();
        final int f = this.f;
        if (f < 10) {
            final int min = Math.min(a, 10 - f);
            System.arraycopy(parsableByteArray.d(), parsableByteArray.e(), this.a.d(), this.f, min);
            if (this.f + min == 10) {
                this.a.P(0);
                if (73 != this.a.D() || 68 != this.a.D() || 51 != this.a.D()) {
                    Log.i("Id3Reader", "Discarding invalid ID3 tag");
                    this.c = false;
                    return;
                }
                this.a.Q(3);
                this.e = this.a.C() + 10;
            }
        }
        final int min2 = Math.min(a, this.e - this.f);
        this.b.c(parsableByteArray, min2);
        this.f += min2;
    }
    
    @Override
    public void c() {
        this.c = false;
        this.d = -9223372036854775807L;
    }
    
    @Override
    public void d(final ExtractorOutput extractorOutput, final TsPayloadReader.TrackIdGenerator trackIdGenerator) {
        trackIdGenerator.a();
        (this.b = extractorOutput.e(trackIdGenerator.c(), 5)).d(new Format.Builder().S(trackIdGenerator.b()).e0("application/id3").E());
    }
    
    @Override
    public void e() {
        Assertions.i(this.b);
        if (this.c) {
            final int e = this.e;
            if (e != 0) {
                if (this.f == e) {
                    final long d = this.d;
                    if (d != -9223372036854775807L) {
                        this.b.e(d, 1, e, 0, null);
                    }
                    this.c = false;
                }
            }
        }
    }
    
    @Override
    public void f(final long d, final int n) {
        if ((n & 0x4) == 0x0) {
            return;
        }
        this.c = true;
        if (d != -9223372036854775807L) {
            this.d = d;
        }
        this.e = 0;
        this.f = 0;
    }
}
