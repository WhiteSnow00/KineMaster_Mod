// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.exoplayer2.upstream;

import java.io.IOException;
import android.net.Uri;

public final class ByteArrayDataSource extends BaseDataSource
{
    private final byte[] e;
    private Uri f;
    private int g;
    private int h;
    private boolean i;
    
    @Override
    public long b(final DataSpec dataSpec) throws IOException {
        this.f = dataSpec.a;
        this.u(dataSpec);
        final long g = dataSpec.g;
        final byte[] e = this.e;
        if (g <= e.length) {
            this.g = (int)g;
            final int h = e.length - (int)g;
            this.h = h;
            final long h2 = dataSpec.h;
            if (h2 != -1L) {
                this.h = (int)Math.min(h, h2);
            }
            this.i = true;
            this.v(dataSpec);
            long h3 = dataSpec.h;
            if (h3 == -1L) {
                h3 = this.h;
            }
            return h3;
        }
        throw new DataSourceException(2008);
    }
    
    @Override
    public void close() {
        if (this.i) {
            this.i = false;
            this.t();
        }
        this.f = null;
    }
    
    @Override
    public Uri q() {
        return this.f;
    }
    
    @Override
    public int read(final byte[] array, final int n, int min) {
        if (min == 0) {
            return 0;
        }
        final int h = this.h;
        if (h == 0) {
            return -1;
        }
        min = Math.min(min, h);
        System.arraycopy(this.e, this.g, array, n, min);
        this.g += min;
        this.h -= min;
        this.s(min);
        return min;
    }
}
