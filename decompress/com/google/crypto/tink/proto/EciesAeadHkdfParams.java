// 
// Decompiled by Procyon v0.6.0
// 

package com.google.crypto.tink.proto;

import com.google.crypto.tink.shaded.protobuf.MessageLite;
import com.google.crypto.tink.shaded.protobuf.Parser;
import com.google.crypto.tink.shaded.protobuf.GeneratedMessageLite;

public final class EciesAeadHkdfParams extends GeneratedMessageLite<EciesAeadHkdfParams, Builder> implements EciesAeadHkdfParamsOrBuilder
{
    private static final EciesAeadHkdfParams DEFAULT_INSTANCE;
    public static final int DEM_PARAMS_FIELD_NUMBER = 2;
    public static final int EC_POINT_FORMAT_FIELD_NUMBER = 3;
    public static final int KEM_PARAMS_FIELD_NUMBER = 1;
    private static volatile Parser<EciesAeadHkdfParams> PARSER;
    private EciesAeadDemParams demParams_;
    private int ecPointFormat_;
    private EciesHkdfKemParams kemParams_;
    
    static {
        GeneratedMessageLite.H(EciesAeadHkdfParams.class, DEFAULT_INSTANCE = new EciesAeadHkdfParams());
    }
    
    private EciesAeadHkdfParams() {
    }
    
    static EciesAeadHkdfParams J() {
        return EciesAeadHkdfParams.DEFAULT_INSTANCE;
    }
    
    static void K(final EciesAeadHkdfParams eciesAeadHkdfParams, final EciesHkdfKemParams eciesHkdfKemParams) {
        eciesAeadHkdfParams.U(eciesHkdfKemParams);
    }
    
    static void L(final EciesAeadHkdfParams eciesAeadHkdfParams, final EciesAeadDemParams eciesAeadDemParams) {
        eciesAeadHkdfParams.S(eciesAeadDemParams);
    }
    
    static void M(final EciesAeadHkdfParams eciesAeadHkdfParams, final EcPointFormat ecPointFormat) {
        eciesAeadHkdfParams.T(ecPointFormat);
    }
    
    public static EciesAeadHkdfParams N() {
        return EciesAeadHkdfParams.DEFAULT_INSTANCE;
    }
    
    public static Builder R() {
        return ((GeneratedMessageLite<GeneratedMessageLite, GeneratedMessageLite.Builder>)EciesAeadHkdfParams.DEFAULT_INSTANCE).n();
    }
    
    private void S(final EciesAeadDemParams demParams_) {
        demParams_.getClass();
        this.demParams_ = demParams_;
    }
    
    private void T(final EcPointFormat ecPointFormat) {
        this.ecPointFormat_ = ecPointFormat.getNumber();
    }
    
    private void U(final EciesHkdfKemParams kemParams_) {
        kemParams_.getClass();
        this.kemParams_ = kemParams_;
    }
    
    public EciesAeadDemParams O() {
        EciesAeadDemParams eciesAeadDemParams;
        if ((eciesAeadDemParams = this.demParams_) == null) {
            eciesAeadDemParams = EciesAeadDemParams.M();
        }
        return eciesAeadDemParams;
    }
    
    public EcPointFormat P() {
        EcPointFormat ecPointFormat;
        if ((ecPointFormat = EcPointFormat.forNumber(this.ecPointFormat_)) == null) {
            ecPointFormat = EcPointFormat.UNRECOGNIZED;
        }
        return ecPointFormat;
    }
    
    public EciesHkdfKemParams Q() {
        EciesHkdfKemParams eciesHkdfKemParams;
        if ((eciesHkdfKemParams = this.kemParams_) == null) {
            eciesHkdfKemParams = EciesHkdfKemParams.O();
        }
        return eciesHkdfKemParams;
    }
    
    @Override
    protected final Object q(final MethodToInvoke methodToInvoke, final Object o, final Object o2) {
        switch (EciesAeadHkdfParams$a.a[methodToInvoke.ordinal()]) {
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
                final Parser<EciesAeadHkdfParams> parser;
                if ((parser = EciesAeadHkdfParams.PARSER) == null) {
                    synchronized (EciesAeadHkdfParams.class) {
                        if (EciesAeadHkdfParams.PARSER == null) {
                            EciesAeadHkdfParams.PARSER = new DefaultInstanceBasedParser<EciesAeadHkdfParams>(EciesAeadHkdfParams.DEFAULT_INSTANCE);
                        }
                    }
                }
                return parser;
            }
            case 4: {
                return EciesAeadHkdfParams.DEFAULT_INSTANCE;
            }
            case 3: {
                return GeneratedMessageLite.A(EciesAeadHkdfParams.DEFAULT_INSTANCE, "\u0000\u0003\u0000\u0000\u0001\u0003\u0003\u0000\u0000\u0000\u0001\t\u0002\t\u0003\f", new Object[] { "kemParams_", "demParams_", "ecPointFormat_" });
            }
            case 2: {
                return new Builder((EciesAeadHkdfParams$a)null);
            }
            case 1: {
                return new EciesAeadHkdfParams();
            }
        }
    }
    
    public static final class Builder extends GeneratedMessageLite.Builder<EciesAeadHkdfParams, Builder> implements EciesAeadHkdfParamsOrBuilder
    {
        private Builder() {
            super(EciesAeadHkdfParams.J());
        }
        
        Builder(final EciesAeadHkdfParams$a object) {
            this();
        }
        
        public Builder D(final EciesAeadDemParams eciesAeadDemParams) {
            ((GeneratedMessageLite.Builder)this).u();
            EciesAeadHkdfParams.L((EciesAeadHkdfParams)super.b, eciesAeadDemParams);
            return this;
        }
        
        public Builder E(final EcPointFormat ecPointFormat) {
            ((GeneratedMessageLite.Builder)this).u();
            EciesAeadHkdfParams.M((EciesAeadHkdfParams)super.b, ecPointFormat);
            return this;
        }
        
        public Builder F(final EciesHkdfKemParams eciesHkdfKemParams) {
            ((GeneratedMessageLite.Builder)this).u();
            EciesAeadHkdfParams.K((EciesAeadHkdfParams)super.b, eciesHkdfKemParams);
            return this;
        }
    }
}
