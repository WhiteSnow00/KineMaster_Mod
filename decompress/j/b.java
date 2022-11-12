// 
// Decompiled by Procyon v0.6.0
// 

package j;

import java.util.Iterator;
import java.util.WeakHashMap;
import java.util.Map;

public class b<K, V> implements Iterable<Map.Entry<K, V>>
{
    c<K, V> a;
    private c<K, V> b;
    private WeakHashMap<f<K, V>, Boolean> c;
    private int d;
    
    public b() {
        this.c = new WeakHashMap<f<K, V>, Boolean>();
        this.d = 0;
    }
    
    public Map.Entry<K, V> a() {
        return this.a;
    }
    
    protected c<K, V> b(final K k) {
        c<K, V> c;
        for (c = this.a; c != null && !c.a.equals(k); c = c.c) {}
        return c;
    }
    
    public Iterator<Map.Entry<K, V>> descendingIterator() {
        final b b = new b<K, V>(this.b, this.a);
        this.c.put((f<K, V>)b, Boolean.FALSE);
        return (Iterator<Map.Entry<K, V>>)b;
    }
    
    public d e() {
        final d d = new d();
        this.c.put((f<K, V>)d, Boolean.FALSE);
        return d;
    }
    
    @Override
    public boolean equals(final Object o) {
        boolean b = true;
        if (o == this) {
            return true;
        }
        if (!(o instanceof b)) {
            return false;
        }
        final b b2 = (b)o;
        if (this.size() != b2.size()) {
            return false;
        }
        final Iterator<Map.Entry<K, V>> iterator = this.iterator();
        final Iterator iterator2 = b2.iterator();
        while (iterator.hasNext() && iterator2.hasNext()) {
            final Map.Entry entry = iterator.next();
            final Object next = iterator2.next();
            if ((entry == null && next != null) || (entry != null && !entry.equals(next))) {
                return false;
            }
        }
        if (iterator.hasNext() || iterator2.hasNext()) {
            b = false;
        }
        return b;
    }
    
    public Map.Entry<K, V> f() {
        return this.b;
    }
    
    protected c<K, V> g(final K k, final V v) {
        final c c = new c((K)k, (V)v);
        ++this.d;
        final c<K, V> b = this.b;
        if (b == null) {
            this.a = c;
            return this.b = c;
        }
        b.c = c;
        c.d = (c<K, V>)b;
        return this.b = c;
    }
    
    @Override
    public int hashCode() {
        final Iterator<Map.Entry<K, V>> iterator = this.iterator();
        int n = 0;
        while (iterator.hasNext()) {
            n += ((Map.Entry)iterator.next()).hashCode();
        }
        return n;
    }
    
    @Override
    public Iterator<Map.Entry<K, V>> iterator() {
        final a a = new a<K, V>(this.a, this.b);
        this.c.put((f<K, V>)a, Boolean.FALSE);
        return (Iterator<Map.Entry<K, V>>)a;
    }
    
    public V k(final K k, final V v) {
        final c<K, V> b = this.b(k);
        if (b != null) {
            return b.b;
        }
        this.g(k, v);
        return null;
    }
    
    public V m(final K k) {
        final c<K, V> b = this.b(k);
        if (b == null) {
            return null;
        }
        --this.d;
        if (!this.c.isEmpty()) {
            final Iterator<f<K, V>> iterator = this.c.keySet().iterator();
            while (iterator.hasNext()) {
                iterator.next().b((c)b);
            }
        }
        final c<K, V> d = (c<K, V>)b.d;
        if (d != null) {
            d.c = (c<K, V>)b.c;
        }
        else {
            this.a = b.c;
        }
        final c<K, V> c = (c<K, V>)b.c;
        if (c != null) {
            c.d = d;
        }
        else {
            this.b = (c<K, V>)d;
        }
        b.c = null;
        b.d = null;
        return b.b;
    }
    
    public int size() {
        return this.d;
    }
    
    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append("[");
        final Iterator<Map.Entry<K, V>> iterator = this.iterator();
        while (iterator.hasNext()) {
            sb.append(((Map.Entry<?, ?>)iterator.next()).toString());
            if (iterator.hasNext()) {
                sb.append(", ");
            }
        }
        sb.append("]");
        return sb.toString();
    }
    
    static class a<K, V> extends e<K, V>
    {
        a(final c<K, V> c, final c<K, V> c2) {
            super(c, c2);
        }
        
        @Override
        c<K, V> c(final c<K, V> c) {
            return c.d;
        }
        
        @Override
        c<K, V> d(final c<K, V> c) {
            return c.c;
        }
    }
    
    private abstract static class e<K, V> implements Iterator<Map.Entry<K, V>>, f<K, V>
    {
        c<K, V> a;
        c<K, V> b;
        
        e(final c<K, V> b, final c<K, V> a) {
            this.a = a;
            this.b = b;
        }
        
        private c<K, V> f() {
            final c<K, V> b = this.b;
            final c<K, V> a = this.a;
            if (b != a && a != null) {
                return this.d(b);
            }
            return null;
        }
        
        @Override
        public void b(final c<K, V> c) {
            if (this.a == c && c == this.b) {
                this.b = null;
                this.a = null;
            }
            final c<K, V> a = this.a;
            if (a == c) {
                this.a = this.c(a);
            }
            if (this.b == c) {
                this.b = this.f();
            }
        }
        
        abstract c<K, V> c(final c<K, V> p0);
        
        abstract c<K, V> d(final c<K, V> p0);
        
        public Map.Entry<K, V> e() {
            final c<K, V> b = this.b;
            this.b = this.f();
            return b;
        }
        
        @Override
        public boolean hasNext() {
            return this.b != null;
        }
        
        @Override
        public /* bridge */ Object next() {
            return this.e();
        }
    }
    
    interface f<K, V>
    {
        void b(final c<K, V> p0);
    }
    
    private static class b<K, V> extends e<K, V>
    {
        b(final c<K, V> c, final c<K, V> c2) {
            super(c, c2);
        }
        
        @Override
        c<K, V> c(final c<K, V> c) {
            return c.c;
        }
        
        @Override
        c<K, V> d(final c<K, V> c) {
            return c.d;
        }
    }
    
    static class c<K, V> implements Entry<K, V>
    {
        final K a;
        final V b;
        c<K, V> c;
        c<K, V> d;
        
        c(final K a, final V b) {
            this.a = a;
            this.b = b;
        }
        
        @Override
        public boolean equals(final Object o) {
            boolean b = true;
            if (o == this) {
                return true;
            }
            if (!(o instanceof c)) {
                return false;
            }
            final c c = (c)o;
            if (!this.a.equals(c.a) || !this.b.equals(c.b)) {
                b = false;
            }
            return b;
        }
        
        @Override
        public K getKey() {
            return this.a;
        }
        
        @Override
        public V getValue() {
            return this.b;
        }
        
        @Override
        public int hashCode() {
            return this.a.hashCode() ^ this.b.hashCode();
        }
        
        @Override
        public V setValue(final V v) {
            throw new UnsupportedOperationException("An entry modification is not supported");
        }
        
        @Override
        public String toString() {
            final StringBuilder sb = new StringBuilder();
            sb.append(this.a);
            sb.append("=");
            sb.append(this.b);
            return sb.toString();
        }
    }
    
    private class d implements Iterator<Map.Entry<K, V>>, f<K, V>
    {
        private c<K, V> a;
        private boolean b;
        final b c;
        
        d(final b c) {
            this.c = c;
            this.b = true;
        }
        
        @Override
        public void b(final c<K, V> c) {
            final c<K, V> a = this.a;
            if (c == a) {
                final c<K, V> d = a.d;
                this.a = d;
                this.b = (d == null);
            }
        }
        
        public Map.Entry<K, V> c() {
            if (this.b) {
                this.b = false;
                this.a = this.c.a;
            }
            else {
                final c<K, V> a = this.a;
                c<K, V> c;
                if (a != null) {
                    c = a.c;
                }
                else {
                    c = null;
                }
                this.a = c;
            }
            return this.a;
        }
        
        @Override
        public boolean hasNext() {
            final boolean b = this.b;
            final boolean b2 = true;
            boolean b3 = true;
            if (b) {
                if (this.c.a == null) {
                    b3 = false;
                }
                return b3;
            }
            final c<K, V> a = this.a;
            return a != null && a.c != null && b2;
        }
        
        @Override
        public /* bridge */ Object next() {
            return this.c();
        }
    }
}
