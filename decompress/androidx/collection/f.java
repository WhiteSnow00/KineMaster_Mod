// 
// Decompiled by Procyon v0.6.0
// 

package androidx.collection;

import java.util.NoSuchElementException;
import java.lang.reflect.Array;
import java.util.Set;
import java.util.Iterator;
import java.util.Collection;
import java.util.Map;

abstract class f<K, V>
{
    b a;
    c b;
    e c;
    
    public static <K, V> boolean j(final Map<K, V> map, final Collection<?> collection) {
        final Iterator<?> iterator = collection.iterator();
        while (iterator.hasNext()) {
            if (!map.containsKey(iterator.next())) {
                return false;
            }
        }
        return true;
    }
    
    public static <T> boolean k(final Set<T> set, final Object o) {
        boolean b = true;
        if (set == o) {
            return true;
        }
        if (!(o instanceof Set)) {
            return false;
        }
        final Set set2 = (Set)o;
        try {
            if (set.size() != set2.size() || !set.containsAll(set2)) {
                b = false;
            }
            return b;
        }
        catch (final NullPointerException | ClassCastException ex) {
            return false;
        }
    }
    
    public static <K, V> boolean o(final Map<K, V> map, final Collection<?> collection) {
        final int size = map.size();
        final Iterator<?> iterator = collection.iterator();
        while (iterator.hasNext()) {
            map.remove(iterator.next());
        }
        return size != map.size();
    }
    
    public static <K, V> boolean p(final Map<K, V> map, final Collection<?> collection) {
        final int size = map.size();
        final Iterator<K> iterator = map.keySet().iterator();
        while (iterator.hasNext()) {
            if (!collection.contains(iterator.next())) {
                iterator.remove();
            }
        }
        return size != map.size();
    }
    
    protected abstract void a();
    
    protected abstract Object b(final int p0, final int p1);
    
    protected abstract Map<K, V> c();
    
    protected abstract int d();
    
    protected abstract int e(final Object p0);
    
    protected abstract int f(final Object p0);
    
    protected abstract void g(final K p0, final V p1);
    
    protected abstract void h(final int p0);
    
    protected abstract V i(final int p0, final V p1);
    
    public Set<Map.Entry<K, V>> l() {
        if (this.a == null) {
            this.a = new b();
        }
        return this.a;
    }
    
    public Set<K> m() {
        if (this.b == null) {
            this.b = new c();
        }
        return this.b;
    }
    
    public Collection<V> n() {
        if (this.c == null) {
            this.c = new e();
        }
        return this.c;
    }
    
    public Object[] q(final int n) {
        final int d = this.d();
        final Object[] array = new Object[d];
        for (int i = 0; i < d; ++i) {
            array[i] = this.b(i, n);
        }
        return array;
    }
    
    public <T> T[] r(final T[] array, final int n) {
        final int d = this.d();
        Object[] array2 = array;
        if (array.length < d) {
            array2 = (Object[])Array.newInstance(array.getClass().getComponentType(), d);
        }
        for (int i = 0; i < d; ++i) {
            array2[i] = this.b(i, n);
        }
        if (array2.length > d) {
            array2[d] = null;
        }
        return (T[])array2;
    }
    
    final class a<T> implements Iterator<T>
    {
        final int a;
        int b;
        int c;
        boolean d;
        final f e;
        
        a(final f e, final int a) {
            this.e = e;
            this.d = false;
            this.a = a;
            this.b = e.d();
        }
        
        @Override
        public boolean hasNext() {
            return this.c < this.b;
        }
        
        @Override
        public T next() {
            if (this.hasNext()) {
                final Object b = this.e.b(this.c, this.a);
                ++this.c;
                this.d = true;
                return (T)b;
            }
            throw new NoSuchElementException();
        }
        
        @Override
        public void remove() {
            if (this.d) {
                final int c = this.c - 1;
                this.c = c;
                --this.b;
                this.d = false;
                this.e.h(c);
                return;
            }
            throw new IllegalStateException();
        }
    }
    
    final class b implements Set<Map.Entry<K, V>>
    {
        final f a;
        
        b(final f a) {
            this.a = a;
        }
        
        public boolean a(final Map.Entry<K, V> entry) {
            throw new UnsupportedOperationException();
        }
        
        @Override
        public /* bridge */ boolean add(final Object o) {
            return this.a((Map.Entry<K, V>)o);
        }
        
        @Override
        public boolean addAll(final Collection<? extends Map.Entry<K, V>> collection) {
            final int d = this.a.d();
            for (final Map.Entry<K, V> entry : collection) {
                this.a.g(entry.getKey(), entry.getValue());
            }
            return d != this.a.d();
        }
        
        @Override
        public void clear() {
            this.a.a();
        }
        
        @Override
        public boolean contains(final Object o) {
            if (!(o instanceof Map.Entry)) {
                return false;
            }
            final Map.Entry entry = (Map.Entry)o;
            final int e = this.a.e(entry.getKey());
            return e >= 0 && androidx.collection.c.c(this.a.b(e, 1), entry.getValue());
        }
        
        @Override
        public boolean containsAll(final Collection<?> collection) {
            final Iterator<?> iterator = collection.iterator();
            while (iterator.hasNext()) {
                if (!this.contains(iterator.next())) {
                    return false;
                }
            }
            return true;
        }
        
        @Override
        public boolean equals(final Object o) {
            return f.k((Set<Object>)this, o);
        }
        
        @Override
        public int hashCode() {
            int i = this.a.d() - 1;
            int n = 0;
            while (i >= 0) {
                final Object b = this.a.b(i, 0);
                final Object b2 = this.a.b(i, 1);
                int hashCode;
                if (b == null) {
                    hashCode = 0;
                }
                else {
                    hashCode = b.hashCode();
                }
                int hashCode2;
                if (b2 == null) {
                    hashCode2 = 0;
                }
                else {
                    hashCode2 = b2.hashCode();
                }
                n += (hashCode ^ hashCode2);
                --i;
            }
            return n;
        }
        
        @Override
        public boolean isEmpty() {
            return this.a.d() == 0;
        }
        
        @Override
        public Iterator<Map.Entry<K, V>> iterator() {
            return this.a.new d();
        }
        
        @Override
        public boolean remove(final Object o) {
            throw new UnsupportedOperationException();
        }
        
        @Override
        public boolean removeAll(final Collection<?> collection) {
            throw new UnsupportedOperationException();
        }
        
        @Override
        public boolean retainAll(final Collection<?> collection) {
            throw new UnsupportedOperationException();
        }
        
        @Override
        public int size() {
            return this.a.d();
        }
        
        @Override
        public Object[] toArray() {
            throw new UnsupportedOperationException();
        }
        
        @Override
        public <T> T[] toArray(final T[] array) {
            throw new UnsupportedOperationException();
        }
    }
    
    final class c implements Set<K>
    {
        final f a;
        
        c(final f a) {
            this.a = a;
        }
        
        @Override
        public boolean add(final K k) {
            throw new UnsupportedOperationException();
        }
        
        @Override
        public boolean addAll(final Collection<? extends K> collection) {
            throw new UnsupportedOperationException();
        }
        
        @Override
        public void clear() {
            this.a.a();
        }
        
        @Override
        public boolean contains(final Object o) {
            return this.a.e(o) >= 0;
        }
        
        @Override
        public boolean containsAll(final Collection<?> collection) {
            return f.j(this.a.c(), collection);
        }
        
        @Override
        public boolean equals(final Object o) {
            return f.k((Set<Object>)this, o);
        }
        
        @Override
        public int hashCode() {
            int i = this.a.d() - 1;
            int n = 0;
            while (i >= 0) {
                final Object b = this.a.b(i, 0);
                int hashCode;
                if (b == null) {
                    hashCode = 0;
                }
                else {
                    hashCode = b.hashCode();
                }
                n += hashCode;
                --i;
            }
            return n;
        }
        
        @Override
        public boolean isEmpty() {
            return this.a.d() == 0;
        }
        
        @Override
        public Iterator<K> iterator() {
            return (Iterator<K>)this.a.new a(0);
        }
        
        @Override
        public boolean remove(final Object o) {
            final int e = this.a.e(o);
            if (e >= 0) {
                this.a.h(e);
                return true;
            }
            return false;
        }
        
        @Override
        public boolean removeAll(final Collection<?> collection) {
            return f.o(this.a.c(), collection);
        }
        
        @Override
        public boolean retainAll(final Collection<?> collection) {
            return f.p(this.a.c(), collection);
        }
        
        @Override
        public int size() {
            return this.a.d();
        }
        
        @Override
        public Object[] toArray() {
            return this.a.q(0);
        }
        
        @Override
        public <T> T[] toArray(final T[] array) {
            return this.a.r(array, 0);
        }
    }
    
    final class d implements Iterator<Entry<K, V>>, Entry<K, V>
    {
        int a;
        int b;
        boolean c;
        final f d;
        
        d(final f d) {
            this.d = d;
            this.c = false;
            this.a = d.d() - 1;
            this.b = -1;
        }
        
        public Entry<K, V> b() {
            if (this.hasNext()) {
                ++this.b;
                this.c = true;
                return this;
            }
            throw new NoSuchElementException();
        }
        
        @Override
        public boolean equals(final Object o) {
            if (!this.c) {
                throw new IllegalStateException("This container does not support retaining Map.Entry objects");
            }
            final boolean b = o instanceof Entry;
            final boolean b2 = false;
            if (!b) {
                return false;
            }
            final Entry entry = (Entry)o;
            boolean b3 = b2;
            if (androidx.collection.c.c(entry.getKey(), this.d.b(this.b, 0))) {
                b3 = b2;
                if (androidx.collection.c.c(entry.getValue(), this.d.b(this.b, 1))) {
                    b3 = true;
                }
            }
            return b3;
        }
        
        @Override
        public K getKey() {
            if (this.c) {
                return (K)this.d.b(this.b, 0);
            }
            throw new IllegalStateException("This container does not support retaining Map.Entry objects");
        }
        
        @Override
        public V getValue() {
            if (this.c) {
                return (V)this.d.b(this.b, 1);
            }
            throw new IllegalStateException("This container does not support retaining Map.Entry objects");
        }
        
        @Override
        public boolean hasNext() {
            return this.b < this.a;
        }
        
        @Override
        public int hashCode() {
            if (this.c) {
                final f d = this.d;
                final int b = this.b;
                int hashCode = 0;
                final Object b2 = d.b(b, 0);
                final Object b3 = this.d.b(this.b, 1);
                int hashCode2;
                if (b2 == null) {
                    hashCode2 = 0;
                }
                else {
                    hashCode2 = b2.hashCode();
                }
                if (b3 != null) {
                    hashCode = b3.hashCode();
                }
                return hashCode2 ^ hashCode;
            }
            throw new IllegalStateException("This container does not support retaining Map.Entry objects");
        }
        
        @Override
        public /* bridge */ Object next() {
            return this.b();
        }
        
        @Override
        public void remove() {
            if (this.c) {
                this.d.h(this.b);
                --this.b;
                --this.a;
                this.c = false;
                return;
            }
            throw new IllegalStateException();
        }
        
        @Override
        public V setValue(final V v) {
            if (this.c) {
                return this.d.i(this.b, v);
            }
            throw new IllegalStateException("This container does not support retaining Map.Entry objects");
        }
        
        @Override
        public String toString() {
            final StringBuilder sb = new StringBuilder();
            sb.append(this.getKey());
            sb.append("=");
            sb.append(this.getValue());
            return sb.toString();
        }
    }
    
    final class e implements Collection<V>
    {
        final f a;
        
        e(final f a) {
            this.a = a;
        }
        
        @Override
        public boolean add(final V v) {
            throw new UnsupportedOperationException();
        }
        
        @Override
        public boolean addAll(final Collection<? extends V> collection) {
            throw new UnsupportedOperationException();
        }
        
        @Override
        public void clear() {
            this.a.a();
        }
        
        @Override
        public boolean contains(final Object o) {
            return this.a.f(o) >= 0;
        }
        
        @Override
        public boolean containsAll(final Collection<?> collection) {
            final Iterator<?> iterator = collection.iterator();
            while (iterator.hasNext()) {
                if (!this.contains(iterator.next())) {
                    return false;
                }
            }
            return true;
        }
        
        @Override
        public boolean isEmpty() {
            return this.a.d() == 0;
        }
        
        @Override
        public Iterator<V> iterator() {
            return (Iterator<V>)this.a.new a(1);
        }
        
        @Override
        public boolean remove(final Object o) {
            final int f = this.a.f(o);
            if (f >= 0) {
                this.a.h(f);
                return true;
            }
            return false;
        }
        
        @Override
        public boolean removeAll(final Collection<?> collection) {
            int d = this.a.d();
            int i = 0;
            boolean b = false;
            while (i < d) {
                int n = d;
                int n2 = i;
                if (collection.contains(this.a.b(i, 1))) {
                    this.a.h(i);
                    n2 = i - 1;
                    n = d - 1;
                    b = true;
                }
                i = n2 + 1;
                d = n;
            }
            return b;
        }
        
        @Override
        public boolean retainAll(final Collection<?> collection) {
            int d = this.a.d();
            int i = 0;
            boolean b = false;
            while (i < d) {
                int n = d;
                int n2 = i;
                if (!collection.contains(this.a.b(i, 1))) {
                    this.a.h(i);
                    n2 = i - 1;
                    n = d - 1;
                    b = true;
                }
                i = n2 + 1;
                d = n;
            }
            return b;
        }
        
        @Override
        public int size() {
            return this.a.d();
        }
        
        @Override
        public Object[] toArray() {
            return this.a.q(1);
        }
        
        @Override
        public <T> T[] toArray(final T[] array) {
            return this.a.r(array, 1);
        }
    }
}
