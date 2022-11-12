// 
// Decompiled by Procyon v0.6.0
// 

package com.airbnb.lottie.model.layer;

import y1.h;
import android.graphics.Canvas;
import android.graphics.Matrix;
import r1.p;
import com.airbnb.lottie.k;
import z1.c;
import java.util.Iterator;
import java.util.ArrayList;
import com.airbnb.lottie.d;
import com.airbnb.lottie.f;
import android.graphics.Paint;
import android.graphics.RectF;
import java.util.List;

public class b extends a
{
    private final List<a> A;
    private final RectF B;
    private final RectF C;
    private Paint D;
    private r1.a<Float, Float> z;
    
    public b(final com.airbnb.lottie.f f, final Layer layer, final List<Layer> list, final com.airbnb.lottie.d d) {
        super(f, layer);
        this.A = new ArrayList<a>();
        this.B = new RectF();
        this.C = new RectF();
        this.D = new Paint();
        final u1.b s = layer.s();
        if (s != null) {
            this.i(this.z = s.a());
            this.z.a((r1.a.b)this);
        }
        else {
            this.z = null;
        }
        final androidx.collection.d<a> d2 = new androidx.collection.d<a>(d.j().size());
        int n = list.size() - 1;
        a a = null;
        int i;
        while (true) {
            i = 0;
            if (n < 0) {
                break;
            }
            final Layer layer2 = list.get(n);
            final a u = com.airbnb.lottie.model.layer.a.u(layer2, f, d);
            if (u != null) {
                d2.l(u.v().b(), u);
                if (a != null) {
                    a.E(u);
                    a = null;
                }
                else {
                    this.A.add(0, u);
                    final int n2 = b$a.a[layer2.f().ordinal()];
                    if (n2 == 1 || n2 == 2) {
                        a = u;
                    }
                }
            }
            --n;
        }
        while (i < d2.o()) {
            final a a2 = d2.f(d2.j(i));
            if (a2 != null) {
                final a a3 = d2.f(a2.v().h());
                if (a3 != null) {
                    a2.G(a3);
                }
            }
            ++i;
        }
    }
    
    protected void D(final t1.d d, final int n, final List<t1.d> list, final t1.d d2) {
        for (int i = 0; i < this.A.size(); ++i) {
            this.A.get(i).d(d, n, list, d2);
        }
    }
    
    public void F(final boolean b) {
        super.F(b);
        final Iterator<a> iterator = this.A.iterator();
        while (iterator.hasNext()) {
            iterator.next().F(b);
        }
    }
    
    public void H(float o) {
        super.H(o);
        float n = o;
        if (this.z != null) {
            final float e = super.n.p().e();
            o = super.o.a().o();
            n = (this.z.h() * super.o.a().h() - o) / (e + 0.01f);
        }
        o = n;
        if (this.z == null) {
            o = n - super.o.p();
        }
        float n2 = o;
        if (super.o.t() != 0.0f) {
            n2 = o / super.o.t();
        }
        for (int i = this.A.size() - 1; i >= 0; --i) {
            this.A.get(i).H(n2);
        }
    }
    
    @Override
    public <T> void c(final T t, final c<T> c) {
        super.c(t, c);
        if (t == com.airbnb.lottie.k.C) {
            if (c == null) {
                final r1.a<Float, Float> z = this.z;
                if (z != null) {
                    z.n(null);
                }
            }
            else {
                (this.z = new p<Float, Float>((c<Float>)c)).a((r1.a.b)this);
                this.i(this.z);
            }
        }
    }
    
    @Override
    public void e(final RectF rectF, final Matrix matrix, final boolean b) {
        super.e(rectF, matrix, b);
        for (int i = this.A.size() - 1; i >= 0; --i) {
            this.B.set(0.0f, 0.0f, 0.0f, 0.0f);
            this.A.get(i).e(this.B, super.m, true);
            rectF.union(this.B);
        }
    }
    
    @Override
    void t(final Canvas canvas, final Matrix matrix, int alpha) {
        com.airbnb.lottie.c.a("CompositionLayer#draw");
        this.C.set(0.0f, 0.0f, (float)super.o.j(), (float)super.o.i());
        matrix.mapRect(this.C);
        final boolean b = super.n.I() && this.A.size() > 1 && alpha != 255;
        if (b) {
            this.D.setAlpha(alpha);
            y1.h.m(canvas, this.C, this.D);
        }
        else {
            canvas.save();
        }
        if (b) {
            alpha = 255;
        }
        for (int i = this.A.size() - 1; i >= 0; --i) {
            if (this.C.isEmpty() || canvas.clipRect(this.C)) {
                this.A.get(i).g(canvas, matrix, alpha);
            }
        }
        canvas.restore();
        com.airbnb.lottie.c.b("CompositionLayer#draw");
    }
}
