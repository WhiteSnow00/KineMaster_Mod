// 
// Decompiled by Procyon v0.6.0
// 

package com.google.firebase.database.collection;

import java.util.List;
import q4.a;
import java.util.Comparator;
import java.util.Iterator;
import java.util.Map;

public abstract class ImmutableSortedMap<K, V> implements Iterable<Map.Entry<K, V>>
{
    public abstract Iterator<Map.Entry<K, V>> F1();
    
    public abstract boolean a(final K p0);
    
    public abstract V b(final K p0);
    
    public abstract Comparator<K> e();
    
    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof ImmutableSortedMap)) {
            return false;
        }
        final ImmutableSortedMap immutableSortedMap = (ImmutableSortedMap)o;
        if (!this.e().equals(immutableSortedMap.e())) {
            return false;
        }
        if (this.size() != immutableSortedMap.size()) {
            return false;
        }
        final Iterator<Map.Entry<K, V>> iterator = this.iterator();
        final Iterator iterator2 = immutableSortedMap.iterator();
        while (iterator.hasNext()) {
            if (!((Map.Entry)iterator.next()).equals(iterator2.next())) {
                return false;
            }
        }
        return true;
    }
    
    public abstract K f();
    
    public abstract K g();
    
    @Override
    public int hashCode() {
        int hashCode = this.e().hashCode();
        final Iterator<Map.Entry<K, V>> iterator = this.iterator();
        while (iterator.hasNext()) {
            hashCode = hashCode * 31 + ((Map.Entry)iterator.next()).hashCode();
        }
        return hashCode;
    }
    
    public abstract boolean isEmpty();
    
    @Override
    public abstract Iterator<Map.Entry<K, V>> iterator();
    
    public abstract K k(final K p0);
    
    public abstract void m(final LLRBNode.NodeVisitor<K, V> p0);
    
    public abstract ImmutableSortedMap<K, V> n(final K p0, final V p1);
    
    public abstract ImmutableSortedMap<K, V> o(final K p0);
    
    public abstract int size();
    
    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append(this.getClass().getSimpleName());
        sb.append("{");
        final Iterator<Map.Entry<K, V>> iterator = this.iterator();
        int n = 1;
        while (iterator.hasNext()) {
            final Map.Entry<Object, V> entry = (Map.Entry<Object, V>)iterator.next();
            if (n != 0) {
                n = 0;
            }
            else {
                sb.append(", ");
            }
            sb.append("(");
            sb.append(entry.getKey());
            sb.append("=>");
            sb.append(entry.getValue());
            sb.append(")");
        }
        sb.append("};");
        return sb.toString();
    }
    
    public static class Builder
    {
        private static final KeyTranslator a;
        
        static {
            a = (KeyTranslator)q4.a.a;
        }
        
        public static Object a(final Object o) {
            return f(o);
        }
        
        public static <A, B, C> ImmutableSortedMap<A, C> b(final List<A> list, final Map<B, C> map, final KeyTranslator<A, B> keyTranslator, final Comparator<A> comparator) {
            if (list.size() < 25) {
                return ArraySortedMap.t(list, map, keyTranslator, comparator);
            }
            return (ImmutableSortedMap<A, C>)RBTreeSortedMap.p((List<A>)list, map, (KeyTranslator<A, B>)keyTranslator, (Comparator<A>)comparator);
        }
        
        public static <K, V> ImmutableSortedMap<K, V> c(final Comparator<K> comparator) {
            return new ArraySortedMap<K, V>(comparator);
        }
        
        public static <A, B> ImmutableSortedMap<A, B> d(final Map<A, B> map, final Comparator<A> comparator) {
            if (map.size() < 25) {
                return ArraySortedMap.x(map, comparator);
            }
            return RBTreeSortedMap.q(map, comparator);
        }
        
        public static <A> KeyTranslator<A, A> e() {
            return Builder.a;
        }
        
        private static Object f(final Object o) {
            return o;
        }
        
        public interface KeyTranslator<C, D>
        {
            D a(final C p0);
        }
    }
}
