// 
// Decompiled by Procyon v0.6.0
// 

package androidx.core.util;

public class f<T> implements e<T>
{
    private final Object[] a;
    private int b;
    
    public f(final int n) {
        if (n > 0) {
            this.a = new Object[n];
            return;
        }
        throw new IllegalArgumentException("The max pool size must be > 0");
    }
    
    private boolean c(final T t) {
        for (int i = 0; i < this.b; ++i) {
            if (this.a[i] == t) {
                return true;
            }
        }
        return false;
    }
    
    @Override
    public T a() {
        final int b = this.b;
        if (b > 0) {
            final int n = b - 1;
            final Object[] a = this.a;
            final Object o = a[n];
            a[n] = null;
            this.b = b - 1;
            return (T)o;
        }
        return null;
    }
    
    @Override
    public boolean b(final T t) {
        if (this.c(t)) {
            throw new IllegalStateException("Already in the pool!");
        }
        final int b = this.b;
        final Object[] a = this.a;
        if (b < a.length) {
            a[b] = t;
            this.b = b + 1;
            return true;
        }
        return false;
    }
}
