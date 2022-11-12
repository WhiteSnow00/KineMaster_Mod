// 
// Decompiled by Procyon v0.6.0
// 

package z2;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.b;

public class e extends b
{
    protected final e c;
    protected z2.b d;
    protected e e;
    protected String f;
    protected Object g;
    protected boolean h;
    
    protected e(final int a, final e c, final z2.b d) {
        super.a = a;
        this.c = c;
        this.d = d;
        super.b = -1;
    }
    
    private final void h(final z2.b b, String string) throws JsonProcessingException {
        if (b.c(string)) {
            final Object b2 = b.b();
            final StringBuilder sb = new StringBuilder();
            sb.append("Duplicate field '");
            sb.append(string);
            sb.append("'");
            string = sb.toString();
            JsonGenerator jsonGenerator;
            if (b2 instanceof JsonGenerator) {
                jsonGenerator = (JsonGenerator)b2;
            }
            else {
                jsonGenerator = null;
            }
            throw new JsonGenerationException(string, jsonGenerator);
        }
    }
    
    public static e l(final z2.b b) {
        return new e(0, null, b);
    }
    
    @Override
    public final String b() {
        return this.f;
    }
    
    public e i() {
        this.g = null;
        return this.c;
    }
    
    public e j() {
        final e e = this.e;
        if (e == null) {
            final z2.b d = this.d;
            z2.b a;
            if (d == null) {
                a = null;
            }
            else {
                a = d.a();
            }
            return this.e = new e(1, this, a);
        }
        return e.m(1);
    }
    
    public e k() {
        final e e = this.e;
        if (e == null) {
            final z2.b d = this.d;
            z2.b a;
            if (d == null) {
                a = null;
            }
            else {
                a = d.a();
            }
            return this.e = new e(2, this, a);
        }
        return e.m(2);
    }
    
    protected e m(final int a) {
        super.a = a;
        super.b = -1;
        this.f = null;
        this.h = false;
        this.g = null;
        final z2.b d = this.d;
        if (d != null) {
            d.d();
        }
        return this;
    }
    
    public int n(final String f) throws JsonProcessingException {
        if (super.a == 2 && !this.h) {
            int n = 1;
            this.h = true;
            this.f = f;
            final z2.b d = this.d;
            if (d != null) {
                this.h(d, f);
            }
            if (super.b < 0) {
                n = 0;
            }
            return n;
        }
        return 4;
    }
    
    public int o() {
        final int a = super.a;
        int n = 0;
        final int n2 = 0;
        if (a == 2) {
            if (!this.h) {
                return 5;
            }
            this.h = false;
            ++super.b;
            return 2;
        }
        else {
            if (a == 1) {
                int n3;
                if (super.b++ < 0) {
                    n3 = n2;
                }
                else {
                    n3 = 1;
                }
                return n3;
            }
            if (++super.b != 0) {
                n = 3;
            }
            return n;
        }
    }
}
