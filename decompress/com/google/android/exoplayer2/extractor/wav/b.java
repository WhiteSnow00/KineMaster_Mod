// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.exoplayer2.extractor.wav;

import android.util.Pair;
import com.google.android.exoplayer2.ParserException;
import com.google.android.exoplayer2.util.Util;
import com.google.android.exoplayer2.util.Assertions;
import java.io.IOException;
import com.google.android.exoplayer2.util.Log;
import com.google.android.exoplayer2.util.ParsableByteArray;
import com.google.android.exoplayer2.extractor.ExtractorInput;

final class b
{
    public static boolean a(final ExtractorInput extractorInput) throws IOException {
        final ParsableByteArray parsableByteArray = new ParsableByteArray(8);
        final int a = b.a.a(extractorInput, parsableByteArray).a;
        if (a != 1380533830 && a != 1380333108) {
            return false;
        }
        extractorInput.r(parsableByteArray.d(), 0, 4);
        parsableByteArray.P(0);
        final int n = parsableByteArray.n();
        if (n != 1463899717) {
            final StringBuilder sb = new StringBuilder();
            sb.append("Unsupported form type: ");
            sb.append(n);
            Log.c("WavHeaderReader", sb.toString());
            return false;
        }
        return true;
    }
    
    public static com.google.android.exoplayer2.extractor.wav.a b(final ExtractorInput extractorInput) throws IOException {
        final ParsableByteArray parsableByteArray = new ParsableByteArray(16);
        final a d = d(1718449184, extractorInput, parsableByteArray);
        Assertions.g(d.b >= 16L);
        extractorInput.r(parsableByteArray.d(), 0, 16);
        parsableByteArray.P(0);
        final int v = parsableByteArray.v();
        final int v2 = parsableByteArray.v();
        final int u = parsableByteArray.u();
        final int u2 = parsableByteArray.u();
        final int v3 = parsableByteArray.v();
        final int v4 = parsableByteArray.v();
        final int n = (int)d.b - 16;
        byte[] f;
        if (n > 0) {
            f = new byte[n];
            extractorInput.r(f, 0, n);
        }
        else {
            f = Util.f;
        }
        extractorInput.o((int)(extractorInput.k() - extractorInput.getPosition()));
        return new com.google.android.exoplayer2.extractor.wav.a(v, v2, u, u2, v3, v4, f);
    }
    
    public static long c(final ExtractorInput extractorInput) throws IOException {
        final ParsableByteArray parsableByteArray = new ParsableByteArray(8);
        final a a = b.a.a(extractorInput, parsableByteArray);
        if (a.a != 1685272116) {
            extractorInput.h();
            return -1L;
        }
        extractorInput.m(8);
        parsableByteArray.P(0);
        extractorInput.r(parsableByteArray.d(), 0, 8);
        final long r = parsableByteArray.r();
        extractorInput.o((int)a.b + 8);
        return r;
    }
    
    private static a d(final int n, final ExtractorInput extractorInput, final ParsableByteArray parsableByteArray) throws IOException {
        a a;
        for (a = b.a.a(extractorInput, parsableByteArray); a.a != n; a = b.a.a(extractorInput, parsableByteArray)) {
            final StringBuilder sb = new StringBuilder();
            sb.append("Ignoring unknown WAV chunk: ");
            sb.append(a.a);
            Log.i("WavHeaderReader", sb.toString());
            final long n2 = a.b + 8L;
            if (n2 > 2147483647L) {
                final StringBuilder sb2 = new StringBuilder();
                sb2.append("Chunk is too large (~2GB+) to skip; id: ");
                sb2.append(a.a);
                throw ParserException.createForUnsupportedContainerFeature(sb2.toString());
            }
            extractorInput.o((int)n2);
        }
        return a;
    }
    
    public static Pair<Long, Long> e(final ExtractorInput extractorInput) throws IOException {
        extractorInput.h();
        final a d = d(1684108385, extractorInput, new ParsableByteArray(8));
        extractorInput.o(8);
        return (Pair<Long, Long>)Pair.create((Object)extractorInput.getPosition(), (Object)d.b);
    }
    
    private static final class a
    {
        public final int a;
        public final long b;
        
        private a(final int a, final long b) {
            this.a = a;
            this.b = b;
        }
        
        public static a a(final ExtractorInput extractorInput, final ParsableByteArray parsableByteArray) throws IOException {
            extractorInput.r(parsableByteArray.d(), 0, 8);
            parsableByteArray.P(0);
            return new a(parsableByteArray.n(), parsableByteArray.t());
        }
    }
}
