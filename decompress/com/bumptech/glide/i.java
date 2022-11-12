// 
// Decompiled by Procyon v0.6.0
// 

package com.bumptech.glide;

import java.util.Iterator;
import android.content.res.Configuration;
import java.io.File;
import android.net.Uri;
import java.util.List;
import android.view.View;
import android.graphics.drawable.Drawable;
import com.bumptech.glide.request.a;
import com.bumptech.glide.request.e;
import java.util.Collection;
import p2.d;
import android.graphics.Bitmap;
import com.bumptech.glide.request.g;
import java.util.concurrent.CopyOnWriteArrayList;
import p2.u;
import p2.q;
import p2.r;
import p2.l;
import android.content.Context;
import com.bumptech.glide.request.h;
import p2.m;
import android.content.ComponentCallbacks2;

public class i implements ComponentCallbacks2, m
{
    private static final h w;
    private static final h x;
    private static final h y;
    protected final com.bumptech.glide.c a;
    protected final Context b;
    final l c;
    private final r d;
    private final q e;
    private final u f;
    private final Runnable g;
    private final p2.c h;
    private final CopyOnWriteArrayList<g<Object>> i;
    private h j;
    private boolean p;
    
    static {
        w = h.t0(Bitmap.class).T();
        x = h.t0(n2.c.class).T();
        y = h.u0(com.bumptech.glide.load.engine.h.c).d0(Priority.LOW).m0(true);
    }
    
    public i(final com.bumptech.glide.c c, final l l, final q q, final Context context) {
        this(c, l, q, new r(), c.g(), context);
    }
    
    i(final com.bumptech.glide.c a, final l c, final q e, final r d, final d d2, final Context b) {
        this.f = new u();
        final Runnable g = new Runnable() {
            final i a;
            
            @Override
            public void run() {
                final i a = this.a;
                a.c.b(a);
            }
        };
        this.g = g;
        this.a = a;
        this.c = c;
        this.e = e;
        this.d = d;
        this.b = b;
        final p2.c a2 = d2.a(b.getApplicationContext(), new c(d));
        this.h = a2;
        if (v2.l.r()) {
            v2.l.v(g);
        }
        else {
            c.b(this);
        }
        c.b(a2);
        this.i = new CopyOnWriteArrayList<g<Object>>(a.i().c());
        this.v(a.i().d());
        a.o(this);
    }
    
    private void y(final s2.i<?> i) {
        final boolean x = this.x(i);
        final e request = i.getRequest();
        if (!x && !this.a.p(i) && request != null) {
            i.setRequest(null);
            request.clear();
        }
    }
    
    public i a(final g<Object> g) {
        this.i.add(g);
        return this;
    }
    
    public <ResourceType> com.bumptech.glide.h<ResourceType> b(final Class<ResourceType> clazz) {
        return new com.bumptech.glide.h<ResourceType>(this.a, this, clazz, this.b);
    }
    
    public com.bumptech.glide.h<Bitmap> c() {
        return this.b(Bitmap.class).u0(com.bumptech.glide.i.w);
    }
    
    public com.bumptech.glide.h<Drawable> d() {
        return this.b(Drawable.class);
    }
    
    public com.bumptech.glide.h<n2.c> e() {
        return this.b(n2.c.class).u0(com.bumptech.glide.i.x);
    }
    
    public void f(final View view) {
        this.g(new b(view));
    }
    
    public void g(final s2.i<?> i) {
        if (i == null) {
            return;
        }
        this.y(i);
    }
    
    List<g<Object>> h() {
        return this.i;
    }
    
    h i() {
        synchronized (this) {
            return this.j;
        }
    }
    
     <T> j<?, T> j(final Class<T> clazz) {
        return this.a.i().e(clazz);
    }
    
    public com.bumptech.glide.h<Drawable> k(final Bitmap bitmap) {
        return this.d().H0(bitmap);
    }
    
    public com.bumptech.glide.h<Drawable> l(final Uri uri) {
        return this.d().I0(uri);
    }
    
    public com.bumptech.glide.h<Drawable> m(final File file) {
        return this.d().J0(file);
    }
    
    public com.bumptech.glide.h<Drawable> n(final Integer n) {
        return this.d().K0(n);
    }
    
    public com.bumptech.glide.h<Drawable> o(final Object o) {
        return this.d().M0(o);
    }
    
    public void onConfigurationChanged(final Configuration configuration) {
    }
    
    public void onDestroy() {
        synchronized (this) {
            this.f.onDestroy();
            final Iterator<s2.i<?>> iterator = this.f.b().iterator();
            while (iterator.hasNext()) {
                this.g(iterator.next());
            }
            this.f.a();
            this.d.b();
            this.c.a(this);
            this.c.a(this.h);
            v2.l.w(this.g);
            this.a.s(this);
        }
    }
    
    public void onLowMemory() {
    }
    
    public void onStart() {
        synchronized (this) {
            this.t();
            this.f.onStart();
        }
    }
    
    public void onStop() {
        synchronized (this) {
            this.s();
            this.f.onStop();
        }
    }
    
    public void onTrimMemory(final int n) {
        if (n == 60 && this.p) {
            this.r();
        }
    }
    
    public com.bumptech.glide.h<Drawable> p(final String s) {
        return this.d().N0(s);
    }
    
    public void q() {
        synchronized (this) {
            this.d.c();
        }
    }
    
    public void r() {
        synchronized (this) {
            this.q();
            final Iterator<i> iterator = this.e.a().iterator();
            while (iterator.hasNext()) {
                iterator.next().q();
            }
        }
    }
    
    public void s() {
        synchronized (this) {
            this.d.d();
        }
    }
    
    public void t() {
        synchronized (this) {
            this.d.f();
        }
    }
    
    @Override
    public String toString() {
        synchronized (this) {
            final StringBuilder sb = new StringBuilder();
            sb.append(super.toString());
            sb.append("{tracker=");
            sb.append(this.d);
            sb.append(", treeNode=");
            sb.append(this.e);
            sb.append("}");
            return sb.toString();
        }
    }
    
    public i u(final h h) {
        synchronized (this) {
            this.v(h);
            return this;
        }
    }
    
    protected void v(final h h) {
        synchronized (this) {
            this.j = h.f().c();
        }
    }
    
    void w(final s2.i<?> i, final e e) {
        synchronized (this) {
            this.f.c(i);
            this.d.g(e);
        }
    }
    
    boolean x(final s2.i<?> i) {
        synchronized (this) {
            final e request = i.getRequest();
            if (request == null) {
                return true;
            }
            if (this.d.a(request)) {
                this.f.d(i);
                i.setRequest(null);
                return true;
            }
            return false;
        }
    }
    
    private static class b extends d<View, Object>
    {
        b(final View view) {
            super(view);
        }
        
        @Override
        protected void d(final Drawable drawable) {
        }
        
        @Override
        public void onLoadFailed(final Drawable drawable) {
        }
        
        @Override
        public void onResourceReady(final Object o, final t2.d<? super Object> d) {
        }
    }
    
    private class c implements a
    {
        private final r a;
        final i b;
        
        c(final i b, final r a) {
            this.b = b;
            this.a = a;
        }
        
        @Override
        public void a(final boolean b) {
            if (b) {
                synchronized (this.b) {
                    this.a.e();
                }
            }
        }
    }
}
