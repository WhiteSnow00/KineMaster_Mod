// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.exoplayer2.source;

import com.google.android.exoplayer2.upstream.DataSource;
import com.google.common.base.Supplier;

public final class g implements Supplier
{
    public final Class a;
    public final DataSource.Factory b;
    
    public g(final Class a, final DataSource.Factory b) {
        this.a = a;
        this.b = b;
    }
    
    public final Object get() {
        return DefaultMediaSourceFactory.a.c(this.a, this.b);
    }
}
