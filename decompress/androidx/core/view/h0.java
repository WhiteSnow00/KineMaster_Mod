// 
// Decompiled by Procyon v0.6.0
// 

package androidx.core.view;

import android.animation.ValueAnimator;
import android.view.View;
import android.animation.ValueAnimator$AnimatorUpdateListener;

public final class h0 implements ValueAnimator$AnimatorUpdateListener
{
    public final l0 a;
    public final View b;
    
    public h0(final l0 a, final View b) {
        this.a = a;
        this.b = b;
    }
    
    public final void onAnimationUpdate(final ValueAnimator valueAnimator) {
        i0.a(this.a, this.b, valueAnimator);
    }
}
