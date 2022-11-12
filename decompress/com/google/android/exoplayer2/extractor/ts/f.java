// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.exoplayer2.extractor.ts;

import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.extractor.ExtractorOutput;
import com.google.android.exoplayer2.extractor.CeaUtil;
import com.google.android.exoplayer2.util.ParsableByteArray;
import com.google.android.exoplayer2.extractor.TrackOutput;
import com.google.android.exoplayer2.Format;
import java.util.List;

final class f
{
    private final List<Format> a;
    private final TrackOutput[] b;
    
    public f(final List<Format> a) {
        this.a = a;
        this.b = new TrackOutput[a.size()];
    }
    
    public void a(final long n, final ParsableByteArray parsableByteArray) {
        if (parsableByteArray.a() < 9) {
            return;
        }
        final int n2 = parsableByteArray.n();
        final int n3 = parsableByteArray.n();
        final int d = parsableByteArray.D();
        if (n2 == 434 && n3 == 1195456820 && d == 3) {
            CeaUtil.b(n, parsableByteArray, this.b);
        }
    }
    
    public void b(final ExtractorOutput extractorOutput, final TsPayloadReader.TrackIdGenerator trackIdGenerator) {
        for (int i = 0; i < this.b.length; ++i) {
            trackIdGenerator.a();
            final TrackOutput e = extractorOutput.e(trackIdGenerator.c(), 3);
            final Format format = this.a.get(i);
            final String w = format.w;
            final boolean b = "application/cea-608".equals(w) || "application/cea-708".equals(w);
            final StringBuilder sb = new StringBuilder();
            sb.append("Invalid closed caption mime type provided: ");
            sb.append(w);
            Assertions.b(b, sb.toString());
            e.d(new Format.Builder().S(trackIdGenerator.b()).e0(w).g0(format.d).V(format.c).F(format.O).T(format.y).E());
            this.b[i] = e;
        }
    }
}
