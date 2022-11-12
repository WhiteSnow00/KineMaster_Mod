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

public final class AesSivKeyFormat extends GeneratedMessageLite<AesSivKeyFormat, Builder> implements AesSivKeyFormatOrBuilder
{
    private static final AesSivKeyFormat DEFAULT_INSTANCE;
    public static final int KEY_SIZE_FIELD_NUMBER = 1;
    private static volatile Parser<AesSivKeyFormat> PARSER;
    private int keySize_;
    
    static {
        GeneratedMessageLite.H(AesSivKeyFormat.class, DEFAULT_INSTANCE = new AesSivKeyFormat());
    }
    
    private AesSivKeyFormat() {
    }
    
    static AesSivKeyFormat J() {
        return AesSivKeyFormat.DEFAULT_INSTANCE;
    }
    
    static void K(final AesSivKeyFormat aesSivKeyFormat, final int n) {
        aesSivKeyFormat.O(n);
    }
    
    public static Builder M() {
        return ((GeneratedMessageLite<GeneratedMessageLite, GeneratedMessageLite.Builder>)AesSivKeyFormat.DEFAULT_INSTANCE).n();
    }
    
    public static AesSivKeyFormat N(final ByteString byteString, final ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return GeneratedMessageLite.B(AesSivKeyFormat.DEFAULT_INSTANCE, byteString, extensionRegistryLite);
    }
    
    private void O(final int keySize_) {
        this.keySize_ = keySize_;
    }
    
    public int L() {
        return this.keySize_;
    }
    
    @Override
    protected final Object q(final MethodToInvoke methodToInvoke, final Object o, final Object o2) {
        switch (AesSivKeyFormat$a.a[methodToInvoke.ordinal()]) {
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
                final Parser<AesSivKeyFormat> parser;
                if ((parser = AesSivKeyFormat.PARSER) == null) {
                    synchronized (AesSivKeyFormat.class) {
                        if (AesSivKeyFormat.PARSER == null) {
                            AesSivKeyFormat.PARSER = new DefaultInstanceBasedParser<AesSivKeyFormat>(AesSivKeyFormat.DEFAULT_INSTANCE);
                        }
                    }
                }
                return parser;
            }
            case 4: {
                return AesSivKeyFormat.DEFAULT_INSTANCE;
            }
            case 3: {
                return GeneratedMessageLite.A(AesSivKeyFormat.DEFAULT_INSTANCE, "\u0000\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0000\u0000\u0001\u000b", new Object[] { "keySize_" });
            }
            case 2: {
                return new Builder((AesSivKeyFormat$a)null);
            }
            case 1: {
                return new AesSivKeyFormat();
            }
        }
    }
    
    public static final class Builder extends GeneratedMessageLite.Builder<AesSivKeyFormat, Builder> implements AesSivKeyFormatOrBuilder
    {
        private Builder() {
            super(AesSivKeyFormat.J());
        }
        
        Builder(final AesSivKeyFormat$a object) {
            this();
        }
        
        public Builder D(final int n) {
            ((GeneratedMessageLite.Builder)this).u();
            AesSivKeyFormat.K((AesSivKeyFormat)super.b, n);
            return this;
        }
    }
}
