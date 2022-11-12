// 
// Decompiled by Procyon v0.6.0
// 

package androidx.constraintlayout.widget;

import android.graphics.Rect;
import android.graphics.Typeface;
import android.graphics.Paint$Align;
import android.graphics.Paint;
import android.graphics.Canvas;
import androidx.constraintlayout.core.widgets.ConstraintWidget;
import android.view.View;

public class f extends View
{
    private int a;
    private View b;
    private int c;
    
    public void a(final ConstraintLayout constraintLayout) {
        if (this.b == null) {
            return;
        }
        final ConstraintLayout.b b = (ConstraintLayout.b)this.getLayoutParams();
        final ConstraintLayout.b b2 = (ConstraintLayout.b)this.b.getLayoutParams();
        b2.v0.g1(0);
        final ConstraintWidget.DimensionBehaviour y = b.v0.y();
        final ConstraintWidget.DimensionBehaviour fixed = ConstraintWidget.DimensionBehaviour.FIXED;
        if (y != fixed) {
            b.v0.h1(b2.v0.U());
        }
        if (b.v0.R() != fixed) {
            b.v0.I0(b2.v0.v());
        }
        b2.v0.g1(8);
    }
    
    public void b(final ConstraintLayout constraintLayout) {
        if (this.a == -1 && !this.isInEditMode()) {
            this.setVisibility(this.c);
        }
        final View viewById = constraintLayout.findViewById(this.a);
        if ((this.b = viewById) != null) {
            ((ConstraintLayout.b)viewById.getLayoutParams()).j0 = true;
            this.b.setVisibility(0);
            this.setVisibility(0);
        }
    }
    
    public View getContent() {
        return this.b;
    }
    
    public int getEmptyVisibility() {
        return this.c;
    }
    
    public void onDraw(final Canvas canvas) {
        if (this.isInEditMode()) {
            canvas.drawRGB(223, 223, 223);
            final Paint paint = new Paint();
            paint.setARGB(255, 210, 210, 210);
            paint.setTextAlign(Paint$Align.CENTER);
            paint.setTypeface(Typeface.create(Typeface.DEFAULT, 0));
            final Rect rect = new Rect();
            canvas.getClipBounds(rect);
            paint.setTextSize((float)rect.height());
            final int height = rect.height();
            final int width = rect.width();
            paint.setTextAlign(Paint$Align.LEFT);
            paint.getTextBounds("?", 0, 1, rect);
            canvas.drawText("?", width / 2.0f - rect.width() / 2.0f - rect.left, height / 2.0f + rect.height() / 2.0f - rect.bottom, paint);
        }
    }
    
    public void setContentId(final int a) {
        if (this.a == a) {
            return;
        }
        final View b = this.b;
        if (b != null) {
            b.setVisibility(0);
            ((ConstraintLayout.b)this.b.getLayoutParams()).j0 = false;
            this.b = null;
        }
        if ((this.a = a) != -1) {
            final View viewById = ((View)this.getParent()).findViewById(a);
            if (viewById != null) {
                viewById.setVisibility(8);
            }
        }
    }
    
    public void setEmptyVisibility(final int c) {
        this.c = c;
    }
}
