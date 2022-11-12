// 
// Decompiled by Procyon v0.6.0
// 

package com.google.firebase.components;

import java.util.Set;
import com.google.firebase.inject.Provider;

abstract class a implements ComponentContainer
{
    @Override
    public <T> T a(final Class<T> clazz) {
        final com.google.firebase.inject.Provider<T> d = this.d(clazz);
        if (d == null) {
            return null;
        }
        return (T)d.get();
    }
    
    @Override
    public <T> Set<T> c(final Class<T> clazz) {
        return (Set)this.b(clazz).get();
    }
}
