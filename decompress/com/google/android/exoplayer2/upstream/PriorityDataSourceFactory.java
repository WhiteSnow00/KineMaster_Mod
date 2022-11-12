// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.exoplayer2.upstream;

import com.google.android.exoplayer2.util.PriorityTaskManager;

@Deprecated
public final class PriorityDataSourceFactory implements Factory
{
    private final Factory a;
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
