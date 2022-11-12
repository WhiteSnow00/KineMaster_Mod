// 
// Decompiled by Procyon v0.6.0
// 

package com.google.crypto.tink.mac;

import java.security.GeneralSecurityException;
import com.google.crypto.tink.proto.RegistryConfig;

public final class MacConfig
{
    public static final String a;
    @Deprecated
    public static final RegistryConfig b;
    @Deprecated
    public static final RegistryConfig c;
    @Deprecated
    public static final RegistryConfig d;
    
    static {
        a = new HmacKeyManager().c();
        d = (c = (b = RegistryConfig.L()));
        try {
            a();
        }
        catch (final GeneralSecurityException ex) {
            throw new ExceptionInInitializerError(ex);
        }
    }
    
    private MacConfig() {
    }
    
    @Deprecated
    public static void a() throws GeneralSecurityException {
        b();
    }
    
    public static void b() throws GeneralSecurityException {
        HmacKeyManager.m(true);
        AesCmacKeyManager.n(true);
        com.google.crypto.tink.mac.a.e();
    }
}
