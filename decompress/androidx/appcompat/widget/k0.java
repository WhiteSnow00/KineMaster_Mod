// 
// Decompiled by Procyon v0.6.0
// 

package androidx.appcompat.widget;

import android.view.accessibility.AccessibilityNodeInfo;
import android.view.accessibility.AccessibilityEvent;
import android.view.ViewParent;
import android.text.TextUtils$TruncateAt;
import android.text.TextUtils;
import android.widget.LinearLayout$LayoutParams;
import android.content.Context;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.LinearLayout;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.view.View$MeasureSpec;
import android.widget.AdapterView;
import android.content.res.Configuration;
import android.view.View$OnClickListener;
import android.widget.AbsListView$LayoutParams;
import android.graphics.drawable.Drawable;
import android.widget.SpinnerAdapter;
import android.view.View;
import android.view.ViewGroup$LayoutParams;
import android.util.AttributeSet;
import d.a;
import android.view.animation.DecelerateInterpolator;
import android.widget.Spinner;
import android.view.animation.Interpolator;
import android.widget.AdapterView$OnItemSelectedListener;
import android.widget.HorizontalScrollView;

public class k0 extends HorizontalScrollView implements AdapterView$OnItemSelectedListener
{
    private static final Interpolator j;
    Runnable a;
    private c b;
    LinearLayoutCompat c;
    private Spinner d;
    private boolean e;
    int f;
    int g;
    private int h;
    private int i;
    
    static {
        j = (Interpolator)new DecelerateInterpolator();
    }
    
    private Spinner b() {
        final AppCompatSpinner appCompatSpinner = new AppCompatSpinner(this.getContext(), null, d.a.h);
        appCompatSpinner.setLayoutParams((ViewGroup$LayoutParams)new LinearLayoutCompat.a(-2, -1));
        appCompatSpinner.setOnItemSelectedListener((AdapterView$OnItemSelectedListener)this);
        return appCompatSpinner;
    }
    
    private boolean d() {
        final Spinner d = this.d;
        return d != null && d.getParent() == this;
    }
    
    private void e() {
        if (this.d()) {
            return;
        }
        if (this.d == null) {
            this.d = this.b();
        }
        this.removeView((View)this.c);
        this.addView((View)this.d, new ViewGroup$LayoutParams(-2, -1));
        if (this.d.getAdapter() == null) {
            this.d.setAdapter((SpinnerAdapter)new b());
        }
        final Runnable a = this.a;
        if (a != null) {
            this.removeCallbacks(a);
            this.a = null;
        }
        this.d.setSelection(this.i);
    }
    
    private boolean f() {
        if (!this.d()) {
            return false;
        }
        this.removeView((View)this.d);
        this.addView((View)this.c, new ViewGroup$LayoutParams(-2, -1));
        this.setTabSelected(this.d.getSelectedItemPosition());
        return false;
    }
    
    public void a(final int n) {
        final View child = this.c.getChildAt(n);
        final Runnable a = this.a;
        if (a != null) {
            this.removeCallbacks(a);
        }
        this.post(this.a = new Runnable(this, child) {
            final View a;
            final k0 b;
            
            @Override
            public void run() {
                this.b.smoothScrollTo(this.a.getLeft() - (this.b.getWidth() - this.a.getWidth()) / 2, 0);
                this.b.a = null;
            }
        });
    }
    
    d c(final androidx.appcompat.app.a.c c, final boolean b) {
        final d d = new d(this.getContext(), c, b);
        if (b) {
            d.setBackgroundDrawable((Drawable)null);
            d.setLayoutParams((ViewGroup$LayoutParams)new AbsListView$LayoutParams(-1, this.h));
        }
        else {
            d.setFocusable(true);
            if (this.b == null) {
                this.b = new c();
            }
            d.setOnClickListener((View$OnClickListener)this.b);
        }
        return d;
    }
    
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        final Runnable a = this.a;
        if (a != null) {
            this.post(a);
        }
    }
    
    protected void onConfigurationChanged(final Configuration configuration) {
        super.onConfigurationChanged(configuration);
        final androidx.appcompat.view.a b = androidx.appcompat.view.a.b(this.getContext());
        this.setContentHeight(b.f());
        this.g = b.e();
    }
    
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        final Runnable a = this.a;
        if (a != null) {
            this.removeCallbacks(a);
        }
    }
    
    public void onItemSelected(final AdapterView<?> adapterView, final View view, final int n, final long n2) {
        ((d)view).b().e();
    }
    
    public void onMeasure(int measuredWidth, int measuredWidth2) {
        final int mode = View$MeasureSpec.getMode(measuredWidth);
        measuredWidth2 = 1;
        final boolean fillViewport = mode == 1073741824;
        this.setFillViewport(fillViewport);
        final int childCount = this.c.getChildCount();
        if (childCount > 1 && (mode == 1073741824 || mode == Integer.MIN_VALUE)) {
            if (childCount > 2) {
                this.f = (int)(View$MeasureSpec.getSize(measuredWidth) * 0.4f);
            }
            else {
                this.f = View$MeasureSpec.getSize(measuredWidth) / 2;
            }
            this.f = Math.min(this.f, this.g);
        }
        else {
            this.f = -1;
        }
        final int measureSpec = View$MeasureSpec.makeMeasureSpec(this.h, 1073741824);
        if (fillViewport || !this.e) {
            measuredWidth2 = 0;
        }
        if (measuredWidth2 != 0) {
            this.c.measure(0, measureSpec);
            if (this.c.getMeasuredWidth() > View$MeasureSpec.getSize(measuredWidth)) {
                this.e();
            }
            else {
                this.f();
            }
        }
        else {
            this.f();
        }
        measuredWidth2 = this.getMeasuredWidth();
        super.onMeasure(measuredWidth, measureSpec);
        measuredWidth = this.getMeasuredWidth();
        if (fillViewport && measuredWidth2 != measuredWidth) {
            this.setTabSelected(this.i);
        }
    }
    
    public void onNothingSelected(final AdapterView<?> adapterView) {
    }
    
    public void setAllowCollapse(final boolean e) {
        this.e = e;
    }
    
    public void setContentHeight(final int h) {
        this.h = h;
        this.requestLayout();
    }
    
    public void setTabSelected(final int n) {
        this.i = n;
        for (int childCount = this.c.getChildCount(), i = 0; i < childCount; ++i) {
            final View child = this.c.getChildAt(i);
            final boolean selected = i == n;
            child.setSelected(selected);
            if (selected) {
                this.a(n);
            }
        }
        final Spinner d = this.d;
        if (d != null && n >= 0) {
            d.setSelection(n);
        }
    }
    
    private class b extends BaseAdapter
    {
        final k0 a;
        
        b(final k0 a) {
            this.a = a;
        }
        
        public int getCount() {
            return this.a.c.getChildCount();
        }
        
        public Object getItem(final int n) {
            return ((d)this.a.c.getChildAt(n)).b();
        }
        
        public long getItemId(final int n) {
            return n;
        }
        
        public View getView(final int n, View c, final ViewGroup viewGroup) {
            if (c == null) {
                c = (View)this.a.c((androidx.appcompat.app.a.c)this.getItem(n), true);
            }
            else {
                ((d)c).a((androidx.appcompat.app.a.c)this.getItem(n));
            }
            return c;
        }
    }
    
    private class c implements View$OnClickListener
    {
        final k0 a;
        
        c(final k0 a) {
            this.a = a;
        }
        
        public void onClick(final View view) {
            ((d)view).b().e();
            for (int childCount = this.a.c.getChildCount(), i = 0; i < childCount; ++i) {
                final View child = this.a.c.getChildAt(i);
                child.setSelected(child == view);
            }
        }
    }
    
    private class d extends LinearLayout
    {
        private final int[] a;
        private androidx.appcompat.app.a.c b;
        private TextView c;
        private ImageView d;
        private View e;
        final k0 f;
        
        public d(final k0 f, final Context context, final androidx.appcompat.app.a.c b, final boolean b2) {
            this.f = f;
            final int d = d.a.d;
            super(context, (AttributeSet)null, d);
            final int[] a = { 16842964 };
            this.a = a;
            this.b = b;
            final r0 v = r0.v(context, null, a, d, 0);
            if (v.s(0)) {
                this.setBackgroundDrawable(v.g(0));
            }
            v.w();
            if (b2) {
                this.setGravity(8388627);
            }
            this.c();
        }
        
        public void a(final androidx.appcompat.app.a.c b) {
            this.b = b;
            this.c();
        }
        
        public androidx.appcompat.app.a.c b() {
            return this.b;
        }
        
        public void c() {
            final androidx.appcompat.app.a.c b = this.b;
            final View b2 = b.b();
            CharSequence a = null;
            if (b2 != null) {
                final ViewParent parent = b2.getParent();
                if (parent != this) {
                    if (parent != null) {
                        ((ViewGroup)parent).removeView(b2);
                    }
                    this.addView(b2);
                }
                this.e = b2;
                final TextView c = this.c;
                if (c != null) {
                    c.setVisibility(8);
                }
                final ImageView d = this.d;
                if (d != null) {
                    d.setVisibility(8);
                    this.d.setImageDrawable((Drawable)null);
                }
            }
            else {
                final View e = this.e;
                if (e != null) {
                    this.removeView(e);
                    this.e = null;
                }
                final Drawable c2 = b.c();
                final CharSequence d2 = b.d();
                if (c2 != null) {
                    if (this.d == null) {
                        final AppCompatImageView d3 = new AppCompatImageView(this.getContext());
                        final LinearLayout$LayoutParams layoutParams = new LinearLayout$LayoutParams(-2, -2);
                        layoutParams.gravity = 16;
                        d3.setLayoutParams((ViewGroup$LayoutParams)layoutParams);
                        this.addView((View)d3, 0);
                        this.d = d3;
                    }
                    this.d.setImageDrawable(c2);
                    this.d.setVisibility(0);
                }
                else {
                    final ImageView d4 = this.d;
                    if (d4 != null) {
                        d4.setVisibility(8);
                        this.d.setImageDrawable((Drawable)null);
                    }
                }
                final boolean b3 = TextUtils.isEmpty(d2) ^ true;
                if (b3) {
                    if (this.c == null) {
                        final AppCompatTextView c3 = new AppCompatTextView(this.getContext(), null, d.a.e);
                        c3.setEllipsize(TextUtils$TruncateAt.END);
                        final LinearLayout$LayoutParams layoutParams2 = new LinearLayout$LayoutParams(-2, -2);
                        layoutParams2.gravity = 16;
                        c3.setLayoutParams((ViewGroup$LayoutParams)layoutParams2);
                        this.addView((View)c3);
                        this.c = c3;
                    }
                    this.c.setText(d2);
                    this.c.setVisibility(0);
                }
                else {
                    final TextView c4 = this.c;
                    if (c4 != null) {
                        c4.setVisibility(8);
                        this.c.setText((CharSequence)null);
                    }
                }
                final ImageView d5 = this.d;
                if (d5 != null) {
                    d5.setContentDescription(b.a());
                }
                if (!b3) {
                    a = b.a();
                }
                u0.a((View)this, a);
            }
        }
        
        public void onInitializeAccessibilityEvent(final AccessibilityEvent accessibilityEvent) {
            super.onInitializeAccessibilityEvent(accessibilityEvent);
            accessibilityEvent.setClassName((CharSequence)"androidx.appcompat.app.ActionBar$Tab");
        }
        
        public void onInitializeAccessibilityNodeInfo(final AccessibilityNodeInfo accessibilityNodeInfo) {
            super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
            accessibilityNodeInfo.setClassName((CharSequence)"androidx.appcompat.app.ActionBar$Tab");
        }
        
        public void onMeasure(int measuredWidth, final int n) {
            super.onMeasure(measuredWidth, n);
            if (this.f.f > 0) {
                measuredWidth = this.getMeasuredWidth();
                final int f = this.f.f;
                if (measuredWidth > f) {
                    super.onMeasure(View$MeasureSpec.makeMeasureSpec(f, 1073741824), n);
                }
            }
        }
        
        public void setSelected(final boolean selected) {
            final boolean b = this.isSelected() != selected;
            super.setSelected(selected);
            if (b && selected) {
                this.sendAccessibilityEvent(4);
            }
        }
    }
}
