// 
// Decompiled by Procyon v0.6.0
// 

package androidx.core.view;

import android.view.WindowInsets$Type;
import java.util.Objects;
import java.lang.reflect.Method;
import android.view.WindowInsets$Builder;
import java.lang.reflect.Constructor;
import android.graphics.Rect;
import android.util.Log;
import java.lang.reflect.Field;
import androidx.core.util.c;
import androidx.core.util.h;
import android.view.View;
import androidx.core.graphics.e;
import android.view.WindowInsets;
import android.os.Build$VERSION;

public class n0
{
    public static final n0 b;
    private final l a;
    
    static {
        if (Build$VERSION.SDK_INT >= 30) {
            b = k.q;
        }
        else {
            b = l.b;
        }
    }
    
    private n0(final WindowInsets windowInsets) {
        final int sdk_INT = Build$VERSION.SDK_INT;
        if (sdk_INT >= 30) {
            this.a = (l)new k(this, windowInsets);
        }
        else if (sdk_INT >= 29) {
            this.a = (l)new j(this, windowInsets);
        }
        else if (sdk_INT >= 28) {
            this.a = (l)new i(this, windowInsets);
        }
        else {
            this.a = (l)new h(this, windowInsets);
        }
    }
    
    public n0(final n0 n0) {
        if (n0 != null) {
            final l a = n0.a;
            final int sdk_INT = Build$VERSION.SDK_INT;
            if (sdk_INT >= 30 && a instanceof k) {
                this.a = (l)new k(this, (k)a);
            }
            else if (sdk_INT >= 29 && a instanceof j) {
                this.a = (l)new j(this, (j)a);
            }
            else if (sdk_INT >= 28 && a instanceof i) {
                this.a = (l)new i(this, (i)a);
            }
            else if (a instanceof h) {
                this.a = (l)new h(this, (h)a);
            }
            else if (a instanceof g) {
                this.a = (l)new g(this, (g)a);
            }
            else {
                this.a = new l(this);
            }
            a.e(this);
        }
        else {
            this.a = new l(this);
        }
    }
    
    static androidx.core.graphics.e n(final androidx.core.graphics.e e, final int n, final int n2, final int n3, final int n4) {
        final int max = Math.max(0, e.a - n);
        final int max2 = Math.max(0, e.b - n2);
        final int max3 = Math.max(0, e.c - n3);
        final int max4 = Math.max(0, e.d - n4);
        if (max == n && max2 == n2 && max3 == n3 && max4 == n4) {
            return e;
        }
        return e.b(max, max2, max3, max4);
    }
    
    public static n0 v(final WindowInsets windowInsets) {
        return w(windowInsets, null);
    }
    
    public static n0 w(final WindowInsets windowInsets, final View view) {
        final n0 n0 = new n0(androidx.core.util.h.g(windowInsets));
        if (view != null && b0.S(view)) {
            n0.s(b0.H(view));
            n0.d(view.getRootView());
        }
        return n0;
    }
    
    @Deprecated
    public n0 a() {
        return this.a.a();
    }
    
    @Deprecated
    public n0 b() {
        return this.a.b();
    }
    
    @Deprecated
    public n0 c() {
        return this.a.c();
    }
    
    void d(final View view) {
        this.a.d(view);
    }
    
    public androidx.core.view.d e() {
        return this.a.f();
    }
    
    @Override
    public boolean equals(final Object o) {
        return this == o || (o instanceof n0 && androidx.core.util.c.a(this.a, ((n0)o).a));
    }
    
    public androidx.core.graphics.e f(final int n) {
        return this.a.g(n);
    }
    
    @Deprecated
    public androidx.core.graphics.e g() {
        return this.a.i();
    }
    
    @Deprecated
    public androidx.core.graphics.e h() {
        return this.a.j();
    }
    
    @Override
    public int hashCode() {
        final l a = this.a;
        int hashCode;
        if (a == null) {
            hashCode = 0;
        }
        else {
            hashCode = a.hashCode();
        }
        return hashCode;
    }
    
    @Deprecated
    public int i() {
        return this.a.k().d;
    }
    
    @Deprecated
    public int j() {
        return this.a.k().a;
    }
    
    @Deprecated
    public int k() {
        return this.a.k().c;
    }
    
    @Deprecated
    public int l() {
        return this.a.k().b;
    }
    
    public n0 m(final int n, final int n2, final int n3, final int n4) {
        return this.a.m(n, n2, n3, n4);
    }
    
    public boolean o() {
        return this.a.n();
    }
    
    @Deprecated
    public n0 p(final int n, final int n2, final int n3, final int n4) {
        return new b(this).c(androidx.core.graphics.e.b(n, n2, n3, n4)).a();
    }
    
    void q(final androidx.core.graphics.e[] array) {
        this.a.p(array);
    }
    
    void r(final androidx.core.graphics.e e) {
        this.a.q(e);
    }
    
    void s(final n0 n0) {
        this.a.r(n0);
    }
    
    void t(final androidx.core.graphics.e e) {
        this.a.s(e);
    }
    
    public WindowInsets u() {
        final l a = this.a;
        WindowInsets c;
        if (a instanceof g) {
            c = ((g)a).c;
        }
        else {
            c = null;
        }
        return c;
    }
    
    static class a
    {
        private static Field a;
        private static Field b;
        private static Field c;
        private static boolean d;
        
        static {
            try {
                (n0.a.a = View.class.getDeclaredField("mAttachInfo")).setAccessible(true);
                final Class<?> forName = Class.forName("android.view.View$AttachInfo");
                (n0.a.b = forName.getDeclaredField("mStableInsets")).setAccessible(true);
                (n0.a.c = forName.getDeclaredField("mContentInsets")).setAccessible(true);
                n0.a.d = true;
            }
            catch (final ReflectiveOperationException ex) {
                final StringBuilder sb = new StringBuilder();
                sb.append("Failed to get visible insets from AttachInfo ");
                sb.append(ex.getMessage());
                Log.w("WindowInsetsCompat", sb.toString(), (Throwable)ex);
            }
        }
        
        public static n0 a(final View view) {
            if (n0.a.d) {
                if (view.isAttachedToWindow()) {
                    final View rootView = view.getRootView();
                    try {
                        final Object value = n0.a.a.get(rootView);
                        if (value != null) {
                            final Rect rect = (Rect)n0.a.b.get(value);
                            final Rect rect2 = (Rect)n0.a.c.get(value);
                            if (rect != null && rect2 != null) {
                                final n0 a = new b().b(androidx.core.graphics.e.c(rect)).c(androidx.core.graphics.e.c(rect2)).a();
                                a.s(a);
                                a.d(view.getRootView());
                                return a;
                            }
                        }
                    }
                    catch (final IllegalAccessException ex) {
                        final StringBuilder sb = new StringBuilder();
                        sb.append("Failed to get insets from AttachInfo. ");
                        sb.append(ex.getMessage());
                        Log.w("WindowInsetsCompat", sb.toString(), (Throwable)ex);
                    }
                }
            }
            return null;
        }
    }
    
    public static final class b
    {
        private final f a;
        
        public b() {
            final int sdk_INT = Build$VERSION.SDK_INT;
            if (sdk_INT >= 30) {
                this.a = new e();
            }
            else if (sdk_INT >= 29) {
                this.a = new d();
            }
            else {
                this.a = new c();
            }
        }
        
        public b(final n0 n0) {
            final int sdk_INT = Build$VERSION.SDK_INT;
            if (sdk_INT >= 30) {
                this.a = new e(n0);
            }
            else if (sdk_INT >= 29) {
                this.a = new d(n0);
            }
            else {
                this.a = new c(n0);
            }
        }
        
        public n0 a() {
            return this.a.b();
        }
        
        @Deprecated
        public b b(final androidx.core.graphics.e e) {
            this.a.d(e);
            return this;
        }
        
        @Deprecated
        public b c(final androidx.core.graphics.e e) {
            this.a.f(e);
            return this;
        }
    }
    
    private static class c extends f
    {
        private static Field e;
        private static boolean f = false;
        private static Constructor<WindowInsets> g;
        private static boolean h = false;
        private WindowInsets c;
        private androidx.core.graphics.e d;
        
        c() {
            this.c = h();
        }
        
        c(final n0 n0) {
            super(n0);
            this.c = n0.u();
        }
        
        private static WindowInsets h() {
            if (!c.f) {
                try {
                    c.e = WindowInsets.class.getDeclaredField("CONSUMED");
                }
                catch (final ReflectiveOperationException ex) {
                    Log.i("WindowInsetsCompat", "Could not retrieve WindowInsets.CONSUMED field", (Throwable)ex);
                }
                c.f = true;
            }
            final Field e = c.e;
            if (e != null) {
                try {
                    final WindowInsets windowInsets = (WindowInsets)e.get(null);
                    if (windowInsets != null) {
                        return new WindowInsets(windowInsets);
                    }
                }
                catch (final ReflectiveOperationException ex2) {
                    Log.i("WindowInsetsCompat", "Could not get value from WindowInsets.CONSUMED field", (Throwable)ex2);
                }
            }
            if (!c.h) {
                try {
                    c.g = WindowInsets.class.getConstructor(Rect.class);
                }
                catch (final ReflectiveOperationException ex3) {
                    Log.i("WindowInsetsCompat", "Could not retrieve WindowInsets(Rect) constructor", (Throwable)ex3);
                }
                c.h = true;
            }
            final Constructor<WindowInsets> g = c.g;
            if (g != null) {
                try {
                    return g.newInstance(new Rect());
                }
                catch (final ReflectiveOperationException ex4) {
                    Log.i("WindowInsetsCompat", "Could not invoke WindowInsets(Rect) constructor", (Throwable)ex4);
                }
            }
            return null;
        }
        
        @Override
        n0 b() {
            ((f)this).a();
            final n0 v = n0.v(this.c);
            v.q(super.b);
            v.t(this.d);
            return v;
        }
        
        @Override
        void d(final androidx.core.graphics.e d) {
            this.d = d;
        }
        
        @Override
        void f(final androidx.core.graphics.e e) {
            final WindowInsets c = this.c;
            if (c != null) {
                this.c = c.replaceSystemWindowInsets(e.a, e.b, e.c, e.d);
            }
        }
    }
    
    private static class f
    {
        private final n0 a;
        androidx.core.graphics.e[] b;
        
        f() {
            this(new n0((n0)null));
        }
        
        f(final n0 a) {
            this.a = a;
        }
        
        protected final void a() {
            final androidx.core.graphics.e[] b = this.b;
            if (b != null) {
                final androidx.core.graphics.e e = b[m.a(1)];
                androidx.core.graphics.e f;
                if ((f = this.b[m.a(2)]) == null) {
                    f = this.a.f(2);
                }
                androidx.core.graphics.e f2;
                if ((f2 = e) == null) {
                    f2 = this.a.f(1);
                }
                this.f(androidx.core.graphics.e.a(f2, f));
                final androidx.core.graphics.e e2 = this.b[m.a(16)];
                if (e2 != null) {
                    this.e(e2);
                }
                final androidx.core.graphics.e e3 = this.b[m.a(32)];
                if (e3 != null) {
                    this.c(e3);
                }
                final androidx.core.graphics.e e4 = this.b[m.a(64)];
                if (e4 != null) {
                    this.g(e4);
                }
            }
        }
        
        n0 b() {
            throw null;
        }
        
        void c(final androidx.core.graphics.e e) {
        }
        
        void d(final androidx.core.graphics.e e) {
            throw null;
        }
        
        void e(final androidx.core.graphics.e e) {
        }
        
        void f(final androidx.core.graphics.e e) {
            throw null;
        }
        
        void g(final androidx.core.graphics.e e) {
        }
    }
    
    private static class d extends f
    {
        final WindowInsets$Builder c;
        
        d() {
            this.c = new WindowInsets$Builder();
        }
        
        d(final n0 n0) {
            super(n0);
            final WindowInsets u = n0.u();
            WindowInsets$Builder c;
            if (u != null) {
                c = new WindowInsets$Builder(u);
            }
            else {
                c = new WindowInsets$Builder();
            }
            this.c = c;
        }
        
        @Override
        n0 b() {
            ((f)this).a();
            final n0 v = n0.v(this.c.build());
            v.q(super.b);
            return v;
        }
        
        @Override
        void c(final androidx.core.graphics.e e) {
            this.c.setMandatorySystemGestureInsets(e.e());
        }
        
        @Override
        void d(final androidx.core.graphics.e e) {
            this.c.setStableInsets(e.e());
        }
        
        @Override
        void e(final androidx.core.graphics.e e) {
            this.c.setSystemGestureInsets(e.e());
        }
        
        @Override
        void f(final androidx.core.graphics.e e) {
            this.c.setSystemWindowInsets(e.e());
        }
        
        @Override
        void g(final androidx.core.graphics.e e) {
            this.c.setTappableElementInsets(e.e());
        }
    }
    
    private static class e extends d
    {
        e() {
        }
        
        e(final n0 n0) {
            super(n0);
        }
    }
    
    private static class g extends l
    {
        private static boolean h = false;
        private static Method i;
        private static Class<?> j;
        private static Field k;
        private static Field l;
        final WindowInsets c;
        private androidx.core.graphics.e[] d;
        private androidx.core.graphics.e e;
        private n0 f;
        androidx.core.graphics.e g;
        
        g(final n0 n0, final WindowInsets c) {
            super(n0);
            this.e = null;
            this.c = c;
        }
        
        g(final n0 n0, final g g) {
            this(n0, new WindowInsets(g.c));
        }
        
        private androidx.core.graphics.e t(final int n, final boolean b) {
            androidx.core.graphics.e e = androidx.core.graphics.e.e;
            for (int i = 1; i <= 256; i <<= 1) {
                if ((n & i) != 0x0) {
                    e = androidx.core.graphics.e.a(e, this.u(i, b));
                }
            }
            return e;
        }
        
        private androidx.core.graphics.e v() {
            final n0 f = this.f;
            if (f != null) {
                return f.g();
            }
            return androidx.core.graphics.e.e;
        }
        
        private androidx.core.graphics.e w(final View view) {
            if (Build$VERSION.SDK_INT < 30) {
                if (!n0.g.h) {
                    x();
                }
                final Method i = n0.g.i;
                final androidx.core.graphics.e e = null;
                if (i != null && n0.g.j != null) {
                    if (n0.g.k != null) {
                        try {
                            final Object invoke = i.invoke(view, new Object[0]);
                            if (invoke == null) {
                                Log.w("WindowInsetsCompat", "Failed to get visible insets. getViewRootImpl() returned null from the provided view. This means that the view is either not attached or the method has been overridden", (Throwable)new NullPointerException());
                                return null;
                            }
                            final Rect rect = (Rect)n0.g.k.get(n0.g.l.get(invoke));
                            androidx.core.graphics.e c = e;
                            if (rect != null) {
                                c = androidx.core.graphics.e.c(rect);
                            }
                            return c;
                        }
                        catch (final ReflectiveOperationException ex) {
                            final StringBuilder sb = new StringBuilder();
                            sb.append("Failed to get visible insets. (Reflection error). ");
                            sb.append(ex.getMessage());
                            Log.e("WindowInsetsCompat", sb.toString(), (Throwable)ex);
                        }
                    }
                }
                return null;
            }
            throw new UnsupportedOperationException("getVisibleInsets() should not be called on API >= 30. Use WindowInsets.isVisible() instead.");
        }
        
        private static void x() {
            try {
                g.i = View.class.getDeclaredMethod("getViewRootImpl", (Class<?>[])new Class[0]);
                g.k = (g.j = Class.forName("android.view.View$AttachInfo")).getDeclaredField("mVisibleInsets");
                g.l = Class.forName("android.view.ViewRootImpl").getDeclaredField("mAttachInfo");
                g.k.setAccessible(true);
                g.l.setAccessible(true);
            }
            catch (final ReflectiveOperationException ex) {
                final StringBuilder sb = new StringBuilder();
                sb.append("Failed to get visible insets. (Reflection error). ");
                sb.append(ex.getMessage());
                Log.e("WindowInsetsCompat", sb.toString(), (Throwable)ex);
            }
            g.h = true;
        }
        
        @Override
        void d(final View view) {
            androidx.core.graphics.e e;
            if ((e = this.w(view)) == null) {
                e = androidx.core.graphics.e.e;
            }
            this.q(e);
        }
        
        @Override
        void e(final n0 n0) {
            n0.s(this.f);
            n0.r(this.g);
        }
        
        @Override
        public boolean equals(final Object o) {
            return super.equals(o) && Objects.equals(this.g, ((g)o).g);
        }
        
        public androidx.core.graphics.e g(final int n) {
            return this.t(n, false);
        }
        
        @Override
        final androidx.core.graphics.e k() {
            if (this.e == null) {
                this.e = androidx.core.graphics.e.b(this.c.getSystemWindowInsetLeft(), this.c.getSystemWindowInsetTop(), this.c.getSystemWindowInsetRight(), this.c.getSystemWindowInsetBottom());
            }
            return this.e;
        }
        
        @Override
        n0 m(final int n, final int n2, final int n3, final int n4) {
            final b b = new b(n0.v(this.c));
            b.c(n0.n(this.k(), n, n2, n3, n4));
            b.b(n0.n(((l)this).i(), n, n2, n3, n4));
            return b.a();
        }
        
        @Override
        boolean o() {
            return this.c.isRound();
        }
        
        @Override
        public void p(final androidx.core.graphics.e[] d) {
            this.d = d;
        }
        
        @Override
        void q(final androidx.core.graphics.e g) {
            this.g = g;
        }
        
        @Override
        void r(final n0 f) {
            this.f = f;
        }
        
        protected androidx.core.graphics.e u(int n, final boolean b) {
            if (n != 1) {
                androidx.core.graphics.e g = null;
                final androidx.core.graphics.e e = null;
                if (n != 2) {
                    if (n != 8) {
                        if (n == 16) {
                            return ((l)this).j();
                        }
                        if (n == 32) {
                            return ((l)this).h();
                        }
                        if (n == 64) {
                            return ((l)this).l();
                        }
                        if (n != 128) {
                            return androidx.core.graphics.e.e;
                        }
                        final n0 f = this.f;
                        androidx.core.view.d d;
                        if (f != null) {
                            d = f.e();
                        }
                        else {
                            d = ((l)this).f();
                        }
                        if (d != null) {
                            return androidx.core.graphics.e.b(d.b(), d.d(), d.c(), d.a());
                        }
                        return androidx.core.graphics.e.e;
                    }
                    else {
                        final androidx.core.graphics.e[] d2 = this.d;
                        androidx.core.graphics.e e2 = e;
                        if (d2 != null) {
                            e2 = d2[m.a(8)];
                        }
                        if (e2 != null) {
                            return e2;
                        }
                        final androidx.core.graphics.e k = this.k();
                        final androidx.core.graphics.e v = this.v();
                        n = k.d;
                        if (n > v.d) {
                            return androidx.core.graphics.e.b(0, 0, 0, n);
                        }
                        final androidx.core.graphics.e g2 = this.g;
                        if (g2 != null && !g2.equals(androidx.core.graphics.e.e)) {
                            n = this.g.d;
                            if (n > v.d) {
                                return androidx.core.graphics.e.b(0, 0, 0, n);
                            }
                        }
                        return androidx.core.graphics.e.e;
                    }
                }
                else {
                    if (b) {
                        final androidx.core.graphics.e v2 = this.v();
                        final androidx.core.graphics.e i = ((l)this).i();
                        return androidx.core.graphics.e.b(Math.max(v2.a, i.a), 0, Math.max(v2.c, i.c), Math.max(v2.d, i.d));
                    }
                    final androidx.core.graphics.e j = this.k();
                    final n0 f2 = this.f;
                    if (f2 != null) {
                        g = f2.g();
                    }
                    final int n2 = n = j.d;
                    if (g != null) {
                        n = Math.min(n2, g.d);
                    }
                    return androidx.core.graphics.e.b(j.a, 0, j.c, n);
                }
            }
            else {
                if (b) {
                    return androidx.core.graphics.e.b(0, Math.max(this.v().b, this.k().b), 0, 0);
                }
                return androidx.core.graphics.e.b(0, this.k().b, 0, 0);
            }
        }
    }
    
    private static class l
    {
        static final n0 b;
        final n0 a;
        
        static {
            b = new b().a().a().b().c();
        }
        
        l(final n0 a) {
            this.a = a;
        }
        
        n0 a() {
            return this.a;
        }
        
        n0 b() {
            return this.a;
        }
        
        n0 c() {
            return this.a;
        }
        
        void d(final View view) {
        }
        
        void e(final n0 n0) {
        }
        
        @Override
        public boolean equals(final Object o) {
            boolean b = true;
            if (this == o) {
                return true;
            }
            if (!(o instanceof l)) {
                return false;
            }
            final l l = (l)o;
            if (this.o() != l.o() || this.n() != l.n() || !androidx.core.util.c.a(this.k(), l.k()) || !androidx.core.util.c.a(this.i(), l.i()) || !androidx.core.util.c.a(this.f(), l.f())) {
                b = false;
            }
            return b;
        }
        
        androidx.core.view.d f() {
            return null;
        }
        
        androidx.core.graphics.e g(final int n) {
            return androidx.core.graphics.e.e;
        }
        
        androidx.core.graphics.e h() {
            return this.k();
        }
        
        @Override
        public int hashCode() {
            return androidx.core.util.c.b(this.o(), this.n(), this.k(), this.i(), this.f());
        }
        
        androidx.core.graphics.e i() {
            return androidx.core.graphics.e.e;
        }
        
        androidx.core.graphics.e j() {
            return this.k();
        }
        
        androidx.core.graphics.e k() {
            return androidx.core.graphics.e.e;
        }
        
        androidx.core.graphics.e l() {
            return this.k();
        }
        
        n0 m(final int n, final int n2, final int n3, final int n4) {
            return l.b;
        }
        
        boolean n() {
            return false;
        }
        
        boolean o() {
            return false;
        }
        
        public void p(final androidx.core.graphics.e[] array) {
        }
        
        void q(final androidx.core.graphics.e e) {
        }
        
        void r(final n0 n0) {
        }
        
        public void s(final androidx.core.graphics.e e) {
        }
    }
    
    private static class h extends g
    {
        private androidx.core.graphics.e m;
        
        h(final n0 n0, final WindowInsets windowInsets) {
            super(n0, windowInsets);
            this.m = null;
        }
        
        h(final n0 n0, final h h) {
            super(n0, (g)h);
            this.m = null;
            this.m = h.m;
        }
        
        @Override
        n0 b() {
            return n0.v(super.c.consumeStableInsets());
        }
        
        @Override
        n0 c() {
            return n0.v(super.c.consumeSystemWindowInsets());
        }
        
        @Override
        final androidx.core.graphics.e i() {
            if (this.m == null) {
                this.m = e.b(super.c.getStableInsetLeft(), super.c.getStableInsetTop(), super.c.getStableInsetRight(), super.c.getStableInsetBottom());
            }
            return this.m;
        }
        
        @Override
        boolean n() {
            return super.c.isConsumed();
        }
        
        @Override
        public void s(final androidx.core.graphics.e m) {
            this.m = m;
        }
    }
    
    private static class i extends h
    {
        i(final n0 n0, final WindowInsets windowInsets) {
            super(n0, windowInsets);
        }
        
        i(final n0 n0, final i i) {
            super(n0, (h)i);
        }
        
        @Override
        n0 a() {
            return n0.v(super.c.consumeDisplayCutout());
        }
        
        @Override
        public boolean equals(final Object o) {
            boolean b = true;
            if (this == o) {
                return true;
            }
            if (!(o instanceof i)) {
                return false;
            }
            final i i = (i)o;
            if (!Objects.equals(super.c, i.c) || !Objects.equals(super.g, i.g)) {
                b = false;
            }
            return b;
        }
        
        @Override
        androidx.core.view.d f() {
            return d.e(super.c.getDisplayCutout());
        }
        
        @Override
        public int hashCode() {
            return super.c.hashCode();
        }
    }
    
    private static class j extends i
    {
        private androidx.core.graphics.e n;
        private androidx.core.graphics.e o;
        private androidx.core.graphics.e p;
        
        j(final n0 n0, final WindowInsets windowInsets) {
            super(n0, windowInsets);
            this.n = null;
            this.o = null;
            this.p = null;
        }
        
        j(final n0 n0, final j j) {
            super(n0, (i)j);
            this.n = null;
            this.o = null;
            this.p = null;
        }
        
        @Override
        androidx.core.graphics.e h() {
            if (this.o == null) {
                this.o = e.d(super.c.getMandatorySystemGestureInsets());
            }
            return this.o;
        }
        
        @Override
        androidx.core.graphics.e j() {
            if (this.n == null) {
                this.n = e.d(super.c.getSystemGestureInsets());
            }
            return this.n;
        }
        
        @Override
        androidx.core.graphics.e l() {
            if (this.p == null) {
                this.p = e.d(super.c.getTappableElementInsets());
            }
            return this.p;
        }
        
        @Override
        n0 m(final int n, final int n2, final int n3, final int n4) {
            return n0.v(super.c.inset(n, n2, n3, n4));
        }
        
        @Override
        public void s(final androidx.core.graphics.e e) {
        }
    }
    
    private static class k extends j
    {
        static final n0 q;
        
        static {
            q = n0.v(WindowInsets.CONSUMED);
        }
        
        k(final n0 n0, final WindowInsets windowInsets) {
            super(n0, windowInsets);
        }
        
        k(final n0 n0, final k k) {
            super(n0, (j)k);
        }
        
        @Override
        final void d(final View view) {
        }
        
        @Override
        public androidx.core.graphics.e g(final int n) {
            return e.d(super.c.getInsets(n0.n.a(n)));
        }
    }
    
    public static final class m
    {
        static int a(final int n) {
            if (n == 1) {
                return 0;
            }
            if (n == 2) {
                return 1;
            }
            if (n == 4) {
                return 2;
            }
            if (n == 8) {
                return 3;
            }
            if (n == 16) {
                return 4;
            }
            if (n == 32) {
                return 5;
            }
            if (n == 64) {
                return 6;
            }
            if (n == 128) {
                return 7;
            }
            if (n == 256) {
                return 8;
            }
            final StringBuilder sb = new StringBuilder();
            sb.append("type needs to be >= FIRST and <= LAST, type=");
            sb.append(n);
            throw new IllegalArgumentException(sb.toString());
        }
        
        public static int b() {
            return 32;
        }
        
        public static int c() {
            return 2;
        }
        
        public static int d() {
            return 1;
        }
        
        public static int e() {
            return 7;
        }
    }
    
    private static final class n
    {
        static int a(final int n) {
            int n2 = 0;
            int n3;
            for (int i = 1; i <= 256; i <<= 1, n2 = n3) {
                n3 = n2;
                if ((n & i) != 0x0) {
                    int n4;
                    if (i != 1) {
                        if (i != 2) {
                            if (i != 4) {
                                if (i != 8) {
                                    if (i != 16) {
                                        if (i != 32) {
                                            if (i != 64) {
                                                if (i != 128) {
                                                    n3 = n2;
                                                    continue;
                                                }
                                                n4 = WindowInsets$Type.displayCutout();
                                            }
                                            else {
                                                n4 = WindowInsets$Type.tappableElement();
                                            }
                                        }
                                        else {
                                            n4 = WindowInsets$Type.mandatorySystemGestures();
                                        }
                                    }
                                    else {
                                        n4 = WindowInsets$Type.systemGestures();
                                    }
                                }
                                else {
                                    n4 = WindowInsets$Type.ime();
                                }
                            }
                            else {
                                n4 = WindowInsets$Type.captionBar();
                            }
                        }
                        else {
                            n4 = WindowInsets$Type.navigationBars();
                        }
                    }
                    else {
                        n4 = WindowInsets$Type.statusBars();
                    }
                    n3 = (n2 | n4);
                }
            }
            return n2;
        }
    }
}
