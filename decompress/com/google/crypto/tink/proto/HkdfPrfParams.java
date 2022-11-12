// 
// Decompiled by Procyon v0.6.0
// 

package com.google.crypto.tink.proto;

import com.google.crypto.tink.shaded.protobuf.MessageLite;
import com.google.crypto.tink.shaded.protobuf.ByteString;
import com.google.crypto.tink.shaded.protobuf.Parser;
import com.google.crypto.tink.shaded.protobuf.GeneratedMessageLite;

public final class HkdfPrfParams extends GeneratedMessageLite<HkdfPrfParams, Builder> implements HkdfPrfParamsOrBuilder
{
    private static final HkdfPrfParams DEFAULT_INSTANCE;
    public static final int HASH_FIELD_NUMBER = 1;
    private static volatile Parser<HkdfPrfParams> PARSER;
    public static final int SALT_FIELD_NUMBER = 2;
    private int hash_;
    private ByteString salt_;
    
    static {
        GeneratedMessageLite.H(HkdfPrfParams.class, DEFAULT_INSTANCE = new HkdfPrfParams());
    }
    
    private HkdfPrfParams() {
        this.salt_ = ByteString.EMPTY;
    }
    
    static HkdfPrfParams J() {
        return HkdfPrfParams.DEFAULT_INSTANCE;
    }
    
    static void K(final HkdfPrfParams hkdfPrfParams, final HashType hashType) {
        hkdfPrfParams.P(hashType);
    }
    
    public static HkdfPrfParams L() {
        return HkdfPrfParams.DEFAULT_INSTANCE;
    }
    
    public static Builder O() {
        return ((GeneratedMessageLite<GeneratedMessageLite, GeneratedMessageLite.Builder>)HkdfPrfParams.DEFAULT_INSTANCE).n();
    }
    
    private void P(final HashType hashType) {
        this.hash_ = hashType.getNumber();
    }
    
    public HashType M() {
        HashType hashType;
        if ((hashType = HashType.forNumber(this.hash_)) == null) {
            hashType = HashType.UNRECOGNIZED;
        }
        return hashType;
    }
    
    public ByteString N() {
        return this.salt_;
    }
    
    @Override
    protected final Object q(final MethodToInvoke methodToInvoke, final Object o, final Object o2) {
        switch (HkdfPrfParams$a.a[methodToInvoke.ordinal()]) {
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
                final Parser<HkdfPrfParams> parser;
                if ((parser = HkdfPrfParams.PARSER) == null) {
                    synchronized (HkdfPrfParams.class) {
                        if (HkdfPrfParams.PARSER == null) {
                            HkdfPrfParams.PARSER = new DefaultInstanceBasedParser<HkdfPrfParams>(HkdfPrfParams.DEFAULT_INSTANCE);
                        }
                    }
                }
                return parser;
            }
            case 4: {
                return HkdfPrfParams.DEFAULT_INSTANCE;
            }
            case 3: {
                return GeneratedMessageLite.A(HkdfPrfParams.DEFAULT_INSTANCE, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0000\u0000\u0001\f\u0002\n", new Object[] { "hash_", "salt_" });
            }
            case 2: {
                return new Builder((HkdfPrfParams$a)null);
            }
            case 1: {
                return new HkdfPrfParams();
            }
        }
    }
    
    public static final class Builder extends GeneratedMessageLite.Builder<HkdfPrfParams, Builder> implements HkdfPrfParamsOrBuilder
    {
        private Builder() {
            super(HkdfPrfParams.J());
        }
        
        Builder(final HkdfPrfParams$a object) {
            this();
        }
        
        public Builder D(final HashType hashType) {
            ((GeneratedMessageLite.Builder)this).u();
            HkdfPrfParams.K((HkdfPrfParams)super.b, hashType);
            return this;
        }
    }
}
