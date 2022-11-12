// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.exoplayer2.extractor.wav;

import com.google.android.exoplayer2.extractor.SeekPoint;
import com.google.android.exoplayer2.util.Util;
import com.google.android.exoplayer2.extractor.SeekMap;

final class c implements SeekMap
{
    private final a a;
    private final int b;
    private final long c;
    private final long d;
    private final long e;
    
    public c(final a a, final int b, long n, final long n2) {
        this.a = a;
        this.b = b;
        this.c = n;
        n = (n2 - n) / a.e;
        this.d = n;
        this.e = this.a(n);
    }
    
    private long a(final long n) {
        return Util.O0(n * this.b, 1000000L, this.a.c);
    }
    
    @Override
    public SeekPoints f(long n) {
        final long r = Util.r(this.a.c * n / (this.b * 1000000L), 0L, this.d - 1L);
        final long c = this.c;
        final long n2 = this.a.e;
        final long a = this.a(r);
        final SeekPoint seekPoint = new SeekPoint(a, c + n2 * r);
        if (a < n && r != this.d - 1L) {
            final long n3 = r + 1L;
            final long c2 = this.c;
            n = this.a.e;
            return new SeekPoints(seekPoint, new SeekPoint(this.a(n3), c2 + n * n3));
        }
        return new SeekPoints(seekPoint);
    }
    
    @Override
    public boolean h() {
        return true;
    }
    
    @Override
    public long i() {
        return this.e;
    }
}
