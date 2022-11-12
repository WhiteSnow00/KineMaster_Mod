// 
// Decompiled by Procyon v0.6.0
// 

package com.fasterxml.jackson.core.util;

import com.fasterxml.jackson.core.io.d;
import java.lang.ref.SoftReference;

public class b
{
    private static final e a;
    protected static final ThreadLocal<SoftReference<a>> b;
    protected static final ThreadLocal<SoftReference<d>> c;
    
    static {
        e a2;
        if ("true".equals(System.getProperty("com.fasterxml.jackson.core.util.BufferRecyclers.trackReusableBuffers"))) {
            a2 = e.a();
        }
        else {
            a2 = null;
        }
        a = a2;
        b = new ThreadLocal<SoftReference<a>>();
        c = new ThreadLocal<SoftReference<d>>();
    }
    
    public static byte[] a(final String s) {
        return c().f(s);
    }
    
    public static a b() {
        final ThreadLocal<SoftReference<a>> b = com.fasterxml.jackson.core.util.b.b;
        final SoftReference softReference = b.get();
        a a;
        if (softReference == null) {
            a = null;
        }
        else {
            a = (a)softReference.get();
        }
        a a2 = a;
        if (a == null) {
            a2 = new a();
            final e a3 = com.fasterxml.jackson.core.util.b.a;
            SoftReference<a> c;
            if (a3 != null) {
                c = a3.c(a2);
            }
            else {
                c = new SoftReference<a>(a2);
            }
            b.set(c);
        }
        return a2;
    }
    
    public static d c() {
        final ThreadLocal<SoftReference<d>> c = com.fasterxml.jackson.core.util.b.c;
        final SoftReference softReference = c.get();
        d d;
        if (softReference == null) {
            d = null;
        }
        else {
            d = (d)softReference.get();
        }
        d d2 = d;
        if (d == null) {
            d2 = new d();
            c.set(new SoftReference<d>(d2));
        }
        return d2;
    }
    
    public static char[] d(final String s) {
        return c().g(s);
    }
    
    public static byte[] e(final String s) {
        return c().h(s);
    }
}
