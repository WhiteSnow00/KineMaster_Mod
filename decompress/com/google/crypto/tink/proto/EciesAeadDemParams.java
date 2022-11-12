// 
// Decompiled by Procyon v0.6.0
// 

package com.google.crypto.tink.proto;

import com.google.crypto.tink.shaded.protobuf.MessageLite;
import com.google.crypto.tink.shaded.protobuf.Parser;
import com.google.crypto.tink.shaded.protobuf.GeneratedMessageLite;

public final class EciesAeadDemParams extends GeneratedMessageLite<EciesAeadDemParams, Builder> implements EciesAeadDemParamsOrBuilder
{
    public static final int AEAD_DEM_FIELD_NUMBER = 2;
    private static final EciesAeadDemParams DEFAULT_INSTANCE;
    private static volatile Parser<EciesAeadDemParams> PARSER;
    private KeyTemplate aeadDem_;
    
    static {
        GeneratedMessageLite.H(EciesAeadDemParams.class, DEFAULT_INSTANCE = new EciesAeadDemParams());
    }
    
    private EciesAeadDemParams() {
    }
    
    static EciesAeadDemParams J() {
        return EciesAeadDemParams.DEFAULT_INSTANCE;
    }
    
    static void K(final EciesAeadDemParams eciesAeadDemParams, final KeyTemplate keyTemplate) {
        eciesAeadDemParams.O(keyTemplate);
    }
    
    public static EciesAeadDemParams M() {
        return EciesAeadDemParams.DEFAULT_INSTANCE;
    }
    
    public static Builder N() {
        return ((GeneratedMessageLite<GeneratedMessageLite, GeneratedMessageLite.Builder>)EciesAeadDemParams.DEFAULT_INSTANCE).n();
    }
    
    private void O(final KeyTemplate aeadDem_) {
        aeadDem_.getClass();
        this.aeadDem_ = aeadDem_;
    }
    
    public KeyTemplate L() {
        KeyTemplate keyTemplate;
        if ((keyTemplate = this.aeadDem_) == null) {
            keyTemplate = KeyTemplate.N();
        }
        return keyTemplate;
    }
    
    @Override
    protected final Object q(final MethodToInvoke methodToInvoke, final Object o, final Object o2) {
        switch (EciesAeadDemParams$a.a[methodToInvoke.ordinal()]) {
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
                final Parser<EciesAeadDemParams> parser;
                if ((parser = EciesAeadDemParams.PARSER) == null) {
                    synchronized (EciesAeadDemParams.class) {
                        if (EciesAeadDemParams.PARSER == null) {
                            EciesAeadDemParams.PARSER = new DefaultInstanceBasedParser<EciesAeadDemParams>(EciesAeadDemParams.DEFAULT_INSTANCE);
                        }
                    }
                }
                return parser;
            }
            case 4: {
                return EciesAeadDemParams.DEFAULT_INSTANCE;
            }
            case 3: {
                return GeneratedMessageLite.A(EciesAeadDemParams.DEFAULT_INSTANCE, "\u0000\u0001\u0000\u0000\u0002\u0002\u0001\u0000\u0000\u0000\u0002\t", new Object[] { "aeadDem_" });
            }
            case 2: {
                return new Builder((EciesAeadDemParams$a)null);
            }
            case 1: {
                return new EciesAeadDemParams();
            }
        }
    }
    
    public static final class Builder extends GeneratedMessageLite.Builder<EciesAeadDemParams, Builder> implements EciesAeadDemParamsOrBuilder
    {
        private Builder() {
            super(EciesAeadDemParams.J());
        }
        
        Builder(final EciesAeadDemParams$a object) {
            this();
        }
        
        public Builder D(final KeyTemplate keyTemplate) {
            ((GeneratedMessageLite.Builder)this).u();
            EciesAeadDemParams.K((EciesAeadDemParams)super.b, keyTemplate);
            return this;
        }
    }
}
