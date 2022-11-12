// 
// Decompiled by Procyon v0.6.0
// 

package androidx.swiperefreshlayout.widget;

import android.graphics.Path$FillType;
import android.graphics.Paint$Style;
import android.graphics.Paint$Cap;
import android.graphics.Path;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.ColorFilter;
import android.graphics.Rect;
import android.graphics.Canvas;
import android.animation.Animator$AnimatorListener;
import android.animation.TimeInterpolator;
import android.animation.ValueAnimator$AnimatorUpdateListener;
import android.animation.ValueAnimator;
import androidx.core.util.h;
import android.content.Context;
import android.view.animation.LinearInterpolator;
import android.animation.Animator;
import android.content.res.Resources;
import android.view.animation.Interpolator;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;

public class b extends Drawable implements Animatable
{
    private static final Interpolator g;
    private static final Interpolator h;
    private static final int[] i;
    private final c a;
    private float b;
    private Resources c;
    private Animator d;
    float e;
    boolean f;
    
    static {
        g = (Interpolator)new LinearInterpolator();
        h = (Interpolator)new h0.b();
        i = new int[] { -16777216 };
    }
    
    public b(final Context context) {
        this.c = androidx.core.util.h.g(context).getResources();
        (this.a = new c()).u(androidx.swiperefreshlayout.widget.b.i);
        this.k(2.5f);
        this.m();
    }
    
    private void a(final float n, final c c) {
        this.n(n, c);
        final float n2 = (float)(Math.floor(c.j() / 0.8f) + 1.0);
        c.y(c.k() + (c.i() - 0.01f - c.k()) * n);
        c.v(c.i());
        c.w(c.j() + (n2 - c.j()) * n);
    }
    
    private int c(final float n, int n2, final int n3) {
        final int n4 = n2 >> 24 & 0xFF;
        final int n5 = n2 >> 16 & 0xFF;
        final int n6 = n2 >> 8 & 0xFF;
        n2 &= 0xFF;
        return n4 + (int)(((n3 >> 24 & 0xFF) - n4) * n) << 24 | n5 + (int)(((n3 >> 16 & 0xFF) - n5) * n) << 16 | n6 + (int)(((n3 >> 8 & 0xFF) - n6) * n) << 8 | n2 + (int)(n * ((n3 & 0xFF) - n2));
    }
    
    private void h(final float b) {
        this.b = b;
    }
    
    private void i(final float n, final float n2, final float n3, final float n4) {
        final c a = this.a;
        final float density = this.c.getDisplayMetrics().density;
        a.z(n2 * density);
        a.q(n * density);
        a.t(0);
        a.o(n3 * density, n4 * density);
    }
    
    private void m() {
        final c a = this.a;
        final ValueAnimator ofFloat = ValueAnimator.ofFloat(new float[] { 0.0f, 1.0f });
        ofFloat.addUpdateListener((ValueAnimator$AnimatorUpdateListener)new ValueAnimator$AnimatorUpdateListener(this, a) {
            final c a;
            final b b;
            
            public void onAnimationUpdate(final ValueAnimator valueAnimator) {
                final float floatValue = (float)valueAnimator.getAnimatedValue();
                this.b.n(floatValue, this.a);
                this.b.b(floatValue, this.a, false);
                this.b.invalidateSelf();
            }
        });
        ofFloat.setRepeatCount(-1);
        ofFloat.setRepeatMode(1);
        ofFloat.setInterpolator((TimeInterpolator)androidx.swiperefreshlayout.widget.b.g);
        ofFloat.addListener((Animator$AnimatorListener)new Animator$AnimatorListener(this, a) {
            final c a;
            final b b;
            
            public void onAnimationCancel(final Animator animator) {
            }
            
            public void onAnimationEnd(final Animator animator) {
            }
            
            public void onAnimationRepeat(final Animator animator) {
                this.b.b(1.0f, this.a, true);
                this.a.A();
                this.a.l();
                final b b = this.b;
                if (b.f) {
                    b.f = false;
                    animator.cancel();
                    animator.setDuration(1332L);
                    animator.start();
                    this.a.x(false);
                }
                else {
                    ++b.e;
                }
            }
            
            public void onAnimationStart(final Animator animator) {
                this.b.e = 0.0f;
            }
        });
        this.d = (Animator)ofFloat;
    }
    
    void b(final float n, final c c, final boolean b) {
        if (this.f) {
            this.a(n, c);
        }
        else if (n != 1.0f || b) {
            final float j = c.j();
            float k;
            float n3;
            if (n < 0.5f) {
                final float n2 = n / 0.5f;
                k = c.k();
                n3 = b.h.getInterpolation(n2) * 0.79f + 0.01f + k;
            }
            else {
                final float n4 = (n - 0.5f) / 0.5f;
                n3 = c.k() + 0.79f;
                k = n3 - ((1.0f - b.h.getInterpolation(n4)) * 0.79f + 0.01f);
            }
            final float e = this.e;
            c.y(k);
            c.v(n3);
            c.w(j + 0.20999998f * n);
            this.h((n + e) * 216.0f);
        }
    }
    
    public void d(final boolean b) {
        this.a.x(b);
        this.invalidateSelf();
    }
    
    public void draw(final Canvas canvas) {
        final Rect bounds = this.getBounds();
        canvas.save();
        canvas.rotate(this.b, bounds.exactCenterX(), bounds.exactCenterY());
        this.a.a(canvas, bounds);
        canvas.restore();
    }
    
    public void e(final float n) {
        this.a.p(n);
        this.invalidateSelf();
    }
    
    public void f(final int... array) {
        this.a.u(array);
        this.a.t(0);
        this.invalidateSelf();
    }
    
    public void g(final float n) {
        this.a.w(n);
        this.invalidateSelf();
    }
    
    public int getAlpha() {
        return this.a.c();
    }
    
    public int getOpacity() {
        return -3;
    }
    
    public boolean isRunning() {
        return this.d.isRunning();
    }
    
    public void j(final float n, final float n2) {
        this.a.y(n);
        this.a.v(n2);
        this.invalidateSelf();
    }
    
    public void k(final float n) {
        this.a.z(n);
        this.invalidateSelf();
    }
    
    public void l(final int n) {
        if (n == 0) {
            this.i(11.0f, 3.0f, 12.0f, 6.0f);
        }
        else {
            this.i(7.5f, 2.5f, 10.0f, 5.0f);
        }
        this.invalidateSelf();
    }
    
    void n(final float n, final c c) {
        if (n > 0.75f) {
            c.r(this.c((n - 0.75f) / 0.25f, c.h(), c.e()));
        }
        else {
            c.r(c.h());
        }
    }
    
    public void setAlpha(final int n) {
        this.a.n(n);
        this.invalidateSelf();
    }
    
    public void setColorFilter(final ColorFilter colorFilter) {
        this.a.s(colorFilter);
        this.invalidateSelf();
    }
    
    public void start() {
        this.d.cancel();
        this.a.A();
        if (this.a.d() != this.a.g()) {
            this.f = true;
            this.d.setDuration(666L);
            this.d.start();
        }
        else {
            this.a.t(0);
            this.a.m();
            this.d.setDuration(1332L);
            this.d.start();
        }
    }
    
    public void stop() {
        this.d.cancel();
        this.h(0.0f);
        this.a.x(false);
        this.a.t(0);
        this.a.m();
        this.invalidateSelf();
    }
    
    private static class c
    {
        final RectF a;
        final Paint b;
        final Paint c;
        final Paint d;
        float e;
        float f;
        float g;
        float h;
        int[] i;
        int j;
        float k;
        float l;
        float m;
        boolean n;
        Path o;
        float p;
        float q;
        int r;
        int s;
        int t;
        int u;
        
        c() {
            this.a = new RectF();
            final Paint b = new Paint();
            this.b = b;
            final Paint c = new Paint();
            this.c = c;
            final Paint d = new Paint();
            this.d = d;
            this.e = 0.0f;
            this.f = 0.0f;
            this.g = 0.0f;
            this.h = 5.0f;
            this.p = 1.0f;
            this.t = 255;
            b.setStrokeCap(Paint$Cap.SQUARE);
            b.setAntiAlias(true);
            b.setStyle(Paint$Style.STROKE);
            c.setStyle(Paint$Style.FILL);
            c.setAntiAlias(true);
            d.setColor(0);
        }
        
        void A() {
            this.k = this.e;
            this.l = this.f;
            this.m = this.g;
        }
        
        void a(final Canvas canvas, final Rect rect) {
            final RectF a = this.a;
            final float q = this.q;
            float n = this.h / 2.0f + q;
            if (q <= 0.0f) {
                n = Math.min(rect.width(), rect.height()) / 2.0f - Math.max(this.r * this.p / 2.0f, this.h / 2.0f);
            }
            a.set(rect.centerX() - n, rect.centerY() - n, rect.centerX() + n, rect.centerY() + n);
            final float e = this.e;
            final float g = this.g;
            final float n2 = (e + g) * 360.0f;
            final float n3 = (this.f + g) * 360.0f - n2;
            this.b.setColor(this.u);
            this.b.setAlpha(this.t);
            final float n4 = this.h / 2.0f;
            a.inset(n4, n4);
            canvas.drawCircle(a.centerX(), a.centerY(), a.width() / 2.0f, this.d);
            final float n5 = -n4;
            a.inset(n5, n5);
            canvas.drawArc(a, n2, n3, false, this.b);
            this.b(canvas, n2, n3, a);
        }
        
        void b(final Canvas canvas, final float n, final float n2, final RectF rectF) {
            if (this.n) {
                final Path o = this.o;
                if (o == null) {
                    (this.o = new Path()).setFillType(Path$FillType.EVEN_ODD);
                }
                else {
                    o.reset();
                }
                final float n3 = Math.min(rectF.width(), rectF.height()) / 2.0f;
                final float n4 = this.r * this.p / 2.0f;
                this.o.moveTo(0.0f, 0.0f);
                this.o.lineTo(this.r * this.p, 0.0f);
                final Path o2 = this.o;
                final float n5 = (float)this.r;
                final float p4 = this.p;
                o2.lineTo(n5 * p4 / 2.0f, this.s * p4);
                this.o.offset(n3 + rectF.centerX() - n4, rectF.centerY() + this.h / 2.0f);
                this.o.close();
                this.c.setColor(this.u);
                this.c.setAlpha(this.t);
                canvas.save();
                canvas.rotate(n + n2, rectF.centerX(), rectF.centerY());
                canvas.drawPath(this.o, this.c);
                canvas.restore();
            }
        }
        
        int c() {
            return this.t;
        }
        
        float d() {
            return this.f;
        }
        
        int e() {
            return this.i[this.f()];
        }
        
        int f() {
            return (this.j + 1) % this.i.length;
        }
        
        float g() {
            return this.e;
        }
        
        int h() {
            return this.i[this.j];
        }
        
        float i() {
            return this.l;
        }
        
        float j() {
            return this.m;
        }
        
        float k() {
            return this.k;
        }
        
        void l() {
            this.t(this.f());
        }
        
        void m() {
            this.k = 0.0f;
            this.l = 0.0f;
            this.y(this.m = 0.0f);
            this.v(0.0f);
            this.w(0.0f);
        }
        
        void n(final int t) {
            this.t = t;
        }
        
        void o(final float n, final float n2) {
            this.r = (int)n;
            this.s = (int)n2;
        }
        
        void p(final float p) {
            if (p != this.p) {
                this.p = p;
            }
        }
        
        void q(final float q) {
            this.q = q;
        }
        
        void r(final int u) {
            this.u = u;
        }
        
        void s(final ColorFilter colorFilter) {
            this.b.setColorFilter(colorFilter);
        }
        
        void t(final int j) {
            this.j = j;
            this.u = this.i[j];
        }
        
        void u(final int[] i) {
            this.i = i;
            this.t(0);
        }
        
        void v(final float f) {
            this.f = f;
        }
        
        void w(final float g) {
            this.g = g;
        }
        
        void x(final boolean n) {
            if (this.n != n) {
                this.n = n;
            }
        }
        
        void y(final float e) {
            this.e = e;
        }
        
        void z(final float n) {
            this.h = n;
            this.b.setStrokeWidth(n);
        }
    }
}
