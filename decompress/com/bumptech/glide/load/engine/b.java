// 
// Decompiled by Procyon v0.6.0
// 

package com.bumptech.glide.load.engine;

import com.bumptech.glide.load.DataSource;
import java.io.File;
import h2.n;
import java.util.List;
import com.bumptech.glide.load.data.d;

class b implements e, d.a<Object>
{
    private final List<c2.b> a;
    private final f<?> b;
    private final e.a c;
    private int d;
    private c2.b e;
    private List<n<File, ?>> f;
    private int g;
    private volatile n.a<?> h;
    private File i;
    
    b(final f<?> f, final e.a a) {
        this(f.c(), f, a);
    }
    
    b(final List<c2.b> a, final f<?> b, final e.a c) {
        this.d = -1;
        this.a = a;
        this.b = b;
        this.c = c;
    }
    
    private boolean a() {
        return this.g < this.f.size();
    }
    
    @Override
    public boolean b() {
        w2.b.a("DataCacheGenerator.startNext");
        try {
            while (true) {
                final List<n<File, ?>> f = this.f;
                boolean b = false;
                if (f != null && this.a()) {
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
                if (++this.d >= this.a.size()) {
                    return false;
                }
                final c2.b e = this.a.get(this.d);
                final File a = this.b.d().a(new c(e, this.b.p()));
                if ((this.i = a) == null) {
                    continue;
                }
                this.e = e;
                this.f = this.b.j(a);
                this.g = 0;
            }
        }
        finally {
            w2.b.e();
        }
    }
    
    @Override
    public void c(final Exception ex) {
        this.c.a(this.e, ex, this.h.c, DataSource.DATA_DISK_CACHE);
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
        this.c.c(this.e, o, this.h.c, DataSource.DATA_DISK_CACHE, this.e);
    }
}
