// 
// Decompiled by Procyon v0.6.0
// 

package g3;

import d3.d;
import android.animation.ValueAnimator;
import f3.b;
import f3.f;
import f3.a;

public class e extends f3.a
{
    @Override
    public f[] O() {
        final a[] array = new a[12];
        for (int i = 0; i < 12; ++i) {
            (array[i] = new a()).t(i * 100);
        }
        return array;
    }
    
    private class a extends b
    {
        final e S;
        
        a(final e s) {
            this.S = s;
            this.setAlpha(0);
        }
        
        @Override
        public ValueAnimator r() {
            final float[] array2;
            final float[] array = array2 = new float[4];
            array2[0] = 0.0f;
            array2[1] = 0.39f;
            array2[2] = 0.4f;
            array2[3] = 1.0f;
            final d d = new d(this);
            final Integer value = 0;
            return (ValueAnimator)d.a(array, value, value, 255, value).c(1200L).d(array).b();
        }
    }
}
