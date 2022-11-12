// 
// Decompiled by Procyon v0.6.0
// 

package r1;

import z1.c;
import y1.g;
import z1.a;
import java.util.List;
import z1.d;

public class k extends f<z1.d>
{
    private final z1.d i;
    
    public k(final List<z1.a<z1.d>> list) {
        super(list);
        this.i = new z1.d();
    }
    
    public /* bridge */ Object i(final z1.a a, final float n) {
        return this.p(a, n);
    }
    
    public z1.d p(final z1.a<z1.d> a, final float n) {
        final z1.d b = a.b;
        if (b != null) {
            final z1.d c = a.c;
            if (c != null) {
                final z1.d d = b;
                final z1.d d2 = c;
                final z1.c<A> e = super.e;
                if (e != null) {
                    final z1.d d3 = (z1.d)e.b(a.g, a.h, (A)d, (A)d2, n, this.e(), this.f());
                    if (d3 != null) {
                        return d3;
                    }
                }
                this.i.d(y1.g.k(d.b(), d2.b(), n), y1.g.k(d.c(), d2.c(), n));
                return this.i;
            }
        }
        throw new IllegalStateException("Missing values for keyframe.");
    }
}
