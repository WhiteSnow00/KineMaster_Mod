// 
// Decompiled by Procyon v0.6.0
// 

package com.google.crypto.tink.subtle;

import java.security.GeneralSecurityException;
import java.security.interfaces.ECPublicKey;
import com.google.crypto.tink.HybridEncrypt;

public final class EciesAeadHkdfHybridEncrypt implements HybridEncrypt
{
    private static final byte[] f;
    private final EciesHkdfSenderKem a;
    private final String b;
    private final byte[] c;
    private final EllipticCurves.PointFormatType d;
    private final EciesAeadHkdfDemHelper e;
    
    static {
        f = new byte[0];
    }
    
    public EciesAeadHkdfHybridEncrypt(final ECPublicKey ecPublicKey, final byte[] c, final String b, final EllipticCurves.PointFormatType d, final EciesAeadHkdfDemHelper e) throws GeneralSecurityException {
        EllipticCurves.b(ecPublicKey);
        this.a = new EciesHkdfSenderKem(ecPublicKey);
        this.c = c;
        this.b = b;
        this.d = d;
        this.e = e;
    }
}
