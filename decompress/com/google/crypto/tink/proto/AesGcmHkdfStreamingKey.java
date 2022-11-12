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

public final class AesGcmHkdfStreamingKey extends GeneratedMessageLite<AesGcmHkdfStreamingKey, Builder> implements AesGcmHkdfStreamingKeyOrBuilder
{
    private static final AesGcmHkdfStreamingKey DEFAULT_INSTANCE;
    public static final int KEY_VALUE_FIELD_NUMBER = 3;
    public static final int PARAMS_FIELD_NUMBER = 2;
    private static volatile Parser<AesGcmHkdfStreamingKey> PARSER;
    public static final int VERSION_FIELD_NUMBER = 1;
    private ByteString keyValue_;
    private AesGcmHkdfStreamingParams params_;
    private int version_;
    
    static {
        GeneratedMessageLite.H(AesGcmHkdfStreamingKey.class, DEFAULT_INSTANCE = new AesGcmHkdfStreamingKey());
    }
    
    private AesGcmHkdfStreamingKey() {
        this.keyValue_ = ByteString.EMPTY;
    }
    
    static AesGcmHkdfStreamingKey J() {
        return AesGcmHkdfStreamingKey.DEFAULT_INSTANCE;
    }
    
    static void K(final AesGcmHkdfStreamingKey aesGcmHkdfStreamingKey, final int n) {
        aesGcmHkdfStreamingKey.U(n);
    }
    
    static void L(final AesGcmHkdfStreamingKey aesGcmHkdfStreamingKey, final AesGcmHkdfStreamingParams aesGcmHkdfStreamingParams) {
        aesGcmHkdfStreamingKey.T(aesGcmHkdfStreamingParams);
    }
    
    static void M(final AesGcmHkdfStreamingKey aesGcmHkdfStreamingKey, final ByteString byteString) {
        aesGcmHkdfStreamingKey.S(byteString);
    }
    
    public static Builder Q() {
        return ((GeneratedMessageLite<GeneratedMessageLite, GeneratedMessageLite.Builder>)AesGcmHkdfStreamingKey.DEFAULT_INSTANCE).n();
    }
    
    public static AesGcmHkdfStreamingKey R(final ByteString byteString, final ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return GeneratedMessageLite.B(AesGcmHkdfStreamingKey.DEFAULT_INSTANCE, byteString, extensionRegistryLite);
    }
    
    private void S(final ByteString keyValue_) {
        keyValue_.getClass();
        this.keyValue_ = keyValue_;
    }
    
    private void T(final AesGcmHkdfStreamingParams params_) {
        params_.getClass();
        this.params_ = params_;
    }
    
    private void U(final int version_) {
        this.version_ = version_;
    }
    
    public ByteString N() {
        return this.keyValue_;
    }
    
    public AesGcmHkdfStreamingParams O() {
        AesGcmHkdfStreamingParams aesGcmHkdfStreamingParams;
        if ((aesGcmHkdfStreamingParams = this.params_) == null) {
            aesGcmHkdfStreamingParams = AesGcmHkdfStreamingParams.O();
        }
        return aesGcmHkdfStreamingParams;
    }
    
    public int P() {
        return this.version_;
    }
    
    @Override
    protected final Object q(final MethodToInvoke methodToInvoke, final Object o, final Object o2) {
        switch (AesGcmHkdfStreamingKey$a.a[methodToInvoke.ordinal()]) {
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
                final Parser<AesGcmHkdfStreamingKey> parser;
                if ((parser = AesGcmHkdfStreamingKey.PARSER) == null) {
                    synchronized (AesGcmHkdfStreamingKey.class) {
                        if (AesGcmHkdfStreamingKey.PARSER == null) {
                            AesGcmHkdfStreamingKey.PARSER = new DefaultInstanceBasedParser<AesGcmHkdfStreamingKey>(AesGcmHkdfStreamingKey.DEFAULT_INSTANCE);
                        }
                    }
                }
                return parser;
            }
            case 4: {
                return AesGcmHkdfStreamingKey.DEFAULT_INSTANCE;
            }
            case 3: {
                return GeneratedMessageLite.A(AesGcmHkdfStreamingKey.DEFAULT_INSTANCE, "\u0000\u0003\u0000\u0000\u0001\u0003\u0003\u0000\u0000\u0000\u0001\u000b\u0002\t\u0003\n", new Object[] { "version_", "params_", "keyValue_" });
            }
            case 2: {
                return new Builder((AesGcmHkdfStreamingKey$a)null);
            }
            case 1: {
                return new AesGcmHkdfStreamingKey();
            }
        }
    }
    
    public static final class Builder extends GeneratedMessageLite.Builder<AesGcmHkdfStreamingKey, Builder> implements AesGcmHkdfStreamingKeyOrBuilder
    {
        private Builder() {
            super(AesGcmHkdfStreamingKey.J());
        }
        
        Builder(final AesGcmHkdfStreamingKey$a object) {
            this();
        }
        
        public Builder D(final ByteString byteString) {
            ((GeneratedMessageLite.Builder)this).u();
            AesGcmHkdfStreamingKey.M((AesGcmHkdfStreamingKey)super.b, byteString);
            return this;
        }
        
        public Builder E(final AesGcmHkdfStreamingParams aesGcmHkdfStreamingParams) {
            ((GeneratedMessageLite.Builder)this).u();
            AesGcmHkdfStreamingKey.L((AesGcmHkdfStreamingKey)super.b, aesGcmHkdfStreamingParams);
            return this;
        }
        
        public Builder F(final int n) {
            ((GeneratedMessageLite.Builder)this).u();
            AesGcmHkdfStreamingKey.K((AesGcmHkdfStreamingKey)super.b, n);
            return this;
        }
    }
}
