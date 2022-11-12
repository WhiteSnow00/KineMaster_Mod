// 
// Decompiled by Procyon v0.6.0
// 

package com.bumptech.glide.load.engine;

import java.lang.ref.Reference;
import v2.k;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.concurrent.Executors;
import android.os.Process;
import java.util.concurrent.ThreadFactory;
import java.lang.ref.ReferenceQueue;
import c2.b;
import java.util.Map;
import java.util.concurrent.Executor;

final class a
{
    private final boolean a;
    private final Executor b;
    final Map<b, d> c;
    private final ReferenceQueue<n<?>> d;
    private n.a e;
    private volatile boolean f;
    private volatile c g;
    
    a(final boolean b) {
        this(b, Executors.newSingleThreadExecutor(new ThreadFactory() {
            @Override
            public Thread newThread(final Runnable runnable) {
                return new Thread(new Runnable(this, runnable) {
                    final Runnable a;
                    final a$a b;
                    
                    @Override
                    public void run() {
                        Process.setThreadPriority(10);
                        this.a.run();
                    }
                }, "glide-active-resources");
            }
        }));
    }
    
    a(final boolean a, final Executor b) {
        this.c = new HashMap<b, d>();
        this.d = new ReferenceQueue<n<?>>();
        this.a = a;
        (this.b = b).execute(new Runnable(this) {
            final a a;
            
            @Override
            public void run() {
                this.a.b();
            }
        });
    }
    
    void a(final b b, final n<?> n) {
        synchronized (this) {
            final d d = this.c.put(b, new d(b, n, this.d, this.a));
            if (d != null) {
                d.a();
            }
        }
    }
    
    void b() {
        while (!this.f) {
            try {
                this.c((d)this.d.remove());
                final c g = this.g;
                if (g == null) {
                    continue;
                }
                g.a();
            }
            catch (final InterruptedException ex) {
                Thread.currentThread().interrupt();
            }
        }
    }
    
    void c(final d d) {
        synchronized (this) {
            this.c.remove(d.a);
            if (d.b) {
                final s<?> c = d.c;
                if (c != null) {
                    monitorexit(this);
                    this.e.c(d.a, new n<Object>((s<Object>)c, true, false, d.a, this.e));
                }
            }
        }
    }
    
    void d(final b b) {
        synchronized (this) {
            final d d = this.c.remove(b);
            if (d != null) {
                d.a();
            }
        }
    }
    
    n<?> e(final b b) {
        synchronized (this) {
            final d d = this.c.get(b);
            if (d == null) {
                return null;
            }
            final n n = ((Reference<n>)d).get();
            if (n == null) {
                this.c(d);
            }
            return n;
        }
    }
    
    void f(final n.a e) {
        synchronized (e) {
            synchronized (this) {
                this.e = e;
            }
        }
    }
    
    interface c
    {
        void a();
    }
    
    static final class d extends WeakReference<n<?>>
    {
        final b a;
        final boolean b;
        s<?> c;
        
        d(final b b, final n<?> n, final ReferenceQueue<? super n<?>> referenceQueue, final boolean b2) {
            super(n, referenceQueue);
            this.a = k.d(b);
            s c;
            if (n.f() && b2) {
                c = k.d(n.e());
            }
            else {
                c = null;
            }
            this.c = c;
            this.b = n.f();
        }
        
        void a() {
            this.c = null;
            this.clear();
        }
    }
}
