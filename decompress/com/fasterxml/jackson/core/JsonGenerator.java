// 
// Decompiled by Procyon v0.6.0
// 

package com.fasterxml.jackson.core;

import com.fasterxml.jackson.core.util.f;
import java.math.BigInteger;
import java.math.BigDecimal;
import java.io.IOException;
import java.io.Flushable;
import java.io.Closeable;

public abstract class JsonGenerator implements Closeable, Flushable
{
    protected d a;
    
    protected JsonGenerator() {
    }
    
    public abstract void E(final long p0) throws IOException;
    
    public abstract void F(final BigDecimal p0) throws IOException;
    
    public abstract void L(final BigInteger p0) throws IOException;
    
    public abstract void M(final char p0) throws IOException;
    
    public void O(final e e) throws IOException {
        this.V(e.getValue());
    }
    
    public abstract void V(final String p0) throws IOException;
    
    public abstract void W(final char[] p0, final int p1, final int p2) throws IOException;
    
    public abstract void Z() throws IOException;
    
    protected void a(final String s) throws JsonGenerationException {
        throw new JsonGenerationException(s, this);
    }
    
    public abstract void a0() throws IOException;
    
    protected final void c() {
        f.c();
    }
    
    public abstract void c0(final String p0) throws IOException;
    
    public d d() {
        return this.a;
    }
    
    public JsonGenerator e(final d a) {
        this.a = a;
        return this;
    }
    
    @Override
    public abstract void flush() throws IOException;
    
    public abstract JsonGenerator h();
    
    public abstract void i(final boolean p0) throws IOException;
    
    public abstract void j() throws IOException;
    
    public abstract void k() throws IOException;
    
    public abstract void l(final String p0) throws IOException;
    
    public abstract void r() throws IOException;
    
    public abstract void s(final double p0) throws IOException;
    
    public abstract void t(final float p0) throws IOException;
    
    public abstract void u(final int p0) throws IOException;
    
    public enum Feature
    {
        private static final Feature[] $VALUES;
        
        AUTO_CLOSE_JSON_CONTENT(true), 
        AUTO_CLOSE_TARGET(true), 
        ESCAPE_NON_ASCII(false), 
        FLUSH_PASSED_TO_STREAM(true), 
        IGNORE_UNKNOWN(false), 
        QUOTE_FIELD_NAMES(true), 
        QUOTE_NON_NUMERIC_NUMBERS(true), 
        STRICT_DUPLICATE_DETECTION(false), 
        WRITE_BIGDECIMAL_AS_PLAIN(false), 
        WRITE_NUMBERS_AS_STRINGS(false);
        
        private final boolean _defaultState;
        private final int _mask;
        
        private Feature(final boolean defaultState) {
            this._defaultState = defaultState;
            this._mask = 1 << this.ordinal();
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
