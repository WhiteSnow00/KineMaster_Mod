// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.exoplayer2.ui;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator$AnimatorUpdateListener;

public final class n implements ValueAnimator$AnimatorUpdateListener
{
    public final x a;
    
    public n(final x a) {
        this.a = a;
    }
    
    public final void onAnimationUpdate(final ValueAnimator valueAnimator) {
        x.g(this.a, valueAnimator);
    }
}
