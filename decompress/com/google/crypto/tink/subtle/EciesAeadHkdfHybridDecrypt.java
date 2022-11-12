// 
// Decompiled by Procyon v0.6.0
// 

package com.google.crypto.tink.subtle;

import java.security.GeneralSecurityException;
import java.security.interfaces.ECPrivateKey;
import com.google.crypto.tink.HybridDecrypt;

public final class EciesAeadHkdfHybridDecrypt implements HybridDecrypt
{
    private static final byte[] g;
    private final ECPrivateKey a;
    private final EciesHkdfRecipientKem b;
    private final String c;
    private final byte[] d;
    private final EllipticCurves.PointFormatType e;
    private final EciesAeadHkdfDemHelper f;
    
    static {
        g = new byte[0];
    }
    
    public EciesAeadHkdfHybridDecrypt(final ECPrivateKey a, final byte[] d, final String c, final EllipticCurves.PointFormatType e, final EciesAeadHkdfDemHelper f) throws GeneralSecurityException {
        this.a = a;
        this.b = new EciesHkdfRecipientKem(a);
        this.d = d;
        this.c = c;
        this.e = e;
        this.f = f;
    }
}
