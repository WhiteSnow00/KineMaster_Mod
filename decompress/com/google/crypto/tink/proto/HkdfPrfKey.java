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

public final class HkdfPrfKey extends GeneratedMessageLite<HkdfPrfKey, Builder> implements HkdfPrfKeyOrBuilder
{
    private static final HkdfPrfKey DEFAULT_INSTANCE;
    public static final int KEY_VALUE_FIELD_NUMBER = 3;
    public static final int PARAMS_FIELD_NUMBER = 2;
    private static volatile Parser<HkdfPrfKey> PARSER;
    public static final int VERSION_FIELD_NUMBER = 1;
    private ByteString keyValue_;
    private HkdfPrfParams params_;
    private int version_;
    
    static {
        GeneratedMessageLite.H(HkdfPrfKey.class, DEFAULT_INSTANCE = new HkdfPrfKey());
    }
    
    private HkdfPrfKey() {
        this.keyValue_ = ByteString.EMPTY;
    }
    
    static HkdfPrfKey J() {
        return HkdfPrfKey.DEFAULT_INSTANCE;
    }
    
    static void K(final HkdfPrfKey hkdfPrfKey, final int n) {
        hkdfPrfKey.U(n);
    }
    
    static void L(final HkdfPrfKey hkdfPrfKey, final HkdfPrfParams hkdfPrfParams) {
        hkdfPrfKey.T(hkdfPrfParams);
    }
    
    static void M(final HkdfPrfKey hkdfPrfKey, final ByteString byteString) {
        hkdfPrfKey.S(byteString);
    }
    
    public static Builder Q() {
        return ((GeneratedMessageLite<GeneratedMessageLite, GeneratedMessageLite.Builder>)HkdfPrfKey.DEFAULT_INSTANCE).n();
    }
    
    public static HkdfPrfKey R(final ByteString byteString, final ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return GeneratedMessageLite.B(HkdfPrfKey.DEFAULT_INSTANCE, byteString, extensionRegistryLite);
    }
    
    private void S(final ByteString keyValue_) {
        keyValue_.getClass();
        this.keyValue_ = keyValue_;
    }
    
    private void T(final HkdfPrfParams params_) {
        params_.getClass();
        this.params_ = params_;
    }
    
    private void U(final int version_) {
        this.version_ = version_;
    }
    
    public ByteString N() {
        return this.keyValue_;
    }
    
    public HkdfPrfParams O() {
        HkdfPrfParams hkdfPrfParams;
        if ((hkdfPrfParams = this.params_) == null) {
            hkdfPrfParams = HkdfPrfParams.L();
        }
        return hkdfPrfParams;
    }
    
    public int P() {
        return this.version_;
    }
    
    @Override
    protected final Object q(final MethodToInvoke methodToInvoke, final Object o, final Object o2) {
        switch (HkdfPrfKey$a.a[methodToInvoke.ordinal()]) {
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
                final Parser<HkdfPrfKey> parser;
                if ((parser = HkdfPrfKey.PARSER) == null) {
                    synchronized (HkdfPrfKey.class) {
                        if (HkdfPrfKey.PARSER == null) {
                            HkdfPrfKey.PARSER = new DefaultInstanceBasedParser<HkdfPrfKey>(HkdfPrfKey.DEFAULT_INSTANCE);
                        }
                    }
                }
                return parser;
            }
            case 4: {
                return HkdfPrfKey.DEFAULT_INSTANCE;
            }
            case 3: {
                return GeneratedMessageLite.A(HkdfPrfKey.DEFAULT_INSTANCE, "\u0000\u0003\u0000\u0000\u0001\u0003\u0003\u0000\u0000\u0000\u0001\u000b\u0002\t\u0003\n", new Object[] { "version_", "params_", "keyValue_" });
            }
            case 2: {
                return new Builder((HkdfPrfKey$a)null);
            }
            case 1: {
                return new HkdfPrfKey();
            }
        }
    }
    
    public static final class Builder extends GeneratedMessageLite.Builder<HkdfPrfKey, Builder> implements HkdfPrfKeyOrBuilder
    {
        private Builder() {
            super(HkdfPrfKey.J());
        }
        
        Builder(final HkdfPrfKey$a object) {
            this();
        }
        
        public Builder D(final ByteString byteString) {
            ((GeneratedMessageLite.Builder)this).u();
            HkdfPrfKey.M((HkdfPrfKey)super.b, byteString);
            return this;
        }
        
        public Builder E(final HkdfPrfParams hkdfPrfParams) {
            ((GeneratedMessageLite.Builder)this).u();
            HkdfPrfKey.L((HkdfPrfKey)super.b, hkdfPrfParams);
            return this;
        }
        
        public Builder F(final int n) {
            ((GeneratedMessageLite.Builder)this).u();
            HkdfPrfKey.K((HkdfPrfKey)super.b, n);
            return this;
        }
    }
}
