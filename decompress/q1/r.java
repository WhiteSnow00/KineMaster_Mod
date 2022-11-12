// 
// Decompiled by Procyon v0.6.0
// 

package q1;

import r1.b;
import android.graphics.Matrix;
import android.graphics.Canvas;
import r1.p;
import com.airbnb.lottie.k;
import z1.c;
import com.airbnb.lottie.model.content.ShapeStroke;
import com.airbnb.lottie.f;
import android.graphics.ColorFilter;

public class r extends a
{
    private final com.airbnb.lottie.model.layer.a o;
    private final String p;
    private final boolean q;
    private final r1.a<Integer, Integer> r;
    private r1.a<ColorFilter, ColorFilter> s;
    
    public r(final com.airbnb.lottie.f f, final com.airbnb.lottie.model.layer.a o, final ShapeStroke shapeStroke) {
        super(f, o, shapeStroke.b().toPaintCap(), shapeStroke.e().toPaintJoin(), shapeStroke.g(), shapeStroke.i(), shapeStroke.j(), shapeStroke.f(), shapeStroke.d());
        this.o = o;
        this.p = shapeStroke.h();
        this.q = shapeStroke.k();
        final r1.a<Integer, Integer> a = shapeStroke.c().a();
        (this.r = a).a((r1.a.b)this);
        o.i(a);
    }
    
    @Override
    public <T> void c(final T t, final c<T> c) {
        super.c(t, c);
        if (t == com.airbnb.lottie.k.b) {
            this.r.n((c<Integer>)c);
        }
        else if (t == com.airbnb.lottie.k.E) {
            final r1.a<ColorFilter, ColorFilter> s = this.s;
            if (s != null) {
                this.o.C(s);
            }
            if (c == null) {
                this.s = null;
            }
            else {
                (this.s = new p<ColorFilter, ColorFilter>((c<ColorFilter>)c)).a((r1.a.b)this);
                this.o.i(this.r);
            }
        }
    }
    
    @Override
    public void g(final Canvas canvas, final Matrix matrix, final int n) {
        if (this.q) {
            return;
        }
        super.i.setColor(((r1.b)this.r).p());
        final r1.a<ColorFilter, ColorFilter> s = this.s;
        if (s != null) {
            super.i.setColorFilter((ColorFilter)s.h());
        }
        super.g(canvas, matrix, n);
    }
    
    @Override
    public String getName() {
        return this.p;
    }
}
