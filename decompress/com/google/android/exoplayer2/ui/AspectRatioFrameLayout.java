// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.exoplayer2.ui;

import android.content.res.TypedArray;
import java.lang.annotation.ElementType;
import java.lang.annotation.Target;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Retention;
import java.lang.annotation.Documented;
import android.view.View$MeasureSpec;
import android.util.AttributeSet;
import android.content.Context;
import android.widget.FrameLayout;

public final class AspectRatioFrameLayout extends FrameLayout
{
    private final b a;
    private AspectRatioListener b;
    private float c;
    private int d;
    
    public AspectRatioFrameLayout(Context obtainStyledAttributes, final AttributeSet set) {
        super(obtainStyledAttributes, set);
        this.d = 0;
        if (set != null) {
            obtainStyledAttributes = (Context)obtainStyledAttributes.getTheme().obtainStyledAttributes(set, R.styleable.a, 0, 0);
            try {
                this.d = ((TypedArray)obtainStyledAttributes).getInt(R.styleable.b, 0);
            }
            finally {
                ((TypedArray)obtainStyledAttributes).recycle();
            }
        }
        this.a = new b(null);
    }
    
    static AspectRatioListener a(final AspectRatioFrameLayout aspectRatioFrameLayout) {
        return aspectRatioFrameLayout.b;
    }
    
    public int getResizeMode() {
        return this.d;
    }
    
    protected void onMeasure(int measuredHeight, int measuredWidth) {
        super.onMeasure(measuredHeight, measuredWidth);
        if (this.c <= 0.0f) {
            return;
        }
        measuredWidth = this.getMeasuredWidth();
        measuredHeight = this.getMeasuredHeight();
        final float n = (float)measuredWidth;
        final float n2 = (float)measuredHeight;
        final float n3 = n / n2;
        final float n4 = this.c / n3 - 1.0f;
        if (Math.abs(n4) <= 0.01f) {
            this.a.a(this.c, n3, false);
            return;
        }
        final int d = this.d;
        Label_0180: {
            float n5 = 0.0f;
            Label_0149: {
                float n6;
                if (d != 0) {
                    if (d == 1) {
                        n5 = this.c;
                        break Label_0149;
                    }
                    if (d != 2) {
                        if (d != 4) {
                            break Label_0180;
                        }
                        if (n4 <= 0.0f) {
                            n5 = this.c;
                            break Label_0149;
                        }
                        n6 = this.c;
                    }
                    else {
                        n6 = this.c;
                    }
                }
                else {
                    if (n4 > 0.0f) {
                        n5 = this.c;
                        break Label_0149;
                    }
                    n6 = this.c;
                }
                measuredWidth = (int)(n2 * n6);
                break Label_0180;
            }
            measuredHeight = (int)(n / n5);
        }
        this.a.a(this.c, n3, true);
        super.onMeasure(View$MeasureSpec.makeMeasureSpec(measuredWidth, 1073741824), View$MeasureSpec.makeMeasureSpec(measuredHeight, 1073741824));
    }
    
    public void setAspectRatio(final float c) {
        if (this.c != c) {
            this.c = c;
            this.requestLayout();
        }
    }
    
    public void setAspectRatioListener(final AspectRatioListener b) {
        this.b = b;
    }
    
    public void setResizeMode(final int d) {
        if (this.d != d) {
            this.d = d;
            this.requestLayout();
        }
    }
    
    public interface AspectRatioListener
    {
        void a(final float p0, final float p1, final boolean p2);
    }
    
    @Documented
    @Retention(RetentionPolicy.SOURCE)
    @Target({ ElementType.TYPE_USE })
    public @interface ResizeMode {
    }
    
    private final class b implements Runnable
    {
        private float a;
        private float b;
        private boolean c;
        private boolean d;
        final AspectRatioFrameLayout e;
        
        private b(final AspectRatioFrameLayout e) {
            this.e = e;
        }
        
        b(final AspectRatioFrameLayout aspectRatioFrameLayout, final AspectRatioFrameLayout$a object) {
            this(aspectRatioFrameLayout);
        }
        
        public void a(final float a, final float b, final boolean c) {
            this.a = a;
            this.b = b;
            this.c = c;
            if (!this.d) {
                this.d = true;
                this.e.post((Runnable)this);
            }
        }
        
        @Override
        public void run() {
            this.d = false;
            if (AspectRatioFrameLayout.a(this.e) == null) {
                return;
            }
            AspectRatioFrameLayout.a(this.e).a(this.a, this.b, this.c);
        }
    }
}
