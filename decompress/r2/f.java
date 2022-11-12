// 
// Decompiled by Procyon v0.6.0
// 

package r2;

import c2.g;
import java.util.ArrayList;
import java.util.List;

public class f
{
    private final List<a<?>> a;
    
    public f() {
        this.a = new ArrayList<a<?>>();
    }
    
    public <Z> void a(final Class<Z> clazz, final g<Z> g) {
        synchronized (this) {
            this.a.add(new a<Object>((Class<Object>)clazz, (g<Object>)g));
        }
    }
    
    public <Z> g<Z> b(final Class<Z> clazz) {
        monitorenter(this);
        int i = 0;
        try {
            while (i < this.a.size()) {
                final a a = this.a.get(i);
                if (a.a(clazz)) {
                    return (g<Z>)a.b;
                }
                ++i;
            }
            return null;
        }
        finally {
            monitorexit(this);
        }
    }
    
    private static final class a<T>
    {
        private final Class<T> a;
        final g<T> b;
        
        a(final Class<T> a, final g<T> b) {
            this.a = a;
            this.b = b;
        }
        
        boolean a(final Class<?> clazz) {
            return this.a.isAssignableFrom(clazz);
        }
    }
}
