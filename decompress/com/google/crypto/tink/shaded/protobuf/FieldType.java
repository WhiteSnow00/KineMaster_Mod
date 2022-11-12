// 
// Decompiled by Procyon v0.6.0
// 

package com.google.crypto.tink.shaded.protobuf;

import java.lang.reflect.Field;
import java.lang.reflect.TypeVariable;
import java.util.List;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

public enum FieldType
{
    private static final FieldType[] $VALUES;
    
    BOOL(7, scalar, boolean1), 
    BOOL_LIST(25, vector, boolean1), 
    BOOL_LIST_PACKED(42, packed_VECTOR, boolean1), 
    BYTES(10, scalar, byte_STRING), 
    BYTES_LIST(28, vector, byte_STRING), 
    DOUBLE(0, scalar, double1), 
    DOUBLE_LIST(18, vector, double1), 
    DOUBLE_LIST_PACKED(35, packed_VECTOR, double1);
    
    private static final Type[] EMPTY_TYPES;
    
    ENUM(12, scalar, enum1), 
    ENUM_LIST(30, vector, enum1), 
    ENUM_LIST_PACKED(44, packed_VECTOR, enum1), 
    FIXED32(6, scalar, int1), 
    FIXED32_LIST(24, vector, int1), 
    FIXED32_LIST_PACKED(41, packed_VECTOR, int1), 
    FIXED64(5, scalar, long1), 
    FIXED64_LIST(23, vector, long1), 
    FIXED64_LIST_PACKED(40, packed_VECTOR, long1), 
    FLOAT(1, scalar, float1), 
    FLOAT_LIST(19, vector, float1), 
    FLOAT_LIST_PACKED(36, packed_VECTOR, float1), 
    GROUP(17, scalar, message), 
    GROUP_LIST(49, vector, message), 
    INT32(4, scalar, int1), 
    INT32_LIST(22, vector, int1), 
    INT32_LIST_PACKED(39, packed_VECTOR, int1), 
    INT64(2, scalar, long1), 
    INT64_LIST(20, vector, long1), 
    INT64_LIST_PACKED(37, packed_VECTOR, long1), 
    MAP(50, Collection.MAP, JavaType.VOID), 
    MESSAGE(9, scalar, message), 
    MESSAGE_LIST(27, vector, message), 
    SFIXED32(13, scalar, int1), 
    SFIXED32_LIST(31, vector, int1), 
    SFIXED32_LIST_PACKED(45, packed_VECTOR, int1), 
    SFIXED64(14, scalar, long1), 
    SFIXED64_LIST(32, vector, long1), 
    SFIXED64_LIST_PACKED(46, packed_VECTOR, long1), 
    SINT32(15, scalar, int1), 
    SINT32_LIST(33, vector, int1), 
    SINT32_LIST_PACKED(47, packed_VECTOR, int1), 
    SINT64(16, scalar, long1), 
    SINT64_LIST(34, vector, long1), 
    SINT64_LIST_PACKED(48, packed_VECTOR, long1), 
    STRING(8, scalar, string), 
    STRING_LIST(26, vector, string), 
    UINT32(11, scalar, int1), 
    UINT32_LIST(29, vector, int1), 
    UINT32_LIST_PACKED(43, packed_VECTOR, int1), 
    UINT64(3, scalar, long1), 
    UINT64_LIST(21, vector, long1), 
    UINT64_LIST_PACKED(38, packed_VECTOR, long1);
    
    private static final FieldType[] VALUES;
    private final Collection collection;
    private final Class<?> elementType;
    private final int id;
    private final JavaType javaType;
    private final boolean primitiveScalar;
    
    static {
        final Collection scalar = Collection.SCALAR;
        final JavaType double1 = JavaType.DOUBLE;
        final JavaType float1 = JavaType.FLOAT;
        final JavaType long1 = JavaType.LONG;
        final JavaType int1 = JavaType.INT;
        final JavaType boolean1 = JavaType.BOOLEAN;
        final JavaType string = JavaType.STRING;
        final JavaType message = JavaType.MESSAGE;
        final JavaType byte_STRING = JavaType.BYTE_STRING;
        final JavaType enum1 = JavaType.ENUM;
        final Collection vector = Collection.VECTOR;
        final Collection packed_VECTOR = Collection.PACKED_VECTOR;
        int i = 0;
        final FieldType fieldType;
        final FieldType fieldType2;
        final FieldType fieldType3;
        final FieldType fieldType4;
        final FieldType fieldType5;
        final FieldType fieldType6;
        final FieldType fieldType7;
        final FieldType fieldType8;
        final FieldType fieldType9;
        final FieldType fieldType10;
        final FieldType fieldType11;
        final FieldType fieldType12;
        final FieldType fieldType13;
        final FieldType fieldType14;
        final FieldType fieldType15;
        final FieldType fieldType16;
        final FieldType fieldType17;
        final FieldType fieldType18;
        final FieldType fieldType19;
        final FieldType fieldType20;
        final FieldType fieldType21;
        final FieldType fieldType22;
        final FieldType fieldType23;
        final FieldType fieldType24;
        final FieldType fieldType25;
        final FieldType fieldType26;
        final FieldType fieldType27;
        final FieldType fieldType28;
        final FieldType fieldType29;
        final FieldType fieldType30;
        final FieldType fieldType31;
        final FieldType fieldType32;
        final FieldType fieldType33;
        final FieldType fieldType34;
        final FieldType fieldType35;
        final FieldType fieldType36;
        final FieldType fieldType37;
        final FieldType fieldType38;
        final FieldType fieldType39;
        final FieldType fieldType40;
        final FieldType fieldType41;
        final FieldType fieldType42;
        final FieldType fieldType43;
        final FieldType fieldType44;
        final FieldType fieldType45;
        final FieldType fieldType46;
        final FieldType fieldType47;
        final FieldType fieldType48;
        final FieldType fieldType49;
        final FieldType fieldType50;
        final FieldType fieldType51;
        $VALUES = new FieldType[] { fieldType, fieldType2, fieldType3, fieldType4, fieldType5, fieldType6, fieldType7, fieldType8, fieldType9, fieldType10, fieldType11, fieldType12, fieldType13, fieldType14, fieldType15, fieldType16, fieldType17, fieldType18, fieldType19, fieldType20, fieldType21, fieldType22, fieldType23, fieldType24, fieldType25, fieldType26, fieldType27, fieldType28, fieldType29, fieldType30, fieldType31, fieldType32, fieldType33, fieldType34, fieldType35, fieldType36, fieldType37, fieldType38, fieldType39, fieldType40, fieldType41, fieldType42, fieldType43, fieldType44, fieldType45, fieldType46, fieldType47, fieldType48, fieldType49, fieldType50, fieldType51 };
        EMPTY_TYPES = new Type[0];
        final FieldType[] values = values();
        VALUES = new FieldType[values.length];
        while (i < values.length) {
            final FieldType fieldType52 = values[i];
            FieldType.VALUES[fieldType52.id] = fieldType52;
            ++i;
        }
    }
    
    private FieldType(final int id, final Collection collection, final JavaType javaType) {
        this.id = id;
        this.collection = collection;
        this.javaType = javaType;
        n = FieldType$a.a[collection.ordinal()];
        boolean primitiveScalar = true;
        if (n != 1) {
            if (n != 2) {
                this.elementType = null;
            }
            else {
                this.elementType = javaType.getBoxedType();
            }
        }
        else {
            this.elementType = javaType.getBoxedType();
        }
        Label_0114: {
            if (collection == Collection.SCALAR) {
                n = FieldType$a.b[javaType.ordinal()];
                if (n != 1 && n != 2 && n != 3) {
                    break Label_0114;
                }
            }
            primitiveScalar = false;
        }
        this.primitiveScalar = primitiveScalar;
    }
    
    private static Type a(final Class<?> clazz) {
        for (final Type type : clazz.getGenericInterfaces()) {
            if (type instanceof ParameterizedType && List.class.isAssignableFrom((Class<?>)((ParameterizedType)type).getRawType())) {
                return type;
            }
        }
        final Type genericSuperclass = clazz.getGenericSuperclass();
        if (genericSuperclass instanceof ParameterizedType && List.class.isAssignableFrom((Class<?>)((ParameterizedType)genericSuperclass).getRawType())) {
            return genericSuperclass;
        }
        return null;
    }
    
    private static Type c(Class<?> superclass, Type[] empty_TYPES) {
    Label_0000:
        while (true) {
            int i = 0;
            if (superclass != List.class) {
                final Type a = a(superclass);
                if (a instanceof ParameterizedType) {
                    final ParameterizedType parameterizedType = (ParameterizedType)a;
                    final Type[] actualTypeArguments = parameterizedType.getActualTypeArguments();
                Label_0167:
                    for (int j = 0; j < actualTypeArguments.length; ++j) {
                        final Type type = actualTypeArguments[j];
                        if (type instanceof TypeVariable) {
                            final TypeVariable[] typeParameters = superclass.getTypeParameters();
                            if (empty_TYPES.length == typeParameters.length) {
                                int k = 0;
                                while (true) {
                                    while (k < typeParameters.length) {
                                        if (type == typeParameters[k]) {
                                            actualTypeArguments[j] = empty_TYPES[k];
                                            final boolean b = true;
                                            if (b) {
                                                continue Label_0167;
                                            }
                                            final StringBuilder sb = new StringBuilder();
                                            sb.append("Unable to find replacement for ");
                                            sb.append(type);
                                            throw new RuntimeException(sb.toString());
                                        }
                                        else {
                                            ++k;
                                        }
                                    }
                                    final boolean b = false;
                                    continue;
                                }
                            }
                            throw new RuntimeException("Type array mismatch");
                        }
                    }
                    superclass = (Class)parameterizedType.getRawType();
                    empty_TYPES = actualTypeArguments;
                }
                else {
                    empty_TYPES = FieldType.EMPTY_TYPES;
                    for (Class[] interfaces = superclass.getInterfaces(); i < interfaces.length; ++i) {
                        final Class clazz = interfaces[i];
                        if (List.class.isAssignableFrom(clazz)) {
                            superclass = clazz;
                            continue Label_0000;
                        }
                    }
                    superclass = superclass.getSuperclass();
                }
            }
            else {
                if (empty_TYPES.length == 1) {
                    return empty_TYPES[0];
                }
                throw new RuntimeException("Unable to identify parameter type for List<T>");
            }
        }
    }
    
    private boolean d(final Field field) {
        final Class<?> type = field.getType();
        if (!this.javaType.getType().isAssignableFrom(type)) {
            return false;
        }
        Type[] array = FieldType.EMPTY_TYPES;
        if (field.getGenericType() instanceof ParameterizedType) {
            array = ((ParameterizedType)field.getGenericType()).getActualTypeArguments();
        }
        final Type c = c(type, array);
        return !(c instanceof Class) || this.elementType.isAssignableFrom((Class<?>)c);
    }
    
    public static FieldType forId(final int n) {
        if (n >= 0) {
            final FieldType[] values = FieldType.VALUES;
            if (n < values.length) {
                return values[n];
            }
        }
        return null;
    }
    
    public JavaType getJavaType() {
        return this.javaType;
    }
    
    public int id() {
        return this.id;
    }
    
    public boolean isList() {
        return this.collection.isList();
    }
    
    public boolean isMap() {
        return this.collection == Collection.MAP;
    }
    
    public boolean isPacked() {
        return Collection.PACKED_VECTOR.equals(this.collection);
    }
    
    public boolean isPrimitiveScalar() {
        return this.primitiveScalar;
    }
    
    public boolean isScalar() {
        return this.collection == Collection.SCALAR;
    }
    
    public boolean isValidForField(final Field field) {
        if (Collection.VECTOR.equals(this.collection)) {
            return this.d(field);
        }
        return this.javaType.getType().isAssignableFrom(field.getType());
    }
    
    enum Collection
    {
        private static final Collection[] $VALUES;
        
        MAP(false), 
        PACKED_VECTOR(true), 
        SCALAR(false), 
        VECTOR(true);
        
        private final boolean isList;
        
        private Collection(final boolean isList) {
            this.isList = isList;
        }
        
        public boolean isList() {
            return this.isList;
        }
    }
}
