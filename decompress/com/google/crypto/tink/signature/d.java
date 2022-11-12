// 
// Decompiled by Procyon v0.6.0
// 

package com.google.crypto.tink.signature;

import com.google.crypto.tink.subtle.Validators;
import com.google.crypto.tink.shaded.protobuf.ExtensionRegistryLite;
import com.google.crypto.tink.shaded.protobuf.InvalidProtocolBufferException;
import com.google.crypto.tink.shaded.protobuf.MessageLite;
import com.google.crypto.tink.shaded.protobuf.ByteString;
import com.google.crypto.tink.proto.KeyData;
import com.google.crypto.tink.subtle.RsaSsaPkcs1VerifyJce;
import java.security.spec.KeySpec;
import java.security.spec.RSAPublicKeySpec;
import java.math.BigInteger;
import com.google.crypto.tink.subtle.EngineFactory;
import java.security.KeyFactory;
import java.security.interfaces.RSAPublicKey;
import java.security.GeneralSecurityException;
import com.google.crypto.tink.PublicKeyVerify;
import com.google.crypto.tink.proto.RsaSsaPkcs1PublicKey;
import com.google.crypto.tink.KeyTypeManager;

class d extends KeyTypeManager<RsaSsaPkcs1PublicKey>
{
    public d() {
        super(RsaSsaPkcs1PublicKey.class, (PrimitiveFactory<?, RsaSsaPkcs1PublicKey>[])new PrimitiveFactory[] { new PrimitiveFactory<PublicKeyVerify, RsaSsaPkcs1PublicKey>(PublicKeyVerify.class) {
                @Override
                public /* bridge */ Object a(final Object o) throws GeneralSecurityException {
                    return this.c((RsaSsaPkcs1PublicKey)o);
                }
                
                public PublicKeyVerify c(final RsaSsaPkcs1PublicKey rsaSsaPkcs1PublicKey) throws GeneralSecurityException {
                    return new RsaSsaPkcs1VerifyJce((RSAPublicKey)EngineFactory.l.a("RSA").generatePublic(new RSAPublicKeySpec(new BigInteger(1, rsaSsaPkcs1PublicKey.Q().toByteArray()), new BigInteger(1, rsaSsaPkcs1PublicKey.P().toByteArray()))), f.c(rsaSsaPkcs1PublicKey.R().M()));
                }
            } });
    }
    
    @Override
    public String c() {
        return "type.googleapis.com/google.crypto.tink.RsaSsaPkcs1PublicKey";
    }
    
    @Override
    public KeyData.KeyMaterialType f() {
        return KeyData.KeyMaterialType.ASYMMETRIC_PUBLIC;
    }
    
    @Override
    public /* bridge */ MessageLite g(final ByteString byteString) throws InvalidProtocolBufferException {
        return this.k(byteString);
    }
    
    @Override
    public /* bridge */ void i(final MessageLite messageLite) throws GeneralSecurityException {
        this.l((RsaSsaPkcs1PublicKey)messageLite);
    }
    
    public int j() {
        return 0;
    }
    
    public RsaSsaPkcs1PublicKey k(final ByteString byteString) throws InvalidProtocolBufferException {
        return RsaSsaPkcs1PublicKey.U(byteString, ExtensionRegistryLite.b());
    }
    
    public void l(final RsaSsaPkcs1PublicKey rsaSsaPkcs1PublicKey) throws GeneralSecurityException {
        Validators.f(rsaSsaPkcs1PublicKey.S(), this.j());
        Validators.c(new BigInteger(1, rsaSsaPkcs1PublicKey.Q().toByteArray()).bitLength());
        Validators.d(new BigInteger(1, rsaSsaPkcs1PublicKey.P().toByteArray()));
        f.e(rsaSsaPkcs1PublicKey.R());
    }
}
