// 
// Decompiled by Procyon v0.6.0
// 

package d3;

import android.animation.Animator;
import f3.f;
import android.animation.ValueAnimator;

public class a
{
    public static boolean a(final ValueAnimator valueAnimator) {
        return valueAnimator != null && valueAnimator.isRunning();
    }
    
    public static boolean b(final f... array) {
        for (int length = array.length, i = 0; i < length; ++i) {
            if (array[i].isRunning()) {
                return true;
            }
        }
        return false;
    }
    
    public static boolean c(final ValueAnimator valueAnimator) {
        return valueAnimator != null && valueAnimator.isStarted();
    }
    
    public static void d(final Animator animator) {
        if (animator != null && !animator.isStarted()) {
            animator.start();
        }
    }
    
    public static void e(final f... array) {
        for (int length = array.length, i = 0; i < length; ++i) {
            array[i].start();
        }
    }
    
    public static void f(final f... array) {
        for (int length = array.length, i = 0; i < length; ++i) {
            array[i].stop();
        }
    }
}
