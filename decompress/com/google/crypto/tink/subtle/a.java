// 
// Decompiled by Procyon v0.6.0
// 

package com.google.crypto.tink.subtle;

import java.util.Arrays;

class a
{
    static byte[] a(final byte[] array) {
        if (array.length < 16) {
            final byte[] copy = Arrays.copyOf(array, 16);
            copy[array.length] = -128;
            return copy;
        }
        throw new IllegalArgumentException("x must be smaller than a block.");
    }
    
    static byte[] b(final byte[] array) {
        if (array.length == 16) {
            final byte[] array2 = new byte[16];
            for (int i = 0; i < 16; ++i) {
                array2[i] = (byte)(array[i] << 1 & 0xFE);
                if (i < 15) {
                    array2[i] |= (byte)(array[i + 1] >> 7 & 0x1);
                }
            }
            array2[15] ^= (byte)(array[0] >> 7 & 0x87);
            return array2;
        }
        throw new IllegalArgumentException("value must be a block.");
    }
}
