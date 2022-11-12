// 
// Decompiled by Procyon v0.6.0
// 

package com.google.crypto.tink.proto;

import com.google.crypto.tink.shaded.protobuf.MessageLite;
import com.google.crypto.tink.shaded.protobuf.Parser;
import com.google.crypto.tink.shaded.protobuf.GeneratedMessageLite;

public final class HmacParams extends GeneratedMessageLite<HmacParams, Builder> implements HmacParamsOrBuilder
{
    private static final HmacParams DEFAULT_INSTANCE;
    public static final int HASH_FIELD_NUMBER = 1;
    private static volatile Parser<HmacParams> PARSER;
    public static final int TAG_SIZE_FIELD_NUMBER = 2;
    private int hash_;
    private int tagSize_;
    
    static {
        GeneratedMessageLite.H(HmacParams.class, DEFAULT_INSTANCE = new HmacParams());
    }
    
    private HmacParams() {
    }
    
    static HmacParams J() {
        return HmacParams.DEFAULT_INSTANCE;
    }
    
    static void K(final HmacParams hmacParams, final HashType hashType) {
        hmacParams.Q(hashType);
    }
    
    static void L(final HmacParams hmacParams, final int n) {
        hmacParams.R(n);
    }
    
    public static HmacParams M() {
        return HmacParams.DEFAULT_INSTANCE;
    }
    
    public static Builder P() {
        return ((GeneratedMessageLite<GeneratedMessageLite, GeneratedMessageLite.Builder>)HmacParams.DEFAULT_INSTANCE).n();
    }
    
    private void Q(final HashType hashType) {
        this.hash_ = hashType.getNumber();
    }
    
    private void R(final int tagSize_) {
        this.tagSize_ = tagSize_;
    }
    
    public HashType N() {
        HashType hashType;
        if ((hashType = HashType.forNumber(this.hash_)) == null) {
            hashType = HashType.UNRECOGNIZED;
        }
        return hashType;
    }
    
    public int O() {
        return this.tagSize_;
    }
    
    @Override
    protected final Object q(final MethodToInvoke methodToInvoke, final Object o, final Object o2) {
        switch (HmacParams$a.a[methodToInvoke.ordinal()]) {
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
                final Parser<HmacParams> parser;
                if ((parser = HmacParams.PARSER) == null) {
                    synchronized (HmacParams.class) {
                        if (HmacParams.PARSER == null) {
                            HmacParams.PARSER = new DefaultInstanceBasedParser<HmacParams>(HmacParams.DEFAULT_INSTANCE);
                        }
                    }
                }
                return parser;
            }
            case 4: {
                return HmacParams.DEFAULT_INSTANCE;
            }
            case 3: {
                return GeneratedMessageLite.A(HmacParams.DEFAULT_INSTANCE, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0000\u0000\u0001\f\u0002\u000b", new Object[] { "hash_", "tagSize_" });
            }
            case 2: {
                return new Builder((HmacParams$a)null);
            }
            case 1: {
                return new HmacParams();
            }
        }
    }
    
    public static final class Builder extends GeneratedMessageLite.Builder<HmacParams, Builder> implements HmacParamsOrBuilder
    {
        private Builder() {
            super(HmacParams.J());
        }
        
        Builder(final HmacParams$a object) {
            this();
        }
        
        public Builder D(final HashType hashType) {
            ((GeneratedMessageLite.Builder)this).u();
            HmacParams.K((HmacParams)super.b, hashType);
            return this;
        }
        
        public Builder E(final int n) {
            ((GeneratedMessageLite.Builder)this).u();
            HmacParams.L((HmacParams)super.b, n);
            return this;
        }
    }
}
