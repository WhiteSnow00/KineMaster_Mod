// 
// Decompiled by Procyon v0.6.0
// 

package androidx.appcompat.view.menu;

import android.graphics.Rect;
import androidx.core.view.f;
import androidx.core.view.b0;
import android.view.Display;
import d.d;
import android.graphics.Point;
import android.view.WindowManager;
import android.widget.PopupWindow$OnDismissListener;
import android.view.View;
import android.content.Context;

public class l
{
    private final Context a;
    private final g b;
    private final boolean c;
    private final int d;
    private final int e;
    private View f;
    private int g;
    private boolean h;
    private m.a i;
    private k j;
    private PopupWindow$OnDismissListener k;
    private final PopupWindow$OnDismissListener l;
    
    public l(final Context context, final g g, final View view, final boolean b, final int n) {
        this(context, g, view, b, n, 0);
    }
    
    public l(final Context a, final g b, final View f, final boolean c, final int d, final int e) {
        this.g = 8388611;
        this.l = (PopupWindow$OnDismissListener)new PopupWindow$OnDismissListener() {
            final l a;
            
            public void onDismiss() {
                this.a.e();
            }
        };
        this.a = a;
        this.b = b;
        this.f = f;
        this.c = c;
        this.d = d;
        this.e = e;
    }
    
    private k a() {
        final Display defaultDisplay = ((WindowManager)this.a.getSystemService("window")).getDefaultDisplay();
        final Point point = new Point();
        androidx.appcompat.view.menu.l.b.a(defaultDisplay, point);
        k k;
        if (Math.min(point.x, point.y) >= this.a.getResources().getDimensionPixelSize(d.d.c)) {
            k = new androidx.appcompat.view.menu.d(this.a, this.f, this.d, this.e, this.c);
        }
        else {
            k = new q(this.a, this.b, this.f, this.d, this.e, this.c);
        }
        k.l(this.b);
        k.v(this.l);
        k.q(this.f);
        k.d(this.i);
        k.s(this.h);
        k.t(this.g);
        return k;
    }
    
    private void l(int n, final int n2, final boolean b, final boolean b2) {
        final k c = this.c();
        c.w(b2);
        if (b) {
            int n3 = n;
            if ((androidx.core.view.f.b(this.g, b0.B(this.f)) & 0x7) == 0x5) {
                n3 = n - this.f.getWidth();
            }
            c.u(n3);
            c.x(n2);
            n = (int)(this.a.getResources().getDisplayMetrics().density * 48.0f / 2.0f);
            c.r(new Rect(n3 - n, n2 - n, n3 + n, n2 + n));
        }
        c.show();
    }
    
    public void b() {
        if (this.d()) {
            this.j.dismiss();
        }
    }
    
    public k c() {
        if (this.j == null) {
            this.j = this.a();
        }
        return this.j;
    }
    
    public boolean d() {
        final k j = this.j;
        return j != null && j.a();
    }
    
    protected void e() {
        this.j = null;
        final PopupWindow$OnDismissListener k = this.k;
        if (k != null) {
            k.onDismiss();
        }
    }
    
    public void f(final View f) {
        this.f = f;
    }
    
    public void g(final boolean h) {
        this.h = h;
        final k j = this.j;
        if (j != null) {
            j.s(h);
        }
    }
    
    public void h(final int g) {
        this.g = g;
    }
    
    public void i(final PopupWindow$OnDismissListener k) {
        this.k = k;
    }
    
    public void j(final m.a i) {
        this.i = i;
        final k j = this.j;
        if (j != null) {
            j.d(i);
        }
    }
    
    public void k() {
        if (this.m()) {
            return;
        }
        throw new IllegalStateException("MenuPopupHelper cannot be used without an anchor");
    }
    
    public boolean m() {
        if (this.d()) {
            return true;
        }
        if (this.f == null) {
            return false;
        }
        this.l(0, 0, false, false);
        return true;
    }
    
    public boolean n(final int n, final int n2) {
        if (this.d()) {
            return true;
        }
        if (this.f == null) {
            return false;
        }
        this.l(n, n2, true, true);
        return true;
    }
    
    static class b
    {
        static void a(final Display display, final Point point) {
            display.getRealSize(point);
        }
    }
}
