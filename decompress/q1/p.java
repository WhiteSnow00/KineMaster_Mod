// 
// Decompiled by Procyon v0.6.0
// 

package q1;

import android.graphics.Canvas;
import u1.l;
import java.util.Collections;
import java.util.ArrayList;
import java.util.ListIterator;
import android.graphics.RectF;
import y1.g;
import java.util.List;
import r1.o;
import com.airbnb.lottie.f;
import android.graphics.Path;
import android.graphics.Matrix;
import r1.a;

public class p implements e, m, j, b, k
{
    private final Matrix a;
    private final Path b;
    private final com.airbnb.lottie.f c;
    private final com.airbnb.lottie.model.layer.a d;
    private final String e;
    private final boolean f;
    private final a<Float, Float> g;
    private final a<Float, Float> h;
    private final o i;
    private q1.d j;
    
    public p(final com.airbnb.lottie.f c, final com.airbnb.lottie.model.layer.a d, final v1.f f) {
        this.a = new Matrix();
        this.b = new Path();
        this.c = c;
        this.d = d;
        this.e = f.c();
        this.f = f.f();
        final a<Float, Float> a = f.b().a();
        d.i(this.g = a);
        a.a((a.b)this);
        final a<Float, Float> a2 = f.d().a();
        d.i(this.h = a2);
        a2.a((a.b)this);
        final o b = f.e().b();
        (this.i = b).a(d);
        b.b(this);
    }
    
    @Override
    public void a() {
        this.c.invalidateSelf();
    }
    
    @Override
    public void b(final List<c> list, final List<c> list2) {
        this.j.b(list, list2);
    }
    
    @Override
    public <T> void c(final T t, final z1.c<T> c) {
        if (this.i.c(t, c)) {
            return;
        }
        if (t == com.airbnb.lottie.k.s) {
            this.g.n((z1.c<Float>)c);
        }
        else if (t == com.airbnb.lottie.k.t) {
            this.h.n((z1.c<Float>)c);
        }
    }
    
    @Override
    public void d(final t1.d d, final int n, final List<t1.d> list, final t1.d d2) {
        y1.g.m(d, n, list, d2, this);
    }
    
    @Override
    public void e(final RectF rectF, final Matrix matrix, final boolean b) {
        this.j.e(rectF, matrix, b);
    }
    
    @Override
    public void f(final ListIterator<c> listIterator) {
        if (this.j != null) {
            return;
        }
        while (listIterator.hasPrevious() && listIterator.previous() != this) {}
        final ArrayList list = new ArrayList();
        while (listIterator.hasPrevious()) {
            list.add(listIterator.previous());
            listIterator.remove();
        }
        Collections.reverse(list);
        this.j = new q1.d(this.c, this.d, "Repeater", this.f, list, null);
    }
    
    @Override
    public void g(final Canvas canvas, final Matrix matrix, final int n) {
        final float floatValue = this.g.h();
        final float floatValue2 = this.h.h();
        final float n2 = this.i.i().h() / 100.0f;
        final float n3 = this.i.e().h() / 100.0f;
        for (int i = (int)floatValue - 1; i >= 0; --i) {
            this.a.set(matrix);
            final Matrix a = this.a;
            final o j = this.i;
            final float n4 = (float)i;
            a.preConcat(j.g(n4 + floatValue2));
            this.j.g(canvas, this.a, (int)(n * y1.g.k(n2, n3, n4 / floatValue)));
        }
    }
    
    @Override
    public String getName() {
        return this.e;
    }
    
    @Override
    public Path getPath() {
        final Path path = this.j.getPath();
        this.b.reset();
        final float floatValue = this.g.h();
        final float floatValue2 = this.h.h();
        for (int i = (int)floatValue - 1; i >= 0; --i) {
            this.a.set(this.i.g(i + floatValue2));
            this.b.addPath(path, this.a);
        }
        return this.b;
    }
}
