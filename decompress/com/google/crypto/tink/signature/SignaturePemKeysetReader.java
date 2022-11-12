// 
// Decompiled by Procyon v0.6.0
// 

package com.google.crypto.tink.signature;

import com.google.crypto.tink.shaded.protobuf.GeneratedMessageLite;
import java.util.ArrayList;
import java.util.Iterator;
import com.google.crypto.tink.proto.EncryptedKeyset;
import java.security.Key;
import com.google.crypto.tink.subtle.Random;
import com.google.crypto.tink.proto.OutputPrefixType;
import com.google.crypto.tink.proto.KeyStatusType;
import com.google.crypto.tink.proto.Keyset;
import java.io.BufferedReader;
import com.google.crypto.tink.proto.HashType;
import com.google.crypto.tink.proto.EllipticCurveType;
import com.google.crypto.tink.proto.RsaSsaPssParams;
import com.google.crypto.tink.proto.RsaSsaPssPublicKey;
import com.google.crypto.tink.proto.RsaSsaPkcs1Params;
import com.google.crypto.tink.proto.RsaSsaPkcs1PublicKey;
import java.security.interfaces.RSAPublicKey;
import java.io.IOException;
import com.google.crypto.tink.shaded.protobuf.ByteString;
import com.google.crypto.tink.proto.EcdsaSignatureEncoding;
import com.google.crypto.tink.proto.EcdsaParams;
import com.google.crypto.tink.proto.EcdsaPublicKey;
import com.google.crypto.tink.proto.KeyData;
import java.security.interfaces.ECPublicKey;
import com.google.crypto.tink.subtle.PemKeyType;
import java.util.List;
import com.google.crypto.tink.KeysetReader;

public final class SignaturePemKeysetReader implements KeysetReader
{
    private List<b> a;
    
    private static KeyData c(final PemKeyType pemKeyType, final ECPublicKey ecPublicKey) throws IOException {
        if (pemKeyType.algorithm.equals("ECDSA")) {
            return ((GeneratedMessageLite.Builder<KeyData, BuilderType>)KeyData.R().E(new a().c()).F(((GeneratedMessageLite.Builder<EcdsaPublicKey, BuilderType>)EcdsaPublicKey.T().E(new a().j()).D(((GeneratedMessageLite.Builder<EcdsaParams, BuilderType>)EcdsaParams.R().F(g(pemKeyType)).D(e(pemKeyType)).E(EcdsaSignatureEncoding.DER)).p()).F(ByteString.copyFrom(ecPublicKey.getW().getAffineX().toByteArray())).G(ByteString.copyFrom(ecPublicKey.getW().getAffineY().toByteArray()))).p().b()).D(KeyData.KeyMaterialType.ASYMMETRIC_PUBLIC)).p();
        }
        final StringBuilder sb = new StringBuilder();
        sb.append("unsupported EC signature algorithm: ");
        sb.append(pemKeyType.algorithm);
        throw new IOException(sb.toString());
    }
    
    private static KeyData d(final PemKeyType pemKeyType, final RSAPublicKey rsaPublicKey) throws IOException {
        if (pemKeyType.algorithm.equals("RSASSA-PKCS1-v1_5")) {
            return ((GeneratedMessageLite.Builder<KeyData, BuilderType>)KeyData.R().E(new d().c()).F(((GeneratedMessageLite.Builder<RsaSsaPkcs1PublicKey, BuilderType>)RsaSsaPkcs1PublicKey.T().G(new d().j()).F(((GeneratedMessageLite.Builder<RsaSsaPkcs1Params, BuilderType>)RsaSsaPkcs1Params.N().D(g(pemKeyType))).p()).D(ByteString.copyFrom(rsaPublicKey.getPublicExponent().toByteArray())).E(ByteString.copyFrom(rsaPublicKey.getModulus().toByteArray()))).p().b()).D(KeyData.KeyMaterialType.ASYMMETRIC_PUBLIC)).p();
        }
        if (pemKeyType.algorithm.equals("RSASSA-PSS")) {
            return ((GeneratedMessageLite.Builder<KeyData, BuilderType>)KeyData.R().E(new e().c()).F(((GeneratedMessageLite.Builder<RsaSsaPssPublicKey, BuilderType>)RsaSsaPssPublicKey.T().G(new e().j()).F(((GeneratedMessageLite.Builder<RsaSsaPssParams, BuilderType>)RsaSsaPssParams.R().F(g(pemKeyType)).D(g(pemKeyType)).E(f(pemKeyType))).p()).D(ByteString.copyFrom(rsaPublicKey.getPublicExponent().toByteArray())).E(ByteString.copyFrom(rsaPublicKey.getModulus().toByteArray()))).p().b()).D(KeyData.KeyMaterialType.ASYMMETRIC_PUBLIC)).p();
        }
        final StringBuilder sb = new StringBuilder();
        sb.append("unsupported RSA signature algorithm: ");
        sb.append(pemKeyType.algorithm);
        throw new IOException(sb.toString());
    }
    
    private static EllipticCurveType e(final PemKeyType pemKeyType) {
        final int keySizeInBits = pemKeyType.keySizeInBits;
        if (keySizeInBits == 256) {
            return EllipticCurveType.NIST_P256;
        }
        if (keySizeInBits == 384) {
            return EllipticCurveType.NIST_P384;
        }
        if (keySizeInBits == 521) {
            return EllipticCurveType.NIST_P521;
        }
        final StringBuilder sb = new StringBuilder();
        sb.append("unsupported curve for key size: ");
        sb.append(pemKeyType.keySizeInBits);
        throw new IllegalArgumentException(sb.toString());
    }
    
    private static int f(final PemKeyType pemKeyType) {
        final int n = SignaturePemKeysetReader$a.a[pemKeyType.hash.ordinal()];
        if (n == 1) {
            return 32;
        }
        if (n == 2) {
            return 48;
        }
        if (n == 3) {
            return 64;
        }
        final StringBuilder sb = new StringBuilder();
        sb.append("unsupported hash type: ");
        sb.append(pemKeyType.hash.name());
        throw new IllegalArgumentException(sb.toString());
    }
    
    private static HashType g(final PemKeyType pemKeyType) {
        final int n = SignaturePemKeysetReader$a.a[pemKeyType.hash.ordinal()];
        if (n == 1) {
            return HashType.SHA256;
        }
        if (n == 2) {
            return HashType.SHA384;
        }
        if (n == 3) {
            return HashType.SHA512;
        }
        final StringBuilder sb = new StringBuilder();
        sb.append("unsupported hash type: ");
        sb.append(pemKeyType.hash.name());
        throw new IllegalArgumentException(sb.toString());
    }
    
    private static Keyset.Key h(final BufferedReader bufferedReader, final PemKeyType pemKeyType) throws IOException {
        final Key key = pemKeyType.readKey(bufferedReader);
        if (key == null) {
            return null;
        }
        KeyData keyData;
        if (key instanceof RSAPublicKey) {
            keyData = d(pemKeyType, (RSAPublicKey)key);
        }
        else {
            if (!(key instanceof ECPublicKey)) {
                return null;
            }
            keyData = c(pemKeyType, (ECPublicKey)key);
        }
        return (Keyset.Key)Keyset.Key.T().D(keyData).G(KeyStatusType.ENABLED).F(OutputPrefixType.RAW).E(Random.d()).p();
    }
    
    @Override
    public EncryptedKeyset a() throws IOException {
        throw new UnsupportedOperationException();
    }
    
    @Override
    public Keyset b() throws IOException {
        final Keyset.Builder s = Keyset.S();
        for (final b b : this.a) {
            for (Keyset.Key key = h(b.a, b.b); key != null; key = h(b.a, b.b)) {
                s.D(key);
            }
        }
        if (s.F() != 0) {
            s.H(s.E(0).P());
            return ((GeneratedMessageLite.Builder<Keyset, BuilderType>)s).p();
        }
        throw new IOException("cannot find any key");
    }
    
    public static final class Builder
    {
        private List<b> a;
        
        Builder() {
            this.a = new ArrayList<b>();
        }
    }
    
    private static final class b
    {
        BufferedReader a;
        PemKeyType b;
    }
}
