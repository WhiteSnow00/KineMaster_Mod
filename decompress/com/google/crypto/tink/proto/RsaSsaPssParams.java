// 
// Decompiled by Procyon v0.6.0
// 

package com.google.crypto.tink.proto;

import com.google.crypto.tink.shaded.protobuf.MessageLite;
import com.google.crypto.tink.shaded.protobuf.Parser;
import com.google.crypto.tink.shaded.protobuf.GeneratedMessageLite;

public final class RsaSsaPssParams extends GeneratedMessageLite<RsaSsaPssParams, Builder> implements RsaSsaPssParamsOrBuilder
{
    private static final RsaSsaPssParams DEFAULT_INSTANCE;
    public static final int MGF1_HASH_FIELD_NUMBER = 2;
    private static volatile Parser<RsaSsaPssParams> PARSER;
    public static final int SALT_LENGTH_FIELD_NUMBER = 3;
    public static final int SIG_HASH_FIELD_NUMBER = 1;
    private int mgf1Hash_;
    private int saltLength_;
    private int sigHash_;
    
    static {
        GeneratedMessageLite.H(RsaSsaPssParams.class, DEFAULT_INSTANCE = new RsaSsaPssParams());
    }
    
    private RsaSsaPssParams() {
    }
    
    static RsaSsaPssParams J() {
        return RsaSsaPssParams.DEFAULT_INSTANCE;
    }
    
    static void K(final RsaSsaPssParams rsaSsaPssParams, final HashType hashType) {
        rsaSsaPssParams.U(hashType);
    }
    
    static void L(final RsaSsaPssParams rsaSsaPssParams, final HashType hashType) {
        rsaSsaPssParams.S(hashType);
    }
    
    static void M(final RsaSsaPssParams rsaSsaPssParams, final int n) {
        rsaSsaPssParams.T(n);
    }
    
    public static RsaSsaPssParams N() {
        return RsaSsaPssParams.DEFAULT_INSTANCE;
    }
    
    public static Builder R() {
        return ((GeneratedMessageLite<GeneratedMessageLite, GeneratedMessageLite.Builder>)RsaSsaPssParams.DEFAULT_INSTANCE).n();
    }
    
    private void S(final HashType hashType) {
        this.mgf1Hash_ = hashType.getNumber();
    }
    
    private void T(final int saltLength_) {
        this.saltLength_ = saltLength_;
    }
    
    private void U(final HashType hashType) {
        this.sigHash_ = hashType.getNumber();
    }
    
    public HashType O() {
        HashType hashType;
        if ((hashType = HashType.forNumber(this.mgf1Hash_)) == null) {
            hashType = HashType.UNRECOGNIZED;
        }
        return hashType;
    }
    
    public int P() {
        return this.saltLength_;
    }
    
    public HashType Q() {
        HashType hashType;
        if ((hashType = HashType.forNumber(this.sigHash_)) == null) {
            hashType = HashType.UNRECOGNIZED;
        }
        return hashType;
    }
    
    @Override
    protected final Object q(final MethodToInvoke methodToInvoke, final Object o, final Object o2) {
        switch (RsaSsaPssParams$a.a[methodToInvoke.ordinal()]) {
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
                final Parser<RsaSsaPssParams> parser;
                if ((parser = RsaSsaPssParams.PARSER) == null) {
                    synchronized (RsaSsaPssParams.class) {
                        if (RsaSsaPssParams.PARSER == null) {
                            RsaSsaPssParams.PARSER = new DefaultInstanceBasedParser<RsaSsaPssParams>(RsaSsaPssParams.DEFAULT_INSTANCE);
                        }
                    }
                }
                return parser;
            }
            case 4: {
                return RsaSsaPssParams.DEFAULT_INSTANCE;
            }
            case 3: {
                return GeneratedMessageLite.A(RsaSsaPssParams.DEFAULT_INSTANCE, "\u0000\u0003\u0000\u0000\u0001\u0003\u0003\u0000\u0000\u0000\u0001\f\u0002\f\u0003\u0004", new Object[] { "sigHash_", "mgf1Hash_", "saltLength_" });
            }
            case 2: {
                return new Builder((RsaSsaPssParams$a)null);
            }
            case 1: {
                return new RsaSsaPssParams();
            }
        }
    }
    
    public static final class Builder extends GeneratedMessageLite.Builder<RsaSsaPssParams, Builder> implements RsaSsaPssParamsOrBuilder
    {
        private Builder() {
            super(RsaSsaPssParams.J());
        }
        
        Builder(final RsaSsaPssParams$a object) {
            this();
        }
        
        public Builder D(final HashType hashType) {
            ((GeneratedMessageLite.Builder)this).u();
            RsaSsaPssParams.L((RsaSsaPssParams)super.b, hashType);
            return this;
        }
        
        public Builder E(final int n) {
            ((GeneratedMessageLite.Builder)this).u();
            RsaSsaPssParams.M((RsaSsaPssParams)super.b, n);
            return this;
        }
        
        public Builder F(final HashType hashType) {
            ((GeneratedMessageLite.Builder)this).u();
            RsaSsaPssParams.K((RsaSsaPssParams)super.b, hashType);
            return this;
        }
    }
}
