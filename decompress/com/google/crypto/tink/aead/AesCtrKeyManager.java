// 
// Decompiled by Procyon v0.6.0
// 

package com.google.crypto.tink.aead;

import com.google.crypto.tink.shaded.protobuf.GeneratedMessageLite;
import com.google.crypto.tink.proto.KeyData;
import com.google.crypto.tink.subtle.Validators;
import com.google.crypto.tink.shaded.protobuf.ExtensionRegistryLite;
import com.google.crypto.tink.subtle.Random;
import com.google.crypto.tink.shaded.protobuf.InvalidProtocolBufferException;
import com.google.crypto.tink.shaded.protobuf.ByteString;
import com.google.crypto.tink.shaded.protobuf.MessageLite;
import com.google.crypto.tink.proto.AesCtrKeyFormat;
import com.google.crypto.tink.proto.AesCtrParams;
import com.google.crypto.tink.subtle.AesCtrJceCipher;
import java.security.GeneralSecurityException;
import com.google.crypto.tink.subtle.IndCpaCipher;
import com.google.crypto.tink.proto.AesCtrKey;
import com.google.crypto.tink.KeyTypeManager;

public class AesCtrKeyManager extends KeyTypeManager<AesCtrKey>
{
    AesCtrKeyManager() {
        super(AesCtrKey.class, (PrimitiveFactory<?, AesCtrKey>[])new PrimitiveFactory[] { new PrimitiveFactory<IndCpaCipher, AesCtrKey>(IndCpaCipher.class) {
                @Override
                public /* bridge */ Object a(final Object o) throws GeneralSecurityException {
                    return this.c((AesCtrKey)o);
                }
                
                public IndCpaCipher c(final AesCtrKey aesCtrKey) throws GeneralSecurityException {
                    return new AesCtrJceCipher(aesCtrKey.O().toByteArray(), aesCtrKey.P().M());
                }
            } });
    }
    
    static void j(final AesCtrKeyManager aesCtrKeyManager, final AesCtrParams aesCtrParams) throws GeneralSecurityException {
        aesCtrKeyManager.n(aesCtrParams);
    }
    
    private void n(final AesCtrParams aesCtrParams) throws GeneralSecurityException {
        if (aesCtrParams.M() >= 12 && aesCtrParams.M() <= 16) {
            return;
        }
        throw new GeneralSecurityException("invalid IV size");
    }
    
    @Override
    public String c() {
        return "type.googleapis.com/google.crypto.tink.AesCtrKey";
    }
    
    @Override
    public KeyFactory<AesCtrKeyFormat, AesCtrKey> e() {
        return new KeyFactory<AesCtrKeyFormat, AesCtrKey>(this, AesCtrKeyFormat.class) {
            final AesCtrKeyManager b;
            
            @Override
            public /* bridge */ Object a(final MessageLite messageLite) throws GeneralSecurityException {
                return this.e((AesCtrKeyFormat)messageLite);
            }
            
            @Override
            public /* bridge */ MessageLite c(final ByteString byteString) throws InvalidProtocolBufferException {
                return this.f(byteString);
            }
            
            @Override
            public /* bridge */ void d(final MessageLite messageLite) throws GeneralSecurityException {
                this.g((AesCtrKeyFormat)messageLite);
            }
            
            public AesCtrKey e(final AesCtrKeyFormat aesCtrKeyFormat) throws GeneralSecurityException {
                return ((GeneratedMessageLite.Builder<AesCtrKey, BuilderType>)AesCtrKey.R().E(aesCtrKeyFormat.O()).D(ByteString.copyFrom(Random.c(aesCtrKeyFormat.N()))).F(this.b.k())).p();
            }
            
            public AesCtrKeyFormat f(final ByteString byteString) throws InvalidProtocolBufferException {
                return AesCtrKeyFormat.Q(byteString, ExtensionRegistryLite.b());
            }
            
            public void g(final AesCtrKeyFormat aesCtrKeyFormat) throws GeneralSecurityException {
                Validators.a(aesCtrKeyFormat.N());
                AesCtrKeyManager.j(this.b, aesCtrKeyFormat.O());
            }
        };
    }
    
    @Override
    public KeyData.KeyMaterialType f() {
        return KeyData.KeyMaterialType.SYMMETRIC;
    }
    
    @Override
    public /* bridge */ MessageLite g(final ByteString byteString) throws InvalidProtocolBufferException {
        return this.l(byteString);
    }
    
    @Override
    public /* bridge */ void i(final MessageLite messageLite) throws GeneralSecurityException {
        this.m((AesCtrKey)messageLite);
    }
    
    public int k() {
        return 0;
    }
    
    public AesCtrKey l(final ByteString byteString) throws InvalidProtocolBufferException {
        return AesCtrKey.S(byteString, ExtensionRegistryLite.b());
    }
    
    public void m(final AesCtrKey aesCtrKey) throws GeneralSecurityException {
        Validators.f(aesCtrKey.Q(), this.k());
        Validators.a(aesCtrKey.O().size());
        this.n(aesCtrKey.P());
    }
}
