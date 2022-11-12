// 
// Decompiled by Procyon v0.6.0
// 

package com.google.crypto.tink.proto;

import com.google.crypto.tink.shaded.protobuf.MessageLite;
import com.google.crypto.tink.shaded.protobuf.Parser;
import com.google.crypto.tink.shaded.protobuf.GeneratedMessageLite;

public final class AesCtrParams extends GeneratedMessageLite<AesCtrParams, Builder> implements AesCtrParamsOrBuilder
{
    private static final AesCtrParams DEFAULT_INSTANCE;
    public static final int IV_SIZE_FIELD_NUMBER = 1;
    private static volatile Parser<AesCtrParams> PARSER;
    private int ivSize_;
    
    static {
        GeneratedMessageLite.H(AesCtrParams.class, DEFAULT_INSTANCE = new AesCtrParams());
    }
    
    private AesCtrParams() {
    }
    
    static AesCtrParams J() {
        return AesCtrParams.DEFAULT_INSTANCE;
    }
    
    static void K(final AesCtrParams aesCtrParams, final int n) {
        aesCtrParams.O(n);
    }
    
    public static AesCtrParams L() {
        return AesCtrParams.DEFAULT_INSTANCE;
    }
    
    public static Builder N() {
        return ((GeneratedMessageLite<GeneratedMessageLite, GeneratedMessageLite.Builder>)AesCtrParams.DEFAULT_INSTANCE).n();
    }
    
    private void O(final int ivSize_) {
        this.ivSize_ = ivSize_;
    }
    
    public int M() {
        return this.ivSize_;
    }
    
    @Override
    protected final Object q(final MethodToInvoke methodToInvoke, final Object o, final Object o2) {
        switch (AesCtrParams$a.a[methodToInvoke.ordinal()]) {
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
                final Parser<AesCtrParams> parser;
                if ((parser = AesCtrParams.PARSER) == null) {
                    synchronized (AesCtrParams.class) {
                        if (AesCtrParams.PARSER == null) {
                            AesCtrParams.PARSER = new DefaultInstanceBasedParser<AesCtrParams>(AesCtrParams.DEFAULT_INSTANCE);
                        }
                    }
                }
                return parser;
            }
            case 4: {
                return AesCtrParams.DEFAULT_INSTANCE;
            }
            case 3: {
                return GeneratedMessageLite.A(AesCtrParams.DEFAULT_INSTANCE, "\u0000\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0000\u0000\u0001\u000b", new Object[] { "ivSize_" });
            }
            case 2: {
                return new Builder((AesCtrParams$a)null);
            }
            case 1: {
                return new AesCtrParams();
            }
        }
    }
    
    public static final class Builder extends GeneratedMessageLite.Builder<AesCtrParams, Builder> implements AesCtrParamsOrBuilder
    {
        private Builder() {
            super(AesCtrParams.J());
        }
        
        Builder(final AesCtrParams$a object) {
            this();
        }
        
        public Builder D(final int n) {
            ((GeneratedMessageLite.Builder)this).u();
            AesCtrParams.K((AesCtrParams)super.b, n);
            return this;
        }
    }
}
