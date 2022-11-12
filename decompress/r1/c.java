// 
// Decompiled by Procyon v0.6.0
// 

package r1;

import y1.g;
import z1.a;
import java.util.List;

public class c extends f<Float>
{
    public c(final List<z1.a<Float>> list) {
        super(list);
    }
    
    @Override
    /* bridge */ Object i(final z1.a a, final float n) {
        return this.r(a, n);
    }
    
    public float p() {
        return this.q(((a<Float, A>)this).b(), this.d());
    }
    
    float q(final z1.a<Float> a, final float n) {
        if (a.b != null && a.c != null) {
            final z1.c<A> e = super.e;
            if (e != null) {
                final Float n2 = (Float)e.b(a.g, a.h, (A)a.b, (A)a.c, n, this.e(), this.f());
                if (n2 != null) {
                    return n2;
                }
            }
            return y1.g.k(a.f(), a.c(), n);
        }
        throw new IllegalStateException("Missing values for keyframe.");
    }
    
    Float r(final z1.a<Float> a, final float n) {
        return this.q(a, n);
    }
}
