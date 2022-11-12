// 
// Decompiled by Procyon v0.6.0
// 

package com.google.crypto.tink.shaded.protobuf;

public final class WireFormat
{
    static final int a;
    static final int b;
    static final int c;
    static final int d;
    
    static {
        a = c(1, 3);
        b = c(1, 4);
        c = c(2, 0);
        d = c(3, 2);
    }
    
    private WireFormat() {
    }
    
    public static int a(final int n) {
        return n >>> 3;
    }
    
    public static int b(final int n) {
        return n & 0x7;
    }
    
    static int c(final int n, final int n2) {
        return n << 3 | n2;
    }
    
    public enum FieldType
    {
        private static final FieldType[] $VALUES;
        
        BOOL(JavaType.BOOLEAN, 0), 
        BYTES(JavaType.BYTE_STRING, 2) {
            @Override
            public boolean isPackable() {
                return false;
            }
        }, 
        DOUBLE(JavaType.DOUBLE, 1), 
        ENUM(JavaType.ENUM, 0), 
        FIXED32(int1, 5), 
        FIXED64(long1, 1), 
        FLOAT(JavaType.FLOAT, 5), 
        GROUP(message, 3) {
            @Override
            public boolean isPackable() {
                return false;
            }
        }, 
        INT32(int1, 0), 
        INT64(long1, 0), 
        MESSAGE(message, 2) {
            @Override
            public boolean isPackable() {
                return false;
            }
        }, 
        SFIXED32(int1, 5), 
        SFIXED64(long1, 1), 
        SINT32(int1, 0), 
        SINT64(long1, 0), 
        STRING(JavaType.STRING, 2) {
            @Override
            public boolean isPackable() {
                return false;
            }
        }, 
        UINT32(int1, 0), 
        UINT64(long1, 0);
        
        private final JavaType javaType;
        private final int wireType;
        
        static {
            final JavaType long1 = JavaType.LONG;
            final JavaType int1 = JavaType.INT;
            final JavaType message = JavaType.MESSAGE;
        }
        
        private FieldType(final JavaType javaType, final int wireType) {
            this.javaType = javaType;
            this.wireType = wireType;
        }
        
        FieldType(final String s, final int n, final JavaType javaType, final int n2, final WireFormat$a object) {
            this(javaType, n2);
        }
        
        public JavaType getJavaType() {
            return this.javaType;
        }
        
        public int getWireType() {
            return this.wireType;
        }
        
        public boolean isPackable() {
            return true;
        }
    }
    
    public enum JavaType
    {
        private static final JavaType[] $VALUES;
        
        BOOLEAN((Object)Boolean.FALSE), 
        BYTE_STRING((Object)ByteString.EMPTY), 
        DOUBLE((Object)0.0), 
        ENUM((Object)null), 
        FLOAT((Object)0.0f), 
        INT((Object)0), 
        LONG((Object)0L), 
        MESSAGE((Object)null), 
        STRING((Object)"");
        
        private final Object defaultDefault;
        
        private JavaType(final Object defaultDefault) {
            this.defaultDefault = defaultDefault;
        }
        
        Object getDefaultDefault() {
            return this.defaultDefault;
        }
    }
}
