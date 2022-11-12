// 
// Decompiled by Procyon v0.6.0
// 

package com.google.crypto.tink.signature;

import com.google.crypto.tink.shaded.protobuf.GeneratedMessageLite;
import com.google.crypto.tink.proto.RsaSsaPssParams;
import com.google.crypto.tink.proto.RsaSsaPssKeyFormat;
import com.google.crypto.tink.shaded.protobuf.ByteString;
import com.google.crypto.tink.proto.RsaSsaPkcs1Params;
import com.google.crypto.tink.proto.RsaSsaPkcs1KeyFormat;
import java.math.BigInteger;
import com.google.crypto.tink.proto.EcdsaParams;
import com.google.crypto.tink.proto.EcdsaKeyFormat;
import java.security.spec.RSAKeyGenParameterSpec;
import com.google.crypto.tink.proto.OutputPrefixType;
import com.google.crypto.tink.proto.EcdsaSignatureEncoding;
import com.google.crypto.tink.proto.EllipticCurveType;
import com.google.crypto.tink.proto.HashType;
import com.google.crypto.tink.proto.KeyTemplate;

@Deprecated
public final class SignatureKeyTemplates
{
    public static final KeyTemplate a;
    public static final KeyTemplate b;
    public static final KeyTemplate c;
    public static final KeyTemplate d;
    public static final KeyTemplate e;
    public static final KeyTemplate f;
    public static final KeyTemplate g;
    public static final KeyTemplate h;
    public static final KeyTemplate i;
    public static final KeyTemplate j;
    public static final KeyTemplate k;
    public static final KeyTemplate l;
    public static final KeyTemplate m;
    public static final KeyTemplate n;
    
    static {
        final HashType sha256 = HashType.SHA256;
        final EllipticCurveType nist_P256 = EllipticCurveType.NIST_P256;
        final EcdsaSignatureEncoding der = EcdsaSignatureEncoding.DER;
        final OutputPrefixType tink = OutputPrefixType.TINK;
        a = a(sha256, nist_P256, der, tink);
        final HashType sha257 = HashType.SHA512;
        final EllipticCurveType nist_P257 = EllipticCurveType.NIST_P384;
        b = a(sha257, nist_P257, der, tink);
        final EllipticCurveType nist_P258 = EllipticCurveType.NIST_P521;
        c = a(sha257, nist_P258, der, tink);
        final EcdsaSignatureEncoding ieee_P1363 = EcdsaSignatureEncoding.IEEE_P1363;
        d = a(sha256, nist_P256, ieee_P1363, tink);
        e = a(sha257, nist_P257, ieee_P1363, tink);
        final OutputPrefixType raw = OutputPrefixType.RAW;
        f = a(sha256, nist_P256, ieee_P1363, raw);
        g = a(sha257, nist_P258, ieee_P1363, tink);
        h = KeyTemplate.R().E(new Ed25519PrivateKeyManager().c()).D(tink).p();
        i = KeyTemplate.R().E(new Ed25519PrivateKeyManager().c()).D(raw).p();
        j = b(sha256, 3072, RSAKeyGenParameterSpec.F4, tink);
        k = b(sha256, 3072, RSAKeyGenParameterSpec.F4, raw);
        l = b(sha257, 4096, RSAKeyGenParameterSpec.F4, tink);
        m = c(sha256, sha256, 32, 3072, RSAKeyGenParameterSpec.F4);
        n = c(sha257, sha257, 64, 4096, RSAKeyGenParameterSpec.F4);
    }
    
    public static KeyTemplate a(final HashType hashType, final EllipticCurveType ellipticCurveType, final EcdsaSignatureEncoding ecdsaSignatureEncoding, final OutputPrefixType outputPrefixType) {
        return ((GeneratedMessageLite.Builder<KeyTemplate, BuilderType>)KeyTemplate.R().F(((GeneratedMessageLite.Builder<EcdsaKeyFormat, BuilderType>)EcdsaKeyFormat.M().D(((GeneratedMessageLite.Builder<EcdsaParams, BuilderType>)EcdsaParams.R().F(hashType).D(ellipticCurveType).E(ecdsaSignatureEncoding)).p())).p().b()).E(new EcdsaSignKeyManager().c()).D(outputPrefixType)).p();
    }
    
    public static KeyTemplate b(final HashType hashType, final int n, final BigInteger bigInteger, final OutputPrefixType outputPrefixType) {
        return ((GeneratedMessageLite.Builder<KeyTemplate, BuilderType>)KeyTemplate.R().F(((GeneratedMessageLite.Builder<RsaSsaPkcs1KeyFormat, BuilderType>)RsaSsaPkcs1KeyFormat.Q().E(((GeneratedMessageLite.Builder<RsaSsaPkcs1Params, BuilderType>)RsaSsaPkcs1Params.N().D(hashType)).p()).D(n).F(ByteString.copyFrom(bigInteger.toByteArray()))).p().b()).E(new RsaSsaPkcs1SignKeyManager().c()).D(outputPrefixType)).p();
    }
    
    public static KeyTemplate c(final HashType hashType, final HashType hashType2, final int n, final int n2, final BigInteger bigInteger) {
        return ((GeneratedMessageLite.Builder<KeyTemplate, BuilderType>)KeyTemplate.R().F(((GeneratedMessageLite.Builder<RsaSsaPssKeyFormat, BuilderType>)RsaSsaPssKeyFormat.Q().E(((GeneratedMessageLite.Builder<RsaSsaPssParams, BuilderType>)RsaSsaPssParams.R().F(hashType).D(hashType2).E(n)).p()).D(n2).F(ByteString.copyFrom(bigInteger.toByteArray()))).p().b()).E(new RsaSsaPssSignKeyManager().c()).D(OutputPrefixType.TINK)).p();
    }
}
