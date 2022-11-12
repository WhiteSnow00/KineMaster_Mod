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

public final class AesEaxKey extends GeneratedMessageLite<AesEaxKey, Builder> implements AesEaxKeyOrBuilder
{
    private static final AesEaxKey DEFAULT_INSTANCE;
    public static final int KEY_VALUE_FIELD_NUMBER = 3;
    public static final int PARAMS_FIELD_NUMBER = 2;
    private static volatile Parser<AesEaxKey> PARSER;
    public static final int VERSION_FIELD_NUMBER = 1;
    private ByteString keyValue_;
    private AesEaxParams params_;
    private int version_;
    
    static {
        GeneratedMessageLite.H(AesEaxKey.class, DEFAULT_INSTANCE = new AesEaxKey());
    }
    
    private AesEaxKey() {
        this.keyValue_ = ByteString.EMPTY;
    }
    
    static AesEaxKey J() {
        return AesEaxKey.DEFAULT_INSTANCE;
    }
    
    static void K(final AesEaxKey aesEaxKey, final int n) {
        aesEaxKey.U(n);
    }
    
    static void L(final AesEaxKey aesEaxKey, final AesEaxParams aesEaxParams) {
        aesEaxKey.T(aesEaxParams);
    }
    
    static void M(final AesEaxKey aesEaxKey, final ByteString byteString) {
        aesEaxKey.S(byteString);
    }
    
    public static Builder Q() {
        return ((GeneratedMessageLite<GeneratedMessageLite, GeneratedMessageLite.Builder>)AesEaxKey.DEFAULT_INSTANCE).n();
    }
    
    public static AesEaxKey R(final ByteString byteString, final ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return GeneratedMessageLite.B(AesEaxKey.DEFAULT_INSTANCE, byteString, extensionRegistryLite);
    }
    
    private void S(final ByteString keyValue_) {
        keyValue_.getClass();
        this.keyValue_ = keyValue_;
    }
    
    private void T(final AesEaxParams params_) {
        params_.getClass();
        this.params_ = params_;
    }
    
    private void U(final int version_) {
        this.version_ = version_;
    }
    
    public ByteString N() {
        return this.keyValue_;
    }
    
    public AesEaxParams O() {
        AesEaxParams aesEaxParams;
        if ((aesEaxParams = this.params_) == null) {
            aesEaxParams = AesEaxParams.L();
        }
        return aesEaxParams;
    }
    
    public int P() {
        return this.version_;
    }
    
    @Override
    protected final Object q(final MethodToInvoke methodToInvoke, final Object o, final Object o2) {
        switch (AesEaxKey$a.a[methodToInvoke.ordinal()]) {
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
                final Parser<AesEaxKey> parser;
                if ((parser = AesEaxKey.PARSER) == null) {
                    synchronized (AesEaxKey.class) {
                        if (AesEaxKey.PARSER == null) {
                            AesEaxKey.PARSER = new DefaultInstanceBasedParser<AesEaxKey>(AesEaxKey.DEFAULT_INSTANCE);
                        }
                    }
                }
                return parser;
            }
            case 4: {
                return AesEaxKey.DEFAULT_INSTANCE;
            }
            case 3: {
                return GeneratedMessageLite.A(AesEaxKey.DEFAULT_INSTANCE, "\u0000\u0003\u0000\u0000\u0001\u0003\u0003\u0000\u0000\u0000\u0001\u000b\u0002\t\u0003\n", new Object[] { "version_", "params_", "keyValue_" });
            }
            case 2: {
                return new Builder((AesEaxKey$a)null);
            }
            case 1: {
                return new AesEaxKey();
            }
        }
    }
    
    public static final class Builder extends GeneratedMessageLite.Builder<AesEaxKey, Builder> implements AesEaxKeyOrBuilder
    {
        private Builder() {
            super(AesEaxKey.J());
        }
        
        Builder(final AesEaxKey$a object) {
            this();
        }
        
        public Builder D(final ByteString byteString) {
            ((GeneratedMessageLite.Builder)this).u();
            AesEaxKey.M((AesEaxKey)super.b, byteString);
            return this;
        }
        
        public Builder E(final AesEaxParams aesEaxParams) {
            ((GeneratedMessageLite.Builder)this).u();
            AesEaxKey.L((AesEaxKey)super.b, aesEaxParams);
            return this;
        }
        
        public Builder F(final int n) {
            ((GeneratedMessageLite.Builder)this).u();
            AesEaxKey.K((AesEaxKey)super.b, n);
            return this;
        }
    }
}
