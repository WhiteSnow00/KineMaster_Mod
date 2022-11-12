// 
// Decompiled by Procyon v0.6.0
// 

package com.google.crypto.tink.signature;

import com.google.crypto.tink.shaded.protobuf.GeneratedMessageLite;
import com.google.crypto.tink.proto.KeyData;
import com.google.crypto.tink.subtle.Validators;
import com.google.crypto.tink.shaded.protobuf.ExtensionRegistryLite;
import java.security.KeyPair;
import com.google.crypto.tink.proto.RsaSsaPkcs1Params;
import java.security.spec.AlgorithmParameterSpec;
import java.security.spec.RSAKeyGenParameterSpec;
import java.security.KeyPairGenerator;
import com.google.crypto.tink.shaded.protobuf.InvalidProtocolBufferException;
import com.google.crypto.tink.shaded.protobuf.ByteString;
import com.google.crypto.tink.proto.RsaSsaPkcs1KeyFormat;
import com.google.crypto.tink.shaded.protobuf.MessageLite;
import com.google.crypto.tink.Registry;
import com.google.crypto.tink.subtle.RsaSsaPkcs1VerifyJce;
import java.security.spec.RSAPublicKeySpec;
import java.security.interfaces.RSAPublicKey;
import com.google.crypto.tink.subtle.RsaSsaPkcs1SignJce;
import java.security.spec.KeySpec;
import java.security.spec.RSAPrivateCrtKeySpec;
import java.math.BigInteger;
import java.security.interfaces.RSAPrivateCrtKey;
import com.google.crypto.tink.subtle.EngineFactory;
import java.security.KeyFactory;
import java.security.GeneralSecurityException;
import com.google.crypto.tink.PublicKeySign;
import com.google.crypto.tink.KeyTypeManager;
import java.nio.charset.Charset;
import com.google.crypto.tink.proto.RsaSsaPkcs1PublicKey;
import com.google.crypto.tink.proto.RsaSsaPkcs1PrivateKey;
import com.google.crypto.tink.PrivateKeyTypeManager;

public final class RsaSsaPkcs1SignKeyManager extends PrivateKeyTypeManager<RsaSsaPkcs1PrivateKey, RsaSsaPkcs1PublicKey>
{
    private static final byte[] e;
    
    static {
        e = "Tink and Wycheproof.".getBytes(Charset.forName("UTF-8"));
    }
    
    RsaSsaPkcs1SignKeyManager() {
        super(RsaSsaPkcs1PrivateKey.class, RsaSsaPkcs1PublicKey.class, (PrimitiveFactory<?, RsaSsaPkcs1PrivateKey>[])new PrimitiveFactory[] { new PrimitiveFactory<PublicKeySign, RsaSsaPkcs1PrivateKey>(PublicKeySign.class) {
                @Override
                public /* bridge */ Object a(final Object o) throws GeneralSecurityException {
                    return this.c((RsaSsaPkcs1PrivateKey)o);
                }
                
                public PublicKeySign c(final RsaSsaPkcs1PrivateKey rsaSsaPkcs1PrivateKey) throws GeneralSecurityException {
                    final java.security.KeyFactory keyFactory = EngineFactory.l.a("RSA");
                    final RsaSsaPkcs1SignJce rsaSsaPkcs1SignJce = new RsaSsaPkcs1SignJce((RSAPrivateCrtKey)keyFactory.generatePrivate(new RSAPrivateCrtKeySpec(new BigInteger(1, rsaSsaPkcs1PrivateKey.X().Q().toByteArray()), new BigInteger(1, rsaSsaPkcs1PrivateKey.X().P().toByteArray()), new BigInteger(1, rsaSsaPkcs1PrivateKey.T().toByteArray()), new BigInteger(1, rsaSsaPkcs1PrivateKey.W().toByteArray()), new BigInteger(1, rsaSsaPkcs1PrivateKey.Y().toByteArray()), new BigInteger(1, rsaSsaPkcs1PrivateKey.U().toByteArray()), new BigInteger(1, rsaSsaPkcs1PrivateKey.V().toByteArray()), new BigInteger(1, rsaSsaPkcs1PrivateKey.S().toByteArray()))), f.c(rsaSsaPkcs1PrivateKey.X().R().M()));
                    final RsaSsaPkcs1VerifyJce rsaSsaPkcs1VerifyJce = new RsaSsaPkcs1VerifyJce((RSAPublicKey)keyFactory.generatePublic(new RSAPublicKeySpec(new BigInteger(1, rsaSsaPkcs1PrivateKey.X().Q().toByteArray()), new BigInteger(1, rsaSsaPkcs1PrivateKey.X().P().toByteArray()))), f.c(rsaSsaPkcs1PrivateKey.X().R().M()));
                    try {
                        rsaSsaPkcs1VerifyJce.c(rsaSsaPkcs1SignJce.a(RsaSsaPkcs1SignKeyManager.j()), RsaSsaPkcs1SignKeyManager.j());
                        return rsaSsaPkcs1SignJce;
                    }
                    catch (final GeneralSecurityException ex) {
                        final StringBuilder sb = new StringBuilder();
                        sb.append("Security bug: signing with private key followed by verifying with public key failed");
                        sb.append(ex);
                        throw new RuntimeException(sb.toString());
                    }
                }
            } });
    }
    
    static byte[] j() {
        return RsaSsaPkcs1SignKeyManager.e;
    }
    
    public static void m(final boolean b) throws GeneralSecurityException {
        Registry.r((PrivateKeyTypeManager<MessageLite, MessageLite>)new RsaSsaPkcs1SignKeyManager(), (KeyTypeManager<MessageLite>)new d(), b);
    }
    
    @Override
    public String c() {
        return "type.googleapis.com/google.crypto.tink.RsaSsaPkcs1PrivateKey";
    }
    
    @Override
    public KeyFactory<RsaSsaPkcs1KeyFormat, RsaSsaPkcs1PrivateKey> e() {
        return new KeyFactory<RsaSsaPkcs1KeyFormat, RsaSsaPkcs1PrivateKey>(this, RsaSsaPkcs1KeyFormat.class) {
            final RsaSsaPkcs1SignKeyManager b;
            
            @Override
            public /* bridge */ Object a(final MessageLite messageLite) throws GeneralSecurityException {
                return this.e((RsaSsaPkcs1KeyFormat)messageLite);
            }
            
            @Override
            public /* bridge */ MessageLite c(final ByteString byteString) throws InvalidProtocolBufferException {
                return this.f(byteString);
            }
            
            @Override
            public /* bridge */ void d(final MessageLite messageLite) throws GeneralSecurityException {
                this.g((RsaSsaPkcs1KeyFormat)messageLite);
            }
            
            public RsaSsaPkcs1PrivateKey e(final RsaSsaPkcs1KeyFormat rsaSsaPkcs1KeyFormat) throws GeneralSecurityException {
                final RsaSsaPkcs1Params o = rsaSsaPkcs1KeyFormat.O();
                final KeyPairGenerator keyPairGenerator = EngineFactory.k.a("RSA");
                keyPairGenerator.initialize(new RSAKeyGenParameterSpec(rsaSsaPkcs1KeyFormat.N(), new BigInteger(1, rsaSsaPkcs1KeyFormat.P().toByteArray())));
                final KeyPair generateKeyPair = keyPairGenerator.generateKeyPair();
                final RSAPublicKey rsaPublicKey = (RSAPublicKey)generateKeyPair.getPublic();
                final RSAPrivateCrtKey rsaPrivateCrtKey = (RSAPrivateCrtKey)generateKeyPair.getPrivate();
                return RsaSsaPkcs1PrivateKey.a0().K(this.b.k()).I(((GeneratedMessageLite.Builder<RsaSsaPkcs1PublicKey, BuilderType>)RsaSsaPkcs1PublicKey.T().G(this.b.k()).F(o).D(ByteString.copyFrom(rsaPublicKey.getPublicExponent().toByteArray())).E(ByteString.copyFrom(rsaPublicKey.getModulus().toByteArray()))).p()).E(ByteString.copyFrom(rsaPrivateCrtKey.getPrivateExponent().toByteArray())).H(ByteString.copyFrom(rsaPrivateCrtKey.getPrimeP().toByteArray())).J(ByteString.copyFrom(rsaPrivateCrtKey.getPrimeQ().toByteArray())).F(ByteString.copyFrom(rsaPrivateCrtKey.getPrimeExponentP().toByteArray())).G(ByteString.copyFrom(rsaPrivateCrtKey.getPrimeExponentQ().toByteArray())).D(ByteString.copyFrom(rsaPrivateCrtKey.getCrtCoefficient().toByteArray())).p();
            }
            
            public RsaSsaPkcs1KeyFormat f(final ByteString byteString) throws InvalidProtocolBufferException {
                return RsaSsaPkcs1KeyFormat.R(byteString, ExtensionRegistryLite.b());
            }
            
            public void g(final RsaSsaPkcs1KeyFormat rsaSsaPkcs1KeyFormat) throws GeneralSecurityException {
                f.e(rsaSsaPkcs1KeyFormat.O());
                Validators.c(rsaSsaPkcs1KeyFormat.N());
                Validators.d(new BigInteger(1, rsaSsaPkcs1KeyFormat.P().toByteArray()));
            }
        };
    }
    
    @Override
    public KeyData.KeyMaterialType f() {
        return KeyData.KeyMaterialType.ASYMMETRIC_PRIVATE;
    }
    
    @Override
    public /* bridge */ MessageLite g(final ByteString byteString) throws InvalidProtocolBufferException {
        return this.l(byteString);
    }
    
    @Override
    public /* bridge */ void i(final MessageLite messageLite) throws GeneralSecurityException {
        this.n((RsaSsaPkcs1PrivateKey)messageLite);
    }
    
    public int k() {
        return 0;
    }
    
    public RsaSsaPkcs1PrivateKey l(final ByteString byteString) throws InvalidProtocolBufferException {
        return RsaSsaPkcs1PrivateKey.b0(byteString, ExtensionRegistryLite.b());
    }
    
    public void n(final RsaSsaPkcs1PrivateKey rsaSsaPkcs1PrivateKey) throws GeneralSecurityException {
        Validators.f(rsaSsaPkcs1PrivateKey.Z(), this.k());
        Validators.c(new BigInteger(1, rsaSsaPkcs1PrivateKey.X().Q().toByteArray()).bitLength());
        Validators.d(new BigInteger(1, rsaSsaPkcs1PrivateKey.X().P().toByteArray()));
        f.e(rsaSsaPkcs1PrivateKey.X().R());
    }
}
