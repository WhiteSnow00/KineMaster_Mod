// 
// Decompiled by Procyon v0.6.0
// 

package d3;

import android.util.Property;

public abstract class c<T> extends Property<T, Integer>
{
    public c(final String s) {
        super((Class)Integer.class, s);
    }
    
    public final void a(final T t, final Integer n) {
        this.b(t, n);
    }
    
    public abstract void b(final T p0, final int p1);
    
    public /* bridge */ void set(final Object o, final Object o2) {
        this.a(o, (Integer)o2);
    }
}
