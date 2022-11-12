// 
// Decompiled by Procyon v0.6.0
// 

package androidx.appcompat.widget;

import android.view.View$MeasureSpec;
import android.view.MotionEvent;
import android.graphics.drawable.Drawable;
import androidx.appcompat.view.menu.m;
import android.view.View$OnClickListener;
import androidx.appcompat.view.b;
import android.view.ViewGroup$MarginLayoutParams;
import android.view.ViewGroup$LayoutParams;
import androidx.core.view.i0;
import android.text.TextUtils;
import d.f;
import android.view.ViewGroup;
import android.view.LayoutInflater;
import d.g;
import androidx.core.view.b0;
import d.j;
import android.util.AttributeSet;
import android.content.Context;
import android.widget.LinearLayout;
import android.view.View;
import android.widget.TextView;

public class ActionBarContextView extends a
{
    private TextView A;
    private int B;
    private int C;
    private boolean D;
    private int E;
    private CharSequence i;
    private CharSequence j;
    private View p;
    private View w;
    private View x;
    private LinearLayout y;
    private TextView z;
    
    public ActionBarContextView(final Context context) {
        this(context, null);
    }
    
    public ActionBarContextView(final Context context, final AttributeSet set) {
        this(context, set, d.a.j);
    }
    
    public ActionBarContextView(final Context context, final AttributeSet set, final int n) {
        super(context, set, n);
        final r0 v = r0.v(context, set, d.j.y, n, 0);
        b0.t0((View)this, v.g(d.j.z));
        this.B = v.n(d.j.D, 0);
        this.C = v.n(d.j.C, 0);
        super.e = v.m(d.j.B, 0);
        this.E = v.n(d.j.A, d.g.d);
        v.w();
    }
    
    private void i() {
        if (this.y == null) {
            LayoutInflater.from(this.getContext()).inflate(d.g.a, (ViewGroup)this);
            final LinearLayout y = (LinearLayout)this.getChildAt(this.getChildCount() - 1);
            this.y = y;
            this.z = (TextView)y.findViewById(d.f.e);
            this.A = (TextView)this.y.findViewById(d.f.d);
            if (this.B != 0) {
                this.z.setTextAppearance(this.getContext(), this.B);
            }
            if (this.C != 0) {
                this.A.setTextAppearance(this.getContext(), this.C);
            }
        }
        this.z.setText(this.i);
        this.A.setText(this.j);
        final boolean empty = TextUtils.isEmpty(this.i);
        final boolean b = TextUtils.isEmpty(this.j) ^ true;
        final TextView a = this.A;
        final int n = 0;
        int visibility;
        if (b) {
            visibility = 0;
        }
        else {
            visibility = 8;
        }
        a.setVisibility(visibility);
        final LinearLayout y2 = this.y;
        int visibility2 = n;
        if (!(empty ^ true)) {
            if (b) {
                visibility2 = n;
            }
            else {
                visibility2 = 8;
            }
        }
        y2.setVisibility(visibility2);
        if (this.y.getParent() == null) {
            this.addView((View)this.y);
        }
    }
    
    @Override
    public /* bridge */ i0 f(final int n, final long n2) {
        return super.f(n, n2);
    }
    
    public void g() {
        if (this.p == null) {
            this.k();
        }
    }
    
    protected ViewGroup$LayoutParams generateDefaultLayoutParams() {
        return (ViewGroup$LayoutParams)new ViewGroup$MarginLayoutParams(-1, -2);
    }
    
    public ViewGroup$LayoutParams generateLayoutParams(final AttributeSet set) {
        return (ViewGroup$LayoutParams)new ViewGroup$MarginLayoutParams(this.getContext(), set);
    }
    
    @Override
    public /* bridge */ int getAnimatedVisibility() {
        return super.getAnimatedVisibility();
    }
    
    @Override
    public /* bridge */ int getContentHeight() {
        return super.getContentHeight();
    }
    
    public CharSequence getSubtitle() {
        return this.j;
    }
    
    public CharSequence getTitle() {
        return this.i;
    }
    
    public void h(final b b) {
        final View p = this.p;
        if (p == null) {
            this.addView(this.p = LayoutInflater.from(this.getContext()).inflate(this.E, (ViewGroup)this, false));
        }
        else if (p.getParent() == null) {
            this.addView(this.p);
        }
        (this.w = this.p.findViewById(d.f.i)).setOnClickListener((View$OnClickListener)new View$OnClickListener(this, b) {
            final b a;
            final ActionBarContextView b;
            
            public void onClick(final View view) {
                this.a.c();
            }
        });
        final androidx.appcompat.view.menu.g g = (androidx.appcompat.view.menu.g)b.e();
        final ActionMenuPresenter d = super.d;
        if (d != null) {
            d.A();
        }
        (super.d = new ActionMenuPresenter(this.getContext())).L(true);
        final ViewGroup$LayoutParams viewGroup$LayoutParams = new ViewGroup$LayoutParams(-2, -1);
        g.c(super.d, super.b);
        b0.t0((View)(super.c = (ActionMenuView)super.d.q(this)), null);
        this.addView((View)super.c, viewGroup$LayoutParams);
    }
    
    public boolean j() {
        return this.D;
    }
    
    public void k() {
        this.removeAllViews();
        this.x = null;
        super.c = null;
        super.d = null;
        final View w = this.w;
        if (w != null) {
            w.setOnClickListener((View$OnClickListener)null);
        }
    }
    
    public boolean l() {
        final ActionMenuPresenter d = super.d;
        return d != null && d.M();
    }
    
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        final ActionMenuPresenter d = super.d;
        if (d != null) {
            d.D();
            super.d.E();
        }
    }
    
    @Override
    public /* bridge */ boolean onHoverEvent(final MotionEvent motionEvent) {
        return super.onHoverEvent(motionEvent);
    }
    
    protected void onLayout(final boolean b, int paddingLeft, int n, final int n2, int n3) {
        final boolean b2 = w0.b((View)this);
        int paddingLeft2;
        if (b2) {
            paddingLeft2 = n2 - paddingLeft - this.getPaddingRight();
        }
        else {
            paddingLeft2 = this.getPaddingLeft();
        }
        final int paddingTop = this.getPaddingTop();
        final int n4 = n3 - n - this.getPaddingTop() - this.getPaddingBottom();
        final View p5 = this.p;
        n = paddingLeft2;
        if (p5 != null) {
            n = paddingLeft2;
            if (p5.getVisibility() != 8) {
                final ViewGroup$MarginLayoutParams viewGroup$MarginLayoutParams = (ViewGroup$MarginLayoutParams)this.p.getLayoutParams();
                if (b2) {
                    n = viewGroup$MarginLayoutParams.rightMargin;
                }
                else {
                    n = viewGroup$MarginLayoutParams.leftMargin;
                }
                if (b2) {
                    n3 = viewGroup$MarginLayoutParams.leftMargin;
                }
                else {
                    n3 = viewGroup$MarginLayoutParams.rightMargin;
                }
                n = androidx.appcompat.widget.a.d(paddingLeft2, n, b2);
                n = androidx.appcompat.widget.a.d(n + this.e(this.p, n, paddingTop, n4, b2), n3, b2);
            }
        }
        final LinearLayout y = this.y;
        n3 = n;
        if (y != null) {
            n3 = n;
            if (this.x == null) {
                n3 = n;
                if (y.getVisibility() != 8) {
                    n3 = n + this.e((View)this.y, n, paddingTop, n4, b2);
                }
            }
        }
        final View x = this.x;
        if (x != null) {
            this.e(x, n3, paddingTop, n4, b2);
        }
        if (b2) {
            paddingLeft = this.getPaddingLeft();
        }
        else {
            paddingLeft = n2 - paddingLeft - this.getPaddingRight();
        }
        final ActionMenuView c = super.c;
        if (c != null) {
            this.e((View)c, paddingLeft, paddingTop, n4, b2 ^ true);
        }
    }
    
    protected void onMeasure(int i, int n) {
        final int mode = View$MeasureSpec.getMode(i);
        final int n2 = 1073741824;
        if (mode != 1073741824) {
            final StringBuilder sb = new StringBuilder();
            sb.append(this.getClass().getSimpleName());
            sb.append(" can only be used with android:layout_width=\"match_parent\" (or fill_parent)");
            throw new IllegalStateException(sb.toString());
        }
        if (View$MeasureSpec.getMode(n) != 0) {
            final int size = View$MeasureSpec.getSize(i);
            int n3 = super.e;
            if (n3 <= 0) {
                n3 = View$MeasureSpec.getSize(n);
            }
            final int n4 = this.getPaddingTop() + this.getPaddingBottom();
            i = size - this.getPaddingLeft() - this.getPaddingRight();
            final int n5 = n3 - n4;
            final int measureSpec = View$MeasureSpec.makeMeasureSpec(n5, Integer.MIN_VALUE);
            final View p2 = this.p;
            final int n6 = 0;
            n = i;
            if (p2 != null) {
                i = this.c(p2, i, measureSpec, 0);
                final ViewGroup$MarginLayoutParams viewGroup$MarginLayoutParams = (ViewGroup$MarginLayoutParams)this.p.getLayoutParams();
                n = i - (viewGroup$MarginLayoutParams.leftMargin + viewGroup$MarginLayoutParams.rightMargin);
            }
            final ActionMenuView c = super.c;
            i = n;
            if (c != null) {
                i = n;
                if (c.getParent() == this) {
                    i = this.c((View)super.c, n, measureSpec, 0);
                }
            }
            final LinearLayout y = this.y;
            n = i;
            if (y != null) {
                n = i;
                if (this.x == null) {
                    if (this.D) {
                        n = View$MeasureSpec.makeMeasureSpec(0, 0);
                        this.y.measure(n, measureSpec);
                        final int measuredWidth = this.y.getMeasuredWidth();
                        final boolean b = measuredWidth <= i;
                        n = i;
                        if (b) {
                            n = i - measuredWidth;
                        }
                        final LinearLayout y2 = this.y;
                        if (b) {
                            i = 0;
                        }
                        else {
                            i = 8;
                        }
                        y2.setVisibility(i);
                    }
                    else {
                        n = this.c((View)y, i, measureSpec, 0);
                    }
                }
            }
            final View x = this.x;
            if (x != null) {
                final ViewGroup$LayoutParams layoutParams = x.getLayoutParams();
                final int width = layoutParams.width;
                if (width != -2) {
                    i = 1073741824;
                }
                else {
                    i = Integer.MIN_VALUE;
                }
                int min = n;
                if (width >= 0) {
                    min = Math.min(width, n);
                }
                final int height = layoutParams.height;
                if (height != -2) {
                    n = n2;
                }
                else {
                    n = Integer.MIN_VALUE;
                }
                int min2 = n5;
                if (height >= 0) {
                    min2 = Math.min(height, n5);
                }
                this.x.measure(View$MeasureSpec.makeMeasureSpec(min, i), View$MeasureSpec.makeMeasureSpec(min2, n));
            }
            if (super.e <= 0) {
                final int childCount = this.getChildCount();
                n = 0;
                int n7;
                int n8;
                for (i = n6; i < childCount; ++i, n = n8) {
                    n7 = this.getChildAt(i).getMeasuredHeight() + n4;
                    if (n7 > (n8 = n)) {
                        n8 = n7;
                    }
                }
                this.setMeasuredDimension(size, n);
            }
            else {
                this.setMeasuredDimension(size, n3);
            }
            return;
        }
        final StringBuilder sb2 = new StringBuilder();
        sb2.append(this.getClass().getSimpleName());
        sb2.append(" can only be used with android:layout_height=\"wrap_content\"");
        throw new IllegalStateException(sb2.toString());
    }
    
    @Override
    public /* bridge */ boolean onTouchEvent(final MotionEvent motionEvent) {
        return super.onTouchEvent(motionEvent);
    }
    
    @Override
    public void setContentHeight(final int e) {
        super.e = e;
    }
    
    public void setCustomView(final View x) {
        final View x2 = this.x;
        if (x2 != null) {
            this.removeView(x2);
        }
        if ((this.x = x) != null) {
            final LinearLayout y = this.y;
            if (y != null) {
                this.removeView((View)y);
                this.y = null;
            }
        }
        if (x != null) {
            this.addView(x);
        }
        this.requestLayout();
    }
    
    public void setSubtitle(final CharSequence j) {
        this.j = j;
        this.i();
    }
    
    public void setTitle(final CharSequence i) {
        this.i = i;
        this.i();
        b0.s0((View)this, i);
    }
    
    public void setTitleOptional(final boolean d) {
        if (d != this.D) {
            this.requestLayout();
        }
        this.D = d;
    }
    
    @Override
    public /* bridge */ void setVisibility(final int visibility) {
        super.setVisibility(visibility);
    }
    
    public boolean shouldDelayChildPressedState() {
        return false;
    }
}
