// 
// Decompiled by Procyon v0.6.0
// 

package v2;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

public class h<T, Y>
{
    private final Map<T, a<Y>> a;
    private final long b;
    private long c;
    private long d;
    
    public h(final long n) {
        this.a = new LinkedHashMap<T, a<Y>>(100, 0.75f, true);
        this.b = n;
        this.c = n;
    }
    
    private void f() {
        this.m(this.c);
    }
    
    public void b() {
        this.m(0L);
    }
    
    public Y g(final T t) {
        synchronized (this) {
            final a a = this.a.get(t);
            Object a2;
            if (a != null) {
                a2 = a.a;
            }
            else {
                a2 = null;
            }
            return (Y)a2;
        }
    }
    
    public long h() {
        synchronized (this) {
            return this.c;
        }
    }
    
    protected int i(final Y y) {
        return 1;
    }
    
    protected void j(final T t, final Y y) {
    }
    
    public Y k(final T t, final Y y) {
        synchronized (this) {
            final int i = this.i(y);
            final long n = i;
            final long c = this.c;
            final Y y2 = null;
            if (n >= c) {
                this.j(t, y);
                return null;
            }
            if (y != null) {
                this.d += n;
            }
            final Map<T, a<Y>> a = this.a;
            a a2;
            if (y == null) {
                a2 = null;
            }
            else {
                a2 = new a(y, i);
            }
            final a a3 = a.put(t, a2);
            if (a3 != null) {
                this.d -= a3.b;
                if (!a3.a.equals(y)) {
                    this.j(t, a3.a);
                }
            }
            this.f();
            Object a4 = y2;
            if (a3 != null) {
                a4 = a3.a;
            }
            return (Y)a4;
        }
    }
    
    public Y l(final T t) {
        synchronized (this) {
            final a a = this.a.remove(t);
            if (a == null) {
                return null;
            }
            this.d -= a.b;
            return (Y)a.a;
        }
    }
    
    protected void m(final long n) {
        synchronized (this) {
            while (this.d > n) {
                final Iterator<Map.Entry<T, a<Y>>> iterator = this.a.entrySet().iterator();
                final Map.Entry<K, a> entry = (Map.Entry<K, a>)iterator.next();
                final a a = entry.getValue();
                this.d -= a.b;
                final K key = entry.getKey();
                iterator.remove();
                this.j((T)key, a.a);
            }
        }
    }
    
    static final class a<Y>
    {
        final Y a;
        final int b;
        
        a(final Y a, final int b) {
            this.a = a;
            this.b = b;
        }
    }
}
