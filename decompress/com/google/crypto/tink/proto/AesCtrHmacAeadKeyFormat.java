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

public final class AesCtrHmacAeadKeyFormat extends GeneratedMessageLite<AesCtrHmacAeadKeyFormat, Builder> implements AesCtrHmacAeadKeyFormatOrBuilder
{
    public static final int AES_CTR_KEY_FORMAT_FIELD_NUMBER = 1;
    private static final AesCtrHmacAeadKeyFormat DEFAULT_INSTANCE;
    public static final int HMAC_KEY_FORMAT_FIELD_NUMBER = 2;
    private static volatile Parser<AesCtrHmacAeadKeyFormat> PARSER;
    private AesCtrKeyFormat aesCtrKeyFormat_;
    private HmacKeyFormat hmacKeyFormat_;
    
    static {
        GeneratedMessageLite.H(AesCtrHmacAeadKeyFormat.class, DEFAULT_INSTANCE = new AesCtrHmacAeadKeyFormat());
    }
    
    private AesCtrHmacAeadKeyFormat() {
    }
    
    static AesCtrHmacAeadKeyFormat J() {
        return AesCtrHmacAeadKeyFormat.DEFAULT_INSTANCE;
    }
    
    static void K(final AesCtrHmacAeadKeyFormat aesCtrHmacAeadKeyFormat, final AesCtrKeyFormat aesCtrKeyFormat) {
        aesCtrHmacAeadKeyFormat.Q(aesCtrKeyFormat);
    }
    
    static void L(final AesCtrHmacAeadKeyFormat aesCtrHmacAeadKeyFormat, final HmacKeyFormat hmacKeyFormat) {
        aesCtrHmacAeadKeyFormat.R(hmacKeyFormat);
    }
    
    public static Builder O() {
        return ((GeneratedMessageLite<GeneratedMessageLite, GeneratedMessageLite.Builder>)AesCtrHmacAeadKeyFormat.DEFAULT_INSTANCE).n();
    }
    
    public static AesCtrHmacAeadKeyFormat P(final ByteString byteString, final ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return GeneratedMessageLite.B(AesCtrHmacAeadKeyFormat.DEFAULT_INSTANCE, byteString, extensionRegistryLite);
    }
    
    private void Q(final AesCtrKeyFormat aesCtrKeyFormat_) {
        aesCtrKeyFormat_.getClass();
        this.aesCtrKeyFormat_ = aesCtrKeyFormat_;
    }
    
    private void R(final HmacKeyFormat hmacKeyFormat_) {
        hmacKeyFormat_.getClass();
        this.hmacKeyFormat_ = hmacKeyFormat_;
    }
    
    public AesCtrKeyFormat M() {
        AesCtrKeyFormat aesCtrKeyFormat;
        if ((aesCtrKeyFormat = this.aesCtrKeyFormat_) == null) {
            aesCtrKeyFormat = AesCtrKeyFormat.M();
        }
        return aesCtrKeyFormat;
    }
    
    public HmacKeyFormat N() {
        HmacKeyFormat hmacKeyFormat;
        if ((hmacKeyFormat = this.hmacKeyFormat_) == null) {
            hmacKeyFormat = HmacKeyFormat.M();
        }
        return hmacKeyFormat;
    }
    
    @Override
    protected final Object q(final MethodToInvoke methodToInvoke, final Object o, final Object o2) {
        switch (AesCtrHmacAeadKeyFormat$a.a[methodToInvoke.ordinal()]) {
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
                final Parser<AesCtrHmacAeadKeyFormat> parser;
                if ((parser = AesCtrHmacAeadKeyFormat.PARSER) == null) {
                    synchronized (AesCtrHmacAeadKeyFormat.class) {
                        if (AesCtrHmacAeadKeyFormat.PARSER == null) {
                            AesCtrHmacAeadKeyFormat.PARSER = new DefaultInstanceBasedParser<AesCtrHmacAeadKeyFormat>(AesCtrHmacAeadKeyFormat.DEFAULT_INSTANCE);
                        }
                    }
                }
                return parser;
            }
            case 4: {
                return AesCtrHmacAeadKeyFormat.DEFAULT_INSTANCE;
            }
            case 3: {
                return GeneratedMessageLite.A(AesCtrHmacAeadKeyFormat.DEFAULT_INSTANCE, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0000\u0000\u0001\t\u0002\t", new Object[] { "aesCtrKeyFormat_", "hmacKeyFormat_" });
            }
            case 2: {
                return new Builder((AesCtrHmacAeadKeyFormat$a)null);
            }
            case 1: {
                return new AesCtrHmacAeadKeyFormat();
            }
        }
    }
    
    public static final class Builder extends GeneratedMessageLite.Builder<AesCtrHmacAeadKeyFormat, Builder> implements AesCtrHmacAeadKeyFormatOrBuilder
    {
        private Builder() {
            super(AesCtrHmacAeadKeyFormat.J());
        }
        
        Builder(final AesCtrHmacAeadKeyFormat$a object) {
            this();
        }
        
        public Builder D(final AesCtrKeyFormat aesCtrKeyFormat) {
            ((GeneratedMessageLite.Builder)this).u();
            AesCtrHmacAeadKeyFormat.K((AesCtrHmacAeadKeyFormat)super.b, aesCtrKeyFormat);
            return this;
        }
        
        public Builder E(final HmacKeyFormat hmacKeyFormat) {
            ((GeneratedMessageLite.Builder)this).u();
            AesCtrHmacAeadKeyFormat.L((AesCtrHmacAeadKeyFormat)super.b, hmacKeyFormat);
            return this;
        }
    }
}
