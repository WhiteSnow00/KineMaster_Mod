// 
// Decompiled by Procyon v0.6.0
// 

package com.google.crypto.tink.proto;

import com.google.crypto.tink.shaded.protobuf.MessageLite;
import com.google.crypto.tink.shaded.protobuf.Parser;
import com.google.crypto.tink.shaded.protobuf.GeneratedMessageLite;

public final class AesCmacParams extends GeneratedMessageLite<AesCmacParams, Builder> implements AesCmacParamsOrBuilder
{
    private static final AesCmacParams DEFAULT_INSTANCE;
    private static volatile Parser<AesCmacParams> PARSER;
    public static final int TAG_SIZE_FIELD_NUMBER = 1;
    private int tagSize_;
    
    static {
        GeneratedMessageLite.H(AesCmacParams.class, DEFAULT_INSTANCE = new AesCmacParams());
    }
    
    private AesCmacParams() {
    }
    
    static AesCmacParams J() {
        return AesCmacParams.DEFAULT_INSTANCE;
    }
    
    static void K(final AesCmacParams aesCmacParams, final int n) {
        aesCmacParams.O(n);
    }
    
    public static AesCmacParams L() {
        return AesCmacParams.DEFAULT_INSTANCE;
    }
    
    public static Builder N() {
        return ((GeneratedMessageLite<GeneratedMessageLite, GeneratedMessageLite.Builder>)AesCmacParams.DEFAULT_INSTANCE).n();
    }
    
    private void O(final int tagSize_) {
        this.tagSize_ = tagSize_;
    }
    
    public int M() {
        return this.tagSize_;
    }
    
    @Override
    protected final Object q(final MethodToInvoke methodToInvoke, final Object o, final Object o2) {
        switch (AesCmacParams$a.a[methodToInvoke.ordinal()]) {
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
                final Parser<AesCmacParams> parser;
                if ((parser = AesCmacParams.PARSER) == null) {
                    synchronized (AesCmacParams.class) {
                        if (AesCmacParams.PARSER == null) {
                            AesCmacParams.PARSER = new DefaultInstanceBasedParser<AesCmacParams>(AesCmacParams.DEFAULT_INSTANCE);
                        }
                    }
                }
                return parser;
            }
            case 4: {
                return AesCmacParams.DEFAULT_INSTANCE;
            }
            case 3: {
                return GeneratedMessageLite.A(AesCmacParams.DEFAULT_INSTANCE, "\u0000\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0000\u0000\u0001\u000b", new Object[] { "tagSize_" });
            }
            case 2: {
                return new Builder((AesCmacParams$a)null);
            }
            case 1: {
                return new AesCmacParams();
            }
        }
    }
    
    public static final class Builder extends GeneratedMessageLite.Builder<AesCmacParams, Builder> implements AesCmacParamsOrBuilder
    {
        private Builder() {
            super(AesCmacParams.J());
        }
        
        Builder(final AesCmacParams$a object) {
            this();
        }
        
        public Builder D(final int n) {
            ((GeneratedMessageLite.Builder)this).u();
            AesCmacParams.K((AesCmacParams)super.b, n);
            return this;
        }
    }
}
