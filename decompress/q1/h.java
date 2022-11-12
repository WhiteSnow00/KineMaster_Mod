// 
// Decompiled by Procyon v0.6.0
// 

package q1;

import android.graphics.Shader;
import android.graphics.Canvas;
import android.graphics.Matrix;
import y1.g;
import android.graphics.Shader$TileMode;
import java.util.ArrayList;
import com.airbnb.lottie.f;
import r1.p;
import android.graphics.ColorFilter;
import android.graphics.PointF;
import v1.c;
import com.airbnb.lottie.model.content.GradientType;
import java.util.List;
import android.graphics.RectF;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RadialGradient;
import android.graphics.LinearGradient;
import androidx.collection.d;
import r1.a;

public class h implements e, b, k
{
    private final String a;
    private final boolean b;
    private final com.airbnb.lottie.model.layer.a c;
    private final androidx.collection.d<LinearGradient> d;
    private final androidx.collection.d<RadialGradient> e;
    private final Path f;
    private final Paint g;
    private final RectF h;
    private final List<m> i;
    private final GradientType j;
    private final a<c, c> k;
    private final a<Integer, Integer> l;
    private final a<PointF, PointF> m;
    private final a<PointF, PointF> n;
    private a<ColorFilter, ColorFilter> o;
    private p p;
    private final com.airbnb.lottie.f q;
    private final int r;
    
    public h(final com.airbnb.lottie.f q, final com.airbnb.lottie.model.layer.a c, final v1.d d) {
        this.d = new androidx.collection.d<LinearGradient>();
        this.e = new androidx.collection.d<RadialGradient>();
        final Path f = new Path();
        this.f = f;
        this.g = new p1.a(1);
        this.h = new RectF();
        this.i = new ArrayList<m>();
        this.c = c;
        this.a = d.f();
        this.b = d.i();
        this.q = q;
        this.j = d.e();
        f.setFillType(d.c());
        this.r = (int)(q.p().d() / 32.0f);
        final a<c, c> a = d.d().a();
        (this.k = a).a((a.b)this);
        c.i(a);
        final a<Integer, Integer> a2 = d.g().a();
        (this.l = a2).a((a.b)this);
        c.i(a2);
        final a<PointF, PointF> a3 = d.h().a();
        (this.m = a3).a((a.b)this);
        c.i(a3);
        final a<PointF, PointF> a4 = d.b().a();
        (this.n = a4).a((a.b)this);
        c.i(a4);
    }
    
    private int[] f(int[] array) {
        final p p = this.p;
        int[] array2 = array;
        if (p != null) {
            final Integer[] array3 = p.h();
            final int length = array.length;
            final int length2 = array3.length;
            int n = 0;
            final int n2 = 0;
            if (length == length2) {
                int n3 = n2;
                while (true) {
                    array2 = array;
                    if (n3 >= array.length) {
                        break;
                    }
                    array[n3] = array3[n3];
                    ++n3;
                }
            }
            else {
                array = new int[array3.length];
                while (true) {
                    array2 = array;
                    if (n >= array3.length) {
                        break;
                    }
                    array[n] = array3[n];
                    ++n;
                }
            }
        }
        return array2;
    }
    
    private int h() {
        final int round = Math.round(this.m.f() * this.r);
        final int round2 = Math.round(this.n.f() * this.r);
        final int round3 = Math.round(this.k.f() * this.r);
        int n;
        if (round != 0) {
            n = 527 * round;
        }
        else {
            n = 17;
        }
        int n2 = n;
        if (round2 != 0) {
            n2 = n * 31 * round2;
        }
        int n3 = n2;
        if (round3 != 0) {
            n3 = n2 * 31 * round3;
        }
        return n3;
    }
    
    private LinearGradient i() {
        final int h = this.h();
        final androidx.collection.d<LinearGradient> d = this.d;
        final long n = h;
        final LinearGradient linearGradient = d.f(n);
        if (linearGradient != null) {
            return linearGradient;
        }
        final PointF pointF = this.m.h();
        final PointF pointF2 = this.n.h();
        final c c = this.k.h();
        final LinearGradient linearGradient2 = new LinearGradient(pointF.x, pointF.y, pointF2.x, pointF2.y, this.f(c.a()), c.b(), Shader$TileMode.CLAMP);
        this.d.l(n, linearGradient2);
        return linearGradient2;
    }
    
    private RadialGradient j() {
        final int h = this.h();
        final androidx.collection.d<RadialGradient> e = this.e;
        final long n = h;
        final RadialGradient radialGradient = e.f(n);
        if (radialGradient != null) {
            return radialGradient;
        }
        final PointF pointF = this.m.h();
        final PointF pointF2 = this.n.h();
        final c c = this.k.h();
        final int[] f = this.f(c.a());
        final float[] b = c.b();
        final float x = pointF.x;
        final float y = pointF.y;
        float n2;
        if ((n2 = (float)Math.hypot(pointF2.x - x, pointF2.y - y)) <= 0.0f) {
            n2 = 0.001f;
        }
        final RadialGradient radialGradient2 = new RadialGradient(x, y, n2, f, b, Shader$TileMode.CLAMP);
        this.e.l(n, radialGradient2);
        return radialGradient2;
    }
    
    @Override
    public void a() {
        this.q.invalidateSelf();
    }
    
    @Override
    public void b(final List<c> list, final List<c> list2) {
        for (int i = 0; i < list2.size(); ++i) {
            final c c = list2.get(i);
            if (c instanceof m) {
                this.i.add((m)c);
            }
        }
    }
    
    @Override
    public <T> void c(final T t, final z1.c<T> c) {
        if (t == com.airbnb.lottie.k.d) {
            this.l.n((z1.c<Integer>)c);
        }
        else if (t == com.airbnb.lottie.k.E) {
            final a<ColorFilter, ColorFilter> o = this.o;
            if (o != null) {
                this.c.C(o);
            }
            if (c == null) {
                this.o = null;
            }
            else {
                (this.o = new p<ColorFilter, ColorFilter>((z1.c<ColorFilter>)c)).a((a.b)this);
                this.c.i(this.o);
            }
        }
        else if (t == com.airbnb.lottie.k.F) {
            final p p2 = this.p;
            if (p2 != null) {
                this.c.C(p2);
            }
            if (c == null) {
                this.p = null;
            }
            else {
                this.d.b();
                this.e.b();
                (this.p = new p((z1.c<A>)c)).a((a.b)this);
                this.c.i(this.p);
            }
        }
    }
    
    @Override
    public void d(final t1.d d, final int n, final List<t1.d> list, final t1.d d2) {
        y1.g.m(d, n, list, d2, this);
    }
    
    @Override
    public void e(final RectF rectF, final Matrix matrix, final boolean b) {
        this.f.reset();
        for (int i = 0; i < this.i.size(); ++i) {
            this.f.addPath(this.i.get(i).getPath(), matrix);
        }
        this.f.computeBounds(rectF, false);
        rectF.set(rectF.left - 1.0f, rectF.top - 1.0f, rectF.right + 1.0f, rectF.bottom + 1.0f);
    }
    
    @Override
    public void g(final Canvas canvas, final Matrix localMatrix, int n) {
        if (this.b) {
            return;
        }
        com.airbnb.lottie.c.a("GradientFillContent#draw");
        this.f.reset();
        for (int i = 0; i < this.i.size(); ++i) {
            this.f.addPath(this.i.get(i).getPath(), localMatrix);
        }
        this.f.computeBounds(this.h, false);
        Object shader;
        if (this.j == GradientType.LINEAR) {
            shader = this.i();
        }
        else {
            shader = this.j();
        }
        ((Shader)shader).setLocalMatrix(localMatrix);
        this.g.setShader((Shader)shader);
        final a<ColorFilter, ColorFilter> o = this.o;
        if (o != null) {
            this.g.setColorFilter((ColorFilter)o.h());
        }
        n = (int)(n / 255.0f * this.l.h() / 100.0f * 255.0f);
        this.g.setAlpha(y1.g.d(n, 0, 255));
        canvas.drawPath(this.f, this.g);
        com.airbnb.lottie.c.b("GradientFillContent#draw");
    }
    
    @Override
    public String getName() {
        return this.a;
    }
}
