// 
// Decompiled by Procyon v0.6.0
// 

package androidx.cardview.widget;

import android.graphics.Outline;
import android.graphics.ColorFilter;
import android.graphics.Canvas;
import android.graphics.PorterDuff$Mode;
import android.graphics.PorterDuffColorFilter;
import android.content.res.ColorStateList;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;

class d extends Drawable
{
    private float a;
    private final Paint b;
    private final RectF c;
    private final Rect d;
    private float e;
    private boolean f;
    private boolean g;
    private ColorStateList h;
    private PorterDuffColorFilter i;
    private ColorStateList j;
    private PorterDuff$Mode k;
    
    d(final ColorStateList list, final float a) {
        this.f = false;
        this.g = true;
        this.k = PorterDuff$Mode.SRC_IN;
        this.a = a;
        this.b = new Paint(5);
        this.e(list);
        this.c = new RectF();
        this.d = new Rect();
    }
    
    private PorterDuffColorFilter a(final ColorStateList list, final PorterDuff$Mode porterDuff$Mode) {
        if (list != null && porterDuff$Mode != null) {
            return new PorterDuffColorFilter(list.getColorForState(this.getState(), 0), porterDuff$Mode);
        }
        return null;
    }
    
    private void e(final ColorStateList list) {
        ColorStateList value = list;
        if (list == null) {
            value = ColorStateList.valueOf(0);
        }
        this.h = value;
        this.b.setColor(value.getColorForState(this.getState(), this.h.getDefaultColor()));
    }
    
    private void i(final Rect rect) {
        Rect bounds = rect;
        if (rect == null) {
            bounds = this.getBounds();
        }
        this.c.set((float)bounds.left, (float)bounds.top, (float)bounds.right, (float)bounds.bottom);
        this.d.set(bounds);
        if (this.f) {
            this.d.inset((int)Math.ceil(androidx.cardview.widget.e.a(this.e, this.a, this.g)), (int)Math.ceil(androidx.cardview.widget.e.b(this.e, this.a, this.g)));
            this.c.set(this.d);
        }
    }
    
    public ColorStateList b() {
        return this.h;
    }
    
    float c() {
        return this.e;
    }
    
    public float d() {
        return this.a;
    }
    
    public void draw(final Canvas canvas) {
        final Paint b = this.b;
        boolean b2;
        if (this.i != null && b.getColorFilter() == null) {
            b.setColorFilter((ColorFilter)this.i);
            b2 = true;
        }
        else {
            b2 = false;
        }
        final RectF c = this.c;
        final float a = this.a;
        canvas.drawRoundRect(c, a, a, b);
        if (b2) {
            b.setColorFilter((ColorFilter)null);
        }
    }
    
    public void f(final ColorStateList list) {
        this.e(list);
        this.invalidateSelf();
    }
    
    void g(final float e, final boolean f, final boolean g) {
        if (e == this.e && this.f == f && this.g == g) {
            return;
        }
        this.e = e;
        this.f = f;
        this.g = g;
        this.i(null);
        this.invalidateSelf();
    }
    
    public int getOpacity() {
        return -3;
    }
    
    public void getOutline(final Outline outline) {
        outline.setRoundRect(this.d, this.a);
    }
    
    void h(final float a) {
        if (a == this.a) {
            return;
        }
        this.a = a;
        this.i(null);
        this.invalidateSelf();
    }
    
    public boolean isStateful() {
        final ColorStateList j = this.j;
        if (j == null || !j.isStateful()) {
            final ColorStateList h = this.h;
            if ((h == null || !h.isStateful()) && !super.isStateful()) {
                return false;
            }
        }
        return true;
    }
    
    protected void onBoundsChange(final Rect rect) {
        super.onBoundsChange(rect);
        this.i(rect);
    }
    
    protected boolean onStateChange(final int[] array) {
        final ColorStateList h = this.h;
        final int colorForState = h.getColorForState(array, h.getDefaultColor());
        final boolean b = colorForState != this.b.getColor();
        if (b) {
            this.b.setColor(colorForState);
        }
        final ColorStateList j = this.j;
        if (j != null) {
            final PorterDuff$Mode k = this.k;
            if (k != null) {
                this.i = this.a(j, k);
                return true;
            }
        }
        return b;
    }
    
    public void setAlpha(final int alpha) {
        this.b.setAlpha(alpha);
    }
    
    public void setColorFilter(final ColorFilter colorFilter) {
        this.b.setColorFilter(colorFilter);
    }
    
    public void setTintList(final ColorStateList j) {
        this.j = j;
        this.i = this.a(j, this.k);
        this.invalidateSelf();
    }
    
    public void setTintMode(final PorterDuff$Mode k) {
        this.k = k;
        this.i = this.a(this.j, k);
        this.invalidateSelf();
    }
}
