// 
// Decompiled by Procyon v0.6.0
// 

package r1;

import z1.c;
import y1.g;
import z1.a;
import java.util.List;

public class b extends f<Integer>
{
    public b(final List<z1.a<Integer>> list) {
        super(list);
    }
    
    @Override
    /* bridge */ Object i(final z1.a a, final float n) {
        return this.r(a, n);
    }
    
    public int p() {
        return this.q(((a<Integer, A>)this).b(), this.d());
    }
    
    public int q(final z1.a<Integer> a, final float n) {
        final Integer b = a.b;
        if (b != null && a.c != null) {
            final int intValue = b;
            final int intValue2 = a.c;
            final z1.c<A> e = super.e;
            if (e != null) {
                final Integer n2 = (Integer)e.b(a.g, a.h, (A)intValue, (A)intValue2, n, this.e(), this.f());
                if (n2 != null) {
                    return n2;
                }
            }
            return y1.b.c(y1.g.c(n, 0.0f, 1.0f), intValue, intValue2);
        }
        throw new IllegalStateException("Missing values for keyframe.");
    }
    
    Integer r(final z1.a<Integer> a, final float n) {
        return this.q(a, n);
    }
}
