// 
// Decompiled by Procyon v0.6.0
// 

package androidx.swiperefreshlayout.widget;

import androidx.core.view.b0;
import android.view.View$MeasureSpec;
import android.util.Log;
import androidx.core.widget.l;
import android.widget.ListView;
import android.view.MotionEvent;
import android.graphics.drawable.Drawable;
import android.view.animation.Interpolator;
import android.content.res.TypedArray;
import android.util.DisplayMetrics;
import android.view.ViewConfiguration;
import android.view.animation.Transformation;
import android.util.AttributeSet;
import android.content.Context;
import androidx.core.view.r;
import androidx.core.view.u;
import android.view.View;
import android.view.animation.Animation$AnimationListener;
import android.view.animation.Animation;
import android.view.animation.DecelerateInterpolator;
import androidx.core.view.q;
import android.view.ViewGroup;

public class SwipeRefreshLayout extends ViewGroup implements q
{
    private static final String c0;
    private static final int[] d0;
    private boolean A;
    private int B;
    boolean C;
    private boolean D;
    private final DecelerateInterpolator E;
    a F;
    private int G;
    protected int H;
    float I;
    protected int J;
    int K;
    int L;
    b M;
    private Animation N;
    private Animation O;
    private Animation P;
    private Animation Q;
    private Animation R;
    boolean S;
    private int T;
    boolean U;
    private i V;
    private Animation$AnimationListener W;
    private View a;
    private final Animation a0;
    j b;
    private final Animation b0;
    boolean c;
    private int d;
    private float e;
    private float f;
    private final u g;
    private final r h;
    private final int[] i;
    private final int[] j;
    private boolean p;
    private int w;
    int x;
    private float y;
    private float z;
    
    static {
        c0 = SwipeRefreshLayout.class.getSimpleName();
        d0 = new int[] { 16842766 };
    }
    
    public SwipeRefreshLayout(final Context context, final AttributeSet set) {
        super(context, set);
        this.c = false;
        this.e = -1.0f;
        this.i = new int[2];
        this.j = new int[2];
        this.B = -1;
        this.G = -1;
        this.W = (Animation$AnimationListener)new Animation$AnimationListener() {
            final SwipeRefreshLayout a;
            
            public void onAnimationEnd(final Animation animation) {
                final SwipeRefreshLayout a = this.a;
                if (a.c) {
                    a.M.setAlpha(255);
                    this.a.M.start();
                    final SwipeRefreshLayout a2 = this.a;
                    if (a2.S) {
                        final j b = a2.b;
                        if (b != null) {
                            b.a();
                        }
                    }
                    final SwipeRefreshLayout a3 = this.a;
                    a3.x = a3.F.getTop();
                }
                else {
                    a.l();
                }
            }
            
            public void onAnimationRepeat(final Animation animation) {
            }
            
            public void onAnimationStart(final Animation animation) {
            }
        };
        this.a0 = new Animation() {
            final SwipeRefreshLayout a;
            
            public void applyTransformation(final float n, final Transformation transformation) {
                final SwipeRefreshLayout a = this.a;
                int k;
                if (!a.U) {
                    k = a.K - Math.abs(a.J);
                }
                else {
                    k = a.K;
                }
                final SwipeRefreshLayout a2 = this.a;
                final int h = a2.H;
                this.a.setTargetOffsetTopAndBottom(h + (int)((k - h) * n) - a2.F.getTop());
                this.a.M.e(1.0f - n);
            }
        };
        this.b0 = new Animation() {
            final SwipeRefreshLayout a;
            
            public void applyTransformation(final float n, final Transformation transformation) {
                this.a.j(n);
            }
        };
        this.d = ViewConfiguration.get(context).getScaledTouchSlop();
        this.w = this.getResources().getInteger(17694721);
        this.setWillNotDraw(false);
        this.E = new DecelerateInterpolator(2.0f);
        final DisplayMetrics displayMetrics = this.getResources().getDisplayMetrics();
        this.T = (int)(displayMetrics.density * 40.0f);
        this.d();
        this.setChildrenDrawingOrderEnabled(true);
        final int k = (int)(displayMetrics.density * 64.0f);
        this.K = k;
        this.e = (float)k;
        this.g = new u(this);
        this.h = new r((View)this);
        this.setNestedScrollingEnabled(true);
        final int n = -this.T;
        this.x = n;
        this.J = n;
        this.j(1.0f);
        final TypedArray obtainStyledAttributes = context.obtainStyledAttributes(set, SwipeRefreshLayout.d0);
        this.setEnabled(obtainStyledAttributes.getBoolean(0, true));
        obtainStyledAttributes.recycle();
    }
    
    private void a(final int h, final Animation$AnimationListener animation$AnimationListener) {
        this.H = h;
        this.a0.reset();
        this.a0.setDuration(200L);
        this.a0.setInterpolator((Interpolator)this.E);
        if (animation$AnimationListener != null) {
            this.F.b(animation$AnimationListener);
        }
        this.F.clearAnimation();
        this.F.startAnimation(this.a0);
    }
    
    private void b(final int h, final Animation$AnimationListener animation$AnimationListener) {
        if (this.C) {
            this.s(h, animation$AnimationListener);
        }
        else {
            this.H = h;
            this.b0.reset();
            this.b0.setDuration(200L);
            this.b0.setInterpolator((Interpolator)this.E);
            if (animation$AnimationListener != null) {
                this.F.b(animation$AnimationListener);
            }
            this.F.clearAnimation();
            this.F.startAnimation(this.b0);
        }
    }
    
    private void d() {
        this.F = new a(this.getContext(), -328966);
        (this.M = new b(this.getContext())).l(1);
        this.F.setImageDrawable((Drawable)this.M);
        this.F.setVisibility(8);
        this.addView((View)this.F);
    }
    
    private void e() {
        if (this.a == null) {
            for (int i = 0; i < this.getChildCount(); ++i) {
                final View child = this.getChildAt(i);
                if (!child.equals(this.F)) {
                    this.a = child;
                    break;
                }
            }
        }
    }
    
    private void f(final float n) {
        if (n > this.e) {
            this.m(true, true);
        }
        else {
            this.c = false;
            this.M.j(0.0f, 0.0f);
            Object o = null;
            if (!this.C) {
                o = new Animation$AnimationListener(this) {
                    final SwipeRefreshLayout a;
                    
                    public void onAnimationEnd(final Animation animation) {
                        final SwipeRefreshLayout a = this.a;
                        if (!a.C) {
                            a.r(null);
                        }
                    }
                    
                    public void onAnimationRepeat(final Animation animation) {
                    }
                    
                    public void onAnimationStart(final Animation animation) {
                    }
                };
            }
            this.b(this.x, (Animation$AnimationListener)o);
            this.M.d(false);
        }
    }
    
    private boolean g(final Animation animation) {
        return animation != null && animation.hasStarted() && !animation.hasEnded();
    }
    
    private void i(final float n) {
        this.M.d(true);
        final float min = Math.min(1.0f, Math.abs(n / this.e));
        final float n2 = (float)Math.max(min - 0.4, 0.0) * 5.0f / 3.0f;
        final float abs = Math.abs(n);
        final float e = this.e;
        int n3 = this.L;
        if (n3 <= 0) {
            if (this.U) {
                n3 = this.K - this.J;
            }
            else {
                n3 = this.K;
            }
        }
        final float n4 = (float)n3;
        final double n5 = Math.max(0.0f, Math.min(abs - e, n4 * 2.0f) / n4) / 4.0f;
        final float n6 = (float)(n5 - Math.pow(n5, 2.0)) * 2.0f;
        final int j = this.J;
        final int n7 = (int)(n4 * min + n4 * n6 * 2.0f);
        if (this.F.getVisibility() != 0) {
            this.F.setVisibility(0);
        }
        if (!this.C) {
            this.F.setScaleX(1.0f);
            this.F.setScaleY(1.0f);
        }
        if (this.C) {
            this.setAnimationProgress(Math.min(1.0f, n / this.e));
        }
        if (n < this.e) {
            if (this.M.getAlpha() > 76 && !this.g(this.P)) {
                this.q();
            }
        }
        else if (this.M.getAlpha() < 255 && !this.g(this.Q)) {
            this.p();
        }
        this.M.j(0.0f, Math.min(0.8f, n2 * 0.8f));
        this.M.e(Math.min(1.0f, n2));
        this.M.g((n2 * 0.4f - 0.25f + n6 * 2.0f) * 0.5f);
        this.setTargetOffsetTopAndBottom(j + n7 - this.x);
    }
    
    private void k(final MotionEvent motionEvent) {
        final int actionIndex = motionEvent.getActionIndex();
        if (motionEvent.getPointerId(actionIndex) == this.B) {
            int n;
            if (actionIndex == 0) {
                n = 1;
            }
            else {
                n = 0;
            }
            this.B = motionEvent.getPointerId(n);
        }
    }
    
    private void m(final boolean c, final boolean s) {
        if (this.c != c) {
            this.S = s;
            this.e();
            this.c = c;
            if (c) {
                this.a(this.x, this.W);
            }
            else {
                this.r(this.W);
            }
        }
    }
    
    private Animation n(final int n, final int n2) {
        final Animation animation = new Animation(this, n, n2) {
            final int a;
            final int b;
            final SwipeRefreshLayout c;
            
            public void applyTransformation(final float n, final Transformation transformation) {
                final b m = this.c.M;
                final int a = this.a;
                m.setAlpha((int)(a + (this.b - a) * n));
            }
        };
        animation.setDuration(300L);
        this.F.b(null);
        this.F.clearAnimation();
        this.F.startAnimation((Animation)animation);
        return animation;
    }
    
    private void o(final float n) {
        final float z = this.z;
        final int d = this.d;
        if (n - z > d && !this.A) {
            this.y = z + d;
            this.A = true;
            this.M.setAlpha(76);
        }
    }
    
    private void p() {
        this.Q = this.n(this.M.getAlpha(), 255);
    }
    
    private void q() {
        this.P = this.n(this.M.getAlpha(), 76);
    }
    
    private void s(final int h, final Animation$AnimationListener animation$AnimationListener) {
        this.H = h;
        this.I = this.F.getScaleX();
        (this.R = new Animation(this) {
            final SwipeRefreshLayout a;
            
            public void applyTransformation(final float n, final Transformation transformation) {
                final SwipeRefreshLayout a = this.a;
                final float i = a.I;
                a.setAnimationProgress(i + -i * n);
                this.a.j(n);
            }
        }).setDuration(150L);
        if (animation$AnimationListener != null) {
            this.F.b(animation$AnimationListener);
        }
        this.F.clearAnimation();
        this.F.startAnimation(this.R);
    }
    
    private void setColorViewAlpha(final int n) {
        this.F.getBackground().setAlpha(n);
        this.M.setAlpha(n);
    }
    
    private void t(final Animation$AnimationListener animation$AnimationListener) {
        this.F.setVisibility(0);
        this.M.setAlpha(255);
        (this.N = new Animation(this) {
            final SwipeRefreshLayout a;
            
            public void applyTransformation(final float animationProgress, final Transformation transformation) {
                this.a.setAnimationProgress(animationProgress);
            }
        }).setDuration((long)this.w);
        if (animation$AnimationListener != null) {
            this.F.b(animation$AnimationListener);
        }
        this.F.clearAnimation();
        this.F.startAnimation(this.N);
    }
    
    public boolean c() {
        final i v = this.V;
        if (v != null) {
            return v.a(this, this.a);
        }
        final View a = this.a;
        if (a instanceof ListView) {
            return l.a((ListView)a, -1);
        }
        return a.canScrollVertically(-1);
    }
    
    public boolean dispatchNestedFling(final float n, final float n2, final boolean b) {
        return this.h.a(n, n2, b);
    }
    
    public boolean dispatchNestedPreFling(final float n, final float n2) {
        return this.h.b(n, n2);
    }
    
    public boolean dispatchNestedPreScroll(final int n, final int n2, final int[] array, final int[] array2) {
        return this.h.c(n, n2, array, array2);
    }
    
    public boolean dispatchNestedScroll(final int n, final int n2, final int n3, final int n4, final int[] array) {
        return this.h.f(n, n2, n3, n4, array);
    }
    
    protected int getChildDrawingOrder(int n, final int n2) {
        final int g = this.G;
        if (g < 0) {
            return n2;
        }
        if (n2 == n - 1) {
            return g;
        }
        if ((n = n2) >= g) {
            n = n2 + 1;
        }
        return n;
    }
    
    public int getNestedScrollAxes() {
        return this.g.a();
    }
    
    public int getProgressCircleDiameter() {
        return this.T;
    }
    
    public int getProgressViewEndOffset() {
        return this.K;
    }
    
    public int getProgressViewStartOffset() {
        return this.J;
    }
    
    public boolean h() {
        return this.c;
    }
    
    public boolean hasNestedScrollingParent() {
        return this.h.k();
    }
    
    public boolean isNestedScrollingEnabled() {
        return this.h.m();
    }
    
    void j(final float n) {
        final int h = this.H;
        this.setTargetOffsetTopAndBottom(h + (int)((this.J - h) * n) - this.F.getTop());
    }
    
    void l() {
        this.F.clearAnimation();
        this.M.stop();
        this.F.setVisibility(8);
        this.setColorViewAlpha(255);
        if (this.C) {
            this.setAnimationProgress(0.0f);
        }
        else {
            this.setTargetOffsetTopAndBottom(this.J - this.x);
        }
        this.x = this.F.getTop();
    }
    
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.l();
    }
    
    public boolean onInterceptTouchEvent(final MotionEvent motionEvent) {
        this.e();
        final int actionMasked = motionEvent.getActionMasked();
        if (this.D && actionMasked == 0) {
            this.D = false;
        }
        if (this.isEnabled() && !this.D && !this.c() && !this.c && !this.p) {
            if (actionMasked != 0) {
                if (actionMasked != 1) {
                    if (actionMasked != 2) {
                        if (actionMasked != 3) {
                            if (actionMasked != 6) {
                                return this.A;
                            }
                            this.k(motionEvent);
                            return this.A;
                        }
                    }
                    else {
                        final int b = this.B;
                        if (b == -1) {
                            Log.e(SwipeRefreshLayout.c0, "Got ACTION_MOVE event but don't have an active pointer id.");
                            return false;
                        }
                        final int pointerIndex = motionEvent.findPointerIndex(b);
                        if (pointerIndex < 0) {
                            return false;
                        }
                        this.o(motionEvent.getY(pointerIndex));
                        return this.A;
                    }
                }
                this.A = false;
                this.B = -1;
            }
            else {
                this.setTargetOffsetTopAndBottom(this.J - this.F.getTop());
                final int pointerId = motionEvent.getPointerId(0);
                this.B = pointerId;
                this.A = false;
                final int pointerIndex2 = motionEvent.findPointerIndex(pointerId);
                if (pointerIndex2 < 0) {
                    return false;
                }
                this.z = motionEvent.getY(pointerIndex2);
            }
            return this.A;
        }
        return false;
    }
    
    protected void onLayout(final boolean b, int n, int measuredWidth, int n2, int measuredHeight) {
        measuredWidth = this.getMeasuredWidth();
        measuredHeight = this.getMeasuredHeight();
        if (this.getChildCount() == 0) {
            return;
        }
        if (this.a == null) {
            this.e();
        }
        final View a = this.a;
        if (a == null) {
            return;
        }
        n2 = this.getPaddingLeft();
        n = this.getPaddingTop();
        a.layout(n2, n, measuredWidth - this.getPaddingLeft() - this.getPaddingRight() + n2, measuredHeight - this.getPaddingTop() - this.getPaddingBottom() + n);
        n2 = this.F.getMeasuredWidth();
        n = this.F.getMeasuredHeight();
        final a f = this.F;
        measuredWidth /= 2;
        measuredHeight = n2 / 2;
        n2 = this.x;
        f.layout(measuredWidth - measuredHeight, n2, measuredWidth + measuredHeight, n + n2);
    }
    
    public void onMeasure(int i, final int n) {
        super.onMeasure(i, n);
        if (this.a == null) {
            this.e();
        }
        final View a = this.a;
        if (a == null) {
            return;
        }
        a.measure(View$MeasureSpec.makeMeasureSpec(this.getMeasuredWidth() - this.getPaddingLeft() - this.getPaddingRight(), 1073741824), View$MeasureSpec.makeMeasureSpec(this.getMeasuredHeight() - this.getPaddingTop() - this.getPaddingBottom(), 1073741824));
        this.F.measure(View$MeasureSpec.makeMeasureSpec(this.T, 1073741824), View$MeasureSpec.makeMeasureSpec(this.T, 1073741824));
        this.G = -1;
        for (i = 0; i < this.getChildCount(); ++i) {
            if (this.getChildAt(i) == this.F) {
                this.G = i;
                break;
            }
        }
    }
    
    public boolean onNestedFling(final View view, final float n, final float n2, final boolean b) {
        return this.dispatchNestedFling(n, n2, b);
    }
    
    public boolean onNestedPreFling(final View view, final float n, final float n2) {
        return this.dispatchNestedPreFling(n, n2);
    }
    
    public void onNestedPreScroll(final View view, final int n, final int n2, final int[] array) {
        if (n2 > 0) {
            final float f = this.f;
            if (f > 0.0f) {
                final float n3 = (float)n2;
                if (n3 > f) {
                    array[1] = n2 - (int)f;
                    this.f = 0.0f;
                }
                else {
                    this.f = f - n3;
                    array[1] = n2;
                }
                this.i(this.f);
            }
        }
        if (this.U && n2 > 0 && this.f == 0.0f && Math.abs(n2 - array[1]) > 0) {
            this.F.setVisibility(8);
        }
        final int[] i = this.i;
        if (this.dispatchNestedPreScroll(n - array[0], n2 - array[1], i, null)) {
            array[0] += i[0];
            array[1] += i[1];
        }
    }
    
    public void onNestedScroll(final View view, int n, final int n2, final int n3, final int n4) {
        this.dispatchNestedScroll(n, n2, n3, n4, this.j);
        n = n4 + this.j[1];
        if (n < 0 && !this.c()) {
            this.i(this.f += Math.abs(n));
        }
    }
    
    public void onNestedScrollAccepted(final View view, final View view2, final int n) {
        this.g.b(view, view2, n);
        this.startNestedScroll(n & 0x2);
        this.f = 0.0f;
        this.p = true;
    }
    
    public boolean onStartNestedScroll(final View view, final View view2, final int n) {
        return this.isEnabled() && !this.D && !this.c && (n & 0x2) != 0x0;
    }
    
    public void onStopNestedScroll(final View view) {
        this.g.d(view);
        this.p = false;
        final float f = this.f;
        if (f > 0.0f) {
            this.f(f);
            this.f = 0.0f;
        }
        this.stopNestedScroll();
    }
    
    public boolean onTouchEvent(final MotionEvent motionEvent) {
        final int actionMasked = motionEvent.getActionMasked();
        if (this.D && actionMasked == 0) {
            this.D = false;
        }
        if (this.isEnabled() && !this.D && !this.c() && !this.c && !this.p) {
            if (actionMasked != 0) {
                if (actionMasked != 1) {
                    if (actionMasked != 2) {
                        if (actionMasked == 3) {
                            return false;
                        }
                        if (actionMasked != 5) {
                            if (actionMasked == 6) {
                                this.k(motionEvent);
                            }
                        }
                        else {
                            final int actionIndex = motionEvent.getActionIndex();
                            if (actionIndex < 0) {
                                Log.e(SwipeRefreshLayout.c0, "Got ACTION_POINTER_DOWN event but have an invalid action index.");
                                return false;
                            }
                            this.B = motionEvent.getPointerId(actionIndex);
                        }
                    }
                    else {
                        final int pointerIndex = motionEvent.findPointerIndex(this.B);
                        if (pointerIndex < 0) {
                            Log.e(SwipeRefreshLayout.c0, "Got ACTION_MOVE event but have an invalid active pointer id.");
                            return false;
                        }
                        final float y = motionEvent.getY(pointerIndex);
                        this.o(y);
                        if (this.A) {
                            final float n = (y - this.y) * 0.5f;
                            if (n <= 0.0f) {
                                return false;
                            }
                            this.i(n);
                        }
                    }
                }
                else {
                    final int pointerIndex2 = motionEvent.findPointerIndex(this.B);
                    if (pointerIndex2 < 0) {
                        Log.e(SwipeRefreshLayout.c0, "Got ACTION_UP event but don't have an active pointer id.");
                        return false;
                    }
                    if (this.A) {
                        final float y2 = motionEvent.getY(pointerIndex2);
                        final float y3 = this.y;
                        this.A = false;
                        this.f((y2 - y3) * 0.5f);
                    }
                    this.B = -1;
                    return false;
                }
            }
            else {
                this.B = motionEvent.getPointerId(0);
                this.A = false;
            }
            return true;
        }
        return false;
    }
    
    void r(final Animation$AnimationListener animation$AnimationListener) {
        (this.O = new Animation(this) {
            final SwipeRefreshLayout a;
            
            public void applyTransformation(final float n, final Transformation transformation) {
                this.a.setAnimationProgress(1.0f - n);
            }
        }).setDuration(150L);
        this.F.b(animation$AnimationListener);
        this.F.clearAnimation();
        this.F.startAnimation(this.O);
    }
    
    public void requestDisallowInterceptTouchEvent(final boolean b) {
        final View a = this.a;
        if (a == null || androidx.core.view.b0.U(a)) {
            super.requestDisallowInterceptTouchEvent(b);
        }
    }
    
    void setAnimationProgress(final float n) {
        this.F.setScaleX(n);
        this.F.setScaleY(n);
    }
    
    @Deprecated
    public void setColorScheme(final int... colorSchemeResources) {
        this.setColorSchemeResources(colorSchemeResources);
    }
    
    public void setColorSchemeColors(final int... array) {
        this.e();
        this.M.f(array);
    }
    
    public void setColorSchemeResources(final int... array) {
        final Context context = this.getContext();
        final int[] colorSchemeColors = new int[array.length];
        for (int i = 0; i < array.length; ++i) {
            colorSchemeColors[i] = androidx.core.content.a.getColor(context, array[i]);
        }
        this.setColorSchemeColors(colorSchemeColors);
    }
    
    public void setDistanceToTriggerSync(final int n) {
        this.e = (float)n;
    }
    
    public void setEnabled(final boolean enabled) {
        super.setEnabled(enabled);
        if (!enabled) {
            this.l();
        }
    }
    
    public void setNestedScrollingEnabled(final boolean b) {
        this.h.n(b);
    }
    
    public void setOnChildScrollUpCallback(final i v) {
        this.V = v;
    }
    
    public void setOnRefreshListener(final j b) {
        this.b = b;
    }
    
    @Deprecated
    public void setProgressBackgroundColor(final int progressBackgroundColorSchemeResource) {
        this.setProgressBackgroundColorSchemeResource(progressBackgroundColorSchemeResource);
    }
    
    public void setProgressBackgroundColorSchemeColor(final int backgroundColor) {
        this.F.setBackgroundColor(backgroundColor);
    }
    
    public void setProgressBackgroundColorSchemeResource(final int n) {
        this.setProgressBackgroundColorSchemeColor(androidx.core.content.a.getColor(this.getContext(), n));
    }
    
    public void setRefreshing(final boolean c) {
        if (c && this.c != c) {
            this.c = c;
            int k;
            if (!this.U) {
                k = this.K + this.J;
            }
            else {
                k = this.K;
            }
            this.setTargetOffsetTopAndBottom(k - this.x);
            this.S = false;
            this.t(this.W);
        }
        else {
            this.m(c, false);
        }
    }
    
    public void setSize(final int n) {
        if (n != 0 && n != 1) {
            return;
        }
        final DisplayMetrics displayMetrics = this.getResources().getDisplayMetrics();
        if (n == 0) {
            this.T = (int)(displayMetrics.density * 56.0f);
        }
        else {
            this.T = (int)(displayMetrics.density * 40.0f);
        }
        this.F.setImageDrawable((Drawable)null);
        this.M.l(n);
        this.F.setImageDrawable((Drawable)this.M);
    }
    
    public void setSlingshotDistance(final int l) {
        this.L = l;
    }
    
    void setTargetOffsetTopAndBottom(final int n) {
        this.F.bringToFront();
        androidx.core.view.b0.a0((View)this.F, n);
        this.x = this.F.getTop();
    }
    
    public boolean startNestedScroll(final int n) {
        return this.h.p(n);
    }
    
    public void stopNestedScroll() {
        this.h.r();
    }
    
    public interface i
    {
        boolean a(final SwipeRefreshLayout p0, final View p1);
    }
    
    public interface j
    {
        void a();
    }
}
