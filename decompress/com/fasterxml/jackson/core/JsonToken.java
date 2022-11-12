// 
// Decompiled by Procyon v0.6.0
// 

package com.fasterxml.jackson.core;

public enum JsonToken
{
    private static final JsonToken[] $VALUES;
    
    END_ARRAY("]", 4), 
    END_OBJECT("}", 2), 
    FIELD_NAME((String)null, 5), 
    NOT_AVAILABLE((String)null, -1), 
    START_ARRAY("[", 3), 
    START_OBJECT("{", 1), 
    VALUE_EMBEDDED_OBJECT((String)null, 12), 
    VALUE_FALSE("false", 10), 
    VALUE_NULL("null", 11), 
    VALUE_NUMBER_FLOAT((String)null, 8), 
    VALUE_NUMBER_INT((String)null, 7), 
    VALUE_STRING((String)null, 6), 
    VALUE_TRUE("true", 9);
    
    final int _id;
    final boolean _isBoolean;
    final boolean _isNumber;
    final boolean _isScalar;
    final boolean _isStructEnd;
    final boolean _isStructStart;
    final String _serialized;
    final byte[] _serializedBytes;
    final char[] _serializedChars;
    
    private JsonToken(final String serialized, final int id) {
        final boolean b = false;
        if (serialized == null) {
            this._serialized = null;
            this._serializedChars = null;
            this._serializedBytes = null;
        }
        else {
            this._serialized = serialized;
            final char[] charArray = serialized.toCharArray();
            this._serializedChars = charArray;
            final int length = charArray.length;
            this._serializedBytes = new byte[length];
            for (i = 0; i < length; ++i) {
                this._serializedBytes[i] = (byte)this._serializedChars[i];
            }
        }
        this._id = id;
        this._isBoolean = (id == 10 || id == 9);
        this._isNumber = (id == 7 || id == 8);
        final boolean isStructStart = id == 1 || id == 3;
        this._isStructStart = isStructStart;
        final boolean isStructEnd = id == 2 || id == 4;
        this._isStructEnd = isStructEnd;
        boolean isScalar = b;
        if (!isStructStart) {
            isScalar = b;
            if (!isStructEnd) {
                isScalar = b;
                if (id != 5) {
                    isScalar = b;
                    if (id != -1) {
                        isScalar = true;
                    }
                }
            }
        }
        this._isScalar = isScalar;
    }
    
    public final byte[] asByteArray() {
        return this._serializedBytes;
    }
    
    public final char[] asCharArray() {
        return this._serializedChars;
    }
    
    public final String asString() {
        return this._serialized;
    }
    
    public final int id() {
        return this._id;
    }
    
    public final boolean isBoolean() {
        return this._isBoolean;
    }
    
    public final boolean isNumeric() {
        return this._isNumber;
    }
    
    public final boolean isScalarValue() {
        return this._isScalar;
    }
    
    public final boolean isStructEnd() {
        return this._isStructEnd;
    }
    
    public final boolean isStructStart() {
        return this._isStructStart;
    }
}
