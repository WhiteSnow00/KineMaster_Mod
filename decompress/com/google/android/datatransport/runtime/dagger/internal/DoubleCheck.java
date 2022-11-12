// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.datatransport.runtime.dagger.internal;

import com.google.android.datatransport.runtime.dagger.Lazy;
import javax.inject.Provider;

public final class DoubleCheck<T> implements Provider<T>, Lazy<T>
{
    private static final Object c;
    private volatile Provider<T> a;
    private volatile Object b;
    
    static {
        c = new Object();
    }
    
    private DoubleCheck(final Provider<T> a) {
        this.b = DoubleCheck.c;
        this.a = a;
    }
    
    public static <P extends Provider<T>, T> Lazy<T> a(final P p) {
        if (p instanceof Lazy) {
            return (Lazy)p;
        }
        return new DoubleCheck<T>(Preconditions.b(p));
    }
    
    public static <P extends Provider<T>, T> Provider<T> b(final P p) {
        Preconditions.b(p);
        if (p instanceof DoubleCheck) {
            return p;
        }
        return (Provider<T>)new DoubleCheck((javax.inject.Provider<Object>)p);
    }
    
    public static Object c(final Object o, final Object o2) {
        if (o != DoubleCheck.c && !(o instanceof MemoizedSentinel) && o != o2) {
            final StringBuilder sb = new StringBuilder();
            sb.append("Scoped provider was invoked recursively returning different results: ");
            sb.append(o);
            sb.append(" & ");
            sb.append(o2);
            sb.append(". This is likely due to a circular dependency.");
            throw new IllegalStateException(sb.toString());
        }
        return o2;
    }
    
    public T get() {
        final Object b = this.b;
        final Object c = DoubleCheck.c;
        final T t = (T)b;
        if (b == c) {
            synchronized (this) {
                if (this.b == c) {
                    this.b = c(this.b, this.a.get());
                    this.a = null;
                }
            }
        }
        return t;
    }
}
