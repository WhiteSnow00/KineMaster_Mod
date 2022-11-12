// 
// Decompiled by Procyon v0.6.0
// 

package r1;

import z1.c;
import y1.g;
import z1.a;
import java.util.List;

public class e extends f<Integer>
{
    public e(final List<z1.a<Integer>> list) {
        super(list);
    }
    
    @Override
    /* bridge */ Object i(final z1.a a, final float n) {
        return this.r(a, n);
    }
    
    public int p() {
        return this.q(((a<Integer, A>)this).b(), this.d());
    }
    
    int q(final z1.a<Integer> a, final float n) {
        if (a.b != null && a.c != null) {
            final z1.c<A> e = super.e;
            if (e != null) {
                final Integer n2 = (Integer)e.b(a.g, a.h, (A)a.b, (A)a.c, n, this.e(), this.f());
                if (n2 != null) {
                    return n2;
                }
            }
            return y1.g.l(a.g(), a.d(), n);
        }
        throw new IllegalStateException("Missing values for keyframe.");
    }
    
    Integer r(final z1.a<Integer> a, final float n) {
        return this.q(a, n);
    }
}
