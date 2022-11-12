// 
// Decompiled by Procyon v0.6.0
// 

package com.google.crypto.tink.proto;

import com.google.crypto.tink.shaded.protobuf.Internal;

public enum EcPointFormat implements EnumLite
{
    private static final EcPointFormat[] $VALUES;
    
    COMPRESSED(2);
    
    public static final int COMPRESSED_VALUE = 2;
    
    DO_NOT_USE_CRUNCHY_UNCOMPRESSED(3);
    
    public static final int DO_NOT_USE_CRUNCHY_UNCOMPRESSED_VALUE = 3;
    
    UNCOMPRESSED(1);
    
    public static final int UNCOMPRESSED_VALUE = 1;
    
    UNKNOWN_FORMAT(0);
    
    public static final int UNKNOWN_FORMAT_VALUE = 0;
    
    UNRECOGNIZED(-1);
    
    private static final EnumLiteMap<EcPointFormat> internalValueMap;
    private final int value;
    
    static {
        internalValueMap = new EnumLiteMap<EcPointFormat>() {
            @Override
            public /* bridge */ EnumLite a(final int n) {
                return this.b(n);
            }
            
            public EcPointFormat b(final int n) {
                return EcPointFormat.forNumber(n);
            }
        };
    }
    
    private EcPointFormat(final int value) {
        this.value = value;
    }
    
    public static EcPointFormat forNumber(final int n) {
        if (n == 0) {
            return EcPointFormat.UNKNOWN_FORMAT;
        }
        if (n == 1) {
            return EcPointFormat.UNCOMPRESSED;
        }
        if (n == 2) {
            return EcPointFormat.COMPRESSED;
        }
        if (n != 3) {
            return null;
        }
        return EcPointFormat.DO_NOT_USE_CRUNCHY_UNCOMPRESSED;
    }
    
    public static EnumLiteMap<EcPointFormat> internalGetValueMap() {
        return EcPointFormat.internalValueMap;
    }
    
    public static EnumVerifier internalGetVerifier() {
        return b.a;
    }
    
    @Deprecated
    public static EcPointFormat valueOf(final int n) {
        return forNumber(n);
    }
    
    @Override
    public final int getNumber() {
        if (this != EcPointFormat.UNRECOGNIZED) {
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
            return EcPointFormat.forNumber(n) != null;
        }
    }
}
