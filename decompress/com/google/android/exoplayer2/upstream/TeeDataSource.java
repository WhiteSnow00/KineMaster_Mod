// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.exoplayer2.upstream;

import android.net.Uri;
import java.util.List;
import java.util.Map;
import java.io.IOException;
import com.google.android.exoplayer2.util.Assertions;

public final class TeeDataSource implements DataSource
{
    private final DataSource a;
    private final DataSink b;
    private boolean c;
    private long d;
    
    public TeeDataSource(final DataSource dataSource, final DataSink dataSink) {
        this.a = Assertions.e(dataSource);
        this.b = Assertions.e(dataSink);
    }
    
    @Override
    public long b(final DataSpec dataSpec) throws IOException {
        final long b = this.a.b(dataSpec);
        this.d = b;
        if (b == 0L) {
            return 0L;
        }
        DataSpec f = dataSpec;
        if (dataSpec.h == -1L) {
            f = dataSpec;
            if (b != -1L) {
                f = dataSpec.f(0L, b);
            }
        }
        this.c = true;
        this.b.b(f);
        return this.d;
    }
    
    @Override
    public void close() throws IOException {
        try {
            this.a.close();
        }
        finally {
            if (this.c) {
                this.c = false;
                this.b.close();
            }
        }
    }
    
    @Override
    public void e(final TransferListener transferListener) {
        Assertions.e(transferListener);
        this.a.e(transferListener);
    }
    
    @Override
    public Map<String, List<String>> g() {
        return this.a.g();
    }
    
    @Override
    public Uri q() {
        return this.a.q();
    }
    
    @Override
    public int read(final byte[] array, final int n, int read) throws IOException {
        if (this.d == 0L) {
            return -1;
        }
        read = this.a.read(array, n, read);
        if (read > 0) {
            this.b.write(array, n, read);
            final long d = this.d;
            if (d != -1L) {
                this.d = d - read;
            }
        }
        return read;
    }
}
