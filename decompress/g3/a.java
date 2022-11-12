// 
// Decompiled by Procyon v0.6.0
// 

package g3;

import f3.b;
import android.view.animation.Interpolator;
import android.view.animation.LinearInterpolator;
import d3.d;
import android.animation.ValueAnimator;
import android.graphics.Rect;
import f3.f;
import f3.g;

public class a extends g
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
    
    @Override
    protected void onBoundsChange(Rect a) {
        super.onBoundsChange(a);
        a = this.a(a);
        final int n = (int)(a.width() * 0.6f);
        final f k = this.K(0);
        final int right = a.right;
        final int top = a.top;
        k.v(right - n, top, right, top + n);
        final f i = this.K(1);
        final int right2 = a.right;
        final int bottom = a.bottom;
        i.v(right2 - n, bottom - n, right2, bottom);
    }
    
    @Override
    public ValueAnimator r() {
        return (ValueAnimator)new d(this).i(new float[] { 0.0f, 1.0f }, 0, 360).c(2000L).h((Interpolator)new LinearInterpolator()).b();
    }
    
    private class a extends b
    {
        final g3.a S;
        
        a(final g3.a s) {
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
            return (ValueAnimator)d.l(array, value, 1.0f, value).c(2000L).d(array).b();
        }
    }
}
