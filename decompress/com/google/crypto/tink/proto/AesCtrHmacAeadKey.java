// 
// Decompiled by Procyon v0.6.0
// 

package com.google.crypto.tink.proto;

import com.google.crypto.tink.shaded.protobuf.MessageLite;
import com.google.crypto.tink.shaded.protobuf.InvalidProtocolBufferException;
import com.google.crypto.tink.shaded.protobuf.ExtensionRegistryLite;
import com.google.crypto.tink.shaded.protobuf.ByteString;
import com.google.crypto.tink.shaded.protobuf.Parser;
import com.google.crypto.tink.shaded.protobuf.GeneratedMessageLite;

public final class AesCtrHmacAeadKey extends GeneratedMessageLite<AesCtrHmacAeadKey, Builder> implements AesCtrHmacAeadKeyOrBuilder
{
    public static final int AES_CTR_KEY_FIELD_NUMBER = 2;
    private static final AesCtrHmacAeadKey DEFAULT_INSTANCE;
    public static final int HMAC_KEY_FIELD_NUMBER = 3;
    private static volatile Parser<AesCtrHmacAeadKey> PARSER;
    public static final int VERSION_FIELD_NUMBER = 1;
    private AesCtrKey aesCtrKey_;
    private HmacKey hmacKey_;
    private int version_;
    
    static {
        GeneratedMessageLite.H(AesCtrHmacAeadKey.class, DEFAULT_INSTANCE = new AesCtrHmacAeadKey());
    }
    
    private AesCtrHmacAeadKey() {
    }
    
    static AesCtrHmacAeadKey J() {
        return AesCtrHmacAeadKey.DEFAULT_INSTANCE;
    }
    
    static void K(final AesCtrHmacAeadKey aesCtrHmacAeadKey, final int n) {
        aesCtrHmacAeadKey.U(n);
    }
    
    static void L(final AesCtrHmacAeadKey aesCtrHmacAeadKey, final AesCtrKey aesCtrKey) {
        aesCtrHmacAeadKey.S(aesCtrKey);
    }
    
    static void M(final AesCtrHmacAeadKey aesCtrHmacAeadKey, final HmacKey hmacKey) {
        aesCtrHmacAeadKey.T(hmacKey);
    }
    
    public static Builder Q() {
        return ((GeneratedMessageLite<GeneratedMessageLite, GeneratedMessageLite.Builder>)AesCtrHmacAeadKey.DEFAULT_INSTANCE).n();
    }
    
    public static AesCtrHmacAeadKey R(final ByteString byteString, final ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return GeneratedMessageLite.B(AesCtrHmacAeadKey.DEFAULT_INSTANCE, byteString, extensionRegistryLite);
    }
    
    private void S(final AesCtrKey aesCtrKey_) {
        aesCtrKey_.getClass();
        this.aesCtrKey_ = aesCtrKey_;
    }
    
    private void T(final HmacKey hmacKey_) {
        hmacKey_.getClass();
        this.hmacKey_ = hmacKey_;
    }
    
    private void U(final int version_) {
        this.version_ = version_;
    }
    
    public AesCtrKey N() {
        AesCtrKey aesCtrKey;
        if ((aesCtrKey = this.aesCtrKey_) == null) {
            aesCtrKey = AesCtrKey.N();
        }
        return aesCtrKey;
    }
    
    public HmacKey O() {
        HmacKey hmacKey;
        if ((hmacKey = this.hmacKey_) == null) {
            hmacKey = HmacKey.N();
        }
        return hmacKey;
    }
    
    public int P() {
        return this.version_;
    }
    
    @Override
    protected final Object q(final MethodToInvoke methodToInvoke, final Object o, final Object o2) {
        switch (AesCtrHmacAeadKey$a.a[methodToInvoke.ordinal()]) {
            default: {
                throw new UnsupportedOperationException();
            }
            case 7: {
                return null;
            }
            case 6: {
                return 1;
            }
            case 5: {
                final Parser<AesCtrHmacAeadKey> parser;
                if ((parser = AesCtrHmacAeadKey.PARSER) == null) {
                    synchronized (AesCtrHmacAeadKey.class) {
                        if (AesCtrHmacAeadKey.PARSER == null) {
                            AesCtrHmacAeadKey.PARSER = new DefaultInstanceBasedParser<AesCtrHmacAeadKey>(AesCtrHmacAeadKey.DEFAULT_INSTANCE);
                        }
                    }
                }
                return parser;
            }
            case 4: {
                return AesCtrHmacAeadKey.DEFAULT_INSTANCE;
            }
            case 3: {
                return GeneratedMessageLite.A(AesCtrHmacAeadKey.DEFAULT_INSTANCE, "\u0000\u0003\u0000\u0000\u0001\u0003\u0003\u0000\u0000\u0000\u0001\u000b\u0002\t\u0003\t", new Object[] { "version_", "aesCtrKey_", "hmacKey_" });
            }
            case 2: {
                return new Builder((AesCtrHmacAeadKey$a)null);
            }
            case 1: {
                return new AesCtrHmacAeadKey();
            }
        }
    }
    
    public static final class Builder extends GeneratedMessageLite.Builder<AesCtrHmacAeadKey, Builder> implements AesCtrHmacAeadKeyOrBuilder
    {
        private Builder() {
            super(AesCtrHmacAeadKey.J());
        }
        
        Builder(final AesCtrHmacAeadKey$a object) {
            this();
        }
        
        public Builder D(final AesCtrKey aesCtrKey) {
            ((GeneratedMessageLite.Builder)this).u();
            AesCtrHmacAeadKey.L((AesCtrHmacAeadKey)super.b, aesCtrKey);
            return this;
        }
        
        public Builder E(final HmacKey hmacKey) {
            ((GeneratedMessageLite.Builder)this).u();
            AesCtrHmacAeadKey.M((AesCtrHmacAeadKey)super.b, hmacKey);
            return this;
        }
        
        public Builder F(final int n) {
            ((GeneratedMessageLite.Builder)this).u();
            AesCtrHmacAeadKey.K((AesCtrHmacAeadKey)super.b, n);
            return this;
        }
    }
}
