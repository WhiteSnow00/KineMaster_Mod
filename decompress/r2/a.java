// 
// Decompiled by Procyon v0.6.0
// 

package r2;

import java.util.Iterator;
import java.util.ArrayList;
import java.util.List;

public class a
{
    private final List<a<?>> a;
    
    public a() {
        this.a = new ArrayList<a<?>>();
    }
    
    public <T> void a(final Class<T> clazz, final a<T> a) {
        synchronized (this) {
            this.a.add(new a<Object>((Class<Object>)clazz, (a<Object>)a));
        }
    }
    
    public <T> a<T> b(final Class<T> clazz) {
        synchronized (this) {
            for (final a a : this.a) {
                if (a.a(clazz)) {
                    return (a<T>)a.b;
                }
            }
            return null;
        }
    }
    
    private static final class a<T>
    {
        private final Class<T> a;
        final c2.a<T> b;
        
        a(final Class<T> a, final c2.a<T> b) {
            this.a = a;
            this.b = b;
        }
        
        boolean a(final Class<?> clazz) {
            return this.a.isAssignableFrom(clazz);
        }
    }
}
