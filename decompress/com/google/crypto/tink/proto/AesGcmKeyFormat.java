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

public final class AesGcmKeyFormat extends GeneratedMessageLite<AesGcmKeyFormat, Builder> implements AesGcmKeyFormatOrBuilder
{
    private static final AesGcmKeyFormat DEFAULT_INSTANCE;
    public static final int KEY_SIZE_FIELD_NUMBER = 2;
    private static volatile Parser<AesGcmKeyFormat> PARSER;
    public static final int VERSION_FIELD_NUMBER = 3;
    private int keySize_;
    private int version_;
    
    static {
        GeneratedMessageLite.H(AesGcmKeyFormat.class, DEFAULT_INSTANCE = new AesGcmKeyFormat());
    }
    
    private AesGcmKeyFormat() {
    }
    
    static AesGcmKeyFormat J() {
        return AesGcmKeyFormat.DEFAULT_INSTANCE;
    }
    
    static void K(final AesGcmKeyFormat aesGcmKeyFormat, final int n) {
        aesGcmKeyFormat.O(n);
    }
    
    public static Builder M() {
        return ((GeneratedMessageLite<GeneratedMessageLite, GeneratedMessageLite.Builder>)AesGcmKeyFormat.DEFAULT_INSTANCE).n();
    }
    
    public static AesGcmKeyFormat N(final ByteString byteString, final ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return GeneratedMessageLite.B(AesGcmKeyFormat.DEFAULT_INSTANCE, byteString, extensionRegistryLite);
    }
    
    private void O(final int keySize_) {
        this.keySize_ = keySize_;
    }
    
    public int L() {
        return this.keySize_;
    }
    
    @Override
    protected final Object q(final MethodToInvoke methodToInvoke, final Object o, final Object o2) {
        switch (AesGcmKeyFormat$a.a[methodToInvoke.ordinal()]) {
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
                final Parser<AesGcmKeyFormat> parser;
                if ((parser = AesGcmKeyFormat.PARSER) == null) {
                    synchronized (AesGcmKeyFormat.class) {
                        if (AesGcmKeyFormat.PARSER == null) {
                            AesGcmKeyFormat.PARSER = new DefaultInstanceBasedParser<AesGcmKeyFormat>(AesGcmKeyFormat.DEFAULT_INSTANCE);
                        }
                    }
                }
                return parser;
            }
            case 4: {
                return AesGcmKeyFormat.DEFAULT_INSTANCE;
            }
            case 3: {
                return GeneratedMessageLite.A(AesGcmKeyFormat.DEFAULT_INSTANCE, "\u0000\u0002\u0000\u0000\u0002\u0003\u0002\u0000\u0000\u0000\u0002\u000b\u0003\u000b", new Object[] { "keySize_", "version_" });
            }
            case 2: {
                return new Builder((AesGcmKeyFormat$a)null);
            }
            case 1: {
                return new AesGcmKeyFormat();
            }
        }
    }
    
    public static final class Builder extends GeneratedMessageLite.Builder<AesGcmKeyFormat, Builder> implements AesGcmKeyFormatOrBuilder
    {
        private Builder() {
            super(AesGcmKeyFormat.J());
        }
        
        Builder(final AesGcmKeyFormat$a object) {
            this();
        }
        
        public Builder D(final int n) {
            ((GeneratedMessageLite.Builder)this).u();
            AesGcmKeyFormat.K((AesGcmKeyFormat)super.b, n);
            return this;
        }
    }
}
