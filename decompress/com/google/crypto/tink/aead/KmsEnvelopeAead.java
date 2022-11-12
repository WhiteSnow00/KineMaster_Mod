// 
// Decompiled by Procyon v0.6.0
// 

package com.google.crypto.tink.aead;

import java.nio.BufferUnderflowException;
import java.security.GeneralSecurityException;
import com.google.crypto.tink.Registry;
import java.nio.ByteBuffer;
import com.google.crypto.tink.proto.KeyTemplate;
import com.google.crypto.tink.Aead;

public final class KmsEnvelopeAead implements Aead
{
    private static final byte[] c;
    private final KeyTemplate a;
    private final Aead b;
    
    static {
        c = new byte[0];
    }
    
    public KmsEnvelopeAead(final KeyTemplate a, final Aead b) {
        this.a = a;
        this.b = b;
    }
    
    private byte[] c(final byte[] array, final byte[] array2) {
        return ByteBuffer.allocate(array.length + 4 + array2.length).putInt(array.length).put(array).put(array2).array();
    }
    
    @Override
    public byte[] a(final byte[] array, final byte[] array2) throws GeneralSecurityException {
        final byte[] c = Registry.p(this.a).c();
        return this.c(this.b.a(c, KmsEnvelopeAead.c), Registry.j(this.a.P(), c, Aead.class).a(array, array2));
    }
    
    @Override
    public byte[] b(byte[] o, final byte[] array) throws GeneralSecurityException {
        try {
            final ByteBuffer wrap = ByteBuffer.wrap((byte[])o);
            final int int1 = wrap.getInt();
            if (int1 > 0 && int1 <= o.length - 4) {
                final byte[] array2 = new byte[int1];
                wrap.get(array2, 0, int1);
                o = new byte[wrap.remaining()];
                wrap.get((byte[])o, 0, wrap.remaining());
                return Registry.j(this.a.P(), this.b.b(array2, KmsEnvelopeAead.c), Aead.class).b((byte[])o, array);
            }
            o = new GeneralSecurityException("invalid ciphertext");
            throw o;
        }
        catch (final NegativeArraySizeException o) {}
        catch (final BufferUnderflowException o) {}
        catch (final IndexOutOfBoundsException ex) {}
        throw new GeneralSecurityException("invalid ciphertext", (Throwable)o);
    }
}
