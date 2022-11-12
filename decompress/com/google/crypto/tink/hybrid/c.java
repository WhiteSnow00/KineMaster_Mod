// 
// Decompiled by Procyon v0.6.0
// 

package com.google.crypto.tink.hybrid;

import com.google.crypto.tink.Registry;
import com.google.crypto.tink.proto.EciesAeadHkdfParams;
import com.google.crypto.tink.proto.EcPointFormat;
import java.security.NoSuchAlgorithmException;
import com.google.crypto.tink.proto.HashType;
import java.security.GeneralSecurityException;
import com.google.crypto.tink.subtle.EllipticCurves;
import com.google.crypto.tink.proto.EllipticCurveType;

class c
{
    public static EllipticCurves.CurveType a(final EllipticCurveType ellipticCurveType) throws GeneralSecurityException {
        final int n = c$a.b[ellipticCurveType.ordinal()];
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
        sb.append(ellipticCurveType);
        throw new GeneralSecurityException(sb.toString());
    }
    
    public static String b(final HashType hashType) throws NoSuchAlgorithmException {
        final int n = c$a.a[hashType.ordinal()];
        if (n == 1) {
            return "HmacSha1";
        }
        if (n == 2) {
            return "HmacSha256";
        }
        if (n == 3) {
            return "HmacSha512";
        }
        final StringBuilder sb = new StringBuilder();
        sb.append("hash unsupported for HMAC: ");
        sb.append(hashType);
        throw new NoSuchAlgorithmException(sb.toString());
    }
    
    public static EllipticCurves.PointFormatType c(final EcPointFormat ecPointFormat) throws GeneralSecurityException {
        final int n = c$a.c[ecPointFormat.ordinal()];
        if (n == 1) {
            return EllipticCurves.PointFormatType.UNCOMPRESSED;
        }
        if (n == 2) {
            return EllipticCurves.PointFormatType.DO_NOT_USE_CRUNCHY_UNCOMPRESSED;
        }
        if (n == 3) {
            return EllipticCurves.PointFormatType.COMPRESSED;
        }
        final StringBuilder sb = new StringBuilder();
        sb.append("unknown point format: ");
        sb.append(ecPointFormat);
        throw new GeneralSecurityException(sb.toString());
    }
    
    public static void d(final EciesAeadHkdfParams eciesAeadHkdfParams) throws GeneralSecurityException {
        EllipticCurves.f(a(eciesAeadHkdfParams.Q().N()));
        b(eciesAeadHkdfParams.Q().P());
        if (eciesAeadHkdfParams.P() != EcPointFormat.UNKNOWN_FORMAT) {
            Registry.q(eciesAeadHkdfParams.O().L());
            return;
        }
        throw new GeneralSecurityException("unknown EC point format");
    }
}
