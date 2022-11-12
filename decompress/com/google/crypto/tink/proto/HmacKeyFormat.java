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

public final class HmacKeyFormat extends GeneratedMessageLite<HmacKeyFormat, Builder> implements HmacKeyFormatOrBuilder
{
    private static final HmacKeyFormat DEFAULT_INSTANCE;
    public static final int KEY_SIZE_FIELD_NUMBER = 2;
    public static final int PARAMS_FIELD_NUMBER = 1;
    private static volatile Parser<HmacKeyFormat> PARSER;
    public static final int VERSION_FIELD_NUMBER = 3;
    private int keySize_;
    private HmacParams params_;
    private int version_;
    
    static {
        GeneratedMessageLite.H(HmacKeyFormat.class, DEFAULT_INSTANCE = new HmacKeyFormat());
    }
    
    private HmacKeyFormat() {
    }
    
    static HmacKeyFormat J() {
        return HmacKeyFormat.DEFAULT_INSTANCE;
    }
    
    static void K(final HmacKeyFormat hmacKeyFormat, final HmacParams hmacParams) {
        hmacKeyFormat.S(hmacParams);
    }
    
    static void L(final HmacKeyFormat hmacKeyFormat, final int n) {
        hmacKeyFormat.R(n);
    }
    
    public static HmacKeyFormat M() {
        return HmacKeyFormat.DEFAULT_INSTANCE;
    }
    
    public static Builder P() {
        return ((GeneratedMessageLite<GeneratedMessageLite, GeneratedMessageLite.Builder>)HmacKeyFormat.DEFAULT_INSTANCE).n();
    }
    
    public static HmacKeyFormat Q(final ByteString byteString, final ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return GeneratedMessageLite.B(HmacKeyFormat.DEFAULT_INSTANCE, byteString, extensionRegistryLite);
    }
    
    private void R(final int keySize_) {
        this.keySize_ = keySize_;
    }
    
    private void S(final HmacParams params_) {
        params_.getClass();
        this.params_ = params_;
    }
    
    public int N() {
        return this.keySize_;
    }
    
    public HmacParams O() {
        HmacParams hmacParams;
        if ((hmacParams = this.params_) == null) {
            hmacParams = HmacParams.M();
        }
        return hmacParams;
    }
    
    @Override
    protected final Object q(final MethodToInvoke methodToInvoke, final Object o, final Object o2) {
        switch (HmacKeyFormat$a.a[methodToInvoke.ordinal()]) {
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
                final Parser<HmacKeyFormat> parser;
                if ((parser = HmacKeyFormat.PARSER) == null) {
                    synchronized (HmacKeyFormat.class) {
                        if (HmacKeyFormat.PARSER == null) {
                            HmacKeyFormat.PARSER = new DefaultInstanceBasedParser<HmacKeyFormat>(HmacKeyFormat.DEFAULT_INSTANCE);
                        }
                    }
                }
                return parser;
            }
            case 4: {
                return HmacKeyFormat.DEFAULT_INSTANCE;
            }
            case 3: {
                return GeneratedMessageLite.A(HmacKeyFormat.DEFAULT_INSTANCE, "\u0000\u0003\u0000\u0000\u0001\u0003\u0003\u0000\u0000\u0000\u0001\t\u0002\u000b\u0003\u000b", new Object[] { "params_", "keySize_", "version_" });
            }
            case 2: {
                return new Builder((HmacKeyFormat$a)null);
            }
            case 1: {
                return new HmacKeyFormat();
            }
        }
    }
    
    public static final class Builder extends GeneratedMessageLite.Builder<HmacKeyFormat, Builder> implements HmacKeyFormatOrBuilder
    {
        private Builder() {
            super(HmacKeyFormat.J());
        }
        
        Builder(final HmacKeyFormat$a object) {
            this();
        }
        
        public Builder D(final int n) {
            ((GeneratedMessageLite.Builder)this).u();
            HmacKeyFormat.L((HmacKeyFormat)super.b, n);
            return this;
        }
        
        public Builder E(final HmacParams hmacParams) {
            ((GeneratedMessageLite.Builder)this).u();
            HmacKeyFormat.K((HmacKeyFormat)super.b, hmacParams);
            return this;
        }
    }
}
