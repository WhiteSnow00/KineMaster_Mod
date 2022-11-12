// 
// Decompiled by Procyon v0.6.0
// 

package com.google.firebase.components;

import java.util.Iterator;
import java.util.Map;
import java.util.Collections;
import java.util.concurrent.ConcurrentHashMap;
import java.util.Collection;
import java.util.Set;
import com.google.firebase.inject.Provider;

class m<T> implements Provider<Set<T>>
{
    private volatile Set<Provider<T>> a;
    private volatile Set<T> b;
    
    m(final Collection<Provider<T>> collection) {
        this.b = null;
        (this.a = Collections.newSetFromMap(new ConcurrentHashMap<Provider<T>, Boolean>())).addAll(collection);
    }
    
    static m<?> b(final Collection<Provider<?>> collection) {
        return new m<Object>(collection);
    }
    
    private void d() {
        synchronized (this) {
            final Iterator<Provider<T>> iterator = this.a.iterator();
            while (iterator.hasNext()) {
                this.b.add((T)iterator.next().get());
            }
            this.a = null;
        }
    }
    
    void a(final Provider<T> provider) {
        synchronized (this) {
            if (this.b == null) {
                this.a.add(provider);
            }
            else {
                this.b.add((T)provider.get());
            }
        }
    }
    
    public Set<T> c() {
        if (this.b == null) {
            synchronized (this) {
                if (this.b == null) {
                    this.b = Collections.newSetFromMap(new ConcurrentHashMap<T, Boolean>());
                    this.d();
                }
            }
        }
        return Collections.unmodifiableSet((Set<? extends T>)this.b);
    }
    
    public /* bridge */ Object get() {
        return this.c();
    }
}
