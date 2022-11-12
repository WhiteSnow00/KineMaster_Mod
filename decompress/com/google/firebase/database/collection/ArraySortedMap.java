// 
// Decompiled by Procyon v0.6.0
// 

package com.google.firebase.database.collection;

import java.util.HashMap;
import java.util.AbstractMap;
import java.util.Collection;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Collections;
import java.util.Map;
import java.util.List;
import java.util.Comparator;

public class ArraySortedMap<K, V> extends ImmutableSortedMap<K, V>
{
    private final K[] a;
    private final V[] b;
    private final Comparator<K> c;
    
    public ArraySortedMap(final Comparator<K> c) {
        this.a = (K[])new Object[0];
        this.b = (V[])new Object[0];
        this.c = c;
    }
    
    private ArraySortedMap(final Comparator<K> c, final K[] a, final V[] b) {
        this.a = a;
        this.b = b;
        this.c = c;
    }
    
    private static <T> T[] A(final T[] array, final int n, final T t) {
        final int length = array.length;
        final Object[] array2 = new Object[length];
        System.arraycopy(array, 0, array2, 0, length);
        array2[n] = t;
        return (T[])array2;
    }
    
    static Object[] p(final ArraySortedMap arraySortedMap) {
        return arraySortedMap.a;
    }
    
    static Object[] q(final ArraySortedMap arraySortedMap) {
        return arraySortedMap.b;
    }
    
    private static <T> T[] s(final T[] array, final int n, final T t) {
        final int n2 = array.length + 1;
        final Object[] array2 = new Object[n2];
        System.arraycopy(array, 0, array2, 0, n);
        array2[n] = t;
        System.arraycopy(array, n, array2, n + 1, n2 - n - 1);
        return (T[])array2;
    }
    
    public static <A, B, C> ArraySortedMap<A, C> t(final List<A> list, final Map<B, C> map, final Builder.KeyTranslator<A, B> keyTranslator, final Comparator<A> comparator) {
        Collections.sort(list, comparator);
        final int size = list.size();
        final Object[] array = new Object[size];
        final Object[] array2 = new Object[size];
        final Iterator iterator = list.iterator();
        int n = 0;
        while (iterator.hasNext()) {
            final Object next = iterator.next();
            array[n] = next;
            array2[n] = map.get(keyTranslator.a((A)next));
            ++n;
        }
        return new ArraySortedMap<A, C>((Comparator<Object>)comparator, array, array2);
    }
    
    private int v(final K k) {
        final K[] a = this.a;
        final int length = a.length;
        int i = 0;
        int n = 0;
        while (i < length) {
            if (this.c.compare(k, a[i]) == 0) {
                return n;
            }
            ++n;
            ++i;
        }
        return -1;
    }
    
    private int w(final K k) {
        int n = 0;
        while (true) {
            final K[] a = this.a;
            if (n >= a.length || this.c.compare(a[n], k) >= 0) {
                break;
            }
            ++n;
        }
        return n;
    }
    
    public static <K, V> ArraySortedMap<K, V> x(final Map<K, V> map, final Comparator<K> comparator) {
        return t(new ArrayList<K>((Collection<? extends K>)map.keySet()), (Map<Object, V>)map, (Builder.KeyTranslator<K, Object>)Builder.e(), comparator);
    }
    
    private Iterator<Map.Entry<K, V>> y(final int n, final boolean b) {
        return new Iterator<Map.Entry<K, V>>(this, n, b) {
            int a = n;
            final int b;
            final boolean c;
            final ArraySortedMap d;
            
            public Map.Entry<K, V> b() {
                final Object o = ArraySortedMap.p(this.d)[this.a];
                final Object[] q = ArraySortedMap.q(this.d);
                int a = this.a;
                final Object o2 = q[a];
                if (this.c) {
                    --a;
                }
                else {
                    ++a;
                }
                this.a = a;
                return (Map.Entry<K, V>)new AbstractMap.SimpleImmutableEntry(o, o2);
            }
            
            @Override
            public boolean hasNext() {
                final boolean c = this.c;
                boolean b = true;
                if (c) {
                    if (this.a >= 0) {
                        return b;
                    }
                }
                else if (this.a < ArraySortedMap.p(this.d).length) {
                    return b;
                }
                b = false;
                return b;
            }
            
            @Override
            public /* bridge */ Object next() {
                return this.b();
            }
            
            @Override
            public void remove() {
                throw new UnsupportedOperationException("Can't remove elements from ImmutableSortedMap");
            }
        };
    }
    
    private static <T> T[] z(final T[] array, final int n) {
        final int n2 = array.length - 1;
        final Object[] array2 = new Object[n2];
        System.arraycopy(array, 0, array2, 0, n);
        System.arraycopy(array, n + 1, array2, n, n2 - n);
        return (T[])array2;
    }
    
    @Override
    public Iterator<Map.Entry<K, V>> F1() {
        return this.y(this.a.length - 1, true);
    }
    
    @Override
    public boolean a(final K k) {
        return this.v(k) != -1;
    }
    
    @Override
    public V b(final K k) {
        final int v = this.v(k);
        V v2;
        if (v != -1) {
            v2 = this.b[v];
        }
        else {
            v2 = null;
        }
        return v2;
    }
    
    @Override
    public Comparator<K> e() {
        return this.c;
    }
    
    @Override
    public K f() {
        final K[] a = this.a;
        K k;
        if (a.length > 0) {
            k = a[a.length - 1];
        }
        else {
            k = null;
        }
        return k;
    }
    
    @Override
    public K g() {
        final K[] a = this.a;
        K k;
        if (a.length > 0) {
            k = a[0];
        }
        else {
            k = null;
        }
        return k;
    }
    
    @Override
    public boolean isEmpty() {
        return this.a.length == 0;
    }
    
    @Override
    public Iterator<Map.Entry<K, V>> iterator() {
        return this.y(0, false);
    }
    
    @Override
    public K k(final K k) {
        final int v = this.v(k);
        if (v != -1) {
            K i;
            if (v > 0) {
                i = this.a[v - 1];
            }
            else {
                i = null;
            }
            return i;
        }
        throw new IllegalArgumentException("Can't find predecessor of nonexistent key");
    }
    
    @Override
    public void m(final LLRBNode.NodeVisitor<K, V> nodeVisitor) {
        int n = 0;
        while (true) {
            final K[] a = this.a;
            if (n >= a.length) {
                break;
            }
            nodeVisitor.a(a[n], this.b[n]);
            ++n;
        }
    }
    
    @Override
    public ImmutableSortedMap<K, V> n(final K k, final V v) {
        final int v2 = this.v(k);
        if (v2 != -1) {
            final K[] a = this.a;
            if (a[v2] == k && this.b[v2] == v) {
                return this;
            }
            return new ArraySortedMap((Comparator<Object>)this.c, A(a, v2, k), A(this.b, v2, v));
        }
        else {
            if (this.a.length > 25) {
                final HashMap hashMap = new HashMap(this.a.length + 1);
                int n = 0;
                while (true) {
                    final K[] a2 = this.a;
                    if (n >= a2.length) {
                        break;
                    }
                    hashMap.put(a2[n], this.b[n]);
                    ++n;
                }
                hashMap.put(k, v);
                return (ImmutableSortedMap<K, V>)RBTreeSortedMap.q((Map<K, Object>)hashMap, this.c);
            }
            final int w = this.w(k);
            return new ArraySortedMap((Comparator<Object>)this.c, s(this.a, w, k), s(this.b, w, v));
        }
    }
    
    @Override
    public ImmutableSortedMap<K, V> o(final K k) {
        final int v = this.v(k);
        if (v == -1) {
            return this;
        }
        return new ArraySortedMap((Comparator<Object>)this.c, z(this.a, v), z(this.b, v));
    }
    
    @Override
    public int size() {
        return this.a.length;
    }
}
