// 
// Decompiled by Procyon v0.6.0
// 

package com.google.crypto.tink.subtle;

import java.util.Arrays;
import com.google.crypto.tink.annotations.Alpha;

@Alpha
final class h
{
    private static final int[] a;
    private static final int[] b;
    private static final int[] c;
    private static final int[] d;
    
    static {
        a = new int[] { 0, 3, 6, 9, 12, 16, 19, 22, 25, 28 };
        b = new int[] { 0, 2, 3, 5, 6, 0, 1, 3, 4, 6 };
        c = new int[] { 67108863, 33554431 };
        d = new int[] { 26, 25 };
    }
    
    static byte[] a(long[] copy) {
        copy = Arrays.copyOf(copy, 10);
        final int n = 0;
        for (int i = 0; i < 2; ++i) {
            int n5;
            for (int j = 0; j < 9; ++j, copy[j] -= n5) {
                final long n2 = copy[j];
                final long n3 = copy[j];
                final int[] d = h.d;
                final int n4 = j & 0x1;
                n5 = -(int)((n2 & n3 >> 31) >> d[n4]);
                copy[j] += n5 << d[n4];
            }
            final int n6 = -(int)((copy[9] >> 31 & copy[9]) >> 25);
            copy[9] += n6 << 25;
            copy[0] -= n6 * 19;
        }
        final int n7 = -(int)((copy[0] & copy[0] >> 31) >> 26);
        copy[0] += n7 << 26;
        copy[1] -= n7;
        for (int k = 0; k < 2; ++k) {
            int n10;
            for (int l = 0; l < 9; ++l, copy[l] += n10) {
                final long n8 = copy[l];
                final int[] d2 = h.d;
                final int n9 = l & 0x1;
                n10 = (int)(n8 >> d2[n9]);
                copy[l] &= h.c[n9];
            }
        }
        final int n11 = (int)(copy[9] >> 25);
        copy[9] &= 0x1FFFFFFL;
        copy[0] += n11 * 19;
        int d3 = d((int)copy[0], 67108845);
        for (int n12 = 1; n12 < 10; ++n12) {
            d3 &= b((int)copy[n12], h.c[n12 & 0x1]);
        }
        copy[0] -= (0x3FFFFED & d3);
        final long n13 = copy[1];
        final long n14 = 0x1FFFFFF & d3;
        copy[1] = n13 - n14;
        for (int n15 = 2; n15 < 10; n15 += 2) {
            copy[n15] -= (0x3FFFFFF & d3);
            final int n16 = n15 + 1;
            copy[n16] -= n14;
        }
        for (int n17 = 0; n17 < 10; ++n17) {
            copy[n17] <<= h.b[n17];
        }
        final byte[] array = new byte[32];
        for (int n18 = n; n18 < 10; ++n18) {
            final int[] a = h.a;
            final int n19 = a[n18];
            array[n19] = (byte)((long)array[n19] | (copy[n18] & 0xFFL));
            final int n20 = a[n18] + 1;
            array[n20] = (byte)((long)array[n20] | (copy[n18] >> 8 & 0xFFL));
            final int n21 = a[n18] + 2;
            array[n21] = (byte)((long)array[n21] | (copy[n18] >> 16 & 0xFFL));
            final int n22 = a[n18] + 3;
            array[n22] = (byte)((long)array[n22] | (copy[n18] >> 24 & 0xFFL));
        }
        return array;
    }
    
    private static int b(int n, final int n2) {
        n = ~(n ^ n2);
        n &= n << 16;
        n &= n << 8;
        n &= n << 4;
        n &= n << 2;
        return (n & n << 1) >> 31;
    }
    
    static long[] c(final byte[] array) {
        final long[] array2 = new long[10];
        for (int i = 0; i < 10; ++i) {
            final int[] a = h.a;
            array2[i] = (((long)(array[a[i]] & 0xFF) | (long)(array[a[i] + 1] & 0xFF) << 8 | (long)(array[a[i] + 2] & 0xFF) << 16 | (long)(array[a[i] + 3] & 0xFF) << 24) >> h.b[i] & (long)h.c[i & 0x1]);
        }
        return array2;
    }
    
    private static int d(final int n, final int n2) {
        return ~(n - n2 >> 31);
    }
    
    static void e(final long[] array, final long[] array2) {
        final long[] array3 = new long[10];
        final long[] array4 = new long[10];
        final long[] array5 = new long[10];
        final long[] array6 = new long[10];
        final long[] array7 = new long[10];
        final long[] array8 = new long[10];
        final long[] array9 = new long[10];
        final long[] array10 = new long[10];
        final long[] array11 = new long[10];
        final long[] array12 = new long[10];
        k(array3, array2);
        k(array12, array3);
        k(array11, array12);
        f(array4, array11, array2);
        f(array5, array4, array3);
        k(array11, array5);
        f(array6, array11, array4);
        k(array11, array6);
        k(array12, array11);
        k(array11, array12);
        k(array12, array11);
        k(array11, array12);
        f(array7, array11, array6);
        k(array11, array7);
        k(array12, array11);
        final int n = 2;
        for (int i = 2; i < 10; i += 2) {
            k(array11, array12);
            k(array12, array11);
        }
        f(array8, array12, array7);
        k(array11, array8);
        k(array12, array11);
        for (int j = 2; j < 20; j += 2) {
            k(array11, array12);
            k(array12, array11);
        }
        f(array11, array12, array8);
        k(array12, array11);
        k(array11, array12);
        for (int k = 2; k < 10; k += 2) {
            k(array12, array11);
            k(array11, array12);
        }
        f(array9, array11, array7);
        k(array11, array9);
        k(array12, array11);
        for (int l = 2; l < 50; l += 2) {
            k(array11, array12);
            k(array12, array11);
        }
        f(array10, array12, array9);
        k(array12, array10);
        k(array11, array12);
        for (int n2 = 2; n2 < 100; n2 += 2) {
            k(array12, array11);
            k(array11, array12);
        }
        f(array12, array11, array10);
        k(array11, array12);
        k(array12, array11);
        for (int n3 = n; n3 < 50; n3 += 2) {
            k(array11, array12);
            k(array12, array11);
        }
        f(array11, array12, array9);
        k(array12, array11);
        k(array11, array12);
        k(array12, array11);
        k(array11, array12);
        k(array12, array11);
        f(array, array12, array5);
    }
    
    static void f(final long[] array, final long[] array2, final long[] array3) {
        final long[] array4 = new long[19];
        g(array4, array2, array3);
        h(array4, array);
    }
    
    static void g(final long[] array, final long[] array2, final long[] array3) {
        array[0] = array2[0] * array3[0];
        array[1] = array2[0] * array3[1] + array2[1] * array3[0];
        array[2] = array2[1] * 2L * array3[1] + array2[0] * array3[2] + array2[2] * array3[0];
        array[3] = array2[1] * array3[2] + array2[2] * array3[1] + array2[0] * array3[3] + array2[3] * array3[0];
        array[4] = array2[2] * array3[2] + (array2[1] * array3[3] + array2[3] * array3[1]) * 2L + array2[0] * array3[4] + array2[4] * array3[0];
        array[5] = array2[2] * array3[3] + array2[3] * array3[2] + array2[1] * array3[4] + array2[4] * array3[1] + array2[0] * array3[5] + array2[5] * array3[0];
        array[6] = (array2[3] * array3[3] + array2[1] * array3[5] + array2[5] * array3[1]) * 2L + array2[2] * array3[4] + array2[4] * array3[2] + array2[0] * array3[6] + array2[6] * array3[0];
        array[7] = array2[3] * array3[4] + array2[4] * array3[3] + array2[2] * array3[5] + array2[5] * array3[2] + array2[1] * array3[6] + array2[6] * array3[1] + array2[0] * array3[7] + array2[7] * array3[0];
        array[8] = array2[4] * array3[4] + (array2[3] * array3[5] + array2[5] * array3[3] + array2[1] * array3[7] + array2[7] * array3[1]) * 2L + array2[2] * array3[6] + array2[6] * array3[2] + array2[0] * array3[8] + array2[8] * array3[0];
        array[9] = array2[4] * array3[5] + array2[5] * array3[4] + array2[3] * array3[6] + array2[6] * array3[3] + array2[2] * array3[7] + array2[7] * array3[2] + array2[1] * array3[8] + array2[8] * array3[1] + array2[0] * array3[9] + array2[9] * array3[0];
        array[10] = (array2[5] * array3[5] + array2[3] * array3[7] + array2[7] * array3[3] + array2[1] * array3[9] + array2[9] * array3[1]) * 2L + array2[4] * array3[6] + array2[6] * array3[4] + array2[2] * array3[8] + array2[8] * array3[2];
        array[11] = array2[5] * array3[6] + array2[6] * array3[5] + array2[4] * array3[7] + array2[7] * array3[4] + array2[3] * array3[8] + array2[8] * array3[3] + array2[2] * array3[9] + array2[9] * array3[2];
        array[12] = array2[6] * array3[6] + (array2[5] * array3[7] + array2[7] * array3[5] + array2[3] * array3[9] + array2[9] * array3[3]) * 2L + array2[4] * array3[8] + array2[8] * array3[4];
        array[13] = array2[6] * array3[7] + array2[7] * array3[6] + array2[5] * array3[8] + array2[8] * array3[5] + array2[4] * array3[9] + array2[9] * array3[4];
        array[14] = (array2[7] * array3[7] + array2[5] * array3[9] + array2[9] * array3[5]) * 2L + array2[6] * array3[8] + array2[8] * array3[6];
        array[15] = array2[7] * array3[8] + array2[8] * array3[7] + array2[6] * array3[9] + array2[9] * array3[6];
        array[16] = array2[8] * array3[8] + (array2[7] * array3[9] + array2[9] * array3[7]) * 2L;
        array[17] = array2[8] * array3[9] + array2[9] * array3[8];
        array[18] = array2[9] * 2L * array3[9];
    }
    
    static void h(long[] array, final long[] array2) {
        if (array.length != 19) {
            final long[] array3 = new long[19];
            System.arraycopy(array, 0, array3, 0, array.length);
            array = array3;
        }
        j(array);
        i(array);
        System.arraycopy(array, 0, array2, 0, 10);
    }
    
    static void i(final long[] array) {
        array[10] = 0L;
        long n3;
        for (int i = 0; i < 10; i += 2, array[i] += n3) {
            final long n = array[i] / 67108864L;
            array[i] -= n << 26;
            final int n2 = i + 1;
            array[n2] += n;
            n3 = array[n2] / 33554432L;
            array[n2] -= n3 << 25;
        }
        array[0] += array[10] << 4;
        array[0] += array[10] << 1;
        array[0] += array[10];
        array[10] = 0L;
        final long n4 = array[0] / 67108864L;
        array[0] -= n4 << 26;
        array[1] += n4;
    }
    
    static void j(final long[] array) {
        array[8] += array[18] << 4;
        array[8] += array[18] << 1;
        array[8] += array[18];
        array[7] += array[17] << 4;
        array[7] += array[17] << 1;
        array[7] += array[17];
        array[6] += array[16] << 4;
        array[6] += array[16] << 1;
        array[6] += array[16];
        array[5] += array[15] << 4;
        array[5] += array[15] << 1;
        array[5] += array[15];
        array[4] += array[14] << 4;
        array[4] += array[14] << 1;
        array[4] += array[14];
        array[3] += array[13] << 4;
        array[3] += array[13] << 1;
        array[3] += array[13];
        array[2] += array[12] << 4;
        array[2] += array[12] << 1;
        array[2] += array[12];
        array[1] += array[11] << 4;
        array[1] += array[11] << 1;
        array[1] += array[11];
        array[0] += array[10] << 4;
        array[0] += array[10] << 1;
        array[0] += array[10];
    }
    
    static void k(final long[] array, final long[] array2) {
        final long[] array3 = new long[19];
        l(array3, array2);
        h(array3, array);
    }
    
    private static void l(final long[] array, final long[] array2) {
        array[0] = array2[0] * array2[0];
        array[1] = array2[0] * 2L * array2[1];
        array[2] = (array2[1] * array2[1] + array2[0] * array2[2]) * 2L;
        array[3] = (array2[1] * array2[2] + array2[0] * array2[3]) * 2L;
        array[4] = array2[2] * array2[2] + array2[1] * 4L * array2[3] + array2[0] * 2L * array2[4];
        array[5] = (array2[2] * array2[3] + array2[1] * array2[4] + array2[0] * array2[5]) * 2L;
        array[6] = (array2[3] * array2[3] + array2[2] * array2[4] + array2[0] * array2[6] + array2[1] * 2L * array2[5]) * 2L;
        array[7] = (array2[3] * array2[4] + array2[2] * array2[5] + array2[1] * array2[6] + array2[0] * array2[7]) * 2L;
        array[8] = array2[4] * array2[4] + (array2[2] * array2[6] + array2[0] * array2[8] + (array2[1] * array2[7] + array2[3] * array2[5]) * 2L) * 2L;
        array[9] = (array2[4] * array2[5] + array2[3] * array2[6] + array2[2] * array2[7] + array2[1] * array2[8] + array2[0] * array2[9]) * 2L;
        array[10] = (array2[5] * array2[5] + array2[4] * array2[6] + array2[2] * array2[8] + (array2[3] * array2[7] + array2[1] * array2[9]) * 2L) * 2L;
        array[11] = (array2[5] * array2[6] + array2[4] * array2[7] + array2[3] * array2[8] + array2[2] * array2[9]) * 2L;
        array[12] = array2[6] * array2[6] + (array2[4] * array2[8] + (array2[5] * array2[7] + array2[3] * array2[9]) * 2L) * 2L;
        array[13] = (array2[6] * array2[7] + array2[5] * array2[8] + array2[4] * array2[9]) * 2L;
        array[14] = (array2[7] * array2[7] + array2[6] * array2[8] + array2[5] * 2L * array2[9]) * 2L;
        array[15] = (array2[7] * array2[8] + array2[6] * array2[9]) * 2L;
        array[16] = array2[8] * array2[8] + array2[7] * 4L * array2[9];
        array[17] = array2[8] * 2L * array2[9];
        array[18] = array2[9] * 2L * array2[9];
    }
    
    static void m(final long[] array, final long[] array2, final long[] array3) {
        for (int i = 0; i < 10; ++i) {
            array[i] = array2[i] - array3[i];
        }
    }
    
    static void n(final long[] array, final long[] array2) {
        o(array, array, array2);
    }
    
    static void o(final long[] array, final long[] array2, final long[] array3) {
        for (int i = 0; i < 10; ++i) {
            array[i] = array2[i] + array3[i];
        }
    }
}
