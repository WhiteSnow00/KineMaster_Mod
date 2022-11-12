// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.exoplayer2.upstream;

import java.util.List;
import java.util.Map;
import java.io.IOException;
import java.io.Closeable;
import com.google.android.exoplayer2.util.Util;
import java.io.InputStream;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.source.LoadEventInfo;
import android.net.Uri;

public final class ParsingLoadable<T> implements Loadable
{
    public final long a;
    public final DataSpec b;
    public final int c;
    private final StatsDataSource d;
    private final Parser<? extends T> e;
    private volatile T f;
    
    public ParsingLoadable(final DataSource dataSource, final Uri uri, final int n, final Parser<? extends T> parser) {
        this(dataSource, new DataSpec.Builder().i(uri).b(1).a(), n, parser);
    }
    
    public ParsingLoadable(final DataSource dataSource, final DataSpec b, final int c, final Parser<? extends T> e) {
        this.d = new StatsDataSource(dataSource);
        this.b = b;
        this.c = c;
        this.e = e;
        this.a = LoadEventInfo.a();
    }
    
    @Override
    public final void a() throws IOException {
        this.d.u();
        final DataSourceInputStream dataSourceInputStream = new DataSourceInputStream(this.d, this.b);
        try {
            dataSourceInputStream.c();
            this.f = (T)this.e.a(Assertions.e(this.d.q()), dataSourceInputStream);
        }
        finally {
            Util.n(dataSourceInputStream);
        }
    }
    
    public long b() {
        return this.d.j();
    }
    
    @Override
    public final void c() {
    }
    
    public Map<String, List<String>> d() {
        return this.d.t();
    }
    
    public final T e() {
        return this.f;
    }
    
    public Uri f() {
        return this.d.s();
    }
    
    public interface Parser<T>
    {
        T a(final Uri p0, final InputStream p1) throws IOException;
    }
}
