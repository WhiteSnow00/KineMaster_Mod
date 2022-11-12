// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.exoplayer2.ui;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator$AnimatorUpdateListener;

public final class j implements ValueAnimator$AnimatorUpdateListener
{
    public final x a;
    
    public j(final x a) {
        this.a = a;
    }
    
    public final void onAnimationUpdate(final ValueAnimator valueAnimator) {
        x.c(this.a, valueAnimator);
    }
}
