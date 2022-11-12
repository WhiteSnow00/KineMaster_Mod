// 
// Decompiled by Procyon v0.6.0
// 

package g3;

import d3.d;
import android.animation.ValueAnimator;
import f3.b;
import android.graphics.Rect;
import f3.f;
import f3.g;

public class m extends g
{
    @Override
    public void N(final f... array) {
        super.N(array);
        array[1].t(160);
        array[2].t(320);
    }
    
    @Override
    public f[] O() {
        return new f[] { new a(), new a(), new a() };
    }
    
    @Override
    protected void onBoundsChange(Rect a) {
        super.onBoundsChange(a);
        a = this.a(a);
        final int n = a.width() / 8;
        final int centerY = a.centerY();
        final int centerY2 = a.centerY();
        for (int i = 0; i < this.L(); ++i) {
            final int n2 = a.width() * i / 3 + a.left;
            this.K(i).v(n2, centerY - n, n * 2 + n2, centerY2 + n);
        }
    }
    
    private class a extends b
    {
        final m S;
        
        a(final m s) {
            this.S = s;
            this.C(0.0f);
        }
        
        @Override
        public ValueAnimator r() {
            final float[] array2;
            final float[] array = array2 = new float[4];
            array2[0] = 0.0f;
            array2[1] = 0.4f;
            array2[2] = 0.8f;
            array2[3] = 1.0f;
            final d d = new d(this);
            final Float value = 0.0f;
            return (ValueAnimator)d.l(array, value, 1.0f, value, value).c(1400L).d(array).b();
        }
    }
}
