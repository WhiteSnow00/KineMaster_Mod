// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.gms.common.util;

import java.util.HashSet;
import androidx.collection.b;
import java.util.HashMap;
import androidx.collection.a;
import java.util.Collection;
import java.util.Set;
import java.util.Map;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import com.google.android.gms.common.annotation.KeepForSdk;

@KeepForSdk
public final class CollectionUtils
{
    private CollectionUtils() {
    }
    
    @Deprecated
    @KeepForSdk
    public static <T> List<T> a() {
        return Collections.emptyList();
    }
    
    @Deprecated
    @KeepForSdk
    public static <T> List<T> b(final T t) {
        return Collections.singletonList(t);
    }
    
    @Deprecated
    @KeepForSdk
    public static <T> List<T> c(final T... array) {
        final int length = array.length;
        if (length == 0) {
            return a();
        }
        if (length != 1) {
            return Collections.unmodifiableList((List<? extends T>)Arrays.asList((T[])array));
        }
        return b(array[0]);
    }
    
    @KeepForSdk
    public static <K, V> Map<K, V> d(final K k, final V v, final K i, final V v2, final K j, final V v3) {
        final Map h = h(3, false);
        h.put(k, v);
        h.put(i, v2);
        h.put(j, v3);
        return (Map<K, V>)Collections.unmodifiableMap((Map<?, ?>)h);
    }
    
    @KeepForSdk
    public static <K, V> Map<K, V> e(final K[] array, final V[] array2) {
        final int length = array.length;
        final int length2 = array2.length;
        if (length != length2) {
            final StringBuilder sb = new StringBuilder();
            sb.append("Key and values array lengths not equal: ");
            sb.append(length);
            sb.append(" != ");
            sb.append(length2);
            throw new IllegalArgumentException(sb.toString());
        }
        if (length == 0) {
            return Collections.emptyMap();
        }
        int i = 0;
        if (length != 1) {
            final Map h = h(length, false);
            while (i < array.length) {
                h.put(array[i], array2[i]);
                ++i;
            }
            return (Map<K, V>)Collections.unmodifiableMap((Map<?, ?>)h);
        }
        return Collections.singletonMap(array[0], array2[0]);
    }
    
    @Deprecated
    @KeepForSdk
    public static <T> Set<T> f(final T t, final T t2, final T t3) {
        final Set i = i(3, false);
        i.add(t);
        i.add(t2);
        i.add(t3);
        return (Set<T>)Collections.unmodifiableSet((Set<?>)i);
    }
    
    @Deprecated
    @KeepForSdk
    public static <T> Set<T> g(final T... array) {
        final int length = array.length;
        if (length == 0) {
            return Collections.emptySet();
        }
        if (length == 1) {
            return Collections.singleton(array[0]);
        }
        if (length == 2) {
            final T t = array[0];
            final T t2 = array[1];
            final Set i = i(2, false);
            i.add(t);
            i.add(t2);
            return (Set<T>)Collections.unmodifiableSet((Set<?>)i);
        }
        if (length == 3) {
            return f(array[0], array[1], array[2]);
        }
        if (length != 4) {
            final Set j = i(length, false);
            Collections.addAll(j, array);
            return (Set<T>)Collections.unmodifiableSet((Set<?>)j);
        }
        final T t3 = array[0];
        final T t4 = array[1];
        final T t5 = array[2];
        final T t6 = array[3];
        final Set k = i(4, false);
        k.add(t3);
        k.add(t4);
        k.add(t5);
        k.add(t6);
        return (Set<T>)Collections.unmodifiableSet((Set<?>)k);
    }
    
    private static Map h(final int n, final boolean b) {
        Object o;
        if (n <= 256) {
            o = new a(n);
        }
        else {
            o = new HashMap(n, 1.0f);
        }
        return (Map)o;
    }
    
    private static Set i(final int n, final boolean b) {
        float n2;
        if (!b) {
            n2 = 1.0f;
        }
        else {
            n2 = 0.75f;
        }
        int n3;
        if (!b) {
            n3 = 256;
        }
        else {
            n3 = 128;
        }
        Object o;
        if (n <= n3) {
            o = new b(n);
        }
        else {
            o = new HashSet(n, n2);
        }
        return (Set)o;
    }
}
