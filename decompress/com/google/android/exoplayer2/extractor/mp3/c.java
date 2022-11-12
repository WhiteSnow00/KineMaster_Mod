// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.exoplayer2.extractor.mp3;

import com.google.android.exoplayer2.extractor.SeekPoint;
import com.google.android.exoplayer2.extractor.SeekMap;
import android.util.Pair;
import com.google.android.exoplayer2.metadata.id3.MlltFrame;
import com.google.android.exoplayer2.util.Util;

final class c implements Seeker
{
    private final long[] a;
    private final long[] b;
    private final long c;
    
    private c(final long[] a, final long[] b, long c0) {
        this.a = a;
        this.b = b;
        if (c0 == -9223372036854775807L) {
            c0 = Util.C0(b[b.length - 1]);
        }
        this.c = c0;
    }
    
    public static c a(long n, final MlltFrame mlltFrame, final long n2) {
        final int length = mlltFrame.e.length;
        final int n3 = length + 1;
        final long[] array = new long[n3];
        final long[] array2 = new long[n3];
        array[0] = n;
        long n4 = 0L;
        array2[0] = 0L;
        for (int i = 1; i <= length; ++i) {
            final int c = mlltFrame.c;
            final int[] e = mlltFrame.e;
            final int n5 = i - 1;
            n += c + e[n5];
            n4 += mlltFrame.d + mlltFrame.f[n5];
            array[i] = n;
            array2[i] = n4;
        }
        return new c(array, array2, n2);
    }
    
    private static Pair<Long, Long> b(final long n, final long[] array, final long[] array2) {
        int i = Util.i(array, n, true, true);
        final long n2 = array[i];
        final long n3 = array2[i];
        if (++i == array.length) {
            return (Pair<Long, Long>)Pair.create((Object)n2, (Object)n3);
        }
        final long n4 = array[i];
        final long n5 = array2[i];
        double n6;
        if (n4 == n2) {
            n6 = 0.0;
        }
        else {
            n6 = (n - (double)n2) / (n4 - n2);
        }
        return (Pair<Long, Long>)Pair.create((Object)n, (Object)((long)(n6 * (n5 - n3)) + n3));
    }
    
    @Override
    public long c(final long n) {
        return Util.C0((long)b(n, this.a, this.b).second);
    }
    
    @Override
    public SeekPoints f(final long n) {
        final Pair<Long, Long> b = b(Util.f1(Util.r(n, 0L, this.c)), this.b, this.a);
        return new SeekMap.SeekPoints(new SeekPoint(Util.C0((long)b.first), (long)b.second));
    }
    
    @Override
    public long g() {
        return -1L;
    }
    
    @Override
    public boolean h() {
        return true;
    }
    
    @Override
    public long i() {
        return this.c;
    }
}
