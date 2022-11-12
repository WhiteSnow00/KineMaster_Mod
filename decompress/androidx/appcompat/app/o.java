// 
// Decompiled by Procyon v0.6.0
// 

package androidx.appcompat.app;

import android.view.MenuInflater;
import android.view.MenuItem;
import java.lang.ref.WeakReference;
import androidx.appcompat.view.menu.g;
import androidx.core.view.i0;
import android.view.Menu;
import android.view.KeyCharacterMap;
import android.view.KeyEvent;
import android.content.res.Configuration;
import android.view.ContextThemeWrapper;
import android.util.TypedValue;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import d.j;
import d.f;
import androidx.appcompat.widget.Toolbar;
import android.app.Dialog;
import androidx.core.view.b0;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.AccelerateInterpolator;
import androidx.appcompat.view.h;
import androidx.appcompat.view.b;
import java.util.ArrayList;
import androidx.appcompat.widget.k0;
import android.view.View;
import androidx.appcompat.widget.ActionBarContextView;
import androidx.appcompat.widget.z;
import androidx.appcompat.widget.ActionBarContainer;
import android.app.Activity;
import android.content.Context;
import androidx.core.view.l0;
import androidx.core.view.j0;
import android.view.animation.Interpolator;
import androidx.appcompat.widget.ActionBarOverlayLayout;

public class o extends a implements ActionBarOverlayLayout.d
{
    private static final Interpolator E;
    private static final Interpolator F;
    boolean A;
    final j0 B;
    final j0 C;
    final l0 D;
    Context a;
    private Context b;
    private Activity c;
    ActionBarOverlayLayout d;
    ActionBarContainer e;
    z f;
    ActionBarContextView g;
    View h;
    k0 i;
    private ArrayList<Object> j;
    private int k;
    private boolean l;
    d m;
    androidx.appcompat.view.b n;
    androidx.appcompat.view.b.a o;
    private boolean p;
    private ArrayList<b> q;
    private boolean r;
    private int s;
    boolean t;
    boolean u;
    boolean v;
    private boolean w;
    private boolean x;
    h y;
    private boolean z;
    
    static {
        E = (Interpolator)new AccelerateInterpolator();
        F = (Interpolator)new DecelerateInterpolator();
    }
    
    public o(final Activity c, final boolean b) {
        this.j = new ArrayList<Object>();
        this.k = -1;
        this.q = new ArrayList<b>();
        this.s = 0;
        this.t = true;
        this.x = true;
        this.B = new androidx.core.view.k0() {
            final o a;
            
            @Override
            public void b(View h) {
                final o a = this.a;
                if (a.t) {
                    h = a.h;
                    if (h != null) {
                        h.setTranslationY(0.0f);
                        this.a.e.setTranslationY(0.0f);
                    }
                }
                this.a.e.setVisibility(8);
                this.a.e.setTransitioning(false);
                final o a2 = this.a;
                a2.y = null;
                a2.x();
                final ActionBarOverlayLayout d = this.a.d;
                if (d != null) {
                    b0.m0((View)d);
                }
            }
        };
        this.C = new androidx.core.view.k0() {
            final o a;
            
            @Override
            public void b(final View view) {
                final o a = this.a;
                a.y = null;
                a.e.requestLayout();
            }
        };
        this.D = new l0() {
            final o a;
            
            @Override
            public void a(final View view) {
                ((View)this.a.e.getParent()).invalidate();
            }
        };
        this.c = c;
        final View decorView = c.getWindow().getDecorView();
        this.D(decorView);
        if (!b) {
            this.h = decorView.findViewById(16908290);
        }
    }
    
    public o(final Dialog dialog) {
        this.j = new ArrayList<Object>();
        this.k = -1;
        this.q = new ArrayList<b>();
        this.s = 0;
        this.t = true;
        this.x = true;
        this.B = new androidx.core.view.k0() {
            final o a;
            
            @Override
            public void b(View h) {
                final o a = this.a;
                if (a.t) {
                    h = a.h;
                    if (h != null) {
                        h.setTranslationY(0.0f);
                        this.a.e.setTranslationY(0.0f);
                    }
                }
                this.a.e.setVisibility(8);
                this.a.e.setTransitioning(false);
                final o a2 = this.a;
                a2.y = null;
                a2.x();
                final ActionBarOverlayLayout d = this.a.d;
                if (d != null) {
                    b0.m0((View)d);
                }
            }
        };
        this.C = new androidx.core.view.k0() {
            final o a;
            
            @Override
            public void b(final View view) {
                final o a = this.a;
                a.y = null;
                a.e.requestLayout();
            }
        };
        this.D = new l0() {
            final o a;
            
            @Override
            public void a(final View view) {
                ((View)this.a.e.getParent()).invalidate();
            }
        };
        this.D(dialog.getWindow().getDecorView());
    }
    
    private z A(final View view) {
        if (view instanceof z) {
            return (z)view;
        }
        if (view instanceof Toolbar) {
            return ((Toolbar)view).getWrapper();
        }
        final StringBuilder sb = new StringBuilder();
        sb.append("Can't make a decor toolbar out of ");
        String simpleName;
        if (view != null) {
            simpleName = view.getClass().getSimpleName();
        }
        else {
            simpleName = "null";
        }
        sb.append(simpleName);
        throw new IllegalStateException(sb.toString());
    }
    
    private void C() {
        if (this.w) {
            this.w = false;
            final ActionBarOverlayLayout d = this.d;
            if (d != null) {
                d.setShowingForActionMode(false);
            }
            this.M(false);
        }
    }
    
    private void D(final View view) {
        final ActionBarOverlayLayout d = (ActionBarOverlayLayout)view.findViewById(d.f.p);
        this.d = d;
        if (d != null) {
            d.setActionBarVisibilityCallback((ActionBarOverlayLayout.d)this);
        }
        this.f = this.A(view.findViewById(d.f.a));
        this.g = (ActionBarContextView)view.findViewById(d.f.f);
        final ActionBarContainer e = (ActionBarContainer)view.findViewById(d.f.c);
        this.e = e;
        final z f = this.f;
        if (f != null && this.g != null && e != null) {
            this.a = f.getContext();
            final boolean b = (this.f.v() & 0x4) != 0x0;
            if (b) {
                this.l = true;
            }
            final androidx.appcompat.view.a b2 = androidx.appcompat.view.a.b(this.a);
            this.J(b2.a() || b);
            this.H(b2.g());
            final TypedArray obtainStyledAttributes = this.a.obtainStyledAttributes((AttributeSet)null, d.j.a, d.a.c, 0);
            if (obtainStyledAttributes.getBoolean(d.j.k, false)) {
                this.I(true);
            }
            final int dimensionPixelSize = obtainStyledAttributes.getDimensionPixelSize(d.j.i, 0);
            if (dimensionPixelSize != 0) {
                this.G((float)dimensionPixelSize);
            }
            obtainStyledAttributes.recycle();
            return;
        }
        final StringBuilder sb = new StringBuilder();
        sb.append(this.getClass().getSimpleName());
        sb.append(" can only be used with a compatible window decor layout");
        throw new IllegalStateException(sb.toString());
    }
    
    private void H(final boolean r) {
        if (!(this.r = r)) {
            this.f.r(null);
            this.e.setTabContainer(this.i);
        }
        else {
            this.e.setTabContainer(null);
            this.f.r(this.i);
        }
        final int b = this.B();
        final boolean b2 = true;
        final boolean b3 = b == 2;
        final k0 i = this.i;
        if (i != null) {
            if (b3) {
                i.setVisibility(0);
                final ActionBarOverlayLayout d = this.d;
                if (d != null) {
                    b0.m0((View)d);
                }
            }
            else {
                i.setVisibility(8);
            }
        }
        this.f.p(!this.r && b3);
        this.d.setHasNonEmbeddedTabs(!this.r && b3 && b2);
    }
    
    private boolean K() {
        return b0.T((View)this.e);
    }
    
    private void L() {
        if (!this.w) {
            this.w = true;
            final ActionBarOverlayLayout d = this.d;
            if (d != null) {
                d.setShowingForActionMode(true);
            }
            this.M(false);
        }
    }
    
    private void M(final boolean b) {
        if (w(this.u, this.v, this.w)) {
            if (!this.x) {
                this.x = true;
                this.z(b);
            }
        }
        else if (this.x) {
            this.x = false;
            this.y(b);
        }
    }
    
    static boolean w(final boolean b, final boolean b2, final boolean b3) {
        return b3 || (!b && !b2);
    }
    
    public int B() {
        return this.f.k();
    }
    
    public void E(final boolean b) {
        int n;
        if (b) {
            n = 4;
        }
        else {
            n = 0;
        }
        this.F(n, 4);
    }
    
    public void F(final int n, final int n2) {
        final int v = this.f.v();
        if ((n2 & 0x4) != 0x0) {
            this.l = true;
        }
        this.f.i((n & n2) | (~n2 & v));
    }
    
    public void G(final float n) {
        b0.x0((View)this.e, n);
    }
    
    public void I(final boolean b) {
        if (b && !this.d.w()) {
            throw new IllegalStateException("Action bar must be in overlay mode (Window.FEATURE_OVERLAY_ACTION_BAR) to enable hide on content scroll");
        }
        this.A = b;
        this.d.setHideOnContentScrollEnabled(b);
    }
    
    public void J(final boolean b) {
        this.f.n(b);
    }
    
    @Override
    public void a() {
        if (this.v) {
            this.v = false;
            this.M(true);
        }
    }
    
    @Override
    public void b() {
    }
    
    @Override
    public void c(final boolean t) {
        this.t = t;
    }
    
    @Override
    public void d() {
        if (!this.v) {
            this.M(this.v = true);
        }
    }
    
    @Override
    public void e() {
        final h y = this.y;
        if (y != null) {
            y.a();
            this.y = null;
        }
    }
    
    @Override
    public boolean g() {
        final z f = this.f;
        if (f != null && f.h()) {
            this.f.collapseActionView();
            return true;
        }
        return false;
    }
    
    @Override
    public void h(final boolean p) {
        if (p == this.p) {
            return;
        }
        this.p = p;
        for (int size = this.q.size(), i = 0; i < size; ++i) {
            this.q.get(i).a(p);
        }
    }
    
    @Override
    public int i() {
        return this.f.v();
    }
    
    @Override
    public Context j() {
        if (this.b == null) {
            final TypedValue typedValue = new TypedValue();
            this.a.getTheme().resolveAttribute(d.a.g, typedValue, true);
            final int resourceId = typedValue.resourceId;
            if (resourceId != 0) {
                this.b = (Context)new ContextThemeWrapper(this.a, resourceId);
            }
            else {
                this.b = this.a;
            }
        }
        return this.b;
    }
    
    @Override
    public void l(final Configuration configuration) {
        this.H(androidx.appcompat.view.a.b(this.a).g());
    }
    
    @Override
    public boolean n(final int n, final KeyEvent keyEvent) {
        final d m = this.m;
        if (m == null) {
            return false;
        }
        final Menu e = m.e();
        if (e != null) {
            int deviceId;
            if (keyEvent != null) {
                deviceId = keyEvent.getDeviceId();
            }
            else {
                deviceId = -1;
            }
            final int keyboardType = KeyCharacterMap.load(deviceId).getKeyboardType();
            boolean qwertyMode = true;
            if (keyboardType == 1) {
                qwertyMode = false;
            }
            e.setQwertyMode(qwertyMode);
            return e.performShortcut(n, keyEvent, 0);
        }
        return false;
    }
    
    @Override
    public void onWindowVisibilityChanged(final int s) {
        this.s = s;
    }
    
    @Override
    public void q(final boolean b) {
        if (!this.l) {
            this.E(b);
        }
    }
    
    @Override
    public void r(final boolean b) {
        int n;
        if (b) {
            n = 8;
        }
        else {
            n = 0;
        }
        this.F(n, 8);
    }
    
    @Override
    public void s(final boolean z) {
        if (!(this.z = z)) {
            final h y = this.y;
            if (y != null) {
                y.a();
            }
        }
    }
    
    @Override
    public void t(final CharSequence windowTitle) {
        this.f.setWindowTitle(windowTitle);
    }
    
    @Override
    public androidx.appcompat.view.b u(final androidx.appcompat.view.b.a a) {
        final d m = this.m;
        if (m != null) {
            m.c();
        }
        this.d.setHideOnContentScrollEnabled(false);
        this.g.k();
        final d i = new d(this.g.getContext(), a);
        if (i.t()) {
            (this.m = i).k();
            this.g.h(i);
            this.v(true);
            return i;
        }
        return null;
    }
    
    public void v(final boolean b) {
        if (b) {
            this.L();
        }
        else {
            this.C();
        }
        if (this.K()) {
            i0 i0;
            i0 i2;
            if (b) {
                i0 = this.f.l(4, 100L);
                i2 = this.g.f(0, 200L);
            }
            else {
                i2 = this.f.l(0, 200L);
                i0 = this.g.f(8, 100L);
            }
            final h h = new h();
            h.d(i0, i2);
            h.h();
        }
        else if (b) {
            this.f.u(4);
            this.g.setVisibility(0);
        }
        else {
            this.f.u(0);
            this.g.setVisibility(8);
        }
    }
    
    void x() {
        final androidx.appcompat.view.b.a o = this.o;
        if (o != null) {
            o.a(this.n);
            this.n = null;
            this.o = null;
        }
    }
    
    public void y(final boolean b) {
        final h y = this.y;
        if (y != null) {
            y.a();
        }
        if (this.s == 0 && (this.z || b)) {
            this.e.setAlpha(1.0f);
            this.e.setTransitioning(true);
            final h y2 = new h();
            float n2;
            final float n = n2 = (float)(-this.e.getHeight());
            if (b) {
                final int[] array2;
                final int[] array = array2 = new int[2];
                array2[1] = (array2[0] = 0);
                this.e.getLocationInWindow(array);
                n2 = n - array[1];
            }
            final i0 o = b0.e((View)this.e).o(n2);
            o.l(this.D);
            y2.c(o);
            if (this.t) {
                final View h = this.h;
                if (h != null) {
                    y2.c(b0.e(h).o(n2));
                }
            }
            y2.f(androidx.appcompat.app.o.E);
            y2.e(250L);
            y2.g(this.B);
            (this.y = y2).h();
        }
        else {
            this.B.b(null);
        }
    }
    
    public void z(final boolean b) {
        final h y = this.y;
        if (y != null) {
            y.a();
        }
        this.e.setVisibility(0);
        if (this.s == 0 && (this.z || b)) {
            this.e.setTranslationY(0.0f);
            float n2;
            final float n = n2 = (float)(-this.e.getHeight());
            if (b) {
                final int[] array2;
                final int[] array = array2 = new int[2];
                array2[1] = (array2[0] = 0);
                this.e.getLocationInWindow(array);
                n2 = n - array[1];
            }
            this.e.setTranslationY(n2);
            final h y2 = new h();
            final i0 o = b0.e((View)this.e).o(0.0f);
            o.l(this.D);
            y2.c(o);
            if (this.t) {
                final View h = this.h;
                if (h != null) {
                    h.setTranslationY(n2);
                    y2.c(b0.e(this.h).o(0.0f));
                }
            }
            y2.f(androidx.appcompat.app.o.F);
            y2.e(250L);
            y2.g(this.C);
            (this.y = y2).h();
        }
        else {
            this.e.setAlpha(1.0f);
            this.e.setTranslationY(0.0f);
            if (this.t) {
                final View h2 = this.h;
                if (h2 != null) {
                    h2.setTranslationY(0.0f);
                }
            }
            this.C.b(null);
        }
        final ActionBarOverlayLayout d = this.d;
        if (d != null) {
            b0.m0((View)d);
        }
    }
    
    public class d extends b implements g.a
    {
        private final Context c;
        private final g d;
        private a e;
        private WeakReference<View> f;
        final o g;
        
        public d(final o g, final Context c, final a e) {
            this.g = g;
            this.c = c;
            this.e = e;
            (this.d = new g(c).W(1)).V((g.a)this);
        }
        
        @Override
        public boolean a(final g g, final MenuItem menuItem) {
            final a e = this.e;
            return e != null && e.c(this, menuItem);
        }
        
        @Override
        public void b(final g g) {
            if (this.e == null) {
                return;
            }
            this.k();
            this.g.g.l();
        }
        
        @Override
        public void c() {
            final o g = this.g;
            if (g.m != this) {
                return;
            }
            if (!o.w(g.u, g.v, false)) {
                final o g2 = this.g;
                g2.n = this;
                g2.o = this.e;
            }
            else {
                this.e.a(this);
            }
            this.e = null;
            this.g.v(false);
            this.g.g.g();
            final o g3 = this.g;
            g3.d.setHideOnContentScrollEnabled(g3.A);
            this.g.m = null;
        }
        
        @Override
        public View d() {
            final WeakReference<View> f = this.f;
            View view;
            if (f != null) {
                view = f.get();
            }
            else {
                view = null;
            }
            return view;
        }
        
        @Override
        public Menu e() {
            return (Menu)this.d;
        }
        
        @Override
        public MenuInflater f() {
            return new androidx.appcompat.view.g(this.c);
        }
        
        @Override
        public CharSequence g() {
            return this.g.g.getSubtitle();
        }
        
        @Override
        public CharSequence i() {
            return this.g.g.getTitle();
        }
        
        @Override
        public void k() {
            if (this.g.m != this) {
                return;
            }
            this.d.h0();
            try {
                this.e.d(this, (Menu)this.d);
            }
            finally {
                this.d.g0();
            }
        }
        
        @Override
        public boolean l() {
            return this.g.g.j();
        }
        
        @Override
        public void m(final View customView) {
            this.g.g.setCustomView(customView);
            this.f = new WeakReference<View>(customView);
        }
        
        @Override
        public void n(final int n) {
            this.o(this.g.a.getResources().getString(n));
        }
        
        @Override
        public void o(final CharSequence subtitle) {
            this.g.g.setSubtitle(subtitle);
        }
        
        @Override
        public void q(final int n) {
            this.r(this.g.a.getResources().getString(n));
        }
        
        @Override
        public void r(final CharSequence title) {
            this.g.g.setTitle(title);
        }
        
        @Override
        public void s(final boolean titleOptional) {
            super.s(titleOptional);
            this.g.g.setTitleOptional(titleOptional);
        }
        
        public boolean t() {
            this.d.h0();
            try {
                return this.e.b(this, (Menu)this.d);
            }
            finally {
                this.d.g0();
            }
        }
    }
}
