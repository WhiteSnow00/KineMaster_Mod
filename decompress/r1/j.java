// 
// Decompiled by Procyon v0.6.0
// 

package r1;

import z1.c;
import z1.a;
import java.util.List;
import android.graphics.PointF;

public class j extends f<PointF>
{
    private final PointF i;
    
    public j(final List<z1.a<PointF>> list) {
        super(list);
        this.i = new PointF();
    }
    
    public /* bridge */ Object i(final z1.a a, final float n) {
        return this.p(a, n);
    }
    
    @Override
    protected /* bridge */ Object j(final z1.a a, final float n, final float n2, final float n3) {
        return this.q(a, n, n2, n3);
    }
    
    public PointF p(final z1.a<PointF> a, final float n) {
        return this.q(a, n, n, n);
    }
    
    protected PointF q(final z1.a<PointF> a, float x, final float n, final float n2) {
        final PointF b = a.b;
        if (b != null) {
            final PointF c = a.c;
            if (c != null) {
                final PointF pointF = b;
                final PointF pointF2 = c;
                final z1.c<A> e = super.e;
                if (e != null) {
                    final PointF pointF3 = (PointF)e.b(a.g, a.h, (A)pointF, (A)pointF2, x, this.e(), this.f());
                    if (pointF3 != null) {
                        return pointF3;
                    }
                }
                final PointF i = this.i;
                x = pointF.x;
                final float x2 = pointF2.x;
                final float y = pointF.y;
                i.set(x + n * (x2 - x), y + n2 * (pointF2.y - y));
                return this.i;
            }
        }
        throw new IllegalStateException("Missing values for keyframe.");
    }
}
