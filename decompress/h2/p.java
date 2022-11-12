// 
// Decompiled by Procyon v0.6.0
// 

package h2;

import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList;
import com.bumptech.glide.Registry;
import java.util.Collections;
import java.util.List;
import androidx.core.util.e;

public class p
{
    private final r a;
    private final a b;
    
    public p(final e<List<Throwable>> e) {
        this(new r(e));
    }
    
    private p(final r a) {
        this.b = new a();
        this.a = a;
    }
    
    private static <A> Class<A> b(final A a) {
        return (Class<A>)a.getClass();
    }
    
    private <A> List<n<A, ?>> e(final Class<A> clazz) {
        synchronized (this) {
            Object o;
            if ((o = this.b.b(clazz)) == null) {
                o = Collections.unmodifiableList((List<? extends n<A, ?>>)this.a.e(clazz));
                this.b.c(clazz, (List<n<A, ?>>)o);
            }
            return (List<n<A, ?>>)o;
        }
    }
    
    public <Model, Data> void a(final Class<Model> clazz, final Class<Data> clazz2, final o<? extends Model, ? extends Data> o) {
        synchronized (this) {
            this.a.b(clazz, clazz2, o);
            this.b.a();
        }
    }
    
    public List<Class<?>> c(final Class<?> clazz) {
        synchronized (this) {
            return this.a.g(clazz);
        }
    }
    
    public <A> List<n<A, ?>> d(final A a) {
        final List<n<Object, ?>> e = this.e((Class<Object>)b((A)a));
        if (e.isEmpty()) {
            throw new Registry.NoModelLoaderAvailableException(a);
        }
        final int size = e.size();
        Object emptyList = Collections.emptyList();
        int n = 1;
        Object o;
        int n3;
        for (int i = 0; i < size; ++i, emptyList = o, n = n3) {
            final n n2 = e.get(i);
            o = emptyList;
            n3 = n;
            if (n2.a(a)) {
                if ((n3 = n) != 0) {
                    emptyList = new ArrayList<n>(size - i);
                    n3 = 0;
                }
                ((List<n>)emptyList).add(n2);
                o = emptyList;
            }
        }
        if (!((List)emptyList).isEmpty()) {
            return (List<n<A, ?>>)emptyList;
        }
        throw new Registry.NoModelLoaderAvailableException((M)a, (List<n<M, ?>>)e);
    }
    
    private static class a
    {
        private final Map<Class<?>, p.a.a<?>> a;
        
        a() {
            this.a = new HashMap<Class<?>, p.a.a<?>>();
        }
        
        public void a() {
            this.a.clear();
        }
        
        public <Model> List<n<Model, ?>> b(final Class<Model> clazz) {
            final p.a.a a = this.a.get(clazz);
            Object a2;
            if (a == null) {
                a2 = null;
            }
            else {
                a2 = a.a;
            }
            return (List<n<Model, ?>>)a2;
        }
        
        public <Model> void c(final Class<Model> clazz, final List<n<Model, ?>> list) {
            if (this.a.put(clazz, new p.a.a<Object>((List<n<Object, ?>>)list)) == null) {
                return;
            }
            final StringBuilder sb = new StringBuilder();
            sb.append("Already cached loaders for model: ");
            sb.append(clazz);
            throw new IllegalStateException(sb.toString());
        }
        
        private static class a<Model>
        {
            final List<n<Model, ?>> a;
            
            public a(final List<n<Model, ?>> a) {
                this.a = a;
            }
        }
    }
}
