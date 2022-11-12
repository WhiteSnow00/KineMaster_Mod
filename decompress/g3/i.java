// 
// Decompiled by Procyon v0.6.0
// 

package g3;

import f3.f;
import d3.d;
import android.animation.ValueAnimator;
import f3.b;

public class i extends b
{
    public i() {
        this.C(0.0f);
    }
    
    @Override
    public ValueAnimator r() {
        final float[] array2;
        final float[] array = array2 = new float[2];
        array2[0] = 0.0f;
        array2[1] = 1.0f;
        return (ValueAnimator)new d(this).l(array, 0.0f, 1.0f).a(array, 255, 0).c(1000L).d(array).b();
    }
}
