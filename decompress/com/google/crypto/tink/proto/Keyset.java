// 
// Decompiled by Procyon v0.6.0
// 

package com.google.crypto.tink.proto;

import com.google.crypto.tink.shaded.protobuf.MessageLiteOrBuilder;
import java.util.Collections;
import com.google.crypto.tink.shaded.protobuf.MessageLite;
import java.util.List;
import com.google.crypto.tink.shaded.protobuf.InvalidProtocolBufferException;
import java.io.IOException;
import com.google.crypto.tink.shaded.protobuf.ExtensionRegistryLite;
import java.io.InputStream;
import com.google.crypto.tink.shaded.protobuf.Internal;
import com.google.crypto.tink.shaded.protobuf.Parser;
import com.google.crypto.tink.shaded.protobuf.GeneratedMessageLite;

public final class Keyset extends GeneratedMessageLite<Keyset, Builder> implements KeysetOrBuilder
{
    private static final Keyset DEFAULT_INSTANCE;
    public static final int KEY_FIELD_NUMBER = 2;
    private static volatile Parser<Keyset> PARSER;
    public static final int PRIMARY_KEY_ID_FIELD_NUMBER = 1;
    private Internal.ProtobufList<Key> key_;
    private int primaryKeyId_;
    
    static {
        GeneratedMessageLite.H(Keyset.class, DEFAULT_INSTANCE = new Keyset());
    }
    
    private Keyset() {
        this.key_ = GeneratedMessageLite.r();
    }
    
    static Keyset J() {
        return Keyset.DEFAULT_INSTANCE;
    }
    
    static void K(final Keyset keyset, final int n) {
        keyset.V(n);
    }
    
    static void L(final Keyset keyset, final Key key) {
        keyset.M(key);
    }
    
    private void M(final Key key) {
        key.getClass();
        this.N();
        this.key_.add(key);
    }
    
    private void N() {
        if (!this.key_.r()) {
            this.key_ = GeneratedMessageLite.y(this.key_);
        }
    }
    
    public static Builder S() {
        return ((GeneratedMessageLite<GeneratedMessageLite, GeneratedMessageLite.Builder>)Keyset.DEFAULT_INSTANCE).n();
    }
    
    public static Keyset T(final InputStream inputStream, final ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return GeneratedMessageLite.C(Keyset.DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }
    
    public static Keyset U(final byte[] array, final ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return GeneratedMessageLite.D(Keyset.DEFAULT_INSTANCE, array, extensionRegistryLite);
    }
    
    private void V(final int primaryKeyId_) {
        this.primaryKeyId_ = primaryKeyId_;
    }
    
    public Key O(final int n) {
        return this.key_.get(n);
    }
    
    public int P() {
        return this.key_.size();
    }
    
    public List<Key> Q() {
        return this.key_;
    }
    
    public int R() {
        return this.primaryKeyId_;
    }
    
    @Override
    protected final Object q(final MethodToInvoke methodToInvoke, final Object o, final Object o2) {
        switch (Keyset$a.a[methodToInvoke.ordinal()]) {
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
                final Parser<Keyset> parser;
                if ((parser = Keyset.PARSER) == null) {
                    synchronized (Keyset.class) {
                        if (Keyset.PARSER == null) {
                            Keyset.PARSER = new DefaultInstanceBasedParser<Keyset>(Keyset.DEFAULT_INSTANCE);
                        }
                    }
                }
                return parser;
            }
            case 4: {
                return Keyset.DEFAULT_INSTANCE;
            }
            case 3: {
                return GeneratedMessageLite.A(Keyset.DEFAULT_INSTANCE, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0001\u0000\u0001\u000b\u0002\u001b", new Object[] { "primaryKeyId_", "key_", Key.class });
            }
            case 2: {
                return new Builder((Keyset$a)null);
            }
            case 1: {
                return new Keyset();
            }
        }
    }
    
    public static final class Builder extends GeneratedMessageLite.Builder<Keyset, Builder> implements KeysetOrBuilder
    {
        private Builder() {
            super(Keyset.J());
        }
        
        Builder(final Keyset$a object) {
            this();
        }
        
        public Builder D(final Key key) {
            ((GeneratedMessageLite.Builder)this).u();
            Keyset.L((Keyset)super.b, key);
            return this;
        }
        
        public Key E(final int n) {
            return ((Keyset)super.b).O(n);
        }
        
        public int F() {
            return ((Keyset)super.b).P();
        }
        
        public List<Key> G() {
            return Collections.unmodifiableList((List<? extends Key>)((Keyset)super.b).Q());
        }
        
        public Builder H(final int n) {
            ((GeneratedMessageLite.Builder)this).u();
            Keyset.K((Keyset)super.b, n);
            return this;
        }
    }
    
    public static final class Key extends GeneratedMessageLite<Key, Builder> implements KeyOrBuilder
    {
        private static final Key DEFAULT_INSTANCE;
        public static final int KEY_DATA_FIELD_NUMBER = 1;
        public static final int KEY_ID_FIELD_NUMBER = 3;
        public static final int OUTPUT_PREFIX_TYPE_FIELD_NUMBER = 4;
        private static volatile Parser<Key> PARSER;
        public static final int STATUS_FIELD_NUMBER = 2;
        private KeyData keyData_;
        private int keyId_;
        private int outputPrefixType_;
        private int status_;
        
        static {
            GeneratedMessageLite.H(Key.class, DEFAULT_INSTANCE = new Key());
        }
        
        private Key() {
        }
        
        static Key J() {
            return Key.DEFAULT_INSTANCE;
        }
        
        static void K(final Key key, final KeyData keyData) {
            key.U(keyData);
        }
        
        static void L(final Key key, final OutputPrefixType outputPrefixType) {
            key.W(outputPrefixType);
        }
        
        static void M(final Key key, final KeyStatusType keyStatusType) {
            key.X(keyStatusType);
        }
        
        static void N(final Key key, final int n) {
            key.V(n);
        }
        
        public static Builder T() {
            return ((GeneratedMessageLite<GeneratedMessageLite, GeneratedMessageLite.Builder>)Key.DEFAULT_INSTANCE).n();
        }
        
        private void U(final KeyData keyData_) {
            keyData_.getClass();
            this.keyData_ = keyData_;
        }
        
        private void V(final int keyId_) {
            this.keyId_ = keyId_;
        }
        
        private void W(final OutputPrefixType outputPrefixType) {
            this.outputPrefixType_ = outputPrefixType.getNumber();
        }
        
        private void X(final KeyStatusType keyStatusType) {
            this.status_ = keyStatusType.getNumber();
        }
        
        public KeyData O() {
            KeyData keyData;
            if ((keyData = this.keyData_) == null) {
                keyData = KeyData.N();
            }
            return keyData;
        }
        
        public int P() {
            return this.keyId_;
        }
        
        public OutputPrefixType Q() {
            OutputPrefixType outputPrefixType;
            if ((outputPrefixType = OutputPrefixType.forNumber(this.outputPrefixType_)) == null) {
                outputPrefixType = OutputPrefixType.UNRECOGNIZED;
            }
            return outputPrefixType;
        }
        
        public KeyStatusType R() {
            KeyStatusType keyStatusType;
            if ((keyStatusType = KeyStatusType.forNumber(this.status_)) == null) {
                keyStatusType = KeyStatusType.UNRECOGNIZED;
            }
            return keyStatusType;
        }
        
        public boolean S() {
            return this.keyData_ != null;
        }
        
        @Override
        protected final Object q(final MethodToInvoke methodToInvoke, final Object o, final Object o2) {
            switch (Keyset$a.a[methodToInvoke.ordinal()]) {
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
                    final Parser<Key> parser;
                    if ((parser = Key.PARSER) == null) {
                        synchronized (Key.class) {
                            if (Key.PARSER == null) {
                                Key.PARSER = new DefaultInstanceBasedParser<Key>(Key.DEFAULT_INSTANCE);
                            }
                        }
                    }
                    return parser;
                }
                case 4: {
                    return Key.DEFAULT_INSTANCE;
                }
                case 3: {
                    return GeneratedMessageLite.A(Key.DEFAULT_INSTANCE, "\u0000\u0004\u0000\u0000\u0001\u0004\u0004\u0000\u0000\u0000\u0001\t\u0002\f\u0003\u000b\u0004\f", new Object[] { "keyData_", "status_", "keyId_", "outputPrefixType_" });
                }
                case 2: {
                    return new Builder((Keyset$a)null);
                }
                case 1: {
                    return new Key();
                }
            }
        }
        
        public static final class Builder extends GeneratedMessageLite.Builder<Key, Builder> implements KeyOrBuilder
        {
            private Builder() {
                super(Key.J());
            }
            
            Builder(final Keyset$a object) {
                this();
            }
            
            public Builder D(final KeyData keyData) {
                ((GeneratedMessageLite.Builder)this).u();
                Key.K((Key)super.b, keyData);
                return this;
            }
            
            public Builder E(final int n) {
                ((GeneratedMessageLite.Builder)this).u();
                Key.N((Key)super.b, n);
                return this;
            }
            
            public Builder F(final OutputPrefixType outputPrefixType) {
                ((GeneratedMessageLite.Builder)this).u();
                Key.L((Key)super.b, outputPrefixType);
                return this;
            }
            
            public Builder G(final KeyStatusType keyStatusType) {
                ((GeneratedMessageLite.Builder)this).u();
                Key.M((Key)super.b, keyStatusType);
                return this;
            }
        }
    }
    
    public interface KeyOrBuilder extends MessageLiteOrBuilder
    {
    }
}
