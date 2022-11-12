// 
// Decompiled by Procyon v0.6.0
// 

package com.google.crypto.tink.daead;

import java.security.GeneralSecurityException;
import com.google.crypto.tink.proto.RegistryConfig;

public final class DeterministicAeadConfig
{
    public static final String a;
    @Deprecated
    public static final RegistryConfig b;
    @Deprecated
    public static final RegistryConfig c;
    
    static {
        a = new AesSivKeyManager().c();
        b = RegistryConfig.L();
        c = RegistryConfig.L();
        try {
            a();
        }
        catch (final GeneralSecurityException ex) {
            throw new ExceptionInInitializerError(ex);
        }
    }
    
    private DeterministicAeadConfig() {
    }
    
    @Deprecated
    public static void a() throws GeneralSecurityException {
        b();
    }
    
    public static void b() throws GeneralSecurityException {
        AesSivKeyManager.n(true);
        DeterministicAeadWrapper.e();
    }
}
