// 
// Decompiled by Procyon v0.6.0
// 

package androidx.databinding;

import androidx.lifecycle.b0;
import java.lang.ref.WeakReference;
import androidx.lifecycle.q;
import androidx.lifecycle.Lifecycle;
import java.lang.ref.Reference;
import android.util.SparseIntArray;
import android.view.ViewGroup;
import android.view.LayoutInflater;
import android.os.Looper;
import android.os.Build$VERSION;
import androidx.lifecycle.r;
import android.os.Handler;
import android.view.Choreographer$FrameCallback;
import android.view.Choreographer;
import android.view.View;
import android.view.View$OnAttachStateChangeListener;
import java.lang.ref.ReferenceQueue;

public abstract class ViewDataBinding extends a implements c1.a
{
    private static final boolean A;
    private static final d B;
    private static final d C;
    private static final d D;
    private static final d E;
    private static final c.a<j, ViewDataBinding, Void> F;
    private static final ReferenceQueue<ViewDataBinding> G;
    private static final View$OnAttachStateChangeListener H;
    static int y = 0;
    private static final int z = 8;
    private final Runnable a;
    private boolean b;
    private boolean c;
    private l[] d;
    private final View e;
    private c<j, ViewDataBinding, Void> f;
    private boolean g;
    private Choreographer h;
    private final Choreographer$FrameCallback i;
    private Handler j;
    protected final f p;
    private ViewDataBinding w;
    private r x;
    
    static {
        ViewDataBinding.y = Build$VERSION.SDK_INT;
        A = true;
        B = new d() {};
        C = new d() {};
        D = new d() {};
        E = new d() {};
        F = new c.a<j, ViewDataBinding, Void>() {
            @Override
            public /* bridge */ void a(final Object o, final Object o2, final int n, final Object o3) {
                this.b((j)o, (ViewDataBinding)o2, n, (Void)o3);
            }
            
            public void b(final j j, final ViewDataBinding viewDataBinding, final int n, final Void void1) {
                if (n != 1) {
                    if (n != 2) {
                        if (n == 3) {
                            j.a(viewDataBinding);
                        }
                    }
                    else {
                        j.b(viewDataBinding);
                    }
                }
                else if (!j.c(viewDataBinding)) {
                    ViewDataBinding.b(viewDataBinding, true);
                }
            }
        };
        G = new ReferenceQueue<ViewDataBinding>();
        H = (View$OnAttachStateChangeListener)new View$OnAttachStateChangeListener() {
            public void onViewAttachedToWindow(final View view) {
                ViewDataBinding.c(ViewDataBinding.l(view)).run();
                view.removeOnAttachStateChangeListener((View$OnAttachStateChangeListener)this);
            }
            
            public void onViewDetachedFromWindow(final View view) {
            }
        };
    }
    
    protected ViewDataBinding(final f p3, final View e, final int n) {
        this.a = new Runnable() {
            final ViewDataBinding a;
            
            @Override
            public void run() {
                synchronized (this) {
                    ViewDataBinding.d(this.a, false);
                    monitorexit(this);
                    ViewDataBinding.e();
                    if (!ViewDataBinding.f(this.a).isAttachedToWindow()) {
                        ViewDataBinding.f(this.a).removeOnAttachStateChangeListener(ViewDataBinding.g());
                        ViewDataBinding.f(this.a).addOnAttachStateChangeListener(ViewDataBinding.g());
                        return;
                    }
                    this.a.k();
                }
            }
        };
        this.b = false;
        this.c = false;
        this.p = p3;
        this.d = new l[n];
        this.e = e;
        if (Looper.myLooper() != null) {
            if (ViewDataBinding.A) {
                this.h = Choreographer.getInstance();
                this.i = (Choreographer$FrameCallback)new Choreographer$FrameCallback(this) {
                    final ViewDataBinding a;
                    
                    public void doFrame(final long n) {
                        ViewDataBinding.c(this.a).run();
                    }
                };
            }
            else {
                this.i = null;
                this.j = new Handler(Looper.myLooper());
            }
            return;
        }
        throw new IllegalStateException("DataBinding must be created in view's UI Thread");
    }
    
    protected ViewDataBinding(final Object o, final View view, final int n) {
        this(h(o), view, n);
    }
    
    static boolean b(final ViewDataBinding viewDataBinding, final boolean c) {
        return viewDataBinding.c = c;
    }
    
    static Runnable c(final ViewDataBinding viewDataBinding) {
        return viewDataBinding.a;
    }
    
    static boolean d(final ViewDataBinding viewDataBinding, final boolean b) {
        return viewDataBinding.b = b;
    }
    
    static void e() {
        s();
    }
    
    static View f(final ViewDataBinding viewDataBinding) {
        return viewDataBinding.e;
    }
    
    static View$OnAttachStateChangeListener g() {
        return ViewDataBinding.H;
    }
    
    private static f h(final Object o) {
        if (o == null) {
            return null;
        }
        if (o instanceof f) {
            return (f)o;
        }
        throw new IllegalArgumentException("The provided bindingComponent parameter must be an instance of DataBindingComponent. See  https://issuetracker.google.com/issues/116541301 for details of why this parameter is not defined as DataBindingComponent");
    }
    
    private void j() {
        if (this.g) {
            this.t();
            return;
        }
        if (!this.m()) {
            return;
        }
        this.g = true;
        this.c = false;
        final c<j, ViewDataBinding, Void> f = this.f;
        if (f != null) {
            f.e(this, 1, null);
            if (this.c) {
                this.f.e(this, 2, null);
            }
        }
        if (!this.c) {
            this.i();
            final c<j, ViewDataBinding, Void> f2 = this.f;
            if (f2 != null) {
                f2.e(this, 3, null);
            }
        }
        this.g = false;
    }
    
    static ViewDataBinding l(final View view) {
        if (view != null) {
            return (ViewDataBinding)view.getTag(b0.a.a);
        }
        return null;
    }
    
    protected static <T extends ViewDataBinding> T n(final LayoutInflater layoutInflater, final int n, final ViewGroup viewGroup, final boolean b, final Object o) {
        return g.g(layoutInflater, n, viewGroup, b, h(o));
    }
    
    private static boolean o(final String s, final int n) {
        final int length = s.length();
        int i = n;
        if (length == n) {
            return false;
        }
        while (i < length) {
            if (!Character.isDigit(s.charAt(i))) {
                return false;
            }
            ++i;
        }
        return true;
    }
    
    private static void p(final f f, final View view, final Object[] array, final i i, final SparseIntArray sparseIntArray, final boolean b) {
        if (l(view) != null) {
            return;
        }
        final Object tag = view.getTag();
        String s;
        if (tag instanceof String) {
            s = (String)tag;
        }
        else {
            s = null;
        }
        final int n = 0;
        final boolean b2 = true;
        int n2 = 0;
        Label_0172: {
            if (b && s != null && s.startsWith("layout")) {
                int lastIndex = s.lastIndexOf(95);
                if (lastIndex > 0) {
                    ++lastIndex;
                    if (o(s, lastIndex)) {
                        final int r = r(s, lastIndex);
                        n2 = (b2 ? 1 : 0);
                        if (array[r] == null) {
                            array[r] = view;
                            n2 = (b2 ? 1 : 0);
                        }
                        break Label_0172;
                    }
                }
            }
            else if (s != null && s.startsWith("binding_")) {
                final int r2 = r(s, ViewDataBinding.z);
                n2 = (b2 ? 1 : 0);
                if (array[r2] == null) {
                    array[r2] = view;
                    n2 = (b2 ? 1 : 0);
                }
                break Label_0172;
            }
            n2 = 0;
        }
        if (n2 == 0) {
            final int id = view.getId();
            if (id > 0 && sparseIntArray != null) {
                final int value = sparseIntArray.get(id, -1);
                if (value >= 0 && array[value] == null) {
                    array[value] = view;
                }
            }
        }
        if (view instanceof ViewGroup) {
            final ViewGroup viewGroup = (ViewGroup)view;
            for (int childCount = viewGroup.getChildCount(), j = n; j < childCount; ++j) {
                p(f, viewGroup.getChildAt(j), array, i, sparseIntArray, false);
            }
        }
    }
    
    protected static Object[] q(final f f, final View view, final int n, final i i, final SparseIntArray sparseIntArray) {
        final Object[] array = new Object[n];
        p(f, view, array, i, sparseIntArray, true);
        return array;
    }
    
    private static int r(final String s, int i) {
        final int length = s.length();
        int n = 0;
        while (i < length) {
            n = n * 10 + (s.charAt(i) - '0');
            ++i;
        }
        return n;
    }
    
    private static void s() {
        while (true) {
            final Reference<? extends ViewDataBinding> poll = ViewDataBinding.G.poll();
            if (poll == null) {
                break;
            }
            if (!(poll instanceof l)) {
                continue;
            }
            ((l)poll).a();
        }
    }
    
    @Override
    public View getRoot() {
        return this.e;
    }
    
    protected abstract void i();
    
    public void k() {
        final ViewDataBinding w = this.w;
        if (w == null) {
            this.j();
        }
        else {
            w.k();
        }
    }
    
    public abstract boolean m();
    
    protected void t() {
        final ViewDataBinding w = this.w;
        if (w != null) {
            w.t();
            return;
        }
        final r x = this.x;
        if (x != null && !x.getLifecycle().b().isAtLeast(Lifecycle.State.STARTED)) {
            return;
        }
        synchronized (this) {
            if (this.b) {
                return;
            }
            this.b = true;
            monitorexit(this);
            if (ViewDataBinding.A) {
                this.h.postFrameCallback(this.i);
            }
            else {
                this.j.post(this.a);
            }
        }
    }
    
    protected void u(final View view) {
        view.setTag(b0.a.a, (Object)this);
    }
    
    static class OnStartListener implements q
    {
        final WeakReference<ViewDataBinding> a;
        
        @b0(Lifecycle.Event.ON_START)
        public void onStart() {
            final ViewDataBinding viewDataBinding = this.a.get();
            if (viewDataBinding != null) {
                viewDataBinding.k();
            }
        }
    }
    
    protected static class i
    {
    }
}
