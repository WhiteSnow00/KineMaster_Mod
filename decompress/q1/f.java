// 
// Decompiled by Procyon v0.6.0
// 

package q1;

import y1.g;
import t1.d;
import com.airbnb.lottie.model.content.ShapeTrimPath;
import java.util.List;
import android.graphics.PointF;
import android.graphics.Path;
import r1.a;

public class f implements m, b, k
{
    private final Path a;
    private final String b;
    private final com.airbnb.lottie.f c;
    private final a<?, PointF> d;
    private final a<?, PointF> e;
    private final v1.a f;
    private q1.b g;
    private boolean h;
    
    public f(final com.airbnb.lottie.f c, final com.airbnb.lottie.model.layer.a a, final v1.a f) {
        this.a = new Path();
        this.g = new q1.b();
        this.b = f.b();
        this.c = c;
        final a<PointF, PointF> a2 = f.d().a();
        this.d = a2;
        final a<PointF, PointF> a3 = f.c().a();
        this.e = a3;
        this.f = f;
        a.i(a2);
        a.i(a3);
        a2.a((a.b)this);
        a3.a((a.b)this);
    }
    
    private void f() {
        this.h = false;
        this.c.invalidateSelf();
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
                    this.g.a(s);
                    s.c(this);
                }
            }
        }
    }
    
    @Override
    public <T> void c(final T t, final z1.c<T> c) {
        if (t == com.airbnb.lottie.k.i) {
            this.d.n((z1.c<PointF>)c);
        }
        else if (t == com.airbnb.lottie.k.l) {
            this.e.n((z1.c<PointF>)c);
        }
    }
    
    @Override
    public void d(final t1.d d, final int n, final List<t1.d> list, final t1.d d2) {
        y1.g.m(d, n, list, d2, this);
    }
    
    @Override
    public String getName() {
        return this.b;
    }
    
    @Override
    public Path getPath() {
        if (this.h) {
            return this.a;
        }
        this.a.reset();
        if (this.f.e()) {
            this.h = true;
            return this.a;
        }
        final PointF pointF = this.d.h();
        final float n = pointF.x / 2.0f;
        final float n2 = pointF.y / 2.0f;
        final float n3 = n * 0.55228f;
        final float n4 = 0.55228f * n2;
        this.a.reset();
        if (this.f.f()) {
            final Path a = this.a;
            final float n5 = -n2;
            a.moveTo(0.0f, n5);
            final Path a2 = this.a;
            final float n6 = 0.0f - n3;
            final float n7 = -n;
            final float n8 = 0.0f - n4;
            a2.cubicTo(n6, n5, n7, n8, n7, 0.0f);
            final Path a3 = this.a;
            final float n9 = n4 + 0.0f;
            a3.cubicTo(n7, n9, n6, n2, 0.0f, n2);
            final Path a4 = this.a;
            final float n10 = n3 + 0.0f;
            a4.cubicTo(n10, n2, n, n9, n, 0.0f);
            this.a.cubicTo(n, n8, n10, n5, 0.0f, n5);
        }
        else {
            final Path a5 = this.a;
            final float n11 = -n2;
            a5.moveTo(0.0f, n11);
            final Path a6 = this.a;
            final float n12 = n3 + 0.0f;
            final float n13 = 0.0f - n4;
            a6.cubicTo(n12, n11, n, n13, n, 0.0f);
            final Path a7 = this.a;
            final float n14 = n4 + 0.0f;
            a7.cubicTo(n, n14, n12, n2, 0.0f, n2);
            final Path a8 = this.a;
            final float n15 = 0.0f - n3;
            final float n16 = -n;
            a8.cubicTo(n15, n2, n16, n14, n16, 0.0f);
            this.a.cubicTo(n16, n13, n15, n11, 0.0f, n11);
        }
        final PointF pointF2 = this.e.h();
        this.a.offset(pointF2.x, pointF2.y);
        this.a.close();
        this.g.b(this.a);
        this.h = true;
        return this.a;
    }
}
