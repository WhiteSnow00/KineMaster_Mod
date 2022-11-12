// 
// Decompiled by Procyon v0.6.0
// 

package v1;

import q1.q;
import q1.c;
import com.airbnb.lottie.model.layer.a;
import com.airbnb.lottie.f;
import u1.h;

public class j implements b
{
    private final String a;
    private final int b;
    private final h c;
    private final boolean d;
    
    public j(final String a, final int b, final h c, final boolean d) {
        this.a = a;
        this.b = b;
        this.c = c;
        this.d = d;
    }
    
    @Override
    public c a(final f f, final a a) {
        return new q(f, a, this);
    }
    
    public String b() {
        return this.a;
    }
    
    public h c() {
        return this.c;
    }
    
    public boolean d() {
        return this.d;
    }
    
    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append("ShapePath{name=");
        sb.append(this.a);
        sb.append(", index=");
        sb.append(this.b);
        sb.append('}');
        return sb.toString();
    }
}
