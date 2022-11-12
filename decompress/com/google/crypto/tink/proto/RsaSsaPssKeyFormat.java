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

public final class RsaSsaPssKeyFormat extends GeneratedMessageLite<RsaSsaPssKeyFormat, Builder> implements RsaSsaPssKeyFormatOrBuilder
{
    private static final RsaSsaPssKeyFormat DEFAULT_INSTANCE;
    public static final int MODULUS_SIZE_IN_BITS_FIELD_NUMBER = 2;
    public static final int PARAMS_FIELD_NUMBER = 1;
    private static volatile Parser<RsaSsaPssKeyFormat> PARSER;
    public static final int PUBLIC_EXPONENT_FIELD_NUMBER = 3;
    private int modulusSizeInBits_;
    private RsaSsaPssParams params_;
    private ByteString publicExponent_;
    
    static {
        GeneratedMessageLite.H(RsaSsaPssKeyFormat.class, DEFAULT_INSTANCE = new RsaSsaPssKeyFormat());
    }
    
    private RsaSsaPssKeyFormat() {
        this.publicExponent_ = ByteString.EMPTY;
    }
    
    static RsaSsaPssKeyFormat J() {
        return RsaSsaPssKeyFormat.DEFAULT_INSTANCE;
    }
    
    static void K(final RsaSsaPssKeyFormat rsaSsaPssKeyFormat, final RsaSsaPssParams rsaSsaPssParams) {
        rsaSsaPssKeyFormat.T(rsaSsaPssParams);
    }
    
    static void L(final RsaSsaPssKeyFormat rsaSsaPssKeyFormat, final int n) {
        rsaSsaPssKeyFormat.S(n);
    }
    
    static void M(final RsaSsaPssKeyFormat rsaSsaPssKeyFormat, final ByteString byteString) {
        rsaSsaPssKeyFormat.U(byteString);
    }
    
    public static Builder Q() {
        return ((GeneratedMessageLite<GeneratedMessageLite, GeneratedMessageLite.Builder>)RsaSsaPssKeyFormat.DEFAULT_INSTANCE).n();
    }
    
    public static RsaSsaPssKeyFormat R(final ByteString byteString, final ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return GeneratedMessageLite.B(RsaSsaPssKeyFormat.DEFAULT_INSTANCE, byteString, extensionRegistryLite);
    }
    
    private void S(final int modulusSizeInBits_) {
        this.modulusSizeInBits_ = modulusSizeInBits_;
    }
    
    private void T(final RsaSsaPssParams params_) {
        params_.getClass();
        this.params_ = params_;
    }
    
    private void U(final ByteString publicExponent_) {
        publicExponent_.getClass();
        this.publicExponent_ = publicExponent_;
    }
    
    public int N() {
        return this.modulusSizeInBits_;
    }
    
    public RsaSsaPssParams O() {
        RsaSsaPssParams rsaSsaPssParams;
        if ((rsaSsaPssParams = this.params_) == null) {
            rsaSsaPssParams = RsaSsaPssParams.N();
        }
        return rsaSsaPssParams;
    }
    
    public ByteString P() {
        return this.publicExponent_;
    }
    
    @Override
    protected final Object q(final MethodToInvoke methodToInvoke, final Object o, final Object o2) {
        switch (RsaSsaPssKeyFormat$a.a[methodToInvoke.ordinal()]) {
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
                final Parser<RsaSsaPssKeyFormat> parser;
                if ((parser = RsaSsaPssKeyFormat.PARSER) == null) {
                    synchronized (RsaSsaPssKeyFormat.class) {
                        if (RsaSsaPssKeyFormat.PARSER == null) {
                            RsaSsaPssKeyFormat.PARSER = new DefaultInstanceBasedParser<RsaSsaPssKeyFormat>(RsaSsaPssKeyFormat.DEFAULT_INSTANCE);
                        }
                    }
                }
                return parser;
            }
            case 4: {
                return RsaSsaPssKeyFormat.DEFAULT_INSTANCE;
            }
            case 3: {
                return GeneratedMessageLite.A(RsaSsaPssKeyFormat.DEFAULT_INSTANCE, "\u0000\u0003\u0000\u0000\u0001\u0003\u0003\u0000\u0000\u0000\u0001\t\u0002\u000b\u0003\n", new Object[] { "params_", "modulusSizeInBits_", "publicExponent_" });
            }
            case 2: {
                return new Builder((RsaSsaPssKeyFormat$a)null);
            }
            case 1: {
                return new RsaSsaPssKeyFormat();
            }
        }
    }
    
    public static final class Builder extends GeneratedMessageLite.Builder<RsaSsaPssKeyFormat, Builder> implements RsaSsaPssKeyFormatOrBuilder
    {
        private Builder() {
            super(RsaSsaPssKeyFormat.J());
        }
        
        Builder(final RsaSsaPssKeyFormat$a object) {
            this();
        }
        
        public Builder D(final int n) {
            ((GeneratedMessageLite.Builder)this).u();
            RsaSsaPssKeyFormat.L((RsaSsaPssKeyFormat)super.b, n);
            return this;
        }
        
        public Builder E(final RsaSsaPssParams rsaSsaPssParams) {
            ((GeneratedMessageLite.Builder)this).u();
            RsaSsaPssKeyFormat.K((RsaSsaPssKeyFormat)super.b, rsaSsaPssParams);
            return this;
        }
        
        public Builder F(final ByteString byteString) {
            ((GeneratedMessageLite.Builder)this).u();
            RsaSsaPssKeyFormat.M((RsaSsaPssKeyFormat)super.b, byteString);
            return this;
        }
    }
}
