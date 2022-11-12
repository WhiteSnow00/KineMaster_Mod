// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.exoplayer2.extractor;

public class ConstantBitrateSeekMap implements SeekMap
{
    private final long a;
    private final long b;
    private final int c;
    private final long d;
    private final int e;
    private final long f;
    private final boolean g;
    
    public ConstantBitrateSeekMap(final long a, final long b, final int e, final int n, final boolean g) {
        this.a = a;
        this.b = b;
        int c = n;
        if (n == -1) {
            c = 1;
        }
        this.c = c;
        this.e = e;
        this.g = g;
        if (a == -1L) {
            this.d = -1L;
            this.f = -9223372036854775807L;
        }
        else {
            this.d = a - b;
            this.f = d(a, b, e);
        }
    }
    
    private long a(long n) {
        n = n * this.e / 8000000L;
        final int c = this.c;
        final long n2 = n / c * c;
        final long d = this.d;
        n = n2;
        if (d != -1L) {
            n = Math.min(n2, d - c);
        }
        n = Math.max(n, 0L);
        return this.b + n;
    }
    
    private static long d(final long n, final long n2, final int n3) {
        return Math.max(0L, n - n2) * 8L * 1000000L / n3;
    }
    
    public long b(final long n) {
        return d(n, this.b, this.e);
    }
    
    @Override
    public SeekPoints f(long n) {
        if (this.d == -1L && !this.g) {
            return new SeekPoints(new SeekPoint(0L, this.b));
        }
        final long a = this.a(n);
        final long b = this.b(a);
        final SeekPoint seekPoint = new SeekPoint(b, a);
        if (this.d != -1L && b < n) {
            final int c = this.c;
            if (c + a < this.a) {
                n = a + c;
                return new SeekPoints(seekPoint, new SeekPoint(this.b(n), n));
            }
        }
        return new SeekPoints(seekPoint);
    }
    
    @Override
    public boolean h() {
        return this.d != -1L || this.g;
    }
    
    @Override
    public long i() {
        return this.f;
    }
}
