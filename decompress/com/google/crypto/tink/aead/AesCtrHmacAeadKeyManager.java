// 
// Decompiled by Procyon v0.6.0
// 

package com.google.crypto.tink.aead;

import com.google.crypto.tink.shaded.protobuf.GeneratedMessageLite;
import com.google.crypto.tink.proto.KeyData;
import com.google.crypto.tink.subtle.Validators;
import com.google.crypto.tink.shaded.protobuf.ExtensionRegistryLite;
import com.google.crypto.tink.proto.HmacKey;
import com.google.crypto.tink.proto.AesCtrKey;
import com.google.crypto.tink.shaded.protobuf.InvalidProtocolBufferException;
import com.google.crypto.tink.shaded.protobuf.ByteString;
import com.google.crypto.tink.proto.AesCtrHmacAeadKeyFormat;
import com.google.crypto.tink.shaded.protobuf.MessageLite;
import com.google.crypto.tink.Registry;
import com.google.crypto.tink.subtle.EncryptThenAuthenticate;
import com.google.crypto.tink.mac.HmacKeyManager;
import com.google.crypto.tink.Mac;
import com.google.crypto.tink.subtle.IndCpaCipher;
import java.security.GeneralSecurityException;
import com.google.crypto.tink.Aead;
import com.google.crypto.tink.proto.AesCtrHmacAeadKey;
import com.google.crypto.tink.KeyTypeManager;

public final class AesCtrHmacAeadKeyManager extends KeyTypeManager<AesCtrHmacAeadKey>
{
    AesCtrHmacAeadKeyManager() {
        super(AesCtrHmacAeadKey.class, (PrimitiveFactory<?, AesCtrHmacAeadKey>[])new PrimitiveFactory[] { new PrimitiveFactory<Aead, AesCtrHmacAeadKey>(Aead.class) {
                @Override
                public /* bridge */ Object a(final Object o) throws GeneralSecurityException {
                    return this.c((AesCtrHmacAeadKey)o);
                }
                
                public Aead c(final AesCtrHmacAeadKey aesCtrHmacAeadKey) throws GeneralSecurityException {
                    return new EncryptThenAuthenticate(new AesCtrKeyManager().d(aesCtrHmacAeadKey.N(), IndCpaCipher.class), new HmacKeyManager().d(aesCtrHmacAeadKey.O(), Mac.class), aesCtrHmacAeadKey.O().P().O());
                }
            } });
    }
    
    public static void l(final boolean b) throws GeneralSecurityException {
        Registry.s((KeyTypeManager<MessageLite>)new AesCtrHmacAeadKeyManager(), b);
    }
    
    @Override
    public String c() {
        return "type.googleapis.com/google.crypto.tink.AesCtrHmacAeadKey";
    }
    
    @Override
    public KeyFactory<AesCtrHmacAeadKeyFormat, AesCtrHmacAeadKey> e() {
        return new KeyFactory<AesCtrHmacAeadKeyFormat, AesCtrHmacAeadKey>(this, AesCtrHmacAeadKeyFormat.class) {
            final AesCtrHmacAeadKeyManager b;
            
            @Override
            public /* bridge */ Object a(final MessageLite messageLite) throws GeneralSecurityException {
                return this.e((AesCtrHmacAeadKeyFormat)messageLite);
            }
            
            @Override
            public /* bridge */ MessageLite c(final ByteString byteString) throws InvalidProtocolBufferException {
                return this.f(byteString);
            }
            
            @Override
            public /* bridge */ void d(final MessageLite messageLite) throws GeneralSecurityException {
                this.g((AesCtrHmacAeadKeyFormat)messageLite);
            }
            
            public AesCtrHmacAeadKey e(final AesCtrHmacAeadKeyFormat aesCtrHmacAeadKeyFormat) throws GeneralSecurityException {
                return ((GeneratedMessageLite.Builder<AesCtrHmacAeadKey, BuilderType>)AesCtrHmacAeadKey.Q().D(new AesCtrKeyManager().e().a(aesCtrHmacAeadKeyFormat.M())).E(new HmacKeyManager().e().a(aesCtrHmacAeadKeyFormat.N())).F(this.b.j())).p();
            }
            
            public AesCtrHmacAeadKeyFormat f(final ByteString byteString) throws InvalidProtocolBufferException {
                return AesCtrHmacAeadKeyFormat.P(byteString, ExtensionRegistryLite.b());
            }
            
            public void g(final AesCtrHmacAeadKeyFormat aesCtrHmacAeadKeyFormat) throws GeneralSecurityException {
                new AesCtrKeyManager().e().d(aesCtrHmacAeadKeyFormat.M());
                new HmacKeyManager().e().d(aesCtrHmacAeadKeyFormat.N());
                Validators.a(aesCtrHmacAeadKeyFormat.M().N());
            }
        };
    }
    
    @Override
    public KeyData.KeyMaterialType f() {
        return KeyData.KeyMaterialType.SYMMETRIC;
    }
    
    @Override
    public /* bridge */ MessageLite g(final ByteString byteString) throws InvalidProtocolBufferException {
        return this.k(byteString);
    }
    
    @Override
    public /* bridge */ void i(final MessageLite messageLite) throws GeneralSecurityException {
        this.m((AesCtrHmacAeadKey)messageLite);
    }
    
    public int j() {
        return 0;
    }
    
    public AesCtrHmacAeadKey k(final ByteString byteString) throws InvalidProtocolBufferException {
        return AesCtrHmacAeadKey.R(byteString, ExtensionRegistryLite.b());
    }
    
    public void m(final AesCtrHmacAeadKey aesCtrHmacAeadKey) throws GeneralSecurityException {
        Validators.f(aesCtrHmacAeadKey.P(), this.j());
        new AesCtrKeyManager().m(aesCtrHmacAeadKey.N());
        new HmacKeyManager().n(aesCtrHmacAeadKey.O());
    }
}
