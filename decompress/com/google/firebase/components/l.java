// 
// Decompiled by Procyon v0.6.0
// 

package com.google.firebase.components;

import java.util.Iterator;
import java.util.Collections;
import java.util.Set;
import java.util.ArrayDeque;
import java.util.HashMap;
import com.google.firebase.events.Event;
import java.util.Queue;
import java.util.concurrent.Executor;
import com.google.firebase.events.EventHandler;
import java.util.concurrent.ConcurrentHashMap;
import java.util.Map;
import com.google.firebase.events.Publisher;
import com.google.firebase.events.Subscriber;

class l implements Subscriber, Publisher
{
    private final Map<Class<?>, ConcurrentHashMap<EventHandler<Object>, Executor>> a;
    private Queue<Event<?>> b;
    private final Executor c;
    
    l(final Executor c) {
        this.a = new HashMap<Class<?>, ConcurrentHashMap<EventHandler<Object>, Executor>>();
        this.b = new ArrayDeque<Event<?>>();
        this.c = c;
    }
    
    public static void d(final Map.Entry entry, final Event event) {
        g(entry, event);
    }
    
    private Set<Map.Entry<EventHandler<Object>, Executor>> f(final Event<?> event) {
        synchronized (this) {
            final Map map = this.a.get(event.b());
            Set<Object> set;
            if (map == null) {
                set = Collections.emptySet();
            }
            else {
                set = map.entrySet();
            }
            return (Set<Map.Entry<EventHandler<Object>, Executor>>)set;
        }
    }
    
    private static void g(final Map.Entry entry, final Event event) {
        entry.getKey().a(event);
    }
    
    public <T> void a(final Class<T> clazz, final EventHandler<? super T> eventHandler) {
        this.b(clazz, this.c, eventHandler);
    }
    
    public <T> void b(final Class<T> clazz, final Executor executor, final EventHandler<? super T> eventHandler) {
        synchronized (this) {
            Preconditions.b(clazz);
            Preconditions.b(eventHandler);
            Preconditions.b(executor);
            if (!this.a.containsKey(clazz)) {
                this.a.put(clazz, new ConcurrentHashMap<EventHandler<Object>, Executor>());
            }
            this.a.get(clazz).put((Object)eventHandler, (Object)executor);
        }
    }
    
    public <T> void c(final Class<T> clazz, final EventHandler<? super T> eventHandler) {
        synchronized (this) {
            Preconditions.b(clazz);
            Preconditions.b(eventHandler);
            if (!this.a.containsKey(clazz)) {
                return;
            }
            final ConcurrentHashMap concurrentHashMap = this.a.get(clazz);
            concurrentHashMap.remove(eventHandler);
            if (concurrentHashMap.isEmpty()) {
                this.a.remove(clazz);
            }
        }
    }
    
    void e() {
        synchronized (this) {
            Queue<Event<?>> b = this.b;
            if (b != null) {
                this.b = null;
            }
            else {
                b = null;
            }
            monitorexit(this);
            if (b != null) {
                final Iterator<Object> iterator = (Iterator<Object>)b.iterator();
                while (iterator.hasNext()) {
                    this.h((Event<?>)iterator.next());
                }
            }
        }
    }
    
    public void h(final Event<?> event) {
        Preconditions.b(event);
        synchronized (this) {
            final Queue<Event<?>> b = this.b;
            if (b != null) {
                b.add(event);
                return;
            }
            monitorexit(this);
            for (final Map.Entry<K, Executor> entry : this.f(event)) {
                entry.getValue().execute(new k((Map.Entry)entry, event));
            }
        }
    }
}
