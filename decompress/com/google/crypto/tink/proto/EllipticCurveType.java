// 
// Decompiled by Procyon v0.6.0
// 

package com.google.crypto.tink.proto;

import com.google.crypto.tink.shaded.protobuf.Internal;

public enum EllipticCurveType implements EnumLite
{
    private static final EllipticCurveType[] $VALUES;
    
    CURVE25519(5);
    
    public static final int CURVE25519_VALUE = 5;
    
    NIST_P256(2);
    
    public static final int NIST_P256_VALUE = 2;
    
    NIST_P384(3);
    
    public static final int NIST_P384_VALUE = 3;
    
    NIST_P521(4);
    
    public static final int NIST_P521_VALUE = 4;
    
    UNKNOWN_CURVE(0);
    
    public static final int UNKNOWN_CURVE_VALUE = 0;
    
    UNRECOGNIZED(-1);
    
    private static final EnumLiteMap<EllipticCurveType> internalValueMap;
    private final int value;
    
    static {
        internalValueMap = new EnumLiteMap<EllipticCurveType>() {
            @Override
            public /* bridge */ EnumLite a(final int n) {
                return this.b(n);
            }
            
            public EllipticCurveType b(final int n) {
                return EllipticCurveType.forNumber(n);
            }
        };
    }
    
    private EllipticCurveType(final int value) {
        this.value = value;
    }
    
    public static EllipticCurveType forNumber(final int n) {
        if (n == 0) {
            return EllipticCurveType.UNKNOWN_CURVE;
        }
        if (n == 2) {
            return EllipticCurveType.NIST_P256;
        }
        if (n == 3) {
            return EllipticCurveType.NIST_P384;
        }
        if (n == 4) {
            return EllipticCurveType.NIST_P521;
        }
        if (n != 5) {
            return null;
        }
        return EllipticCurveType.CURVE25519;
    }
    
    public static EnumLiteMap<EllipticCurveType> internalGetValueMap() {
        return EllipticCurveType.internalValueMap;
    }
    
    public static EnumVerifier internalGetVerifier() {
        return b.a;
    }
    
    @Deprecated
    public static EllipticCurveType valueOf(final int n) {
        return forNumber(n);
    }
    
    @Override
    public final int getNumber() {
        if (this != EllipticCurveType.UNRECOGNIZED) {
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
            return EllipticCurveType.forNumber(n) != null;
        }
    }
}
