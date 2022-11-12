// 
// Decompiled by Procyon v0.6.0
// 

package com.airbnb.lottie;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;
import java.util.Iterator;
import y1.d;
import java.util.Collection;
import java.util.ArrayList;
import android.os.Looper;
import java.util.LinkedHashSet;
import java.util.concurrent.Callable;
import java.util.concurrent.Executors;
import android.os.Handler;
import java.util.Set;
import java.util.concurrent.Executor;

public class m<T>
{
    public static Executor e;
    private final Set<h<T>> a;
    private final Set<h<Throwable>> b;
    private final Handler c;
    private volatile l<T> d;
    
    static {
        m.e = Executors.newCachedThreadPool();
    }
    
    public m(final Callable<l<T>> callable) {
        this(callable, false);
    }
    
    m(final Callable<l<T>> callable, final boolean b) {
        this.a = new LinkedHashSet<h<T>>(1);
        this.b = new LinkedHashSet<h<Throwable>>(1);
        this.c = new Handler(Looper.getMainLooper());
        this.d = null;
        if (b) {
            try {
                this.l(callable.call());
            }
            finally {
                final Throwable t;
                this.l(new l<T>(t));
            }
        }
        else {
            m.e.execute(new b(callable));
        }
    }
    
    static l a(final m m) {
        return m.d;
    }
    
    static void b(final m m, final Object o) {
        m.i(o);
    }
    
    static void c(final m m, final Throwable t) {
        m.g(t);
    }
    
    static void d(final m m, final l l) {
        m.l(l);
    }
    
    private void g(final Throwable t) {
        synchronized (this) {
            final ArrayList list = new ArrayList(this.b);
            if (list.isEmpty()) {
                y1.d.d("Lottie encountered an error but no failure listener was added:", t);
                return;
            }
            final Iterator iterator = list.iterator();
            while (iterator.hasNext()) {
                ((h<Throwable>)iterator.next()).a(t);
            }
        }
    }
    
    private void h() {
        this.c.post((Runnable)new Runnable(this) {
            final m a;
            
            @Override
            public void run() {
                if (m.a(this.a) == null) {
                    return;
                }
                final l a = m.a(this.a);
                if (a.b() != null) {
                    m.b(this.a, a.b());
                }
                else {
                    m.c(this.a, a.a());
                }
            }
        });
    }
    
    private void i(final T t) {
        synchronized (this) {
            final Iterator iterator = new ArrayList(this.a).iterator();
            while (iterator.hasNext()) {
                ((h<T>)iterator.next()).a(t);
            }
        }
    }
    
    private void l(final l<T> d) {
        if (this.d == null) {
            this.d = d;
            this.h();
            return;
        }
        throw new IllegalStateException("A task may only be set once.");
    }
    
    public m<T> e(final h<Throwable> h) {
        synchronized (this) {
            if (this.d != null && this.d.a() != null) {
                h.a(this.d.a());
            }
            this.b.add(h);
            return this;
        }
    }
    
    public m<T> f(final h<T> h) {
        synchronized (this) {
            if (this.d != null && this.d.b() != null) {
                h.a(this.d.b());
            }
            this.a.add(h);
            return this;
        }
    }
    
    public m<T> j(final h<Throwable> h) {
        synchronized (this) {
            this.b.remove(h);
            return this;
        }
    }
    
    public m<T> k(final h<T> h) {
        synchronized (this) {
            this.a.remove(h);
            return this;
        }
    }
    
    private class b extends FutureTask<l<T>>
    {
        final m a;
        
        b(final m a, final Callable<l<T>> callable) {
            this.a = a;
            super(callable);
        }
        
        @Override
        protected void done() {
            if (this.isCancelled()) {
                return;
            }
            try {
                m.d(this.a, ((FutureTask<l>)this).get());
                return;
            }
            catch (final ExecutionException ex) {}
            catch (final InterruptedException ex2) {}
            final ExecutionException ex;
            m.d(this.a, new l(ex));
        }
    }
}
