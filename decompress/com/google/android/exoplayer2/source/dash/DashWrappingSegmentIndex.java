// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.exoplayer2.source.dash;

import com.google.android.exoplayer2.source.dash.manifest.RangedUri;
import com.google.android.exoplayer2.extractor.ChunkIndex;

public final class DashWrappingSegmentIndex implements DashSegmentIndex
{
    private final ChunkIndex a;
    private final long b;
    
    public DashWrappingSegmentIndex(final ChunkIndex a, final long b) {
        this.a = a;
        this.b = b;
    }
    
    @Override
    public long a(final long n, final long n2) {
        return this.a.d[(int)n];
    }
    
    @Override
    public long b(final long n, final long n2) {
        return 0L;
    }
    
    @Override
    public long c(final long n) {
        return this.a.e[(int)n] - this.b;
    }
    
    @Override
    public long d(final long n, final long n2) {
        return -9223372036854775807L;
    }
    
    @Override
    public RangedUri e(final long n) {
        final ChunkIndex a = this.a;
        final long[] c = a.c;
        final int n2 = (int)n;
        return new RangedUri(null, c[n2], a.b[n2]);
    }
    
    @Override
    public long f(final long n, final long n2) {
        return this.a.a(n + this.b);
    }
    
    @Override
    public long g(final long n) {
        return this.a.a;
    }
    
    @Override
    public boolean h() {
        return true;
    }
    
    @Override
    public long i() {
        return 0L;
    }
    
    @Override
    public long j(final long n, final long n2) {
        return this.a.a;
    }
}
