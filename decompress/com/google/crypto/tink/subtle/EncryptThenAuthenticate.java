// 
// Decompiled by Procyon v0.6.0
// 

package com.google.crypto.tink.subtle;

import java.security.GeneralSecurityException;
import java.util.Arrays;
import java.nio.ByteBuffer;
import com.google.crypto.tink.Mac;
import com.google.crypto.tink.Aead;

public final class EncryptThenAuthenticate implements Aead
{
    private final IndCpaCipher a;
    private final Mac b;
    private final int c;
    
    public EncryptThenAuthenticate(final IndCpaCipher a, final Mac b, final int c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }
    
    @Override
    public byte[] a(byte[] array, byte[] copy) throws GeneralSecurityException {
        final byte[] a = this.a.a(array);
        array = copy;
        if (copy == null) {
            array = new byte[0];
        }
        copy = Arrays.copyOf(ByteBuffer.allocate(8).putLong(array.length * 8L).array(), 8);
        return Bytes.a(new byte[][] { a, this.b.b(Bytes.a(new byte[][] { array, a, copy })) });
    }
    
    @Override
    public byte[] b(byte[] array, byte[] copy) throws GeneralSecurityException {
        final int length = array.length;
        final int c = this.c;
        if (length >= c) {
            final byte[] copyOfRange = Arrays.copyOfRange(array, 0, array.length - c);
            final byte[] copyOfRange2 = Arrays.copyOfRange(array, array.length - this.c, array.length);
            if ((array = copy) == null) {
                array = new byte[0];
            }
            copy = Arrays.copyOf(ByteBuffer.allocate(8).putLong(array.length * 8L).array(), 8);
            this.b.a(copyOfRange2, Bytes.a(new byte[][] { array, copyOfRange, copy }));
            return this.a.b(copyOfRange);
        }
        throw new GeneralSecurityException("ciphertext too short");
    }
}
