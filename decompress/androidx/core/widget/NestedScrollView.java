// 
// Decompiled by Procyon v0.6.0
// 

package androidx.core.widget;

import android.os.Bundle;
import androidx.core.view.accessibility.d;
import android.view.accessibility.AccessibilityRecord;
import androidx.core.view.accessibility.f;
import android.widget.ScrollView;
import android.view.accessibility.AccessibilityEvent;
import android.os.Parcel;
import android.os.Parcelable$Creator;
import android.view.View$BaseSavedState;
import android.os.Parcelable;
import android.util.Log;
import androidx.core.view.p;
import android.view.ViewGroup$MarginLayoutParams;
import android.view.View$MeasureSpec;
import android.graphics.Canvas;
import android.view.KeyEvent;
import android.view.FocusFinder;
import android.view.ViewGroup$LayoutParams;
import android.view.ViewConfiguration;
import java.util.ArrayList;
import android.util.TypedValue;
import android.widget.FrameLayout$LayoutParams;
import android.view.animation.AnimationUtils;
import android.view.MotionEvent;
import android.view.ViewParent;
import android.content.res.TypedArray;
import androidx.core.view.b0;
import android.view.ViewGroup;
import v.a;
import android.util.AttributeSet;
import android.content.Context;
import android.view.VelocityTracker;
import android.view.View;
import android.widget.EdgeEffect;
import android.widget.OverScroller;
import android.graphics.Rect;
import androidx.core.view.r;
import androidx.core.view.u;
import androidx.core.view.q;
import androidx.core.view.t;
import android.widget.FrameLayout;

public class NestedScrollView extends FrameLayout implements t, q
{
    private static final a L;
    private static final int[] M;
    private int A;
    private int B;
    private final int[] C;
    private final int[] D;
    private int E;
    private int F;
    private SavedState G;
    private final u H;
    private final r I;
    private float J;
    private c K;
    private long a;
    private final Rect b;
    private OverScroller c;
    public EdgeEffect d;
    public EdgeEffect e;
    private int f;
    private boolean g;
    private boolean h;
    private View i;
    private boolean j;
    private VelocityTracker p;
    private boolean w;
    private boolean x;
    private int y;
    private int z;
    
    static {
        L = new a();
        M = new int[] { 16843130 };
    }
    
    public NestedScrollView(final Context context, final AttributeSet set) {
        this(context, set, v.a.c);
    }
    
    public NestedScrollView(final Context context, final AttributeSet set, final int n) {
        super(context, set, n);
        this.b = new Rect();
        this.g = true;
        this.h = false;
        this.i = null;
        this.j = false;
        this.x = true;
        this.B = -1;
        this.C = new int[2];
        this.D = new int[2];
        this.d = androidx.core.widget.i.a(context, set);
        this.e = androidx.core.widget.i.a(context, set);
        this.y();
        final TypedArray obtainStyledAttributes = context.obtainStyledAttributes(set, NestedScrollView.M, n, 0);
        this.setFillViewport(obtainStyledAttributes.getBoolean(0, false));
        obtainStyledAttributes.recycle();
        this.H = new u((ViewGroup)this);
        this.I = new r((View)this);
        this.setNestedScrollingEnabled(true);
        b0.p0((View)this, NestedScrollView.L);
    }
    
    private boolean A(final View view) {
        return this.C(view, 0, this.getHeight()) ^ true;
    }
    
    private static boolean B(final View view, final View view2) {
        boolean b = true;
        if (view == view2) {
            return true;
        }
        final ViewParent parent = view.getParent();
        if (!(parent instanceof ViewGroup) || !B((View)parent, view2)) {
            b = false;
        }
        return b;
    }
    
    private boolean C(final View view, final int n, final int n2) {
        view.getDrawingRect(this.b);
        this.offsetDescendantRectToMyCoords(view, this.b);
        return this.b.bottom + n >= this.getScrollY() && this.b.top - n <= this.getScrollY() + n2;
    }
    
    private void D(final int n, final int n2, final int[] array) {
        final int scrollY = this.getScrollY();
        this.scrollBy(0, n);
        final int n3 = this.getScrollY() - scrollY;
        if (array != null) {
            array[1] += n3;
        }
        this.I.e(0, n3, 0, n - n3, null, n2, array);
    }
    
    private void E(final MotionEvent motionEvent) {
        final int actionIndex = motionEvent.getActionIndex();
        if (motionEvent.getPointerId(actionIndex) == this.B) {
            int n;
            if (actionIndex == 0) {
                n = 1;
            }
            else {
                n = 0;
            }
            this.f = (int)motionEvent.getY(n);
            this.B = motionEvent.getPointerId(n);
            final VelocityTracker p = this.p;
            if (p != null) {
                p.clear();
            }
        }
    }
    
    private void H() {
        final VelocityTracker p = this.p;
        if (p != null) {
            p.recycle();
            this.p = null;
        }
    }
    
    private int I(int round, float d) {
        final float n = d / this.getWidth();
        final float n2 = round / (float)this.getHeight();
        final float b = androidx.core.widget.i.b(this.d);
        d = 0.0f;
        if (b != 0.0f) {
            final float n3 = d = -androidx.core.widget.i.d(this.d, -n2, n);
            if (androidx.core.widget.i.b(this.d) == 0.0f) {
                this.d.onRelease();
                d = n3;
            }
        }
        else if (androidx.core.widget.i.b(this.e) != 0.0f) {
            final float n4 = d = androidx.core.widget.i.d(this.e, n2, 1.0f - n);
            if (androidx.core.widget.i.b(this.e) == 0.0f) {
                this.e.onRelease();
                d = n4;
            }
        }
        round = Math.round(d * this.getHeight());
        if (round != 0) {
            this.invalidate();
        }
        return round;
    }
    
    private void J(final boolean b) {
        if (b) {
            this.S(2, 1);
        }
        else {
            this.U(1);
        }
        this.F = this.getScrollY();
        b0.g0((View)this);
    }
    
    private boolean K(final int n, int n2, final int n3) {
        final int height = this.getHeight();
        final int scrollY = this.getScrollY();
        final int n4 = height + scrollY;
        final boolean b = false;
        final boolean b2 = n == 33;
        Object s;
        if ((s = this.s(b2, n2, n3)) == null) {
            s = this;
        }
        boolean b3;
        if (n2 >= scrollY && n3 <= n4) {
            b3 = b;
        }
        else {
            if (b2) {
                n2 -= scrollY;
            }
            else {
                n2 = n3 - n4;
            }
            this.l(n2);
            b3 = true;
        }
        if (s != this.findFocus()) {
            ((View)s).requestFocus(n);
        }
        return b3;
    }
    
    private void L(final View view) {
        view.getDrawingRect(this.b);
        this.offsetDescendantRectToMyCoords(view, this.b);
        final int f = this.f(this.b);
        if (f != 0) {
            this.scrollBy(0, f);
        }
    }
    
    private boolean M(final Rect rect, final boolean b) {
        final int f = this.f(rect);
        final boolean b2 = f != 0;
        if (b2) {
            if (b) {
                this.scrollBy(0, f);
            }
            else {
                this.N(0, f);
            }
        }
        return b2;
    }
    
    private void O(int scrollY, int max, final int n, final boolean b) {
        if (this.getChildCount() == 0) {
            return;
        }
        if (AnimationUtils.currentAnimationTimeMillis() - this.a > 250L) {
            final View child = this.getChildAt(0);
            final FrameLayout$LayoutParams frameLayout$LayoutParams = (FrameLayout$LayoutParams)child.getLayoutParams();
            final int height = child.getHeight();
            final int topMargin = frameLayout$LayoutParams.topMargin;
            final int bottomMargin = frameLayout$LayoutParams.bottomMargin;
            final int height2 = this.getHeight();
            final int paddingTop = this.getPaddingTop();
            final int paddingBottom = this.getPaddingBottom();
            scrollY = this.getScrollY();
            max = Math.max(0, Math.min(max + scrollY, Math.max(0, height + topMargin + bottomMargin - (height2 - paddingTop - paddingBottom))));
            this.c.startScroll(this.getScrollX(), scrollY, 0, max - scrollY, n);
            this.J(b);
        }
        else {
            if (!this.c.isFinished()) {
                this.a();
            }
            this.scrollBy(scrollY, max);
        }
        this.a = AnimationUtils.currentAnimationTimeMillis();
    }
    
    private boolean T(final MotionEvent motionEvent) {
        final float b = androidx.core.widget.i.b(this.d);
        final boolean b2 = true;
        boolean b3;
        if (b != 0.0f) {
            androidx.core.widget.i.d(this.d, 0.0f, motionEvent.getX() / this.getWidth());
            b3 = true;
        }
        else {
            b3 = false;
        }
        if (androidx.core.widget.i.b(this.e) != 0.0f) {
            androidx.core.widget.i.d(this.e, 0.0f, 1.0f - motionEvent.getX() / this.getWidth());
            b3 = b2;
        }
        return b3;
    }
    
    private void a() {
        this.c.abortAnimation();
        this.U(1);
    }
    
    private boolean c() {
        final int overScrollMode = this.getOverScrollMode();
        boolean b = true;
        if (overScrollMode != 0) {
            b = (overScrollMode == 1 && this.getScrollRange() > 0 && b);
        }
        return b;
    }
    
    private boolean d() {
        final int childCount = this.getChildCount();
        boolean b = false;
        if (childCount > 0) {
            final View child = this.getChildAt(0);
            final FrameLayout$LayoutParams frameLayout$LayoutParams = (FrameLayout$LayoutParams)child.getLayoutParams();
            b = b;
            if (child.getHeight() + frameLayout$LayoutParams.topMargin + frameLayout$LayoutParams.bottomMargin > this.getHeight() - this.getPaddingTop() - this.getPaddingBottom()) {
                b = true;
            }
        }
        return b;
    }
    
    private static int e(final int n, final int n2, final int n3) {
        if (n2 >= n3 || n < 0) {
            return 0;
        }
        if (n2 + n > n3) {
            return n3 - n2;
        }
        return n;
    }
    
    private float getVerticalScrollFactorCompat() {
        if (this.J == 0.0f) {
            final TypedValue typedValue = new TypedValue();
            final Context context = this.getContext();
            if (!context.getTheme().resolveAttribute(16842829, typedValue, true)) {
                throw new IllegalStateException("Expected theme to define listPreferredItemHeight.");
            }
            this.J = typedValue.getDimension(context.getResources().getDisplayMetrics());
        }
        return this.J;
    }
    
    private void l(final int n) {
        if (n != 0) {
            if (this.x) {
                this.N(0, n);
            }
            else {
                this.scrollBy(0, n);
            }
        }
    }
    
    private boolean p(final int n) {
        if (androidx.core.widget.i.b(this.d) != 0.0f) {
            this.d.onAbsorb(n);
        }
        else {
            if (androidx.core.widget.i.b(this.e) == 0.0f) {
                return false;
            }
            this.e.onAbsorb(-n);
        }
        return true;
    }
    
    private void q() {
        this.j = false;
        this.H();
        this.U(0);
        this.d.onRelease();
        this.e.onRelease();
    }
    
    private View s(final boolean b, final int n, final int n2) {
        final ArrayList focusables = this.getFocusables(2);
        final int size = focusables.size();
        View view = null;
        int i = 0;
        int n3 = 0;
        while (i < size) {
            final View view2 = (View)focusables.get(i);
            final int top = view2.getTop();
            final int bottom = view2.getBottom();
            View view3 = view;
            int n4 = n3;
            Label_0232: {
                if (n < bottom) {
                    view3 = view;
                    n4 = n3;
                    if (top < n2) {
                        final boolean b2 = n < top && bottom < n2;
                        if (view == null) {
                            view3 = view2;
                            n4 = (b2 ? 1 : 0);
                        }
                        else {
                            final boolean b3 = (b && top < view.getTop()) || (!b && bottom > view.getBottom());
                            if (n3 != 0) {
                                view3 = view;
                                n4 = n3;
                                if (!b2) {
                                    break Label_0232;
                                }
                                view3 = view;
                                n4 = n3;
                                if (!b3) {
                                    break Label_0232;
                                }
                            }
                            else {
                                if (b2) {
                                    view3 = view2;
                                    n4 = 1;
                                    break Label_0232;
                                }
                                view3 = view;
                                n4 = n3;
                                if (!b3) {
                                    break Label_0232;
                                }
                            }
                            view3 = view2;
                            n4 = n3;
                        }
                    }
                }
            }
            ++i;
            view = view3;
            n3 = n4;
        }
        return view;
    }
    
    private boolean w(final int n, final int n2) {
        final int childCount = this.getChildCount();
        boolean b2;
        final boolean b = b2 = false;
        if (childCount > 0) {
            final int scrollY = this.getScrollY();
            final View child = this.getChildAt(0);
            b2 = b;
            if (n2 >= child.getTop() - scrollY) {
                b2 = b;
                if (n2 < child.getBottom() - scrollY) {
                    b2 = b;
                    if (n >= child.getLeft()) {
                        b2 = b;
                        if (n < child.getRight()) {
                            b2 = true;
                        }
                    }
                }
            }
        }
        return b2;
    }
    
    private void x() {
        final VelocityTracker p = this.p;
        if (p == null) {
            this.p = VelocityTracker.obtain();
        }
        else {
            p.clear();
        }
    }
    
    private void y() {
        this.c = new OverScroller(this.getContext());
        this.setFocusable(true);
        this.setDescendantFocusability(262144);
        this.setWillNotDraw(false);
        final ViewConfiguration value = ViewConfiguration.get(this.getContext());
        this.y = value.getScaledTouchSlop();
        this.z = value.getScaledMinimumFlingVelocity();
        this.A = value.getScaledMaximumFlingVelocity();
    }
    
    private void z() {
        if (this.p == null) {
            this.p = VelocityTracker.obtain();
        }
    }
    
    boolean F(int n, int n2, int n3, int n4, int n5, final int n6, int n7, final int n8, final boolean b) {
        final int overScrollMode = this.getOverScrollMode();
        final int computeHorizontalScrollRange = this.computeHorizontalScrollRange();
        final int computeHorizontalScrollExtent = this.computeHorizontalScrollExtent();
        final boolean b2 = false;
        final boolean b3 = computeHorizontalScrollRange > computeHorizontalScrollExtent;
        final boolean b4 = this.computeVerticalScrollRange() > this.computeVerticalScrollExtent();
        final boolean b5 = overScrollMode == 0 || (overScrollMode == 1 && b3);
        final boolean b6 = overScrollMode == 0 || (overScrollMode == 1 && b4);
        n3 += n;
        if (!b5) {
            n = 0;
        }
        else {
            n = n7;
        }
        n4 += n2;
        if (!b6) {
            n2 = 0;
        }
        else {
            n2 = n8;
        }
        n7 = -n;
        n += n5;
        n5 = -n2;
        n2 += n6;
        boolean b7;
        if (n3 > n) {
            b7 = true;
        }
        else if (n3 < n7) {
            b7 = true;
            n = n7;
        }
        else {
            b7 = false;
            n = n3;
        }
        boolean b8;
        if (n4 > n2) {
            b8 = true;
        }
        else if (n4 < n5) {
            b8 = true;
            n2 = n5;
        }
        else {
            b8 = false;
            n2 = n4;
        }
        if (b8 && !this.v(1)) {
            this.c.springBack(n, n2, 0, 0, 0, this.getScrollRange());
        }
        this.onOverScrolled(n, n2, b7, b8);
        if (!b7) {
            final boolean b9 = b2;
            if (!b8) {
                return b9;
            }
        }
        return true;
    }
    
    public boolean G(final int n) {
        final boolean b = n == 130;
        final int height = this.getHeight();
        if (b) {
            this.b.top = this.getScrollY() + height;
            final int childCount = this.getChildCount();
            if (childCount > 0) {
                final View child = this.getChildAt(childCount - 1);
                final int n2 = child.getBottom() + ((FrameLayout$LayoutParams)child.getLayoutParams()).bottomMargin + this.getPaddingBottom();
                final Rect b2 = this.b;
                if (b2.top + height > n2) {
                    b2.top = n2 - height;
                }
            }
        }
        else {
            this.b.top = this.getScrollY() - height;
            final Rect b3 = this.b;
            if (b3.top < 0) {
                b3.top = 0;
            }
        }
        final Rect b4 = this.b;
        final int top = b4.top;
        final int bottom = height + top;
        b4.bottom = bottom;
        return this.K(n, top, bottom);
    }
    
    public final void N(final int n, final int n2) {
        this.O(n, n2, 250, false);
    }
    
    public final void P(final int n, final int n2) {
        this.Q(n, n2, 250, false);
    }
    
    void Q(final int n, final int n2, final int n3, final boolean b) {
        this.O(n - this.getScrollX(), n2 - this.getScrollY(), n3, b);
    }
    
    void R(final int n, final int n2, final boolean b) {
        this.Q(n, n2, 250, b);
    }
    
    public boolean S(final int n, final int n2) {
        return this.I.q(n, n2);
    }
    
    public void U(final int n) {
        this.I.s(n);
    }
    
    public void addView(final View view) {
        if (this.getChildCount() <= 0) {
            super.addView(view);
            return;
        }
        throw new IllegalStateException("ScrollView can host only one direct child");
    }
    
    public void addView(final View view, final int n) {
        if (this.getChildCount() <= 0) {
            super.addView(view, n);
            return;
        }
        throw new IllegalStateException("ScrollView can host only one direct child");
    }
    
    public void addView(final View view, final int n, final ViewGroup$LayoutParams viewGroup$LayoutParams) {
        if (this.getChildCount() <= 0) {
            super.addView(view, n, viewGroup$LayoutParams);
            return;
        }
        throw new IllegalStateException("ScrollView can host only one direct child");
    }
    
    public void addView(final View view, final ViewGroup$LayoutParams viewGroup$LayoutParams) {
        if (this.getChildCount() <= 0) {
            super.addView(view, viewGroup$LayoutParams);
            return;
        }
        throw new IllegalStateException("ScrollView can host only one direct child");
    }
    
    public boolean b(int descendantFocusability) {
        View focus;
        if ((focus = this.findFocus()) == this) {
            focus = null;
        }
        final View nextFocus = FocusFinder.getInstance().findNextFocus((ViewGroup)this, focus, descendantFocusability);
        final int maxScrollAmount = this.getMaxScrollAmount();
        if (nextFocus != null && this.C(nextFocus, maxScrollAmount, this.getHeight())) {
            nextFocus.getDrawingRect(this.b);
            this.offsetDescendantRectToMyCoords(nextFocus, this.b);
            this.l(this.f(this.b));
            nextFocus.requestFocus(descendantFocusability);
        }
        else {
            int n;
            if (descendantFocusability == 33 && this.getScrollY() < maxScrollAmount) {
                n = this.getScrollY();
            }
            else {
                n = maxScrollAmount;
                if (descendantFocusability == 130) {
                    n = maxScrollAmount;
                    if (this.getChildCount() > 0) {
                        final View child = this.getChildAt(0);
                        n = Math.min(child.getBottom() + ((FrameLayout$LayoutParams)child.getLayoutParams()).bottomMargin - (this.getScrollY() + this.getHeight() - this.getPaddingBottom()), maxScrollAmount);
                    }
                }
            }
            if (n == 0) {
                return false;
            }
            if (descendantFocusability != 130) {
                n = -n;
            }
            this.l(n);
        }
        if (focus != null && focus.isFocused() && this.A(focus)) {
            descendantFocusability = this.getDescendantFocusability();
            this.setDescendantFocusability(131072);
            this.requestFocus();
            this.setDescendantFocusability(descendantFocusability);
        }
        return true;
    }
    
    public int computeHorizontalScrollExtent() {
        return super.computeHorizontalScrollExtent();
    }
    
    public int computeHorizontalScrollOffset() {
        return super.computeHorizontalScrollOffset();
    }
    
    public int computeHorizontalScrollRange() {
        return super.computeHorizontalScrollRange();
    }
    
    public void computeScroll() {
        if (this.c.isFinished()) {
            return;
        }
        this.c.computeScrollOffset();
        final int currY = this.c.getCurrY();
        final int n = currY - this.F;
        this.F = currY;
        final int[] d = this.D;
        final boolean b = false;
        this.g(d[1] = 0, n, d, null, 1);
        final int n2 = n - this.D[1];
        final int scrollRange = this.getScrollRange();
        int n3;
        if ((n3 = n2) != 0) {
            final int scrollY = this.getScrollY();
            this.F(0, n2, this.getScrollX(), scrollY, 0, scrollRange, 0, 0, false);
            final int n4 = this.getScrollY() - scrollY;
            final int n5 = n2 - n4;
            final int[] d2 = this.D;
            this.h(d2[1] = 0, n4, 0, n5, this.C, 1, d2);
            n3 = n5 - this.D[1];
        }
        if (n3 != 0) {
            final int overScrollMode = this.getOverScrollMode();
            int n6 = 0;
            Label_0185: {
                if (overScrollMode != 0) {
                    n6 = (b ? 1 : 0);
                    if (overScrollMode != 1) {
                        break Label_0185;
                    }
                    n6 = (b ? 1 : 0);
                    if (scrollRange <= 0) {
                        break Label_0185;
                    }
                }
                n6 = 1;
            }
            if (n6 != 0) {
                if (n3 < 0) {
                    if (this.d.isFinished()) {
                        this.d.onAbsorb((int)this.c.getCurrVelocity());
                    }
                }
                else if (this.e.isFinished()) {
                    this.e.onAbsorb((int)this.c.getCurrVelocity());
                }
            }
            this.a();
        }
        if (!this.c.isFinished()) {
            b0.g0((View)this);
        }
        else {
            this.U(1);
        }
    }
    
    public int computeVerticalScrollExtent() {
        return super.computeVerticalScrollExtent();
    }
    
    public int computeVerticalScrollOffset() {
        return Math.max(0, super.computeVerticalScrollOffset());
    }
    
    public int computeVerticalScrollRange() {
        final int childCount = this.getChildCount();
        final int n = this.getHeight() - this.getPaddingBottom() - this.getPaddingTop();
        if (childCount == 0) {
            return n;
        }
        final View child = this.getChildAt(0);
        final int n2 = child.getBottom() + ((FrameLayout$LayoutParams)child.getLayoutParams()).bottomMargin;
        final int scrollY = this.getScrollY();
        final int max = Math.max(0, n2 - n);
        int n3;
        if (scrollY < 0) {
            n3 = n2 - scrollY;
        }
        else {
            n3 = n2;
            if (scrollY > max) {
                n3 = n2 + (scrollY - max);
            }
        }
        return n3;
    }
    
    public boolean dispatchKeyEvent(final KeyEvent keyEvent) {
        return super.dispatchKeyEvent(keyEvent) || this.r(keyEvent);
    }
    
    public boolean dispatchNestedFling(final float n, final float n2, final boolean b) {
        return this.I.a(n, n2, b);
    }
    
    public boolean dispatchNestedPreFling(final float n, final float n2) {
        return this.I.b(n, n2);
    }
    
    public boolean dispatchNestedPreScroll(final int n, final int n2, final int[] array, final int[] array2) {
        return this.g(n, n2, array, array2, 0);
    }
    
    public boolean dispatchNestedScroll(final int n, final int n2, final int n3, final int n4, final int[] array) {
        return this.I.f(n, n2, n3, n4, array);
    }
    
    public void draw(final Canvas canvas) {
        super.draw(canvas);
        final int scrollY = this.getScrollY();
        final boolean finished = this.d.isFinished();
        final int n = 0;
        if (!finished) {
            final int save = canvas.save();
            int width = this.getWidth();
            final int height = this.getHeight();
            final int min = Math.min(0, scrollY);
            int n2;
            if (NestedScrollView.b.a((ViewGroup)this)) {
                width -= this.getPaddingLeft() + this.getPaddingRight();
                n2 = this.getPaddingLeft() + 0;
            }
            else {
                n2 = 0;
            }
            int n3 = height;
            int n4 = min;
            if (NestedScrollView.b.a((ViewGroup)this)) {
                n3 = height - (this.getPaddingTop() + this.getPaddingBottom());
                n4 = min + this.getPaddingTop();
            }
            canvas.translate((float)n2, (float)n4);
            this.d.setSize(width, n3);
            if (this.d.draw(canvas)) {
                b0.g0((View)this);
            }
            canvas.restoreToCount(save);
        }
        if (!this.e.isFinished()) {
            final int save2 = canvas.save();
            final int width2 = this.getWidth();
            final int height2 = this.getHeight();
            final int n5 = Math.max(this.getScrollRange(), scrollY) + height2;
            int n6 = n;
            int n7 = width2;
            if (NestedScrollView.b.a((ViewGroup)this)) {
                n7 = width2 - (this.getPaddingLeft() + this.getPaddingRight());
                n6 = 0 + this.getPaddingLeft();
            }
            int n8 = n5;
            int n9 = height2;
            if (NestedScrollView.b.a((ViewGroup)this)) {
                n9 = height2 - (this.getPaddingTop() + this.getPaddingBottom());
                n8 = n5 - this.getPaddingBottom();
            }
            canvas.translate((float)(n6 - n7), (float)n8);
            canvas.rotate(180.0f, (float)n7, 0.0f);
            this.e.setSize(n7, n9);
            if (this.e.draw(canvas)) {
                b0.g0((View)this);
            }
            canvas.restoreToCount(save2);
        }
    }
    
    protected int f(final Rect rect) {
        final int childCount = this.getChildCount();
        final boolean b = false;
        if (childCount == 0) {
            return 0;
        }
        final int height = this.getHeight();
        final int scrollY = this.getScrollY();
        final int n = scrollY + height;
        final int verticalFadingEdgeLength = this.getVerticalFadingEdgeLength();
        int n2 = scrollY;
        if (rect.top > 0) {
            n2 = scrollY + verticalFadingEdgeLength;
        }
        final View child = this.getChildAt(0);
        final FrameLayout$LayoutParams frameLayout$LayoutParams = (FrameLayout$LayoutParams)child.getLayoutParams();
        int n3;
        if (rect.bottom < child.getHeight() + frameLayout$LayoutParams.topMargin + frameLayout$LayoutParams.bottomMargin) {
            n3 = n - verticalFadingEdgeLength;
        }
        else {
            n3 = n;
        }
        final int bottom = rect.bottom;
        int n5;
        if (bottom > n3 && rect.top > n2) {
            int n4;
            if (rect.height() > height) {
                n4 = rect.top - n2;
            }
            else {
                n4 = rect.bottom - n3;
            }
            n5 = Math.min(n4 + 0, child.getBottom() + frameLayout$LayoutParams.bottomMargin - n);
        }
        else {
            n5 = (b ? 1 : 0);
            if (rect.top < n2) {
                n5 = (b ? 1 : 0);
                if (bottom < n3) {
                    int n6;
                    if (rect.height() > height) {
                        n6 = 0 - (n3 - rect.bottom);
                    }
                    else {
                        n6 = 0 - (n2 - rect.top);
                    }
                    n5 = Math.max(n6, -this.getScrollY());
                }
            }
        }
        return n5;
    }
    
    public boolean g(final int n, final int n2, final int[] array, final int[] array2, final int n3) {
        return this.I.d(n, n2, array, array2, n3);
    }
    
    protected float getBottomFadingEdgeStrength() {
        if (this.getChildCount() == 0) {
            return 0.0f;
        }
        final View child = this.getChildAt(0);
        final FrameLayout$LayoutParams frameLayout$LayoutParams = (FrameLayout$LayoutParams)child.getLayoutParams();
        final int verticalFadingEdgeLength = this.getVerticalFadingEdgeLength();
        final int n = child.getBottom() + frameLayout$LayoutParams.bottomMargin - this.getScrollY() - (this.getHeight() - this.getPaddingBottom());
        if (n < verticalFadingEdgeLength) {
            return n / (float)verticalFadingEdgeLength;
        }
        return 1.0f;
    }
    
    public int getMaxScrollAmount() {
        return (int)(this.getHeight() * 0.5f);
    }
    
    public int getNestedScrollAxes() {
        return this.H.a();
    }
    
    int getScrollRange() {
        final int childCount = this.getChildCount();
        int max = 0;
        if (childCount > 0) {
            final View child = this.getChildAt(0);
            final FrameLayout$LayoutParams frameLayout$LayoutParams = (FrameLayout$LayoutParams)child.getLayoutParams();
            max = Math.max(0, child.getHeight() + frameLayout$LayoutParams.topMargin + frameLayout$LayoutParams.bottomMargin - (this.getHeight() - this.getPaddingTop() - this.getPaddingBottom()));
        }
        return max;
    }
    
    protected float getTopFadingEdgeStrength() {
        if (this.getChildCount() == 0) {
            return 0.0f;
        }
        final int verticalFadingEdgeLength = this.getVerticalFadingEdgeLength();
        final int scrollY = this.getScrollY();
        if (scrollY < verticalFadingEdgeLength) {
            return scrollY / (float)verticalFadingEdgeLength;
        }
        return 1.0f;
    }
    
    public void h(final int n, final int n2, final int n3, final int n4, final int[] array, final int n5, final int[] array2) {
        this.I.e(n, n2, n3, n4, array, n5, array2);
    }
    
    public boolean hasNestedScrollingParent() {
        return this.v(0);
    }
    
    public void i(final View view, final View view2, final int n, final int n2) {
        this.H.c(view, view2, n, n2);
        this.S(2, n2);
    }
    
    public boolean isNestedScrollingEnabled() {
        return this.I.m();
    }
    
    public void j(final View view, final int n) {
        this.H.e(view, n);
        this.U(n);
    }
    
    public void k(final View view, final int n, final int n2, final int[] array, final int n3) {
        this.g(n, n2, array, null, n3);
    }
    
    public void m(final View view, final int n, final int n2, final int n3, final int n4, final int n5, final int[] array) {
        this.D(n4, n5, array);
    }
    
    protected void measureChild(final View view, final int n, final int n2) {
        view.measure(FrameLayout.getChildMeasureSpec(n, this.getPaddingLeft() + this.getPaddingRight(), view.getLayoutParams().width), View$MeasureSpec.makeMeasureSpec(0, 0));
    }
    
    protected void measureChildWithMargins(final View view, final int n, final int n2, final int n3, final int n4) {
        final ViewGroup$MarginLayoutParams viewGroup$MarginLayoutParams = (ViewGroup$MarginLayoutParams)view.getLayoutParams();
        view.measure(FrameLayout.getChildMeasureSpec(n, this.getPaddingLeft() + this.getPaddingRight() + viewGroup$MarginLayoutParams.leftMargin + viewGroup$MarginLayoutParams.rightMargin + n2, viewGroup$MarginLayoutParams.width), View$MeasureSpec.makeMeasureSpec(viewGroup$MarginLayoutParams.topMargin + viewGroup$MarginLayoutParams.bottomMargin, 0));
    }
    
    public void n(final View view, final int n, final int n2, final int n3, final int n4, final int n5) {
        this.D(n4, n5, null);
    }
    
    public boolean o(final View view, final View view2, final int n, final int n2) {
        return (n & 0x2) != 0x0;
    }
    
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.h = false;
    }
    
    public boolean onGenericMotionEvent(final MotionEvent motionEvent) {
        final int action = motionEvent.getAction();
        final int n = 0;
        boolean b = false;
        if (action == 8 && !this.j) {
            float n2;
            if (androidx.core.view.p.a(motionEvent, 2)) {
                n2 = motionEvent.getAxisValue(9);
            }
            else if (androidx.core.view.p.a(motionEvent, 4194304)) {
                n2 = motionEvent.getAxisValue(26);
            }
            else {
                n2 = 0.0f;
            }
            if (n2 != 0.0f) {
                final int n3 = (int)(n2 * this.getVerticalScrollFactorCompat());
                final int scrollRange = this.getScrollRange();
                final int scrollY = this.getScrollY();
                final int n4 = scrollY - n3;
                int n5;
                if (n4 < 0) {
                    if (this.c() && !androidx.core.view.p.a(motionEvent, 8194)) {
                        androidx.core.widget.i.d(this.d, -(float)n4 / this.getHeight(), 0.5f);
                        this.d.onRelease();
                        this.invalidate();
                        b = true;
                        n5 = n;
                    }
                    else {
                        b = false;
                        n5 = n;
                    }
                }
                else if (n4 > scrollRange) {
                    if (this.c() && !androidx.core.view.p.a(motionEvent, 8194)) {
                        androidx.core.widget.i.d(this.e, (n4 - scrollRange) / (float)this.getHeight(), 0.5f);
                        this.e.onRelease();
                        this.invalidate();
                        b = true;
                    }
                    n5 = scrollRange;
                }
                else {
                    b = false;
                    n5 = n4;
                }
                if (n5 != scrollY) {
                    super.scrollTo(this.getScrollX(), n5);
                    return true;
                }
                return b;
            }
        }
        return false;
    }
    
    public boolean onInterceptTouchEvent(final MotionEvent motionEvent) {
        final int action = motionEvent.getAction();
        final boolean b = true;
        final boolean b2 = true;
        if (action == 2 && this.j) {
            return true;
        }
        final int n = action & 0xFF;
        if (n != 0) {
            if (n != 1) {
                if (n != 2) {
                    if (n != 3) {
                        if (n != 6) {
                            return this.j;
                        }
                        this.E(motionEvent);
                        return this.j;
                    }
                }
                else {
                    final int b3 = this.B;
                    if (b3 == -1) {
                        return this.j;
                    }
                    final int pointerIndex = motionEvent.findPointerIndex(b3);
                    if (pointerIndex == -1) {
                        final StringBuilder sb = new StringBuilder();
                        sb.append("Invalid pointerId=");
                        sb.append(b3);
                        sb.append(" in onInterceptTouchEvent");
                        Log.e("NestedScrollView", sb.toString());
                        return this.j;
                    }
                    final int f = (int)motionEvent.getY(pointerIndex);
                    if (Math.abs(f - this.f) <= this.y || (0x2 & this.getNestedScrollAxes()) != 0x0) {
                        return this.j;
                    }
                    this.j = true;
                    this.f = f;
                    this.z();
                    this.p.addMovement(motionEvent);
                    this.E = 0;
                    final ViewParent parent = this.getParent();
                    if (parent != null) {
                        parent.requestDisallowInterceptTouchEvent(true);
                        return this.j;
                    }
                    return this.j;
                }
            }
            this.j = false;
            this.B = -1;
            this.H();
            if (this.c.springBack(this.getScrollX(), this.getScrollY(), 0, 0, 0, this.getScrollRange())) {
                b0.g0((View)this);
            }
            this.U(0);
        }
        else {
            final int f2 = (int)motionEvent.getY();
            if (!this.w((int)motionEvent.getX(), f2)) {
                boolean j = b2;
                if (!this.T(motionEvent)) {
                    j = (!this.c.isFinished() && b2);
                }
                this.j = j;
                this.H();
            }
            else {
                this.f = f2;
                this.B = motionEvent.getPointerId(0);
                this.x();
                this.p.addMovement(motionEvent);
                this.c.computeScrollOffset();
                boolean i = b;
                if (!this.T(motionEvent)) {
                    i = (!this.c.isFinished() && b);
                }
                this.j = i;
                this.S(2, 0);
            }
        }
        return this.j;
    }
    
    protected void onLayout(final boolean b, int e, final int n, int scrollY, final int n2) {
        super.onLayout(b, e, n, scrollY, n2);
        e = 0;
        this.g = false;
        final View i = this.i;
        if (i != null && B(i, (View)this)) {
            this.L(this.i);
        }
        this.i = null;
        if (!this.h) {
            if (this.G != null) {
                this.scrollTo(this.getScrollX(), this.G.a);
                this.G = null;
            }
            if (this.getChildCount() > 0) {
                final View child = this.getChildAt(0);
                final FrameLayout$LayoutParams frameLayout$LayoutParams = (FrameLayout$LayoutParams)child.getLayoutParams();
                e = child.getMeasuredHeight() + frameLayout$LayoutParams.topMargin + frameLayout$LayoutParams.bottomMargin;
            }
            final int paddingTop = this.getPaddingTop();
            final int paddingBottom = this.getPaddingBottom();
            scrollY = this.getScrollY();
            e = e(scrollY, n2 - n - paddingTop - paddingBottom, e);
            if (e != scrollY) {
                this.scrollTo(this.getScrollX(), e);
            }
        }
        this.scrollTo(this.getScrollX(), this.getScrollY());
        this.h = true;
    }
    
    protected void onMeasure(final int n, int measuredHeight) {
        super.onMeasure(n, measuredHeight);
        if (!this.w) {
            return;
        }
        if (View$MeasureSpec.getMode(measuredHeight) == 0) {
            return;
        }
        if (this.getChildCount() > 0) {
            final View child = this.getChildAt(0);
            final FrameLayout$LayoutParams frameLayout$LayoutParams = (FrameLayout$LayoutParams)child.getLayoutParams();
            measuredHeight = child.getMeasuredHeight();
            final int n2 = this.getMeasuredHeight() - this.getPaddingTop() - this.getPaddingBottom() - frameLayout$LayoutParams.topMargin - frameLayout$LayoutParams.bottomMargin;
            if (measuredHeight < n2) {
                child.measure(FrameLayout.getChildMeasureSpec(n, this.getPaddingLeft() + this.getPaddingRight() + frameLayout$LayoutParams.leftMargin + frameLayout$LayoutParams.rightMargin, frameLayout$LayoutParams.width), View$MeasureSpec.makeMeasureSpec(n2, 1073741824));
            }
        }
    }
    
    public boolean onNestedFling(final View view, final float n, final float n2, final boolean b) {
        if (!b) {
            this.dispatchNestedFling(0.0f, n2, true);
            this.t((int)n2);
            return true;
        }
        return false;
    }
    
    public boolean onNestedPreFling(final View view, final float n, final float n2) {
        return this.dispatchNestedPreFling(n, n2);
    }
    
    public void onNestedPreScroll(final View view, final int n, final int n2, final int[] array) {
        this.k(view, n, n2, array, 0);
    }
    
    public void onNestedScroll(final View view, final int n, final int n2, final int n3, final int n4) {
        this.D(n4, 0, null);
    }
    
    public void onNestedScrollAccepted(final View view, final View view2, final int n) {
        this.i(view, view2, n, 0);
    }
    
    protected void onOverScrolled(final int n, final int n2, final boolean b, final boolean b2) {
        super.scrollTo(n, n2);
    }
    
    protected boolean onRequestFocusInDescendants(final int n, final Rect rect) {
        int n2;
        if (n == 2) {
            n2 = 130;
        }
        else if ((n2 = n) == 1) {
            n2 = 33;
        }
        View view;
        if (rect == null) {
            view = FocusFinder.getInstance().findNextFocus((ViewGroup)this, (View)null, n2);
        }
        else {
            view = FocusFinder.getInstance().findNextFocusFromRect((ViewGroup)this, rect, n2);
        }
        return view != null && !this.A(view) && view.requestFocus(n2, rect);
    }
    
    protected void onRestoreInstanceState(final Parcelable parcelable) {
        if (!(parcelable instanceof SavedState)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        final SavedState g = (SavedState)parcelable;
        super.onRestoreInstanceState(g.getSuperState());
        this.G = g;
        this.requestLayout();
    }
    
    protected Parcelable onSaveInstanceState() {
        final SavedState savedState = new SavedState(super.onSaveInstanceState());
        savedState.a = this.getScrollY();
        return (Parcelable)savedState;
    }
    
    protected void onScrollChanged(final int n, final int n2, final int n3, final int n4) {
        super.onScrollChanged(n, n2, n3, n4);
        final c k = this.K;
        if (k != null) {
            k.a(this, n, n2, n3, n4);
        }
    }
    
    protected void onSizeChanged(final int n, final int n2, final int n3, final int n4) {
        super.onSizeChanged(n, n2, n3, n4);
        final View focus = this.findFocus();
        if (focus != null) {
            if (this != focus) {
                if (this.C(focus, 0, n4)) {
                    focus.getDrawingRect(this.b);
                    this.offsetDescendantRectToMyCoords(focus, this.b);
                    this.l(this.f(this.b));
                }
            }
        }
    }
    
    public boolean onStartNestedScroll(final View view, final View view2, final int n) {
        return this.o(view, view2, n, 0);
    }
    
    public void onStopNestedScroll(final View view) {
        this.j(view, 0);
    }
    
    public boolean onTouchEvent(final MotionEvent motionEvent) {
        this.z();
        final int actionMasked = motionEvent.getActionMasked();
        final int n = 0;
        if (actionMasked == 0) {
            this.E = 0;
        }
        final MotionEvent obtain = MotionEvent.obtain(motionEvent);
        obtain.offsetLocation(0.0f, (float)this.E);
        if (actionMasked != 0) {
            if (actionMasked != 1) {
                if (actionMasked != 2) {
                    if (actionMasked != 3) {
                        if (actionMasked != 5) {
                            if (actionMasked == 6) {
                                this.E(motionEvent);
                                this.f = (int)motionEvent.getY(motionEvent.findPointerIndex(this.B));
                            }
                        }
                        else {
                            final int actionIndex = motionEvent.getActionIndex();
                            this.f = (int)motionEvent.getY(actionIndex);
                            this.B = motionEvent.getPointerId(actionIndex);
                        }
                    }
                    else {
                        if (this.j && this.getChildCount() > 0 && this.c.springBack(this.getScrollX(), this.getScrollY(), 0, 0, 0, this.getScrollRange())) {
                            b0.g0((View)this);
                        }
                        this.B = -1;
                        this.q();
                    }
                }
                else {
                    final int pointerIndex = motionEvent.findPointerIndex(this.B);
                    if (pointerIndex == -1) {
                        final StringBuilder sb = new StringBuilder();
                        sb.append("Invalid pointerId=");
                        sb.append(this.B);
                        sb.append(" in onTouchEvent");
                        Log.e("NestedScrollView", sb.toString());
                    }
                    else {
                        final int n2 = (int)motionEvent.getY(pointerIndex);
                        final int n3 = this.f - n2;
                        int n5;
                        final int n4 = n5 = n3 - this.I(n3, motionEvent.getX(pointerIndex));
                        if (!this.j) {
                            n5 = n4;
                            if (Math.abs(n4) > this.y) {
                                final ViewParent parent = this.getParent();
                                if (parent != null) {
                                    parent.requestDisallowInterceptTouchEvent(true);
                                }
                                this.j = true;
                                if (n4 > 0) {
                                    n5 = n4 - this.y;
                                }
                                else {
                                    n5 = n4 + this.y;
                                }
                            }
                        }
                        if (this.j) {
                            int n6 = n5;
                            if (this.g(0, n5, this.D, this.C, 0)) {
                                n6 = n5 - this.D[1];
                                this.E += this.C[1];
                            }
                            this.f = n2 - this.C[1];
                            final int scrollY = this.getScrollY();
                            final int scrollRange = this.getScrollRange();
                            final int overScrollMode = this.getOverScrollMode();
                            final boolean b = overScrollMode == 0 || (overScrollMode == 1 && scrollRange > 0);
                            int n7;
                            if (this.F(0, n6, 0, this.getScrollY(), 0, scrollRange, 0, 0, true) && !this.v(0)) {
                                n7 = 1;
                            }
                            else {
                                n7 = 0;
                            }
                            final int n8 = this.getScrollY() - scrollY;
                            final int[] d = this.D;
                            this.h(d[1] = 0, n8, 0, n6 - n8, this.C, 0, d);
                            final int f = this.f;
                            final int[] c = this.C;
                            this.f = f - c[1];
                            this.E += c[1];
                            if (b) {
                                final int n9 = n6 - this.D[1];
                                final int n10 = scrollY + n9;
                                if (n10 < 0) {
                                    androidx.core.widget.i.d(this.d, -n9 / (float)this.getHeight(), motionEvent.getX(pointerIndex) / this.getWidth());
                                    if (!this.e.isFinished()) {
                                        this.e.onRelease();
                                    }
                                }
                                else if (n10 > scrollRange) {
                                    androidx.core.widget.i.d(this.e, n9 / (float)this.getHeight(), 1.0f - motionEvent.getX(pointerIndex) / this.getWidth());
                                    if (!this.d.isFinished()) {
                                        this.d.onRelease();
                                    }
                                }
                                if (!this.d.isFinished() || !this.e.isFinished()) {
                                    b0.g0((View)this);
                                    n7 = n;
                                }
                            }
                            if (n7 != 0) {
                                this.p.clear();
                            }
                        }
                    }
                }
            }
            else {
                final VelocityTracker p = this.p;
                p.computeCurrentVelocity(1000, (float)this.A);
                final int n11 = (int)p.getYVelocity(this.B);
                if (Math.abs(n11) >= this.z) {
                    if (!this.p(n11)) {
                        final int n12 = -n11;
                        final float n13 = (float)n12;
                        if (!this.dispatchNestedPreFling(0.0f, n13)) {
                            this.dispatchNestedFling(0.0f, n13, true);
                            this.t(n12);
                        }
                    }
                }
                else if (this.c.springBack(this.getScrollX(), this.getScrollY(), 0, 0, 0, this.getScrollRange())) {
                    b0.g0((View)this);
                }
                this.B = -1;
                this.q();
            }
        }
        else {
            if (this.getChildCount() == 0) {
                return false;
            }
            if (this.j) {
                final ViewParent parent2 = this.getParent();
                if (parent2 != null) {
                    parent2.requestDisallowInterceptTouchEvent(true);
                }
            }
            if (!this.c.isFinished()) {
                this.a();
            }
            this.f = (int)motionEvent.getY();
            this.B = motionEvent.getPointerId(0);
            this.S(2, 0);
        }
        final VelocityTracker p2 = this.p;
        if (p2 != null) {
            p2.addMovement(obtain);
        }
        obtain.recycle();
        return true;
    }
    
    public boolean r(final KeyEvent keyEvent) {
        this.b.setEmpty();
        final boolean d = this.d();
        final boolean b = false;
        final boolean b2 = false;
        int n = 130;
        if (!d) {
            boolean b3 = b2;
            if (this.isFocused()) {
                b3 = b2;
                if (keyEvent.getKeyCode() != 4) {
                    View focus;
                    if ((focus = this.findFocus()) == this) {
                        focus = null;
                    }
                    final View nextFocus = FocusFinder.getInstance().findNextFocus((ViewGroup)this, focus, 130);
                    b3 = b2;
                    if (nextFocus != null) {
                        b3 = b2;
                        if (nextFocus != this) {
                            b3 = b2;
                            if (nextFocus.requestFocus(130)) {
                                b3 = true;
                            }
                        }
                    }
                }
            }
            return b3;
        }
        boolean b4 = b;
        if (keyEvent.getAction() == 0) {
            final int keyCode = keyEvent.getKeyCode();
            if (keyCode != 19) {
                if (keyCode != 20) {
                    if (keyCode != 62) {
                        b4 = b;
                    }
                    else {
                        if (keyEvent.isShiftPressed()) {
                            n = 33;
                        }
                        this.G(n);
                        b4 = b;
                    }
                }
                else if (!keyEvent.isAltPressed()) {
                    b4 = this.b(130);
                }
                else {
                    b4 = this.u(130);
                }
            }
            else if (!keyEvent.isAltPressed()) {
                b4 = this.b(33);
            }
            else {
                b4 = this.u(33);
            }
        }
        return b4;
    }
    
    public void requestChildFocus(final View view, final View i) {
        if (!this.g) {
            this.L(i);
        }
        else {
            this.i = i;
        }
        super.requestChildFocus(view, i);
    }
    
    public boolean requestChildRectangleOnScreen(final View view, final Rect rect, final boolean b) {
        rect.offset(view.getLeft() - view.getScrollX(), view.getTop() - view.getScrollY());
        return this.M(rect, b);
    }
    
    public void requestDisallowInterceptTouchEvent(final boolean b) {
        if (b) {
            this.H();
        }
        super.requestDisallowInterceptTouchEvent(b);
    }
    
    public void requestLayout() {
        this.g = true;
        super.requestLayout();
    }
    
    public void scrollTo(int e, int e2) {
        if (this.getChildCount() > 0) {
            final View child = this.getChildAt(0);
            final FrameLayout$LayoutParams frameLayout$LayoutParams = (FrameLayout$LayoutParams)child.getLayoutParams();
            final int width = this.getWidth();
            final int paddingLeft = this.getPaddingLeft();
            final int paddingRight = this.getPaddingRight();
            final int width2 = child.getWidth();
            final int leftMargin = frameLayout$LayoutParams.leftMargin;
            final int rightMargin = frameLayout$LayoutParams.rightMargin;
            final int height = this.getHeight();
            final int paddingTop = this.getPaddingTop();
            final int paddingBottom = this.getPaddingBottom();
            final int height2 = child.getHeight();
            final int topMargin = frameLayout$LayoutParams.topMargin;
            final int bottomMargin = frameLayout$LayoutParams.bottomMargin;
            e = e(e, width - paddingLeft - paddingRight, width2 + leftMargin + rightMargin);
            e2 = e(e2, height - paddingTop - paddingBottom, height2 + topMargin + bottomMargin);
            if (e != this.getScrollX() || e2 != this.getScrollY()) {
                super.scrollTo(e, e2);
            }
        }
    }
    
    public void setFillViewport(final boolean w) {
        if (w != this.w) {
            this.w = w;
            this.requestLayout();
        }
    }
    
    public void setNestedScrollingEnabled(final boolean b) {
        this.I.n(b);
    }
    
    public void setOnScrollChangeListener(final c k) {
        this.K = k;
    }
    
    public void setSmoothScrollingEnabled(final boolean x) {
        this.x = x;
    }
    
    public boolean shouldDelayChildPressedState() {
        return true;
    }
    
    public boolean startNestedScroll(final int n) {
        return this.S(n, 0);
    }
    
    public void stopNestedScroll() {
        this.U(0);
    }
    
    public void t(final int n) {
        if (this.getChildCount() > 0) {
            this.c.fling(this.getScrollX(), this.getScrollY(), 0, n, 0, 0, Integer.MIN_VALUE, Integer.MAX_VALUE, 0, 0);
            this.J(true);
        }
    }
    
    public boolean u(final int n) {
        final boolean b = n == 130;
        final int height = this.getHeight();
        final Rect b2 = this.b;
        b2.top = 0;
        b2.bottom = height;
        if (b) {
            final int childCount = this.getChildCount();
            if (childCount > 0) {
                final View child = this.getChildAt(childCount - 1);
                this.b.bottom = child.getBottom() + ((FrameLayout$LayoutParams)child.getLayoutParams()).bottomMargin + this.getPaddingBottom();
                final Rect b3 = this.b;
                b3.top = b3.bottom - height;
            }
        }
        final Rect b4 = this.b;
        return this.K(n, b4.top, b4.bottom);
    }
    
    public boolean v(final int n) {
        return this.I.l(n);
    }
    
    static class SavedState extends View$BaseSavedState
    {
        public static final Parcelable$Creator<SavedState> CREATOR;
        public int a;
        
        static {
            CREATOR = (Parcelable$Creator)new Parcelable$Creator<SavedState>() {
                public SavedState a(final Parcel parcel) {
                    return new SavedState(parcel);
                }
                
                public SavedState[] b(final int n) {
                    return new SavedState[n];
                }
                
                public /* bridge */ Object createFromParcel(final Parcel parcel) {
                    return this.a(parcel);
                }
                
                public /* bridge */ Object[] newArray(final int n) {
                    return this.b(n);
                }
            };
        }
        
        SavedState(final Parcel parcel) {
            super(parcel);
            this.a = parcel.readInt();
        }
        
        SavedState(final Parcelable parcelable) {
            super(parcelable);
        }
        
        public String toString() {
            final StringBuilder sb = new StringBuilder();
            sb.append("HorizontalScrollView.SavedState{");
            sb.append(Integer.toHexString(System.identityHashCode(this)));
            sb.append(" scrollPosition=");
            sb.append(this.a);
            sb.append("}");
            return sb.toString();
        }
        
        public void writeToParcel(final Parcel parcel, final int n) {
            super.writeToParcel(parcel, n);
            parcel.writeInt(this.a);
        }
    }
    
    static class a extends androidx.core.view.a
    {
        @Override
        public void onInitializeAccessibilityEvent(final View view, final AccessibilityEvent accessibilityEvent) {
            super.onInitializeAccessibilityEvent(view, accessibilityEvent);
            final NestedScrollView nestedScrollView = (NestedScrollView)view;
            accessibilityEvent.setClassName((CharSequence)ScrollView.class.getName());
            accessibilityEvent.setScrollable(nestedScrollView.getScrollRange() > 0);
            accessibilityEvent.setScrollX(nestedScrollView.getScrollX());
            accessibilityEvent.setScrollY(nestedScrollView.getScrollY());
            androidx.core.view.accessibility.f.a((AccessibilityRecord)accessibilityEvent, nestedScrollView.getScrollX());
            androidx.core.view.accessibility.f.b((AccessibilityRecord)accessibilityEvent, nestedScrollView.getScrollRange());
        }
        
        @Override
        public void onInitializeAccessibilityNodeInfo(final View view, final d d) {
            super.onInitializeAccessibilityNodeInfo(view, d);
            final NestedScrollView nestedScrollView = (NestedScrollView)view;
            d.Q(ScrollView.class.getName());
            if (nestedScrollView.isEnabled()) {
                final int scrollRange = nestedScrollView.getScrollRange();
                if (scrollRange > 0) {
                    d.l0(true);
                    if (nestedScrollView.getScrollY() > 0) {
                        d.b(androidx.core.view.accessibility.d.a.r);
                        d.b(androidx.core.view.accessibility.d.a.C);
                    }
                    if (nestedScrollView.getScrollY() < scrollRange) {
                        d.b(androidx.core.view.accessibility.d.a.q);
                        d.b(androidx.core.view.accessibility.d.a.E);
                    }
                }
            }
        }
        
        @Override
        public boolean performAccessibilityAction(final View view, int n, final Bundle bundle) {
            if (super.performAccessibilityAction(view, n, bundle)) {
                return true;
            }
            final NestedScrollView nestedScrollView = (NestedScrollView)view;
            if (!nestedScrollView.isEnabled()) {
                return false;
            }
            final int height = nestedScrollView.getHeight();
            final Rect rect = new Rect();
            int height2 = height;
            if (nestedScrollView.getMatrix().isIdentity()) {
                height2 = height;
                if (nestedScrollView.getGlobalVisibleRect(rect)) {
                    height2 = rect.height();
                }
            }
            if (n != 4096) {
                if (n != 8192 && n != 16908344) {
                    if (n != 16908346) {
                        return false;
                    }
                }
                else {
                    n = nestedScrollView.getPaddingBottom();
                    n = Math.max(nestedScrollView.getScrollY() - (height2 - n - nestedScrollView.getPaddingTop()), 0);
                    if (n != nestedScrollView.getScrollY()) {
                        nestedScrollView.R(0, n, true);
                        return true;
                    }
                    return false;
                }
            }
            n = nestedScrollView.getPaddingBottom();
            n = Math.min(nestedScrollView.getScrollY() + (height2 - n - nestedScrollView.getPaddingTop()), nestedScrollView.getScrollRange());
            if (n != nestedScrollView.getScrollY()) {
                nestedScrollView.R(0, n, true);
                return true;
            }
            return false;
        }
    }
    
    static class b
    {
        static boolean a(final ViewGroup viewGroup) {
            return viewGroup.getClipToPadding();
        }
    }
    
    public interface c
    {
        void a(final NestedScrollView p0, final int p1, final int p2, final int p3, final int p4);
    }
}
