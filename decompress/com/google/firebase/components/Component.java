// 
// Decompiled by Procyon v0.6.0
// 

package com.google.firebase.components;

import java.util.Collection;
import java.util.HashSet;
import java.util.Arrays;
import java.util.Collections;
import java.util.Set;

public final class Component<T>
{
    private final Set<Class<? super T>> a;
    private final Set<Dependency> b;
    private final int c;
    private final int d;
    private final ComponentFactory<T> e;
    private final Set<Class<?>> f;
    
    private Component(final Set<Class<? super T>> set, final Set<Dependency> set2, final int c, final int d, final ComponentFactory<T> e, final Set<Class<?>> set3) {
        this.a = Collections.unmodifiableSet((Set<? extends Class<? super T>>)set);
        this.b = Collections.unmodifiableSet((Set<? extends Dependency>)set2);
        this.c = c;
        this.d = d;
        this.e = e;
        this.f = Collections.unmodifiableSet((Set<? extends Class<?>>)set3);
    }
    
    Component(final Set set, final Set set2, final int n, final int n2, final ComponentFactory componentFactory, final Set set3, final Component$a object) {
        this(set, set2, n, n2, componentFactory, set3);
    }
    
    public static Object a(final Object o, final ComponentContainer componentContainer) {
        return n(o, componentContainer);
    }
    
    public static Object b(final Object o, final ComponentContainer componentContainer) {
        return o(o, componentContainer);
    }
    
    public static <T> Builder<T> c(final Class<T> clazz) {
        return new Builder<T>(clazz, new Class[0], null);
    }
    
    @SafeVarargs
    public static <T> Builder<T> d(final Class<T> clazz, final Class<? super T>... array) {
        return new Builder<T>(clazz, array, null);
    }
    
    public static <T> Component<T> i(final T t, final Class<T> clazz) {
        return j(clazz).f(new b(t)).d();
    }
    
    public static <T> Builder<T> j(final Class<T> clazz) {
        return (Builder<T>)Builder.a(c((Class<Object>)clazz));
    }
    
    private static Object n(final Object o, final ComponentContainer componentContainer) {
        return o;
    }
    
    private static Object o(final Object o, final ComponentContainer componentContainer) {
        return o;
    }
    
    @SafeVarargs
    public static <T> Component<T> p(final T t, final Class<T> clazz, final Class<? super T>... array) {
        return d(clazz, array).f(new c(t)).d();
    }
    
    public Set<Dependency> e() {
        return this.b;
    }
    
    public ComponentFactory<T> f() {
        return this.e;
    }
    
    public Set<Class<? super T>> g() {
        return this.a;
    }
    
    public Set<Class<?>> h() {
        return this.f;
    }
    
    public boolean k() {
        final int c = this.c;
        boolean b = true;
        if (c != 1) {
            b = false;
        }
        return b;
    }
    
    public boolean l() {
        return this.c == 2;
    }
    
    public boolean m() {
        return this.d == 0;
    }
    
    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Component<");
        sb.append(Arrays.toString(this.a.toArray()));
        sb.append(">{");
        sb.append(this.c);
        sb.append(", type=");
        sb.append(this.d);
        sb.append(", deps=");
        sb.append(Arrays.toString(this.b.toArray()));
        sb.append("}");
        return sb.toString();
    }
    
    public static class Builder<T>
    {
        private final Set<Class<? super T>> a;
        private final Set<Dependency> b;
        private int c;
        private int d;
        private ComponentFactory<T> e;
        private Set<Class<?>> f;
        
        @SafeVarargs
        private Builder(final Class<T> clazz, final Class<? super T>... array) {
            final HashSet a = new HashSet();
            this.a = a;
            this.b = new HashSet<Dependency>();
            int i = 0;
            this.c = 0;
            this.d = 0;
            this.f = new HashSet<Class<?>>();
            Preconditions.c(clazz, "Null interface");
            a.add(clazz);
            while (i < array.length) {
                Preconditions.c(array[i], "Null interface");
                ++i;
            }
            Collections.addAll(this.a, array);
        }
        
        Builder(final Class clazz, final Class[] array, final Component$a object) {
            this(clazz, (Class[])array);
        }
        
        static Builder a(final Builder builder) {
            return builder.g();
        }
        
        private Builder<T> g() {
            this.d = 1;
            return this;
        }
        
        private Builder<T> h(final int c) {
            Preconditions.d(this.c == 0, "Instantiation type has already been set.");
            this.c = c;
            return this;
        }
        
        private void i(final Class<?> clazz) {
            Preconditions.a(this.a.contains(clazz) ^ true, "Components are not allowed to depend on interfaces they themselves provide.");
        }
        
        public Builder<T> b(final Dependency dependency) {
            Preconditions.c(dependency, "Null dependency");
            this.i(dependency.c());
            this.b.add(dependency);
            return this;
        }
        
        public Builder<T> c() {
            return this.h(1);
        }
        
        public Component<T> d() {
            Preconditions.d(this.e != null, "Missing required property: factory.");
            return new Component<T>(new HashSet(this.a), new HashSet(this.b), this.c, this.d, this.e, this.f, null);
        }
        
        public Builder<T> e() {
            return this.h(2);
        }
        
        public Builder<T> f(final ComponentFactory<T> componentFactory) {
            this.e = Preconditions.c(componentFactory, "Null factory");
            return this;
        }
    }
}
