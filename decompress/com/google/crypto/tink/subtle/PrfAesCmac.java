// 
// Decompiled by Procyon v0.6.0
// 

package com.google.crypto.tink.subtle;

import java.security.InvalidAlgorithmParameterException;
import java.util.Arrays;
import javax.crypto.Cipher;
import java.security.Key;
import java.security.GeneralSecurityException;
import javax.crypto.spec.SecretKeySpec;
import javax.crypto.SecretKey;
import com.google.errorprone.annotations.Immutable;
import com.google.crypto.tink.prf.Prf;

@Immutable
public final class PrfAesCmac implements Prf
{
    private final SecretKey a;
    private byte[] b;
    private byte[] c;
    
    public PrfAesCmac(final byte[] array) throws GeneralSecurityException {
        Validators.a(array.length);
        this.a = new SecretKeySpec(array, "AES");
        this.b();
    }
    
    private void b() throws GeneralSecurityException {
        final Cipher c = c();
        c.init(1, this.a);
        final byte[] b = com.google.crypto.tink.subtle.a.b(c.doFinal(new byte[16]));
        this.b = b;
        this.c = com.google.crypto.tink.subtle.a.b(b);
    }
    
    private static Cipher c() throws GeneralSecurityException {
        return EngineFactory.f.a("AES/ECB/NoPadding");
    }
    
    @Override
    public byte[] a(final byte[] array, final int n) throws GeneralSecurityException {
        if (n <= 16) {
            final Cipher c = c();
            c.init(1, this.a);
            final int max = Math.max(1, (int)Math.ceil(array.length / 16.0));
            byte[] array2;
            if (max * 16 == array.length) {
                array2 = Bytes.d(array, (max - 1) * 16, this.b, 0, 16);
            }
            else {
                array2 = Bytes.e(com.google.crypto.tink.subtle.a.a(Arrays.copyOfRange(array, (max - 1) * 16, array.length)), this.c);
            }
            byte[] doFinal = new byte[16];
            for (int i = 0; i < max - 1; ++i) {
                doFinal = c.doFinal(Bytes.d(doFinal, 0, array, i * 16, 16));
            }
            return Arrays.copyOf(c.doFinal(Bytes.e(array2, doFinal)), n);
        }
        throw new InvalidAlgorithmParameterException("outputLength too large, max is 16 bytes");
    }
}
