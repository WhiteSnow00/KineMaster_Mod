// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.exoplayer2.extractor.mp3;

import com.google.android.exoplayer2.extractor.SeekPoint;
import com.google.android.exoplayer2.extractor.SeekMap;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.Log;
import com.google.android.exoplayer2.util.Util;
import com.google.android.exoplayer2.util.ParsableByteArray;
import com.google.android.exoplayer2.audio.MpegAudioUtil;

final class e implements Seeker
{
    private final long a;
    private final int b;
    private final long c;
    private final long d;
    private final long e;
    private final long[] f;
    
    private e(final long n, final int n2, final long n3) {
        this(n, n2, n3, -1L, null);
    }
    
    private e(long n, final int b, long c, final long d, final long[] f) {
        this.a = n;
        this.b = b;
        this.c = c;
        this.f = f;
        this.d = d;
        c = -1L;
        if (d == -1L) {
            n = c;
        }
        else {
            n += d;
        }
        this.e = n;
    }
    
    public static e a(final long n, final long n2, final MpegAudioUtil.Header header, final ParsableByteArray parsableByteArray) {
        final int g = header.g;
        final int d = header.d;
        final int n3 = parsableByteArray.n();
        if ((n3 & 0x1) == 0x1) {
            final int h = parsableByteArray.H();
            if (h != 0) {
                final long o0 = Util.O0(h, g * 1000000L, d);
                if ((n3 & 0x6) != 0x6) {
                    return new e(n2, header.c, o0);
                }
                final long f = parsableByteArray.F();
                final long[] array = new long[100];
                for (int i = 0; i < 100; ++i) {
                    array[i] = parsableByteArray.D();
                }
                if (n != -1L) {
                    final long n4 = n2 + f;
                    if (n != n4) {
                        final StringBuilder sb = new StringBuilder();
                        sb.append("XING data size mismatch: ");
                        sb.append(n);
                        sb.append(", ");
                        sb.append(n4);
                        Log.i("XingSeeker", sb.toString());
                    }
                }
                return new e(n2, header.c, o0, f, array);
            }
        }
        return null;
    }
    
    private long b(final int n) {
        return this.c * n / 100L;
    }
    
    @Override
    public long c(long n) {
        n -= this.a;
        if (this.h() && n > this.b) {
            final long[] array = Assertions.i(this.f);
            final double n2 = n * 256.0 / this.d;
            final int i = Util.i(array, (long)n2, true, true);
            final long b = this.b(i);
            final long n3 = array[i];
            final int n4 = i + 1;
            final long b2 = this.b(n4);
            if (i == 99) {
                n = 256L;
            }
            else {
                n = array[n4];
            }
            double n5;
            if (n3 == n) {
                n5 = 0.0;
            }
            else {
                n5 = (n2 - n3) / (n - n3);
            }
            return b + Math.round(n5 * (b2 - b));
        }
        return 0L;
    }
    
    @Override
    public SeekPoints f(long r) {
        if (!this.h()) {
            return new SeekMap.SeekPoints(new SeekPoint(0L, this.a + this.b));
        }
        r = Util.r(r, 0L, this.c);
        final double n = r * 100.0 / this.c;
        double n2 = 0.0;
        if (n > 0.0) {
            if (n >= 100.0) {
                n2 = 256.0;
            }
            else {
                final int n3 = (int)n;
                final long[] array = Assertions.i(this.f);
                final double n4 = (double)array[n3];
                double n5;
                if (n3 == 99) {
                    n5 = 256.0;
                }
                else {
                    n5 = (double)array[n3 + 1];
                }
                n2 = n4 + (n - n3) * (n5 - n4);
            }
        }
        return new SeekMap.SeekPoints(new SeekPoint(r, this.a + Util.r(Math.round(n2 / 256.0 * this.d), this.b, this.d - 1L)));
    }
    
    @Override
    public long g() {
        return this.e;
    }
    
    @Override
    public boolean h() {
        return this.f != null;
    }
    
    @Override
    public long i() {
        return this.c;
    }
}
