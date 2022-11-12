// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.exoplayer2.upstream;

import java.io.IOException;
import java.util.Collections;
import com.google.android.exoplayer2.util.Assertions;
import java.util.List;
import java.util.Map;
import android.net.Uri;

public final class StatsDataSource implements DataSource
{
    private final DataSource a;
    private long b;
    private Uri c;
    private Map<String, List<String>> d;
    
    public StatsDataSource(final DataSource dataSource) {
        this.a = Assertions.e(dataSource);
        this.c = Uri.EMPTY;
        this.d = Collections.emptyMap();
    }
    
    @Override
    public long b(final DataSpec dataSpec) throws IOException {
        this.c = dataSpec.a;
        this.d = Collections.emptyMap();
        final long b = this.a.b(dataSpec);
        this.c = Assertions.e(this.q());
        this.d = this.g();
        return b;
    }
    
    @Override
    public void close() throws IOException {
        this.a.close();
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
    
    public long j() {
        return this.b;
    }
    
    @Override
    public Uri q() {
        return this.a.q();
    }
    
    @Override
    public int read(final byte[] array, int read, final int n) throws IOException {
        read = this.a.read(array, read, n);
        if (read != -1) {
            this.b += read;
        }
        return read;
    }
    
    public Uri s() {
        return this.c;
    }
    
    public Map<String, List<String>> t() {
        return this.d;
    }
    
    public void u() {
        this.b = 0L;
    }
}
