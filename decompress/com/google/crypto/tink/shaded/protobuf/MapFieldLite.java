// 
// Decompiled by Procyon v0.6.0
// 

package com.google.crypto.tink.shaded.protobuf;

import java.util.Collections;
import java.util.Set;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Map;
import java.util.LinkedHashMap;

public final class MapFieldLite<K, V> extends LinkedHashMap<K, V>
{
    private static final MapFieldLite a;
    private boolean isMutable;
    
    static {
        (a = new MapFieldLite()).makeImmutable();
    }
    
    private MapFieldLite() {
        this.isMutable = true;
    }
    
    private MapFieldLite(final Map<K, V> map) {
        super(map);
        this.isMutable = true;
    }
    
    private static int b(final Object o) {
        if (o instanceof byte[]) {
            return Internal.d((byte[])o);
        }
        if (!(o instanceof Internal.EnumLite)) {
            return o.hashCode();
        }
        throw new UnsupportedOperationException();
    }
    
    private static void c(final Map<?, ?> map) {
        for (final Object next : map.keySet()) {
            Internal.a(next);
            Internal.a(map.get(next));
        }
    }
    
    static <K, V> int calculateHashCodeForMap(final Map<K, V> map) {
        final Iterator<Map.Entry<K, V>> iterator = map.entrySet().iterator();
        int n = 0;
        while (iterator.hasNext()) {
            final Map.Entry entry = iterator.next();
            n += (b(entry.getValue()) ^ b(entry.getKey()));
        }
        return n;
    }
    
    static <K, V> Map<K, V> copy(final Map<K, V> map) {
        final LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (final Map.Entry<Object, V> entry : map.entrySet()) {
            linkedHashMap.put(entry.getKey(), d(entry.getValue()));
        }
        return linkedHashMap;
    }
    
    private static Object d(final Object o) {
        Object copy = o;
        if (o instanceof byte[]) {
            final byte[] array = (byte[])o;
            copy = Arrays.copyOf(array, array.length);
        }
        return copy;
    }
    
    private void e() {
        if (this.isMutable()) {
            return;
        }
        throw new UnsupportedOperationException();
    }
    
    public static <K, V> MapFieldLite<K, V> emptyMapField() {
        return MapFieldLite.a;
    }
    
    static <K, V> boolean equals(final Map<K, V> map, final Map<K, V> map2) {
        if (map == map2) {
            return true;
        }
        if (map.size() != map2.size()) {
            return false;
        }
        for (final Map.Entry<Object, V> entry : map.entrySet()) {
            if (!map2.containsKey(entry.getKey())) {
                return false;
            }
            if (!f(entry.getValue(), map2.get(entry.getKey()))) {
                return false;
            }
        }
        return true;
    }
    
    private static boolean f(final Object o, final Object o2) {
        if (o instanceof byte[] && o2 instanceof byte[]) {
            return Arrays.equals((byte[])o, (byte[])o2);
        }
        return o.equals(o2);
    }
    
    @Override
    public void clear() {
        this.e();
        super.clear();
    }
    
    @Override
    public Set<Map.Entry<K, V>> entrySet() {
        Object o;
        if (this.isEmpty()) {
            o = Collections.emptySet();
        }
        else {
            o = super.entrySet();
        }
        return (Set<Map.Entry<K, V>>)o;
    }
    
    @Override
    public boolean equals(final Object o) {
        return o instanceof Map && equals((Map<Object, Object>)this, (Map<Object, Object>)o);
    }
    
    @Override
    public int hashCode() {
        return calculateHashCodeForMap((Map<Object, Object>)this);
    }
    
    public boolean isMutable() {
        return this.isMutable;
    }
    
    public void makeImmutable() {
        this.isMutable = false;
    }
    
    public void mergeFrom(final MapFieldLite<K, V> mapFieldLite) {
        this.e();
        if (!mapFieldLite.isEmpty()) {
            this.putAll((Map<? extends K, ? extends V>)mapFieldLite);
        }
    }
    
    public MapFieldLite<K, V> mutableCopy() {
        MapFieldLite mapFieldLite;
        if (this.isEmpty()) {
            mapFieldLite = new MapFieldLite();
        }
        else {
            mapFieldLite = new MapFieldLite(this);
        }
        return mapFieldLite;
    }
    
    @Override
    public V put(final K k, final V v) {
        this.e();
        Internal.a(k);
        Internal.a(v);
        return super.put(k, v);
    }
    
    public V put(final Map.Entry<K, V> entry) {
        return this.put(entry.getKey(), entry.getValue());
    }
    
    @Override
    public void putAll(final Map<? extends K, ? extends V> map) {
        this.e();
        c(map);
        super.putAll(map);
    }
    
    @Override
    public V remove(final Object o) {
        this.e();
        return super.remove(o);
    }
}
