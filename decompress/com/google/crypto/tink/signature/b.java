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
import com.google.crypto.tink.subtle.Ed25519Verify;
import java.security.GeneralSecurityException;
import com.google.crypto.tink.PublicKeyVerify;
import com.google.crypto.tink.proto.Ed25519PublicKey;
import com.google.crypto.tink.KeyTypeManager;

class b extends KeyTypeManager<Ed25519PublicKey>
{
    public b() {
        super(Ed25519PublicKey.class, (PrimitiveFactory<?, Ed25519PublicKey>[])new PrimitiveFactory[] { new PrimitiveFactory<PublicKeyVerify, Ed25519PublicKey>(PublicKeyVerify.class) {
                @Override
                public /* bridge */ Object a(final Object o) throws GeneralSecurityException {
                    return this.c((Ed25519PublicKey)o);
                }
                
                public PublicKeyVerify c(final Ed25519PublicKey ed25519PublicKey) {
                    return new Ed25519Verify(ed25519PublicKey.N().toByteArray());
                }
            } });
    }
    
    @Override
    public String c() {
        return "type.googleapis.com/google.crypto.tink.Ed25519PublicKey";
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
        this.l((Ed25519PublicKey)messageLite);
    }
    
    public int j() {
        return 0;
    }
    
    public Ed25519PublicKey k(final ByteString byteString) throws InvalidProtocolBufferException {
        return Ed25519PublicKey.Q(byteString, ExtensionRegistryLite.b());
    }
    
    public void l(final Ed25519PublicKey ed25519PublicKey) throws GeneralSecurityException {
        Validators.f(ed25519PublicKey.O(), this.j());
        if (ed25519PublicKey.N().size() == 32) {
            return;
        }
        throw new GeneralSecurityException("invalid Ed25519 public key: incorrect key length");
    }
}
