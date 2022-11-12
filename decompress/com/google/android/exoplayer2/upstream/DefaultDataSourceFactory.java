// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.exoplayer2.upstream;

import android.content.Context;

@Deprecated
public final class DefaultDataSourceFactory implements Factory
{
    private final Context a;
    private final TransferListener b;
    private final Factory c;
    
    public DefaultDataSource a() {
        final DefaultDataSource defaultDataSource = new DefaultDataSource(this.a, this.c.createDataSource());
        final TransferListener b = this.b;
        if (b != null) {
            defaultDataSource.e(b);
        }
        return defaultDataSource;
    }
    
    @Override
    public /* bridge */ DataSource createDataSource() {
        return this.a();
    }
}
