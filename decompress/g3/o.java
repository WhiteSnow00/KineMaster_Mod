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

public class o extends g
{
    @Override
    public f[] O() {
        final a[] array = new a[5];
        for (int i = 0; i < 5; ++i) {
            (array[i] = new a()).t(i * 100 + 600);
        }
        return array;
    }
    
    @Override
    protected void onBoundsChange(Rect a) {
        super.onBoundsChange(a);
        a = this.a(a);
        final int n = a.width() / this.L();
        final int n2 = a.width() / 5 * 3 / 5;
        for (int i = 0; i < this.L(); ++i) {
            final f k = this.K(i);
            final int n3 = a.left + i * n + n / 5;
            k.v(n3, a.top, n3 + n2, a.bottom);
        }
    }
    
    private class a extends c
    {
        final o S;
        
        a(final o s) {
            this.S = s;
            this.E(0.4f);
        }
        
        @Override
        public ValueAnimator r() {
            final float[] array2;
            final float[] array = array2 = new float[4];
            array2[0] = 0.0f;
            array2[1] = 0.2f;
            array2[2] = 0.4f;
            array2[3] = 1.0f;
            final d d = new d(this);
            final Float value = 0.4f;
            return (ValueAnimator)d.m(array, value, 1.0f, value, value).c(1200L).d(array).b();
        }
    }
}
