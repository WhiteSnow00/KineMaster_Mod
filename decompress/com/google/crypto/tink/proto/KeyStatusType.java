// 
// Decompiled by Procyon v0.6.0
// 

package com.google.crypto.tink.proto;

import com.google.crypto.tink.shaded.protobuf.Internal;

public enum KeyStatusType implements EnumLite
{
    private static final KeyStatusType[] $VALUES;
    
    DESTROYED(3);
    
    public static final int DESTROYED_VALUE = 3;
    
    DISABLED(2);
    
    public static final int DISABLED_VALUE = 2;
    
    ENABLED(1);
    
    public static final int ENABLED_VALUE = 1;
    
    UNKNOWN_STATUS(0);
    
    public static final int UNKNOWN_STATUS_VALUE = 0;
    
    UNRECOGNIZED(-1);
    
    private static final EnumLiteMap<KeyStatusType> internalValueMap;
    private final int value;
    
    static {
        internalValueMap = new EnumLiteMap<KeyStatusType>() {
            @Override
            public /* bridge */ EnumLite a(final int n) {
                return this.b(n);
            }
            
            public KeyStatusType b(final int n) {
                return KeyStatusType.forNumber(n);
            }
        };
    }
    
    private KeyStatusType(final int value) {
        this.value = value;
    }
    
    public static KeyStatusType forNumber(final int n) {
        if (n == 0) {
            return KeyStatusType.UNKNOWN_STATUS;
        }
        if (n == 1) {
            return KeyStatusType.ENABLED;
        }
        if (n == 2) {
            return KeyStatusType.DISABLED;
        }
        if (n != 3) {
            return null;
        }
        return KeyStatusType.DESTROYED;
    }
    
    public static EnumLiteMap<KeyStatusType> internalGetValueMap() {
        return KeyStatusType.internalValueMap;
    }
    
    public static EnumVerifier internalGetVerifier() {
        return b.a;
    }
    
    @Deprecated
    public static KeyStatusType valueOf(final int n) {
        return forNumber(n);
    }
    
    @Override
    public final int getNumber() {
        if (this != KeyStatusType.UNRECOGNIZED) {
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
            return KeyStatusType.forNumber(n) != null;
        }
    }
}
