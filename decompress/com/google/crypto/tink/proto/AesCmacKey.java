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

public final class AesCmacKey extends GeneratedMessageLite<AesCmacKey, Builder> implements AesCmacKeyOrBuilder
{
    private static final AesCmacKey DEFAULT_INSTANCE;
    public static final int KEY_VALUE_FIELD_NUMBER = 2;
    public static final int PARAMS_FIELD_NUMBER = 3;
    private static volatile Parser<AesCmacKey> PARSER;
    public static final int VERSION_FIELD_NUMBER = 1;
    private ByteString keyValue_;
    private AesCmacParams params_;
    private int version_;
    
    static {
        GeneratedMessageLite.H(AesCmacKey.class, DEFAULT_INSTANCE = new AesCmacKey());
    }
    
    private AesCmacKey() {
        this.keyValue_ = ByteString.EMPTY;
    }
    
    static AesCmacKey J() {
        return AesCmacKey.DEFAULT_INSTANCE;
    }
    
    static void K(final AesCmacKey aesCmacKey, final int n) {
        aesCmacKey.U(n);
    }
    
    static void L(final AesCmacKey aesCmacKey, final ByteString byteString) {
        aesCmacKey.S(byteString);
    }
    
    static void M(final AesCmacKey aesCmacKey, final AesCmacParams aesCmacParams) {
        aesCmacKey.T(aesCmacParams);
    }
    
    public static Builder Q() {
        return ((GeneratedMessageLite<GeneratedMessageLite, GeneratedMessageLite.Builder>)AesCmacKey.DEFAULT_INSTANCE).n();
    }
    
    public static AesCmacKey R(final ByteString byteString, final ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return GeneratedMessageLite.B(AesCmacKey.DEFAULT_INSTANCE, byteString, extensionRegistryLite);
    }
    
    private void S(final ByteString keyValue_) {
        keyValue_.getClass();
        this.keyValue_ = keyValue_;
    }
    
    private void T(final AesCmacParams params_) {
        params_.getClass();
        this.params_ = params_;
    }
    
    private void U(final int version_) {
        this.version_ = version_;
    }
    
    public ByteString N() {
        return this.keyValue_;
    }
    
    public AesCmacParams O() {
        AesCmacParams aesCmacParams;
        if ((aesCmacParams = this.params_) == null) {
            aesCmacParams = AesCmacParams.L();
        }
        return aesCmacParams;
    }
    
    public int P() {
        return this.version_;
    }
    
    @Override
    protected final Object q(final MethodToInvoke methodToInvoke, final Object o, final Object o2) {
        switch (AesCmacKey$a.a[methodToInvoke.ordinal()]) {
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
                final Parser<AesCmacKey> parser;
                if ((parser = AesCmacKey.PARSER) == null) {
                    synchronized (AesCmacKey.class) {
                        if (AesCmacKey.PARSER == null) {
                            AesCmacKey.PARSER = new DefaultInstanceBasedParser<AesCmacKey>(AesCmacKey.DEFAULT_INSTANCE);
                        }
                    }
                }
                return parser;
            }
            case 4: {
                return AesCmacKey.DEFAULT_INSTANCE;
            }
            case 3: {
                return GeneratedMessageLite.A(AesCmacKey.DEFAULT_INSTANCE, "\u0000\u0003\u0000\u0000\u0001\u0003\u0003\u0000\u0000\u0000\u0001\u000b\u0002\n\u0003\t", new Object[] { "version_", "keyValue_", "params_" });
            }
            case 2: {
                return new Builder((AesCmacKey$a)null);
            }
            case 1: {
                return new AesCmacKey();
            }
        }
    }
    
    public static final class Builder extends GeneratedMessageLite.Builder<AesCmacKey, Builder> implements AesCmacKeyOrBuilder
    {
        private Builder() {
            super(AesCmacKey.J());
        }
        
        Builder(final AesCmacKey$a object) {
            this();
        }
        
        public Builder D(final ByteString byteString) {
            ((GeneratedMessageLite.Builder)this).u();
            AesCmacKey.L((AesCmacKey)super.b, byteString);
            return this;
        }
        
        public Builder E(final AesCmacParams aesCmacParams) {
            ((GeneratedMessageLite.Builder)this).u();
            AesCmacKey.M((AesCmacKey)super.b, aesCmacParams);
            return this;
        }
        
        public Builder F(final int n) {
            ((GeneratedMessageLite.Builder)this).u();
            AesCmacKey.K((AesCmacKey)super.b, n);
            return this;
        }
    }
}
