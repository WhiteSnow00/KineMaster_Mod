// 
// Decompiled by Procyon v0.6.0
// 

package com.google.crypto.tink.subtle;

import java.security.interfaces.ECPublicKey;

public final class EciesHkdfSenderKem
{
    private ECPublicKey a;
    
    public EciesHkdfSenderKem(final ECPublicKey a) {
        this.a = a;
    }
    
    public static final class KemKey
    {
    }
}
