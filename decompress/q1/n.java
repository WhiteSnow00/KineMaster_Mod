// 
// Decompiled by Procyon v0.6.0
// 

package q1;

import y1.g;
import t1.d;
import com.airbnb.lottie.model.content.ShapeTrimPath;
import java.util.List;
import android.graphics.PointF;
import com.airbnb.lottie.model.content.PolystarShape;
import com.airbnb.lottie.f;
import android.graphics.Path;
import r1.a;

public class n implements m, b, k
{
    private final Path a;
    private final String b;
    private final com.airbnb.lottie.f c;
    private final PolystarShape.Type d;
    private final boolean e;
    private final a<?, Float> f;
    private final a<?, PointF> g;
    private final a<?, Float> h;
    private final a<?, Float> i;
    private final a<?, Float> j;
    private final a<?, Float> k;
    private final a<?, Float> l;
    private q1.b m;
    private boolean n;
    
    public n(final com.airbnb.lottie.f c, final com.airbnb.lottie.model.layer.a a, final PolystarShape polystarShape) {
        this.a = new Path();
        this.m = new q1.b();
        this.c = c;
        this.b = polystarShape.d();
        final PolystarShape.Type j = polystarShape.j();
        this.d = j;
        this.e = polystarShape.k();
        final a<Float, Float> a2 = polystarShape.g().a();
        this.f = a2;
        final a<PointF, PointF> a3 = polystarShape.h().a();
        this.g = a3;
        final a<Float, Float> a4 = polystarShape.i().a();
        this.h = a4;
        final a<Float, Float> a5 = polystarShape.e().a();
        this.j = a5;
        final a<Float, Float> a6 = polystarShape.f().a();
        this.l = a6;
        final PolystarShape.Type star = PolystarShape.Type.STAR;
        if (j == star) {
            this.i = polystarShape.b().a();
            this.k = polystarShape.c().a();
        }
        else {
            this.i = null;
            this.k = null;
        }
        a.i(a2);
        a.i(a3);
        a.i(a4);
        a.i(a5);
        a.i(a6);
        if (j == star) {
            a.i(this.i);
            a.i(this.k);
        }
        a2.a((a.b)this);
        a3.a((a.b)this);
        a4.a((a.b)this);
        a5.a((a.b)this);
        a6.a((a.b)this);
        if (j == star) {
            this.i.a((a.b)this);
            this.k.a((a.b)this);
        }
    }
    
    private void f() {
        final int n = (int)Math.floor(this.f.h());
        final a<?, Float> h = this.h;
        double n2;
        if (h == null) {
            n2 = 0.0;
        }
        else {
            n2 = h.h();
        }
        final double radians = Math.toRadians(n2 - 90.0);
        final double n3 = n;
        final float n4 = (float)(6.283185307179586 / n3);
        final float n5 = this.l.h() / 100.0f;
        final float floatValue = this.j.h();
        final double n6 = floatValue;
        float n7 = (float)(Math.cos(radians) * n6);
        float n8 = (float)(Math.sin(radians) * n6);
        this.a.moveTo(n7, n8);
        final double n9 = n4;
        double n10 = radians + n9;
        final double ceil = Math.ceil(n3);
        float n12;
        float n13;
        for (int n11 = 0; n11 < ceil; ++n11, n8 = n13, n7 = n12) {
            n12 = (float)(Math.cos(n10) * n6);
            n13 = (float)(n6 * Math.sin(n10));
            if (n5 != 0.0f) {
                final double n14 = (float)(Math.atan2(n8, n7) - 1.5707963267948966);
                final float n15 = (float)Math.cos(n14);
                final float n16 = (float)Math.sin(n14);
                final double n17 = (float)(Math.atan2(n13, n12) - 1.5707963267948966);
                final float n18 = (float)Math.cos(n17);
                final float n19 = (float)Math.sin(n17);
                final float n20 = floatValue * n5 * 0.25f;
                this.a.cubicTo(n7 - n15 * n20, n8 - n16 * n20, n12 + n18 * n20, n13 + n20 * n19, n12, n13);
            }
            else {
                this.a.lineTo(n12, n13);
            }
            n10 += n9;
        }
        final PointF pointF = this.g.h();
        this.a.offset(pointF.x, pointF.y);
        this.a.close();
    }
    
    private void h() {
        final float floatValue = this.f.h();
        final a<?, Float> h = this.h;
        double n;
        if (h == null) {
            n = 0.0;
        }
        else {
            n = h.h();
        }
        final double radians = Math.toRadians(n - 90.0);
        final double n2 = floatValue;
        final float n3 = (float)(6.283185307179586 / n2);
        final float n4 = n3 / 2.0f;
        final float n5 = floatValue - (int)floatValue;
        final float n6 = fcmpl(n5, 0.0f);
        double n7 = radians;
        if (n6 != 0) {
            n7 = radians + (1.0f - n5) * n4;
        }
        final float floatValue2 = this.j.h();
        final float floatValue3 = this.i.h();
        final a<?, Float> k = this.k;
        float n8;
        if (k != null) {
            n8 = k.h() / 100.0f;
        }
        else {
            n8 = 0.0f;
        }
        final a<?, Float> l = this.l;
        float n9;
        if (l != null) {
            n9 = l.h() / 100.0f;
        }
        else {
            n9 = 0.0f;
        }
        float n10;
        float n12;
        float n13;
        double n14;
        if (n6 != 0) {
            n10 = (floatValue2 - floatValue3) * n5 + floatValue3;
            final double n11 = n10;
            n12 = (float)(n11 * Math.cos(n7));
            n13 = (float)(n11 * Math.sin(n7));
            this.a.moveTo(n12, n13);
            n14 = n7 + n3 * n5 / 2.0f;
        }
        else {
            final double n15 = floatValue2;
            n12 = (float)(Math.cos(n7) * n15);
            n13 = (float)(n15 * Math.sin(n7));
            this.a.moveTo(n12, n13);
            n14 = n7 + n4;
            n10 = 0.0f;
        }
        final double n16 = Math.ceil(n2) * 2.0;
        int n17 = 0;
        int n18 = 0;
        float n19 = n13;
        float n20 = n12;
        while (true) {
            final double n21 = n17;
            if (n21 >= n16) {
                break;
            }
            float n22;
            if (n18 != 0) {
                n22 = floatValue2;
            }
            else {
                n22 = floatValue3;
            }
            final float n23 = fcmpl(n10, 0.0f);
            float n24;
            if (n23 != 0 && n21 == n16 - 2.0) {
                n24 = n3 * n5 / 2.0f;
            }
            else {
                n24 = n4;
            }
            if (n23 != 0 && n21 == n16 - 1.0) {
                n22 = n10;
            }
            final double n25 = n22;
            final float n26 = (float)(n25 * Math.cos(n14));
            final float n27 = (float)(n25 * Math.sin(n14));
            if (n8 == 0.0f && n9 == 0.0f) {
                this.a.lineTo(n26, n27);
            }
            else {
                final double n28 = (float)(Math.atan2(n19, n20) - 1.5707963267948966);
                final float n29 = (float)Math.cos(n28);
                final float n30 = (float)Math.sin(n28);
                final double n31 = (float)(Math.atan2(n27, n26) - 1.5707963267948966);
                final float n32 = (float)Math.cos(n31);
                final float n33 = (float)Math.sin(n31);
                float n34;
                if (n18 != 0) {
                    n34 = n8;
                }
                else {
                    n34 = n9;
                }
                float n35;
                if (n18 != 0) {
                    n35 = n9;
                }
                else {
                    n35 = n8;
                }
                float n36;
                if (n18 != 0) {
                    n36 = floatValue3;
                }
                else {
                    n36 = floatValue2;
                }
                float n37;
                if (n18 != 0) {
                    n37 = floatValue2;
                }
                else {
                    n37 = floatValue3;
                }
                final float n38 = n36 * n34 * 0.47829f;
                final float n39 = n29 * n38;
                final float n40 = n38 * n30;
                final float n41 = n37 * n35 * 0.47829f;
                final float n42 = n32 * n41;
                final float n43 = n41 * n33;
                float n44 = n42;
                float n45 = n40;
                float n46 = n43;
                float n47 = n39;
                if (n6 != 0) {
                    if (n17 == 0) {
                        n47 = n39 * n5;
                        n45 = n40 * n5;
                        n44 = n42;
                        n46 = n43;
                    }
                    else {
                        n44 = n42;
                        n45 = n40;
                        n46 = n43;
                        n47 = n39;
                        if (n21 == n16 - 1.0) {
                            n44 = n42 * n5;
                            n46 = n43 * n5;
                            n47 = n39;
                            n45 = n40;
                        }
                    }
                }
                this.a.cubicTo(n20 - n47, n19 - n45, n26 + n44, n27 + n46, n26, n27);
            }
            n14 += n24;
            n18 ^= 0x1;
            ++n17;
            n20 = n26;
            n19 = n27;
        }
        final PointF pointF = this.g.h();
        this.a.offset(pointF.x, pointF.y);
        this.a.close();
    }
    
    private void i() {
        this.n = false;
        this.c.invalidateSelf();
    }
    
    @Override
    public void a() {
        this.i();
    }
    
    @Override
    public void b(final List<c> list, final List<c> list2) {
        for (int i = 0; i < list.size(); ++i) {
            final c c = list.get(i);
            if (c instanceof s) {
                final s s = (s)c;
                if (s.i() == ShapeTrimPath.Type.SIMULTANEOUSLY) {
                    this.m.a(s);
                    s.c(this);
                }
            }
        }
    }
    
    @Override
    public <T> void c(final T t, final z1.c<T> c) {
        if (t == com.airbnb.lottie.k.u) {
            this.f.n((z1.c<Float>)c);
        }
        else if (t == com.airbnb.lottie.k.v) {
            this.h.n((z1.c<Float>)c);
        }
        else if (t == com.airbnb.lottie.k.l) {
            this.g.n((z1.c<PointF>)c);
        }
        else {
            if (t == com.airbnb.lottie.k.w) {
                final a<?, Float> i = this.i;
                if (i != null) {
                    i.n((z1.c<Float>)c);
                    return;
                }
            }
            if (t == com.airbnb.lottie.k.x) {
                this.j.n((z1.c<Float>)c);
            }
            else {
                if (t == com.airbnb.lottie.k.y) {
                    final a<?, Float> k = this.k;
                    if (k != null) {
                        k.n((z1.c<Float>)c);
                        return;
                    }
                }
                if (t == com.airbnb.lottie.k.z) {
                    this.l.n((z1.c<Float>)c);
                }
            }
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
        if (this.n) {
            return this.a;
        }
        this.a.reset();
        if (this.e) {
            this.n = true;
            return this.a;
        }
        final int n = n$a.a[this.d.ordinal()];
        if (n != 1) {
            if (n == 2) {
                this.f();
            }
        }
        else {
            this.h();
        }
        this.a.close();
        this.m.b(this.a);
        this.n = true;
        return this.a;
    }
}
