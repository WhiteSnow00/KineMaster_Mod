// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.exoplayer2.util;

import java.util.Objects;
import android.text.TextUtils;

public final class Assertions
{
    private Assertions() {
    }
    
    public static void a(final boolean b) {
        if (b) {
            return;
        }
        throw new IllegalArgumentException();
    }
    
    public static void b(final boolean b, final Object o) {
        if (b) {
            return;
        }
        throw new IllegalArgumentException(String.valueOf(o));
    }
    
    public static int c(final int n, final int n2, final int n3) {
        if (n >= n2 && n < n3) {
            return n;
        }
        throw new IndexOutOfBoundsException();
    }
    
    public static String d(final String s) {
        if (!TextUtils.isEmpty((CharSequence)s)) {
            return s;
        }
        throw new IllegalArgumentException();
    }
    
    public static <T> T e(final T t) {
        Objects.requireNonNull(t);
        return t;
    }
    
    public static <T> T f(final T t, final Object o) {
        if (t != null) {
            return t;
        }
        throw new NullPointerException(String.valueOf(o));
    }
    
    public static void g(final boolean b) {
        if (b) {
            return;
        }
        throw new IllegalStateException();
    }
    
    public static void h(final boolean b, final Object o) {
        if (b) {
            return;
        }
        throw new IllegalStateException(String.valueOf(o));
    }
    
    public static <T> T i(final T t) {
        if (t != null) {
            return t;
        }
        throw new IllegalStateException();
    }
    
    public static <T> T j(final T t, final Object o) {
        if (t != null) {
            return t;
        }
        throw new IllegalStateException(String.valueOf(o));
    }
}
