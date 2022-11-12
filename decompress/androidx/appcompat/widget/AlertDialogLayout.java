// 
// Decompiled by Procyon v0.6.0
// 

package androidx.appcompat.widget;

import android.graphics.drawable.Drawable;
import android.view.View$MeasureSpec;
import d.f;
import android.view.ViewGroup;
import androidx.core.view.b0;
import android.view.View;
import android.util.AttributeSet;
import android.content.Context;

public class AlertDialogLayout extends LinearLayoutCompat
{
    public AlertDialogLayout(final Context context, final AttributeSet set) {
        super(context, set);
    }
    
    private void A(final View view, final int n, final int n2, final int n3, final int n4) {
        view.layout(n, n2, n3 + n, n4 + n2);
    }
    
    private static int B(final View view) {
        final int c = b0.C(view);
        if (c > 0) {
            return c;
        }
        if (view instanceof ViewGroup) {
            final ViewGroup viewGroup = (ViewGroup)view;
            if (viewGroup.getChildCount() == 1) {
                return B(viewGroup.getChildAt(0));
            }
        }
        return 0;
    }
    
    private boolean C(final int n, final int n2) {
        final int childCount = this.getChildCount();
        View view = null;
        View view2 = null;
        View view3 = null;
        for (int i = 0; i < childCount; ++i) {
            final View child = this.getChildAt(i);
            if (child.getVisibility() != 8) {
                final int id = child.getId();
                if (id == d.f.O) {
                    view = child;
                }
                else if (id == d.f.k) {
                    view2 = child;
                }
                else {
                    if (id != d.f.m && id != d.f.o) {
                        return false;
                    }
                    if (view3 != null) {
                        return false;
                    }
                    view3 = child;
                }
            }
        }
        final int mode = View$MeasureSpec.getMode(n2);
        final int size = View$MeasureSpec.getSize(n2);
        final int mode2 = View$MeasureSpec.getMode(n);
        int n3 = this.getPaddingTop() + this.getPaddingBottom();
        int n4;
        if (view != null) {
            view.measure(n, 0);
            n3 += view.getMeasuredHeight();
            n4 = View.combineMeasuredStates(0, view.getMeasuredState());
        }
        else {
            n4 = 0;
        }
        int b;
        int n5;
        if (view2 != null) {
            view2.measure(n, 0);
            b = B(view2);
            n5 = view2.getMeasuredHeight() - b;
            n3 += b;
            n4 = View.combineMeasuredStates(n4, view2.getMeasuredState());
        }
        else {
            b = 0;
            n5 = 0;
        }
        int measuredHeight;
        if (view3 != null) {
            int measureSpec;
            if (mode == 0) {
                measureSpec = 0;
            }
            else {
                measureSpec = View$MeasureSpec.makeMeasureSpec(Math.max(0, size - n3), mode);
            }
            view3.measure(n, measureSpec);
            measuredHeight = view3.getMeasuredHeight();
            n3 += measuredHeight;
            n4 = View.combineMeasuredStates(n4, view3.getMeasuredState());
        }
        else {
            measuredHeight = 0;
        }
        final int n6 = size - n3;
        int n7 = n4;
        int n8 = n6;
        int n9 = n3;
        if (view2 != null) {
            final int min = Math.min(n6, n5);
            int n10 = n6;
            int n11 = b;
            if (min > 0) {
                n10 = n6 - min;
                n11 = b + min;
            }
            view2.measure(n, View$MeasureSpec.makeMeasureSpec(n11, 1073741824));
            n9 = n3 - b + view2.getMeasuredHeight();
            final int combineMeasuredStates = View.combineMeasuredStates(n4, view2.getMeasuredState());
            n8 = n10;
            n7 = combineMeasuredStates;
        }
        int combineMeasuredStates2 = n7;
        int n12 = n9;
        if (view3 != null) {
            combineMeasuredStates2 = n7;
            n12 = n9;
            if (n8 > 0) {
                view3.measure(n, View$MeasureSpec.makeMeasureSpec(measuredHeight + n8, mode));
                n12 = n9 - measuredHeight + view3.getMeasuredHeight();
                combineMeasuredStates2 = View.combineMeasuredStates(n7, view3.getMeasuredState());
            }
        }
        int j = 0;
        int n13 = 0;
        while (j < childCount) {
            final View child2 = this.getChildAt(j);
            int max = n13;
            if (child2.getVisibility() != 8) {
                max = Math.max(n13, child2.getMeasuredWidth());
            }
            ++j;
            n13 = max;
        }
        this.setMeasuredDimension(View.resolveSizeAndState(n13 + (this.getPaddingLeft() + this.getPaddingRight()), n, combineMeasuredStates2), View.resolveSizeAndState(n12, n2, 0));
        if (mode2 != 1073741824) {
            this.l(childCount, n2);
        }
        return true;
    }
    
    private void l(final int n, final int n2) {
        final int measureSpec = View$MeasureSpec.makeMeasureSpec(this.getMeasuredWidth(), 1073741824);
        for (int i = 0; i < n; ++i) {
            final View child = this.getChildAt(i);
            if (child.getVisibility() != 8) {
                final a a = (a)child.getLayoutParams();
                if (a.width == -1) {
                    final int height = a.height;
                    a.height = child.getMeasuredHeight();
                    this.measureChildWithMargins(child, measureSpec, 0, n2, 0);
                    a.height = height;
                }
            }
        }
    }
    
    @Override
    protected void onLayout(final boolean b, int n, int intrinsicHeight, int i, int n2) {
        final int paddingLeft = this.getPaddingLeft();
        final int n3 = i - n;
        final int paddingRight = this.getPaddingRight();
        final int paddingRight2 = this.getPaddingRight();
        n = this.getMeasuredHeight();
        final int childCount = this.getChildCount();
        final int gravity = this.getGravity();
        i = (gravity & 0x70);
        if (i != 16) {
            if (i != 80) {
                n = this.getPaddingTop();
            }
            else {
                n = this.getPaddingTop() + n2 - intrinsicHeight - n;
            }
        }
        else {
            n = this.getPaddingTop() + (n2 - intrinsicHeight - n) / 2;
        }
        final Drawable dividerDrawable = this.getDividerDrawable();
        if (dividerDrawable == null) {
            intrinsicHeight = 0;
        }
        else {
            intrinsicHeight = dividerDrawable.getIntrinsicHeight();
        }
        View child;
        int measuredWidth;
        int measuredHeight;
        a a;
        int n4;
        int n5;
        for (i = 0; i < childCount; ++i, n = n2) {
            child = this.getChildAt(i);
            n2 = n;
            if (child != null) {
                n2 = n;
                if (child.getVisibility() != 8) {
                    measuredWidth = child.getMeasuredWidth();
                    measuredHeight = child.getMeasuredHeight();
                    a = (a)child.getLayoutParams();
                    if ((n2 = a.gravity) < 0) {
                        n2 = (gravity & 0x800007);
                    }
                    n2 = (androidx.core.view.f.b(n2, b0.B((View)this)) & 0x7);
                    Label_0304: {
                        if (n2 != 1) {
                            if (n2 != 5) {
                                n2 = a.leftMargin + paddingLeft;
                                break Label_0304;
                            }
                            n4 = n3 - paddingRight - measuredWidth;
                            n2 = a.rightMargin;
                        }
                        else {
                            n4 = (n3 - paddingLeft - paddingRight2 - measuredWidth) / 2 + paddingLeft + a.leftMargin;
                            n2 = a.rightMargin;
                        }
                        n2 = n4 - n2;
                    }
                    n5 = n;
                    if (this.t(i)) {
                        n5 = n + intrinsicHeight;
                    }
                    n = n5 + a.topMargin;
                    this.A(child, n2, n, measuredWidth, measuredHeight);
                    n2 = n + (measuredHeight + a.bottomMargin);
                }
            }
        }
    }
    
    @Override
    protected void onMeasure(final int n, final int n2) {
        if (!this.C(n, n2)) {
            super.onMeasure(n, n2);
        }
    }
}
