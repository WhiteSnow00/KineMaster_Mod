// 
// Decompiled by Procyon v0.6.0
// 

package androidx.core.util;

public class g<T> extends f<T>
{
    private final Object c;
    
    public g(final int n) {
        super(n);
        this.c = new Object();
    }
    
    @Override
    public T a() {
        synchronized (this.c) {
            return super.a();
        }
    }
    
    @Override
    public boolean b(final T t) {
        synchronized (this.c) {
            return super.b(t);
        }
    }
}
