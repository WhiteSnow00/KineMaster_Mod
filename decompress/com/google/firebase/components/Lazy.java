// 
// Decompiled by Procyon v0.6.0
// 

package com.google.firebase.components;

import com.google.firebase.inject.Provider;

public class Lazy<T> implements Provider<T>
{
    private static final Object c;
    private volatile Object a;
    private volatile Provider<T> b;
    
    static {
        c = new Object();
    }
    
    public Lazy(final Provider<T> b) {
        this.a = Lazy.c;
        this.b = b;
    }
    
    public T get() {
        final Object a = this.a;
        final Object c = Lazy.c;
        final T t = (T)a;
        if (a == c) {
            synchronized (this) {
                if (this.a == c) {
                    this.a = this.b.get();
                    this.b = null;
                }
            }
        }
        return t;
    }
}
