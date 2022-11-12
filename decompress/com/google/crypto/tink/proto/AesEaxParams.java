// 
// Decompiled by Procyon v0.6.0
// 

package com.google.crypto.tink.proto;

import com.google.crypto.tink.shaded.protobuf.MessageLite;
import com.google.crypto.tink.shaded.protobuf.Parser;
import com.google.crypto.tink.shaded.protobuf.GeneratedMessageLite;

public final class AesEaxParams extends GeneratedMessageLite<AesEaxParams, Builder> implements AesEaxParamsOrBuilder
{
    private static final AesEaxParams DEFAULT_INSTANCE;
    public static final int IV_SIZE_FIELD_NUMBER = 1;
    private static volatile Parser<AesEaxParams> PARSER;
    private int ivSize_;
    
    static {
        GeneratedMessageLite.H(AesEaxParams.class, DEFAULT_INSTANCE = new AesEaxParams());
    }
    
    private AesEaxParams() {
    }
    
    static AesEaxParams J() {
        return AesEaxParams.DEFAULT_INSTANCE;
    }
    
    static void K(final AesEaxParams aesEaxParams, final int n) {
        aesEaxParams.O(n);
    }
    
    public static AesEaxParams L() {
        return AesEaxParams.DEFAULT_INSTANCE;
    }
    
    public static Builder N() {
        return ((GeneratedMessageLite<GeneratedMessageLite, GeneratedMessageLite.Builder>)AesEaxParams.DEFAULT_INSTANCE).n();
    }
    
    private void O(final int ivSize_) {
        this.ivSize_ = ivSize_;
    }
    
    public int M() {
        return this.ivSize_;
    }
    
    @Override
    protected final Object q(final MethodToInvoke methodToInvoke, final Object o, final Object o2) {
        switch (AesEaxParams$a.a[methodToInvoke.ordinal()]) {
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
                final Parser<AesEaxParams> parser;
                if ((parser = AesEaxParams.PARSER) == null) {
                    synchronized (AesEaxParams.class) {
                        if (AesEaxParams.PARSER == null) {
                            AesEaxParams.PARSER = new DefaultInstanceBasedParser<AesEaxParams>(AesEaxParams.DEFAULT_INSTANCE);
                        }
                    }
                }
                return parser;
            }
            case 4: {
                return AesEaxParams.DEFAULT_INSTANCE;
            }
            case 3: {
                return GeneratedMessageLite.A(AesEaxParams.DEFAULT_INSTANCE, "\u0000\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0000\u0000\u0001\u000b", new Object[] { "ivSize_" });
            }
            case 2: {
                return new Builder((AesEaxParams$a)null);
            }
            case 1: {
                return new AesEaxParams();
            }
        }
    }
    
    public static final class Builder extends GeneratedMessageLite.Builder<AesEaxParams, Builder> implements AesEaxParamsOrBuilder
    {
        private Builder() {
            super(AesEaxParams.J());
        }
        
        Builder(final AesEaxParams$a object) {
            this();
        }
        
        public Builder D(final int n) {
            ((GeneratedMessageLite.Builder)this).u();
            AesEaxParams.K((AesEaxParams)super.b, n);
            return this;
        }
    }
}
