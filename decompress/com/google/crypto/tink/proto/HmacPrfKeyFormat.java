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

public final class HmacPrfKeyFormat extends GeneratedMessageLite<HmacPrfKeyFormat, Builder> implements HmacPrfKeyFormatOrBuilder
{
    private static final HmacPrfKeyFormat DEFAULT_INSTANCE;
    public static final int KEY_SIZE_FIELD_NUMBER = 2;
    public static final int PARAMS_FIELD_NUMBER = 1;
    private static volatile Parser<HmacPrfKeyFormat> PARSER;
    public static final int VERSION_FIELD_NUMBER = 3;
    private int keySize_;
    private HmacPrfParams params_;
    private int version_;
    
    static {
        GeneratedMessageLite.H(HmacPrfKeyFormat.class, DEFAULT_INSTANCE = new HmacPrfKeyFormat());
    }
    
    private HmacPrfKeyFormat() {
    }
    
    static HmacPrfKeyFormat J() {
        return HmacPrfKeyFormat.DEFAULT_INSTANCE;
    }
    
    static void K(final HmacPrfKeyFormat hmacPrfKeyFormat, final HmacPrfParams hmacPrfParams) {
        hmacPrfKeyFormat.R(hmacPrfParams);
    }
    
    static void L(final HmacPrfKeyFormat hmacPrfKeyFormat, final int n) {
        hmacPrfKeyFormat.Q(n);
    }
    
    public static Builder O() {
        return ((GeneratedMessageLite<GeneratedMessageLite, GeneratedMessageLite.Builder>)HmacPrfKeyFormat.DEFAULT_INSTANCE).n();
    }
    
    public static HmacPrfKeyFormat P(final ByteString byteString, final ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return GeneratedMessageLite.B(HmacPrfKeyFormat.DEFAULT_INSTANCE, byteString, extensionRegistryLite);
    }
    
    private void Q(final int keySize_) {
        this.keySize_ = keySize_;
    }
    
    private void R(final HmacPrfParams params_) {
        params_.getClass();
        this.params_ = params_;
    }
    
    public int M() {
        return this.keySize_;
    }
    
    public HmacPrfParams N() {
        HmacPrfParams hmacPrfParams;
        if ((hmacPrfParams = this.params_) == null) {
            hmacPrfParams = HmacPrfParams.L();
        }
        return hmacPrfParams;
    }
    
    @Override
    protected final Object q(final MethodToInvoke methodToInvoke, final Object o, final Object o2) {
        switch (HmacPrfKeyFormat$a.a[methodToInvoke.ordinal()]) {
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
                final Parser<HmacPrfKeyFormat> parser;
                if ((parser = HmacPrfKeyFormat.PARSER) == null) {
                    synchronized (HmacPrfKeyFormat.class) {
                        if (HmacPrfKeyFormat.PARSER == null) {
                            HmacPrfKeyFormat.PARSER = new DefaultInstanceBasedParser<HmacPrfKeyFormat>(HmacPrfKeyFormat.DEFAULT_INSTANCE);
                        }
                    }
                }
                return parser;
            }
            case 4: {
                return HmacPrfKeyFormat.DEFAULT_INSTANCE;
            }
            case 3: {
                return GeneratedMessageLite.A(HmacPrfKeyFormat.DEFAULT_INSTANCE, "\u0000\u0003\u0000\u0000\u0001\u0003\u0003\u0000\u0000\u0000\u0001\t\u0002\u000b\u0003\u000b", new Object[] { "params_", "keySize_", "version_" });
            }
            case 2: {
                return new Builder((HmacPrfKeyFormat$a)null);
            }
            case 1: {
                return new HmacPrfKeyFormat();
            }
        }
    }
    
    public static final class Builder extends GeneratedMessageLite.Builder<HmacPrfKeyFormat, Builder> implements HmacPrfKeyFormatOrBuilder
    {
        private Builder() {
            super(HmacPrfKeyFormat.J());
        }
        
        Builder(final HmacPrfKeyFormat$a object) {
            this();
        }
        
        public Builder D(final int n) {
            ((GeneratedMessageLite.Builder)this).u();
            HmacPrfKeyFormat.L((HmacPrfKeyFormat)super.b, n);
            return this;
        }
        
        public Builder E(final HmacPrfParams hmacPrfParams) {
            ((GeneratedMessageLite.Builder)this).u();
            HmacPrfKeyFormat.K((HmacPrfKeyFormat)super.b, hmacPrfParams);
            return this;
        }
    }
}
