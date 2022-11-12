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

public final class AesGcmKey extends GeneratedMessageLite<AesGcmKey, Builder> implements AesGcmKeyOrBuilder
{
    private static final AesGcmKey DEFAULT_INSTANCE;
    public static final int KEY_VALUE_FIELD_NUMBER = 3;
    private static volatile Parser<AesGcmKey> PARSER;
    public static final int VERSION_FIELD_NUMBER = 1;
    private ByteString keyValue_;
    private int version_;
    
    static {
        GeneratedMessageLite.H(AesGcmKey.class, DEFAULT_INSTANCE = new AesGcmKey());
    }
    
    private AesGcmKey() {
        this.keyValue_ = ByteString.EMPTY;
    }
    
    static AesGcmKey J() {
        return AesGcmKey.DEFAULT_INSTANCE;
    }
    
    static void K(final AesGcmKey aesGcmKey, final int n) {
        aesGcmKey.R(n);
    }
    
    static void L(final AesGcmKey aesGcmKey, final ByteString byteString) {
        aesGcmKey.Q(byteString);
    }
    
    public static Builder O() {
        return ((GeneratedMessageLite<GeneratedMessageLite, GeneratedMessageLite.Builder>)AesGcmKey.DEFAULT_INSTANCE).n();
    }
    
    public static AesGcmKey P(final ByteString byteString, final ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return GeneratedMessageLite.B(AesGcmKey.DEFAULT_INSTANCE, byteString, extensionRegistryLite);
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
        switch (AesGcmKey$a.a[methodToInvoke.ordinal()]) {
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
                final Parser<AesGcmKey> parser;
                if ((parser = AesGcmKey.PARSER) == null) {
                    synchronized (AesGcmKey.class) {
                        if (AesGcmKey.PARSER == null) {
                            AesGcmKey.PARSER = new DefaultInstanceBasedParser<AesGcmKey>(AesGcmKey.DEFAULT_INSTANCE);
                        }
                    }
                }
                return parser;
            }
            case 4: {
                return AesGcmKey.DEFAULT_INSTANCE;
            }
            case 3: {
                return GeneratedMessageLite.A(AesGcmKey.DEFAULT_INSTANCE, "\u0000\u0002\u0000\u0000\u0001\u0003\u0002\u0000\u0000\u0000\u0001\u000b\u0003\n", new Object[] { "version_", "keyValue_" });
            }
            case 2: {
                return new Builder((AesGcmKey$a)null);
            }
            case 1: {
                return new AesGcmKey();
            }
        }
    }
    
    public static final class Builder extends GeneratedMessageLite.Builder<AesGcmKey, Builder> implements AesGcmKeyOrBuilder
    {
        private Builder() {
            super(AesGcmKey.J());
        }
        
        Builder(final AesGcmKey$a object) {
            this();
        }
        
        public Builder D(final ByteString byteString) {
            ((GeneratedMessageLite.Builder)this).u();
            AesGcmKey.L((AesGcmKey)super.b, byteString);
            return this;
        }
        
        public Builder E(final int n) {
            ((GeneratedMessageLite.Builder)this).u();
            AesGcmKey.K((AesGcmKey)super.b, n);
            return this;
        }
    }
}
