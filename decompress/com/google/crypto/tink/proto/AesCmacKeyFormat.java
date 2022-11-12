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

public final class AesCmacKeyFormat extends GeneratedMessageLite<AesCmacKeyFormat, Builder> implements AesCmacKeyFormatOrBuilder
{
    private static final AesCmacKeyFormat DEFAULT_INSTANCE;
    public static final int KEY_SIZE_FIELD_NUMBER = 1;
    public static final int PARAMS_FIELD_NUMBER = 2;
    private static volatile Parser<AesCmacKeyFormat> PARSER;
    private int keySize_;
    private AesCmacParams params_;
    
    static {
        GeneratedMessageLite.H(AesCmacKeyFormat.class, DEFAULT_INSTANCE = new AesCmacKeyFormat());
    }
    
    private AesCmacKeyFormat() {
    }
    
    static AesCmacKeyFormat J() {
        return AesCmacKeyFormat.DEFAULT_INSTANCE;
    }
    
    static void K(final AesCmacKeyFormat aesCmacKeyFormat, final int n) {
        aesCmacKeyFormat.Q(n);
    }
    
    static void L(final AesCmacKeyFormat aesCmacKeyFormat, final AesCmacParams aesCmacParams) {
        aesCmacKeyFormat.R(aesCmacParams);
    }
    
    public static Builder O() {
        return ((GeneratedMessageLite<GeneratedMessageLite, GeneratedMessageLite.Builder>)AesCmacKeyFormat.DEFAULT_INSTANCE).n();
    }
    
    public static AesCmacKeyFormat P(final ByteString byteString, final ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return GeneratedMessageLite.B(AesCmacKeyFormat.DEFAULT_INSTANCE, byteString, extensionRegistryLite);
    }
    
    private void Q(final int keySize_) {
        this.keySize_ = keySize_;
    }
    
    private void R(final AesCmacParams params_) {
        params_.getClass();
        this.params_ = params_;
    }
    
    public int M() {
        return this.keySize_;
    }
    
    public AesCmacParams N() {
        AesCmacParams aesCmacParams;
        if ((aesCmacParams = this.params_) == null) {
            aesCmacParams = AesCmacParams.L();
        }
        return aesCmacParams;
    }
    
    @Override
    protected final Object q(final MethodToInvoke methodToInvoke, final Object o, final Object o2) {
        switch (AesCmacKeyFormat$a.a[methodToInvoke.ordinal()]) {
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
                final Parser<AesCmacKeyFormat> parser;
                if ((parser = AesCmacKeyFormat.PARSER) == null) {
                    synchronized (AesCmacKeyFormat.class) {
                        if (AesCmacKeyFormat.PARSER == null) {
                            AesCmacKeyFormat.PARSER = new DefaultInstanceBasedParser<AesCmacKeyFormat>(AesCmacKeyFormat.DEFAULT_INSTANCE);
                        }
                    }
                }
                return parser;
            }
            case 4: {
                return AesCmacKeyFormat.DEFAULT_INSTANCE;
            }
            case 3: {
                return GeneratedMessageLite.A(AesCmacKeyFormat.DEFAULT_INSTANCE, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0000\u0000\u0001\u000b\u0002\t", new Object[] { "keySize_", "params_" });
            }
            case 2: {
                return new Builder((AesCmacKeyFormat$a)null);
            }
            case 1: {
                return new AesCmacKeyFormat();
            }
        }
    }
    
    public static final class Builder extends GeneratedMessageLite.Builder<AesCmacKeyFormat, Builder> implements AesCmacKeyFormatOrBuilder
    {
        private Builder() {
            super(AesCmacKeyFormat.J());
        }
        
        Builder(final AesCmacKeyFormat$a object) {
            this();
        }
        
        public Builder D(final int n) {
            ((GeneratedMessageLite.Builder)this).u();
            AesCmacKeyFormat.K((AesCmacKeyFormat)super.b, n);
            return this;
        }
        
        public Builder E(final AesCmacParams aesCmacParams) {
            ((GeneratedMessageLite.Builder)this).u();
            AesCmacKeyFormat.L((AesCmacKeyFormat)super.b, aesCmacParams);
            return this;
        }
    }
}
