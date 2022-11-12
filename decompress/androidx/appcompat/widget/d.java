// 
// Decompiled by Procyon v0.6.0
// 

package androidx.appcompat.widget;

import android.content.Context;
import d.j;
import android.util.AttributeSet;
import android.graphics.PorterDuff$Mode;
import android.content.res.ColorStateList;
import androidx.core.view.b0;
import android.graphics.drawable.Drawable;
import android.view.View;

class d
{
    private final View a;
    private final h b;
    private int c;
    private p0 d;
    private p0 e;
    private p0 f;
    
    d(final View a) {
        this.c = -1;
        this.a = a;
        this.b = h.b();
    }
    
    private boolean a(final Drawable drawable) {
        if (this.f == null) {
            this.f = new p0();
        }
        final p0 f = this.f;
        f.a();
        final ColorStateList s = b0.s(this.a);
        if (s != null) {
            f.d = true;
            f.a = s;
        }
        final PorterDuff$Mode t = b0.t(this.a);
        if (t != null) {
            f.c = true;
            f.b = t;
        }
        if (!f.d && !f.c) {
            return false;
        }
        h.i(drawable, f, this.a.getDrawableState());
        return true;
    }
    
    private boolean k() {
        return this.d != null;
    }
    
    void b() {
        final Drawable background = this.a.getBackground();
        if (background != null) {
            if (this.k() && this.a(background)) {
                return;
            }
            final p0 e = this.e;
            if (e != null) {
                h.i(background, e, this.a.getDrawableState());
            }
            else {
                final p0 d = this.d;
                if (d != null) {
                    h.i(background, d, this.a.getDrawableState());
                }
            }
        }
    }
    
    ColorStateList c() {
        final p0 e = this.e;
        ColorStateList a;
        if (e != null) {
            a = e.a;
        }
        else {
            a = null;
        }
        return a;
    }
    
    PorterDuff$Mode d() {
        final p0 e = this.e;
        PorterDuff$Mode b;
        if (e != null) {
            b = e.b;
        }
        else {
            b = null;
        }
        return b;
    }
    
    void e(final AttributeSet set, int n) {
        final Context context = this.a.getContext();
        final int[] k3 = j.K3;
        final r0 v = r0.v(context, set, k3, n, 0);
        final View a = this.a;
        b0.n0(a, a.getContext(), k3, set, v.r(), n, 0);
        try {
            n = j.L3;
            if (v.s(n)) {
                this.c = v.n(n, -1);
                final ColorStateList f = this.b.f(this.a.getContext(), this.c);
                if (f != null) {
                    this.h(f);
                }
            }
            n = j.M3;
            if (v.s(n)) {
                b0.u0(this.a, v.c(n));
            }
            n = j.N3;
            if (v.s(n)) {
                b0.v0(this.a, a0.e(v.k(n, -1), null));
            }
        }
        finally {
            v.w();
        }
    }
    
    void f(final Drawable drawable) {
        this.c = -1;
        this.h(null);
        this.b();
    }
    
    void g(final int c) {
        this.c = c;
        final h b = this.b;
        ColorStateList f;
        if (b != null) {
            f = b.f(this.a.getContext(), c);
        }
        else {
            f = null;
        }
        this.h(f);
        this.b();
    }
    
    void h(final ColorStateList a) {
        if (a != null) {
            if (this.d == null) {
                this.d = new p0();
            }
            final p0 d = this.d;
            d.a = a;
            d.d = true;
        }
        else {
            this.d = null;
        }
        this.b();
    }
    
    void i(final ColorStateList a) {
        if (this.e == null) {
            this.e = new p0();
        }
        final p0 e = this.e;
        e.a = a;
        e.d = true;
        this.b();
    }
    
    void j(final PorterDuff$Mode b) {
        if (this.e == null) {
            this.e = new p0();
        }
        final p0 e = this.e;
        e.b = b;
        e.c = true;
        this.b();
    }
}
