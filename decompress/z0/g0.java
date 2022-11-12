// 
// Decompiled by Procyon v0.6.0
// 

package z0;

import android.animation.AnimatorListenerAdapter;
import android.animation.Animator$AnimatorListener;
import android.animation.Animator;
import android.view.View;
import android.view.ViewGroup;

public abstract class g0 extends m
{
    private static final String[] U;
    private int T;
    
    static {
        U = new String[] { "android:visibility:visibility", "android:visibility:parent" };
    }
    
    public g0() {
        this.T = 3;
    }
    
    private void i0(final s s) {
        s.a.put("android:visibility:visibility", s.b.getVisibility());
        s.a.put("android:visibility:parent", s.b.getParent());
        final int[] array = new int[2];
        s.b.getLocationOnScreen(array);
        s.a.put("android:visibility:screenLocation", array);
    }
    
    private c j0(final s s, final s s2) {
        final c c = new c();
        c.a = false;
        c.b = false;
        if (s != null && s.a.containsKey("android:visibility:visibility")) {
            c.c = s.a.get("android:visibility:visibility");
            c.e = s.a.get("android:visibility:parent");
        }
        else {
            c.c = -1;
            c.e = null;
        }
        if (s2 != null && s2.a.containsKey("android:visibility:visibility")) {
            c.d = s2.a.get("android:visibility:visibility");
            c.f = s2.a.get("android:visibility:parent");
        }
        else {
            c.d = -1;
            c.f = null;
        }
        if (s != null && s2 != null) {
            final int c2 = c.c;
            final int d = c.d;
            if (c2 == d && c.e == c.f) {
                return c;
            }
            if (c2 != d) {
                if (c2 == 0) {
                    c.b = false;
                    c.a = true;
                }
                else if (d == 0) {
                    c.b = true;
                    c.a = true;
                }
            }
            else if (c.f == null) {
                c.b = false;
                c.a = true;
            }
            else if (c.e == null) {
                c.b = true;
                c.a = true;
            }
        }
        else if (s == null && c.d == 0) {
            c.b = true;
            c.a = true;
        }
        else if (s2 == null && c.c == 0) {
            c.b = false;
            c.a = true;
        }
        return c;
    }
    
    @Override
    public String[] G() {
        return g0.U;
    }
    
    @Override
    public boolean I(final s s, final s s2) {
        final boolean b = false;
        if (s == null && s2 == null) {
            return false;
        }
        if (s != null && s2 != null && s2.a.containsKey("android:visibility:visibility") != s.a.containsKey("android:visibility:visibility")) {
            return false;
        }
        final c j0 = this.j0(s, s2);
        boolean b2 = b;
        if (j0.a) {
            if (j0.c != 0) {
                b2 = b;
                if (j0.d != 0) {
                    return b2;
                }
            }
            b2 = true;
        }
        return b2;
    }
    
    @Override
    public void g(final s s) {
        this.i0(s);
    }
    
    @Override
    public void j(final s s) {
        this.i0(s);
    }
    
    public Animator k0(final ViewGroup viewGroup, final View view, final s s, final s s2) {
        return null;
    }
    
    public Animator l0(final ViewGroup viewGroup, final s s, final int n, final s s2, final int n2) {
        if ((this.T & 0x1) == 0x1 && s2 != null) {
            if (s == null) {
                final View view = (View)s2.b.getParent();
                if (this.j0(this.w(view, false), this.H(view, false)).a) {
                    return null;
                }
            }
            return this.k0(viewGroup, s2.b, s, s2);
        }
        return null;
    }
    
    public Animator m0(final ViewGroup viewGroup, final View view, final s s, final s s2) {
        return null;
    }
    
    public Animator n0(final ViewGroup viewGroup, final s s, int n, final s s2, int n2) {
        if ((this.T & 0x2) != 0x2) {
            return null;
        }
        if (s == null) {
            return null;
        }
        final View b = s.b;
        View b2;
        if (s2 != null) {
            b2 = s2.b;
        }
        else {
            b2 = null;
        }
        final int a = z0.j.a;
        View view = (View)b.getTag(a);
        View view2 = null;
        Label_0291: {
            if (view != null) {
                view2 = null;
                n = 1;
            }
            else {
                View view3 = null;
                Label_0137: {
                    Label_0129: {
                        if (b2 != null && b2.getParent() != null) {
                            if (n2 != 4) {
                                if (b != b2) {
                                    break Label_0129;
                                }
                            }
                            view3 = b2;
                            n = 0;
                            b2 = null;
                            break Label_0137;
                        }
                        if (b2 != null) {
                            view3 = null;
                            n = 0;
                            break Label_0137;
                        }
                    }
                    b2 = null;
                    view3 = null;
                    n = 1;
                }
                View a2 = b2;
                Label_0281: {
                    if (n != 0) {
                        if (b.getParent() != null) {
                            a2 = b2;
                            if (!(b.getParent() instanceof View)) {
                                break Label_0281;
                            }
                            final View view4 = (View)b.getParent();
                            if (!this.j0(this.H(view4, true), this.w(view4, true)).a) {
                                a2 = r.a(viewGroup, b, view4);
                                break Label_0281;
                            }
                            n = view4.getId();
                            a2 = b2;
                            if (view4.getParent() != null) {
                                break Label_0281;
                            }
                            a2 = b2;
                            if (n == -1) {
                                break Label_0281;
                            }
                            a2 = b2;
                            if (viewGroup.findViewById(n) == null) {
                                break Label_0281;
                            }
                            a2 = b2;
                            if (!super.G) {
                                break Label_0281;
                            }
                        }
                        view2 = view3;
                        n = 0;
                        view = b;
                        break Label_0291;
                    }
                }
                n = 0;
                view2 = view3;
                view = a2;
            }
        }
        if (view != null) {
            if (n == 0) {
                final int[] array = s.a.get("android:visibility:screenLocation");
                n2 = array[0];
                final int n3 = array[1];
                final int[] array2 = new int[2];
                viewGroup.getLocationOnScreen(array2);
                view.offsetLeftAndRight(n2 - array2[0] - view.getLeft());
                view.offsetTopAndBottom(n3 - array2[1] - view.getTop());
                z0.w.a(viewGroup).c(view);
            }
            final Animator m0 = this.m0(viewGroup, view, s, s2);
            if (n == 0) {
                if (m0 == null) {
                    z0.w.a(viewGroup).d(view);
                }
                else {
                    b.setTag(a, (Object)view);
                    this.b((f)new n(this, viewGroup, view, b) {
                        final ViewGroup a;
                        final View b;
                        final View c;
                        final g0 d;
                        
                        @Override
                        public void c(final m m) {
                            this.c.setTag(z0.j.a, (Object)null);
                            z0.w.a(this.a).d(this.b);
                            m.T((f)this);
                        }
                        
                        @Override
                        public void d(final m m) {
                            z0.w.a(this.a).d(this.b);
                        }
                        
                        @Override
                        public void e(final m m) {
                            if (this.b.getParent() == null) {
                                z0.w.a(this.a).c(this.b);
                            }
                            else {
                                this.d.cancel();
                            }
                        }
                    });
                }
            }
            return m0;
        }
        if (view2 != null) {
            n = view2.getVisibility();
            z0.z.h(view2, 0);
            final Animator m2 = this.m0(viewGroup, view2, s, s2);
            if (m2 != null) {
                final b b3 = new b(view2, n2, true);
                m2.addListener((Animator$AnimatorListener)b3);
                z0.a.a(m2, b3);
                this.b((f)b3);
            }
            else {
                z0.z.h(view2, n);
            }
            return m2;
        }
        return null;
    }
    
    @Override
    public Animator o(final ViewGroup viewGroup, final s s, final s s2) {
        final c j0 = this.j0(s, s2);
        if (!j0.a || (j0.e == null && j0.f == null)) {
            return null;
        }
        if (j0.b) {
            return this.l0(viewGroup, s, j0.c, s2, j0.d);
        }
        return this.n0(viewGroup, s, j0.c, s2, j0.d);
    }
    
    public void o0(final int t) {
        if ((t & 0xFFFFFFFC) == 0x0) {
            this.T = t;
            return;
        }
        throw new IllegalArgumentException("Only MODE_IN and MODE_OUT flags are allowed");
    }
    
    private static class b extends AnimatorListenerAdapter implements f
    {
        private final View a;
        private final int b;
        private final ViewGroup c;
        private final boolean d;
        private boolean e;
        boolean f;
        
        b(final View a, final int b, final boolean d) {
            this.f = false;
            this.a = a;
            this.b = b;
            this.c = (ViewGroup)a.getParent();
            this.d = d;
            this.g(true);
        }
        
        private void f() {
            if (!this.f) {
                z0.z.h(this.a, this.b);
                final ViewGroup c = this.c;
                if (c != null) {
                    c.invalidate();
                }
            }
            this.g(false);
        }
        
        private void g(final boolean e) {
            if (this.d && this.e != e) {
                final ViewGroup c = this.c;
                if (c != null) {
                    z0.w.c(c, this.e = e);
                }
            }
        }
        
        public void a(final m m) {
        }
        
        public void b(final m m) {
        }
        
        public void c(final m m) {
            this.f();
            m.T((f)this);
        }
        
        public void d(final m m) {
            this.g(false);
        }
        
        public void e(final m m) {
            this.g(true);
        }
        
        public void onAnimationCancel(final Animator animator) {
            this.f = true;
        }
        
        public void onAnimationEnd(final Animator animator) {
            this.f();
        }
        
        public void onAnimationPause(final Animator animator) {
            if (!this.f) {
                z0.z.h(this.a, this.b);
            }
        }
        
        public void onAnimationRepeat(final Animator animator) {
        }
        
        public void onAnimationResume(final Animator animator) {
            if (!this.f) {
                z0.z.h(this.a, 0);
            }
        }
        
        public void onAnimationStart(final Animator animator) {
        }
    }
    
    private static class c
    {
        boolean a;
        boolean b;
        int c;
        int d;
        ViewGroup e;
        ViewGroup f;
        
        c() {
        }
    }
}
