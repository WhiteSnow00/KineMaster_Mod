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

public final class EcdsaKeyFormat extends GeneratedMessageLite<EcdsaKeyFormat, Builder> implements EcdsaKeyFormatOrBuilder
{
    private static final EcdsaKeyFormat DEFAULT_INSTANCE;
    public static final int PARAMS_FIELD_NUMBER = 2;
    private static volatile Parser<EcdsaKeyFormat> PARSER;
    private EcdsaParams params_;
    
    static {
        GeneratedMessageLite.H(EcdsaKeyFormat.class, DEFAULT_INSTANCE = new EcdsaKeyFormat());
    }
    
    private EcdsaKeyFormat() {
    }
    
    static EcdsaKeyFormat J() {
        return EcdsaKeyFormat.DEFAULT_INSTANCE;
    }
    
    static void K(final EcdsaKeyFormat ecdsaKeyFormat, final EcdsaParams ecdsaParams) {
        ecdsaKeyFormat.O(ecdsaParams);
    }
    
    public static Builder M() {
        return ((GeneratedMessageLite<GeneratedMessageLite, GeneratedMessageLite.Builder>)EcdsaKeyFormat.DEFAULT_INSTANCE).n();
    }
    
    public static EcdsaKeyFormat N(final ByteString byteString, final ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return GeneratedMessageLite.B(EcdsaKeyFormat.DEFAULT_INSTANCE, byteString, extensionRegistryLite);
    }
    
    private void O(final EcdsaParams params_) {
        params_.getClass();
        this.params_ = params_;
    }
    
    public EcdsaParams L() {
        EcdsaParams ecdsaParams;
        if ((ecdsaParams = this.params_) == null) {
            ecdsaParams = EcdsaParams.O();
        }
        return ecdsaParams;
    }
    
    @Override
    protected final Object q(final MethodToInvoke methodToInvoke, final Object o, final Object o2) {
        switch (EcdsaKeyFormat$a.a[methodToInvoke.ordinal()]) {
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
                final Parser<EcdsaKeyFormat> parser;
                if ((parser = EcdsaKeyFormat.PARSER) == null) {
                    synchronized (EcdsaKeyFormat.class) {
                        if (EcdsaKeyFormat.PARSER == null) {
                            EcdsaKeyFormat.PARSER = new DefaultInstanceBasedParser<EcdsaKeyFormat>(EcdsaKeyFormat.DEFAULT_INSTANCE);
                        }
                    }
                }
                return parser;
            }
            case 4: {
                return EcdsaKeyFormat.DEFAULT_INSTANCE;
            }
            case 3: {
                return GeneratedMessageLite.A(EcdsaKeyFormat.DEFAULT_INSTANCE, "\u0000\u0001\u0000\u0000\u0002\u0002\u0001\u0000\u0000\u0000\u0002\t", new Object[] { "params_" });
            }
            case 2: {
                return new Builder((EcdsaKeyFormat$a)null);
            }
            case 1: {
                return new EcdsaKeyFormat();
            }
        }
    }
    
    public static final class Builder extends GeneratedMessageLite.Builder<EcdsaKeyFormat, Builder> implements EcdsaKeyFormatOrBuilder
    {
        private Builder() {
            super(EcdsaKeyFormat.J());
        }
        
        Builder(final EcdsaKeyFormat$a object) {
            this();
        }
        
        public Builder D(final EcdsaParams ecdsaParams) {
            ((GeneratedMessageLite.Builder)this).u();
            EcdsaKeyFormat.K((EcdsaKeyFormat)super.b, ecdsaParams);
            return this;
        }
    }
}
