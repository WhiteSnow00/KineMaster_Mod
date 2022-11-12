// 
// Decompiled by Procyon v0.6.0
// 

package q1;

import y1.h;
import android.graphics.Canvas;
import java.util.Collection;
import v1.b;
import v1.i;
import java.util.ArrayList;
import u1.l;
import r1.o;
import com.airbnb.lottie.f;
import java.util.List;
import android.graphics.Path;
import android.graphics.Matrix;
import android.graphics.RectF;
import android.graphics.Paint;
import r1.a;

public class d implements e, m, b, t1.e
{
    private Paint a;
    private RectF b;
    private final Matrix c;
    private final Path d;
    private final RectF e;
    private final String f;
    private final boolean g;
    private final List<c> h;
    private final com.airbnb.lottie.f i;
    private List<m> j;
    private o k;
    
    d(final com.airbnb.lottie.f i, final com.airbnb.lottie.model.layer.a a, final String f, final boolean g, final List<c> h, final l l) {
        this.a = new p1.a();
        this.b = new RectF();
        this.c = new Matrix();
        this.d = new Path();
        this.e = new RectF();
        this.f = f;
        this.i = i;
        this.g = g;
        this.h = h;
        if (l != null) {
            (this.k = l.b()).a(a);
            this.k.b(this);
        }
        final ArrayList list = new ArrayList();
        for (int j = h.size() - 1; j >= 0; --j) {
            final c c = h.get(j);
            if (c instanceof j) {
                list.add(c);
            }
        }
        for (int k = list.size() - 1; k >= 0; --k) {
            ((j)list.get(k)).f(h.listIterator(h.size()));
        }
    }
    
    public d(final com.airbnb.lottie.f f, final com.airbnb.lottie.model.layer.a a, final i i) {
        this(f, a, i.c(), i.d(), f(f, a, i.b()), h(i.b()));
    }
    
    private static List<c> f(final com.airbnb.lottie.f f, final com.airbnb.lottie.model.layer.a a, final List<v1.b> list) {
        final ArrayList list2 = new ArrayList(list.size());
        for (int i = 0; i < list.size(); ++i) {
            final c a2 = list.get(i).a(f, a);
            if (a2 != null) {
                list2.add(a2);
            }
        }
        return list2;
    }
    
    static l h(final List<v1.b> list) {
        for (int i = 0; i < list.size(); ++i) {
            final v1.b b = list.get(i);
            if (b instanceof l) {
                return (l)b;
            }
        }
        return null;
    }
    
    private boolean k() {
        int i = 0;
        int n = 0;
        while (i < this.h.size()) {
            int n2 = n;
            if (this.h.get(i) instanceof e) {
                n2 = ++n;
                if (n >= 2) {
                    return true;
                }
            }
            ++i;
            n = n2;
        }
        return false;
    }
    
    @Override
    public void a() {
        this.i.invalidateSelf();
    }
    
    @Override
    public void b(final List<c> list, final List<c> list2) {
        final ArrayList list3 = new ArrayList(list.size() + this.h.size());
        list3.addAll(list);
        for (int i = this.h.size() - 1; i >= 0; --i) {
            final c c = this.h.get(i);
            c.b(list3, this.h.subList(0, i));
            list3.add(c);
        }
    }
    
    @Override
    public <T> void c(final T t, final z1.c<T> c) {
        final o k = this.k;
        if (k != null) {
            k.c(t, c);
        }
    }
    
    @Override
    public void d(final t1.d d, final int n, final List<t1.d> list, t1.d d2) {
        if (!d.g(this.getName(), n) && !"__container".equals(this.getName())) {
            return;
        }
        t1.d a = d2;
        if (!"__container".equals(this.getName())) {
            d2 = (a = d2.a(this.getName()));
            if (d.c(this.getName(), n)) {
                list.add(d2.i(this));
                a = d2;
            }
        }
        if (d.h(this.getName(), n)) {
            final int e = d.e(this.getName(), n);
            for (int i = 0; i < this.h.size(); ++i) {
                final c c = this.h.get(i);
                if (c instanceof t1.e) {
                    ((t1.e)c).d(d, n + e, list, a);
                }
            }
        }
    }
    
    @Override
    public void e(final RectF rectF, final Matrix matrix, final boolean b) {
        this.c.set(matrix);
        final o k = this.k;
        if (k != null) {
            this.c.preConcat(k.f());
        }
        this.e.set(0.0f, 0.0f, 0.0f, 0.0f);
        for (int i = this.h.size() - 1; i >= 0; --i) {
            final c c = this.h.get(i);
            if (c instanceof e) {
                ((e)c).e(this.e, this.c, b);
                rectF.union(this.e);
            }
        }
    }
    
    @Override
    public void g(final Canvas canvas, final Matrix matrix, int n) {
        if (this.g) {
            return;
        }
        this.c.set(matrix);
        final o k = this.k;
        int alpha = n;
        if (k != null) {
            this.c.preConcat(k.f());
            int intValue;
            if (this.k.h() == null) {
                intValue = 100;
            }
            else {
                intValue = this.k.h().h();
            }
            alpha = (int)(intValue / 100.0f * n / 255.0f * 255.0f);
        }
        if (this.i.I() && this.k() && alpha != 255) {
            n = 1;
        }
        else {
            n = 0;
        }
        if (n != 0) {
            this.b.set(0.0f, 0.0f, 0.0f, 0.0f);
            this.e(this.b, this.c, true);
            this.a.setAlpha(alpha);
            y1.h.m(canvas, this.b, this.a);
        }
        if (n != 0) {
            alpha = 255;
        }
        for (int i = this.h.size() - 1; i >= 0; --i) {
            final c value = this.h.get(i);
            if (value instanceof e) {
                ((e)value).g(canvas, this.c, alpha);
            }
        }
        if (n != 0) {
            canvas.restore();
        }
    }
    
    @Override
    public String getName() {
        return this.f;
    }
    
    @Override
    public Path getPath() {
        this.c.reset();
        final o k = this.k;
        if (k != null) {
            this.c.set(k.f());
        }
        this.d.reset();
        if (this.g) {
            return this.d;
        }
        for (int i = this.h.size() - 1; i >= 0; --i) {
            final c c = this.h.get(i);
            if (c instanceof m) {
                this.d.addPath(((m)c).getPath(), this.c);
            }
        }
        return this.d;
    }
    
    List<m> i() {
        if (this.j == null) {
            this.j = new ArrayList<m>();
            for (int i = 0; i < this.h.size(); ++i) {
                final c c = this.h.get(i);
                if (c instanceof m) {
                    this.j.add((m)c);
                }
            }
        }
        return this.j;
    }
    
    Matrix j() {
        final o k = this.k;
        if (k != null) {
            return k.f();
        }
        this.c.reset();
        return this.c;
    }
}
