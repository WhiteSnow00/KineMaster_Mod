// 
// Decompiled by Procyon v0.6.0
// 

package androidx.core.view;

import android.view.ViewPropertyAnimator;
import android.animation.ValueAnimator$AnimatorUpdateListener;
import android.animation.TimeInterpolator;
import android.view.animation.Interpolator;
import android.animation.Animator$AnimatorListener;
import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.view.View;
import java.lang.ref.WeakReference;

public final class i0
{
    private final WeakReference<View> a;
    Runnable b;
    Runnable c;
    int d;
    
    i0(final View view) {
        this.b = null;
        this.c = null;
        this.d = -1;
        this.a = new WeakReference<View>(view);
    }
    
    public static void a(final l0 l0, final View view, final ValueAnimator valueAnimator) {
        e(l0, view, valueAnimator);
    }
    
    private static void e(final l0 l0, final View view, final ValueAnimator valueAnimator) {
        l0.a(view);
    }
    
    private void j(final View view, final j0 j0) {
        if (j0 != null) {
            view.animate().setListener((Animator$AnimatorListener)new AnimatorListenerAdapter(this, j0, view) {
                final j0 a;
                final View b;
                final i0 c;
                
                public void onAnimationCancel(final Animator animator) {
                    this.a.a(this.b);
                }
                
                public void onAnimationEnd(final Animator animator) {
                    this.a.b(this.b);
                }
                
                public void onAnimationStart(final Animator animator) {
                    this.a.c(this.b);
                }
            });
        }
        else {
            view.animate().setListener((Animator$AnimatorListener)null);
        }
    }
    
    public i0 b(final float n) {
        final View view = this.a.get();
        if (view != null) {
            view.animate().alpha(n);
        }
        return this;
    }
    
    public void c() {
        final View view = this.a.get();
        if (view != null) {
            view.animate().cancel();
        }
    }
    
    public long d() {
        final View view = this.a.get();
        if (view != null) {
            return view.animate().getDuration();
        }
        return 0L;
    }
    
    public i0 f(final float n) {
        final View view = this.a.get();
        if (view != null) {
            view.animate().rotationY(n);
        }
        return this;
    }
    
    public i0 g(final long duration) {
        final View view = this.a.get();
        if (view != null) {
            view.animate().setDuration(duration);
        }
        return this;
    }
    
    public i0 h(final Interpolator interpolator) {
        final View view = this.a.get();
        if (view != null) {
            view.animate().setInterpolator((TimeInterpolator)interpolator);
        }
        return this;
    }
    
    public i0 i(final j0 j0) {
        final View view = this.a.get();
        if (view != null) {
            this.j(view, j0);
        }
        return this;
    }
    
    public i0 k(final long startDelay) {
        final View view = this.a.get();
        if (view != null) {
            view.animate().setStartDelay(startDelay);
        }
        return this;
    }
    
    public i0 l(final l0 l0) {
        final View view = this.a.get();
        if (view != null) {
            Object o = null;
            if (l0 != null) {
                o = new h0(l0, view);
            }
            i0.b.a(view.animate(), (ValueAnimator$AnimatorUpdateListener)o);
        }
        return this;
    }
    
    public void m() {
        final View view = this.a.get();
        if (view != null) {
            view.animate().start();
        }
    }
    
    public i0 n(final float n) {
        final View view = this.a.get();
        if (view != null) {
            view.animate().translationX(n);
        }
        return this;
    }
    
    public i0 o(final float n) {
        final View view = this.a.get();
        if (view != null) {
            view.animate().translationY(n);
        }
        return this;
    }
    
    static class b
    {
        static ViewPropertyAnimator a(final ViewPropertyAnimator viewPropertyAnimator, final ValueAnimator$AnimatorUpdateListener updateListener) {
            return viewPropertyAnimator.setUpdateListener(updateListener);
        }
    }
}
