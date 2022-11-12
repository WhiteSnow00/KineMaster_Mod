// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.exoplayer2.upstream.cache;

public final class NoOpCacheEvictor implements CacheEvictor
{
    @Override
    public void a(final Cache cache, final CacheSpan cacheSpan) {
    }
    
    @Override
    public boolean b() {
        return false;
    }
    
    @Override
    public void c(final Cache cache, final String s, final long n, final long n2) {
    }
    
    @Override
    public void d(final Cache cache, final CacheSpan cacheSpan) {
    }
    
    @Override
    public void e(final Cache cache, final CacheSpan cacheSpan, final CacheSpan cacheSpan2) {
    }
    
    @Override
    public void f() {
    }
}
