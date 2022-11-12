// 
// Decompiled by Procyon v0.6.0
// 

package com.google.crypto.tink.subtle;

import javax.crypto.AEADBadTagException;
import java.security.spec.AlgorithmParameterSpec;
import java.security.Key;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import javax.crypto.Cipher;
import java.security.GeneralSecurityException;
import java.security.InvalidKeyException;
import java.util.Arrays;
import java.util.Collection;
import com.google.crypto.tink.DeterministicAead;

public final class AesSiv implements DeterministicAead
{
    private static final Collection<Integer> c;
    private static final byte[] d;
    private static final byte[] e;
    private final PrfAesCmac a;
    private final byte[] b;
    
    static {
        c = Arrays.asList(64);
        d = new byte[16];
        e = new byte[] { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1 };
    }
    
    public AesSiv(final byte[] array) throws GeneralSecurityException {
        if (AesSiv.c.contains(array.length)) {
            final byte[] copyOfRange = Arrays.copyOfRange(array, 0, array.length / 2);
            this.b = Arrays.copyOfRange(array, array.length / 2, array.length);
            this.a = new PrfAesCmac(copyOfRange);
            return;
        }
        final StringBuilder sb = new StringBuilder();
        sb.append("invalid key size: ");
        sb.append(array.length);
        sb.append(" bytes; key must have 64 bytes");
        throw new InvalidKeyException(sb.toString());
    }
    
    private byte[] c(final byte[]... array) throws GeneralSecurityException {
        if (array.length == 0) {
            return this.a.a(AesSiv.e, 16);
        }
        byte[] array2 = this.a.a(AesSiv.d, 16);
        for (int i = 0; i < array.length - 1; ++i) {
            byte[] array3;
            if (array[i] == null) {
                array3 = new byte[0];
            }
            else {
                array3 = array[i];
            }
            array2 = Bytes.e(com.google.crypto.tink.subtle.a.b(array2), this.a.a(array3, 16));
        }
        final byte[] array4 = array[array.length - 1];
        byte[] array5;
        if (array4.length >= 16) {
            array5 = Bytes.f(array4, array2);
        }
        else {
            array5 = Bytes.e(com.google.crypto.tink.subtle.a.a(array4), com.google.crypto.tink.subtle.a.b(array2));
        }
        return this.a.a(array5, 16);
    }
    
    @Override
    public byte[] a(final byte[] array, byte[] c) throws GeneralSecurityException {
        if (array.length <= 2147483631) {
            final Cipher cipher = EngineFactory.f.a("AES/CTR/NoPadding");
            c = this.c(new byte[][] { c, array });
            final byte[] array2 = c.clone();
            array2[8] &= 0x7F;
            array2[12] &= 0x7F;
            cipher.init(1, new SecretKeySpec(this.b, "AES"), new IvParameterSpec(array2));
            return Bytes.a(new byte[][] { c, cipher.doFinal(array) });
        }
        throw new GeneralSecurityException("plaintext too long");
    }
    
    @Override
    public byte[] b(byte[] doFinal, final byte[] array) throws GeneralSecurityException {
        if (doFinal.length < 16) {
            throw new GeneralSecurityException("Ciphertext too short.");
        }
        final Cipher cipher = EngineFactory.f.a("AES/CTR/NoPadding");
        final byte[] copyOfRange = Arrays.copyOfRange(doFinal, 0, 16);
        final byte[] array2 = copyOfRange.clone();
        array2[8] &= 0x7F;
        array2[12] &= 0x7F;
        cipher.init(2, new SecretKeySpec(this.b, "AES"), new IvParameterSpec(array2));
        final byte[] copyOfRange2 = Arrays.copyOfRange(doFinal, 16, doFinal.length);
        final byte[] array3 = doFinal = cipher.doFinal(copyOfRange2);
        if (copyOfRange2.length == 0 && (doFinal = array3) == null) {
            doFinal = array3;
            if (SubtleUtil.d()) {
                doFinal = new byte[0];
            }
        }
        if (Bytes.b(copyOfRange, this.c(new byte[][] { array, doFinal }))) {
            return doFinal;
        }
        throw new AEADBadTagException("Integrity check failed.");
    }
}
