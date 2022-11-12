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

public final class RsaSsaPssPrivateKey extends GeneratedMessageLite<RsaSsaPssPrivateKey, Builder> implements RsaSsaPssPrivateKeyOrBuilder
{
    public static final int CRT_FIELD_NUMBER = 8;
    private static final RsaSsaPssPrivateKey DEFAULT_INSTANCE;
    public static final int DP_FIELD_NUMBER = 6;
    public static final int DQ_FIELD_NUMBER = 7;
    public static final int D_FIELD_NUMBER = 3;
    private static volatile Parser<RsaSsaPssPrivateKey> PARSER;
    public static final int PUBLIC_KEY_FIELD_NUMBER = 2;
    public static final int P_FIELD_NUMBER = 4;
    public static final int Q_FIELD_NUMBER = 5;
    public static final int VERSION_FIELD_NUMBER = 1;
    private ByteString crt_;
    private ByteString d_;
    private ByteString dp_;
    private ByteString dq_;
    private ByteString p_;
    private RsaSsaPssPublicKey publicKey_;
    private ByteString q_;
    private int version_;
    
    static {
        GeneratedMessageLite.H(RsaSsaPssPrivateKey.class, DEFAULT_INSTANCE = new RsaSsaPssPrivateKey());
    }
    
    private RsaSsaPssPrivateKey() {
        final ByteString empty = ByteString.EMPTY;
        this.d_ = empty;
        this.p_ = empty;
        this.q_ = empty;
        this.dp_ = empty;
        this.dq_ = empty;
        this.crt_ = empty;
    }
    
    static RsaSsaPssPrivateKey J() {
        return RsaSsaPssPrivateKey.DEFAULT_INSTANCE;
    }
    
    static void K(final RsaSsaPssPrivateKey rsaSsaPssPrivateKey, final int n) {
        rsaSsaPssPrivateKey.j0(n);
    }
    
    static void L(final RsaSsaPssPrivateKey rsaSsaPssPrivateKey, final ByteString byteString) {
        rsaSsaPssPrivateKey.i0(byteString);
    }
    
    static void M(final RsaSsaPssPrivateKey rsaSsaPssPrivateKey, final ByteString byteString) {
        rsaSsaPssPrivateKey.e0(byteString);
    }
    
    static void N(final RsaSsaPssPrivateKey rsaSsaPssPrivateKey, final ByteString byteString) {
        rsaSsaPssPrivateKey.f0(byteString);
    }
    
    static void O(final RsaSsaPssPrivateKey rsaSsaPssPrivateKey, final ByteString byteString) {
        rsaSsaPssPrivateKey.c0(byteString);
    }
    
    static void P(final RsaSsaPssPrivateKey rsaSsaPssPrivateKey, final RsaSsaPssPublicKey rsaSsaPssPublicKey) {
        rsaSsaPssPrivateKey.h0(rsaSsaPssPublicKey);
    }
    
    static void Q(final RsaSsaPssPrivateKey rsaSsaPssPrivateKey, final ByteString byteString) {
        rsaSsaPssPrivateKey.d0(byteString);
    }
    
    static void R(final RsaSsaPssPrivateKey rsaSsaPssPrivateKey, final ByteString byteString) {
        rsaSsaPssPrivateKey.g0(byteString);
    }
    
    public static Builder a0() {
        return ((GeneratedMessageLite<GeneratedMessageLite, GeneratedMessageLite.Builder>)RsaSsaPssPrivateKey.DEFAULT_INSTANCE).n();
    }
    
    public static RsaSsaPssPrivateKey b0(final ByteString byteString, final ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return GeneratedMessageLite.B(RsaSsaPssPrivateKey.DEFAULT_INSTANCE, byteString, extensionRegistryLite);
    }
    
    private void c0(final ByteString crt_) {
        crt_.getClass();
        this.crt_ = crt_;
    }
    
    private void d0(final ByteString d_) {
        d_.getClass();
        this.d_ = d_;
    }
    
    private void e0(final ByteString dp_) {
        dp_.getClass();
        this.dp_ = dp_;
    }
    
    private void f0(final ByteString dq_) {
        dq_.getClass();
        this.dq_ = dq_;
    }
    
    private void g0(final ByteString p_) {
        p_.getClass();
        this.p_ = p_;
    }
    
    private void h0(final RsaSsaPssPublicKey publicKey_) {
        publicKey_.getClass();
        this.publicKey_ = publicKey_;
    }
    
    private void i0(final ByteString q_) {
        q_.getClass();
        this.q_ = q_;
    }
    
    private void j0(final int version_) {
        this.version_ = version_;
    }
    
    public ByteString S() {
        return this.crt_;
    }
    
    public ByteString T() {
        return this.d_;
    }
    
    public ByteString U() {
        return this.dp_;
    }
    
    public ByteString V() {
        return this.dq_;
    }
    
    public ByteString W() {
        return this.p_;
    }
    
    public RsaSsaPssPublicKey X() {
        RsaSsaPssPublicKey rsaSsaPssPublicKey;
        if ((rsaSsaPssPublicKey = this.publicKey_) == null) {
            rsaSsaPssPublicKey = RsaSsaPssPublicKey.O();
        }
        return rsaSsaPssPublicKey;
    }
    
    public ByteString Y() {
        return this.q_;
    }
    
    public int Z() {
        return this.version_;
    }
    
    @Override
    protected final Object q(final MethodToInvoke methodToInvoke, final Object o, final Object o2) {
        switch (RsaSsaPssPrivateKey$a.a[methodToInvoke.ordinal()]) {
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
                final Parser<RsaSsaPssPrivateKey> parser;
                if ((parser = RsaSsaPssPrivateKey.PARSER) == null) {
                    synchronized (RsaSsaPssPrivateKey.class) {
                        if (RsaSsaPssPrivateKey.PARSER == null) {
                            RsaSsaPssPrivateKey.PARSER = new DefaultInstanceBasedParser<RsaSsaPssPrivateKey>(RsaSsaPssPrivateKey.DEFAULT_INSTANCE);
                        }
                    }
                }
                return parser;
            }
            case 4: {
                return RsaSsaPssPrivateKey.DEFAULT_INSTANCE;
            }
            case 3: {
                return GeneratedMessageLite.A(RsaSsaPssPrivateKey.DEFAULT_INSTANCE, "\u0000\b\u0000\u0000\u0001\b\b\u0000\u0000\u0000\u0001\u000b\u0002\t\u0003\n\u0004\n\u0005\n\u0006\n\u0007\n\b\n", new Object[] { "version_", "publicKey_", "d_", "p_", "q_", "dp_", "dq_", "crt_" });
            }
            case 2: {
                return new Builder((RsaSsaPssPrivateKey$a)null);
            }
            case 1: {
                return new RsaSsaPssPrivateKey();
            }
        }
    }
    
    public static final class Builder extends GeneratedMessageLite.Builder<RsaSsaPssPrivateKey, Builder> implements RsaSsaPssPrivateKeyOrBuilder
    {
        private Builder() {
            super(RsaSsaPssPrivateKey.J());
        }
        
        Builder(final RsaSsaPssPrivateKey$a object) {
            this();
        }
        
        public Builder D(final ByteString byteString) {
            ((GeneratedMessageLite.Builder)this).u();
            RsaSsaPssPrivateKey.O((RsaSsaPssPrivateKey)super.b, byteString);
            return this;
        }
        
        public Builder E(final ByteString byteString) {
            ((GeneratedMessageLite.Builder)this).u();
            RsaSsaPssPrivateKey.Q((RsaSsaPssPrivateKey)super.b, byteString);
            return this;
        }
        
        public Builder F(final ByteString byteString) {
            ((GeneratedMessageLite.Builder)this).u();
            RsaSsaPssPrivateKey.M((RsaSsaPssPrivateKey)super.b, byteString);
            return this;
        }
        
        public Builder G(final ByteString byteString) {
            ((GeneratedMessageLite.Builder)this).u();
            RsaSsaPssPrivateKey.N((RsaSsaPssPrivateKey)super.b, byteString);
            return this;
        }
        
        public Builder H(final ByteString byteString) {
            ((GeneratedMessageLite.Builder)this).u();
            RsaSsaPssPrivateKey.R((RsaSsaPssPrivateKey)super.b, byteString);
            return this;
        }
        
        public Builder I(final RsaSsaPssPublicKey rsaSsaPssPublicKey) {
            ((GeneratedMessageLite.Builder)this).u();
            RsaSsaPssPrivateKey.P((RsaSsaPssPrivateKey)super.b, rsaSsaPssPublicKey);
            return this;
        }
        
        public Builder J(final ByteString byteString) {
            ((GeneratedMessageLite.Builder)this).u();
            RsaSsaPssPrivateKey.L((RsaSsaPssPrivateKey)super.b, byteString);
            return this;
        }
        
        public Builder K(final int n) {
            ((GeneratedMessageLite.Builder)this).u();
            RsaSsaPssPrivateKey.K((RsaSsaPssPrivateKey)super.b, n);
            return this;
        }
    }
}
