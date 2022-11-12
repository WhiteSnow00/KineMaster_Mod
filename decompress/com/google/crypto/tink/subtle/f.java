// 
// Decompiled by Procyon v0.6.0
// 

package com.google.crypto.tink.subtle;

import java.util.Arrays;
import java.security.GeneralSecurityException;
import java.security.MessageDigest;

final class f
{
    private static final a a;
    private static final b b;
    static final byte[] c;
    
    static {
        a = new a(new long[] { 1L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L }, new long[] { 1L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L }, new long[] { 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L });
        b = new b(new c(new long[] { 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L }, new long[] { 1L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L }, new long[] { 1L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L }), new long[] { 1L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L });
        c = new byte[] { -19, -45, -11, 92, 26, 99, 18, 88, -42, -100, -9, -94, -34, -7, -34, 20, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 16 };
    }
    
    static int a(final long[] array) {
        return f(array);
    }
    
    private static void b(final b b, final d d, final a a) {
        final long[] array = new long[10];
        final long[] a2 = b.a.a;
        final c a3 = d.a;
        h.o(a2, a3.b, a3.a);
        final long[] b2 = b.a.b;
        final c a4 = d.a;
        h.m(b2, a4.b, a4.a);
        final long[] b3 = b.a.b;
        h.f(b3, b3, a.b);
        final c a5 = b.a;
        h.f(a5.c, a5.a, a.a);
        h.f(b.b, d.b, a.c);
        a.b(b.a.a, d.a.c);
        final long[] a6 = b.a.a;
        h.o(array, a6, a6);
        final c a7 = b.a;
        h.m(a7.a, a7.c, a7.b);
        final c a8 = b.a;
        final long[] b4 = a8.b;
        h.o(b4, a8.c, b4);
        h.o(b.a.c, array, b.b);
        final long[] b5 = b.b;
        h.m(b5, array, b5);
    }
    
    private static void c(final b b, c c) {
        final long[] array = new long[10];
        h.k(b.a.a, c.a);
        h.k(b.a.c, c.b);
        h.k(b.b, c.c);
        final long[] b2 = b.b;
        h.o(b2, b2, b2);
        h.o(b.a.b, c.a, c.b);
        h.k(array, b.a.b);
        c = b.a;
        h.o(c.b, c.c, c.a);
        c = b.a;
        final long[] c2 = c.c;
        h.m(c2, c2, c.a);
        c = b.a;
        h.m(c.a, array, c.b);
        final long[] b3 = b.b;
        h.m(b3, b3, b.a.c);
    }
    
    private static int d(int n, final int n2) {
        n = (~(n ^ n2) & 0xFF);
        n &= n << 4;
        n &= n << 2;
        return (n & n << 1) >> 7 & 0x1;
    }
    
    static byte[] e(byte[] digest) throws GeneralSecurityException {
        final MessageDigest messageDigest = EngineFactory.i.a("SHA-512");
        messageDigest.update(digest, 0, 32);
        digest = messageDigest.digest();
        digest[0] &= (byte)248;
        digest[31] &= 0x7F;
        digest[31] |= 0x40;
        return digest;
    }
    
    private static int f(final long[] array) {
        return h.a(array)[0] & 0x1;
    }
    
    private static void g(final long[] array, final long[] array2) {
        for (int i = 0; i < array2.length; ++i) {
            array[i] = -array2[i];
        }
    }
    
    private static c h(final byte[] array) {
        final byte[] array2 = new byte[64];
        final int n = 0;
        int n2 = 0;
        int n3;
        while (true) {
            n3 = 1;
            if (n2 >= 32) {
                break;
            }
            final int n4 = n2 * 2;
            array2[n4 + 0] = (byte)((array[n2] & 0xFF) >> 0 & 0xF);
            array2[n4 + 1] = (byte)((array[n2] & 0xFF) >> 4 & 0xF);
            ++n2;
        }
        int i = 0;
        int n5 = 0;
        while (i < 63) {
            array2[i] += (byte)n5;
            n5 = array2[i] + 8 >> 4;
            array2[i] -= (byte)(n5 << 4);
            ++i;
        }
        array2[63] += (byte)n5;
        final b b = new b(f.b);
        final d d = new d();
        for (int j = n3; j < 64; j += 2) {
            final a a = new a(f.a);
            j(a, j / 2, array2[j]);
            b(b, f.d.a(d, b), a);
        }
        final c c = new c();
        c(b, f.c.a(c, b));
        c(b, f.c.a(c, b));
        c(b, f.c.a(c, b));
        c(b, f.c.a(c, b));
        for (int k = n; k < 64; k += 2) {
            final a a2 = new a(f.a);
            j(a2, k / 2, array2[k]);
            b(b, f.d.a(d, b), a2);
        }
        final c c2 = new c(b);
        if (c2.b()) {
            return c2;
        }
        throw new IllegalStateException("arithmetic error in scalar multiplication");
    }
    
    static byte[] i(final byte[] array) {
        return h(array).c();
    }
    
    private static void j(final a a, final int n, final byte b) {
        final int n2 = (b & 0xFF) >> 7;
        final int n3 = b - ((-n2 & b) << 1);
        final a[][] d = g.d;
        a.a(d[n][0], d(n3, 1));
        a.a(d[n][1], d(n3, 2));
        a.a(d[n][2], d(n3, 3));
        a.a(d[n][3], d(n3, 4));
        a.a(d[n][4], d(n3, 5));
        a.a(d[n][5], d(n3, 6));
        a.a(d[n][6], d(n3, 7));
        a.a(d[n][7], d(n3, 8));
        final long[] copy = Arrays.copyOf(a.b, 10);
        final long[] copy2 = Arrays.copyOf(a.a, 10);
        final long[] copy3 = Arrays.copyOf(a.c, 10);
        g(copy3, copy3);
        a.a(new a(copy, copy2, copy3), n2);
    }
    
    static class a
    {
        final long[] a;
        final long[] b;
        final long[] c;
        
        a() {
            this(new long[10], new long[10], new long[10]);
        }
        
        a(final a a) {
            this.a = Arrays.copyOf(a.a, 10);
            this.b = Arrays.copyOf(a.b, 10);
            this.c = Arrays.copyOf(a.c, 10);
        }
        
        a(final long[] a, final long[] b, final long[] c) {
            this.a = a;
            this.b = b;
            this.c = c;
        }
        
        void a(final a a, final int n) {
            e.a(this.a, a.a, n);
            e.a(this.b, a.b, n);
            e.a(this.c, a.c, n);
        }
        
        void b(final long[] array, final long[] array2) {
            System.arraycopy(array2, 0, array, 0, 10);
        }
    }
    
    private static class b
    {
        final c a;
        final long[] b;
        
        b(final b b) {
            this.a = new c(b.a);
            this.b = Arrays.copyOf(b.b, 10);
        }
        
        b(final c a, final long[] b) {
            this.a = a;
            this.b = b;
        }
    }
    
    private static class c
    {
        final long[] a;
        final long[] b;
        final long[] c;
        
        c() {
            this(new long[10], new long[10], new long[10]);
        }
        
        c(final b b) {
            this();
            a(this, b);
        }
        
        c(final c c) {
            this.a = Arrays.copyOf(c.a, 10);
            this.b = Arrays.copyOf(c.b, 10);
            this.c = Arrays.copyOf(c.c, 10);
        }
        
        c(final long[] a, final long[] b, final long[] c) {
            this.a = a;
            this.b = b;
            this.c = c;
        }
        
        static c a(final c c, final b b) {
            h.f(c.a, b.a.a, b.b);
            final long[] b2 = c.b;
            final c a = b.a;
            h.f(b2, a.b, a.c);
            h.f(c.c, b.a.c, b.b);
            return c;
        }
        
        boolean b() {
            final long[] array = new long[10];
            h.k(array, this.a);
            final long[] array2 = new long[10];
            h.k(array2, this.b);
            final long[] array3 = new long[10];
            h.k(array3, this.c);
            final long[] array4 = new long[10];
            h.k(array4, array3);
            final long[] array5 = new long[10];
            h.m(array5, array2, array);
            h.f(array5, array5, array3);
            final long[] array6 = new long[10];
            h.f(array6, array, array2);
            h.f(array6, array6, g.a);
            h.n(array6, array4);
            h.h(array6, array6);
            return Bytes.b(h.a(array5), h.a(array6));
        }
        
        byte[] c() {
            final long[] array = new long[10];
            final long[] array2 = new long[10];
            final long[] array3 = new long[10];
            h.e(array, this.c);
            h.f(array2, this.a, array);
            h.f(array3, this.b, array);
            final byte[] a = h.a(array3);
            a[31] ^= (byte)(f.a(array2) << 7);
            return a;
        }
    }
    
    private static class d
    {
        final c a;
        final long[] b;
        
        d() {
            this(new c(), new long[10]);
        }
        
        d(final c a, final long[] b) {
            this.a = a;
            this.b = b;
        }
        
        static d a(final d d, final b b) {
            return b(d, b);
        }
        
        private static d b(final d d, final b b) {
            h.f(d.a.a, b.a.a, b.b);
            final long[] b2 = d.a.b;
            final c a = b.a;
            h.f(b2, a.b, a.c);
            h.f(d.a.c, b.a.c, b.b);
            final long[] b3 = d.b;
            final c a2 = b.a;
            h.f(b3, a2.a, a2.b);
            return d;
        }
    }
}
