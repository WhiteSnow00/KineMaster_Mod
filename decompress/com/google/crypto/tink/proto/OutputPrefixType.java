// 
// Decompiled by Procyon v0.6.0
// 

package com.google.crypto.tink.proto;

import com.google.crypto.tink.shaded.protobuf.Internal;

public enum OutputPrefixType implements EnumLite
{
    private static final OutputPrefixType[] $VALUES;
    
    CRUNCHY(4);
    
    public static final int CRUNCHY_VALUE = 4;
    
    LEGACY(2);
    
    public static final int LEGACY_VALUE = 2;
    
    RAW(3);
    
    public static final int RAW_VALUE = 3;
    
    TINK(1);
    
    public static final int TINK_VALUE = 1;
    
    UNKNOWN_PREFIX(0);
    
    public static final int UNKNOWN_PREFIX_VALUE = 0;
    
    UNRECOGNIZED(-1);
    
    private static final EnumLiteMap<OutputPrefixType> internalValueMap;
    private final int value;
    
    static {
        internalValueMap = new EnumLiteMap<OutputPrefixType>() {
            @Override
            public /* bridge */ EnumLite a(final int n) {
                return this.b(n);
            }
            
            public OutputPrefixType b(final int n) {
                return OutputPrefixType.forNumber(n);
            }
        };
    }
    
    private OutputPrefixType(final int value) {
        this.value = value;
    }
    
    public static OutputPrefixType forNumber(final int n) {
        if (n == 0) {
            return OutputPrefixType.UNKNOWN_PREFIX;
        }
        if (n == 1) {
            return OutputPrefixType.TINK;
        }
        if (n == 2) {
            return OutputPrefixType.LEGACY;
        }
        if (n == 3) {
            return OutputPrefixType.RAW;
        }
        if (n != 4) {
            return null;
        }
        return OutputPrefixType.CRUNCHY;
    }
    
    public static EnumLiteMap<OutputPrefixType> internalGetValueMap() {
        return OutputPrefixType.internalValueMap;
    }
    
    public static EnumVerifier internalGetVerifier() {
        return b.a;
    }
    
    @Deprecated
    public static OutputPrefixType valueOf(final int n) {
        return forNumber(n);
    }
    
    @Override
    public final int getNumber() {
        if (this != OutputPrefixType.UNRECOGNIZED) {
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
            return OutputPrefixType.forNumber(n) != null;
        }
    }
}
