// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.datatransport.runtime.dagger.internal;

import javax.inject.Provider;
import java.util.Map;

abstract class AbstractMapFactory<K, V, V2> implements Factory<Map<K, V2>>
{
    private final Map<K, Provider<V>> a;
    
    final Map<K, Provider<V>> a() {
        return this.a;
    }
    
    public abstract static class Builder<K, V, V2>
    {
    }
}
