// 
// Decompiled by Procyon v0.6.0
// 

package androidx.appcompat.view.menu;

import android.view.KeyEvent;
import android.view.Gravity;
import androidx.core.view.b0;
import android.os.Parcelable;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.FrameLayout;
import android.view.ViewGroup;
import android.widget.ListAdapter;
import android.widget.AdapterView$OnItemClickListener;
import android.content.res.Resources;
import android.util.AttributeSet;
import d.d;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View$OnAttachStateChangeListener;
import android.view.ViewTreeObserver$OnGlobalLayoutListener;
import androidx.appcompat.widget.g0;
import android.content.Context;
import android.view.ViewTreeObserver;
import android.view.View$OnKeyListener;
import android.widget.PopupWindow$OnDismissListener;

final class q extends k implements PopupWindow$OnDismissListener, View$OnKeyListener
{
    private static final int G;
    ViewTreeObserver A;
    private boolean B;
    private boolean C;
    private int D;
    private int E;
    private boolean F;
    private final Context b;
    private final g c;
    private final f d;
    private final boolean e;
    private final int f;
    private final int g;
    private final int h;
    final g0 i;
    final ViewTreeObserver$OnGlobalLayoutListener j;
    private final View$OnAttachStateChangeListener p;
    private PopupWindow$OnDismissListener w;
    private View x;
    View y;
    private a z;
    
    static {
        G = d.g.m;
    }
    
    public q(final Context b, final g c, final View x, final int g, final int h, final boolean e) {
        this.j = (ViewTreeObserver$OnGlobalLayoutListener)new ViewTreeObserver$OnGlobalLayoutListener() {
            final q a;
            
            public void onGlobalLayout() {
                if (this.a.a() && !this.a.i.A()) {
                    final View y = this.a.y;
                    if (y != null && y.isShown()) {
                        this.a.i.show();
                    }
                    else {
                        this.a.dismiss();
                    }
                }
            }
        };
        this.p = (View$OnAttachStateChangeListener)new View$OnAttachStateChangeListener() {
            final q a;
            
            public void onViewAttachedToWindow(final View view) {
            }
            
            public void onViewDetachedFromWindow(final View view) {
                final ViewTreeObserver a = this.a.A;
                if (a != null) {
                    if (!a.isAlive()) {
                        this.a.A = view.getViewTreeObserver();
                    }
                    final q a2 = this.a;
                    a2.A.removeGlobalOnLayoutListener(a2.j);
                }
                view.removeOnAttachStateChangeListener((View$OnAttachStateChangeListener)this);
            }
        };
        this.E = 0;
        this.b = b;
        this.c = c;
        this.e = e;
        this.d = new f(c, LayoutInflater.from(b), e, q.G);
        this.g = g;
        this.h = h;
        final Resources resources = b.getResources();
        this.f = Math.max(resources.getDisplayMetrics().widthPixels / 2, resources.getDimensionPixelSize(d.d.d));
        this.x = x;
        this.i = new g0(b, null, g, h);
        c.c(this, b);
    }
    
    private boolean A() {
        if (this.a()) {
            return true;
        }
        if (!this.B) {
            final View x = this.x;
            if (x != null) {
                this.y = x;
                this.i.J((PopupWindow$OnDismissListener)this);
                this.i.K((AdapterView$OnItemClickListener)this);
                this.i.I(true);
                final View y = this.y;
                final boolean b = this.A == null;
                final ViewTreeObserver viewTreeObserver = y.getViewTreeObserver();
                this.A = viewTreeObserver;
                if (b) {
                    viewTreeObserver.addOnGlobalLayoutListener(this.j);
                }
                y.addOnAttachStateChangeListener(this.p);
                this.i.C(y);
                this.i.F(this.E);
                if (!this.C) {
                    this.D = k.p((ListAdapter)this.d, null, this.b, this.f);
                    this.C = true;
                }
                this.i.E(this.D);
                this.i.H(2);
                this.i.G(this.n());
                this.i.show();
                final ListView o = this.i.o();
                o.setOnKeyListener((View$OnKeyListener)this);
                if (this.F && this.c.z() != null) {
                    final FrameLayout frameLayout = (FrameLayout)LayoutInflater.from(this.b).inflate(d.g.l, (ViewGroup)o, false);
                    final TextView textView = (TextView)frameLayout.findViewById(16908310);
                    if (textView != null) {
                        textView.setText(this.c.z());
                    }
                    frameLayout.setEnabled(false);
                    o.addHeaderView((View)frameLayout, (Object)null, false);
                }
                this.i.m((ListAdapter)this.d);
                this.i.show();
                return true;
            }
        }
        return false;
    }
    
    public boolean a() {
        return !this.B && this.i.a();
    }
    
    public void b(final g g, final boolean b) {
        if (g != this.c) {
            return;
        }
        this.dismiss();
        final a z = this.z;
        if (z != null) {
            z.b(g, b);
        }
    }
    
    public void d(final a z) {
        this.z = z;
    }
    
    public void dismiss() {
        if (this.a()) {
            this.i.dismiss();
        }
    }
    
    public void e(final Parcelable parcelable) {
    }
    
    public boolean f(final r r) {
        if (r.hasVisibleItems()) {
            final l l = new l(this.b, r, this.y, this.e, this.g, this.h);
            l.j(this.z);
            l.g(k.y(r));
            l.i(this.w);
            this.w = null;
            this.c.e(false);
            final int c = this.i.c();
            final int i = this.i.l();
            int n = c;
            if ((Gravity.getAbsoluteGravity(this.E, b0.B(this.x)) & 0x7) == 0x5) {
                n = c + this.x.getWidth();
            }
            if (l.n(n, i)) {
                final a z = this.z;
                if (z != null) {
                    z.c(r);
                }
                return true;
            }
        }
        return false;
    }
    
    public Parcelable g() {
        return null;
    }
    
    public void h(final boolean b) {
        this.C = false;
        final f d = this.d;
        if (d != null) {
            d.notifyDataSetChanged();
        }
    }
    
    public boolean i() {
        return false;
    }
    
    @Override
    public void l(final g g) {
    }
    
    public ListView o() {
        return this.i.o();
    }
    
    public void onDismiss() {
        this.B = true;
        this.c.close();
        final ViewTreeObserver a = this.A;
        if (a != null) {
            if (!a.isAlive()) {
                this.A = this.y.getViewTreeObserver();
            }
            this.A.removeGlobalOnLayoutListener(this.j);
            this.A = null;
        }
        this.y.removeOnAttachStateChangeListener(this.p);
        final PopupWindow$OnDismissListener w = this.w;
        if (w != null) {
            w.onDismiss();
        }
    }
    
    public boolean onKey(final View view, final int n, final KeyEvent keyEvent) {
        if (keyEvent.getAction() == 1 && n == 82) {
            this.dismiss();
            return true;
        }
        return false;
    }
    
    @Override
    public void q(final View x) {
        this.x = x;
    }
    
    @Override
    public void s(final boolean b) {
        this.d.d(b);
    }
    
    public void show() {
        if (this.A()) {
            return;
        }
        throw new IllegalStateException("StandardMenuPopup cannot be used without an anchor");
    }
    
    @Override
    public void t(final int e) {
        this.E = e;
    }
    
    @Override
    public void u(final int n) {
        this.i.e(n);
    }
    
    @Override
    public void v(final PopupWindow$OnDismissListener w) {
        this.w = w;
    }
    
    @Override
    public void w(final boolean f) {
        this.F = f;
    }
    
    @Override
    public void x(final int n) {
        this.i.i(n);
    }
}
