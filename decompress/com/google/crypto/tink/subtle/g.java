// 
// Decompiled by Procyon v0.6.0
// 

package com.google.crypto.tink.subtle;

import java.math.BigInteger;

final class g
{
    static final long[] a;
    static final long[] b;
    static final long[] c;
    static final f.a[][] d;
    static final f.a[] e;
    private static final BigInteger f;
    private static final BigInteger g;
    private static final BigInteger h;
    private static final BigInteger i;
    
    static {
        final BigInteger bigInteger = f = BigInteger.valueOf(2L).pow(255).subtract(BigInteger.valueOf(19L));
        final BigInteger bigInteger2 = g = BigInteger.valueOf(-121665L).multiply(BigInteger.valueOf(121666L).modInverse(bigInteger)).mod(bigInteger);
        final BigInteger bigInteger3 = h = BigInteger.valueOf(2L).multiply(bigInteger2).mod(bigInteger);
        final BigInteger bigInteger4 = i = BigInteger.valueOf(2L).modPow(bigInteger.subtract(BigInteger.ONE).divide(BigInteger.valueOf(4L)), bigInteger);
        b a2 = new b(null);
        com.google.crypto.tink.subtle.g.b.b(a2, BigInteger.valueOf(4L).multiply(BigInteger.valueOf(5L).modInverse(bigInteger)).mod(bigInteger));
        com.google.crypto.tink.subtle.g.b.d(a2, c(com.google.crypto.tink.subtle.g.b.a(a2)));
        a = com.google.crypto.tink.subtle.h.c(d(bigInteger2));
        b = com.google.crypto.tink.subtle.h.c(d(bigInteger3));
        c = com.google.crypto.tink.subtle.h.c(d(bigInteger4));
        d = new f.a[32][8];
        final int n = 0;
        int j = 0;
        b a3 = a2;
        while (j < 32) {
            int k = 0;
            b a4 = a3;
            while (k < 8) {
                com.google.crypto.tink.subtle.g.d[j][k] = b(a4);
                a4 = a(a4, a3);
                ++k;
            }
            for (int l = 0; l < 8; ++l) {
                a3 = a(a3, a3);
            }
            ++j;
        }
        final b a5 = a(a2, a2);
        e = new f.a[8];
        for (int n2 = n; n2 < 8; ++n2) {
            com.google.crypto.tink.subtle.g.e[n2] = b(a2);
            a2 = a(a2, a5);
        }
    }
    
    private static b a(final b b, final b b2) {
        final b b3 = new b(null);
        final BigInteger multiply = com.google.crypto.tink.subtle.g.g.multiply(com.google.crypto.tink.subtle.g.b.c(b).multiply(com.google.crypto.tink.subtle.g.b.c(b2)).multiply(com.google.crypto.tink.subtle.g.b.a(b)).multiply(com.google.crypto.tink.subtle.g.b.a(b2)));
        final BigInteger f = com.google.crypto.tink.subtle.g.f;
        final BigInteger mod = multiply.mod(f);
        final BigInteger add = com.google.crypto.tink.subtle.g.b.c(b).multiply(com.google.crypto.tink.subtle.g.b.a(b2)).add(com.google.crypto.tink.subtle.g.b.c(b2).multiply(com.google.crypto.tink.subtle.g.b.a(b)));
        final BigInteger one = BigInteger.ONE;
        com.google.crypto.tink.subtle.g.b.d(b3, add.multiply(one.add(mod).modInverse(f)).mod(f));
        com.google.crypto.tink.subtle.g.b.b(b3, com.google.crypto.tink.subtle.g.b.a(b).multiply(com.google.crypto.tink.subtle.g.b.a(b2)).add(com.google.crypto.tink.subtle.g.b.c(b).multiply(com.google.crypto.tink.subtle.g.b.c(b2))).multiply(one.subtract(mod).modInverse(f)).mod(f));
        return b3;
    }
    
    private static f.a b(final b b) {
        final BigInteger add = com.google.crypto.tink.subtle.g.b.a(b).add(com.google.crypto.tink.subtle.g.b.c(b));
        final BigInteger f = com.google.crypto.tink.subtle.g.f;
        return new f.a(com.google.crypto.tink.subtle.h.c(d(add.mod(f))), com.google.crypto.tink.subtle.h.c(d(com.google.crypto.tink.subtle.g.b.a(b).subtract(com.google.crypto.tink.subtle.g.b.c(b)).mod(f))), com.google.crypto.tink.subtle.h.c(d(com.google.crypto.tink.subtle.g.h.multiply(com.google.crypto.tink.subtle.g.b.c(b)).multiply(com.google.crypto.tink.subtle.g.b.a(b)).mod(f))));
    }
    
    private static BigInteger c(BigInteger bigInteger) {
        final BigInteger pow = bigInteger.pow(2);
        final BigInteger one = BigInteger.ONE;
        final BigInteger subtract = pow.subtract(one);
        bigInteger = com.google.crypto.tink.subtle.g.g.multiply(bigInteger.pow(2)).add(one);
        final BigInteger f = com.google.crypto.tink.subtle.g.f;
        final BigInteger multiply = subtract.multiply(bigInteger.modInverse(f));
        final BigInteger bigInteger2 = bigInteger = multiply.modPow(f.add(BigInteger.valueOf(3L)).divide(BigInteger.valueOf(8L)), f);
        if (!bigInteger2.pow(2).subtract(multiply).mod(f).equals(BigInteger.ZERO)) {
            bigInteger = bigInteger2.multiply(com.google.crypto.tink.subtle.g.i).mod(f);
        }
        BigInteger subtract2 = bigInteger;
        if (bigInteger.testBit(0)) {
            subtract2 = f.subtract(bigInteger);
        }
        return subtract2;
    }
    
    private static byte[] d(final BigInteger bigInteger) {
        final byte[] array = new byte[32];
        final byte[] byteArray = bigInteger.toByteArray();
        final int length = byteArray.length;
        final int length2 = byteArray.length;
        int i = 0;
        System.arraycopy(byteArray, 0, array, 32 - length, length2);
        while (i < 16) {
            final byte b = array[i];
            final int n = 32 - i - 1;
            array[i] = array[n];
            array[n] = b;
            ++i;
        }
        return array;
    }
    
    private static class b
    {
        private BigInteger a;
        private BigInteger b;
        
        private b() {
        }
        
        b(final g$a object) {
            this();
        }
        
        static BigInteger a(final b b) {
            return b.b;
        }
        
        static BigInteger b(final b b, final BigInteger b2) {
            return b.b = b2;
        }
        
        static BigInteger c(final b b) {
            return b.a;
        }
        
        static BigInteger d(final b b, final BigInteger a) {
            return b.a = a;
        }
    }
}
