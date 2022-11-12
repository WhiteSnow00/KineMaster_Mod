// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.datatransport.runtime.dagger.internal;

import javax.inject.Provider;

public final class SingleCheck<T> implements Provider<T>
{
    private static final Object c;
    private volatile Provider<T> a;
    private volatile Object b;
    
    static {
        c = new Object();
    }
    
    public T get() {
        Object b;
        if ((b = this.b) == SingleCheck.c) {
            final Provider<T> a = this.a;
            if (a == null) {
                b = this.b;
            }
            else {
                b = a.get();
                this.b = b;
                this.a = null;
            }
        }
        return (T)b;
    }
}
