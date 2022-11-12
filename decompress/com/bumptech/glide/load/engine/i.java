// 
// Decompiled by Procyon v0.6.0
// 

package com.bumptech.glide.load.engine;

import com.bumptech.glide.load.DataSource;
import java.util.concurrent.Executor;
import java.util.Map;
import com.bumptech.glide.Priority;
import com.bumptech.glide.e;
import v2.g;
import c2.b;
import android.util.Log;
import f2.h;

public class i implements k, h.a, n.a
{
    private static final boolean i;
    private final p a;
    private final m b;
    private final h c;
    private final b d;
    private final v e;
    private final c f;
    private final a g;
    private final com.bumptech.glide.load.engine.a h;
    
    static {
        i = Log.isLoggable("Engine", 2);
    }
    
    i(final h c, final f2.a.a a, final g2.a a2, final g2.a a3, final g2.a a4, final g2.a a5, final p p13, m b, com.bumptech.glide.load.engine.a h, final b b2, a g, v e, final boolean b3) {
        this.c = c;
        final c f = new c(a);
        this.f = f;
        if (h == null) {
            h = new com.bumptech.glide.load.engine.a(b3);
        }
        (this.h = h).f(this);
        if (b == null) {
            b = new m();
        }
        this.b = b;
        p a6;
        if (p13 == null) {
            a6 = new p();
        }
        else {
            a6 = p13;
        }
        this.a = a6;
        b d;
        if (b2 == null) {
            d = new b(a2, a3, a4, a5, this, this);
        }
        else {
            d = b2;
        }
        this.d = d;
        if (g == null) {
            g = new a(f);
        }
        this.g = g;
        if (e == null) {
            e = new v();
        }
        this.e = e;
        c.d((h.a)this);
    }
    
    public i(final h h, final f2.a.a a, final g2.a a2, final g2.a a3, final g2.a a4, final g2.a a5, final boolean b) {
        this(h, a, a2, a3, a4, a5, null, null, null, null, null, null, b);
    }
    
    private n<?> e(final c2.b b) {
        final s<?> c = this.c.c(b);
        n<?> n;
        if (c == null) {
            n = null;
        }
        else if (c instanceof n) {
            n = (n<?>)c;
        }
        else {
            n = new n<Object>(c, true, true, b, (n.a)this);
        }
        return n;
    }
    
    private n<?> g(final c2.b b) {
        final n<?> e = this.h.e(b);
        if (e != null) {
            e.d();
        }
        return e;
    }
    
    private n<?> h(final c2.b b) {
        final n<?> e = this.e(b);
        if (e != null) {
            e.d();
            this.h.a(b, e);
        }
        return e;
    }
    
    private n<?> i(final l l, final boolean b, final long n) {
        if (!b) {
            return null;
        }
        final n<?> g = this.g(l);
        if (g != null) {
            if (com.bumptech.glide.load.engine.i.i) {
                j("Loaded resource from active resources", n, l);
            }
            return g;
        }
        final n<?> h = this.h(l);
        if (h != null) {
            if (com.bumptech.glide.load.engine.i.i) {
                j("Loaded resource from cache", n, l);
            }
            return h;
        }
        return null;
    }
    
    private static void j(final String s, final long n, final c2.b b) {
        final StringBuilder sb = new StringBuilder();
        sb.append(s);
        sb.append(" in ");
        sb.append(g.a(n));
        sb.append("ms, key: ");
        sb.append(b);
        Log.v("Engine", sb.toString());
    }
    
    private <R> d l(final e e, final Object o, final c2.b b, final int n, final int n2, final Class<?> clazz, final Class<R> clazz2, final Priority priority, final com.bumptech.glide.load.engine.h h, final Map<Class<?>, c2.h<?>> map, final boolean b2, final boolean b3, final c2.e e2, final boolean b4, final boolean b5, final boolean b6, final boolean b7, final com.bumptech.glide.request.i i, final Executor executor, final l l, final long n3) {
        final j<?> a = this.a.a(l, b7);
        if (a != null) {
            a.a(i, executor);
            if (i.i) {
                j("Added to existing load", n3, l);
            }
            return new d(i, a);
        }
        final j<Object> a2 = this.d.a(l, b4, b5, b6, b7);
        final DecodeJob<R> a3 = this.g.a(e, o, l, b, n, n2, clazz, clazz2, priority, h, map, b2, b3, b7, e2, (DecodeJob.b<R>)a2);
        this.a.c(l, a2);
        a2.a(i, executor);
        a2.s((DecodeJob<Object>)a3);
        if (i.i) {
            j("Started new load", n3, l);
        }
        return new d(i, a2);
    }
    
    @Override
    public void a(final s<?> s) {
        this.e.a(s, true);
    }
    
    @Override
    public void b(final j<?> j, final c2.b b) {
        synchronized (this) {
            this.a.d(b, j);
        }
    }
    
    @Override
    public void c(final c2.b b, final n<?> n) {
        this.h.d(b);
        if (n.f()) {
            this.c.e(b, n);
        }
        else {
            this.e.a(n, false);
        }
    }
    
    @Override
    public void d(final j<?> j, final c2.b b, final n<?> n) {
        monitorenter(this);
        Label_0022: {
            if (n == null) {
                break Label_0022;
            }
            try {
                if (n.f()) {
                    this.h.a(b, n);
                }
                this.a.d(b, j);
            }
            finally {
                monitorexit(this);
            }
        }
    }
    
    public <R> d f(final e e, final Object o, final c2.b b, final int n, final int n2, final Class<?> clazz, final Class<R> clazz2, final Priority priority, final com.bumptech.glide.load.engine.h h, final Map<Class<?>, c2.h<?>> map, final boolean b2, final boolean b3, final c2.e e2, final boolean b4, final boolean b5, final boolean b6, final boolean b7, final com.bumptech.glide.request.i i, final Executor executor) {
        long b8;
        if (i.i) {
            b8 = v2.g.b();
        }
        else {
            b8 = 0L;
        }
        final l a = this.b.a(o, b, n, n2, map, clazz, clazz2, e2);
        synchronized (this) {
            final n<?> j = this.i(a, b4, b8);
            if (j == null) {
                return this.l(e, o, b, n, n2, clazz, clazz2, priority, h, map, b2, b3, e2, b4, b5, b6, b7, i, executor, a, b8);
            }
            monitorexit(this);
            i.b(j, DataSource.MEMORY_CACHE, false);
            return null;
        }
    }
    
    public void k(final s<?> s) {
        if (s instanceof n) {
            ((n)s).g();
            return;
        }
        throw new IllegalArgumentException("Cannot release anything but an EngineResource");
    }
    
    static class a
    {
        final DecodeJob.e a;
        final androidx.core.util.e<DecodeJob<?>> b;
        private int c;
        
        a(final DecodeJob.e a) {
            this.b = w2.a.d(150, (w2.a.d<DecodeJob<?>>)new w2.a.d<DecodeJob<?>>() {
                final i.a a;
                
                @Override
                public /* bridge */ Object a() {
                    return this.b();
                }
                
                public DecodeJob<?> b() {
                    final i.a a = this.a;
                    return new DecodeJob<Object>(a.a, a.b);
                }
            });
            this.a = a;
        }
        
         <R> DecodeJob<R> a(final e e, final Object o, final l l, final c2.b b, final int n, final int n2, final Class<?> clazz, final Class<R> clazz2, final Priority priority, final com.bumptech.glide.load.engine.h h, final Map<Class<?>, c2.h<?>> map, final boolean b2, final boolean b3, final boolean b4, final c2.e e2, final DecodeJob.b<R> b5) {
            return v2.k.d(this.b.a()).q(e, o, l, b, n, n2, clazz, clazz2, priority, h, map, b2, b3, b4, e2, (DecodeJob.b)b5, this.c++);
        }
    }
    
    static class b
    {
        final g2.a a;
        final g2.a b;
        final g2.a c;
        final g2.a d;
        final k e;
        final n.a f;
        final androidx.core.util.e<j<?>> g;
        
        b(final g2.a a, final g2.a b, final g2.a c, final g2.a d, final k e, final n.a f) {
            this.g = w2.a.d(150, (w2.a.d<j<?>>)new w2.a.d<j<?>>() {
                final b a;
                
                @Override
                public /* bridge */ Object a() {
                    return this.b();
                }
                
                public j<?> b() {
                    final b a = this.a;
                    return new j<Object>(a.a, a.b, a.c, a.d, a.e, a.f, a.g);
                }
            });
            this.a = a;
            this.b = b;
            this.c = c;
            this.d = d;
            this.e = e;
            this.f = f;
        }
        
         <R> j<R> a(final c2.b b, final boolean b2, final boolean b3, final boolean b4, final boolean b5) {
            return v2.k.d(this.g.a()).l(b, b2, b3, b4, b5);
        }
    }
    
    private static class c implements e
    {
        private final a.a a;
        private volatile f2.a b;
        
        c(final a.a a) {
            this.a = a;
        }
        
        @Override
        public f2.a a() {
            if (this.b == null) {
                synchronized (this) {
                    if (this.b == null) {
                        this.b = this.a.build();
                    }
                    if (this.b == null) {
                        this.b = new f2.b();
                    }
                }
            }
            return this.b;
        }
    }
    
    public class d
    {
        private final j<?> a;
        private final com.bumptech.glide.request.i b;
        final i c;
        
        d(final i c, final com.bumptech.glide.request.i b, final j<?> a) {
            this.c = c;
            this.b = b;
            this.a = a;
        }
        
        public void a() {
            synchronized (this.c) {
                this.a.r(this.b);
            }
        }
    }
}
