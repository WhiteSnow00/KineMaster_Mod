// 
// Decompiled by Procyon v0.6.0
// 

package com.google.crypto.tink.proto;

import com.google.crypto.tink.shaded.protobuf.MessageLite;
import com.google.crypto.tink.shaded.protobuf.ByteString;
import com.google.crypto.tink.shaded.protobuf.Parser;
import com.google.crypto.tink.shaded.protobuf.GeneratedMessageLite;

public final class EciesHkdfKemParams extends GeneratedMessageLite<EciesHkdfKemParams, Builder> implements EciesHkdfKemParamsOrBuilder
{
    public static final int CURVE_TYPE_FIELD_NUMBER = 1;
    private static final EciesHkdfKemParams DEFAULT_INSTANCE;
    public static final int HKDF_HASH_TYPE_FIELD_NUMBER = 2;
    public static final int HKDF_SALT_FIELD_NUMBER = 11;
    private static volatile Parser<EciesHkdfKemParams> PARSER;
    private int curveType_;
    private int hkdfHashType_;
    private ByteString hkdfSalt_;
    
    static {
        GeneratedMessageLite.H(EciesHkdfKemParams.class, DEFAULT_INSTANCE = new EciesHkdfKemParams());
    }
    
    private EciesHkdfKemParams() {
        this.hkdfSalt_ = ByteString.EMPTY;
    }
    
    static EciesHkdfKemParams J() {
        return EciesHkdfKemParams.DEFAULT_INSTANCE;
    }
    
    static void K(final EciesHkdfKemParams eciesHkdfKemParams, final EllipticCurveType ellipticCurveType) {
        eciesHkdfKemParams.S(ellipticCurveType);
    }
    
    static void L(final EciesHkdfKemParams eciesHkdfKemParams, final HashType hashType) {
        eciesHkdfKemParams.T(hashType);
    }
    
    static void M(final EciesHkdfKemParams eciesHkdfKemParams, final ByteString byteString) {
        eciesHkdfKemParams.U(byteString);
    }
    
    public static EciesHkdfKemParams O() {
        return EciesHkdfKemParams.DEFAULT_INSTANCE;
    }
    
    public static Builder R() {
        return ((GeneratedMessageLite<GeneratedMessageLite, GeneratedMessageLite.Builder>)EciesHkdfKemParams.DEFAULT_INSTANCE).n();
    }
    
    private void S(final EllipticCurveType ellipticCurveType) {
        this.curveType_ = ellipticCurveType.getNumber();
    }
    
    private void T(final HashType hashType) {
        this.hkdfHashType_ = hashType.getNumber();
    }
    
    private void U(final ByteString hkdfSalt_) {
        hkdfSalt_.getClass();
        this.hkdfSalt_ = hkdfSalt_;
    }
    
    public EllipticCurveType N() {
        EllipticCurveType ellipticCurveType;
        if ((ellipticCurveType = EllipticCurveType.forNumber(this.curveType_)) == null) {
            ellipticCurveType = EllipticCurveType.UNRECOGNIZED;
        }
        return ellipticCurveType;
    }
    
    public HashType P() {
        HashType hashType;
        if ((hashType = HashType.forNumber(this.hkdfHashType_)) == null) {
            hashType = HashType.UNRECOGNIZED;
        }
        return hashType;
    }
    
    public ByteString Q() {
        return this.hkdfSalt_;
    }
    
    @Override
    protected final Object q(final MethodToInvoke methodToInvoke, final Object o, final Object o2) {
        switch (EciesHkdfKemParams$a.a[methodToInvoke.ordinal()]) {
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
                final Parser<EciesHkdfKemParams> parser;
                if ((parser = EciesHkdfKemParams.PARSER) == null) {
                    synchronized (EciesHkdfKemParams.class) {
                        if (EciesHkdfKemParams.PARSER == null) {
                            EciesHkdfKemParams.PARSER = new DefaultInstanceBasedParser<EciesHkdfKemParams>(EciesHkdfKemParams.DEFAULT_INSTANCE);
                        }
                    }
                }
                return parser;
            }
            case 4: {
                return EciesHkdfKemParams.DEFAULT_INSTANCE;
            }
            case 3: {
                return GeneratedMessageLite.A(EciesHkdfKemParams.DEFAULT_INSTANCE, "\u0000\u0003\u0000\u0000\u0001\u000b\u0003\u0000\u0000\u0000\u0001\f\u0002\f\u000b\n", new Object[] { "curveType_", "hkdfHashType_", "hkdfSalt_" });
            }
            case 2: {
                return new Builder((EciesHkdfKemParams$a)null);
            }
            case 1: {
                return new EciesHkdfKemParams();
            }
        }
    }
    
    public static final class Builder extends GeneratedMessageLite.Builder<EciesHkdfKemParams, Builder> implements EciesHkdfKemParamsOrBuilder
    {
        private Builder() {
            super(EciesHkdfKemParams.J());
        }
        
        Builder(final EciesHkdfKemParams$a object) {
            this();
        }
        
        public Builder D(final EllipticCurveType ellipticCurveType) {
            ((GeneratedMessageLite.Builder)this).u();
            EciesHkdfKemParams.K((EciesHkdfKemParams)super.b, ellipticCurveType);
            return this;
        }
        
        public Builder E(final HashType hashType) {
            ((GeneratedMessageLite.Builder)this).u();
            EciesHkdfKemParams.L((EciesHkdfKemParams)super.b, hashType);
            return this;
        }
        
        public Builder F(final ByteString byteString) {
            ((GeneratedMessageLite.Builder)this).u();
            EciesHkdfKemParams.M((EciesHkdfKemParams)super.b, byteString);
            return this;
        }
    }
}
