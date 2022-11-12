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

public final class KmsAeadKey extends GeneratedMessageLite<KmsAeadKey, Builder> implements KmsAeadKeyOrBuilder
{
    private static final KmsAeadKey DEFAULT_INSTANCE;
    public static final int PARAMS_FIELD_NUMBER = 2;
    private static volatile Parser<KmsAeadKey> PARSER;
    public static final int VERSION_FIELD_NUMBER = 1;
    private KmsAeadKeyFormat params_;
    private int version_;
    
    static {
        GeneratedMessageLite.H(KmsAeadKey.class, DEFAULT_INSTANCE = new KmsAeadKey());
    }
    
    private KmsAeadKey() {
    }
    
    static KmsAeadKey J() {
        return KmsAeadKey.DEFAULT_INSTANCE;
    }
    
    static void K(final KmsAeadKey kmsAeadKey, final int n) {
        kmsAeadKey.R(n);
    }
    
    static void L(final KmsAeadKey kmsAeadKey, final KmsAeadKeyFormat kmsAeadKeyFormat) {
        kmsAeadKey.Q(kmsAeadKeyFormat);
    }
    
    public static Builder O() {
        return ((GeneratedMessageLite<GeneratedMessageLite, GeneratedMessageLite.Builder>)KmsAeadKey.DEFAULT_INSTANCE).n();
    }
    
    public static KmsAeadKey P(final ByteString byteString, final ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return GeneratedMessageLite.B(KmsAeadKey.DEFAULT_INSTANCE, byteString, extensionRegistryLite);
    }
    
    private void Q(final KmsAeadKeyFormat params_) {
        params_.getClass();
        this.params_ = params_;
    }
    
    private void R(final int version_) {
        this.version_ = version_;
    }
    
    public KmsAeadKeyFormat M() {
        KmsAeadKeyFormat kmsAeadKeyFormat;
        if ((kmsAeadKeyFormat = this.params_) == null) {
            kmsAeadKeyFormat = KmsAeadKeyFormat.K();
        }
        return kmsAeadKeyFormat;
    }
    
    public int N() {
        return this.version_;
    }
    
    @Override
    protected final Object q(final MethodToInvoke methodToInvoke, final Object o, final Object o2) {
        switch (KmsAeadKey$a.a[methodToInvoke.ordinal()]) {
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
                final Parser<KmsAeadKey> parser;
                if ((parser = KmsAeadKey.PARSER) == null) {
                    synchronized (KmsAeadKey.class) {
                        if (KmsAeadKey.PARSER == null) {
                            KmsAeadKey.PARSER = new DefaultInstanceBasedParser<KmsAeadKey>(KmsAeadKey.DEFAULT_INSTANCE);
                        }
                    }
                }
                return parser;
            }
            case 4: {
                return KmsAeadKey.DEFAULT_INSTANCE;
            }
            case 3: {
                return GeneratedMessageLite.A(KmsAeadKey.DEFAULT_INSTANCE, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0000\u0000\u0001\u000b\u0002\t", new Object[] { "version_", "params_" });
            }
            case 2: {
                return new Builder((KmsAeadKey$a)null);
            }
            case 1: {
                return new KmsAeadKey();
            }
        }
    }
    
    public static final class Builder extends GeneratedMessageLite.Builder<KmsAeadKey, Builder> implements KmsAeadKeyOrBuilder
    {
        private Builder() {
            super(KmsAeadKey.J());
        }
        
        Builder(final KmsAeadKey$a object) {
            this();
        }
        
        public Builder D(final KmsAeadKeyFormat kmsAeadKeyFormat) {
            ((GeneratedMessageLite.Builder)this).u();
            KmsAeadKey.L((KmsAeadKey)super.b, kmsAeadKeyFormat);
            return this;
        }
        
        public Builder E(final int n) {
            ((GeneratedMessageLite.Builder)this).u();
            KmsAeadKey.K((KmsAeadKey)super.b, n);
            return this;
        }
    }
}
