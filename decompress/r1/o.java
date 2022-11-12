// 
// Decompiled by Procyon v0.6.0
// 

package r1;

import java.util.Collections;
import com.airbnb.lottie.k;
import u1.l;
import z1.d;
import android.graphics.PointF;
import android.graphics.Matrix;

public class o
{
    private final Matrix a;
    private final Matrix b;
    private final Matrix c;
    private final Matrix d;
    private final float[] e;
    private a<PointF, PointF> f;
    private a<?, PointF> g;
    private a<d, d> h;
    private a<Float, Float> i;
    private a<Integer, Integer> j;
    private c k;
    private c l;
    private a<?, Float> m;
    private a<?, Float> n;
    
    public o(final l l) {
        this.a = new Matrix();
        a<PointF, PointF> a;
        if (l.c() == null) {
            a = null;
        }
        else {
            a = l.c().a();
        }
        this.f = a;
        a<?, PointF> a2;
        if (l.f() == null) {
            a2 = null;
        }
        else {
            a2 = l.f().a();
        }
        this.g = a2;
        a<d, d> a3;
        if (l.h() == null) {
            a3 = null;
        }
        else {
            a3 = l.h().a();
        }
        this.h = a3;
        a<Float, Float> a4;
        if (l.g() == null) {
            a4 = null;
        }
        else {
            a4 = l.g().a();
        }
        this.i = a4;
        c k;
        if (l.i() == null) {
            k = null;
        }
        else {
            k = (c)l.i().a();
        }
        this.k = k;
        if (k != null) {
            this.b = new Matrix();
            this.c = new Matrix();
            this.d = new Matrix();
            this.e = new float[9];
        }
        else {
            this.b = null;
            this.c = null;
            this.d = null;
            this.e = null;
        }
        c i;
        if (l.j() == null) {
            i = null;
        }
        else {
            i = (c)l.j().a();
        }
        this.l = i;
        if (l.e() != null) {
            this.j = l.e().a();
        }
        if (l.k() != null) {
            this.m = l.k().a();
        }
        else {
            this.m = null;
        }
        if (l.d() != null) {
            this.n = l.d().a();
        }
        else {
            this.n = null;
        }
    }
    
    private void d() {
        for (int i = 0; i < 9; ++i) {
            this.e[i] = 0.0f;
        }
    }
    
    public void a(final com.airbnb.lottie.model.layer.a a) {
        a.i(this.j);
        a.i(this.m);
        a.i(this.n);
        a.i(this.f);
        a.i(this.g);
        a.i(this.h);
        a.i(this.i);
        a.i(this.k);
        a.i(this.l);
    }
    
    public void b(final a.b b) {
        final a<Integer, Integer> j = this.j;
        if (j != null) {
            j.a(b);
        }
        final a<?, Float> m = this.m;
        if (m != null) {
            m.a(b);
        }
        final a<?, Float> n = this.n;
        if (n != null) {
            n.a(b);
        }
        final a<PointF, PointF> f = this.f;
        if (f != null) {
            f.a(b);
        }
        final a<?, PointF> g = this.g;
        if (g != null) {
            g.a(b);
        }
        final a<d, d> h = this.h;
        if (h != null) {
            h.a(b);
        }
        final a<Float, Float> i = this.i;
        if (i != null) {
            i.a(b);
        }
        final c k = this.k;
        if (k != null) {
            k.a(b);
        }
        final c l = this.l;
        if (l != null) {
            l.a(b);
        }
    }
    
    public <T> boolean c(final T t, final z1.c<T> c) {
        if (t == com.airbnb.lottie.k.e) {
            final a<PointF, PointF> f = this.f;
            if (f == null) {
                this.f = new p<PointF, PointF>((z1.c<PointF>)c, new PointF());
            }
            else {
                f.n((z1.c<PointF>)c);
            }
        }
        else if (t == com.airbnb.lottie.k.f) {
            final a<?, PointF> g = this.g;
            if (g == null) {
                this.g = new p<Object, PointF>((z1.c<Object>)c, new PointF());
            }
            else {
                g.n((z1.c<PointF>)c);
            }
        }
        else {
            if (t == com.airbnb.lottie.k.g) {
                final a<?, PointF> g2 = this.g;
                if (g2 instanceof m) {
                    ((m)g2).r((z1.c<Float>)c);
                    return true;
                }
            }
            if (t == com.airbnb.lottie.k.h) {
                final a<?, PointF> g3 = this.g;
                if (g3 instanceof m) {
                    ((m)g3).s((z1.c<Float>)c);
                    return true;
                }
            }
            if (t == com.airbnb.lottie.k.m) {
                final a<d, d> h = this.h;
                if (h == null) {
                    this.h = new p<d, d>((z1.c<d>)c, new d());
                }
                else {
                    h.n((z1.c<d>)c);
                }
            }
            else if (t == com.airbnb.lottie.k.n) {
                final a<Float, Float> i = this.i;
                if (i == null) {
                    this.i = new p<Float, Float>((z1.c<Float>)c, 0.0f);
                }
                else {
                    i.n((z1.c<Float>)c);
                }
            }
            else {
                if (t != com.airbnb.lottie.k.c) {
                    if (t == com.airbnb.lottie.k.A) {
                        final a<?, Float> m = this.m;
                        if (m != null) {
                            if (m == null) {
                                this.m = new p<Object, Float>((z1.c<Float>)c, Float.valueOf(100));
                                return true;
                            }
                            m.n((z1.c<Float>)c);
                            return true;
                        }
                    }
                    if (t == com.airbnb.lottie.k.B) {
                        final a<?, Float> n = this.n;
                        if (n != null) {
                            if (n == null) {
                                this.n = new p<Object, Float>((z1.c<Float>)c, Float.valueOf(100));
                                return true;
                            }
                            n.n((z1.c<Float>)c);
                            return true;
                        }
                    }
                    if (t == com.airbnb.lottie.k.o) {
                        final c k = this.k;
                        if (k != null) {
                            if (k == null) {
                                this.k = new c(Collections.singletonList(new z1.a<Float>(0.0f)));
                            }
                            ((a<K, T>)this.k).n((z1.c<T>)c);
                            return true;
                        }
                    }
                    if (t == com.airbnb.lottie.k.p) {
                        final c l = this.l;
                        if (l != null) {
                            if (l == null) {
                                this.l = new c(Collections.singletonList(new z1.a<Float>(0.0f)));
                            }
                            ((a<K, T>)this.l).n((z1.c<T>)c);
                            return true;
                        }
                    }
                    return false;
                }
                final a<Integer, Integer> j = this.j;
                if (j == null) {
                    this.j = new p<Integer, Integer>((z1.c<Integer>)c, 100);
                }
                else {
                    j.n((z1.c<Integer>)c);
                }
            }
        }
        return true;
    }
    
    public a<?, Float> e() {
        return this.n;
    }
    
    public Matrix f() {
        this.a.reset();
        final a<?, PointF> g = this.g;
        if (g != null) {
            final PointF pointF = g.h();
            final float x = pointF.x;
            if (x != 0.0f || pointF.y != 0.0f) {
                this.a.preTranslate(x, pointF.y);
            }
        }
        final a<Float, Float> i = this.i;
        if (i != null) {
            float n;
            if (i instanceof p) {
                n = i.h();
            }
            else {
                n = ((c)i).p();
            }
            if (n != 0.0f) {
                this.a.preRotate(n);
            }
        }
        if (this.k != null) {
            final c l = this.l;
            float n2;
            if (l == null) {
                n2 = 0.0f;
            }
            else {
                n2 = (float)Math.cos(Math.toRadians(-l.p() + 90.0f));
            }
            final c j = this.l;
            float n3;
            if (j == null) {
                n3 = 1.0f;
            }
            else {
                n3 = (float)Math.sin(Math.toRadians(-j.p() + 90.0f));
            }
            final float n4 = (float)Math.tan(Math.toRadians(this.k.p()));
            this.d();
            final float[] e = this.e;
            e[0] = n2;
            e[1] = n3;
            final float n5 = -n3;
            e[3] = n5;
            e[4] = n2;
            e[8] = 1.0f;
            this.b.setValues(e);
            this.d();
            final float[] e2 = this.e;
            e2[0] = 1.0f;
            e2[3] = n4;
            e2[8] = (e2[4] = 1.0f);
            this.c.setValues(e2);
            this.d();
            final float[] e3 = this.e;
            e3[0] = n2;
            e3[1] = n5;
            e3[3] = n3;
            e3[4] = n2;
            e3[8] = 1.0f;
            this.d.setValues(e3);
            this.c.preConcat(this.b);
            this.d.preConcat(this.c);
            this.a.preConcat(this.d);
        }
        final a<d, d> h = this.h;
        if (h != null) {
            final d d = h.h();
            if (d.b() != 1.0f || d.c() != 1.0f) {
                this.a.preScale(d.b(), d.c());
            }
        }
        final a<PointF, PointF> f = this.f;
        if (f != null) {
            final PointF pointF2 = f.h();
            final float x2 = pointF2.x;
            if (x2 != 0.0f || pointF2.y != 0.0f) {
                this.a.preTranslate(-x2, -pointF2.y);
            }
        }
        return this.a;
    }
    
    public Matrix g(final float n) {
        final a<?, PointF> g = this.g;
        final PointF pointF = null;
        PointF pointF2;
        if (g == null) {
            pointF2 = null;
        }
        else {
            pointF2 = g.h();
        }
        final a<d, d> h = this.h;
        d d;
        if (h == null) {
            d = null;
        }
        else {
            d = h.h();
        }
        this.a.reset();
        if (pointF2 != null) {
            this.a.preTranslate(pointF2.x * n, pointF2.y * n);
        }
        if (d != null) {
            final Matrix a = this.a;
            final double n2 = d.b();
            final double n3 = n;
            a.preScale((float)Math.pow(n2, n3), (float)Math.pow(d.c(), n3));
        }
        final a<Float, Float> i = this.i;
        if (i != null) {
            final float floatValue = i.h();
            final a<PointF, PointF> f = this.f;
            PointF pointF3;
            if (f == null) {
                pointF3 = pointF;
            }
            else {
                pointF3 = f.h();
            }
            final Matrix a2 = this.a;
            float y = 0.0f;
            float x;
            if (pointF3 == null) {
                x = 0.0f;
            }
            else {
                x = pointF3.x;
            }
            if (pointF3 != null) {
                y = pointF3.y;
            }
            a2.preRotate(floatValue * n, x, y);
        }
        return this.a;
    }
    
    public a<?, Integer> h() {
        return this.j;
    }
    
    public a<?, Float> i() {
        return this.m;
    }
    
    public void j(final float n) {
        final a<Integer, Integer> j = this.j;
        if (j != null) {
            j.m(n);
        }
        final a<?, Float> m = this.m;
        if (m != null) {
            m.m(n);
        }
        final a<?, Float> n2 = this.n;
        if (n2 != null) {
            n2.m(n);
        }
        final a<PointF, PointF> f = this.f;
        if (f != null) {
            f.m(n);
        }
        final a<?, PointF> g = this.g;
        if (g != null) {
            g.m(n);
        }
        final a<d, d> h = this.h;
        if (h != null) {
            h.m(n);
        }
        final a<Float, Float> i = this.i;
        if (i != null) {
            i.m(n);
        }
        final c k = this.k;
        if (k != null) {
            k.m(n);
        }
        final c l = this.l;
        if (l != null) {
            l.m(n);
        }
    }
}
