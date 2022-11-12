// 
// Decompiled by Procyon v0.6.0
// 

package g3;

import f3.f;
import d3.d;
import android.animation.ValueAnimator;
import android.graphics.Rect;
import f3.c;

public class l extends c
{
    @Override
    protected void onBoundsChange(final Rect rect) {
        this.w(this.a(rect));
    }
    
    @Override
    public ValueAnimator r() {
        final float[] array2;
        final float[] array = array2 = new float[3];
        array2[0] = 0.0f;
        array2[1] = 0.5f;
        array2[2] = 1.0f;
        final d d = new d(this);
        final Integer value = 0;
        final Integer value2 = -180;
        return (ValueAnimator)d.j(array, value, value2, value2).k(array, value, value, value2).c(1200L).d(array).b();
    }
}
