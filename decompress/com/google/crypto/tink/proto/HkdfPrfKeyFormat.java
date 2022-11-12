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

public final class HkdfPrfKeyFormat extends GeneratedMessageLite<HkdfPrfKeyFormat, Builder> implements HkdfPrfKeyFormatOrBuilder
{
    private static final HkdfPrfKeyFormat DEFAULT_INSTANCE;
    public static final int KEY_SIZE_FIELD_NUMBER = 2;
    public static final int PARAMS_FIELD_NUMBER = 1;
    private static volatile Parser<HkdfPrfKeyFormat> PARSER;
    public static final int VERSION_FIELD_NUMBER = 3;
    private int keySize_;
    private HkdfPrfParams params_;
    private int version_;
    
    static {
        GeneratedMessageLite.H(HkdfPrfKeyFormat.class, DEFAULT_INSTANCE = new HkdfPrfKeyFormat());
    }
    
    private HkdfPrfKeyFormat() {
    }
    
    static HkdfPrfKeyFormat J() {
        return HkdfPrfKeyFormat.DEFAULT_INSTANCE;
    }
    
    static void K(final HkdfPrfKeyFormat hkdfPrfKeyFormat, final HkdfPrfParams hkdfPrfParams) {
        hkdfPrfKeyFormat.R(hkdfPrfParams);
    }
    
    static void L(final HkdfPrfKeyFormat hkdfPrfKeyFormat, final int n) {
        hkdfPrfKeyFormat.Q(n);
    }
    
    public static Builder O() {
        return ((GeneratedMessageLite<GeneratedMessageLite, GeneratedMessageLite.Builder>)HkdfPrfKeyFormat.DEFAULT_INSTANCE).n();
    }
    
    public static HkdfPrfKeyFormat P(final ByteString byteString, final ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return GeneratedMessageLite.B(HkdfPrfKeyFormat.DEFAULT_INSTANCE, byteString, extensionRegistryLite);
    }
    
    private void Q(final int keySize_) {
        this.keySize_ = keySize_;
    }
    
    private void R(final HkdfPrfParams params_) {
        params_.getClass();
        this.params_ = params_;
    }
    
    public int M() {
        return this.keySize_;
    }
    
    public HkdfPrfParams N() {
        HkdfPrfParams hkdfPrfParams;
        if ((hkdfPrfParams = this.params_) == null) {
            hkdfPrfParams = HkdfPrfParams.L();
        }
        return hkdfPrfParams;
    }
    
    @Override
    protected final Object q(final MethodToInvoke methodToInvoke, final Object o, final Object o2) {
        switch (HkdfPrfKeyFormat$a.a[methodToInvoke.ordinal()]) {
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
                final Parser<HkdfPrfKeyFormat> parser;
                if ((parser = HkdfPrfKeyFormat.PARSER) == null) {
                    synchronized (HkdfPrfKeyFormat.class) {
                        if (HkdfPrfKeyFormat.PARSER == null) {
                            HkdfPrfKeyFormat.PARSER = new DefaultInstanceBasedParser<HkdfPrfKeyFormat>(HkdfPrfKeyFormat.DEFAULT_INSTANCE);
                        }
                    }
                }
                return parser;
            }
            case 4: {
                return HkdfPrfKeyFormat.DEFAULT_INSTANCE;
            }
            case 3: {
                return GeneratedMessageLite.A(HkdfPrfKeyFormat.DEFAULT_INSTANCE, "\u0000\u0003\u0000\u0000\u0001\u0003\u0003\u0000\u0000\u0000\u0001\t\u0002\u000b\u0003\u000b", new Object[] { "params_", "keySize_", "version_" });
            }
            case 2: {
                return new Builder((HkdfPrfKeyFormat$a)null);
            }
            case 1: {
                return new HkdfPrfKeyFormat();
            }
        }
    }
    
    public static final class Builder extends GeneratedMessageLite.Builder<HkdfPrfKeyFormat, Builder> implements HkdfPrfKeyFormatOrBuilder
    {
        private Builder() {
            super(HkdfPrfKeyFormat.J());
        }
        
        Builder(final HkdfPrfKeyFormat$a object) {
            this();
        }
        
        public Builder D(final int n) {
            ((GeneratedMessageLite.Builder)this).u();
            HkdfPrfKeyFormat.L((HkdfPrfKeyFormat)super.b, n);
            return this;
        }
        
        public Builder E(final HkdfPrfParams.Builder builder) {
            ((GeneratedMessageLite.Builder)this).u();
            HkdfPrfKeyFormat.K((HkdfPrfKeyFormat)super.b, ((GeneratedMessageLite.Builder<HkdfPrfParams, BuilderType>)builder).p());
            return this;
        }
    }
}
