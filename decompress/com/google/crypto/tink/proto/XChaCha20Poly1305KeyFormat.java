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

public final class XChaCha20Poly1305KeyFormat extends GeneratedMessageLite<XChaCha20Poly1305KeyFormat, Builder> implements XChaCha20Poly1305KeyFormatOrBuilder
{
    private static final XChaCha20Poly1305KeyFormat DEFAULT_INSTANCE;
    private static volatile Parser<XChaCha20Poly1305KeyFormat> PARSER;
    
    static {
        GeneratedMessageLite.H(XChaCha20Poly1305KeyFormat.class, DEFAULT_INSTANCE = new XChaCha20Poly1305KeyFormat());
    }
    
    private XChaCha20Poly1305KeyFormat() {
    }
    
    static XChaCha20Poly1305KeyFormat J() {
        return XChaCha20Poly1305KeyFormat.DEFAULT_INSTANCE;
    }
    
    public static XChaCha20Poly1305KeyFormat K(final ByteString byteString, final ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return GeneratedMessageLite.B(XChaCha20Poly1305KeyFormat.DEFAULT_INSTANCE, byteString, extensionRegistryLite);
    }
    
    @Override
    protected final Object q(final MethodToInvoke methodToInvoke, final Object o, final Object o2) {
        switch (XChaCha20Poly1305KeyFormat$a.a[methodToInvoke.ordinal()]) {
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
                final Parser<XChaCha20Poly1305KeyFormat> parser;
                if ((parser = XChaCha20Poly1305KeyFormat.PARSER) == null) {
                    synchronized (XChaCha20Poly1305KeyFormat.class) {
                        if (XChaCha20Poly1305KeyFormat.PARSER == null) {
                            XChaCha20Poly1305KeyFormat.PARSER = new DefaultInstanceBasedParser<XChaCha20Poly1305KeyFormat>(XChaCha20Poly1305KeyFormat.DEFAULT_INSTANCE);
                        }
                    }
                }
                return parser;
            }
            case 4: {
                return XChaCha20Poly1305KeyFormat.DEFAULT_INSTANCE;
            }
            case 3: {
                return GeneratedMessageLite.A(XChaCha20Poly1305KeyFormat.DEFAULT_INSTANCE, "\u0000\u0000", null);
            }
            case 2: {
                return new Builder((XChaCha20Poly1305KeyFormat$a)null);
            }
            case 1: {
                return new XChaCha20Poly1305KeyFormat();
            }
        }
    }
    
    public static final class Builder extends GeneratedMessageLite.Builder<XChaCha20Poly1305KeyFormat, Builder> implements XChaCha20Poly1305KeyFormatOrBuilder
    {
        private Builder() {
            super(XChaCha20Poly1305KeyFormat.J());
        }
        
        Builder(final XChaCha20Poly1305KeyFormat$a object) {
            this();
        }
    }
}
