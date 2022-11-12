// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.exoplayer2.util;

import java.util.Collection;
import java.util.Iterator;
import android.os.Message;
import android.os.Handler$Callback;
import android.os.Looper;
import java.util.ArrayDeque;
import java.util.concurrent.CopyOnWriteArraySet;

public final class ListenerSet<T>
{
    private final Clock a;
    private final HandlerWrapper b;
    private final IterationFinishedEvent<T> c;
    private final CopyOnWriteArraySet<a<T>> d;
    private final ArrayDeque<Runnable> e;
    private final ArrayDeque<Runnable> f;
    private boolean g;
    
    public ListenerSet(final Looper looper, final Clock clock, final IterationFinishedEvent<T> iterationFinishedEvent) {
        this((CopyOnWriteArraySet)new CopyOnWriteArraySet(), looper, clock, iterationFinishedEvent);
    }
    
    private ListenerSet(final CopyOnWriteArraySet<a<T>> d, final Looper looper, final Clock a, final IterationFinishedEvent<T> c) {
        this.a = a;
        this.d = d;
        this.c = c;
        this.e = new ArrayDeque<Runnable>();
        this.f = new ArrayDeque<Runnable>();
        this.b = a.e(looper, (Handler$Callback)new com.google.android.exoplayer2.util.a(this));
    }
    
    public static void a(final CopyOnWriteArraySet set, final int n, final Event event) {
        h(set, n, event);
    }
    
    public static boolean b(final ListenerSet set, final Message message) {
        return set.g(message);
    }
    
    private boolean g(final Message message) {
        final Iterator<a<T>> iterator = this.d.iterator();
        while (iterator.hasNext()) {
            iterator.next().b(this.c);
            if (this.b.c(0)) {
                break;
            }
        }
        return true;
    }
    
    private static void h(final CopyOnWriteArraySet set, final int n, final Event event) {
        final Iterator iterator = set.iterator();
        while (iterator.hasNext()) {
            ((a)iterator.next()).a(n, event);
        }
    }
    
    public void c(final T t) {
        if (this.g) {
            return;
        }
        Assertions.e(t);
        this.d.add(new a<T>(t));
    }
    
    public ListenerSet<T> d(final Looper looper, final Clock clock, final IterationFinishedEvent<T> iterationFinishedEvent) {
        return new ListenerSet<T>(this.d, looper, clock, iterationFinishedEvent);
    }
    
    public ListenerSet<T> e(final Looper looper, final IterationFinishedEvent<T> iterationFinishedEvent) {
        return this.d(looper, this.a, iterationFinishedEvent);
    }
    
    public void f() {
        if (this.f.isEmpty()) {
            return;
        }
        if (!this.b.c(0)) {
            final HandlerWrapper b = this.b;
            b.b(b.a(0));
        }
        final boolean empty = this.e.isEmpty();
        this.e.addAll((Collection<?>)this.f);
        this.f.clear();
        if (empty ^ true) {
            return;
        }
        while (!this.e.isEmpty()) {
            this.e.peekFirst().run();
            this.e.removeFirst();
        }
    }
    
    public void i(final int n, final Event<T> event) {
        this.f.add(new b(new CopyOnWriteArraySet((Collection<? extends E>)this.d), n, (Event)event));
    }
    
    public void j() {
        final Iterator<a<T>> iterator = this.d.iterator();
        while (iterator.hasNext()) {
            iterator.next().c(this.c);
        }
        this.d.clear();
        this.g = true;
    }
    
    public void k(final T t) {
        for (final a a : this.d) {
            if (a.a.equals(t)) {
                a.c((IterationFinishedEvent)this.c);
                this.d.remove(a);
            }
        }
    }
    
    public void l(final int n, final Event<T> event) {
        this.i(n, event);
        this.f();
    }
    
    public interface Event<T>
    {
        void invoke(final T p0);
    }
    
    public interface IterationFinishedEvent<T>
    {
        void a(final T p0, final FlagSet p1);
    }
    
    private static final class a<T>
    {
        public final T a;
        private FlagSet.Builder b;
        private boolean c;
        private boolean d;
        
        public a(final T a) {
            this.a = a;
            this.b = new FlagSet.Builder();
        }
        
        public void a(final int n, final Event<T> event) {
            if (!this.d) {
                if (n != -1) {
                    this.b.a(n);
                }
                this.c = true;
                event.invoke(this.a);
            }
        }
        
        public void b(final IterationFinishedEvent<T> iterationFinishedEvent) {
            if (!this.d && this.c) {
                final FlagSet e = this.b.e();
                this.b = new FlagSet.Builder();
                this.c = false;
                iterationFinishedEvent.a(this.a, e);
            }
        }
        
        public void c(final IterationFinishedEvent<T> iterationFinishedEvent) {
            this.d = true;
            if (this.c) {
                iterationFinishedEvent.a(this.a, this.b.e());
            }
        }
        
        @Override
        public boolean equals(final Object o) {
            return this == o || (o != null && a.class == o.getClass() && this.a.equals(((a)o).a));
        }
        
        @Override
        public int hashCode() {
            return this.a.hashCode();
        }
    }
}
