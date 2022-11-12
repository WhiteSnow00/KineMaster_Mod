// 
// Decompiled by Procyon v0.6.0
// 

package com.google.crypto.tink.streamingaead;

import java.security.GeneralSecurityException;
import com.google.crypto.tink.proto.RegistryConfig;

public final class StreamingAeadConfig
{
    public static final String a;
    public static final String b;
    @Deprecated
    public static final RegistryConfig c;
    public static final RegistryConfig d;
    
    static {
        a = new AesCtrHmacStreamingKeyManager().c();
        b = new AesGcmHkdfStreamingKeyManager().c();
        c = RegistryConfig.L();
        d = RegistryConfig.L();
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
        AesCtrHmacStreamingKeyManager.m(true);
        AesGcmHkdfStreamingKeyManager.m(true);
        StreamingAeadWrapper.d();
    }
}
