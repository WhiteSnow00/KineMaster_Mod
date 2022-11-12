// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.datatransport.runtime.logging;

import android.util.Log;

public final class Logging
{
    private Logging() {
    }
    
    public static void a(String d, final String s, final Object o) {
        d = d(d);
        if (Log.isLoggable(d, 3)) {
            Log.d(d, String.format(s, o));
        }
    }
    
    public static void b(String d, final String s, final Object... array) {
        d = d(d);
        if (Log.isLoggable(d, 3)) {
            Log.d(d, String.format(s, array));
        }
    }
    
    public static void c(String d, final String s, final Throwable t) {
        d = d(d);
        if (Log.isLoggable(d, 6)) {
            Log.e(d, s, t);
        }
    }
    
    private static String d(final String s) {
        final StringBuilder sb = new StringBuilder();
        sb.append("TRuntime.");
        sb.append(s);
        return sb.toString();
    }
    
    public static void e(String d, final String s, final Object o) {
        d = d(d);
        if (Log.isLoggable(d, 4)) {
            Log.i(d, String.format(s, o));
        }
    }
    
    public static void f(String d, final String s, final Object o) {
        d = d(d);
        if (Log.isLoggable(d, 5)) {
            Log.w(d, String.format(s, o));
        }
    }
}
