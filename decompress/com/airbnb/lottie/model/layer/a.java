// 
// Decompiled by Procyon v0.6.0
// 

package com.airbnb.lottie.model.layer;

import android.graphics.Paint$Style;
import com.airbnb.lottie.d;
import java.util.Collections;
import android.os.Build$VERSION;
import y1.h;
import com.airbnb.lottie.model.content.Mask;
import android.graphics.Canvas;
import java.util.Iterator;
import android.graphics.Xfermode;
import android.graphics.PorterDuffXfermode;
import java.util.ArrayList;
import android.graphics.PorterDuff$Mode;
import r1.o;
import java.util.List;
import r1.c;
import r1.g;
import com.airbnb.lottie.f;
import android.graphics.RectF;
import android.graphics.Paint;
import android.graphics.Matrix;
import android.graphics.Path;
import q1.e;

public abstract class a implements e, b, t1.e
{
    private final Path a;
    private final Matrix b;
    private final Paint c;
    private final Paint d;
    private final Paint e;
    private final Paint f;
    private final Paint g;
    private final RectF h;
    private final RectF i;
    private final RectF j;
    private final RectF k;
    private final String l;
    final Matrix m;
    final com.airbnb.lottie.f n;
    final Layer o;
    private g p;
    private c q;
    private a r;
    private a s;
    private List<a> t;
    private final List<r1.a<?, ?>> u;
    final o v;
    private boolean w;
    private boolean x;
    private Paint y;
    
    a(final com.airbnb.lottie.f n, final Layer o) {
        this.a = new Path();
        this.b = new Matrix();
        this.c = new p1.a(1);
        this.d = new p1.a(1, PorterDuff$Mode.DST_IN);
        this.e = new p1.a(1, PorterDuff$Mode.DST_OUT);
        final p1.a f = new p1.a(1);
        this.f = f;
        this.g = new p1.a(PorterDuff$Mode.CLEAR);
        this.h = new RectF();
        this.i = new RectF();
        this.j = new RectF();
        this.k = new RectF();
        this.m = new Matrix();
        this.u = new ArrayList<r1.a<?, ?>>();
        this.w = true;
        this.n = n;
        this.o = o;
        final StringBuilder sb = new StringBuilder();
        sb.append(o.g());
        sb.append("#draw");
        this.l = sb.toString();
        if (o.f() == Layer.MatteType.INVERT) {
            f.setXfermode((Xfermode)new PorterDuffXfermode(PorterDuff$Mode.DST_OUT));
        }
        else {
            f.setXfermode((Xfermode)new PorterDuffXfermode(PorterDuff$Mode.DST_IN));
        }
        (this.v = o.u().b()).b(this);
        if (o.e() != null && !o.e().isEmpty()) {
            final g p2 = new g(o.e());
            this.p = p2;
            final Iterator<r1.a<v1.g, Path>> iterator = p2.a().iterator();
            while (iterator.hasNext()) {
                iterator.next().a((b)this);
            }
            for (final r1.a a : this.p.c()) {
                this.i(a);
                a.a((b)this);
            }
        }
        this.J();
    }
    
    private void A() {
        this.n.invalidateSelf();
    }
    
    private void B(final float n) {
        this.n.p().m().a(this.o.g(), n);
    }
    
    private void I(final boolean w) {
        if (w != this.w) {
            this.w = w;
            this.A();
        }
    }
    
    private void J() {
        final boolean empty = this.o.c().isEmpty();
        boolean b = true;
        if (!empty) {
            (this.q = new c(this.o.c())).l();
            this.q.a((b)new b(this) {
                final a a;
                
                @Override
                public void a() {
                    final a a = this.a;
                    com.airbnb.lottie.model.layer.a.h(a, com.airbnb.lottie.model.layer.a.f(a).p() == 1.0f);
                }
            });
            if (((r1.a<K, Float>)this.q).h() != 1.0f) {
                b = false;
            }
            this.I(b);
            this.i(this.q);
        }
        else {
            this.I(true);
        }
    }
    
    static c f(final a a) {
        return a.q;
    }
    
    static void h(final a a, final boolean b) {
        a.I(b);
    }
    
    private void j(final Canvas canvas, final Matrix matrix, final Mask mask, final r1.a<v1.g, Path> a, final r1.a<Integer, Integer> a2) {
        this.a.set((Path)a.h());
        this.a.transform(matrix);
        this.c.setAlpha((int)(a2.h() * 2.55f));
        canvas.drawPath(this.a, this.c);
    }
    
    private void k(final Canvas canvas, final Matrix matrix, final Mask mask, final r1.a<v1.g, Path> a, final r1.a<Integer, Integer> a2) {
        y1.h.m(canvas, this.h, this.d);
        this.a.set((Path)a.h());
        this.a.transform(matrix);
        this.c.setAlpha((int)(a2.h() * 2.55f));
        canvas.drawPath(this.a, this.c);
        canvas.restore();
    }
    
    private void l(final Canvas canvas, final Matrix matrix, final Mask mask, final r1.a<v1.g, Path> a, final r1.a<Integer, Integer> a2) {
        y1.h.m(canvas, this.h, this.c);
        canvas.drawRect(this.h, this.c);
        this.a.set((Path)a.h());
        this.a.transform(matrix);
        this.c.setAlpha((int)(a2.h() * 2.55f));
        canvas.drawPath(this.a, this.e);
        canvas.restore();
    }
    
    private void m(final Canvas canvas, final Matrix matrix, final Mask mask, final r1.a<v1.g, Path> a, final r1.a<Integer, Integer> a2) {
        y1.h.m(canvas, this.h, this.d);
        canvas.drawRect(this.h, this.c);
        this.e.setAlpha((int)(a2.h() * 2.55f));
        this.a.set((Path)a.h());
        this.a.transform(matrix);
        canvas.drawPath(this.a, this.e);
        canvas.restore();
    }
    
    private void n(final Canvas canvas, final Matrix matrix, final Mask mask, final r1.a<v1.g, Path> a, final r1.a<Integer, Integer> a2) {
        y1.h.m(canvas, this.h, this.e);
        canvas.drawRect(this.h, this.c);
        this.e.setAlpha((int)(a2.h() * 2.55f));
        this.a.set((Path)a.h());
        this.a.transform(matrix);
        canvas.drawPath(this.a, this.e);
        canvas.restore();
    }
    
    private void o(final Canvas canvas, final Matrix matrix) {
        com.airbnb.lottie.c.a("Layer#saveLayer");
        y1.h.n(canvas, this.h, this.d, 19);
        if (Build$VERSION.SDK_INT < 28) {
            this.s(canvas);
        }
        com.airbnb.lottie.c.b("Layer#saveLayer");
        for (int i = 0; i < this.p.b().size(); ++i) {
            final Mask mask = this.p.b().get(i);
            final r1.a a = this.p.a().get(i);
            final r1.a a2 = this.p.c().get(i);
            final int n = a$b.b[mask.a().ordinal()];
            if (n != 1) {
                if (n != 2) {
                    if (n != 3) {
                        if (n == 4) {
                            if (mask.d()) {
                                this.l(canvas, matrix, mask, a, a2);
                            }
                            else {
                                this.j(canvas, matrix, mask, a, a2);
                            }
                        }
                    }
                    else if (mask.d()) {
                        this.m(canvas, matrix, mask, a, a2);
                    }
                    else {
                        this.k(canvas, matrix, mask, a, a2);
                    }
                }
                else {
                    if (i == 0) {
                        this.c.setColor(-16777216);
                        this.c.setAlpha(255);
                        canvas.drawRect(this.h, this.c);
                    }
                    if (mask.d()) {
                        this.n(canvas, matrix, mask, a, a2);
                    }
                    else {
                        this.p(canvas, matrix, mask, a, a2);
                    }
                }
            }
            else if (this.q()) {
                this.c.setAlpha(255);
                canvas.drawRect(this.h, this.c);
            }
        }
        com.airbnb.lottie.c.a("Layer#restoreLayer");
        canvas.restore();
        com.airbnb.lottie.c.b("Layer#restoreLayer");
    }
    
    private void p(final Canvas canvas, final Matrix matrix, final Mask mask, final r1.a<v1.g, Path> a, final r1.a<Integer, Integer> a2) {
        this.a.set((Path)a.h());
        this.a.transform(matrix);
        canvas.drawPath(this.a, this.e);
    }
    
    private boolean q() {
        if (this.p.a().isEmpty()) {
            return false;
        }
        for (int i = 0; i < this.p.b().size(); ++i) {
            if (this.p.b().get(i).a() != Mask.MaskMode.MASK_MODE_NONE) {
                return false;
            }
        }
        return true;
    }
    
    private void r() {
        if (this.t != null) {
            return;
        }
        if (this.s == null) {
            this.t = Collections.emptyList();
            return;
        }
        this.t = new ArrayList<a>();
        for (a a = this.s; a != null; a = a.s) {
            this.t.add(a);
        }
    }
    
    private void s(final Canvas canvas) {
        com.airbnb.lottie.c.a("Layer#clearLayer");
        final RectF h = this.h;
        canvas.drawRect(h.left - 1.0f, h.top - 1.0f, h.right + 1.0f, h.bottom + 1.0f, this.g);
        com.airbnb.lottie.c.b("Layer#clearLayer");
    }
    
    static a u(final Layer layer, final com.airbnb.lottie.f f, final com.airbnb.lottie.d d) {
        switch (a$b.a[layer.d().ordinal()]) {
            default: {
                final StringBuilder sb = new StringBuilder();
                sb.append("Unknown layer type ");
                sb.append(layer.d());
                y1.d.c(sb.toString());
                return null;
            }
            case 6: {
                return new com.airbnb.lottie.model.layer.g(f, layer);
            }
            case 5: {
                return new com.airbnb.lottie.model.layer.d(f, layer);
            }
            case 4: {
                return new c(f, layer);
            }
            case 3: {
                return new com.airbnb.lottie.model.layer.f(f, layer);
            }
            case 2: {
                return new com.airbnb.lottie.model.layer.b(f, layer, d.n(layer.k()), d);
            }
            case 1: {
                return new e(f, layer);
            }
        }
    }
    
    private void y(final RectF rectF, final Matrix matrix) {
        this.i.set(0.0f, 0.0f, 0.0f, 0.0f);
        if (!this.w()) {
            return;
        }
        for (int size = this.p.b().size(), i = 0; i < size; ++i) {
            final Mask mask = this.p.b().get(i);
            this.a.set((Path)this.p.a().get(i).h());
            this.a.transform(matrix);
            final int n = a$b.b[mask.a().ordinal()];
            if (n == 1 || n == 2) {
                return;
            }
            if (n == 3 || n == 4) {
                if (mask.d()) {
                    return;
                }
            }
            this.a.computeBounds(this.k, false);
            if (i == 0) {
                this.i.set(this.k);
            }
            else {
                final RectF j = this.i;
                j.set(Math.min(j.left, this.k.left), Math.min(this.i.top, this.k.top), Math.max(this.i.right, this.k.right), Math.max(this.i.bottom, this.k.bottom));
            }
        }
        if (!rectF.intersect(this.i)) {
            rectF.set(0.0f, 0.0f, 0.0f, 0.0f);
        }
    }
    
    private void z(final RectF rectF, final Matrix matrix) {
        if (!this.x()) {
            return;
        }
        if (this.o.f() == Layer.MatteType.INVERT) {
            return;
        }
        this.j.set(0.0f, 0.0f, 0.0f, 0.0f);
        this.r.e(this.j, matrix, true);
        if (!rectF.intersect(this.j)) {
            rectF.set(0.0f, 0.0f, 0.0f, 0.0f);
        }
    }
    
    public void C(final r1.a<?, ?> a) {
        this.u.remove(a);
    }
    
    void D(final t1.d d, final int n, final List<t1.d> list, final t1.d d2) {
    }
    
    void E(final a r) {
        this.r = r;
    }
    
    void F(final boolean x) {
        if (x && this.y == null) {
            this.y = new p1.a();
        }
        this.x = x;
    }
    
    void G(final a s) {
        this.s = s;
    }
    
    void H(float t) {
        this.v.j(t);
        final g p = this.p;
        final int n = 0;
        if (p != null) {
            for (int i = 0; i < this.p.a().size(); ++i) {
                this.p.a().get(i).m(t);
            }
        }
        float n2 = t;
        if (this.o.t() != 0.0f) {
            n2 = t / this.o.t();
        }
        final c q = this.q;
        if (q != null) {
            q.m(n2 / this.o.t());
        }
        final a r = this.r;
        int j = n;
        if (r != null) {
            t = r.o.t();
            this.r.H(t * n2);
            j = n;
        }
        while (j < this.u.size()) {
            this.u.get(j).m(n2);
            ++j;
        }
    }
    
    @Override
    public void a() {
        this.A();
    }
    
    @Override
    public void b(final List<q1.c> list, final List<q1.c> list2) {
    }
    
    @Override
    public <T> void c(final T t, final z1.c<T> c) {
        this.v.c(t, c);
    }
    
    @Override
    public void d(final t1.d d, final int n, final List<t1.d> list, t1.d d2) {
        final a r = this.r;
        if (r != null) {
            final t1.d a = d2.a(r.getName());
            if (d.c(this.r.getName(), n)) {
                list.add(a.i(this.r));
            }
            if (d.h(this.getName(), n)) {
                this.r.D(d, d.e(this.r.getName(), n) + n, list, a);
            }
        }
        if (!d.g(this.getName(), n)) {
            return;
        }
        t1.d a2 = d2;
        if (!"__container".equals(this.getName())) {
            d2 = (a2 = d2.a(this.getName()));
            if (d.c(this.getName(), n)) {
                list.add(d2.i(this));
                a2 = d2;
            }
        }
        if (d.h(this.getName(), n)) {
            this.D(d, n + d.e(this.getName(), n), list, a2);
        }
    }
    
    @Override
    public void e(final RectF rectF, final Matrix matrix, final boolean b) {
        this.h.set(0.0f, 0.0f, 0.0f, 0.0f);
        this.r();
        this.m.set(matrix);
        if (b) {
            final List<a> t = this.t;
            if (t != null) {
                for (int i = t.size() - 1; i >= 0; --i) {
                    this.m.preConcat(this.t.get(i).v.f());
                }
            }
            else {
                final a s = this.s;
                if (s != null) {
                    this.m.preConcat(s.v.f());
                }
            }
        }
        this.m.preConcat(this.v.f());
    }
    
    @Override
    public void g(final Canvas canvas, final Matrix matrix, int n) {
        com.airbnb.lottie.c.a(this.l);
        if (!this.w || this.o.v()) {
            com.airbnb.lottie.c.b(this.l);
            return;
        }
        this.r();
        com.airbnb.lottie.c.a("Layer#parentMatrix");
        this.b.reset();
        this.b.set(matrix);
        for (int i = this.t.size() - 1; i >= 0; --i) {
            this.b.preConcat(this.t.get(i).v.f());
        }
        com.airbnb.lottie.c.b("Layer#parentMatrix");
        int intValue;
        if (this.v.h() == null) {
            intValue = 100;
        }
        else {
            intValue = this.v.h().h();
        }
        n = (int)(n / 255.0f * intValue / 100.0f * 255.0f);
        if (!this.x() && !this.w()) {
            this.b.preConcat(this.v.f());
            com.airbnb.lottie.c.a("Layer#drawLayer");
            this.t(canvas, this.b, n);
            com.airbnb.lottie.c.b("Layer#drawLayer");
            this.B(com.airbnb.lottie.c.b(this.l));
            return;
        }
        com.airbnb.lottie.c.a("Layer#computeBounds");
        this.e(this.h, this.b, false);
        this.z(this.h, matrix);
        this.b.preConcat(this.v.f());
        this.y(this.h, this.b);
        if (!this.h.intersect(0.0f, 0.0f, (float)canvas.getWidth(), (float)canvas.getHeight())) {
            this.h.set(0.0f, 0.0f, 0.0f, 0.0f);
        }
        com.airbnb.lottie.c.b("Layer#computeBounds");
        if (this.h.width() >= 1.0f && this.h.height() >= 1.0f) {
            com.airbnb.lottie.c.a("Layer#saveLayer");
            this.c.setAlpha(255);
            y1.h.m(canvas, this.h, this.c);
            com.airbnb.lottie.c.b("Layer#saveLayer");
            this.s(canvas);
            com.airbnb.lottie.c.a("Layer#drawLayer");
            this.t(canvas, this.b, n);
            com.airbnb.lottie.c.b("Layer#drawLayer");
            if (this.w()) {
                this.o(canvas, this.b);
            }
            if (this.x()) {
                com.airbnb.lottie.c.a("Layer#drawMatte");
                com.airbnb.lottie.c.a("Layer#saveLayer");
                y1.h.n(canvas, this.h, this.f, 19);
                com.airbnb.lottie.c.b("Layer#saveLayer");
                this.s(canvas);
                this.r.g(canvas, matrix, n);
                com.airbnb.lottie.c.a("Layer#restoreLayer");
                canvas.restore();
                com.airbnb.lottie.c.b("Layer#restoreLayer");
                com.airbnb.lottie.c.b("Layer#drawMatte");
            }
            com.airbnb.lottie.c.a("Layer#restoreLayer");
            canvas.restore();
            com.airbnb.lottie.c.b("Layer#restoreLayer");
        }
        if (this.x) {
            final Paint y = this.y;
            if (y != null) {
                y.setStyle(Paint$Style.STROKE);
                this.y.setColor(-251901);
                this.y.setStrokeWidth(4.0f);
                canvas.drawRect(this.h, this.y);
                this.y.setStyle(Paint$Style.FILL);
                this.y.setColor(1357638635);
                canvas.drawRect(this.h, this.y);
            }
        }
        this.B(com.airbnb.lottie.c.b(this.l));
    }
    
    @Override
    public String getName() {
        return this.o.g();
    }
    
    public void i(final r1.a<?, ?> a) {
        if (a == null) {
            return;
        }
        this.u.add(a);
    }
    
    abstract void t(final Canvas p0, final Matrix p1, final int p2);
    
    Layer v() {
        return this.o;
    }
    
    boolean w() {
        final g p = this.p;
        return p != null && !p.a().isEmpty();
    }
    
    boolean x() {
        return this.r != null;
    }
}
