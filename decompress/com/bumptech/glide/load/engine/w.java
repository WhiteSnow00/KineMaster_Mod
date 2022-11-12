// 
// Decompiled by Procyon v0.6.0
// 

package com.bumptech.glide.load.engine;

import com.bumptech.glide.load.DataSource;
import java.io.IOException;
import java.util.Collections;
import android.util.Log;
import f2.a;
import v2.g;
import h2.n;

class w implements e, a
{
    private final f<?> a;
    private final a b;
    private volatile int c;
    private volatile b d;
    private volatile Object e;
    private volatile n.a<?> f;
    private volatile c g;
    
    w(final f<?> a, final a b) {
        this.a = a;
        this.b = b;
    }
    
    private boolean d(Object d) throws IOException {
        final long b = v2.g.b();
        boolean b2;
        try {
            final com.bumptech.glide.load.data.e<Object> o = this.a.o(d);
            final Object a = o.a();
            final c2.a<Object> q = this.a.q(a);
            final d d2 = new d(q, a, this.a.k());
            final c g = new c(this.f.a, this.a.p());
            final f2.a d3 = this.a.d();
            d3.b(g, (f2.a.b)d2);
            if (Log.isLoggable("SourceGenerator", 2)) {
                final StringBuilder sb = new StringBuilder();
                sb.append("Finished encoding source to cache, key: ");
                sb.append(g);
                sb.append(", data: ");
                sb.append(d);
                sb.append(", encoder: ");
                sb.append(q);
                sb.append(", duration: ");
                sb.append(v2.g.a(b));
                Log.v("SourceGenerator", sb.toString());
            }
            if (d3.a(g) != null) {
                this.g = g;
                d = new b(Collections.singletonList(this.f.a), this.a, this);
                this.d = (b)d;
                this.f.c.b();
                return true;
            }
            if (Log.isLoggable("SourceGenerator", 3)) {
                final StringBuilder sb2 = new StringBuilder();
                sb2.append("Attempt to write: ");
                sb2.append(this.g);
                sb2.append(", data: ");
                sb2.append(d);
                sb2.append(" to the disk cache failed, maybe the disk cache is disabled? Trying to decode the data directly...");
                Log.d("SourceGenerator", sb2.toString());
            }
            try {
                this.b.c(this.f.a, o.a(), this.f.c, this.f.c.d(), this.f.a);
                return false;
            }
            finally {}
        }
        finally {
            b2 = false;
        }
        if (!b2) {
            this.f.c.b();
        }
    }
    
    private boolean e() {
        return this.c < this.a.g().size();
    }
    
    private void j(final n.a<?> a) {
        this.f.c.e(this.a.l(), (com.bumptech.glide.load.data.d.a<?>)new com.bumptech.glide.load.data.d.a<Object>(this, a) {
            final n.a a;
            final w b;
            
            @Override
            public void c(final Exception ex) {
                if (this.b.g(this.a)) {
                    this.b.i(this.a, ex);
                }
            }
            
            @Override
            public void f(final Object o) {
                if (this.b.g(this.a)) {
                    this.b.h(this.a, o);
                }
            }
        });
    }
    
    @Override
    public void a(final c2.b b, final Exception ex, final com.bumptech.glide.load.data.d<?> d, final DataSource dataSource) {
        this.b.a(b, ex, d, this.f.c.d());
    }
    
    @Override
    public boolean b() {
        if (this.e != null) {
            final Object e = this.e;
            this.e = null;
            try {
                if (!this.d(e)) {
                    return true;
                }
            }
            catch (final IOException ex) {
                if (Log.isLoggable("SourceGenerator", 3)) {
                    Log.d("SourceGenerator", "Failed to properly rewind or write data to cache", (Throwable)ex);
                }
            }
        }
        if (this.d != null && this.d.b()) {
            return true;
        }
        this.d = null;
        this.f = null;
        boolean b;
        for (b = false; !b && this.e(); b = true) {
            this.f = (n.a<?>)(n.a)this.a.g().get(this.c++);
            if (this.f != null && (this.a.e().c(this.f.c.d()) || this.a.u(this.f.c.a()))) {
                this.j(this.f);
            }
        }
        return b;
    }
    
    @Override
    public void c(final c2.b b, final Object o, final com.bumptech.glide.load.data.d<?> d, final DataSource dataSource, final c2.b b2) {
        this.b.c(b, o, d, this.f.c.d(), b);
    }
    
    @Override
    public void cancel() {
        final n.a<?> f = this.f;
        if (f != null) {
            f.c.cancel();
        }
    }
    
    @Override
    public void f() {
        throw new UnsupportedOperationException();
    }
    
    boolean g(final n.a<?> a) {
        final n.a<?> f = this.f;
        return f != null && f == a;
    }
    
    void h(final n.a<?> a, final Object e) {
        final h e2 = this.a.e();
        if (e != null && e2.c(a.c.d())) {
            this.e = e;
            this.b.f();
        }
        else {
            final a b = this.b;
            final c2.b a2 = a.a;
            final com.bumptech.glide.load.data.d<?> c = a.c;
            b.c(a2, e, c, c.d(), this.g);
        }
    }
    
    void i(final n.a<?> a, final Exception ex) {
        final a b = this.b;
        final c g = this.g;
        final com.bumptech.glide.load.data.d<?> c = a.c;
        b.a(g, ex, c, c.d());
    }
}
