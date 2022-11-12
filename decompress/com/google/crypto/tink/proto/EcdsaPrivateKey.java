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

public final class EcdsaPrivateKey extends GeneratedMessageLite<EcdsaPrivateKey, Builder> implements EcdsaPrivateKeyOrBuilder
{
    private static final EcdsaPrivateKey DEFAULT_INSTANCE;
    public static final int KEY_VALUE_FIELD_NUMBER = 3;
    private static volatile Parser<EcdsaPrivateKey> PARSER;
    public static final int PUBLIC_KEY_FIELD_NUMBER = 2;
    public static final int VERSION_FIELD_NUMBER = 1;
    private ByteString keyValue_;
    private EcdsaPublicKey publicKey_;
    private int version_;
    
    static {
        GeneratedMessageLite.H(EcdsaPrivateKey.class, DEFAULT_INSTANCE = new EcdsaPrivateKey());
    }
    
    private EcdsaPrivateKey() {
        this.keyValue_ = ByteString.EMPTY;
    }
    
    static EcdsaPrivateKey J() {
        return EcdsaPrivateKey.DEFAULT_INSTANCE;
    }
    
    static void K(final EcdsaPrivateKey ecdsaPrivateKey, final int n) {
        ecdsaPrivateKey.U(n);
    }
    
    static void L(final EcdsaPrivateKey ecdsaPrivateKey, final EcdsaPublicKey ecdsaPublicKey) {
        ecdsaPrivateKey.T(ecdsaPublicKey);
    }
    
    static void M(final EcdsaPrivateKey ecdsaPrivateKey, final ByteString byteString) {
        ecdsaPrivateKey.S(byteString);
    }
    
    public static Builder Q() {
        return ((GeneratedMessageLite<GeneratedMessageLite, GeneratedMessageLite.Builder>)EcdsaPrivateKey.DEFAULT_INSTANCE).n();
    }
    
    public static EcdsaPrivateKey R(final ByteString byteString, final ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return GeneratedMessageLite.B(EcdsaPrivateKey.DEFAULT_INSTANCE, byteString, extensionRegistryLite);
    }
    
    private void S(final ByteString keyValue_) {
        keyValue_.getClass();
        this.keyValue_ = keyValue_;
    }
    
    private void T(final EcdsaPublicKey publicKey_) {
        publicKey_.getClass();
        this.publicKey_ = publicKey_;
    }
    
    private void U(final int version_) {
        this.version_ = version_;
    }
    
    public ByteString N() {
        return this.keyValue_;
    }
    
    public EcdsaPublicKey O() {
        EcdsaPublicKey ecdsaPublicKey;
        if ((ecdsaPublicKey = this.publicKey_) == null) {
            ecdsaPublicKey = EcdsaPublicKey.O();
        }
        return ecdsaPublicKey;
    }
    
    public int P() {
        return this.version_;
    }
    
    @Override
    protected final Object q(final MethodToInvoke methodToInvoke, final Object o, final Object o2) {
        switch (EcdsaPrivateKey$a.a[methodToInvoke.ordinal()]) {
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
                final Parser<EcdsaPrivateKey> parser;
                if ((parser = EcdsaPrivateKey.PARSER) == null) {
                    synchronized (EcdsaPrivateKey.class) {
                        if (EcdsaPrivateKey.PARSER == null) {
                            EcdsaPrivateKey.PARSER = new DefaultInstanceBasedParser<EcdsaPrivateKey>(EcdsaPrivateKey.DEFAULT_INSTANCE);
                        }
                    }
                }
                return parser;
            }
            case 4: {
                return EcdsaPrivateKey.DEFAULT_INSTANCE;
            }
            case 3: {
                return GeneratedMessageLite.A(EcdsaPrivateKey.DEFAULT_INSTANCE, "\u0000\u0003\u0000\u0000\u0001\u0003\u0003\u0000\u0000\u0000\u0001\u000b\u0002\t\u0003\n", new Object[] { "version_", "publicKey_", "keyValue_" });
            }
            case 2: {
                return new Builder((EcdsaPrivateKey$a)null);
            }
            case 1: {
                return new EcdsaPrivateKey();
            }
        }
    }
    
    public static final class Builder extends GeneratedMessageLite.Builder<EcdsaPrivateKey, Builder> implements EcdsaPrivateKeyOrBuilder
    {
        private Builder() {
            super(EcdsaPrivateKey.J());
        }
        
        Builder(final EcdsaPrivateKey$a object) {
            this();
        }
        
        public Builder D(final ByteString byteString) {
            ((GeneratedMessageLite.Builder)this).u();
            EcdsaPrivateKey.M((EcdsaPrivateKey)super.b, byteString);
            return this;
        }
        
        public Builder E(final EcdsaPublicKey ecdsaPublicKey) {
            ((GeneratedMessageLite.Builder)this).u();
            EcdsaPrivateKey.L((EcdsaPrivateKey)super.b, ecdsaPublicKey);
            return this;
        }
        
        public Builder F(final int n) {
            ((GeneratedMessageLite.Builder)this).u();
            EcdsaPrivateKey.K((EcdsaPrivateKey)super.b, n);
            return this;
        }
    }
}
