// 
// Decompiled by Procyon v0.6.0
// 

package com.fasterxml.jackson.core;

public enum JsonEncoding
{
    private static final JsonEncoding[] $VALUES;
    
    UTF16_BE("UTF-16BE", true, 16), 
    UTF16_LE("UTF-16LE", false, 16), 
    UTF32_BE("UTF-32BE", true, 32), 
    UTF32_LE("UTF-32LE", false, 32), 
    UTF8("UTF-8", false, 8);
    
    private final boolean _bigEndian;
    private final int _bits;
    private final String _javaName;
    
    private JsonEncoding(final String javaName, final boolean bigEndian, final int bits) {
        this._javaName = javaName;
        this._bigEndian = bigEndian;
        this._bits = bits;
    }
    
    public int bits() {
        return this._bits;
    }
    
    public String getJavaName() {
        return this._javaName;
    }
    
    public boolean isBigEndian() {
        return this._bigEndian;
    }
}
