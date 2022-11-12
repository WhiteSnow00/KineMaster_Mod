// 
// Decompiled by Procyon v0.6.0
// 

package com.google.crypto.tink.shaded.protobuf;

import java.util.NoSuchElementException;
import java.util.AbstractSet;
import java.util.Set;
import java.util.Iterator;
import java.util.TreeMap;
import java.util.SortedMap;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Map;
import java.util.List;
import java.util.AbstractMap;

class m0<K extends Comparable<K>, V> extends AbstractMap<K, V>
{
    private final int a;
    private List<e> b;
    private Map<K, V> c;
    private boolean d;
    private volatile g e;
    private Map<K, V> f;
    private volatile c g;
    
    private m0(final int a) {
        this.a = a;
        this.b = Collections.emptyList();
        this.c = Collections.emptyMap();
        this.f = Collections.emptyMap();
    }
    
    m0(final int n, final m0$a m0) {
        this(n);
    }
    
    static void a(final m0 m0) {
        m0.g();
    }
    
    static List b(final m0 m0) {
        return m0.b;
    }
    
    static Map c(final m0 m0) {
        return m0.c;
    }
    
    static Object d(final m0 m0, final int n) {
        return m0.s(n);
    }
    
    static Map e(final m0 m0) {
        return m0.f;
    }
    
    private int f(final K k) {
        int n = this.b.size() - 1;
        if (n >= 0) {
            final int compareTo = k.compareTo(this.b.get(n).d());
            if (compareTo > 0) {
                return -(n + 2);
            }
            if (compareTo == 0) {
                return n;
            }
        }
        int i = 0;
        while (i <= n) {
            final int n2 = (i + n) / 2;
            final int compareTo2 = k.compareTo(this.b.get(n2).d());
            if (compareTo2 < 0) {
                n = n2 - 1;
            }
            else {
                if (compareTo2 <= 0) {
                    return n2;
                }
                i = n2 + 1;
            }
        }
        return -(i + 1);
    }
    
    private void g() {
        if (!this.d) {
            return;
        }
        throw new UnsupportedOperationException();
    }
    
    private void i() {
        this.g();
        if (this.b.isEmpty() && !(this.b instanceof ArrayList)) {
            this.b = new ArrayList<e>(this.a);
        }
    }
    
    private SortedMap<K, V> n() {
        this.g();
        if (this.c.isEmpty() && !(this.c instanceof TreeMap)) {
            final TreeMap c = new TreeMap();
            this.c = c;
            final TreeMap treeMap = c;
            this.f = c.descendingMap();
        }
        return (SortedMap)this.c;
    }
    
    static <FieldDescriptorType extends FieldSet.FieldDescriptorLite<FieldDescriptorType>> m0<FieldDescriptorType, Object> q(final int n) {
        return new m0<FieldDescriptorType, Object>(n) {
            @Override
            public void p() {
                if (!this.o()) {
                    for (int i = 0; i < this.k(); ++i) {
                        final Entry<FieldDescriptorType, Object> j = this.j(i);
                        if (((FieldSet.FieldDescriptorLite)j.getKey()).isRepeated()) {
                            j.setValue(Collections.unmodifiableList((List<?>)j.getValue()));
                        }
                    }
                    for (final Map.Entry<FieldSet.FieldDescriptorLite, V> entry : this.m()) {
                        if (entry.getKey().isRepeated()) {
                            entry.setValue((V)Collections.unmodifiableList((List<?>)entry.getValue()));
                        }
                    }
                }
                super.p();
            }
        };
    }
    
    private V s(final int n) {
        this.g();
        final V value = this.b.remove(n).getValue();
        if (!this.c.isEmpty()) {
            final Iterator<Map.Entry<K, V>> iterator = this.n().entrySet().iterator();
            this.b.add(new e(iterator.next()));
            iterator.remove();
        }
        return value;
    }
    
    @Override
    public void clear() {
        this.g();
        if (!this.b.isEmpty()) {
            this.b.clear();
        }
        if (!this.c.isEmpty()) {
            this.c.clear();
        }
    }
    
    @Override
    public boolean containsKey(final Object o) {
        final Comparable comparable = (Comparable)o;
        return this.f((K)comparable) >= 0 || this.c.containsKey(comparable);
    }
    
    @Override
    public Set<Entry<K, V>> entrySet() {
        if (this.e == null) {
            this.e = new g(null);
        }
        return this.e;
    }
    
    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof m0)) {
            return super.equals(o);
        }
        final m0 m0 = (m0)o;
        final int size = this.size();
        if (size != m0.size()) {
            return false;
        }
        final int k = this.k();
        if (k != m0.k()) {
            return this.entrySet().equals(m0.entrySet());
        }
        for (int i = 0; i < k; ++i) {
            if (!this.j(i).equals(m0.j(i))) {
                return false;
            }
        }
        return k == size || this.c.equals(m0.c);
    }
    
    @Override
    public V get(final Object o) {
        final Comparable comparable = (Comparable)o;
        final int f = this.f((K)comparable);
        if (f >= 0) {
            return this.b.get(f).getValue();
        }
        return this.c.get(comparable);
    }
    
    Set<Entry<K, V>> h() {
        if (this.g == null) {
            this.g = new c(null);
        }
        return this.g;
    }
    
    @Override
    public int hashCode() {
        final int k = this.k();
        int i = 0;
        int n = 0;
        while (i < k) {
            n += this.b.get(i).hashCode();
            ++i;
        }
        int n2 = n;
        if (this.l() > 0) {
            n2 = n + this.c.hashCode();
        }
        return n2;
    }
    
    public Entry<K, V> j(final int n) {
        return this.b.get(n);
    }
    
    public int k() {
        return this.b.size();
    }
    
    public int l() {
        return this.c.size();
    }
    
    public Iterable<Entry<K, V>> m() {
        Object o;
        if (this.c.isEmpty()) {
            o = m0.d.b();
        }
        else {
            o = this.c.entrySet();
        }
        return (Iterable<Entry<K, V>>)o;
    }
    
    public boolean o() {
        return this.d;
    }
    
    public void p() {
        if (!this.d) {
            Map<Object, Object> c;
            if (this.c.isEmpty()) {
                c = (Map<Object, Object>)Collections.emptyMap();
            }
            else {
                c = (Map<Object, Object>)Collections.unmodifiableMap((Map<? extends K, ? extends V>)this.c);
            }
            this.c = (Map<K, V>)c;
            Map<Object, Object> f;
            if (this.f.isEmpty()) {
                f = (Map<Object, Object>)Collections.emptyMap();
            }
            else {
                f = (Map<Object, Object>)Collections.unmodifiableMap((Map<? extends K, ? extends V>)this.f);
            }
            this.f = (Map<K, V>)f;
            this.d = true;
        }
    }
    
    @Override
    public /* bridge */ Object put(final Object o, final Object o2) {
        return this.r((K)o, o2);
    }
    
    public V r(final K k, final V value) {
        this.g();
        final int f = this.f(k);
        if (f >= 0) {
            return this.b.get(f).setValue(value);
        }
        this.i();
        final int n = -(f + 1);
        if (n >= this.a) {
            return this.n().put(k, value);
        }
        final int size = this.b.size();
        final int a = this.a;
        if (size == a) {
            final e e = this.b.remove(a - 1);
            this.n().put(e.d(), e.getValue());
        }
        this.b.add(n, new e(k, value));
        return null;
    }
    
    @Override
    public V remove(final Object o) {
        this.g();
        final Comparable comparable = (Comparable)o;
        final int f = this.f((K)comparable);
        if (f >= 0) {
            return this.s(f);
        }
        if (this.c.isEmpty()) {
            return null;
        }
        return this.c.remove(comparable);
    }
    
    @Override
    public int size() {
        return this.b.size() + this.c.size();
    }
    
    private class b implements Iterator<Entry<K, V>>
    {
        private int a;
        private Iterator<Entry<K, V>> b;
        final m0 c;
        
        private b(final m0 c) {
            this.c = c;
            this.a = m0.b(c).size();
        }
        
        b(final m0 m0, final m0$a m2) {
            this(m0);
        }
        
        private Iterator<Entry<K, V>> b() {
            if (this.b == null) {
                this.b = m0.e(this.c).entrySet().iterator();
            }
            return this.b;
        }
        
        public Entry<K, V> c() {
            if (this.b().hasNext()) {
                return this.b().next();
            }
            final List b = m0.b(this.c);
            final int a = this.a - 1;
            this.a = a;
            return (Entry<K, V>)b.get(a);
        }
        
        @Override
        public boolean hasNext() {
            final int a = this.a;
            return (a > 0 && a <= m0.b(this.c).size()) || this.b().hasNext();
        }
        
        @Override
        public /* bridge */ Object next() {
            return this.c();
        }
        
        @Override
        public void remove() {
            throw new UnsupportedOperationException();
        }
    }
    
    private class c extends g
    {
        final m0 b;
        
        private c(final m0 b) {
            this.b = b.super(null);
        }
        
        c(final m0 m0, final m0$a m2) {
            this(m0);
        }
        
        @Override
        public Iterator<Entry<K, V>> iterator() {
            return this.b.new b(null);
        }
    }
    
    private class g extends AbstractSet<Entry<K, V>>
    {
        final m0 a;
        
        private g(final m0 a) {
            this.a = a;
        }
        
        g(final m0 m0, final m0$a m2) {
            this(m0);
        }
        
        public boolean a(final Entry<K, V> entry) {
            if (!this.contains(entry)) {
                this.a.r(entry.getKey(), entry.getValue());
                return true;
            }
            return false;
        }
        
        @Override
        public /* bridge */ boolean add(final Object o) {
            return this.a((Entry<K, V>)o);
        }
        
        @Override
        public void clear() {
            this.a.clear();
        }
        
        @Override
        public boolean contains(Object value) {
            final Entry entry = (Entry)value;
            value = this.a.get(entry.getKey());
            final Object value2 = entry.getValue();
            return value == value2 || (value != null && value.equals(value2));
        }
        
        @Override
        public Iterator<Entry<K, V>> iterator() {
            return this.a.new f(null);
        }
        
        @Override
        public boolean remove(final Object o) {
            final Entry entry = (Entry)o;
            if (this.contains(entry)) {
                this.a.remove(entry.getKey());
                return true;
            }
            return false;
        }
        
        @Override
        public int size() {
            return this.a.size();
        }
    }
    
    private static class d
    {
        private static final Iterator<Object> a;
        private static final Iterable<Object> b;
        
        static {
            a = new Iterator<Object>() {
                @Override
                public boolean hasNext() {
                    return false;
                }
                
                @Override
                public Object next() {
                    throw new NoSuchElementException();
                }
                
                @Override
                public void remove() {
                    throw new UnsupportedOperationException();
                }
            };
            b = new Iterable<Object>() {
                @Override
                public Iterator<Object> iterator() {
                    return d.a();
                }
            };
        }
        
        static Iterator a() {
            return d.a;
        }
        
        static <T> Iterable<T> b() {
            return (Iterable<T>)d.b;
        }
    }
    
    private class e implements Entry<K, V>, Comparable<e>
    {
        private final K a;
        private V b;
        final m0 c;
        
        e(final m0 c, final K a, final V b) {
            this.c = c;
            this.a = a;
            this.b = b;
        }
        
        e(final m0 m0, final Entry<K, V> entry) {
            this(entry.getKey(), entry.getValue());
        }
        
        private boolean c(final Object o, final Object o2) {
            boolean equals;
            if (o == null) {
                equals = (o2 == null);
            }
            else {
                equals = o.equals(o2);
            }
            return equals;
        }
        
        public int a(final e e) {
            return this.d().compareTo(e.d());
        }
        
        @Override
        public /* bridge */ int compareTo(final Object o) {
            return this.a((e)o);
        }
        
        public K d() {
            return this.a;
        }
        
        @Override
        public boolean equals(final Object o) {
            boolean b = true;
            if (o == this) {
                return true;
            }
            if (!(o instanceof Entry)) {
                return false;
            }
            final Entry entry = (Entry)o;
            if (!this.c(this.a, entry.getKey()) || !this.c(this.b, entry.getValue())) {
                b = false;
            }
            return b;
        }
        
        @Override
        public /* bridge */ Object getKey() {
            return this.d();
        }
        
        @Override
        public V getValue() {
            return this.b;
        }
        
        @Override
        public int hashCode() {
            final Comparable<K> a = this.a;
            int hashCode = 0;
            int hashCode2;
            if (a == null) {
                hashCode2 = 0;
            }
            else {
                hashCode2 = a.hashCode();
            }
            final V b = this.b;
            if (b != null) {
                hashCode = b.hashCode();
            }
            return hashCode2 ^ hashCode;
        }
        
        @Override
        public V setValue(final V b) {
            m0.a(this.c);
            final V b2 = this.b;
            this.b = b;
            return b2;
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
    
    private class f implements Iterator<Entry<K, V>>
    {
        private int a;
        private boolean b;
        private Iterator<Entry<K, V>> c;
        final m0 d;
        
        private f(final m0 d) {
            this.d = d;
            this.a = -1;
        }
        
        f(final m0 m0, final m0$a m2) {
            this(m0);
        }
        
        private Iterator<Entry<K, V>> b() {
            if (this.c == null) {
                this.c = m0.c(this.d).entrySet().iterator();
            }
            return this.c;
        }
        
        public Entry<K, V> c() {
            this.b = true;
            final int a = this.a + 1;
            this.a = a;
            if (a < m0.b(this.d).size()) {
                return (Entry<K, V>)m0.b(this.d).get(this.a);
            }
            return this.b().next();
        }
        
        @Override
        public boolean hasNext() {
            final int a = this.a;
            boolean b = true;
            if (a + 1 >= m0.b(this.d).size()) {
                b = (!m0.c(this.d).isEmpty() && this.b().hasNext() && b);
            }
            return b;
        }
        
        @Override
        public /* bridge */ Object next() {
            return this.c();
        }
        
        @Override
        public void remove() {
            if (this.b) {
                this.b = false;
                m0.a(this.d);
                if (this.a < m0.b(this.d).size()) {
                    m0.d(this.d, this.a--);
                }
                else {
                    this.b().remove();
                }
                return;
            }
            throw new IllegalStateException("remove() was called before next()");
        }
    }
}
