// 
// Decompiled by Procyon v0.6.0
// 

package z2;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonGenerator;
import java.util.HashSet;

public class b
{
    protected final Object a;
    protected String b;
    protected String c;
    protected HashSet<String> d;
    
    private b(final Object a) {
        this.a = a;
    }
    
    public static b e(final JsonGenerator jsonGenerator) {
        return new b(jsonGenerator);
    }
    
    public static b f(final JsonParser jsonParser) {
        return new b(jsonParser);
    }
    
    public b a() {
        return new b(this.a);
    }
    
    public Object b() {
        return this.a;
    }
    
    public boolean c(final String s) throws JsonParseException {
        final String b = this.b;
        if (b == null) {
            this.b = s;
            return false;
        }
        if (s.equals(b)) {
            return true;
        }
        final String c = this.c;
        if (c == null) {
            this.c = s;
            return false;
        }
        if (s.equals(c)) {
            return true;
        }
        if (this.d == null) {
            (this.d = new HashSet<String>(16)).add(this.b);
            this.d.add(this.c);
        }
        return this.d.add(s) ^ true;
    }
    
    public void d() {
        this.b = null;
        this.c = null;
        this.d = null;
    }
}
