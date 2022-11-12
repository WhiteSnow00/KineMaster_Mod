// 
// Decompiled by Procyon v0.6.0
// 

package androidx.appcompat.widget;

import android.util.DisplayMetrics;
import android.view.View$MeasureSpec;
import android.view.View;
import androidx.core.view.b0;
import android.util.AttributeSet;
import android.content.Context;
import android.graphics.Rect;
import android.util.TypedValue;
import android.widget.FrameLayout;

public class ContentFrameLayout extends FrameLayout
{
    private TypedValue a;
    private TypedValue b;
    private TypedValue c;
    private TypedValue d;
    private TypedValue e;
    private TypedValue f;
    private final Rect g;
    private a h;
    
    public ContentFrameLayout(final Context context) {
        this(context, null);
    }
    
    public ContentFrameLayout(final Context context, final AttributeSet set) {
        this(context, set, 0);
    }
    
    public ContentFrameLayout(final Context context, final AttributeSet set, final int n) {
        super(context, set, n);
        this.g = new Rect();
    }
    
    public void a(final int n, final int n2, final int n3, final int n4) {
        this.g.set(n, n2, n3, n4);
        if (b0.T((View)this)) {
            this.requestLayout();
        }
    }
    
    public TypedValue getFixedHeightMajor() {
        if (this.e == null) {
            this.e = new TypedValue();
        }
        return this.e;
    }
    
    public TypedValue getFixedHeightMinor() {
        if (this.f == null) {
            this.f = new TypedValue();
        }
        return this.f;
    }
    
    public TypedValue getFixedWidthMajor() {
        if (this.c == null) {
            this.c = new TypedValue();
        }
        return this.c;
    }
    
    public TypedValue getFixedWidthMinor() {
        if (this.d == null) {
            this.d = new TypedValue();
        }
        return this.d;
    }
    
    public TypedValue getMinWidthMajor() {
        if (this.a == null) {
            this.a = new TypedValue();
        }
        return this.a;
    }
    
    public TypedValue getMinWidthMinor() {
        if (this.b == null) {
            this.b = new TypedValue();
        }
        return this.b;
    }
    
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        final a h = this.h;
        if (h != null) {
            h.a();
        }
    }
    
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        final a h = this.h;
        if (h != null) {
            h.onDetachedFromWindow();
        }
    }
    
    protected void onMeasure(int n, int n2) {
        final DisplayMetrics displayMetrics = this.getContext().getResources().getDisplayMetrics();
        final int widthPixels = displayMetrics.widthPixels;
        final int heightPixels = displayMetrics.heightPixels;
        final int n3 = 1;
        final boolean b = widthPixels < heightPixels;
        final int mode = View$MeasureSpec.getMode(n);
        final int mode2 = View$MeasureSpec.getMode(n2);
        int measureSpec = 0;
        Label_0207: {
            if (mode == Integer.MIN_VALUE) {
                TypedValue typedValue;
                if (b) {
                    typedValue = this.d;
                }
                else {
                    typedValue = this.c;
                }
                if (typedValue != null) {
                    final int type = typedValue.type;
                    if (type != 0) {
                        int n5 = 0;
                        Label_0154: {
                            float n4;
                            if (type == 5) {
                                n4 = typedValue.getDimension(displayMetrics);
                            }
                            else {
                                if (type != 6) {
                                    n5 = 0;
                                    break Label_0154;
                                }
                                final int widthPixels2 = displayMetrics.widthPixels;
                                n4 = typedValue.getFraction((float)widthPixels2, (float)widthPixels2);
                            }
                            n5 = (int)n4;
                        }
                        if (n5 > 0) {
                            final Rect g = this.g;
                            measureSpec = View$MeasureSpec.makeMeasureSpec(Math.min(n5 - (g.left + g.right), View$MeasureSpec.getSize(n)), 1073741824);
                            n = 1;
                            break Label_0207;
                        }
                    }
                }
            }
            final int n6 = 0;
            measureSpec = n;
            n = n6;
        }
        int measureSpec2 = n2;
        if (mode2 == Integer.MIN_VALUE) {
            TypedValue typedValue2;
            if (b) {
                typedValue2 = this.e;
            }
            else {
                typedValue2 = this.f;
            }
            measureSpec2 = n2;
            if (typedValue2 != null) {
                final int type2 = typedValue2.type;
                measureSpec2 = n2;
                if (type2 != 0) {
                    int n8 = 0;
                    Label_0313: {
                        float n7;
                        if (type2 == 5) {
                            n7 = typedValue2.getDimension(displayMetrics);
                        }
                        else {
                            if (type2 != 6) {
                                n8 = 0;
                                break Label_0313;
                            }
                            final int heightPixels2 = displayMetrics.heightPixels;
                            n7 = typedValue2.getFraction((float)heightPixels2, (float)heightPixels2);
                        }
                        n8 = (int)n7;
                    }
                    measureSpec2 = n2;
                    if (n8 > 0) {
                        final Rect g2 = this.g;
                        measureSpec2 = View$MeasureSpec.makeMeasureSpec(Math.min(n8 - (g2.top + g2.bottom), View$MeasureSpec.getSize(n2)), 1073741824);
                    }
                }
            }
        }
        super.onMeasure(measureSpec, measureSpec2);
        final int measuredWidth = this.getMeasuredWidth();
        final int measureSpec3 = View$MeasureSpec.makeMeasureSpec(measuredWidth, 1073741824);
        Label_0520: {
            if (n == 0 && mode == Integer.MIN_VALUE) {
                TypedValue typedValue3;
                if (b) {
                    typedValue3 = this.b;
                }
                else {
                    typedValue3 = this.a;
                }
                if (typedValue3 != null) {
                    n = typedValue3.type;
                    if (n != 0) {
                        Label_0470: {
                            float n9;
                            if (n == 5) {
                                n9 = typedValue3.getDimension(displayMetrics);
                            }
                            else {
                                if (n != 6) {
                                    n = 0;
                                    break Label_0470;
                                }
                                n = displayMetrics.widthPixels;
                                n9 = typedValue3.getFraction((float)n, (float)n);
                            }
                            n = (int)n9;
                        }
                        n2 = n;
                        if (n > 0) {
                            final Rect g3 = this.g;
                            n2 = n - (g3.left + g3.right);
                        }
                        if (measuredWidth < n2) {
                            n = View$MeasureSpec.makeMeasureSpec(n2, 1073741824);
                            n2 = n3;
                            break Label_0520;
                        }
                    }
                }
            }
            n2 = 0;
            n = measureSpec3;
        }
        if (n2 != 0) {
            super.onMeasure(n, measureSpec2);
        }
    }
    
    public void setAttachListener(final a h) {
        this.h = h;
    }
    
    public interface a
    {
        void a();
        
        void onDetachedFromWindow();
    }
}
