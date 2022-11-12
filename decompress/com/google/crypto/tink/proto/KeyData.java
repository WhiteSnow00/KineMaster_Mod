// 
// Decompiled by Procyon v0.6.0
// 

package com.google.crypto.tink.proto;

import com.google.crypto.tink.shaded.protobuf.Internal;
import com.google.crypto.tink.shaded.protobuf.MessageLite;
import com.google.crypto.tink.shaded.protobuf.ByteString;
import com.google.crypto.tink.shaded.protobuf.Parser;
import com.google.crypto.tink.shaded.protobuf.GeneratedMessageLite;

public final class KeyData extends GeneratedMessageLite<KeyData, Builder> implements KeyDataOrBuilder
{
    private static final KeyData DEFAULT_INSTANCE;
    public static final int KEY_MATERIAL_TYPE_FIELD_NUMBER = 3;
    private static volatile Parser<KeyData> PARSER;
    public static final int TYPE_URL_FIELD_NUMBER = 1;
    public static final int VALUE_FIELD_NUMBER = 2;
    private int keyMaterialType_;
    private String typeUrl_;
    private ByteString value_;
    
    static {
        GeneratedMessageLite.H(KeyData.class, DEFAULT_INSTANCE = new KeyData());
    }
    
    private KeyData() {
        this.typeUrl_ = "";
        this.value_ = ByteString.EMPTY;
    }
    
    static KeyData J() {
        return KeyData.DEFAULT_INSTANCE;
    }
    
    static void K(final KeyData keyData, final String s) {
        keyData.T(s);
    }
    
    static void L(final KeyData keyData, final ByteString byteString) {
        keyData.U(byteString);
    }
    
    static void M(final KeyData keyData, final KeyMaterialType keyMaterialType) {
        keyData.S(keyMaterialType);
    }
    
    public static KeyData N() {
        return KeyData.DEFAULT_INSTANCE;
    }
    
    public static Builder R() {
        return ((GeneratedMessageLite<GeneratedMessageLite, GeneratedMessageLite.Builder>)KeyData.DEFAULT_INSTANCE).n();
    }
    
    private void S(final KeyMaterialType keyMaterialType) {
        this.keyMaterialType_ = keyMaterialType.getNumber();
    }
    
    private void T(final String typeUrl_) {
        typeUrl_.getClass();
        this.typeUrl_ = typeUrl_;
    }
    
    private void U(final ByteString value_) {
        value_.getClass();
        this.value_ = value_;
    }
    
    public KeyMaterialType O() {
        KeyMaterialType keyMaterialType;
        if ((keyMaterialType = KeyMaterialType.forNumber(this.keyMaterialType_)) == null) {
            keyMaterialType = KeyMaterialType.UNRECOGNIZED;
        }
        return keyMaterialType;
    }
    
    public String P() {
        return this.typeUrl_;
    }
    
    public ByteString Q() {
        return this.value_;
    }
    
    @Override
    protected final Object q(final MethodToInvoke methodToInvoke, final Object o, final Object o2) {
        switch (KeyData$a.a[methodToInvoke.ordinal()]) {
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
                final Parser<KeyData> parser;
                if ((parser = KeyData.PARSER) == null) {
                    synchronized (KeyData.class) {
                        if (KeyData.PARSER == null) {
                            KeyData.PARSER = new DefaultInstanceBasedParser<KeyData>(KeyData.DEFAULT_INSTANCE);
                        }
                    }
                }
                return parser;
            }
            case 4: {
                return KeyData.DEFAULT_INSTANCE;
            }
            case 3: {
                return GeneratedMessageLite.A(KeyData.DEFAULT_INSTANCE, "\u0000\u0003\u0000\u0000\u0001\u0003\u0003\u0000\u0000\u0000\u0001\u0208\u0002\n\u0003\f", new Object[] { "typeUrl_", "value_", "keyMaterialType_" });
            }
            case 2: {
                return new Builder((KeyData$a)null);
            }
            case 1: {
                return new KeyData();
            }
        }
    }
    
    public static final class Builder extends GeneratedMessageLite.Builder<KeyData, Builder> implements KeyDataOrBuilder
    {
        private Builder() {
            super(KeyData.J());
        }
        
        Builder(final KeyData$a object) {
            this();
        }
        
        public Builder D(final KeyMaterialType keyMaterialType) {
            ((GeneratedMessageLite.Builder)this).u();
            KeyData.M((KeyData)super.b, keyMaterialType);
            return this;
        }
        
        public Builder E(final String s) {
            ((GeneratedMessageLite.Builder)this).u();
            KeyData.K((KeyData)super.b, s);
            return this;
        }
        
        public Builder F(final ByteString byteString) {
            ((GeneratedMessageLite.Builder)this).u();
            KeyData.L((KeyData)super.b, byteString);
            return this;
        }
    }
    
    public enum KeyMaterialType implements EnumLite
    {
        private static final KeyMaterialType[] $VALUES;
        
        ASYMMETRIC_PRIVATE(2);
        
        public static final int ASYMMETRIC_PRIVATE_VALUE = 2;
        
        ASYMMETRIC_PUBLIC(3);
        
        public static final int ASYMMETRIC_PUBLIC_VALUE = 3;
        
        REMOTE(4);
        
        public static final int REMOTE_VALUE = 4;
        
        SYMMETRIC(1);
        
        public static final int SYMMETRIC_VALUE = 1;
        
        UNKNOWN_KEYMATERIAL(0);
        
        public static final int UNKNOWN_KEYMATERIAL_VALUE = 0;
        
        UNRECOGNIZED(-1);
        
        private static final EnumLiteMap<KeyMaterialType> internalValueMap;
        private final int value;
        
        static {
            internalValueMap = new EnumLiteMap<KeyMaterialType>() {
                @Override
                public /* bridge */ EnumLite a(final int n) {
                    return this.b(n);
                }
                
                public KeyMaterialType b(final int n) {
                    return KeyMaterialType.forNumber(n);
                }
            };
        }
        
        private KeyMaterialType(final int value) {
            this.value = value;
        }
        
        public static KeyMaterialType forNumber(final int n) {
            if (n == 0) {
                return KeyMaterialType.UNKNOWN_KEYMATERIAL;
            }
            if (n == 1) {
                return KeyMaterialType.SYMMETRIC;
            }
            if (n == 2) {
                return KeyMaterialType.ASYMMETRIC_PRIVATE;
            }
            if (n == 3) {
                return KeyMaterialType.ASYMMETRIC_PUBLIC;
            }
            if (n != 4) {
                return null;
            }
            return KeyMaterialType.REMOTE;
        }
        
        public static EnumLiteMap<KeyMaterialType> internalGetValueMap() {
            return KeyMaterialType.internalValueMap;
        }
        
        public static EnumVerifier internalGetVerifier() {
            return b.a;
        }
        
        @Deprecated
        public static KeyMaterialType valueOf(final int n) {
            return forNumber(n);
        }
        
        @Override
        public final int getNumber() {
            if (this != KeyMaterialType.UNRECOGNIZED) {
                return this.value;
            }
            throw new IllegalArgumentException("Can't get the number of an unknown enum value.");
        }
        
        private static final class b implements EnumVerifier
        {
            static final EnumVerifier a;
            
            static {
                a = new b();
            }
            
            @Override
            public boolean a(final int n) {
                return KeyMaterialType.forNumber(n) != null;
            }
        }
    }
}
