// 
// Decompiled by Procyon v0.6.0
// 

package com.bumptech.glide;

import java.util.Collections;
import e2.e;
import android.content.Context;
import com.bumptech.glide.request.g;
import java.util.List;
import p2.p;
import g2.a;
import f2.h;
import e2.b;
import com.bumptech.glide.load.engine.i;
import java.util.Map;

public final class d
{
    private final Map<Class<?>, j<?, ?>> a;
    private final f.a b;
    private i c;
    private d d;
    private e2.b e;
    private h f;
    private a g;
    private a h;
    private f2.a.a i;
    private f2.i j;
    private p2.d k;
    private int l;
    private com.bumptech.glide.c.a m;
    private p.b n;
    private a o;
    private boolean p;
    private List<g<Object>> q;
    
    public d() {
        this.a = new androidx.collection.a<Class<?>, j<?, ?>>();
        this.b = new f.a();
        this.l = 4;
        this.m = new com.bumptech.glide.c.a() {
            final d a;
            
            @Override
            public com.bumptech.glide.request.h build() {
                return new com.bumptech.glide.request.h();
            }
        };
    }
    
    com.bumptech.glide.c a(final Context context) {
        if (this.g == null) {
            this.g = g2.a.g();
        }
        if (this.h == null) {
            this.h = g2.a.e();
        }
        if (this.o == null) {
            this.o = g2.a.c();
        }
        if (this.j == null) {
            this.j = new f2.i.a(context).a();
        }
        if (this.k == null) {
            this.k = new p2.f();
        }
        if (this.d == null) {
            final int b = this.j.b();
            if (b > 0) {
                this.d = new e2.j(b);
            }
            else {
                this.d = new e2.e();
            }
        }
        if (this.e == null) {
            this.e = new e2.i(this.j.a());
        }
        if (this.f == null) {
            this.f = new f2.g(this.j.d());
        }
        if (this.i == null) {
            this.i = new f2.f(context);
        }
        if (this.c == null) {
            this.c = new i(this.f, this.i, this.h, this.g, g2.a.h(), this.o, this.p);
        }
        final List<g<Object>> q = this.q;
        if (q == null) {
            this.q = Collections.emptyList();
        }
        else {
            this.q = (List<g<Object>>)Collections.unmodifiableList((List<?>)q);
        }
        final f b2 = this.b.b();
        return new com.bumptech.glide.c(context, this.c, this.f, this.d, this.e, new p(this.n, b2), this.k, this.l, this.m, this.a, this.q, b2);
    }
    
    void b(final p.b n) {
        this.n = n;
    }
    
    static final class b
    {
    }
    
    static final class c
    {
    }
    
    public static final class d
    {
    }
    
    public static final class e
    {
        private e() {
        }
    }
}
