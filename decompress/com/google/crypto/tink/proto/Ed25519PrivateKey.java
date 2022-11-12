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

public final class Ed25519PrivateKey extends GeneratedMessageLite<Ed25519PrivateKey, Builder> implements Ed25519PrivateKeyOrBuilder
{
    private static final Ed25519PrivateKey DEFAULT_INSTANCE;
    public static final int KEY_VALUE_FIELD_NUMBER = 2;
    private static volatile Parser<Ed25519PrivateKey> PARSER;
    public static final int PUBLIC_KEY_FIELD_NUMBER = 3;
    public static final int VERSION_FIELD_NUMBER = 1;
    private ByteString keyValue_;
    private Ed25519PublicKey publicKey_;
    private int version_;
    
    static {
        GeneratedMessageLite.H(Ed25519PrivateKey.class, DEFAULT_INSTANCE = new Ed25519PrivateKey());
    }
    
    private Ed25519PrivateKey() {
        this.keyValue_ = ByteString.EMPTY;
    }
    
    static Ed25519PrivateKey J() {
        return Ed25519PrivateKey.DEFAULT_INSTANCE;
    }
    
    static void K(final Ed25519PrivateKey ed25519PrivateKey, final int n) {
        ed25519PrivateKey.U(n);
    }
    
    static void L(final Ed25519PrivateKey ed25519PrivateKey, final ByteString byteString) {
        ed25519PrivateKey.S(byteString);
    }
    
    static void M(final Ed25519PrivateKey ed25519PrivateKey, final Ed25519PublicKey ed25519PublicKey) {
        ed25519PrivateKey.T(ed25519PublicKey);
    }
    
    public static Builder Q() {
        return ((GeneratedMessageLite<GeneratedMessageLite, GeneratedMessageLite.Builder>)Ed25519PrivateKey.DEFAULT_INSTANCE).n();
    }
    
    public static Ed25519PrivateKey R(final ByteString byteString, final ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return GeneratedMessageLite.B(Ed25519PrivateKey.DEFAULT_INSTANCE, byteString, extensionRegistryLite);
    }
    
    private void S(final ByteString keyValue_) {
        keyValue_.getClass();
        this.keyValue_ = keyValue_;
    }
    
    private void T(final Ed25519PublicKey publicKey_) {
        publicKey_.getClass();
        this.publicKey_ = publicKey_;
    }
    
    private void U(final int version_) {
        this.version_ = version_;
    }
    
    public ByteString N() {
        return this.keyValue_;
    }
    
    public Ed25519PublicKey O() {
        Ed25519PublicKey ed25519PublicKey;
        if ((ed25519PublicKey = this.publicKey_) == null) {
            ed25519PublicKey = Ed25519PublicKey.M();
        }
        return ed25519PublicKey;
    }
    
    public int P() {
        return this.version_;
    }
    
    @Override
    protected final Object q(final MethodToInvoke methodToInvoke, final Object o, final Object o2) {
        switch (Ed25519PrivateKey$a.a[methodToInvoke.ordinal()]) {
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
                final Parser<Ed25519PrivateKey> parser;
                if ((parser = Ed25519PrivateKey.PARSER) == null) {
                    synchronized (Ed25519PrivateKey.class) {
                        if (Ed25519PrivateKey.PARSER == null) {
                            Ed25519PrivateKey.PARSER = new DefaultInstanceBasedParser<Ed25519PrivateKey>(Ed25519PrivateKey.DEFAULT_INSTANCE);
                        }
                    }
                }
                return parser;
            }
            case 4: {
                return Ed25519PrivateKey.DEFAULT_INSTANCE;
            }
            case 3: {
                return GeneratedMessageLite.A(Ed25519PrivateKey.DEFAULT_INSTANCE, "\u0000\u0003\u0000\u0000\u0001\u0003\u0003\u0000\u0000\u0000\u0001\u000b\u0002\n\u0003\t", new Object[] { "version_", "keyValue_", "publicKey_" });
            }
            case 2: {
                return new Builder((Ed25519PrivateKey$a)null);
            }
            case 1: {
                return new Ed25519PrivateKey();
            }
        }
    }
    
    public static final class Builder extends GeneratedMessageLite.Builder<Ed25519PrivateKey, Builder> implements Ed25519PrivateKeyOrBuilder
    {
        private Builder() {
            super(Ed25519PrivateKey.J());
        }
        
        Builder(final Ed25519PrivateKey$a object) {
            this();
        }
        
        public Builder D(final ByteString byteString) {
            ((GeneratedMessageLite.Builder)this).u();
            Ed25519PrivateKey.L((Ed25519PrivateKey)super.b, byteString);
            return this;
        }
        
        public Builder E(final Ed25519PublicKey ed25519PublicKey) {
            ((GeneratedMessageLite.Builder)this).u();
            Ed25519PrivateKey.M((Ed25519PrivateKey)super.b, ed25519PublicKey);
            return this;
        }
        
        public Builder F(final int n) {
            ((GeneratedMessageLite.Builder)this).u();
            Ed25519PrivateKey.K((Ed25519PrivateKey)super.b, n);
            return this;
        }
    }
}
