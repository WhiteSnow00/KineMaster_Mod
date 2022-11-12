// 
// Decompiled by Procyon v0.6.0
// 

package com.bumptech.glide.load.data;

import java.io.IOException;

public interface e<T>
{
    T a() throws IOException;
    
    void b();
    
    public interface a<T>
    {
        Class<T> a();
        
        e<T> b(final T p0);
    }
}
