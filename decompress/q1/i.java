// 
// Decompiled by Procyon v0.6.0
// 

package q1;

import android.graphics.Shader;
import android.graphics.Matrix;
import android.graphics.Canvas;
import com.airbnb.lottie.k;
import android.graphics.Shader$TileMode;
import com.airbnb.lottie.f;
import r1.p;
import android.graphics.PointF;
import v1.c;
import com.airbnb.lottie.model.content.GradientType;
import android.graphics.RectF;
import android.graphics.RadialGradient;
import android.graphics.LinearGradient;
import androidx.collection.d;

public class i extends a
{
    private final String o;
    private final boolean p;
    private final androidx.collection.d<LinearGradient> q;
    private final androidx.collection.d<RadialGradient> r;
    private final RectF s;
    private final GradientType t;
    private final int u;
    private final r1.a<c, c> v;
    private final r1.a<PointF, PointF> w;
    private final r1.a<PointF, PointF> x;
    private p y;
    
    public i(final com.airbnb.lottie.f f, final com.airbnb.lottie.model.layer.a a, final com.airbnb.lottie.model.content.a a2) {
        super(f, a, a2.b().toPaintCap(), a2.g().toPaintJoin(), a2.i(), a2.k(), a2.m(), a2.h(), a2.c());
        this.q = new androidx.collection.d<LinearGradient>();
        this.r = new androidx.collection.d<RadialGradient>();
        this.s = new RectF();
        this.o = a2.j();
        this.t = a2.f();
        this.p = a2.n();
        this.u = (int)(f.p().d() / 32.0f);
        final r1.a<c, c> a3 = a2.e().a();
        (this.v = a3).a((r1.a.b)this);
        a.i(a3);
        final r1.a<PointF, PointF> a4 = a2.l().a();
        (this.w = a4).a((r1.a.b)this);
        a.i(a4);
        final r1.a<PointF, PointF> a5 = a2.d().a();
        (this.x = a5).a((r1.a.b)this);
        a.i(a5);
    }
    
    private int[] i(int[] array) {
        final p y = this.y;
        int[] array2 = array;
        if (y != null) {
            final Integer[] array3 = y.h();
            final int length = array.length;
            final int length2 = array3.length;
            final int n = 0;
            int n2 = 0;
            if (length == length2) {
                while (true) {
                    array2 = array;
                    if (n2 >= array.length) {
                        break;
                    }
                    array[n2] = array3[n2];
                    ++n2;
                }
            }
            else {
                array = new int[array3.length];
                int n3 = n;
                while (true) {
                    array2 = array;
                    if (n3 >= array3.length) {
                        break;
                    }
                    array[n3] = array3[n3];
                    ++n3;
                }
            }
        }
        return array2;
    }
    
    private int j() {
        final int round = Math.round(this.w.f() * this.u);
        final int round2 = Math.round(this.x.f() * this.u);
        final int round3 = Math.round(this.v.f() * this.u);
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
    
    private LinearGradient k() {
        final int j = this.j();
        final androidx.collection.d<LinearGradient> q = this.q;
        final long n = j;
        final LinearGradient linearGradient = q.f(n);
        if (linearGradient != null) {
            return linearGradient;
        }
        final PointF pointF = this.w.h();
        final PointF pointF2 = this.x.h();
        final c c = this.v.h();
        final LinearGradient linearGradient2 = new LinearGradient(pointF.x, pointF.y, pointF2.x, pointF2.y, this.i(c.a()), c.b(), Shader$TileMode.CLAMP);
        this.q.l(n, linearGradient2);
        return linearGradient2;
    }
    
    private RadialGradient l() {
        final int j = this.j();
        final androidx.collection.d<RadialGradient> r = this.r;
        final long n = j;
        final RadialGradient radialGradient = r.f(n);
        if (radialGradient != null) {
            return radialGradient;
        }
        final PointF pointF = this.w.h();
        final PointF pointF2 = this.x.h();
        final c c = this.v.h();
        final int[] i = this.i(c.a());
        final float[] b = c.b();
        final float x = pointF.x;
        final float y = pointF.y;
        final RadialGradient radialGradient2 = new RadialGradient(x, y, (float)Math.hypot(pointF2.x - x, pointF2.y - y), i, b, Shader$TileMode.CLAMP);
        this.r.l(n, radialGradient2);
        return radialGradient2;
    }
    
    @Override
    public <T> void c(final T t, final z1.c<T> c) {
        super.c(t, c);
        if (t == com.airbnb.lottie.k.F) {
            final p y = this.y;
            if (y != null) {
                super.f.C(y);
            }
            if (c == null) {
                this.y = null;
            }
            else {
                (this.y = new p((z1.c<A>)c)).a((r1.a.b)this);
                super.f.i(this.y);
            }
        }
    }
    
    @Override
    public void g(final Canvas canvas, final Matrix localMatrix, final int n) {
        if (this.p) {
            return;
        }
        this.e(this.s, localMatrix, false);
        Object shader;
        if (this.t == GradientType.LINEAR) {
            shader = this.k();
        }
        else {
            shader = this.l();
        }
        ((Shader)shader).setLocalMatrix(localMatrix);
        super.i.setShader((Shader)shader);
        super.g(canvas, localMatrix, n);
    }
    
    @Override
    public String getName() {
        return this.o;
    }
}
