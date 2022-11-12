// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.exoplayer2.upstream.cache;

import java.util.Comparator;
import g4.b;
import java.util.TreeSet;

public final class LeastRecentlyUsedCacheEvictor implements CacheEvictor
{
    private final long a;
    private final TreeSet<CacheSpan> b;
    private long c;
    
    public LeastRecentlyUsedCacheEvictor(final long a) {
        this.a = a;
        this.b = new TreeSet<CacheSpan>((Comparator<? super CacheSpan>)g4.b.a);
    }
    
    public static int g(final CacheSpan cacheSpan, final CacheSpan cacheSpan2) {
        return h(cacheSpan, cacheSpan2);
    }
    
    private static int h(final CacheSpan cacheSpan, final CacheSpan cacheSpan2) {
        final long f = cacheSpan.f;
        final long f2 = cacheSpan2.f;
        if (f - f2 == 0L) {
            return cacheSpan.a(cacheSpan2);
        }
        int n;
        if (f < f2) {
            n = -1;
        }
        else {
            n = 1;
        }
        return n;
    }
    
    private void i(final Cache cache, final long n) {
        while (this.c + n > this.a && !this.b.isEmpty()) {
            cache.i(this.b.first());
        }
    }
    
    @Override
    public void a(final Cache cache, final CacheSpan cacheSpan) {
        this.b.add(cacheSpan);
        this.c += cacheSpan.c;
        this.i(cache, 0L);
    }
    
    @Override
    public boolean b() {
        return true;
    }
    
    @Override
    public void c(final Cache cache, final String s, final long n, final long n2) {
        if (n2 != -1L) {
            this.i(cache, n2);
        }
    }
    
    @Override
    public void d(final Cache cache, final CacheSpan cacheSpan) {
        this.b.remove(cacheSpan);
        this.c -= cacheSpan.c;
    }
    
    @Override
    public void e(final Cache cache, final CacheSpan cacheSpan, final CacheSpan cacheSpan2) {
        this.d(cache, cacheSpan);
        this.a(cache, cacheSpan2);
    }
    
    @Override
    public void f() {
    }
}
