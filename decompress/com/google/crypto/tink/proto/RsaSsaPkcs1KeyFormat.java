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

public final class RsaSsaPkcs1KeyFormat extends GeneratedMessageLite<RsaSsaPkcs1KeyFormat, Builder> implements RsaSsaPkcs1KeyFormatOrBuilder
{
    private static final RsaSsaPkcs1KeyFormat DEFAULT_INSTANCE;
    public static final int MODULUS_SIZE_IN_BITS_FIELD_NUMBER = 2;
    public static final int PARAMS_FIELD_NUMBER = 1;
    private static volatile Parser<RsaSsaPkcs1KeyFormat> PARSER;
    public static final int PUBLIC_EXPONENT_FIELD_NUMBER = 3;
    private int modulusSizeInBits_;
    private RsaSsaPkcs1Params params_;
    private ByteString publicExponent_;
    
    static {
        GeneratedMessageLite.H(RsaSsaPkcs1KeyFormat.class, DEFAULT_INSTANCE = new RsaSsaPkcs1KeyFormat());
    }
    
    private RsaSsaPkcs1KeyFormat() {
        this.publicExponent_ = ByteString.EMPTY;
    }
    
    static RsaSsaPkcs1KeyFormat J() {
        return RsaSsaPkcs1KeyFormat.DEFAULT_INSTANCE;
    }
    
    static void K(final RsaSsaPkcs1KeyFormat rsaSsaPkcs1KeyFormat, final RsaSsaPkcs1Params rsaSsaPkcs1Params) {
        rsaSsaPkcs1KeyFormat.T(rsaSsaPkcs1Params);
    }
    
    static void L(final RsaSsaPkcs1KeyFormat rsaSsaPkcs1KeyFormat, final int n) {
        rsaSsaPkcs1KeyFormat.S(n);
    }
    
    static void M(final RsaSsaPkcs1KeyFormat rsaSsaPkcs1KeyFormat, final ByteString byteString) {
        rsaSsaPkcs1KeyFormat.U(byteString);
    }
    
    public static Builder Q() {
        return ((GeneratedMessageLite<GeneratedMessageLite, GeneratedMessageLite.Builder>)RsaSsaPkcs1KeyFormat.DEFAULT_INSTANCE).n();
    }
    
    public static RsaSsaPkcs1KeyFormat R(final ByteString byteString, final ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return GeneratedMessageLite.B(RsaSsaPkcs1KeyFormat.DEFAULT_INSTANCE, byteString, extensionRegistryLite);
    }
    
    private void S(final int modulusSizeInBits_) {
        this.modulusSizeInBits_ = modulusSizeInBits_;
    }
    
    private void T(final RsaSsaPkcs1Params params_) {
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
    
    public RsaSsaPkcs1Params O() {
        RsaSsaPkcs1Params rsaSsaPkcs1Params;
        if ((rsaSsaPkcs1Params = this.params_) == null) {
            rsaSsaPkcs1Params = RsaSsaPkcs1Params.L();
        }
        return rsaSsaPkcs1Params;
    }
    
    public ByteString P() {
        return this.publicExponent_;
    }
    
    @Override
    protected final Object q(final MethodToInvoke methodToInvoke, final Object o, final Object o2) {
        switch (RsaSsaPkcs1KeyFormat$a.a[methodToInvoke.ordinal()]) {
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
                final Parser<RsaSsaPkcs1KeyFormat> parser;
                if ((parser = RsaSsaPkcs1KeyFormat.PARSER) == null) {
                    synchronized (RsaSsaPkcs1KeyFormat.class) {
                        if (RsaSsaPkcs1KeyFormat.PARSER == null) {
                            RsaSsaPkcs1KeyFormat.PARSER = new DefaultInstanceBasedParser<RsaSsaPkcs1KeyFormat>(RsaSsaPkcs1KeyFormat.DEFAULT_INSTANCE);
                        }
                    }
                }
                return parser;
            }
            case 4: {
                return RsaSsaPkcs1KeyFormat.DEFAULT_INSTANCE;
            }
            case 3: {
                return GeneratedMessageLite.A(RsaSsaPkcs1KeyFormat.DEFAULT_INSTANCE, "\u0000\u0003\u0000\u0000\u0001\u0003\u0003\u0000\u0000\u0000\u0001\t\u0002\u000b\u0003\n", new Object[] { "params_", "modulusSizeInBits_", "publicExponent_" });
            }
            case 2: {
                return new Builder((RsaSsaPkcs1KeyFormat$a)null);
            }
            case 1: {
                return new RsaSsaPkcs1KeyFormat();
            }
        }
    }
    
    public static final class Builder extends GeneratedMessageLite.Builder<RsaSsaPkcs1KeyFormat, Builder> implements RsaSsaPkcs1KeyFormatOrBuilder
    {
        private Builder() {
            super(RsaSsaPkcs1KeyFormat.J());
        }
        
        Builder(final RsaSsaPkcs1KeyFormat$a object) {
            this();
        }
        
        public Builder D(final int n) {
            ((GeneratedMessageLite.Builder)this).u();
            RsaSsaPkcs1KeyFormat.L((RsaSsaPkcs1KeyFormat)super.b, n);
            return this;
        }
        
        public Builder E(final RsaSsaPkcs1Params rsaSsaPkcs1Params) {
            ((GeneratedMessageLite.Builder)this).u();
            RsaSsaPkcs1KeyFormat.K((RsaSsaPkcs1KeyFormat)super.b, rsaSsaPkcs1Params);
            return this;
        }
        
        public Builder F(final ByteString byteString) {
            ((GeneratedMessageLite.Builder)this).u();
            RsaSsaPkcs1KeyFormat.M((RsaSsaPkcs1KeyFormat)super.b, byteString);
            return this;
        }
    }
}
