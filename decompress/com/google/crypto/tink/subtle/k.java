// 
// Decompiled by Procyon v0.6.0
// 

package com.google.crypto.tink.subtle;

import java.util.Arrays;
import java.security.InvalidKeyException;

class k extends c
{
    k(final byte[] array, final int n) throws InvalidKeyException {
        super(array, n);
    }
    
    static int[] n(final int[] array, final int[] array2) {
        final int[] array3 = new int[16];
        com.google.crypto.tink.subtle.c.k(array3, array);
        array3[12] = array2[0];
        array3[13] = array2[1];
        array3[14] = array2[2];
        array3[15] = array2[3];
        com.google.crypto.tink.subtle.c.l(array3);
        array3[4] = array3[12];
        array3[5] = array3[13];
        array3[6] = array3[14];
        array3[7] = array3[15];
        return Arrays.copyOf(array3, 8);
    }
    
    @Override
    int[] d(final int[] array, final int n) {
        if (array.length == this.g() / 4) {
            final int[] array2 = new int[16];
            com.google.crypto.tink.subtle.c.k(array2, n(super.a, array));
            array2[12] = n;
            array2[13] = 0;
            array2[14] = array[4];
            array2[15] = array[5];
            return array2;
        }
        throw new IllegalArgumentException(String.format("XChaCha20 uses 192-bit nonces, but got a %d-bit nonce", array.length * 32));
    }
    
    @Override
    int g() {
        return 24;
    }
}
