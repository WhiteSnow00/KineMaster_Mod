// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.exoplayer2.upstream.cache;

public interface CacheEvictor extends Listener
{
    boolean b();
    
    void c(final Cache p0, final String p1, final long p2, final long p3);
    
    void f();
}
