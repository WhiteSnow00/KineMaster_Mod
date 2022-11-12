// 
// Decompiled by Procyon v0.6.0
// 

package r2;

import java.util.Collection;
import java.util.Iterator;
import c2.f;
import java.util.HashMap;
import java.util.ArrayList;
import java.util.Map;
import java.util.List;

public class e
{
    private final List<String> a;
    private final Map<String, List<a<?, ?>>> b;
    
    public e() {
        this.a = new ArrayList<String>();
        this.b = new HashMap<String, List<a<?, ?>>>();
    }
    
    private List<a<?, ?>> c(final String s) {
        synchronized (this) {
            if (!this.a.contains(s)) {
                this.a.add(s);
            }
            List list;
            if ((list = this.b.get(s)) == null) {
                list = new ArrayList();
                this.b.put(s, list);
            }
            return list;
        }
    }
    
    public <T, R> void a(final String s, final f<T, R> f, final Class<T> clazz, final Class<R> clazz2) {
        synchronized (this) {
            this.c(s).add(new a<Object, Object>((Class<Object>)clazz, (Class<Object>)clazz2, (f<Object, Object>)f));
        }
    }
    
    public <T, R> List<f<T, R>> b(final Class<T> clazz, final Class<R> clazz2) {
        synchronized (this) {
            final ArrayList list = new ArrayList();
            final Iterator<String> iterator = this.a.iterator();
            while (iterator.hasNext()) {
                final List list2 = this.b.get(iterator.next());
                if (list2 == null) {
                    continue;
                }
                for (final a a : list2) {
                    if (a.a(clazz, clazz2)) {
                        list.add(a.c);
                    }
                }
            }
            return list;
        }
    }
    
    public <T, R> List<Class<R>> d(final Class<T> clazz, final Class<R> clazz2) {
        synchronized (this) {
            final ArrayList list = new ArrayList();
            final Iterator<String> iterator = this.a.iterator();
            while (iterator.hasNext()) {
                final List list2 = this.b.get(iterator.next());
                if (list2 == null) {
                    continue;
                }
                for (final a a : list2) {
                    if (a.a(clazz, clazz2) && !list.contains(a.b)) {
                        list.add(a.b);
                    }
                }
            }
            return list;
        }
    }
    
    public void e(final List<String> list) {
        synchronized (this) {
            final ArrayList list2 = new ArrayList(this.a);
            this.a.clear();
            final Iterator<String> iterator = list.iterator();
            while (iterator.hasNext()) {
                this.a.add(iterator.next());
            }
            for (final String s : list2) {
                if (!list.contains(s)) {
                    this.a.add(s);
                }
            }
        }
    }
    
    private static class a<T, R>
    {
        private final Class<T> a;
        final Class<R> b;
        final f<T, R> c;
        
        public a(final Class<T> a, final Class<R> b, final f<T, R> c) {
            this.a = a;
            this.b = b;
            this.c = c;
        }
        
        public boolean a(final Class<?> clazz, final Class<?> clazz2) {
            return this.a.isAssignableFrom(clazz) && clazz2.isAssignableFrom(this.b);
        }
    }
}
