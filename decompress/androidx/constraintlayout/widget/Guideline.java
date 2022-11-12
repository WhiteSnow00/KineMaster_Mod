// 
// Decompiled by Procyon v0.6.0
// 

package androidx.constraintlayout.widget;

import android.view.ViewGroup$LayoutParams;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.content.Context;
import android.view.View;

public class Guideline extends View
{
    private boolean a;
    
    public Guideline(final Context context) {
        super(context);
        this.a = true;
        super.setVisibility(8);
    }
    
    public Guideline(final Context context, final AttributeSet set) {
        super(context, set);
        this.a = true;
        super.setVisibility(8);
    }
    
    public void draw(final Canvas canvas) {
    }
    
    protected void onMeasure(final int n, final int n2) {
        this.setMeasuredDimension(0, 0);
    }
    
    public void setFilterRedundantCalls(final boolean a) {
        this.a = a;
    }
    
    public void setGuidelineBegin(final int a) {
        final ConstraintLayout.b layoutParams = (ConstraintLayout.b)this.getLayoutParams();
        if (this.a && layoutParams.a == a) {
            return;
        }
        layoutParams.a = a;
        this.setLayoutParams((ViewGroup$LayoutParams)layoutParams);
    }
    
    public void setGuidelineEnd(final int b) {
        final ConstraintLayout.b layoutParams = (ConstraintLayout.b)this.getLayoutParams();
        if (this.a && layoutParams.b == b) {
            return;
        }
        layoutParams.b = b;
        this.setLayoutParams((ViewGroup$LayoutParams)layoutParams);
    }
    
    public void setGuidelinePercent(final float c) {
        final ConstraintLayout.b layoutParams = (ConstraintLayout.b)this.getLayoutParams();
        if (this.a && layoutParams.c == c) {
            return;
        }
        layoutParams.c = c;
        this.setLayoutParams((ViewGroup$LayoutParams)layoutParams);
    }
    
    public void setVisibility(final int n) {
    }
}
