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

public final class RsaSsaPkcs1PrivateKey extends GeneratedMessageLite<RsaSsaPkcs1PrivateKey, Builder> implements RsaSsaPkcs1PrivateKeyOrBuilder
{
    public static final int CRT_FIELD_NUMBER = 8;
    private static final RsaSsaPkcs1PrivateKey DEFAULT_INSTANCE;
    public static final int DP_FIELD_NUMBER = 6;
    public static final int DQ_FIELD_NUMBER = 7;
    public static final int D_FIELD_NUMBER = 3;
    private static volatile Parser<RsaSsaPkcs1PrivateKey> PARSER;
    public static final int PUBLIC_KEY_FIELD_NUMBER = 2;
    public static final int P_FIELD_NUMBER = 4;
    public static final int Q_FIELD_NUMBER = 5;
    public static final int VERSION_FIELD_NUMBER = 1;
    private ByteString crt_;
    private ByteString d_;
    private ByteString dp_;
    private ByteString dq_;
    private ByteString p_;
    private RsaSsaPkcs1PublicKey publicKey_;
    private ByteString q_;
    private int version_;
    
    static {
        GeneratedMessageLite.H(RsaSsaPkcs1PrivateKey.class, DEFAULT_INSTANCE = new RsaSsaPkcs1PrivateKey());
    }
    
    private RsaSsaPkcs1PrivateKey() {
        final ByteString empty = ByteString.EMPTY;
        this.d_ = empty;
        this.p_ = empty;
        this.q_ = empty;
        this.dp_ = empty;
        this.dq_ = empty;
        this.crt_ = empty;
    }
    
    static RsaSsaPkcs1PrivateKey J() {
        return RsaSsaPkcs1PrivateKey.DEFAULT_INSTANCE;
    }
    
    static void K(final RsaSsaPkcs1PrivateKey rsaSsaPkcs1PrivateKey, final int n) {
        rsaSsaPkcs1PrivateKey.j0(n);
    }
    
    static void L(final RsaSsaPkcs1PrivateKey rsaSsaPkcs1PrivateKey, final ByteString byteString) {
        rsaSsaPkcs1PrivateKey.i0(byteString);
    }
    
    static void M(final RsaSsaPkcs1PrivateKey rsaSsaPkcs1PrivateKey, final ByteString byteString) {
        rsaSsaPkcs1PrivateKey.e0(byteString);
    }
    
    static void N(final RsaSsaPkcs1PrivateKey rsaSsaPkcs1PrivateKey, final ByteString byteString) {
        rsaSsaPkcs1PrivateKey.f0(byteString);
    }
    
    static void O(final RsaSsaPkcs1PrivateKey rsaSsaPkcs1PrivateKey, final ByteString byteString) {
        rsaSsaPkcs1PrivateKey.c0(byteString);
    }
    
    static void P(final RsaSsaPkcs1PrivateKey rsaSsaPkcs1PrivateKey, final RsaSsaPkcs1PublicKey rsaSsaPkcs1PublicKey) {
        rsaSsaPkcs1PrivateKey.h0(rsaSsaPkcs1PublicKey);
    }
    
    static void Q(final RsaSsaPkcs1PrivateKey rsaSsaPkcs1PrivateKey, final ByteString byteString) {
        rsaSsaPkcs1PrivateKey.d0(byteString);
    }
    
    static void R(final RsaSsaPkcs1PrivateKey rsaSsaPkcs1PrivateKey, final ByteString byteString) {
        rsaSsaPkcs1PrivateKey.g0(byteString);
    }
    
    public static Builder a0() {
        return ((GeneratedMessageLite<GeneratedMessageLite, GeneratedMessageLite.Builder>)RsaSsaPkcs1PrivateKey.DEFAULT_INSTANCE).n();
    }
    
    public static RsaSsaPkcs1PrivateKey b0(final ByteString byteString, final ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return GeneratedMessageLite.B(RsaSsaPkcs1PrivateKey.DEFAULT_INSTANCE, byteString, extensionRegistryLite);
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
    
    private void h0(final RsaSsaPkcs1PublicKey publicKey_) {
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
    
    public RsaSsaPkcs1PublicKey X() {
        RsaSsaPkcs1PublicKey rsaSsaPkcs1PublicKey;
        if ((rsaSsaPkcs1PublicKey = this.publicKey_) == null) {
            rsaSsaPkcs1PublicKey = RsaSsaPkcs1PublicKey.O();
        }
        return rsaSsaPkcs1PublicKey;
    }
    
    public ByteString Y() {
        return this.q_;
    }
    
    public int Z() {
        return this.version_;
    }
    
    @Override
    protected final Object q(final MethodToInvoke methodToInvoke, final Object o, final Object o2) {
        switch (RsaSsaPkcs1PrivateKey$a.a[methodToInvoke.ordinal()]) {
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
                final Parser<RsaSsaPkcs1PrivateKey> parser;
                if ((parser = RsaSsaPkcs1PrivateKey.PARSER) == null) {
                    synchronized (RsaSsaPkcs1PrivateKey.class) {
                        if (RsaSsaPkcs1PrivateKey.PARSER == null) {
                            RsaSsaPkcs1PrivateKey.PARSER = new DefaultInstanceBasedParser<RsaSsaPkcs1PrivateKey>(RsaSsaPkcs1PrivateKey.DEFAULT_INSTANCE);
                        }
                    }
                }
                return parser;
            }
            case 4: {
                return RsaSsaPkcs1PrivateKey.DEFAULT_INSTANCE;
            }
            case 3: {
                return GeneratedMessageLite.A(RsaSsaPkcs1PrivateKey.DEFAULT_INSTANCE, "\u0000\b\u0000\u0000\u0001\b\b\u0000\u0000\u0000\u0001\u000b\u0002\t\u0003\n\u0004\n\u0005\n\u0006\n\u0007\n\b\n", new Object[] { "version_", "publicKey_", "d_", "p_", "q_", "dp_", "dq_", "crt_" });
            }
            case 2: {
                return new Builder((RsaSsaPkcs1PrivateKey$a)null);
            }
            case 1: {
                return new RsaSsaPkcs1PrivateKey();
            }
        }
    }
    
    public static final class Builder extends GeneratedMessageLite.Builder<RsaSsaPkcs1PrivateKey, Builder> implements RsaSsaPkcs1PrivateKeyOrBuilder
    {
        private Builder() {
            super(RsaSsaPkcs1PrivateKey.J());
        }
        
        Builder(final RsaSsaPkcs1PrivateKey$a object) {
            this();
        }
        
        public Builder D(final ByteString byteString) {
            ((GeneratedMessageLite.Builder)this).u();
            RsaSsaPkcs1PrivateKey.O((RsaSsaPkcs1PrivateKey)super.b, byteString);
            return this;
        }
        
        public Builder E(final ByteString byteString) {
            ((GeneratedMessageLite.Builder)this).u();
            RsaSsaPkcs1PrivateKey.Q((RsaSsaPkcs1PrivateKey)super.b, byteString);
            return this;
        }
        
        public Builder F(final ByteString byteString) {
            ((GeneratedMessageLite.Builder)this).u();
            RsaSsaPkcs1PrivateKey.M((RsaSsaPkcs1PrivateKey)super.b, byteString);
            return this;
        }
        
        public Builder G(final ByteString byteString) {
            ((GeneratedMessageLite.Builder)this).u();
            RsaSsaPkcs1PrivateKey.N((RsaSsaPkcs1PrivateKey)super.b, byteString);
            return this;
        }
        
        public Builder H(final ByteString byteString) {
            ((GeneratedMessageLite.Builder)this).u();
            RsaSsaPkcs1PrivateKey.R((RsaSsaPkcs1PrivateKey)super.b, byteString);
            return this;
        }
        
        public Builder I(final RsaSsaPkcs1PublicKey rsaSsaPkcs1PublicKey) {
            ((GeneratedMessageLite.Builder)this).u();
            RsaSsaPkcs1PrivateKey.P((RsaSsaPkcs1PrivateKey)super.b, rsaSsaPkcs1PublicKey);
            return this;
        }
        
        public Builder J(final ByteString byteString) {
            ((GeneratedMessageLite.Builder)this).u();
            RsaSsaPkcs1PrivateKey.L((RsaSsaPkcs1PrivateKey)super.b, byteString);
            return this;
        }
        
        public Builder K(final int n) {
            ((GeneratedMessageLite.Builder)this).u();
            RsaSsaPkcs1PrivateKey.K((RsaSsaPkcs1PrivateKey)super.b, n);
            return this;
        }
    }
}
