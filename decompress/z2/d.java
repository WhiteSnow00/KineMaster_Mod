// 
// Decompiled by Procyon v0.6.0
// 

package z2;

import com.fasterxml.jackson.core.JsonLocation;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.b;

public final class d extends b
{
    protected final d c;
    protected z2.b d;
    protected d e;
    protected String f;
    protected Object g;
    protected int h;
    protected int i;
    
    public d(final d c, final z2.b d, final int a, final int h, final int i) {
        this.c = c;
        this.d = d;
        super.a = a;
        this.h = h;
        this.i = i;
        super.b = -1;
    }
    
    private void h(final z2.b b, final String s) throws JsonProcessingException {
        if (b.c(s)) {
            final Object b2 = b.b();
            JsonParser jsonParser;
            if (b2 instanceof JsonParser) {
                jsonParser = (JsonParser)b2;
            }
            else {
                jsonParser = null;
            }
            final StringBuilder sb = new StringBuilder();
            sb.append("Duplicate field '");
            sb.append(s);
            sb.append("'");
            throw new JsonParseException(jsonParser, sb.toString());
        }
    }
    
    public static d l(final z2.b b) {
        return new d(null, b, 0, 1, 0);
    }
    
    @Override
    public String b() {
        return this.f;
    }
    
    public d i() {
        this.g = null;
        return this.c;
    }
    
    public d j(final int n, final int n2) {
        d e = this.e;
        if (e == null) {
            final z2.b d = this.d;
            z2.b a;
            if (d == null) {
                a = null;
            }
            else {
                a = d.a();
            }
            e = new d(this, a, 1, n, n2);
            this.e = e;
        }
        else {
            e.p(1, n, n2);
        }
        return e;
    }
    
    public d k(final int n, final int n2) {
        final d e = this.e;
        if (e == null) {
            final z2.b d = this.d;
            z2.b a;
            if (d == null) {
                a = null;
            }
            else {
                a = d.a();
            }
            return this.e = new d(this, a, 2, n, n2);
        }
        e.p(2, n, n2);
        return e;
    }
    
    public boolean m() {
        int b = super.b;
        boolean b2 = true;
        ++b;
        super.b = b;
        if (super.a == 0 || b <= 0) {
            b2 = false;
        }
        return b2;
    }
    
    public d n() {
        return this.c;
    }
    
    public JsonLocation o(final Object o) {
        return new JsonLocation(o, -1L, this.h, this.i);
    }
    
    protected void p(final int a, final int h, final int i) {
        super.a = a;
        super.b = -1;
        this.h = h;
        this.i = i;
        this.f = null;
        this.g = null;
        final z2.b d = this.d;
        if (d != null) {
            d.d();
        }
    }
    
    public void q(final String f) throws JsonProcessingException {
        this.f = f;
        final z2.b d = this.d;
        if (d != null) {
            this.h(d, f);
        }
    }
}
