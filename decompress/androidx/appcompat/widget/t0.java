// 
// Decompiled by Procyon v0.6.0
// 

package androidx.appcompat.widget;

import android.view.ViewParent;
import android.util.Log;
import androidx.core.view.j0;
import androidx.core.view.k0;
import androidx.core.view.i0;
import android.content.Context;
import androidx.appcompat.view.menu.g;
import d.f;
import androidx.appcompat.view.menu.m;
import android.view.Menu;
import androidx.core.view.b0;
import android.view.ViewGroup$LayoutParams;
import android.view.MenuItem;
import android.view.View$OnClickListener;
import android.view.ViewGroup;
import android.view.LayoutInflater;
import android.text.TextUtils;
import android.util.AttributeSet;
import d.a;
import d.j;
import d.e;
import d.h;
import android.view.Window$Callback;
import android.graphics.drawable.Drawable;
import android.view.View;

public class t0 implements z
{
    Toolbar a;
    private int b;
    private View c;
    private View d;
    private Drawable e;
    private Drawable f;
    private Drawable g;
    private boolean h;
    CharSequence i;
    private CharSequence j;
    private CharSequence k;
    Window$Callback l;
    boolean m;
    private ActionMenuPresenter n;
    private int o;
    private int p;
    private Drawable q;
    
    public t0(final Toolbar toolbar, final boolean b) {
        this(toolbar, b, d.h.a, d.e.n);
    }
    
    public t0(final Toolbar a, final boolean b, final int n, int n2) {
        this.o = 0;
        this.p = 0;
        this.a = a;
        this.i = a.getTitle();
        this.j = a.getSubtitle();
        this.h = (this.i != null);
        this.g = a.getNavigationIcon();
        final r0 v = r0.v(a.getContext(), null, d.j.a, d.a.c, 0);
        this.q = v.g(d.j.l);
        if (b) {
            final CharSequence p4 = v.p(d.j.r);
            if (!TextUtils.isEmpty(p4)) {
                this.F(p4);
            }
            final CharSequence p5 = v.p(d.j.p);
            if (!TextUtils.isEmpty(p5)) {
                this.E(p5);
            }
            final Drawable g = v.g(d.j.n);
            if (g != null) {
                this.A(g);
            }
            final Drawable g2 = v.g(d.j.m);
            if (g2 != null) {
                this.setIcon(g2);
            }
            if (this.g == null) {
                final Drawable q = this.q;
                if (q != null) {
                    this.D(q);
                }
            }
            this.i(v.k(d.j.h, 0));
            n2 = v.n(d.j.g, 0);
            if (n2 != 0) {
                this.y(LayoutInflater.from(this.a.getContext()).inflate(n2, (ViewGroup)this.a, false));
                this.i(this.b | 0x10);
            }
            n2 = v.m(d.j.j, 0);
            if (n2 > 0) {
                final ViewGroup$LayoutParams layoutParams = this.a.getLayoutParams();
                layoutParams.height = n2;
                this.a.setLayoutParams(layoutParams);
            }
            final int e = v.e(d.j.f, -1);
            n2 = v.e(d.j.e, -1);
            if (e >= 0 || n2 >= 0) {
                this.a.J(Math.max(e, 0), Math.max(n2, 0));
            }
            n2 = v.n(d.j.s, 0);
            if (n2 != 0) {
                final Toolbar a2 = this.a;
                a2.N(a2.getContext(), n2);
            }
            n2 = v.n(d.j.q, 0);
            if (n2 != 0) {
                final Toolbar a3 = this.a;
                a3.M(a3.getContext(), n2);
            }
            n2 = v.n(d.j.o, 0);
            if (n2 != 0) {
                this.a.setPopupTheme(n2);
            }
        }
        else {
            this.b = this.x();
        }
        v.w();
        this.z(n);
        this.k = this.a.getNavigationContentDescription();
        this.a.setNavigationOnClickListener((View$OnClickListener)new View$OnClickListener(this) {
            final androidx.appcompat.view.menu.a a = new androidx.appcompat.view.menu.a(b.a.getContext(), 0, 16908332, 0, 0, b.i);
            final t0 b;
            
            public void onClick(final View view) {
                final t0 b = this.b;
                final Window$Callback l = b.l;
                if (l != null && b.m) {
                    l.onMenuItemSelected(0, (MenuItem)this.a);
                }
            }
        });
    }
    
    private void G(final CharSequence charSequence) {
        this.i = charSequence;
        if ((this.b & 0x8) != 0x0) {
            this.a.setTitle(charSequence);
            if (this.h) {
                b0.s0(this.a.getRootView(), charSequence);
            }
        }
    }
    
    private void H() {
        if ((this.b & 0x4) != 0x0) {
            if (TextUtils.isEmpty(this.k)) {
                this.a.setNavigationContentDescription(this.p);
            }
            else {
                this.a.setNavigationContentDescription(this.k);
            }
        }
    }
    
    private void I() {
        if ((this.b & 0x4) != 0x0) {
            final Toolbar a = this.a;
            Drawable navigationIcon = this.g;
            if (navigationIcon == null) {
                navigationIcon = this.q;
            }
            a.setNavigationIcon(navigationIcon);
        }
        else {
            this.a.setNavigationIcon(null);
        }
    }
    
    private void J() {
        final int b = this.b;
        Drawable logo;
        if ((b & 0x2) != 0x0) {
            if ((b & 0x1) != 0x0) {
                logo = this.f;
                if (logo == null) {
                    logo = this.e;
                }
            }
            else {
                logo = this.e;
            }
        }
        else {
            logo = null;
        }
        this.a.setLogo(logo);
    }
    
    private int x() {
        int n;
        if (this.a.getNavigationIcon() != null) {
            n = 15;
            this.q = this.a.getNavigationIcon();
        }
        else {
            n = 11;
        }
        return n;
    }
    
    public void A(final Drawable f) {
        this.f = f;
        this.J();
    }
    
    public void B(final int n) {
        CharSequence string;
        if (n == 0) {
            string = null;
        }
        else {
            string = this.getContext().getString(n);
        }
        this.C(string);
    }
    
    public void C(final CharSequence k) {
        this.k = k;
        this.H();
    }
    
    public void D(final Drawable g) {
        this.g = g;
        this.I();
    }
    
    public void E(final CharSequence charSequence) {
        this.j = charSequence;
        if ((this.b & 0x8) != 0x0) {
            this.a.setSubtitle(charSequence);
        }
    }
    
    public void F(final CharSequence charSequence) {
        this.h = true;
        this.G(charSequence);
    }
    
    @Override
    public boolean a() {
        return this.a.d();
    }
    
    @Override
    public boolean b() {
        return this.a.w();
    }
    
    @Override
    public boolean c() {
        return this.a.Q();
    }
    
    @Override
    public void collapseActionView() {
        this.a.e();
    }
    
    @Override
    public void d(final Menu menu, final m.a a) {
        if (this.n == null) {
            (this.n = new ActionMenuPresenter(this.a.getContext())).r(d.f.g);
        }
        this.n.d(a);
        this.a.K((g)menu, this.n);
    }
    
    @Override
    public boolean e() {
        return this.a.B();
    }
    
    @Override
    public void f() {
        this.m = true;
    }
    
    @Override
    public boolean g() {
        return this.a.A();
    }
    
    @Override
    public Context getContext() {
        return this.a.getContext();
    }
    
    @Override
    public CharSequence getTitle() {
        return this.a.getTitle();
    }
    
    @Override
    public boolean h() {
        return this.a.v();
    }
    
    @Override
    public void i(final int b) {
        final int n = this.b ^ b;
        this.b = b;
        if (n != 0) {
            if ((n & 0x4) != 0x0) {
                if ((b & 0x4) != 0x0) {
                    this.H();
                }
                this.I();
            }
            if ((n & 0x3) != 0x0) {
                this.J();
            }
            if ((n & 0x8) != 0x0) {
                if ((b & 0x8) != 0x0) {
                    this.a.setTitle(this.i);
                    this.a.setSubtitle(this.j);
                }
                else {
                    this.a.setTitle(null);
                    this.a.setSubtitle(null);
                }
            }
            if ((n & 0x10) != 0x0) {
                final View d = this.d;
                if (d != null) {
                    if ((b & 0x10) != 0x0) {
                        this.a.addView(d);
                    }
                    else {
                        this.a.removeView(d);
                    }
                }
            }
        }
    }
    
    @Override
    public Menu j() {
        return this.a.getMenu();
    }
    
    @Override
    public int k() {
        return this.o;
    }
    
    @Override
    public i0 l(final int n, final long n2) {
        final i0 e = b0.e((View)this.a);
        float n3;
        if (n == 0) {
            n3 = 1.0f;
        }
        else {
            n3 = 0.0f;
        }
        return e.b(n3).g(n2).i(new k0(this, n) {
            private boolean a = false;
            final int b;
            final t0 c;
            
            @Override
            public void a(final View view) {
                this.a = true;
            }
            
            @Override
            public void b(final View view) {
                if (!this.a) {
                    this.c.a.setVisibility(this.b);
                }
            }
            
            @Override
            public void c(final View view) {
                this.c.a.setVisibility(0);
            }
        });
    }
    
    @Override
    public ViewGroup m() {
        return this.a;
    }
    
    @Override
    public void n(final boolean b) {
    }
    
    @Override
    public void o() {
        Log.i("ToolbarWidgetWrapper", "Progress display unsupported");
    }
    
    @Override
    public void p(final boolean collapsible) {
        this.a.setCollapsible(collapsible);
    }
    
    @Override
    public void q() {
        this.a.f();
    }
    
    @Override
    public void r(final androidx.appcompat.widget.k0 c) {
        final View c2 = this.c;
        if (c2 != null) {
            final ViewParent parent = c2.getParent();
            final Toolbar a = this.a;
            if (parent == a) {
                a.removeView(this.c);
            }
        }
        if ((this.c = (View)c) != null && this.o == 2) {
            this.a.addView((View)c, 0);
            final Toolbar.e e = (Toolbar.e)this.c.getLayoutParams();
            e.width = -2;
            e.height = -2;
            e.a = 8388691;
            c.setAllowCollapse(true);
        }
    }
    
    @Override
    public void s(final int n) {
        Drawable b;
        if (n != 0) {
            b = e.a.b(this.getContext(), n);
        }
        else {
            b = null;
        }
        this.A(b);
    }
    
    @Override
    public void setIcon(final int n) {
        Drawable b;
        if (n != 0) {
            b = e.a.b(this.getContext(), n);
        }
        else {
            b = null;
        }
        this.setIcon(b);
    }
    
    @Override
    public void setIcon(final Drawable e) {
        this.e = e;
        this.J();
    }
    
    @Override
    public void setWindowCallback(final Window$Callback l) {
        this.l = l;
    }
    
    @Override
    public void setWindowTitle(final CharSequence charSequence) {
        if (!this.h) {
            this.G(charSequence);
        }
    }
    
    @Override
    public void t(final m.a a, final g.a a2) {
        this.a.L(a, a2);
    }
    
    @Override
    public void u(final int visibility) {
        this.a.setVisibility(visibility);
    }
    
    @Override
    public int v() {
        return this.b;
    }
    
    @Override
    public void w() {
        Log.i("ToolbarWidgetWrapper", "Progress display unsupported");
    }
    
    public void y(final View d) {
        final View d2 = this.d;
        if (d2 != null && (this.b & 0x10) != 0x0) {
            this.a.removeView(d2);
        }
        if ((this.d = d) != null && (this.b & 0x10) != 0x0) {
            this.a.addView(d);
        }
    }
    
    public void z(final int p) {
        if (p == this.p) {
            return;
        }
        this.p = p;
        if (TextUtils.isEmpty(this.a.getNavigationContentDescription())) {
            this.B(this.p);
        }
    }
}
