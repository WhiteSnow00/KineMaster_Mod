// 
// Decompiled by Procyon v0.6.0
// 

package androidx.appcompat.widget;

import android.widget.LinearLayout$LayoutParams;
import android.view.View$MeasureSpec;
import d.f;
import android.content.res.TypedArray;
import android.view.View;
import androidx.core.view.b0;
import d.j;
import android.util.AttributeSet;
import android.content.Context;
import android.widget.LinearLayout;

public class ButtonBarLayout extends LinearLayout
{
    private boolean a;
    private boolean b;
    private int c;
    
    public ButtonBarLayout(final Context context, final AttributeSet set) {
        super(context, set);
        this.c = -1;
        final int[] n0 = j.N0;
        final TypedArray obtainStyledAttributes = context.obtainStyledAttributes(set, n0);
        b0.n0((View)this, context, n0, set, obtainStyledAttributes, 0, 0);
        this.a = obtainStyledAttributes.getBoolean(j.O0, true);
        obtainStyledAttributes.recycle();
        if (this.getOrientation() == 1) {
            this.setStacked(this.a);
        }
    }
    
    private int a(int i) {
        while (i < this.getChildCount()) {
            if (this.getChildAt(i).getVisibility() == 0) {
                return i;
            }
            ++i;
        }
        return -1;
    }
    
    private boolean b() {
        return this.b;
    }
    
    private void setStacked(final boolean b) {
        if (this.b != b && (!b || this.a)) {
            this.setOrientation((int)((this.b = b) ? 1 : 0));
            int gravity;
            if (b) {
                gravity = 8388613;
            }
            else {
                gravity = 80;
            }
            this.setGravity(gravity);
            final View viewById = this.findViewById(f.F);
            if (viewById != null) {
                int visibility;
                if (b) {
                    visibility = 8;
                }
                else {
                    visibility = 4;
                }
                viewById.setVisibility(visibility);
            }
            for (int i = this.getChildCount() - 2; i >= 0; --i) {
                this.bringChildToFront(this.getChildAt(i));
            }
        }
    }
    
    protected void onMeasure(final int n, final int n2) {
        final int size = View$MeasureSpec.getSize(n);
        final boolean a = this.a;
        final int n3 = 0;
        if (a) {
            if (size > this.c && this.b()) {
                this.setStacked(false);
            }
            this.c = size;
        }
        int measureSpec;
        boolean b;
        if (!this.b() && View$MeasureSpec.getMode(n) == 1073741824) {
            measureSpec = View$MeasureSpec.makeMeasureSpec(size, Integer.MIN_VALUE);
            b = true;
        }
        else {
            measureSpec = n;
            b = false;
        }
        super.onMeasure(measureSpec, n2);
        boolean b2 = b;
        if (this.a) {
            b2 = b;
            if (!this.b()) {
                final boolean b3 = (this.getMeasuredWidthAndState() & 0xFF000000) == 0x1000000;
                b2 = b;
                if (b3) {
                    this.setStacked(true);
                    b2 = true;
                }
            }
        }
        if (b2) {
            super.onMeasure(n, n2);
        }
        final int a2 = this.a(0);
        int minimumHeight = n3;
        if (a2 >= 0) {
            final View child = this.getChildAt(a2);
            final LinearLayout$LayoutParams linearLayout$LayoutParams = (LinearLayout$LayoutParams)child.getLayoutParams();
            final int n4 = this.getPaddingTop() + child.getMeasuredHeight() + linearLayout$LayoutParams.topMargin + linearLayout$LayoutParams.bottomMargin + 0;
            if (this.b()) {
                final int a3 = this.a(a2 + 1);
                minimumHeight = n4;
                if (a3 >= 0) {
                    minimumHeight = n4 + (this.getChildAt(a3).getPaddingTop() + (int)(this.getResources().getDisplayMetrics().density * 16.0f));
                }
            }
            else {
                minimumHeight = n4 + this.getPaddingBottom();
            }
        }
        if (b0.C((View)this) != minimumHeight) {
            this.setMinimumHeight(minimumHeight);
            if (n2 == 0) {
                super.onMeasure(n, n2);
            }
        }
    }
    
    public void setAllowStacking(final boolean a) {
        if (this.a != a) {
            this.a = a;
            if (!a && this.b()) {
                this.setStacked(false);
            }
            this.requestLayout();
        }
    }
}
