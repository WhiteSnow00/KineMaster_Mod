// 
// Decompiled by Procyon v0.6.0
// 

package com.google.crypto.tink.shaded.protobuf;

import java.util.Iterator;
import java.util.Map;

class u implements t
{
    private static <K, V> int i(final int n, final Object o, final Object o2) {
        final MapFieldLite mapFieldLite = (MapFieldLite)o;
        final MapEntryLite mapEntryLite = (MapEntryLite)o2;
        final boolean empty = mapFieldLite.isEmpty();
        int n2 = 0;
        if (empty) {
            return 0;
        }
        for (final Map.Entry<Object, V> entry : mapFieldLite.entrySet()) {
            n2 += mapEntryLite.a(n, entry.getKey(), entry.getValue());
        }
        return n2;
    }
    
    private static <K, V> MapFieldLite<K, V> j(final Object o, final Object o2) {
        final MapFieldLite mapFieldLite = (MapFieldLite)o;
        final MapFieldLite mapFieldLite2 = (MapFieldLite)o2;
        MapFieldLite mutableCopy = mapFieldLite;
        if (!mapFieldLite2.isEmpty()) {
            mutableCopy = mapFieldLite;
            if (!mapFieldLite.isMutable()) {
                mutableCopy = mapFieldLite.mutableCopy();
            }
            mutableCopy.mergeFrom(mapFieldLite2);
        }
        return mutableCopy;
    }
    
    @Override
    public Object a(final Object o, final Object o2) {
        return j(o, o2);
    }
    
    @Override
    public MapEntryLite.a<?, ?> b(final Object o) {
        ((MapEntryLite)o).c();
        return null;
    }
    
    @Override
    public Map<?, ?> c(final Object o) {
        return (MapFieldLite)o;
    }
    
    @Override
    public Object d(final Object o) {
        return MapFieldLite.emptyMapField().mutableCopy();
    }
    
    @Override
    public Map<?, ?> e(final Object o) {
        return (MapFieldLite)o;
    }
    
    @Override
    public Object f(final Object o) {
        ((MapFieldLite)o).makeImmutable();
        return o;
    }
    
    @Override
    public int g(final int n, final Object o, final Object o2) {
        return i(n, o, o2);
    }
    
    @Override
    public boolean h(final Object o) {
        return ((MapFieldLite)o).isMutable() ^ true;
    }
}
