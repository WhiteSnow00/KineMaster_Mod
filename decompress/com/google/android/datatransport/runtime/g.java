// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.datatransport.runtime;

import com.google.android.datatransport.Transport;
import com.google.android.datatransport.Transformer;
import com.google.android.datatransport.Encoding;
import java.util.Set;
import com.google.android.datatransport.TransportFactory;

final class g implements TransportFactory
{
    private final Set<Encoding> a;
    private final TransportContext b;
    private final j c;
    
    g(final Set<Encoding> a, final TransportContext b, final j c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }
    
    @Override
    public <T> Transport<T> a(final String s, final Class<T> clazz, final Transformer<T, byte[]> transformer) {
        return this.b(s, clazz, Encoding.b("proto"), transformer);
    }
    
    @Override
    public <T> Transport<T> b(final String s, final Class<T> clazz, final Encoding encoding, final Transformer<T, byte[]> transformer) {
        if (this.a.contains(encoding)) {
            return new i<T>(this.b, s, encoding, transformer, this.c);
        }
        throw new IllegalArgumentException(String.format("%s is not supported byt this factory. Supported encodings are: %s.", encoding, this.a));
    }
}
