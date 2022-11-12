// 
// Decompiled by Procyon v0.6.0
// 

package r2;

import java.util.List;
import androidx.collection.a;
import v2.j;
import java.util.concurrent.atomic.AtomicReference;

public class d
{
    private final AtomicReference<j> a;
    private final a<j, List<Class<?>>> b;
    
    public d() {
        this.a = new AtomicReference<j>();
        this.b = new a<j, List<Class<?>>>();
    }
    
    public List<Class<?>> a(final Class<?> clazz, final Class<?> clazz2, final Class<?> clazz3) {
        final j j = this.a.getAndSet(null);
        j i;
        if (j == null) {
            i = new j(clazz, clazz2, clazz3);
        }
        else {
            j.a(clazz, clazz2, clazz3);
            i = j;
        }
        synchronized (this.b) {
            final List list = this.b.get(i);
            monitorexit(this.b);
            this.a.set(i);
            return list;
        }
    }
    
    public void b(final Class<?> clazz, final Class<?> clazz2, final Class<?> clazz3, final List<Class<?>> list) {
        synchronized (this.b) {
            this.b.put(new j(clazz, clazz2, clazz3), list);
        }
    }
}
