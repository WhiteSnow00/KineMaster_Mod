// 
// Decompiled by Procyon v0.6.0
// 

package com.google.crypto.tink.subtle;

import java.security.GeneralSecurityException;
import java.security.interfaces.ECPublicKey;
import com.google.crypto.tink.PublicKeyVerify;

public final class EcdsaVerifyJce implements PublicKeyVerify
{
    private final ECPublicKey a;
    private final String b;
    private final EllipticCurves.EcdsaEncoding c;
    
    public EcdsaVerifyJce(final ECPublicKey a, final Enums.HashType hashType, final EllipticCurves.EcdsaEncoding c) throws GeneralSecurityException {
        EllipticCurves.b(a);
        this.b = SubtleUtil.g(hashType);
        this.a = a;
        this.c = c;
    }
}
