// 
// Decompiled by Procyon v0.6.0
// 

package g3;

import d3.d;
import android.animation.ValueAnimator;
import f3.f;
import f3.a;

public class b extends f3.a
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
        final b S;
        
        a(final b s) {
            this.S = s;
            this.C(0.0f);
        }
        
        @Override
        public ValueAnimator r() {
            final float[] array2;
            final float[] array = array2 = new float[3];
            array2[0] = 0.0f;
            array2[1] = 0.5f;
            array2[2] = 1.0f;
            final d d = new d(this);
            final Float value = 0.0f;
            return (ValueAnimator)d.l(array, value, 1.0f, value).c(1200L).d(array).b();
        }
    }
}
