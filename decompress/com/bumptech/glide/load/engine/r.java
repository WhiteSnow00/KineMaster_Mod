// 
// Decompiled by Procyon v0.6.0
// 

package com.bumptech.glide.load.engine;

import v2.k;
import w2.c;
import androidx.core.util.e;
import w2.a;

final class r<Z> implements s<Z>, f
{
    private static final androidx.core.util.e<r<?>> e;
    private final c a;
    private s<Z> b;
    private boolean c;
    private boolean d;
    
    static {
        e = w2.a.d(20, (a.d<r<?>>)new d<r<?>>() {
            @Override
            public /* bridge */ Object a() {
                return this.b();
            }
            
            public r<?> b() {
                return new r<Object>();
            }
        });
    }
    
    r() {
        this.a = w2.c.a();
    }
    
    private void e(final s<Z> b) {
        this.d = false;
        this.c = true;
        this.b = b;
    }
    
    static <Z> r<Z> f(final s<Z> s) {
        final r r = k.d(com.bumptech.glide.load.engine.r.e.a());
        r.e(s);
        return r;
    }
    
    private void g() {
        this.b = null;
        r.e.b(this);
    }
    
    @Override
    public int a() {
        return this.b.a();
    }
    
    @Override
    public void b() {
        synchronized (this) {
            this.a.c();
            this.d = true;
            if (!this.c) {
                this.b.b();
                this.g();
            }
        }
    }
    
    @Override
    public Class<Z> c() {
        return this.b.c();
    }
    
    @Override
    public c d() {
        return this.a;
    }
    
    @Override
    public Z get() {
        return this.b.get();
    }
    
    void h() {
        synchronized (this) {
            this.a.c();
            if (this.c) {
                this.c = false;
                if (this.d) {
                    this.b();
                }
                return;
            }
            throw new IllegalStateException("Already unlocked");
        }
    }
}
