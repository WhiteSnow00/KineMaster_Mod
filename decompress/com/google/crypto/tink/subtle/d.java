// 
// Decompiled by Procyon v0.6.0
// 

package com.google.crypto.tink.subtle;

import java.nio.ByteOrder;
import java.security.GeneralSecurityException;
import javax.crypto.AEADBadTagException;
import java.nio.ByteBuffer;
import java.security.InvalidKeyException;
import com.google.crypto.tink.Aead;

abstract class d implements Aead
{
    private final c a;
    private final c b;
    
    public d(final byte[] array) throws InvalidKeyException {
        this.a = this.g(array, 1);
        this.b = this.g(array, 0);
    }
    
    private byte[] c(final ByteBuffer byteBuffer, final byte[] array) throws GeneralSecurityException {
        if (byteBuffer.remaining() >= this.a.g() + 16) {
            final int position = byteBuffer.position();
            final byte[] array2 = new byte[16];
            byteBuffer.position(byteBuffer.limit() - 16);
            byteBuffer.get(array2);
            byteBuffer.position(position);
            byteBuffer.limit(byteBuffer.limit() - 16);
            final byte[] array3 = new byte[this.a.g()];
            byteBuffer.get(array3);
            byte[] array4;
            if ((array4 = array) == null) {
                array4 = new byte[0];
            }
            try {
                j.f(this.e(array3), f(array4, byteBuffer), array2);
                byteBuffer.position(position);
                return this.a.e(byteBuffer);
            }
            catch (final GeneralSecurityException ex) {
                throw new AEADBadTagException(ex.toString());
            }
        }
        throw new GeneralSecurityException("ciphertext too short");
    }
    
    private void d(final ByteBuffer byteBuffer, byte[] a, final byte[] array) throws GeneralSecurityException {
        if (byteBuffer.remaining() >= a.length + this.a.g() + 16) {
            final int position = byteBuffer.position();
            this.a.f(byteBuffer, a);
            byteBuffer.position(position);
            final byte[] array2 = new byte[this.a.g()];
            byteBuffer.get(array2);
            byteBuffer.limit(byteBuffer.limit() - 16);
            if ((a = array) == null) {
                a = new byte[0];
            }
            a = j.a(this.e(array2), f(a, byteBuffer));
            byteBuffer.limit(byteBuffer.limit() + 16);
            byteBuffer.put(a);
            return;
        }
        throw new IllegalArgumentException("Given ByteBuffer output is too small");
    }
    
    private byte[] e(final byte[] array) throws GeneralSecurityException {
        final ByteBuffer c = this.b.c(array, 0);
        final byte[] array2 = new byte[32];
        c.get(array2);
        return array2;
    }
    
    private static byte[] f(final byte[] array, final ByteBuffer byteBuffer) {
        int length;
        if (array.length % 16 == 0) {
            length = array.length;
        }
        else {
            length = array.length + 16 - array.length % 16;
        }
        final int remaining = byteBuffer.remaining();
        final int n = remaining % 16;
        int n2;
        if (n == 0) {
            n2 = remaining;
        }
        else {
            n2 = remaining + 16 - n;
        }
        final int n3 = n2 + length;
        final ByteBuffer order = ByteBuffer.allocate(n3 + 16).order(ByteOrder.LITTLE_ENDIAN);
        order.put(array);
        order.position(length);
        order.put(byteBuffer);
        order.position(n3);
        order.putLong(array.length);
        order.putLong(remaining);
        return order.array();
    }
    
    @Override
    public byte[] a(final byte[] array, final byte[] array2) throws GeneralSecurityException {
        if (array.length <= Integer.MAX_VALUE - this.a.g() - 16) {
            final ByteBuffer allocate = ByteBuffer.allocate(array.length + this.a.g() + 16);
            this.d(allocate, array, array2);
            return allocate.array();
        }
        throw new GeneralSecurityException("plaintext too long");
    }
    
    @Override
    public byte[] b(final byte[] array, final byte[] array2) throws GeneralSecurityException {
        return this.c(ByteBuffer.wrap(array), array2);
    }
    
    abstract c g(final byte[] p0, final int p1) throws InvalidKeyException;
}
