// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.datatransport.runtime.dagger.internal;

import java.util.Objects;

public final class Preconditions
{
    private Preconditions() {
    }
    
    public static <T> void a(final T t, final Class<T> clazz) {
        if (t != null) {
            return;
        }
        final StringBuilder sb = new StringBuilder();
        sb.append(clazz.getCanonicalName());
        sb.append(" must be set");
        throw new IllegalStateException(sb.toString());
    }
    
    public static <T> T b(final T t) {
        Objects.requireNonNull(t);
        return t;
    }
    
    public static <T> T c(final T t, final String s) {
        Objects.requireNonNull(t, s);
        return t;
    }
}
