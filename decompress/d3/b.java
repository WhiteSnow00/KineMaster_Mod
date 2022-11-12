// 
// Decompiled by Procyon v0.6.0
// 

package d3;

import android.util.Property;

public abstract class b<T> extends Property<T, Float>
{
    public b(final String s) {
        super((Class)Float.class, s);
    }
    
    public final void a(final T t, final Float n) {
        this.b(t, n);
    }
    
    public abstract void b(final T p0, final float p1);
    
    public /* bridge */ void set(final Object o, final Object o2) {
        this.a(o, (Float)o2);
    }
}
