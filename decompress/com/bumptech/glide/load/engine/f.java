// 
// Decompiled by Procyon v0.6.0
// 

package com.bumptech.glide.load.engine;

import java.util.Iterator;
import j2.c;
import c2.g;
import com.bumptech.glide.Registry;
import java.io.File;
import f2.a;
import java.util.ArrayList;
import com.bumptech.glide.Priority;
import c2.h;
import java.util.Map;
import com.bumptech.glide.e;
import c2.b;
import h2.n;
import java.util.List;

final class f<Transcode>
{
    private final List<n.a<?>> a;
    private final List<b> b;
    private e c;
    private Object d;
    private int e;
    private int f;
    private Class<?> g;
    private DecodeJob.e h;
    private c2.e i;
    private Map<Class<?>, h<?>> j;
    private Class<Transcode> k;
    private boolean l;
    private boolean m;
    private b n;
    private Priority o;
    private com.bumptech.glide.load.engine.h p;
    private boolean q;
    private boolean r;
    
    f() {
        this.a = new ArrayList<n.a<?>>();
        this.b = new ArrayList<b>();
    }
    
    void a() {
        this.c = null;
        this.d = null;
        this.n = null;
        this.g = null;
        this.k = null;
        this.i = null;
        this.o = null;
        this.j = null;
        this.p = null;
        this.a.clear();
        this.l = false;
        this.b.clear();
        this.m = false;
    }
    
    e2.b b() {
        return this.c.b();
    }
    
    List<b> c() {
        if (!this.m) {
            this.m = true;
            this.b.clear();
            final List<n.a<?>> g = this.g();
            for (int size = g.size(), i = 0; i < size; ++i) {
                final n.a a = (n.a)g.get(i);
                if (!this.b.contains(a.a)) {
                    this.b.add(a.a);
                }
                for (int j = 0; j < a.b.size(); ++j) {
                    if (!this.b.contains(a.b.get(j))) {
                        this.b.add(a.b.get(j));
                    }
                }
            }
        }
        return this.b;
    }
    
    a d() {
        return this.h.a();
    }
    
    com.bumptech.glide.load.engine.h e() {
        return this.p;
    }
    
    int f() {
        return this.f;
    }
    
    List<n.a<?>> g() {
        if (!this.l) {
            this.l = true;
            this.a.clear();
            final List<n<Object, ?>> i = this.c.i().i(this.d);
            for (int j = 0; j < i.size(); ++j) {
                final n.a<Object> b = i.get(j).b(this.d, this.e, this.f, this.i);
                if (b != null) {
                    this.a.add((n.a<?>)b);
                }
            }
        }
        return this.a;
    }
    
     <Data> q<Data, ?, Transcode> h(final Class<Data> clazz) {
        return this.c.i().h(clazz, this.g, this.k);
    }
    
    Class<?> i() {
        return this.d.getClass();
    }
    
    List<n<File, ?>> j(final File file) throws Registry.NoModelLoaderAvailableException {
        return this.c.i().i(file);
    }
    
    c2.e k() {
        return this.i;
    }
    
    Priority l() {
        return this.o;
    }
    
    List<Class<?>> m() {
        return this.c.i().j(this.d.getClass(), this.g, this.k);
    }
    
     <Z> g<Z> n(final s<Z> s) {
        return this.c.i().k(s);
    }
    
     <T> com.bumptech.glide.load.data.e<T> o(final T t) {
        return this.c.i().l(t);
    }
    
    b p() {
        return this.n;
    }
    
     <X> c2.a<X> q(final X x) throws Registry.NoSourceEncoderAvailableException {
        return this.c.i().m(x);
    }
    
    Class<?> r() {
        return this.k;
    }
    
     <Z> h<Z> s(final Class<Z> clazz) {
        h h2;
        final h h = h2 = this.j.get(clazz);
        Label_0085: {
            if (h == null) {
                final Iterator<Map.Entry<Class<?>, h<?>>> iterator = this.j.entrySet().iterator();
                Map.Entry<Class, V> entry;
                do {
                    h2 = h;
                    if (!iterator.hasNext()) {
                        break Label_0085;
                    }
                    entry = iterator.next();
                } while (!entry.getKey().isAssignableFrom(clazz));
                h2 = (h)entry.getValue();
            }
        }
        if (h2 != null) {
            return h2;
        }
        if (this.j.isEmpty() && this.q) {
            final StringBuilder sb = new StringBuilder();
            sb.append("Missing transformation for ");
            sb.append(clazz);
            sb.append(". If you wish to ignore unknown resource types, use the optional transformation methods.");
            throw new IllegalArgumentException(sb.toString());
        }
        return (h<Z>)j2.c.c();
    }
    
    int t() {
        return this.e;
    }
    
    boolean u(final Class<?> clazz) {
        return this.h(clazz) != null;
    }
    
     <R> void v(final e c, final Object d, final b n, final int e, final int f, final com.bumptech.glide.load.engine.h p14, final Class<?> g, final Class<R> k, final Priority o, final c2.e i, final Map<Class<?>, h<?>> j, final boolean q, final boolean r, final DecodeJob.e h) {
        this.c = c;
        this.d = d;
        this.n = n;
        this.e = e;
        this.f = f;
        this.p = p14;
        this.g = g;
        this.h = h;
        this.k = (Class<Transcode>)k;
        this.o = o;
        this.i = i;
        this.j = j;
        this.q = q;
        this.r = r;
    }
    
    boolean w(final s<?> s) {
        return this.c.i().n(s);
    }
    
    boolean x() {
        return this.r;
    }
    
    boolean y(final b b) {
        final List<n.a<?>> g = this.g();
        for (int size = g.size(), i = 0; i < size; ++i) {
            if (((n.a)g.get(i)).a.equals(b)) {
                return true;
            }
        }
        return false;
    }
}
