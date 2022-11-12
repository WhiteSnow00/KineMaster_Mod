// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.exoplayer2.source.chunk;

import android.net.Uri;
import java.util.List;
import java.util.Map;
import com.google.android.exoplayer2.source.LoadEventInfo;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.upstream.DataSource;
import com.google.android.exoplayer2.upstream.StatsDataSource;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.upstream.DataSpec;
import com.google.android.exoplayer2.upstream.Loader;

public abstract class Chunk implements Loadable
{
    public final long a;
    public final DataSpec b;
    public final int c;
    public final Format d;
    public final int e;
    public final Object f;
    public final long g;
    public final long h;
    protected final StatsDataSource i;
    
    public Chunk(final DataSource dataSource, final DataSpec dataSpec, final int c, final Format d, final int e, final Object f, final long g, final long h) {
        this.i = new StatsDataSource(dataSource);
        this.b = Assertions.e(dataSpec);
        this.c = c;
        this.d = d;
        this.e = e;
        this.f = f;
        this.g = g;
        this.h = h;
        this.a = LoadEventInfo.a();
    }
    
    public final long b() {
        return this.i.j();
    }
    
    public final long d() {
        return this.h - this.g;
    }
    
    public final Map<String, List<String>> e() {
        return this.i.t();
    }
    
    public final Uri f() {
        return this.i.s();
    }
}
