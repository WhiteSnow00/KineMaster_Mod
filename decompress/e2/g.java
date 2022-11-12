// 
// Decompiled by Procyon v0.6.0
// 

package e2;

import java.util.ArrayList;
import java.util.List;
import java.util.HashMap;
import java.util.Map;

class g<K extends l, V>
{
    private final a<K, V> a;
    private final Map<K, a<K, V>> b;
    
    g() {
        this.a = new a<K, V>();
        this.b = new HashMap<K, a<K, V>>();
    }
    
    private void b(final a<K, V> a) {
        e(a);
        final a<K, V> a2 = this.a;
        a.d = a2;
        a.c = a2.c;
        g(a);
    }
    
    private void c(final a<K, V> a) {
        e(a);
        final a<K, V> a2 = this.a;
        a.d = a2.d;
        a.c = a2;
        g(a);
    }
    
    private static <K, V> void e(final a<K, V> a) {
        final a<K, V> d = a.d;
        d.c = a.c;
        a.c.d = d;
    }
    
    private static <K, V> void g(final a<K, V> a) {
        a.c.d = a;
        a.d.c = a;
    }
    
    public V a(final K k) {
        final a a = this.b.get(k);
        a a3;
        if (a == null) {
            final a a2 = new a((K)k);
            this.b.put(k, a2);
            a3 = a2;
        }
        else {
            k.a();
            a3 = a;
        }
        this.b(a3);
        return (V)a3.b();
    }
    
    public void d(final K k, final V v) {
        final a a = this.b.get(k);
        a a3;
        if (a == null) {
            final a a2 = new a((K)k);
            this.c(a2);
            this.b.put(k, a2);
            a3 = a2;
        }
        else {
            k.a();
            a3 = a;
        }
        a3.a(v);
    }
    
    public V f() {
        for (a<K, V> a = this.a.d; !a.equals(this.a); a = a.d) {
            final V b = a.b();
            if (b != null) {
                return b;
            }
            e((a<Object, Object>)a);
            this.b.remove(a.a);
            a.a.a();
        }
        return null;
    }
    
    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("GroupedLinkedMap( ");
        a<K, V> a = this.a.c;
        boolean b = false;
        while (!a.equals(this.a)) {
            b = true;
            sb.append('{');
            sb.append(a.a);
            sb.append(':');
            sb.append(a.c());
            sb.append("}, ");
            a = a.c;
        }
        if (b) {
            sb.delete(sb.length() - 2, sb.length());
        }
        sb.append(" )");
        return sb.toString();
    }
    
    private static class a<K, V>
    {
        final K a;
        private List<V> b;
        a<K, V> c;
        a<K, V> d;
        
        a() {
            this(null);
        }
        
        a(final K a) {
            this.d = this;
            this.c = this;
            this.a = a;
        }
        
        public void a(final V v) {
            if (this.b == null) {
                this.b = new ArrayList<V>();
            }
            this.b.add(v);
        }
        
        public V b() {
            final int c = this.c();
            V remove;
            if (c > 0) {
                remove = this.b.remove(c - 1);
            }
            else {
                remove = null;
            }
            return remove;
        }
        
        public int c() {
            final List<V> b = this.b;
            int size;
            if (b != null) {
                size = b.size();
            }
            else {
                size = 0;
            }
            return size;
        }
    }
}
