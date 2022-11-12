// 
// Decompiled by Procyon v0.6.0
// 

package com.fasterxml.jackson.core;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.io.IOException;
import com.fasterxml.jackson.core.util.RequestPayload;
import java.io.Closeable;

public abstract class JsonParser implements Closeable
{
    protected int a;
    protected transient RequestPayload b;
    
    protected JsonParser() {
    }
    
    protected JsonParser(final int a) {
        this.a = a;
    }
    
    public boolean E(final Feature feature) {
        return feature.enabledIn(this.a);
    }
    
    public abstract JsonToken F() throws IOException;
    
    public abstract JsonParser L() throws IOException;
    
    protected JsonParseException a(final String s) {
        return new JsonParseException(this, s).withRequestPayload(this.b);
    }
    
    public abstract BigInteger c() throws IOException;
    
    @Override
    public abstract void close() throws IOException;
    
    public byte d() throws IOException {
        final int r = this.r();
        if (r >= -128 && r <= 255) {
            return (byte)r;
        }
        final StringBuilder sb = new StringBuilder();
        sb.append("Numeric value (");
        sb.append(this.u());
        sb.append(") out of range of Java byte");
        throw this.a(sb.toString());
    }
    
    public abstract JsonLocation e();
    
    public abstract String h() throws IOException;
    
    public abstract JsonToken i();
    
    public abstract BigDecimal j() throws IOException;
    
    public abstract double k() throws IOException;
    
    public abstract float l() throws IOException;
    
    public abstract int r() throws IOException;
    
    public abstract long s() throws IOException;
    
    public short t() throws IOException {
        final int r = this.r();
        if (r >= -32768 && r <= 32767) {
            return (short)r;
        }
        final StringBuilder sb = new StringBuilder();
        sb.append("Numeric value (");
        sb.append(this.u());
        sb.append(") out of range of Java short");
        throw this.a(sb.toString());
    }
    
    public abstract String u() throws IOException;
    
    public enum Feature
    {
        private static final Feature[] $VALUES;
        
        ALLOW_BACKSLASH_ESCAPING_ANY_CHARACTER(false), 
        ALLOW_COMMENTS(false), 
        ALLOW_MISSING_VALUES(false), 
        ALLOW_NON_NUMERIC_NUMBERS(false), 
        ALLOW_NUMERIC_LEADING_ZEROS(false), 
        ALLOW_SINGLE_QUOTES(false), 
        ALLOW_TRAILING_COMMA(false), 
        ALLOW_UNQUOTED_CONTROL_CHARS(false), 
        ALLOW_UNQUOTED_FIELD_NAMES(false), 
        ALLOW_YAML_COMMENTS(false), 
        AUTO_CLOSE_SOURCE(true), 
        IGNORE_UNDEFINED(false), 
        INCLUDE_SOURCE_IN_LOCATION(true), 
        STRICT_DUPLICATE_DETECTION(false);
        
        private final boolean _defaultState;
        private final int _mask;
        
        private Feature(final boolean defaultState) {
            this._mask = 1 << this.ordinal();
            this._defaultState = defaultState;
        }
        
        public static int collectDefaults() {
            final Feature[] values = values();
            final int length = values.length;
            int i = 0;
            int n = 0;
            while (i < length) {
                final Feature feature = values[i];
                int n2 = n;
                if (feature.enabledByDefault()) {
                    n2 = (n | feature.getMask());
                }
                ++i;
                n = n2;
            }
            return n;
        }
        
        public boolean enabledByDefault() {
            return this._defaultState;
        }
        
        public boolean enabledIn(final int n) {
            return (n & this._mask) != 0x0;
        }
        
        public int getMask() {
            return this._mask;
        }
    }
}
