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

public final class Ed25519PublicKey extends GeneratedMessageLite<Ed25519PublicKey, Builder> implements Ed25519PublicKeyOrBuilder
{
    private static final Ed25519PublicKey DEFAULT_INSTANCE;
    public static final int KEY_VALUE_FIELD_NUMBER = 2;
    private static volatile Parser<Ed25519PublicKey> PARSER;
    public static final int VERSION_FIELD_NUMBER = 1;
    private ByteString keyValue_;
    private int version_;
    
    static {
        GeneratedMessageLite.H(Ed25519PublicKey.class, DEFAULT_INSTANCE = new Ed25519PublicKey());
    }
    
    private Ed25519PublicKey() {
        this.keyValue_ = ByteString.EMPTY;
    }
    
    static Ed25519PublicKey J() {
        return Ed25519PublicKey.DEFAULT_INSTANCE;
    }
    
    static void K(final Ed25519PublicKey ed25519PublicKey, final int n) {
        ed25519PublicKey.S(n);
    }
    
    static void L(final Ed25519PublicKey ed25519PublicKey, final ByteString byteString) {
        ed25519PublicKey.R(byteString);
    }
    
    public static Ed25519PublicKey M() {
        return Ed25519PublicKey.DEFAULT_INSTANCE;
    }
    
    public static Builder P() {
        return ((GeneratedMessageLite<GeneratedMessageLite, GeneratedMessageLite.Builder>)Ed25519PublicKey.DEFAULT_INSTANCE).n();
    }
    
    public static Ed25519PublicKey Q(final ByteString byteString, final ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return GeneratedMessageLite.B(Ed25519PublicKey.DEFAULT_INSTANCE, byteString, extensionRegistryLite);
    }
    
    private void R(final ByteString keyValue_) {
        keyValue_.getClass();
        this.keyValue_ = keyValue_;
    }
    
    private void S(final int version_) {
        this.version_ = version_;
    }
    
    public ByteString N() {
        return this.keyValue_;
    }
    
    public int O() {
        return this.version_;
    }
    
    @Override
    protected final Object q(final MethodToInvoke methodToInvoke, final Object o, final Object o2) {
        switch (Ed25519PublicKey$a.a[methodToInvoke.ordinal()]) {
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
                final Parser<Ed25519PublicKey> parser;
                if ((parser = Ed25519PublicKey.PARSER) == null) {
                    synchronized (Ed25519PublicKey.class) {
                        if (Ed25519PublicKey.PARSER == null) {
                            Ed25519PublicKey.PARSER = new DefaultInstanceBasedParser<Ed25519PublicKey>(Ed25519PublicKey.DEFAULT_INSTANCE);
                        }
                    }
                }
                return parser;
            }
            case 4: {
                return Ed25519PublicKey.DEFAULT_INSTANCE;
            }
            case 3: {
                return GeneratedMessageLite.A(Ed25519PublicKey.DEFAULT_INSTANCE, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0000\u0000\u0001\u000b\u0002\n", new Object[] { "version_", "keyValue_" });
            }
            case 2: {
                return new Builder((Ed25519PublicKey$a)null);
            }
            case 1: {
                return new Ed25519PublicKey();
            }
        }
    }
    
    public static final class Builder extends GeneratedMessageLite.Builder<Ed25519PublicKey, Builder> implements Ed25519PublicKeyOrBuilder
    {
        private Builder() {
            super(Ed25519PublicKey.J());
        }
        
        Builder(final Ed25519PublicKey$a object) {
            this();
        }
        
        public Builder D(final ByteString byteString) {
            ((GeneratedMessageLite.Builder)this).u();
            Ed25519PublicKey.L((Ed25519PublicKey)super.b, byteString);
            return this;
        }
        
        public Builder E(final int n) {
            ((GeneratedMessageLite.Builder)this).u();
            Ed25519PublicKey.K((Ed25519PublicKey)super.b, n);
            return this;
        }
    }
}
