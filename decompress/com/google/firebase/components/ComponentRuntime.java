// 
// Decompiled by Procyon v0.6.0
// 

package com.google.firebase.components;

import com.google.firebase.inject.Deferred;
import java.util.HashSet;
import java.util.Collections;
import android.util.Log;
import java.util.Iterator;
import com.google.firebase.events.Publisher;
import com.google.firebase.events.Subscriber;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Collection;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicReference;
import java.util.List;
import java.util.Map;
import java.util.Set;
import com.google.firebase.inject.Provider;
import com.google.firebase.dynamicloading.ComponentLoader;

public class ComponentRuntime extends a implements ComponentLoader
{
    private static final Provider<Set<Object>> g;
    private final Map<Component<?>, Provider<?>> a;
    private final Map<Class<?>, Provider<?>> b;
    private final Map<Class<?>, m<?>> c;
    private final List<Provider<ComponentRegistrar>> d;
    private final l e;
    private final AtomicReference<Boolean> f;
    
    static {
        g = (Provider)f.a;
    }
    
    private ComponentRuntime(final Executor executor, final Iterable<Provider<ComponentRegistrar>> iterable, final Collection<Component<?>> collection) {
        this.a = new HashMap<Component<?>, Provider<?>>();
        this.b = new HashMap<Class<?>, Provider<?>>();
        this.c = new HashMap<Class<?>, m<?>>();
        this.f = new AtomicReference<Boolean>();
        final l e = new l(executor);
        this.e = e;
        final ArrayList list = new ArrayList();
        list.add(Component.p(e, l.class, Subscriber.class, Publisher.class));
        list.add(Component.p(this, (Class<Object>)ComponentLoader.class, (Class<? super Object>[])new Class[0]));
        for (final Component component : collection) {
            if (component != null) {
                list.add(component);
            }
        }
        this.d = m(iterable);
        this.j(list);
    }
    
    ComponentRuntime(final Executor executor, final Iterable iterable, final Collection collection, final ComponentRuntime$a object) {
        this(executor, iterable, collection);
    }
    
    public static Object f(final ComponentRuntime componentRuntime, final Component component) {
        return componentRuntime.n(component);
    }
    
    public static void g(final m m, final Provider provider) {
        p(m, provider);
    }
    
    public static void h(final q q, final Provider provider) {
        o(q, provider);
    }
    
    public static Builder i(final Executor executor) {
        return new Builder(executor);
    }
    
    private void j(final List<Component<?>> list) {
        final ArrayList list2 = new ArrayList();
        synchronized (this) {
            final Iterator<Provider<ComponentRegistrar>> iterator = this.d.iterator();
            while (iterator.hasNext()) {
                final Provider provider = iterator.next();
                try {
                    final ComponentRegistrar componentRegistrar = (ComponentRegistrar)provider.get();
                    if (componentRegistrar == null) {
                        continue;
                    }
                    list.addAll(componentRegistrar.getComponents());
                    iterator.remove();
                }
                catch (final InvalidRegistrarException ex) {
                    iterator.remove();
                    Log.w("ComponentDiscovery", "Invalid component registrar.", (Throwable)ex);
                }
            }
            if (this.a.isEmpty()) {
                j.a(list);
            }
            else {
                final ArrayList list3 = new ArrayList(this.a.keySet());
                list3.addAll(list);
                j.a(list3);
            }
            for (final Component component : list) {
                this.a.put(component, (Provider<?>)new Lazy((com.google.firebase.inject.Provider<Object>)new e(this, component)));
            }
            list2.addAll(this.s(list));
            list2.addAll(this.t());
            this.r();
            monitorexit(this);
            final Iterator iterator3 = list2.iterator();
            while (iterator3.hasNext()) {
                ((Runnable)iterator3.next()).run();
            }
            this.q();
        }
    }
    
    private void k(final Map<Component<?>, Provider<?>> map, final boolean b) {
        for (final Map.Entry<Component, V> entry : map.entrySet()) {
            final Component component = entry.getKey();
            final Provider provider = (Provider)entry.getValue();
            if (component.k() || (component.l() && b)) {
                provider.get();
            }
        }
        this.e.e();
    }
    
    private static <T> List<T> m(final Iterable<T> iterable) {
        final ArrayList list = new ArrayList();
        final Iterator<T> iterator = iterable.iterator();
        while (iterator.hasNext()) {
            list.add(iterator.next());
        }
        return list;
    }
    
    private Object n(final Component component) {
        return component.f().a(new s(component, this));
    }
    
    private static void o(final q q, final Provider provider) {
        q.j(provider);
    }
    
    private static void p(final m m, final Provider provider) {
        m.a(provider);
    }
    
    private void q() {
        final Boolean b = this.f.get();
        if (b != null) {
            this.k(this.a, b);
        }
    }
    
    private void r() {
        for (final Component component : this.a.keySet()) {
            for (final Dependency dependency : component.e()) {
                if (dependency.g() && !this.c.containsKey(dependency.c())) {
                    this.c.put(dependency.c(), m.b((Collection<Provider<?>>)Collections.emptySet()));
                }
                else {
                    if (this.b.containsKey(dependency.c())) {
                        continue;
                    }
                    if (dependency.f()) {
                        throw new MissingDependencyException(String.format("Unsatisfied dependency for component %s: %s", component, dependency.c()));
                    }
                    if (dependency.g()) {
                        continue;
                    }
                    this.b.put(dependency.c(), (Provider<?>)q.e());
                }
            }
        }
    }
    
    private List<Runnable> s(final List<Component<?>> list) {
        final ArrayList list2 = new ArrayList();
        for (final Component component : list) {
            if (!component.m()) {
                continue;
            }
            final Provider provider = this.a.get(component);
            for (final Class clazz : component.g()) {
                if (!this.b.containsKey(clazz)) {
                    this.b.put(clazz, (Provider<?>)provider);
                }
                else {
                    list2.add(new h((q)this.b.get(clazz), provider));
                }
            }
        }
        return list2;
    }
    
    private List<Runnable> t() {
        final ArrayList list = new ArrayList();
        final HashMap hashMap = new HashMap();
        for (final Map.Entry<Component, V> entry : this.a.entrySet()) {
            final Component component = entry.getKey();
            if (component.m()) {
                continue;
            }
            final Provider provider = (Provider)entry.getValue();
            for (final Class clazz : component.g()) {
                if (!hashMap.containsKey(clazz)) {
                    hashMap.put(clazz, new HashSet());
                }
                ((Set)hashMap.get(clazz)).add(provider);
            }
        }
        for (final Map.Entry<Object, V> entry2 : hashMap.entrySet()) {
            if (!this.c.containsKey(entry2.getKey())) {
                this.c.put(entry2.getKey(), m.b((Collection<Provider<?>>)entry2.getValue()));
            }
            else {
                final m m = this.c.get(entry2.getKey());
                final Iterator iterator4 = ((Set)entry2.getValue()).iterator();
                while (iterator4.hasNext()) {
                    list.add(new g(m, (Provider)iterator4.next()));
                }
            }
        }
        return list;
    }
    
    @Override
    public /* bridge */ Object a(final Class clazz) {
        return super.a((Class<Object>)clazz);
    }
    
    public <T> Provider<Set<T>> b(final Class<T> clazz) {
        synchronized (this) {
            final m m = this.c.get(clazz);
            if (m != null) {
                return (Provider<Set<T>>)m;
            }
            return (Provider<Set<T>>)ComponentRuntime.g;
        }
    }
    
    @Override
    public /* bridge */ Set c(final Class clazz) {
        return super.c((Class<Object>)clazz);
    }
    
    public <T> Provider<T> d(final Class<T> clazz) {
        synchronized (this) {
            Preconditions.c(clazz, "Null interface requested.");
            return (Provider<T>)this.b.get(clazz);
        }
    }
    
    public <T> Deferred<T> e(final Class<T> clazz) {
        final com.google.firebase.inject.Provider<T> d = this.d(clazz);
        if (d == null) {
            return (Deferred<T>)q.e();
        }
        if (d instanceof q) {
            return (Deferred<T>)(q)d;
        }
        return (Deferred<T>)q.i((com.google.firebase.inject.Provider<Object>)d);
    }
    
    public void l(final boolean b) {
        if (!this.f.compareAndSet(null, b)) {
            return;
        }
        synchronized (this) {
            final HashMap<Component<?>, Provider<?>> hashMap = new HashMap<Component<?>, Provider<?>>(this.a);
            monitorexit(this);
            this.k(hashMap, b);
        }
    }
    
    public static final class Builder
    {
        private final Executor a;
        private final List<Provider<ComponentRegistrar>> b;
        private final List<Component<?>> c;
        
        Builder(final Executor a) {
            this.b = new ArrayList<Provider<ComponentRegistrar>>();
            this.c = new ArrayList<Component<?>>();
            this.a = a;
        }
        
        public static ComponentRegistrar a(final ComponentRegistrar componentRegistrar) {
            return f(componentRegistrar);
        }
        
        private static ComponentRegistrar f(final ComponentRegistrar componentRegistrar) {
            return componentRegistrar;
        }
        
        public Builder b(final Component<?> component) {
            this.c.add(component);
            return this;
        }
        
        public Builder c(final ComponentRegistrar componentRegistrar) {
            this.b.add((Provider<ComponentRegistrar>)new i(componentRegistrar));
            return this;
        }
        
        public Builder d(final Collection<Provider<ComponentRegistrar>> collection) {
            this.b.addAll(collection);
            return this;
        }
        
        public ComponentRuntime e() {
            return new ComponentRuntime(this.a, this.b, this.c, null);
        }
    }
}
