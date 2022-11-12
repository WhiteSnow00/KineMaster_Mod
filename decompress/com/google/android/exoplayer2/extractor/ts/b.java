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

final class b extends BinarySearchSeeker
{
    public b(final TimestampAdjuster timestampAdjuster, final long n, final long n2) {
        super((SeekTimestampConverter)new DefaultSeekTimestampConverter(), (TimestampSeeker)new b(timestampAdjuster, null), n, 0L, n + 1L, 0L, n2, 188L, 1000);
    }
    
    static int j(final byte[] array, final int n) {
        return k(array, n);
    }
    
    private static int k(final byte[] array, final int n) {
        return (array[n + 3] & 0xFF) | ((array[n] & 0xFF) << 24 | (array[n + 1] & 0xFF) << 16 | (array[n + 2] & 0xFF) << 8);
    }
    
    private static final class b implements TimestampSeeker
    {
        private final TimestampAdjuster a;
        private final ParsableByteArray b;
        
        private b(final TimestampAdjuster a) {
            this.a = a;
            this.b = new ParsableByteArray();
        }
        
        b(final TimestampAdjuster timestampAdjuster, final b$a object) {
            this(timestampAdjuster);
        }
        
        private TimestampSearchResult c(final ParsableByteArray parsableByteArray, final long n, final long n2) {
            int e = -1;
            int n3 = -1;
            long n4 = -9223372036854775807L;
            while (parsableByteArray.a() >= 4) {
                if (com.google.android.exoplayer2.extractor.ts.b.j(parsableByteArray.d(), parsableByteArray.e()) != 442) {
                    parsableByteArray.Q(1);
                }
                else {
                    parsableByteArray.Q(4);
                    final long l = com.google.android.exoplayer2.extractor.ts.c.l(parsableByteArray);
                    int e2 = n3;
                    long b = n4;
                    if (l != -9223372036854775807L) {
                        b = this.a.b(l);
                        if (b > n) {
                            if (n4 == -9223372036854775807L) {
                                return TimestampSearchResult.d(b, n2);
                            }
                            return TimestampSearchResult.e(n2 + n3);
                        }
                        else {
                            if (100000L + b > n) {
                                return TimestampSearchResult.e(n2 + parsableByteArray.e());
                            }
                            e2 = parsableByteArray.e();
                        }
                    }
                    d(parsableByteArray);
                    e = parsableByteArray.e();
                    n3 = e2;
                    n4 = b;
                }
            }
            if (n4 != -9223372036854775807L) {
                return TimestampSearchResult.f(n4, n2 + e);
            }
            return TimestampSearchResult.d;
        }
        
        private static void d(final ParsableByteArray parsableByteArray) {
            final int f = parsableByteArray.f();
            if (parsableByteArray.a() < 10) {
                parsableByteArray.P(f);
                return;
            }
            parsableByteArray.Q(9);
            final int n = parsableByteArray.D() & 0x7;
            if (parsableByteArray.a() < n) {
                parsableByteArray.P(f);
                return;
            }
            parsableByteArray.Q(n);
            if (parsableByteArray.a() < 4) {
                parsableByteArray.P(f);
                return;
            }
            if (com.google.android.exoplayer2.extractor.ts.b.j(parsableByteArray.d(), parsableByteArray.e()) == 443) {
                parsableByteArray.Q(4);
                final int j = parsableByteArray.J();
                if (parsableByteArray.a() < j) {
                    parsableByteArray.P(f);
                    return;
                }
                parsableByteArray.Q(j);
            }
            while (parsableByteArray.a() >= 4) {
                final int i = com.google.android.exoplayer2.extractor.ts.b.j(parsableByteArray.d(), parsableByteArray.e());
                if (i == 442) {
                    break;
                }
                if (i == 441) {
                    break;
                }
                if (i >>> 8 != 1) {
                    break;
                }
                parsableByteArray.Q(4);
                if (parsableByteArray.a() < 2) {
                    parsableByteArray.P(f);
                    return;
                }
                parsableByteArray.P(Math.min(parsableByteArray.f(), parsableByteArray.e() + parsableByteArray.J()));
            }
        }
        
        @Override
        public TimestampSearchResult a(final ExtractorInput extractorInput, final long n) throws IOException {
            final long position = extractorInput.getPosition();
            final int n2 = (int)Math.min(20000L, extractorInput.getLength() - position);
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
