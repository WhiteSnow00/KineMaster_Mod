// 
// Decompiled by Procyon v0.6.0
// 

package q1;

import y1.g;
import t1.d;
import com.airbnb.lottie.model.content.ShapeTrimPath;
import java.util.List;
import v1.e;
import android.graphics.PointF;
import com.airbnb.lottie.f;
import android.graphics.RectF;
import android.graphics.Path;
import r1.a;

public class o implements b, k, m
{
    private final Path a;
    private final RectF b;
    private final String c;
    private final boolean d;
    private final com.airbnb.lottie.f e;
    private final a<?, PointF> f;
    private final a<?, PointF> g;
    private final a<?, Float> h;
    private q1.b i;
    private boolean j;
    
    public o(final com.airbnb.lottie.f e, final com.airbnb.lottie.model.layer.a a, final e e2) {
        this.a = new Path();
        this.b = new RectF();
        this.i = new q1.b();
        this.c = e2.c();
        this.d = e2.f();
        this.e = e;
        final a<PointF, PointF> a2 = e2.d().a();
        this.f = a2;
        final a<PointF, PointF> a3 = e2.e().a();
        this.g = a3;
        final a<Float, Float> a4 = e2.b().a();
        this.h = a4;
        a.i(a2);
        a.i(a3);
        a.i(a4);
        a2.a((a.b)this);
        a3.a((a.b)this);
        a4.a((a.b)this);
    }
    
    private void f() {
        this.j = false;
        this.e.invalidateSelf();
    }
    
    @Override
    public void a() {
        this.f();
    }
    
    @Override
    public void b(final List<c> list, final List<c> list2) {
        for (int i = 0; i < list.size(); ++i) {
            final c c = list.get(i);
            if (c instanceof s) {
                final s s = (s)c;
                if (s.i() == ShapeTrimPath.Type.SIMULTANEOUSLY) {
                    this.i.a(s);
                    s.c(this);
                }
            }
        }
    }
    
    @Override
    public <T> void c(final T t, final z1.c<T> c) {
        if (t == com.airbnb.lottie.k.j) {
            this.g.n((z1.c<PointF>)c);
        }
        else if (t == com.airbnb.lottie.k.l) {
            this.f.n((z1.c<PointF>)c);
        }
        else if (t == com.airbnb.lottie.k.k) {
            this.h.n((z1.c<Float>)c);
        }
    }
    
    @Override
    public void d(final t1.d d, final int n, final List<t1.d> list, final t1.d d2) {
        y1.g.m(d, n, list, d2, this);
    }
    
    @Override
    public String getName() {
        return this.c;
    }
    
    @Override
    public Path getPath() {
        if (this.j) {
            return this.a;
        }
        this.a.reset();
        if (this.d) {
            this.j = true;
            return this.a;
        }
        final PointF pointF = this.g.h();
        final float n = pointF.x / 2.0f;
        final float n2 = pointF.y / 2.0f;
        final a<?, Float> h = this.h;
        float p;
        if (h == null) {
            p = 0.0f;
        }
        else {
            p = ((r1.c)h).p();
        }
        final float min = Math.min(n, n2);
        float n3 = p;
        if (p > min) {
            n3 = min;
        }
        final PointF pointF2 = this.f.h();
        this.a.moveTo(pointF2.x + n, pointF2.y - n2 + n3);
        this.a.lineTo(pointF2.x + n, pointF2.y + n2 - n3);
        final float n4 = fcmpl(n3, 0.0f);
        if (n4 > 0) {
            final RectF b = this.b;
            final float x = pointF2.x;
            final float n5 = n3 * 2.0f;
            final float y = pointF2.y;
            b.set(x + n - n5, y + n2 - n5, x + n, y + n2);
            this.a.arcTo(this.b, 0.0f, 90.0f, false);
        }
        this.a.lineTo(pointF2.x - n + n3, pointF2.y + n2);
        if (n4 > 0) {
            final RectF b2 = this.b;
            final float x2 = pointF2.x;
            final float y2 = pointF2.y;
            final float n6 = n3 * 2.0f;
            b2.set(x2 - n, y2 + n2 - n6, x2 - n + n6, y2 + n2);
            this.a.arcTo(this.b, 90.0f, 90.0f, false);
        }
        this.a.lineTo(pointF2.x - n, pointF2.y - n2 + n3);
        if (n4 > 0) {
            final RectF b3 = this.b;
            final float x3 = pointF2.x;
            final float y3 = pointF2.y;
            final float n7 = n3 * 2.0f;
            b3.set(x3 - n, y3 - n2, x3 - n + n7, y3 - n2 + n7);
            this.a.arcTo(this.b, 180.0f, 90.0f, false);
        }
        this.a.lineTo(pointF2.x + n - n3, pointF2.y - n2);
        if (n4 > 0) {
            final RectF b4 = this.b;
            final float x4 = pointF2.x;
            final float n8 = n3 * 2.0f;
            final float y4 = pointF2.y;
            b4.set(x4 + n - n8, y4 - n2, x4 + n, y4 - n2 + n8);
            this.a.arcTo(this.b, 270.0f, 90.0f, false);
        }
        this.a.close();
        this.i.b(this.a);
        this.j = true;
        return this.a;
    }
}
