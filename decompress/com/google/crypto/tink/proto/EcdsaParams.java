// 
// Decompiled by Procyon v0.6.0
// 

package com.google.crypto.tink.proto;

import com.google.crypto.tink.shaded.protobuf.MessageLite;
import com.google.crypto.tink.shaded.protobuf.Parser;
import com.google.crypto.tink.shaded.protobuf.GeneratedMessageLite;

public final class EcdsaParams extends GeneratedMessageLite<EcdsaParams, Builder> implements EcdsaParamsOrBuilder
{
    public static final int CURVE_FIELD_NUMBER = 2;
    private static final EcdsaParams DEFAULT_INSTANCE;
    public static final int ENCODING_FIELD_NUMBER = 3;
    public static final int HASH_TYPE_FIELD_NUMBER = 1;
    private static volatile Parser<EcdsaParams> PARSER;
    private int curve_;
    private int encoding_;
    private int hashType_;
    
    static {
        GeneratedMessageLite.H(EcdsaParams.class, DEFAULT_INSTANCE = new EcdsaParams());
    }
    
    private EcdsaParams() {
    }
    
    static EcdsaParams J() {
        return EcdsaParams.DEFAULT_INSTANCE;
    }
    
    static void K(final EcdsaParams ecdsaParams, final HashType hashType) {
        ecdsaParams.U(hashType);
    }
    
    static void L(final EcdsaParams ecdsaParams, final EllipticCurveType ellipticCurveType) {
        ecdsaParams.S(ellipticCurveType);
    }
    
    static void M(final EcdsaParams ecdsaParams, final EcdsaSignatureEncoding ecdsaSignatureEncoding) {
        ecdsaParams.T(ecdsaSignatureEncoding);
    }
    
    public static EcdsaParams O() {
        return EcdsaParams.DEFAULT_INSTANCE;
    }
    
    public static Builder R() {
        return ((GeneratedMessageLite<GeneratedMessageLite, GeneratedMessageLite.Builder>)EcdsaParams.DEFAULT_INSTANCE).n();
    }
    
    private void S(final EllipticCurveType ellipticCurveType) {
        this.curve_ = ellipticCurveType.getNumber();
    }
    
    private void T(final EcdsaSignatureEncoding ecdsaSignatureEncoding) {
        this.encoding_ = ecdsaSignatureEncoding.getNumber();
    }
    
    private void U(final HashType hashType) {
        this.hashType_ = hashType.getNumber();
    }
    
    public EllipticCurveType N() {
        EllipticCurveType ellipticCurveType;
        if ((ellipticCurveType = EllipticCurveType.forNumber(this.curve_)) == null) {
            ellipticCurveType = EllipticCurveType.UNRECOGNIZED;
        }
        return ellipticCurveType;
    }
    
    public EcdsaSignatureEncoding P() {
        EcdsaSignatureEncoding ecdsaSignatureEncoding;
        if ((ecdsaSignatureEncoding = EcdsaSignatureEncoding.forNumber(this.encoding_)) == null) {
            ecdsaSignatureEncoding = EcdsaSignatureEncoding.UNRECOGNIZED;
        }
        return ecdsaSignatureEncoding;
    }
    
    public HashType Q() {
        HashType hashType;
        if ((hashType = HashType.forNumber(this.hashType_)) == null) {
            hashType = HashType.UNRECOGNIZED;
        }
        return hashType;
    }
    
    @Override
    protected final Object q(final MethodToInvoke methodToInvoke, final Object o, final Object o2) {
        switch (EcdsaParams$a.a[methodToInvoke.ordinal()]) {
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
                final Parser<EcdsaParams> parser;
                if ((parser = EcdsaParams.PARSER) == null) {
                    synchronized (EcdsaParams.class) {
                        if (EcdsaParams.PARSER == null) {
                            EcdsaParams.PARSER = new DefaultInstanceBasedParser<EcdsaParams>(EcdsaParams.DEFAULT_INSTANCE);
                        }
                    }
                }
                return parser;
            }
            case 4: {
                return EcdsaParams.DEFAULT_INSTANCE;
            }
            case 3: {
                return GeneratedMessageLite.A(EcdsaParams.DEFAULT_INSTANCE, "\u0000\u0003\u0000\u0000\u0001\u0003\u0003\u0000\u0000\u0000\u0001\f\u0002\f\u0003\f", new Object[] { "hashType_", "curve_", "encoding_" });
            }
            case 2: {
                return new Builder((EcdsaParams$a)null);
            }
            case 1: {
                return new EcdsaParams();
            }
        }
    }
    
    public static final class Builder extends GeneratedMessageLite.Builder<EcdsaParams, Builder> implements EcdsaParamsOrBuilder
    {
        private Builder() {
            super(EcdsaParams.J());
        }
        
        Builder(final EcdsaParams$a object) {
            this();
        }
        
        public Builder D(final EllipticCurveType ellipticCurveType) {
            ((GeneratedMessageLite.Builder)this).u();
            EcdsaParams.L((EcdsaParams)super.b, ellipticCurveType);
            return this;
        }
        
        public Builder E(final EcdsaSignatureEncoding ecdsaSignatureEncoding) {
            ((GeneratedMessageLite.Builder)this).u();
            EcdsaParams.M((EcdsaParams)super.b, ecdsaSignatureEncoding);
            return this;
        }
        
        public Builder F(final HashType hashType) {
            ((GeneratedMessageLite.Builder)this).u();
            EcdsaParams.K((EcdsaParams)super.b, hashType);
            return this;
        }
    }
}
