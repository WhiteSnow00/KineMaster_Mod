// 
// Decompiled by Procyon v0.6.0
// 

package r1;

import com.airbnb.lottie.d;
import android.graphics.Path;
import android.graphics.PointF;
import z1.a;

public class h extends a<PointF>
{
    private Path q;
    private final a<PointF> r;
    
    public h(final d d, final a<PointF> r) {
        super(d, r.b, r.c, r.d, r.e, r.f, r.g, r.h);
        this.r = r;
        this.i();
    }
    
    public void i() {
        final T c = (T)super.c;
        boolean b2 = false;
        Label_0049: {
            if (c != null) {
                final T b = (T)super.b;
                if (b != null && ((PointF)b).equals(((PointF)c).x, ((PointF)c).y)) {
                    b2 = true;
                    break Label_0049;
                }
            }
            b2 = false;
        }
        final T b3 = (T)super.b;
        if (b3 != null) {
            final T c2 = (T)super.c;
            if (c2 != null && !b2) {
                final PointF pointF = (PointF)b3;
                final PointF pointF2 = (PointF)c2;
                final a<PointF> r = this.r;
                this.q = y1.h.d(pointF, pointF2, r.o, r.p);
            }
        }
    }
    
    Path j() {
        return this.q;
    }
}
