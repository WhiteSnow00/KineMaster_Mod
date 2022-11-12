// 
// Decompiled by Procyon v0.6.0
// 

package androidx.recyclerview.widget;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.MotionEvent;
import android.view.View;
import androidx.core.view.b0;
import android.graphics.Canvas;
import android.animation.ValueAnimator$AnimatorUpdateListener;
import android.animation.Animator$AnimatorListener;
import android.animation.ValueAnimator;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.StateListDrawable;

class k extends n implements s
{
    private static final int[] D;
    private static final int[] E;
    int A;
    private final Runnable B;
    private final t C;
    private final int a;
    private final int b;
    final StateListDrawable c;
    final Drawable d;
    private final int e;
    private final int f;
    private final StateListDrawable g;
    private final Drawable h;
    private final int i;
    private final int j;
    int k;
    int l;
    float m;
    int n;
    int o;
    float p;
    private int q;
    private int r;
    private RecyclerView s;
    private boolean t;
    private boolean u;
    private int v;
    private int w;
    private final int[] x;
    private final int[] y;
    final ValueAnimator z;
    
    static {
        D = new int[] { 16842919 };
        E = new int[0];
    }
    
    k(final RecyclerView recyclerView, final StateListDrawable c, final Drawable d, final StateListDrawable g, final Drawable h, final int n, final int a, final int b) {
        this.q = 0;
        this.r = 0;
        this.t = false;
        this.u = false;
        this.v = 0;
        this.w = 0;
        this.x = new int[2];
        this.y = new int[2];
        final ValueAnimator ofFloat = ValueAnimator.ofFloat(new float[] { 0.0f, 1.0f });
        this.z = ofFloat;
        this.A = 0;
        this.B = new Runnable() {
            final k a;
            
            @Override
            public void run() {
                this.a.k(500);
            }
        };
        this.C = new t() {
            final k a;
            
            @Override
            public void onScrolled(final RecyclerView recyclerView, final int n, final int n2) {
                this.a.v(recyclerView.computeHorizontalScrollOffset(), recyclerView.computeVerticalScrollOffset());
            }
        };
        this.c = c;
        this.d = d;
        this.g = g;
        this.h = h;
        this.e = Math.max(n, c.getIntrinsicWidth());
        this.f = Math.max(n, d.getIntrinsicWidth());
        this.i = Math.max(n, g.getIntrinsicWidth());
        this.j = Math.max(n, h.getIntrinsicWidth());
        this.a = a;
        this.b = b;
        c.setAlpha(255);
        d.setAlpha(255);
        ofFloat.addListener((Animator$AnimatorListener)new c());
        ofFloat.addUpdateListener((ValueAnimator$AnimatorUpdateListener)new d());
        this.d(recyclerView);
    }
    
    private void e() {
        this.s.removeCallbacks(this.B);
    }
    
    private void f() {
        this.s.removeItemDecoration((RecyclerView.n)this);
        this.s.removeOnItemTouchListener((RecyclerView.s)this);
        this.s.removeOnScrollListener(this.C);
        this.e();
    }
    
    private void g(final Canvas canvas) {
        final int r = this.r;
        final int i = this.i;
        final int n = r - i;
        final int o = this.o;
        final int n2 = this.n;
        final int n3 = o - n2 / 2;
        this.g.setBounds(0, 0, n2, i);
        this.h.setBounds(0, 0, this.q, this.j);
        canvas.translate(0.0f, (float)n);
        this.h.draw(canvas);
        canvas.translate((float)n3, 0.0f);
        this.g.draw(canvas);
        canvas.translate((float)(-n3), (float)(-n));
    }
    
    private void h(final Canvas canvas) {
        final int q = this.q;
        final int e = this.e;
        final int n = q - e;
        final int l = this.l;
        final int k = this.k;
        final int n2 = l - k / 2;
        this.c.setBounds(0, 0, e, k);
        this.d.setBounds(0, 0, this.f, this.r);
        if (this.m()) {
            this.d.draw(canvas);
            canvas.translate((float)this.e, (float)n2);
            canvas.scale(-1.0f, 1.0f);
            this.c.draw(canvas);
            canvas.scale(-1.0f, 1.0f);
            canvas.translate((float)(-this.e), (float)(-n2));
        }
        else {
            canvas.translate((float)n, 0.0f);
            this.d.draw(canvas);
            canvas.translate(0.0f, (float)n2);
            this.c.draw(canvas);
            canvas.translate((float)(-n), (float)(-n2));
        }
    }
    
    private int[] i() {
        final int[] y = this.y;
        final int b = this.b;
        y[0] = b;
        y[1] = this.q - b;
        return y;
    }
    
    private int[] j() {
        final int[] x = this.x;
        final int b = this.b;
        x[0] = b;
        x[1] = this.r - b;
        return x;
    }
    
    private void l(float max) {
        final int[] i = this.i();
        max = Math.max((float)i[0], Math.min((float)i[1], max));
        if (Math.abs(this.o - max) < 2.0f) {
            return;
        }
        final int r = this.r(this.p, max, i, this.s.computeHorizontalScrollRange(), this.s.computeHorizontalScrollOffset(), this.q);
        if (r != 0) {
            this.s.scrollBy(r, 0);
        }
        this.p = max;
    }
    
    private boolean m() {
        final int b = androidx.core.view.b0.B((View)this.s);
        boolean b2 = true;
        if (b != 1) {
            b2 = false;
        }
        return b2;
    }
    
    private void q(final int n) {
        this.e();
        this.s.postDelayed(this.B, (long)n);
    }
    
    private int r(float n, final float n2, final int[] array, int n3, int n4, int n5) {
        final int n6 = array[1] - array[0];
        if (n6 == 0) {
            return 0;
        }
        n = (n2 - n) / n6;
        n3 -= n5;
        n5 = (int)(n * n3);
        n4 += n5;
        if (n4 < n3 && n4 >= 0) {
            return n5;
        }
        return 0;
    }
    
    private void t() {
        this.s.addItemDecoration((RecyclerView.n)this);
        this.s.addOnItemTouchListener((RecyclerView.s)this);
        this.s.addOnScrollListener(this.C);
    }
    
    private void w(float max) {
        final int[] j = this.j();
        max = Math.max((float)j[0], Math.min((float)j[1], max));
        if (Math.abs(this.l - max) < 2.0f) {
            return;
        }
        final int r = this.r(this.m, max, j, this.s.computeVerticalScrollRange(), this.s.computeVerticalScrollOffset(), this.r);
        if (r != 0) {
            this.s.scrollBy(0, r);
        }
        this.m = max;
    }
    
    @Override
    public void a(final RecyclerView recyclerView, final MotionEvent motionEvent) {
        if (this.v == 0) {
            return;
        }
        if (motionEvent.getAction() == 0) {
            final boolean o = this.o(motionEvent.getX(), motionEvent.getY());
            final boolean n = this.n(motionEvent.getX(), motionEvent.getY());
            if (o || n) {
                if (n) {
                    this.w = 1;
                    this.p = (float)(int)motionEvent.getX();
                }
                else if (o) {
                    this.w = 2;
                    this.m = (float)(int)motionEvent.getY();
                }
                this.s(2);
            }
        }
        else if (motionEvent.getAction() == 1 && this.v == 2) {
            this.m = 0.0f;
            this.p = 0.0f;
            this.s(1);
            this.w = 0;
        }
        else if (motionEvent.getAction() == 2 && this.v == 2) {
            this.u();
            if (this.w == 1) {
                this.l(motionEvent.getX());
            }
            if (this.w == 2) {
                this.w(motionEvent.getY());
            }
        }
    }
    
    @Override
    public boolean b(final RecyclerView recyclerView, final MotionEvent motionEvent) {
        final int v = this.v;
        final boolean b = false;
        if (v == 1) {
            final boolean o = this.o(motionEvent.getX(), motionEvent.getY());
            final boolean n = this.n(motionEvent.getX(), motionEvent.getY());
            boolean b2 = b;
            if (motionEvent.getAction() != 0) {
                return b2;
            }
            if (!o) {
                b2 = b;
                if (!n) {
                    return b2;
                }
            }
            if (n) {
                this.w = 1;
                this.p = (float)(int)motionEvent.getX();
            }
            else if (o) {
                this.w = 2;
                this.m = (float)(int)motionEvent.getY();
            }
            this.s(2);
        }
        else {
            final boolean b2 = b;
            if (v != 2) {
                return b2;
            }
        }
        return true;
    }
    
    @Override
    public void c(final boolean b) {
    }
    
    public void d(final RecyclerView s) {
        final RecyclerView s2 = this.s;
        if (s2 == s) {
            return;
        }
        if (s2 != null) {
            this.f();
        }
        if ((this.s = s) != null) {
            this.t();
        }
    }
    
    void k(final int n) {
        final int a = this.A;
        if (a != 1) {
            if (a != 2) {
                return;
            }
        }
        else {
            this.z.cancel();
        }
        this.A = 3;
        final ValueAnimator z = this.z;
        z.setFloatValues(new float[] { (float)z.getAnimatedValue(), 0.0f });
        this.z.setDuration((long)n);
        this.z.start();
    }
    
    boolean n(final float n, final float n2) {
        if (n2 >= this.r - this.i) {
            final int o = this.o;
            final int n3 = this.n;
            if (n >= o - n3 / 2 && n <= o + n3 / 2) {
                return true;
            }
        }
        return false;
    }
    
    boolean o(final float n, final float n2) {
        if (this.m()) {
            if (n > this.e) {
                return false;
            }
        }
        else if (n < this.q - this.e) {
            return false;
        }
        final int l = this.l;
        final int k = this.k;
        if (n2 >= l - k / 2 && n2 <= l + k / 2) {
            return true;
        }
        return false;
    }
    
    @Override
    public void onDrawOver(final Canvas canvas, final RecyclerView recyclerView, final z z) {
        if (this.q == this.s.getWidth() && this.r == this.s.getHeight()) {
            if (this.A != 0) {
                if (this.t) {
                    this.h(canvas);
                }
                if (this.u) {
                    this.g(canvas);
                }
            }
            return;
        }
        this.q = this.s.getWidth();
        this.r = this.s.getHeight();
        this.s(0);
    }
    
    void p() {
        this.s.invalidate();
    }
    
    void s(final int v) {
        if (v == 2 && this.v != 2) {
            this.c.setState(androidx.recyclerview.widget.k.D);
            this.e();
        }
        if (v == 0) {
            this.p();
        }
        else {
            this.u();
        }
        if (this.v == 2 && v != 2) {
            this.c.setState(androidx.recyclerview.widget.k.E);
            this.q(1200);
        }
        else if (v == 1) {
            this.q(1500);
        }
        this.v = v;
    }
    
    public void u() {
        final int a = this.A;
        if (a != 0) {
            if (a != 3) {
                return;
            }
            this.z.cancel();
        }
        this.A = 1;
        final ValueAnimator z = this.z;
        z.setFloatValues(new float[] { (float)z.getAnimatedValue(), 1.0f });
        this.z.setDuration(500L);
        this.z.setStartDelay(0L);
        this.z.start();
    }
    
    void v(int v, final int n) {
        final int computeVerticalScrollRange = this.s.computeVerticalScrollRange();
        final int r = this.r;
        this.t = (computeVerticalScrollRange - r > 0 && r >= this.a);
        final int computeHorizontalScrollRange = this.s.computeHorizontalScrollRange();
        final int q = this.q;
        final boolean u = computeHorizontalScrollRange - q > 0 && q >= this.a;
        this.u = u;
        final boolean t = this.t;
        if (!t && !u) {
            if (this.v != 0) {
                this.s(0);
            }
            return;
        }
        if (t) {
            final float n2 = (float)n;
            final float n3 = (float)r;
            this.l = (int)(n3 * (n2 + n3 / 2.0f) / computeVerticalScrollRange);
            this.k = Math.min(r, r * r / computeVerticalScrollRange);
        }
        if (this.u) {
            final float n4 = (float)v;
            final float n5 = (float)q;
            this.o = (int)(n5 * (n4 + n5 / 2.0f) / computeHorizontalScrollRange);
            this.n = Math.min(q, q * q / computeHorizontalScrollRange);
        }
        v = this.v;
        if (v == 0 || v == 1) {
            this.s(1);
        }
    }
    
    private class c extends AnimatorListenerAdapter
    {
        private boolean a;
        final k b;
        
        c(final k b) {
            this.b = b;
            this.a = false;
        }
        
        public void onAnimationCancel(final Animator animator) {
            this.a = true;
        }
        
        public void onAnimationEnd(final Animator animator) {
            if (this.a) {
                this.a = false;
                return;
            }
            if ((float)this.b.z.getAnimatedValue() == 0.0f) {
                final k b = this.b;
                b.s(b.A = 0);
            }
            else {
                final k b2 = this.b;
                b2.A = 2;
                b2.p();
            }
        }
    }
    
    private class d implements ValueAnimator$AnimatorUpdateListener
    {
        final k a;
        
        d(final k a) {
            this.a = a;
        }
        
        public void onAnimationUpdate(final ValueAnimator valueAnimator) {
            final int n = (int)((float)valueAnimator.getAnimatedValue() * 255.0f);
            this.a.c.setAlpha(n);
            this.a.d.setAlpha(n);
            this.a.p();
        }
    }
}
