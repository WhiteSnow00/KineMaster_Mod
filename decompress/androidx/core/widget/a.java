// 
// Decompiled by Procyon v0.6.0
// 

package androidx.core.widget;

import android.view.animation.AnimationUtils;
import android.view.MotionEvent;
import android.os.SystemClock;
import androidx.core.view.b0;
import android.content.res.Resources;
import android.view.animation.AccelerateInterpolator;
import android.view.ViewConfiguration;
import android.view.View;
import android.view.animation.Interpolator;
import android.view.View$OnTouchListener;

public abstract class a implements View$OnTouchListener
{
    private static final int C;
    private boolean A;
    private boolean B;
    final a a;
    private final Interpolator b;
    final View c;
    private Runnable d;
    private float[] e;
    private float[] f;
    private int g;
    private int h;
    private float[] i;
    private float[] j;
    private float[] p;
    private boolean w;
    boolean x;
    boolean y;
    boolean z;
    
    static {
        C = ViewConfiguration.getTapTimeout();
    }
    
    public a(final View c) {
        this.a = new a();
        this.b = (Interpolator)new AccelerateInterpolator();
        this.e = new float[] { 0.0f, 0.0f };
        this.f = new float[] { Float.MAX_VALUE, Float.MAX_VALUE };
        this.i = new float[] { 0.0f, 0.0f };
        this.j = new float[] { 0.0f, 0.0f };
        this.p = new float[] { Float.MAX_VALUE, Float.MAX_VALUE };
        this.c = c;
        final float density = Resources.getSystem().getDisplayMetrics().density;
        final int n = (int)(1575.0f * density + 0.5f);
        final int n2 = (int)(density * 315.0f + 0.5f);
        final float n3 = (float)n;
        this.o(n3, n3);
        final float n4 = (float)n2;
        this.p(n4, n4);
        this.l(1);
        this.n(Float.MAX_VALUE, Float.MAX_VALUE);
        this.s(0.2f, 0.2f);
        this.t(1.0f, 1.0f);
        this.k(androidx.core.widget.a.C);
        this.r(500);
        this.q(500);
    }
    
    private float d(final int n, float n2, float h, float n3) {
        h = this.h(this.e[n], h, this.f[n], n2);
        final float n4 = fcmpl(h, 0.0f);
        if (n4 == 0) {
            return 0.0f;
        }
        final float n5 = this.i[n];
        n2 = this.j[n];
        final float n6 = this.p[n];
        n3 *= n5;
        if (n4 > 0) {
            return e(h * n3, n2, n6);
        }
        return -e(-h * n3, n2, n6);
    }
    
    static float e(final float n, final float n2, final float n3) {
        if (n > n3) {
            return n3;
        }
        if (n < n2) {
            return n2;
        }
        return n;
    }
    
    static int f(final int n, final int n2, final int n3) {
        if (n > n3) {
            return n3;
        }
        if (n < n2) {
            return n2;
        }
        return n;
    }
    
    private float g(final float n, final float n2) {
        if (n2 == 0.0f) {
            return 0.0f;
        }
        final int g = this.g;
        if (g != 0 && g != 1) {
            if (g == 2) {
                if (n < 0.0f) {
                    return n / -n2;
                }
            }
        }
        else if (n < n2) {
            if (n >= 0.0f) {
                return 1.0f - n / n2;
            }
            if (this.z && g == 1) {
                return 1.0f;
            }
        }
        return 0.0f;
    }
    
    private float h(float n, final float n2, float e, final float n3) {
        e = e(n * n2, 0.0f, e);
        n = this.g(n3, e);
        n = this.g(n2 - n3, e) - n;
        if (n < 0.0f) {
            n = -this.b.getInterpolation(-n);
        }
        else {
            if (n <= 0.0f) {
                return 0.0f;
            }
            n = this.b.getInterpolation(n);
        }
        return e(n, -1.0f, 1.0f);
    }
    
    private void i() {
        if (this.x) {
            this.z = false;
        }
        else {
            this.a.i();
        }
    }
    
    private void v() {
        if (this.d == null) {
            this.d = new b();
        }
        this.z = true;
        this.x = true;
        Label_0070: {
            if (!this.w) {
                final int h = this.h;
                if (h > 0) {
                    b0.i0(this.c, this.d, h);
                    break Label_0070;
                }
            }
            this.d.run();
        }
        this.w = true;
    }
    
    public abstract boolean a(final int p0);
    
    public abstract boolean b(final int p0);
    
    void c() {
        final long uptimeMillis = SystemClock.uptimeMillis();
        final MotionEvent obtain = MotionEvent.obtain(uptimeMillis, uptimeMillis, 3, 0.0f, 0.0f, 0);
        this.c.onTouchEvent(obtain);
        obtain.recycle();
    }
    
    public abstract void j(final int p0, final int p1);
    
    public a k(final int h) {
        this.h = h;
        return this;
    }
    
    public a l(final int g) {
        this.g = g;
        return this;
    }
    
    public a m(final boolean a) {
        if (this.A && !a) {
            this.i();
        }
        this.A = a;
        return this;
    }
    
    public a n(final float n, final float n2) {
        final float[] f = this.f;
        f[0] = n;
        f[1] = n2;
        return this;
    }
    
    public a o(final float n, final float n2) {
        final float[] p2 = this.p;
        p2[0] = n / 1000.0f;
        p2[1] = n2 / 1000.0f;
        return this;
    }
    
    public boolean onTouch(final View view, final MotionEvent motionEvent) {
        final boolean a = this.A;
        final boolean b = false;
        if (!a) {
            return false;
        }
        final int actionMasked = motionEvent.getActionMasked();
        Label_0140: {
            Label_0065: {
                if (actionMasked != 0) {
                    if (actionMasked != 1) {
                        if (actionMasked == 2) {
                            break Label_0065;
                        }
                        if (actionMasked != 3) {
                            break Label_0140;
                        }
                    }
                    this.i();
                    break Label_0140;
                }
                this.y = true;
                this.w = false;
            }
            this.a.l(this.d(0, motionEvent.getX(), (float)view.getWidth(), (float)this.c.getWidth()), this.d(1, motionEvent.getY(), (float)view.getHeight(), (float)this.c.getHeight()));
            if (!this.z && this.u()) {
                this.v();
            }
        }
        boolean b2 = b;
        if (this.B) {
            b2 = b;
            if (this.z) {
                b2 = true;
            }
        }
        return b2;
    }
    
    public a p(final float n, final float n2) {
        final float[] j = this.j;
        j[0] = n / 1000.0f;
        j[1] = n2 / 1000.0f;
        return this;
    }
    
    public a q(final int n) {
        this.a.j(n);
        return this;
    }
    
    public a r(final int n) {
        this.a.k(n);
        return this;
    }
    
    public a s(final float n, final float n2) {
        final float[] e = this.e;
        e[0] = n;
        e[1] = n2;
        return this;
    }
    
    public a t(final float n, final float n2) {
        final float[] i = this.i;
        i[0] = n / 1000.0f;
        i[1] = n2 / 1000.0f;
        return this;
    }
    
    boolean u() {
        final a a = this.a;
        final int f = a.f();
        final int d = a.d();
        return (f != 0 && this.b(f)) || (d != 0 && this.a(d));
    }
    
    private static class a
    {
        private int a;
        private int b;
        private float c;
        private float d;
        private long e;
        private long f;
        private int g;
        private int h;
        private long i;
        private float j;
        private int k;
        
        a() {
            this.e = Long.MIN_VALUE;
            this.i = -1L;
            this.f = 0L;
            this.g = 0;
            this.h = 0;
        }
        
        private float e(final long n) {
            final long e = this.e;
            if (n < e) {
                return 0.0f;
            }
            final long i = this.i;
            if (i >= 0L && n >= i) {
                final float j = this.j;
                return 1.0f - j + j * androidx.core.widget.a.e((n - i) / (float)this.k, 0.0f, 1.0f);
            }
            return androidx.core.widget.a.e((n - e) / (float)this.a, 0.0f, 1.0f) * 0.5f;
        }
        
        private float g(final float n) {
            return -4.0f * n * n + n * 4.0f;
        }
        
        public void a() {
            if (this.f != 0L) {
                final long currentAnimationTimeMillis = AnimationUtils.currentAnimationTimeMillis();
                final float g = this.g(this.e(currentAnimationTimeMillis));
                final long f = this.f;
                this.f = currentAnimationTimeMillis;
                final float n = (currentAnimationTimeMillis - f) * g;
                this.g = (int)(this.c * n);
                this.h = (int)(n * this.d);
                return;
            }
            throw new RuntimeException("Cannot compute scroll delta before calling start()");
        }
        
        public int b() {
            return this.g;
        }
        
        public int c() {
            return this.h;
        }
        
        public int d() {
            final float c = this.c;
            return (int)(c / Math.abs(c));
        }
        
        public int f() {
            final float d = this.d;
            return (int)(d / Math.abs(d));
        }
        
        public boolean h() {
            return this.i > 0L && AnimationUtils.currentAnimationTimeMillis() > this.i + this.k;
        }
        
        public void i() {
            final long currentAnimationTimeMillis = AnimationUtils.currentAnimationTimeMillis();
            this.k = androidx.core.widget.a.f((int)(currentAnimationTimeMillis - this.e), 0, this.b);
            this.j = this.e(currentAnimationTimeMillis);
            this.i = currentAnimationTimeMillis;
        }
        
        public void j(final int b) {
            this.b = b;
        }
        
        public void k(final int a) {
            this.a = a;
        }
        
        public void l(final float c, final float d) {
            this.c = c;
            this.d = d;
        }
        
        public void m() {
            final long currentAnimationTimeMillis = AnimationUtils.currentAnimationTimeMillis();
            this.e = currentAnimationTimeMillis;
            this.i = -1L;
            this.f = currentAnimationTimeMillis;
            this.j = 0.5f;
            this.g = 0;
            this.h = 0;
        }
    }
    
    private class b implements Runnable
    {
        final a a;
        
        b(final a a) {
            this.a = a;
        }
        
        @Override
        public void run() {
            final a a = this.a;
            if (!a.z) {
                return;
            }
            if (a.x) {
                a.x = false;
                a.a.m();
            }
            final a a2 = this.a.a;
            if (!a2.h() && this.a.u()) {
                final a a3 = this.a;
                if (a3.y) {
                    a3.y = false;
                    a3.c();
                }
                a2.a();
                this.a.j(a2.b(), a2.c());
                b0.h0(this.a.c, this);
                return;
            }
            this.a.z = false;
        }
    }
}
