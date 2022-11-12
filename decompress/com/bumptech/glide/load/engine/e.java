// 
// Decompiled by Procyon v0.6.0
// 

package com.bumptech.glide.load.engine;

import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.data.d;
import c2.b;

interface e
{
    boolean b();
    
    void cancel();
    
    public interface a
    {
        void a(final b p0, final Exception p1, final d<?> p2, final DataSource p3);
        
        void c(final b p0, final Object p1, final d<?> p2, final DataSource p3, final b p4);
        
        void f();
    }
}
