// 
// Decompiled by Procyon v0.6.0
// 

package g3;

import android.view.animation.Interpolator;
import e3.b;
import f3.f;
import android.animation.ValueAnimator;
import f3.d;

public class j extends d
{
    public j() {
        this.C(0.0f);
    }
    
    @Override
    public ValueAnimator r() {
        final float[] array2;
        final float[] array = array2 = new float[3];
        array2[0] = 0.0f;
        array2[1] = 0.7f;
        array2[2] = 1.0f;
        final d3.d d = new d3.d(this);
        final Float value = 1.0f;
        return (ValueAnimator)d.l(array, 0.0f, value, value).a(array, 255, 178, 0).c(1000L).h((Interpolator)e3.b.b(0.21f, 0.53f, 0.56f, 0.8f, array)).b();
    }
}
