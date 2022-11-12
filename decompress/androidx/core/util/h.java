// 
// Decompiled by Procyon v0.6.0
// 

package androidx.core.util;

import java.util.Objects;
import java.util.Locale;

public final class h
{
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
    
    public static int c(final int n, final int n2, final int n3, final String s) {
        if (n < n2) {
            throw new IllegalArgumentException(String.format(Locale.US, "%s is out of range of [%d, %d] (too low)", s, n2, n3));
        }
        if (n <= n3) {
            return n;
        }
        throw new IllegalArgumentException(String.format(Locale.US, "%s is out of range of [%d, %d] (too high)", s, n2, n3));
    }
    
    public static int d(final int n) {
        if (n >= 0) {
            return n;
        }
        throw new IllegalArgumentException();
    }
    
    public static int e(final int n, final String s) {
        if (n >= 0) {
            return n;
        }
        throw new IllegalArgumentException(s);
    }
    
    public static int f(final int n, final int n2) {
        if ((n & n2) == n) {
            return n;
        }
        final StringBuilder sb = new StringBuilder();
        sb.append("Requested flags 0x");
        sb.append(Integer.toHexString(n));
        sb.append(", but only 0x");
        sb.append(Integer.toHexString(n2));
        sb.append(" are allowed");
        throw new IllegalArgumentException(sb.toString());
    }
    
    public static <T> T g(final T t) {
        Objects.requireNonNull(t);
        return t;
    }
    
    public static <T> T h(final T t, final Object o) {
        if (t != null) {
            return t;
        }
        throw new NullPointerException(String.valueOf(o));
    }
    
    public static void i(final boolean b, final String s) {
        if (b) {
            return;
        }
        throw new IllegalStateException(s);
    }
}
