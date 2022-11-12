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

public final class RsaSsaPkcs1PublicKey extends GeneratedMessageLite<RsaSsaPkcs1PublicKey, Builder> implements RsaSsaPkcs1PublicKeyOrBuilder
{
    private static final RsaSsaPkcs1PublicKey DEFAULT_INSTANCE;
    public static final int E_FIELD_NUMBER = 4;
    public static final int N_FIELD_NUMBER = 3;
    public static final int PARAMS_FIELD_NUMBER = 2;
    private static volatile Parser<RsaSsaPkcs1PublicKey> PARSER;
    public static final int VERSION_FIELD_NUMBER = 1;
    private ByteString e_;
    private ByteString n_;
    private RsaSsaPkcs1Params params_;
    private int version_;
    
    static {
        GeneratedMessageLite.H(RsaSsaPkcs1PublicKey.class, DEFAULT_INSTANCE = new RsaSsaPkcs1PublicKey());
    }
    
    private RsaSsaPkcs1PublicKey() {
        final ByteString empty = ByteString.EMPTY;
        this.n_ = empty;
        this.e_ = empty;
    }
    
    static RsaSsaPkcs1PublicKey J() {
        return RsaSsaPkcs1PublicKey.DEFAULT_INSTANCE;
    }
    
    static void K(final RsaSsaPkcs1PublicKey rsaSsaPkcs1PublicKey, final int n) {
        rsaSsaPkcs1PublicKey.Y(n);
    }
    
    static void L(final RsaSsaPkcs1PublicKey rsaSsaPkcs1PublicKey, final RsaSsaPkcs1Params rsaSsaPkcs1Params) {
        rsaSsaPkcs1PublicKey.X(rsaSsaPkcs1Params);
    }
    
    static void M(final RsaSsaPkcs1PublicKey rsaSsaPkcs1PublicKey, final ByteString byteString) {
        rsaSsaPkcs1PublicKey.W(byteString);
    }
    
    static void N(final RsaSsaPkcs1PublicKey rsaSsaPkcs1PublicKey, final ByteString byteString) {
        rsaSsaPkcs1PublicKey.V(byteString);
    }
    
    public static RsaSsaPkcs1PublicKey O() {
        return RsaSsaPkcs1PublicKey.DEFAULT_INSTANCE;
    }
    
    public static Builder T() {
        return ((GeneratedMessageLite<GeneratedMessageLite, GeneratedMessageLite.Builder>)RsaSsaPkcs1PublicKey.DEFAULT_INSTANCE).n();
    }
    
    public static RsaSsaPkcs1PublicKey U(final ByteString byteString, final ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return GeneratedMessageLite.B(RsaSsaPkcs1PublicKey.DEFAULT_INSTANCE, byteString, extensionRegistryLite);
    }
    
    private void V(final ByteString e_) {
        e_.getClass();
        this.e_ = e_;
    }
    
    private void W(final ByteString n_) {
        n_.getClass();
        this.n_ = n_;
    }
    
    private void X(final RsaSsaPkcs1Params params_) {
        params_.getClass();
        this.params_ = params_;
    }
    
    private void Y(final int version_) {
        this.version_ = version_;
    }
    
    public ByteString P() {
        return this.e_;
    }
    
    public ByteString Q() {
        return this.n_;
    }
    
    public RsaSsaPkcs1Params R() {
        RsaSsaPkcs1Params rsaSsaPkcs1Params;
        if ((rsaSsaPkcs1Params = this.params_) == null) {
            rsaSsaPkcs1Params = RsaSsaPkcs1Params.L();
        }
        return rsaSsaPkcs1Params;
    }
    
    public int S() {
        return this.version_;
    }
    
    @Override
    protected final Object q(final MethodToInvoke methodToInvoke, final Object o, final Object o2) {
        switch (RsaSsaPkcs1PublicKey$a.a[methodToInvoke.ordinal()]) {
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
                final Parser<RsaSsaPkcs1PublicKey> parser;
                if ((parser = RsaSsaPkcs1PublicKey.PARSER) == null) {
                    synchronized (RsaSsaPkcs1PublicKey.class) {
                        if (RsaSsaPkcs1PublicKey.PARSER == null) {
                            RsaSsaPkcs1PublicKey.PARSER = new DefaultInstanceBasedParser<RsaSsaPkcs1PublicKey>(RsaSsaPkcs1PublicKey.DEFAULT_INSTANCE);
                        }
                    }
                }
                return parser;
            }
            case 4: {
                return RsaSsaPkcs1PublicKey.DEFAULT_INSTANCE;
            }
            case 3: {
                return GeneratedMessageLite.A(RsaSsaPkcs1PublicKey.DEFAULT_INSTANCE, "\u0000\u0004\u0000\u0000\u0001\u0004\u0004\u0000\u0000\u0000\u0001\u000b\u0002\t\u0003\n\u0004\n", new Object[] { "version_", "params_", "n_", "e_" });
            }
            case 2: {
                return new Builder((RsaSsaPkcs1PublicKey$a)null);
            }
            case 1: {
                return new RsaSsaPkcs1PublicKey();
            }
        }
    }
    
    public static final class Builder extends GeneratedMessageLite.Builder<RsaSsaPkcs1PublicKey, Builder> implements RsaSsaPkcs1PublicKeyOrBuilder
    {
        private Builder() {
            super(RsaSsaPkcs1PublicKey.J());
        }
        
        Builder(final RsaSsaPkcs1PublicKey$a object) {
            this();
        }
        
        public Builder D(final ByteString byteString) {
            ((GeneratedMessageLite.Builder)this).u();
            RsaSsaPkcs1PublicKey.N((RsaSsaPkcs1PublicKey)super.b, byteString);
            return this;
        }
        
        public Builder E(final ByteString byteString) {
            ((GeneratedMessageLite.Builder)this).u();
            RsaSsaPkcs1PublicKey.M((RsaSsaPkcs1PublicKey)super.b, byteString);
            return this;
        }
        
        public Builder F(final RsaSsaPkcs1Params rsaSsaPkcs1Params) {
            ((GeneratedMessageLite.Builder)this).u();
            RsaSsaPkcs1PublicKey.L((RsaSsaPkcs1PublicKey)super.b, rsaSsaPkcs1Params);
            return this;
        }
        
        public Builder G(final int n) {
            ((GeneratedMessageLite.Builder)this).u();
            RsaSsaPkcs1PublicKey.K((RsaSsaPkcs1PublicKey)super.b, n);
            return this;
        }
    }
}
