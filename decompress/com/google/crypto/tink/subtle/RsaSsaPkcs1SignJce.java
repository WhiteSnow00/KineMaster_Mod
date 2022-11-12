// 
// Decompiled by Procyon v0.6.0
// 

package com.google.crypto.tink.subtle;

import java.security.PublicKey;
import java.security.PrivateKey;
import java.security.Signature;
import java.security.GeneralSecurityException;
import java.security.spec.KeySpec;
import java.security.spec.RSAPublicKeySpec;
import java.security.KeyFactory;
import java.security.interfaces.RSAPublicKey;
import java.security.interfaces.RSAPrivateCrtKey;
import com.google.crypto.tink.PublicKeySign;

public final class RsaSsaPkcs1SignJce implements PublicKeySign
{
    private final RSAPrivateCrtKey a;
    private final RSAPublicKey b;
    private final String c;
    
    public RsaSsaPkcs1SignJce(final RSAPrivateCrtKey a, final Enums.HashType hashType) throws GeneralSecurityException {
        Validators.e(hashType);
        Validators.c(a.getModulus().bitLength());
        Validators.d(a.getPublicExponent());
        this.a = a;
        this.c = SubtleUtil.h(hashType);
        this.b = (RSAPublicKey)EngineFactory.l.a("RSA").generatePublic(new RSAPublicKeySpec(a.getModulus(), a.getPublicExponent()));
    }
    
    public byte[] a(final byte[] array) throws GeneralSecurityException {
        final EngineFactory<EngineWrapper.TSignature, Signature> h = EngineFactory.h;
        final Signature signature = h.a(this.c);
        signature.initSign(this.a);
        signature.update(array);
        final byte[] sign = signature.sign();
        final Signature signature2 = h.a(this.c);
        signature2.initVerify(this.b);
        signature2.update(array);
        if (signature2.verify(sign)) {
            return sign;
        }
        throw new RuntimeException("Security bug: RSA signature computation error");
    }
}
