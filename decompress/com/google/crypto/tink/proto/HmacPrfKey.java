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

public final class HmacPrfKey extends GeneratedMessageLite<HmacPrfKey, Builder> implements HmacPrfKeyOrBuilder
{
    private static final HmacPrfKey DEFAULT_INSTANCE;
    public static final int KEY_VALUE_FIELD_NUMBER = 3;
    public static final int PARAMS_FIELD_NUMBER = 2;
    private static volatile Parser<HmacPrfKey> PARSER;
    public static final int VERSION_FIELD_NUMBER = 1;
    private ByteString keyValue_;
    private HmacPrfParams params_;
    private int version_;
    
    static {
        GeneratedMessageLite.H(HmacPrfKey.class, DEFAULT_INSTANCE = new HmacPrfKey());
    }
    
    private HmacPrfKey() {
        this.keyValue_ = ByteString.EMPTY;
    }
    
    static HmacPrfKey J() {
        return HmacPrfKey.DEFAULT_INSTANCE;
    }
    
    static void K(final HmacPrfKey hmacPrfKey, final int n) {
        hmacPrfKey.U(n);
    }
    
    static void L(final HmacPrfKey hmacPrfKey, final HmacPrfParams hmacPrfParams) {
        hmacPrfKey.T(hmacPrfParams);
    }
    
    static void M(final HmacPrfKey hmacPrfKey, final ByteString byteString) {
        hmacPrfKey.S(byteString);
    }
    
    public static Builder Q() {
        return ((GeneratedMessageLite<GeneratedMessageLite, GeneratedMessageLite.Builder>)HmacPrfKey.DEFAULT_INSTANCE).n();
    }
    
    public static HmacPrfKey R(final ByteString byteString, final ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return GeneratedMessageLite.B(HmacPrfKey.DEFAULT_INSTANCE, byteString, extensionRegistryLite);
    }
    
    private void S(final ByteString keyValue_) {
        keyValue_.getClass();
        this.keyValue_ = keyValue_;
    }
    
    private void T(final HmacPrfParams params_) {
        params_.getClass();
        this.params_ = params_;
    }
    
    private void U(final int version_) {
        this.version_ = version_;
    }
    
    public ByteString N() {
        return this.keyValue_;
    }
    
    public HmacPrfParams O() {
        HmacPrfParams hmacPrfParams;
        if ((hmacPrfParams = this.params_) == null) {
            hmacPrfParams = HmacPrfParams.L();
        }
        return hmacPrfParams;
    }
    
    public int P() {
        return this.version_;
    }
    
    @Override
    protected final Object q(final MethodToInvoke methodToInvoke, final Object o, final Object o2) {
        switch (HmacPrfKey$a.a[methodToInvoke.ordinal()]) {
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
                final Parser<HmacPrfKey> parser;
                if ((parser = HmacPrfKey.PARSER) == null) {
                    synchronized (HmacPrfKey.class) {
                        if (HmacPrfKey.PARSER == null) {
                            HmacPrfKey.PARSER = new DefaultInstanceBasedParser<HmacPrfKey>(HmacPrfKey.DEFAULT_INSTANCE);
                        }
                    }
                }
                return parser;
            }
            case 4: {
                return HmacPrfKey.DEFAULT_INSTANCE;
            }
            case 3: {
                return GeneratedMessageLite.A(HmacPrfKey.DEFAULT_INSTANCE, "\u0000\u0003\u0000\u0000\u0001\u0003\u0003\u0000\u0000\u0000\u0001\u000b\u0002\t\u0003\n", new Object[] { "version_", "params_", "keyValue_" });
            }
            case 2: {
                return new Builder((HmacPrfKey$a)null);
            }
            case 1: {
                return new HmacPrfKey();
            }
        }
    }
    
    public static final class Builder extends GeneratedMessageLite.Builder<HmacPrfKey, Builder> implements HmacPrfKeyOrBuilder
    {
        private Builder() {
            super(HmacPrfKey.J());
        }
        
        Builder(final HmacPrfKey$a object) {
            this();
        }
        
        public Builder D(final ByteString byteString) {
            ((GeneratedMessageLite.Builder)this).u();
            HmacPrfKey.M((HmacPrfKey)super.b, byteString);
            return this;
        }
        
        public Builder E(final HmacPrfParams hmacPrfParams) {
            ((GeneratedMessageLite.Builder)this).u();
            HmacPrfKey.L((HmacPrfKey)super.b, hmacPrfParams);
            return this;
        }
        
        public Builder F(final int n) {
            ((GeneratedMessageLite.Builder)this).u();
            HmacPrfKey.K((HmacPrfKey)super.b, n);
            return this;
        }
    }
}
