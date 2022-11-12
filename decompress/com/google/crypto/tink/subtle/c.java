// 
// Decompiled by Procyon v0.6.0
// 

package com.google.crypto.tink.subtle;

import java.nio.IntBuffer;
import java.nio.ByteOrder;
import java.security.GeneralSecurityException;
import java.nio.ByteBuffer;
import java.security.InvalidKeyException;

abstract class c implements IndCpaCipher
{
    private static final int[] c;
    int[] a;
    private final int b;
    
    static {
        c = m(new byte[] { 101, 120, 112, 97, 110, 100, 32, 51, 50, 45, 98, 121, 116, 101, 32, 107 });
    }
    
    c(final byte[] array, final int b) throws InvalidKeyException {
        if (array.length == 32) {
            this.a = m(array);
            this.b = b;
            return;
        }
        throw new InvalidKeyException("The key length in bytes must be 32.");
    }
    
    private void h(final byte[] array, final ByteBuffer byteBuffer, final ByteBuffer byteBuffer2) throws GeneralSecurityException {
        final int remaining = byteBuffer2.remaining();
        for (int n = remaining / 64 + 1, i = 0; i < n; ++i) {
            final ByteBuffer c = this.c(array, this.b + i);
            if (i == n - 1) {
                Bytes.c(byteBuffer, byteBuffer2, c, remaining % 64);
            }
            else {
                Bytes.c(byteBuffer, byteBuffer2, c, 64);
            }
        }
    }
    
    static void i(final int[] array, final int n, final int n2, final int n3, final int n4) {
        array[n] += array[n2];
        array[n4] = j(array[n4] ^ array[n], 16);
        array[n3] += array[n4];
        array[n2] = j(array[n2] ^ array[n3], 12);
        array[n] += array[n2];
        array[n4] = j(array[n] ^ array[n4], 8);
        array[n3] += array[n4];
        array[n2] = j(array[n2] ^ array[n3], 7);
    }
    
    private static int j(final int n, final int n2) {
        return n >>> -n2 | n << n2;
    }
    
    static void k(final int[] array, final int[] array2) {
        final int[] c = com.google.crypto.tink.subtle.c.c;
        System.arraycopy(c, 0, array, 0, c.length);
        System.arraycopy(array2, 0, array, c.length, 8);
    }
    
    static void l(final int[] array) {
        for (int i = 0; i < 10; ++i) {
            i(array, 0, 4, 8, 12);
            i(array, 1, 5, 9, 13);
            i(array, 2, 6, 10, 14);
            i(array, 3, 7, 11, 15);
            i(array, 0, 5, 10, 15);
            i(array, 1, 6, 11, 12);
            i(array, 2, 7, 8, 13);
            i(array, 3, 4, 9, 14);
        }
    }
    
    static int[] m(final byte[] array) {
        final IntBuffer intBuffer = ByteBuffer.wrap(array).order(ByteOrder.LITTLE_ENDIAN).asIntBuffer();
        final int[] array2 = new int[intBuffer.remaining()];
        intBuffer.get(array2);
        return array2;
    }
    
    @Override
    public byte[] a(final byte[] array) throws GeneralSecurityException {
        if (array.length <= Integer.MAX_VALUE - this.g()) {
            final ByteBuffer allocate = ByteBuffer.allocate(this.g() + array.length);
            this.f(allocate, array);
            return allocate.array();
        }
        throw new GeneralSecurityException("plaintext too long");
    }
    
    @Override
    public byte[] b(final byte[] array) throws GeneralSecurityException {
        return this.e(ByteBuffer.wrap(array));
    }
    
    ByteBuffer c(final byte[] array, int i) {
        final int[] d = this.d(m(array), i);
        final int[] array2 = d.clone();
        l(array2);
        for (i = 0; i < d.length; ++i) {
            d[i] += array2[i];
        }
        final ByteBuffer order = ByteBuffer.allocate(64).order(ByteOrder.LITTLE_ENDIAN);
        order.asIntBuffer().put(d, 0, 16);
        return order;
    }
    
    abstract int[] d(final int[] p0, final int p1);
    
    byte[] e(final ByteBuffer byteBuffer) throws GeneralSecurityException {
        if (byteBuffer.remaining() >= this.g()) {
            final byte[] array = new byte[this.g()];
            byteBuffer.get(array);
            final ByteBuffer allocate = ByteBuffer.allocate(byteBuffer.remaining());
            this.h(array, allocate, byteBuffer);
            return allocate.array();
        }
        throw new GeneralSecurityException("ciphertext too short");
    }
    
    void f(final ByteBuffer byteBuffer, final byte[] array) throws GeneralSecurityException {
        if (byteBuffer.remaining() - this.g() >= array.length) {
            final byte[] c = Random.c(this.g());
            byteBuffer.put(c);
            this.h(c, byteBuffer, ByteBuffer.wrap(array));
            return;
        }
        throw new IllegalArgumentException("Given ByteBuffer output is too small");
    }
    
    abstract int g();
}
