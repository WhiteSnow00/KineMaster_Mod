// 
// Decompiled by Procyon v0.6.0
// 

package com.google.crypto.tink.subtle;

import java.security.GeneralSecurityException;
import java.security.interfaces.ECPrivateKey;
import com.google.crypto.tink.PublicKeySign;

public final class EcdsaSignJce implements PublicKeySign
{
    private final ECPrivateKey a;
    private final String b;
    private final EllipticCurves.EcdsaEncoding c;
    
    public EcdsaSignJce(final ECPrivateKey a, final Enums.HashType hashType, final EllipticCurves.EcdsaEncoding c) throws GeneralSecurityException {
        this.a = a;
        this.b = SubtleUtil.g(hashType);
        this.c = c;
    }
}
