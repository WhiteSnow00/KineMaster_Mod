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

public final class EciesAeadHkdfPrivateKey extends GeneratedMessageLite<EciesAeadHkdfPrivateKey, Builder> implements EciesAeadHkdfPrivateKeyOrBuilder
{
    private static final EciesAeadHkdfPrivateKey DEFAULT_INSTANCE;
    public static final int KEY_VALUE_FIELD_NUMBER = 3;
    private static volatile Parser<EciesAeadHkdfPrivateKey> PARSER;
    public static final int PUBLIC_KEY_FIELD_NUMBER = 2;
    public static final int VERSION_FIELD_NUMBER = 1;
    private ByteString keyValue_;
    private EciesAeadHkdfPublicKey publicKey_;
    private int version_;
    
    static {
        GeneratedMessageLite.H(EciesAeadHkdfPrivateKey.class, DEFAULT_INSTANCE = new EciesAeadHkdfPrivateKey());
    }
    
    private EciesAeadHkdfPrivateKey() {
        this.keyValue_ = ByteString.EMPTY;
    }
    
    static EciesAeadHkdfPrivateKey J() {
        return EciesAeadHkdfPrivateKey.DEFAULT_INSTANCE;
    }
    
    static void K(final EciesAeadHkdfPrivateKey eciesAeadHkdfPrivateKey, final int n) {
        eciesAeadHkdfPrivateKey.U(n);
    }
    
    static void L(final EciesAeadHkdfPrivateKey eciesAeadHkdfPrivateKey, final EciesAeadHkdfPublicKey eciesAeadHkdfPublicKey) {
        eciesAeadHkdfPrivateKey.T(eciesAeadHkdfPublicKey);
    }
    
    static void M(final EciesAeadHkdfPrivateKey eciesAeadHkdfPrivateKey, final ByteString byteString) {
        eciesAeadHkdfPrivateKey.S(byteString);
    }
    
    public static Builder Q() {
        return ((GeneratedMessageLite<GeneratedMessageLite, GeneratedMessageLite.Builder>)EciesAeadHkdfPrivateKey.DEFAULT_INSTANCE).n();
    }
    
    public static EciesAeadHkdfPrivateKey R(final ByteString byteString, final ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return GeneratedMessageLite.B(EciesAeadHkdfPrivateKey.DEFAULT_INSTANCE, byteString, extensionRegistryLite);
    }
    
    private void S(final ByteString keyValue_) {
        keyValue_.getClass();
        this.keyValue_ = keyValue_;
    }
    
    private void T(final EciesAeadHkdfPublicKey publicKey_) {
        publicKey_.getClass();
        this.publicKey_ = publicKey_;
    }
    
    private void U(final int version_) {
        this.version_ = version_;
    }
    
    public ByteString N() {
        return this.keyValue_;
    }
    
    public EciesAeadHkdfPublicKey O() {
        EciesAeadHkdfPublicKey eciesAeadHkdfPublicKey;
        if ((eciesAeadHkdfPublicKey = this.publicKey_) == null) {
            eciesAeadHkdfPublicKey = EciesAeadHkdfPublicKey.O();
        }
        return eciesAeadHkdfPublicKey;
    }
    
    public int P() {
        return this.version_;
    }
    
    @Override
    protected final Object q(final MethodToInvoke methodToInvoke, final Object o, final Object o2) {
        switch (EciesAeadHkdfPrivateKey$a.a[methodToInvoke.ordinal()]) {
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
                final Parser<EciesAeadHkdfPrivateKey> parser;
                if ((parser = EciesAeadHkdfPrivateKey.PARSER) == null) {
                    synchronized (EciesAeadHkdfPrivateKey.class) {
                        if (EciesAeadHkdfPrivateKey.PARSER == null) {
                            EciesAeadHkdfPrivateKey.PARSER = new DefaultInstanceBasedParser<EciesAeadHkdfPrivateKey>(EciesAeadHkdfPrivateKey.DEFAULT_INSTANCE);
                        }
                    }
                }
                return parser;
            }
            case 4: {
                return EciesAeadHkdfPrivateKey.DEFAULT_INSTANCE;
            }
            case 3: {
                return GeneratedMessageLite.A(EciesAeadHkdfPrivateKey.DEFAULT_INSTANCE, "\u0000\u0003\u0000\u0000\u0001\u0003\u0003\u0000\u0000\u0000\u0001\u000b\u0002\t\u0003\n", new Object[] { "version_", "publicKey_", "keyValue_" });
            }
            case 2: {
                return new Builder((EciesAeadHkdfPrivateKey$a)null);
            }
            case 1: {
                return new EciesAeadHkdfPrivateKey();
            }
        }
    }
    
    public static final class Builder extends GeneratedMessageLite.Builder<EciesAeadHkdfPrivateKey, Builder> implements EciesAeadHkdfPrivateKeyOrBuilder
    {
        private Builder() {
            super(EciesAeadHkdfPrivateKey.J());
        }
        
        Builder(final EciesAeadHkdfPrivateKey$a object) {
            this();
        }
        
        public Builder D(final ByteString byteString) {
            ((GeneratedMessageLite.Builder)this).u();
            EciesAeadHkdfPrivateKey.M((EciesAeadHkdfPrivateKey)super.b, byteString);
            return this;
        }
        
        public Builder E(final EciesAeadHkdfPublicKey eciesAeadHkdfPublicKey) {
            ((GeneratedMessageLite.Builder)this).u();
            EciesAeadHkdfPrivateKey.L((EciesAeadHkdfPrivateKey)super.b, eciesAeadHkdfPublicKey);
            return this;
        }
        
        public Builder F(final int n) {
            ((GeneratedMessageLite.Builder)this).u();
            EciesAeadHkdfPrivateKey.K((EciesAeadHkdfPrivateKey)super.b, n);
            return this;
        }
    }
}
