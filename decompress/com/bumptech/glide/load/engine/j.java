// 
// Decompiled by Procyon v0.6.0
// 

package com.bumptech.glide.load.engine;

import java.util.Collection;
import java.util.ArrayList;
import java.util.List;
import java.util.Iterator;
import java.util.concurrent.Executor;
import com.bumptech.glide.request.i;
import c2.b;
import java.util.concurrent.atomic.AtomicInteger;
import androidx.core.util.e;
import w2.c;
import com.bumptech.glide.load.DataSource;
import w2.a;

class j<R> implements DecodeJob.b<R>, w2.a.f
{
    private static final c K;
    private boolean A;
    private s<?> B;
    DataSource C;
    private boolean D;
    GlideException E;
    private boolean F;
    n<?> G;
    private DecodeJob<R> H;
    private volatile boolean I;
    private boolean J;
    final e a;
    private final w2.c b;
    private final n.a c;
    private final androidx.core.util.e<j<?>> d;
    private final c e;
    private final k f;
    private final g2.a g;
    private final g2.a h;
    private final g2.a i;
    private final g2.a j;
    private final AtomicInteger p;
    private c2.b w;
    private boolean x;
    private boolean y;
    private boolean z;
    
    static {
        K = new c();
    }
    
    j(final g2.a a, final g2.a a2, final g2.a a3, final g2.a a4, final k k, final n.a a5, final androidx.core.util.e<j<?>> e) {
        this(a, a2, a3, a4, k, a5, e, com.bumptech.glide.load.engine.j.K);
    }
    
    j(final g2.a g, final g2.a h, final g2.a i, final g2.a j, final k f, final n.a c, final androidx.core.util.e<j<?>> d, final c e) {
        this.a = new e();
        this.b = w2.c.a();
        this.p = new AtomicInteger();
        this.g = g;
        this.h = h;
        this.i = i;
        this.j = j;
        this.f = f;
        this.c = c;
        this.d = d;
        this.e = e;
    }
    
    private g2.a j() {
        g2.a a;
        if (this.y) {
            a = this.i;
        }
        else if (this.z) {
            a = this.j;
        }
        else {
            a = this.h;
        }
        return a;
    }
    
    private boolean m() {
        return this.F || this.D || this.I;
    }
    
    private void q() {
        synchronized (this) {
            if (this.w != null) {
                this.a.clear();
                this.w = null;
                this.G = null;
                this.B = null;
                this.F = false;
                this.I = false;
                this.D = false;
                this.J = false;
                this.H.A(false);
                this.H = null;
                this.E = null;
                this.C = null;
                this.d.b(this);
                return;
            }
            throw new IllegalArgumentException();
        }
    }
    
    void a(final i i, final Executor executor) {
        synchronized (this) {
            this.b.c();
            this.a.a(i, executor);
            final boolean d = this.D;
            boolean b = true;
            if (d) {
                this.k(1);
                executor.execute(new b(i));
            }
            else if (this.F) {
                this.k(1);
                executor.execute(new a(i));
            }
            else {
                if (this.I) {
                    b = false;
                }
                v2.k.a(b, "Cannot add callbacks to a cancelled EngineJob");
            }
        }
    }
    
    @Override
    public void b(final s<R> b, final DataSource c, final boolean j) {
        synchronized (this) {
            this.B = b;
            this.C = c;
            this.J = j;
            monitorexit(this);
            this.o();
        }
    }
    
    @Override
    public void c(final GlideException e) {
        synchronized (this) {
            this.E = e;
            monitorexit(this);
            this.n();
        }
    }
    
    @Override
    public w2.c d() {
        return this.b;
    }
    
    @Override
    public void e(final DecodeJob<?> decodeJob) {
        this.j().execute(decodeJob);
    }
    
    void f(final i i) {
        try {
            i.c(this.E);
        }
        finally {
            final Throwable t;
            throw new CallbackException(t);
        }
    }
    
    void g(final i i) {
        try {
            i.b(this.G, this.C, this.J);
        }
        finally {
            final Throwable t;
            throw new CallbackException(t);
        }
    }
    
    void h() {
        if (this.m()) {
            return;
        }
        this.I = true;
        this.H.g();
        this.f.b(this, this.w);
    }
    
    void i() {
        synchronized (this) {
            this.b.c();
            v2.k.a(this.m(), "Not yet complete!");
            final int decrementAndGet = this.p.decrementAndGet();
            v2.k.a(decrementAndGet >= 0, "Can't decrement below 0");
            n<?> g;
            if (decrementAndGet == 0) {
                g = this.G;
                this.q();
            }
            else {
                g = null;
            }
            monitorexit(this);
            if (g != null) {
                g.g();
            }
        }
    }
    
    void k(final int n) {
        synchronized (this) {
            v2.k.a(this.m(), "Not yet complete!");
            if (this.p.getAndAdd(n) == 0) {
                final n<?> g = this.G;
                if (g != null) {
                    g.d();
                }
            }
        }
    }
    
    j<R> l(final c2.b w, final boolean x, final boolean y, final boolean z, final boolean a) {
        synchronized (this) {
            this.w = w;
            this.x = x;
            this.y = y;
            this.z = z;
            this.A = a;
            return this;
        }
    }
    
    void n() {
        synchronized (this) {
            this.b.c();
            if (this.I) {
                this.q();
                return;
            }
            if (this.a.isEmpty()) {
                throw new IllegalStateException("Received an exception without any callbacks to notify");
            }
            if (!this.F) {
                this.F = true;
                final c2.b w = this.w;
                final e e = this.a.e();
                this.k(e.size() + 1);
                monitorexit(this);
                this.f.d(this, w, null);
                for (final d d : e) {
                    d.b.execute(new a(d.a));
                }
                this.i();
                return;
            }
            throw new IllegalStateException("Already failed once");
        }
    }
    
    void o() {
        synchronized (this) {
            this.b.c();
            if (this.I) {
                this.B.b();
                this.q();
                return;
            }
            if (this.a.isEmpty()) {
                throw new IllegalStateException("Received a resource without any callbacks to notify");
            }
            if (!this.D) {
                this.G = this.e.a(this.B, this.x, this.w, this.c);
                this.D = true;
                final e e = this.a.e();
                this.k(e.size() + 1);
                final c2.b w = this.w;
                final n<?> g = this.G;
                monitorexit(this);
                this.f.d(this, w, g);
                for (final d d : e) {
                    d.b.execute(new b(d.a));
                }
                this.i();
                return;
            }
            throw new IllegalStateException("Already have resource");
        }
    }
    
    boolean p() {
        return this.A;
    }
    
    void r(final i i) {
        synchronized (this) {
            this.b.c();
            this.a.g(i);
            if (this.a.isEmpty()) {
                this.h();
                if ((this.D || this.F) && this.p.get() == 0) {
                    this.q();
                }
            }
        }
    }
    
    public void s(final DecodeJob<R> h) {
        synchronized (this) {
            this.H = h;
            g2.a a;
            if (h.I()) {
                a = this.g;
            }
            else {
                a = this.j();
            }
            a.execute(h);
        }
    }
    
    private class a implements Runnable
    {
        private final i a;
        final j b;
        
        a(final j b, final i a) {
            this.b = b;
            this.a = a;
        }
        
        @Override
        public void run() {
            synchronized (this.a.f()) {
                synchronized (this.b) {
                    if (this.b.a.b(this.a)) {
                        this.b.f(this.a);
                    }
                    this.b.i();
                }
            }
        }
    }
    
    private class b implements Runnable
    {
        private final i a;
        final j b;
        
        b(final j b, final i a) {
            this.b = b;
            this.a = a;
        }
        
        @Override
        public void run() {
            synchronized (this.a.f()) {
                synchronized (this.b) {
                    if (this.b.a.b(this.a)) {
                        this.b.G.d();
                        this.b.g(this.a);
                        this.b.r(this.a);
                    }
                    this.b.i();
                }
            }
        }
    }
    
    static class c
    {
        public <R> n<R> a(final s<R> s, final boolean b, final c2.b b2, final n.a a) {
            return new n<R>(s, b, true, b2, a);
        }
    }
    
    static final class d
    {
        final i a;
        final Executor b;
        
        d(final i a, final Executor b) {
            this.a = a;
            this.b = b;
        }
        
        @Override
        public boolean equals(final Object o) {
            return o instanceof d && this.a.equals(((d)o).a);
        }
        
        @Override
        public int hashCode() {
            return this.a.hashCode();
        }
    }
    
    static final class e implements Iterable<d>
    {
        private final List<d> a;
        
        e() {
            this(new ArrayList<d>(2));
        }
        
        e(final List<d> a) {
            this.a = a;
        }
        
        private static d f(final i i) {
            return new d(i, v2.e.a());
        }
        
        void a(final i i, final Executor executor) {
            this.a.add(new d(i, executor));
        }
        
        boolean b(final i i) {
            return this.a.contains(f(i));
        }
        
        void clear() {
            this.a.clear();
        }
        
        e e() {
            return new e(new ArrayList<d>(this.a));
        }
        
        void g(final i i) {
            this.a.remove(f(i));
        }
        
        boolean isEmpty() {
            return this.a.isEmpty();
        }
        
        @Override
        public Iterator<d> iterator() {
            return this.a.iterator();
        }
        
        int size() {
            return this.a.size();
        }
    }
}
