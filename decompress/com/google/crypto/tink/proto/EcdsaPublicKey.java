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

public final class EcdsaPublicKey extends GeneratedMessageLite<EcdsaPublicKey, Builder> implements EcdsaPublicKeyOrBuilder
{
    private static final EcdsaPublicKey DEFAULT_INSTANCE;
    public static final int PARAMS_FIELD_NUMBER = 2;
    private static volatile Parser<EcdsaPublicKey> PARSER;
    public static final int VERSION_FIELD_NUMBER = 1;
    public static final int X_FIELD_NUMBER = 3;
    public static final int Y_FIELD_NUMBER = 4;
    private EcdsaParams params_;
    private int version_;
    private ByteString x_;
    private ByteString y_;
    
    static {
        GeneratedMessageLite.H(EcdsaPublicKey.class, DEFAULT_INSTANCE = new EcdsaPublicKey());
    }
    
    private EcdsaPublicKey() {
        final ByteString empty = ByteString.EMPTY;
        this.x_ = empty;
        this.y_ = empty;
    }
    
    static EcdsaPublicKey J() {
        return EcdsaPublicKey.DEFAULT_INSTANCE;
    }
    
    static void K(final EcdsaPublicKey ecdsaPublicKey, final int n) {
        ecdsaPublicKey.W(n);
    }
    
    static void L(final EcdsaPublicKey ecdsaPublicKey, final EcdsaParams ecdsaParams) {
        ecdsaPublicKey.V(ecdsaParams);
    }
    
    static void M(final EcdsaPublicKey ecdsaPublicKey, final ByteString byteString) {
        ecdsaPublicKey.X(byteString);
    }
    
    static void N(final EcdsaPublicKey ecdsaPublicKey, final ByteString byteString) {
        ecdsaPublicKey.Y(byteString);
    }
    
    public static EcdsaPublicKey O() {
        return EcdsaPublicKey.DEFAULT_INSTANCE;
    }
    
    public static Builder T() {
        return ((GeneratedMessageLite<GeneratedMessageLite, GeneratedMessageLite.Builder>)EcdsaPublicKey.DEFAULT_INSTANCE).n();
    }
    
    public static EcdsaPublicKey U(final ByteString byteString, final ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return GeneratedMessageLite.B(EcdsaPublicKey.DEFAULT_INSTANCE, byteString, extensionRegistryLite);
    }
    
    private void V(final EcdsaParams params_) {
        params_.getClass();
        this.params_ = params_;
    }
    
    private void W(final int version_) {
        this.version_ = version_;
    }
    
    private void X(final ByteString x_) {
        x_.getClass();
        this.x_ = x_;
    }
    
    private void Y(final ByteString y_) {
        y_.getClass();
        this.y_ = y_;
    }
    
    public EcdsaParams P() {
        EcdsaParams ecdsaParams;
        if ((ecdsaParams = this.params_) == null) {
            ecdsaParams = EcdsaParams.O();
        }
        return ecdsaParams;
    }
    
    public int Q() {
        return this.version_;
    }
    
    public ByteString R() {
        return this.x_;
    }
    
    public ByteString S() {
        return this.y_;
    }
    
    @Override
    protected final Object q(final MethodToInvoke methodToInvoke, final Object o, final Object o2) {
        switch (EcdsaPublicKey$a.a[methodToInvoke.ordinal()]) {
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
                final Parser<EcdsaPublicKey> parser;
                if ((parser = EcdsaPublicKey.PARSER) == null) {
                    synchronized (EcdsaPublicKey.class) {
                        if (EcdsaPublicKey.PARSER == null) {
                            EcdsaPublicKey.PARSER = new DefaultInstanceBasedParser<EcdsaPublicKey>(EcdsaPublicKey.DEFAULT_INSTANCE);
                        }
                    }
                }
                return parser;
            }
            case 4: {
                return EcdsaPublicKey.DEFAULT_INSTANCE;
            }
            case 3: {
                return GeneratedMessageLite.A(EcdsaPublicKey.DEFAULT_INSTANCE, "\u0000\u0004\u0000\u0000\u0001\u0004\u0004\u0000\u0000\u0000\u0001\u000b\u0002\t\u0003\n\u0004\n", new Object[] { "version_", "params_", "x_", "y_" });
            }
            case 2: {
                return new Builder((EcdsaPublicKey$a)null);
            }
            case 1: {
                return new EcdsaPublicKey();
            }
        }
    }
    
    public static final class Builder extends GeneratedMessageLite.Builder<EcdsaPublicKey, Builder> implements EcdsaPublicKeyOrBuilder
    {
        private Builder() {
            super(EcdsaPublicKey.J());
        }
        
        Builder(final EcdsaPublicKey$a object) {
            this();
        }
        
        public Builder D(final EcdsaParams ecdsaParams) {
            ((GeneratedMessageLite.Builder)this).u();
            EcdsaPublicKey.L((EcdsaPublicKey)super.b, ecdsaParams);
            return this;
        }
        
        public Builder E(final int n) {
            ((GeneratedMessageLite.Builder)this).u();
            EcdsaPublicKey.K((EcdsaPublicKey)super.b, n);
            return this;
        }
        
        public Builder F(final ByteString byteString) {
            ((GeneratedMessageLite.Builder)this).u();
            EcdsaPublicKey.M((EcdsaPublicKey)super.b, byteString);
            return this;
        }
        
        public Builder G(final ByteString byteString) {
            ((GeneratedMessageLite.Builder)this).u();
            EcdsaPublicKey.N((EcdsaPublicKey)super.b, byteString);
            return this;
        }
    }
}
