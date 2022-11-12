// 
// Decompiled by Procyon v0.6.0
// 

package g3;

import android.view.animation.Interpolator;
import android.view.animation.LinearInterpolator;
import d3.d;
import android.animation.ValueAnimator;
import f3.c;
import android.graphics.Rect;
import android.graphics.Canvas;
import f3.g;

public class f extends g
{
    private boolean R;
    
    public f() {
        this.R = false;
    }
    
    @Override
    public void J(final Canvas canvas) {
        final Rect a = this.a(this.getBounds());
        for (int i = 0; i < this.L(); ++i) {
            final int save = canvas.save();
            canvas.rotate((float)(i * 90 + 45), (float)a.centerX(), (float)a.centerY());
            this.K(i).draw(canvas);
            canvas.restoreToCount(save);
        }
    }
    
    @Override
    public f3.f[] O() {
        final a[] array = new a[4];
        for (int i = 0; i < 4; ++i) {
            (array[i] = new a()).t(i * 300);
        }
        return array;
    }
    
    @Override
    protected void onBoundsChange(Rect rect) {
        super.onBoundsChange(rect);
        final Rect a = this.a(rect);
        int min;
        final int n = min = Math.min(a.width(), a.height());
        rect = a;
        if (this.R) {
            min = (int)Math.sqrt(n * n / 2);
            final int n2 = (a.width() - min) / 2;
            final int n3 = (a.height() - min) / 2;
            rect = new Rect(a.left + n2, a.top + n3, a.right - n2, a.bottom - n3);
        }
        final int left = rect.left;
        final int n4 = min / 2;
        final int top = rect.top;
        for (int i = 0; i < this.L(); ++i) {
            final f3.f k = this.K(i);
            k.v(rect.left, rect.top, left + n4 + 1, top + n4 + 1);
            k.x((float)k.d().right);
            k.y((float)k.d().bottom);
        }
    }
    
    private class a extends c
    {
        final f S;
        
        a(final f s) {
            this.S = s;
            this.setAlpha(0);
            this.A(-180);
        }
        
        @Override
        public ValueAnimator r() {
            final float[] array2;
            final float[] array = array2 = new float[6];
            array2[0] = 0.0f;
            array2[1] = 0.1f;
            array2[2] = 0.25f;
            array2[3] = 0.75f;
            array2[4] = 0.9f;
            array2[5] = 1.0f;
            final d d = new d(this);
            final Integer value = 0;
            final Integer value2 = 255;
            final d a = d.a(array, value, value, value2, value2, value, value);
            final Integer value3 = -180;
            final d j = a.j(array, value3, value3, value, value, value, value);
            final Integer value4 = 180;
            return (ValueAnimator)j.k(array, value, value, value, value, value4, value4).c(2400L).h((Interpolator)new LinearInterpolator()).b();
        }
    }
}
