// 
// Decompiled by Procyon v0.6.0
// 

package g3;

import android.animation.ValueAnimator;
import f3.b;
import f3.f;
import f3.g;

public class d extends g
{
    @Override
    public void N(final f... array) {
        super.N(array);
        array[1].t(1000);
    }
    
    @Override
    public f[] O() {
        return new f[] { new a(), new a() };
    }
    
    private class a extends b
    {
        final d S;
        
        a(final d s) {
            this.S = s;
            this.setAlpha(153);
            this.C(0.0f);
        }
        
        @Override
        public ValueAnimator r() {
            final float[] array2;
            final float[] array = array2 = new float[3];
            array2[0] = 0.0f;
            array2[1] = 0.5f;
            array2[2] = 1.0f;
            final d3.d d = new d3.d(this);
            final Float value = 0.0f;
            return (ValueAnimator)d.l(array, value, 1.0f, value).c(2000L).d(array).b();
        }
    }
}
