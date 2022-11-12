// 
// Decompiled by Procyon v0.6.0
// 

package com.google.firebase.database.collection;

import java.util.Map;
import java.util.Iterator;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ImmutableSortedSet<T> implements Iterable<T>
{
    private final ImmutableSortedMap<T, Void> a;
    
    private ImmutableSortedSet(final ImmutableSortedMap<T, Void> a) {
        this.a = a;
    }
    
    public ImmutableSortedSet(final List<T> list, final Comparator<T> comparator) {
        this.a = ImmutableSortedMap.Builder.b(list, Collections.emptyMap(), (ImmutableSortedMap.Builder.KeyTranslator<T, Object>)ImmutableSortedMap.Builder.e(), comparator);
    }
    
    public Iterator<T> F1() {
        return new a<T>(this.a.F1());
    }
    
    public T a() {
        return this.a.f();
    }
    
    public T b() {
        return this.a.g();
    }
    
    public boolean contains(final T t) {
        return this.a.a(t);
    }
    
    public T e(final T t) {
        return this.a.k(t);
    }
    
    @Override
    public boolean equals(final Object o) {
        return this == o || (o instanceof ImmutableSortedSet && this.a.equals(((ImmutableSortedSet)o).a));
    }
    
    public ImmutableSortedSet<T> f(final T t) {
        return new ImmutableSortedSet<T>(this.a.n(t, null));
    }
    
    public ImmutableSortedSet<T> g(final T t) {
        final ImmutableSortedMap<T, Void> o = this.a.o(t);
        ImmutableSortedSet set;
        if (o == this.a) {
            set = this;
        }
        else {
            set = new ImmutableSortedSet((ImmutableSortedMap<Object, Void>)o);
        }
        return set;
    }
    
    @Override
    public int hashCode() {
        return this.a.hashCode();
    }
    
    @Override
    public Iterator<T> iterator() {
        return new a<T>(this.a.iterator());
    }
    
    public int size() {
        return this.a.size();
    }
    
    private static class a<T> implements Iterator<T>
    {
        final Iterator<Map.Entry<T, Void>> a;
        
        public a(final Iterator<Map.Entry<T, Void>> a) {
            this.a = a;
        }
        
        @Override
        public boolean hasNext() {
            return this.a.hasNext();
        }
        
        @Override
        public T next() {
            return this.a.next().getKey();
        }
        
        @Override
        public void remove() {
            this.a.remove();
        }
    }
}
