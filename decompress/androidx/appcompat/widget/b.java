// 
// Decompiled by Procyon v0.6.0
// 

package androidx.appcompat.widget;

import android.graphics.ColorFilter;
import android.graphics.Outline;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;

class b extends Drawable
{
    final ActionBarContainer a;
    
    public b(final ActionBarContainer a) {
        this.a = a;
    }
    
    public void draw(final Canvas canvas) {
        final ActionBarContainer a = this.a;
        if (a.h) {
            final Drawable g = a.g;
            if (g != null) {
                g.draw(canvas);
            }
        }
        else {
            final Drawable e = a.e;
            if (e != null) {
                e.draw(canvas);
            }
            final ActionBarContainer a2 = this.a;
            final Drawable f = a2.f;
            if (f != null && a2.i) {
                f.draw(canvas);
            }
        }
    }
    
    public int getOpacity() {
        return 0;
    }
    
    public void getOutline(final Outline outline) {
        final ActionBarContainer a = this.a;
        if (a.h) {
            if (a.g != null) {
                b.a.a(a.e, outline);
            }
        }
        else {
            final Drawable e = a.e;
            if (e != null) {
                b.a.a(e, outline);
            }
        }
    }
    
    public void setAlpha(final int n) {
    }
    
    public void setColorFilter(final ColorFilter colorFilter) {
    }
    
    private static class a
    {
        public static void a(final Drawable drawable, final Outline outline) {
            drawable.getOutline(outline);
        }
    }
}
