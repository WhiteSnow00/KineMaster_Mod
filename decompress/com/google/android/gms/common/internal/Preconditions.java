// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.gms.common.internal;

import java.util.Objects;
import android.text.TextUtils;
import com.google.android.gms.common.util.zzb;
import android.os.Looper;
import android.os.Handler;
import com.google.android.gms.common.annotation.KeepForSdk;

@KeepForSdk
public final class Preconditions
{
    private Preconditions() {
        throw new AssertionError((Object)"Uninstantiable");
    }
    
    @KeepForSdk
    public static void a(final boolean b) {
        if (b) {
            return;
        }
        throw new IllegalArgumentException();
    }
    
    @KeepForSdk
    public static void b(final boolean b, final Object o) {
        if (b) {
            return;
        }
        throw new IllegalArgumentException(String.valueOf(o));
    }
    
    @KeepForSdk
    public static void c(final boolean b, final String s, final Object... array) {
        if (b) {
            return;
        }
        throw new IllegalArgumentException(String.format(s, array));
    }
    
    @KeepForSdk
    public static void d(final Handler handler) {
        final Looper myLooper = Looper.myLooper();
        if (myLooper != handler.getLooper()) {
            String name;
            if (myLooper != null) {
                name = myLooper.getThread().getName();
            }
            else {
                name = "null current looper";
            }
            final String name2 = handler.getLooper().getThread().getName();
            final StringBuilder sb = new StringBuilder();
            sb.append("Must be called on ");
            sb.append(name2);
            sb.append(" thread, but got ");
            sb.append(name);
            sb.append(".");
            throw new IllegalStateException(sb.toString());
        }
    }
    
    @KeepForSdk
    public static void e(final Handler handler, final String s) {
        if (Looper.myLooper() == handler.getLooper()) {
            return;
        }
        throw new IllegalStateException(s);
    }
    
    @KeepForSdk
    public static void f(final String s) {
        if (zzb.a()) {
            return;
        }
        throw new IllegalStateException(s);
    }
    
    @KeepForSdk
    public static String g(final String s) {
        if (!TextUtils.isEmpty((CharSequence)s)) {
            return s;
        }
        throw new IllegalArgumentException("Given String is empty or null");
    }
    
    @KeepForSdk
    public static String h(final String s, final Object o) {
        if (!TextUtils.isEmpty((CharSequence)s)) {
            return s;
        }
        throw new IllegalArgumentException(String.valueOf(o));
    }
    
    @KeepForSdk
    public static void i() {
        j("Must not be called on the main application thread");
    }
    
    @KeepForSdk
    public static void j(final String s) {
        if (!zzb.a()) {
            return;
        }
        throw new IllegalStateException(s);
    }
    
    @KeepForSdk
    public static <T> T k(final T t) {
        Objects.requireNonNull(t, "null reference");
        return t;
    }
    
    @KeepForSdk
    public static <T> T l(final T t, final Object o) {
        if (t != null) {
            return t;
        }
        throw new NullPointerException(String.valueOf(o));
    }
    
    @KeepForSdk
    public static int m(final int n) {
        if (n != 0) {
            return n;
        }
        throw new IllegalArgumentException("Given Integer is zero");
    }
    
    @KeepForSdk
    public static long n(final long n) {
        if (n != 0L) {
            return n;
        }
        throw new IllegalArgumentException("Given Long is zero");
    }
    
    @KeepForSdk
    public static void o(final boolean b) {
        if (b) {
            return;
        }
        throw new IllegalStateException();
    }
    
    @KeepForSdk
    public static void p(final boolean b, final Object o) {
        if (b) {
            return;
        }
        throw new IllegalStateException(String.valueOf(o));
    }
    
    @KeepForSdk
    public static void q(final boolean b, final String s, final Object... array) {
        if (b) {
            return;
        }
        throw new IllegalStateException(String.format(s, array));
    }
}
