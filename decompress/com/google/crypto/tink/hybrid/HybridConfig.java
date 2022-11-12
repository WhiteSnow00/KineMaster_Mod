// 
// Decompiled by Procyon v0.6.0
// 

package com.google.crypto.tink.hybrid;

import com.google.crypto.tink.aead.AeadConfig;
import java.security.GeneralSecurityException;
import com.google.crypto.tink.proto.RegistryConfig;

public final class HybridConfig
{
    public static final String a;
    public static final String b;
    @Deprecated
    public static final RegistryConfig c;
    @Deprecated
    public static final RegistryConfig d;
    @Deprecated
    public static final RegistryConfig e;
    
    static {
        a = new a().c();
        b = new EciesAeadHkdfPrivateKeyManager().c();
        c = RegistryConfig.L();
        d = RegistryConfig.L();
        e = RegistryConfig.L();
        try {
            a();
        }
        catch (final GeneralSecurityException ex) {
            throw new ExceptionInInitializerError(ex);
        }
    }
    
    @Deprecated
    public static void a() throws GeneralSecurityException {
        b();
    }
    
    public static void b() throws GeneralSecurityException {
        AeadConfig.b();
        EciesAeadHkdfPrivateKeyManager.l(true);
        HybridDecryptWrapper.d();
        com.google.crypto.tink.hybrid.b.d();
    }
}
