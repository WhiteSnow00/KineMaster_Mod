// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.exoplayer2.extractor.ts;

import com.google.android.exoplayer2.util.ParsableByteArray;
import com.google.android.exoplayer2.extractor.ExtractorOutput;
import com.google.android.exoplayer2.util.Util;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.extractor.TrackOutput;
import com.google.android.exoplayer2.util.TimestampAdjuster;
import com.google.android.exoplayer2.Format;

public final class PassthroughSectionPayloadReader implements SectionPayloadReader
{
    private Format a;
    private TimestampAdjuster b;
    private TrackOutput c;
    
    public PassthroughSectionPayloadReader(final String s) {
        this.a = new Format.Builder().e0(s).E();
    }
    
    private void c() {
        Assertions.i(this.b);
        Util.j(this.c);
    }
    
    @Override
    public void a(final TimestampAdjuster b, final ExtractorOutput extractorOutput, final TsPayloadReader.TrackIdGenerator trackIdGenerator) {
        this.b = b;
        trackIdGenerator.a();
        (this.c = extractorOutput.e(trackIdGenerator.c(), 5)).d(this.a);
    }
    
    @Override
    public void b(final ParsableByteArray parsableByteArray) {
        this.c();
        final long d = this.b.d();
        final long e = this.b.e();
        if (d != -9223372036854775807L) {
            if (e != -9223372036854775807L) {
                final Format a = this.a;
                if (e != a.A) {
                    final Format e2 = a.b().i0(e).E();
                    this.a = e2;
                    this.c.d(e2);
                }
                final int a2 = parsableByteArray.a();
                this.c.c(parsableByteArray, a2);
                this.c.e(d, 1, a2, 0, null);
            }
        }
    }
}
