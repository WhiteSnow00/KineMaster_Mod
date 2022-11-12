// 
// Decompiled by Procyon v0.6.0
// 

package androidx.appcompat.widget;

import android.view.ViewGroup$MarginLayoutParams;
import d.f;
import android.view.Window$Callback;
import androidx.core.graphics.e;
import android.content.res.Configuration;
import androidx.core.view.b0;
import android.view.WindowInsets;
import android.graphics.Canvas;
import androidx.appcompat.view.menu.m;
import android.view.Menu;
import android.view.ViewGroup$LayoutParams;
import android.content.res.TypedArray;
import android.view.View;
import android.animation.Animator$AnimatorListener;
import android.animation.Animator;
import android.util.AttributeSet;
import android.content.Context;
import d.a;
import android.graphics.drawable.Drawable;
import androidx.core.view.u;
import android.animation.AnimatorListenerAdapter;
import android.view.ViewPropertyAnimator;
import android.widget.OverScroller;
import androidx.core.view.n0;
import android.graphics.Rect;
import androidx.core.view.t;
import androidx.core.view.s;
import android.view.ViewGroup;

public class ActionBarOverlayLayout extends ViewGroup implements y, s, t
{
    static final int[] Q;
    private final Rect A;
    private final Rect B;
    private final Rect C;
    private final Rect D;
    private final Rect E;
    private n0 F;
    private n0 G;
    private n0 H;
    private n0 I;
    private d J;
    private OverScroller K;
    ViewPropertyAnimator L;
    final AnimatorListenerAdapter M;
    private final Runnable N;
    private final Runnable O;
    private final u P;
    private int a;
    private int b;
    private ContentFrameLayout c;
    ActionBarContainer d;
    private z e;
    private Drawable f;
    private boolean g;
    private boolean h;
    private boolean i;
    private boolean j;
    boolean p;
    private int w;
    private int x;
    private final Rect y;
    private final Rect z;
    
    static {
        Q = new int[] { a.b, 16842841 };
    }
    
    public ActionBarOverlayLayout(final Context context, final AttributeSet set) {
        super(context, set);
        this.b = 0;
        this.y = new Rect();
        this.z = new Rect();
        this.A = new Rect();
        this.B = new Rect();
        this.C = new Rect();
        this.D = new Rect();
        this.E = new Rect();
        final n0 b = n0.b;
        this.F = b;
        this.G = b;
        this.H = b;
        this.I = b;
        this.M = new AnimatorListenerAdapter() {
            final ActionBarOverlayLayout a;
            
            public void onAnimationCancel(final Animator animator) {
                final ActionBarOverlayLayout a = this.a;
                a.L = null;
                a.p = false;
            }
            
            public void onAnimationEnd(final Animator animator) {
                final ActionBarOverlayLayout a = this.a;
                a.L = null;
                a.p = false;
            }
        };
        this.N = new Runnable() {
            final ActionBarOverlayLayout a;
            
            @Override
            public void run() {
                this.a.u();
                final ActionBarOverlayLayout a = this.a;
                a.L = a.d.animate().translationY(0.0f).setListener((Animator$AnimatorListener)this.a.M);
            }
        };
        this.O = new Runnable() {
            final ActionBarOverlayLayout a;
            
            @Override
            public void run() {
                this.a.u();
                final ActionBarOverlayLayout a = this.a;
                a.L = a.d.animate().translationY((float)(-this.a.d.getHeight())).setListener((Animator$AnimatorListener)this.a.M);
            }
        };
        this.v(context);
        this.P = new u(this);
    }
    
    private void A() {
        this.u();
        this.N.run();
    }
    
    private boolean B(final float n) {
        this.K.fling(0, 0, 0, (int)n, 0, 0, Integer.MIN_VALUE, Integer.MAX_VALUE);
        return this.K.getFinalY() > this.d.getHeight();
    }
    
    private void p() {
        this.u();
        this.O.run();
    }
    
    private boolean q(final View view, final Rect rect, final boolean b, final boolean b2, final boolean b3, final boolean b4) {
        final e e = (e)view.getLayoutParams();
        final boolean b5 = true;
        boolean b6 = false;
        Label_0049: {
            if (b) {
                final int leftMargin = e.leftMargin;
                final int left = rect.left;
                if (leftMargin != left) {
                    e.leftMargin = left;
                    b6 = true;
                    break Label_0049;
                }
            }
            b6 = false;
        }
        boolean b7 = b6;
        if (b2) {
            final int topMargin = e.topMargin;
            final int top = rect.top;
            b7 = b6;
            if (topMargin != top) {
                e.topMargin = top;
                b7 = true;
            }
        }
        boolean b8 = b7;
        if (b4) {
            final int rightMargin = e.rightMargin;
            final int right = rect.right;
            b8 = b7;
            if (rightMargin != right) {
                e.rightMargin = right;
                b8 = true;
            }
        }
        if (b3) {
            final int bottomMargin = e.bottomMargin;
            final int bottom = rect.bottom;
            if (bottomMargin != bottom) {
                e.bottomMargin = bottom;
                b8 = b5;
            }
        }
        return b8;
    }
    
    private z t(final View view) {
        if (view instanceof z) {
            return (z)view;
        }
        if (view instanceof Toolbar) {
            return ((Toolbar)view).getWrapper();
        }
        final StringBuilder sb = new StringBuilder();
        sb.append("Can't make a decor toolbar out of ");
        sb.append(view.getClass().getSimpleName());
        throw new IllegalStateException(sb.toString());
    }
    
    private void v(final Context context) {
        final TypedArray obtainStyledAttributes = this.getContext().getTheme().obtainStyledAttributes(ActionBarOverlayLayout.Q);
        final boolean b = false;
        this.a = obtainStyledAttributes.getDimensionPixelSize(0, 0);
        final Drawable drawable = obtainStyledAttributes.getDrawable(1);
        this.f = drawable;
        this.setWillNotDraw(drawable == null);
        obtainStyledAttributes.recycle();
        boolean g = b;
        if (context.getApplicationInfo().targetSdkVersion < 19) {
            g = true;
        }
        this.g = g;
        this.K = new OverScroller(context);
    }
    
    private void x() {
        this.u();
        this.postDelayed(this.O, 600L);
    }
    
    private void y() {
        this.u();
        this.postDelayed(this.N, 600L);
    }
    
    public boolean a() {
        this.z();
        return this.e.a();
    }
    
    public boolean b() {
        this.z();
        return this.e.b();
    }
    
    public boolean c() {
        this.z();
        return this.e.c();
    }
    
    protected boolean checkLayoutParams(final ViewGroup$LayoutParams viewGroup$LayoutParams) {
        return viewGroup$LayoutParams instanceof e;
    }
    
    public void d(final Menu menu, final m.a a) {
        this.z();
        this.e.d(menu, a);
    }
    
    public void draw(final Canvas canvas) {
        super.draw(canvas);
        if (this.f != null && !this.g) {
            int n;
            if (this.d.getVisibility() == 0) {
                n = (int)(this.d.getBottom() + this.d.getTranslationY() + 0.5f);
            }
            else {
                n = 0;
            }
            this.f.setBounds(0, n, this.getWidth(), this.f.getIntrinsicHeight() + n);
            this.f.draw(canvas);
        }
    }
    
    public boolean e() {
        this.z();
        return this.e.e();
    }
    
    public void f() {
        this.z();
        this.e.f();
    }
    
    protected boolean fitSystemWindows(final Rect rect) {
        return super.fitSystemWindows(rect);
    }
    
    public boolean g() {
        this.z();
        return this.e.g();
    }
    
    protected /* bridge */ ViewGroup$LayoutParams generateDefaultLayoutParams() {
        return (ViewGroup$LayoutParams)this.r();
    }
    
    public /* bridge */ ViewGroup$LayoutParams generateLayoutParams(final AttributeSet set) {
        return (ViewGroup$LayoutParams)this.s(set);
    }
    
    protected ViewGroup$LayoutParams generateLayoutParams(final ViewGroup$LayoutParams viewGroup$LayoutParams) {
        return (ViewGroup$LayoutParams)new e(viewGroup$LayoutParams);
    }
    
    public int getActionBarHideOffset() {
        final ActionBarContainer d = this.d;
        int n;
        if (d != null) {
            n = -(int)d.getTranslationY();
        }
        else {
            n = 0;
        }
        return n;
    }
    
    public int getNestedScrollAxes() {
        return this.P.a();
    }
    
    public CharSequence getTitle() {
        this.z();
        return this.e.getTitle();
    }
    
    public void h(final int n) {
        this.z();
        if (n != 2) {
            if (n != 5) {
                if (n == 109) {
                    this.setOverlayMode(true);
                }
            }
            else {
                this.e.w();
            }
        }
        else {
            this.e.o();
        }
    }
    
    public void i(final View view, final View view2, final int n, final int n2) {
        if (n2 == 0) {
            this.onNestedScrollAccepted(view, view2, n);
        }
    }
    
    public void j(final View view, final int n) {
        if (n == 0) {
            this.onStopNestedScroll(view);
        }
    }
    
    public void k(final View view, final int n, final int n2, final int[] array, final int n3) {
        if (n3 == 0) {
            this.onNestedPreScroll(view, n, n2, array);
        }
    }
    
    public void l() {
        this.z();
        this.e.q();
    }
    
    public void m(final View view, final int n, final int n2, final int n3, final int n4, final int n5, final int[] array) {
        this.n(view, n, n2, n3, n4, n5);
    }
    
    public void n(final View view, final int n, final int n2, final int n3, final int n4, final int n5) {
        if (n5 == 0) {
            this.onNestedScroll(view, n, n2, n3, n4);
        }
    }
    
    public boolean o(final View view, final View view2, final int n, final int n2) {
        return n2 == 0 && this.onStartNestedScroll(view, view2, n);
    }
    
    public WindowInsets onApplyWindowInsets(final WindowInsets windowInsets) {
        this.z();
        final n0 w = n0.w(windowInsets, (View)this);
        int q = this.q((View)this.d, new Rect(w.j(), w.l(), w.k(), w.i()), true, true, false, true) ? 1 : 0;
        b0.f((View)this, w, this.y);
        final Rect y = this.y;
        final n0 m = w.m(y.left, y.top, y.right, y.bottom);
        this.F = m;
        final boolean equals = this.G.equals(m);
        final int n = 1;
        if (!equals) {
            this.G = this.F;
            q = 1;
        }
        if (!this.z.equals((Object)this.y)) {
            this.z.set(this.y);
            q = n;
        }
        if (q != 0) {
            this.requestLayout();
        }
        return w.a().c().b().u();
    }
    
    protected void onConfigurationChanged(final Configuration configuration) {
        super.onConfigurationChanged(configuration);
        this.v(this.getContext());
        b0.m0((View)this);
    }
    
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.u();
    }
    
    protected void onLayout(final boolean b, int i, int paddingTop, int childCount, int paddingLeft) {
        childCount = this.getChildCount();
        paddingLeft = this.getPaddingLeft();
        paddingTop = this.getPaddingTop();
        View child;
        e e;
        int measuredWidth;
        int measuredHeight;
        int n;
        int n2;
        for (i = 0; i < childCount; ++i) {
            child = this.getChildAt(i);
            if (child.getVisibility() != 8) {
                e = (e)child.getLayoutParams();
                measuredWidth = child.getMeasuredWidth();
                measuredHeight = child.getMeasuredHeight();
                n = e.leftMargin + paddingLeft;
                n2 = e.topMargin + paddingTop;
                child.layout(n, n2, measuredWidth + n, measuredHeight + n2);
            }
        }
    }
    
    protected void onMeasure(final int n, final int n2) {
        this.z();
        this.measureChildWithMargins((View)this.d, n, 0, n2, 0);
        final e e = (e)this.d.getLayoutParams();
        final int max = Math.max(0, this.d.getMeasuredWidth() + e.leftMargin + e.rightMargin);
        final int max2 = Math.max(0, this.d.getMeasuredHeight() + e.topMargin + e.bottomMargin);
        final int combineMeasuredStates = View.combineMeasuredStates(0, this.d.getMeasuredState());
        final boolean b = (b0.L((View)this) & 0x100) != 0x0;
        int n4;
        if (b) {
            final int n3 = n4 = this.a;
            if (this.i) {
                n4 = n3;
                if (this.d.getTabContainer() != null) {
                    n4 = n3 + this.a;
                }
            }
        }
        else if (this.d.getVisibility() != 8) {
            n4 = this.d.getMeasuredHeight();
        }
        else {
            n4 = 0;
        }
        this.A.set(this.y);
        final n0 f = this.F;
        this.H = f;
        if (!this.h && !b) {
            final Rect a = this.A;
            a.top += n4;
            a.bottom += 0;
            this.H = f.m(0, n4, 0, 0);
        }
        else {
            this.H = new n0.b(this.H).c(androidx.core.graphics.e.b(f.j(), this.H.l() + n4, this.H.k(), this.H.i() + 0)).a();
        }
        this.q((View)this.c, this.A, true, true, true, true);
        if (!this.I.equals(this.H)) {
            final n0 h = this.H;
            this.I = h;
            b0.g((View)this.c, h);
        }
        this.measureChildWithMargins((View)this.c, n, 0, n2, 0);
        final e e2 = (e)this.c.getLayoutParams();
        final int max3 = Math.max(max, this.c.getMeasuredWidth() + e2.leftMargin + e2.rightMargin);
        final int max4 = Math.max(max2, this.c.getMeasuredHeight() + e2.topMargin + e2.bottomMargin);
        final int combineMeasuredStates2 = View.combineMeasuredStates(combineMeasuredStates, this.c.getMeasuredState());
        this.setMeasuredDimension(View.resolveSizeAndState(Math.max(max3 + (this.getPaddingLeft() + this.getPaddingRight()), this.getSuggestedMinimumWidth()), n, combineMeasuredStates2), View.resolveSizeAndState(Math.max(max4 + (this.getPaddingTop() + this.getPaddingBottom()), this.getSuggestedMinimumHeight()), n2, combineMeasuredStates2 << 16));
    }
    
    public boolean onNestedFling(final View view, final float n, final float n2, final boolean b) {
        if (this.j && b) {
            if (this.B(n2)) {
                this.p();
            }
            else {
                this.A();
            }
            return this.p = true;
        }
        return false;
    }
    
    public boolean onNestedPreFling(final View view, final float n, final float n2) {
        return false;
    }
    
    public void onNestedPreScroll(final View view, final int n, final int n2, final int[] array) {
    }
    
    public void onNestedScroll(final View view, int w, final int n, final int n2, final int n3) {
        w = this.w + n;
        this.setActionBarHideOffset(this.w = w);
    }
    
    public void onNestedScrollAccepted(final View view, final View view2, final int n) {
        this.P.b(view, view2, n);
        this.w = this.getActionBarHideOffset();
        this.u();
        final d j = this.J;
        if (j != null) {
            j.e();
        }
    }
    
    public boolean onStartNestedScroll(final View view, final View view2, final int n) {
        return (n & 0x2) != 0x0 && this.d.getVisibility() == 0 && this.j;
    }
    
    public void onStopNestedScroll(final View view) {
        if (this.j && !this.p) {
            if (this.w <= this.d.getHeight()) {
                this.y();
            }
            else {
                this.x();
            }
        }
        final d j = this.J;
        if (j != null) {
            j.b();
        }
    }
    
    @Deprecated
    public void onWindowSystemUiVisibilityChanged(final int x) {
        super.onWindowSystemUiVisibilityChanged(x);
        this.z();
        final int x2 = this.x;
        this.x = x;
        boolean b = false;
        final boolean b2 = (x & 0x4) == 0x0;
        if ((x & 0x100) != 0x0) {
            b = true;
        }
        final d j = this.J;
        if (j != null) {
            j.c(b ^ true);
            if (!b2 && b) {
                this.J.d();
            }
            else {
                this.J.a();
            }
        }
        if (((x2 ^ x) & 0x100) != 0x0 && this.J != null) {
            b0.m0((View)this);
        }
    }
    
    protected void onWindowVisibilityChanged(final int b) {
        super.onWindowVisibilityChanged(b);
        this.b = b;
        final d j = this.J;
        if (j != null) {
            j.onWindowVisibilityChanged(b);
        }
    }
    
    protected e r() {
        return new e(-1, -1);
    }
    
    public e s(final AttributeSet set) {
        return new e(this.getContext(), set);
    }
    
    public void setActionBarHideOffset(int max) {
        this.u();
        max = Math.max(0, Math.min(max, this.d.getHeight()));
        this.d.setTranslationY((float)(-max));
    }
    
    public void setActionBarVisibilityCallback(final d j) {
        this.J = j;
        if (this.getWindowToken() != null) {
            this.J.onWindowVisibilityChanged(this.b);
            final int x = this.x;
            if (x != 0) {
                this.onWindowSystemUiVisibilityChanged(x);
                b0.m0((View)this);
            }
        }
    }
    
    public void setHasNonEmbeddedTabs(final boolean i) {
        this.i = i;
    }
    
    public void setHideOnContentScrollEnabled(final boolean j) {
        if (j != this.j && !(this.j = j)) {
            this.u();
            this.setActionBarHideOffset(0);
        }
    }
    
    public void setIcon(final int icon) {
        this.z();
        this.e.setIcon(icon);
    }
    
    public void setIcon(final Drawable icon) {
        this.z();
        this.e.setIcon(icon);
    }
    
    public void setLogo(final int n) {
        this.z();
        this.e.s(n);
    }
    
    public void setOverlayMode(final boolean h) {
        this.h = h;
        this.g = (h && this.getContext().getApplicationInfo().targetSdkVersion < 19);
    }
    
    public void setShowingForActionMode(final boolean b) {
    }
    
    public void setUiOptions(final int n) {
    }
    
    public void setWindowCallback(final Window$Callback windowCallback) {
        this.z();
        this.e.setWindowCallback(windowCallback);
    }
    
    public void setWindowTitle(final CharSequence windowTitle) {
        this.z();
        this.e.setWindowTitle(windowTitle);
    }
    
    public boolean shouldDelayChildPressedState() {
        return false;
    }
    
    void u() {
        this.removeCallbacks(this.N);
        this.removeCallbacks(this.O);
        final ViewPropertyAnimator l = this.L;
        if (l != null) {
            l.cancel();
        }
    }
    
    public boolean w() {
        return this.h;
    }
    
    void z() {
        if (this.c == null) {
            this.c = (ContentFrameLayout)this.findViewById(d.f.b);
            this.d = (ActionBarContainer)this.findViewById(d.f.c);
            this.e = this.t(this.findViewById(d.f.a));
        }
    }
    
    public interface d
    {
        void a();
        
        void b();
        
        void c(final boolean p0);
        
        void d();
        
        void e();
        
        void onWindowVisibilityChanged(final int p0);
    }
    
    public static class e extends ViewGroup$MarginLayoutParams
    {
        public e(final int n, final int n2) {
            super(n, n2);
        }
        
        public e(final Context context, final AttributeSet set) {
            super(context, set);
        }
        
        public e(final ViewGroup$LayoutParams viewGroup$LayoutParams) {
            super(viewGroup$LayoutParams);
        }
    }
}
