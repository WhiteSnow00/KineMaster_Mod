// 
// Decompiled by Procyon v0.6.0
// 

package q1;

import y1.g;
import r1.p;
import com.airbnb.lottie.model.content.ShapeTrimPath;
import android.graphics.Canvas;
import android.graphics.PathEffect;
import android.graphics.DashPathEffect;
import y1.h;
import com.airbnb.lottie.c;
import android.graphics.Matrix;
import android.graphics.Paint$Style;
import java.util.ArrayList;
import u1.b;
import u1.d;
import android.graphics.Paint$Join;
import android.graphics.Paint$Cap;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import java.util.List;
import com.airbnb.lottie.f;
import android.graphics.RectF;
import android.graphics.Path;
import android.graphics.PathMeasure;

public abstract class a implements r1.a.b, k, e
{
    private final PathMeasure a;
    private final Path b;
    private final Path c;
    private final RectF d;
    private final com.airbnb.lottie.f e;
    protected final com.airbnb.lottie.model.layer.a f;
    private final List<b> g;
    private final float[] h;
    final Paint i;
    private final r1.a<?, Float> j;
    private final r1.a<?, Integer> k;
    private final List<r1.a<?, Float>> l;
    private final r1.a<?, Float> m;
    private r1.a<ColorFilter, ColorFilter> n;
    
    a(final com.airbnb.lottie.f e, final com.airbnb.lottie.model.layer.a f, final Paint$Cap strokeCap, final Paint$Join strokeJoin, final float strokeMiter, final u1.d d, final u1.b b, final List<u1.b> list, final u1.b b2) {
        this.a = new PathMeasure();
        this.b = new Path();
        this.c = new Path();
        this.d = new RectF();
        this.g = new ArrayList<b>();
        final p1.a i = new p1.a(1);
        this.i = i;
        this.e = e;
        this.f = f;
        i.setStyle(Paint$Style.STROKE);
        i.setStrokeCap(strokeCap);
        i.setStrokeJoin(strokeJoin);
        i.setStrokeMiter(strokeMiter);
        this.k = d.a();
        this.j = b.a();
        if (b2 == null) {
            this.m = null;
        }
        else {
            this.m = b2.a();
        }
        this.l = new ArrayList<r1.a<?, Float>>(list.size());
        this.h = new float[list.size()];
        final int n = 0;
        for (int j = 0; j < list.size(); ++j) {
            this.l.add(((u1.b)list.get(j)).a());
        }
        f.i(this.k);
        f.i(this.j);
        for (int k = 0; k < this.l.size(); ++k) {
            f.i(this.l.get(k));
        }
        final r1.a<?, Float> m = this.m;
        if (m != null) {
            f.i(m);
        }
        this.k.a((r1.a.b)this);
        this.j.a((r1.a.b)this);
        for (int l = n; l < list.size(); ++l) {
            this.l.get(l).a((r1.a.b)this);
        }
        final r1.a<?, Float> m2 = this.m;
        if (m2 != null) {
            m2.a((r1.a.b)this);
        }
    }
    
    private void f(final Matrix matrix) {
        com.airbnb.lottie.c.a("StrokeContent#applyDashPattern");
        if (this.l.isEmpty()) {
            com.airbnb.lottie.c.b("StrokeContent#applyDashPattern");
            return;
        }
        final float g = y1.h.g(matrix);
        for (int i = 0; i < this.l.size(); ++i) {
            this.h[i] = (float)this.l.get(i).h();
            if (i % 2 == 0) {
                final float[] h = this.h;
                if (h[i] < 1.0f) {
                    h[i] = 1.0f;
                }
            }
            else {
                final float[] h2 = this.h;
                if (h2[i] < 0.1f) {
                    h2[i] = 0.1f;
                }
            }
            final float[] h3 = this.h;
            h3[i] *= g;
        }
        final r1.a<?, Float> m = this.m;
        float n;
        if (m == null) {
            n = 0.0f;
        }
        else {
            n = g * m.h();
        }
        this.i.setPathEffect((PathEffect)new DashPathEffect(this.h, n));
        com.airbnb.lottie.c.b("StrokeContent#applyDashPattern");
    }
    
    private void h(final Canvas canvas, final b b, final Matrix matrix) {
        com.airbnb.lottie.c.a("StrokeContent#applyTrimPath");
        if (q1.a.b.b(b) == null) {
            com.airbnb.lottie.c.b("StrokeContent#applyTrimPath");
            return;
        }
        this.b.reset();
        for (int i = q1.a.b.a(b).size() - 1; i >= 0; --i) {
            this.b.addPath(((m)q1.a.b.a(b).get(i)).getPath(), matrix);
        }
        this.a.setPath(this.b, false);
        float length = this.a.getLength();
        while (this.a.nextContour()) {
            length += this.a.getLength();
        }
        final float n = q1.a.b.b(b).f().h() * length / 360.0f;
        final float n2 = q1.a.b.b(b).h().h() * length / 100.0f + n;
        final float n3 = q1.a.b.b(b).d().h() * length / 100.0f + n;
        int j = q1.a.b.a(b).size() - 1;
        float n4 = 0.0f;
        while (j >= 0) {
            this.c.set(((m)q1.a.b.a(b).get(j)).getPath());
            this.c.transform(matrix);
            this.a.setPath(this.c, false);
            final float length2 = this.a.getLength();
            float n5 = 1.0f;
            Label_0502: {
                if (n3 > length) {
                    final float n6 = n3 - length;
                    if (n6 < n4 + length2 && n4 < n6) {
                        float n7;
                        if (n2 > length) {
                            n7 = (n2 - length) / length2;
                        }
                        else {
                            n7 = 0.0f;
                        }
                        y1.h.a(this.c, n7, Math.min(n6 / length2, 1.0f), 0.0f);
                        canvas.drawPath(this.c, this.i);
                        break Label_0502;
                    }
                }
                final float n8 = n4 + length2;
                if (n8 >= n2) {
                    if (n4 <= n3) {
                        if (n8 <= n3 && n2 < n4) {
                            canvas.drawPath(this.c, this.i);
                        }
                        else {
                            float n9;
                            if (n2 < n4) {
                                n9 = 0.0f;
                            }
                            else {
                                n9 = (n2 - n4) / length2;
                            }
                            if (n3 <= n8) {
                                n5 = (n3 - n4) / length2;
                            }
                            y1.h.a(this.c, n9, n5, 0.0f);
                            canvas.drawPath(this.c, this.i);
                        }
                    }
                }
            }
            n4 += length2;
            --j;
        }
        com.airbnb.lottie.c.b("StrokeContent#applyTrimPath");
    }
    
    @Override
    public void a() {
        this.e.invalidateSelf();
    }
    
    @Override
    public void b(final List<c> list, final List<c> list2) {
        int i = list.size() - 1;
        s s = null;
        while (i >= 0) {
            final c c = list.get(i);
            s s2 = s;
            if (c instanceof s) {
                final s s3 = (s)c;
                s2 = s;
                if (s3.i() == ShapeTrimPath.Type.INDIVIDUALLY) {
                    s2 = s3;
                }
            }
            --i;
            s = s2;
        }
        if (s != null) {
            s.c(this);
        }
        int j = list2.size() - 1;
        b b = null;
        while (j >= 0) {
            final c c2 = list2.get(j);
            b b2 = null;
            Label_0222: {
                if (c2 instanceof s) {
                    final s s4 = (s)c2;
                    if (s4.i() == ShapeTrimPath.Type.INDIVIDUALLY) {
                        if (b != null) {
                            this.g.add(b);
                        }
                        b2 = new b(s4, null);
                        s4.c(this);
                        break Label_0222;
                    }
                }
                b2 = b;
                if (c2 instanceof m) {
                    if ((b2 = b) == null) {
                        b2 = new b(s, null);
                    }
                    q1.a.b.a(b2).add(c2);
                }
            }
            --j;
            b = b2;
        }
        if (b != null) {
            this.g.add(b);
        }
    }
    
    @Override
    public <T> void c(final T t, final z1.c<T> c) {
        if (t == com.airbnb.lottie.k.d) {
            this.k.n((z1.c<Integer>)c);
        }
        else if (t == com.airbnb.lottie.k.q) {
            this.j.n((z1.c<Float>)c);
        }
        else if (t == com.airbnb.lottie.k.E) {
            final r1.a<ColorFilter, ColorFilter> n = this.n;
            if (n != null) {
                this.f.C(n);
            }
            if (c == null) {
                this.n = null;
            }
            else {
                (this.n = new p<ColorFilter, ColorFilter>((z1.c<ColorFilter>)c)).a((r1.a.b)this);
                this.f.i(this.n);
            }
        }
    }
    
    @Override
    public void d(final t1.d d, final int n, final List<t1.d> list, final t1.d d2) {
        y1.g.m(d, n, list, d2, this);
    }
    
    @Override
    public void e(final RectF rectF, final Matrix matrix, final boolean b) {
        com.airbnb.lottie.c.a("StrokeContent#getBounds");
        this.b.reset();
        for (int i = 0; i < this.g.size(); ++i) {
            final b b2 = this.g.get(i);
            for (int j = 0; j < q1.a.b.a(b2).size(); ++j) {
                this.b.addPath(((m)q1.a.b.a(b2).get(j)).getPath(), matrix);
            }
        }
        this.b.computeBounds(this.d, false);
        final float p3 = ((r1.c)this.j).p();
        final RectF d = this.d;
        final float left = d.left;
        final float n = p3 / 2.0f;
        d.set(left - n, d.top - n, d.right + n, d.bottom + n);
        rectF.set(this.d);
        rectF.set(rectF.left - 1.0f, rectF.top - 1.0f, rectF.right + 1.0f, rectF.bottom + 1.0f);
        com.airbnb.lottie.c.b("StrokeContent#getBounds");
    }
    
    @Override
    public void g(final Canvas canvas, final Matrix matrix, int i) {
        com.airbnb.lottie.c.a("StrokeContent#draw");
        if (y1.h.h(matrix)) {
            com.airbnb.lottie.c.b("StrokeContent#draw");
            return;
        }
        i = (int)(i / 255.0f * ((r1.e)this.k).p() / 100.0f * 255.0f);
        final Paint j = this.i;
        final int n = 0;
        j.setAlpha(y1.g.d(i, 0, 255));
        this.i.setStrokeWidth(((r1.c)this.j).p() * y1.h.g(matrix));
        if (this.i.getStrokeWidth() <= 0.0f) {
            com.airbnb.lottie.c.b("StrokeContent#draw");
            return;
        }
        this.f(matrix);
        final r1.a<ColorFilter, ColorFilter> n2 = this.n;
        i = n;
        if (n2 != null) {
            this.i.setColorFilter((ColorFilter)n2.h());
            i = n;
        }
        while (i < this.g.size()) {
            final b b = this.g.get(i);
            if (q1.a.b.b(b) != null) {
                this.h(canvas, b, matrix);
            }
            else {
                com.airbnb.lottie.c.a("StrokeContent#buildPath");
                this.b.reset();
                for (int k = q1.a.b.a(b).size() - 1; k >= 0; --k) {
                    this.b.addPath(((m)q1.a.b.a(b).get(k)).getPath(), matrix);
                }
                com.airbnb.lottie.c.b("StrokeContent#buildPath");
                com.airbnb.lottie.c.a("StrokeContent#drawPath");
                canvas.drawPath(this.b, this.i);
                com.airbnb.lottie.c.b("StrokeContent#drawPath");
            }
            ++i;
        }
        com.airbnb.lottie.c.b("StrokeContent#draw");
    }
    
    private static final class b
    {
        private final List<m> a;
        private final s b;
        
        private b(final s b) {
            this.a = new ArrayList<m>();
            this.b = b;
        }
        
        b(final s s, final a$a object) {
            this(s);
        }
        
        static List a(final b b) {
            return b.a;
        }
        
        static s b(final b b) {
            return b.b;
        }
    }
}
