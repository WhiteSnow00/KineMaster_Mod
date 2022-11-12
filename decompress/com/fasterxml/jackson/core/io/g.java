// 
// Decompiled by Procyon v0.6.0
// 

package com.fasterxml.jackson.core.io;

public final class g
{
    private static int a = 1000000;
    private static int b = 1000000000;
    private static long c = 1000000000L;
    private static long d = -2147483648L;
    private static long e = 2147483647L;
    static final String f;
    static final String g;
    private static final int[] h;
    private static final String[] i;
    private static final String[] j;
    
    static {
        f = String.valueOf(Integer.MIN_VALUE);
        g = String.valueOf(Long.MIN_VALUE);
        h = new int[1000];
        int k = 0;
        int n = 0;
        while (k < 10) {
            for (int l = 0; l < 10; ++l) {
                for (int n2 = 0; n2 < 10; ++n2, ++n) {
                    com.fasterxml.jackson.core.io.g.h[n] = (k + 48 << 16 | l + 48 << 8 | n2 + 48);
                }
            }
            ++k;
        }
        i = new String[] { "0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10" };
        j = new String[] { "-1", "-2", "-3", "-4", "-5", "-6", "-7", "-8", "-9", "-10" };
    }
    
    private static int a(int n, final byte[] array, int n2) {
        n = com.fasterxml.jackson.core.io.g.h[n];
        final int n3 = n2 + 1;
        array[n2] = (byte)(n >> 16);
        n2 = n3 + 1;
        array[n3] = (byte)(n >> 8);
        array[n2] = (byte)n;
        return n2 + 1;
    }
    
    private static int b(int n, final char[] array, int n2) {
        n = com.fasterxml.jackson.core.io.g.h[n];
        final int n3 = n2 + 1;
        array[n2] = (char)(n >> 16);
        n2 = n3 + 1;
        array[n3] = (char)(n >> 8 & 0x7F);
        array[n2] = (char)(n & 0x7F);
        return n2 + 1;
    }
    
    private static int c(final int n, final byte[] array, final int n2) {
        final int n3 = com.fasterxml.jackson.core.io.g.h[n];
        int n4 = n2;
        if (n > 9) {
            n4 = n2;
            if (n > 99) {
                array[n2] = (byte)(n3 >> 16);
                n4 = n2 + 1;
            }
            array[n4] = (byte)(n3 >> 8);
            ++n4;
        }
        array[n4] = (byte)n3;
        return n4 + 1;
    }
    
    private static int d(final int n, final char[] array, final int n2) {
        final int n3 = com.fasterxml.jackson.core.io.g.h[n];
        int n4 = n2;
        if (n > 9) {
            n4 = n2;
            if (n > 99) {
                array[n2] = (char)(n3 >> 16);
                n4 = n2 + 1;
            }
            array[n4] = (char)(n3 >> 8 & 0x7F);
            ++n4;
        }
        array[n4] = (char)(n3 & 0x7F);
        return n4 + 1;
    }
    
    private static int e(int n, final byte[] array, int n2) {
        final int n3 = n / 1000;
        final int n4 = n3 / 1000;
        final int[] h = com.fasterxml.jackson.core.io.g.h;
        final int n5 = h[n4];
        final int n6 = n2 + 1;
        array[n2] = (byte)(n5 >> 16);
        final int n7 = n6 + 1;
        array[n6] = (byte)(n5 >> 8);
        n2 = n7 + 1;
        array[n7] = (byte)n5;
        final int n8 = h[n3 - n4 * 1000];
        final int n9 = n2 + 1;
        array[n2] = (byte)(n8 >> 16);
        final int n10 = n9 + 1;
        array[n9] = (byte)(n8 >> 8);
        n2 = n10 + 1;
        array[n10] = (byte)n8;
        n = h[n - n3 * 1000];
        final int n11 = n2 + 1;
        array[n2] = (byte)(n >> 16);
        n2 = n11 + 1;
        array[n11] = (byte)(n >> 8);
        array[n2] = (byte)n;
        return n2 + 1;
    }
    
    private static int f(int n, final char[] array, int n2) {
        final int n3 = n / 1000;
        final int n4 = n3 / 1000;
        final int[] h = com.fasterxml.jackson.core.io.g.h;
        final int n5 = h[n4];
        final int n6 = n2 + 1;
        array[n2] = (char)(n5 >> 16);
        final int n7 = n6 + 1;
        array[n6] = (char)(n5 >> 8 & 0x7F);
        n2 = n7 + 1;
        array[n7] = (char)(n5 & 0x7F);
        final int n8 = h[n3 - n4 * 1000];
        final int n9 = n2 + 1;
        array[n2] = (char)(n8 >> 16);
        final int n10 = n9 + 1;
        array[n9] = (char)(n8 >> 8 & 0x7F);
        n2 = n10 + 1;
        array[n10] = (char)(n8 & 0x7F);
        final int n11 = h[n - n3 * 1000];
        n = n2 + 1;
        array[n2] = (char)(n11 >> 16);
        n2 = n + 1;
        array[n] = (char)(n11 >> 8 & 0x7F);
        array[n2] = (char)(n11 & 0x7F);
        return n2 + 1;
    }
    
    private static int g(final byte[] array, int n) {
        for (int length = com.fasterxml.jackson.core.io.g.f.length(), i = 0; i < length; ++i, ++n) {
            array[n] = (byte)com.fasterxml.jackson.core.io.g.f.charAt(i);
        }
        return n;
    }
    
    private static int h(final char[] array, final int n) {
        final String f = com.fasterxml.jackson.core.io.g.f;
        final int length = f.length();
        f.getChars(0, length, array, n);
        return n + length;
    }
    
    private static int i(final byte[] array, int n) {
        for (int length = com.fasterxml.jackson.core.io.g.g.length(), i = 0; i < length; ++i, ++n) {
            array[n] = (byte)com.fasterxml.jackson.core.io.g.g.charAt(i);
        }
        return n;
    }
    
    private static int j(final char[] array, final int n) {
        final String g = com.fasterxml.jackson.core.io.g.g;
        final int length = g.length();
        g.getChars(0, length, array, n);
        return n + length;
    }
    
    private static int k(int n, final byte[] array, int n2) {
        if (n >= com.fasterxml.jackson.core.io.g.a) {
            final int n3 = n / 1000;
            final int n4 = n3 / 1000;
            final int c = c(n4, array, n2);
            final int[] h = com.fasterxml.jackson.core.io.g.h;
            final int n5 = h[n3 - n4 * 1000];
            n2 = c + 1;
            array[c] = (byte)(n5 >> 16);
            final int n6 = n2 + 1;
            array[n2] = (byte)(n5 >> 8);
            n2 = n6 + 1;
            array[n6] = (byte)n5;
            final int n7 = h[n - n3 * 1000];
            n = n2 + 1;
            array[n2] = (byte)(n7 >> 16);
            n2 = n + 1;
            array[n] = (byte)(n7 >> 8);
            array[n2] = (byte)n7;
            return n2 + 1;
        }
        if (n < 1000) {
            return c(n, array, n2);
        }
        final int n8 = n / 1000;
        return m(array, n2, n8, n - n8 * 1000);
    }
    
    private static int l(int n, final char[] array, int n2) {
        if (n >= com.fasterxml.jackson.core.io.g.a) {
            final int n3 = n / 1000;
            final int n4 = n3 / 1000;
            final int d = d(n4, array, n2);
            final int[] h = com.fasterxml.jackson.core.io.g.h;
            n2 = h[n3 - n4 * 1000];
            final int n5 = d + 1;
            array[d] = (char)(n2 >> 16);
            final int n6 = n5 + 1;
            array[n5] = (char)(n2 >> 8 & 0x7F);
            final int n7 = n6 + 1;
            array[n6] = (char)(n2 & 0x7F);
            n = h[n - n3 * 1000];
            n2 = n7 + 1;
            array[n7] = (char)(n >> 16);
            final int n8 = n2 + 1;
            array[n2] = (char)(n >> 8 & 0x7F);
            array[n8] = (char)(n & 0x7F);
            return n8 + 1;
        }
        if (n < 1000) {
            return d(n, array, n2);
        }
        final int n9 = n / 1000;
        return n(array, n2, n9, n - n9 * 1000);
    }
    
    private static int m(final byte[] array, int n, int n2, int n3) {
        final int[] h = com.fasterxml.jackson.core.io.g.h;
        final int n4 = h[n2];
        int n5 = n;
        if (n2 > 9) {
            n5 = n;
            if (n2 > 99) {
                array[n] = (byte)(n4 >> 16);
                n5 = n + 1;
            }
            array[n5] = (byte)(n4 >> 8);
            ++n5;
        }
        n = n5 + 1;
        array[n5] = (byte)n4;
        n3 = h[n3];
        n2 = n + 1;
        array[n] = (byte)(n3 >> 16);
        n = n2 + 1;
        array[n2] = (byte)(n3 >> 8);
        array[n] = (byte)n3;
        return n + 1;
    }
    
    private static int n(final char[] array, int n, int n2, int n3) {
        final int[] h = com.fasterxml.jackson.core.io.g.h;
        final int n4 = h[n2];
        int n5 = n;
        if (n2 > 9) {
            n5 = n;
            if (n2 > 99) {
                array[n] = (char)(n4 >> 16);
                n5 = n + 1;
            }
            array[n5] = (char)(n4 >> 8 & 0x7F);
            ++n5;
        }
        n = n5 + 1;
        array[n5] = (char)(n4 & 0x7F);
        n2 = h[n3];
        n3 = n + 1;
        array[n] = (char)(n2 >> 16);
        n = n3 + 1;
        array[n3] = (char)(n2 >> 8 & 0x7F);
        array[n] = (char)(n2 & 0x7F);
        return n + 1;
    }
    
    public static int o(int n, final byte[] array, int n2) {
        int n3 = n;
        int n4 = n2;
        if (n < 0) {
            if (n == Integer.MIN_VALUE) {
                return g(array, n2);
            }
            array[n2] = 45;
            n3 = -n;
            n4 = n2 + 1;
        }
        if (n3 < com.fasterxml.jackson.core.io.g.a) {
            if (n3 < 1000) {
                if (n3 < 10) {
                    n = n4 + 1;
                    array[n4] = (byte)(n3 + 48);
                }
                else {
                    n = c(n3, array, n4);
                }
            }
            else {
                n = n3 / 1000;
                n = a(n3 - n * 1000, array, c(n, array, n4));
            }
            return n;
        }
        n = com.fasterxml.jackson.core.io.g.b;
        if (n3 >= n) {
            n2 = n3 - n;
            if (n2 >= n) {
                n2 -= n;
                n = n4 + 1;
                array[n4] = 50;
            }
            else {
                n = n4 + 1;
                array[n4] = 49;
            }
            return e(n2, array, n);
        }
        n2 = n3 / 1000;
        n = n2 / 1000;
        return a(n3 - n2 * 1000, array, a(n2 - n * 1000, array, c(n, array, n4)));
    }
    
    public static int p(int n, final char[] array, int b) {
        int n2 = n;
        int n3 = b;
        if (n < 0) {
            if (n == Integer.MIN_VALUE) {
                return h(array, b);
            }
            array[b] = '-';
            n2 = -n;
            n3 = b + 1;
        }
        if (n2 < com.fasterxml.jackson.core.io.g.a) {
            if (n2 >= 1000) {
                n = n2 / 1000;
                return b(n2 - n * 1000, array, d(n, array, n3));
            }
            if (n2 < 10) {
                array[n3] = (char)(n2 + 48);
                return n3 + 1;
            }
            return d(n2, array, n3);
        }
        else {
            b = com.fasterxml.jackson.core.io.g.b;
            if (n2 >= b) {
                n = n2 - b;
                if (n >= b) {
                    n -= b;
                    b = n3 + 1;
                    array[n3] = '2';
                }
                else {
                    b = n3 + 1;
                    array[n3] = '1';
                }
                return f(n, array, b);
            }
            b = n2 / 1000;
            n = b / 1000;
            return b(n2 - b * 1000, array, b(b - n * 1000, array, d(n, array, n3)));
        }
    }
    
    public static int q(long n, final byte[] array, int n2) {
        long n3;
        int n4;
        if (n < 0L) {
            if (n > com.fasterxml.jackson.core.io.g.d) {
                return o((int)n, array, n2);
            }
            if (n == Long.MIN_VALUE) {
                return i(array, n2);
            }
            array[n2] = 45;
            n3 = -n;
            n4 = n2 + 1;
        }
        else {
            n3 = n;
            n4 = n2;
            if (n <= com.fasterxml.jackson.core.io.g.e) {
                return o((int)n, array, n2);
            }
        }
        final long c = com.fasterxml.jackson.core.io.g.c;
        n = n3 / c;
        if (n < c) {
            n2 = k((int)n, array, n4);
        }
        else {
            final long n5 = n / c;
            n2 = c((int)n5, array, n4);
            n2 = e((int)(n - c * n5), array, n2);
        }
        return e((int)(n3 - n * c), array, n2);
    }
    
    public static int r(long n, final char[] array, int n2) {
        long n3;
        int n4;
        if (n < 0L) {
            if (n > com.fasterxml.jackson.core.io.g.d) {
                return p((int)n, array, n2);
            }
            if (n == Long.MIN_VALUE) {
                return j(array, n2);
            }
            array[n2] = '-';
            n3 = -n;
            n4 = n2 + 1;
        }
        else {
            n3 = n;
            n4 = n2;
            if (n <= com.fasterxml.jackson.core.io.g.e) {
                return p((int)n, array, n2);
            }
        }
        final long c = com.fasterxml.jackson.core.io.g.c;
        n = n3 / c;
        if (n < c) {
            n2 = l((int)n, array, n4);
        }
        else {
            final long n5 = n / c;
            n2 = d((int)n5, array, n4);
            n2 = f((int)(n - c * n5), array, n2);
        }
        return f((int)(n3 - n * c), array, n2);
    }
}
