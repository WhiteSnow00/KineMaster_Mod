// 
// Decompiled by Procyon v0.6.0
// 

package androidx.appcompat.widget;

import android.view.ActionMode;
import android.view.ActionMode$Callback;
import android.view.ViewGroup$LayoutParams;
import android.graphics.drawable.Drawable$Callback;
import android.view.View$MeasureSpec;
import android.view.MotionEvent;
import android.widget.FrameLayout$LayoutParams;
import android.content.res.TypedArray;
import d.f;
import d.j;
import androidx.core.view.b0;
import android.util.AttributeSet;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.FrameLayout;

public class ActionBarContainer extends FrameLayout
{
    private boolean a;
    private View b;
    private View c;
    private View d;
    Drawable e;
    Drawable f;
    Drawable g;
    boolean h;
    boolean i;
    private int j;
    
    public ActionBarContainer(final Context context, final AttributeSet set) {
        super(context, set);
        b0.t0((View)this, new b(this));
        final TypedArray obtainStyledAttributes = context.obtainStyledAttributes(set, d.j.a);
        this.e = obtainStyledAttributes.getDrawable(d.j.b);
        this.f = obtainStyledAttributes.getDrawable(d.j.d);
        this.j = obtainStyledAttributes.getDimensionPixelSize(d.j.j, -1);
        final int id = this.getId();
        final int g = d.f.G;
        boolean willNotDraw = true;
        if (id == g) {
            this.h = true;
            this.g = obtainStyledAttributes.getDrawable(d.j.c);
        }
        obtainStyledAttributes.recycle();
        Label_0137: {
            if (this.h) {
                if (this.g == null) {
                    break Label_0137;
                }
            }
            else if (this.e == null && this.f == null) {
                break Label_0137;
            }
            willNotDraw = false;
        }
        this.setWillNotDraw(willNotDraw);
    }
    
    private int a(final View view) {
        final FrameLayout$LayoutParams frameLayout$LayoutParams = (FrameLayout$LayoutParams)view.getLayoutParams();
        return view.getMeasuredHeight() + frameLayout$LayoutParams.topMargin + frameLayout$LayoutParams.bottomMargin;
    }
    
    private boolean b(final View view) {
        return view == null || view.getVisibility() == 8 || view.getMeasuredHeight() == 0;
    }
    
    protected void drawableStateChanged() {
        super.drawableStateChanged();
        final Drawable e = this.e;
        if (e != null && e.isStateful()) {
            this.e.setState(this.getDrawableState());
        }
        final Drawable f = this.f;
        if (f != null && f.isStateful()) {
            this.f.setState(this.getDrawableState());
        }
        final Drawable g = this.g;
        if (g != null && g.isStateful()) {
            this.g.setState(this.getDrawableState());
        }
    }
    
    public View getTabContainer() {
        return this.b;
    }
    
    public void jumpDrawablesToCurrentState() {
        super.jumpDrawablesToCurrentState();
        final Drawable e = this.e;
        if (e != null) {
            e.jumpToCurrentState();
        }
        final Drawable f = this.f;
        if (f != null) {
            f.jumpToCurrentState();
        }
        final Drawable g = this.g;
        if (g != null) {
            g.jumpToCurrentState();
        }
    }
    
    public void onFinishInflate() {
        super.onFinishInflate();
        this.c = this.findViewById(d.f.a);
        this.d = this.findViewById(d.f.f);
    }
    
    public boolean onHoverEvent(final MotionEvent motionEvent) {
        super.onHoverEvent(motionEvent);
        return true;
    }
    
    public boolean onInterceptTouchEvent(final MotionEvent motionEvent) {
        return this.a || super.onInterceptTouchEvent(motionEvent);
    }
    
    public void onLayout(final boolean b, int n, int n2, final int n3, int n4) {
        super.onLayout(b, n, n2, n3, n4);
        final View b2 = this.b;
        n4 = 1;
        n2 = 0;
        final int n5 = 0;
        final boolean i = b2 != null && b2.getVisibility() != 8;
        if (b2 != null && b2.getVisibility() != 8) {
            final int measuredHeight = this.getMeasuredHeight();
            final FrameLayout$LayoutParams frameLayout$LayoutParams = (FrameLayout$LayoutParams)b2.getLayoutParams();
            final int measuredHeight2 = b2.getMeasuredHeight();
            final int bottomMargin = frameLayout$LayoutParams.bottomMargin;
            b2.layout(n, measuredHeight - measuredHeight2 - bottomMargin, n3, measuredHeight - bottomMargin);
        }
        Label_0339: {
            if (this.h) {
                final Drawable g = this.g;
                n2 = n5;
                if (g != null) {
                    g.setBounds(0, 0, this.getMeasuredWidth(), this.getMeasuredHeight());
                    n = n4;
                    break Label_0339;
                }
            }
            else {
                n = n2;
                if (this.e != null) {
                    if (this.c.getVisibility() == 0) {
                        this.e.setBounds(this.c.getLeft(), this.c.getTop(), this.c.getRight(), this.c.getBottom());
                    }
                    else {
                        final View d = this.d;
                        if (d != null && d.getVisibility() == 0) {
                            this.e.setBounds(this.d.getLeft(), this.d.getTop(), this.d.getRight(), this.d.getBottom());
                        }
                        else {
                            this.e.setBounds(0, 0, 0, 0);
                        }
                    }
                    n = 1;
                }
                this.i = i;
                n2 = n;
                if (i) {
                    final Drawable f = this.f;
                    n2 = n;
                    if (f != null) {
                        f.setBounds(b2.getLeft(), b2.getTop(), b2.getRight(), b2.getBottom());
                        n = n4;
                        break Label_0339;
                    }
                }
            }
            n = n2;
        }
        if (n != 0) {
            this.invalidate();
        }
    }
    
    public void onMeasure(int n, int n2) {
        int measureSpec = n2;
        if (this.c == null) {
            measureSpec = n2;
            if (View$MeasureSpec.getMode(n2) == Integer.MIN_VALUE) {
                final int j = this.j;
                measureSpec = n2;
                if (j >= 0) {
                    measureSpec = View$MeasureSpec.makeMeasureSpec(Math.min(j, View$MeasureSpec.getSize(n2)), Integer.MIN_VALUE);
                }
            }
        }
        super.onMeasure(n, measureSpec);
        if (this.c == null) {
            return;
        }
        n2 = View$MeasureSpec.getMode(measureSpec);
        final View b = this.b;
        if (b != null && b.getVisibility() != 8 && n2 != 1073741824) {
            if (!this.b(this.c)) {
                n = this.a(this.c);
            }
            else if (!this.b(this.d)) {
                n = this.a(this.d);
            }
            else {
                n = 0;
            }
            if (n2 == Integer.MIN_VALUE) {
                n2 = View$MeasureSpec.getSize(measureSpec);
            }
            else {
                n2 = Integer.MAX_VALUE;
            }
            this.setMeasuredDimension(this.getMeasuredWidth(), Math.min(n + this.a(this.b), n2));
        }
    }
    
    public boolean onTouchEvent(final MotionEvent motionEvent) {
        super.onTouchEvent(motionEvent);
        return true;
    }
    
    public void setPrimaryBackground(final Drawable e) {
        final Drawable e2 = this.e;
        if (e2 != null) {
            e2.setCallback((Drawable$Callback)null);
            this.unscheduleDrawable(this.e);
        }
        if ((this.e = e) != null) {
            e.setCallback((Drawable$Callback)this);
            final View c = this.c;
            if (c != null) {
                this.e.setBounds(c.getLeft(), this.c.getTop(), this.c.getRight(), this.c.getBottom());
            }
        }
        final boolean h = this.h;
        boolean willNotDraw = true;
        Label_0120: {
            if (h) {
                if (this.g == null) {
                    break Label_0120;
                }
            }
            else if (this.e == null && this.f == null) {
                break Label_0120;
            }
            willNotDraw = false;
        }
        this.setWillNotDraw(willNotDraw);
        this.invalidate();
        ActionBarContainer.a.a(this);
    }
    
    public void setSplitBackground(Drawable g) {
        final Drawable g2 = this.g;
        if (g2 != null) {
            g2.setCallback((Drawable$Callback)null);
            this.unscheduleDrawable(this.g);
        }
        this.g = g;
        final boolean b = false;
        if (g != null) {
            g.setCallback((Drawable$Callback)this);
            if (this.h) {
                g = this.g;
                if (g != null) {
                    g.setBounds(0, 0, this.getMeasuredWidth(), this.getMeasuredHeight());
                }
            }
        }
        boolean willNotDraw = false;
        Label_0113: {
            if (this.h) {
                willNotDraw = b;
                if (this.g != null) {
                    break Label_0113;
                }
            }
            else {
                willNotDraw = b;
                if (this.e != null) {
                    break Label_0113;
                }
                willNotDraw = b;
                if (this.f != null) {
                    break Label_0113;
                }
            }
            willNotDraw = true;
        }
        this.setWillNotDraw(willNotDraw);
        this.invalidate();
        ActionBarContainer.a.a(this);
    }
    
    public void setStackedBackground(Drawable f) {
        final Drawable f2 = this.f;
        if (f2 != null) {
            f2.setCallback((Drawable$Callback)null);
            this.unscheduleDrawable(this.f);
        }
        if ((this.f = f) != null) {
            f.setCallback((Drawable$Callback)this);
            if (this.i) {
                f = this.f;
                if (f != null) {
                    f.setBounds(this.b.getLeft(), this.b.getTop(), this.b.getRight(), this.b.getBottom());
                }
            }
        }
        final boolean h = this.h;
        boolean willNotDraw = true;
        Label_0127: {
            if (h) {
                if (this.g == null) {
                    break Label_0127;
                }
            }
            else if (this.e == null && this.f == null) {
                break Label_0127;
            }
            willNotDraw = false;
        }
        this.setWillNotDraw(willNotDraw);
        this.invalidate();
        ActionBarContainer.a.a(this);
    }
    
    public void setTabContainer(final k0 b) {
        final View b2 = this.b;
        if (b2 != null) {
            this.removeView(b2);
        }
        if ((this.b = (View)b) != null) {
            this.addView((View)b);
            final ViewGroup$LayoutParams layoutParams = b.getLayoutParams();
            layoutParams.width = -1;
            layoutParams.height = -2;
            b.setAllowCollapse(false);
        }
    }
    
    public void setTransitioning(final boolean a) {
        this.a = a;
        int descendantFocusability;
        if (a) {
            descendantFocusability = 393216;
        }
        else {
            descendantFocusability = 262144;
        }
        this.setDescendantFocusability(descendantFocusability);
    }
    
    public void setVisibility(final int visibility) {
        super.setVisibility(visibility);
        final boolean b = visibility == 0;
        final Drawable e = this.e;
        if (e != null) {
            e.setVisible(b, false);
        }
        final Drawable f = this.f;
        if (f != null) {
            f.setVisible(b, false);
        }
        final Drawable g = this.g;
        if (g != null) {
            g.setVisible(b, false);
        }
    }
    
    public ActionMode startActionModeForChild(final View view, final ActionMode$Callback actionMode$Callback) {
        return null;
    }
    
    public ActionMode startActionModeForChild(final View view, final ActionMode$Callback actionMode$Callback, final int n) {
        if (n != 0) {
            return super.startActionModeForChild(view, actionMode$Callback, n);
        }
        return null;
    }
    
    protected boolean verifyDrawable(final Drawable drawable) {
        return (drawable == this.e && !this.h) || (drawable == this.f && this.i) || (drawable == this.g && this.h) || super.verifyDrawable(drawable);
    }
    
    private static class a
    {
        public static void a(final ActionBarContainer actionBarContainer) {
            actionBarContainer.invalidateOutline();
        }
    }
}
