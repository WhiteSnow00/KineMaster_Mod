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

public final class AesGcmSivKeyFormat extends GeneratedMessageLite<AesGcmSivKeyFormat, Builder> implements AesGcmSivKeyFormatOrBuilder
{
    private static final AesGcmSivKeyFormat DEFAULT_INSTANCE;
    public static final int KEY_SIZE_FIELD_NUMBER = 2;
    private static volatile Parser<AesGcmSivKeyFormat> PARSER;
    public static final int VERSION_FIELD_NUMBER = 1;
    private int keySize_;
    private int version_;
    
    static {
        GeneratedMessageLite.H(AesGcmSivKeyFormat.class, DEFAULT_INSTANCE = new AesGcmSivKeyFormat());
    }
    
    private AesGcmSivKeyFormat() {
    }
    
    static AesGcmSivKeyFormat J() {
        return AesGcmSivKeyFormat.DEFAULT_INSTANCE;
    }
    
    public static AesGcmSivKeyFormat L(final ByteString byteString, final ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return GeneratedMessageLite.B(AesGcmSivKeyFormat.DEFAULT_INSTANCE, byteString, extensionRegistryLite);
    }
    
    public int K() {
        return this.keySize_;
    }
    
    @Override
    protected final Object q(final MethodToInvoke methodToInvoke, final Object o, final Object o2) {
        switch (AesGcmSivKeyFormat$a.a[methodToInvoke.ordinal()]) {
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
                final Parser<AesGcmSivKeyFormat> parser;
                if ((parser = AesGcmSivKeyFormat.PARSER) == null) {
                    synchronized (AesGcmSivKeyFormat.class) {
                        if (AesGcmSivKeyFormat.PARSER == null) {
                            AesGcmSivKeyFormat.PARSER = new DefaultInstanceBasedParser<AesGcmSivKeyFormat>(AesGcmSivKeyFormat.DEFAULT_INSTANCE);
                        }
                    }
                }
                return parser;
            }
            case 4: {
                return AesGcmSivKeyFormat.DEFAULT_INSTANCE;
            }
            case 3: {
                return GeneratedMessageLite.A(AesGcmSivKeyFormat.DEFAULT_INSTANCE, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0000\u0000\u0001\u000b\u0002\u000b", new Object[] { "version_", "keySize_" });
            }
            case 2: {
                return new Builder((AesGcmSivKeyFormat$a)null);
            }
            case 1: {
                return new AesGcmSivKeyFormat();
            }
        }
    }
    
    public static final class Builder extends GeneratedMessageLite.Builder<AesGcmSivKeyFormat, Builder> implements AesGcmSivKeyFormatOrBuilder
    {
        private Builder() {
            super(AesGcmSivKeyFormat.J());
        }
        
        Builder(final AesGcmSivKeyFormat$a object) {
            this();
        }
    }
}
