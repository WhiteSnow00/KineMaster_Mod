// 
// Decompiled by Procyon v0.6.0
// 

package com.google.crypto.tink.proto;

import com.google.crypto.tink.shaded.protobuf.MessageLiteOrBuilder;
import com.google.crypto.tink.shaded.protobuf.MessageLite;
import java.util.List;
import com.google.crypto.tink.shaded.protobuf.Internal;
import com.google.crypto.tink.shaded.protobuf.Parser;
import com.google.crypto.tink.shaded.protobuf.GeneratedMessageLite;

public final class KeysetInfo extends GeneratedMessageLite<KeysetInfo, Builder> implements KeysetInfoOrBuilder
{
    private static final KeysetInfo DEFAULT_INSTANCE;
    public static final int KEY_INFO_FIELD_NUMBER = 2;
    private static volatile Parser<KeysetInfo> PARSER;
    public static final int PRIMARY_KEY_ID_FIELD_NUMBER = 1;
    private Internal.ProtobufList<KeyInfo> keyInfo_;
    private int primaryKeyId_;
    
    static {
        GeneratedMessageLite.H(KeysetInfo.class, DEFAULT_INSTANCE = new KeysetInfo());
    }
    
    private KeysetInfo() {
        this.keyInfo_ = GeneratedMessageLite.r();
    }
    
    static KeysetInfo J() {
        return KeysetInfo.DEFAULT_INSTANCE;
    }
    
    static void K(final KeysetInfo keysetInfo, final int n) {
        keysetInfo.T(n);
    }
    
    static void L(final KeysetInfo keysetInfo, final KeyInfo keyInfo) {
        keysetInfo.M(keyInfo);
    }
    
    private void M(final KeyInfo keyInfo) {
        keyInfo.getClass();
        this.N();
        this.keyInfo_.add(keyInfo);
    }
    
    private void N() {
        if (!this.keyInfo_.r()) {
            this.keyInfo_ = GeneratedMessageLite.y(this.keyInfo_);
        }
    }
    
    public static KeysetInfo O() {
        return KeysetInfo.DEFAULT_INSTANCE;
    }
    
    public static Builder S() {
        return ((GeneratedMessageLite<GeneratedMessageLite, GeneratedMessageLite.Builder>)KeysetInfo.DEFAULT_INSTANCE).n();
    }
    
    private void T(final int primaryKeyId_) {
        this.primaryKeyId_ = primaryKeyId_;
    }
    
    public KeyInfo P(final int n) {
        return this.keyInfo_.get(n);
    }
    
    public List<KeyInfo> Q() {
        return this.keyInfo_;
    }
    
    public int R() {
        return this.primaryKeyId_;
    }
    
    @Override
    protected final Object q(final MethodToInvoke methodToInvoke, final Object o, final Object o2) {
        switch (KeysetInfo$a.a[methodToInvoke.ordinal()]) {
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
                final Parser<KeysetInfo> parser;
                if ((parser = KeysetInfo.PARSER) == null) {
                    synchronized (KeysetInfo.class) {
                        if (KeysetInfo.PARSER == null) {
                            KeysetInfo.PARSER = new DefaultInstanceBasedParser<KeysetInfo>(KeysetInfo.DEFAULT_INSTANCE);
                        }
                    }
                }
                return parser;
            }
            case 4: {
                return KeysetInfo.DEFAULT_INSTANCE;
            }
            case 3: {
                return GeneratedMessageLite.A(KeysetInfo.DEFAULT_INSTANCE, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0001\u0000\u0001\u000b\u0002\u001b", new Object[] { "primaryKeyId_", "keyInfo_", KeyInfo.class });
            }
            case 2: {
                return new Builder((KeysetInfo$a)null);
            }
            case 1: {
                return new KeysetInfo();
            }
        }
    }
    
    public static final class Builder extends GeneratedMessageLite.Builder<KeysetInfo, Builder> implements KeysetInfoOrBuilder
    {
        private Builder() {
            super(KeysetInfo.J());
        }
        
        Builder(final KeysetInfo$a object) {
            this();
        }
        
        public Builder D(final KeyInfo keyInfo) {
            ((GeneratedMessageLite.Builder)this).u();
            KeysetInfo.L((KeysetInfo)super.b, keyInfo);
            return this;
        }
        
        public Builder E(final int n) {
            ((GeneratedMessageLite.Builder)this).u();
            KeysetInfo.K((KeysetInfo)super.b, n);
            return this;
        }
    }
    
    public static final class KeyInfo extends GeneratedMessageLite<KeyInfo, Builder> implements KeyInfoOrBuilder
    {
        private static final KeyInfo DEFAULT_INSTANCE;
        public static final int KEY_ID_FIELD_NUMBER = 3;
        public static final int OUTPUT_PREFIX_TYPE_FIELD_NUMBER = 4;
        private static volatile Parser<KeyInfo> PARSER;
        public static final int STATUS_FIELD_NUMBER = 2;
        public static final int TYPE_URL_FIELD_NUMBER = 1;
        private int keyId_;
        private int outputPrefixType_;
        private int status_;
        private String typeUrl_;
        
        static {
            GeneratedMessageLite.H(KeyInfo.class, DEFAULT_INSTANCE = new KeyInfo());
        }
        
        private KeyInfo() {
            this.typeUrl_ = "";
        }
        
        static KeyInfo J() {
            return KeyInfo.DEFAULT_INSTANCE;
        }
        
        static void K(final KeyInfo keyInfo, final String s) {
            keyInfo.W(s);
        }
        
        static void L(final KeyInfo keyInfo, final OutputPrefixType outputPrefixType) {
            keyInfo.U(outputPrefixType);
        }
        
        static void M(final KeyInfo keyInfo, final KeyStatusType keyStatusType) {
            keyInfo.V(keyStatusType);
        }
        
        static void N(final KeyInfo keyInfo, final int n) {
            keyInfo.T(n);
        }
        
        public static Builder S() {
            return ((GeneratedMessageLite<GeneratedMessageLite, GeneratedMessageLite.Builder>)KeyInfo.DEFAULT_INSTANCE).n();
        }
        
        private void T(final int keyId_) {
            this.keyId_ = keyId_;
        }
        
        private void U(final OutputPrefixType outputPrefixType) {
            this.outputPrefixType_ = outputPrefixType.getNumber();
        }
        
        private void V(final KeyStatusType keyStatusType) {
            this.status_ = keyStatusType.getNumber();
        }
        
        private void W(final String typeUrl_) {
            typeUrl_.getClass();
            this.typeUrl_ = typeUrl_;
        }
        
        public int O() {
            return this.keyId_;
        }
        
        public OutputPrefixType P() {
            OutputPrefixType outputPrefixType;
            if ((outputPrefixType = OutputPrefixType.forNumber(this.outputPrefixType_)) == null) {
                outputPrefixType = OutputPrefixType.UNRECOGNIZED;
            }
            return outputPrefixType;
        }
        
        public KeyStatusType Q() {
            KeyStatusType keyStatusType;
            if ((keyStatusType = KeyStatusType.forNumber(this.status_)) == null) {
                keyStatusType = KeyStatusType.UNRECOGNIZED;
            }
            return keyStatusType;
        }
        
        public String R() {
            return this.typeUrl_;
        }
        
        @Override
        protected final Object q(final MethodToInvoke methodToInvoke, final Object o, final Object o2) {
            switch (KeysetInfo$a.a[methodToInvoke.ordinal()]) {
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
                    final Parser<KeyInfo> parser;
                    if ((parser = KeyInfo.PARSER) == null) {
                        synchronized (KeyInfo.class) {
                            if (KeyInfo.PARSER == null) {
                                KeyInfo.PARSER = new DefaultInstanceBasedParser<KeyInfo>(KeyInfo.DEFAULT_INSTANCE);
                            }
                        }
                    }
                    return parser;
                }
                case 4: {
                    return KeyInfo.DEFAULT_INSTANCE;
                }
                case 3: {
                    return GeneratedMessageLite.A(KeyInfo.DEFAULT_INSTANCE, "\u0000\u0004\u0000\u0000\u0001\u0004\u0004\u0000\u0000\u0000\u0001\u0208\u0002\f\u0003\u000b\u0004\f", new Object[] { "typeUrl_", "status_", "keyId_", "outputPrefixType_" });
                }
                case 2: {
                    return new Builder((KeysetInfo$a)null);
                }
                case 1: {
                    return new KeyInfo();
                }
            }
        }
        
        public static final class Builder extends GeneratedMessageLite.Builder<KeyInfo, Builder> implements KeyInfoOrBuilder
        {
            private Builder() {
                super(KeyInfo.J());
            }
            
            Builder(final KeysetInfo$a object) {
                this();
            }
            
            public Builder D(final int n) {
                ((GeneratedMessageLite.Builder)this).u();
                KeyInfo.N((KeyInfo)super.b, n);
                return this;
            }
            
            public Builder E(final OutputPrefixType outputPrefixType) {
                ((GeneratedMessageLite.Builder)this).u();
                KeyInfo.L((KeyInfo)super.b, outputPrefixType);
                return this;
            }
            
            public Builder F(final KeyStatusType keyStatusType) {
                ((GeneratedMessageLite.Builder)this).u();
                KeyInfo.M((KeyInfo)super.b, keyStatusType);
                return this;
            }
            
            public Builder G(final String s) {
                ((GeneratedMessageLite.Builder)this).u();
                KeyInfo.K((KeyInfo)super.b, s);
                return this;
            }
        }
    }
    
    public interface KeyInfoOrBuilder extends MessageLiteOrBuilder
    {
    }
}
