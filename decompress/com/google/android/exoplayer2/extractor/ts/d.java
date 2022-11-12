// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.exoplayer2.extractor.ts;

import com.google.android.exoplayer2.util.Util;
import java.io.IOException;
import com.google.android.exoplayer2.extractor.ExtractorInput;
import com.google.android.exoplayer2.util.ParsableByteArray;
import com.google.android.exoplayer2.util.TimestampAdjuster;
import com.google.android.exoplayer2.extractor.BinarySearchSeeker;

final class d extends BinarySearchSeeker
{
    public d(final TimestampAdjuster timestampAdjuster, final long n, final long n2, final int n3, final int n4) {
        super((SeekTimestampConverter)new DefaultSeekTimestampConverter(), (TimestampSeeker)new a(n3, timestampAdjuster, n4), n, 0L, n + 1L, 0L, n2, 188L, 940);
    }
    
    private static final class a implements TimestampSeeker
    {
        private final TimestampAdjuster a;
        private final ParsableByteArray b;
        private final int c;
        private final int d;
        
        public a(final int c, final TimestampAdjuster a, final int d) {
            this.c = c;
            this.a = a;
            this.d = d;
            this.b = new ParsableByteArray();
        }
        
        private TimestampSearchResult c(final ParsableByteArray parsableByteArray, final long n, final long n2) {
            final int f = parsableByteArray.f();
            long n3 = -1L;
            long n4 = -1L;
            long n5 = -9223372036854775807L;
            while (parsableByteArray.a() >= 188) {
                final int a = TsUtil.a(parsableByteArray.d(), parsableByteArray.e(), f);
                final int n6 = a + 188;
                if (n6 > f) {
                    break;
                }
                final long c = TsUtil.c(parsableByteArray, a, this.c);
                long n7 = n4;
                long b = n5;
                if (c != -9223372036854775807L) {
                    b = this.a.b(c);
                    if (b > n) {
                        if (n5 == -9223372036854775807L) {
                            return TimestampSearchResult.d(b, n2);
                        }
                        return TimestampSearchResult.e(n2 + n4);
                    }
                    else {
                        if (100000L + b > n) {
                            return TimestampSearchResult.e(n2 + a);
                        }
                        n7 = a;
                    }
                }
                parsableByteArray.P(n6);
                n3 = n6;
                n4 = n7;
                n5 = b;
            }
            if (n5 != -9223372036854775807L) {
                return TimestampSearchResult.f(n5, n2 + n3);
            }
            return TimestampSearchResult.d;
        }
        
        @Override
        public TimestampSearchResult a(final ExtractorInput extractorInput, final long n) throws IOException {
            final long position = extractorInput.getPosition();
            final int n2 = (int)Math.min(this.d, extractorInput.getLength() - position);
            this.b.L(n2);
            extractorInput.r(this.b.d(), 0, n2);
            return this.c(this.b, n, position);
        }
        
        @Override
        public void b() {
            this.b.M(Util.f);
        }
    }
}
