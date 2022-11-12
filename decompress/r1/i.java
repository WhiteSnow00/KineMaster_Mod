// 
// Decompiled by Procyon v0.6.0
// 

package r1;

import z1.c;
import android.graphics.Path;
import z1.a;
import java.util.List;
import android.graphics.PathMeasure;
import android.graphics.PointF;

public class i extends f<PointF>
{
    private final PointF i;
    private final float[] j;
    private final PathMeasure k;
    private h l;
    
    public i(final List<? extends z1.a<PointF>> list) {
        super(list);
        this.i = new PointF();
        this.j = new float[2];
        this.k = new PathMeasure();
    }
    
    public /* bridge */ Object i(final z1.a a, final float n) {
        return this.p(a, n);
    }
    
    public PointF p(final z1.a<PointF> a, final float n) {
        final h l = (h)a;
        final Path j = l.j();
        if (j == null) {
            return a.b;
        }
        final z1.c<A> e = super.e;
        if (e != null) {
            final PointF pointF = (PointF)e.b(l.g, l.h, (A)l.b, (A)l.c, this.e(), n, this.f());
            if (pointF != null) {
                return pointF;
            }
        }
        if (this.l != l) {
            this.k.setPath(j, false);
            this.l = l;
        }
        final PathMeasure k = this.k;
        k.getPosTan(n * k.getLength(), this.j, (float[])null);
        final PointF i = this.i;
        final float[] m = this.j;
        i.set(m[0], m[1]);
        return this.i;
    }
}
