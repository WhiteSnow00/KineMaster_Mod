// 
// Decompiled by Procyon v0.6.0
// 

package com.google.crypto.tink.proto;

import com.google.crypto.tink.shaded.protobuf.Internal;

public enum HashType implements EnumLite
{
    private static final HashType[] $VALUES;
    
    SHA1(1);
    
    public static final int SHA1_VALUE = 1;
    
    SHA256(3);
    
    public static final int SHA256_VALUE = 3;
    
    SHA384(2);
    
    public static final int SHA384_VALUE = 2;
    
    SHA512(4);
    
    public static final int SHA512_VALUE = 4;
    
    UNKNOWN_HASH(0);
    
    public static final int UNKNOWN_HASH_VALUE = 0;
    
    UNRECOGNIZED(-1);
    
    private static final EnumLiteMap<HashType> internalValueMap;
    private final int value;
    
    static {
        internalValueMap = new EnumLiteMap<HashType>() {
            @Override
            public /* bridge */ EnumLite a(final int n) {
                return this.b(n);
            }
            
            public HashType b(final int n) {
                return HashType.forNumber(n);
            }
        };
    }
    
    private HashType(final int value) {
        this.value = value;
    }
    
    public static HashType forNumber(final int n) {
        if (n == 0) {
            return HashType.UNKNOWN_HASH;
        }
        if (n == 1) {
            return HashType.SHA1;
        }
        if (n == 2) {
            return HashType.SHA384;
        }
        if (n == 3) {
            return HashType.SHA256;
        }
        if (n != 4) {
            return null;
        }
        return HashType.SHA512;
    }
    
    public static EnumLiteMap<HashType> internalGetValueMap() {
        return HashType.internalValueMap;
    }
    
    public static EnumVerifier internalGetVerifier() {
        return b.a;
    }
    
    @Deprecated
    public static HashType valueOf(final int n) {
        return forNumber(n);
    }
    
    @Override
    public final int getNumber() {
        if (this != HashType.UNRECOGNIZED) {
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
            return HashType.forNumber(n) != null;
        }
    }
}
