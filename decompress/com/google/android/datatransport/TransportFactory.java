// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.datatransport;

public interface TransportFactory
{
    @Deprecated
     <T> Transport<T> a(final String p0, final Class<T> p1, final Transformer<T, byte[]> p2);
    
     <T> Transport<T> b(final String p0, final Class<T> p1, final Encoding p2, final Transformer<T, byte[]> p3);
}
