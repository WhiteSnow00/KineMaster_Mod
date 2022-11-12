// 
// Decompiled by Procyon v0.6.0
// 

package y1;

import android.animation.TimeInterpolator;
import java.util.Iterator;
import android.animation.Animator;
import java.util.concurrent.CopyOnWriteArraySet;
import android.animation.Animator$AnimatorListener;
import android.animation.ValueAnimator$AnimatorUpdateListener;
import java.util.Set;
import android.animation.ValueAnimator;

public abstract class a extends ValueAnimator
{
    private final Set<ValueAnimator$AnimatorUpdateListener> a;
    private final Set<Animator$AnimatorListener> b;
    
    public a() {
        this.a = new CopyOnWriteArraySet<ValueAnimator$AnimatorUpdateListener>();
        this.b = new CopyOnWriteArraySet<Animator$AnimatorListener>();
    }
    
    public void addListener(final Animator$AnimatorListener animator$AnimatorListener) {
        this.b.add(animator$AnimatorListener);
    }
    
    public void addUpdateListener(final ValueAnimator$AnimatorUpdateListener valueAnimator$AnimatorUpdateListener) {
        this.a.add(valueAnimator$AnimatorUpdateListener);
    }
    
    void b() {
        final Iterator<Animator$AnimatorListener> iterator = this.b.iterator();
        while (iterator.hasNext()) {
            iterator.next().onAnimationCancel((Animator)this);
        }
    }
    
    void c(final boolean b) {
        final Iterator<Animator$AnimatorListener> iterator = this.b.iterator();
        while (iterator.hasNext()) {
            iterator.next().onAnimationEnd((Animator)this, b);
        }
    }
    
    void d() {
        final Iterator<Animator$AnimatorListener> iterator = this.b.iterator();
        while (iterator.hasNext()) {
            iterator.next().onAnimationRepeat((Animator)this);
        }
    }
    
    void e(final boolean b) {
        final Iterator<Animator$AnimatorListener> iterator = this.b.iterator();
        while (iterator.hasNext()) {
            iterator.next().onAnimationStart((Animator)this, b);
        }
    }
    
    void f() {
        final Iterator<ValueAnimator$AnimatorUpdateListener> iterator = this.a.iterator();
        while (iterator.hasNext()) {
            iterator.next().onAnimationUpdate((ValueAnimator)this);
        }
    }
    
    public long getStartDelay() {
        throw new UnsupportedOperationException("LottieAnimator does not support getStartDelay.");
    }
    
    public void removeAllListeners() {
        this.b.clear();
    }
    
    public void removeAllUpdateListeners() {
        this.a.clear();
    }
    
    public void removeListener(final Animator$AnimatorListener animator$AnimatorListener) {
        this.b.remove(animator$AnimatorListener);
    }
    
    public void removeUpdateListener(final ValueAnimator$AnimatorUpdateListener valueAnimator$AnimatorUpdateListener) {
        this.a.remove(valueAnimator$AnimatorUpdateListener);
    }
    
    public /* bridge */ Animator setDuration(final long duration) {
        return (Animator)this.setDuration(duration);
    }
    
    public ValueAnimator setDuration(final long n) {
        throw new UnsupportedOperationException("LottieAnimator does not support setDuration.");
    }
    
    public void setInterpolator(final TimeInterpolator timeInterpolator) {
        throw new UnsupportedOperationException("LottieAnimator does not support setInterpolator.");
    }
    
    public void setStartDelay(final long n) {
        throw new UnsupportedOperationException("LottieAnimator does not support setStartDelay.");
    }
}
