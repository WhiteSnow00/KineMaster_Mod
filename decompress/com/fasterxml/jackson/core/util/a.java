// 
// Decompiled by Procyon v0.6.0
// 

package com.fasterxml.jackson.core.util;

public class a
{
    private static final int[] c;
    private static final int[] d;
    protected final byte[][] a;
    protected final char[][] b;
    
    static {
        c = new int[] { 8000, 8000, 2000, 2000 };
        d = new int[] { 4000, 4000, 200, 200 };
    }
    
    public a() {
        this(4, 4);
    }
    
    protected a(final int n, final int n2) {
        this.a = new byte[n][];
        this.b = new char[n2][];
    }
    
    public final byte[] a(final int n) {
        return this.b(n, 0);
    }
    
    public byte[] b(final int n, final int n2) {
        final int f = this.f(n);
        int n3 = n2;
        if (n2 < f) {
            n3 = f;
        }
        final byte[][] a = this.a;
        byte[] e = a[n];
        if (e != null && e.length >= n3) {
            a[n] = null;
        }
        else {
            e = this.e(n3);
        }
        return e;
    }
    
    public final char[] c(final int n) {
        return this.d(n, 0);
    }
    
    public char[] d(final int n, final int n2) {
        final int h = this.h(n);
        int n3 = n2;
        if (n2 < h) {
            n3 = h;
        }
        final char[][] b = this.b;
        char[] g = b[n];
        if (g != null && g.length >= n3) {
            b[n] = null;
        }
        else {
            g = this.g(n3);
        }
        return g;
    }
    
    protected byte[] e(final int n) {
        return new byte[n];
    }
    
    protected int f(final int n) {
        return com.fasterxml.jackson.core.util.a.c[n];
    }
    
    protected char[] g(final int n) {
        return new char[n];
    }
    
    protected int h(final int n) {
        return com.fasterxml.jackson.core.util.a.d[n];
    }
    
    public void i(final int n, final byte[] array) {
        this.a[n] = array;
    }
    
    public void j(final int n, final char[] array) {
        this.b[n] = array;
    }
}
