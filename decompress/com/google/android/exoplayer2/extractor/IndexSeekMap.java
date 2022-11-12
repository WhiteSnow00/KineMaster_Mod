// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.exoplayer2.extractor;

import com.google.android.exoplayer2.util.Util;
import com.google.android.exoplayer2.util.Assertions;

public final class IndexSeekMap implements SeekMap
{
    private final long[] a;
    private final long[] b;
    private final long c;
    private final boolean d;
    
    public IndexSeekMap(final long[] a, final long[] b, final long c) {
        Assertions.a(a.length == b.length);
        final int length = b.length;
        final boolean d = length > 0;
        this.d = d;
        if (d && b[0] > 0L) {
            final int n = length + 1;
            final long[] a2 = new long[n];
            this.a = a2;
            final long[] b2 = new long[n];
            this.b = b2;
            System.arraycopy(a, 0, a2, 1, length);
            System.arraycopy(b, 0, b2, 1, length);
        }
        else {
            this.a = a;
            this.b = b;
        }
        this.c = c;
    }
    
    @Override
    public SeekPoints f(final long n) {
        if (!this.d) {
            return new SeekPoints(SeekPoint.c);
        }
        int i = Util.i(this.b, n, true, true);
        final SeekPoint seekPoint = new SeekPoint(this.b[i], this.a[i]);
        if (seekPoint.a != n && i != this.b.length - 1) {
            final long[] b = this.b;
            ++i;
            return new SeekPoints(seekPoint, new SeekPoint(b[i], this.a[i]));
        }
        return new SeekPoints(seekPoint);
    }
    
    @Override
    public boolean h() {
        return this.d;
    }
    
    @Override
    public long i() {
        return this.c;
    }
}
