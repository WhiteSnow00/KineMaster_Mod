// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.exoplayer2.source.chunk;

import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.upstream.DataSpec;
import com.google.android.exoplayer2.upstream.DataSource;

public abstract class BaseMediaChunk extends MediaChunk
{
    public final long k;
    public final long l;
    private BaseMediaChunkOutput m;
    private int[] n;
    
    public BaseMediaChunk(final DataSource dataSource, final DataSpec dataSpec, final Format format, final int n, final Object o, final long n2, final long n3, final long k, final long l, final long n4) {
        super(dataSource, dataSpec, format, n, o, n2, n3, n4);
        this.k = k;
        this.l = l;
    }
    
    public final int i(final int n) {
        return Assertions.i(this.n)[n];
    }
    
    protected final BaseMediaChunkOutput j() {
        return Assertions.i(this.m);
    }
    
    public void k(final BaseMediaChunkOutput m) {
        this.m = m;
        this.n = m.a();
    }
}
