// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.exoplayer2.extractor;

import java.util.Arrays;
import com.google.android.exoplayer2.util.Util;

public final class ChunkIndex implements SeekMap
{
    public final int a;
    public final int[] b;
    public final long[] c;
    public final long[] d;
    public final long[] e;
    private final long f;
    
    public ChunkIndex(final int[] b, final long[] c, final long[] d, final long[] e) {
        this.b = b;
        this.c = c;
        this.d = d;
        this.e = e;
        final int length = b.length;
        this.a = length;
        if (length > 0) {
            this.f = d[length - 1] + e[length - 1];
        }
        else {
            this.f = 0L;
        }
    }
    
    public int a(final long n) {
        return Util.i(this.e, n, true, true);
    }
    
    @Override
    public SeekPoints f(final long n) {
        int a = this.a(n);
        final SeekPoint seekPoint = new SeekPoint(this.e[a], this.c[a]);
        if (seekPoint.a < n && a != this.a - 1) {
            final long[] e = this.e;
            ++a;
            return new SeekPoints(seekPoint, new SeekPoint(e[a], this.c[a]));
        }
        return new SeekPoints(seekPoint);
    }
    
    @Override
    public boolean h() {
        return true;
    }
    
    @Override
    public long i() {
        return this.f;
    }
    
    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append("ChunkIndex(length=");
        sb.append(this.a);
        sb.append(", sizes=");
        sb.append(Arrays.toString(this.b));
        sb.append(", offsets=");
        sb.append(Arrays.toString(this.c));
        sb.append(", timeUs=");
        sb.append(Arrays.toString(this.e));
        sb.append(", durationsUs=");
        sb.append(Arrays.toString(this.d));
        sb.append(")");
        return sb.toString();
    }
}
