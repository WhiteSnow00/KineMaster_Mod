// 
// Decompiled by Procyon v0.6.0
// 

package com.google.crypto.tink.signature;

import java.security.GeneralSecurityException;
import com.google.crypto.tink.proto.RegistryConfig;

public final class SignatureConfig
{
    public static final String a;
    public static final String b;
    public static final String c;
    public static final String d;
    public static final String e;
    public static final String f;
    @Deprecated
    public static final RegistryConfig g;
    @Deprecated
    public static final RegistryConfig h;
    public static final RegistryConfig i;
    
    static {
        a = new a().c();
        b = new EcdsaSignKeyManager().c();
        c = new b().c();
        d = new Ed25519PrivateKeyManager().c();
        e = new RsaSsaPkcs1SignKeyManager().c();
        f = new d().c();
        g = RegistryConfig.L();
        h = RegistryConfig.L();
        i = RegistryConfig.L();
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
        EcdsaSignKeyManager.l(true);
        Ed25519PrivateKeyManager.l(true);
        RsaSsaPkcs1SignKeyManager.m(true);
        RsaSsaPssSignKeyManager.m(true);
        PublicKeySignWrapper.d();
        com.google.crypto.tink.signature.c.d();
    }
}
