// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.exoplayer2;

import com.google.android.exoplayer2.util.Util;
import com.google.android.exoplayer2.util.Assertions;

public final class SeekParameters
{
    public static final SeekParameters c;
    public static final SeekParameters d;
    public static final SeekParameters e;
    public static final SeekParameters f;
    public static final SeekParameters g;
    public final long a;
    public final long b;
    
    static {
        final SeekParameters g2 = c = new SeekParameters(0L, 0L);
        d = new SeekParameters(Long.MAX_VALUE, Long.MAX_VALUE);
        e = new SeekParameters(Long.MAX_VALUE, 0L);
        f = new SeekParameters(0L, Long.MAX_VALUE);
        g = g2;
    }
    
    public SeekParameters(final long a, final long b) {
        final boolean b2 = true;
        Assertions.a(a >= 0L);
        Assertions.a(b >= 0L && b2);
        this.a = a;
        this.b = b;
    }
    
    public long a(final long n, final long n2, final long n3) {
        final long a = this.a;
        if (a == 0L && this.b == 0L) {
            return n;
        }
        final long x0 = Util.X0(n, a, Long.MIN_VALUE);
        final long b = Util.b(n, this.b, Long.MAX_VALUE);
        boolean b2 = true;
        final boolean b3 = x0 <= n2 && n2 <= b;
        if (x0 > n3 || n3 > b) {
            b2 = false;
        }
        if (b3 && b2) {
            if (Math.abs(n2 - n) <= Math.abs(n3 - n)) {
                return n2;
            }
            return n3;
        }
        else {
            if (b3) {
                return n2;
            }
            if (b2) {
                return n3;
            }
            return x0;
        }
    }
    
    @Override
    public boolean equals(final Object o) {
        boolean b = true;
        if (this == o) {
            return true;
        }
        if (o != null && SeekParameters.class == o.getClass()) {
            final SeekParameters seekParameters = (SeekParameters)o;
            if (this.a != seekParameters.a || this.b != seekParameters.b) {
                b = false;
            }
            return b;
        }
        return false;
    }
    
    @Override
    public int hashCode() {
        return (int)this.a * 31 + (int)this.b;
    }
}
