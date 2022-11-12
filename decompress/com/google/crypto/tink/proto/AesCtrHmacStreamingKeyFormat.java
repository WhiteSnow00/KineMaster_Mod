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

public final class AesCtrHmacStreamingKeyFormat extends GeneratedMessageLite<AesCtrHmacStreamingKeyFormat, Builder> implements AesCtrHmacStreamingKeyFormatOrBuilder
{
    private static final AesCtrHmacStreamingKeyFormat DEFAULT_INSTANCE;
    public static final int KEY_SIZE_FIELD_NUMBER = 2;
    public static final int PARAMS_FIELD_NUMBER = 1;
    private static volatile Parser<AesCtrHmacStreamingKeyFormat> PARSER;
    public static final int VERSION_FIELD_NUMBER = 3;
    private int keySize_;
    private AesCtrHmacStreamingParams params_;
    private int version_;
    
    static {
        GeneratedMessageLite.H(AesCtrHmacStreamingKeyFormat.class, DEFAULT_INSTANCE = new AesCtrHmacStreamingKeyFormat());
    }
    
    private AesCtrHmacStreamingKeyFormat() {
    }
    
    static AesCtrHmacStreamingKeyFormat J() {
        return AesCtrHmacStreamingKeyFormat.DEFAULT_INSTANCE;
    }
    
    static void K(final AesCtrHmacStreamingKeyFormat aesCtrHmacStreamingKeyFormat, final AesCtrHmacStreamingParams aesCtrHmacStreamingParams) {
        aesCtrHmacStreamingKeyFormat.R(aesCtrHmacStreamingParams);
    }
    
    static void L(final AesCtrHmacStreamingKeyFormat aesCtrHmacStreamingKeyFormat, final int n) {
        aesCtrHmacStreamingKeyFormat.Q(n);
    }
    
    public static Builder O() {
        return ((GeneratedMessageLite<GeneratedMessageLite, GeneratedMessageLite.Builder>)AesCtrHmacStreamingKeyFormat.DEFAULT_INSTANCE).n();
    }
    
    public static AesCtrHmacStreamingKeyFormat P(final ByteString byteString, final ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return GeneratedMessageLite.B(AesCtrHmacStreamingKeyFormat.DEFAULT_INSTANCE, byteString, extensionRegistryLite);
    }
    
    private void Q(final int keySize_) {
        this.keySize_ = keySize_;
    }
    
    private void R(final AesCtrHmacStreamingParams params_) {
        params_.getClass();
        this.params_ = params_;
    }
    
    public int M() {
        return this.keySize_;
    }
    
    public AesCtrHmacStreamingParams N() {
        AesCtrHmacStreamingParams aesCtrHmacStreamingParams;
        if ((aesCtrHmacStreamingParams = this.params_) == null) {
            aesCtrHmacStreamingParams = AesCtrHmacStreamingParams.P();
        }
        return aesCtrHmacStreamingParams;
    }
    
    @Override
    protected final Object q(final MethodToInvoke methodToInvoke, final Object o, final Object o2) {
        switch (AesCtrHmacStreamingKeyFormat$a.a[methodToInvoke.ordinal()]) {
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
                final Parser<AesCtrHmacStreamingKeyFormat> parser;
                if ((parser = AesCtrHmacStreamingKeyFormat.PARSER) == null) {
                    synchronized (AesCtrHmacStreamingKeyFormat.class) {
                        if (AesCtrHmacStreamingKeyFormat.PARSER == null) {
                            AesCtrHmacStreamingKeyFormat.PARSER = new DefaultInstanceBasedParser<AesCtrHmacStreamingKeyFormat>(AesCtrHmacStreamingKeyFormat.DEFAULT_INSTANCE);
                        }
                    }
                }
                return parser;
            }
            case 4: {
                return AesCtrHmacStreamingKeyFormat.DEFAULT_INSTANCE;
            }
            case 3: {
                return GeneratedMessageLite.A(AesCtrHmacStreamingKeyFormat.DEFAULT_INSTANCE, "\u0000\u0003\u0000\u0000\u0001\u0003\u0003\u0000\u0000\u0000\u0001\t\u0002\u000b\u0003\u000b", new Object[] { "params_", "keySize_", "version_" });
            }
            case 2: {
                return new Builder((AesCtrHmacStreamingKeyFormat$a)null);
            }
            case 1: {
                return new AesCtrHmacStreamingKeyFormat();
            }
        }
    }
    
    public static final class Builder extends GeneratedMessageLite.Builder<AesCtrHmacStreamingKeyFormat, Builder> implements AesCtrHmacStreamingKeyFormatOrBuilder
    {
        private Builder() {
            super(AesCtrHmacStreamingKeyFormat.J());
        }
        
        Builder(final AesCtrHmacStreamingKeyFormat$a object) {
            this();
        }
        
        public Builder D(final int n) {
            ((GeneratedMessageLite.Builder)this).u();
            AesCtrHmacStreamingKeyFormat.L((AesCtrHmacStreamingKeyFormat)super.b, n);
            return this;
        }
        
        public Builder E(final AesCtrHmacStreamingParams aesCtrHmacStreamingParams) {
            ((GeneratedMessageLite.Builder)this).u();
            AesCtrHmacStreamingKeyFormat.K((AesCtrHmacStreamingKeyFormat)super.b, aesCtrHmacStreamingParams);
            return this;
        }
    }
}
