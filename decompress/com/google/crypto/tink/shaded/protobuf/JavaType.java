// 
// Decompiled by Procyon v0.6.0
// 

package com.google.crypto.tink.shaded.protobuf;

public enum JavaType
{
    private static final JavaType[] $VALUES;
    
    BOOLEAN((Class<?>)Boolean.TYPE, (Class<?>)Boolean.class, (Object)Boolean.FALSE), 
    BYTE_STRING((Class<?>)ByteString.class, (Class<?>)ByteString.class, (Object)ByteString.EMPTY), 
    DOUBLE((Class<?>)Double.TYPE, (Class<?>)Double.class, (Object)0.0), 
    ENUM((Class<?>)type, (Class<?>)Integer.class, (Object)null), 
    FLOAT((Class<?>)Float.TYPE, (Class<?>)Float.class, (Object)0.0f), 
    INT((Class<?>)type, (Class<?>)Integer.class, (Object)0), 
    LONG((Class<?>)Long.TYPE, (Class<?>)Long.class, (Object)0L), 
    MESSAGE((Class<?>)Object.class, (Class<?>)Object.class, (Object)null), 
    STRING((Class<?>)String.class, (Class<?>)String.class, (Object)""), 
    VOID((Class<?>)Void.class, (Class<?>)Void.class, (Object)null);
    
    private final Class<?> boxedType;
    private final Object defaultDefault;
    private final Class<?> type;
    
    static {
        final Class<Integer> type = Integer.TYPE;
    }
    
    private JavaType(final Class<?> type, final Class<?> boxedType, final Object defaultDefault) {
        this.type = type;
        this.boxedType = boxedType;
        this.defaultDefault = defaultDefault;
    }
    
    public Class<?> getBoxedType() {
        return this.boxedType;
    }
    
    public Object getDefaultDefault() {
        return this.defaultDefault;
    }
    
    public Class<?> getType() {
        return this.type;
    }
    
    public boolean isValidType(final Class<?> clazz) {
        return this.type.isAssignableFrom(clazz);
    }
}
