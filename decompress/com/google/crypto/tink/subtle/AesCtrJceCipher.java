// 
// Decompiled by Procyon v0.6.0
// 

package com.google.crypto.tink.subtle;

import java.security.spec.AlgorithmParameterSpec;
import java.security.Key;
import javax.crypto.spec.IvParameterSpec;
import java.security.GeneralSecurityException;
import javax.crypto.spec.SecretKeySpec;
import javax.crypto.Cipher;

public final class AesCtrJceCipher implements IndCpaCipher
{
    private static final ThreadLocal<Cipher> d;
    private final SecretKeySpec a;
    private final int b;
    private final int c;
    
    static {
        d = new ThreadLocal<Cipher>() {
            protected Cipher a() {
                try {
                    return EngineFactory.f.a("AES/CTR/NoPadding");
                }
                catch (final GeneralSecurityException ex) {
                    throw new IllegalStateException(ex);
                }
            }
            
            @Override
            protected /* bridge */ Object initialValue() {
                return this.a();
            }
        };
    }
    
    public AesCtrJceCipher(final byte[] array, final int b) throws GeneralSecurityException {
        Validators.a(array.length);
        this.a = new SecretKeySpec(array, "AES");
        final int blockSize = AesCtrJceCipher.d.get().getBlockSize();
        this.c = blockSize;
        if (b >= 12 && b <= blockSize) {
            this.b = b;
            return;
        }
        throw new GeneralSecurityException("invalid IV size");
    }
    
    private void c(final byte[] array, final int n, final int n2, final byte[] array2, final int n3, final byte[] array3, final boolean b) throws GeneralSecurityException {
        final Cipher cipher = AesCtrJceCipher.d.get();
        final byte[] array4 = new byte[this.c];
        System.arraycopy(array3, 0, array4, 0, this.b);
        final IvParameterSpec ivParameterSpec = new IvParameterSpec(array4);
        if (b) {
            cipher.init(1, this.a, ivParameterSpec);
        }
        else {
            cipher.init(2, this.a, ivParameterSpec);
        }
        if (cipher.doFinal(array, n, n2, array2, n3) == n2) {
            return;
        }
        throw new GeneralSecurityException("stored output's length does not match input's length");
    }
    
    @Override
    public byte[] a(final byte[] array) throws GeneralSecurityException {
        final int length = array.length;
        final int b = this.b;
        if (length <= Integer.MAX_VALUE - b) {
            final byte[] array2 = new byte[array.length + b];
            final byte[] c = Random.c(b);
            System.arraycopy(c, 0, array2, 0, this.b);
            this.c(array, 0, array.length, array2, this.b, c, true);
            return array2;
        }
        final StringBuilder sb = new StringBuilder();
        sb.append("plaintext length can not exceed ");
        sb.append(Integer.MAX_VALUE - this.b);
        throw new GeneralSecurityException(sb.toString());
    }
    
    @Override
    public byte[] b(final byte[] array) throws GeneralSecurityException {
        final int length = array.length;
        final int b = this.b;
        if (length >= b) {
            final byte[] array2 = new byte[b];
            System.arraycopy(array, 0, array2, 0, b);
            final int length2 = array.length;
            final int b2 = this.b;
            final byte[] array3 = new byte[length2 - b2];
            this.c(array, b2, array.length - b2, array3, 0, array2, false);
            return array3;
        }
        throw new GeneralSecurityException("ciphertext too short");
    }
}
