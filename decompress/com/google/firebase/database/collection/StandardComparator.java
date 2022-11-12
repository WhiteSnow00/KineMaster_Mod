// 
// Decompiled by Procyon v0.6.0
// 

package com.google.firebase.database.collection;

import java.util.Comparator;

public class StandardComparator<A extends Comparable<A>> implements Comparator<A>
{
    private static StandardComparator a;
    
    static {
        StandardComparator.a = new StandardComparator();
    }
    
    private StandardComparator() {
    }
    
    public static <T extends Comparable<T>> StandardComparator<T> b(final Class<T> clazz) {
        return StandardComparator.a;
    }
    
    public int a(final A a, final A a2) {
        return a.compareTo(a2);
    }
    
    @Override
    public /* bridge */ int compare(final Object o, final Object o2) {
        return this.a((A)o, (A)o2);
    }
}
