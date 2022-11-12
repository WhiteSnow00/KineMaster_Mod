// 
// Decompiled by Procyon v0.6.0
// 

package h2;

import java.util.Iterator;
import com.bumptech.glide.Registry;
import v2.k;
import java.util.HashSet;
import java.util.ArrayList;
import androidx.core.util.e;
import java.util.Set;
import java.util.List;

public class r
{
    private static final c e;
    private static final n<Object, Object> f;
    private final List<b<?, ?>> a;
    private final c b;
    private final Set<b<?, ?>> c;
    private final e<List<Throwable>> d;
    
    static {
        e = new c();
        f = new a();
    }
    
    public r(final e<List<Throwable>> e) {
        this(e, r.e);
    }
    
    r(final e<List<Throwable>> d, final c b) {
        this.a = new ArrayList<b<?, ?>>();
        this.c = new HashSet<b<?, ?>>();
        this.d = d;
        this.b = b;
    }
    
    private <Model, Data> void a(final Class<Model> clazz, final Class<Data> clazz2, final o<? extends Model, ? extends Data> o, final boolean b) {
        final b b2 = new b((Class<Model>)clazz, (Class<Data>)clazz2, (o<? extends Model, ? extends Data>)o);
        final List<b<?, ?>> a = this.a;
        int size;
        if (b) {
            size = a.size();
        }
        else {
            size = 0;
        }
        a.add(size, b2);
    }
    
    private <Model, Data> n<Model, Data> c(final b<?, ?> b) {
        return k.d(b.c.b(this));
    }
    
    private static <Model, Data> n<Model, Data> f() {
        return (n<Model, Data>)r.f;
    }
    
     <Model, Data> void b(final Class<Model> clazz, final Class<Data> clazz2, final o<? extends Model, ? extends Data> o) {
        synchronized (this) {
            this.a(clazz, clazz2, o, true);
        }
    }
    
    public <Model, Data> n<Model, Data> d(final Class<Model> clazz, final Class<Data> clazz2) {
        monitorenter(this);
        try {
            final ArrayList list = new ArrayList();
            final Iterator<b<?, ?>> iterator = this.a.iterator();
            boolean b = false;
            while (iterator.hasNext()) {
                final b b2 = iterator.next();
                if (this.c.contains(b2)) {
                    b = true;
                }
                else {
                    if (!b2.b(clazz, clazz2)) {
                        continue;
                    }
                    this.c.add(b2);
                    list.add(this.c(b2));
                    this.c.remove(b2);
                }
            }
            if (list.size() > 1) {
                final q<Object, Object> a = this.b.a((List<n<Object, Object>>)list, this.d);
                monitorexit(this);
                return (n<Model, Data>)a;
            }
            if (list.size() == 1) {
                final n n = (n)list.get(0);
                monitorexit(this);
                return n;
            }
            if (b) {
                final n<Object, Object> f = f();
                monitorexit(this);
                return (n<Model, Data>)f;
            }
            throw new Registry.NoModelLoaderAvailableException(clazz, clazz2);
        }
        finally {
            try {
                this.c.clear();
            }
            finally {
                monitorexit(this);
            }
        }
    }
    
     <Model> List<n<Model, ?>> e(final Class<Model> clazz) {
        monitorenter(this);
        try {
            final ArrayList list = new ArrayList();
            for (final b b : this.a) {
                if (this.c.contains(b)) {
                    continue;
                }
                if (!b.a(clazz)) {
                    continue;
                }
                this.c.add(b);
                list.add(this.c(b));
                this.c.remove(b);
            }
            monitorexit(this);
            return list;
        }
        finally {
            try {
                this.c.clear();
            }
            finally {
                monitorexit(this);
            }
        }
    }
    
    List<Class<?>> g(final Class<?> clazz) {
        synchronized (this) {
            final ArrayList list = new ArrayList();
            for (final b b : this.a) {
                if (!list.contains(b.b) && b.a(clazz)) {
                    list.add(b.b);
                }
            }
            return list;
        }
    }
    
    private static class a implements n<Object, Object>
    {
        a() {
        }
        
        @Override
        public boolean a(final Object o) {
            return false;
        }
        
        @Override
        public n.a<Object> b(final Object o, final int n, final int n2, final c2.e e) {
            return null;
        }
    }
    
    private static class b<Model, Data>
    {
        private final Class<Model> a;
        final Class<Data> b;
        final o<? extends Model, ? extends Data> c;
        
        public b(final Class<Model> a, final Class<Data> b, final o<? extends Model, ? extends Data> c) {
            this.a = a;
            this.b = b;
            this.c = c;
        }
        
        public boolean a(final Class<?> clazz) {
            return this.a.isAssignableFrom(clazz);
        }
        
        public boolean b(final Class<?> clazz, final Class<?> clazz2) {
            return this.a(clazz) && this.b.isAssignableFrom(clazz2);
        }
    }
    
    static class c
    {
        public <Model, Data> q<Model, Data> a(final List<n<Model, Data>> list, final e<List<Throwable>> e) {
            return new q<Model, Data>(list, e);
        }
    }
}
