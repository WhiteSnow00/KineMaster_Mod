// 
// Decompiled by Procyon v0.6.0
// 

package v1;

import q1.p;
import q1.c;
import com.airbnb.lottie.model.layer.a;
import u1.l;

public class f implements b
{
    private final String a;
    private final u1.b b;
    private final u1.b c;
    private final l d;
    private final boolean e;
    
    public f(final String a, final u1.b b, final u1.b c, final l d, final boolean e) {
        this.a = a;
        this.b = b;
        this.c = c;
        this.d = d;
        this.e = e;
    }
    
    @Override
    public c a(final com.airbnb.lottie.f f, final a a) {
        return new p(f, a, this);
    }
    
    public u1.b b() {
        return this.b;
    }
    
    public String c() {
        return this.a;
    }
    
    public u1.b d() {
        return this.c;
    }
    
    public l e() {
        return this.d;
    }
    
    public boolean f() {
        return this.e;
    }
}
