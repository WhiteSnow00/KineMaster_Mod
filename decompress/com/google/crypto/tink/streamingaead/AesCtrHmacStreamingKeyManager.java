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
import com.google.crypto.tink.proto.AesCtrHmacStreamingKeyFormat;
import com.google.crypto.tink.proto.HashType;
import com.google.crypto.tink.subtle.Validators;
import com.google.crypto.tink.proto.HmacParams;
import com.google.crypto.tink.shaded.protobuf.MessageLite;
import com.google.crypto.tink.Registry;
import com.google.crypto.tink.proto.AesCtrHmacStreamingParams;
import com.google.crypto.tink.subtle.AesCtrHmacStreaming;
import java.security.GeneralSecurityException;
import com.google.crypto.tink.StreamingAead;
import com.google.crypto.tink.proto.AesCtrHmacStreamingKey;
import com.google.crypto.tink.KeyTypeManager;

public final class AesCtrHmacStreamingKeyManager extends KeyTypeManager<AesCtrHmacStreamingKey>
{
    AesCtrHmacStreamingKeyManager() {
        super(AesCtrHmacStreamingKey.class, (PrimitiveFactory<?, AesCtrHmacStreamingKey>[])new PrimitiveFactory[] { new PrimitiveFactory<StreamingAead, AesCtrHmacStreamingKey>(StreamingAead.class) {
                @Override
                public /* bridge */ Object a(final Object o) throws GeneralSecurityException {
                    return this.c((AesCtrHmacStreamingKey)o);
                }
                
                public StreamingAead c(final AesCtrHmacStreamingKey aesCtrHmacStreamingKey) throws GeneralSecurityException {
                    return new AesCtrHmacStreaming(aesCtrHmacStreamingKey.N().toByteArray(), com.google.crypto.tink.streamingaead.b.a(aesCtrHmacStreamingKey.O().R()), aesCtrHmacStreamingKey.O().Q(), com.google.crypto.tink.streamingaead.b.a(aesCtrHmacStreamingKey.O().S().N()), aesCtrHmacStreamingKey.O().S().O(), aesCtrHmacStreamingKey.O().O(), 0);
                }
            } });
    }
    
    static void j(final AesCtrHmacStreamingParams aesCtrHmacStreamingParams) throws GeneralSecurityException {
        p(aesCtrHmacStreamingParams);
    }
    
    public static void m(final boolean b) throws GeneralSecurityException {
        Registry.s((KeyTypeManager<MessageLite>)new AesCtrHmacStreamingKeyManager(), b);
    }
    
    private static void n(final HmacParams hmacParams) throws GeneralSecurityException {
        if (hmacParams.O() >= 10) {
            final int n = AesCtrHmacStreamingKeyManager$c.a[hmacParams.N().ordinal()];
            if (n != 1) {
                if (n != 2) {
                    if (n != 3) {
                        throw new GeneralSecurityException("unknown hash type");
                    }
                    if (hmacParams.O() > 64) {
                        throw new GeneralSecurityException("tag size too big");
                    }
                }
                else if (hmacParams.O() > 32) {
                    throw new GeneralSecurityException("tag size too big");
                }
            }
            else if (hmacParams.O() > 20) {
                throw new GeneralSecurityException("tag size too big");
            }
            return;
        }
        throw new GeneralSecurityException("tag size too small");
    }
    
    private static void p(final AesCtrHmacStreamingParams aesCtrHmacStreamingParams) throws GeneralSecurityException {
        Validators.a(aesCtrHmacStreamingParams.Q());
        final HashType r = aesCtrHmacStreamingParams.R();
        final HashType unknown_HASH = HashType.UNKNOWN_HASH;
        if (r == unknown_HASH) {
            throw new GeneralSecurityException("unknown HKDF hash type");
        }
        if (aesCtrHmacStreamingParams.S().N() == unknown_HASH) {
            throw new GeneralSecurityException("unknown HMAC hash type");
        }
        n(aesCtrHmacStreamingParams.S());
        if (aesCtrHmacStreamingParams.O() >= aesCtrHmacStreamingParams.Q() + aesCtrHmacStreamingParams.S().O() + 2 + 7) {
            return;
        }
        throw new GeneralSecurityException("ciphertext_segment_size must be at least (derived_key_size + tag_size + NONCE_PREFIX_IN_BYTES + 2)");
    }
    
    @Override
    public String c() {
        return "type.googleapis.com/google.crypto.tink.AesCtrHmacStreamingKey";
    }
    
    @Override
    public KeyFactory<AesCtrHmacStreamingKeyFormat, AesCtrHmacStreamingKey> e() {
        return new KeyFactory<AesCtrHmacStreamingKeyFormat, AesCtrHmacStreamingKey>(this, AesCtrHmacStreamingKeyFormat.class) {
            final AesCtrHmacStreamingKeyManager b;
            
            @Override
            public /* bridge */ Object a(final MessageLite messageLite) throws GeneralSecurityException {
                return this.e((AesCtrHmacStreamingKeyFormat)messageLite);
            }
            
            @Override
            public /* bridge */ MessageLite c(final ByteString byteString) throws InvalidProtocolBufferException {
                return this.f(byteString);
            }
            
            @Override
            public /* bridge */ void d(final MessageLite messageLite) throws GeneralSecurityException {
                this.g((AesCtrHmacStreamingKeyFormat)messageLite);
            }
            
            public AesCtrHmacStreamingKey e(final AesCtrHmacStreamingKeyFormat aesCtrHmacStreamingKeyFormat) throws GeneralSecurityException {
                return ((GeneratedMessageLite.Builder<AesCtrHmacStreamingKey, BuilderType>)AesCtrHmacStreamingKey.Q().D(ByteString.copyFrom(Random.c(aesCtrHmacStreamingKeyFormat.M()))).E(aesCtrHmacStreamingKeyFormat.N()).F(this.b.k())).p();
            }
            
            public AesCtrHmacStreamingKeyFormat f(final ByteString byteString) throws InvalidProtocolBufferException {
                return AesCtrHmacStreamingKeyFormat.P(byteString, ExtensionRegistryLite.b());
            }
            
            public void g(final AesCtrHmacStreamingKeyFormat aesCtrHmacStreamingKeyFormat) throws GeneralSecurityException {
                if (aesCtrHmacStreamingKeyFormat.M() >= 16) {
                    AesCtrHmacStreamingKeyManager.j(aesCtrHmacStreamingKeyFormat.N());
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
        this.o((AesCtrHmacStreamingKey)messageLite);
    }
    
    public int k() {
        return 0;
    }
    
    public AesCtrHmacStreamingKey l(final ByteString byteString) throws InvalidProtocolBufferException {
        return AesCtrHmacStreamingKey.R(byteString, ExtensionRegistryLite.b());
    }
    
    public void o(final AesCtrHmacStreamingKey aesCtrHmacStreamingKey) throws GeneralSecurityException {
        Validators.f(aesCtrHmacStreamingKey.P(), this.k());
        if (aesCtrHmacStreamingKey.N().size() < 16) {
            throw new GeneralSecurityException("key_value must have at least 16 bytes");
        }
        if (aesCtrHmacStreamingKey.N().size() >= aesCtrHmacStreamingKey.O().Q()) {
            p(aesCtrHmacStreamingKey.O());
            return;
        }
        throw new GeneralSecurityException("key_value must have at least as many bits as derived keys");
    }
}
