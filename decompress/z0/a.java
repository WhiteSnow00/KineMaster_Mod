// 
// Decompiled by Procyon v0.6.0
// 

package z0;

import android.animation.Animator$AnimatorPauseListener;
import android.animation.AnimatorListenerAdapter;
import android.animation.Animator;

class a
{
    static void a(final Animator animator, final AnimatorListenerAdapter animatorListenerAdapter) {
        animator.addPauseListener((Animator$AnimatorPauseListener)animatorListenerAdapter);
    }
    
    static void b(final Animator animator) {
        animator.pause();
    }
    
    static void c(final Animator animator) {
        animator.resume();
    }
}
