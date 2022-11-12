// 
// Decompiled by Procyon v0.6.0
// 

package com.google.crypto.tink.signature;

import com.google.crypto.tink.shaded.protobuf.GeneratedMessageLite;
import com.google.crypto.tink.proto.KeyData;
import com.google.crypto.tink.shaded.protobuf.ExtensionRegistryLite;
import java.security.KeyPair;
import java.security.spec.AlgorithmParameterSpec;
import java.security.spec.RSAKeyGenParameterSpec;
import java.security.KeyPairGenerator;
import com.google.crypto.tink.subtle.Validators;
import com.google.crypto.tink.shaded.protobuf.InvalidProtocolBufferException;
import com.google.crypto.tink.shaded.protobuf.ByteString;
import com.google.crypto.tink.proto.RsaSsaPssKeyFormat;
import com.google.crypto.tink.shaded.protobuf.MessageLite;
import com.google.crypto.tink.Registry;
import com.google.crypto.tink.proto.RsaSsaPssParams;
import com.google.crypto.tink.subtle.RsaSsaPssVerifyJce;
import java.security.spec.RSAPublicKeySpec;
import java.security.interfaces.RSAPublicKey;
import com.google.crypto.tink.subtle.RsaSsaPssSignJce;
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
import com.google.crypto.tink.proto.RsaSsaPssPublicKey;
import com.google.crypto.tink.proto.RsaSsaPssPrivateKey;
import com.google.crypto.tink.PrivateKeyTypeManager;

public final class RsaSsaPssSignKeyManager extends PrivateKeyTypeManager<RsaSsaPssPrivateKey, RsaSsaPssPublicKey>
{
    private static final byte[] e;
    
    static {
        e = "Tink and Wycheproof.".getBytes(Charset.forName("UTF-8"));
    }
    
    RsaSsaPssSignKeyManager() {
        super(RsaSsaPssPrivateKey.class, RsaSsaPssPublicKey.class, (PrimitiveFactory<?, RsaSsaPssPrivateKey>[])new PrimitiveFactory[] { new PrimitiveFactory<PublicKeySign, RsaSsaPssPrivateKey>(PublicKeySign.class) {
                @Override
                public /* bridge */ Object a(final Object o) throws GeneralSecurityException {
                    return this.c((RsaSsaPssPrivateKey)o);
                }
                
                public PublicKeySign c(final RsaSsaPssPrivateKey rsaSsaPssPrivateKey) throws GeneralSecurityException {
                    final java.security.KeyFactory keyFactory = EngineFactory.l.a("RSA");
                    final RSAPrivateCrtKey rsaPrivateCrtKey = (RSAPrivateCrtKey)keyFactory.generatePrivate(new RSAPrivateCrtKeySpec(new BigInteger(1, rsaSsaPssPrivateKey.X().Q().toByteArray()), new BigInteger(1, rsaSsaPssPrivateKey.X().P().toByteArray()), new BigInteger(1, rsaSsaPssPrivateKey.T().toByteArray()), new BigInteger(1, rsaSsaPssPrivateKey.W().toByteArray()), new BigInteger(1, rsaSsaPssPrivateKey.Y().toByteArray()), new BigInteger(1, rsaSsaPssPrivateKey.U().toByteArray()), new BigInteger(1, rsaSsaPssPrivateKey.V().toByteArray()), new BigInteger(1, rsaSsaPssPrivateKey.S().toByteArray())));
                    final RsaSsaPssParams r = rsaSsaPssPrivateKey.X().R();
                    final RsaSsaPssSignJce rsaSsaPssSignJce = new RsaSsaPssSignJce(rsaPrivateCrtKey, f.c(r.Q()), f.c(r.O()), r.P());
                    final RsaSsaPssVerifyJce rsaSsaPssVerifyJce = new RsaSsaPssVerifyJce((RSAPublicKey)keyFactory.generatePublic(new RSAPublicKeySpec(new BigInteger(1, rsaSsaPssPrivateKey.X().Q().toByteArray()), new BigInteger(1, rsaSsaPssPrivateKey.X().P().toByteArray()))), f.c(r.Q()), f.c(r.O()), r.P());
                    try {
                        rsaSsaPssVerifyJce.b(rsaSsaPssSignJce.c(RsaSsaPssSignKeyManager.j()), RsaSsaPssSignKeyManager.j());
                        return rsaSsaPssSignJce;
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
        return RsaSsaPssSignKeyManager.e;
    }
    
    public static void m(final boolean b) throws GeneralSecurityException {
        Registry.r((PrivateKeyTypeManager<MessageLite, MessageLite>)new RsaSsaPssSignKeyManager(), (KeyTypeManager<MessageLite>)new e(), b);
    }
    
    @Override
    public String c() {
        return "type.googleapis.com/google.crypto.tink.RsaSsaPssPrivateKey";
    }
    
    @Override
    public KeyFactory<RsaSsaPssKeyFormat, RsaSsaPssPrivateKey> e() {
        return new KeyFactory<RsaSsaPssKeyFormat, RsaSsaPssPrivateKey>(this, RsaSsaPssKeyFormat.class) {
            final RsaSsaPssSignKeyManager b;
            
            @Override
            public /* bridge */ Object a(final MessageLite messageLite) throws GeneralSecurityException {
                return this.e((RsaSsaPssKeyFormat)messageLite);
            }
            
            @Override
            public /* bridge */ MessageLite c(final ByteString byteString) throws InvalidProtocolBufferException {
                return this.f(byteString);
            }
            
            @Override
            public /* bridge */ void d(final MessageLite messageLite) throws GeneralSecurityException {
                this.g((RsaSsaPssKeyFormat)messageLite);
            }
            
            public RsaSsaPssPrivateKey e(final RsaSsaPssKeyFormat rsaSsaPssKeyFormat) throws GeneralSecurityException {
                final RsaSsaPssParams o = rsaSsaPssKeyFormat.O();
                Validators.c(rsaSsaPssKeyFormat.N());
                Validators.e(f.c(o.Q()));
                final KeyPairGenerator keyPairGenerator = EngineFactory.k.a("RSA");
                keyPairGenerator.initialize(new RSAKeyGenParameterSpec(rsaSsaPssKeyFormat.N(), new BigInteger(1, rsaSsaPssKeyFormat.P().toByteArray())));
                final KeyPair generateKeyPair = keyPairGenerator.generateKeyPair();
                final RSAPublicKey rsaPublicKey = (RSAPublicKey)generateKeyPair.getPublic();
                final RSAPrivateCrtKey rsaPrivateCrtKey = (RSAPrivateCrtKey)generateKeyPair.getPrivate();
                return RsaSsaPssPrivateKey.a0().K(this.b.k()).I(((GeneratedMessageLite.Builder<RsaSsaPssPublicKey, BuilderType>)RsaSsaPssPublicKey.T().G(this.b.k()).F(o).D(ByteString.copyFrom(rsaPublicKey.getPublicExponent().toByteArray())).E(ByteString.copyFrom(rsaPublicKey.getModulus().toByteArray()))).p()).E(ByteString.copyFrom(rsaPrivateCrtKey.getPrivateExponent().toByteArray())).H(ByteString.copyFrom(rsaPrivateCrtKey.getPrimeP().toByteArray())).J(ByteString.copyFrom(rsaPrivateCrtKey.getPrimeQ().toByteArray())).F(ByteString.copyFrom(rsaPrivateCrtKey.getPrimeExponentP().toByteArray())).G(ByteString.copyFrom(rsaPrivateCrtKey.getPrimeExponentQ().toByteArray())).D(ByteString.copyFrom(rsaPrivateCrtKey.getCrtCoefficient().toByteArray())).p();
            }
            
            public RsaSsaPssKeyFormat f(final ByteString byteString) throws InvalidProtocolBufferException {
                return RsaSsaPssKeyFormat.R(byteString, ExtensionRegistryLite.b());
            }
            
            public void g(final RsaSsaPssKeyFormat rsaSsaPssKeyFormat) throws GeneralSecurityException {
                f.f(rsaSsaPssKeyFormat.O());
                Validators.c(rsaSsaPssKeyFormat.N());
                Validators.d(new BigInteger(1, rsaSsaPssKeyFormat.P().toByteArray()));
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
        this.n((RsaSsaPssPrivateKey)messageLite);
    }
    
    public int k() {
        return 0;
    }
    
    public RsaSsaPssPrivateKey l(final ByteString byteString) throws InvalidProtocolBufferException {
        return RsaSsaPssPrivateKey.b0(byteString, ExtensionRegistryLite.b());
    }
    
    public void n(final RsaSsaPssPrivateKey rsaSsaPssPrivateKey) throws GeneralSecurityException {
        Validators.f(rsaSsaPssPrivateKey.Z(), this.k());
        Validators.c(new BigInteger(1, rsaSsaPssPrivateKey.X().Q().toByteArray()).bitLength());
        Validators.d(new BigInteger(1, rsaSsaPssPrivateKey.X().P().toByteArray()));
        f.f(rsaSsaPssPrivateKey.X().R());
    }
}
