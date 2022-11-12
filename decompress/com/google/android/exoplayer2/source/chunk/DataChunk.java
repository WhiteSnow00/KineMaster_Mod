// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.exoplayer2.source.chunk;

import java.io.IOException;
import com.google.android.exoplayer2.upstream.DataSourceUtil;
import java.util.Arrays;
import com.google.android.exoplayer2.util.Util;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.upstream.DataSpec;
import com.google.android.exoplayer2.upstream.DataSource;

public abstract class DataChunk extends Chunk
{
    private byte[] j;
    private volatile boolean k;
    
    public DataChunk(final DataSource dataSource, final DataSpec dataSpec, final int n, final Format format, final int n2, final Object o, byte[] f) {
        super(dataSource, dataSpec, n, format, n2, o, -9223372036854775807L, -9223372036854775807L);
        if (f == null) {
            f = Util.f;
        }
        this.j = f;
    }
    
    private void i(final int n) {
        final byte[] j = this.j;
        if (j.length < n + 16384) {
            this.j = Arrays.copyOf(j, j.length + 16384);
        }
    }
    
    @Override
    public final void a() throws IOException {
        try {
            super.i.b(super.b);
            int n = 0;
            int n2 = 0;
            while (n != -1 && !this.k) {
                this.i(n2);
                final int read = super.i.read(this.j, n2, 16384);
                if ((n = read) != -1) {
                    n2 += read;
                    n = read;
                }
            }
            if (!this.k) {
                this.g(this.j, n2);
            }
        }
        finally {
            DataSourceUtil.a(super.i);
        }
    }
    
    @Override
    public final void c() {
        this.k = true;
    }
    
    protected abstract void g(final byte[] p0, final int p1) throws IOException;
    
    public byte[] h() {
        return this.j;
    }
}
