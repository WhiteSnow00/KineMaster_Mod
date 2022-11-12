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
import com.google.crypto.tink.proto.RsaSsaPssParams;
import com.google.crypto.tink.subtle.RsaSsaPssVerifyJce;
import java.security.spec.KeySpec;
import java.security.spec.RSAPublicKeySpec;
import java.math.BigInteger;
import com.google.crypto.tink.subtle.EngineFactory;
import java.security.KeyFactory;
import java.security.interfaces.RSAPublicKey;
import java.security.GeneralSecurityException;
import com.google.crypto.tink.PublicKeyVerify;
import com.google.crypto.tink.proto.RsaSsaPssPublicKey;
import com.google.crypto.tink.KeyTypeManager;

class e extends KeyTypeManager<RsaSsaPssPublicKey>
{
    public e() {
        super(RsaSsaPssPublicKey.class, (PrimitiveFactory<?, RsaSsaPssPublicKey>[])new PrimitiveFactory[] { new PrimitiveFactory<PublicKeyVerify, RsaSsaPssPublicKey>(PublicKeyVerify.class) {
                @Override
                public /* bridge */ Object a(final Object o) throws GeneralSecurityException {
                    return this.c((RsaSsaPssPublicKey)o);
                }
                
                public PublicKeyVerify c(final RsaSsaPssPublicKey rsaSsaPssPublicKey) throws GeneralSecurityException {
                    final RSAPublicKey rsaPublicKey = (RSAPublicKey)EngineFactory.l.a("RSA").generatePublic(new RSAPublicKeySpec(new BigInteger(1, rsaSsaPssPublicKey.Q().toByteArray()), new BigInteger(1, rsaSsaPssPublicKey.P().toByteArray())));
                    final RsaSsaPssParams r = rsaSsaPssPublicKey.R();
                    return new RsaSsaPssVerifyJce(rsaPublicKey, f.c(r.Q()), f.c(r.O()), r.P());
                }
            } });
    }
    
    @Override
    public String c() {
        return "type.googleapis.com/google.crypto.tink.RsaSsaPssPublicKey";
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
        this.l((RsaSsaPssPublicKey)messageLite);
    }
    
    public int j() {
        return 0;
    }
    
    public RsaSsaPssPublicKey k(final ByteString byteString) throws InvalidProtocolBufferException {
        return RsaSsaPssPublicKey.U(byteString, ExtensionRegistryLite.b());
    }
    
    public void l(final RsaSsaPssPublicKey rsaSsaPssPublicKey) throws GeneralSecurityException {
        Validators.f(rsaSsaPssPublicKey.S(), this.j());
        Validators.c(new BigInteger(1, rsaSsaPssPublicKey.Q().toByteArray()).bitLength());
        Validators.d(new BigInteger(1, rsaSsaPssPublicKey.P().toByteArray()));
        f.f(rsaSsaPssPublicKey.R());
    }
}
