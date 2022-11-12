// 
// Decompiled by Procyon v0.6.0
// 

package com.google.crypto.tink.prf;

public final class PrfConfig
{
    public static final String a;
    
    static {
        a = new HkdfPrfKeyManager().c();
    }
    
    private PrfConfig() {
    }
}
