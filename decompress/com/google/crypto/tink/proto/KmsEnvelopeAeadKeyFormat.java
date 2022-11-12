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

public final class KmsEnvelopeAeadKeyFormat extends GeneratedMessageLite<KmsEnvelopeAeadKeyFormat, Builder> implements KmsEnvelopeAeadKeyFormatOrBuilder
{
    private static final KmsEnvelopeAeadKeyFormat DEFAULT_INSTANCE;
    public static final int DEK_TEMPLATE_FIELD_NUMBER = 2;
    public static final int KEK_URI_FIELD_NUMBER = 1;
    private static volatile Parser<KmsEnvelopeAeadKeyFormat> PARSER;
    private KeyTemplate dekTemplate_;
    private String kekUri_;
    
    static {
        GeneratedMessageLite.H(KmsEnvelopeAeadKeyFormat.class, DEFAULT_INSTANCE = new KmsEnvelopeAeadKeyFormat());
    }
    
    private KmsEnvelopeAeadKeyFormat() {
        this.kekUri_ = "";
    }
    
    static KmsEnvelopeAeadKeyFormat J() {
        return KmsEnvelopeAeadKeyFormat.DEFAULT_INSTANCE;
    }
    
    public static KmsEnvelopeAeadKeyFormat K() {
        return KmsEnvelopeAeadKeyFormat.DEFAULT_INSTANCE;
    }
    
    public static KmsEnvelopeAeadKeyFormat N(final ByteString byteString, final ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return GeneratedMessageLite.B(KmsEnvelopeAeadKeyFormat.DEFAULT_INSTANCE, byteString, extensionRegistryLite);
    }
    
    public KeyTemplate L() {
        KeyTemplate keyTemplate;
        if ((keyTemplate = this.dekTemplate_) == null) {
            keyTemplate = KeyTemplate.N();
        }
        return keyTemplate;
    }
    
    public String M() {
        return this.kekUri_;
    }
    
    @Override
    protected final Object q(final MethodToInvoke methodToInvoke, final Object o, final Object o2) {
        switch (KmsEnvelopeAeadKeyFormat$a.a[methodToInvoke.ordinal()]) {
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
                final Parser<KmsEnvelopeAeadKeyFormat> parser;
                if ((parser = KmsEnvelopeAeadKeyFormat.PARSER) == null) {
                    synchronized (KmsEnvelopeAeadKeyFormat.class) {
                        if (KmsEnvelopeAeadKeyFormat.PARSER == null) {
                            KmsEnvelopeAeadKeyFormat.PARSER = new DefaultInstanceBasedParser<KmsEnvelopeAeadKeyFormat>(KmsEnvelopeAeadKeyFormat.DEFAULT_INSTANCE);
                        }
                    }
                }
                return parser;
            }
            case 4: {
                return KmsEnvelopeAeadKeyFormat.DEFAULT_INSTANCE;
            }
            case 3: {
                return GeneratedMessageLite.A(KmsEnvelopeAeadKeyFormat.DEFAULT_INSTANCE, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0000\u0000\u0001\u0208\u0002\t", new Object[] { "kekUri_", "dekTemplate_" });
            }
            case 2: {
                return new Builder((KmsEnvelopeAeadKeyFormat$a)null);
            }
            case 1: {
                return new KmsEnvelopeAeadKeyFormat();
            }
        }
    }
    
    public static final class Builder extends GeneratedMessageLite.Builder<KmsEnvelopeAeadKeyFormat, Builder> implements KmsEnvelopeAeadKeyFormatOrBuilder
    {
        private Builder() {
            super(KmsEnvelopeAeadKeyFormat.J());
        }
        
        Builder(final KmsEnvelopeAeadKeyFormat$a object) {
            this();
        }
    }
}
