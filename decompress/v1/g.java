// 
// Decompiled by Procyon v0.6.0
// 

package v1;

import y1.d;
import java.util.Collection;
import java.util.ArrayList;
import android.graphics.PointF;
import t1.a;
import java.util.List;

public class g
{
    private final List<a> a;
    private PointF b;
    private boolean c;
    
    public g() {
        this.a = new ArrayList<a>();
    }
    
    public g(final PointF b, final boolean c, final List<a> list) {
        this.b = b;
        this.c = c;
        this.a = new ArrayList<a>(list);
    }
    
    private void e(final float n, final float n2) {
        if (this.b == null) {
            this.b = new PointF();
        }
        this.b.set(n, n2);
    }
    
    public List<a> a() {
        return this.a;
    }
    
    public PointF b() {
        return this.b;
    }
    
    public void c(final g g, final g g2, final float n) {
        if (this.b == null) {
            this.b = new PointF();
        }
        this.c = (g.d() || g2.d());
        if (g.a().size() != g2.a().size()) {
            final StringBuilder sb = new StringBuilder();
            sb.append("Curves must have the same number of control points. Shape 1: ");
            sb.append(g.a().size());
            sb.append("\tShape 2: ");
            sb.append(g2.a().size());
            d.c(sb.toString());
        }
        final int min = Math.min(g.a().size(), g2.a().size());
        if (this.a.size() < min) {
            for (int i = this.a.size(); i < min; ++i) {
                this.a.add(new a());
            }
        }
        else if (this.a.size() > min) {
            for (int j = this.a.size() - 1; j >= min; --j) {
                final List<a> a = this.a;
                a.remove(a.size() - 1);
            }
        }
        final PointF b = g.b();
        final PointF b2 = g2.b();
        this.e(g.k(b.x, b2.x, n), g.k(b.y, b2.y, n));
        for (int k = this.a.size() - 1; k >= 0; --k) {
            final a a2 = g.a().get(k);
            final a a3 = g2.a().get(k);
            final PointF a4 = a2.a();
            final PointF b3 = a2.b();
            final PointF c = a2.c();
            final PointF a5 = a3.a();
            final PointF b4 = a3.b();
            final PointF c2 = a3.c();
            this.a.get(k).d(g.k(a4.x, a5.x, n), g.k(a4.y, a5.y, n));
            this.a.get(k).e(g.k(b3.x, b4.x, n), g.k(b3.y, b4.y, n));
            this.a.get(k).f(g.k(c.x, c2.x, n), g.k(c.y, c2.y, n));
        }
    }
    
    public boolean d() {
        return this.c;
    }
    
    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append("ShapeData{numCurves=");
        sb.append(this.a.size());
        sb.append("closed=");
        sb.append(this.c);
        sb.append('}');
        return sb.toString();
    }
}
