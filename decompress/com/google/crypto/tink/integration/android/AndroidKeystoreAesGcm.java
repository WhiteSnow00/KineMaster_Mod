// 
// Decompiled by Procyon v0.6.0
// 

package com.google.crypto.tink.integration.android;

import android.util.Log;
import java.security.ProviderException;
import java.security.spec.AlgorithmParameterSpec;
import java.security.Key;
import javax.crypto.Cipher;
import javax.crypto.spec.GCMParameterSpec;
import java.security.GeneralSecurityException;
import java.security.InvalidKeyException;
import java.security.KeyStore;
import javax.crypto.SecretKey;
import com.google.crypto.tink.Aead;

public final class AndroidKeystoreAesGcm implements Aead
{
    private static final String b = "AndroidKeystoreAesGcm";
    private final SecretKey a;
    
    AndroidKeystoreAesGcm(final String s, final KeyStore keyStore) throws GeneralSecurityException {
        final SecretKey a = (SecretKey)keyStore.getKey(s, null);
        this.a = a;
        if (a != null) {
            return;
        }
        final StringBuilder sb = new StringBuilder();
        sb.append("Keystore cannot load the key with ID: ");
        sb.append(s);
        throw new InvalidKeyException(sb.toString());
    }
    
    private byte[] c(final byte[] array, final byte[] array2) throws GeneralSecurityException {
        if (array.length >= 28) {
            final GCMParameterSpec gcmParameterSpec = new GCMParameterSpec(128, array, 0, 12);
            final Cipher instance = Cipher.getInstance("AES/GCM/NoPadding");
            instance.init(2, this.a, gcmParameterSpec);
            instance.updateAAD(array2);
            return instance.doFinal(array, 12, array.length - 12);
        }
        throw new GeneralSecurityException("ciphertext too short");
    }
    
    private byte[] d(final byte[] array, final byte[] array2) throws GeneralSecurityException {
        if (array.length <= 2147483619) {
            final byte[] array3 = new byte[array.length + 12 + 16];
            final Cipher instance = Cipher.getInstance("AES/GCM/NoPadding");
            instance.init(1, this.a);
            instance.updateAAD(array2);
            instance.doFinal(array, 0, array.length, array3, 12);
            System.arraycopy(instance.getIV(), 0, array3, 0, 12);
            return array3;
        }
        throw new GeneralSecurityException("plaintext too long");
    }
    
    private static void e() {
        final long n = (int)(Math.random() * 100.0);
        try {
            Thread.sleep(n);
        }
        catch (final InterruptedException ex) {}
    }
    
    @Override
    public byte[] a(final byte[] array, final byte[] array2) throws GeneralSecurityException {
        byte[] d = null;
        try {
            d = this.d(array, array2);
            return d;
        }
        catch (final GeneralSecurityException d) {}
        catch (final ProviderException ex) {}
        Log.w(AndroidKeystoreAesGcm.b, "encountered a potentially transient KeyStore error, will wait and retry", (Throwable)(Object)d);
        e();
        return this.d(array, array2);
    }
    
    @Override
    public byte[] b(final byte[] array, final byte[] array2) throws GeneralSecurityException {
        byte[] c = null;
        try {
            c = this.c(array, array2);
            return c;
        }
        catch (final GeneralSecurityException c) {}
        catch (final ProviderException ex) {}
        Log.w(AndroidKeystoreAesGcm.b, "encountered a potentially transient KeyStore error, will wait and retry", (Throwable)(Object)c);
        e();
        return this.c(array, array2);
    }
}
