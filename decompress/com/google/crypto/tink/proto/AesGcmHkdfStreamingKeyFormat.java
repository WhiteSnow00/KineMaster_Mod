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

public final class AesGcmHkdfStreamingKeyFormat extends GeneratedMessageLite<AesGcmHkdfStreamingKeyFormat, Builder> implements AesGcmHkdfStreamingKeyFormatOrBuilder
{
    private static final AesGcmHkdfStreamingKeyFormat DEFAULT_INSTANCE;
    public static final int KEY_SIZE_FIELD_NUMBER = 2;
    public static final int PARAMS_FIELD_NUMBER = 1;
    private static volatile Parser<AesGcmHkdfStreamingKeyFormat> PARSER;
    public static final int VERSION_FIELD_NUMBER = 3;
    private int keySize_;
    private AesGcmHkdfStreamingParams params_;
    private int version_;
    
    static {
        GeneratedMessageLite.H(AesGcmHkdfStreamingKeyFormat.class, DEFAULT_INSTANCE = new AesGcmHkdfStreamingKeyFormat());
    }
    
    private AesGcmHkdfStreamingKeyFormat() {
    }
    
    static AesGcmHkdfStreamingKeyFormat J() {
        return AesGcmHkdfStreamingKeyFormat.DEFAULT_INSTANCE;
    }
    
    static void K(final AesGcmHkdfStreamingKeyFormat aesGcmHkdfStreamingKeyFormat, final AesGcmHkdfStreamingParams aesGcmHkdfStreamingParams) {
        aesGcmHkdfStreamingKeyFormat.R(aesGcmHkdfStreamingParams);
    }
    
    static void L(final AesGcmHkdfStreamingKeyFormat aesGcmHkdfStreamingKeyFormat, final int n) {
        aesGcmHkdfStreamingKeyFormat.Q(n);
    }
    
    public static Builder O() {
        return ((GeneratedMessageLite<GeneratedMessageLite, GeneratedMessageLite.Builder>)AesGcmHkdfStreamingKeyFormat.DEFAULT_INSTANCE).n();
    }
    
    public static AesGcmHkdfStreamingKeyFormat P(final ByteString byteString, final ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return GeneratedMessageLite.B(AesGcmHkdfStreamingKeyFormat.DEFAULT_INSTANCE, byteString, extensionRegistryLite);
    }
    
    private void Q(final int keySize_) {
        this.keySize_ = keySize_;
    }
    
    private void R(final AesGcmHkdfStreamingParams params_) {
        params_.getClass();
        this.params_ = params_;
    }
    
    public int M() {
        return this.keySize_;
    }
    
    public AesGcmHkdfStreamingParams N() {
        AesGcmHkdfStreamingParams aesGcmHkdfStreamingParams;
        if ((aesGcmHkdfStreamingParams = this.params_) == null) {
            aesGcmHkdfStreamingParams = AesGcmHkdfStreamingParams.O();
        }
        return aesGcmHkdfStreamingParams;
    }
    
    @Override
    protected final Object q(final MethodToInvoke methodToInvoke, final Object o, final Object o2) {
        switch (AesGcmHkdfStreamingKeyFormat$a.a[methodToInvoke.ordinal()]) {
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
                final Parser<AesGcmHkdfStreamingKeyFormat> parser;
                if ((parser = AesGcmHkdfStreamingKeyFormat.PARSER) == null) {
                    synchronized (AesGcmHkdfStreamingKeyFormat.class) {
                        if (AesGcmHkdfStreamingKeyFormat.PARSER == null) {
                            AesGcmHkdfStreamingKeyFormat.PARSER = new DefaultInstanceBasedParser<AesGcmHkdfStreamingKeyFormat>(AesGcmHkdfStreamingKeyFormat.DEFAULT_INSTANCE);
                        }
                    }
                }
                return parser;
            }
            case 4: {
                return AesGcmHkdfStreamingKeyFormat.DEFAULT_INSTANCE;
            }
            case 3: {
                return GeneratedMessageLite.A(AesGcmHkdfStreamingKeyFormat.DEFAULT_INSTANCE, "\u0000\u0003\u0000\u0000\u0001\u0003\u0003\u0000\u0000\u0000\u0001\t\u0002\u000b\u0003\u000b", new Object[] { "params_", "keySize_", "version_" });
            }
            case 2: {
                return new Builder((AesGcmHkdfStreamingKeyFormat$a)null);
            }
            case 1: {
                return new AesGcmHkdfStreamingKeyFormat();
            }
        }
    }
    
    public static final class Builder extends GeneratedMessageLite.Builder<AesGcmHkdfStreamingKeyFormat, Builder> implements AesGcmHkdfStreamingKeyFormatOrBuilder
    {
        private Builder() {
            super(AesGcmHkdfStreamingKeyFormat.J());
        }
        
        Builder(final AesGcmHkdfStreamingKeyFormat$a object) {
            this();
        }
        
        public Builder D(final int n) {
            ((GeneratedMessageLite.Builder)this).u();
            AesGcmHkdfStreamingKeyFormat.L((AesGcmHkdfStreamingKeyFormat)super.b, n);
            return this;
        }
        
        public Builder E(final AesGcmHkdfStreamingParams aesGcmHkdfStreamingParams) {
            ((GeneratedMessageLite.Builder)this).u();
            AesGcmHkdfStreamingKeyFormat.K((AesGcmHkdfStreamingKeyFormat)super.b, aesGcmHkdfStreamingParams);
            return this;
        }
    }
}
