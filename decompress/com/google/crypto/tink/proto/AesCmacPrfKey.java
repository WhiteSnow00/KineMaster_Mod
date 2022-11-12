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

public final class AesCmacPrfKey extends GeneratedMessageLite<AesCmacPrfKey, Builder> implements AesCmacPrfKeyOrBuilder
{
    private static final AesCmacPrfKey DEFAULT_INSTANCE;
    public static final int KEY_VALUE_FIELD_NUMBER = 2;
    private static volatile Parser<AesCmacPrfKey> PARSER;
    public static final int VERSION_FIELD_NUMBER = 1;
    private ByteString keyValue_;
    private int version_;
    
    static {
        GeneratedMessageLite.H(AesCmacPrfKey.class, DEFAULT_INSTANCE = new AesCmacPrfKey());
    }
    
    private AesCmacPrfKey() {
        this.keyValue_ = ByteString.EMPTY;
    }
    
    static AesCmacPrfKey J() {
        return AesCmacPrfKey.DEFAULT_INSTANCE;
    }
    
    static void K(final AesCmacPrfKey aesCmacPrfKey, final int n) {
        aesCmacPrfKey.R(n);
    }
    
    static void L(final AesCmacPrfKey aesCmacPrfKey, final ByteString byteString) {
        aesCmacPrfKey.Q(byteString);
    }
    
    public static Builder O() {
        return ((GeneratedMessageLite<GeneratedMessageLite, GeneratedMessageLite.Builder>)AesCmacPrfKey.DEFAULT_INSTANCE).n();
    }
    
    public static AesCmacPrfKey P(final ByteString byteString, final ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return GeneratedMessageLite.B(AesCmacPrfKey.DEFAULT_INSTANCE, byteString, extensionRegistryLite);
    }
    
    private void Q(final ByteString keyValue_) {
        keyValue_.getClass();
        this.keyValue_ = keyValue_;
    }
    
    private void R(final int version_) {
        this.version_ = version_;
    }
    
    public ByteString M() {
        return this.keyValue_;
    }
    
    public int N() {
        return this.version_;
    }
    
    @Override
    protected final Object q(final MethodToInvoke methodToInvoke, final Object o, final Object o2) {
        switch (AesCmacPrfKey$a.a[methodToInvoke.ordinal()]) {
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
                final Parser<AesCmacPrfKey> parser;
                if ((parser = AesCmacPrfKey.PARSER) == null) {
                    synchronized (AesCmacPrfKey.class) {
                        if (AesCmacPrfKey.PARSER == null) {
                            AesCmacPrfKey.PARSER = new DefaultInstanceBasedParser<AesCmacPrfKey>(AesCmacPrfKey.DEFAULT_INSTANCE);
                        }
                    }
                }
                return parser;
            }
            case 4: {
                return AesCmacPrfKey.DEFAULT_INSTANCE;
            }
            case 3: {
                return GeneratedMessageLite.A(AesCmacPrfKey.DEFAULT_INSTANCE, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0000\u0000\u0001\u000b\u0002\n", new Object[] { "version_", "keyValue_" });
            }
            case 2: {
                return new Builder((AesCmacPrfKey$a)null);
            }
            case 1: {
                return new AesCmacPrfKey();
            }
        }
    }
    
    public static final class Builder extends GeneratedMessageLite.Builder<AesCmacPrfKey, Builder> implements AesCmacPrfKeyOrBuilder
    {
        private Builder() {
            super(AesCmacPrfKey.J());
        }
        
        Builder(final AesCmacPrfKey$a object) {
            this();
        }
        
        public Builder D(final ByteString byteString) {
            ((GeneratedMessageLite.Builder)this).u();
            AesCmacPrfKey.L((AesCmacPrfKey)super.b, byteString);
            return this;
        }
        
        public Builder E(final int n) {
            ((GeneratedMessageLite.Builder)this).u();
            AesCmacPrfKey.K((AesCmacPrfKey)super.b, n);
            return this;
        }
    }
}
