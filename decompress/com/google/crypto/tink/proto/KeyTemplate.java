// 
// Decompiled by Procyon v0.6.0
// 

package com.google.crypto.tink.proto;

import com.google.crypto.tink.shaded.protobuf.MessageLite;
import com.google.crypto.tink.shaded.protobuf.ByteString;
import com.google.crypto.tink.shaded.protobuf.Parser;
import com.google.crypto.tink.shaded.protobuf.GeneratedMessageLite;

public final class KeyTemplate extends GeneratedMessageLite<KeyTemplate, Builder> implements KeyTemplateOrBuilder
{
    private static final KeyTemplate DEFAULT_INSTANCE;
    public static final int OUTPUT_PREFIX_TYPE_FIELD_NUMBER = 3;
    private static volatile Parser<KeyTemplate> PARSER;
    public static final int TYPE_URL_FIELD_NUMBER = 1;
    public static final int VALUE_FIELD_NUMBER = 2;
    private int outputPrefixType_;
    private String typeUrl_;
    private ByteString value_;
    
    static {
        GeneratedMessageLite.H(KeyTemplate.class, DEFAULT_INSTANCE = new KeyTemplate());
    }
    
    private KeyTemplate() {
        this.typeUrl_ = "";
        this.value_ = ByteString.EMPTY;
    }
    
    static KeyTemplate J() {
        return KeyTemplate.DEFAULT_INSTANCE;
    }
    
    static void K(final KeyTemplate keyTemplate, final String s) {
        keyTemplate.T(s);
    }
    
    static void L(final KeyTemplate keyTemplate, final ByteString byteString) {
        keyTemplate.U(byteString);
    }
    
    static void M(final KeyTemplate keyTemplate, final OutputPrefixType outputPrefixType) {
        keyTemplate.S(outputPrefixType);
    }
    
    public static KeyTemplate N() {
        return KeyTemplate.DEFAULT_INSTANCE;
    }
    
    public static Builder R() {
        return ((GeneratedMessageLite<GeneratedMessageLite, GeneratedMessageLite.Builder>)KeyTemplate.DEFAULT_INSTANCE).n();
    }
    
    private void S(final OutputPrefixType outputPrefixType) {
        this.outputPrefixType_ = outputPrefixType.getNumber();
    }
    
    private void T(final String typeUrl_) {
        typeUrl_.getClass();
        this.typeUrl_ = typeUrl_;
    }
    
    private void U(final ByteString value_) {
        value_.getClass();
        this.value_ = value_;
    }
    
    public OutputPrefixType O() {
        OutputPrefixType outputPrefixType;
        if ((outputPrefixType = OutputPrefixType.forNumber(this.outputPrefixType_)) == null) {
            outputPrefixType = OutputPrefixType.UNRECOGNIZED;
        }
        return outputPrefixType;
    }
    
    public String P() {
        return this.typeUrl_;
    }
    
    public ByteString Q() {
        return this.value_;
    }
    
    @Override
    protected final Object q(final MethodToInvoke methodToInvoke, final Object o, final Object o2) {
        switch (KeyTemplate$a.a[methodToInvoke.ordinal()]) {
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
                final Parser<KeyTemplate> parser;
                if ((parser = KeyTemplate.PARSER) == null) {
                    synchronized (KeyTemplate.class) {
                        if (KeyTemplate.PARSER == null) {
                            KeyTemplate.PARSER = new DefaultInstanceBasedParser<KeyTemplate>(KeyTemplate.DEFAULT_INSTANCE);
                        }
                    }
                }
                return parser;
            }
            case 4: {
                return KeyTemplate.DEFAULT_INSTANCE;
            }
            case 3: {
                return GeneratedMessageLite.A(KeyTemplate.DEFAULT_INSTANCE, "\u0000\u0003\u0000\u0000\u0001\u0003\u0003\u0000\u0000\u0000\u0001\u0208\u0002\n\u0003\f", new Object[] { "typeUrl_", "value_", "outputPrefixType_" });
            }
            case 2: {
                return new Builder((KeyTemplate$a)null);
            }
            case 1: {
                return new KeyTemplate();
            }
        }
    }
    
    public static final class Builder extends GeneratedMessageLite.Builder<KeyTemplate, Builder> implements KeyTemplateOrBuilder
    {
        private Builder() {
            super(KeyTemplate.J());
        }
        
        Builder(final KeyTemplate$a object) {
            this();
        }
        
        public Builder D(final OutputPrefixType outputPrefixType) {
            ((GeneratedMessageLite.Builder)this).u();
            KeyTemplate.M((KeyTemplate)super.b, outputPrefixType);
            return this;
        }
        
        public Builder E(final String s) {
            ((GeneratedMessageLite.Builder)this).u();
            KeyTemplate.K((KeyTemplate)super.b, s);
            return this;
        }
        
        public Builder F(final ByteString byteString) {
            ((GeneratedMessageLite.Builder)this).u();
            KeyTemplate.L((KeyTemplate)super.b, byteString);
            return this;
        }
    }
}
