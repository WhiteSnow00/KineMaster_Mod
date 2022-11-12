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

public final class AesEaxKeyFormat extends GeneratedMessageLite<AesEaxKeyFormat, Builder> implements AesEaxKeyFormatOrBuilder
{
    private static final AesEaxKeyFormat DEFAULT_INSTANCE;
    public static final int KEY_SIZE_FIELD_NUMBER = 2;
    public static final int PARAMS_FIELD_NUMBER = 1;
    private static volatile Parser<AesEaxKeyFormat> PARSER;
    private int keySize_;
    private AesEaxParams params_;
    
    static {
        GeneratedMessageLite.H(AesEaxKeyFormat.class, DEFAULT_INSTANCE = new AesEaxKeyFormat());
    }
    
    private AesEaxKeyFormat() {
    }
    
    static AesEaxKeyFormat J() {
        return AesEaxKeyFormat.DEFAULT_INSTANCE;
    }
    
    static void K(final AesEaxKeyFormat aesEaxKeyFormat, final AesEaxParams aesEaxParams) {
        aesEaxKeyFormat.R(aesEaxParams);
    }
    
    static void L(final AesEaxKeyFormat aesEaxKeyFormat, final int n) {
        aesEaxKeyFormat.Q(n);
    }
    
    public static Builder O() {
        return ((GeneratedMessageLite<GeneratedMessageLite, GeneratedMessageLite.Builder>)AesEaxKeyFormat.DEFAULT_INSTANCE).n();
    }
    
    public static AesEaxKeyFormat P(final ByteString byteString, final ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return GeneratedMessageLite.B(AesEaxKeyFormat.DEFAULT_INSTANCE, byteString, extensionRegistryLite);
    }
    
    private void Q(final int keySize_) {
        this.keySize_ = keySize_;
    }
    
    private void R(final AesEaxParams params_) {
        params_.getClass();
        this.params_ = params_;
    }
    
    public int M() {
        return this.keySize_;
    }
    
    public AesEaxParams N() {
        AesEaxParams aesEaxParams;
        if ((aesEaxParams = this.params_) == null) {
            aesEaxParams = AesEaxParams.L();
        }
        return aesEaxParams;
    }
    
    @Override
    protected final Object q(final MethodToInvoke methodToInvoke, final Object o, final Object o2) {
        switch (AesEaxKeyFormat$a.a[methodToInvoke.ordinal()]) {
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
                final Parser<AesEaxKeyFormat> parser;
                if ((parser = AesEaxKeyFormat.PARSER) == null) {
                    synchronized (AesEaxKeyFormat.class) {
                        if (AesEaxKeyFormat.PARSER == null) {
                            AesEaxKeyFormat.PARSER = new DefaultInstanceBasedParser<AesEaxKeyFormat>(AesEaxKeyFormat.DEFAULT_INSTANCE);
                        }
                    }
                }
                return parser;
            }
            case 4: {
                return AesEaxKeyFormat.DEFAULT_INSTANCE;
            }
            case 3: {
                return GeneratedMessageLite.A(AesEaxKeyFormat.DEFAULT_INSTANCE, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0000\u0000\u0001\t\u0002\u000b", new Object[] { "params_", "keySize_" });
            }
            case 2: {
                return new Builder((AesEaxKeyFormat$a)null);
            }
            case 1: {
                return new AesEaxKeyFormat();
            }
        }
    }
    
    public static final class Builder extends GeneratedMessageLite.Builder<AesEaxKeyFormat, Builder> implements AesEaxKeyFormatOrBuilder
    {
        private Builder() {
            super(AesEaxKeyFormat.J());
        }
        
        Builder(final AesEaxKeyFormat$a object) {
            this();
        }
        
        public Builder D(final int n) {
            ((GeneratedMessageLite.Builder)this).u();
            AesEaxKeyFormat.L((AesEaxKeyFormat)super.b, n);
            return this;
        }
        
        public Builder E(final AesEaxParams aesEaxParams) {
            ((GeneratedMessageLite.Builder)this).u();
            AesEaxKeyFormat.K((AesEaxKeyFormat)super.b, aesEaxParams);
            return this;
        }
    }
}
