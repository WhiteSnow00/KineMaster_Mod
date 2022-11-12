// 
// Decompiled by Procyon v0.6.0
// 

package androidx.appcompat.widget;

import android.graphics.Bitmap;
import android.widget.ProgressBar;
import android.view.View;
import d.a;
import android.util.AttributeSet;
import android.content.Context;
import android.widget.RatingBar;

public class r extends RatingBar
{
    private final p a;
    
    public r(final Context context, final AttributeSet set) {
        this(context, set, d.a.I);
    }
    
    public r(final Context context, final AttributeSet set, final int n) {
        super(context, set, n);
        m0.a((View)this, this.getContext());
        (this.a = new p((ProgressBar)this)).c(set, n);
    }
    
    protected void onMeasure(final int n, final int n2) {
        synchronized (this) {
            super.onMeasure(n, n2);
            final Bitmap b = this.a.b();
            if (b != null) {
                this.setMeasuredDimension(View.resolveSizeAndState(b.getWidth() * this.getNumStars(), n, 0), this.getMeasuredHeight());
            }
        }
    }
}
