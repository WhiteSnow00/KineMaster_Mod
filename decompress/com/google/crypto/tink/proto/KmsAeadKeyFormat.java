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

public final class KmsAeadKeyFormat extends GeneratedMessageLite<KmsAeadKeyFormat, Builder> implements KmsAeadKeyFormatOrBuilder
{
    private static final KmsAeadKeyFormat DEFAULT_INSTANCE;
    public static final int KEY_URI_FIELD_NUMBER = 1;
    private static volatile Parser<KmsAeadKeyFormat> PARSER;
    private String keyUri_;
    
    static {
        GeneratedMessageLite.H(KmsAeadKeyFormat.class, DEFAULT_INSTANCE = new KmsAeadKeyFormat());
    }
    
    private KmsAeadKeyFormat() {
        this.keyUri_ = "";
    }
    
    static KmsAeadKeyFormat J() {
        return KmsAeadKeyFormat.DEFAULT_INSTANCE;
    }
    
    public static KmsAeadKeyFormat K() {
        return KmsAeadKeyFormat.DEFAULT_INSTANCE;
    }
    
    public static KmsAeadKeyFormat M(final ByteString byteString, final ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return GeneratedMessageLite.B(KmsAeadKeyFormat.DEFAULT_INSTANCE, byteString, extensionRegistryLite);
    }
    
    public String L() {
        return this.keyUri_;
    }
    
    @Override
    protected final Object q(final MethodToInvoke methodToInvoke, final Object o, final Object o2) {
        switch (KmsAeadKeyFormat$a.a[methodToInvoke.ordinal()]) {
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
                final Parser<KmsAeadKeyFormat> parser;
                if ((parser = KmsAeadKeyFormat.PARSER) == null) {
                    synchronized (KmsAeadKeyFormat.class) {
                        if (KmsAeadKeyFormat.PARSER == null) {
                            KmsAeadKeyFormat.PARSER = new DefaultInstanceBasedParser<KmsAeadKeyFormat>(KmsAeadKeyFormat.DEFAULT_INSTANCE);
                        }
                    }
                }
                return parser;
            }
            case 4: {
                return KmsAeadKeyFormat.DEFAULT_INSTANCE;
            }
            case 3: {
                return GeneratedMessageLite.A(KmsAeadKeyFormat.DEFAULT_INSTANCE, "\u0000\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0000\u0000\u0001\u0208", new Object[] { "keyUri_" });
            }
            case 2: {
                return new Builder((KmsAeadKeyFormat$a)null);
            }
            case 1: {
                return new KmsAeadKeyFormat();
            }
        }
    }
    
    public static final class Builder extends GeneratedMessageLite.Builder<KmsAeadKeyFormat, Builder> implements KmsAeadKeyFormatOrBuilder
    {
        private Builder() {
            super(KmsAeadKeyFormat.J());
        }
        
        Builder(final KmsAeadKeyFormat$a object) {
            this();
        }
    }
}
