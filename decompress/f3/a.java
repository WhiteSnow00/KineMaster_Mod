// 
// Decompiled by Procyon v0.6.0
// 

package f3;

import android.graphics.Rect;
import android.graphics.Canvas;

public abstract class a extends g
{
    @Override
    public void J(final Canvas canvas) {
        for (int i = 0; i < this.L(); ++i) {
            final f k = this.K(i);
            final int save = canvas.save();
            canvas.rotate((float)(i * 360 / this.L()), (float)this.getBounds().centerX(), (float)this.getBounds().centerY());
            k.draw(canvas);
            canvas.restoreToCount(save);
        }
    }
    
    @Override
    protected void onBoundsChange(final Rect rect) {
        super.onBoundsChange(rect);
        final Rect a = this.a(rect);
        final int n = (int)(a.width() * 3.141592653589793 / 3.5999999046325684 / this.L());
        final int centerX = a.centerX();
        final int centerX2 = a.centerX();
        for (int i = 0; i < this.L(); ++i) {
            final f k = this.K(i);
            final int top = a.top;
            k.v(centerX - n, top, centerX2 + n, n * 2 + top);
        }
    }
}
