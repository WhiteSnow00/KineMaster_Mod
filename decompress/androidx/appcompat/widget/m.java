// 
// Decompiled by Procyon v0.6.0
// 

package androidx.appcompat.widget;

import android.content.Context;
import e.a;
import android.view.View;
import androidx.core.view.b0;
import android.util.AttributeSet;
import android.graphics.drawable.RippleDrawable;
import android.graphics.PorterDuff$Mode;
import android.content.res.ColorStateList;
import androidx.core.widget.j;
import android.graphics.drawable.Drawable;
import android.widget.ImageView;

public class m
{
    private final ImageView a;
    private p0 b;
    private p0 c;
    private p0 d;
    private int e;
    
    public m(final ImageView a) {
        this.e = 0;
        this.a = a;
    }
    
    private boolean a(final Drawable drawable) {
        if (this.d == null) {
            this.d = new p0();
        }
        final p0 d = this.d;
        d.a();
        final ColorStateList a = j.a(this.a);
        if (a != null) {
            d.d = true;
            d.a = a;
        }
        final PorterDuff$Mode b = j.b(this.a);
        if (b != null) {
            d.c = true;
            d.b = b;
        }
        if (!d.d && !d.c) {
            return false;
        }
        h.i(drawable, d, this.a.getDrawableState());
        return true;
    }
    
    private boolean l() {
        return this.b != null;
    }
    
    void b() {
        if (this.a.getDrawable() != null) {
            this.a.getDrawable().setLevel(this.e);
        }
    }
    
    void c() {
        final Drawable drawable = this.a.getDrawable();
        if (drawable != null) {
            a0.b(drawable);
        }
        if (drawable != null) {
            if (this.l() && this.a(drawable)) {
                return;
            }
            final p0 c = this.c;
            if (c != null) {
                h.i(drawable, c, this.a.getDrawableState());
            }
            else {
                final p0 b = this.b;
                if (b != null) {
                    h.i(drawable, b, this.a.getDrawableState());
                }
            }
        }
    }
    
    ColorStateList d() {
        final p0 c = this.c;
        ColorStateList a;
        if (c != null) {
            a = c.a;
        }
        else {
            a = null;
        }
        return a;
    }
    
    PorterDuff$Mode e() {
        final p0 c = this.c;
        PorterDuff$Mode b;
        if (c != null) {
            b = c.b;
        }
        else {
            b = null;
        }
        return b;
    }
    
    boolean f() {
        return !(this.a.getBackground() instanceof RippleDrawable);
    }
    
    public void g(final AttributeSet set, int n) {
        final Context context = this.a.getContext();
        final int[] p2 = d.j.P;
        final r0 v = r0.v(context, set, p2, n, 0);
        final ImageView a = this.a;
        b0.n0((View)a, a.getContext(), p2, set, v.r(), n, 0);
        try {
            Drawable drawable2;
            final Drawable drawable = drawable2 = this.a.getDrawable();
            if (drawable == null) {
                n = v.n(d.j.Q, -1);
                drawable2 = drawable;
                if (n != -1) {
                    final Drawable b = e.a.b(this.a.getContext(), n);
                    if ((drawable2 = b) != null) {
                        this.a.setImageDrawable(b);
                        drawable2 = b;
                    }
                }
            }
            if (drawable2 != null) {
                a0.b(drawable2);
            }
            n = d.j.R;
            if (v.s(n)) {
                j.c(this.a, v.c(n));
            }
            n = d.j.S;
            if (v.s(n)) {
                j.d(this.a, a0.e(v.k(n, -1), null));
            }
        }
        finally {
            v.w();
        }
    }
    
    void h(final Drawable drawable) {
        this.e = drawable.getLevel();
    }
    
    public void i(final int n) {
        if (n != 0) {
            final Drawable b = e.a.b(this.a.getContext(), n);
            if (b != null) {
                a0.b(b);
            }
            this.a.setImageDrawable(b);
        }
        else {
            this.a.setImageDrawable((Drawable)null);
        }
        this.c();
    }
    
    void j(final ColorStateList a) {
        if (this.c == null) {
            this.c = new p0();
        }
        final p0 c = this.c;
        c.a = a;
        c.d = true;
        this.c();
    }
    
    void k(final PorterDuff$Mode b) {
        if (this.c == null) {
            this.c = new p0();
        }
        final p0 c = this.c;
        c.b = b;
        c.c = true;
        this.c();
    }
}
