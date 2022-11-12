// 
// Decompiled by Procyon v0.6.0
// 

package x2;

import com.fasterxml.jackson.core.util.f;
import com.fasterxml.jackson.core.io.JsonEOFException;
import com.fasterxml.jackson.core.JsonProcessingException;
import java.io.IOException;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonToken;
import java.math.BigDecimal;
import java.math.BigInteger;
import com.fasterxml.jackson.core.JsonParser;

public abstract class c extends JsonParser
{
    protected static final byte[] d;
    protected static final int[] e;
    protected static final BigInteger f;
    protected static final BigInteger g;
    protected static final BigInteger h;
    protected static final BigInteger i;
    protected static final BigDecimal j;
    protected static final BigDecimal p;
    protected static final BigDecimal w;
    protected static final BigDecimal x;
    protected JsonToken c;
    
    static {
        d = new byte[0];
        e = new int[0];
        final BigInteger bigInteger = f = BigInteger.valueOf(-2147483648L);
        final BigInteger bigInteger2 = g = BigInteger.valueOf(2147483647L);
        final BigInteger bigInteger3 = h = BigInteger.valueOf(Long.MIN_VALUE);
        final BigInteger bigInteger4 = i = BigInteger.valueOf(Long.MAX_VALUE);
        j = new BigDecimal(bigInteger3);
        p = new BigDecimal(bigInteger4);
        w = new BigDecimal(bigInteger);
        x = new BigDecimal(bigInteger2);
    }
    
    protected c(final int n) {
        super(n);
    }
    
    protected static final String O(final int n) {
        final char c = (char)n;
        if (Character.isISOControl(c)) {
            final StringBuilder sb = new StringBuilder();
            sb.append("(CTRL-CHAR, code ");
            sb.append(n);
            sb.append(")");
            return sb.toString();
        }
        if (n > 255) {
            final StringBuilder sb2 = new StringBuilder();
            sb2.append("'");
            sb2.append(c);
            sb2.append("' (code ");
            sb2.append(n);
            sb2.append(" / 0x");
            sb2.append(Integer.toHexString(n));
            sb2.append(")");
            return sb2.toString();
        }
        final StringBuilder sb3 = new StringBuilder();
        sb3.append("'");
        sb3.append(c);
        sb3.append("' (code ");
        sb3.append(n);
        sb3.append(")");
        return sb3.toString();
    }
    
    protected void B0(final String s) throws JsonParseException {
        final StringBuilder sb = new StringBuilder();
        sb.append("Invalid numeric value: ");
        sb.append(s);
        this.Z(sb.toString());
    }
    
    protected void C0() throws IOException {
        this.Z(String.format("Numeric value (%s) out of range of int (%d - %s)", this.u(), Integer.MIN_VALUE, Integer.MAX_VALUE));
    }
    
    @Override
    public abstract JsonToken F() throws IOException;
    
    protected void F0() throws IOException {
        this.Z(String.format("Numeric value (%s) out of range of long (%d - %s)", this.u(), Long.MIN_VALUE, Long.MAX_VALUE));
    }
    
    protected void G0(final int n, final String s) throws JsonParseException {
        String s2 = String.format("Unexpected character (%s) in numeric value", O(n));
        if (s != null) {
            final StringBuilder sb = new StringBuilder();
            sb.append(s2);
            sb.append(": ");
            sb.append(s);
            s2 = sb.toString();
        }
        this.Z(s2);
    }
    
    @Override
    public JsonParser L() throws IOException {
        final JsonToken c = this.c;
        if (c != JsonToken.START_OBJECT && c != JsonToken.START_ARRAY) {
            return this;
        }
        int n = 1;
        while (true) {
            final JsonToken f = this.F();
            if (f == null) {
                this.V();
                return this;
            }
            if (f.isStructStart()) {
                ++n;
            }
            else if (f.isStructEnd()) {
                if (--n == 0) {
                    return this;
                }
                continue;
            }
            else {
                if (f != JsonToken.NOT_AVAILABLE) {
                    continue;
                }
                this.a0("Not enough content available for `skipChildren()`: non-blocking parser? (%s)", this.getClass().getName());
            }
        }
    }
    
    protected final JsonParseException M(final String s, final Throwable t) {
        return new JsonParseException(this, s, t);
    }
    
    protected abstract void V() throws JsonParseException;
    
    protected char W(final char c) throws JsonProcessingException {
        if (this.E(Feature.ALLOW_BACKSLASH_ESCAPING_ANY_CHARACTER)) {
            return c;
        }
        if (c == '\'' && this.E(Feature.ALLOW_SINGLE_QUOTES)) {
            return c;
        }
        final StringBuilder sb = new StringBuilder();
        sb.append("Unrecognized character escape ");
        sb.append(O(c));
        this.Z(sb.toString());
        return c;
    }
    
    protected final void Z(final String s) throws JsonParseException {
        throw this.a(s);
    }
    
    protected final void a0(final String s, final Object o) throws JsonParseException {
        throw this.a(String.format(s, o));
    }
    
    protected final void c0(final String s, final Object o, final Object o2) throws JsonParseException {
        throw this.a(String.format(s, o, o2));
    }
    
    protected void e0() throws JsonParseException {
        final StringBuilder sb = new StringBuilder();
        sb.append(" in ");
        sb.append(this.c);
        this.f0(sb.toString(), this.c);
    }
    
    protected void f0(final String s, final JsonToken jsonToken) throws JsonParseException {
        final StringBuilder sb = new StringBuilder();
        sb.append("Unexpected end-of-input");
        sb.append(s);
        throw new JsonEOFException(this, jsonToken, sb.toString());
    }
    
    protected void g0(final JsonToken jsonToken) throws JsonParseException {
        String s;
        if (jsonToken == JsonToken.VALUE_STRING) {
            s = " in a String value";
        }
        else if (jsonToken != JsonToken.VALUE_NUMBER_INT && jsonToken != JsonToken.VALUE_NUMBER_FLOAT) {
            s = " in a value";
        }
        else {
            s = " in a Number value";
        }
        this.f0(s, jsonToken);
    }
    
    @Override
    public JsonToken i() {
        return this.c;
    }
    
    protected void i0(final int n) throws JsonParseException {
        this.l0(n, "Expected space separating root-level values");
    }
    
    protected void l0(final int n, final String s) throws JsonParseException {
        if (n < 0) {
            this.e0();
        }
        String s2 = String.format("Unexpected character (%s)", O(n));
        if (s != null) {
            final StringBuilder sb = new StringBuilder();
            sb.append(s2);
            sb.append(": ");
            sb.append(s);
            s2 = sb.toString();
        }
        this.Z(s2);
    }
    
    protected final void m0() {
        com.fasterxml.jackson.core.util.f.c();
    }
    
    protected void r0(int n) throws JsonParseException {
        n = (char)n;
        final StringBuilder sb = new StringBuilder();
        sb.append("Illegal character (");
        sb.append(O(n));
        sb.append("): only regular white space (\\r, \\n, \\t) is allowed between tokens");
        this.Z(sb.toString());
    }
    
    protected void t0(int n, final String s) throws JsonParseException {
        if (!this.E(Feature.ALLOW_UNQUOTED_CONTROL_CHARS) || n > 32) {
            n = (char)n;
            final StringBuilder sb = new StringBuilder();
            sb.append("Illegal unquoted character (");
            sb.append(O(n));
            sb.append("): has to be escaped using backslash to be included in ");
            sb.append(s);
            this.Z(sb.toString());
        }
    }
    
    @Override
    public abstract String u() throws IOException;
    
    protected final void y0(final String s, final Throwable t) throws JsonParseException {
        throw this.M(s, t);
    }
}
