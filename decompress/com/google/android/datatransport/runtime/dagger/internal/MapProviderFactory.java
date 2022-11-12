// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.datatransport.runtime.dagger.internal;

import java.util.Map;
import com.google.android.datatransport.runtime.dagger.Lazy;
import javax.inject.Provider;

public final class MapProviderFactory<K, V> extends AbstractMapFactory<K, V, Provider<V>> implements Lazy<Map<K, Provider<V>>>
{
    public Map<K, Provider<V>> b() {
        return this.a();
    }
    
    @Override
    public /* bridge */ Object get() {
        return this.b();
    }
    
    public static final class Builder<K, V> extends AbstractMapFactory.Builder<K, V, Provider<V>>
    {
    }
}
