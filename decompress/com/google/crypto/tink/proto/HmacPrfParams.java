// 
// Decompiled by Procyon v0.6.0
// 

package com.google.crypto.tink.proto;

import com.google.crypto.tink.shaded.protobuf.MessageLite;
import com.google.crypto.tink.shaded.protobuf.Parser;
import com.google.crypto.tink.shaded.protobuf.GeneratedMessageLite;

public final class HmacPrfParams extends GeneratedMessageLite<HmacPrfParams, Builder> implements HmacPrfParamsOrBuilder
{
    private static final HmacPrfParams DEFAULT_INSTANCE;
    public static final int HASH_FIELD_NUMBER = 1;
    private static volatile Parser<HmacPrfParams> PARSER;
    private int hash_;
    
    static {
        GeneratedMessageLite.H(HmacPrfParams.class, DEFAULT_INSTANCE = new HmacPrfParams());
    }
    
    private HmacPrfParams() {
    }
    
    static HmacPrfParams J() {
        return HmacPrfParams.DEFAULT_INSTANCE;
    }
    
    static void K(final HmacPrfParams hmacPrfParams, final HashType hashType) {
        hmacPrfParams.O(hashType);
    }
    
    public static HmacPrfParams L() {
        return HmacPrfParams.DEFAULT_INSTANCE;
    }
    
    public static Builder N() {
        return ((GeneratedMessageLite<GeneratedMessageLite, GeneratedMessageLite.Builder>)HmacPrfParams.DEFAULT_INSTANCE).n();
    }
    
    private void O(final HashType hashType) {
        this.hash_ = hashType.getNumber();
    }
    
    public HashType M() {
        HashType hashType;
        if ((hashType = HashType.forNumber(this.hash_)) == null) {
            hashType = HashType.UNRECOGNIZED;
        }
        return hashType;
    }
    
    @Override
    protected final Object q(final MethodToInvoke methodToInvoke, final Object o, final Object o2) {
        switch (HmacPrfParams$a.a[methodToInvoke.ordinal()]) {
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
                final Parser<HmacPrfParams> parser;
                if ((parser = HmacPrfParams.PARSER) == null) {
                    synchronized (HmacPrfParams.class) {
                        if (HmacPrfParams.PARSER == null) {
                            HmacPrfParams.PARSER = new DefaultInstanceBasedParser<HmacPrfParams>(HmacPrfParams.DEFAULT_INSTANCE);
                        }
                    }
                }
                return parser;
            }
            case 4: {
                return HmacPrfParams.DEFAULT_INSTANCE;
            }
            case 3: {
                return GeneratedMessageLite.A(HmacPrfParams.DEFAULT_INSTANCE, "\u0000\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0000\u0000\u0001\f", new Object[] { "hash_" });
            }
            case 2: {
                return new Builder((HmacPrfParams$a)null);
            }
            case 1: {
                return new HmacPrfParams();
            }
        }
    }
    
    public static final class Builder extends GeneratedMessageLite.Builder<HmacPrfParams, Builder> implements HmacPrfParamsOrBuilder
    {
        private Builder() {
            super(HmacPrfParams.J());
        }
        
        Builder(final HmacPrfParams$a object) {
            this();
        }
        
        public Builder D(final HashType hashType) {
            ((GeneratedMessageLite.Builder)this).u();
            HmacPrfParams.K((HmacPrfParams)super.b, hashType);
            return this;
        }
    }
}
