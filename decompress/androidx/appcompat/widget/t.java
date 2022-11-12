// 
// Decompiled by Procyon v0.6.0
// 

package androidx.appcompat.widget;

import android.graphics.drawable.Drawable$Callback;
import android.graphics.Canvas;
import android.content.Context;
import android.view.View;
import androidx.core.view.b0;
import d.j;
import android.util.AttributeSet;
import androidx.core.graphics.drawable.a;
import android.widget.ProgressBar;
import android.graphics.PorterDuff$Mode;
import android.content.res.ColorStateList;
import android.graphics.drawable.Drawable;
import android.widget.SeekBar;

class t extends p
{
    private final SeekBar d;
    private Drawable e;
    private ColorStateList f;
    private PorterDuff$Mode g;
    private boolean h;
    private boolean i;
    
    t(final SeekBar d) {
        super((ProgressBar)d);
        this.f = null;
        this.g = null;
        this.h = false;
        this.i = false;
        this.d = d;
    }
    
    private void f() {
        final Drawable e = this.e;
        if (e != null && (this.h || this.i)) {
            final Drawable l = androidx.core.graphics.drawable.a.l(e.mutate());
            this.e = l;
            if (this.h) {
                androidx.core.graphics.drawable.a.i(l, this.f);
            }
            if (this.i) {
                androidx.core.graphics.drawable.a.j(this.e, this.g);
            }
            if (this.e.isStateful()) {
                this.e.setState(this.d.getDrawableState());
            }
        }
    }
    
    @Override
    void c(final AttributeSet set, int n) {
        super.c(set, n);
        final Context context = this.d.getContext();
        final int[] t = j.T;
        final r0 v = r0.v(context, set, t, n, 0);
        final SeekBar d = this.d;
        b0.n0((View)d, d.getContext(), t, set, v.r(), n, 0);
        final Drawable h = v.h(j.U);
        if (h != null) {
            this.d.setThumb(h);
        }
        this.j(v.g(j.V));
        n = j.X;
        if (v.s(n)) {
            this.g = a0.e(v.k(n, -1), this.g);
            this.i = true;
        }
        n = j.W;
        if (v.s(n)) {
            this.f = v.c(n);
            this.h = true;
        }
        v.w();
        this.f();
    }
    
    void g(final Canvas canvas) {
        if (this.e != null) {
            final int max = this.d.getMax();
            int n = 1;
            if (max > 1) {
                final int intrinsicWidth = this.e.getIntrinsicWidth();
                final int intrinsicHeight = this.e.getIntrinsicHeight();
                int n2;
                if (intrinsicWidth >= 0) {
                    n2 = intrinsicWidth / 2;
                }
                else {
                    n2 = 1;
                }
                if (intrinsicHeight >= 0) {
                    n = intrinsicHeight / 2;
                }
                this.e.setBounds(-n2, -n, n2, n);
                final float n3 = (this.d.getWidth() - this.d.getPaddingLeft() - this.d.getPaddingRight()) / (float)max;
                final int save = canvas.save();
                canvas.translate((float)this.d.getPaddingLeft(), (float)(this.d.getHeight() / 2));
                for (int i = 0; i <= max; ++i) {
                    this.e.draw(canvas);
                    canvas.translate(n3, 0.0f);
                }
                canvas.restoreToCount(save);
            }
        }
    }
    
    void h() {
        final Drawable e = this.e;
        if (e != null && e.isStateful() && e.setState(this.d.getDrawableState())) {
            this.d.invalidateDrawable(e);
        }
    }
    
    void i() {
        final Drawable e = this.e;
        if (e != null) {
            e.jumpToCurrentState();
        }
    }
    
    void j(final Drawable e) {
        final Drawable e2 = this.e;
        if (e2 != null) {
            e2.setCallback((Drawable$Callback)null);
        }
        if ((this.e = e) != null) {
            e.setCallback((Drawable$Callback)this.d);
            androidx.core.graphics.drawable.a.g(e, b0.B((View)this.d));
            if (e.isStateful()) {
                e.setState(this.d.getDrawableState());
            }
            this.f();
        }
        this.d.invalidate();
    }
}
