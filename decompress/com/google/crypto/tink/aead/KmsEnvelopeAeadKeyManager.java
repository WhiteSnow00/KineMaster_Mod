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
import com.google.crypto.tink.proto.KmsEnvelopeAeadKeyFormat;
import com.google.crypto.tink.shaded.protobuf.MessageLite;
import com.google.crypto.tink.Registry;
import com.google.crypto.tink.KmsClients;
import java.security.GeneralSecurityException;
import com.google.crypto.tink.Aead;
import com.google.crypto.tink.proto.KmsEnvelopeAeadKey;
import com.google.crypto.tink.KeyTypeManager;

public class KmsEnvelopeAeadKeyManager extends KeyTypeManager<KmsEnvelopeAeadKey>
{
    KmsEnvelopeAeadKeyManager() {
        super(KmsEnvelopeAeadKey.class, (PrimitiveFactory<?, KmsEnvelopeAeadKey>[])new PrimitiveFactory[] { new PrimitiveFactory<Aead, KmsEnvelopeAeadKey>(Aead.class) {
                @Override
                public /* bridge */ Object a(final Object o) throws GeneralSecurityException {
                    return this.c((KmsEnvelopeAeadKey)o);
                }
                
                public Aead c(final KmsEnvelopeAeadKey kmsEnvelopeAeadKey) throws GeneralSecurityException {
                    final String m = kmsEnvelopeAeadKey.M().M();
                    return new KmsEnvelopeAead(kmsEnvelopeAeadKey.M().L(), KmsClients.a(m).b(m));
                }
            } });
    }
    
    public static void l(final boolean b) throws GeneralSecurityException {
        Registry.s((KeyTypeManager<MessageLite>)new KmsEnvelopeAeadKeyManager(), b);
    }
    
    @Override
    public String c() {
        return "type.googleapis.com/google.crypto.tink.KmsEnvelopeAeadKey";
    }
    
    @Override
    public KeyFactory<KmsEnvelopeAeadKeyFormat, KmsEnvelopeAeadKey> e() {
        return new KeyFactory<KmsEnvelopeAeadKeyFormat, KmsEnvelopeAeadKey>(this, KmsEnvelopeAeadKeyFormat.class) {
            final KmsEnvelopeAeadKeyManager b;
            
            @Override
            public /* bridge */ Object a(final MessageLite messageLite) throws GeneralSecurityException {
                return this.e((KmsEnvelopeAeadKeyFormat)messageLite);
            }
            
            @Override
            public /* bridge */ MessageLite c(final ByteString byteString) throws InvalidProtocolBufferException {
                return this.f(byteString);
            }
            
            @Override
            public /* bridge */ void d(final MessageLite messageLite) throws GeneralSecurityException {
                this.g((KmsEnvelopeAeadKeyFormat)messageLite);
            }
            
            public KmsEnvelopeAeadKey e(final KmsEnvelopeAeadKeyFormat kmsEnvelopeAeadKeyFormat) throws GeneralSecurityException {
                return ((GeneratedMessageLite.Builder<KmsEnvelopeAeadKey, BuilderType>)KmsEnvelopeAeadKey.O().D(kmsEnvelopeAeadKeyFormat).E(this.b.j())).p();
            }
            
            public KmsEnvelopeAeadKeyFormat f(final ByteString byteString) throws InvalidProtocolBufferException {
                return KmsEnvelopeAeadKeyFormat.N(byteString, ExtensionRegistryLite.b());
            }
            
            public void g(final KmsEnvelopeAeadKeyFormat kmsEnvelopeAeadKeyFormat) throws GeneralSecurityException {
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
        this.m((KmsEnvelopeAeadKey)messageLite);
    }
    
    public int j() {
        return 0;
    }
    
    public KmsEnvelopeAeadKey k(final ByteString byteString) throws InvalidProtocolBufferException {
        return KmsEnvelopeAeadKey.P(byteString, ExtensionRegistryLite.b());
    }
    
    public void m(final KmsEnvelopeAeadKey kmsEnvelopeAeadKey) throws GeneralSecurityException {
        Validators.f(kmsEnvelopeAeadKey.N(), this.j());
    }
}
