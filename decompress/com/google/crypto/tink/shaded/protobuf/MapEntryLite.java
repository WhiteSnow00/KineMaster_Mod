// 
// Decompiled by Procyon v0.6.0
// 

package com.google.crypto.tink.shaded.protobuf;

import java.io.IOException;

public class MapEntryLite<K, V>
{
    static <K, V> int b(final a<K, V> a, final K k, final V v) {
        throw null;
    }
    
    static <K, V> void d(final CodedOutputStream codedOutputStream, final a<K, V> a, final K k, final V v) throws IOException {
        throw null;
    }
    
    public int a(final int n, final K k, final V v) {
        return CodedOutputStream.W(n) + CodedOutputStream.D(b(null, k, v));
    }
    
    a<K, V> c() {
        return null;
    }
    
    static class a<K, V>
    {
    }
}
