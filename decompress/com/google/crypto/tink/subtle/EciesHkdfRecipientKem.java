// 
// Decompiled by Procyon v0.6.0
// 

package com.google.crypto.tink.subtle;

import java.security.interfaces.ECPrivateKey;

public final class EciesHkdfRecipientKem
{
    private ECPrivateKey a;
    
    public EciesHkdfRecipientKem(final ECPrivateKey a) {
        this.a = a;
    }
}
