// 
// Decompiled by Procyon v0.6.0
// 

package com.google.crypto.tink.subtle;

import java.security.InvalidKeyException;

class b extends c
{
    b(final byte[] array, final int n) throws InvalidKeyException {
        super(array, n);
    }
    
    @Override
    int[] d(final int[] array, final int n) {
        if (array.length == this.g() / 4) {
            final int[] array2 = new int[16];
            com.google.crypto.tink.subtle.c.k(array2, super.a);
            array2[12] = n;
            System.arraycopy(array, 0, array2, 13, array.length);
            return array2;
        }
        throw new IllegalArgumentException(String.format("ChaCha20 uses 96-bit nonces, but got a %d-bit nonce", array.length * 32));
    }
    
    @Override
    int g() {
        return 12;
    }
}
