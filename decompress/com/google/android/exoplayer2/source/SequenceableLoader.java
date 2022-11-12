// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.exoplayer2.source;

public interface SequenceableLoader
{
    long b();
    
    boolean d(final long p0);
    
    long f();
    
    void g(final long p0);
    
    boolean isLoading();
    
    public interface Callback<T extends SequenceableLoader>
    {
        void l(final T p0);
    }
}
