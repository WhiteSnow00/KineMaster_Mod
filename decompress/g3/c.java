// 
// Decompiled by Procyon v0.6.0
// 

package g3;

import d3.d;
import android.animation.ValueAnimator;
import android.graphics.Rect;
import f3.f;
import f3.g;

public class c extends g
{
    @Override
    public f[] O() {
        final b[] array = new b[9];
        for (int i = 0; i < 9; ++i) {
            (array[i] = new b(null)).t((new int[] { 200, 300, 400, 100, 200, 300, 0, 100, 200 })[i]);
        }
        return array;
    }
    
    @Override
    protected void onBoundsChange(Rect a) {
        super.onBoundsChange(a);
        a = this.a(a);
        final int n = (int)(a.width() * 0.33f);
        final int n2 = (int)(a.height() * 0.33f);
        for (int i = 0; i < this.L(); ++i) {
            final int n3 = i / 3;
            final int n4 = a.left + i % 3 * n;
            final int n5 = a.top + n3 * n2;
            this.K(i).v(n4, n5, n4 + n, n5 + n2);
        }
    }
    
    private class b extends c
    {
        final c S;
        
        private b(final c s) {
            this.S = s;
        }
        
        b(final c c, final c$a object) {
            this(c);
        }
        
        @Override
        public ValueAnimator r() {
            final float[] array2;
            final float[] array = array2 = new float[4];
            array2[0] = 0.0f;
            array2[1] = 0.35f;
            array2[2] = 0.7f;
            array2[3] = 1.0f;
            final d d = new d(this);
            final Float value = 1.0f;
            return (ValueAnimator)d.l(array, value, 0.0f, value, value).c(1300L).d(array).b();
        }
    }
}
