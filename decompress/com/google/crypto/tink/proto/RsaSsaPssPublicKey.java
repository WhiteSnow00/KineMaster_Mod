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

public final class RsaSsaPssPublicKey extends GeneratedMessageLite<RsaSsaPssPublicKey, Builder> implements RsaSsaPssPublicKeyOrBuilder
{
    private static final RsaSsaPssPublicKey DEFAULT_INSTANCE;
    public static final int E_FIELD_NUMBER = 4;
    public static final int N_FIELD_NUMBER = 3;
    public static final int PARAMS_FIELD_NUMBER = 2;
    private static volatile Parser<RsaSsaPssPublicKey> PARSER;
    public static final int VERSION_FIELD_NUMBER = 1;
    private ByteString e_;
    private ByteString n_;
    private RsaSsaPssParams params_;
    private int version_;
    
    static {
        GeneratedMessageLite.H(RsaSsaPssPublicKey.class, DEFAULT_INSTANCE = new RsaSsaPssPublicKey());
    }
    
    private RsaSsaPssPublicKey() {
        final ByteString empty = ByteString.EMPTY;
        this.n_ = empty;
        this.e_ = empty;
    }
    
    static RsaSsaPssPublicKey J() {
        return RsaSsaPssPublicKey.DEFAULT_INSTANCE;
    }
    
    static void K(final RsaSsaPssPublicKey rsaSsaPssPublicKey, final int n) {
        rsaSsaPssPublicKey.Y(n);
    }
    
    static void L(final RsaSsaPssPublicKey rsaSsaPssPublicKey, final RsaSsaPssParams rsaSsaPssParams) {
        rsaSsaPssPublicKey.X(rsaSsaPssParams);
    }
    
    static void M(final RsaSsaPssPublicKey rsaSsaPssPublicKey, final ByteString byteString) {
        rsaSsaPssPublicKey.W(byteString);
    }
    
    static void N(final RsaSsaPssPublicKey rsaSsaPssPublicKey, final ByteString byteString) {
        rsaSsaPssPublicKey.V(byteString);
    }
    
    public static RsaSsaPssPublicKey O() {
        return RsaSsaPssPublicKey.DEFAULT_INSTANCE;
    }
    
    public static Builder T() {
        return ((GeneratedMessageLite<GeneratedMessageLite, GeneratedMessageLite.Builder>)RsaSsaPssPublicKey.DEFAULT_INSTANCE).n();
    }
    
    public static RsaSsaPssPublicKey U(final ByteString byteString, final ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return GeneratedMessageLite.B(RsaSsaPssPublicKey.DEFAULT_INSTANCE, byteString, extensionRegistryLite);
    }
    
    private void V(final ByteString e_) {
        e_.getClass();
        this.e_ = e_;
    }
    
    private void W(final ByteString n_) {
        n_.getClass();
        this.n_ = n_;
    }
    
    private void X(final RsaSsaPssParams params_) {
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
    
    public RsaSsaPssParams R() {
        RsaSsaPssParams rsaSsaPssParams;
        if ((rsaSsaPssParams = this.params_) == null) {
            rsaSsaPssParams = RsaSsaPssParams.N();
        }
        return rsaSsaPssParams;
    }
    
    public int S() {
        return this.version_;
    }
    
    @Override
    protected final Object q(final MethodToInvoke methodToInvoke, final Object o, final Object o2) {
        switch (RsaSsaPssPublicKey$a.a[methodToInvoke.ordinal()]) {
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
                final Parser<RsaSsaPssPublicKey> parser;
                if ((parser = RsaSsaPssPublicKey.PARSER) == null) {
                    synchronized (RsaSsaPssPublicKey.class) {
                        if (RsaSsaPssPublicKey.PARSER == null) {
                            RsaSsaPssPublicKey.PARSER = new DefaultInstanceBasedParser<RsaSsaPssPublicKey>(RsaSsaPssPublicKey.DEFAULT_INSTANCE);
                        }
                    }
                }
                return parser;
            }
            case 4: {
                return RsaSsaPssPublicKey.DEFAULT_INSTANCE;
            }
            case 3: {
                return GeneratedMessageLite.A(RsaSsaPssPublicKey.DEFAULT_INSTANCE, "\u0000\u0004\u0000\u0000\u0001\u0004\u0004\u0000\u0000\u0000\u0001\u000b\u0002\t\u0003\n\u0004\n", new Object[] { "version_", "params_", "n_", "e_" });
            }
            case 2: {
                return new Builder((RsaSsaPssPublicKey$a)null);
            }
            case 1: {
                return new RsaSsaPssPublicKey();
            }
        }
    }
    
    public static final class Builder extends GeneratedMessageLite.Builder<RsaSsaPssPublicKey, Builder> implements RsaSsaPssPublicKeyOrBuilder
    {
        private Builder() {
            super(RsaSsaPssPublicKey.J());
        }
        
        Builder(final RsaSsaPssPublicKey$a object) {
            this();
        }
        
        public Builder D(final ByteString byteString) {
            ((GeneratedMessageLite.Builder)this).u();
            RsaSsaPssPublicKey.N((RsaSsaPssPublicKey)super.b, byteString);
            return this;
        }
        
        public Builder E(final ByteString byteString) {
            ((GeneratedMessageLite.Builder)this).u();
            RsaSsaPssPublicKey.M((RsaSsaPssPublicKey)super.b, byteString);
            return this;
        }
        
        public Builder F(final RsaSsaPssParams rsaSsaPssParams) {
            ((GeneratedMessageLite.Builder)this).u();
            RsaSsaPssPublicKey.L((RsaSsaPssPublicKey)super.b, rsaSsaPssParams);
            return this;
        }
        
        public Builder G(final int n) {
            ((GeneratedMessageLite.Builder)this).u();
            RsaSsaPssPublicKey.K((RsaSsaPssPublicKey)super.b, n);
            return this;
        }
    }
}
