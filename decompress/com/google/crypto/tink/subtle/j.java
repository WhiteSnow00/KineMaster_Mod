// 
// Decompiled by Procyon v0.6.0
// 

package com.google.crypto.tink.subtle;

import java.security.GeneralSecurityException;
import java.util.Arrays;

class j
{
    static byte[] a(byte[] array, final byte[] array2) {
        if (array.length == 32) {
            final long n = c(array, 0, 0) & 0x3FFFFFFL;
            final long n2 = c(array, 3, 2) & 0x3FFFF03L;
            final long n3 = c(array, 6, 4) & 0x3FFC0FFL;
            final long n4 = c(array, 9, 6) & 0x3F03FFFL;
            final long n5 = c(array, 12, 8) & 0xFFFFFL;
            final long n6 = n3 * 5L;
            final long n7 = n4 * 5L;
            final long n8 = n5 * 5L;
            final byte[] array3 = new byte[17];
            final long n9 = 0L;
            int i = 0;
            long n10 = 0L;
            long n11 = 0L;
            long n13;
            long n12 = n13 = n11;
            long n14 = n9;
            while (i < array2.length) {
                b(array3, array2, i);
                final long n15 = n12 + c(array3, 0, 0);
                final long n16 = n14 + c(array3, 3, 2);
                final long n17 = n10 + c(array3, 6, 4);
                final long n18 = n11 + c(array3, 9, 6);
                final long n19 = n13 + (c(array3, 12, 8) | (long)(array3[16] << 24));
                final long n20 = n15 * n + n16 * n8 + n17 * n7 + n18 * n6 + n19 * (n2 * 5L);
                final long n21 = n15 * n2 + n16 * n + n17 * n8 + n18 * n7 + n19 * n6 + (n20 >> 26);
                final long n22 = n15 * n3 + n16 * n2 + n17 * n + n18 * n8 + n19 * n7 + (n21 >> 26);
                final long n23 = n15 * n4 + n16 * n3 + n17 * n2 + n18 * n + n19 * n8 + (n22 >> 26);
                final long n24 = n15 * n5 + n16 * n4 + n17 * n3 + n18 * n2 + n19 * n + (n23 >> 26);
                final long n25 = (n20 & 0x3FFFFFFL) + (n24 >> 26) * 5L;
                n14 = (n21 & 0x3FFFFFFL) + (n25 >> 26);
                i += 16;
                n10 = (n22 & 0x3FFFFFFL);
                n11 = (n23 & 0x3FFFFFFL);
                n13 = (n24 & 0x3FFFFFFL);
                n12 = (n25 & 0x3FFFFFFL);
            }
            final long n26 = n10 + (n14 >> 26);
            final long n27 = n26 & 0x3FFFFFFL;
            final long n28 = n11 + (n26 >> 26);
            final long n29 = n28 & 0x3FFFFFFL;
            final long n30 = n13 + (n28 >> 26);
            final long n31 = n30 & 0x3FFFFFFL;
            final long n32 = n12 + (n30 >> 26) * 5L;
            final long n33 = n32 & 0x3FFFFFFL;
            final long n34 = (n14 & 0x3FFFFFFL) + (n32 >> 26);
            final long n35 = n33 + 5L;
            final long n36 = (n35 >> 26) + n34;
            final long n37 = n27 + (n36 >> 26);
            final long n38 = n29 + (n37 >> 26);
            final long n39 = n31 + (n38 >> 26) - 67108864L;
            final long n40 = n39 >> 63;
            final long n41 = ~n40;
            final long n42 = (n36 & 0x3FFFFFFL & n41) | (n34 & n40);
            final long n43 = (n37 & 0x3FFFFFFL & n41) | (n27 & n40);
            final long n44 = (n38 & 0x3FFFFFFL & n41) | (n29 & n40);
            final long n45 = (((n33 & n40) | (n35 & 0x3FFFFFFL & n41) | n42 << 26) & 0xFFFFFFFFL) + d(array, 16);
            final long n46 = ((n42 >> 6 | n43 << 20) & 0xFFFFFFFFL) + d(array, 20) + (n45 >> 32);
            final long n47 = ((n43 >> 12 | n44 << 14) & 0xFFFFFFFFL) + d(array, 24) + (n46 >> 32);
            final long d = d(array, 28);
            array = new byte[16];
            e(array, n45 & 0xFFFFFFFFL, 0);
            e(array, n46 & 0xFFFFFFFFL, 4);
            e(array, n47 & 0xFFFFFFFFL, 8);
            e(array, ((n44 >> 18 | ((n39 & n41) | (n31 & n40)) << 8) & 0xFFFFFFFFL) + d + (n47 >> 32) & 0xFFFFFFFFL, 12);
            return array;
        }
        throw new IllegalArgumentException("The key length in bytes must be 32.");
    }
    
    private static void b(final byte[] array, final byte[] array2, final int n) {
        final int min = Math.min(16, array2.length - n);
        System.arraycopy(array2, n, array, 0, min);
        array[min] = 1;
        if (min != 16) {
            Arrays.fill(array, min + 1, array.length, (byte)0);
        }
    }
    
    private static long c(final byte[] array, final int n, final int n2) {
        return d(array, n) >> n2 & 0x3FFFFFFL;
    }
    
    private static long d(final byte[] array, final int n) {
        return (long)((array[n + 3] & 0xFF) << 24 | ((array[n] & 0xFF) | (array[n + 1] & 0xFF) << 8 | (array[n + 2] & 0xFF) << 16)) & 0xFFFFFFFFL;
    }
    
    private static void e(final byte[] array, long n, final int n2) {
        for (int i = 0; i < 4; ++i, n >>= 8) {
            array[n2 + i] = (byte)(0xFFL & n);
        }
    }
    
    static void f(final byte[] array, final byte[] array2, final byte[] array3) throws GeneralSecurityException {
        if (Bytes.b(a(array, array2), array3)) {
            return;
        }
        throw new GeneralSecurityException("invalid MAC");
    }
}
