// 
// Decompiled by Procyon v0.6.0
// 

package com.google.crypto.tink.proto;

import com.google.crypto.tink.shaded.protobuf.Internal;

public enum EcdsaSignatureEncoding implements EnumLite
{
    private static final EcdsaSignatureEncoding[] $VALUES;
    
    DER(2);
    
    public static final int DER_VALUE = 2;
    
    IEEE_P1363(1);
    
    public static final int IEEE_P1363_VALUE = 1;
    
    UNKNOWN_ENCODING(0);
    
    public static final int UNKNOWN_ENCODING_VALUE = 0;
    
    UNRECOGNIZED(-1);
    
    private static final EnumLiteMap<EcdsaSignatureEncoding> internalValueMap;
    private final int value;
    
    static {
        internalValueMap = new EnumLiteMap<EcdsaSignatureEncoding>() {
            @Override
            public /* bridge */ EnumLite a(final int n) {
                return this.b(n);
            }
            
            public EcdsaSignatureEncoding b(final int n) {
                return EcdsaSignatureEncoding.forNumber(n);
            }
        };
    }
    
    private EcdsaSignatureEncoding(final int value) {
        this.value = value;
    }
    
    public static EcdsaSignatureEncoding forNumber(final int n) {
        if (n == 0) {
            return EcdsaSignatureEncoding.UNKNOWN_ENCODING;
        }
        if (n == 1) {
            return EcdsaSignatureEncoding.IEEE_P1363;
        }
        if (n != 2) {
            return null;
        }
        return EcdsaSignatureEncoding.DER;
    }
    
    public static EnumLiteMap<EcdsaSignatureEncoding> internalGetValueMap() {
        return EcdsaSignatureEncoding.internalValueMap;
    }
    
    public static EnumVerifier internalGetVerifier() {
        return b.a;
    }
    
    @Deprecated
    public static EcdsaSignatureEncoding valueOf(final int n) {
        return forNumber(n);
    }
    
    @Override
    public final int getNumber() {
        if (this != EcdsaSignatureEncoding.UNRECOGNIZED) {
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
            return EcdsaSignatureEncoding.forNumber(n) != null;
        }
    }
}
