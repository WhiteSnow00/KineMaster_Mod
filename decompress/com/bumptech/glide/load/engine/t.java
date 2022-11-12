// 
// Decompiled by Procyon v0.6.0
// 

package com.bumptech.glide.load.engine;

import com.bumptech.glide.load.DataSource;
import c2.h;
import java.io.File;
import h2.n;
import java.util.List;
import c2.b;
import com.bumptech.glide.load.data.d;

class t implements e, d.a<Object>
{
    private final e.a a;
    private final f<?> b;
    private int c;
    private int d;
    private b e;
    private List<n<File, ?>> f;
    private int g;
    private volatile n.a<?> h;
    private File i;
    private u j;
    
    t(final f<?> b, final e.a a) {
        this.d = -1;
        this.b = b;
        this.a = a;
    }
    
    private boolean a() {
        return this.g < this.f.size();
    }
    
    @Override
    public boolean b() {
        w2.b.a("ResourceCacheGenerator.startNext");
        try {
            final List<b> c = this.b.c();
            final boolean empty = c.isEmpty();
            boolean b = false;
            if (empty) {
                return false;
            }
            final List<Class<?>> m = this.b.m();
            if (!m.isEmpty()) {
                while (this.f == null || !this.a()) {
                    if (++this.d >= m.size()) {
                        if (++this.c >= c.size()) {
                            return false;
                        }
                        this.d = 0;
                    }
                    final b e = c.get(this.c);
                    final Class clazz = m.get(this.d);
                    this.j = new u(this.b.b(), e, this.b.p(), this.b.t(), this.b.f(), this.b.s((Class<Object>)clazz), clazz, this.b.k());
                    final File a = this.b.d().a(this.j);
                    if ((this.i = a) != null) {
                        this.e = e;
                        this.f = this.b.j(a);
                        this.g = 0;
                    }
                }
                this.h = null;
                while (!b && this.a()) {
                    this.h = this.f.get(this.g++).b(this.i, this.b.t(), this.b.f(), this.b.k());
                    if (this.h != null && this.b.u(this.h.c.a())) {
                        this.h.c.e(this.b.l(), (d.a<?>)this);
                        b = true;
                    }
                }
                return b;
            }
            if (File.class.equals(this.b.r())) {
                return false;
            }
            final StringBuilder sb = new StringBuilder();
            sb.append("Failed to find any load path from ");
            sb.append(this.b.i());
            sb.append(" to ");
            sb.append(this.b.r());
            throw new IllegalStateException(sb.toString());
        }
        finally {
            w2.b.e();
        }
    }
    
    @Override
    public void c(final Exception ex) {
        this.a.a(this.j, ex, this.h.c, DataSource.RESOURCE_DISK_CACHE);
    }
    
    @Override
    public void cancel() {
        final n.a<?> h = this.h;
        if (h != null) {
            h.c.cancel();
        }
    }
    
    @Override
    public void f(final Object o) {
        this.a.c(this.e, o, this.h.c, DataSource.RESOURCE_DISK_CACHE, this.j);
    }
}
