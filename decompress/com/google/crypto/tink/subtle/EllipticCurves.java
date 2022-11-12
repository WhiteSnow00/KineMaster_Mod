// 
// Decompiled by Procyon v0.6.0
// 

package com.google.crypto.tink.subtle;

import java.security.spec.ECField;
import java.security.spec.ECFieldFp;
import java.security.spec.ECPublicKeySpec;
import java.security.spec.KeySpec;
import java.security.spec.ECPrivateKeySpec;
import java.security.KeyFactory;
import java.security.interfaces.ECPrivateKey;
import java.security.NoSuchAlgorithmException;
import java.security.spec.AlgorithmParameterSpec;
import java.security.KeyPairGenerator;
import java.security.spec.ECParameterSpec;
import java.security.KeyPair;
import java.security.interfaces.ECPublicKey;
import java.math.BigInteger;
import java.security.GeneralSecurityException;
import java.security.spec.EllipticCurve;
import java.security.spec.ECPoint;

public final class EllipticCurves
{
    static void a(final ECPoint ecPoint, final EllipticCurve ellipticCurve) throws GeneralSecurityException {
        final BigInteger i = i(ellipticCurve);
        final BigInteger affineX = ecPoint.getAffineX();
        final BigInteger affineY = ecPoint.getAffineY();
        if (affineX == null || affineY == null) {
            throw new GeneralSecurityException("point is at infinity");
        }
        if (affineX.signum() == -1 || affineX.compareTo(i) >= 0) {
            throw new GeneralSecurityException("x is out of range");
        }
        if (affineY.signum() == -1 || affineY.compareTo(i) >= 0) {
            throw new GeneralSecurityException("y is out of range");
        }
        if (affineY.multiply(affineY).mod(i).equals(affineX.multiply(affineX).add(ellipticCurve.getA()).multiply(affineX).add(ellipticCurve.getB()).mod(i))) {
            return;
        }
        throw new GeneralSecurityException("Point is not on curve");
    }
    
    static void b(final ECPublicKey ecPublicKey) throws GeneralSecurityException {
        a(ecPublicKey.getW(), ecPublicKey.getParams().getCurve());
    }
    
    static int c(final EllipticCurve ellipticCurve) throws GeneralSecurityException {
        return i(ellipticCurve).subtract(BigInteger.ONE).bitLength();
    }
    
    public static KeyPair d(final CurveType curveType) throws GeneralSecurityException {
        return e(f(curveType));
    }
    
    public static KeyPair e(final ECParameterSpec ecParameterSpec) throws GeneralSecurityException {
        final KeyPairGenerator keyPairGenerator = EngineFactory.k.a("EC");
        keyPairGenerator.initialize(ecParameterSpec);
        return keyPairGenerator.generateKeyPair();
    }
    
    public static ECParameterSpec f(final CurveType curveType) throws NoSuchAlgorithmException {
        final int n = EllipticCurves$a.b[curveType.ordinal()];
        if (n == 1) {
            return k();
        }
        if (n == 2) {
            return l();
        }
        if (n == 3) {
            return m();
        }
        final StringBuilder sb = new StringBuilder();
        sb.append("curve not implemented:");
        sb.append(curveType);
        throw new NoSuchAlgorithmException(sb.toString());
    }
    
    public static ECPrivateKey g(final CurveType curveType, final byte[] array) throws GeneralSecurityException {
        return (ECPrivateKey)EngineFactory.l.a("EC").generatePrivate(new ECPrivateKeySpec(new BigInteger(1, array), f(curveType)));
    }
    
    public static ECPublicKey h(final CurveType curveType, final byte[] array, final byte[] array2) throws GeneralSecurityException {
        final ECParameterSpec f = f(curveType);
        final ECPoint ecPoint = new ECPoint(new BigInteger(1, array), new BigInteger(1, array2));
        a(ecPoint, f.getCurve());
        return (ECPublicKey)EngineFactory.l.a("EC").generatePublic(new ECPublicKeySpec(ecPoint, f));
    }
    
    public static BigInteger i(final EllipticCurve ellipticCurve) throws GeneralSecurityException {
        final ECField field = ellipticCurve.getField();
        if (field instanceof ECFieldFp) {
            return ((ECFieldFp)field).getP();
        }
        throw new GeneralSecurityException("Only curves over prime order fields are supported");
    }
    
    private static ECParameterSpec j(final String s, final String s2, final String s3, final String s4, final String s5) {
        final BigInteger bigInteger = new BigInteger(s);
        return new ECParameterSpec(new EllipticCurve(new ECFieldFp(bigInteger), bigInteger.subtract(new BigInteger("3")), new BigInteger(s3, 16)), new ECPoint(new BigInteger(s4, 16), new BigInteger(s5, 16)), new BigInteger(s2), 1);
    }
    
    public static ECParameterSpec k() {
        return j("115792089210356248762697446949407573530086143415290314195533631308867097853951", "115792089210356248762697446949407573529996955224135760342422259061068512044369", "5ac635d8aa3a93e7b3ebbd55769886bc651d06b0cc53b0f63bce3c3e27d2604b", "6b17d1f2e12c4247f8bce6e563a440f277037d812deb33a0f4a13945d898c296", "4fe342e2fe1a7f9b8ee7eb4a7c0f9e162bce33576b315ececbb6406837bf51f5");
    }
    
    public static ECParameterSpec l() {
        return j("39402006196394479212279040100143613805079739270465446667948293404245721771496870329047266088258938001861606973112319", "39402006196394479212279040100143613805079739270465446667946905279627659399113263569398956308152294913554433653942643", "b3312fa7e23ee7e4988e056be3f82d19181d9c6efe8141120314088f5013875ac656398d8a2ed19d2a85c8edd3ec2aef", "aa87ca22be8b05378eb1c71ef320ad746e1d3b628ba79b9859f741e082542a385502f25dbf55296c3a545e3872760ab7", "3617de4a96262c6f5d9e98bf9292dc29f8f41dbd289a147ce9da3113b5f0b8c00a60b1ce1d7e819d7a431d7c90ea0e5f");
    }
    
    public static ECParameterSpec m() {
        return j("6864797660130609714981900799081393217269435300143305409394463459185543183397656052122559640661454554977296311391480858037121987999716643812574028291115057151", "6864797660130609714981900799081393217269435300143305409394463459185543183397655394245057746333217197532963996371363321113864768612440380340372808892707005449", "051953eb9618e1c9a1f929a21a0b68540eea2da725b99b315f3b8b489918ef109e156193951ec7e937b1652c0bd3bb1bf073573df883d2c34f1ef451fd46b503f00", "c6858e06b70404e9cd9e3ecb662395b4429c648139053fb521f828af606b4d3dbaa14b5e77efe75928fe1dc127a2ffa8de3348b3c1856a429bf97e7e31c2e5bd66", "11839296a789a3bc0045c8a5fb42c7d1bd998f54449579b446817afbd17273e662c97ee72995ef42640c550b9013fad0761353c7086a272c24088be94769fd16650");
    }
    
    public static boolean n(final ECParameterSpec ecParameterSpec) {
        return o(ecParameterSpec, k()) || o(ecParameterSpec, l()) || o(ecParameterSpec, m());
    }
    
    public static boolean o(final ECParameterSpec ecParameterSpec, final ECParameterSpec ecParameterSpec2) {
        return ecParameterSpec.getCurve().equals(ecParameterSpec2.getCurve()) && ecParameterSpec.getGenerator().equals(ecParameterSpec2.getGenerator()) && ecParameterSpec.getOrder().equals(ecParameterSpec2.getOrder()) && ecParameterSpec.getCofactor() == ecParameterSpec2.getCofactor();
    }
    
    public enum CurveType
    {
        private static final CurveType[] $VALUES;
        
        NIST_P256, 
        NIST_P384, 
        NIST_P521;
    }
    
    public enum EcdsaEncoding
    {
        private static final EcdsaEncoding[] $VALUES;
        
        DER, 
        IEEE_P1363;
    }
    
    public enum PointFormatType
    {
        private static final PointFormatType[] $VALUES;
        
        COMPRESSED, 
        DO_NOT_USE_CRUNCHY_UNCOMPRESSED, 
        UNCOMPRESSED;
    }
}
