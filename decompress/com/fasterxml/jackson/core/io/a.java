// 
// Decompiled by Procyon v0.6.0
// 

package com.fasterxml.jackson.core.io;

import java.util.Arrays;

public final class a
{
    private static final char[] a;
    private static final byte[] b;
    private static final int[] c;
    private static final int[] d;
    private static final int[] e;
    private static final int[] f;
    private static final int[] g;
    private static final int[] h;
    private static final int[] i;
    private static final int[] j;
    
    static {
        final int length = (a = "0123456789ABCDEF".toCharArray()).length;
        b = new byte[length];
        final int n = 0;
        for (int k = 0; k < length; ++k) {
            com.fasterxml.jackson.core.io.a.b[k] = (byte)com.fasterxml.jackson.core.io.a.a[k];
        }
        final int[] c2 = new int[256];
        for (int l = 0; l < 32; ++l) {
            c2[l] = -1;
        }
        c2[92] = (c2[34] = 1);
        c = c2;
        final int length2 = c2.length;
        final int[] d2 = new int[length2];
        System.arraycopy(c2, 0, d2, 0, length2);
        for (int n2 = 128; n2 < 256; ++n2) {
            int n3;
            if ((n2 & 0xE0) == 0xC0) {
                n3 = 2;
            }
            else if ((n2 & 0xF0) == 0xE0) {
                n3 = 3;
            }
            else if ((n2 & 0xF8) == 0xF0) {
                n3 = 4;
            }
            else {
                n3 = -1;
            }
            d2[n2] = n3;
        }
        d = d2;
        final int[] e2 = new int[256];
        Arrays.fill(e2, -1);
        for (int n4 = 33; n4 < 256; ++n4) {
            if (Character.isJavaIdentifierPart((char)n4)) {
                e2[n4] = 0;
            }
        }
        e2[64] = 0;
        e2[42] = (e2[35] = 0);
        e2[43] = (e2[45] = 0);
        e = e2;
        final int[] f2 = new int[256];
        System.arraycopy(e2, 0, f2, 0, 256);
        Arrays.fill(f2, 128, 128, 0);
        f = f2;
        final int[] g2 = new int[256];
        final int[] d3 = com.fasterxml.jackson.core.io.a.d;
        System.arraycopy(d3, 128, g2, 128, 128);
        Arrays.fill(g2, 0, 32, -1);
        g2[9] = 0;
        g2[10] = 10;
        g2[13] = 13;
        g2[42] = 42;
        g = g2;
        final int[] h2 = new int[256];
        System.arraycopy(d3, 128, h2, 128, 128);
        Arrays.fill(h2, 0, 32, -1);
        h2[9] = (h2[32] = 1);
        h2[10] = 10;
        h2[13] = 13;
        h2[47] = 47;
        h2[35] = 35;
        h = h2;
        final int[] m = new int[128];
        for (int n5 = 0; n5 < 32; ++n5) {
            m[n5] = -1;
        }
        m[34] = 34;
        m[92] = 92;
        m[8] = 98;
        m[9] = 116;
        m[12] = 102;
        m[10] = 110;
        m[13] = 114;
        i = m;
        Arrays.fill(j = new int[128], -1);
        int n6 = 0;
        int n7;
        while (true) {
            n7 = n;
            if (n6 >= 10) {
                break;
            }
            com.fasterxml.jackson.core.io.a.j[n6 + 48] = n6;
            ++n6;
        }
        while (n7 < 6) {
            final int[] j2 = com.fasterxml.jackson.core.io.a.j;
            j2[n7 + 65] = (j2[n7 + 97] = n7 + 10);
            ++n7;
        }
    }
    
    public static void a(final StringBuilder sb, final String s) {
        final int[] i = com.fasterxml.jackson.core.io.a.i;
        final int length = i.length;
        for (int length2 = s.length(), j = 0; j < length2; ++j) {
            final char char1 = s.charAt(j);
            if (char1 < length && i[char1] != 0) {
                sb.append('\\');
                final int n = i[char1];
                if (n < 0) {
                    sb.append('u');
                    sb.append('0');
                    sb.append('0');
                    final char[] a = com.fasterxml.jackson.core.io.a.a;
                    sb.append(a[char1 >> 4]);
                    sb.append(a[char1 & '\u000f']);
                }
                else {
                    sb.append((char)n);
                }
            }
            else {
                sb.append(char1);
            }
        }
    }
    
    public static int b(int n) {
        if (n > 127) {
            n = -1;
        }
        else {
            n = com.fasterxml.jackson.core.io.a.j[n];
        }
        return n;
    }
    
    public static byte[] c() {
        return com.fasterxml.jackson.core.io.a.b.clone();
    }
    
    public static char[] d() {
        return com.fasterxml.jackson.core.io.a.a.clone();
    }
    
    public static int[] e() {
        return com.fasterxml.jackson.core.io.a.i;
    }
    
    public static int[] f() {
        return com.fasterxml.jackson.core.io.a.g;
    }
    
    public static int[] g() {
        return com.fasterxml.jackson.core.io.a.c;
    }
    
    public static int[] h() {
        return com.fasterxml.jackson.core.io.a.e;
    }
    
    public static int[] i() {
        return com.fasterxml.jackson.core.io.a.d;
    }
    
    public static int[] j() {
        return com.fasterxml.jackson.core.io.a.f;
    }
}
