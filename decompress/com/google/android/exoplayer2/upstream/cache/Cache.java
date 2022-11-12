// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.exoplayer2.upstream.cache;

import java.io.IOException;
import java.io.File;

public interface Cache
{
    File a(final String p0, final long p1, final long p2) throws CacheException;
    
    ContentMetadata b(final String p0);
    
    void c(final String p0, final ContentMetadataMutations p1) throws CacheException;
    
    long d(final String p0, final long p1, final long p2);
    
    CacheSpan e(final String p0, final long p1, final long p2) throws CacheException;
    
    long f(final String p0, final long p1, final long p2);
    
    long g();
    
    void h(final CacheSpan p0);
    
    void i(final CacheSpan p0);
    
    CacheSpan j(final String p0, final long p1, final long p2) throws InterruptedException, CacheException;
    
    void k(final File p0, final long p1) throws CacheException;
    
    public static class CacheException extends IOException
    {
        public CacheException(final String s) {
            super(s);
        }
        
        public CacheException(final String s, final Throwable t) {
            super(s, t);
        }
        
        public CacheException(final Throwable t) {
            super(t);
        }
    }
    
    public interface Listener
    {
        void a(final Cache p0, final CacheSpan p1);
        
        void d(final Cache p0, final CacheSpan p1);
        
        void e(final Cache p0, final CacheSpan p1, final CacheSpan p2);
    }
}
