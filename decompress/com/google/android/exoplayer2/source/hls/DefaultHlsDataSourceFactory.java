// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.exoplayer2.source.hls;

import com.google.android.exoplayer2.upstream.DataSource;

public final class DefaultHlsDataSourceFactory implements HlsDataSourceFactory
{
    private final DataSource.Factory a;
    
    public DefaultHlsDataSourceFactory(final DataSource.Factory a) {
        this.a = a;
    }
    
    @Override
    public DataSource a(final int n) {
        return this.a.createDataSource();
    }
}
