// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.datatransport.runtime.dagger.internal;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Collections;
import java.util.Map;
import javax.inject.Provider;

public final class MapFactory<K, V> extends AbstractMapFactory<K, V, V>
{
    private static final Provider<Map<Object, Object>> b;
    
    static {
        b = (Provider)InstanceFactory.a(Collections.emptyMap());
    }
    
    public Map<K, V> b() {
        final LinkedHashMap<Object, Object> c = DaggerCollections.c(this.a().size());
        for (final Map.Entry<Object, V> entry : this.a().entrySet()) {
            c.put(entry.getKey(), ((Provider)entry.getValue()).get());
        }
        return Collections.unmodifiableMap((Map<? extends K, ? extends V>)c);
    }
    
    public /* bridge */ Object get() {
        return this.b();
    }
    
    public static final class Builder<K, V> extends AbstractMapFactory.Builder<K, V, V>
    {
    }
}
