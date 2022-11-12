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

public final class ChaCha20Poly1305KeyFormat extends GeneratedMessageLite<ChaCha20Poly1305KeyFormat, Builder> implements ChaCha20Poly1305KeyFormatOrBuilder
{
    private static final ChaCha20Poly1305KeyFormat DEFAULT_INSTANCE;
    private static volatile Parser<ChaCha20Poly1305KeyFormat> PARSER;
    
    static {
        GeneratedMessageLite.H(ChaCha20Poly1305KeyFormat.class, DEFAULT_INSTANCE = new ChaCha20Poly1305KeyFormat());
    }
    
    private ChaCha20Poly1305KeyFormat() {
    }
    
    static ChaCha20Poly1305KeyFormat J() {
        return ChaCha20Poly1305KeyFormat.DEFAULT_INSTANCE;
    }
    
    public static ChaCha20Poly1305KeyFormat K(final ByteString byteString, final ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return GeneratedMessageLite.B(ChaCha20Poly1305KeyFormat.DEFAULT_INSTANCE, byteString, extensionRegistryLite);
    }
    
    @Override
    protected final Object q(final MethodToInvoke methodToInvoke, final Object o, final Object o2) {
        switch (ChaCha20Poly1305KeyFormat$a.a[methodToInvoke.ordinal()]) {
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
                final Parser<ChaCha20Poly1305KeyFormat> parser;
                if ((parser = ChaCha20Poly1305KeyFormat.PARSER) == null) {
                    synchronized (ChaCha20Poly1305KeyFormat.class) {
                        if (ChaCha20Poly1305KeyFormat.PARSER == null) {
                            ChaCha20Poly1305KeyFormat.PARSER = new DefaultInstanceBasedParser<ChaCha20Poly1305KeyFormat>(ChaCha20Poly1305KeyFormat.DEFAULT_INSTANCE);
                        }
                    }
                }
                return parser;
            }
            case 4: {
                return ChaCha20Poly1305KeyFormat.DEFAULT_INSTANCE;
            }
            case 3: {
                return GeneratedMessageLite.A(ChaCha20Poly1305KeyFormat.DEFAULT_INSTANCE, "\u0000\u0000", null);
            }
            case 2: {
                return new Builder((ChaCha20Poly1305KeyFormat$a)null);
            }
            case 1: {
                return new ChaCha20Poly1305KeyFormat();
            }
        }
    }
    
    public static final class Builder extends GeneratedMessageLite.Builder<ChaCha20Poly1305KeyFormat, Builder> implements ChaCha20Poly1305KeyFormatOrBuilder
    {
        private Builder() {
            super(ChaCha20Poly1305KeyFormat.J());
        }
        
        Builder(final ChaCha20Poly1305KeyFormat$a object) {
            this();
        }
    }
}
