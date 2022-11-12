// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.exoplayer2.extractor;

import com.google.android.exoplayer2.util.Util;
import com.google.android.exoplayer2.util.Assertions;

public final class FlacSeekTableSeekMap implements SeekMap
{
    private final FlacStreamMetadata a;
    private final long b;
    
    public FlacSeekTableSeekMap(final FlacStreamMetadata a, final long b) {
        this.a = a;
        this.b = b;
    }
    
    private SeekPoint a(final long n, final long n2) {
        return new SeekPoint(n * 1000000L / this.a.e, this.b + n2);
    }
    
    @Override
    public SeekPoints f(final long n) {
        Assertions.i(this.a.k);
        final FlacStreamMetadata a = this.a;
        final FlacStreamMetadata.SeekTable k = a.k;
        final long[] a2 = k.a;
        final long[] b = k.b;
        int i = Util.i(a2, a.i(n), true, false);
        long n2 = 0L;
        long n3;
        if (i == -1) {
            n3 = 0L;
        }
        else {
            n3 = a2[i];
        }
        if (i != -1) {
            n2 = b[i];
        }
        final SeekPoint a3 = this.a(n3, n2);
        if (a3.a != n && i != a2.length - 1) {
            ++i;
            return new SeekPoints(a3, this.a(a2[i], b[i]));
        }
        return new SeekPoints(a3);
    }
    
    @Override
    public boolean h() {
        return true;
    }
    
    @Override
    public long i() {
        return this.a.f();
    }
}
