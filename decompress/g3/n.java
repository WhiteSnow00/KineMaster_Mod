// 
// Decompiled by Procyon v0.6.0
// 

package g3;

import d3.d;
import android.animation.ValueAnimator;
import f3.c;
import android.graphics.Rect;
import f3.f;
import f3.g;

public class n extends g
{
    @Override
    public void N(final f... array) {
        super.N(array);
    }
    
    @Override
    public f[] O() {
        return new f[] { new a(0), new a(3) };
    }
    
    @Override
    protected void onBoundsChange(final Rect rect) {
        final Rect a = this.a(rect);
        super.onBoundsChange(a);
        for (int i = 0; i < this.L(); ++i) {
            final f k = this.K(i);
            final int left = a.left;
            k.v(left, a.top, a.width() / 4 + left, a.top + a.height() / 4);
        }
    }
    
    private class a extends c
    {
        int S;
        final n T;
        
        public a(final n t, final int s) {
            this.T = t;
            this.S = s;
        }
        
        @Override
        public ValueAnimator r() {
            final float[] array2;
            final float[] array = array2 = new float[6];
            array2[0] = 0.0f;
            array2[1] = 0.25f;
            array2[2] = 0.5f;
            array2[3] = 0.51f;
            array2[4] = 0.75f;
            array2[5] = 1.0f;
            final d i = new d(this).i(array, 0, -90, -179, -180, -270, -360);
            final Float value = 0.0f;
            final Float value2 = 0.75f;
            final d p = i.o(array, value, value2, value2, value2, value, value).p(array, value, value, value2, value2, value2, value);
            final Float value3 = 1.0f;
            final Float value4 = 0.5f;
            final d d = p.l(array, value3, value4, value3, value3, value4, value3).c(1800L).d(array);
            d.n(this.S);
            return (ValueAnimator)d.b();
        }
    }
}
