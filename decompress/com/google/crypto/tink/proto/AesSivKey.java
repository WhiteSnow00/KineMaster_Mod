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

public final class AesSivKey extends GeneratedMessageLite<AesSivKey, Builder> implements AesSivKeyOrBuilder
{
    private static final AesSivKey DEFAULT_INSTANCE;
    public static final int KEY_VALUE_FIELD_NUMBER = 2;
    private static volatile Parser<AesSivKey> PARSER;
    public static final int VERSION_FIELD_NUMBER = 1;
    private ByteString keyValue_;
    private int version_;
    
    static {
        GeneratedMessageLite.H(AesSivKey.class, DEFAULT_INSTANCE = new AesSivKey());
    }
    
    private AesSivKey() {
        this.keyValue_ = ByteString.EMPTY;
    }
    
    static AesSivKey J() {
        return AesSivKey.DEFAULT_INSTANCE;
    }
    
    static void K(final AesSivKey aesSivKey, final int n) {
        aesSivKey.R(n);
    }
    
    static void L(final AesSivKey aesSivKey, final ByteString byteString) {
        aesSivKey.Q(byteString);
    }
    
    public static Builder O() {
        return ((GeneratedMessageLite<GeneratedMessageLite, GeneratedMessageLite.Builder>)AesSivKey.DEFAULT_INSTANCE).n();
    }
    
    public static AesSivKey P(final ByteString byteString, final ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return GeneratedMessageLite.B(AesSivKey.DEFAULT_INSTANCE, byteString, extensionRegistryLite);
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
        switch (AesSivKey$a.a[methodToInvoke.ordinal()]) {
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
                final Parser<AesSivKey> parser;
                if ((parser = AesSivKey.PARSER) == null) {
                    synchronized (AesSivKey.class) {
                        if (AesSivKey.PARSER == null) {
                            AesSivKey.PARSER = new DefaultInstanceBasedParser<AesSivKey>(AesSivKey.DEFAULT_INSTANCE);
                        }
                    }
                }
                return parser;
            }
            case 4: {
                return AesSivKey.DEFAULT_INSTANCE;
            }
            case 3: {
                return GeneratedMessageLite.A(AesSivKey.DEFAULT_INSTANCE, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0000\u0000\u0001\u000b\u0002\n", new Object[] { "version_", "keyValue_" });
            }
            case 2: {
                return new Builder((AesSivKey$a)null);
            }
            case 1: {
                return new AesSivKey();
            }
        }
    }
    
    public static final class Builder extends GeneratedMessageLite.Builder<AesSivKey, Builder> implements AesSivKeyOrBuilder
    {
        private Builder() {
            super(AesSivKey.J());
        }
        
        Builder(final AesSivKey$a object) {
            this();
        }
        
        public Builder D(final ByteString byteString) {
            ((GeneratedMessageLite.Builder)this).u();
            AesSivKey.L((AesSivKey)super.b, byteString);
            return this;
        }
        
        public Builder E(final int n) {
            ((GeneratedMessageLite.Builder)this).u();
            AesSivKey.K((AesSivKey)super.b, n);
            return this;
        }
    }
}
