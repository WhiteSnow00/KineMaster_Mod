// 
// Decompiled by Procyon v0.6.0
// 

package r1;

import java.util.List;
import java.util.Collections;
import z1.c;
import android.graphics.PointF;

public class m extends a<PointF, PointF>
{
    private final PointF i;
    private final PointF j;
    private final a<Float, Float> k;
    private final a<Float, Float> l;
    protected z1.c<Float> m;
    protected z1.c<Float> n;
    
    public m(final a<Float, Float> k, final a<Float, Float> l) {
        super(Collections.emptyList());
        this.i = new PointF();
        this.j = new PointF();
        this.k = k;
        this.l = l;
        this.m(this.f());
    }
    
    @Override
    public /* bridge */ Object h() {
        return this.p();
    }
    
    @Override
    /* bridge */ Object i(final z1.a a, final float n) {
        return this.q(a, n);
    }
    
    @Override
    public void m(final float n) {
        this.k.m(n);
        this.l.m(n);
        this.i.set((float)this.k.h(), (float)this.l.h());
        for (int i = 0; i < super.a.size(); ++i) {
            ((b)super.a.get(i)).a();
        }
    }
    
    public PointF p() {
        return this.q(null, 0.0f);
    }
    
    PointF q(final z1.a<PointF> a, final float n) {
        final z1.c<Float> m = this.m;
        final Float n2 = null;
        Float n3 = null;
        Label_0100: {
            if (m != null) {
                final z1.a<Float> b = this.k.b();
                if (b != null) {
                    final float d = this.k.d();
                    final Float h = b.h;
                    final z1.c<Float> i = this.m;
                    final float g = b.g;
                    float floatValue;
                    if (h == null) {
                        floatValue = g;
                    }
                    else {
                        floatValue = h;
                    }
                    n3 = i.b(g, floatValue, b.b, b.c, n, n, d);
                    break Label_0100;
                }
            }
            n3 = null;
        }
        Float n4 = n2;
        if (this.n != null) {
            final z1.a<Float> b2 = this.l.b();
            n4 = n2;
            if (b2 != null) {
                final float d2 = this.l.d();
                final Float h2 = b2.h;
                final z1.c<Float> n5 = this.n;
                final float g2 = b2.g;
                float floatValue2;
                if (h2 == null) {
                    floatValue2 = g2;
                }
                else {
                    floatValue2 = h2;
                }
                n4 = n5.b(g2, floatValue2, b2.b, b2.c, n, n, d2);
            }
        }
        if (n3 == null) {
            this.j.set(this.i.x, 0.0f);
        }
        else {
            this.j.set((float)n3, 0.0f);
        }
        if (n4 == null) {
            final PointF j = this.j;
            j.set(j.x, this.i.y);
        }
        else {
            final PointF k = this.j;
            k.set(k.x, (float)n4);
        }
        return this.j;
    }
    
    public void r(final z1.c<Float> m) {
        final z1.c<Float> i = this.m;
        if (i != null) {
            i.c(null);
        }
        if ((this.m = m) != null) {
            m.c(this);
        }
    }
    
    public void s(final z1.c<Float> n) {
        final z1.c<Float> n2 = this.n;
        if (n2 != null) {
            n2.c(null);
        }
        if ((this.n = n) != null) {
            n.c(this);
        }
    }
}
