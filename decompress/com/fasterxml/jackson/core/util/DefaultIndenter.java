// 
// Decompiled by Procyon v0.6.0
// 

package com.fasterxml.jackson.core.util;

import java.io.IOException;
import com.fasterxml.jackson.core.JsonGenerator;

public class DefaultIndenter extends NopIndenter
{
    public static final DefaultIndenter SYSTEM_LINEFEED_INSTANCE;
    public static final String SYS_LF;
    private static final long serialVersionUID = 1L;
    private final int charsPerLevel;
    private final String eol;
    private final char[] indents;
    
    static {
        String sys_LF;
        try {
            System.getProperty("line.separator");
        }
        finally {
            sys_LF = "\n";
        }
        SYS_LF = sys_LF;
        SYSTEM_LINEFEED_INSTANCE = new DefaultIndenter("  ", sys_LF);
    }
    
    public DefaultIndenter() {
        this("  ", DefaultIndenter.SYS_LF);
    }
    
    public DefaultIndenter(final String s, final String eol) {
        this.charsPerLevel = s.length();
        this.indents = new char[s.length() * 16];
        int i = 0;
        int n = 0;
        while (i < 16) {
            s.getChars(0, s.length(), this.indents, n);
            n += s.length();
            ++i;
        }
        this.eol = eol;
    }
    
    public String getEol() {
        return this.eol;
    }
    
    public String getIndent() {
        return new String(this.indents, 0, this.charsPerLevel);
    }
    
    @Override
    public boolean isInline() {
        return false;
    }
    
    public DefaultIndenter withIndent(final String s) {
        if (s.equals(this.getIndent())) {
            return this;
        }
        return new DefaultIndenter(s, this.eol);
    }
    
    public DefaultIndenter withLinefeed(final String s) {
        if (s.equals(this.eol)) {
            return this;
        }
        return new DefaultIndenter(this.getIndent(), s);
    }
    
    @Override
    public void writeIndentation(final JsonGenerator jsonGenerator, int n) throws IOException {
        jsonGenerator.V(this.eol);
        if (n > 0) {
            n *= this.charsPerLevel;
            char[] indents;
            while (true) {
                indents = this.indents;
                if (n <= indents.length) {
                    break;
                }
                jsonGenerator.W(indents, 0, indents.length);
                n -= this.indents.length;
            }
            jsonGenerator.W(indents, 0, n);
        }
    }
}
