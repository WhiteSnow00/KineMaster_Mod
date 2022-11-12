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

public final class AesCtrHmacStreamingKey extends GeneratedMessageLite<AesCtrHmacStreamingKey, Builder> implements AesCtrHmacStreamingKeyOrBuilder
{
    private static final AesCtrHmacStreamingKey DEFAULT_INSTANCE;
    public static final int KEY_VALUE_FIELD_NUMBER = 3;
    public static final int PARAMS_FIELD_NUMBER = 2;
    private static volatile Parser<AesCtrHmacStreamingKey> PARSER;
    public static final int VERSION_FIELD_NUMBER = 1;
    private ByteString keyValue_;
    private AesCtrHmacStreamingParams params_;
    private int version_;
    
    static {
        GeneratedMessageLite.H(AesCtrHmacStreamingKey.class, DEFAULT_INSTANCE = new AesCtrHmacStreamingKey());
    }
    
    private AesCtrHmacStreamingKey() {
        this.keyValue_ = ByteString.EMPTY;
    }
    
    static AesCtrHmacStreamingKey J() {
        return AesCtrHmacStreamingKey.DEFAULT_INSTANCE;
    }
    
    static void K(final AesCtrHmacStreamingKey aesCtrHmacStreamingKey, final int n) {
        aesCtrHmacStreamingKey.U(n);
    }
    
    static void L(final AesCtrHmacStreamingKey aesCtrHmacStreamingKey, final AesCtrHmacStreamingParams aesCtrHmacStreamingParams) {
        aesCtrHmacStreamingKey.T(aesCtrHmacStreamingParams);
    }
    
    static void M(final AesCtrHmacStreamingKey aesCtrHmacStreamingKey, final ByteString byteString) {
        aesCtrHmacStreamingKey.S(byteString);
    }
    
    public static Builder Q() {
        return ((GeneratedMessageLite<GeneratedMessageLite, GeneratedMessageLite.Builder>)AesCtrHmacStreamingKey.DEFAULT_INSTANCE).n();
    }
    
    public static AesCtrHmacStreamingKey R(final ByteString byteString, final ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return GeneratedMessageLite.B(AesCtrHmacStreamingKey.DEFAULT_INSTANCE, byteString, extensionRegistryLite);
    }
    
    private void S(final ByteString keyValue_) {
        keyValue_.getClass();
        this.keyValue_ = keyValue_;
    }
    
    private void T(final AesCtrHmacStreamingParams params_) {
        params_.getClass();
        this.params_ = params_;
    }
    
    private void U(final int version_) {
        this.version_ = version_;
    }
    
    public ByteString N() {
        return this.keyValue_;
    }
    
    public AesCtrHmacStreamingParams O() {
        AesCtrHmacStreamingParams aesCtrHmacStreamingParams;
        if ((aesCtrHmacStreamingParams = this.params_) == null) {
            aesCtrHmacStreamingParams = AesCtrHmacStreamingParams.P();
        }
        return aesCtrHmacStreamingParams;
    }
    
    public int P() {
        return this.version_;
    }
    
    @Override
    protected final Object q(final MethodToInvoke methodToInvoke, final Object o, final Object o2) {
        switch (AesCtrHmacStreamingKey$a.a[methodToInvoke.ordinal()]) {
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
                final Parser<AesCtrHmacStreamingKey> parser;
                if ((parser = AesCtrHmacStreamingKey.PARSER) == null) {
                    synchronized (AesCtrHmacStreamingKey.class) {
                        if (AesCtrHmacStreamingKey.PARSER == null) {
                            AesCtrHmacStreamingKey.PARSER = new DefaultInstanceBasedParser<AesCtrHmacStreamingKey>(AesCtrHmacStreamingKey.DEFAULT_INSTANCE);
                        }
                    }
                }
                return parser;
            }
            case 4: {
                return AesCtrHmacStreamingKey.DEFAULT_INSTANCE;
            }
            case 3: {
                return GeneratedMessageLite.A(AesCtrHmacStreamingKey.DEFAULT_INSTANCE, "\u0000\u0003\u0000\u0000\u0001\u0003\u0003\u0000\u0000\u0000\u0001\u000b\u0002\t\u0003\n", new Object[] { "version_", "params_", "keyValue_" });
            }
            case 2: {
                return new Builder((AesCtrHmacStreamingKey$a)null);
            }
            case 1: {
                return new AesCtrHmacStreamingKey();
            }
        }
    }
    
    public static final class Builder extends GeneratedMessageLite.Builder<AesCtrHmacStreamingKey, Builder> implements AesCtrHmacStreamingKeyOrBuilder
    {
        private Builder() {
            super(AesCtrHmacStreamingKey.J());
        }
        
        Builder(final AesCtrHmacStreamingKey$a object) {
            this();
        }
        
        public Builder D(final ByteString byteString) {
            ((GeneratedMessageLite.Builder)this).u();
            AesCtrHmacStreamingKey.M((AesCtrHmacStreamingKey)super.b, byteString);
            return this;
        }
        
        public Builder E(final AesCtrHmacStreamingParams aesCtrHmacStreamingParams) {
            ((GeneratedMessageLite.Builder)this).u();
            AesCtrHmacStreamingKey.L((AesCtrHmacStreamingKey)super.b, aesCtrHmacStreamingParams);
            return this;
        }
        
        public Builder F(final int n) {
            ((GeneratedMessageLite.Builder)this).u();
            AesCtrHmacStreamingKey.K((AesCtrHmacStreamingKey)super.b, n);
            return this;
        }
    }
}
