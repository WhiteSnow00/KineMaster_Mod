// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.datatransport.runtime.dagger.internal;

import java.util.Iterator;
import java.util.HashSet;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Collection;
import javax.inject.Provider;
import java.util.List;
import java.util.Set;

public final class SetFactory<T> implements Factory<Set<T>>
{
    private static final Factory<Set<Object>> c;
    private final List<Provider<T>> a;
    private final List<Provider<Collection<T>>> b;
    
    static {
        c = InstanceFactory.a(Collections.emptySet());
    }
    
    public Set<T> a() {
        int size = this.a.size();
        final ArrayList list = new ArrayList(this.b.size());
        final int size2 = this.b.size();
        final int n = 0;
        for (int i = 0; i < size2; ++i) {
            final Collection collection = (Collection)this.b.get(i).get();
            size += collection.size();
            list.add(collection);
        }
        final HashSet<Object> b = DaggerCollections.b(size);
        for (int size3 = this.a.size(), j = 0; j < size3; ++j) {
            b.add(Preconditions.b(this.a.get(j).get()));
        }
        for (int size4 = list.size(), k = n; k < size4; ++k) {
            final Iterator iterator = ((Collection)list.get(k)).iterator();
            while (iterator.hasNext()) {
                b.add(Preconditions.b(iterator.next()));
            }
        }
        return Collections.unmodifiableSet((Set<? extends T>)b);
    }
    
    public /* bridge */ Object get() {
        return this.a();
    }
    
    public static final class Builder<T>
    {
    }
}
