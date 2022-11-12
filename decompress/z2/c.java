// 
// Decompiled by Procyon v0.6.0
// 

package z2;

import java.io.IOException;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.util.DefaultPrettyPrinter;
import com.fasterxml.jackson.core.e;
import com.fasterxml.jackson.core.io.CharacterEscapes;
import x2.a;

public abstract class c extends a
{
    protected static final int[] x;
    protected final com.fasterxml.jackson.core.io.c g;
    protected int[] h;
    protected int i;
    protected CharacterEscapes j;
    protected e p;
    protected boolean w;
    
    static {
        x = com.fasterxml.jackson.core.io.a.e();
    }
    
    public c(final com.fasterxml.jackson.core.io.c g, final int n, final com.fasterxml.jackson.core.c c) {
        super(n, c);
        this.h = c.x;
        this.p = DefaultPrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR;
        this.g = g;
        if (Feature.ESCAPE_NON_ASCII.enabledIn(n)) {
            this.i = 127;
        }
        this.w = (Feature.QUOTE_FIELD_NAMES.enabledIn(n) ^ true);
    }
    
    public JsonGenerator B0(final e p) {
        this.p = p;
        return this;
    }
    
    protected void m0(final String s) throws IOException {
        this.a(String.format("Can not %s, expecting field name (context: %s)", s, super.d.g()));
    }
    
    protected void r0(final String s, final int n) throws IOException {
        if (n != 0) {
            if (n != 1) {
                if (n != 2) {
                    if (n != 3) {
                        if (n != 5) {
                            this.c();
                        }
                        else {
                            this.m0(s);
                        }
                    }
                    else {
                        super.a.writeRootValueSeparator(this);
                    }
                }
                else {
                    super.a.writeObjectFieldValueSeparator(this);
                }
            }
            else {
                super.a.writeArrayValueSeparator(this);
            }
        }
        else if (super.d.d()) {
            super.a.beforeArrayValues(this);
        }
        else if (super.d.e()) {
            super.a.beforeObjectEntries(this);
        }
    }
    
    public JsonGenerator t0(final CharacterEscapes j) {
        this.j = j;
        if (j == null) {
            this.h = c.x;
        }
        else {
            this.h = j.getEscapeCodesForAscii();
        }
        return this;
    }
    
    public JsonGenerator y0(final int n) {
        int i = n;
        if (n < 0) {
            i = 0;
        }
        this.i = i;
        return this;
    }
}
