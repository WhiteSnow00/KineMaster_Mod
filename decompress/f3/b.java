// 
// Decompiled by Procyon v0.6.0
// 

package f3;

import android.graphics.Paint;
import android.graphics.Canvas;

public class b extends e
{
    @Override
    public void J(final Canvas canvas, final Paint paint) {
        if (this.d() != null) {
            canvas.drawCircle((float)this.d().centerX(), (float)this.d().centerY(), (float)(Math.min(this.d().width(), this.d().height()) / 2), paint);
        }
    }
}
