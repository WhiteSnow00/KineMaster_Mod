// 
// Decompiled by Procyon v0.6.0
// 

package androidx.drawerlayout.widget;

import android.content.res.TypedArray;
import android.content.Context;
import android.os.Parcel;
import android.os.Parcelable$ClassLoaderCreator;
import android.os.Parcelable$Creator;
import androidx.customview.view.AbsSavedState;
import android.graphics.drawable.ColorDrawable;
import android.os.Parcelable;
import android.view.View$MeasureSpec;
import androidx.core.graphics.e;
import androidx.core.view.n0;
import android.view.KeyEvent;
import android.view.WindowInsets;
import android.view.ViewGroup$MarginLayoutParams;
import android.util.AttributeSet;
import android.graphics.Canvas;
import android.view.ViewGroup$LayoutParams;
import androidx.core.view.f;
import android.view.MotionEvent;
import androidx.core.view.accessibility.d;
import androidx.core.view.b0;
import androidx.core.graphics.drawable.a;
import android.os.Build$VERSION;
import androidx.customview.widget.c;
import android.graphics.Paint;
import androidx.core.view.accessibility.g;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.view.View;
import java.util.ArrayList;
import android.graphics.drawable.Drawable;
import java.util.List;
import android.view.ViewGroup;

public class DrawerLayout extends ViewGroup
{
    private static final int[] R;
    static final int[] S;
    static final boolean T;
    private static final boolean U;
    private static boolean V;
    private a A;
    private List<a> B;
    private float C;
    private float D;
    private Drawable E;
    private Drawable F;
    private Drawable G;
    private Object H;
    private boolean I;
    private Drawable J;
    private Drawable K;
    private Drawable L;
    private Drawable M;
    private final ArrayList<View> N;
    private Rect O;
    private Matrix P;
    private final g Q;
    private float a;
    private int b;
    private int c;
    private float d;
    private Paint e;
    private final c f;
    private final c g;
    private int h;
    private boolean i;
    private boolean j;
    private int p;
    private int w;
    private int x;
    private int y;
    private boolean z;
    
    static {
        boolean v = true;
        R = new int[] { 16843828 };
        S = new int[] { 16842931 };
        final int sdk_INT = Build$VERSION.SDK_INT;
        T = true;
        U = true;
        if (sdk_INT < 29) {
            v = false;
        }
        DrawerLayout.V = v;
    }
    
    private boolean A(final float n, final float n2, final View view) {
        if (this.O == null) {
            this.O = new Rect();
        }
        view.getHitRect(this.O);
        return this.O.contains((int)n, (int)n2);
    }
    
    private void B(final Drawable drawable, final int n) {
        if (drawable != null && androidx.core.graphics.drawable.a.c(drawable)) {
            androidx.core.graphics.drawable.a.g(drawable, n);
        }
    }
    
    private Drawable G() {
        final int b = b0.B((View)this);
        if (b == 0) {
            final Drawable j = this.J;
            if (j != null) {
                this.B(j, b);
                return this.J;
            }
        }
        else {
            final Drawable k = this.K;
            if (k != null) {
                this.B(k, b);
                return this.K;
            }
        }
        return this.L;
    }
    
    private Drawable H() {
        final int b = b0.B((View)this);
        if (b == 0) {
            final Drawable k = this.K;
            if (k != null) {
                this.B(k, b);
                return this.K;
            }
        }
        else {
            final Drawable j = this.J;
            if (j != null) {
                this.B(j, b);
                return this.J;
            }
        }
        return this.M;
    }
    
    private void I() {
        if (DrawerLayout.U) {
            return;
        }
        this.F = this.G();
        this.G = this.H();
    }
    
    private void L(final View view) {
        final d.a y = androidx.core.view.accessibility.d.a.y;
        b0.j0(view, y.b());
        if (this.x(view) && this.o(view) != 2) {
            b0.l0(view, y, null, this.Q);
        }
    }
    
    private void M(final View view, final boolean b) {
        for (int childCount = this.getChildCount(), i = 0; i < childCount; ++i) {
            final View child = this.getChildAt(i);
            if ((!b && !this.y(child)) || (b && child == view)) {
                b0.A0(child, 1);
            }
            else {
                b0.A0(child, 4);
            }
        }
    }
    
    private boolean j(MotionEvent r, final View view) {
        boolean b;
        if (!view.getMatrix().isIdentity()) {
            r = this.r(r, view);
            b = view.dispatchGenericMotionEvent(r);
            r.recycle();
        }
        else {
            final float n = (float)(this.getScrollX() - view.getLeft());
            final float n2 = (float)(this.getScrollY() - view.getTop());
            r.offsetLocation(n, n2);
            b = view.dispatchGenericMotionEvent(r);
            r.offsetLocation(-n, -n2);
        }
        return b;
    }
    
    private MotionEvent r(MotionEvent obtain, final View view) {
        final float n = (float)(this.getScrollX() - view.getLeft());
        final float n2 = (float)(this.getScrollY() - view.getTop());
        obtain = MotionEvent.obtain(obtain);
        obtain.offsetLocation(n, n2);
        final Matrix matrix = view.getMatrix();
        if (!matrix.isIdentity()) {
            if (this.P == null) {
                this.P = new Matrix();
            }
            matrix.invert(this.P);
            obtain.transform(this.P);
        }
        return obtain;
    }
    
    static String s(final int n) {
        if ((n & 0x3) == 0x3) {
            return "LEFT";
        }
        if ((n & 0x5) == 0x5) {
            return "RIGHT";
        }
        return Integer.toHexString(n);
    }
    
    private static boolean t(final View view) {
        final Drawable background = view.getBackground();
        boolean b = false;
        if (background != null) {
            b = b;
            if (background.getOpacity() == -1) {
                b = true;
            }
        }
        return b;
    }
    
    private boolean u() {
        for (int childCount = this.getChildCount(), i = 0; i < childCount; ++i) {
            if (((b)this.getChildAt(i).getLayoutParams()).c) {
                return true;
            }
        }
        return false;
    }
    
    private boolean v() {
        return this.m() != null;
    }
    
    void C(final View view, final float n) {
        final float q = this.q(view);
        final float n2 = (float)view.getWidth();
        int n3 = (int)(n2 * n) - (int)(q * n2);
        if (!this.b(view, 3)) {
            n3 = -n3;
        }
        view.offsetLeftAndRight(n3);
        this.K(view, n);
    }
    
    public void D(final View view) {
        this.E(view, true);
    }
    
    public void E(final View view, final boolean b) {
        if (this.y(view)) {
            final b b2 = (b)view.getLayoutParams();
            if (this.j) {
                b2.b = 1.0f;
                b2.d = 1;
                this.M(view, true);
                this.L(view);
            }
            else if (b) {
                b2.d |= 0x2;
                if (this.b(view, 3)) {
                    this.f.N(view, 0, view.getTop());
                }
                else {
                    this.g.N(view, this.getWidth() - view.getWidth(), view.getTop());
                }
            }
            else {
                this.C(view, 1.0f);
                this.N(0, view);
                view.setVisibility(0);
            }
            this.invalidate();
            return;
        }
        final StringBuilder sb = new StringBuilder();
        sb.append("View ");
        sb.append(view);
        sb.append(" is not a sliding drawer");
        throw new IllegalArgumentException(sb.toString());
    }
    
    public void F(final a a) {
        if (a == null) {
            return;
        }
        final List<a> b = this.B;
        if (b == null) {
            return;
        }
        b.remove(a);
    }
    
    public void J(final int n, final int n2) {
        final int b = androidx.core.view.f.b(n2, b0.B((View)this));
        if (n2 != 3) {
            if (n2 != 5) {
                if (n2 != 8388611) {
                    if (n2 == 8388613) {
                        this.y = n;
                    }
                }
                else {
                    this.x = n;
                }
            }
            else {
                this.w = n;
            }
        }
        else {
            this.p = n;
        }
        if (n != 0) {
            c c;
            if (b == 3) {
                c = this.f;
            }
            else {
                c = this.g;
            }
            c.a();
        }
        if (n != 1) {
            if (n == 2) {
                final View k = this.k(b);
                if (k != null) {
                    this.D(k);
                }
            }
        }
        else {
            final View i = this.k(b);
            if (i != null) {
                this.c(i);
            }
        }
    }
    
    void K(final View view, final float b) {
        final b b2 = (b)view.getLayoutParams();
        if (b == b2.b) {
            return;
        }
        this.i(view, b2.b = b);
    }
    
    void N(int i, final View view) {
        final int z = this.f.z();
        final int z2 = this.g.z();
        final int n = 2;
        int h;
        if (z != 1 && z2 != 1) {
            h = n;
            if (z != 2) {
                if (z2 == 2) {
                    h = n;
                }
                else {
                    h = 0;
                }
            }
        }
        else {
            h = 1;
        }
        if (view != null && i == 0) {
            final float b = ((b)view.getLayoutParams()).b;
            if (b == 0.0f) {
                this.g(view);
            }
            else if (b == 1.0f) {
                this.h(view);
            }
        }
        if (h != this.h) {
            this.h = h;
            final List<a> b2 = this.B;
            if (b2 != null) {
                for (i = b2.size() - 1; i >= 0; --i) {
                    this.B.get(i).c(h);
                }
            }
        }
    }
    
    public void a(final a a) {
        if (a == null) {
            return;
        }
        if (this.B == null) {
            this.B = new ArrayList<a>();
        }
        this.B.add(a);
    }
    
    public void addFocusables(final ArrayList<View> list, final int n, final int n2) {
        if (this.getDescendantFocusability() == 393216) {
            return;
        }
        final int childCount = this.getChildCount();
        final int n3 = 0;
        int i = 0;
        boolean b = false;
        while (i < childCount) {
            final View child = this.getChildAt(i);
            if (this.y(child)) {
                if (this.x(child)) {
                    child.addFocusables((ArrayList)list, n, n2);
                    b = true;
                }
            }
            else {
                this.N.add(child);
            }
            ++i;
        }
        if (!b) {
            for (int size = this.N.size(), j = n3; j < size; ++j) {
                final View view = this.N.get(j);
                if (view.getVisibility() == 0) {
                    view.addFocusables((ArrayList)list, n, n2);
                }
            }
        }
        this.N.clear();
    }
    
    public void addView(final View view, final int n, final ViewGroup$LayoutParams viewGroup$LayoutParams) {
        super.addView(view, n, viewGroup$LayoutParams);
        if (this.l() == null && !this.y(view)) {
            b0.A0(view, 1);
        }
        else {
            b0.A0(view, 4);
        }
        if (!DrawerLayout.T) {
            b0.p0(view, null);
        }
    }
    
    boolean b(final View view, final int n) {
        return (this.p(view) & n) == n;
    }
    
    public void c(final View view) {
        this.d(view, true);
    }
    
    protected boolean checkLayoutParams(final ViewGroup$LayoutParams viewGroup$LayoutParams) {
        return viewGroup$LayoutParams instanceof b && super.checkLayoutParams(viewGroup$LayoutParams);
    }
    
    public void computeScroll() {
        final int childCount = this.getChildCount();
        float max = 0.0f;
        for (int i = 0; i < childCount; ++i) {
            max = Math.max(max, ((b)this.getChildAt(i).getLayoutParams()).b);
        }
        this.d = max;
        final boolean m = this.f.m(true);
        final boolean j = this.g.m(true);
        if (m || j) {
            b0.g0((View)this);
        }
    }
    
    public void d(final View view, final boolean b) {
        if (this.y(view)) {
            final b b2 = (b)view.getLayoutParams();
            if (this.j) {
                b2.b = 0.0f;
                b2.d = 0;
            }
            else if (b) {
                b2.d |= 0x4;
                if (this.b(view, 3)) {
                    this.f.N(view, -view.getWidth(), view.getTop());
                }
                else {
                    this.g.N(view, this.getWidth(), view.getTop());
                }
            }
            else {
                this.C(view, 0.0f);
                this.N(0, view);
                view.setVisibility(4);
            }
            this.invalidate();
            return;
        }
        final StringBuilder sb = new StringBuilder();
        sb.append("View ");
        sb.append(view);
        sb.append(" is not a sliding drawer");
        throw new IllegalArgumentException(sb.toString());
    }
    
    public boolean dispatchGenericMotionEvent(final MotionEvent motionEvent) {
        if ((motionEvent.getSource() & 0x2) != 0x0 && motionEvent.getAction() != 10 && this.d > 0.0f) {
            int i = this.getChildCount();
            if (i != 0) {
                final float x = motionEvent.getX();
                final float y = motionEvent.getY();
                --i;
                while (i >= 0) {
                    final View child = this.getChildAt(i);
                    if (this.A(x, y, child)) {
                        if (!this.w(child)) {
                            if (this.j(motionEvent, child)) {
                                return true;
                            }
                        }
                    }
                    --i;
                }
            }
            return false;
        }
        return super.dispatchGenericMotionEvent(motionEvent);
    }
    
    protected boolean drawChild(final Canvas canvas, final View view, final long n) {
        final int height = this.getHeight();
        final boolean w = this.w(view);
        int width = this.getWidth();
        final int save = canvas.save();
        int n2 = 0;
        int n3 = width;
        if (w) {
            final int childCount = this.getChildCount();
            int i = 0;
            n2 = 0;
            while (i < childCount) {
                final View child = this.getChildAt(i);
                int n4 = width;
                int n5 = n2;
                if (child != view) {
                    n4 = width;
                    n5 = n2;
                    if (child.getVisibility() == 0) {
                        n4 = width;
                        n5 = n2;
                        if (t(child)) {
                            n4 = width;
                            n5 = n2;
                            if (this.y(child)) {
                                if (child.getHeight() < height) {
                                    n4 = width;
                                    n5 = n2;
                                }
                                else if (this.b(child, 3)) {
                                    final int right = child.getRight();
                                    n4 = width;
                                    if (right > (n5 = n2)) {
                                        n5 = right;
                                        n4 = width;
                                    }
                                }
                                else {
                                    final int left = child.getLeft();
                                    n4 = width;
                                    n5 = n2;
                                    if (left < width) {
                                        n4 = left;
                                        n5 = n2;
                                    }
                                }
                            }
                        }
                    }
                }
                ++i;
                width = n4;
                n2 = n5;
            }
            canvas.clipRect(n2, 0, width, this.getHeight());
            n3 = width;
        }
        final boolean drawChild = super.drawChild(canvas, view, n);
        canvas.restoreToCount(save);
        final float d = this.d;
        if (d > 0.0f && w) {
            final int c = this.c;
            this.e.setColor((c & 0xFFFFFF) | (int)(((0xFF000000 & c) >>> 24) * d) << 24);
            canvas.drawRect((float)n2, 0.0f, (float)n3, (float)this.getHeight(), this.e);
        }
        else if (this.F != null && this.b(view, 3)) {
            final int intrinsicWidth = this.F.getIntrinsicWidth();
            final int right2 = view.getRight();
            final float max = Math.max(0.0f, Math.min(right2 / (float)this.f.w(), 1.0f));
            this.F.setBounds(right2, view.getTop(), intrinsicWidth + right2, view.getBottom());
            this.F.setAlpha((int)(max * 255.0f));
            this.F.draw(canvas);
        }
        else if (this.G != null && this.b(view, 5)) {
            final int intrinsicWidth2 = this.G.getIntrinsicWidth();
            final int left2 = view.getLeft();
            final float max2 = Math.max(0.0f, Math.min((this.getWidth() - left2) / (float)this.g.w(), 1.0f));
            this.G.setBounds(left2 - intrinsicWidth2, view.getTop(), left2, view.getBottom());
            this.G.setAlpha((int)(max2 * 255.0f));
            this.G.draw(canvas);
        }
        return drawChild;
    }
    
    public void e() {
        this.f(false);
    }
    
    void f(final boolean b) {
        for (int childCount = this.getChildCount(), i = 0; i < childCount; ++i) {
            final View child = this.getChildAt(i);
            final b b2 = (b)child.getLayoutParams();
            if (this.y(child)) {
                if (!b || b2.c) {
                    final int width = child.getWidth();
                    if (this.b(child, 3)) {
                        this.f.N(child, -width, child.getTop());
                    }
                    else {
                        this.g.N(child, this.getWidth(), child.getTop());
                    }
                    b2.c = false;
                }
            }
        }
        throw null;
    }
    
    void g(View rootView) {
        final b b = (b)rootView.getLayoutParams();
        if ((b.d & 0x1) == 0x1) {
            b.d = 0;
            final List<a> b2 = this.B;
            if (b2 != null) {
                for (int i = b2.size() - 1; i >= 0; --i) {
                    this.B.get(i).b(rootView);
                }
            }
            this.M(rootView, false);
            this.L(rootView);
            if (this.hasWindowFocus()) {
                rootView = this.getRootView();
                if (rootView != null) {
                    rootView.sendAccessibilityEvent(32);
                }
            }
        }
    }
    
    protected ViewGroup$LayoutParams generateDefaultLayoutParams() {
        return (ViewGroup$LayoutParams)new b(-1, -1);
    }
    
    public ViewGroup$LayoutParams generateLayoutParams(final AttributeSet set) {
        return (ViewGroup$LayoutParams)new b(this.getContext(), set);
    }
    
    protected ViewGroup$LayoutParams generateLayoutParams(final ViewGroup$LayoutParams viewGroup$LayoutParams) {
        b b;
        if (viewGroup$LayoutParams instanceof b) {
            b = new b((b)viewGroup$LayoutParams);
        }
        else if (viewGroup$LayoutParams instanceof ViewGroup$MarginLayoutParams) {
            b = new b((ViewGroup$MarginLayoutParams)viewGroup$LayoutParams);
        }
        else {
            b = new b(viewGroup$LayoutParams);
        }
        return (ViewGroup$LayoutParams)b;
    }
    
    public float getDrawerElevation() {
        if (DrawerLayout.U) {
            return this.a;
        }
        return 0.0f;
    }
    
    public Drawable getStatusBarBackgroundDrawable() {
        return this.E;
    }
    
    void h(final View view) {
        final b b = (b)view.getLayoutParams();
        if ((b.d & 0x1) == 0x0) {
            b.d = 1;
            final List<a> b2 = this.B;
            if (b2 != null) {
                for (int i = b2.size() - 1; i >= 0; --i) {
                    this.B.get(i).a(view);
                }
            }
            this.M(view, true);
            this.L(view);
            if (this.hasWindowFocus()) {
                this.sendAccessibilityEvent(32);
            }
        }
    }
    
    void i(final View view, final float n) {
        final List<a> b = this.B;
        if (b != null) {
            for (int i = b.size() - 1; i >= 0; --i) {
                this.B.get(i).d(view, n);
            }
        }
    }
    
    View k(int i) {
        final int b = androidx.core.view.f.b(i, b0.B((View)this));
        int childCount;
        View child;
        for (childCount = this.getChildCount(), i = 0; i < childCount; ++i) {
            child = this.getChildAt(i);
            if ((this.p(child) & 0x7) == (b & 0x7)) {
                return child;
            }
        }
        return null;
    }
    
    View l() {
        for (int childCount = this.getChildCount(), i = 0; i < childCount; ++i) {
            final View child = this.getChildAt(i);
            if ((((b)child.getLayoutParams()).d & 0x1) == 0x1) {
                return child;
            }
        }
        return null;
    }
    
    View m() {
        for (int childCount = this.getChildCount(), i = 0; i < childCount; ++i) {
            final View child = this.getChildAt(i);
            if (this.y(child) && this.z(child)) {
                return child;
            }
        }
        return null;
    }
    
    public int n(int n) {
        final int b = b0.B((View)this);
        if (n != 3) {
            if (n != 5) {
                if (n != 8388611) {
                    if (n == 8388613) {
                        n = this.y;
                        if (n != 3) {
                            return n;
                        }
                        if (b == 0) {
                            n = this.w;
                        }
                        else {
                            n = this.p;
                        }
                        if (n != 3) {
                            return n;
                        }
                    }
                }
                else {
                    n = this.x;
                    if (n != 3) {
                        return n;
                    }
                    if (b == 0) {
                        n = this.p;
                    }
                    else {
                        n = this.w;
                    }
                    if (n != 3) {
                        return n;
                    }
                }
            }
            else {
                n = this.w;
                if (n != 3) {
                    return n;
                }
                if (b == 0) {
                    n = this.y;
                }
                else {
                    n = this.x;
                }
                if (n != 3) {
                    return n;
                }
            }
        }
        else {
            n = this.p;
            if (n != 3) {
                return n;
            }
            if (b == 0) {
                n = this.x;
            }
            else {
                n = this.y;
            }
            if (n != 3) {
                return n;
            }
        }
        return 0;
    }
    
    public int o(final View view) {
        if (this.y(view)) {
            return this.n(((b)view.getLayoutParams()).a);
        }
        final StringBuilder sb = new StringBuilder();
        sb.append("View ");
        sb.append(view);
        sb.append(" is not a drawer");
        throw new IllegalArgumentException(sb.toString());
    }
    
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.j = true;
    }
    
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.j = true;
    }
    
    public void onDraw(final Canvas canvas) {
        super.onDraw(canvas);
        if (this.I && this.E != null) {
            final Object h = this.H;
            int systemWindowInsetTop;
            if (h != null) {
                systemWindowInsetTop = ((WindowInsets)h).getSystemWindowInsetTop();
            }
            else {
                systemWindowInsetTop = 0;
            }
            if (systemWindowInsetTop > 0) {
                this.E.setBounds(0, 0, this.getWidth(), systemWindowInsetTop);
                this.E.draw(canvas);
            }
        }
    }
    
    public boolean onInterceptTouchEvent(final MotionEvent motionEvent) {
        final int actionMasked = motionEvent.getActionMasked();
        final boolean m = this.f.M(motionEvent);
        final boolean i = this.g.M(motionEvent);
        final boolean b = true;
        boolean b2;
        if (actionMasked != 0) {
            Label_0081: {
                if (actionMasked != 1) {
                    if (actionMasked != 2) {
                        if (actionMasked != 3) {
                            break Label_0081;
                        }
                    }
                    else {
                        if (!this.f.d(3)) {
                            break Label_0081;
                        }
                        throw null;
                    }
                }
                this.f(true);
                this.z = false;
            }
            b2 = false;
        }
        else {
            final float x = motionEvent.getX();
            final float y = motionEvent.getY();
            this.C = x;
            this.D = y;
            Label_0149: {
                if (this.d > 0.0f) {
                    final View t = this.f.t((int)x, (int)y);
                    if (t != null && this.w(t)) {
                        b2 = true;
                        break Label_0149;
                    }
                }
                b2 = false;
            }
            this.z = false;
        }
        boolean b3 = b;
        if (!(m | i)) {
            b3 = b;
            if (!b2) {
                b3 = b;
                if (!this.u()) {
                    b3 = (this.z && b);
                }
            }
        }
        return b3;
    }
    
    public boolean onKeyDown(final int n, final KeyEvent keyEvent) {
        if (n == 4 && this.v()) {
            keyEvent.startTracking();
            return true;
        }
        return super.onKeyDown(n, keyEvent);
    }
    
    public boolean onKeyUp(final int n, final KeyEvent keyEvent) {
        if (n == 4) {
            final View m = this.m();
            if (m != null && this.o(m) == 0) {
                this.e();
            }
            return m != null;
        }
        return super.onKeyUp(n, keyEvent);
    }
    
    protected void onLayout(final boolean b, int visibility, final int n, int i, final int n2) {
        this.i = true;
        final int n3 = i - visibility;
        int childCount;
        View child;
        b b2;
        int measuredWidth;
        int measuredHeight;
        float n4;
        int n5;
        float n6;
        float n7;
        boolean b3;
        int n8;
        int n9;
        int bottomMargin;
        for (childCount = this.getChildCount(), i = 0; i < childCount; ++i) {
            child = this.getChildAt(i);
            if (child.getVisibility() != 8) {
                b2 = (b)child.getLayoutParams();
                if (this.w(child)) {
                    visibility = b2.leftMargin;
                    child.layout(visibility, b2.topMargin, child.getMeasuredWidth() + visibility, b2.topMargin + child.getMeasuredHeight());
                }
                else {
                    measuredWidth = child.getMeasuredWidth();
                    measuredHeight = child.getMeasuredHeight();
                    if (this.b(child, 3)) {
                        visibility = -measuredWidth;
                        n4 = (float)measuredWidth;
                        n5 = visibility + (int)(b2.b * n4);
                        n6 = (measuredWidth + n5) / n4;
                    }
                    else {
                        n7 = (float)measuredWidth;
                        n5 = n3 - (int)(b2.b * n7);
                        n6 = (n3 - n5) / n7;
                    }
                    b3 = (n6 != b2.b);
                    visibility = (b2.a & 0x70);
                    if (visibility != 16) {
                        if (visibility != 80) {
                            visibility = b2.topMargin;
                            child.layout(n5, visibility, measuredWidth + n5, measuredHeight + visibility);
                        }
                        else {
                            visibility = n2 - n;
                            child.layout(n5, visibility - b2.bottomMargin - child.getMeasuredHeight(), measuredWidth + n5, visibility - b2.bottomMargin);
                        }
                    }
                    else {
                        n8 = n2 - n;
                        n9 = (n8 - measuredHeight) / 2;
                        visibility = b2.topMargin;
                        if (n9 >= visibility) {
                            bottomMargin = b2.bottomMargin;
                            visibility = n9;
                            if (n9 + measuredHeight > n8 - bottomMargin) {
                                visibility = n8 - bottomMargin - measuredHeight;
                            }
                        }
                        child.layout(n5, visibility, measuredWidth + n5, measuredHeight + visibility);
                    }
                    if (b3) {
                        this.K(child, n6);
                    }
                    if (b2.b > 0.0f) {
                        visibility = 0;
                    }
                    else {
                        visibility = 4;
                    }
                    if (child.getVisibility() != visibility) {
                        child.setVisibility(visibility);
                    }
                }
            }
        }
        if (DrawerLayout.V) {
            final WindowInsets rootWindowInsets = this.getRootWindowInsets();
            if (rootWindowInsets != null) {
                final e h = n0.v(rootWindowInsets).h();
                final c f = this.f;
                f.K(Math.max(f.v(), h.a));
                final c g = this.g;
                g.K(Math.max(g.v(), h.c));
            }
        }
        this.i = false;
        this.j = false;
    }
    
    protected void onMeasure(final int n, final int n2) {
        final int mode = View$MeasureSpec.getMode(n);
        final int mode2 = View$MeasureSpec.getMode(n2);
        int size = View$MeasureSpec.getSize(n);
        final int size2 = View$MeasureSpec.getSize(n2);
        int n3 = 0;
        int n4 = 0;
        Label_0087: {
            if (mode == 1073741824) {
                n3 = size;
                n4 = size2;
                if (mode2 == 1073741824) {
                    break Label_0087;
                }
            }
            if (!this.isInEditMode()) {
                throw new IllegalArgumentException("DrawerLayout must be measured with MeasureSpec.EXACTLY.");
            }
            if (mode == 0) {
                size = 300;
            }
            n3 = size;
            n4 = size2;
            if (mode2 == 0) {
                n4 = 300;
                n3 = size;
            }
        }
        this.setMeasuredDimension(n3, n4);
        final boolean b = this.H != null && b0.y((View)this);
        final int b2 = b0.B((View)this);
        final int childCount = this.getChildCount();
        int i = 0;
        int n6;
        int n5 = n6 = 0;
        while (i < childCount) {
            final View child = this.getChildAt(i);
            if (child.getVisibility() != 8) {
                final b b3 = (b)child.getLayoutParams();
                if (b) {
                    final int b4 = androidx.core.view.f.b(b3.a, b2);
                    if (b0.y(child)) {
                        final WindowInsets windowInsets = (WindowInsets)this.H;
                        WindowInsets windowInsets2;
                        if (b4 == 3) {
                            windowInsets2 = windowInsets.replaceSystemWindowInsets(windowInsets.getSystemWindowInsetLeft(), windowInsets.getSystemWindowInsetTop(), 0, windowInsets.getSystemWindowInsetBottom());
                        }
                        else {
                            windowInsets2 = windowInsets;
                            if (b4 == 5) {
                                windowInsets2 = windowInsets.replaceSystemWindowInsets(0, windowInsets.getSystemWindowInsetTop(), windowInsets.getSystemWindowInsetRight(), windowInsets.getSystemWindowInsetBottom());
                            }
                        }
                        child.dispatchApplyWindowInsets(windowInsets2);
                    }
                    else {
                        final WindowInsets windowInsets3 = (WindowInsets)this.H;
                        WindowInsets windowInsets4;
                        if (b4 == 3) {
                            windowInsets4 = windowInsets3.replaceSystemWindowInsets(windowInsets3.getSystemWindowInsetLeft(), windowInsets3.getSystemWindowInsetTop(), 0, windowInsets3.getSystemWindowInsetBottom());
                        }
                        else {
                            windowInsets4 = windowInsets3;
                            if (b4 == 5) {
                                windowInsets4 = windowInsets3.replaceSystemWindowInsets(0, windowInsets3.getSystemWindowInsetTop(), windowInsets3.getSystemWindowInsetRight(), windowInsets3.getSystemWindowInsetBottom());
                            }
                        }
                        b3.leftMargin = windowInsets4.getSystemWindowInsetLeft();
                        b3.topMargin = windowInsets4.getSystemWindowInsetTop();
                        b3.rightMargin = windowInsets4.getSystemWindowInsetRight();
                        b3.bottomMargin = windowInsets4.getSystemWindowInsetBottom();
                    }
                }
                if (this.w(child)) {
                    child.measure(View$MeasureSpec.makeMeasureSpec(n3 - b3.leftMargin - b3.rightMargin, 1073741824), View$MeasureSpec.makeMeasureSpec(n4 - b3.topMargin - b3.bottomMargin, 1073741824));
                }
                else {
                    if (!this.y(child)) {
                        final StringBuilder sb = new StringBuilder();
                        sb.append("Child ");
                        sb.append(child);
                        sb.append(" at index ");
                        sb.append(i);
                        sb.append(" does not have a valid layout_gravity - must be Gravity.LEFT, Gravity.RIGHT or Gravity.NO_GRAVITY");
                        throw new IllegalStateException(sb.toString());
                    }
                    if (DrawerLayout.U) {
                        final float w = b0.w(child);
                        final float a = this.a;
                        if (w != a) {
                            b0.x0(child, a);
                        }
                    }
                    final int n7 = this.p(child) & 0x7;
                    final boolean b5 = n7 == 3;
                    if ((b5 && n5 != 0) || (!b5 && n6 != 0)) {
                        final StringBuilder sb2 = new StringBuilder();
                        sb2.append("Child drawer has absolute gravity ");
                        sb2.append(s(n7));
                        sb2.append(" but this ");
                        sb2.append("DrawerLayout");
                        sb2.append(" already has a drawer view along that edge");
                        throw new IllegalStateException(sb2.toString());
                    }
                    if (b5) {
                        n5 = 1;
                    }
                    else {
                        n6 = 1;
                    }
                    child.measure(ViewGroup.getChildMeasureSpec(n, this.b + b3.leftMargin + b3.rightMargin, b3.width), ViewGroup.getChildMeasureSpec(n2, b3.topMargin + b3.bottomMargin, b3.height));
                }
            }
            ++i;
        }
    }
    
    protected void onRestoreInstanceState(final Parcelable parcelable) {
        if (!(parcelable instanceof SavedState)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        final SavedState savedState = (SavedState)parcelable;
        super.onRestoreInstanceState(savedState.a());
        final int c = savedState.c;
        if (c != 0) {
            final View k = this.k(c);
            if (k != null) {
                this.D(k);
            }
        }
        final int d = savedState.d;
        if (d != 3) {
            this.J(d, 3);
        }
        final int e = savedState.e;
        if (e != 3) {
            this.J(e, 5);
        }
        final int f = savedState.f;
        if (f != 3) {
            this.J(f, 8388611);
        }
        final int g = savedState.g;
        if (g != 3) {
            this.J(g, 8388613);
        }
    }
    
    public void onRtlPropertiesChanged(final int n) {
        this.I();
    }
    
    protected Parcelable onSaveInstanceState() {
        final SavedState savedState = new SavedState(super.onSaveInstanceState());
        for (int childCount = this.getChildCount(), i = 0; i < childCount; ++i) {
            final b b = (b)this.getChildAt(i).getLayoutParams();
            final int d = b.d;
            boolean b2 = true;
            final boolean b3 = d == 1;
            if (d != 2) {
                b2 = false;
            }
            if (b3 || b2) {
                savedState.c = b.a;
                break;
            }
        }
        savedState.d = this.p;
        savedState.e = this.w;
        savedState.f = this.x;
        savedState.g = this.y;
        return (Parcelable)savedState;
    }
    
    public boolean onTouchEvent(final MotionEvent motionEvent) {
        this.f.E(motionEvent);
        this.g.E(motionEvent);
        final int n = motionEvent.getAction() & 0xFF;
        boolean b = false;
        if (n != 0) {
            if (n != 1) {
                if (n == 3) {
                    this.f(true);
                    this.z = false;
                }
            }
            else {
                final float x = motionEvent.getX();
                final float y = motionEvent.getY();
                final View t = this.f.t((int)x, (int)y);
                Label_0157: {
                    if (t != null && this.w(t)) {
                        final float n2 = x - this.C;
                        final float n3 = y - this.D;
                        final int y2 = this.f.y();
                        if (n2 * n2 + n3 * n3 < y2 * y2) {
                            final View l = this.l();
                            if (l != null && this.o(l) != 2) {
                                break Label_0157;
                            }
                        }
                    }
                    b = true;
                }
                this.f(b);
            }
        }
        else {
            final float x2 = motionEvent.getX();
            final float y3 = motionEvent.getY();
            this.C = x2;
            this.D = y3;
            this.z = false;
        }
        return true;
    }
    
    int p(final View view) {
        return androidx.core.view.f.b(((b)view.getLayoutParams()).a, b0.B((View)this));
    }
    
    float q(final View view) {
        return ((b)view.getLayoutParams()).b;
    }
    
    public void requestDisallowInterceptTouchEvent(final boolean b) {
        super.requestDisallowInterceptTouchEvent(b);
        if (b) {
            this.f(true);
        }
    }
    
    public void requestLayout() {
        if (!this.i) {
            super.requestLayout();
        }
    }
    
    public void setDrawerElevation(final float a) {
        this.a = a;
        for (int i = 0; i < this.getChildCount(); ++i) {
            final View child = this.getChildAt(i);
            if (this.y(child)) {
                b0.x0(child, this.a);
            }
        }
    }
    
    @Deprecated
    public void setDrawerListener(final a a) {
        final a a2 = this.A;
        if (a2 != null) {
            this.F(a2);
        }
        if (a != null) {
            this.a(a);
        }
        this.A = a;
    }
    
    public void setDrawerLockMode(final int n) {
        this.J(n, 3);
        this.J(n, 5);
    }
    
    public void setScrimColor(final int c) {
        this.c = c;
        this.invalidate();
    }
    
    public void setStatusBarBackground(final int n) {
        Drawable drawable;
        if (n != 0) {
            drawable = androidx.core.content.a.getDrawable(this.getContext(), n);
        }
        else {
            drawable = null;
        }
        this.E = drawable;
        this.invalidate();
    }
    
    public void setStatusBarBackground(final Drawable e) {
        this.E = e;
        this.invalidate();
    }
    
    public void setStatusBarBackgroundColor(final int n) {
        this.E = (Drawable)new ColorDrawable(n);
        this.invalidate();
    }
    
    boolean w(final View view) {
        return ((b)view.getLayoutParams()).a == 0;
    }
    
    public boolean x(final View view) {
        if (this.y(view)) {
            final int d = ((b)view.getLayoutParams()).d;
            boolean b = true;
            if ((d & 0x1) != 0x1) {
                b = false;
            }
            return b;
        }
        final StringBuilder sb = new StringBuilder();
        sb.append("View ");
        sb.append(view);
        sb.append(" is not a drawer");
        throw new IllegalArgumentException(sb.toString());
    }
    
    boolean y(final View view) {
        final int b = androidx.core.view.f.b(((b)view.getLayoutParams()).a, b0.B(view));
        return (b & 0x3) != 0x0 || (b & 0x5) != 0x0;
    }
    
    public boolean z(final View view) {
        if (this.y(view)) {
            return ((b)view.getLayoutParams()).b > 0.0f;
        }
        final StringBuilder sb = new StringBuilder();
        sb.append("View ");
        sb.append(view);
        sb.append(" is not a drawer");
        throw new IllegalArgumentException(sb.toString());
    }
    
    protected static class SavedState extends AbsSavedState
    {
        public static final Parcelable$Creator<SavedState> CREATOR;
        int c;
        int d;
        int e;
        int f;
        int g;
        
        static {
            CREATOR = (Parcelable$Creator)new Parcelable$ClassLoaderCreator<SavedState>() {
                public SavedState a(final Parcel parcel) {
                    return new SavedState(parcel, null);
                }
                
                public SavedState b(final Parcel parcel, final ClassLoader classLoader) {
                    return new SavedState(parcel, classLoader);
                }
                
                public SavedState[] c(final int n) {
                    return new SavedState[n];
                }
                
                public /* bridge */ Object createFromParcel(final Parcel parcel) {
                    return this.a(parcel);
                }
                
                public /* bridge */ Object createFromParcel(final Parcel parcel, final ClassLoader classLoader) {
                    return this.b(parcel, classLoader);
                }
                
                public /* bridge */ Object[] newArray(final int n) {
                    return this.c(n);
                }
            };
        }
        
        public SavedState(final Parcel parcel, final ClassLoader classLoader) {
            super(parcel, classLoader);
            this.c = 0;
            this.c = parcel.readInt();
            this.d = parcel.readInt();
            this.e = parcel.readInt();
            this.f = parcel.readInt();
            this.g = parcel.readInt();
        }
        
        public SavedState(final Parcelable parcelable) {
            super(parcelable);
            this.c = 0;
        }
        
        @Override
        public void writeToParcel(final Parcel parcel, final int n) {
            super.writeToParcel(parcel, n);
            parcel.writeInt(this.c);
            parcel.writeInt(this.d);
            parcel.writeInt(this.e);
            parcel.writeInt(this.f);
            parcel.writeInt(this.g);
        }
    }
    
    public interface a
    {
        void a(final View p0);
        
        void b(final View p0);
        
        void c(final int p0);
        
        void d(final View p0, final float p1);
    }
    
    public static class b extends ViewGroup$MarginLayoutParams
    {
        public int a;
        float b;
        boolean c;
        int d;
        
        public b(final int n, final int n2) {
            super(n, n2);
            this.a = 0;
        }
        
        public b(final Context context, final AttributeSet set) {
            super(context, set);
            this.a = 0;
            final TypedArray obtainStyledAttributes = context.obtainStyledAttributes(set, DrawerLayout.S);
            this.a = obtainStyledAttributes.getInt(0, 0);
            obtainStyledAttributes.recycle();
        }
        
        public b(final ViewGroup$LayoutParams viewGroup$LayoutParams) {
            super(viewGroup$LayoutParams);
            this.a = 0;
        }
        
        public b(final ViewGroup$MarginLayoutParams viewGroup$MarginLayoutParams) {
            super(viewGroup$MarginLayoutParams);
            this.a = 0;
        }
        
        public b(final b b) {
            super((ViewGroup$MarginLayoutParams)b);
            this.a = 0;
            this.a = b.a;
        }
    }
}
