// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.exoplayer2.upstream.cache;

import java.util.Set;
import java.util.List;
import java.util.Arrays;
import com.google.common.base.Charsets;
import java.nio.ByteBuffer;
import java.util.Iterator;
import java.util.HashMap;
import java.util.Collections;
import java.util.Map;

public final class DefaultContentMetadata implements ContentMetadata
{
    public static final DefaultContentMetadata c;
    private int a;
    private final Map<String, byte[]> b;
    
    static {
        c = new DefaultContentMetadata(Collections.emptyMap());
    }
    
    public DefaultContentMetadata() {
        this(Collections.emptyMap());
    }
    
    public DefaultContentMetadata(final Map<String, byte[]> map) {
        this.b = Collections.unmodifiableMap((Map<? extends String, ? extends byte[]>)map);
    }
    
    private static void e(final HashMap<String, byte[]> hashMap, final Map<String, Object> map) {
        for (final Map.Entry<String, V> entry : map.entrySet()) {
            hashMap.put(entry.getKey(), i(entry.getValue()));
        }
    }
    
    private static Map<String, byte[]> f(final Map<String, byte[]> map, final ContentMetadataMutations contentMetadataMutations) {
        final HashMap hashMap = new HashMap((Map<? extends K, ? extends V>)map);
        k(hashMap, contentMetadataMutations.c());
        e(hashMap, contentMetadataMutations.b());
        return hashMap;
    }
    
    private static byte[] i(final Object o) {
        if (o instanceof Long) {
            return ByteBuffer.allocate(8).putLong((long)o).array();
        }
        if (o instanceof String) {
            return ((String)o).getBytes(Charsets.c);
        }
        if (o instanceof byte[]) {
            return (byte[])o;
        }
        throw new IllegalArgumentException();
    }
    
    private static boolean j(final Map<String, byte[]> map, final Map<String, byte[]> map2) {
        if (map.size() != map2.size()) {
            return false;
        }
        for (final Map.Entry<K, byte[]> entry : map.entrySet()) {
            if (!Arrays.equals(entry.getValue(), (byte[])map2.get(entry.getKey()))) {
                return false;
            }
        }
        return true;
    }
    
    private static void k(final HashMap<String, byte[]> hashMap, final List<String> list) {
        for (int i = 0; i < list.size(); ++i) {
            hashMap.remove(list.get(i));
        }
    }
    
    @Override
    public final long a(final String s, final long n) {
        final byte[] array = this.b.get(s);
        if (array != null) {
            return ByteBuffer.wrap(array).getLong();
        }
        return n;
    }
    
    @Override
    public final String c(final String s, String s2) {
        final byte[] array = this.b.get(s);
        if (array != null) {
            s2 = new String(array, Charsets.c);
        }
        return s2;
    }
    
    @Override
    public boolean equals(final Object o) {
        return this == o || (o != null && DefaultContentMetadata.class == o.getClass() && j(this.b, ((DefaultContentMetadata)o).b));
    }
    
    public DefaultContentMetadata g(final ContentMetadataMutations contentMetadataMutations) {
        final Map<String, byte[]> f = f(this.b, contentMetadataMutations);
        if (j(this.b, f)) {
            return this;
        }
        return new DefaultContentMetadata(f);
    }
    
    public Set<Map.Entry<String, byte[]>> h() {
        return this.b.entrySet();
    }
    
    @Override
    public int hashCode() {
        if (this.a == 0) {
            int a = 0;
            for (final Map.Entry entry : this.b.entrySet()) {
                a += (Arrays.hashCode((byte[])entry.getValue()) ^ ((String)entry.getKey()).hashCode());
            }
            this.a = a;
        }
        return this.a;
    }
}
