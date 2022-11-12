// 
// Decompiled by Procyon v0.6.0
// 

package com.google.crypto.tink.streamingaead;

import com.google.crypto.tink.shaded.protobuf.GeneratedMessageLite;
import com.google.crypto.tink.proto.KeyData;
import com.google.crypto.tink.shaded.protobuf.ExtensionRegistryLite;
import com.google.crypto.tink.subtle.Random;
import com.google.crypto.tink.shaded.protobuf.InvalidProtocolBufferException;
import com.google.crypto.tink.shaded.protobuf.ByteString;
import com.google.crypto.tink.proto.AesGcmHkdfStreamingKeyFormat;
import com.google.crypto.tink.proto.HashType;
import com.google.crypto.tink.subtle.Validators;
import com.google.crypto.tink.shaded.protobuf.MessageLite;
import com.google.crypto.tink.Registry;
import com.google.crypto.tink.proto.AesGcmHkdfStreamingParams;
import com.google.crypto.tink.subtle.AesGcmHkdfStreaming;
import java.security.GeneralSecurityException;
import com.google.crypto.tink.StreamingAead;
import com.google.crypto.tink.proto.AesGcmHkdfStreamingKey;
import com.google.crypto.tink.KeyTypeManager;

public final class AesGcmHkdfStreamingKeyManager extends KeyTypeManager<AesGcmHkdfStreamingKey>
{
    AesGcmHkdfStreamingKeyManager() {
        super(AesGcmHkdfStreamingKey.class, (PrimitiveFactory<?, AesGcmHkdfStreamingKey>[])new PrimitiveFactory[] { new PrimitiveFactory<StreamingAead, AesGcmHkdfStreamingKey>(StreamingAead.class) {
                @Override
                public /* bridge */ Object a(final Object o) throws GeneralSecurityException {
                    return this.c((AesGcmHkdfStreamingKey)o);
                }
                
                public StreamingAead c(final AesGcmHkdfStreamingKey aesGcmHkdfStreamingKey) throws GeneralSecurityException {
                    return new AesGcmHkdfStreaming(aesGcmHkdfStreamingKey.N().toByteArray(), com.google.crypto.tink.streamingaead.b.a(aesGcmHkdfStreamingKey.O().Q()), aesGcmHkdfStreamingKey.O().P(), aesGcmHkdfStreamingKey.O().N(), 0);
                }
            } });
    }
    
    static void j(final AesGcmHkdfStreamingParams aesGcmHkdfStreamingParams) throws GeneralSecurityException {
        o(aesGcmHkdfStreamingParams);
    }
    
    public static void m(final boolean b) throws GeneralSecurityException {
        Registry.s((KeyTypeManager<MessageLite>)new AesGcmHkdfStreamingKeyManager(), b);
    }
    
    private static void o(final AesGcmHkdfStreamingParams aesGcmHkdfStreamingParams) throws GeneralSecurityException {
        Validators.a(aesGcmHkdfStreamingParams.P());
        if (aesGcmHkdfStreamingParams.Q() == HashType.UNKNOWN_HASH) {
            throw new GeneralSecurityException("unknown HKDF hash type");
        }
        if (aesGcmHkdfStreamingParams.N() >= aesGcmHkdfStreamingParams.P() + 7 + 16 + 2) {
            return;
        }
        throw new GeneralSecurityException("ciphertext_segment_size must be at least (derived_key_size + NONCE_PREFIX_IN_BYTES + TAG_SIZE_IN_BYTES + 2)");
    }
    
    @Override
    public String c() {
        return "type.googleapis.com/google.crypto.tink.AesGcmHkdfStreamingKey";
    }
    
    @Override
    public KeyFactory<AesGcmHkdfStreamingKeyFormat, AesGcmHkdfStreamingKey> e() {
        return new KeyFactory<AesGcmHkdfStreamingKeyFormat, AesGcmHkdfStreamingKey>(this, AesGcmHkdfStreamingKeyFormat.class) {
            final AesGcmHkdfStreamingKeyManager b;
            
            @Override
            public /* bridge */ Object a(final MessageLite messageLite) throws GeneralSecurityException {
                return this.e((AesGcmHkdfStreamingKeyFormat)messageLite);
            }
            
            @Override
            public /* bridge */ MessageLite c(final ByteString byteString) throws InvalidProtocolBufferException {
                return this.f(byteString);
            }
            
            @Override
            public /* bridge */ void d(final MessageLite messageLite) throws GeneralSecurityException {
                this.g((AesGcmHkdfStreamingKeyFormat)messageLite);
            }
            
            public AesGcmHkdfStreamingKey e(final AesGcmHkdfStreamingKeyFormat aesGcmHkdfStreamingKeyFormat) throws GeneralSecurityException {
                return ((GeneratedMessageLite.Builder<AesGcmHkdfStreamingKey, BuilderType>)AesGcmHkdfStreamingKey.Q().D(ByteString.copyFrom(Random.c(aesGcmHkdfStreamingKeyFormat.M()))).E(aesGcmHkdfStreamingKeyFormat.N()).F(this.b.k())).p();
            }
            
            public AesGcmHkdfStreamingKeyFormat f(final ByteString byteString) throws InvalidProtocolBufferException {
                return AesGcmHkdfStreamingKeyFormat.P(byteString, ExtensionRegistryLite.b());
            }
            
            public void g(final AesGcmHkdfStreamingKeyFormat aesGcmHkdfStreamingKeyFormat) throws GeneralSecurityException {
                if (aesGcmHkdfStreamingKeyFormat.M() >= 16) {
                    AesGcmHkdfStreamingKeyManager.j(aesGcmHkdfStreamingKeyFormat.N());
                    return;
                }
                throw new GeneralSecurityException("key_size must be at least 16 bytes");
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
        this.n((AesGcmHkdfStreamingKey)messageLite);
    }
    
    public int k() {
        return 0;
    }
    
    public AesGcmHkdfStreamingKey l(final ByteString byteString) throws InvalidProtocolBufferException {
        return AesGcmHkdfStreamingKey.R(byteString, ExtensionRegistryLite.b());
    }
    
    public void n(final AesGcmHkdfStreamingKey aesGcmHkdfStreamingKey) throws GeneralSecurityException {
        Validators.f(aesGcmHkdfStreamingKey.P(), this.k());
        o(aesGcmHkdfStreamingKey.O());
    }
}
