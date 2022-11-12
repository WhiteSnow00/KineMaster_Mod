// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.exoplayer2.util;

import java.lang.annotation.ElementType;
import java.lang.annotation.Target;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Retention;
import java.lang.annotation.Documented;
import java.net.UnknownHostException;
import android.text.TextUtils;

public final class Log
{
    private static final Object a;
    private static int b = 0;
    private static boolean c = true;
    private static Logger d;
    
    static {
        a = new Object();
        Log.d = Logger.a;
    }
    
    private Log() {
    }
    
    private static String a(final String s, final Throwable t) {
        final String e = e(t);
        String string = s;
        if (!TextUtils.isEmpty((CharSequence)e)) {
            final StringBuilder sb = new StringBuilder();
            sb.append(s);
            sb.append("\n  ");
            sb.append(e.replace("\n", "\n  "));
            sb.append('\n');
            string = sb.toString();
        }
        return string;
    }
    
    public static void b(final String s, final String s2) {
        synchronized (Log.a) {
            if (Log.b == 0) {
                Log.d.c(s, s2);
            }
        }
    }
    
    public static void c(final String s, final String s2) {
        synchronized (Log.a) {
            if (Log.b <= 3) {
                Log.d.b(s, s2);
            }
        }
    }
    
    public static void d(final String s, final String s2, final Throwable t) {
        c(s, a(s2, t));
    }
    
    public static String e(final Throwable t) {
        final Object a = Log.a;
        monitorenter(a);
        Label_0014: {
            if (t != null) {
                break Label_0014;
            }
            try {
                monitorexit(a);
                return null;
                Label_0041: {
                    return android.util.Log.getStackTraceString(t).trim().replace("\t", "    ");
                }
                Label_0026:
                iftrue(Label_0041:)(Log.c);
                return t.getMessage();
                iftrue(Label_0026:)(!h(t));
                return "UnknownHostException (no network)";
            }
            finally {
                monitorexit(a);
            }
        }
    }
    
    public static void f(final String s, final String s2) {
        synchronized (Log.a) {
            if (Log.b <= 1) {
                Log.d.d(s, s2);
            }
        }
    }
    
    public static void g(final String s, final String s2, final Throwable t) {
        f(s, a(s2, t));
    }
    
    private static boolean h(Throwable cause) {
        while (cause != null) {
            if (cause instanceof UnknownHostException) {
                return true;
            }
            cause = cause.getCause();
        }
        return false;
    }
    
    public static void i(final String s, final String s2) {
        synchronized (Log.a) {
            if (Log.b <= 2) {
                Log.d.a(s, s2);
            }
        }
    }
    
    public static void j(final String s, final String s2, final Throwable t) {
        i(s, a(s2, t));
    }
    
    @Documented
    @Retention(RetentionPolicy.SOURCE)
    @Target({ ElementType.TYPE_USE })
    public @interface LogLevel {
    }
    
    public interface Logger
    {
        public static final Logger a = new Logger() {
            @Override
            public void a(final String s, final String s2) {
                android.util.Log.w(s, s2);
            }
            
            @Override
            public void b(final String s, final String s2) {
                android.util.Log.e(s, s2);
            }
            
            @Override
            public void c(final String s, final String s2) {
                android.util.Log.d(s, s2);
            }
            
            @Override
            public void d(final String s, final String s2) {
                android.util.Log.i(s, s2);
            }
        };
        
        void a(final String p0, final String p1);
        
        void b(final String p0, final String p1);
        
        void c(final String p0, final String p1);
        
        void d(final String p0, final String p1);
    }
}
