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

public final class AesCtrKeyFormat extends GeneratedMessageLite<AesCtrKeyFormat, Builder> implements AesCtrKeyFormatOrBuilder
{
    private static final AesCtrKeyFormat DEFAULT_INSTANCE;
    public static final int KEY_SIZE_FIELD_NUMBER = 2;
    public static final int PARAMS_FIELD_NUMBER = 1;
    private static volatile Parser<AesCtrKeyFormat> PARSER;
    private int keySize_;
    private AesCtrParams params_;
    
    static {
        GeneratedMessageLite.H(AesCtrKeyFormat.class, DEFAULT_INSTANCE = new AesCtrKeyFormat());
    }
    
    private AesCtrKeyFormat() {
    }
    
    static AesCtrKeyFormat J() {
        return AesCtrKeyFormat.DEFAULT_INSTANCE;
    }
    
    static void K(final AesCtrKeyFormat aesCtrKeyFormat, final AesCtrParams aesCtrParams) {
        aesCtrKeyFormat.S(aesCtrParams);
    }
    
    static void L(final AesCtrKeyFormat aesCtrKeyFormat, final int n) {
        aesCtrKeyFormat.R(n);
    }
    
    public static AesCtrKeyFormat M() {
        return AesCtrKeyFormat.DEFAULT_INSTANCE;
    }
    
    public static Builder P() {
        return ((GeneratedMessageLite<GeneratedMessageLite, GeneratedMessageLite.Builder>)AesCtrKeyFormat.DEFAULT_INSTANCE).n();
    }
    
    public static AesCtrKeyFormat Q(final ByteString byteString, final ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return GeneratedMessageLite.B(AesCtrKeyFormat.DEFAULT_INSTANCE, byteString, extensionRegistryLite);
    }
    
    private void R(final int keySize_) {
        this.keySize_ = keySize_;
    }
    
    private void S(final AesCtrParams params_) {
        params_.getClass();
        this.params_ = params_;
    }
    
    public int N() {
        return this.keySize_;
    }
    
    public AesCtrParams O() {
        AesCtrParams aesCtrParams;
        if ((aesCtrParams = this.params_) == null) {
            aesCtrParams = AesCtrParams.L();
        }
        return aesCtrParams;
    }
    
    @Override
    protected final Object q(final MethodToInvoke methodToInvoke, final Object o, final Object o2) {
        switch (AesCtrKeyFormat$a.a[methodToInvoke.ordinal()]) {
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
                final Parser<AesCtrKeyFormat> parser;
                if ((parser = AesCtrKeyFormat.PARSER) == null) {
                    synchronized (AesCtrKeyFormat.class) {
                        if (AesCtrKeyFormat.PARSER == null) {
                            AesCtrKeyFormat.PARSER = new DefaultInstanceBasedParser<AesCtrKeyFormat>(AesCtrKeyFormat.DEFAULT_INSTANCE);
                        }
                    }
                }
                return parser;
            }
            case 4: {
                return AesCtrKeyFormat.DEFAULT_INSTANCE;
            }
            case 3: {
                return GeneratedMessageLite.A(AesCtrKeyFormat.DEFAULT_INSTANCE, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0000\u0000\u0001\t\u0002\u000b", new Object[] { "params_", "keySize_" });
            }
            case 2: {
                return new Builder((AesCtrKeyFormat$a)null);
            }
            case 1: {
                return new AesCtrKeyFormat();
            }
        }
    }
    
    public static final class Builder extends GeneratedMessageLite.Builder<AesCtrKeyFormat, Builder> implements AesCtrKeyFormatOrBuilder
    {
        private Builder() {
            super(AesCtrKeyFormat.J());
        }
        
        Builder(final AesCtrKeyFormat$a object) {
            this();
        }
        
        public Builder D(final int n) {
            ((GeneratedMessageLite.Builder)this).u();
            AesCtrKeyFormat.L((AesCtrKeyFormat)super.b, n);
            return this;
        }
        
        public Builder E(final AesCtrParams aesCtrParams) {
            ((GeneratedMessageLite.Builder)this).u();
            AesCtrKeyFormat.K((AesCtrKeyFormat)super.b, aesCtrParams);
            return this;
        }
    }
}
