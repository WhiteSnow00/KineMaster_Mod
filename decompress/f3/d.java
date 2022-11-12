// 
// Decompiled by Procyon v0.6.0
// 

package f3;

import android.graphics.Paint$Style;
import android.graphics.Paint;
import android.graphics.Canvas;

public class d extends e
{
    @Override
    public void J(final Canvas canvas, final Paint paint) {
        if (this.d() != null) {
            paint.setStyle(Paint$Style.STROKE);
            final int n = Math.min(this.d().width(), this.d().height()) / 2;
            paint.setStrokeWidth((float)(n / 12));
            canvas.drawCircle((float)this.d().centerX(), (float)this.d().centerY(), (float)n, paint);
        }
    }
}
