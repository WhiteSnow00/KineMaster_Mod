// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.exoplayer2.extractor.mp3;

import com.google.android.exoplayer2.extractor.SeekPoint;
import com.google.android.exoplayer2.extractor.SeekMap;
import com.google.android.exoplayer2.util.Log;
import com.google.android.exoplayer2.util.Util;
import com.google.android.exoplayer2.util.ParsableByteArray;
import com.google.android.exoplayer2.audio.MpegAudioUtil;

final class d implements Seeker
{
    private final long[] a;
    private final long[] b;
    private final long c;
    private final long d;
    
    private d(final long[] a, final long[] b, final long c, final long d) {
        this.a = a;
        this.b = b;
        this.c = c;
        this.d = d;
    }
    
    public static d a(final long n, long n2, final MpegAudioUtil.Header header, final ParsableByteArray parsableByteArray) {
        parsableByteArray.Q(10);
        final int n3 = parsableByteArray.n();
        if (n3 <= 0) {
            return null;
        }
        final int d = header.d;
        final long n4 = n3;
        int n5;
        if (d >= 32000) {
            n5 = 1152;
        }
        else {
            n5 = 576;
        }
        final long o0 = Util.O0(n4, 1000000L * n5, d);
        final int j = parsableByteArray.J();
        final int i = parsableByteArray.J();
        final int k = parsableByteArray.J();
        parsableByteArray.Q(2);
        final long n6 = n2 + header.c;
        final long[] array = new long[j];
        final long[] array2 = new long[j];
        int l = 0;
        long n7 = n2;
        n2 = n6;
        while (l < j) {
            array[l] = l * o0 / j;
            array2[l] = Math.max(n7, n2);
            int n8;
            if (k != 1) {
                if (k != 2) {
                    if (k != 3) {
                        if (k != 4) {
                            return null;
                        }
                        n8 = parsableByteArray.H();
                    }
                    else {
                        n8 = parsableByteArray.G();
                    }
                }
                else {
                    n8 = parsableByteArray.J();
                }
            }
            else {
                n8 = parsableByteArray.D();
            }
            n7 += n8 * (long)i;
            ++l;
        }
        if (n != -1L && n != n7) {
            final StringBuilder sb = new StringBuilder();
            sb.append("VBRI data size mismatch: ");
            sb.append(n);
            sb.append(", ");
            sb.append(n7);
            Log.i("VbriSeeker", sb.toString());
        }
        return new d(array, array2, o0, n7);
    }
    
    @Override
    public long c(final long n) {
        return this.a[Util.i(this.b, n, true, true)];
    }
    
    @Override
    public SeekPoints f(final long n) {
        int i = Util.i(this.a, n, true, true);
        final SeekPoint seekPoint = new SeekPoint(this.a[i], this.b[i]);
        if (seekPoint.a < n && i != this.a.length - 1) {
            final long[] a = this.a;
            ++i;
            return new SeekMap.SeekPoints(seekPoint, new SeekPoint(a[i], this.b[i]));
        }
        return new SeekMap.SeekPoints(seekPoint);
    }
    
    @Override
    public long g() {
        return this.d;
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
