// 
// Decompiled by Procyon v0.6.0
// 

package x2;

import com.fasterxml.jackson.core.util.DefaultPrettyPrinter;
import com.fasterxml.jackson.core.d;
import java.math.BigDecimal;
import java.io.IOException;
import z2.b;
import com.fasterxml.jackson.core.c;
import z2.e;
import com.fasterxml.jackson.core.JsonGenerator;

public abstract class a extends JsonGenerator
{
    protected static final int f;
    protected int b;
    protected boolean c;
    protected e d;
    protected boolean e;
    
    static {
        f = (Feature.WRITE_NUMBERS_AS_STRINGS.getMask() | Feature.ESCAPE_NON_ASCII.getMask() | Feature.STRICT_DUPLICATE_DETECTION.getMask());
    }
    
    protected a(final int b, final c c) {
        this.b = b;
        b e;
        if (Feature.STRICT_DUPLICATE_DETECTION.enabledIn(b)) {
            e = z2.b.e(this);
        }
        else {
            e = null;
        }
        this.d = z2.e.l(e);
        this.c = Feature.WRITE_NUMBERS_AS_STRINGS.enabledIn(b);
    }
    
    @Override
    public void close() throws IOException {
        this.e = true;
    }
    
    protected String e0(final BigDecimal bigDecimal) throws IOException {
        if (Feature.WRITE_BIGDECIMAL_AS_PLAIN.enabledIn(this.b)) {
            final int scale = bigDecimal.scale();
            if (scale < -9999 || scale > 9999) {
                this.a(String.format("Attempt to write plain `java.math.BigDecimal` (see JsonGenerator.Feature.WRITE_BIGDECIMAL_AS_PLAIN) with illegal scale (%d): needs to be between [-%d, %d]", scale, 9999, 9999));
            }
            return bigDecimal.toPlainString();
        }
        return bigDecimal.toString();
    }
    
    protected d f0() {
        return new DefaultPrettyPrinter();
    }
    
    protected final int g0(final int n, final int n2) throws IOException {
        if (n2 < 56320 || n2 > 57343) {
            final StringBuilder sb = new StringBuilder();
            sb.append("Incomplete surrogate pair: first char 0x");
            sb.append(Integer.toHexString(n));
            sb.append(", second 0x");
            sb.append(Integer.toHexString(n2));
            this.a(sb.toString());
        }
        return (n - 55296 << 10) + 65536 + (n2 - 56320);
    }
    
    @Override
    public JsonGenerator h() {
        if (this.d() != null) {
            return this;
        }
        return this.e(this.f0());
    }
    
    public com.fasterxml.jackson.core.b i0() {
        return this.d;
    }
    
    public final boolean l0(final Feature feature) {
        return (feature.getMask() & this.b) != 0x0;
    }
}
