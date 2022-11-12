// 
// Decompiled by Procyon v0.6.0
// 

package com.google.crypto.tink.aead.subtle;

import java.security.Key;
import com.google.crypto.tink.subtle.Random;
import javax.crypto.spec.IvParameterSpec;
import com.google.crypto.tink.subtle.SubtleUtil;
import javax.crypto.spec.GCMParameterSpec;
import java.security.spec.AlgorithmParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import com.google.crypto.tink.subtle.Validators;
import java.security.GeneralSecurityException;
import com.google.crypto.tink.subtle.EngineFactory;
import javax.crypto.SecretKey;
import javax.crypto.Cipher;
import com.google.crypto.tink.annotations.Alpha;
import com.google.crypto.tink.Aead;

@Alpha
public final class AesGcmSiv implements Aead
{
    private static final ThreadLocal<Cipher> b;
    private final SecretKey a;
    
    static {
        b = new ThreadLocal<Cipher>() {
            protected Cipher a() {
                try {
                    return EngineFactory.f.a("AES/GCM-SIV/NoPadding");
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
    
    public AesGcmSiv(final byte[] array) throws GeneralSecurityException {
        Validators.a(array.length);
        this.a = new SecretKeySpec(array, "AES");
    }
    
    private static AlgorithmParameterSpec c(final byte[] array) throws GeneralSecurityException {
        return d(array, 0, array.length);
    }
    
    private static AlgorithmParameterSpec d(final byte[] array, final int n, final int n2) throws GeneralSecurityException {
        try {
            Class.forName("javax.crypto.spec.GCMParameterSpec");
            return new GCMParameterSpec(128, array, n, n2);
        }
        catch (final ClassNotFoundException ex) {
            if (SubtleUtil.d()) {
                return new IvParameterSpec(array, n, n2);
            }
            throw new GeneralSecurityException("cannot use AES-GCM: javax.crypto.spec.GCMParameterSpec not found");
        }
    }
    
    @Override
    public byte[] a(final byte[] array, final byte[] array2) throws GeneralSecurityException {
        if (array.length > 2147483619) {
            throw new GeneralSecurityException("plaintext too long");
        }
        final byte[] array3 = new byte[array.length + 12 + 16];
        final byte[] c = Random.c(12);
        System.arraycopy(c, 0, array3, 0, 12);
        final AlgorithmParameterSpec c2 = c(c);
        final ThreadLocal<Cipher> b = AesGcmSiv.b;
        b.get().init(1, this.a, c2);
        if (array2 != null && array2.length != 0) {
            b.get().updateAAD(array2);
        }
        final int doFinal = b.get().doFinal(array, 0, array.length, array3, 12);
        if (doFinal == array.length + 16) {
            return array3;
        }
        throw new GeneralSecurityException(String.format("encryption failed; GCM tag must be %s bytes, but got only %s bytes", 16, doFinal - array.length));
    }
    
    @Override
    public byte[] b(final byte[] array, final byte[] array2) throws GeneralSecurityException {
        if (array.length >= 28) {
            final AlgorithmParameterSpec d = d(array, 0, 12);
            final ThreadLocal<Cipher> b = AesGcmSiv.b;
            b.get().init(2, this.a, d);
            if (array2 != null && array2.length != 0) {
                b.get().updateAAD(array2);
            }
            return b.get().doFinal(array, 12, array.length - 12);
        }
        throw new GeneralSecurityException("ciphertext too short");
    }
}
