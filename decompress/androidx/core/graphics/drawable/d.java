// 
// Decompiled by Procyon v0.6.0
// 

package androidx.core.graphics.drawable;

import android.graphics.ColorFilter;
import android.graphics.Shader;
import android.graphics.Canvas;
import android.graphics.Shader$TileMode;
import android.content.res.Resources;
import android.graphics.RectF;
import android.graphics.Rect;
import android.graphics.Matrix;
import android.graphics.BitmapShader;
import android.graphics.Paint;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;

public abstract class d extends Drawable
{
    final Bitmap a;
    private int b;
    private int c;
    private final Paint d;
    private final BitmapShader e;
    private final Matrix f;
    private float g;
    final Rect h;
    private final RectF i;
    private boolean j;
    private boolean k;
    private int l;
    private int m;
    
    d(final Resources resources, final Bitmap a) {
        this.b = 160;
        this.c = 119;
        this.d = new Paint(3);
        this.f = new Matrix();
        this.h = new Rect();
        this.i = new RectF();
        this.j = true;
        if (resources != null) {
            this.b = resources.getDisplayMetrics().densityDpi;
        }
        if ((this.a = a) != null) {
            this.a();
            final Shader$TileMode clamp = Shader$TileMode.CLAMP;
            this.e = new BitmapShader(a, clamp, clamp);
        }
        else {
            this.m = -1;
            this.l = -1;
            this.e = null;
        }
    }
    
    private void a() {
        this.l = this.a.getScaledWidth(this.b);
        this.m = this.a.getScaledHeight(this.b);
    }
    
    private static boolean d(final float n) {
        return n > 0.05f;
    }
    
    private void g() {
        this.g = (float)(Math.min(this.m, this.l) / 2);
    }
    
    public float b() {
        return this.g;
    }
    
    abstract void c(final int p0, final int p1, final int p2, final Rect p3, final Rect p4);
    
    public void draw(final Canvas canvas) {
        final Bitmap a = this.a;
        if (a == null) {
            return;
        }
        this.h();
        if (this.d.getShader() == null) {
            canvas.drawBitmap(a, (Rect)null, this.h, this.d);
        }
        else {
            final RectF i = this.i;
            final float g = this.g;
            canvas.drawRoundRect(i, g, g, this.d);
        }
    }
    
    public void e(final boolean k) {
        this.k = k;
        this.j = true;
        if (k) {
            this.g();
            this.d.setShader((Shader)this.e);
            this.invalidateSelf();
        }
        else {
            this.f(0.0f);
        }
    }
    
    public void f(final float g) {
        if (this.g == g) {
            return;
        }
        this.k = false;
        if (d(g)) {
            this.d.setShader((Shader)this.e);
        }
        else {
            this.d.setShader((Shader)null);
        }
        this.g = g;
        this.invalidateSelf();
    }
    
    public int getAlpha() {
        return this.d.getAlpha();
    }
    
    public ColorFilter getColorFilter() {
        return this.d.getColorFilter();
    }
    
    public int getIntrinsicHeight() {
        return this.m;
    }
    
    public int getIntrinsicWidth() {
        return this.l;
    }
    
    public int getOpacity() {
        final int c = this.c;
        int n2;
        final int n = n2 = -3;
        if (c == 119) {
            if (this.k) {
                n2 = n;
            }
            else {
                final Bitmap a = this.a;
                n2 = n;
                if (a != null) {
                    n2 = n;
                    if (!a.hasAlpha()) {
                        n2 = n;
                        if (this.d.getAlpha() >= 255) {
                            if (d(this.g)) {
                                n2 = n;
                            }
                            else {
                                n2 = -1;
                            }
                        }
                    }
                }
            }
        }
        return n2;
    }
    
    void h() {
        if (this.j) {
            if (this.k) {
                final int min = Math.min(this.l, this.m);
                this.c(this.c, min, min, this.getBounds(), this.h);
                final int min2 = Math.min(this.h.width(), this.h.height());
                this.h.inset(Math.max(0, (this.h.width() - min2) / 2), Math.max(0, (this.h.height() - min2) / 2));
                this.g = min2 * 0.5f;
            }
            else {
                this.c(this.c, this.l, this.m, this.getBounds(), this.h);
            }
            this.i.set(this.h);
            if (this.e != null) {
                final Matrix f = this.f;
                final RectF i = this.i;
                f.setTranslate(i.left, i.top);
                this.f.preScale(this.i.width() / this.a.getWidth(), this.i.height() / this.a.getHeight());
                this.e.setLocalMatrix(this.f);
                this.d.setShader((Shader)this.e);
            }
            this.j = false;
        }
    }
    
    protected void onBoundsChange(final Rect rect) {
        super.onBoundsChange(rect);
        if (this.k) {
            this.g();
        }
        this.j = true;
    }
    
    public void setAlpha(final int alpha) {
        if (alpha != this.d.getAlpha()) {
            this.d.setAlpha(alpha);
            this.invalidateSelf();
        }
    }
    
    public void setColorFilter(final ColorFilter colorFilter) {
        this.d.setColorFilter(colorFilter);
        this.invalidateSelf();
    }
    
    public void setDither(final boolean dither) {
        this.d.setDither(dither);
        this.invalidateSelf();
    }
    
    public void setFilterBitmap(final boolean filterBitmap) {
        this.d.setFilterBitmap(filterBitmap);
        this.invalidateSelf();
    }
}
