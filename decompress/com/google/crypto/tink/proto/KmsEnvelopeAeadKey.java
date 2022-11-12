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

public final class KmsEnvelopeAeadKey extends GeneratedMessageLite<KmsEnvelopeAeadKey, Builder> implements KmsEnvelopeAeadKeyOrBuilder
{
    private static final KmsEnvelopeAeadKey DEFAULT_INSTANCE;
    public static final int PARAMS_FIELD_NUMBER = 2;
    private static volatile Parser<KmsEnvelopeAeadKey> PARSER;
    public static final int VERSION_FIELD_NUMBER = 1;
    private KmsEnvelopeAeadKeyFormat params_;
    private int version_;
    
    static {
        GeneratedMessageLite.H(KmsEnvelopeAeadKey.class, DEFAULT_INSTANCE = new KmsEnvelopeAeadKey());
    }
    
    private KmsEnvelopeAeadKey() {
    }
    
    static KmsEnvelopeAeadKey J() {
        return KmsEnvelopeAeadKey.DEFAULT_INSTANCE;
    }
    
    static void K(final KmsEnvelopeAeadKey kmsEnvelopeAeadKey, final int n) {
        kmsEnvelopeAeadKey.R(n);
    }
    
    static void L(final KmsEnvelopeAeadKey kmsEnvelopeAeadKey, final KmsEnvelopeAeadKeyFormat kmsEnvelopeAeadKeyFormat) {
        kmsEnvelopeAeadKey.Q(kmsEnvelopeAeadKeyFormat);
    }
    
    public static Builder O() {
        return ((GeneratedMessageLite<GeneratedMessageLite, GeneratedMessageLite.Builder>)KmsEnvelopeAeadKey.DEFAULT_INSTANCE).n();
    }
    
    public static KmsEnvelopeAeadKey P(final ByteString byteString, final ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return GeneratedMessageLite.B(KmsEnvelopeAeadKey.DEFAULT_INSTANCE, byteString, extensionRegistryLite);
    }
    
    private void Q(final KmsEnvelopeAeadKeyFormat params_) {
        params_.getClass();
        this.params_ = params_;
    }
    
    private void R(final int version_) {
        this.version_ = version_;
    }
    
    public KmsEnvelopeAeadKeyFormat M() {
        KmsEnvelopeAeadKeyFormat kmsEnvelopeAeadKeyFormat;
        if ((kmsEnvelopeAeadKeyFormat = this.params_) == null) {
            kmsEnvelopeAeadKeyFormat = KmsEnvelopeAeadKeyFormat.K();
        }
        return kmsEnvelopeAeadKeyFormat;
    }
    
    public int N() {
        return this.version_;
    }
    
    @Override
    protected final Object q(final MethodToInvoke methodToInvoke, final Object o, final Object o2) {
        switch (KmsEnvelopeAeadKey$a.a[methodToInvoke.ordinal()]) {
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
                final Parser<KmsEnvelopeAeadKey> parser;
                if ((parser = KmsEnvelopeAeadKey.PARSER) == null) {
                    synchronized (KmsEnvelopeAeadKey.class) {
                        if (KmsEnvelopeAeadKey.PARSER == null) {
                            KmsEnvelopeAeadKey.PARSER = new DefaultInstanceBasedParser<KmsEnvelopeAeadKey>(KmsEnvelopeAeadKey.DEFAULT_INSTANCE);
                        }
                    }
                }
                return parser;
            }
            case 4: {
                return KmsEnvelopeAeadKey.DEFAULT_INSTANCE;
            }
            case 3: {
                return GeneratedMessageLite.A(KmsEnvelopeAeadKey.DEFAULT_INSTANCE, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0000\u0000\u0001\u000b\u0002\t", new Object[] { "version_", "params_" });
            }
            case 2: {
                return new Builder((KmsEnvelopeAeadKey$a)null);
            }
            case 1: {
                return new KmsEnvelopeAeadKey();
            }
        }
    }
    
    public static final class Builder extends GeneratedMessageLite.Builder<KmsEnvelopeAeadKey, Builder> implements KmsEnvelopeAeadKeyOrBuilder
    {
        private Builder() {
            super(KmsEnvelopeAeadKey.J());
        }
        
        Builder(final KmsEnvelopeAeadKey$a object) {
            this();
        }
        
        public Builder D(final KmsEnvelopeAeadKeyFormat kmsEnvelopeAeadKeyFormat) {
            ((GeneratedMessageLite.Builder)this).u();
            KmsEnvelopeAeadKey.L((KmsEnvelopeAeadKey)super.b, kmsEnvelopeAeadKeyFormat);
            return this;
        }
        
        public Builder E(final int n) {
            ((GeneratedMessageLite.Builder)this).u();
            KmsEnvelopeAeadKey.K((KmsEnvelopeAeadKey)super.b, n);
            return this;
        }
    }
}
