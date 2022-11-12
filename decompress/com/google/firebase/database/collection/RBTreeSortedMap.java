// 
// Decompiled by Procyon v0.6.0
// 

package com.google.firebase.database.collection;

import java.util.Collections;
import java.util.Iterator;
import java.util.Collection;
import java.util.ArrayList;
import java.util.Map;
import java.util.List;
import java.util.Comparator;

public class RBTreeSortedMap<K, V> extends ImmutableSortedMap<K, V>
{
    private LLRBNode<K, V> a;
    private Comparator<K> b;
    
    private RBTreeSortedMap(final LLRBNode<K, V> a, final Comparator<K> b) {
        this.a = a;
        this.b = b;
    }
    
    RBTreeSortedMap(final LLRBNode llrbNode, final Comparator comparator, final RBTreeSortedMap$a object) {
        this(llrbNode, comparator);
    }
    
    public static <A, B, C> RBTreeSortedMap<A, C> p(final List<A> list, final Map<B, C> map, final Builder.KeyTranslator<A, B> keyTranslator, final Comparator<A> comparator) {
        return b.b(list, map, keyTranslator, comparator);
    }
    
    public static <A, B> RBTreeSortedMap<A, B> q(final Map<A, B> map, final Comparator<A> comparator) {
        return b.b(new ArrayList<A>((Collection<? extends A>)map.keySet()), (Map<Object, B>)map, (Builder.KeyTranslator<A, Object>)Builder.e(), comparator);
    }
    
    private LLRBNode<K, V> s(final K k) {
        LLRBNode<K, V> llrbNode = this.a;
        while (!llrbNode.isEmpty()) {
            final int compare = this.b.compare(k, llrbNode.getKey());
            if (compare < 0) {
                llrbNode = llrbNode.a();
            }
            else {
                if (compare == 0) {
                    return llrbNode;
                }
                llrbNode = llrbNode.f();
            }
        }
        return null;
    }
    
    @Override
    public Iterator<Map.Entry<K, V>> F1() {
        return new ImmutableSortedMapIterator<K, V>(this.a, null, this.b, true);
    }
    
    @Override
    public boolean a(final K k) {
        return this.s(k) != null;
    }
    
    @Override
    public V b(final K k) {
        final LLRBNode<K, V> s = this.s(k);
        V value;
        if (s != null) {
            value = s.getValue();
        }
        else {
            value = null;
        }
        return value;
    }
    
    @Override
    public Comparator<K> e() {
        return this.b;
    }
    
    @Override
    public K f() {
        return this.a.i().getKey();
    }
    
    @Override
    public K g() {
        return this.a.h().getKey();
    }
    
    @Override
    public boolean isEmpty() {
        return this.a.isEmpty();
    }
    
    @Override
    public Iterator<Map.Entry<K, V>> iterator() {
        return new ImmutableSortedMapIterator<K, V>(this.a, null, this.b, false);
    }
    
    @Override
    public K k(final K k) {
        LLRBNode<K, V> llrbNode = this.a;
        LLRBNode llrbNode2 = null;
        while (!llrbNode.isEmpty()) {
            final int compare = this.b.compare(k, llrbNode.getKey());
            if (compare == 0) {
                if (!llrbNode.a().isEmpty()) {
                    LLRBNode llrbNode3;
                    for (llrbNode3 = llrbNode.a(); !llrbNode3.f().isEmpty(); llrbNode3 = llrbNode3.f()) {}
                    return (K)llrbNode3.getKey();
                }
                if (llrbNode2 != null) {
                    return (K)llrbNode2.getKey();
                }
                return null;
            }
            else if (compare < 0) {
                llrbNode = llrbNode.a();
            }
            else {
                final LLRBNode f = llrbNode.f();
                llrbNode2 = llrbNode;
                llrbNode = f;
            }
        }
        final StringBuilder sb = new StringBuilder();
        sb.append("Couldn't find predecessor key of non-present key: ");
        sb.append(k);
        throw new IllegalArgumentException(sb.toString());
    }
    
    @Override
    public void m(final LLRBNode.NodeVisitor<K, V> nodeVisitor) {
        this.a.b(nodeVisitor);
    }
    
    @Override
    public ImmutableSortedMap<K, V> n(final K k, final V v) {
        return new RBTreeSortedMap((LLRBNode<Object, Object>)this.a.d(k, v, this.b).g(null, null, LLRBNode.Color.BLACK, null, null), (Comparator<Object>)this.b);
    }
    
    @Override
    public ImmutableSortedMap<K, V> o(final K k) {
        if (!this.a(k)) {
            return this;
        }
        return new RBTreeSortedMap((LLRBNode<Object, Object>)this.a.e(k, this.b).g(null, null, LLRBNode.Color.BLACK, null, null), (Comparator<Object>)this.b);
    }
    
    @Override
    public int size() {
        return this.a.size();
    }
    
    private static class b<A, B, C>
    {
        private final List<A> a;
        private final Map<B, C> b;
        private final Builder.KeyTranslator<A, B> c;
        private LLRBValueNode<A, C> d;
        private LLRBValueNode<A, C> e;
        
        private b(final List<A> a, final Map<B, C> b, final Builder.KeyTranslator<A, B> c) {
            this.a = a;
            this.b = b;
            this.c = c;
        }
        
        private LLRBNode<A, C> a(final int n, int n2) {
            if (n2 == 0) {
                return (LLRBNode<A, C>)LLRBEmptyNode.j();
            }
            if (n2 == 1) {
                final A value = this.a.get(n);
                return new LLRBBlackValueNode<A, C>(value, this.d(value), null, null);
            }
            n2 /= 2;
            final int n3 = n + n2;
            final LLRBNode<A, C> a = this.a(n, n2);
            final LLRBNode<A, C> a2 = this.a(n3 + 1, n2);
            final A value2 = this.a.get(n3);
            return new LLRBBlackValueNode<A, C>(value2, this.d(value2), (LLRBNode<Object, Object>)a, (LLRBNode<Object, Object>)a2);
        }
        
        public static <A, B, C> RBTreeSortedMap<A, C> b(final List<A> list, final Map<B, C> map, final Builder.KeyTranslator<A, B> keyTranslator, final Comparator<A> comparator) {
            final RBTreeSortedMap.b b = new RBTreeSortedMap.b((List<Object>)list, (Map<Object, Object>)map, (Builder.KeyTranslator<Object, Object>)keyTranslator);
            Collections.sort(list, comparator);
            final Iterator<RBTreeSortedMap.b.b> iterator = new a(list.size()).iterator();
            int size = list.size();
            while (iterator.hasNext()) {
                final RBTreeSortedMap.b.b b2 = iterator.next();
                final int b3 = b2.b;
                size -= b3;
                if (b2.a) {
                    b.c(LLRBNode.Color.BLACK, b3, size);
                }
                else {
                    b.c(LLRBNode.Color.BLACK, b3, size);
                    final int b4 = b2.b;
                    size -= b4;
                    b.c(LLRBNode.Color.RED, b4, size);
                }
            }
            Object o;
            if ((o = b.d) == null) {
                o = LLRBEmptyNode.j();
            }
            return new RBTreeSortedMap<A, C>((LLRBNode)o, comparator, null);
        }
        
        private void c(final LLRBNode.Color color, final int n, final int n2) {
            final LLRBNode<A, C> a = this.a(n2 + 1, n - 1);
            final A value = this.a.get(n2);
            Object e;
            if (color == LLRBNode.Color.RED) {
                e = new LLRBRedValueNode<A, C>(value, this.d(value), null, a);
            }
            else {
                e = new LLRBBlackValueNode<A, C>(value, this.d(value), null, a);
            }
            if (this.d == null) {
                this.d = (LLRBValueNode<A, C>)e;
                this.e = (LLRBValueNode<A, C>)e;
            }
            else {
                this.e.u((LLRBNode<A, C>)e);
                this.e = (LLRBValueNode<A, C>)e;
            }
        }
        
        private C d(final A a) {
            return this.b.get(this.c.a(a));
        }
        
        static class a implements Iterable<RBTreeSortedMap.b.b>
        {
            private long a;
            private final int b;
            
            public a(int b) {
                final int n = b + 1;
                b = (int)Math.floor(Math.log(n) / Math.log(2.0));
                this.b = b;
                this.a = ((long)Math.pow(2.0, b) - 1L & (long)n);
            }
            
            static int a(final a a) {
                return a.b;
            }
            
            static long b(final a a) {
                return a.a;
            }
            
            @Override
            public Iterator<RBTreeSortedMap.b.b> iterator() {
                return new Iterator<RBTreeSortedMap.b.b>(this) {
                    private int a = RBTreeSortedMap.b.a.a(b) - 1;
                    final a b;
                    
                    public RBTreeSortedMap.b.b b() {
                        final long b = RBTreeSortedMap.b.a.b(this.b);
                        final long n = 1 << this.a;
                        final RBTreeSortedMap.b.b b2 = new RBTreeSortedMap.b.b();
                        b2.a = ((b & n) == 0x0L);
                        b2.b = (int)Math.pow(2.0, this.a);
                        --this.a;
                        return b2;
                    }
                    
                    @Override
                    public boolean hasNext() {
                        return this.a >= 0;
                    }
                    
                    @Override
                    public /* bridge */ Object next() {
                        return this.b();
                    }
                    
                    @Override
                    public void remove() {
                    }
                };
            }
        }
        
        static class b
        {
            public boolean a;
            public int b;
        }
    }
}
