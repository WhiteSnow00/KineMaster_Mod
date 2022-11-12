// 
// Decompiled by Procyon v0.6.0
// 

package com.google.firebase.components;

import com.google.firebase.inject.Deferred$DeferredHandler;
import com.google.firebase.inject.Deferred;
import com.google.firebase.inject.Provider;

class q<T> implements Provider<T>, Deferred<T>
{
    private static final Deferred$DeferredHandler<Object> c;
    private static final Provider<Object> d;
    private Deferred$DeferredHandler<T> a;
    private volatile Provider<T> b;
    
    static {
        c = (Deferred$DeferredHandler)o.a;
        d = (Provider)p.a;
    }
    
    private q(final Deferred$DeferredHandler<T> a, final Provider<T> b) {
        this.a = a;
        this.b = b;
    }
    
    public static Object b() {
        return g();
    }
    
    public static void c(final Provider provider) {
        f(provider);
    }
    
    public static void d(final Deferred$DeferredHandler deferred$DeferredHandler, final Deferred$DeferredHandler deferred$DeferredHandler2, final Provider provider) {
        h(deferred$DeferredHandler, deferred$DeferredHandler2, provider);
    }
    
    static <T> q<T> e() {
        return new q<T>((com.google.firebase.inject.Deferred$DeferredHandler<T>)q.c, (com.google.firebase.inject.Provider<T>)q.d);
    }
    
    private static void f(final Provider provider) {
    }
    
    private static Object g() {
        return null;
    }
    
    private static void h(final Deferred$DeferredHandler deferred$DeferredHandler, final Deferred$DeferredHandler deferred$DeferredHandler2, final Provider provider) {
        deferred$DeferredHandler.a(provider);
        deferred$DeferredHandler2.a(provider);
    }
    
    static <T> q<T> i(final Provider<T> provider) {
        return new q<T>(null, provider);
    }
    
    public void a(final Deferred$DeferredHandler<T> deferred$DeferredHandler) {
        final Provider<T> b = this.b;
        final Provider<Object> d = q.d;
        if (b != d) {
            deferred$DeferredHandler.a((Provider)b);
            return;
        }
        Provider<T> provider = null;
        synchronized (this) {
            final Provider<T> b2 = this.b;
            if (b2 != d) {
                provider = b2;
            }
            else {
                this.a = (Deferred$DeferredHandler<T>)new n(this.a, deferred$DeferredHandler);
            }
            monitorexit(this);
            if (provider != null) {
                deferred$DeferredHandler.a((Provider)b2);
            }
        }
    }
    
    public T get() {
        return (T)this.b.get();
    }
    
    void j(final Provider<T> b) {
        if (this.b == q.d) {
            synchronized (this) {
                final Deferred$DeferredHandler<T> a = this.a;
                this.a = null;
                this.b = b;
                monitorexit(this);
                a.a((Provider)b);
                return;
            }
        }
        throw new IllegalStateException("provide() can be called only once.");
    }
}
