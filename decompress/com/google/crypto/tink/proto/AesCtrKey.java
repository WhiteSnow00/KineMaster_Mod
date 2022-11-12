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

public final class AesCtrKey extends GeneratedMessageLite<AesCtrKey, Builder> implements AesCtrKeyOrBuilder
{
    private static final AesCtrKey DEFAULT_INSTANCE;
    public static final int KEY_VALUE_FIELD_NUMBER = 3;
    public static final int PARAMS_FIELD_NUMBER = 2;
    private static volatile Parser<AesCtrKey> PARSER;
    public static final int VERSION_FIELD_NUMBER = 1;
    private ByteString keyValue_;
    private AesCtrParams params_;
    private int version_;
    
    static {
        GeneratedMessageLite.H(AesCtrKey.class, DEFAULT_INSTANCE = new AesCtrKey());
    }
    
    private AesCtrKey() {
        this.keyValue_ = ByteString.EMPTY;
    }
    
    static AesCtrKey J() {
        return AesCtrKey.DEFAULT_INSTANCE;
    }
    
    static void K(final AesCtrKey aesCtrKey, final int n) {
        aesCtrKey.V(n);
    }
    
    static void L(final AesCtrKey aesCtrKey, final AesCtrParams aesCtrParams) {
        aesCtrKey.U(aesCtrParams);
    }
    
    static void M(final AesCtrKey aesCtrKey, final ByteString byteString) {
        aesCtrKey.T(byteString);
    }
    
    public static AesCtrKey N() {
        return AesCtrKey.DEFAULT_INSTANCE;
    }
    
    public static Builder R() {
        return ((GeneratedMessageLite<GeneratedMessageLite, GeneratedMessageLite.Builder>)AesCtrKey.DEFAULT_INSTANCE).n();
    }
    
    public static AesCtrKey S(final ByteString byteString, final ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return GeneratedMessageLite.B(AesCtrKey.DEFAULT_INSTANCE, byteString, extensionRegistryLite);
    }
    
    private void T(final ByteString keyValue_) {
        keyValue_.getClass();
        this.keyValue_ = keyValue_;
    }
    
    private void U(final AesCtrParams params_) {
        params_.getClass();
        this.params_ = params_;
    }
    
    private void V(final int version_) {
        this.version_ = version_;
    }
    
    public ByteString O() {
        return this.keyValue_;
    }
    
    public AesCtrParams P() {
        AesCtrParams aesCtrParams;
        if ((aesCtrParams = this.params_) == null) {
            aesCtrParams = AesCtrParams.L();
        }
        return aesCtrParams;
    }
    
    public int Q() {
        return this.version_;
    }
    
    @Override
    protected final Object q(final MethodToInvoke methodToInvoke, final Object o, final Object o2) {
        switch (AesCtrKey$a.a[methodToInvoke.ordinal()]) {
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
                final Parser<AesCtrKey> parser;
                if ((parser = AesCtrKey.PARSER) == null) {
                    synchronized (AesCtrKey.class) {
                        if (AesCtrKey.PARSER == null) {
                            AesCtrKey.PARSER = new DefaultInstanceBasedParser<AesCtrKey>(AesCtrKey.DEFAULT_INSTANCE);
                        }
                    }
                }
                return parser;
            }
            case 4: {
                return AesCtrKey.DEFAULT_INSTANCE;
            }
            case 3: {
                return GeneratedMessageLite.A(AesCtrKey.DEFAULT_INSTANCE, "\u0000\u0003\u0000\u0000\u0001\u0003\u0003\u0000\u0000\u0000\u0001\u000b\u0002\t\u0003\n", new Object[] { "version_", "params_", "keyValue_" });
            }
            case 2: {
                return new Builder((AesCtrKey$a)null);
            }
            case 1: {
                return new AesCtrKey();
            }
        }
    }
    
    public static final class Builder extends GeneratedMessageLite.Builder<AesCtrKey, Builder> implements AesCtrKeyOrBuilder
    {
        private Builder() {
            super(AesCtrKey.J());
        }
        
        Builder(final AesCtrKey$a object) {
            this();
        }
        
        public Builder D(final ByteString byteString) {
            ((GeneratedMessageLite.Builder)this).u();
            AesCtrKey.M((AesCtrKey)super.b, byteString);
            return this;
        }
        
        public Builder E(final AesCtrParams aesCtrParams) {
            ((GeneratedMessageLite.Builder)this).u();
            AesCtrKey.L((AesCtrKey)super.b, aesCtrParams);
            return this;
        }
        
        public Builder F(final int n) {
            ((GeneratedMessageLite.Builder)this).u();
            AesCtrKey.K((AesCtrKey)super.b, n);
            return this;
        }
    }
}
