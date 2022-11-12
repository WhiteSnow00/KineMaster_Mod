// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.exoplayer2.ui;

import android.content.res.TypedArray;
import android.os.Bundle;
import android.view.View$MeasureSpec;
import android.view.KeyEvent;
import android.view.accessibility.AccessibilityNodeInfo$AccessibilityAction;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.accessibility.AccessibilityEvent;
import java.util.Iterator;
import android.view.ViewParent;
import java.util.List;
import java.util.Collections;
import android.view.MotionEvent;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.Util;
import android.graphics.Canvas;
import android.animation.ValueAnimator$AnimatorUpdateListener;
import e4.a;
import e4.b;
import java.util.Locale;
import android.util.AttributeSet;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.graphics.Paint;
import android.animation.ValueAnimator;
import android.graphics.Rect;
import android.graphics.Point;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.Formatter;
import android.view.View;

public class DefaultTimeBar extends View implements TimeBar
{
    private final int A;
    private final int B;
    private final int C;
    private final int D;
    private final int E;
    private final StringBuilder F;
    private final Formatter G;
    private final Runnable H;
    private final CopyOnWriteArraySet<OnScrubListener> I;
    private final Point J;
    private final float K;
    private int L;
    private long M;
    private int N;
    private Rect O;
    private ValueAnimator P;
    private float Q;
    private boolean R;
    private boolean S;
    private long T;
    private long U;
    private long V;
    private long W;
    private final Rect a;
    private int a0;
    private final Rect b;
    private long[] b0;
    private final Rect c;
    private boolean[] c0;
    private final Rect d;
    private final Paint e;
    private final Paint f;
    private final Paint g;
    private final Paint h;
    private final Paint i;
    private final Paint j;
    private final Drawable p;
    private final int w;
    private final int x;
    private final int y;
    private final int z;
    
    public DefaultTimeBar(Context obtainStyledAttributes, final AttributeSet set, int color, final AttributeSet set2, int int1) {
        super(obtainStyledAttributes, set, color);
        this.a = new Rect();
        this.b = new Rect();
        this.c = new Rect();
        this.d = new Rect();
        final Paint e = new Paint();
        this.e = e;
        final Paint f = new Paint();
        this.f = f;
        final Paint g = new Paint();
        this.g = g;
        final Paint h = new Paint();
        this.h = h;
        final Paint i = new Paint();
        this.i = i;
        final Paint j = new Paint();
        (this.j = j).setAntiAlias(true);
        this.I = new CopyOnWriteArraySet<OnScrubListener>();
        this.J = new Point();
        final float density = obtainStyledAttributes.getResources().getDisplayMetrics().density;
        this.K = density;
        this.E = e(density, -50);
        final int e2 = e(density, 4);
        final int e3 = e(density, 26);
        final int e4 = e(density, 4);
        final int e5 = e(density, 12);
        final int e6 = e(density, 0);
        final int e7 = e(density, 16);
        Label_0599: {
            if (set2 != null) {
                obtainStyledAttributes = (Context)obtainStyledAttributes.getTheme().obtainStyledAttributes(set2, com.google.android.exoplayer2.ui.R.styleable.e, color, int1);
                try {
                    final Drawable drawable = ((TypedArray)obtainStyledAttributes).getDrawable(com.google.android.exoplayer2.ui.R.styleable.p);
                    this.p = drawable;
                    color = e3;
                    if (drawable != null) {
                        this.q(drawable);
                        color = Math.max(drawable.getMinimumHeight(), e3);
                    }
                    this.w = ((TypedArray)obtainStyledAttributes).getDimensionPixelSize(com.google.android.exoplayer2.ui.R.styleable.i, e2);
                    this.x = ((TypedArray)obtainStyledAttributes).getDimensionPixelSize(com.google.android.exoplayer2.ui.R.styleable.r, color);
                    this.y = ((TypedArray)obtainStyledAttributes).getInt(com.google.android.exoplayer2.ui.R.styleable.h, 0);
                    this.z = ((TypedArray)obtainStyledAttributes).getDimensionPixelSize(com.google.android.exoplayer2.ui.R.styleable.g, e4);
                    this.A = ((TypedArray)obtainStyledAttributes).getDimensionPixelSize(com.google.android.exoplayer2.ui.R.styleable.q, e5);
                    this.B = ((TypedArray)obtainStyledAttributes).getDimensionPixelSize(com.google.android.exoplayer2.ui.R.styleable.n, e6);
                    this.C = ((TypedArray)obtainStyledAttributes).getDimensionPixelSize(com.google.android.exoplayer2.ui.R.styleable.o, e7);
                    final int int2 = ((TypedArray)obtainStyledAttributes).getInt(com.google.android.exoplayer2.ui.R.styleable.l, -1);
                    int1 = ((TypedArray)obtainStyledAttributes).getInt(com.google.android.exoplayer2.ui.R.styleable.m, -1);
                    final int int3 = ((TypedArray)obtainStyledAttributes).getInt(com.google.android.exoplayer2.ui.R.styleable.j, -855638017);
                    color = ((TypedArray)obtainStyledAttributes).getInt(com.google.android.exoplayer2.ui.R.styleable.s, 872415231);
                    final int int4 = ((TypedArray)obtainStyledAttributes).getInt(com.google.android.exoplayer2.ui.R.styleable.f, -1291845888);
                    final int int5 = ((TypedArray)obtainStyledAttributes).getInt(com.google.android.exoplayer2.ui.R.styleable.k, 872414976);
                    e.setColor(int2);
                    j.setColor(int1);
                    f.setColor(int3);
                    g.setColor(color);
                    h.setColor(int4);
                    i.setColor(int5);
                    break Label_0599;
                }
                finally {
                    ((TypedArray)obtainStyledAttributes).recycle();
                }
            }
            this.w = e2;
            this.x = e3;
            this.y = 0;
            this.z = e4;
            this.A = e5;
            this.B = e6;
            this.C = e7;
            e.setColor(-1);
            j.setColor(-1);
            f.setColor(-855638017);
            g.setColor(872415231);
            h.setColor(-1291845888);
            i.setColor(872414976);
            this.p = null;
        }
        final StringBuilder f2 = new StringBuilder();
        this.F = f2;
        this.G = new Formatter(f2, Locale.getDefault());
        this.H = (Runnable)new b(this);
        final Drawable p5 = this.p;
        if (p5 != null) {
            this.D = (p5.getMinimumWidth() + 1) / 2;
        }
        else {
            this.D = (Math.max(this.B, Math.max(this.A, this.C)) + 1) / 2;
        }
        this.Q = 1.0f;
        (this.P = new ValueAnimator()).addUpdateListener((ValueAnimator$AnimatorUpdateListener)new a(this));
        this.U = -9223372036854775807L;
        this.M = -9223372036854775807L;
        this.L = 20;
        this.setFocusable(true);
        if (this.getImportantForAccessibility() == 0) {
            this.setImportantForAccessibility(1);
        }
    }
    
    public static void c(final DefaultTimeBar defaultTimeBar) {
        defaultTimeBar.k();
    }
    
    public static void d(final DefaultTimeBar defaultTimeBar, final ValueAnimator valueAnimator) {
        defaultTimeBar.l(valueAnimator);
    }
    
    private static int e(final float n, final int n2) {
        return (int)(n2 * n + 0.5f);
    }
    
    private void f(final Canvas canvas) {
        if (this.U <= 0L) {
            return;
        }
        final Rect d = this.d;
        final int q = Util.q(d.right, d.left, this.b.right);
        final int centerY = this.d.centerY();
        final Drawable p = this.p;
        if (p == null) {
            int n;
            if (!this.S && !this.isFocused()) {
                if (this.isEnabled()) {
                    n = this.A;
                }
                else {
                    n = this.B;
                }
            }
            else {
                n = this.C;
            }
            canvas.drawCircle((float)q, (float)centerY, (float)(int)(n * this.Q / 2.0f), this.j);
        }
        else {
            final int n2 = (int)(p.getIntrinsicWidth() * this.Q);
            final int n3 = (int)(this.p.getIntrinsicHeight() * this.Q);
            final Drawable p2 = this.p;
            final int n4 = n2 / 2;
            final int n5 = n3 / 2;
            p2.setBounds(q - n4, centerY - n5, q + n4, centerY + n5);
            this.p.draw(canvas);
        }
    }
    
    private void g(final Canvas canvas) {
        final int height = this.b.height();
        final int n = this.b.centerY() - height / 2;
        final int n2 = height + n;
        if (this.U <= 0L) {
            final Rect b = this.b;
            canvas.drawRect((float)b.left, (float)n, (float)b.right, (float)n2, this.g);
            return;
        }
        final Rect c = this.c;
        final int left = c.left;
        final int right = c.right;
        final int max = Math.max(Math.max(this.b.left, right), this.d.right);
        final int right2 = this.b.right;
        if (max < right2) {
            canvas.drawRect((float)max, (float)n, (float)right2, (float)n2, this.g);
        }
        final int max2 = Math.max(left, this.d.right);
        if (right > max2) {
            canvas.drawRect((float)max2, (float)n, (float)right, (float)n2, this.f);
        }
        if (this.d.width() > 0) {
            final Rect d = this.d;
            canvas.drawRect((float)d.left, (float)n, (float)d.right, (float)n2, this.e);
        }
        if (this.a0 == 0) {
            return;
        }
        final long[] array = Assertions.e(this.b0);
        final boolean[] array2 = Assertions.e(this.c0);
        final int n3 = this.z / 2;
        for (int i = 0; i < this.a0; ++i) {
            final int n4 = (int)(this.b.width() * Util.r(array[i], 0L, this.U) / this.U);
            final Rect b2 = this.b;
            final int n5 = b2.left + Math.min(b2.width() - this.z, Math.max(0, n4 - n3));
            Paint paint;
            if (array2[i]) {
                paint = this.i;
            }
            else {
                paint = this.h;
            }
            canvas.drawRect((float)n5, (float)n, (float)(n5 + this.z), (float)n2, paint);
        }
    }
    
    private long getPositionIncrement() {
        long m;
        if ((m = this.M) == -9223372036854775807L) {
            final long u = this.U;
            if (u == -9223372036854775807L) {
                m = 0L;
            }
            else {
                m = u / this.L;
            }
        }
        return m;
    }
    
    private String getProgressText() {
        return Util.h0(this.F, this.G, this.V);
    }
    
    private long getScrubberPosition() {
        if (this.b.width() > 0 && this.U != -9223372036854775807L) {
            return this.d.width() * this.U / this.b.width();
        }
        return 0L;
    }
    
    private boolean j(final float n, final float n2) {
        return this.a.contains((int)n, (int)n2);
    }
    
    private void k() {
        this.w(false);
    }
    
    private void l(final ValueAnimator valueAnimator) {
        this.Q = (float)valueAnimator.getAnimatedValue();
        this.invalidate(this.a);
    }
    
    private void m(final float n) {
        final Rect d = this.d;
        final int n2 = (int)n;
        final Rect b = this.b;
        d.right = Util.q(n2, b.left, b.right);
    }
    
    private static int n(final float n, final int n2) {
        return (int)(n2 / n);
    }
    
    private Point o(final MotionEvent motionEvent) {
        this.J.set((int)motionEvent.getX(), (int)motionEvent.getY());
        return this.J;
    }
    
    private boolean p(long r) {
        final long u = this.U;
        if (u <= 0L) {
            return false;
        }
        long n;
        if (this.S) {
            n = this.T;
        }
        else {
            n = this.V;
        }
        r = Util.r(n + r, 0L, u);
        if (r == n) {
            return false;
        }
        if (!this.S) {
            this.v(r);
        }
        else {
            this.z(r);
        }
        this.x();
        return true;
    }
    
    private boolean q(final Drawable drawable) {
        return Util.a >= 23 && r(drawable, this.getLayoutDirection());
    }
    
    private static boolean r(final Drawable drawable, final int layoutDirection) {
        return Util.a >= 23 && drawable.setLayoutDirection(layoutDirection);
    }
    
    private void s(final int n, final int n2) {
        final Rect o = this.O;
        if (o != null && o.width() == n && this.O.height() == n2) {
            return;
        }
        final Rect o2 = new Rect(0, 0, n, n2);
        this.O = o2;
        this.setSystemGestureExclusionRects((List)Collections.singletonList(o2));
    }
    
    private void v(final long t) {
        this.T = t;
        this.setPressed(this.S = true);
        final ViewParent parent = this.getParent();
        if (parent != null) {
            parent.requestDisallowInterceptTouchEvent(true);
        }
        final Iterator<OnScrubListener> iterator = this.I.iterator();
        while (iterator.hasNext()) {
            iterator.next().u(this, t);
        }
    }
    
    private void w(final boolean b) {
        this.removeCallbacks(this.H);
        this.setPressed(this.S = false);
        final ViewParent parent = this.getParent();
        if (parent != null) {
            parent.requestDisallowInterceptTouchEvent(false);
        }
        this.invalidate();
        final Iterator<OnScrubListener> iterator = this.I.iterator();
        while (iterator.hasNext()) {
            iterator.next().t(this, this.T, b);
        }
    }
    
    private void x() {
        this.c.set(this.b);
        this.d.set(this.b);
        long n;
        if (this.S) {
            n = this.T;
        }
        else {
            n = this.V;
        }
        if (this.U > 0L) {
            final int n2 = (int)(this.b.width() * this.W / this.U);
            final Rect c = this.c;
            final Rect b = this.b;
            c.right = Math.min(b.left + n2, b.right);
            final int n3 = (int)(this.b.width() * n / this.U);
            final Rect d = this.d;
            final Rect b2 = this.b;
            d.right = Math.min(b2.left + n3, b2.right);
        }
        else {
            final Rect c2 = this.c;
            final int left = this.b.left;
            c2.right = left;
            this.d.right = left;
        }
        this.invalidate(this.a);
    }
    
    private void y() {
        final Drawable p = this.p;
        if (p != null && p.isStateful() && this.p.setState(this.getDrawableState())) {
            this.invalidate();
        }
    }
    
    private void z(final long t) {
        if (this.T == t) {
            return;
        }
        this.T = t;
        final Iterator<OnScrubListener> iterator = this.I.iterator();
        while (iterator.hasNext()) {
            iterator.next().k(this, t);
        }
    }
    
    public void a(final OnScrubListener onScrubListener) {
        Assertions.e(onScrubListener);
        this.I.add(onScrubListener);
    }
    
    public void b(final long[] b0, final boolean[] c0, final int a0) {
        Assertions.a(a0 == 0 || (b0 != null && c0 != null));
        this.a0 = a0;
        this.b0 = b0;
        this.c0 = c0;
        this.x();
    }
    
    protected void drawableStateChanged() {
        super.drawableStateChanged();
        this.y();
    }
    
    public long getPreferredUpdateDelay() {
        final int n = n(this.K, this.b.width());
        if (n != 0) {
            final long u = this.U;
            if (u != 0L) {
                if (u != -9223372036854775807L) {
                    return u / n;
                }
            }
        }
        return Long.MAX_VALUE;
    }
    
    public void h(final long duration) {
        if (this.P.isStarted()) {
            this.P.cancel();
        }
        this.P.setFloatValues(new float[] { this.Q, 0.0f });
        this.P.setDuration(duration);
        this.P.start();
    }
    
    public void i(final boolean r) {
        if (this.P.isStarted()) {
            this.P.cancel();
        }
        this.R = r;
        this.Q = 0.0f;
        this.invalidate(this.a);
    }
    
    public void jumpDrawablesToCurrentState() {
        super.jumpDrawablesToCurrentState();
        final Drawable p = this.p;
        if (p != null) {
            p.jumpToCurrentState();
        }
    }
    
    public void onDraw(final Canvas canvas) {
        canvas.save();
        this.g(canvas);
        this.f(canvas);
        canvas.restore();
    }
    
    protected void onFocusChanged(final boolean b, final int n, final Rect rect) {
        super.onFocusChanged(b, n, rect);
        if (this.S && !b) {
            this.w(false);
        }
    }
    
    public void onInitializeAccessibilityEvent(final AccessibilityEvent accessibilityEvent) {
        super.onInitializeAccessibilityEvent(accessibilityEvent);
        if (accessibilityEvent.getEventType() == 4) {
            accessibilityEvent.getText().add(this.getProgressText());
        }
        accessibilityEvent.setClassName((CharSequence)"android.widget.SeekBar");
    }
    
    public void onInitializeAccessibilityNodeInfo(final AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        accessibilityNodeInfo.setClassName((CharSequence)"android.widget.SeekBar");
        accessibilityNodeInfo.setContentDescription((CharSequence)this.getProgressText());
        if (this.U <= 0L) {
            return;
        }
        if (Util.a >= 21) {
            accessibilityNodeInfo.addAction(AccessibilityNodeInfo$AccessibilityAction.ACTION_SCROLL_FORWARD);
            accessibilityNodeInfo.addAction(AccessibilityNodeInfo$AccessibilityAction.ACTION_SCROLL_BACKWARD);
        }
        else {
            accessibilityNodeInfo.addAction(4096);
            accessibilityNodeInfo.addAction(8192);
        }
    }
    
    public boolean onKeyDown(final int n, final KeyEvent keyEvent) {
        if (this.isEnabled()) {
            final long positionIncrement = this.getPositionIncrement();
            if (n != 66) {
                long n2 = positionIncrement;
                switch (n) {
                    default: {
                        return super.onKeyDown(n, keyEvent);
                    }
                    case 21: {
                        n2 = -positionIncrement;
                    }
                    case 22: {
                        if (this.p(n2)) {
                            this.removeCallbacks(this.H);
                            this.postDelayed(this.H, 1000L);
                            return true;
                        }
                        return super.onKeyDown(n, keyEvent);
                    }
                    case 23: {
                        break;
                    }
                }
            }
            if (this.S) {
                this.w(false);
                return true;
            }
        }
        return super.onKeyDown(n, keyEvent);
    }
    
    protected void onLayout(final boolean b, int d, int w, int n, int paddingRight) {
        final int n2 = n - d;
        final int n3 = paddingRight - w;
        final int paddingLeft = this.getPaddingLeft();
        paddingRight = this.getPaddingRight();
        if (this.R) {
            d = 0;
        }
        else {
            d = this.D;
        }
        if (this.y == 1) {
            n = n3 - this.getPaddingBottom() - this.x;
            final int paddingBottom = this.getPaddingBottom();
            w = this.w;
            w = n3 - paddingBottom - w - Math.max(d - w / 2, 0);
        }
        else {
            n = (n3 - this.x) / 2;
            w = (n3 - this.w) / 2;
        }
        this.a.set(paddingLeft, n, n2 - paddingRight, this.x + n);
        final Rect b2 = this.b;
        final Rect a = this.a;
        b2.set(a.left + d, w, a.right - d, this.w + w);
        if (Util.a >= 29) {
            this.s(n2, n3);
        }
        this.x();
    }
    
    protected void onMeasure(final int n, int n2) {
        final int mode = View$MeasureSpec.getMode(n2);
        n2 = View$MeasureSpec.getSize(n2);
        if (mode == 0) {
            n2 = this.x;
        }
        else if (mode != 1073741824) {
            n2 = Math.min(this.x, n2);
        }
        this.setMeasuredDimension(View$MeasureSpec.getSize(n), n2);
        this.y();
    }
    
    public void onRtlPropertiesChanged(final int n) {
        final Drawable p = this.p;
        if (p != null && r(p, n)) {
            this.invalidate();
        }
    }
    
    public boolean onTouchEvent(final MotionEvent motionEvent) {
        final boolean enabled = this.isEnabled();
        boolean b = false;
        if (enabled) {
            if (this.U > 0L) {
                final Point o = this.o(motionEvent);
                final int x = o.x;
                final int y = o.y;
                final int action = motionEvent.getAction();
                if (action != 0) {
                    if (action != 1) {
                        if (action != 2) {
                            if (action != 3) {
                                return false;
                            }
                        }
                        else {
                            if (this.S) {
                                if (y < this.E) {
                                    final int n = this.N;
                                    this.m((float)(n + (x - n) / 3));
                                }
                                else {
                                    this.N = x;
                                    this.m((float)x);
                                }
                                this.z(this.getScrubberPosition());
                                this.x();
                                this.invalidate();
                                return true;
                            }
                            return false;
                        }
                    }
                    if (this.S) {
                        if (motionEvent.getAction() == 3) {
                            b = true;
                        }
                        this.w(b);
                        return true;
                    }
                }
                else {
                    final float n2 = (float)x;
                    if (this.j(n2, (float)y)) {
                        this.m(n2);
                        this.v(this.getScrubberPosition());
                        this.x();
                        this.invalidate();
                        return true;
                    }
                }
            }
        }
        return false;
    }
    
    public boolean performAccessibilityAction(final int n, final Bundle bundle) {
        if (super.performAccessibilityAction(n, bundle)) {
            return true;
        }
        if (this.U <= 0L) {
            return false;
        }
        if (n == 8192) {
            if (this.p(-this.getPositionIncrement())) {
                this.w(false);
            }
        }
        else {
            if (n != 4096) {
                return false;
            }
            if (this.p(this.getPositionIncrement())) {
                this.w(false);
            }
        }
        this.sendAccessibilityEvent(4);
        return true;
    }
    
    public void setAdMarkerColor(final int color) {
        this.h.setColor(color);
        this.invalidate(this.a);
    }
    
    public void setBufferedColor(final int color) {
        this.f.setColor(color);
        this.invalidate(this.a);
    }
    
    public void setBufferedPosition(final long w) {
        if (this.W == w) {
            return;
        }
        this.W = w;
        this.x();
    }
    
    public void setDuration(final long u) {
        if (this.U == u) {
            return;
        }
        this.U = u;
        if (this.S && u == -9223372036854775807L) {
            this.w(true);
        }
        this.x();
    }
    
    public void setEnabled(final boolean enabled) {
        super.setEnabled(enabled);
        if (this.S && !enabled) {
            this.w(true);
        }
    }
    
    public void setKeyCountIncrement(final int l) {
        Assertions.a(l > 0);
        this.L = l;
        this.M = -9223372036854775807L;
    }
    
    public void setKeyTimeIncrement(final long m) {
        Assertions.a(m > 0L);
        this.L = -1;
        this.M = m;
    }
    
    public void setPlayedAdMarkerColor(final int color) {
        this.i.setColor(color);
        this.invalidate(this.a);
    }
    
    public void setPlayedColor(final int color) {
        this.e.setColor(color);
        this.invalidate(this.a);
    }
    
    public void setPosition(final long v) {
        if (this.V == v) {
            return;
        }
        this.V = v;
        this.setContentDescription((CharSequence)this.getProgressText());
        this.x();
    }
    
    public void setScrubberColor(final int color) {
        this.j.setColor(color);
        this.invalidate(this.a);
    }
    
    public void setUnplayedColor(final int color) {
        this.g.setColor(color);
        this.invalidate(this.a);
    }
    
    public void t() {
        if (this.P.isStarted()) {
            this.P.cancel();
        }
        this.R = false;
        this.Q = 1.0f;
        this.invalidate(this.a);
    }
    
    public void u(final long duration) {
        if (this.P.isStarted()) {
            this.P.cancel();
        }
        this.R = false;
        this.P.setFloatValues(new float[] { this.Q, 1.0f });
        this.P.setDuration(duration);
        this.P.start();
    }
}
