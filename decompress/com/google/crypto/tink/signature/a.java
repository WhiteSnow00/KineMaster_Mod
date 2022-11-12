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
import com.google.crypto.tink.subtle.EcdsaVerifyJce;
import com.google.crypto.tink.subtle.EllipticCurves;
import java.security.GeneralSecurityException;
import com.google.crypto.tink.PublicKeyVerify;
import com.google.crypto.tink.proto.EcdsaPublicKey;
import com.google.crypto.tink.KeyTypeManager;

class a extends KeyTypeManager<EcdsaPublicKey>
{
    public a() {
        super(EcdsaPublicKey.class, (PrimitiveFactory<?, EcdsaPublicKey>[])new PrimitiveFactory[] { new PrimitiveFactory<PublicKeyVerify, EcdsaPublicKey>(PublicKeyVerify.class) {
                @Override
                public /* bridge */ Object a(final Object o) throws GeneralSecurityException {
                    return this.c((EcdsaPublicKey)o);
                }
                
                public PublicKeyVerify c(final EcdsaPublicKey ecdsaPublicKey) throws GeneralSecurityException {
                    return new EcdsaVerifyJce(EllipticCurves.h(f.a(ecdsaPublicKey.P().N()), ecdsaPublicKey.R().toByteArray(), ecdsaPublicKey.S().toByteArray()), f.c(ecdsaPublicKey.P().Q()), f.b(ecdsaPublicKey.P().P()));
                }
            } });
    }
    
    @Override
    public String c() {
        return "type.googleapis.com/google.crypto.tink.EcdsaPublicKey";
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
        this.l((EcdsaPublicKey)messageLite);
    }
    
    public int j() {
        return 0;
    }
    
    public EcdsaPublicKey k(final ByteString byteString) throws InvalidProtocolBufferException {
        return EcdsaPublicKey.U(byteString, ExtensionRegistryLite.b());
    }
    
    public void l(final EcdsaPublicKey ecdsaPublicKey) throws GeneralSecurityException {
        Validators.f(ecdsaPublicKey.Q(), this.j());
        f.d(ecdsaPublicKey.P());
    }
}
