// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.datatransport.runtime.dagger.internal;

import java.util.LinkedHashMap;
import java.util.HashSet;

public final class DaggerCollections
{
    private DaggerCollections() {
    }
    
    private static int a(final int n) {
        if (n < 3) {
            return n + 1;
        }
        if (n < 1073741824) {
            return (int)(n / 0.75f + 1.0f);
        }
        return Integer.MAX_VALUE;
    }
    
    static <T> HashSet<T> b(final int n) {
        return new HashSet<T>(a(n));
    }
    
    public static <K, V> LinkedHashMap<K, V> c(final int n) {
        return new LinkedHashMap<K, V>(a(n));
    }
}
