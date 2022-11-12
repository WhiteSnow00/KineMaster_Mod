// 
// Decompiled by Procyon v0.6.0
// 

package q1;

import r1.b;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.RectF;
import t1.d;
import r1.p;
import java.util.ArrayList;
import v1.h;
import com.airbnb.lottie.f;
import android.graphics.ColorFilter;
import java.util.List;
import android.graphics.Paint;
import android.graphics.Path;
import r1.a;

public class g implements e, b, k
{
    private final Path a;
    private final Paint b;
    private final com.airbnb.lottie.model.layer.a c;
    private final String d;
    private final boolean e;
    private final List<m> f;
    private final a<Integer, Integer> g;
    private final a<Integer, Integer> h;
    private a<ColorFilter, ColorFilter> i;
    private final com.airbnb.lottie.f j;
    
    public g(final com.airbnb.lottie.f j, final com.airbnb.lottie.model.layer.a c, final h h) {
        final Path a = new Path();
        this.a = a;
        this.b = new p1.a(1);
        this.f = new ArrayList<m>();
        this.c = c;
        this.d = h.d();
        this.e = h.f();
        this.j = j;
        if (h.b() != null && h.e() != null) {
            a.setFillType(h.c());
            final a<Integer, Integer> a2 = h.b().a();
            (this.g = a2).a((a.b)this);
            c.i(a2);
            final a<Integer, Integer> a3 = h.e().a();
            (this.h = a3).a((a.b)this);
            c.i(a3);
            return;
        }
        this.g = null;
        this.h = null;
    }
    
    @Override
    public void a() {
        this.j.invalidateSelf();
    }
    
    @Override
    public void b(final List<c> list, final List<c> list2) {
        for (int i = 0; i < list2.size(); ++i) {
            final c c = list2.get(i);
            if (c instanceof m) {
                this.f.add((m)c);
            }
        }
    }
    
    @Override
    public <T> void c(final T t, final z1.c<T> c) {
        if (t == com.airbnb.lottie.k.a) {
            this.g.n((z1.c<Integer>)c);
        }
        else if (t == com.airbnb.lottie.k.d) {
            this.h.n((z1.c<Integer>)c);
        }
        else if (t == com.airbnb.lottie.k.E) {
            final a<ColorFilter, ColorFilter> i = this.i;
            if (i != null) {
                this.c.C(i);
            }
            if (c == null) {
                this.i = null;
            }
            else {
                (this.i = new p<ColorFilter, ColorFilter>((z1.c<ColorFilter>)c)).a((a.b)this);
                this.c.i(this.i);
            }
        }
    }
    
    @Override
    public void d(final t1.d d, final int n, final List<t1.d> list, final t1.d d2) {
        y1.g.m(d, n, list, d2, this);
    }
    
    @Override
    public void e(final RectF rectF, final Matrix matrix, final boolean b) {
        this.a.reset();
        for (int i = 0; i < this.f.size(); ++i) {
            this.a.addPath(this.f.get(i).getPath(), matrix);
        }
        this.a.computeBounds(rectF, false);
        rectF.set(rectF.left - 1.0f, rectF.top - 1.0f, rectF.right + 1.0f, rectF.bottom + 1.0f);
    }
    
    @Override
    public void g(final Canvas canvas, final Matrix matrix, int i) {
        if (this.e) {
            return;
        }
        com.airbnb.lottie.c.a("FillContent#draw");
        this.b.setColor(((r1.b)this.g).p());
        final int n = (int)(i / 255.0f * this.h.h() / 100.0f * 255.0f);
        final Paint b = this.b;
        i = 0;
        b.setAlpha(y1.g.d(n, 0, 255));
        final a<ColorFilter, ColorFilter> j = this.i;
        if (j != null) {
            this.b.setColorFilter((ColorFilter)j.h());
        }
        this.a.reset();
        while (i < this.f.size()) {
            this.a.addPath(this.f.get(i).getPath(), matrix);
            ++i;
        }
        canvas.drawPath(this.a, this.b);
        com.airbnb.lottie.c.b("FillContent#draw");
    }
    
    @Override
    public String getName() {
        return this.d;
    }
}
