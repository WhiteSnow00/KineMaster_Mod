// 
// Decompiled by Procyon v0.6.0
// 

package com.google.firebase.components;

import com.google.firebase.inject.Deferred;
import com.google.firebase.inject.Provider;
import java.util.Iterator;
import java.util.Collections;
import com.google.firebase.events.Publisher;
import java.util.HashSet;
import java.util.Set;

final class s extends com.google.firebase.components.a
{
    private final Set<Class<?>> a;
    private final Set<Class<?>> b;
    private final Set<Class<?>> c;
    private final Set<Class<?>> d;
    private final Set<Class<?>> e;
    private final Set<Class<?>> f;
    private final ComponentContainer g;
    
    s(final Component<?> component, final ComponentContainer g) {
        final HashSet set = new HashSet();
        final HashSet set2 = new HashSet();
        final HashSet set3 = new HashSet();
        final HashSet set4 = new HashSet();
        final HashSet set5 = new HashSet();
        for (final Dependency dependency : component.e()) {
            if (dependency.e()) {
                if (dependency.g()) {
                    set4.add(dependency.c());
                }
                else {
                    set.add(dependency.c());
                }
            }
            else if (dependency.d()) {
                set3.add(dependency.c());
            }
            else if (dependency.g()) {
                set5.add(dependency.c());
            }
            else {
                set2.add(dependency.c());
            }
        }
        if (!component.h().isEmpty()) {
            set.add(Publisher.class);
        }
        this.a = (Set<Class<?>>)Collections.unmodifiableSet((Set<?>)set);
        this.b = (Set<Class<?>>)Collections.unmodifiableSet((Set<?>)set2);
        this.c = (Set<Class<?>>)Collections.unmodifiableSet((Set<?>)set3);
        this.d = (Set<Class<?>>)Collections.unmodifiableSet((Set<?>)set4);
        this.e = (Set<Class<?>>)Collections.unmodifiableSet((Set<?>)set5);
        this.f = component.h();
        this.g = g;
    }
    
    @Override
    public <T> T a(final Class<T> clazz) {
        if (!this.a.contains(clazz)) {
            throw new DependencyException(String.format("Attempting to request an undeclared dependency %s.", clazz));
        }
        final T a = this.g.a(clazz);
        if (!clazz.equals(Publisher.class)) {
            return a;
        }
        return (T)new a(this.f, (Publisher)a);
    }
    
    @Override
    public <T> Provider<Set<T>> b(final Class<T> clazz) {
        if (this.e.contains(clazz)) {
            return this.g.b(clazz);
        }
        throw new DependencyException(String.format("Attempting to request an undeclared dependency Provider<Set<%s>>.", clazz));
    }
    
    @Override
    public <T> Set<T> c(final Class<T> clazz) {
        if (this.d.contains(clazz)) {
            return this.g.c(clazz);
        }
        throw new DependencyException(String.format("Attempting to request an undeclared dependency Set<%s>.", clazz));
    }
    
    @Override
    public <T> Provider<T> d(final Class<T> clazz) {
        if (this.b.contains(clazz)) {
            return this.g.d(clazz);
        }
        throw new DependencyException(String.format("Attempting to request an undeclared dependency Provider<%s>.", clazz));
    }
    
    @Override
    public <T> Deferred<T> e(final Class<T> clazz) {
        if (this.c.contains(clazz)) {
            return this.g.e(clazz);
        }
        throw new DependencyException(String.format("Attempting to request an undeclared dependency Deferred<%s>.", clazz));
    }
    
    private static class a implements Publisher
    {
        private final Set<Class<?>> a;
        private final Publisher b;
        
        public a(final Set<Class<?>> a, final Publisher b) {
            this.a = a;
            this.b = b;
        }
    }
}
