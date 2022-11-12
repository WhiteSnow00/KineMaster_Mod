// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.exoplayer2.upstream;

import android.net.Uri;
import java.util.List;
import java.util.Map;
import com.google.android.exoplayer2.util.Assertions;
import java.io.IOException;

public final class ResolvingDataSource implements DataSource
{
    private final DataSource a;
    private final Resolver b;
    private boolean c;
    
    public ResolvingDataSource(final DataSource a, final Resolver b) {
        this.a = a;
        this.b = b;
    }
    
    @Override
    public long b(DataSpec a) throws IOException {
        a = this.b.a(a);
        this.c = true;
        return this.a.b(a);
    }
    
    @Override
    public void close() throws IOException {
        if (this.c) {
            this.c = false;
            this.a.close();
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
        final Uri q = this.a.q();
        Uri b;
        if (q == null) {
            b = null;
        }
        else {
            b = this.b.b(q);
        }
        return b;
    }
    
    @Override
    public int read(final byte[] array, final int n, final int n2) throws IOException {
        return this.a.read(array, n, n2);
    }
    
    public static final class Factory implements DataSource.Factory
    {
        private final DataSource.Factory a;
        private final Resolver b;
        
        public ResolvingDataSource a() {
            return new ResolvingDataSource(this.a.createDataSource(), this.b);
        }
        
        @Override
        public /* bridge */ DataSource createDataSource() {
            return this.a();
        }
    }
    
    public interface Resolver
    {
        DataSpec a(final DataSpec p0) throws IOException;
        
        default Uri b(final Uri uri) {
            return uri;
        }
    }
}
