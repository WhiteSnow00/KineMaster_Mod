// 
// Decompiled by Procyon v0.6.0
// 

package r2;

import java.util.List;
import o2.e;
import o2.g;
import java.util.Collections;
import java.util.concurrent.atomic.AtomicReference;
import v2.j;
import androidx.collection.a;
import com.bumptech.glide.load.engine.q;

public class c
{
    private static final q<?, ?, ?> c;
    private final a<j, q<?, ?, ?>> a;
    private final AtomicReference<j> b;
    
    static {
        c = new q<Object, Object, Object>(Object.class, Object.class, Object.class, Collections.singletonList((com.bumptech.glide.load.engine.g<?, ?, ?>)new com.bumptech.glide.load.engine.g<Object, Object, Object>(Object.class, Object.class, Object.class, Collections.emptyList(), new g<Object>(), null)), null);
    }
    
    public c() {
        this.a = new a<j, q<?, ?, ?>>();
        this.b = new AtomicReference<j>();
    }
    
    private j b(final Class<?> clazz, final Class<?> clazz2, final Class<?> clazz3) {
        j j;
        if ((j = this.b.getAndSet(null)) == null) {
            j = new j();
        }
        j.a(clazz, clazz2, clazz3);
        return j;
    }
    
    public <Data, TResource, Transcode> q<Data, TResource, Transcode> a(final Class<Data> clazz, final Class<TResource> clazz2, final Class<Transcode> clazz3) {
        final j b = this.b(clazz, clazz2, clazz3);
        synchronized (this.a) {
            final q q = this.a.get(b);
            monitorexit(this.a);
            this.b.set(b);
            return q;
        }
    }
    
    public boolean c(final q<?, ?, ?> q) {
        return r2.c.c.equals(q);
    }
    
    public void d(final Class<?> clazz, final Class<?> clazz2, final Class<?> clazz3, q<?, ?, ?> c) {
        synchronized (this.a) {
            final a<j, q<?, ?, ?>> a = this.a;
            final j j = new j(clazz, clazz2, clazz3);
            if (c == null) {
                c = c.c;
            }
            a.put(j, c);
        }
    }
}
