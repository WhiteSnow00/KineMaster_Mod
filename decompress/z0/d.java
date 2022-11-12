// 
// Decompiled by Procyon v0.6.0
// 

package z0;

import androidx.core.view.b0;
import android.graphics.Paint;
import android.animation.AnimatorListenerAdapter;
import android.view.ViewGroup;
import android.animation.Animator$AnimatorListener;
import android.util.Property;
import android.animation.ObjectAnimator;
import android.animation.Animator;
import android.view.View;

public class d extends g0
{
    public d() {
    }
    
    public d(final int n) {
        this.o0(n);
    }
    
    private Animator p0(final View view, final float n, final float n2) {
        if (n == n2) {
            return null;
        }
        z0.z.g(view, n);
        final ObjectAnimator ofFloat = ObjectAnimator.ofFloat((Object)view, (Property)z0.z.b, new float[] { n2 });
        ofFloat.addListener((Animator$AnimatorListener)new b(view));
        this.b((f)new n(this, view) {
            final View a;
            final d b;
            
            @Override
            public void c(final m m) {
                z0.z.g(this.a, 1.0f);
                z0.z.a(this.a);
                m.T((f)this);
            }
        });
        return (Animator)ofFloat;
    }
    
    private static float q0(final s s, final float n) {
        float floatValue = n;
        if (s != null) {
            final Float n2 = s.a.get("android:fade:transitionAlpha");
            floatValue = n;
            if (n2 != null) {
                floatValue = n2;
            }
        }
        return floatValue;
    }
    
    @Override
    public void j(final s s) {
        super.j(s);
        s.a.put("android:fade:transitionAlpha", z0.z.c(s.b));
    }
    
    @Override
    public Animator k0(final ViewGroup viewGroup, final View view, final s s, final s s2) {
        final float n = 0.0f;
        float q0 = q0(s, 0.0f);
        if (q0 == 1.0f) {
            q0 = n;
        }
        return this.p0(view, q0, 1.0f);
    }
    
    @Override
    public Animator m0(final ViewGroup viewGroup, final View view, final s s, final s s2) {
        z0.z.e(view);
        return this.p0(view, q0(s, 1.0f), 0.0f);
    }
    
    private static class b extends AnimatorListenerAdapter
    {
        private final View a;
        private boolean b;
        
        b(final View a) {
            this.b = false;
            this.a = a;
        }
        
        public void onAnimationEnd(final Animator animator) {
            z0.z.g(this.a, 1.0f);
            if (this.b) {
                this.a.setLayerType(0, (Paint)null);
            }
        }
        
        public void onAnimationStart(final Animator animator) {
            if (b0.P(this.a) && this.a.getLayerType() == 0) {
                this.b = true;
                this.a.setLayerType(2, (Paint)null);
            }
        }
    }
}
