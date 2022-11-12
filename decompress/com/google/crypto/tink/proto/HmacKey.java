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

public final class HmacKey extends GeneratedMessageLite<HmacKey, Builder> implements HmacKeyOrBuilder
{
    private static final HmacKey DEFAULT_INSTANCE;
    public static final int KEY_VALUE_FIELD_NUMBER = 3;
    public static final int PARAMS_FIELD_NUMBER = 2;
    private static volatile Parser<HmacKey> PARSER;
    public static final int VERSION_FIELD_NUMBER = 1;
    private ByteString keyValue_;
    private HmacParams params_;
    private int version_;
    
    static {
        GeneratedMessageLite.H(HmacKey.class, DEFAULT_INSTANCE = new HmacKey());
    }
    
    private HmacKey() {
        this.keyValue_ = ByteString.EMPTY;
    }
    
    static HmacKey J() {
        return HmacKey.DEFAULT_INSTANCE;
    }
    
    static void K(final HmacKey hmacKey, final int n) {
        hmacKey.V(n);
    }
    
    static void L(final HmacKey hmacKey, final HmacParams hmacParams) {
        hmacKey.U(hmacParams);
    }
    
    static void M(final HmacKey hmacKey, final ByteString byteString) {
        hmacKey.T(byteString);
    }
    
    public static HmacKey N() {
        return HmacKey.DEFAULT_INSTANCE;
    }
    
    public static Builder R() {
        return ((GeneratedMessageLite<GeneratedMessageLite, GeneratedMessageLite.Builder>)HmacKey.DEFAULT_INSTANCE).n();
    }
    
    public static HmacKey S(final ByteString byteString, final ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return GeneratedMessageLite.B(HmacKey.DEFAULT_INSTANCE, byteString, extensionRegistryLite);
    }
    
    private void T(final ByteString keyValue_) {
        keyValue_.getClass();
        this.keyValue_ = keyValue_;
    }
    
    private void U(final HmacParams params_) {
        params_.getClass();
        this.params_ = params_;
    }
    
    private void V(final int version_) {
        this.version_ = version_;
    }
    
    public ByteString O() {
        return this.keyValue_;
    }
    
    public HmacParams P() {
        HmacParams hmacParams;
        if ((hmacParams = this.params_) == null) {
            hmacParams = HmacParams.M();
        }
        return hmacParams;
    }
    
    public int Q() {
        return this.version_;
    }
    
    @Override
    protected final Object q(final MethodToInvoke methodToInvoke, final Object o, final Object o2) {
        switch (HmacKey$a.a[methodToInvoke.ordinal()]) {
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
                final Parser<HmacKey> parser;
                if ((parser = HmacKey.PARSER) == null) {
                    synchronized (HmacKey.class) {
                        if (HmacKey.PARSER == null) {
                            HmacKey.PARSER = new DefaultInstanceBasedParser<HmacKey>(HmacKey.DEFAULT_INSTANCE);
                        }
                    }
                }
                return parser;
            }
            case 4: {
                return HmacKey.DEFAULT_INSTANCE;
            }
            case 3: {
                return GeneratedMessageLite.A(HmacKey.DEFAULT_INSTANCE, "\u0000\u0003\u0000\u0000\u0001\u0003\u0003\u0000\u0000\u0000\u0001\u000b\u0002\t\u0003\n", new Object[] { "version_", "params_", "keyValue_" });
            }
            case 2: {
                return new Builder((HmacKey$a)null);
            }
            case 1: {
                return new HmacKey();
            }
        }
    }
    
    public static final class Builder extends GeneratedMessageLite.Builder<HmacKey, Builder> implements HmacKeyOrBuilder
    {
        private Builder() {
            super(HmacKey.J());
        }
        
        Builder(final HmacKey$a object) {
            this();
        }
        
        public Builder D(final ByteString byteString) {
            ((GeneratedMessageLite.Builder)this).u();
            HmacKey.M((HmacKey)super.b, byteString);
            return this;
        }
        
        public Builder E(final HmacParams hmacParams) {
            ((GeneratedMessageLite.Builder)this).u();
            HmacKey.L((HmacKey)super.b, hmacParams);
            return this;
        }
        
        public Builder F(final int n) {
            ((GeneratedMessageLite.Builder)this).u();
            HmacKey.K((HmacKey)super.b, n);
            return this;
        }
    }
}
