// 
// Decompiled by Procyon v0.6.0
// 

package com.google.firebase.components;

import java.util.Objects;

public final class Preconditions
{
    public static void a(final boolean b, final String s) {
        if (b) {
            return;
        }
        throw new IllegalArgumentException(s);
    }
    
    public static <T> T b(final T t) {
        Objects.requireNonNull(t);
        return t;
    }
    
    public static <T> T c(final T t, final String s) {
        Objects.requireNonNull(t, s);
        return t;
    }
    
    public static void d(final boolean b, final String s) {
        if (b) {
            return;
        }
        throw new IllegalStateException(s);
    }
}
