// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.exoplayer2.util;

import java.util.Iterator;
import java.util.HashSet;
import java.util.Collection;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Set;
import java.util.Map;

public final class CopyOnWriteMultiset<E> implements Iterable<E>
{
    private final Object a;
    private final Map<E, Integer> b;
    private Set<E> c;
    private List<E> d;
    
    public CopyOnWriteMultiset() {
        this.a = new Object();
        this.b = new HashMap<E, Integer>();
        this.c = Collections.emptySet();
        this.d = Collections.emptyList();
    }
    
    public void a(final E e) {
        synchronized (this.a) {
            final ArrayList list = new ArrayList(this.d);
            list.add(e);
            this.d = (List<E>)Collections.unmodifiableList((List<?>)list);
            final Integer n = this.b.get(e);
            if (n == null) {
                final HashSet set = new HashSet(this.c);
                set.add(e);
                this.c = (Set<E>)Collections.unmodifiableSet((Set<?>)set);
            }
            final Map<E, Integer> b = this.b;
            int n2 = 1;
            if (n != null) {
                n2 = 1 + n;
            }
            b.put(e, n2);
        }
    }
    
    public void b(final E e) {
        synchronized (this.a) {
            final Integer n = this.b.get(e);
            if (n == null) {
                return;
            }
            final ArrayList list = new ArrayList(this.d);
            list.remove(e);
            this.d = (List<E>)Collections.unmodifiableList((List<?>)list);
            if (n == 1) {
                this.b.remove(e);
                final HashSet set = new HashSet(this.c);
                set.remove(e);
                this.c = (Set<E>)Collections.unmodifiableSet((Set<?>)set);
            }
            else {
                this.b.put(e, n - 1);
            }
        }
    }
    
    public int count(final E e) {
        synchronized (this.a) {
            int intValue;
            if (this.b.containsKey(e)) {
                intValue = this.b.get(e);
            }
            else {
                intValue = 0;
            }
            return intValue;
        }
    }
    
    public Set<E> elementSet() {
        synchronized (this.a) {
            return this.c;
        }
    }
    
    @Override
    public Iterator<E> iterator() {
        synchronized (this.a) {
            return this.d.iterator();
        }
    }
}
