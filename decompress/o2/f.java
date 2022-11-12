// 
// Decompiled by Procyon v0.6.0
// 

package o2;

import java.util.Iterator;
import java.util.ArrayList;
import java.util.List;

public class f
{
    private final List<a<?, ?>> a;
    
    public f() {
        this.a = new ArrayList<a<?, ?>>();
    }
    
    public <Z, R> e<Z, R> a(final Class<Z> clazz, final Class<R> clazz2) {
        synchronized (this) {
            if (clazz2.isAssignableFrom(clazz)) {
                return (e<Z, R>)g.b();
            }
            for (final a a : this.a) {
                if (a.a(clazz, clazz2)) {
                    return (e<Z, R>)a.c;
                }
            }
            final StringBuilder sb = new StringBuilder();
            sb.append("No transcoder registered to transcode from ");
            sb.append(clazz);
            sb.append(" to ");
            sb.append(clazz2);
            throw new IllegalArgumentException(sb.toString());
        }
    }
    
    public <Z, R> List<Class<R>> b(final Class<Z> clazz, final Class<R> clazz2) {
        synchronized (this) {
            final ArrayList list = new ArrayList();
            if (clazz2.isAssignableFrom(clazz)) {
                list.add(clazz2);
                return list;
            }
            for (final a a : this.a) {
                if (a.a(clazz, clazz2) && !list.contains(a.b)) {
                    list.add(a.b);
                }
            }
            return list;
        }
    }
    
    public <Z, R> void c(final Class<Z> clazz, final Class<R> clazz2, final e<Z, R> e) {
        synchronized (this) {
            this.a.add(new a<Object, Object>((Class<Object>)clazz, (Class<Object>)clazz2, (e<Object, Object>)e));
        }
    }
    
    private static final class a<Z, R>
    {
        final Class<Z> a;
        final Class<R> b;
        final e<Z, R> c;
        
        a(final Class<Z> a, final Class<R> b, final e<Z, R> c) {
            this.a = a;
            this.b = b;
            this.c = c;
        }
        
        public boolean a(final Class<?> clazz, final Class<?> clazz2) {
            return this.a.isAssignableFrom(clazz) && clazz2.isAssignableFrom(this.b);
        }
    }
}
