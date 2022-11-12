// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.exoplayer2.ui;

import java.util.Iterator;
import android.animation.ObjectAnimator;
import android.view.ViewGroup$LayoutParams;
import android.view.ViewGroup$MarginLayoutParams;
import android.content.res.Resources;
import android.animation.Animator$AnimatorListener;
import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator$AnimatorUpdateListener;
import android.animation.TimeInterpolator;
import android.view.animation.LinearInterpolator;
import android.view.View$OnClickListener;
import java.util.ArrayList;
import java.util.List;
import android.view.View$OnLayoutChangeListener;
import android.animation.ValueAnimator;
import android.animation.AnimatorSet;
import android.view.ViewGroup;
import android.view.View;

final class x
{
    private boolean A;
    private boolean B;
    private boolean C;
    private final StyledPlayerControlView a;
    private final View b;
    private final ViewGroup c;
    private final ViewGroup d;
    private final ViewGroup e;
    private final ViewGroup f;
    private final ViewGroup g;
    private final ViewGroup h;
    private final ViewGroup i;
    private final View j;
    private final View k;
    private final AnimatorSet l;
    private final AnimatorSet m;
    private final AnimatorSet n;
    private final AnimatorSet o;
    private final AnimatorSet p;
    private final ValueAnimator q;
    private final ValueAnimator r;
    private final Runnable s;
    private final Runnable t;
    private final Runnable u;
    private final Runnable v;
    private final Runnable w;
    private final View$OnLayoutChangeListener x;
    private final List<View> y;
    private int z;
    
    public x(final StyledPlayerControlView a) {
        this.a = a;
        this.s = new m(this);
        this.t = new v(this);
        this.u = new k(this);
        this.v = new l(this);
        this.w = new w(this);
        this.x = (View$OnLayoutChangeListener)new s(this);
        this.C = true;
        this.z = 0;
        this.y = new ArrayList<View>();
        this.b = a.findViewById(R.id.l);
        this.c = (ViewGroup)a.findViewById(R.id.g);
        this.e = (ViewGroup)a.findViewById(R.id.v);
        final ViewGroup d = (ViewGroup)a.findViewById(R.id.e);
        this.d = d;
        this.i = (ViewGroup)a.findViewById(R.id.R);
        final View viewById = a.findViewById(R.id.F);
        this.j = viewById;
        this.f = (ViewGroup)a.findViewById(R.id.d);
        this.g = (ViewGroup)a.findViewById(R.id.o);
        this.h = (ViewGroup)a.findViewById(R.id.p);
        final View viewById2 = a.findViewById(R.id.z);
        this.k = viewById2;
        final View viewById3 = a.findViewById(R.id.y);
        if (viewById2 != null && viewById3 != null) {
            viewById2.setOnClickListener((View$OnClickListener)new q(this));
            viewById3.setOnClickListener((View$OnClickListener)new q(this));
        }
        final ValueAnimator ofFloat = ValueAnimator.ofFloat(new float[] { 1.0f, 0.0f });
        ofFloat.setInterpolator((TimeInterpolator)new LinearInterpolator());
        ofFloat.addUpdateListener((ValueAnimator$AnimatorUpdateListener)new n(this));
        ofFloat.addListener((Animator$AnimatorListener)new AnimatorListenerAdapter(this) {
            final x a;
            
            public void onAnimationEnd(final Animator animator) {
                if (com.google.android.exoplayer2.ui.x.p(this.a) != null) {
                    com.google.android.exoplayer2.ui.x.p(this.a).setVisibility(4);
                }
                if (com.google.android.exoplayer2.ui.x.q(this.a) != null) {
                    com.google.android.exoplayer2.ui.x.q(this.a).setVisibility(4);
                }
                if (com.google.android.exoplayer2.ui.x.r(this.a) != null) {
                    com.google.android.exoplayer2.ui.x.r(this.a).setVisibility(4);
                }
            }
            
            public void onAnimationStart(final Animator animator) {
                if (com.google.android.exoplayer2.ui.x.n(this.a) instanceof DefaultTimeBar && !com.google.android.exoplayer2.ui.x.o(this.a)) {
                    ((DefaultTimeBar)com.google.android.exoplayer2.ui.x.n(this.a)).h(250L);
                }
            }
        });
        final ValueAnimator ofFloat2 = ValueAnimator.ofFloat(new float[] { 0.0f, 1.0f });
        ofFloat2.setInterpolator((TimeInterpolator)new LinearInterpolator());
        ofFloat2.addUpdateListener((ValueAnimator$AnimatorUpdateListener)new j(this));
        ofFloat2.addListener((Animator$AnimatorListener)new AnimatorListenerAdapter(this) {
            final x a;
            
            public void onAnimationStart(final Animator animator) {
                final View p = com.google.android.exoplayer2.ui.x.p(this.a);
                int visibility = 0;
                if (p != null) {
                    com.google.android.exoplayer2.ui.x.p(this.a).setVisibility(0);
                }
                if (com.google.android.exoplayer2.ui.x.q(this.a) != null) {
                    com.google.android.exoplayer2.ui.x.q(this.a).setVisibility(0);
                }
                if (com.google.android.exoplayer2.ui.x.r(this.a) != null) {
                    final ViewGroup r = com.google.android.exoplayer2.ui.x.r(this.a);
                    if (!com.google.android.exoplayer2.ui.x.o(this.a)) {
                        visibility = 4;
                    }
                    r.setVisibility(visibility);
                }
                if (com.google.android.exoplayer2.ui.x.n(this.a) instanceof DefaultTimeBar && !com.google.android.exoplayer2.ui.x.o(this.a)) {
                    ((DefaultTimeBar)com.google.android.exoplayer2.ui.x.n(this.a)).u(250L);
                }
            }
        });
        final Resources resources = a.getResources();
        final int b = R.dimen.b;
        final float n = resources.getDimension(b) - resources.getDimension(R.dimen.c);
        final float dimension = resources.getDimension(b);
        final AnimatorSet l = new AnimatorSet();
        (this.l = l).setDuration(250L);
        l.addListener((Animator$AnimatorListener)new AnimatorListenerAdapter(this, a) {
            final StyledPlayerControlView a;
            final x b;
            
            public void onAnimationEnd(final Animator animator) {
                com.google.android.exoplayer2.ui.x.s(this.b, 1);
                if (com.google.android.exoplayer2.ui.x.t(this.b)) {
                    this.a.post(com.google.android.exoplayer2.ui.x.v(this.b));
                    com.google.android.exoplayer2.ui.x.u(this.b, false);
                }
            }
            
            public void onAnimationStart(final Animator animator) {
                com.google.android.exoplayer2.ui.x.s(this.b, 3);
            }
        });
        l.play((Animator)ofFloat).with((Animator)N(0.0f, n, viewById)).with((Animator)N(0.0f, n, (View)d));
        final AnimatorSet m = new AnimatorSet();
        (this.m = m).setDuration(250L);
        m.addListener((Animator$AnimatorListener)new AnimatorListenerAdapter(this, a) {
            final StyledPlayerControlView a;
            final x b;
            
            public void onAnimationEnd(final Animator animator) {
                com.google.android.exoplayer2.ui.x.s(this.b, 2);
                if (com.google.android.exoplayer2.ui.x.t(this.b)) {
                    this.a.post(com.google.android.exoplayer2.ui.x.v(this.b));
                    com.google.android.exoplayer2.ui.x.u(this.b, false);
                }
            }
            
            public void onAnimationStart(final Animator animator) {
                com.google.android.exoplayer2.ui.x.s(this.b, 3);
            }
        });
        m.play((Animator)N(n, dimension, viewById)).with((Animator)N(n, dimension, (View)d));
        final AnimatorSet n2 = new AnimatorSet();
        (this.n = n2).setDuration(250L);
        n2.addListener((Animator$AnimatorListener)new AnimatorListenerAdapter(this, a) {
            final StyledPlayerControlView a;
            final x b;
            
            public void onAnimationEnd(final Animator animator) {
                com.google.android.exoplayer2.ui.x.s(this.b, 2);
                if (com.google.android.exoplayer2.ui.x.t(this.b)) {
                    this.a.post(com.google.android.exoplayer2.ui.x.v(this.b));
                    com.google.android.exoplayer2.ui.x.u(this.b, false);
                }
            }
            
            public void onAnimationStart(final Animator animator) {
                com.google.android.exoplayer2.ui.x.s(this.b, 3);
            }
        });
        n2.play((Animator)ofFloat).with((Animator)N(0.0f, dimension, viewById)).with((Animator)N(0.0f, dimension, (View)d));
        final AnimatorSet o = new AnimatorSet();
        (this.o = o).setDuration(250L);
        o.addListener((Animator$AnimatorListener)new AnimatorListenerAdapter(this) {
            final x a;
            
            public void onAnimationEnd(final Animator animator) {
                com.google.android.exoplayer2.ui.x.s(this.a, 0);
            }
            
            public void onAnimationStart(final Animator animator) {
                com.google.android.exoplayer2.ui.x.s(this.a, 4);
            }
        });
        o.play((Animator)ofFloat2).with((Animator)N(n, 0.0f, viewById)).with((Animator)N(n, 0.0f, (View)d));
        final AnimatorSet p = new AnimatorSet();
        (this.p = p).setDuration(250L);
        p.addListener((Animator$AnimatorListener)new AnimatorListenerAdapter(this) {
            final x a;
            
            public void onAnimationEnd(final Animator animator) {
                com.google.android.exoplayer2.ui.x.s(this.a, 0);
            }
            
            public void onAnimationStart(final Animator animator) {
                com.google.android.exoplayer2.ui.x.s(this.a, 4);
            }
        });
        p.play((Animator)ofFloat2).with((Animator)N(dimension, 0.0f, viewById)).with((Animator)N(dimension, 0.0f, (View)d));
        final ValueAnimator ofFloat3 = ValueAnimator.ofFloat(new float[] { 0.0f, 1.0f });
        (this.q = ofFloat3).setDuration(250L);
        ofFloat3.addUpdateListener((ValueAnimator$AnimatorUpdateListener)new o(this));
        ofFloat3.addListener((Animator$AnimatorListener)new AnimatorListenerAdapter(this) {
            final x a;
            
            public void onAnimationEnd(final Animator animator) {
                if (com.google.android.exoplayer2.ui.x.x(this.a) != null) {
                    com.google.android.exoplayer2.ui.x.x(this.a).setVisibility(4);
                }
            }
            
            public void onAnimationStart(final Animator animator) {
                if (com.google.android.exoplayer2.ui.x.w(this.a) != null) {
                    com.google.android.exoplayer2.ui.x.w(this.a).setVisibility(0);
                    com.google.android.exoplayer2.ui.x.w(this.a).setTranslationX((float)com.google.android.exoplayer2.ui.x.w(this.a).getWidth());
                    com.google.android.exoplayer2.ui.x.w(this.a).scrollTo(com.google.android.exoplayer2.ui.x.w(this.a).getWidth(), 0);
                }
            }
        });
        final ValueAnimator ofFloat4 = ValueAnimator.ofFloat(new float[] { 1.0f, 0.0f });
        (this.r = ofFloat4).setDuration(250L);
        ofFloat4.addUpdateListener((ValueAnimator$AnimatorUpdateListener)new p(this));
        ofFloat4.addListener((Animator$AnimatorListener)new AnimatorListenerAdapter(this) {
            final x a;
            
            public void onAnimationEnd(final Animator animator) {
                if (com.google.android.exoplayer2.ui.x.w(this.a) != null) {
                    com.google.android.exoplayer2.ui.x.w(this.a).setVisibility(4);
                }
            }
            
            public void onAnimationStart(final Animator animator) {
                if (com.google.android.exoplayer2.ui.x.x(this.a) != null) {
                    com.google.android.exoplayer2.ui.x.x(this.a).setVisibility(0);
                }
            }
        });
    }
    
    private static int B(final View view) {
        if (view == null) {
            return 0;
        }
        final int width = view.getWidth();
        final ViewGroup$LayoutParams layoutParams = view.getLayoutParams();
        int n = width;
        if (layoutParams instanceof ViewGroup$MarginLayoutParams) {
            final ViewGroup$MarginLayoutParams viewGroup$MarginLayoutParams = (ViewGroup$MarginLayoutParams)layoutParams;
            n = width + (viewGroup$MarginLayoutParams.leftMargin + viewGroup$MarginLayoutParams.rightMargin);
        }
        return n;
    }
    
    private void D() {
        this.n.start();
    }
    
    private void E() {
        this.Z(2);
    }
    
    private void G() {
        this.l.start();
        this.U(this.u, 2000L);
    }
    
    private void H() {
        this.m.start();
    }
    
    private void J(final ValueAnimator valueAnimator) {
        final float floatValue = (float)valueAnimator.getAnimatedValue();
        final View b = this.b;
        if (b != null) {
            b.setAlpha(floatValue);
        }
        final ViewGroup c = this.c;
        if (c != null) {
            c.setAlpha(floatValue);
        }
        final ViewGroup e = this.e;
        if (e != null) {
            e.setAlpha(floatValue);
        }
    }
    
    private void K(final ValueAnimator valueAnimator) {
        final float floatValue = (float)valueAnimator.getAnimatedValue();
        final View b = this.b;
        if (b != null) {
            b.setAlpha(floatValue);
        }
        final ViewGroup c = this.c;
        if (c != null) {
            c.setAlpha(floatValue);
        }
        final ViewGroup e = this.e;
        if (e != null) {
            e.setAlpha(floatValue);
        }
    }
    
    private void L(final ValueAnimator valueAnimator) {
        this.y((float)valueAnimator.getAnimatedValue());
    }
    
    private void M(final ValueAnimator valueAnimator) {
        this.y((float)valueAnimator.getAnimatedValue());
    }
    
    private static ObjectAnimator N(final float n, final float n2, final View view) {
        return ObjectAnimator.ofFloat((Object)view, "translationY", new float[] { n, n2 });
    }
    
    private void R(final View view, int n, final int n2, final int n3, final int n4, final int n5, final int n6, final int n7, final int n8) {
        final boolean e0 = this.e0();
        if (this.A != e0) {
            this.A = e0;
            view.post((Runnable)new t(this));
        }
        if (n3 - n != n7 - n5) {
            n = 1;
        }
        else {
            n = 0;
        }
        if (!this.A && n != 0) {
            view.post((Runnable)new u(this));
        }
    }
    
    private void S() {
        if (this.f != null) {
            if (this.g != null) {
                final int n = this.a.getWidth() - this.a.getPaddingLeft() - this.a.getPaddingRight();
                int n2;
                while (true) {
                    final int childCount = this.g.getChildCount();
                    n2 = 0;
                    if (childCount <= 1) {
                        break;
                    }
                    final int n3 = this.g.getChildCount() - 2;
                    final View child = this.g.getChildAt(n3);
                    this.g.removeViewAt(n3);
                    this.f.addView(child, 0);
                }
                final View k = this.k;
                if (k != null) {
                    k.setVisibility(8);
                }
                int b = B((View)this.i);
                final int n4 = this.f.getChildCount() - 1;
                for (int i = 0; i < n4; ++i) {
                    b += B(this.f.getChildAt(i));
                }
                if (b > n) {
                    final View j = this.k;
                    int n5 = b;
                    if (j != null) {
                        j.setVisibility(0);
                        n5 = b + B(this.k);
                    }
                    final ArrayList<View> list = new ArrayList<View>();
                    for (int l = 0; l < n4; ++l) {
                        final View child2 = this.f.getChildAt(l);
                        n5 -= B(child2);
                        list.add(child2);
                        if (n5 <= n) {
                            break;
                        }
                    }
                    if (!list.isEmpty()) {
                        this.f.removeViews(0, list.size());
                        for (int n6 = n2; n6 < list.size(); ++n6) {
                            this.g.addView((View)list.get(n6), this.g.getChildCount() - 1);
                        }
                    }
                }
                else {
                    final ViewGroup h = this.h;
                    if (h != null && h.getVisibility() == 0 && !this.r.isStarted()) {
                        this.q.cancel();
                        this.r.start();
                    }
                }
            }
        }
    }
    
    private void T(final View view) {
        this.W();
        if (view.getId() == R.id.z) {
            this.q.start();
        }
        else if (view.getId() == R.id.y) {
            this.r.start();
        }
    }
    
    private void U(final Runnable runnable, final long n) {
        if (n >= 0L) {
            this.a.postDelayed(runnable, n);
        }
    }
    
    private void Z(final int z) {
        final int z2 = this.z;
        this.z = z;
        if (z == 2) {
            this.a.setVisibility(8);
        }
        else if (z2 == 2) {
            this.a.setVisibility(0);
        }
        if (z2 != z) {
            this.a.i0();
        }
    }
    
    public static void a(final x x) {
        x.d0();
    }
    
    private boolean a0(final View view) {
        final int id = view.getId();
        return id == R.id.e || id == R.id.E || id == R.id.x || id == R.id.I || id == R.id.J || id == R.id.q || id == R.id.r;
    }
    
    public static void b(final x x) {
        x.S();
    }
    
    public static void c(final x x, final ValueAnimator valueAnimator) {
        x.K(valueAnimator);
    }
    
    private void c0() {
        if (!this.C) {
            this.Z(0);
            this.W();
            return;
        }
        final int z = this.z;
        if (z != 1) {
            if (z != 2) {
                if (z != 3) {
                    if (z == 4) {
                        return;
                    }
                }
                else {
                    this.B = true;
                }
            }
            else {
                this.p.start();
            }
        }
        else {
            this.o.start();
        }
        this.W();
    }
    
    public static void d(final x x) {
        x.D();
    }
    
    private void d0() {
        final ViewGroup e = this.e;
        if (e != null) {
            int visibility;
            if (this.A) {
                visibility = 0;
            }
            else {
                visibility = 4;
            }
            e.setVisibility(visibility);
        }
        if (this.j != null) {
            int dimensionPixelSize = this.a.getResources().getDimensionPixelSize(R.dimen.d);
            final ViewGroup$MarginLayoutParams layoutParams = (ViewGroup$MarginLayoutParams)this.j.getLayoutParams();
            if (layoutParams != null) {
                if (this.A) {
                    dimensionPixelSize = 0;
                }
                layoutParams.bottomMargin = dimensionPixelSize;
                this.j.setLayoutParams((ViewGroup$LayoutParams)layoutParams);
            }
            final View j = this.j;
            if (j instanceof DefaultTimeBar) {
                final DefaultTimeBar defaultTimeBar = (DefaultTimeBar)j;
                if (this.A) {
                    defaultTimeBar.i(true);
                }
                else {
                    final int z = this.z;
                    if (z == 1) {
                        defaultTimeBar.i(false);
                    }
                    else if (z != 3) {
                        defaultTimeBar.t();
                    }
                }
            }
        }
        for (final View view : this.y) {
            int visibility2;
            if (this.A && this.a0(view)) {
                visibility2 = 4;
            }
            else {
                visibility2 = 0;
            }
            view.setVisibility(visibility2);
        }
    }
    
    public static void e(final x x) {
        x.E();
    }
    
    private boolean e0() {
        final int width = this.a.getWidth();
        final int paddingLeft = this.a.getPaddingLeft();
        final int paddingRight = this.a.getPaddingRight();
        final int height = this.a.getHeight();
        final int paddingBottom = this.a.getPaddingBottom();
        final int paddingTop = this.a.getPaddingTop();
        final int b = B((View)this.c);
        final ViewGroup c = this.c;
        boolean b2 = false;
        int n;
        if (c != null) {
            n = c.getPaddingLeft() + this.c.getPaddingRight();
        }
        else {
            n = 0;
        }
        final int z = z((View)this.c);
        final ViewGroup c2 = this.c;
        int n2;
        if (c2 != null) {
            n2 = c2.getPaddingTop() + this.c.getPaddingBottom();
        }
        else {
            n2 = 0;
        }
        final int max = Math.max(b - n, B((View)this.i) + B(this.k));
        final int z2 = z((View)this.d);
        if (width - paddingLeft - paddingRight <= max || height - paddingBottom - paddingTop <= z - n2 + z2 * 2) {
            b2 = true;
        }
        return b2;
    }
    
    public static void f(final x x, final View view, final int n, final int n2, final int n3, final int n4, final int n5, final int n6, final int n7, final int n8) {
        x.R(view, n, n2, n3, n4, n5, n6, n7, n8);
    }
    
    public static void g(final x x, final ValueAnimator valueAnimator) {
        x.J(valueAnimator);
    }
    
    public static void h(final x x) {
        x.H();
    }
    
    public static void i(final x x, final ValueAnimator valueAnimator) {
        x.L(valueAnimator);
    }
    
    public static void j(final x x, final View view) {
        x.T(view);
    }
    
    public static void k(final x x) {
        x.G();
    }
    
    public static void l(final x x) {
        x.c0();
    }
    
    public static void m(final x x, final ValueAnimator valueAnimator) {
        x.M(valueAnimator);
    }
    
    static View n(final x x) {
        return x.j;
    }
    
    static boolean o(final x x) {
        return x.A;
    }
    
    static View p(final x x) {
        return x.b;
    }
    
    static ViewGroup q(final x x) {
        return x.c;
    }
    
    static ViewGroup r(final x x) {
        return x.e;
    }
    
    static void s(final x x, final int n) {
        x.Z(n);
    }
    
    static boolean t(final x x) {
        return x.B;
    }
    
    static boolean u(final x x, final boolean b) {
        return x.B = b;
    }
    
    static Runnable v(final x x) {
        return x.s;
    }
    
    static ViewGroup w(final x x) {
        return x.h;
    }
    
    static ViewGroup x(final x x) {
        return x.f;
    }
    
    private void y(final float n) {
        final ViewGroup h = this.h;
        if (h != null) {
            this.h.setTranslationX((float)(int)(h.getWidth() * (1.0f - n)));
        }
        final ViewGroup i = this.i;
        if (i != null) {
            i.setAlpha(1.0f - n);
        }
        final ViewGroup f = this.f;
        if (f != null) {
            f.setAlpha(1.0f - n);
        }
    }
    
    private static int z(final View view) {
        if (view == null) {
            return 0;
        }
        final int height = view.getHeight();
        final ViewGroup$LayoutParams layoutParams = view.getLayoutParams();
        int n = height;
        if (layoutParams instanceof ViewGroup$MarginLayoutParams) {
            final ViewGroup$MarginLayoutParams viewGroup$MarginLayoutParams = (ViewGroup$MarginLayoutParams)layoutParams;
            n = height + (viewGroup$MarginLayoutParams.topMargin + viewGroup$MarginLayoutParams.bottomMargin);
        }
        return n;
    }
    
    public boolean A(final View view) {
        return view != null && this.y.contains(view);
    }
    
    public void C() {
        final int z = this.z;
        if (z != 3) {
            if (z != 2) {
                this.V();
                if (!this.C) {
                    this.E();
                }
                else if (this.z == 1) {
                    this.H();
                }
                else {
                    this.D();
                }
            }
        }
    }
    
    public void F() {
        final int z = this.z;
        if (z != 3) {
            if (z != 2) {
                this.V();
                this.E();
            }
        }
    }
    
    public boolean I() {
        return this.z == 0 && this.a.h0();
    }
    
    public void O() {
        this.a.addOnLayoutChangeListener(this.x);
    }
    
    public void P() {
        this.a.removeOnLayoutChangeListener(this.x);
    }
    
    public void Q(final boolean b, final int n, final int n2, final int n3, final int n4) {
        final View b2 = this.b;
        if (b2 != null) {
            b2.layout(0, 0, n3 - n, n4 - n2);
        }
    }
    
    public void V() {
        this.a.removeCallbacks(this.w);
        this.a.removeCallbacks(this.t);
        this.a.removeCallbacks(this.v);
        this.a.removeCallbacks(this.u);
    }
    
    public void W() {
        if (this.z == 3) {
            return;
        }
        this.V();
        final int showTimeoutMs = this.a.getShowTimeoutMs();
        if (showTimeoutMs > 0) {
            if (!this.C) {
                this.U(this.w, showTimeoutMs);
            }
            else if (this.z == 1) {
                this.U(this.u, 2000L);
            }
            else {
                this.U(this.v, showTimeoutMs);
            }
        }
    }
    
    public void X(final boolean c) {
        this.C = c;
    }
    
    public void Y(final View view, final boolean b) {
        if (view == null) {
            return;
        }
        if (!b) {
            view.setVisibility(8);
            this.y.remove(view);
            return;
        }
        if (this.A && this.a0(view)) {
            view.setVisibility(4);
        }
        else {
            view.setVisibility(0);
        }
        this.y.add(view);
    }
    
    public void b0() {
        if (!this.a.h0()) {
            this.a.setVisibility(0);
            this.a.s0();
            this.a.n0();
        }
        this.c0();
    }
}
