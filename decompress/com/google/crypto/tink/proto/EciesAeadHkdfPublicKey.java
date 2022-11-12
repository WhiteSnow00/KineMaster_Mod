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

public final class EciesAeadHkdfPublicKey extends GeneratedMessageLite<EciesAeadHkdfPublicKey, Builder> implements EciesAeadHkdfPublicKeyOrBuilder
{
    private static final EciesAeadHkdfPublicKey DEFAULT_INSTANCE;
    public static final int PARAMS_FIELD_NUMBER = 2;
    private static volatile Parser<EciesAeadHkdfPublicKey> PARSER;
    public static final int VERSION_FIELD_NUMBER = 1;
    public static final int X_FIELD_NUMBER = 3;
    public static final int Y_FIELD_NUMBER = 4;
    private EciesAeadHkdfParams params_;
    private int version_;
    private ByteString x_;
    private ByteString y_;
    
    static {
        GeneratedMessageLite.H(EciesAeadHkdfPublicKey.class, DEFAULT_INSTANCE = new EciesAeadHkdfPublicKey());
    }
    
    private EciesAeadHkdfPublicKey() {
        final ByteString empty = ByteString.EMPTY;
        this.x_ = empty;
        this.y_ = empty;
    }
    
    static EciesAeadHkdfPublicKey J() {
        return EciesAeadHkdfPublicKey.DEFAULT_INSTANCE;
    }
    
    static void K(final EciesAeadHkdfPublicKey eciesAeadHkdfPublicKey, final int n) {
        eciesAeadHkdfPublicKey.W(n);
    }
    
    static void L(final EciesAeadHkdfPublicKey eciesAeadHkdfPublicKey, final EciesAeadHkdfParams eciesAeadHkdfParams) {
        eciesAeadHkdfPublicKey.V(eciesAeadHkdfParams);
    }
    
    static void M(final EciesAeadHkdfPublicKey eciesAeadHkdfPublicKey, final ByteString byteString) {
        eciesAeadHkdfPublicKey.X(byteString);
    }
    
    static void N(final EciesAeadHkdfPublicKey eciesAeadHkdfPublicKey, final ByteString byteString) {
        eciesAeadHkdfPublicKey.Y(byteString);
    }
    
    public static EciesAeadHkdfPublicKey O() {
        return EciesAeadHkdfPublicKey.DEFAULT_INSTANCE;
    }
    
    public static Builder T() {
        return ((GeneratedMessageLite<GeneratedMessageLite, GeneratedMessageLite.Builder>)EciesAeadHkdfPublicKey.DEFAULT_INSTANCE).n();
    }
    
    public static EciesAeadHkdfPublicKey U(final ByteString byteString, final ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return GeneratedMessageLite.B(EciesAeadHkdfPublicKey.DEFAULT_INSTANCE, byteString, extensionRegistryLite);
    }
    
    private void V(final EciesAeadHkdfParams params_) {
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
    
    public EciesAeadHkdfParams P() {
        EciesAeadHkdfParams eciesAeadHkdfParams;
        if ((eciesAeadHkdfParams = this.params_) == null) {
            eciesAeadHkdfParams = EciesAeadHkdfParams.N();
        }
        return eciesAeadHkdfParams;
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
        switch (EciesAeadHkdfPublicKey$a.a[methodToInvoke.ordinal()]) {
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
                final Parser<EciesAeadHkdfPublicKey> parser;
                if ((parser = EciesAeadHkdfPublicKey.PARSER) == null) {
                    synchronized (EciesAeadHkdfPublicKey.class) {
                        if (EciesAeadHkdfPublicKey.PARSER == null) {
                            EciesAeadHkdfPublicKey.PARSER = new DefaultInstanceBasedParser<EciesAeadHkdfPublicKey>(EciesAeadHkdfPublicKey.DEFAULT_INSTANCE);
                        }
                    }
                }
                return parser;
            }
            case 4: {
                return EciesAeadHkdfPublicKey.DEFAULT_INSTANCE;
            }
            case 3: {
                return GeneratedMessageLite.A(EciesAeadHkdfPublicKey.DEFAULT_INSTANCE, "\u0000\u0004\u0000\u0000\u0001\u0004\u0004\u0000\u0000\u0000\u0001\u000b\u0002\t\u0003\n\u0004\n", new Object[] { "version_", "params_", "x_", "y_" });
            }
            case 2: {
                return new Builder((EciesAeadHkdfPublicKey$a)null);
            }
            case 1: {
                return new EciesAeadHkdfPublicKey();
            }
        }
    }
    
    public static final class Builder extends GeneratedMessageLite.Builder<EciesAeadHkdfPublicKey, Builder> implements EciesAeadHkdfPublicKeyOrBuilder
    {
        private Builder() {
            super(EciesAeadHkdfPublicKey.J());
        }
        
        Builder(final EciesAeadHkdfPublicKey$a object) {
            this();
        }
        
        public Builder D(final EciesAeadHkdfParams eciesAeadHkdfParams) {
            ((GeneratedMessageLite.Builder)this).u();
            EciesAeadHkdfPublicKey.L((EciesAeadHkdfPublicKey)super.b, eciesAeadHkdfParams);
            return this;
        }
        
        public Builder E(final int n) {
            ((GeneratedMessageLite.Builder)this).u();
            EciesAeadHkdfPublicKey.K((EciesAeadHkdfPublicKey)super.b, n);
            return this;
        }
        
        public Builder F(final ByteString byteString) {
            ((GeneratedMessageLite.Builder)this).u();
            EciesAeadHkdfPublicKey.M((EciesAeadHkdfPublicKey)super.b, byteString);
            return this;
        }
        
        public Builder G(final ByteString byteString) {
            ((GeneratedMessageLite.Builder)this).u();
            EciesAeadHkdfPublicKey.N((EciesAeadHkdfPublicKey)super.b, byteString);
            return this;
        }
    }
}
