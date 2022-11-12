// 
// Decompiled by Procyon v0.6.0
// 

package androidx.core.view;

import android.view.ViewGroup;
import android.util.SparseArray;
import java.lang.ref.WeakReference;
import android.view.OnReceiveContentListener;
import android.view.ContentInfo;
import android.view.View$OnUnhandledKeyEventListener;
import java.util.Objects;
import java.util.Collection;
import android.view.View$DragShadowBuilder;
import android.content.ClipData;
import android.view.View$OnApplyWindowInsetsListener;
import android.graphics.Paint;
import android.view.ViewTreeObserver;
import android.view.accessibility.AccessibilityNodeProvider;
import java.util.Iterator;
import java.util.Map;
import android.view.View$OnAttachStateChangeListener;
import android.view.ViewTreeObserver$OnGlobalLayoutListener;
import android.view.Display;
import android.graphics.drawable.Drawable;
import android.graphics.PorterDuff$Mode;
import android.content.res.ColorStateList;
import java.util.ArrayList;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.content.Context;
import android.view.View$AccessibilityDelegate;
import java.util.List;
import android.view.KeyEvent;
import android.graphics.Rect;
import android.os.Bundle;
import androidx.core.view.accessibility.d;
import androidx.core.view.accessibility.g;
import android.view.WindowInsets;
import android.util.Log;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityManager;
import android.text.TextUtils;
import android.view.ViewParent;
import android.view.PointerIcon;
import android.os.Build$VERSION;
import v.c;
import java.lang.reflect.Field;
import android.view.View;
import java.util.WeakHashMap;
import java.util.concurrent.atomic.AtomicInteger;

public class b0
{
    private static final AtomicInteger a;
    private static WeakHashMap<View, i0> b;
    private static Field c;
    private static boolean d;
    private static final int[] e;
    private static final x f;
    private static final e g;
    
    static {
        a = new AtomicInteger(1);
        b0.b = null;
        b0.d = false;
        e = new int[] { v.c.b, v.c.c, v.c.n, v.c.y, v.c.B, v.c.C, v.c.D, v.c.E, v.c.F, v.c.G, v.c.d, v.c.e, v.c.f, v.c.g, v.c.h, v.c.i, v.c.j, v.c.k, v.c.l, v.c.m, v.c.o, v.c.p, v.c.q, v.c.r, v.c.s, v.c.t, v.c.u, v.c.v, v.c.w, v.c.x, v.c.z, v.c.A };
        f = a0.a;
        g = new e();
    }
    
    public static int A(final View view) {
        return p.b(view);
    }
    
    public static void A0(final View view, final int n) {
        h.s(view, n);
    }
    
    public static int B(final View view) {
        return i.d(view);
    }
    
    public static void B0(final View view, final int n) {
        p.l(view, n);
    }
    
    public static int C(final View view) {
        return h.d(view);
    }
    
    public static void C0(final View view, final boolean b) {
        m.t(view, b);
    }
    
    public static int D(final View view) {
        return h.e(view);
    }
    
    public static void D0(final View view, final androidx.core.view.v v) {
        m.u(view, v);
    }
    
    public static String[] E(final View view) {
        if (Build$VERSION.SDK_INT >= 31) {
            return t.a(view);
        }
        return (String[])view.getTag(v.c.N);
    }
    
    public static void E0(final View view, final int n, final int n2, final int n3, final int n4) {
        i.k(view, n, n2, n3, n4);
    }
    
    public static int F(final View view) {
        return i.e(view);
    }
    
    public static void F0(final View view, final z z) {
        Object a;
        if (z != null) {
            a = z.a();
        }
        else {
            a = null;
        }
        o.d(view, (PointerIcon)a);
    }
    
    public static int G(final View view) {
        return i.f(view);
    }
    
    public static void G0(final View view, final boolean b) {
        o0().g(view, b);
    }
    
    public static n0 H(final View view) {
        return n.a(view);
    }
    
    public static void H0(final View view, final int n, final int n2) {
        b0.n.d(view, n, n2);
    }
    
    public static CharSequence I(final View view) {
        return L0().f(view);
    }
    
    public static void I0(final View view, final CharSequence charSequence) {
        L0().g(view, charSequence);
    }
    
    public static String J(final View view) {
        return m.k(view);
    }
    
    public static void J0(final View view, final String s) {
        m.v(view, s);
    }
    
    @Deprecated
    public static float K(final View view) {
        return view.getTranslationY();
    }
    
    private static void K0(final View view) {
        if (z(view) == 0) {
            A0(view, 1);
        }
        for (ViewParent viewParent = view.getParent(); viewParent instanceof View; viewParent = viewParent.getParent()) {
            if (z((View)viewParent) == 4) {
                A0(view, 2);
                break;
            }
        }
    }
    
    @Deprecated
    public static int L(final View view) {
        return h.g(view);
    }
    
    private static f<CharSequence> L0() {
        return (f<CharSequence>)new f<CharSequence>(v.c.P, CharSequence.class, 64, 30) {
            @Override
            /* bridge */ Object d(final View view) {
                return this.i(view);
            }
            
            @Override
            /* bridge */ void e(final View view, final Object o) {
                this.j(view, (CharSequence)o);
            }
            
            @Override
            /* bridge */ boolean h(final Object o, final Object o2) {
                return this.k((CharSequence)o, (CharSequence)o2);
            }
            
            CharSequence i(final View view) {
                return s.a(view);
            }
            
            void j(final View view, final CharSequence charSequence) {
                s.b(view, charSequence);
            }
            
            boolean k(final CharSequence charSequence, final CharSequence charSequence2) {
                return TextUtils.equals(charSequence, charSequence2) ^ true;
            }
        };
    }
    
    public static float M(final View view) {
        return m.m(view);
    }
    
    public static void M0(final View view) {
        m.z(view);
    }
    
    public static boolean N(final View view) {
        return m(view) != null;
    }
    
    public static boolean O(final View view) {
        return b0.g.a(view);
    }
    
    public static boolean P(final View view) {
        return h.h(view);
    }
    
    public static boolean Q(final View view) {
        return h.i(view);
    }
    
    public static boolean R(final View view) {
        final Boolean b = b().f(view);
        return b != null && b;
    }
    
    public static boolean S(final View view) {
        return k.b(view);
    }
    
    public static boolean T(final View view) {
        return k.c(view);
    }
    
    public static boolean U(final View view) {
        return m.p(view);
    }
    
    public static boolean V(final View view) {
        return i.g(view);
    }
    
    public static boolean W(final View view) {
        final Boolean b = o0().f(view);
        return b != null && b;
    }
    
    private static androidx.core.view.c X(final androidx.core.view.c c) {
        return c;
    }
    
    static void Y(final View source, final int n) {
        final AccessibilityManager accessibilityManager = (AccessibilityManager)source.getContext().getSystemService("accessibility");
        if (!accessibilityManager.isEnabled()) {
            return;
        }
        final boolean b = p(source) != null && source.isShown() && source.getWindowVisibility() == 0;
        final int o = o(source);
        int eventType = 32;
        if (o == 0 && !b) {
            if (n == 32) {
                final AccessibilityEvent obtain = AccessibilityEvent.obtain();
                source.onInitializeAccessibilityEvent(obtain);
                obtain.setEventType(32);
                k.g(obtain, n);
                obtain.setSource(source);
                source.onPopulateAccessibilityEvent(obtain);
                obtain.getText().add(p(source));
                accessibilityManager.sendAccessibilityEvent(obtain);
            }
            else if (source.getParent() != null) {
                final ViewParent parent = source.getParent();
                try {
                    k.e(parent, source, source, n);
                }
                catch (final AbstractMethodError abstractMethodError) {
                    final StringBuilder sb = new StringBuilder();
                    sb.append(source.getParent().getClass().getSimpleName());
                    sb.append(" does not fully implement ViewParent");
                    Log.e("ViewCompat", sb.toString(), (Throwable)abstractMethodError);
                }
            }
        }
        else {
            final AccessibilityEvent obtain2 = AccessibilityEvent.obtain();
            if (!b) {
                eventType = 2048;
            }
            obtain2.setEventType(eventType);
            k.g(obtain2, n);
            if (b) {
                obtain2.getText().add(p(source));
                K0(source);
            }
            source.sendAccessibilityEventUnchecked(obtain2);
        }
    }
    
    public static void Z(final View view, final int n) {
        view.offsetLeftAndRight(n);
    }
    
    public static androidx.core.view.c a(final androidx.core.view.c c) {
        return X(c);
    }
    
    public static void a0(final View view, final int n) {
        view.offsetTopAndBottom(n);
    }
    
    private static f<Boolean> b() {
        return (f<Boolean>)new f<Boolean>(v.c.J, Boolean.class, 28) {
            @Override
            /* bridge */ Object d(final View view) {
                return this.i(view);
            }
            
            @Override
            /* bridge */ void e(final View view, final Object o) {
                this.j(view, (Boolean)o);
            }
            
            @Override
            /* bridge */ boolean h(final Object o, final Object o2) {
                return this.k((Boolean)o, (Boolean)o2);
            }
            
            Boolean i(final View view) {
                return q.c(view);
            }
            
            void j(final View view, final Boolean b) {
                q.g(view, b);
            }
            
            boolean k(final Boolean b, final Boolean b2) {
                return ((f)this).a(b, b2) ^ true;
            }
        };
    }
    
    public static n0 b0(final View view, final n0 n0) {
        final WindowInsets u = n0.u();
        if (u != null) {
            final WindowInsets b = l.b(view, u);
            if (!b.equals((Object)u)) {
                return n0.w(b, view);
            }
        }
        return n0;
    }
    
    public static int c(final View view, final CharSequence charSequence, final androidx.core.view.accessibility.g g) {
        final int r = r(view, charSequence);
        if (r != -1) {
            d(view, new d.a(r, charSequence, g));
        }
        return r;
    }
    
    public static void c0(final View view, final d d) {
        view.onInitializeAccessibilityNodeInfo(d.s0());
    }
    
    private static void d(final View view, final d.a a) {
        j(view);
        k0(a.b(), view);
        q(view).add(a);
        Y(view, 0);
    }
    
    private static f<CharSequence> d0() {
        return (f<CharSequence>)new f<CharSequence>(v.c.K, CharSequence.class, 8, 28) {
            @Override
            /* bridge */ Object d(final View view) {
                return this.i(view);
            }
            
            @Override
            /* bridge */ void e(final View view, final Object o) {
                this.j(view, (CharSequence)o);
            }
            
            @Override
            /* bridge */ boolean h(final Object o, final Object o2) {
                return this.k((CharSequence)o, (CharSequence)o2);
            }
            
            CharSequence i(final View view) {
                return q.b(view);
            }
            
            void j(final View view, final CharSequence charSequence) {
                q.h(view, charSequence);
            }
            
            boolean k(final CharSequence charSequence, final CharSequence charSequence2) {
                return TextUtils.equals(charSequence, charSequence2) ^ true;
            }
        };
    }
    
    public static i0 e(final View view) {
        if (b0.b == null) {
            b0.b = new WeakHashMap<View, i0>();
        }
        i0 i0;
        if ((i0 = b0.b.get(view)) == null) {
            i0 = new i0(view);
            b0.b.put(view, i0);
        }
        return i0;
    }
    
    public static boolean e0(final View view, final int n, final Bundle bundle) {
        return h.j(view, n, bundle);
    }
    
    public static n0 f(final View view, final n0 n0, final Rect rect) {
        return m.b(view, n0, rect);
    }
    
    public static androidx.core.view.c f0(final View view, androidx.core.view.c a) {
        if (Log.isLoggable("ViewCompat", 3)) {
            final StringBuilder sb = new StringBuilder();
            sb.append("performReceiveContent: ");
            sb.append(a);
            sb.append(", view=");
            sb.append(view.getClass().getSimpleName());
            sb.append("[");
            sb.append(view.getId());
            sb.append("]");
            Log.d("ViewCompat", sb.toString());
        }
        if (Build$VERSION.SDK_INT >= 31) {
            return t.b(view, a);
        }
        final androidx.core.view.w w = (androidx.core.view.w)view.getTag(v.c.M);
        if (w != null) {
            a = w.a(view, a);
            androidx.core.view.c onReceiveContent;
            if (a == null) {
                onReceiveContent = null;
            }
            else {
                onReceiveContent = x(view).onReceiveContent(a);
            }
            return onReceiveContent;
        }
        return x(view).onReceiveContent(a);
    }
    
    public static n0 g(final View view, final n0 n0) {
        final WindowInsets u = n0.u();
        if (u != null) {
            final WindowInsets a = l.a(view, u);
            if (!a.equals((Object)u)) {
                return n0.w(a, view);
            }
        }
        return n0;
    }
    
    public static void g0(final View view) {
        h.k(view);
    }
    
    static boolean h(final View view, final KeyEvent keyEvent) {
        return Build$VERSION.SDK_INT < 28 && w.a(view).b(view, keyEvent);
    }
    
    public static void h0(final View view, final Runnable runnable) {
        h.m(view, runnable);
    }
    
    static boolean i(final View view, final KeyEvent keyEvent) {
        return Build$VERSION.SDK_INT < 28 && w.a(view).f(keyEvent);
    }
    
    public static void i0(final View view, final Runnable runnable, final long n) {
        h.n(view, runnable, n);
    }
    
    static void j(final View view) {
        a l;
        if ((l = l(view)) == null) {
            l = new a();
        }
        p0(view, l);
    }
    
    public static void j0(final View view, final int n) {
        k0(n, view);
        Y(view, 0);
    }
    
    public static int k() {
        return i.a();
    }
    
    private static void k0(final int n, final View view) {
        final List<d.a> q = q(view);
        for (int i = 0; i < q.size(); ++i) {
            if (((d.a)q.get(i)).b() == n) {
                q.remove(i);
                break;
            }
        }
    }
    
    public static a l(final View view) {
        final View$AccessibilityDelegate m = m(view);
        if (m == null) {
            return null;
        }
        if (m instanceof a.a) {
            return ((a.a)m).a;
        }
        return new a(m);
    }
    
    public static void l0(final View view, final d.a a, final CharSequence charSequence, final androidx.core.view.accessibility.g g) {
        if (g == null && charSequence == null) {
            j0(view, a.b());
        }
        else {
            d(view, a.a(charSequence, g));
        }
    }
    
    private static View$AccessibilityDelegate m(final View view) {
        if (Build$VERSION.SDK_INT >= 29) {
            return r.a(view);
        }
        return n(view);
    }
    
    public static void m0(final View view) {
        l.c(view);
    }
    
    private static View$AccessibilityDelegate n(final View view) {
        if (b0.d) {
            return null;
        }
        if (b0.c == null) {
            try {
                (b0.c = View.class.getDeclaredField("mAccessibilityDelegate")).setAccessible(true);
            }
            finally {
                b0.d = true;
                return null;
            }
        }
        try {
            final Object value = b0.c.get(view);
            if (value instanceof View$AccessibilityDelegate) {
                return (View$AccessibilityDelegate)value;
            }
            return null;
        }
        finally {
            b0.d = true;
            return null;
        }
    }
    
    public static void n0(final View view, final Context context, final int[] array, final AttributeSet set, final TypedArray typedArray, final int n, final int n2) {
        if (Build$VERSION.SDK_INT >= 29) {
            r.c(view, context, array, set, typedArray, n, n2);
        }
    }
    
    public static int o(final View view) {
        return k.a(view);
    }
    
    private static f<Boolean> o0() {
        return (f<Boolean>)new f<Boolean>(v.c.O, Boolean.class, 28) {
            @Override
            /* bridge */ Object d(final View view) {
                return this.i(view);
            }
            
            @Override
            /* bridge */ void e(final View view, final Object o) {
                this.j(view, (Boolean)o);
            }
            
            @Override
            /* bridge */ boolean h(final Object o, final Object o2) {
                return this.k((Boolean)o, (Boolean)o2);
            }
            
            Boolean i(final View view) {
                return q.d(view);
            }
            
            void j(final View view, final Boolean b) {
                q.i(view, b);
            }
            
            boolean k(final Boolean b, final Boolean b2) {
                return ((f)this).a(b, b2) ^ true;
            }
        };
    }
    
    public static CharSequence p(final View view) {
        return d0().f(view);
    }
    
    public static void p0(final View view, final a a) {
        a a2 = a;
        if (a == null) {
            a2 = a;
            if (m(view) instanceof a.a) {
                a2 = new a();
            }
        }
        View$AccessibilityDelegate bridge;
        if (a2 == null) {
            bridge = null;
        }
        else {
            bridge = a2.getBridge();
        }
        view.setAccessibilityDelegate(bridge);
    }
    
    private static List<d.a> q(final View view) {
        final int h = v.c.H;
        ArrayList list;
        if ((list = (ArrayList)view.getTag(h)) == null) {
            list = new ArrayList();
            view.setTag(h, (Object)list);
        }
        return list;
    }
    
    public static void q0(final View view, final boolean b) {
        b().g(view, b);
    }
    
    private static int r(final View view, final CharSequence charSequence) {
        final List<d.a> q = q(view);
        for (int i = 0; i < q.size(); ++i) {
            if (TextUtils.equals(charSequence, ((d.a)q.get(i)).c())) {
                return ((d.a)q.get(i)).b();
            }
        }
        int n = -1;
        int n2 = 0;
        while (true) {
            final int[] e = b0.e;
            if (n2 >= e.length || n != -1) {
                break;
            }
            final int n3 = e[n2];
            int j = 0;
            boolean b = true;
            while (j < q.size()) {
                b &= (((d.a)q.get(j)).b() != n3);
                ++j;
            }
            if (b) {
                n = n3;
            }
            ++n2;
        }
        return n;
    }
    
    public static void r0(final View view, final int n) {
        k.f(view, n);
    }
    
    public static ColorStateList s(final View view) {
        return m.g(view);
    }
    
    public static void s0(final View view, final CharSequence charSequence) {
        d0().g(view, charSequence);
        if (charSequence != null) {
            b0.g.a(view);
        }
        else {
            b0.g.d(view);
        }
    }
    
    public static PorterDuff$Mode t(final View view) {
        return m.h(view);
    }
    
    public static void t0(final View view, final Drawable drawable) {
        h.q(view, drawable);
    }
    
    public static Rect u(final View view) {
        return j.a(view);
    }
    
    public static void u0(final View view, final ColorStateList list) {
        m.q(view, list);
    }
    
    public static Display v(final View view) {
        return i.b(view);
    }
    
    public static void v0(final View view, final PorterDuff$Mode porterDuff$Mode) {
        m.r(view, porterDuff$Mode);
    }
    
    public static float w(final View view) {
        return m.i(view);
    }
    
    public static void w0(final View view, final Rect rect) {
        j.c(view, rect);
    }
    
    private static x x(final View view) {
        if (view instanceof x) {
            return (x)view;
        }
        return b0.f;
    }
    
    public static void x0(final View view, final float n) {
        m.s(view, n);
    }
    
    public static boolean y(final View view) {
        return h.b(view);
    }
    
    @Deprecated
    public static void y0(final View view, final boolean fitsSystemWindows) {
        view.setFitsSystemWindows(fitsSystemWindows);
    }
    
    public static int z(final View view) {
        return h.c(view);
    }
    
    public static void z0(final View view, final boolean b) {
        h.r(view, b);
    }
    
    static class e implements ViewTreeObserver$OnGlobalLayoutListener, View$OnAttachStateChangeListener
    {
        private final WeakHashMap<View, Boolean> a;
        
        e() {
            this.a = new WeakHashMap<View, Boolean>();
        }
        
        private void b(final View view, final boolean b) {
            final boolean b2 = view.isShown() && view.getWindowVisibility() == 0;
            if (b != b2) {
                int n;
                if (b2) {
                    n = 16;
                }
                else {
                    n = 32;
                }
                b0.Y(view, n);
                this.a.put(view, b2);
            }
        }
        
        private void c(final View view) {
            view.getViewTreeObserver().addOnGlobalLayoutListener((ViewTreeObserver$OnGlobalLayoutListener)this);
        }
        
        private void e(final View view) {
            h.o(view.getViewTreeObserver(), (ViewTreeObserver$OnGlobalLayoutListener)this);
        }
        
        void a(final View view) {
            this.a.put(view, view.isShown() && view.getWindowVisibility() == 0);
            view.addOnAttachStateChangeListener((View$OnAttachStateChangeListener)this);
            if (k.b(view)) {
                this.c(view);
            }
        }
        
        void d(final View view) {
            this.a.remove(view);
            view.removeOnAttachStateChangeListener((View$OnAttachStateChangeListener)this);
            this.e(view);
        }
        
        public void onGlobalLayout() {
            if (Build$VERSION.SDK_INT < 28) {
                for (final Map.Entry<View, V> entry : this.a.entrySet()) {
                    this.b(entry.getKey(), (boolean)entry.getValue());
                }
            }
        }
        
        public void onViewAttachedToWindow(final View view) {
            this.c(view);
        }
        
        public void onViewDetachedFromWindow(final View view) {
        }
    }
    
    abstract static class f<T>
    {
        private final int a;
        private final Class<T> b;
        private final int c;
        private final int d;
        
        f(final int n, final Class<T> clazz, final int n2) {
            this(n, clazz, 0, n2);
        }
        
        f(final int a, final Class<T> b, final int d, final int c) {
            this.a = a;
            this.b = b;
            this.d = d;
            this.c = c;
        }
        
        private boolean b() {
            return true;
        }
        
        private boolean c() {
            return Build$VERSION.SDK_INT >= this.c;
        }
        
        boolean a(final Boolean b, final Boolean b2) {
            boolean b3 = true;
            if ((b != null && b) != (b2 != null && b2)) {
                b3 = false;
            }
            return b3;
        }
        
        abstract T d(final View p0);
        
        abstract void e(final View p0, final T p1);
        
        T f(final View view) {
            if (this.c()) {
                return this.d(view);
            }
            if (this.b()) {
                final Object tag = view.getTag(this.a);
                if (this.b.isInstance(tag)) {
                    return (T)tag;
                }
            }
            return null;
        }
        
        void g(final View view, final T t) {
            if (this.c()) {
                this.e(view, t);
            }
            else if (this.b() && this.h(this.f(view), t)) {
                b0.j(view);
                view.setTag(this.a, (Object)t);
                b0.Y(view, this.d);
            }
        }
        
        abstract boolean h(final T p0, final T p1);
    }
    
    static class g
    {
        static boolean a(final View view) {
            return view.hasOnClickListeners();
        }
    }
    
    static class h
    {
        static AccessibilityNodeProvider a(final View view) {
            return view.getAccessibilityNodeProvider();
        }
        
        static boolean b(final View view) {
            return view.getFitsSystemWindows();
        }
        
        static int c(final View view) {
            return view.getImportantForAccessibility();
        }
        
        static int d(final View view) {
            return view.getMinimumHeight();
        }
        
        static int e(final View view) {
            return view.getMinimumWidth();
        }
        
        static ViewParent f(final View view) {
            return view.getParentForAccessibility();
        }
        
        static int g(final View view) {
            return view.getWindowSystemUiVisibility();
        }
        
        static boolean h(final View view) {
            return view.hasOverlappingRendering();
        }
        
        static boolean i(final View view) {
            return view.hasTransientState();
        }
        
        static boolean j(final View view, final int n, final Bundle bundle) {
            return view.performAccessibilityAction(n, bundle);
        }
        
        static void k(final View view) {
            view.postInvalidateOnAnimation();
        }
        
        static void l(final View view, final int n, final int n2, final int n3, final int n4) {
            view.postInvalidateOnAnimation(n, n2, n3, n4);
        }
        
        static void m(final View view, final Runnable runnable) {
            view.postOnAnimation(runnable);
        }
        
        static void n(final View view, final Runnable runnable, final long n) {
            view.postOnAnimationDelayed(runnable, n);
        }
        
        static void o(final ViewTreeObserver viewTreeObserver, final ViewTreeObserver$OnGlobalLayoutListener viewTreeObserver$OnGlobalLayoutListener) {
            viewTreeObserver.removeOnGlobalLayoutListener(viewTreeObserver$OnGlobalLayoutListener);
        }
        
        static void p(final View view) {
            view.requestFitSystemWindows();
        }
        
        static void q(final View view, final Drawable background) {
            view.setBackground(background);
        }
        
        static void r(final View view, final boolean hasTransientState) {
            view.setHasTransientState(hasTransientState);
        }
        
        static void s(final View view, final int importantForAccessibility) {
            view.setImportantForAccessibility(importantForAccessibility);
        }
    }
    
    static class i
    {
        static int a() {
            return View.generateViewId();
        }
        
        static Display b(final View view) {
            return view.getDisplay();
        }
        
        static int c(final View view) {
            return view.getLabelFor();
        }
        
        static int d(final View view) {
            return view.getLayoutDirection();
        }
        
        static int e(final View view) {
            return view.getPaddingEnd();
        }
        
        static int f(final View view) {
            return view.getPaddingStart();
        }
        
        static boolean g(final View view) {
            return view.isPaddingRelative();
        }
        
        static void h(final View view, final int labelFor) {
            view.setLabelFor(labelFor);
        }
        
        static void i(final View view, final Paint layerPaint) {
            view.setLayerPaint(layerPaint);
        }
        
        static void j(final View view, final int layoutDirection) {
            view.setLayoutDirection(layoutDirection);
        }
        
        static void k(final View view, final int n, final int n2, final int n3, final int n4) {
            view.setPaddingRelative(n, n2, n3, n4);
        }
    }
    
    static class j
    {
        static Rect a(final View view) {
            return view.getClipBounds();
        }
        
        static boolean b(final View view) {
            return view.isInLayout();
        }
        
        static void c(final View view, final Rect clipBounds) {
            view.setClipBounds(clipBounds);
        }
    }
    
    static class k
    {
        static int a(final View view) {
            return view.getAccessibilityLiveRegion();
        }
        
        static boolean b(final View view) {
            return view.isAttachedToWindow();
        }
        
        static boolean c(final View view) {
            return view.isLaidOut();
        }
        
        static boolean d(final View view) {
            return view.isLayoutDirectionResolved();
        }
        
        static void e(final ViewParent viewParent, final View view, final View view2, final int n) {
            viewParent.notifySubtreeAccessibilityStateChanged(view, view2, n);
        }
        
        static void f(final View view, final int accessibilityLiveRegion) {
            view.setAccessibilityLiveRegion(accessibilityLiveRegion);
        }
        
        static void g(final AccessibilityEvent accessibilityEvent, final int contentChangeTypes) {
            accessibilityEvent.setContentChangeTypes(contentChangeTypes);
        }
    }
    
    static class l
    {
        static WindowInsets a(final View view, final WindowInsets windowInsets) {
            return view.dispatchApplyWindowInsets(windowInsets);
        }
        
        static WindowInsets b(final View view, final WindowInsets windowInsets) {
            return view.onApplyWindowInsets(windowInsets);
        }
        
        static void c(final View view) {
            view.requestApplyInsets();
        }
    }
    
    private static class m
    {
        static void a(final WindowInsets windowInsets, final View view) {
            final View$OnApplyWindowInsetsListener view$OnApplyWindowInsetsListener = (View$OnApplyWindowInsetsListener)view.getTag(v.c.S);
            if (view$OnApplyWindowInsetsListener != null) {
                view$OnApplyWindowInsetsListener.onApplyWindowInsets(view, windowInsets);
            }
        }
        
        static n0 b(final View view, final n0 n0, final Rect rect) {
            final WindowInsets u = n0.u();
            if (u != null) {
                return n0.w(view.computeSystemWindowInsets(u, rect), view);
            }
            rect.setEmpty();
            return n0;
        }
        
        static boolean c(final View view, final float n, final float n2, final boolean b) {
            return view.dispatchNestedFling(n, n2, b);
        }
        
        static boolean d(final View view, final float n, final float n2) {
            return view.dispatchNestedPreFling(n, n2);
        }
        
        static boolean e(final View view, final int n, final int n2, final int[] array, final int[] array2) {
            return view.dispatchNestedPreScroll(n, n2, array, array2);
        }
        
        static boolean f(final View view, final int n, final int n2, final int n3, final int n4, final int[] array) {
            return view.dispatchNestedScroll(n, n2, n3, n4, array);
        }
        
        static ColorStateList g(final View view) {
            return view.getBackgroundTintList();
        }
        
        static PorterDuff$Mode h(final View view) {
            return view.getBackgroundTintMode();
        }
        
        static float i(final View view) {
            return view.getElevation();
        }
        
        public static n0 j(final View view) {
            return n0.a.a(view);
        }
        
        static String k(final View view) {
            return view.getTransitionName();
        }
        
        static float l(final View view) {
            return view.getTranslationZ();
        }
        
        static float m(final View view) {
            return view.getZ();
        }
        
        static boolean n(final View view) {
            return view.hasNestedScrollingParent();
        }
        
        static boolean o(final View view) {
            return view.isImportantForAccessibility();
        }
        
        static boolean p(final View view) {
            return view.isNestedScrollingEnabled();
        }
        
        static void q(final View view, final ColorStateList backgroundTintList) {
            view.setBackgroundTintList(backgroundTintList);
        }
        
        static void r(final View view, final PorterDuff$Mode backgroundTintMode) {
            view.setBackgroundTintMode(backgroundTintMode);
        }
        
        static void s(final View view, final float elevation) {
            view.setElevation(elevation);
        }
        
        static void t(final View view, final boolean nestedScrollingEnabled) {
            view.setNestedScrollingEnabled(nestedScrollingEnabled);
        }
        
        static void u(final View view, final androidx.core.view.v v) {
            if (Build$VERSION.SDK_INT < 30) {
                view.setTag(v.c.L, (Object)v);
            }
            if (v == null) {
                view.setOnApplyWindowInsetsListener((View$OnApplyWindowInsetsListener)view.getTag(v.c.S));
                return;
            }
            view.setOnApplyWindowInsetsListener((View$OnApplyWindowInsetsListener)new View$OnApplyWindowInsetsListener(view, v) {
                n0 a = null;
                final View b;
                final androidx.core.view.v c;
                
                public WindowInsets onApplyWindowInsets(final View view, final WindowInsets windowInsets) {
                    final n0 w = n0.w(windowInsets, view);
                    final int sdk_INT = Build$VERSION.SDK_INT;
                    if (sdk_INT < 30) {
                        m.a(windowInsets, this.b);
                        if (w.equals(this.a)) {
                            return this.c.a(view, w).u();
                        }
                    }
                    this.a = w;
                    final n0 a = this.c.a(view, w);
                    if (sdk_INT >= 30) {
                        return a.u();
                    }
                    b0.m0(view);
                    return a.u();
                }
            });
        }
        
        static void v(final View view, final String transitionName) {
            view.setTransitionName(transitionName);
        }
        
        static void w(final View view, final float translationZ) {
            view.setTranslationZ(translationZ);
        }
        
        static void x(final View view, final float z) {
            view.setZ(z);
        }
        
        static boolean y(final View view, final int n) {
            return view.startNestedScroll(n);
        }
        
        static void z(final View view) {
            view.stopNestedScroll();
        }
    }
    
    private static class n
    {
        public static n0 a(final View view) {
            final WindowInsets rootWindowInsets = view.getRootWindowInsets();
            if (rootWindowInsets == null) {
                return null;
            }
            final n0 v = n0.v(rootWindowInsets);
            v.s(v);
            v.d(view.getRootView());
            return v;
        }
        
        static int b(final View view) {
            return view.getScrollIndicators();
        }
        
        static void c(final View view, final int scrollIndicators) {
            view.setScrollIndicators(scrollIndicators);
        }
        
        static void d(final View view, final int n, final int n2) {
            view.setScrollIndicators(n, n2);
        }
    }
    
    static class o
    {
        static void a(final View view) {
            view.cancelDragAndDrop();
        }
        
        static void b(final View view) {
            view.dispatchFinishTemporaryDetach();
        }
        
        static void c(final View view) {
            view.dispatchStartTemporaryDetach();
        }
        
        static void d(final View view, final PointerIcon pointerIcon) {
            view.setPointerIcon(pointerIcon);
        }
        
        static boolean e(final View view, final ClipData clipData, final View$DragShadowBuilder view$DragShadowBuilder, final Object o, final int n) {
            return view.startDragAndDrop(clipData, view$DragShadowBuilder, o, n);
        }
        
        static void f(final View view, final View$DragShadowBuilder view$DragShadowBuilder) {
            view.updateDragShadow(view$DragShadowBuilder);
        }
    }
    
    static class p
    {
        static void a(final View view, final Collection<View> collection, final int n) {
            view.addKeyboardNavigationClusters((Collection)collection, n);
        }
        
        static int b(final View view) {
            return view.getImportantForAutofill();
        }
        
        static int c(final View view) {
            return view.getNextClusterForwardId();
        }
        
        static boolean d(final View view) {
            return view.hasExplicitFocusable();
        }
        
        static boolean e(final View view) {
            return view.isFocusedByDefault();
        }
        
        static boolean f(final View view) {
            return view.isImportantForAutofill();
        }
        
        static boolean g(final View view) {
            return view.isKeyboardNavigationCluster();
        }
        
        static View h(final View view, final View view2, final int n) {
            return view.keyboardNavigationClusterSearch(view2, n);
        }
        
        static boolean i(final View view) {
            return view.restoreDefaultFocus();
        }
        
        static void j(final View view, final String... autofillHints) {
            view.setAutofillHints(autofillHints);
        }
        
        static void k(final View view, final boolean focusedByDefault) {
            view.setFocusedByDefault(focusedByDefault);
        }
        
        static void l(final View view, final int importantForAutofill) {
            view.setImportantForAutofill(importantForAutofill);
        }
        
        static void m(final View view, final boolean keyboardNavigationCluster) {
            view.setKeyboardNavigationCluster(keyboardNavigationCluster);
        }
        
        static void n(final View view, final int nextClusterForwardId) {
            view.setNextClusterForwardId(nextClusterForwardId);
        }
        
        static void o(final View view, final CharSequence tooltipText) {
            view.setTooltipText(tooltipText);
        }
    }
    
    static class q
    {
        static void a(final View view, final v v) {
            final int r = v.c.R;
            androidx.collection.g g;
            if ((g = (androidx.collection.g)view.getTag(r)) == null) {
                g = new androidx.collection.g();
                view.setTag(r, (Object)g);
            }
            Objects.requireNonNull(v);
            final c0 c0 = new c0(v);
            g.put(v, c0);
            view.addOnUnhandledKeyEventListener((View$OnUnhandledKeyEventListener)c0);
        }
        
        static CharSequence b(final View view) {
            return view.getAccessibilityPaneTitle();
        }
        
        static boolean c(final View view) {
            return view.isAccessibilityHeading();
        }
        
        static boolean d(final View view) {
            return view.isScreenReaderFocusable();
        }
        
        static void e(final View view, final v v) {
            final androidx.collection.g g = (androidx.collection.g)view.getTag(v.c.R);
            if (g == null) {
                return;
            }
            final View$OnUnhandledKeyEventListener view$OnUnhandledKeyEventListener = g.get(v);
            if (view$OnUnhandledKeyEventListener != null) {
                view.removeOnUnhandledKeyEventListener(view$OnUnhandledKeyEventListener);
            }
        }
        
        static <T> T f(final View view, final int n) {
            return (T)view.requireViewById(n);
        }
        
        static void g(final View view, final boolean accessibilityHeading) {
            view.setAccessibilityHeading(accessibilityHeading);
        }
        
        static void h(final View view, final CharSequence accessibilityPaneTitle) {
            view.setAccessibilityPaneTitle(accessibilityPaneTitle);
        }
        
        static void i(final View view, final boolean screenReaderFocusable) {
            view.setScreenReaderFocusable(screenReaderFocusable);
        }
    }
    
    private static class r
    {
        static View$AccessibilityDelegate a(final View view) {
            return view.getAccessibilityDelegate();
        }
        
        static List<Rect> b(final View view) {
            return view.getSystemGestureExclusionRects();
        }
        
        static void c(final View view, final Context context, final int[] array, final AttributeSet set, final TypedArray typedArray, final int n, final int n2) {
            view.saveAttributeDataForStyleable(context, array, set, typedArray, n, n2);
        }
        
        static void d(final View view, final List<Rect> systemGestureExclusionRects) {
            view.setSystemGestureExclusionRects((List)systemGestureExclusionRects);
        }
    }
    
    private static class s
    {
        static CharSequence a(final View view) {
            return view.getStateDescription();
        }
        
        static void b(final View view, final CharSequence stateDescription) {
            view.setStateDescription(stateDescription);
        }
    }
    
    private static final class t
    {
        public static String[] a(final View view) {
            return view.getReceiveContentMimeTypes();
        }
        
        public static androidx.core.view.c b(final View view, final androidx.core.view.c c) {
            final ContentInfo f = c.f();
            final ContentInfo performReceiveContent = view.performReceiveContent(f);
            if (performReceiveContent == null) {
                return null;
            }
            if (performReceiveContent == f) {
                return c;
            }
            return c.g(performReceiveContent);
        }
        
        public static void c(final View view, final String[] array, final androidx.core.view.w w) {
            if (w == null) {
                view.setOnReceiveContentListener(array, (OnReceiveContentListener)null);
            }
            else {
                view.setOnReceiveContentListener(array, (OnReceiveContentListener)new u(w));
            }
        }
    }
    
    private static final class u implements OnReceiveContentListener
    {
        private final androidx.core.view.w a;
        
        u(final androidx.core.view.w a) {
            this.a = a;
        }
        
        public ContentInfo onReceiveContent(final View view, final ContentInfo contentInfo) {
            final androidx.core.view.c g = androidx.core.view.c.g(contentInfo);
            final androidx.core.view.c a = this.a.a(view, g);
            if (a == null) {
                return null;
            }
            if (a == g) {
                return contentInfo;
            }
            return a.f();
        }
    }
    
    public interface v
    {
        boolean onUnhandledKeyEvent(final View p0, final KeyEvent p1);
    }
    
    static class w
    {
        private static final ArrayList<WeakReference<View>> d;
        private WeakHashMap<View, Boolean> a;
        private SparseArray<WeakReference<View>> b;
        private WeakReference<KeyEvent> c;
        
        static {
            d = new ArrayList<WeakReference<View>>();
        }
        
        w() {
            this.a = null;
            this.b = null;
            this.c = null;
        }
        
        static w a(final View view) {
            final int q = v.c.Q;
            w w;
            if ((w = (w)view.getTag(q)) == null) {
                w = new w();
                view.setTag(q, (Object)w);
            }
            return w;
        }
        
        private View c(final View view, final KeyEvent keyEvent) {
            final WeakHashMap<View, Boolean> a = this.a;
            if (a != null) {
                if (a.containsKey(view)) {
                    if (view instanceof ViewGroup) {
                        final ViewGroup viewGroup = (ViewGroup)view;
                        for (int i = viewGroup.getChildCount() - 1; i >= 0; --i) {
                            final View c = this.c(viewGroup.getChildAt(i), keyEvent);
                            if (c != null) {
                                return c;
                            }
                        }
                    }
                    if (this.e(view, keyEvent)) {
                        return view;
                    }
                }
            }
            return null;
        }
        
        private SparseArray<WeakReference<View>> d() {
            if (this.b == null) {
                this.b = (SparseArray<WeakReference<View>>)new SparseArray();
            }
            return this.b;
        }
        
        private boolean e(final View view, final KeyEvent keyEvent) {
            final ArrayList list = (ArrayList)view.getTag(v.c.R);
            if (list != null) {
                for (int i = list.size() - 1; i >= 0; --i) {
                    if (((v)list.get(i)).onUnhandledKeyEvent(view, keyEvent)) {
                        return true;
                    }
                }
            }
            return false;
        }
        
        private void g() {
            final WeakHashMap<View, Boolean> a = this.a;
            if (a != null) {
                a.clear();
            }
            final ArrayList<WeakReference<View>> d = w.d;
            if (d.isEmpty()) {
                return;
            }
            synchronized (d) {
                if (this.a == null) {
                    this.a = new WeakHashMap<View, Boolean>();
                }
                for (int i = d.size() - 1; i >= 0; --i) {
                    final ArrayList<WeakReference<View>> d2 = w.d;
                    final View view = d2.get(i).get();
                    if (view == null) {
                        d2.remove(i);
                    }
                    else {
                        this.a.put(view, Boolean.TRUE);
                        for (ViewParent viewParent = view.getParent(); viewParent instanceof View; viewParent = viewParent.getParent()) {
                            this.a.put((View)viewParent, Boolean.TRUE);
                        }
                    }
                }
            }
        }
        
        boolean b(View c, final KeyEvent keyEvent) {
            if (keyEvent.getAction() == 0) {
                this.g();
            }
            c = this.c(c, keyEvent);
            if (keyEvent.getAction() == 0) {
                final int keyCode = keyEvent.getKeyCode();
                if (c != null && !KeyEvent.isModifierKey(keyCode)) {
                    this.d().put(keyCode, (Object)new WeakReference(c));
                }
            }
            return c != null;
        }
        
        boolean f(final KeyEvent keyEvent) {
            final WeakReference<KeyEvent> c = this.c;
            if (c != null && c.get() == keyEvent) {
                return false;
            }
            this.c = new WeakReference<KeyEvent>(keyEvent);
            final WeakReference weakReference = null;
            final SparseArray<WeakReference<View>> d = this.d();
            WeakReference weakReference2 = weakReference;
            if (keyEvent.getAction() == 1) {
                final int indexOfKey = d.indexOfKey(keyEvent.getKeyCode());
                weakReference2 = weakReference;
                if (indexOfKey >= 0) {
                    weakReference2 = (WeakReference)d.valueAt(indexOfKey);
                    d.removeAt(indexOfKey);
                }
            }
            WeakReference weakReference3;
            if ((weakReference3 = weakReference2) == null) {
                weakReference3 = (WeakReference)d.get(keyEvent.getKeyCode());
            }
            if (weakReference3 != null) {
                final View view = (View)weakReference3.get();
                if (view != null && b0.S(view)) {
                    this.e(view, keyEvent);
                }
                return true;
            }
            return false;
        }
    }
}
