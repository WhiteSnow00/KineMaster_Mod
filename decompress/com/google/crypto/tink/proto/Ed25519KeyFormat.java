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

public final class Ed25519KeyFormat extends GeneratedMessageLite<Ed25519KeyFormat, Builder> implements Ed25519KeyFormatOrBuilder
{
    private static final Ed25519KeyFormat DEFAULT_INSTANCE;
    private static volatile Parser<Ed25519KeyFormat> PARSER;
    
    static {
        GeneratedMessageLite.H(Ed25519KeyFormat.class, DEFAULT_INSTANCE = new Ed25519KeyFormat());
    }
    
    private Ed25519KeyFormat() {
    }
    
    static Ed25519KeyFormat J() {
        return Ed25519KeyFormat.DEFAULT_INSTANCE;
    }
    
    public static Ed25519KeyFormat K(final ByteString byteString, final ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return GeneratedMessageLite.B(Ed25519KeyFormat.DEFAULT_INSTANCE, byteString, extensionRegistryLite);
    }
    
    @Override
    protected final Object q(final MethodToInvoke methodToInvoke, final Object o, final Object o2) {
        switch (Ed25519KeyFormat$a.a[methodToInvoke.ordinal()]) {
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
                final Parser<Ed25519KeyFormat> parser;
                if ((parser = Ed25519KeyFormat.PARSER) == null) {
                    synchronized (Ed25519KeyFormat.class) {
                        if (Ed25519KeyFormat.PARSER == null) {
                            Ed25519KeyFormat.PARSER = new DefaultInstanceBasedParser<Ed25519KeyFormat>(Ed25519KeyFormat.DEFAULT_INSTANCE);
                        }
                    }
                }
                return parser;
            }
            case 4: {
                return Ed25519KeyFormat.DEFAULT_INSTANCE;
            }
            case 3: {
                return GeneratedMessageLite.A(Ed25519KeyFormat.DEFAULT_INSTANCE, "\u0000\u0000", null);
            }
            case 2: {
                return new Builder((Ed25519KeyFormat$a)null);
            }
            case 1: {
                return new Ed25519KeyFormat();
            }
        }
    }
    
    public static final class Builder extends GeneratedMessageLite.Builder<Ed25519KeyFormat, Builder> implements Ed25519KeyFormatOrBuilder
    {
        private Builder() {
            super(Ed25519KeyFormat.J());
        }
        
        Builder(final Ed25519KeyFormat$a object) {
            this();
        }
    }
}
