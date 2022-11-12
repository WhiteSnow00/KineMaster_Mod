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

public final class AesCmacPrfKeyFormat extends GeneratedMessageLite<AesCmacPrfKeyFormat, Builder> implements AesCmacPrfKeyFormatOrBuilder
{
    private static final AesCmacPrfKeyFormat DEFAULT_INSTANCE;
    public static final int KEY_SIZE_FIELD_NUMBER = 1;
    private static volatile Parser<AesCmacPrfKeyFormat> PARSER;
    public static final int VERSION_FIELD_NUMBER = 2;
    private int keySize_;
    private int version_;
    
    static {
        GeneratedMessageLite.H(AesCmacPrfKeyFormat.class, DEFAULT_INSTANCE = new AesCmacPrfKeyFormat());
    }
    
    private AesCmacPrfKeyFormat() {
    }
    
    static AesCmacPrfKeyFormat J() {
        return AesCmacPrfKeyFormat.DEFAULT_INSTANCE;
    }
    
    static void K(final AesCmacPrfKeyFormat aesCmacPrfKeyFormat, final int n) {
        aesCmacPrfKeyFormat.O(n);
    }
    
    public static Builder M() {
        return ((GeneratedMessageLite<GeneratedMessageLite, GeneratedMessageLite.Builder>)AesCmacPrfKeyFormat.DEFAULT_INSTANCE).n();
    }
    
    public static AesCmacPrfKeyFormat N(final ByteString byteString, final ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return GeneratedMessageLite.B(AesCmacPrfKeyFormat.DEFAULT_INSTANCE, byteString, extensionRegistryLite);
    }
    
    private void O(final int keySize_) {
        this.keySize_ = keySize_;
    }
    
    public int L() {
        return this.keySize_;
    }
    
    @Override
    protected final Object q(final MethodToInvoke methodToInvoke, final Object o, final Object o2) {
        switch (AesCmacPrfKeyFormat$a.a[methodToInvoke.ordinal()]) {
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
                final Parser<AesCmacPrfKeyFormat> parser;
                if ((parser = AesCmacPrfKeyFormat.PARSER) == null) {
                    synchronized (AesCmacPrfKeyFormat.class) {
                        if (AesCmacPrfKeyFormat.PARSER == null) {
                            AesCmacPrfKeyFormat.PARSER = new DefaultInstanceBasedParser<AesCmacPrfKeyFormat>(AesCmacPrfKeyFormat.DEFAULT_INSTANCE);
                        }
                    }
                }
                return parser;
            }
            case 4: {
                return AesCmacPrfKeyFormat.DEFAULT_INSTANCE;
            }
            case 3: {
                return GeneratedMessageLite.A(AesCmacPrfKeyFormat.DEFAULT_INSTANCE, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0000\u0000\u0001\u000b\u0002\u000b", new Object[] { "keySize_", "version_" });
            }
            case 2: {
                return new Builder((AesCmacPrfKeyFormat$a)null);
            }
            case 1: {
                return new AesCmacPrfKeyFormat();
            }
        }
    }
    
    public static final class Builder extends GeneratedMessageLite.Builder<AesCmacPrfKeyFormat, Builder> implements AesCmacPrfKeyFormatOrBuilder
    {
        private Builder() {
            super(AesCmacPrfKeyFormat.J());
        }
        
        Builder(final AesCmacPrfKeyFormat$a object) {
            this();
        }
        
        public Builder D(final int n) {
            ((GeneratedMessageLite.Builder)this).u();
            AesCmacPrfKeyFormat.K((AesCmacPrfKeyFormat)super.b, n);
            return this;
        }
    }
}
