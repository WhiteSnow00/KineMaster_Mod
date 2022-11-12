// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.exoplayer2.util;

public interface HandlerWrapper
{
    Message a(final int p0);
    
    boolean b(final Message p0);
    
    boolean c(final int p0);
    
    Message d(final int p0, final int p1, final int p2, final Object p3);
    
    Message e(final int p0, final Object p1);
    
    void f(final Object p0);
    
    Message g(final int p0, final int p1, final int p2);
    
    boolean h(final Runnable p0);
    
    boolean i(final int p0);
    
    boolean j(final int p0, final long p1);
    
    void k(final int p0);
    
    public interface Message
    {
        void a();
    }
}
