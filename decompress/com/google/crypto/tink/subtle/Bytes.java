// 
// Decompiled by Procyon v0.6.0
// 

package com.google.crypto.tink.subtle;

import java.util.Arrays;
import java.nio.ByteBuffer;
import java.security.GeneralSecurityException;

public final class Bytes
{
    public static byte[] a(final byte[]... array) throws GeneralSecurityException {
        final int length = array.length;
        int i = 0;
        int n = 0;
        while (i < length) {
            final byte[] array2 = array[i];
            if (n > Integer.MAX_VALUE - array2.length) {
                throw new GeneralSecurityException("exceeded size limit");
            }
            n += array2.length;
            ++i;
        }
        final byte[] array3 = new byte[n];
        final int length2 = array.length;
        int j = 0;
        int n2 = 0;
        while (j < length2) {
            final byte[] array4 = array[j];
            System.arraycopy(array4, 0, array3, n2, array4.length);
            n2 += array4.length;
            ++j;
        }
        return array3;
    }
    
    public static final boolean b(final byte[] array, final byte[] array2) {
        boolean b2;
        final boolean b = b2 = false;
        if (array != null) {
            if (array2 == null) {
                b2 = b;
            }
            else {
                if (array.length != array2.length) {
                    return false;
                }
                int i = 0;
                int n = 0;
                while (i < array.length) {
                    n |= (array[i] ^ array2[i]);
                    ++i;
                }
                b2 = b;
                if (n == 0) {
                    b2 = true;
                }
            }
        }
        return b2;
    }
    
    public static final void c(final ByteBuffer byteBuffer, final ByteBuffer byteBuffer2, final ByteBuffer byteBuffer3, final int n) {
        if (n >= 0 && byteBuffer2.remaining() >= n && byteBuffer3.remaining() >= n && byteBuffer.remaining() >= n) {
            for (int i = 0; i < n; ++i) {
                byteBuffer.put((byte)(byteBuffer2.get() ^ byteBuffer3.get()));
            }
            return;
        }
        throw new IllegalArgumentException("That combination of buffers, offsets and length to xor result in out-of-bond accesses.");
    }
    
    public static final byte[] d(final byte[] array, final int n, final byte[] array2, final int n2, final int n3) {
        if (n3 >= 0 && array.length - n3 >= n && array2.length - n3 >= n2) {
            final byte[] array3 = new byte[n3];
            for (int i = 0; i < n3; ++i) {
                array3[i] = (byte)(array[i + n] ^ array2[i + n2]);
            }
            return array3;
        }
        throw new IllegalArgumentException("That combination of buffers, offsets and length to xor result in out-of-bond accesses.");
    }
    
    public static final byte[] e(final byte[] array, final byte[] array2) {
        if (array.length == array2.length) {
            return d(array, 0, array2, 0, array.length);
        }
        throw new IllegalArgumentException("The lengths of x and y should match.");
    }
    
    public static final byte[] f(byte[] copy, final byte[] array) {
        if (copy.length >= array.length) {
            final int length = copy.length;
            final int length2 = array.length;
            copy = Arrays.copyOf(copy, copy.length);
            for (int i = 0; i < array.length; ++i) {
                final int n = length - length2 + i;
                copy[n] ^= array[i];
            }
            return copy;
        }
        throw new IllegalArgumentException("xorEnd requires a.length >= b.length");
    }
}
