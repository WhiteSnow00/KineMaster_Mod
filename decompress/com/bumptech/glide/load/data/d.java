// 
// Decompiled by Procyon v0.6.0
// 

package com.bumptech.glide.load.data;

import com.bumptech.glide.Priority;
import com.bumptech.glide.load.DataSource;

public interface d<T>
{
    Class<T> a();
    
    void b();
    
    void cancel();
    
    DataSource d();
    
    void e(final Priority p0, final a<? super T> p1);
    
    public interface a<T>
    {
        void c(final Exception p0);
        
        void f(final T p0);
    }
}
