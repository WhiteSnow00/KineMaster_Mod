// 
// Decompiled by Procyon v0.6.0
// 

package com.google.crypto.tink.signature;

import com.google.crypto.tink.subtle.Validators;
import com.google.crypto.tink.proto.KeyData;
import com.google.crypto.tink.shaded.protobuf.ExtensionRegistryLite;
import java.security.spec.ECPoint;
import java.security.KeyPair;
import com.google.crypto.tink.proto.EcdsaParams;
import java.security.interfaces.ECPrivateKey;
import java.security.interfaces.ECPublicKey;
import com.google.crypto.tink.shaded.protobuf.InvalidProtocolBufferException;
import com.google.crypto.tink.shaded.protobuf.ByteString;
import com.google.crypto.tink.proto.EcdsaKeyFormat;
import com.google.crypto.tink.shaded.protobuf.MessageLite;
import com.google.crypto.tink.Registry;
import com.google.crypto.tink.subtle.EcdsaSignJce;
import com.google.crypto.tink.subtle.EllipticCurves;
import java.security.GeneralSecurityException;
import com.google.crypto.tink.PublicKeySign;
import com.google.crypto.tink.KeyTypeManager;
import com.google.crypto.tink.proto.EcdsaPublicKey;
import com.google.crypto.tink.proto.EcdsaPrivateKey;
import com.google.crypto.tink.PrivateKeyTypeManager;

public final class EcdsaSignKeyManager extends PrivateKeyTypeManager<EcdsaPrivateKey, EcdsaPublicKey>
{
    EcdsaSignKeyManager() {
        super(EcdsaPrivateKey.class, EcdsaPublicKey.class, (PrimitiveFactory<?, EcdsaPrivateKey>[])new PrimitiveFactory[] { new PrimitiveFactory<PublicKeySign, EcdsaPrivateKey>(PublicKeySign.class) {
                @Override
                public /* bridge */ Object a(final Object o) throws GeneralSecurityException {
                    return this.c((EcdsaPrivateKey)o);
                }
                
                public PublicKeySign c(final EcdsaPrivateKey ecdsaPrivateKey) throws GeneralSecurityException {
                    return new EcdsaSignJce(EllipticCurves.g(f.a(ecdsaPrivateKey.O().P().N()), ecdsaPrivateKey.N().toByteArray()), f.c(ecdsaPrivateKey.O().P().Q()), f.b(ecdsaPrivateKey.O().P().P()));
                }
            } });
    }
    
    public static void l(final boolean b) throws GeneralSecurityException {
        Registry.r((PrivateKeyTypeManager<MessageLite, MessageLite>)new EcdsaSignKeyManager(), (KeyTypeManager<MessageLite>)new a(), b);
    }
    
    @Override
    public String c() {
        return "type.googleapis.com/google.crypto.tink.EcdsaPrivateKey";
    }
    
    @Override
    public KeyFactory<EcdsaKeyFormat, EcdsaPrivateKey> e() {
        return new KeyFactory<EcdsaKeyFormat, EcdsaPrivateKey>(this, EcdsaKeyFormat.class) {
            final EcdsaSignKeyManager b;
            
            @Override
            public /* bridge */ Object a(final MessageLite messageLite) throws GeneralSecurityException {
                return this.e((EcdsaKeyFormat)messageLite);
            }
            
            @Override
            public /* bridge */ MessageLite c(final ByteString byteString) throws InvalidProtocolBufferException {
                return this.f(byteString);
            }
            
            @Override
            public /* bridge */ void d(final MessageLite messageLite) throws GeneralSecurityException {
                this.g((EcdsaKeyFormat)messageLite);
            }
            
            public EcdsaPrivateKey e(final EcdsaKeyFormat ecdsaKeyFormat) throws GeneralSecurityException {
                final EcdsaParams l = ecdsaKeyFormat.L();
                final KeyPair d = EllipticCurves.d(f.a(l.N()));
                final ECPublicKey ecPublicKey = (ECPublicKey)d.getPublic();
                final ECPrivateKey ecPrivateKey = (ECPrivateKey)d.getPrivate();
                final ECPoint w = ecPublicKey.getW();
                return EcdsaPrivateKey.Q().F(this.b.j()).E(EcdsaPublicKey.T().E(this.b.j()).D(l).F(ByteString.copyFrom(w.getAffineX().toByteArray())).G(ByteString.copyFrom(w.getAffineY().toByteArray())).p()).D(ByteString.copyFrom(ecPrivateKey.getS().toByteArray())).p();
            }
            
            public EcdsaKeyFormat f(final ByteString byteString) throws InvalidProtocolBufferException {
                return EcdsaKeyFormat.N(byteString, ExtensionRegistryLite.b());
            }
            
            public void g(final EcdsaKeyFormat ecdsaKeyFormat) throws GeneralSecurityException {
                f.d(ecdsaKeyFormat.L());
            }
        };
    }
    
    @Override
    public KeyData.KeyMaterialType f() {
        return KeyData.KeyMaterialType.ASYMMETRIC_PRIVATE;
    }
    
    @Override
    public /* bridge */ MessageLite g(final ByteString byteString) throws InvalidProtocolBufferException {
        return this.k(byteString);
    }
    
    @Override
    public /* bridge */ void i(final MessageLite messageLite) throws GeneralSecurityException {
        this.m((EcdsaPrivateKey)messageLite);
    }
    
    public int j() {
        return 0;
    }
    
    public EcdsaPrivateKey k(final ByteString byteString) throws InvalidProtocolBufferException {
        return EcdsaPrivateKey.R(byteString, ExtensionRegistryLite.b());
    }
    
    public void m(final EcdsaPrivateKey ecdsaPrivateKey) throws GeneralSecurityException {
        Validators.f(ecdsaPrivateKey.P(), this.j());
        f.d(ecdsaPrivateKey.O().P());
    }
}
