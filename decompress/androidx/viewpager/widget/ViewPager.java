// 
// Decompiled by Procyon v0.6.0
// 

package androidx.viewpager.widget;

import android.os.Bundle;
import androidx.core.view.accessibility.d;
import java.util.Objects;
import android.content.res.TypedArray;
import java.lang.annotation.ElementType;
import java.lang.annotation.Target;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Retention;
import java.lang.annotation.Inherited;
import android.os.Parcel;
import android.os.Parcelable$ClassLoaderCreator;
import android.os.Parcelable$Creator;
import androidx.customview.view.AbsSavedState;
import androidx.core.view.n0;
import androidx.core.view.v;
import android.view.ViewConfiguration;
import android.view.View$MeasureSpec;
import android.graphics.Canvas;
import android.view.accessibility.AccessibilityEvent;
import android.view.KeyEvent;
import android.view.SoundEffectConstants;
import android.view.FocusFinder;
import android.util.Log;
import android.view.ViewGroup$LayoutParams;
import android.view.MotionEvent;
import android.graphics.Paint;
import androidx.core.view.b0;
import java.util.Collections;
import android.view.ViewParent;
import android.util.AttributeSet;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.Scroller;
import java.util.List;
import android.os.Parcelable;
import android.graphics.Rect;
import java.util.ArrayList;
import android.widget.EdgeEffect;
import android.view.VelocityTracker;
import android.view.animation.Interpolator;
import java.util.Comparator;
import android.view.ViewGroup;

public class ViewPager extends ViewGroup
{
    static final int[] q0;
    private static final Comparator<f> r0;
    private static final Interpolator s0;
    private static final l t0;
    private float A;
    private int B;
    private int C;
    private boolean D;
    private boolean E;
    private boolean F;
    private int G;
    private boolean H;
    private boolean I;
    private int J;
    private int K;
    private int L;
    private float M;
    private float N;
    private float O;
    private float P;
    private int Q;
    private VelocityTracker R;
    private int S;
    private int T;
    private int U;
    private int V;
    private boolean W;
    private int a;
    private EdgeEffect a0;
    private final ArrayList<f> b;
    private EdgeEffect b0;
    private final f c;
    private boolean c0;
    private final Rect d;
    private boolean d0;
    int e;
    private boolean e0;
    private int f;
    private int f0;
    private Parcelable g;
    private List<j> g0;
    private ClassLoader h;
    private j h0;
    private Scroller i;
    private j i0;
    private boolean j;
    private List<i> j0;
    private k k0;
    private int l0;
    private int m0;
    private ArrayList<View> n0;
    private final Runnable o0;
    private int p;
    private int p0;
    private Drawable w;
    private int x;
    private int y;
    private float z;
    
    static {
        q0 = new int[] { 16842931 };
        r0 = new Comparator<f>() {
            public int a(final f f, final f f2) {
                return f.b - f2.b;
            }
            
            @Override
            public /* bridge */ int compare(final Object o, final Object o2) {
                return this.a((f)o, (f)o2);
            }
        };
        s0 = (Interpolator)new Interpolator() {
            public float getInterpolation(float n) {
                --n;
                return n * n * n * n * n + 1.0f;
            }
        };
        t0 = new l();
    }
    
    public ViewPager(final Context context, final AttributeSet set) {
        super(context, set);
        this.b = new ArrayList<f>();
        this.c = new f();
        this.d = new Rect();
        this.f = -1;
        this.g = null;
        this.h = null;
        this.z = -3.4028235E38f;
        this.A = Float.MAX_VALUE;
        this.G = 1;
        this.Q = -1;
        this.c0 = true;
        this.d0 = false;
        this.o0 = new Runnable() {
            final ViewPager a;
            
            @Override
            public void run() {
                this.a.setScrollState(0);
                this.a.z();
            }
        };
        this.p0 = 0;
        this.q();
    }
    
    private void B(int n, final int n2, final int n3, final int n4) {
        if (n2 > 0 && !this.b.isEmpty()) {
            if (!this.i.isFinished()) {
                this.i.setFinalX(this.getCurrentItem() * this.getClientWidth());
            }
            else {
                this.scrollTo((int)(this.getScrollX() / (float)(n2 - this.getPaddingLeft() - this.getPaddingRight() + n4) * (n - this.getPaddingLeft() - this.getPaddingRight() + n3)), this.getScrollY());
            }
        }
        else {
            final f p4 = this.p(this.e);
            float min;
            if (p4 != null) {
                min = Math.min(p4.e, this.A);
            }
            else {
                min = 0.0f;
            }
            n = (int)(min * (n - this.getPaddingLeft() - this.getPaddingRight()));
            if (n != this.getScrollX()) {
                this.e(false);
                this.scrollTo(n, this.getScrollY());
            }
        }
    }
    
    private void E(final boolean b) {
        final ViewParent parent = this.getParent();
        if (parent != null) {
            parent.requestDisallowInterceptTouchEvent(b);
        }
    }
    
    private boolean F() {
        this.Q = -1;
        this.k();
        this.a0.onRelease();
        this.b0.onRelease();
        return this.a0.isFinished() || this.b0.isFinished();
    }
    
    private void G(final int n, final boolean b, final int n2, final boolean b2) {
        final f p4 = this.p(n);
        int n3;
        if (p4 != null) {
            n3 = (int)(this.getClientWidth() * Math.max(this.z, Math.min(p4.e, this.A)));
        }
        else {
            n3 = 0;
        }
        if (b) {
            this.K(n3, 0, n2);
            if (b2) {
                this.g(n);
            }
        }
        else {
            if (b2) {
                this.g(n);
            }
            this.e(false);
            this.scrollTo(n3, 0);
            this.x(n3);
        }
    }
    
    private void L() {
        if (this.m0 != 0) {
            final ArrayList<View> n0 = this.n0;
            if (n0 == null) {
                this.n0 = new ArrayList<View>();
            }
            else {
                n0.clear();
            }
            for (int childCount = this.getChildCount(), i = 0; i < childCount; ++i) {
                this.n0.add(this.getChildAt(i));
            }
            Collections.sort(this.n0, ViewPager.t0);
        }
    }
    
    private void e(final boolean b) {
        int n;
        if (this.p0 == 2) {
            n = 1;
        }
        else {
            n = 0;
        }
        if (n != 0) {
            this.setScrollingCacheEnabled(false);
            if (this.i.isFinished() ^ true) {
                this.i.abortAnimation();
                final int scrollX = this.getScrollX();
                final int scrollY = this.getScrollY();
                final int currX = this.i.getCurrX();
                final int currY = this.i.getCurrY();
                if (scrollX != currX || scrollY != currY) {
                    this.scrollTo(currX, currY);
                    if (currX != scrollX) {
                        this.x(currX);
                    }
                }
            }
        }
        this.F = false;
        for (int i = 0; i < this.b.size(); ++i) {
            final f f = this.b.get(i);
            if (f.c) {
                f.c = false;
                n = 1;
            }
        }
        if (n != 0) {
            if (b) {
                androidx.core.view.b0.h0((View)this, this.o0);
            }
            else {
                this.o0.run();
            }
        }
    }
    
    private void f(final int n, final float n2, final int n3) {
        final j h0 = this.h0;
        if (h0 != null) {
            h0.a(n, n2, n3);
        }
        final List<j> g0 = this.g0;
        if (g0 != null) {
            for (int i = 0; i < g0.size(); ++i) {
                final j j = this.g0.get(i);
                if (j != null) {
                    j.a(n, n2, n3);
                }
            }
        }
        final j i2 = this.i0;
        if (i2 != null) {
            i2.a(n, n2, n3);
        }
    }
    
    private void g(final int n) {
        final j h0 = this.h0;
        if (h0 != null) {
            h0.c(n);
        }
        final List<j> g0 = this.g0;
        if (g0 != null) {
            for (int i = 0; i < g0.size(); ++i) {
                final j j = this.g0.get(i);
                if (j != null) {
                    j.c(n);
                }
            }
        }
        final j i2 = this.i0;
        if (i2 != null) {
            i2.c(n);
        }
    }
    
    private int getClientWidth() {
        return this.getMeasuredWidth() - this.getPaddingLeft() - this.getPaddingRight();
    }
    
    private void h(final int n) {
        final j h0 = this.h0;
        if (h0 != null) {
            h0.b(n);
        }
        final List<j> g0 = this.g0;
        if (g0 != null) {
            for (int i = 0; i < g0.size(); ++i) {
                final j j = this.g0.get(i);
                if (j != null) {
                    j.b(n);
                }
            }
        }
        final j i2 = this.i0;
        if (i2 != null) {
            i2.b(n);
        }
    }
    
    private void j(final boolean b) {
        for (int childCount = this.getChildCount(), i = 0; i < childCount; ++i) {
            int l0;
            if (b) {
                l0 = this.l0;
            }
            else {
                l0 = 0;
            }
            this.getChildAt(i).setLayerType(l0, (Paint)null);
        }
    }
    
    private void k() {
        this.H = false;
        this.I = false;
        final VelocityTracker r = this.R;
        if (r != null) {
            r.recycle();
            this.R = null;
        }
    }
    
    private Rect m(final Rect rect, final View view) {
        Rect rect2 = rect;
        if (rect == null) {
            rect2 = new Rect();
        }
        if (view == null) {
            rect2.set(0, 0, 0, 0);
            return rect2;
        }
        rect2.left = view.getLeft();
        rect2.right = view.getRight();
        rect2.top = view.getTop();
        rect2.bottom = view.getBottom();
        ViewGroup viewGroup;
        for (ViewParent viewParent = view.getParent(); viewParent instanceof ViewGroup && viewParent != this; viewParent = viewGroup.getParent()) {
            viewGroup = (ViewGroup)viewParent;
            rect2.left += viewGroup.getLeft();
            rect2.right += viewGroup.getRight();
            rect2.top += viewGroup.getTop();
            rect2.bottom += viewGroup.getBottom();
        }
        return rect2;
    }
    
    private f o() {
        final int clientWidth = this.getClientWidth();
        float e = 0.0f;
        float n;
        if (clientWidth > 0) {
            n = this.getScrollX() / (float)clientWidth;
        }
        else {
            n = 0.0f;
        }
        float n2;
        if (clientWidth > 0) {
            n2 = this.p / (float)clientWidth;
        }
        else {
            n2 = 0.0f;
        }
        int b = -1;
        float d = 0.0f;
        int i = 0;
        f f = null;
        int n3 = 1;
        while (i < this.b.size()) {
            final f f2 = this.b.get(i);
            if (n3 == 0) {
                final int b2 = f2.b;
                ++b;
                if (b2 != b) {
                    final f c = this.c;
                    c.e = e + d + n2;
                    c.b = b;
                    throw null;
                }
            }
            e = f2.e;
            final float d2 = f2.d;
            if (n3 == 0 && n < e) {
                return f;
            }
            if (n < d2 + e + n2 || i == this.b.size() - 1) {
                return f2;
            }
            b = f2.b;
            d = f2.d;
            ++i;
            n3 = 0;
            f = f2;
        }
        return f;
    }
    
    private static boolean r(final View view) {
        return view.getClass().getAnnotation(e.class) != null;
    }
    
    private boolean s(final float n, final float n2) {
        return (n < this.K && n2 > 0.0f) || (n > this.getWidth() - this.K && n2 < 0.0f);
    }
    
    private void setScrollingCacheEnabled(final boolean e) {
        if (this.E != e) {
            this.E = e;
        }
    }
    
    private void u(final MotionEvent motionEvent) {
        final int actionIndex = motionEvent.getActionIndex();
        if (motionEvent.getPointerId(actionIndex) == this.Q) {
            int n;
            if (actionIndex == 0) {
                n = 1;
            }
            else {
                n = 0;
            }
            this.M = motionEvent.getX(n);
            this.Q = motionEvent.getPointerId(n);
            final VelocityTracker r = this.R;
            if (r != null) {
                r.clear();
            }
        }
    }
    
    private boolean x(int n) {
        if (this.b.size() == 0) {
            if (this.c0) {
                return false;
            }
            this.e0 = false;
            this.t(0, 0.0f, 0);
            if (this.e0) {
                return false;
            }
            throw new IllegalStateException("onPageScrolled did not call superclass implementation");
        }
        else {
            final f o = this.o();
            final int clientWidth = this.getClientWidth();
            final int p = this.p;
            final float n2 = (float)p;
            final float n3 = (float)clientWidth;
            final float n4 = n2 / n3;
            final int b = o.b;
            final float n5 = (n / n3 - o.e) / (o.d + n4);
            n = (int)((clientWidth + p) * n5);
            this.e0 = false;
            this.t(b, n5, n);
            if (this.e0) {
                return true;
            }
            throw new IllegalStateException("onPageScrolled did not call superclass implementation");
        }
    }
    
    private boolean y(final float m) {
        this.M = m;
        this.getScrollX();
        this.getClientWidth();
        final f f = this.b.get(0);
        final ArrayList<f> b = this.b;
        final f f2 = b.get(b.size() - 1);
        final int b2 = f.b;
        final int b3 = f2.b;
        throw null;
    }
    
    void A(final int e) {
        final int e2 = this.e;
        if (e2 != e) {
            this.p(e2);
            this.e = e;
        }
        this.L();
    }
    
    public void C(final i i) {
        final List<i> j0 = this.j0;
        if (j0 != null) {
            j0.remove(i);
        }
    }
    
    public void D(final j j) {
        final List<j> g0 = this.g0;
        if (g0 != null) {
            g0.remove(j);
        }
    }
    
    public void H(final int n, final boolean b) {
        this.I(n, b, this.F = false);
    }
    
    void I(final int n, final boolean b, final boolean b2) {
        this.J(n, b, b2, 0);
    }
    
    void J(final int n, final boolean b, final boolean b2, final int n2) {
        this.setScrollingCacheEnabled(false);
    }
    
    void K(int n, int n2, int n3) {
        if (this.getChildCount() == 0) {
            this.setScrollingCacheEnabled(false);
            return;
        }
        final Scroller i = this.i;
        int n4;
        if (i != null && !i.isFinished()) {
            if (this.j) {
                n4 = this.i.getCurrX();
            }
            else {
                n4 = this.i.getStartX();
            }
            this.i.abortAnimation();
            this.setScrollingCacheEnabled(false);
        }
        else {
            n4 = this.getScrollX();
        }
        final int scrollY = this.getScrollY();
        n -= n4;
        n2 -= scrollY;
        if (n == 0 && n2 == 0) {
            this.e(false);
            this.z();
            this.setScrollState(0);
            return;
        }
        this.setScrollingCacheEnabled(true);
        this.setScrollState(2);
        final int clientWidth = this.getClientWidth();
        final int n5 = clientWidth / 2;
        final float min = Math.min(1.0f, Math.abs(n) * 1.0f / clientWidth);
        final float n6 = (float)n5;
        final float j = this.i(min);
        n3 = Math.abs(n3);
        if (n3 > 0) {
            n3 = Math.min(Math.round(Math.abs((n6 + j * n6) / n3) * 1000.0f) * 4, 600);
            this.j = false;
            this.i.startScroll(n4, scrollY, n, n2, n3);
            androidx.core.view.b0.g0((View)this);
            return;
        }
        throw null;
    }
    
    public void a(final i i) {
        if (this.j0 == null) {
            this.j0 = new ArrayList<i>();
        }
        this.j0.add(i);
    }
    
    public void addFocusables(final ArrayList<View> list, final int n, final int n2) {
        final int size = list.size();
        final int descendantFocusability = this.getDescendantFocusability();
        if (descendantFocusability != 393216) {
            for (int i = 0; i < this.getChildCount(); ++i) {
                final View child = this.getChildAt(i);
                if (child.getVisibility() == 0) {
                    final f n3 = this.n(child);
                    if (n3 != null && n3.b == this.e) {
                        child.addFocusables((ArrayList)list, n, n2);
                    }
                }
            }
        }
        if (descendantFocusability != 262144 || size == list.size()) {
            if (!this.isFocusable()) {
                return;
            }
            if ((n2 & 0x1) == 0x1 && this.isInTouchMode() && !this.isFocusableInTouchMode()) {
                return;
            }
            list.add((View)this);
        }
    }
    
    public void addTouchables(final ArrayList<View> list) {
        for (int i = 0; i < this.getChildCount(); ++i) {
            final View child = this.getChildAt(i);
            if (child.getVisibility() == 0) {
                final f n = this.n(child);
                if (n != null && n.b == this.e) {
                    child.addTouchables((ArrayList)list);
                }
            }
        }
    }
    
    public void addView(final View view, final int n, final ViewGroup$LayoutParams viewGroup$LayoutParams) {
        ViewGroup$LayoutParams generateLayoutParams = viewGroup$LayoutParams;
        if (!this.checkLayoutParams(viewGroup$LayoutParams)) {
            generateLayoutParams = this.generateLayoutParams(viewGroup$LayoutParams);
        }
        final g g = (g)generateLayoutParams;
        final boolean a = g.a | r(view);
        g.a = a;
        if (this.D) {
            if (a) {
                throw new IllegalStateException("Cannot add pager decor view during layout");
            }
            g.d = true;
            this.addViewInLayout(view, n, generateLayoutParams);
        }
        else {
            super.addView(view, n, generateLayoutParams);
        }
    }
    
    public void b(final j j) {
        if (this.g0 == null) {
            this.g0 = new ArrayList<j>();
        }
        this.g0.add(j);
    }
    
    public boolean c(final int n) {
        final View focus = this.findFocus();
        boolean b = false;
        View view = null;
        Label_0195: {
            Label_0015: {
                if (focus != this) {
                    if ((view = focus) != null) {
                        ViewParent viewParent = focus.getParent();
                        while (true) {
                            while (viewParent instanceof ViewGroup) {
                                if (viewParent == this) {
                                    final boolean b2 = true;
                                    view = focus;
                                    if (!b2) {
                                        final StringBuilder sb = new StringBuilder();
                                        sb.append(focus.getClass().getSimpleName());
                                        for (ViewParent viewParent2 = focus.getParent(); viewParent2 instanceof ViewGroup; viewParent2 = viewParent2.getParent()) {
                                            sb.append(" => ");
                                            sb.append(viewParent2.getClass().getSimpleName());
                                        }
                                        final StringBuilder sb2 = new StringBuilder();
                                        sb2.append("arrowScroll tried to find focus based on non-child current focused view ");
                                        sb2.append(sb.toString());
                                        Log.e("ViewPager", sb2.toString());
                                        break Label_0015;
                                    }
                                    break Label_0195;
                                }
                                else {
                                    viewParent = viewParent.getParent();
                                }
                            }
                            final boolean b2 = false;
                            continue;
                        }
                    }
                    break Label_0195;
                }
            }
            view = null;
        }
        final View nextFocus = FocusFinder.getInstance().findNextFocus((ViewGroup)this, view, n);
        if (nextFocus != null && nextFocus != view) {
            if (n == 17) {
                final int left = this.m(this.d, nextFocus).left;
                final int left2 = this.m(this.d, view).left;
                if (view != null && left >= left2) {
                    b = this.v();
                }
                else {
                    b = nextFocus.requestFocus();
                }
            }
            else if (n == 66) {
                final int left3 = this.m(this.d, nextFocus).left;
                final int left4 = this.m(this.d, view).left;
                if (view != null && left3 <= left4) {
                    b = this.w();
                }
                else {
                    b = nextFocus.requestFocus();
                }
            }
        }
        else if (n != 17 && n != 1) {
            if (n == 66 || n == 2) {
                b = this.w();
            }
        }
        else {
            b = this.v();
        }
        if (b) {
            this.playSoundEffect(SoundEffectConstants.getContantForFocusDirection(n));
        }
        return b;
    }
    
    public boolean canScrollHorizontally(final int n) {
        return false;
    }
    
    protected boolean checkLayoutParams(final ViewGroup$LayoutParams viewGroup$LayoutParams) {
        return viewGroup$LayoutParams instanceof g && super.checkLayoutParams(viewGroup$LayoutParams);
    }
    
    public void computeScroll() {
        this.j = true;
        if (!this.i.isFinished() && this.i.computeScrollOffset()) {
            final int scrollX = this.getScrollX();
            final int scrollY = this.getScrollY();
            final int currX = this.i.getCurrX();
            final int currY = this.i.getCurrY();
            if (scrollX != currX || scrollY != currY) {
                this.scrollTo(currX, currY);
                if (!this.x(currX)) {
                    this.i.abortAnimation();
                    this.scrollTo(0, currY);
                }
            }
            androidx.core.view.b0.g0((View)this);
            return;
        }
        this.e(true);
    }
    
    protected boolean d(final View view, final boolean b, final int n, final int n2, final int n3) {
        final boolean b2 = view instanceof ViewGroup;
        final boolean b3 = true;
        if (b2) {
            final ViewGroup viewGroup = (ViewGroup)view;
            final int scrollX = view.getScrollX();
            final int scrollY = view.getScrollY();
            for (int i = viewGroup.getChildCount() - 1; i >= 0; --i) {
                final View child = viewGroup.getChildAt(i);
                final int n4 = n2 + scrollX;
                if (n4 >= child.getLeft() && n4 < child.getRight()) {
                    final int n5 = n3 + scrollY;
                    if (n5 >= child.getTop() && n5 < child.getBottom() && this.d(child, true, n, n4 - child.getLeft(), n5 - child.getTop())) {
                        return true;
                    }
                }
            }
        }
        return b && view.canScrollHorizontally(-n) && b3;
    }
    
    public boolean dispatchKeyEvent(final KeyEvent keyEvent) {
        return super.dispatchKeyEvent(keyEvent) || this.l(keyEvent);
    }
    
    public boolean dispatchPopulateAccessibilityEvent(final AccessibilityEvent accessibilityEvent) {
        if (accessibilityEvent.getEventType() == 4096) {
            return super.dispatchPopulateAccessibilityEvent(accessibilityEvent);
        }
        for (int childCount = this.getChildCount(), i = 0; i < childCount; ++i) {
            final View child = this.getChildAt(i);
            if (child.getVisibility() == 0) {
                final f n = this.n(child);
                if (n != null && n.b == this.e && child.dispatchPopulateAccessibilityEvent(accessibilityEvent)) {
                    return true;
                }
            }
        }
        return false;
    }
    
    public void draw(final Canvas canvas) {
        super.draw(canvas);
        final int overScrollMode = this.getOverScrollMode();
        int n = 0;
        int n2 = 0;
        if (overScrollMode != 0) {
            this.a0.finish();
            this.b0.finish();
        }
        else {
            if (!this.a0.isFinished()) {
                final int save = canvas.save();
                final int n3 = this.getHeight() - this.getPaddingTop() - this.getPaddingBottom();
                final int width = this.getWidth();
                canvas.rotate(270.0f);
                canvas.translate((float)(-n3 + this.getPaddingTop()), this.z * width);
                this.a0.setSize(n3, width);
                n2 = ((false | this.a0.draw(canvas)) ? 1 : 0);
                canvas.restoreToCount(save);
            }
            n = n2;
            if (!this.b0.isFinished()) {
                final int save2 = canvas.save();
                final int width2 = this.getWidth();
                final int height = this.getHeight();
                final int paddingTop = this.getPaddingTop();
                final int paddingBottom = this.getPaddingBottom();
                canvas.rotate(90.0f);
                canvas.translate((float)(-this.getPaddingTop()), -(this.A + 1.0f) * width2);
                this.b0.setSize(height - paddingTop - paddingBottom, width2);
                n = (n2 | (this.b0.draw(canvas) ? 1 : 0));
                canvas.restoreToCount(save2);
            }
        }
        if (n != 0) {
            androidx.core.view.b0.g0((View)this);
        }
    }
    
    protected void drawableStateChanged() {
        super.drawableStateChanged();
        final Drawable w = this.w;
        if (w != null && w.isStateful()) {
            w.setState(this.getDrawableState());
        }
    }
    
    protected ViewGroup$LayoutParams generateDefaultLayoutParams() {
        return new g();
    }
    
    public ViewGroup$LayoutParams generateLayoutParams(final AttributeSet set) {
        return new g(this.getContext(), set);
    }
    
    protected ViewGroup$LayoutParams generateLayoutParams(final ViewGroup$LayoutParams viewGroup$LayoutParams) {
        return this.generateDefaultLayoutParams();
    }
    
    public a getAdapter() {
        return null;
    }
    
    protected int getChildDrawingOrder(final int n, final int n2) {
        int n3 = n2;
        if (this.m0 == 2) {
            n3 = n - 1 - n2;
        }
        return ((g)this.n0.get(n3).getLayoutParams()).f;
    }
    
    public int getCurrentItem() {
        return this.e;
    }
    
    public int getOffscreenPageLimit() {
        return this.G;
    }
    
    public int getPageMargin() {
        return this.p;
    }
    
    float i(final float n) {
        return (float)Math.sin((n - 0.5f) * 0.47123894f);
    }
    
    public boolean l(final KeyEvent keyEvent) {
        if (keyEvent.getAction() == 0) {
            final int keyCode = keyEvent.getKeyCode();
            if (keyCode != 21) {
                if (keyCode != 22) {
                    if (keyCode == 61) {
                        if (keyEvent.hasNoModifiers()) {
                            return this.c(2);
                        }
                        if (keyEvent.hasModifiers(1)) {
                            return this.c(1);
                        }
                    }
                }
                else {
                    if (keyEvent.hasModifiers(2)) {
                        return this.w();
                    }
                    return this.c(66);
                }
            }
            else {
                if (keyEvent.hasModifiers(2)) {
                    return this.v();
                }
                return this.c(17);
            }
        }
        return false;
    }
    
    f n(final View view) {
        if (this.b.size() <= 0) {
            return null;
        }
        final Object a = this.b.get(0).a;
        throw null;
    }
    
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.c0 = true;
    }
    
    protected void onDetachedFromWindow() {
        this.removeCallbacks(this.o0);
        final Scroller i = this.i;
        if (i != null && !i.isFinished()) {
            this.i.abortAnimation();
        }
        super.onDetachedFromWindow();
    }
    
    protected void onDraw(final Canvas canvas) {
        super.onDraw(canvas);
        if (this.p > 0 && this.w != null) {
            this.b.size();
        }
    }
    
    public boolean onInterceptTouchEvent(final MotionEvent motionEvent) {
        final int n = motionEvent.getAction() & 0xFF;
        if (n != 3 && n != 1) {
            if (n != 0) {
                if (this.H) {
                    return true;
                }
                if (this.I) {
                    return false;
                }
            }
            if (n != 0) {
                if (n != 2) {
                    if (n == 6) {
                        this.u(motionEvent);
                    }
                }
                else {
                    final int q = this.Q;
                    if (q != -1) {
                        final int pointerIndex = motionEvent.findPointerIndex(q);
                        final float x = motionEvent.getX(pointerIndex);
                        final float n2 = x - this.M;
                        final float abs = Math.abs(n2);
                        final float y = motionEvent.getY(pointerIndex);
                        final float abs2 = Math.abs(y - this.P);
                        final float n3 = fcmpl(n2, 0.0f);
                        if (n3 != 0 && !this.s(this.M, n2) && this.d((View)this, false, (int)n2, (int)x, (int)y)) {
                            this.M = x;
                            this.N = y;
                            this.I = true;
                            return false;
                        }
                        final int l = this.L;
                        if (abs > l && abs * 0.5f > abs2) {
                            this.E(this.H = true);
                            this.setScrollState(1);
                            final float o = this.O;
                            final float n4 = (float)this.L;
                            float m;
                            if (n3 > 0) {
                                m = o + n4;
                            }
                            else {
                                m = o - n4;
                            }
                            this.M = m;
                            this.N = y;
                            this.setScrollingCacheEnabled(true);
                        }
                        else if (abs2 > l) {
                            this.I = true;
                        }
                        if (this.H && this.y(x)) {
                            androidx.core.view.b0.g0((View)this);
                        }
                    }
                }
            }
            else {
                final float x2 = motionEvent.getX();
                this.O = x2;
                this.M = x2;
                final float y2 = motionEvent.getY();
                this.P = y2;
                this.N = y2;
                this.Q = motionEvent.getPointerId(0);
                this.I = false;
                this.j = true;
                this.i.computeScrollOffset();
                if (this.p0 == 2 && Math.abs(this.i.getFinalX() - this.i.getCurrX()) > this.V) {
                    this.i.abortAnimation();
                    this.F = false;
                    this.z();
                    this.E(this.H = true);
                    this.setScrollState(1);
                }
                else {
                    this.e(false);
                    this.H = false;
                }
            }
            if (this.R == null) {
                this.R = VelocityTracker.obtain();
            }
            this.R.addMovement(motionEvent);
            return this.H;
        }
        this.F();
        return false;
    }
    
    protected void onLayout(final boolean b, int paddingTop, int paddingLeft, int paddingBottom, int paddingRight) {
        final int childCount = this.getChildCount();
        final int n = paddingBottom - paddingTop;
        final int n2 = paddingRight - paddingLeft;
        paddingLeft = this.getPaddingLeft();
        paddingTop = this.getPaddingTop();
        paddingRight = this.getPaddingRight();
        paddingBottom = this.getPaddingBottom();
        final int scrollX = this.getScrollX();
        int i = 0;
        int f0 = 0;
        while (i < childCount) {
            final View child = this.getChildAt(i);
            int n3 = paddingLeft;
            int n4 = paddingTop;
            int n5 = paddingRight;
            int n6 = paddingBottom;
            int n7 = f0;
            if (child.getVisibility() != 8) {
                final g g = (g)child.getLayoutParams();
                n3 = paddingLeft;
                n4 = paddingTop;
                n5 = paddingRight;
                n6 = paddingBottom;
                n7 = f0;
                if (g.a) {
                    final int b2 = g.b;
                    final int n8 = b2 & 0x7;
                    final int n9 = b2 & 0x70;
                    int n11 = 0;
                    Label_0246: {
                        int max;
                        if (n8 != 1) {
                            if (n8 == 3) {
                                final int n10 = child.getMeasuredWidth() + paddingLeft;
                                n11 = paddingLeft;
                                paddingLeft = n10;
                                break Label_0246;
                            }
                            if (n8 != 5) {
                                final int n12 = paddingLeft;
                                n11 = paddingLeft;
                                paddingLeft = n12;
                                break Label_0246;
                            }
                            max = n - paddingRight - child.getMeasuredWidth();
                            paddingRight += child.getMeasuredWidth();
                        }
                        else {
                            max = Math.max((n - child.getMeasuredWidth()) / 2, paddingLeft);
                        }
                        n11 = max;
                    }
                    int max2;
                    if (n9 != 16) {
                        if (n9 != 48) {
                            if (n9 != 80) {
                                final int n13 = paddingTop;
                                max2 = paddingTop;
                                paddingTop = n13;
                            }
                            else {
                                max2 = n2 - paddingBottom - child.getMeasuredHeight();
                                paddingBottom += child.getMeasuredHeight();
                            }
                        }
                        else {
                            final int n14 = child.getMeasuredHeight() + paddingTop;
                            max2 = paddingTop;
                            paddingTop = n14;
                        }
                    }
                    else {
                        max2 = Math.max((n2 - child.getMeasuredHeight()) / 2, paddingTop);
                    }
                    final int n15 = n11 + scrollX;
                    child.layout(n15, max2, child.getMeasuredWidth() + n15, max2 + child.getMeasuredHeight());
                    n7 = f0 + 1;
                    n6 = paddingBottom;
                    n5 = paddingRight;
                    n4 = paddingTop;
                    n3 = paddingLeft;
                }
            }
            ++i;
            paddingLeft = n3;
            paddingTop = n4;
            paddingRight = n5;
            paddingBottom = n6;
            f0 = n7;
        }
        for (int j = 0; j < childCount; ++j) {
            final View child2 = this.getChildAt(j);
            if (child2.getVisibility() != 8) {
                final g g2 = (g)child2.getLayoutParams();
                if (!g2.a) {
                    final f n16 = this.n(child2);
                    if (n16 != null) {
                        final float n17 = (float)(n - paddingLeft - paddingRight);
                        final int n18 = (int)(n16.e * n17) + paddingLeft;
                        if (g2.d) {
                            g2.d = false;
                            child2.measure(View$MeasureSpec.makeMeasureSpec((int)(n17 * g2.c), 1073741824), View$MeasureSpec.makeMeasureSpec(n2 - paddingTop - paddingBottom, 1073741824));
                        }
                        child2.layout(n18, paddingTop, child2.getMeasuredWidth() + n18, child2.getMeasuredHeight() + paddingTop);
                    }
                }
            }
        }
        this.x = paddingTop;
        this.y = n2 - paddingBottom;
        this.f0 = f0;
        if (this.c0) {
            this.G(this.e, false, 0, false);
        }
        this.c0 = false;
    }
    
    protected void onMeasure(int measuredWidth, int i) {
        final int n = 0;
        this.setMeasuredDimension(ViewGroup.getDefaultSize(0, measuredWidth), ViewGroup.getDefaultSize(0, i));
        measuredWidth = this.getMeasuredWidth();
        this.K = Math.min(measuredWidth / 10, this.J);
        measuredWidth = measuredWidth - this.getPaddingLeft() - this.getPaddingRight();
        i = this.getMeasuredHeight() - this.getPaddingTop() - this.getPaddingBottom();
        final int childCount = this.getChildCount();
        int n2 = 0;
        while (true) {
            final int n3 = 1;
            int n4 = 1073741824;
            if (n2 >= childCount) {
                break;
            }
            final View child = this.getChildAt(n2);
            int n5 = measuredWidth;
            int n6 = i;
            if (child.getVisibility() != 8) {
                final g g = (g)child.getLayoutParams();
                n5 = measuredWidth;
                n6 = i;
                if (g != null) {
                    n5 = measuredWidth;
                    n6 = i;
                    if (g.a) {
                        final int b = g.b;
                        final int n7 = b & 0x7;
                        final int n8 = b & 0x70;
                        final boolean b2 = n8 == 48 || n8 == 80;
                        int n9 = n3;
                        if (n7 != 3) {
                            if (n7 == 5) {
                                n9 = n3;
                            }
                            else {
                                n9 = 0;
                            }
                        }
                        int n10 = Integer.MIN_VALUE;
                        int n11;
                        if (b2) {
                            n11 = Integer.MIN_VALUE;
                            n10 = 1073741824;
                        }
                        else if (n9 != 0) {
                            n11 = 1073741824;
                        }
                        else {
                            n11 = Integer.MIN_VALUE;
                        }
                        final int width = g.width;
                        int n13;
                        int n14;
                        if (width != -2) {
                            int n12;
                            if (width != -1) {
                                n12 = width;
                            }
                            else {
                                n12 = measuredWidth;
                            }
                            n13 = 1073741824;
                            n14 = n12;
                        }
                        else {
                            n14 = measuredWidth;
                            n13 = n10;
                        }
                        final int height = g.height;
                        int n15;
                        if (height != -2) {
                            if (height != -1) {
                                n15 = height;
                            }
                            else {
                                n15 = i;
                            }
                        }
                        else {
                            final int n16 = i;
                            n4 = n11;
                            n15 = n16;
                        }
                        child.measure(View$MeasureSpec.makeMeasureSpec(n14, n13), View$MeasureSpec.makeMeasureSpec(n15, n4));
                        if (b2) {
                            n6 = i - child.getMeasuredHeight();
                            n5 = measuredWidth;
                        }
                        else {
                            n5 = measuredWidth;
                            n6 = i;
                            if (n9 != 0) {
                                n5 = measuredWidth - child.getMeasuredWidth();
                                n6 = i;
                            }
                        }
                    }
                }
            }
            ++n2;
            measuredWidth = n5;
            i = n6;
        }
        this.B = View$MeasureSpec.makeMeasureSpec(measuredWidth, 1073741824);
        this.C = View$MeasureSpec.makeMeasureSpec(i, 1073741824);
        this.D = true;
        this.z();
        this.D = false;
        int childCount2;
        View child2;
        g g2;
        for (childCount2 = this.getChildCount(), i = n; i < childCount2; ++i) {
            child2 = this.getChildAt(i);
            if (child2.getVisibility() != 8) {
                g2 = (g)child2.getLayoutParams();
                if (g2 == null || !g2.a) {
                    child2.measure(View$MeasureSpec.makeMeasureSpec((int)(measuredWidth * g2.c), 1073741824), this.C);
                }
            }
        }
    }
    
    protected boolean onRequestFocusInDescendants(final int n, final Rect rect) {
        int i = this.getChildCount();
        int n2 = -1;
        int n3;
        if ((n & 0x2) != 0x0) {
            n2 = i;
            i = 0;
            n3 = 1;
        }
        else {
            --i;
            n3 = -1;
        }
        while (i != n2) {
            final View child = this.getChildAt(i);
            if (child.getVisibility() == 0) {
                final f n4 = this.n(child);
                if (n4 != null && n4.b == this.e && child.requestFocus(n, rect)) {
                    return true;
                }
            }
            i += n3;
        }
        return false;
    }
    
    public void onRestoreInstanceState(final Parcelable parcelable) {
        if (!(parcelable instanceof SavedState)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        final SavedState savedState = (SavedState)parcelable;
        super.onRestoreInstanceState(savedState.a());
        this.f = savedState.c;
        this.g = savedState.d;
        this.h = savedState.e;
    }
    
    public Parcelable onSaveInstanceState() {
        final SavedState savedState = new SavedState(super.onSaveInstanceState());
        savedState.c = this.e;
        return (Parcelable)savedState;
    }
    
    protected void onSizeChanged(final int n, int p4, final int n2, final int n3) {
        super.onSizeChanged(n, p4, n2, n3);
        if (n != n2) {
            p4 = this.p;
            this.B(n, n2, p4, p4);
        }
    }
    
    public boolean onTouchEvent(final MotionEvent motionEvent) {
        if (this.W) {
            return true;
        }
        if (motionEvent.getAction() == 0) {
            motionEvent.getEdgeFlags();
        }
        return false;
    }
    
    f p(final int n) {
        for (int i = 0; i < this.b.size(); ++i) {
            final f f = this.b.get(i);
            if (f.b == n) {
                return f;
            }
        }
        return null;
    }
    
    void q() {
        this.setWillNotDraw(false);
        this.setDescendantFocusability(262144);
        this.setFocusable(true);
        final Context context = this.getContext();
        this.i = new Scroller(context, ViewPager.s0);
        final ViewConfiguration value = ViewConfiguration.get(context);
        final float density = context.getResources().getDisplayMetrics().density;
        this.L = value.getScaledPagingTouchSlop();
        this.S = (int)(400.0f * density);
        this.T = value.getScaledMaximumFlingVelocity();
        this.a0 = new EdgeEffect(context);
        this.b0 = new EdgeEffect(context);
        this.U = (int)(25.0f * density);
        this.V = (int)(2.0f * density);
        this.J = (int)(density * 16.0f);
        androidx.core.view.b0.p0((View)this, new h());
        if (androidx.core.view.b0.z((View)this) == 0) {
            androidx.core.view.b0.A0((View)this, 1);
        }
        androidx.core.view.b0.D0((View)this, new v(this) {
            private final Rect a = new Rect();
            final ViewPager b;
            
            @Override
            public n0 a(final View view, final n0 n0) {
                final n0 b0 = androidx.core.view.b0.b0(view, n0);
                if (b0.o()) {
                    return b0;
                }
                final Rect a = this.a;
                a.left = b0.j();
                a.top = b0.l();
                a.right = b0.k();
                a.bottom = b0.i();
                for (int i = 0; i < this.b.getChildCount(); ++i) {
                    final n0 g = androidx.core.view.b0.g(this.b.getChildAt(i), b0);
                    a.left = Math.min(g.j(), a.left);
                    a.top = Math.min(g.l(), a.top);
                    a.right = Math.min(g.k(), a.right);
                    a.bottom = Math.min(g.i(), a.bottom);
                }
                return b0.p(a.left, a.top, a.right, a.bottom);
            }
        });
    }
    
    public void removeView(final View view) {
        if (this.D) {
            this.removeViewInLayout(view);
        }
        else {
            super.removeView(view);
        }
    }
    
    public void setAdapter(final a a) {
        int i = 0;
        this.a = 0;
        final List<i> j0 = this.j0;
        if (j0 != null && !j0.isEmpty()) {
            while (i < this.j0.size()) {
                this.j0.get(i).a(this, null, a);
                ++i;
            }
        }
    }
    
    public void setCurrentItem(final int n) {
        this.F = false;
        this.I(n, this.c0 ^ true, false);
    }
    
    public void setOffscreenPageLimit(final int n) {
        int g = n;
        if (n < 1) {
            final StringBuilder sb = new StringBuilder();
            sb.append("Requested offscreen page limit ");
            sb.append(n);
            sb.append(" too small; defaulting to ");
            sb.append(1);
            Log.w("ViewPager", sb.toString());
            g = 1;
        }
        if (g != this.G) {
            this.G = g;
            this.z();
        }
    }
    
    @Deprecated
    public void setOnPageChangeListener(final j h0) {
        this.h0 = h0;
    }
    
    public void setPageMargin(final int p) {
        final int p2 = this.p;
        this.p = p;
        final int width = this.getWidth();
        this.B(width, width, p, p2);
        this.requestLayout();
    }
    
    public void setPageMarginDrawable(final int n) {
        this.setPageMarginDrawable(androidx.core.content.a.getDrawable(this.getContext(), n));
    }
    
    public void setPageMarginDrawable(final Drawable w) {
        this.w = w;
        if (w != null) {
            this.refreshDrawableState();
        }
        this.setWillNotDraw(w == null);
        this.invalidate();
    }
    
    void setScrollState(final int p) {
        if (this.p0 == p) {
            return;
        }
        this.p0 = p;
        if (this.k0 != null) {
            this.j(p != 0);
        }
        this.h(p);
    }
    
    protected void t(int i, float n, int childCount) {
        final int f0 = this.f0;
        final int n2 = 0;
        if (f0 > 0) {
            final int scrollX = this.getScrollX();
            int paddingLeft = this.getPaddingLeft();
            int paddingRight = this.getPaddingRight();
            final int width = this.getWidth();
            for (int childCount2 = this.getChildCount(), j = 0; j < childCount2; ++j) {
                final View child = this.getChildAt(j);
                final g g = (g)child.getLayoutParams();
                if (g.a) {
                    final int n3 = g.b & 0x7;
                    int max;
                    if (n3 != 1) {
                        if (n3 != 3) {
                            if (n3 != 5) {
                                final int n4 = paddingLeft;
                                max = paddingLeft;
                                paddingLeft = n4;
                            }
                            else {
                                max = width - paddingRight - child.getMeasuredWidth();
                                paddingRight += child.getMeasuredWidth();
                            }
                        }
                        else {
                            final int n5 = child.getWidth() + paddingLeft;
                            max = paddingLeft;
                            paddingLeft = n5;
                        }
                    }
                    else {
                        max = Math.max((width - child.getMeasuredWidth()) / 2, paddingLeft);
                    }
                    final int n6 = max + scrollX - child.getLeft();
                    if (n6 != 0) {
                        child.offsetLeftAndRight(n6);
                    }
                }
            }
        }
        this.f(i, n, childCount);
        if (this.k0 != null) {
            final int scrollX2 = this.getScrollX();
            View child2;
            for (childCount = this.getChildCount(), i = n2; i < childCount; ++i) {
                child2 = this.getChildAt(i);
                if (!((g)child2.getLayoutParams()).a) {
                    n = (child2.getLeft() - scrollX2) / (float)this.getClientWidth();
                    this.k0.a(child2, n);
                }
            }
        }
        this.e0 = true;
    }
    
    boolean v() {
        final int e = this.e;
        if (e > 0) {
            this.H(e - 1, true);
            return true;
        }
        return false;
    }
    
    protected boolean verifyDrawable(final Drawable drawable) {
        return super.verifyDrawable(drawable) || drawable == this.w;
    }
    
    boolean w() {
        return false;
    }
    
    void z() {
        this.A(this.e);
    }
    
    public static class SavedState extends AbsSavedState
    {
        public static final Parcelable$Creator<SavedState> CREATOR;
        int c;
        Parcelable d;
        ClassLoader e;
        
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
        
        SavedState(final Parcel parcel, final ClassLoader classLoader) {
            super(parcel, classLoader);
            ClassLoader classLoader2 = classLoader;
            if (classLoader == null) {
                classLoader2 = this.getClass().getClassLoader();
            }
            this.c = parcel.readInt();
            this.d = parcel.readParcelable(classLoader2);
            this.e = classLoader2;
        }
        
        public SavedState(final Parcelable parcelable) {
            super(parcelable);
        }
        
        @Override
        public String toString() {
            final StringBuilder sb = new StringBuilder();
            sb.append("FragmentPager.SavedState{");
            sb.append(Integer.toHexString(System.identityHashCode(this)));
            sb.append(" position=");
            sb.append(this.c);
            sb.append("}");
            return sb.toString();
        }
        
        @Override
        public void writeToParcel(final Parcel parcel, final int n) {
            super.writeToParcel(parcel, n);
            parcel.writeInt(this.c);
            parcel.writeParcelable(this.d, n);
        }
    }
    
    @Inherited
    @Retention(RetentionPolicy.RUNTIME)
    @Target({ ElementType.TYPE })
    public @interface e {
    }
    
    static class f
    {
        Object a;
        int b;
        boolean c;
        float d;
        float e;
    }
    
    public static class g extends ViewGroup$LayoutParams
    {
        public boolean a;
        public int b;
        float c;
        boolean d;
        int e;
        int f;
        
        public g() {
            super(-1, -1);
            this.c = 0.0f;
        }
        
        public g(final Context context, final AttributeSet set) {
            super(context, set);
            this.c = 0.0f;
            final TypedArray obtainStyledAttributes = context.obtainStyledAttributes(set, ViewPager.q0);
            this.b = obtainStyledAttributes.getInteger(0, 48);
            obtainStyledAttributes.recycle();
        }
    }
    
    class h extends androidx.core.view.a
    {
        final ViewPager a;
        
        h(final ViewPager a) {
            this.a = a;
        }
        
        private boolean a() {
            Objects.requireNonNull(this.a);
            return false;
        }
        
        @Override
        public void onInitializeAccessibilityEvent(final View view, final AccessibilityEvent accessibilityEvent) {
            super.onInitializeAccessibilityEvent(view, accessibilityEvent);
            accessibilityEvent.setClassName((CharSequence)ViewPager.class.getName());
            accessibilityEvent.setScrollable(this.a());
            if (accessibilityEvent.getEventType() == 4096) {
                Objects.requireNonNull(this.a);
            }
        }
        
        @Override
        public void onInitializeAccessibilityNodeInfo(final View view, final d d) {
            super.onInitializeAccessibilityNodeInfo(view, d);
            d.Q(ViewPager.class.getName());
            d.l0(this.a());
            if (this.a.canScrollHorizontally(1)) {
                d.a(4096);
            }
            if (this.a.canScrollHorizontally(-1)) {
                d.a(8192);
            }
        }
        
        @Override
        public boolean performAccessibilityAction(final View view, final int n, final Bundle bundle) {
            if (super.performAccessibilityAction(view, n, bundle)) {
                return true;
            }
            if (n != 4096) {
                if (n != 8192) {
                    return false;
                }
                if (this.a.canScrollHorizontally(-1)) {
                    final ViewPager a = this.a;
                    a.setCurrentItem(a.e - 1);
                    return true;
                }
                return false;
            }
            else {
                if (this.a.canScrollHorizontally(1)) {
                    final ViewPager a2 = this.a;
                    a2.setCurrentItem(a2.e + 1);
                    return true;
                }
                return false;
            }
        }
    }
    
    public interface i
    {
        void a(final ViewPager p0, final a p1, final a p2);
    }
    
    public interface j
    {
        void a(final int p0, final float p1, final int p2);
        
        void b(final int p0);
        
        void c(final int p0);
    }
    
    public interface k
    {
        void a(final View p0, final float p1);
    }
    
    static class l implements Comparator<View>
    {
        public int a(final View view, final View view2) {
            final g g = (g)view.getLayoutParams();
            final g g2 = (g)view2.getLayoutParams();
            final boolean a = g.a;
            if (a != g2.a) {
                int n;
                if (a) {
                    n = 1;
                }
                else {
                    n = -1;
                }
                return n;
            }
            return g.e - g2.e;
        }
        
        @Override
        public /* bridge */ int compare(final Object o, final Object o2) {
            return this.a((View)o, (View)o2);
        }
    }
}
