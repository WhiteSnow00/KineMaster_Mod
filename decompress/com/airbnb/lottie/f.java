// 
// Decompiled by Procyon v0.6.0
// 

package com.airbnb.lottie;

import android.graphics.Bitmap;
import android.graphics.ColorFilter;
import z1.c;
import android.animation.Animator$AnimatorListener;
import t1.g;
import java.util.Iterator;
import android.widget.ImageView;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import android.graphics.Typeface;
import android.view.View;
import android.content.Context;
import android.graphics.Canvas;
import x1.s;
import android.graphics.Rect;
import android.animation.ValueAnimator;
import s1.a;
import android.animation.ValueAnimator$AnimatorUpdateListener;
import java.util.ArrayList;
import y1.e;
import android.graphics.Matrix;
import com.airbnb.lottie.model.layer.b;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable$Callback;
import android.graphics.drawable.Drawable;

public class f extends Drawable implements Drawable$Callback, Animatable
{
    private b A;
    private int B;
    private boolean C;
    private boolean D;
    private boolean E;
    private boolean F;
    private boolean G;
    private final Matrix a;
    private d b;
    private final e c;
    private float d;
    private boolean e;
    private boolean f;
    private final ArrayList<o> g;
    private final ValueAnimator$AnimatorUpdateListener h;
    private s1.b i;
    private String j;
    private com.airbnb.lottie.b p;
    private a w;
    com.airbnb.lottie.a x;
    r y;
    private boolean z;
    
    public f() {
        this.a = new Matrix();
        final e c = new e();
        this.c = c;
        this.d = 1.0f;
        this.e = true;
        this.f = false;
        this.g = new ArrayList<o>();
        final ValueAnimator$AnimatorUpdateListener h = (ValueAnimator$AnimatorUpdateListener)new ValueAnimator$AnimatorUpdateListener() {
            final f a;
            
            public void onAnimationUpdate(final ValueAnimator valueAnimator) {
                if (com.airbnb.lottie.f.a(this.a) != null) {
                    com.airbnb.lottie.f.a(this.a).H(com.airbnb.lottie.f.b(this.a).i());
                }
            }
        };
        this.h = (ValueAnimator$AnimatorUpdateListener)h;
        this.B = 255;
        this.F = true;
        this.G = false;
        c.addUpdateListener((ValueAnimator$AnimatorUpdateListener)h);
    }
    
    static b a(final f f) {
        return f.A;
    }
    
    static e b(final f f) {
        return f.c;
    }
    
    private float e(final Rect rect) {
        return rect.width() / (float)rect.height();
    }
    
    private boolean f() {
        final d b = this.b;
        boolean b3;
        final boolean b2 = b3 = true;
        if (b != null) {
            if (this.getBounds().isEmpty()) {
                b3 = b2;
            }
            else {
                b3 = (this.e(this.getBounds()) == this.e(b.b()) && b2);
            }
        }
        return b3;
    }
    
    private void g() {
        final b a = new b(this, s.a(this.b), this.b.j(), this.b);
        this.A = a;
        if (this.D) {
            a.F(true);
        }
    }
    
    private void j(final Canvas canvas) {
        if (!this.f()) {
            this.k(canvas);
        }
        else {
            this.l(canvas);
        }
    }
    
    private void k(final Canvas canvas) {
        if (this.A == null) {
            return;
        }
        final int n = -1;
        final Rect bounds = this.getBounds();
        float n2 = bounds.width() / (float)this.b.b().width();
        float n3 = bounds.height() / (float)this.b.b().height();
        int save = n;
        float n4 = n2;
        float n5 = n3;
        if (this.F) {
            final float min = Math.min(n2, n3);
            float n6;
            if (min < 1.0f) {
                n6 = 1.0f / min;
                n2 /= n6;
                n3 /= n6;
            }
            else {
                n6 = 1.0f;
            }
            save = n;
            n4 = n2;
            n5 = n3;
            if (n6 > 1.0f) {
                save = canvas.save();
                final float n7 = bounds.width() / 2.0f;
                final float n8 = bounds.height() / 2.0f;
                final float n9 = n7 * min;
                final float n10 = min * n8;
                canvas.translate(n7 - n9, n8 - n10);
                canvas.scale(n6, n6, n9, n10);
                n5 = n3;
                n4 = n2;
            }
        }
        this.a.reset();
        this.a.preScale(n4, n5);
        this.A.g(canvas, this.a, this.B);
        if (save > 0) {
            canvas.restoreToCount(save);
        }
    }
    
    private void l(final Canvas canvas) {
        if (this.A == null) {
            return;
        }
        final float d = this.d;
        float x = this.x(canvas);
        float n;
        if (d > x) {
            n = this.d / x;
        }
        else {
            x = d;
            n = 1.0f;
        }
        int save = -1;
        if (n > 1.0f) {
            save = canvas.save();
            final float n2 = this.b.b().width() / 2.0f;
            final float n3 = this.b.b().height() / 2.0f;
            final float n4 = n2 * x;
            final float n5 = n3 * x;
            canvas.translate(this.D() * n2 - n4, this.D() * n3 - n5);
            canvas.scale(n, n, n4, n5);
        }
        this.a.reset();
        this.a.preScale(x, x);
        this.A.g(canvas, this.a, this.B);
        if (save > 0) {
            canvas.restoreToCount(save);
        }
    }
    
    private Context q() {
        final Drawable$Callback callback = this.getCallback();
        if (callback == null) {
            return null;
        }
        if (callback instanceof View) {
            return ((View)callback).getContext();
        }
        return null;
    }
    
    private a r() {
        if (this.getCallback() == null) {
            return null;
        }
        if (this.w == null) {
            this.w = new a(this.getCallback(), this.x);
        }
        return this.w;
    }
    
    private s1.b u() {
        if (this.getCallback() == null) {
            return null;
        }
        final s1.b i = this.i;
        if (i != null && !i.b(this.q())) {
            this.i = null;
        }
        if (this.i == null) {
            this.i = new s1.b(this.getCallback(), this.j, this.p, this.b.i());
        }
        return this.i;
    }
    
    private float x(final Canvas canvas) {
        return Math.min(canvas.getWidth() / (float)this.b.b().width(), canvas.getHeight() / (float)this.b.b().height());
    }
    
    public float A() {
        return this.c.i();
    }
    
    public int B() {
        return this.c.getRepeatCount();
    }
    
    public int C() {
        return this.c.getRepeatMode();
    }
    
    public float D() {
        return this.d;
    }
    
    public float E() {
        return this.c.o();
    }
    
    public r F() {
        return this.y;
    }
    
    public Typeface G(final String s, final String s2) {
        final a r = this.r();
        if (r != null) {
            return r.b(s, s2);
        }
        return null;
    }
    
    public boolean H() {
        final e c = this.c;
        return c != null && c.isRunning();
    }
    
    public boolean I() {
        return this.E;
    }
    
    public void J() {
        this.g.clear();
        this.c.q();
    }
    
    public void K() {
        if (this.A == null) {
            this.g.add((o)new o(this) {
                final f a;
                
                @Override
                public void a(final d d) {
                    this.a.K();
                }
            });
            return;
        }
        if (this.e || this.B() == 0) {
            this.c.r();
        }
        if (!this.e) {
            float n;
            if (this.E() < 0.0f) {
                n = this.y();
            }
            else {
                n = this.w();
            }
            this.Q((int)n);
            this.c.h();
        }
    }
    
    public List<t1.d> L(final t1.d d) {
        if (this.A == null) {
            y1.d.c("Cannot resolve KeyPath. Composition is not set yet.");
            return Collections.emptyList();
        }
        final ArrayList list = new ArrayList();
        this.A.d(d, 0, list, new t1.d(new String[0]));
        return list;
    }
    
    public void M() {
        if (this.A == null) {
            this.g.add((o)new o(this) {
                final f a;
                
                @Override
                public void a(final d d) {
                    this.a.M();
                }
            });
            return;
        }
        if (this.e || this.B() == 0) {
            this.c.x();
        }
        if (!this.e) {
            float n;
            if (this.E() < 0.0f) {
                n = this.y();
            }
            else {
                n = this.w();
            }
            this.Q((int)n);
            this.c.h();
        }
    }
    
    public void N(final boolean e) {
        this.E = e;
    }
    
    public boolean O(final d b) {
        if (this.b == b) {
            return false;
        }
        this.G = false;
        this.i();
        this.b = b;
        this.g();
        this.c.z(b);
        this.d0(this.c.getAnimatedFraction());
        this.h0(this.d);
        final Iterator iterator = new ArrayList(this.g).iterator();
        while (iterator.hasNext()) {
            final o o = (o)iterator.next();
            if (o != null) {
                o.a(b);
            }
            iterator.remove();
        }
        this.g.clear();
        b.u(this.C);
        final Drawable$Callback callback = this.getCallback();
        if (callback instanceof ImageView) {
            final ImageView imageView = (ImageView)callback;
            imageView.setImageDrawable((Drawable)null);
            imageView.setImageDrawable((Drawable)this);
        }
        return true;
    }
    
    public void P(final com.airbnb.lottie.a x) {
        this.x = x;
        final a w = this.w;
        if (w != null) {
            w.c(x);
        }
    }
    
    public void Q(final int n) {
        if (this.b == null) {
            this.g.add((o)new o(this, n) {
                final int a;
                final f b;
                
                @Override
                public void a(final d d) {
                    this.b.Q(this.a);
                }
            });
            return;
        }
        this.c.A((float)n);
    }
    
    public void R(final com.airbnb.lottie.b p) {
        this.p = p;
        final s1.b i = this.i;
        if (i != null) {
            i.d(p);
        }
    }
    
    public void S(final String j) {
        this.j = j;
    }
    
    public void T(final int n) {
        if (this.b == null) {
            this.g.add((o)new o(this, n) {
                final int a;
                final f b;
                
                @Override
                public void a(final d d) {
                    this.b.T(this.a);
                }
            });
            return;
        }
        this.c.B(n + 0.99f);
    }
    
    public void U(final String s) {
        final d b = this.b;
        if (b == null) {
            this.g.add((o)new o(this, s) {
                final String a;
                final f b;
                
                @Override
                public void a(final d d) {
                    this.b.U(this.a);
                }
            });
            return;
        }
        final g k = b.k(s);
        if (k != null) {
            this.T((int)(k.b + k.c));
            return;
        }
        final StringBuilder sb = new StringBuilder();
        sb.append("Cannot find marker with name ");
        sb.append(s);
        sb.append(".");
        throw new IllegalArgumentException(sb.toString());
    }
    
    public void V(final float n) {
        final d b = this.b;
        if (b == null) {
            this.g.add((o)new o(this, n) {
                final float a;
                final f b;
                
                @Override
                public void a(final d d) {
                    this.b.V(this.a);
                }
            });
            return;
        }
        this.T((int)y1.g.k(b.o(), this.b.f(), n));
    }
    
    public void W(final int n, final int n2) {
        if (this.b == null) {
            this.g.add((o)new o(this, n, n2) {
                final int a;
                final int b;
                final f c;
                
                @Override
                public void a(final d d) {
                    this.c.W(this.a, this.b);
                }
            });
            return;
        }
        this.c.C((float)n, n2 + 0.99f);
    }
    
    public void X(final String s) {
        final d b = this.b;
        if (b == null) {
            this.g.add((o)new o(this, s) {
                final String a;
                final f b;
                
                @Override
                public void a(final d d) {
                    this.b.X(this.a);
                }
            });
            return;
        }
        final g k = b.k(s);
        if (k != null) {
            final int n = (int)k.b;
            this.W(n, (int)k.c + n);
            return;
        }
        final StringBuilder sb = new StringBuilder();
        sb.append("Cannot find marker with name ");
        sb.append(s);
        sb.append(".");
        throw new IllegalArgumentException(sb.toString());
    }
    
    public void Y(final int n) {
        if (this.b == null) {
            this.g.add((o)new o(this, n) {
                final int a;
                final f b;
                
                @Override
                public void a(final d d) {
                    this.b.Y(this.a);
                }
            });
            return;
        }
        this.c.D(n);
    }
    
    public void Z(final String s) {
        final d b = this.b;
        if (b == null) {
            this.g.add((o)new o(this, s) {
                final String a;
                final f b;
                
                @Override
                public void a(final d d) {
                    this.b.Z(this.a);
                }
            });
            return;
        }
        final g k = b.k(s);
        if (k != null) {
            this.Y((int)k.b);
            return;
        }
        final StringBuilder sb = new StringBuilder();
        sb.append("Cannot find marker with name ");
        sb.append(s);
        sb.append(".");
        throw new IllegalArgumentException(sb.toString());
    }
    
    public void a0(final float n) {
        final d b = this.b;
        if (b == null) {
            this.g.add((o)new o(this, n) {
                final float a;
                final f b;
                
                @Override
                public void a(final d d) {
                    this.b.a0(this.a);
                }
            });
            return;
        }
        this.Y((int)y1.g.k(b.o(), this.b.f(), n));
    }
    
    public void b0(final boolean d) {
        if (this.D == d) {
            return;
        }
        this.D = d;
        final b a = this.A;
        if (a != null) {
            a.F(d);
        }
    }
    
    public void c(final Animator$AnimatorListener animator$AnimatorListener) {
        this.c.addListener(animator$AnimatorListener);
    }
    
    public void c0(final boolean c) {
        this.C = c;
        final d b = this.b;
        if (b != null) {
            b.u(c);
        }
    }
    
    public <T> void d(final t1.d d, final T t, final c<T> c) {
        final b a = this.A;
        if (a == null) {
            this.g.add((o)new o(this, d, t, c) {
                final t1.d a;
                final Object b;
                final c c;
                final f d;
                
                @Override
                public void a(final d d) {
                    this.d.d(this.a, this.b, this.c);
                }
            });
            return;
        }
        final t1.d c2 = t1.d.c;
        boolean b = true;
        if (d == c2) {
            a.c(t, c);
        }
        else if (d.d() != null) {
            d.d().c(t, c);
        }
        else {
            final List<t1.d> l = this.L(d);
            for (int i = 0; i < l.size(); ++i) {
                ((t1.d)l.get(i)).d().c(t, c);
            }
            b = (true ^ l.isEmpty());
        }
        if (b) {
            this.invalidateSelf();
            if (t == k.C) {
                this.d0(this.A());
            }
        }
    }
    
    public void d0(final float n) {
        if (this.b == null) {
            this.g.add((o)new o(this, n) {
                final float a;
                final f b;
                
                @Override
                public void a(final d d) {
                    this.b.d0(this.a);
                }
            });
            return;
        }
        com.airbnb.lottie.c.a("Drawable#setProgress");
        this.c.A(y1.g.k(this.b.o(), this.b.f(), n));
        com.airbnb.lottie.c.b("Drawable#setProgress");
    }
    
    public void draw(final Canvas canvas) {
        this.G = false;
        com.airbnb.lottie.c.a("Drawable#draw");
        if (this.f) {
            try {
                this.j(canvas);
            }
            finally {
                final Throwable t;
                y1.d.b("Lottie crashed in draw!", t);
            }
        }
        else {
            this.j(canvas);
        }
        com.airbnb.lottie.c.b("Drawable#draw");
    }
    
    public void e0(final int repeatCount) {
        this.c.setRepeatCount(repeatCount);
    }
    
    public void f0(final int repeatMode) {
        this.c.setRepeatMode(repeatMode);
    }
    
    public void g0(final boolean f) {
        this.f = f;
    }
    
    public int getAlpha() {
        return this.B;
    }
    
    public int getIntrinsicHeight() {
        final d b = this.b;
        int n;
        if (b == null) {
            n = -1;
        }
        else {
            n = (int)(b.b().height() * this.D());
        }
        return n;
    }
    
    public int getIntrinsicWidth() {
        final d b = this.b;
        int n;
        if (b == null) {
            n = -1;
        }
        else {
            n = (int)(b.b().width() * this.D());
        }
        return n;
    }
    
    public int getOpacity() {
        return -3;
    }
    
    public void h() {
        this.g.clear();
        this.c.cancel();
    }
    
    public void h0(final float d) {
        this.d = d;
    }
    
    public void i() {
        if (this.c.isRunning()) {
            this.c.cancel();
        }
        this.b = null;
        this.A = null;
        this.i = null;
        this.c.g();
        this.invalidateSelf();
    }
    
    public void i0(final float n) {
        this.c.E(n);
    }
    
    public void invalidateDrawable(final Drawable drawable) {
        final Drawable$Callback callback = this.getCallback();
        if (callback == null) {
            return;
        }
        callback.invalidateDrawable((Drawable)this);
    }
    
    public void invalidateSelf() {
        if (this.G) {
            return;
        }
        this.G = true;
        final Drawable$Callback callback = this.getCallback();
        if (callback != null) {
            callback.invalidateDrawable((Drawable)this);
        }
    }
    
    public boolean isRunning() {
        return this.H();
    }
    
    void j0(final Boolean b) {
        this.e = b;
    }
    
    public void k0(final r y) {
        this.y = y;
    }
    
    public boolean l0() {
        return this.y == null && this.b.c().q() > 0;
    }
    
    public void m(final boolean z) {
        if (this.z == z) {
            return;
        }
        this.z = z;
        if (this.b != null) {
            this.g();
        }
    }
    
    public boolean n() {
        return this.z;
    }
    
    public void o() {
        this.g.clear();
        this.c.h();
    }
    
    public d p() {
        return this.b;
    }
    
    public int s() {
        return (int)this.c.j();
    }
    
    public void scheduleDrawable(final Drawable drawable, final Runnable runnable, final long n) {
        final Drawable$Callback callback = this.getCallback();
        if (callback == null) {
            return;
        }
        callback.scheduleDrawable((Drawable)this, runnable, n);
    }
    
    public void setAlpha(final int b) {
        this.B = b;
        this.invalidateSelf();
    }
    
    public void setColorFilter(final ColorFilter colorFilter) {
        y1.d.c("Use addColorFilter instead.");
    }
    
    public void start() {
        final Drawable$Callback callback = this.getCallback();
        if (callback instanceof View && !((View)callback).isInEditMode()) {
            this.K();
        }
    }
    
    public void stop() {
        this.o();
    }
    
    public Bitmap t(final String s) {
        final s1.b u = this.u();
        if (u != null) {
            return u.a(s);
        }
        return null;
    }
    
    public void unscheduleDrawable(final Drawable drawable, final Runnable runnable) {
        final Drawable$Callback callback = this.getCallback();
        if (callback == null) {
            return;
        }
        callback.unscheduleDrawable((Drawable)this, runnable);
    }
    
    public String v() {
        return this.j;
    }
    
    public float w() {
        return this.c.m();
    }
    
    public float y() {
        return this.c.n();
    }
    
    public n z() {
        final d b = this.b;
        if (b != null) {
            return b.m();
        }
        return null;
    }
    
    private interface o
    {
        void a(final d p0);
    }
}
