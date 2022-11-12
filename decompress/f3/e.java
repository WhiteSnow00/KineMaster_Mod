// 
// Decompiled by Procyon v0.6.0
// 

package f3;

import android.graphics.ColorFilter;
import android.graphics.Canvas;
import android.graphics.Paint;

public abstract class e extends f
{
    private Paint P;
    private int Q;
    private int R;
    
    public e() {
        this.u(-1);
        (this.P = new Paint()).setAntiAlias(true);
        this.P.setColor(this.Q);
    }
    
    private void K() {
        final int alpha = this.getAlpha();
        final int r = this.R;
        this.Q = ((r >>> 24) * (alpha + (alpha >> 7)) >> 8 << 24 | r << 8 >>> 8);
    }
    
    public abstract void J(final Canvas p0, final Paint p1);
    
    @Override
    protected final void b(final Canvas canvas) {
        this.P.setColor(this.Q);
        this.J(canvas, this.P);
    }
    
    @Override
    public int c() {
        return this.R;
    }
    
    @Override
    public void setAlpha(final int alpha) {
        super.setAlpha(alpha);
        this.K();
    }
    
    @Override
    public void setColorFilter(final ColorFilter colorFilter) {
        this.P.setColorFilter(colorFilter);
    }
    
    @Override
    public void u(final int r) {
        this.R = r;
        this.K();
    }
}
