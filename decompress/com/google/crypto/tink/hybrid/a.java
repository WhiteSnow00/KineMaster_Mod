// 
// Decompiled by Procyon v0.6.0
// 

package com.google.crypto.tink.hybrid;

import com.google.crypto.tink.subtle.Validators;
import com.google.crypto.tink.shaded.protobuf.ExtensionRegistryLite;
import com.google.crypto.tink.shaded.protobuf.InvalidProtocolBufferException;
import com.google.crypto.tink.shaded.protobuf.MessageLite;
import com.google.crypto.tink.shaded.protobuf.ByteString;
import com.google.crypto.tink.proto.KeyData;
import com.google.crypto.tink.proto.EciesHkdfKemParams;
import com.google.crypto.tink.proto.EciesAeadHkdfParams;
import com.google.crypto.tink.subtle.EciesAeadHkdfDemHelper;
import com.google.crypto.tink.subtle.EciesAeadHkdfHybridEncrypt;
import com.google.crypto.tink.subtle.EllipticCurves;
import java.security.GeneralSecurityException;
import com.google.crypto.tink.HybridEncrypt;
import com.google.crypto.tink.proto.EciesAeadHkdfPublicKey;
import com.google.crypto.tink.KeyTypeManager;

class a extends KeyTypeManager<EciesAeadHkdfPublicKey>
{
    public a() {
        super(EciesAeadHkdfPublicKey.class, (PrimitiveFactory<?, EciesAeadHkdfPublicKey>[])new PrimitiveFactory[] { new PrimitiveFactory<HybridEncrypt, EciesAeadHkdfPublicKey>(HybridEncrypt.class) {
                @Override
                public /* bridge */ Object a(final Object o) throws GeneralSecurityException {
                    return this.c((EciesAeadHkdfPublicKey)o);
                }
                
                public HybridEncrypt c(final EciesAeadHkdfPublicKey eciesAeadHkdfPublicKey) throws GeneralSecurityException {
                    final EciesAeadHkdfParams p = eciesAeadHkdfPublicKey.P();
                    final EciesHkdfKemParams q = p.Q();
                    return new EciesAeadHkdfHybridEncrypt(EllipticCurves.h(com.google.crypto.tink.hybrid.c.a(q.N()), eciesAeadHkdfPublicKey.R().toByteArray(), eciesAeadHkdfPublicKey.S().toByteArray()), q.Q().toByteArray(), com.google.crypto.tink.hybrid.c.b(q.P()), com.google.crypto.tink.hybrid.c.c(p.P()), new d(p.O().L()));
                }
            } });
    }
    
    @Override
    public String c() {
        return "type.googleapis.com/google.crypto.tink.EciesAeadHkdfPublicKey";
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
        this.l((EciesAeadHkdfPublicKey)messageLite);
    }
    
    public int j() {
        return 0;
    }
    
    public EciesAeadHkdfPublicKey k(final ByteString byteString) throws InvalidProtocolBufferException {
        return EciesAeadHkdfPublicKey.U(byteString, ExtensionRegistryLite.b());
    }
    
    public void l(final EciesAeadHkdfPublicKey eciesAeadHkdfPublicKey) throws GeneralSecurityException {
        Validators.f(eciesAeadHkdfPublicKey.Q(), this.j());
        com.google.crypto.tink.hybrid.c.d(eciesAeadHkdfPublicKey.P());
    }
}
