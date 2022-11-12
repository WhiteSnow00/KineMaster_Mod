// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.exoplayer2.upstream;

import android.net.Uri;
import java.util.List;
import java.util.Map;
import java.io.IOException;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.PriorityTaskManager;

public final class PriorityDataSource implements DataSource
{
    private final DataSource a;
    private final PriorityTaskManager b;
    private final int c;
    
    public PriorityDataSource(final DataSource dataSource, final PriorityTaskManager priorityTaskManager, final int c) {
        this.a = Assertions.e(dataSource);
        this.b = Assertions.e(priorityTaskManager);
        this.c = c;
    }
    
    @Override
    public long b(final DataSpec dataSpec) throws IOException {
        this.b.c(this.c);
        return this.a.b(dataSpec);
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
    
    @Override
    public Uri q() {
        return this.a.q();
    }
    
    @Override
    public int read(final byte[] array, final int n, final int n2) throws IOException {
        this.b.c(this.c);
        return this.a.read(array, n, n2);
    }
    
    public static final class Factory implements DataSource.Factory
    {
        private final DataSource.Factory a;
        private final PriorityTaskManager b;
        private final int c;
        
        public PriorityDataSource a() {
            return new PriorityDataSource(this.a.createDataSource(), this.b, this.c);
        }
        
        @Override
        public /* bridge */ DataSource createDataSource() {
            return this.a();
        }
    }
}
