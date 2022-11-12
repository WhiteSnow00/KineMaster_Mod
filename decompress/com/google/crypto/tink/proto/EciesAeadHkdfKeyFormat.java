// 
// Decompiled by Procyon v0.6.0
// 

package com.google.crypto.tink.proto;

import com.google.crypto.tink.shaded.protobuf.MessageLite;
import com.google.crypto.tink.shaded.protobuf.InvalidProtocolBufferException;
import com.google.crypto.tink.shaded.protobuf.ExtensionRegistryLite;
import com.google.crypto.tink.shaded.protobuf.ByteString;
import com.google.crypto.tink.shaded.protobuf.Parser;
import com.google.crypto.tink.shaded.protobuf.GeneratedMessageLite;

public final class EciesAeadHkdfKeyFormat extends GeneratedMessageLite<EciesAeadHkdfKeyFormat, Builder> implements EciesAeadHkdfKeyFormatOrBuilder
{
    private static final EciesAeadHkdfKeyFormat DEFAULT_INSTANCE;
    public static final int PARAMS_FIELD_NUMBER = 1;
    private static volatile Parser<EciesAeadHkdfKeyFormat> PARSER;
    private EciesAeadHkdfParams params_;
    
    static {
        GeneratedMessageLite.H(EciesAeadHkdfKeyFormat.class, DEFAULT_INSTANCE = new EciesAeadHkdfKeyFormat());
    }
    
    private EciesAeadHkdfKeyFormat() {
    }
    
    static EciesAeadHkdfKeyFormat J() {
        return EciesAeadHkdfKeyFormat.DEFAULT_INSTANCE;
    }
    
    static void K(final EciesAeadHkdfKeyFormat eciesAeadHkdfKeyFormat, final EciesAeadHkdfParams eciesAeadHkdfParams) {
        eciesAeadHkdfKeyFormat.O(eciesAeadHkdfParams);
    }
    
    public static Builder M() {
        return ((GeneratedMessageLite<GeneratedMessageLite, GeneratedMessageLite.Builder>)EciesAeadHkdfKeyFormat.DEFAULT_INSTANCE).n();
    }
    
    public static EciesAeadHkdfKeyFormat N(final ByteString byteString, final ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return GeneratedMessageLite.B(EciesAeadHkdfKeyFormat.DEFAULT_INSTANCE, byteString, extensionRegistryLite);
    }
    
    private void O(final EciesAeadHkdfParams params_) {
        params_.getClass();
        this.params_ = params_;
    }
    
    public EciesAeadHkdfParams L() {
        EciesAeadHkdfParams eciesAeadHkdfParams;
        if ((eciesAeadHkdfParams = this.params_) == null) {
            eciesAeadHkdfParams = EciesAeadHkdfParams.N();
        }
        return eciesAeadHkdfParams;
    }
    
    @Override
    protected final Object q(final MethodToInvoke methodToInvoke, final Object o, final Object o2) {
        switch (EciesAeadHkdfKeyFormat$a.a[methodToInvoke.ordinal()]) {
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
                final Parser<EciesAeadHkdfKeyFormat> parser;
                if ((parser = EciesAeadHkdfKeyFormat.PARSER) == null) {
                    synchronized (EciesAeadHkdfKeyFormat.class) {
                        if (EciesAeadHkdfKeyFormat.PARSER == null) {
                            EciesAeadHkdfKeyFormat.PARSER = new DefaultInstanceBasedParser<EciesAeadHkdfKeyFormat>(EciesAeadHkdfKeyFormat.DEFAULT_INSTANCE);
                        }
                    }
                }
                return parser;
            }
            case 4: {
                return EciesAeadHkdfKeyFormat.DEFAULT_INSTANCE;
            }
            case 3: {
                return GeneratedMessageLite.A(EciesAeadHkdfKeyFormat.DEFAULT_INSTANCE, "\u0000\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0000\u0000\u0001\t", new Object[] { "params_" });
            }
            case 2: {
                return new Builder((EciesAeadHkdfKeyFormat$a)null);
            }
            case 1: {
                return new EciesAeadHkdfKeyFormat();
            }
        }
    }
    
    public static final class Builder extends GeneratedMessageLite.Builder<EciesAeadHkdfKeyFormat, Builder> implements EciesAeadHkdfKeyFormatOrBuilder
    {
        private Builder() {
            super(EciesAeadHkdfKeyFormat.J());
        }
        
        Builder(final EciesAeadHkdfKeyFormat$a object) {
            this();
        }
        
        public Builder D(final EciesAeadHkdfParams eciesAeadHkdfParams) {
            ((GeneratedMessageLite.Builder)this).u();
            EciesAeadHkdfKeyFormat.K((EciesAeadHkdfKeyFormat)super.b, eciesAeadHkdfParams);
            return this;
        }
    }
}
