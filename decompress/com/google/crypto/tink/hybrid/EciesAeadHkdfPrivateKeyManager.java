// 
// Decompiled by Procyon v0.6.0
// 

package com.google.crypto.tink.hybrid;

import com.google.crypto.tink.subtle.Validators;
import com.google.crypto.tink.proto.KeyData;
import com.google.crypto.tink.shaded.protobuf.ExtensionRegistryLite;
import java.security.spec.ECPoint;
import java.security.KeyPair;
import java.security.interfaces.ECPrivateKey;
import java.security.interfaces.ECPublicKey;
import com.google.crypto.tink.shaded.protobuf.InvalidProtocolBufferException;
import com.google.crypto.tink.shaded.protobuf.ByteString;
import com.google.crypto.tink.proto.EciesAeadHkdfKeyFormat;
import com.google.crypto.tink.shaded.protobuf.MessageLite;
import com.google.crypto.tink.Registry;
import com.google.crypto.tink.proto.EciesHkdfKemParams;
import com.google.crypto.tink.proto.EciesAeadHkdfParams;
import com.google.crypto.tink.subtle.EciesAeadHkdfDemHelper;
import com.google.crypto.tink.subtle.EciesAeadHkdfHybridDecrypt;
import com.google.crypto.tink.subtle.EllipticCurves;
import java.security.GeneralSecurityException;
import com.google.crypto.tink.HybridDecrypt;
import com.google.crypto.tink.KeyTypeManager;
import com.google.crypto.tink.proto.EciesAeadHkdfPublicKey;
import com.google.crypto.tink.proto.EciesAeadHkdfPrivateKey;
import com.google.crypto.tink.PrivateKeyTypeManager;

public final class EciesAeadHkdfPrivateKeyManager extends PrivateKeyTypeManager<EciesAeadHkdfPrivateKey, EciesAeadHkdfPublicKey>
{
    private static final byte[] e;
    
    static {
        e = new byte[0];
    }
    
    EciesAeadHkdfPrivateKeyManager() {
        super(EciesAeadHkdfPrivateKey.class, EciesAeadHkdfPublicKey.class, (PrimitiveFactory<?, EciesAeadHkdfPrivateKey>[])new PrimitiveFactory[] { new PrimitiveFactory<HybridDecrypt, EciesAeadHkdfPrivateKey>(HybridDecrypt.class) {
                @Override
                public /* bridge */ Object a(final Object o) throws GeneralSecurityException {
                    return this.c((EciesAeadHkdfPrivateKey)o);
                }
                
                public HybridDecrypt c(final EciesAeadHkdfPrivateKey eciesAeadHkdfPrivateKey) throws GeneralSecurityException {
                    final EciesAeadHkdfParams p = eciesAeadHkdfPrivateKey.O().P();
                    final EciesHkdfKemParams q = p.Q();
                    return new EciesAeadHkdfHybridDecrypt(EllipticCurves.g(com.google.crypto.tink.hybrid.c.a(q.N()), eciesAeadHkdfPrivateKey.N().toByteArray()), q.Q().toByteArray(), com.google.crypto.tink.hybrid.c.b(q.P()), com.google.crypto.tink.hybrid.c.c(p.P()), new d(p.O().L()));
                }
            } });
    }
    
    public static void l(final boolean b) throws GeneralSecurityException {
        Registry.r((PrivateKeyTypeManager<MessageLite, MessageLite>)new EciesAeadHkdfPrivateKeyManager(), (KeyTypeManager<MessageLite>)new a(), b);
    }
    
    @Override
    public String c() {
        return "type.googleapis.com/google.crypto.tink.EciesAeadHkdfPrivateKey";
    }
    
    @Override
    public KeyFactory<EciesAeadHkdfKeyFormat, EciesAeadHkdfPrivateKey> e() {
        return new KeyFactory<EciesAeadHkdfKeyFormat, EciesAeadHkdfPrivateKey>(this, EciesAeadHkdfKeyFormat.class) {
            final EciesAeadHkdfPrivateKeyManager b;
            
            @Override
            public /* bridge */ Object a(final MessageLite messageLite) throws GeneralSecurityException {
                return this.e((EciesAeadHkdfKeyFormat)messageLite);
            }
            
            @Override
            public /* bridge */ MessageLite c(final ByteString byteString) throws InvalidProtocolBufferException {
                return this.f(byteString);
            }
            
            @Override
            public /* bridge */ void d(final MessageLite messageLite) throws GeneralSecurityException {
                this.g((EciesAeadHkdfKeyFormat)messageLite);
            }
            
            public EciesAeadHkdfPrivateKey e(final EciesAeadHkdfKeyFormat eciesAeadHkdfKeyFormat) throws GeneralSecurityException {
                final KeyPair d = EllipticCurves.d(com.google.crypto.tink.hybrid.c.a(eciesAeadHkdfKeyFormat.L().Q().N()));
                final ECPublicKey ecPublicKey = (ECPublicKey)d.getPublic();
                final ECPrivateKey ecPrivateKey = (ECPrivateKey)d.getPrivate();
                final ECPoint w = ecPublicKey.getW();
                return EciesAeadHkdfPrivateKey.Q().F(this.b.j()).E(EciesAeadHkdfPublicKey.T().E(this.b.j()).D(eciesAeadHkdfKeyFormat.L()).F(ByteString.copyFrom(w.getAffineX().toByteArray())).G(ByteString.copyFrom(w.getAffineY().toByteArray())).p()).D(ByteString.copyFrom(ecPrivateKey.getS().toByteArray())).p();
            }
            
            public EciesAeadHkdfKeyFormat f(final ByteString byteString) throws InvalidProtocolBufferException {
                return EciesAeadHkdfKeyFormat.N(byteString, ExtensionRegistryLite.b());
            }
            
            public void g(final EciesAeadHkdfKeyFormat eciesAeadHkdfKeyFormat) throws GeneralSecurityException {
                com.google.crypto.tink.hybrid.c.d(eciesAeadHkdfKeyFormat.L());
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
        this.m((EciesAeadHkdfPrivateKey)messageLite);
    }
    
    public int j() {
        return 0;
    }
    
    public EciesAeadHkdfPrivateKey k(final ByteString byteString) throws InvalidProtocolBufferException {
        return EciesAeadHkdfPrivateKey.R(byteString, ExtensionRegistryLite.b());
    }
    
    public void m(final EciesAeadHkdfPrivateKey eciesAeadHkdfPrivateKey) throws GeneralSecurityException {
        if (!eciesAeadHkdfPrivateKey.N().isEmpty()) {
            Validators.f(eciesAeadHkdfPrivateKey.P(), this.j());
            com.google.crypto.tink.hybrid.c.d(eciesAeadHkdfPrivateKey.O().P());
            return;
        }
        throw new GeneralSecurityException("invalid ECIES private key");
    }
}
