// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.exoplayer2.source.chunk;

import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.upstream.DataSpec;
import com.google.android.exoplayer2.upstream.DataSource;

public abstract class MediaChunk extends Chunk
{
    public final long j;
    
    public MediaChunk(final DataSource dataSource, final DataSpec dataSpec, final Format format, final int n, final Object o, final long n2, final long n3, final long j) {
        super(dataSource, dataSpec, 1, format, n, o, n2, n3);
        Assertions.e(format);
        this.j = j;
    }
    
    public long g() {
        final long j = this.j;
        long n = -1L;
        if (j != -1L) {
            n = 1L + j;
        }
        return n;
    }
    
    public abstract boolean h();
}
