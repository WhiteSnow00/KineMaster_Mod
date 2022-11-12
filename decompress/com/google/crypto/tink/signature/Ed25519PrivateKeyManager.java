// 
// Decompiled by Procyon v0.6.0
// 

package com.google.crypto.tink.signature;

import com.google.crypto.tink.subtle.Validators;
import com.google.crypto.tink.proto.KeyData;
import com.google.crypto.tink.shaded.protobuf.ExtensionRegistryLite;
import com.google.crypto.tink.shaded.protobuf.InvalidProtocolBufferException;
import com.google.crypto.tink.shaded.protobuf.ByteString;
import com.google.crypto.tink.proto.Ed25519KeyFormat;
import com.google.crypto.tink.shaded.protobuf.MessageLite;
import com.google.crypto.tink.Registry;
import com.google.crypto.tink.subtle.Ed25519Sign;
import java.security.GeneralSecurityException;
import com.google.crypto.tink.PublicKeySign;
import com.google.crypto.tink.KeyTypeManager;
import com.google.crypto.tink.proto.Ed25519PublicKey;
import com.google.crypto.tink.proto.Ed25519PrivateKey;
import com.google.crypto.tink.PrivateKeyTypeManager;

public final class Ed25519PrivateKeyManager extends PrivateKeyTypeManager<Ed25519PrivateKey, Ed25519PublicKey>
{
    Ed25519PrivateKeyManager() {
        super(Ed25519PrivateKey.class, Ed25519PublicKey.class, (PrimitiveFactory<?, Ed25519PrivateKey>[])new PrimitiveFactory[] { new PrimitiveFactory<PublicKeySign, Ed25519PrivateKey>(PublicKeySign.class) {
                @Override
                public /* bridge */ Object a(final Object o) throws GeneralSecurityException {
                    return this.c((Ed25519PrivateKey)o);
                }
                
                public PublicKeySign c(final Ed25519PrivateKey ed25519PrivateKey) throws GeneralSecurityException {
                    return new Ed25519Sign(ed25519PrivateKey.N().toByteArray());
                }
            } });
    }
    
    public static void l(final boolean b) throws GeneralSecurityException {
        Registry.r((PrivateKeyTypeManager<MessageLite, MessageLite>)new Ed25519PrivateKeyManager(), (KeyTypeManager<MessageLite>)new b(), b);
    }
    
    @Override
    public String c() {
        return "type.googleapis.com/google.crypto.tink.Ed25519PrivateKey";
    }
    
    @Override
    public KeyFactory<Ed25519KeyFormat, Ed25519PrivateKey> e() {
        return new KeyFactory<Ed25519KeyFormat, Ed25519PrivateKey>(this, Ed25519KeyFormat.class) {
            final Ed25519PrivateKeyManager b;
            
            @Override
            public /* bridge */ Object a(final MessageLite messageLite) throws GeneralSecurityException {
                return this.e((Ed25519KeyFormat)messageLite);
            }
            
            @Override
            public /* bridge */ MessageLite c(final ByteString byteString) throws InvalidProtocolBufferException {
                return this.f(byteString);
            }
            
            @Override
            public /* bridge */ void d(final MessageLite messageLite) throws GeneralSecurityException {
                this.g((Ed25519KeyFormat)messageLite);
            }
            
            public Ed25519PrivateKey e(final Ed25519KeyFormat ed25519KeyFormat) throws GeneralSecurityException {
                final Ed25519Sign.KeyPair c = Ed25519Sign.KeyPair.c();
                return Ed25519PrivateKey.Q().F(this.b.j()).D(ByteString.copyFrom(c.a())).E(Ed25519PublicKey.P().E(this.b.j()).D(ByteString.copyFrom(c.b())).p()).p();
            }
            
            public Ed25519KeyFormat f(final ByteString byteString) throws InvalidProtocolBufferException {
                return Ed25519KeyFormat.K(byteString, ExtensionRegistryLite.b());
            }
            
            public void g(final Ed25519KeyFormat ed25519KeyFormat) throws GeneralSecurityException {
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
        this.m((Ed25519PrivateKey)messageLite);
    }
    
    public int j() {
        return 0;
    }
    
    public Ed25519PrivateKey k(final ByteString byteString) throws InvalidProtocolBufferException {
        return Ed25519PrivateKey.R(byteString, ExtensionRegistryLite.b());
    }
    
    public void m(final Ed25519PrivateKey ed25519PrivateKey) throws GeneralSecurityException {
        Validators.f(ed25519PrivateKey.P(), this.j());
        new b().l(ed25519PrivateKey.O());
        if (ed25519PrivateKey.N().size() == 32) {
            return;
        }
        throw new GeneralSecurityException("invalid Ed25519 private key: incorrect key length");
    }
}
