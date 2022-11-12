// 
// Decompiled by Procyon v0.6.0
// 

package androidx.cardview.widget;

import android.view.View$MeasureSpec;
import android.content.res.TypedArray;
import android.content.res.ColorStateList;
import android.graphics.Color;
import m.d;
import android.view.View;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.content.Context;
import android.graphics.Rect;
import android.widget.FrameLayout;

public class CardView extends FrameLayout
{
    private static final int[] h;
    private static final c i;
    private boolean a;
    private boolean b;
    int c;
    int d;
    final Rect e;
    final Rect f;
    private final b g;
    
    static {
        h = new int[] { 16842801 };
        (i = new a()).k();
    }
    
    public CardView(final Context context, final AttributeSet set) {
        this(context, set, m.a.a);
    }
    
    public CardView(final Context context, final AttributeSet set, int n) {
        super(context, set, n);
        final Rect e = new Rect();
        this.e = e;
        this.f = new Rect();
        final b g = new b() {
            private Drawable a;
            final CardView b;
            
            @Override
            public void a(final int n, final int n2, final int n3, final int n4) {
                this.b.f.set(n, n2, n3, n4);
                final CardView b = this.b;
                final Rect e = b.e;
                CardView.e(b, n + e.left, n2 + e.top, n3 + e.right, n4 + e.bottom);
            }
            
            @Override
            public void b(final Drawable drawable) {
                this.a = drawable;
                this.b.setBackgroundDrawable(drawable);
            }
            
            @Override
            public boolean c() {
                return this.b.getUseCompatPadding();
            }
            
            @Override
            public Drawable d() {
                return this.a;
            }
            
            @Override
            public boolean e() {
                return this.b.getPreventCornerOverlap();
            }
            
            @Override
            public View f() {
                return (View)this.b;
            }
        };
        this.g = g;
        final TypedArray obtainStyledAttributes = context.obtainStyledAttributes(set, m.d.a, n, m.c.a);
        n = m.d.d;
        ColorStateList list;
        if (obtainStyledAttributes.hasValue(n)) {
            list = obtainStyledAttributes.getColorStateList(n);
        }
        else {
            final TypedArray obtainStyledAttributes2 = this.getContext().obtainStyledAttributes(CardView.h);
            n = obtainStyledAttributes2.getColor(0, 0);
            obtainStyledAttributes2.recycle();
            final float[] array = new float[3];
            Color.colorToHSV(n, array);
            if (array[2] > 0.5f) {
                n = this.getResources().getColor(m.b.b);
            }
            else {
                n = this.getResources().getColor(m.b.a);
            }
            list = ColorStateList.valueOf(n);
        }
        final float dimension = obtainStyledAttributes.getDimension(m.d.e, 0.0f);
        final float dimension2 = obtainStyledAttributes.getDimension(m.d.f, 0.0f);
        float dimension3 = obtainStyledAttributes.getDimension(m.d.g, 0.0f);
        this.a = obtainStyledAttributes.getBoolean(m.d.i, false);
        this.b = obtainStyledAttributes.getBoolean(m.d.h, true);
        n = obtainStyledAttributes.getDimensionPixelSize(m.d.j, 0);
        e.left = obtainStyledAttributes.getDimensionPixelSize(m.d.l, n);
        e.top = obtainStyledAttributes.getDimensionPixelSize(m.d.n, n);
        e.right = obtainStyledAttributes.getDimensionPixelSize(m.d.m, n);
        e.bottom = obtainStyledAttributes.getDimensionPixelSize(m.d.k, n);
        if (dimension2 > dimension3) {
            dimension3 = dimension2;
        }
        this.c = obtainStyledAttributes.getDimensionPixelSize(m.d.b, 0);
        this.d = obtainStyledAttributes.getDimensionPixelSize(m.d.c, 0);
        obtainStyledAttributes.recycle();
        CardView.i.h(g, context, list, dimension, dimension2, dimension3);
    }
    
    static void e(final CardView cardView, final int n, final int n2, final int n3, final int n4) {
        cardView.setPadding(n, n2, n3, n4);
    }
    
    public ColorStateList getCardBackgroundColor() {
        return CardView.i.e(this.g);
    }
    
    public float getCardElevation() {
        return CardView.i.i(this.g);
    }
    
    public int getContentPaddingBottom() {
        return this.e.bottom;
    }
    
    public int getContentPaddingLeft() {
        return this.e.left;
    }
    
    public int getContentPaddingRight() {
        return this.e.right;
    }
    
    public int getContentPaddingTop() {
        return this.e.top;
    }
    
    public float getMaxCardElevation() {
        return CardView.i.d(this.g);
    }
    
    public boolean getPreventCornerOverlap() {
        return this.b;
    }
    
    public float getRadius() {
        return CardView.i.b(this.g);
    }
    
    public boolean getUseCompatPadding() {
        return this.a;
    }
    
    protected void onMeasure(int measureSpec, int measureSpec2) {
        final c i = CardView.i;
        if (!(i instanceof a)) {
            final int mode = View$MeasureSpec.getMode(measureSpec);
            if (mode == Integer.MIN_VALUE || mode == 1073741824) {
                measureSpec = View$MeasureSpec.makeMeasureSpec(Math.max((int)Math.ceil(i.l(this.g)), View$MeasureSpec.getSize(measureSpec)), mode);
            }
            final int mode2 = View$MeasureSpec.getMode(measureSpec2);
            if (mode2 == Integer.MIN_VALUE || mode2 == 1073741824) {
                measureSpec2 = View$MeasureSpec.makeMeasureSpec(Math.max((int)Math.ceil(i.f(this.g)), View$MeasureSpec.getSize(measureSpec2)), mode2);
            }
            super.onMeasure(measureSpec, measureSpec2);
        }
        else {
            super.onMeasure(measureSpec, measureSpec2);
        }
    }
    
    public void setCardBackgroundColor(final int n) {
        CardView.i.m(this.g, ColorStateList.valueOf(n));
    }
    
    public void setCardBackgroundColor(final ColorStateList list) {
        CardView.i.m(this.g, list);
    }
    
    public void setCardElevation(final float n) {
        CardView.i.c(this.g, n);
    }
    
    public void setMaxCardElevation(final float n) {
        CardView.i.n(this.g, n);
    }
    
    public void setMinimumHeight(final int d) {
        super.setMinimumHeight(this.d = d);
    }
    
    public void setMinimumWidth(final int c) {
        super.setMinimumWidth(this.c = c);
    }
    
    public void setPadding(final int n, final int n2, final int n3, final int n4) {
    }
    
    public void setPaddingRelative(final int n, final int n2, final int n3, final int n4) {
    }
    
    public void setPreventCornerOverlap(final boolean b) {
        if (b != this.b) {
            this.b = b;
            CardView.i.g(this.g);
        }
    }
    
    public void setRadius(final float n) {
        CardView.i.a(this.g, n);
    }
    
    public void setUseCompatPadding(final boolean a) {
        if (this.a != a) {
            this.a = a;
            CardView.i.j(this.g);
        }
    }
}
