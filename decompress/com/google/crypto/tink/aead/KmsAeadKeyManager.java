// 
// Decompiled by Procyon v0.6.0
// 

package com.google.crypto.tink.aead;

import com.google.crypto.tink.shaded.protobuf.GeneratedMessageLite;
import com.google.crypto.tink.subtle.Validators;
import com.google.crypto.tink.proto.KeyData;
import com.google.crypto.tink.shaded.protobuf.ExtensionRegistryLite;
import com.google.crypto.tink.shaded.protobuf.InvalidProtocolBufferException;
import com.google.crypto.tink.shaded.protobuf.ByteString;
import com.google.crypto.tink.proto.KmsAeadKeyFormat;
import com.google.crypto.tink.shaded.protobuf.MessageLite;
import com.google.crypto.tink.Registry;
import com.google.crypto.tink.KmsClients;
import java.security.GeneralSecurityException;
import com.google.crypto.tink.Aead;
import com.google.crypto.tink.proto.KmsAeadKey;
import com.google.crypto.tink.KeyTypeManager;

public class KmsAeadKeyManager extends KeyTypeManager<KmsAeadKey>
{
    KmsAeadKeyManager() {
        super(KmsAeadKey.class, (PrimitiveFactory<?, KmsAeadKey>[])new PrimitiveFactory[] { new PrimitiveFactory<Aead, KmsAeadKey>(Aead.class) {
                @Override
                public /* bridge */ Object a(final Object o) throws GeneralSecurityException {
                    return this.c((KmsAeadKey)o);
                }
                
                public Aead c(final KmsAeadKey kmsAeadKey) throws GeneralSecurityException {
                    final String l = kmsAeadKey.M().L();
                    return KmsClients.a(l).b(l);
                }
            } });
    }
    
    public static void l(final boolean b) throws GeneralSecurityException {
        Registry.s((KeyTypeManager<MessageLite>)new KmsAeadKeyManager(), b);
    }
    
    @Override
    public String c() {
        return "type.googleapis.com/google.crypto.tink.KmsAeadKey";
    }
    
    @Override
    public KeyFactory<KmsAeadKeyFormat, KmsAeadKey> e() {
        return new KeyFactory<KmsAeadKeyFormat, KmsAeadKey>(this, KmsAeadKeyFormat.class) {
            final KmsAeadKeyManager b;
            
            @Override
            public /* bridge */ Object a(final MessageLite messageLite) throws GeneralSecurityException {
                return this.e((KmsAeadKeyFormat)messageLite);
            }
            
            @Override
            public /* bridge */ MessageLite c(final ByteString byteString) throws InvalidProtocolBufferException {
                return this.f(byteString);
            }
            
            @Override
            public /* bridge */ void d(final MessageLite messageLite) throws GeneralSecurityException {
                this.g((KmsAeadKeyFormat)messageLite);
            }
            
            public KmsAeadKey e(final KmsAeadKeyFormat kmsAeadKeyFormat) throws GeneralSecurityException {
                return ((GeneratedMessageLite.Builder<KmsAeadKey, BuilderType>)KmsAeadKey.O().D(kmsAeadKeyFormat).E(this.b.j())).p();
            }
            
            public KmsAeadKeyFormat f(final ByteString byteString) throws InvalidProtocolBufferException {
                return KmsAeadKeyFormat.M(byteString, ExtensionRegistryLite.b());
            }
            
            public void g(final KmsAeadKeyFormat kmsAeadKeyFormat) throws GeneralSecurityException {
            }
        };
    }
    
    @Override
    public KeyData.KeyMaterialType f() {
        return KeyData.KeyMaterialType.REMOTE;
    }
    
    @Override
    public /* bridge */ MessageLite g(final ByteString byteString) throws InvalidProtocolBufferException {
        return this.k(byteString);
    }
    
    @Override
    public /* bridge */ void i(final MessageLite messageLite) throws GeneralSecurityException {
        this.m((KmsAeadKey)messageLite);
    }
    
    public int j() {
        return 0;
    }
    
    public KmsAeadKey k(final ByteString byteString) throws InvalidProtocolBufferException {
        return KmsAeadKey.P(byteString, ExtensionRegistryLite.b());
    }
    
    public void m(final KmsAeadKey kmsAeadKey) throws GeneralSecurityException {
        Validators.f(kmsAeadKey.N(), this.j());
    }
}
