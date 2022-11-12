// 
// Decompiled by Procyon v0.6.0
// 

package com.google.crypto.tink.proto;

import com.google.crypto.tink.shaded.protobuf.MessageLite;
import com.google.crypto.tink.shaded.protobuf.Parser;
import com.google.crypto.tink.shaded.protobuf.GeneratedMessageLite;

public final class RsaSsaPkcs1Params extends GeneratedMessageLite<RsaSsaPkcs1Params, Builder> implements RsaSsaPkcs1ParamsOrBuilder
{
    private static final RsaSsaPkcs1Params DEFAULT_INSTANCE;
    public static final int HASH_TYPE_FIELD_NUMBER = 1;
    private static volatile Parser<RsaSsaPkcs1Params> PARSER;
    private int hashType_;
    
    static {
        GeneratedMessageLite.H(RsaSsaPkcs1Params.class, DEFAULT_INSTANCE = new RsaSsaPkcs1Params());
    }
    
    private RsaSsaPkcs1Params() {
    }
    
    static RsaSsaPkcs1Params J() {
        return RsaSsaPkcs1Params.DEFAULT_INSTANCE;
    }
    
    static void K(final RsaSsaPkcs1Params rsaSsaPkcs1Params, final HashType hashType) {
        rsaSsaPkcs1Params.O(hashType);
    }
    
    public static RsaSsaPkcs1Params L() {
        return RsaSsaPkcs1Params.DEFAULT_INSTANCE;
    }
    
    public static Builder N() {
        return ((GeneratedMessageLite<GeneratedMessageLite, GeneratedMessageLite.Builder>)RsaSsaPkcs1Params.DEFAULT_INSTANCE).n();
    }
    
    private void O(final HashType hashType) {
        this.hashType_ = hashType.getNumber();
    }
    
    public HashType M() {
        HashType hashType;
        if ((hashType = HashType.forNumber(this.hashType_)) == null) {
            hashType = HashType.UNRECOGNIZED;
        }
        return hashType;
    }
    
    @Override
    protected final Object q(final MethodToInvoke methodToInvoke, final Object o, final Object o2) {
        switch (RsaSsaPkcs1Params$a.a[methodToInvoke.ordinal()]) {
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
                final Parser<RsaSsaPkcs1Params> parser;
                if ((parser = RsaSsaPkcs1Params.PARSER) == null) {
                    synchronized (RsaSsaPkcs1Params.class) {
                        if (RsaSsaPkcs1Params.PARSER == null) {
                            RsaSsaPkcs1Params.PARSER = new DefaultInstanceBasedParser<RsaSsaPkcs1Params>(RsaSsaPkcs1Params.DEFAULT_INSTANCE);
                        }
                    }
                }
                return parser;
            }
            case 4: {
                return RsaSsaPkcs1Params.DEFAULT_INSTANCE;
            }
            case 3: {
                return GeneratedMessageLite.A(RsaSsaPkcs1Params.DEFAULT_INSTANCE, "\u0000\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0000\u0000\u0001\f", new Object[] { "hashType_" });
            }
            case 2: {
                return new Builder((RsaSsaPkcs1Params$a)null);
            }
            case 1: {
                return new RsaSsaPkcs1Params();
            }
        }
    }
    
    public static final class Builder extends GeneratedMessageLite.Builder<RsaSsaPkcs1Params, Builder> implements RsaSsaPkcs1ParamsOrBuilder
    {
        private Builder() {
            super(RsaSsaPkcs1Params.J());
        }
        
        Builder(final RsaSsaPkcs1Params$a object) {
            this();
        }
        
        public Builder D(final HashType hashType) {
            ((GeneratedMessageLite.Builder)this).u();
            RsaSsaPkcs1Params.K((RsaSsaPkcs1Params)super.b, hashType);
            return this;
        }
    }
}
