// 
// Decompiled by Procyon v0.6.0
// 

package androidx.appcompat.widget;

import android.view.MotionEvent;
import android.content.res.TypedArray;
import d.j;
import android.content.res.Configuration;
import androidx.core.view.j0;
import androidx.core.view.b0;
import android.view.View$MeasureSpec;
import android.view.View;
import android.view.ContextThemeWrapper;
import android.util.TypedValue;
import android.util.AttributeSet;
import androidx.core.view.i0;
import android.content.Context;
import android.view.ViewGroup;

abstract class a extends ViewGroup
{
    protected final a a;
    protected final Context b;
    protected ActionMenuView c;
    protected ActionMenuPresenter d;
    protected int e;
    protected i0 f;
    private boolean g;
    private boolean h;
    
    a(final Context context, final AttributeSet set) {
        this(context, set, 0);
    }
    
    a(final Context b, final AttributeSet set, final int n) {
        super(b, set, n);
        this.a = new a();
        final TypedValue typedValue = new TypedValue();
        if (b.getTheme().resolveAttribute(d.a.a, typedValue, true) && typedValue.resourceId != 0) {
            this.b = (Context)new ContextThemeWrapper(b, typedValue.resourceId);
        }
        else {
            this.b = b;
        }
    }
    
    static void a(final a a, final int visibility) {
        a.setVisibility(visibility);
    }
    
    static void b(final a a, final int visibility) {
        a.setVisibility(visibility);
    }
    
    protected static int d(int n, final int n2, final boolean b) {
        if (b) {
            n -= n2;
        }
        else {
            n += n2;
        }
        return n;
    }
    
    protected int c(final View view, final int n, final int n2, final int n3) {
        view.measure(View$MeasureSpec.makeMeasureSpec(n, Integer.MIN_VALUE), n2);
        return Math.max(0, n - view.getMeasuredWidth() - n3);
    }
    
    protected int e(final View view, int n, int n2, final int n3, final boolean b) {
        final int measuredWidth = view.getMeasuredWidth();
        final int measuredHeight = view.getMeasuredHeight();
        n2 += (n3 - measuredHeight) / 2;
        if (b) {
            view.layout(n - measuredWidth, n2, n, measuredHeight + n2);
        }
        else {
            view.layout(n, n2, n + measuredWidth, measuredHeight + n2);
        }
        n = measuredWidth;
        if (b) {
            n = -measuredWidth;
        }
        return n;
    }
    
    public i0 f(final int n, final long n2) {
        final i0 f = this.f;
        if (f != null) {
            f.c();
        }
        if (n == 0) {
            if (this.getVisibility() != 0) {
                this.setAlpha(0.0f);
            }
            final i0 b = b0.e((View)this).b(1.0f);
            b.g(n2);
            b.i(this.a.d(b, n));
            return b;
        }
        final i0 b2 = b0.e((View)this).b(0.0f);
        b2.g(n2);
        b2.i(this.a.d(b2, n));
        return b2;
    }
    
    public int getAnimatedVisibility() {
        if (this.f != null) {
            return this.a.b;
        }
        return this.getVisibility();
    }
    
    public int getContentHeight() {
        return this.e;
    }
    
    protected void onConfigurationChanged(final Configuration configuration) {
        super.onConfigurationChanged(configuration);
        final TypedArray obtainStyledAttributes = this.getContext().obtainStyledAttributes((AttributeSet)null, j.a, d.a.c, 0);
        this.setContentHeight(obtainStyledAttributes.getLayoutDimension(j.j, 0));
        obtainStyledAttributes.recycle();
        final ActionMenuPresenter d = this.d;
        if (d != null) {
            d.H(configuration);
        }
    }
    
    public boolean onHoverEvent(final MotionEvent motionEvent) {
        final int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 9) {
            this.h = false;
        }
        if (!this.h) {
            final boolean onHoverEvent = super.onHoverEvent(motionEvent);
            if (actionMasked == 9 && !onHoverEvent) {
                this.h = true;
            }
        }
        if (actionMasked == 10 || actionMasked == 3) {
            this.h = false;
        }
        return true;
    }
    
    public boolean onTouchEvent(final MotionEvent motionEvent) {
        final int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 0) {
            this.g = false;
        }
        if (!this.g) {
            final boolean onTouchEvent = super.onTouchEvent(motionEvent);
            if (actionMasked == 0 && !onTouchEvent) {
                this.g = true;
            }
        }
        if (actionMasked == 1 || actionMasked == 3) {
            this.g = false;
        }
        return true;
    }
    
    public void setContentHeight(final int e) {
        this.e = e;
        this.requestLayout();
    }
    
    public void setVisibility(final int visibility) {
        if (visibility != this.getVisibility()) {
            final i0 f = this.f;
            if (f != null) {
                f.c();
            }
            super.setVisibility(visibility);
        }
    }
    
    protected class a implements j0
    {
        private boolean a;
        int b;
        final androidx.appcompat.widget.a c;
        
        protected a(final androidx.appcompat.widget.a c) {
            this.c = c;
            this.a = false;
        }
        
        @Override
        public void a(final View view) {
            this.a = true;
        }
        
        @Override
        public void b(final View view) {
            if (this.a) {
                return;
            }
            final androidx.appcompat.widget.a c = this.c;
            c.f = null;
            androidx.appcompat.widget.a.b(c, this.b);
        }
        
        @Override
        public void c(final View view) {
            androidx.appcompat.widget.a.a(this.c, 0);
            this.a = false;
        }
        
        public a d(final i0 f, final int b) {
            this.c.f = f;
            this.b = b;
            return this;
        }
    }
}
