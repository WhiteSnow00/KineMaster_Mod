// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.exoplayer2.source.dash.manifest;

import com.google.android.exoplayer2.source.dash.DashSegmentIndex;

final class a implements DashSegmentIndex
{
    private final RangedUri a;
    
    public a(final RangedUri a) {
        this.a = a;
    }
    
    @Override
    public long a(final long n, final long n2) {
        return n2;
    }
    
    @Override
    public long b(final long n, final long n2) {
        return 0L;
    }
    
    @Override
    public long c(final long n) {
        return 0L;
    }
    
    @Override
    public long d(final long n, final long n2) {
        return -9223372036854775807L;
    }
    
    @Override
    public RangedUri e(final long n) {
        return this.a;
    }
    
    @Override
    public long f(final long n, final long n2) {
        return 0L;
    }
    
    @Override
    public long g(final long n) {
        return 1L;
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
        return 1L;
    }
}
