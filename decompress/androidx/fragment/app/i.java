// 
// Decompiled by Procyon v0.6.0
// 

package androidx.fragment.app;

import androidx.core.view.y;
import android.view.animation.Transformation;
import android.view.View;
import android.view.animation.AnimationSet;
import f0.a;
import android.content.res.TypedArray;
import android.animation.Animator;
import android.view.animation.Animation;
import android.view.ViewGroup;
import android.animation.AnimatorInflater;
import android.content.res.Resources$NotFoundException;
import android.view.animation.AnimationUtils;
import f0.b;
import android.content.Context;

class i
{
    private static int a(final Fragment fragment, final boolean b, final boolean b2) {
        if (b2) {
            if (b) {
                return fragment.getPopEnterAnim();
            }
            return fragment.getPopExitAnim();
        }
        else {
            if (b) {
                return fragment.getEnterAnim();
            }
            return fragment.getExitAnim();
        }
    }
    
    static a b(final Context context, final Fragment fragment, boolean equals, final boolean b) {
        final int nextTransition = fragment.getNextTransition();
        final int a = a(fragment, equals, b);
        fragment.setAnimations(0, 0, 0, 0);
        final ViewGroup mContainer = fragment.mContainer;
        if (mContainer != null) {
            final int c = b.c;
            if (mContainer.getTag(c) != null) {
                fragment.mContainer.setTag(c, (Object)null);
            }
        }
        final ViewGroup mContainer2 = fragment.mContainer;
        if (mContainer2 != null && mContainer2.getLayoutTransition() != null) {
            return null;
        }
        final Animation onCreateAnimation = fragment.onCreateAnimation(nextTransition, equals, a);
        if (onCreateAnimation != null) {
            return new a(onCreateAnimation);
        }
        final Animator onCreateAnimator = fragment.onCreateAnimator(nextTransition, equals, a);
        if (onCreateAnimator != null) {
            return new a(onCreateAnimator);
        }
        int d;
        if ((d = a) == 0) {
            d = a;
            if (nextTransition != 0) {
                d = d(context, nextTransition, equals);
            }
        }
        if (d == 0) {
            goto Label_0271;
        }
        equals = "anim".equals(context.getResources().getResourceTypeName(d));
        if (!equals) {
            goto Label_0217;
        }
        try {
            final Animation loadAnimation = AnimationUtils.loadAnimation(context, d);
            if (loadAnimation != null) {
                return new a(loadAnimation);
            }
            goto Label_0217;
        }
        catch (final Resources$NotFoundException ex) {
            throw ex;
        }
        catch (final RuntimeException ex2) {
            goto Label_0217;
        }
        try {
            final Animator loadAnimator = AnimatorInflater.loadAnimator(context, d);
            if (loadAnimator != null) {
                return new a(loadAnimator);
            }
            goto Label_0271;
        }
        catch (final RuntimeException ex3) {}
    }
    
    private static int c(final Context context, int resourceId) {
        final TypedArray obtainStyledAttributes = context.obtainStyledAttributes(16973825, new int[] { resourceId });
        resourceId = obtainStyledAttributes.getResourceId(0, -1);
        obtainStyledAttributes.recycle();
        return resourceId;
    }
    
    private static int d(final Context context, int n, final boolean b) {
        if (n != 4097) {
            if (n != 8194) {
                if (n != 8197) {
                    if (n != 4099) {
                        if (n != 4100) {
                            n = -1;
                        }
                        else if (b) {
                            n = c(context, 16842936);
                        }
                        else {
                            n = c(context, 16842937);
                        }
                    }
                    else if (b) {
                        n = f0.a.c;
                    }
                    else {
                        n = f0.a.d;
                    }
                }
                else if (b) {
                    n = c(context, 16842938);
                }
                else {
                    n = c(context, 16842939);
                }
            }
            else if (b) {
                n = f0.a.a;
            }
            else {
                n = f0.a.b;
            }
        }
        else if (b) {
            n = f0.a.e;
        }
        else {
            n = f0.a.f;
        }
        return n;
    }
    
    static class a
    {
        public final Animation a;
        public final Animator b;
        
        a(final Animator b) {
            this.a = null;
            this.b = b;
            if (b != null) {
                return;
            }
            throw new IllegalStateException("Animator cannot be null");
        }
        
        a(final Animation a) {
            this.a = a;
            this.b = null;
            if (a != null) {
                return;
            }
            throw new IllegalStateException("Animation cannot be null");
        }
    }
    
    static class b extends AnimationSet implements Runnable
    {
        private final ViewGroup a;
        private final View b;
        private boolean c;
        private boolean d;
        private boolean e;
        
        b(final Animation animation, final ViewGroup a, final View b) {
            super(false);
            this.e = true;
            this.a = a;
            this.b = b;
            this.addAnimation(animation);
            a.post((Runnable)this);
        }
        
        public boolean getTransformation(final long n, final Transformation transformation) {
            this.e = true;
            if (this.c) {
                return this.d ^ true;
            }
            if (!super.getTransformation(n, transformation)) {
                this.c = true;
                y.a((View)this.a, this);
            }
            return true;
        }
        
        public boolean getTransformation(final long n, final Transformation transformation, final float n2) {
            this.e = true;
            if (this.c) {
                return this.d ^ true;
            }
            if (!super.getTransformation(n, transformation, n2)) {
                this.c = true;
                y.a((View)this.a, this);
            }
            return true;
        }
        
        public void run() {
            if (!this.c && this.e) {
                this.e = false;
                this.a.post((Runnable)this);
            }
            else {
                this.a.endViewTransition(this.b);
                this.d = true;
            }
        }
    }
}
