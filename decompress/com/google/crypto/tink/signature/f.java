// 
// Decompiled by Procyon v0.6.0
// 

package com.google.crypto.tink.signature;

import com.google.crypto.tink.proto.RsaSsaPssParams;
import com.google.crypto.tink.proto.RsaSsaPkcs1Params;
import com.google.crypto.tink.proto.EcdsaParams;
import com.google.crypto.tink.subtle.Enums;
import com.google.crypto.tink.proto.HashType;
import com.google.crypto.tink.proto.EcdsaSignatureEncoding;
import java.security.GeneralSecurityException;
import com.google.crypto.tink.subtle.EllipticCurves;
import com.google.crypto.tink.proto.EllipticCurveType;

final class f
{
    public static EllipticCurves.CurveType a(final EllipticCurveType ellipticCurveType) throws GeneralSecurityException {
        final int n = f$a.b[ellipticCurveType.ordinal()];
        if (n == 1) {
            return EllipticCurves.CurveType.NIST_P256;
        }
        if (n == 2) {
            return EllipticCurves.CurveType.NIST_P384;
        }
        if (n == 3) {
            return EllipticCurves.CurveType.NIST_P521;
        }
        final StringBuilder sb = new StringBuilder();
        sb.append("unknown curve type: ");
        sb.append(ellipticCurveType.name());
        throw new GeneralSecurityException(sb.toString());
    }
    
    public static EllipticCurves.EcdsaEncoding b(final EcdsaSignatureEncoding ecdsaSignatureEncoding) throws GeneralSecurityException {
        final int n = f$a.a[ecdsaSignatureEncoding.ordinal()];
        if (n == 1) {
            return EllipticCurves.EcdsaEncoding.DER;
        }
        if (n == 2) {
            return EllipticCurves.EcdsaEncoding.IEEE_P1363;
        }
        final StringBuilder sb = new StringBuilder();
        sb.append("unknown ECDSA encoding: ");
        sb.append(ecdsaSignatureEncoding.name());
        throw new GeneralSecurityException(sb.toString());
    }
    
    public static Enums.HashType c(final HashType hashType) throws GeneralSecurityException {
        final int n = f$a.c[hashType.ordinal()];
        if (n == 1) {
            return Enums.HashType.SHA256;
        }
        if (n == 2) {
            return Enums.HashType.SHA384;
        }
        if (n == 3) {
            return Enums.HashType.SHA512;
        }
        final StringBuilder sb = new StringBuilder();
        sb.append("unsupported hash type: ");
        sb.append(hashType.name());
        throw new GeneralSecurityException(sb.toString());
    }
    
    public static void d(final EcdsaParams ecdsaParams) throws GeneralSecurityException {
        final EcdsaSignatureEncoding p = ecdsaParams.P();
        final HashType q = ecdsaParams.Q();
        final EllipticCurveType n = ecdsaParams.N();
        final int n2 = f$a.a[p.ordinal()];
        if (n2 != 1 && n2 != 2) {
            throw new GeneralSecurityException("unsupported signature encoding");
        }
        final int n3 = f$a.b[n.ordinal()];
        if (n3 != 1) {
            if (n3 != 2) {
                if (n3 != 3) {
                    throw new GeneralSecurityException("Invalid ECDSA parameters");
                }
                if (q != HashType.SHA512) {
                    throw new GeneralSecurityException("Invalid ECDSA parameters");
                }
            }
            else if (q != HashType.SHA384) {
                if (q != HashType.SHA512) {
                    throw new GeneralSecurityException("Invalid ECDSA parameters");
                }
            }
        }
        else if (q != HashType.SHA256) {
            throw new GeneralSecurityException("Invalid ECDSA parameters");
        }
    }
    
    public static void e(final RsaSsaPkcs1Params rsaSsaPkcs1Params) throws GeneralSecurityException {
        c(rsaSsaPkcs1Params.M());
    }
    
    public static void f(final RsaSsaPssParams rsaSsaPssParams) throws GeneralSecurityException {
        c(rsaSsaPssParams.Q());
        if (rsaSsaPssParams.Q() != rsaSsaPssParams.O()) {
            throw new GeneralSecurityException("MGF1 hash is different from signature hash");
        }
        if (rsaSsaPssParams.P() >= 0) {
            return;
        }
        throw new GeneralSecurityException("salt length is negative");
    }
}
