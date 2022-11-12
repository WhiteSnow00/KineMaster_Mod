// 
// Decompiled by Procyon v0.6.0
// 

package f3;

import android.animation.Animator;
import android.graphics.ColorFilter;
import d3.a;
import android.graphics.Canvas;
import d3.b;
import d3.c;
import android.animation.ValueAnimator;
import android.graphics.Matrix;
import android.graphics.Camera;
import android.util.Property;
import android.graphics.Rect;
import android.graphics.drawable.Drawable$Callback;
import android.graphics.drawable.Animatable;
import android.animation.ValueAnimator$AnimatorUpdateListener;
import android.graphics.drawable.Drawable;

public abstract class f extends Drawable implements ValueAnimator$AnimatorUpdateListener, Animatable, Drawable$Callback
{
    private static final Rect D;
    public static final Property<f, Integer> E;
    public static final Property<f, Integer> F;
    public static final Property<f, Integer> G;
    public static final Property<f, Integer> H;
    public static final Property<f, Integer> I;
    public static final Property<f, Float> J;
    public static final Property<f, Float> K;
    public static final Property<f, Float> L;
    public static final Property<f, Float> M;
    public static final Property<f, Float> N;
    public static final Property<f, Integer> O;
    protected Rect A;
    private Camera B;
    private Matrix C;
    private float a;
    private float b;
    private float c;
    private float d;
    private float e;
    private int f;
    private int g;
    private int h;
    private int i;
    private int j;
    private int p;
    private float w;
    private float x;
    private ValueAnimator y;
    private int z;
    
    static {
        D = new Rect();
        E = new c<f>("rotateX") {
            @Override
            public /* bridge */ void b(final Object o, final int n) {
                this.d((f)o, n);
            }
            
            public Integer c(final f f) {
                return f.h();
            }
            
            public void d(final f f, final int n) {
                f.A(n);
            }
            
            public /* bridge */ Object get(final Object o) {
                return this.c((f)o);
            }
        };
        F = new c<f>("rotate") {
            @Override
            public /* bridge */ void b(final Object o, final int n) {
                this.d((f)o, n);
            }
            
            public Integer c(final f f) {
                return f.g();
            }
            
            public void d(final f f, final int n) {
                f.z(n);
            }
            
            public /* bridge */ Object get(final Object o) {
                return this.c((f)o);
            }
        };
        G = new c<f>("rotateY") {
            @Override
            public /* bridge */ void b(final Object o, final int n) {
                this.d((f)o, n);
            }
            
            public Integer c(final f f) {
                return f.i();
            }
            
            public void d(final f f, final int n) {
                f.B(n);
            }
            
            public /* bridge */ Object get(final Object o) {
                return this.c((f)o);
            }
        };
        H = new c<f>("translateX") {
            @Override
            public /* bridge */ void b(final Object o, final int n) {
                this.d((f)o, n);
            }
            
            public Integer c(final f f) {
                return f.m();
            }
            
            public void d(final f f, final int n) {
                f.F(n);
            }
            
            public /* bridge */ Object get(final Object o) {
                return this.c((f)o);
            }
        };
        I = new c<f>("translateY") {
            @Override
            public /* bridge */ void b(final Object o, final int n) {
                this.d((f)o, n);
            }
            
            public Integer c(final f f) {
                return f.o();
            }
            
            public void d(final f f, final int n) {
                f.H(n);
            }
            
            public /* bridge */ Object get(final Object o) {
                return this.c((f)o);
            }
        };
        J = new b<f>("translateXPercentage") {
            @Override
            public /* bridge */ void b(final Object o, final float n) {
                this.d((f)o, n);
            }
            
            public Float c(final f f) {
                return f.n();
            }
            
            public void d(final f f, final float n) {
                f.G(n);
            }
            
            public /* bridge */ Object get(final Object o) {
                return this.c((f)o);
            }
        };
        K = new b<f>("translateYPercentage") {
            @Override
            public /* bridge */ void b(final Object o, final float n) {
                this.d((f)o, n);
            }
            
            public Float c(final f f) {
                return f.p();
            }
            
            public void d(final f f, final float n) {
                f.I(n);
            }
            
            public /* bridge */ Object get(final Object o) {
                return this.c((f)o);
            }
        };
        L = new b<f>("scaleX") {
            @Override
            public /* bridge */ void b(final Object o, final float n) {
                this.d((f)o, n);
            }
            
            public Float c(final f f) {
                return f.k();
            }
            
            public void d(final f f, final float n) {
                f.D(n);
            }
            
            public /* bridge */ Object get(final Object o) {
                return this.c((f)o);
            }
        };
        M = new b<f>("scaleY") {
            @Override
            public /* bridge */ void b(final Object o, final float n) {
                this.d((f)o, n);
            }
            
            public Float c(final f f) {
                return f.l();
            }
            
            public void d(final f f, final float n) {
                f.E(n);
            }
            
            public /* bridge */ Object get(final Object o) {
                return this.c((f)o);
            }
        };
        N = new b<f>("scale") {
            @Override
            public /* bridge */ void b(final Object o, final float n) {
                this.d((f)o, n);
            }
            
            public Float c(final f f) {
                return f.j();
            }
            
            public void d(final f f, final float n) {
                f.C(n);
            }
            
            public /* bridge */ Object get(final Object o) {
                return this.c((f)o);
            }
        };
        O = new c<f>("alpha") {
            @Override
            public /* bridge */ void b(final Object o, final int n) {
                this.d((f)o, n);
            }
            
            public Integer c(final f f) {
                return f.getAlpha();
            }
            
            public void d(final f f, final int alpha) {
                f.setAlpha(alpha);
            }
            
            public /* bridge */ Object get(final Object o) {
                return this.c((f)o);
            }
        };
    }
    
    public f() {
        this.a = 1.0f;
        this.b = 1.0f;
        this.c = 1.0f;
        this.z = 255;
        this.A = f3.f.D;
        this.B = new Camera();
        this.C = new Matrix();
    }
    
    public void A(final int g) {
        this.g = g;
    }
    
    public void B(final int h) {
        this.h = h;
    }
    
    public void C(final float a) {
        this.D(this.a = a);
        this.E(a);
    }
    
    public void D(final float b) {
        this.b = b;
    }
    
    public void E(final float c) {
        this.c = c;
    }
    
    public void F(final int i) {
        this.i = i;
    }
    
    public void G(final float w) {
        this.w = w;
    }
    
    public void H(final int j) {
        this.j = j;
    }
    
    public void I(final float x) {
        this.x = x;
    }
    
    public Rect a(final Rect rect) {
        final int min = Math.min(rect.width(), rect.height());
        final int centerX = rect.centerX();
        final int centerY = rect.centerY();
        final int n = min / 2;
        return new Rect(centerX - n, centerY - n, centerX + n, centerY + n);
    }
    
    protected abstract void b(final Canvas p0);
    
    public abstract int c();
    
    public Rect d() {
        return this.A;
    }
    
    public void draw(final Canvas canvas) {
        int m;
        if ((m = this.m()) == 0) {
            m = (int)(this.getBounds().width() * this.n());
        }
        int o;
        if ((o = this.o()) == 0) {
            o = (int)(this.getBounds().height() * this.p());
        }
        canvas.translate((float)m, (float)o);
        canvas.scale(this.k(), this.l(), this.e(), this.f());
        canvas.rotate((float)this.g(), this.e(), this.f());
        if (this.h() != 0 || this.i() != 0) {
            this.B.save();
            this.B.rotateX((float)this.h());
            this.B.rotateY((float)this.i());
            this.B.getMatrix(this.C);
            this.C.preTranslate(-this.e(), -this.f());
            this.C.postTranslate(this.e(), this.f());
            this.B.restore();
            canvas.concat(this.C);
        }
        this.b(canvas);
    }
    
    public float e() {
        return this.d;
    }
    
    public float f() {
        return this.e;
    }
    
    public int g() {
        return this.p;
    }
    
    public int getAlpha() {
        return this.z;
    }
    
    public int getOpacity() {
        return -3;
    }
    
    public int h() {
        return this.g;
    }
    
    public int i() {
        return this.h;
    }
    
    public void invalidateDrawable(final Drawable drawable) {
        this.invalidateSelf();
    }
    
    public boolean isRunning() {
        return d3.a.a(this.y);
    }
    
    public float j() {
        return this.a;
    }
    
    public float k() {
        return this.b;
    }
    
    public float l() {
        return this.c;
    }
    
    public int m() {
        return this.i;
    }
    
    public float n() {
        return this.w;
    }
    
    public int o() {
        return this.j;
    }
    
    public void onAnimationUpdate(final ValueAnimator valueAnimator) {
        final Drawable$Callback callback = this.getCallback();
        if (callback != null) {
            callback.invalidateDrawable((Drawable)this);
        }
    }
    
    protected void onBoundsChange(final Rect rect) {
        super.onBoundsChange(rect);
        this.w(rect);
    }
    
    public float p() {
        return this.x;
    }
    
    public ValueAnimator q() {
        if (this.y == null) {
            this.y = this.r();
        }
        final ValueAnimator y = this.y;
        if (y != null) {
            y.addUpdateListener((ValueAnimator$AnimatorUpdateListener)this);
            this.y.setStartDelay((long)this.f);
        }
        return this.y;
    }
    
    public abstract ValueAnimator r();
    
    public void s() {
        this.a = 1.0f;
        this.g = 0;
        this.h = 0;
        this.i = 0;
        this.j = 0;
        this.p = 0;
        this.w = 0.0f;
        this.x = 0.0f;
    }
    
    public void scheduleDrawable(final Drawable drawable, final Runnable runnable, final long n) {
    }
    
    public void setAlpha(final int z) {
        this.z = z;
    }
    
    public void setColorFilter(final ColorFilter colorFilter) {
    }
    
    public void start() {
        if (d3.a.c(this.y)) {
            return;
        }
        final ValueAnimator q = this.q();
        if ((this.y = q) == null) {
            return;
        }
        d3.a.d((Animator)q);
        this.invalidateSelf();
    }
    
    public void stop() {
        if (d3.a.c(this.y)) {
            this.y.removeAllUpdateListeners();
            this.y.end();
            this.s();
        }
    }
    
    public f t(final int f) {
        this.f = f;
        return this;
    }
    
    public abstract void u(final int p0);
    
    public void unscheduleDrawable(final Drawable drawable, final Runnable runnable) {
    }
    
    public void v(final int n, final int n2, final int n3, final int n4) {
        this.A = new Rect(n, n2, n3, n4);
        this.x((float)this.d().centerX());
        this.y((float)this.d().centerY());
    }
    
    public void w(final Rect rect) {
        this.v(rect.left, rect.top, rect.right, rect.bottom);
    }
    
    public void x(final float d) {
        this.d = d;
    }
    
    public void y(final float e) {
        this.e = e;
    }
    
    public void z(final int p) {
        this.p = p;
    }
}
