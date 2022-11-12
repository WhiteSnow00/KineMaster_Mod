// 
// Decompiled by Procyon v0.6.0
// 

package com.fasterxml.jackson.core.io;

import com.fasterxml.jackson.core.util.c;

public final class d
{
    private static final char[] d;
    private static final byte[] e;
    protected com.fasterxml.jackson.core.util.d a;
    protected c b;
    protected final char[] c;
    
    static {
        d = a.d();
        e = a.c();
    }
    
    public d() {
        final char[] c = new char[6];
        (this.c = c)[0] = '\\';
        c[3] = (c[2] = '0');
    }
    
    private int a(int n, int n2, final c c, final int n3) {
        c.k(n3);
        c.c(92);
        if (n2 < 0) {
            c.c(117);
            if (n > 255) {
                n2 = n >> 8;
                final byte[] e = com.fasterxml.jackson.core.io.d.e;
                c.c(e[n2 >> 4]);
                c.c(e[n2 & 0xF]);
                n &= 0xFF;
            }
            else {
                c.c(48);
                c.c(48);
            }
            final byte[] e2 = com.fasterxml.jackson.core.io.d.e;
            c.c(e2[n >> 4]);
            c.c(e2[n & 0xF]);
        }
        else {
            c.c((byte)n2);
        }
        return c.i();
    }
    
    private int b(final int n, final char[] array) {
        array[1] = (char)n;
        return 2;
    }
    
    private int c(final int n, final char[] array) {
        array[1] = 'u';
        final char[] d = com.fasterxml.jackson.core.io.d.d;
        array[4] = d[n >> 4];
        array[5] = d[n & 0xF];
        return 6;
    }
    
    private static int d(final int n, final int n2) {
        if (n2 >= 56320 && n2 <= 57343) {
            return (n - 55296 << 10) + 65536 + (n2 - 56320);
        }
        final StringBuilder sb = new StringBuilder();
        sb.append("Broken surrogate pair: first char 0x");
        sb.append(Integer.toHexString(n));
        sb.append(", second 0x");
        sb.append(Integer.toHexString(n2));
        sb.append("; illegal combination");
        throw new IllegalArgumentException(sb.toString());
    }
    
    private static void e(final int n) {
        throw new IllegalArgumentException(i.d(n));
    }
    
    public byte[] f(final String s) {
        c b;
        if ((b = this.b) == null) {
            b = new c(null);
            this.b = b;
        }
        final int length = s.length();
        byte[] array = b.j();
        int n = array.length;
        int n2 = 0;
        int n3 = 0;
        int n4 = 0;
    Label_0540:
        while (true) {
            n4 = n3;
            if (n2 >= length) {
                break;
            }
            int n5;
            int i;
            int length2;
            for (n5 = n2 + 1, i = s.charAt(n2); i <= 127; i = s.charAt(n5), ++n5, n = length2) {
                int n6;
                if ((n6 = n3) >= (length2 = n)) {
                    array = b.e();
                    length2 = array.length;
                    n6 = 0;
                }
                n3 = n6 + 1;
                array[n6] = (byte)i;
                if (n5 >= length) {
                    n4 = n3;
                    break Label_0540;
                }
            }
            int n7;
            int length3;
            if ((n7 = n3) >= (length3 = n)) {
                array = b.e();
                length3 = array.length;
                n7 = 0;
            }
            int length5 = 0;
            int n14 = 0;
            Label_0489: {
                int n8;
                if (i < 2048) {
                    n8 = n7 + 1;
                    array[n7] = (byte)(i >> 6 | 0xC0);
                }
                else {
                    if (i >= 55296 && i <= 57343) {
                        if (i > 56319) {
                            e(i);
                        }
                        if (n5 >= length) {
                            e(i);
                        }
                        final int d = d(i, s.charAt(n5));
                        if (d > 1114111) {
                            e(d);
                        }
                        final int n9 = n7 + 1;
                        array[n7] = (byte)(d >> 18 | 0xF0);
                        int n10;
                        int length4;
                        if ((n10 = n9) >= (length4 = length3)) {
                            array = b.e();
                            length4 = array.length;
                            n10 = 0;
                        }
                        final int n11 = n10 + 1;
                        array[n10] = (byte)((d >> 12 & 0x3F) | 0x80);
                        int n12;
                        if ((n12 = n11) >= (length5 = length4)) {
                            array = b.e();
                            length5 = array.length;
                            n12 = 0;
                        }
                        array[n12] = (byte)((d >> 6 & 0x3F) | 0x80);
                        i = d;
                        final int n13 = n5 + 1;
                        n14 = n12 + 1;
                        n2 = n13;
                        break Label_0489;
                    }
                    final int n15 = n7 + 1;
                    array[n7] = (byte)(i >> 12 | 0xE0);
                    int length6;
                    if ((n8 = n15) >= (length6 = length3)) {
                        array = b.e();
                        length6 = array.length;
                        n8 = 0;
                    }
                    array[n8] = (byte)((i >> 6 & 0x3F) | 0x80);
                    ++n8;
                    length3 = length6;
                }
                length5 = length3;
                n2 = n5;
                n14 = n8;
            }
            n = length5;
            int n16 = n14;
            if (n14 >= length5) {
                array = b.e();
                n = array.length;
                n16 = 0;
            }
            array[n16] = (byte)((i & 0x3F) | 0x80);
            n3 = n16 + 1;
        }
        return this.b.d(n4);
    }
    
    public char[] g(final String s) {
        com.fasterxml.jackson.core.util.d a;
        if ((a = this.a) == null) {
            a = new com.fasterxml.jackson.core.util.d(null);
            this.a = a;
        }
        char[] array = a.m();
        final int[] e = com.fasterxml.jackson.core.io.a.e();
        final int length = e.length;
        final int length2 = s.length();
        int n = 0;
        int n2 = 0;
        int n3 = 0;
    Label_0284:
        while (true) {
            n3 = n2;
            if (n >= length2) {
                break;
            }
            while (true) {
                final char char1 = s.charAt(n);
                if (char1 < length && e[char1] != 0) {
                    final char char2 = s.charAt(n);
                    final int n4 = e[char2];
                    int n5;
                    if (n4 < 0) {
                        n5 = this.c(char2, this.c);
                    }
                    else {
                        n5 = this.b(n4, this.c);
                    }
                    final int n6 = n2 + n5;
                    if (n6 > array.length) {
                        final int n7 = array.length - n2;
                        if (n7 > 0) {
                            System.arraycopy(this.c, 0, array, n2, n7);
                        }
                        array = a.p();
                        n2 = n5 - n7;
                        System.arraycopy(this.c, n7, array, 0, n2);
                    }
                    else {
                        System.arraycopy(this.c, 0, array, n2, n5);
                        n2 = n6;
                    }
                    ++n;
                    break;
                }
                char[] p = array;
                int n8;
                if ((n8 = n2) >= array.length) {
                    p = a.p();
                    n8 = 0;
                }
                n2 = n8 + 1;
                p[n8] = char1;
                if (++n >= length2) {
                    n3 = n2;
                    break Label_0284;
                }
                array = p;
            }
        }
        a.D(n3);
        return a.g();
    }
    
    public byte[] h(final String s) {
        c b;
        if ((b = this.b) == null) {
            b = new c(null);
            this.b = b;
        }
        final int length = s.length();
        byte[] array = b.j();
        int n = 0;
        int a = 0;
        int n2 = 0;
    Label_0590:
        while (true) {
            n2 = a;
            if (n >= length) {
                break;
            }
            final int[] e = com.fasterxml.jackson.core.io.a.e();
            byte[] array2 = array;
            while (true) {
                final char char1 = s.charAt(n);
                if (char1 <= '\u007f' && e[char1] == 0) {
                    byte[] e2 = array2;
                    int n3;
                    if ((n3 = a) >= array2.length) {
                        e2 = b.e();
                        n3 = 0;
                    }
                    a = n3 + 1;
                    e2[n3] = (byte)char1;
                    if (++n >= length) {
                        n2 = a;
                        break Label_0590;
                    }
                    array2 = e2;
                }
                else {
                    byte[] array3 = array2;
                    int n4;
                    if ((n4 = a) >= array2.length) {
                        array3 = b.e();
                        n4 = 0;
                    }
                    final int n5 = n + 1;
                    final char char2 = s.charAt(n);
                    if (char2 <= '\u007f') {
                        a = this.a(char2, e[char2], b, n4);
                        array = b.h();
                        n = n5;
                        break;
                    }
                    int n6 = 0;
                    int n12 = 0;
                    Label_0546: {
                        int n7;
                        if (char2 <= '\u07ff') {
                            n6 = n4 + 1;
                            array3[n4] = (byte)(char2 >> 6 | 0xC0);
                            n7 = ((char2 & '?') | 0x80);
                        }
                        else {
                            if (char2 >= '\ud800' && char2 <= '\udfff') {
                                if (char2 > '\udbff') {
                                    e(char2);
                                }
                                if (n5 >= length) {
                                    e(char2);
                                }
                                final int d = d(char2, s.charAt(n5));
                                if (d > 1114111) {
                                    e(d);
                                }
                                final int n8 = n4 + 1;
                                array3[n4] = (byte)(d >> 18 | 0xF0);
                                byte[] e3 = array3;
                                int n9;
                                if ((n9 = n8) >= array3.length) {
                                    e3 = b.e();
                                    n9 = 0;
                                }
                                final int n10 = n9 + 1;
                                e3[n9] = (byte)((d >> 12 & 0x3F) | 0x80);
                                array3 = e3;
                                if ((n6 = n10) >= e3.length) {
                                    array3 = b.e();
                                    n6 = 0;
                                }
                                array3[n6] = (byte)((d >> 6 & 0x3F) | 0x80);
                                final int n11 = (d & 0x3F) | 0x80;
                                n = n5 + 1;
                                ++n6;
                                n12 = n11;
                                break Label_0546;
                            }
                            final int n13 = n4 + 1;
                            array3[n4] = (byte)(char2 >> 12 | 0xE0);
                            byte[] e4 = array3;
                            if ((n6 = n13) >= array3.length) {
                                e4 = b.e();
                                n6 = 0;
                            }
                            e4[n6] = (byte)((char2 >> 6 & 0x3F) | 0x80);
                            n7 = ((char2 & '?') | 0x80);
                            ++n6;
                            array3 = e4;
                        }
                        final int n14 = n7;
                        n = n5;
                        n12 = n14;
                    }
                    byte[] e5 = array3;
                    int n15 = n6;
                    if (n6 >= array3.length) {
                        e5 = b.e();
                        n15 = 0;
                    }
                    e5[n15] = (byte)n12;
                    a = n15 + 1;
                    array = e5;
                    break;
                }
            }
        }
        return this.b.d(n2);
    }
}
