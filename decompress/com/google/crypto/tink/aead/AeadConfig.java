// 
// Decompiled by Procyon v0.6.0
// 

package com.google.crypto.tink.aead;

import com.google.crypto.tink.mac.MacConfig;
import java.security.GeneralSecurityException;
import com.google.crypto.tink.proto.RegistryConfig;

public final class AeadConfig
{
    public static final String a;
    public static final String b;
    public static final String c;
    public static final String d;
    public static final String e;
    public static final String f;
    public static final String g;
    public static final String h;
    @Deprecated
    public static final RegistryConfig i;
    @Deprecated
    public static final RegistryConfig j;
    @Deprecated
    public static final RegistryConfig k;
    
    static {
        a = new AesCtrHmacAeadKeyManager().c();
        b = new AesGcmKeyManager().c();
        c = new AesGcmSivKeyManager().c();
        d = new AesEaxKeyManager().c();
        e = new KmsAeadKeyManager().c();
        f = new KmsEnvelopeAeadKeyManager().c();
        g = new ChaCha20Poly1305KeyManager().c();
        h = new XChaCha20Poly1305KeyManager().c();
        k = (j = (i = RegistryConfig.L()));
        try {
            a();
        }
        catch (final GeneralSecurityException ex) {
            throw new ExceptionInInitializerError(ex);
        }
    }
    
    private AeadConfig() {
    }
    
    @Deprecated
    public static void a() throws GeneralSecurityException {
        b();
    }
    
    public static void b() throws GeneralSecurityException {
        MacConfig.b();
        AesCtrHmacAeadKeyManager.l(true);
        AesEaxKeyManager.l(true);
        AesGcmKeyManager.n(true);
        AesGcmSivKeyManager.m(true);
        ChaCha20Poly1305KeyManager.l(true);
        KmsAeadKeyManager.l(true);
        KmsEnvelopeAeadKeyManager.l(true);
        XChaCha20Poly1305KeyManager.l(true);
        AeadWrapper.e();
    }
}
