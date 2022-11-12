// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.gms.ads.internal.overlay;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;

final class c extends AnimatorListenerAdapter
{
    final zzr a;
    
    c(final zzr a) {
        this.a = a;
    }
    
    private final void a(final boolean b) {
        this.a.setClickable(b);
        zzr.a(this.a).setClickable(b);
    }
    
    public final void onAnimationCancel(final Animator animator) {
        this.a(true);
    }
    
    public final void onAnimationEnd(final Animator animator) {
        this.a(true);
    }
    
    public final void onAnimationStart(final Animator animator) {
        this.a(false);
    }
}
