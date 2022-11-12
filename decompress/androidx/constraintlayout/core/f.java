// 
// Decompiled by Procyon v0.6.0
// 

package androidx.constraintlayout.core;

class f<T> implements e<T>
{
    private final Object[] a;
    private int b;
    
    f(final int n) {
        if (n > 0) {
            this.a = new Object[n];
            return;
        }
        throw new IllegalArgumentException("The max pool size must be > 0");
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
        final int b = this.b;
        final Object[] a = this.a;
        if (b < a.length) {
            a[b] = t;
            this.b = b + 1;
            return true;
        }
        return false;
    }
    
    @Override
    public void c(final T[] array, int i) {
        int length = i;
        if (i > array.length) {
            length = array.length;
        }
        T t;
        int b;
        Object[] a;
        for (i = 0; i < length; ++i) {
            t = array[i];
            b = this.b;
            a = this.a;
            if (b < a.length) {
                a[b] = t;
                this.b = b + 1;
            }
        }
    }
}
