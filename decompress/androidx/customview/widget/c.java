// 
// Decompiled by Procyon v0.6.0
// 

package androidx.customview.widget;

import androidx.core.view.b0;
import java.util.Arrays;
import android.view.MotionEvent;
import android.util.Log;
import android.view.ViewConfiguration;
import android.content.Context;
import android.view.ViewGroup;
import android.view.View;
import android.widget.OverScroller;
import android.view.VelocityTracker;
import android.view.animation.Interpolator;

public class c
{
    private static final Interpolator x;
    private int a;
    private int b;
    private int c;
    private float[] d;
    private float[] e;
    private float[] f;
    private float[] g;
    private int[] h;
    private int[] i;
    private int[] j;
    private int k;
    private VelocityTracker l;
    private float m;
    private float n;
    private int o;
    private final int p;
    private int q;
    private OverScroller r;
    private final c s;
    private View t;
    private boolean u;
    private final ViewGroup v;
    private final Runnable w;
    
    static {
        x = (Interpolator)new Interpolator() {
            public float getInterpolation(float n) {
                --n;
                return n * n * n * n * n + 1.0f;
            }
        };
    }
    
    private c(final Context context, final ViewGroup v, final c s) {
        this.c = -1;
        this.w = new Runnable() {
            final c a;
            
            @Override
            public void run() {
                this.a.J(0);
            }
        };
        if (v == null) {
            throw new IllegalArgumentException("Parent view may not be null");
        }
        if (s != null) {
            this.v = v;
            this.s = s;
            final ViewConfiguration value = ViewConfiguration.get(context);
            final int n = (int)(context.getResources().getDisplayMetrics().density * 20.0f + 0.5f);
            this.p = n;
            this.o = n;
            this.b = value.getScaledTouchSlop();
            this.m = (float)value.getScaledMaximumFlingVelocity();
            this.n = (float)value.getScaledMinimumFlingVelocity();
            this.r = new OverScroller(context, androidx.customview.widget.c.x);
            return;
        }
        throw new IllegalArgumentException("Callback may not be null");
    }
    
    private boolean C(final int n) {
        if (!this.B(n)) {
            final StringBuilder sb = new StringBuilder();
            sb.append("Ignoring pointerId=");
            sb.append(n);
            sb.append(" because ACTION_DOWN was not received for this pointer before ACTION_MOVE. It likely happened because  ViewDragHelper did not receive all the events in the event stream.");
            Log.e("ViewDragHelper", sb.toString());
            return false;
        }
        return true;
    }
    
    private void F() {
        this.l.computeCurrentVelocity(1000, this.m);
        this.p(this.g(this.l.getXVelocity(this.c), this.n, this.m), this.g(this.l.getYVelocity(this.c), this.n, this.m));
    }
    
    private void G(final float n, final float n2, final int n3) {
        int c;
        final boolean b = (c = (this.c(n, n2, n3, 1) ? 1 : 0)) != 0;
        if (this.c(n2, n, n3, 4)) {
            c = ((b ? 1 : 0) | 0x4);
        }
        int n4 = c;
        if (this.c(n, n2, n3, 2)) {
            n4 = (c | 0x2);
        }
        int n5 = n4;
        if (this.c(n2, n, n3, 8)) {
            n5 = (n4 | 0x8);
        }
        if (n5 != 0) {
            final int[] i = this.i;
            i[n3] |= n5;
            this.s.f(n5, n3);
        }
    }
    
    private void H(final float n, final float n2, final int n3) {
        this.s(n3);
        this.d[n3] = (this.f[n3] = n);
        this.e[n3] = (this.g[n3] = n2);
        this.h[n3] = this.x((int)n, (int)n2);
        this.k |= 1 << n3;
    }
    
    private void I(final MotionEvent motionEvent) {
        for (int pointerCount = motionEvent.getPointerCount(), i = 0; i < pointerCount; ++i) {
            final int pointerId = motionEvent.getPointerId(i);
            if (this.C(pointerId)) {
                final float x = motionEvent.getX(i);
                final float y = motionEvent.getY(i);
                this.f[pointerId] = x;
                this.g[pointerId] = y;
            }
        }
    }
    
    private boolean c(float abs, float abs2, final int n, final int n2) {
        abs = Math.abs(abs);
        abs2 = Math.abs(abs2);
        final int n3 = this.h[n];
        boolean b2;
        final boolean b = b2 = false;
        if ((n3 & n2) == n2) {
            b2 = b;
            if ((this.q & n2) != 0x0) {
                b2 = b;
                if ((this.j[n] & n2) != n2) {
                    b2 = b;
                    if ((this.i[n] & n2) != n2) {
                        final int b3 = this.b;
                        if (abs <= b3 && abs2 <= b3) {
                            b2 = b;
                        }
                        else {
                            if (abs < abs2 * 0.5f && this.s.g(n2)) {
                                final int[] j = this.j;
                                j[n] |= n2;
                                return false;
                            }
                            b2 = b;
                            if ((this.i[n] & n2) == 0x0) {
                                b2 = b;
                                if (abs > this.b) {
                                    b2 = true;
                                }
                            }
                        }
                    }
                }
            }
        }
        return b2;
    }
    
    private boolean f(final View view, final float n, final float n2) {
        final boolean b = false;
        final boolean b2 = false;
        boolean b3 = false;
        if (view == null) {
            return false;
        }
        final boolean b4 = this.s.d(view) > 0;
        final boolean b5 = this.s.e(view) > 0;
        if (b4 && b5) {
            final int b6 = this.b;
            if (n * n + n2 * n2 > b6 * b6) {
                b3 = true;
            }
            return b3;
        }
        if (b4) {
            boolean b7 = b;
            if (Math.abs(n) > this.b) {
                b7 = true;
            }
            return b7;
        }
        boolean b8 = b2;
        if (b5) {
            b8 = b2;
            if (Math.abs(n2) > this.b) {
                b8 = true;
            }
        }
        return b8;
    }
    
    private float g(final float n, final float n2, float n3) {
        final float abs = Math.abs(n);
        if (abs < n2) {
            return 0.0f;
        }
        if (abs > n3) {
            if (n <= 0.0f) {
                n3 = -n3;
            }
            return n3;
        }
        return n;
    }
    
    private int h(final int n, final int n2, int n3) {
        final int abs = Math.abs(n);
        if (abs < n2) {
            return 0;
        }
        if (abs > n3) {
            if (n <= 0) {
                n3 = -n3;
            }
            return n3;
        }
        return n;
    }
    
    private void i() {
        final float[] d = this.d;
        if (d == null) {
            return;
        }
        Arrays.fill(d, 0.0f);
        Arrays.fill(this.e, 0.0f);
        Arrays.fill(this.f, 0.0f);
        Arrays.fill(this.g, 0.0f);
        Arrays.fill(this.h, 0);
        Arrays.fill(this.i, 0);
        Arrays.fill(this.j, 0);
        this.k = 0;
    }
    
    private void j(final int n) {
        if (this.d != null) {
            if (this.B(n)) {
                this.d[n] = 0.0f;
                this.e[n] = 0.0f;
                this.f[n] = 0.0f;
                this.g[n] = 0.0f;
                this.h[n] = 0;
                this.i[n] = 0;
                this.j[n] = 0;
                this.k &= ~(1 << n);
            }
        }
    }
    
    private int k(int n, int abs, final int n2) {
        if (n == 0) {
            return 0;
        }
        final int width = this.v.getWidth();
        final int n3 = width / 2;
        final float min = Math.min(1.0f, Math.abs(n) / (float)width);
        final float n4 = (float)n3;
        final float q = this.q(min);
        abs = Math.abs(abs);
        if (abs > 0) {
            n = Math.round(Math.abs((n4 + q * n4) / abs) * 1000.0f) * 4;
        }
        else {
            n = (int)((Math.abs(n) / (float)n2 + 1.0f) * 256.0f);
        }
        return Math.min(n, 600);
    }
    
    private int l(final View view, int k, int i, int h, int abs) {
        final int h2 = this.h(h, (int)this.n, (int)this.m);
        h = this.h(abs, (int)this.n, (int)this.m);
        abs = Math.abs(k);
        final int abs2 = Math.abs(i);
        final int abs3 = Math.abs(h2);
        final int abs4 = Math.abs(h);
        final int n = abs3 + abs4;
        final int n2 = abs + abs2;
        float n3;
        float n4;
        if (h2 != 0) {
            n3 = (float)abs3;
            n4 = (float)n;
        }
        else {
            n3 = (float)abs;
            n4 = (float)n2;
        }
        final float n5 = n3 / n4;
        float n6;
        float n7;
        if (h != 0) {
            n6 = (float)abs4;
            n7 = (float)n;
        }
        else {
            n6 = (float)abs2;
            n7 = (float)n2;
        }
        final float n8 = n6 / n7;
        k = this.k(k, h2, this.s.d(view));
        i = this.k(i, h, this.s.e(view));
        return (int)(k * n5 + i * n8);
    }
    
    public static c n(final ViewGroup viewGroup, final float n, final c c) {
        final c o = o(viewGroup, c);
        o.b *= (int)(1.0f / n);
        return o;
    }
    
    public static c o(final ViewGroup viewGroup, final c c) {
        return new c(viewGroup.getContext(), viewGroup, c);
    }
    
    private void p(final float n, final float n2) {
        this.u = true;
        this.s.l(this.t, n, n2);
        this.u = false;
        if (this.a == 1) {
            this.J(0);
        }
    }
    
    private float q(final float n) {
        return (float)Math.sin((n - 0.5f) * 0.47123894f);
    }
    
    private void r(int b, final int n, final int n2, final int n3) {
        final int left = this.t.getLeft();
        final int top = this.t.getTop();
        int a = b;
        if (n2 != 0) {
            a = this.s.a(this.t, b, n2);
            b0.Z(this.t, a - left);
        }
        b = n;
        if (n3 != 0) {
            b = this.s.b(this.t, n, n3);
            b0.a0(this.t, b - top);
        }
        if (n2 != 0 || n3 != 0) {
            this.s.k(this.t, a, b, a - left, b - top);
        }
    }
    
    private void s(int n) {
        final float[] d = this.d;
        if (d == null || d.length <= n) {
            final float[] d2 = new float[++n];
            final float[] e = new float[n];
            final float[] f = new float[n];
            final float[] g = new float[n];
            final int[] h = new int[n];
            final int[] i = new int[n];
            final int[] j = new int[n];
            if (d != null) {
                System.arraycopy(d, 0, d2, 0, d.length);
                final float[] e2 = this.e;
                System.arraycopy(e2, 0, e, 0, e2.length);
                final float[] f2 = this.f;
                System.arraycopy(f2, 0, f, 0, f2.length);
                final float[] g2 = this.g;
                System.arraycopy(g2, 0, g, 0, g2.length);
                final int[] h2 = this.h;
                System.arraycopy(h2, 0, h, 0, h2.length);
                final int[] k = this.i;
                System.arraycopy(k, 0, i, 0, k.length);
                final int[] l = this.j;
                System.arraycopy(l, 0, j, 0, l.length);
            }
            this.d = d2;
            this.e = e;
            this.f = f;
            this.g = g;
            this.h = h;
            this.i = i;
            this.j = j;
        }
    }
    
    private boolean u(int n, int n2, int l, final int n3) {
        final int left = this.t.getLeft();
        final int top = this.t.getTop();
        n -= left;
        n2 -= top;
        if (n == 0 && n2 == 0) {
            this.r.abortAnimation();
            this.J(0);
            return false;
        }
        l = this.l(this.t, n, n2, l, n3);
        this.r.startScroll(left, top, n, n2, l);
        this.J(2);
        return true;
    }
    
    private int x(int n, final int n2) {
        int n3;
        final boolean b = (n3 = ((n < this.v.getLeft() + this.o) ? 1 : 0)) != 0;
        if (n2 < this.v.getTop() + this.o) {
            n3 = ((b ? 1 : 0) | 0x4);
        }
        int n4 = n3;
        if (n > this.v.getRight() - this.o) {
            n4 = (n3 | 0x2);
        }
        n = n4;
        if (n2 > this.v.getBottom() - this.o) {
            n = (n4 | 0x8);
        }
        return n;
    }
    
    public boolean A(final int n, final int n2) {
        return this.D(this.t, n, n2);
    }
    
    public boolean B(final int n) {
        final int k = this.k;
        boolean b = true;
        if ((1 << n & k) == 0x0) {
            b = false;
        }
        return b;
    }
    
    public boolean D(final View view, final int n, final int n2) {
        final boolean b = false;
        if (view == null) {
            return false;
        }
        boolean b2 = b;
        if (n >= view.getLeft()) {
            b2 = b;
            if (n < view.getRight()) {
                b2 = b;
                if (n2 >= view.getTop()) {
                    b2 = b;
                    if (n2 < view.getBottom()) {
                        b2 = true;
                    }
                }
            }
        }
        return b2;
    }
    
    public void E(final MotionEvent motionEvent) {
        final int actionMasked = motionEvent.getActionMasked();
        final int actionIndex = motionEvent.getActionIndex();
        if (actionMasked == 0) {
            this.a();
        }
        if (this.l == null) {
            this.l = VelocityTracker.obtain();
        }
        this.l.addMovement(motionEvent);
        final int n = 0;
        int i = 0;
        if (actionMasked != 0) {
            if (actionMasked != 1) {
                if (actionMasked != 2) {
                    if (actionMasked != 3) {
                        if (actionMasked != 5) {
                            if (actionMasked == 6) {
                                final int pointerId = motionEvent.getPointerId(actionIndex);
                                Label_0222: {
                                    if (this.a == 1 && pointerId == this.c) {
                                        while (true) {
                                            while (i < motionEvent.getPointerCount()) {
                                                final int pointerId2 = motionEvent.getPointerId(i);
                                                if (pointerId2 != this.c) {
                                                    final View t = this.t((int)motionEvent.getX(i), (int)motionEvent.getY(i));
                                                    final View t2 = this.t;
                                                    if (t == t2 && this.O(t2, pointerId2)) {
                                                        final int c = this.c;
                                                        if (c == -1) {
                                                            this.F();
                                                        }
                                                        break Label_0222;
                                                    }
                                                }
                                                ++i;
                                            }
                                            final int c = -1;
                                            continue;
                                        }
                                    }
                                }
                                this.j(pointerId);
                            }
                        }
                        else {
                            final int pointerId3 = motionEvent.getPointerId(actionIndex);
                            final float x = motionEvent.getX(actionIndex);
                            final float y = motionEvent.getY(actionIndex);
                            this.H(x, y, pointerId3);
                            if (this.a == 0) {
                                this.O(this.t((int)x, (int)y), pointerId3);
                                final int n2 = this.h[pointerId3];
                                final int q = this.q;
                                if ((n2 & q) != 0x0) {
                                    this.s.h(n2 & q, pointerId3);
                                }
                            }
                            else if (this.A((int)x, (int)y)) {
                                this.O(this.t, pointerId3);
                            }
                        }
                    }
                    else {
                        if (this.a == 1) {
                            this.p(0.0f, 0.0f);
                        }
                        this.a();
                    }
                }
                else if (this.a == 1) {
                    if (this.C(this.c)) {
                        final int pointerIndex = motionEvent.findPointerIndex(this.c);
                        final float x2 = motionEvent.getX(pointerIndex);
                        final float y2 = motionEvent.getY(pointerIndex);
                        final float[] f = this.f;
                        final int c2 = this.c;
                        final int n3 = (int)(x2 - f[c2]);
                        final int n4 = (int)(y2 - this.g[c2]);
                        this.r(this.t.getLeft() + n3, this.t.getTop() + n4, n3, n4);
                        this.I(motionEvent);
                    }
                }
                else {
                    for (int pointerCount = motionEvent.getPointerCount(), j = n; j < pointerCount; ++j) {
                        final int pointerId4 = motionEvent.getPointerId(j);
                        if (this.C(pointerId4)) {
                            final float x3 = motionEvent.getX(j);
                            final float y3 = motionEvent.getY(j);
                            final float n5 = x3 - this.d[pointerId4];
                            final float n6 = y3 - this.e[pointerId4];
                            this.G(n5, n6, pointerId4);
                            if (this.a == 1) {
                                break;
                            }
                            final View t3 = this.t((int)x3, (int)y3);
                            if (this.f(t3, n5, n6) && this.O(t3, pointerId4)) {
                                break;
                            }
                        }
                    }
                    this.I(motionEvent);
                }
            }
            else {
                if (this.a == 1) {
                    this.F();
                }
                this.a();
            }
        }
        else {
            final float x4 = motionEvent.getX();
            final float y4 = motionEvent.getY();
            final int pointerId5 = motionEvent.getPointerId(0);
            final View t4 = this.t((int)x4, (int)y4);
            this.H(x4, y4, pointerId5);
            this.O(t4, pointerId5);
            final int n7 = this.h[pointerId5];
            final int q2 = this.q;
            if ((n7 & q2) != 0x0) {
                this.s.h(n7 & q2, pointerId5);
            }
        }
    }
    
    void J(final int a) {
        this.v.removeCallbacks(this.w);
        if (this.a != a) {
            this.a = a;
            this.s.j(a);
            if (this.a == 0) {
                this.t = null;
            }
        }
    }
    
    public void K(final int o) {
        this.o = o;
    }
    
    public boolean L(final int n, final int n2) {
        if (this.u) {
            return this.u(n, n2, (int)this.l.getXVelocity(this.c), (int)this.l.getYVelocity(this.c));
        }
        throw new IllegalStateException("Cannot settleCapturedViewAt outside of a call to Callback#onViewReleased");
    }
    
    public boolean M(final MotionEvent motionEvent) {
        final int actionMasked = motionEvent.getActionMasked();
        final int actionIndex = motionEvent.getActionIndex();
        if (actionMasked == 0) {
            this.a();
        }
        if (this.l == null) {
            this.l = VelocityTracker.obtain();
        }
        this.l.addMovement(motionEvent);
        Label_0615: {
            if (actionMasked != 0) {
                Label_0513: {
                    if (actionMasked == 1) {
                        break Label_0513;
                    }
                    if (actionMasked != 2) {
                        if (actionMasked == 3) {
                            break Label_0513;
                        }
                        if (actionMasked != 5) {
                            if (actionMasked == 6) {
                                this.j(motionEvent.getPointerId(actionIndex));
                            }
                        }
                        else {
                            final int pointerId = motionEvent.getPointerId(actionIndex);
                            final float x = motionEvent.getX(actionIndex);
                            final float y = motionEvent.getY(actionIndex);
                            this.H(x, y, pointerId);
                            final int a = this.a;
                            if (a == 0) {
                                final int n = this.h[pointerId];
                                final int q = this.q;
                                if ((n & q) != 0x0) {
                                    this.s.h(n & q, pointerId);
                                }
                            }
                            else if (a == 2) {
                                final View t = this.t((int)x, (int)y);
                                if (t == this.t) {
                                    this.O(t, pointerId);
                                }
                            }
                        }
                    }
                    else if (this.d != null) {
                        if (this.e != null) {
                            for (int pointerCount = motionEvent.getPointerCount(), i = 0; i < pointerCount; ++i) {
                                final int pointerId2 = motionEvent.getPointerId(i);
                                if (this.C(pointerId2)) {
                                    final float x2 = motionEvent.getX(i);
                                    final float y2 = motionEvent.getY(i);
                                    final float n2 = x2 - this.d[pointerId2];
                                    final float n3 = y2 - this.e[pointerId2];
                                    final View t2 = this.t((int)x2, (int)y2);
                                    final boolean b = t2 != null && this.f(t2, n2, n3);
                                    if (b) {
                                        final int left = t2.getLeft();
                                        final int n4 = (int)n2;
                                        final int a2 = this.s.a(t2, left + n4, n4);
                                        final int top = t2.getTop();
                                        final int n5 = (int)n3;
                                        final int b2 = this.s.b(t2, top + n5, n5);
                                        final int d = this.s.d(t2);
                                        final int e = this.s.e(t2);
                                        if (d == 0 || (d > 0 && a2 == left)) {
                                            if (e == 0) {
                                                break;
                                            }
                                            if (e > 0 && b2 == top) {
                                                break;
                                            }
                                        }
                                    }
                                    this.G(n2, n3, pointerId2);
                                    if (this.a == 1) {
                                        break;
                                    }
                                    if (b && this.O(t2, pointerId2)) {
                                        break;
                                    }
                                }
                            }
                            this.I(motionEvent);
                        }
                    }
                    break Label_0615;
                }
                this.a();
            }
            else {
                final float x3 = motionEvent.getX();
                final float y3 = motionEvent.getY();
                final int pointerId3 = motionEvent.getPointerId(0);
                this.H(x3, y3, pointerId3);
                final View t3 = this.t((int)x3, (int)y3);
                if (t3 == this.t && this.a == 2) {
                    this.O(t3, pointerId3);
                }
                final int n6 = this.h[pointerId3];
                final int q2 = this.q;
                if ((n6 & q2) != 0x0) {
                    this.s.h(n6 & q2, pointerId3);
                }
            }
        }
        boolean b3 = false;
        if (this.a == 1) {
            b3 = true;
        }
        return b3;
    }
    
    public boolean N(final View t, final int n, final int n2) {
        this.t = t;
        this.c = -1;
        final boolean u = this.u(n, n2, 0, 0);
        if (!u && this.a == 0 && this.t != null) {
            this.t = null;
        }
        return u;
    }
    
    boolean O(final View view, final int c) {
        if (view == this.t && this.c == c) {
            return true;
        }
        if (view != null && this.s.m(view, c)) {
            this.b(view, this.c = c);
            return true;
        }
        return false;
    }
    
    public void a() {
        this.c = -1;
        this.i();
        final VelocityTracker l = this.l;
        if (l != null) {
            l.recycle();
            this.l = null;
        }
    }
    
    public void b(final View t, final int c) {
        if (t.getParent() == this.v) {
            this.t = t;
            this.c = c;
            this.s.i(t, c);
            this.J(1);
            return;
        }
        final StringBuilder sb = new StringBuilder();
        sb.append("captureChildView: parameter must be a descendant of the ViewDragHelper's tracked parent view (");
        sb.append(this.v);
        sb.append(")");
        throw new IllegalArgumentException(sb.toString());
    }
    
    public boolean d(final int n) {
        for (int length = this.d.length, i = 0; i < length; ++i) {
            if (this.e(n, i)) {
                return true;
            }
        }
        return false;
    }
    
    public boolean e(int b, final int n) {
        final boolean b2 = this.B(n);
        final boolean b3 = false;
        final boolean b4 = false;
        boolean b5 = false;
        if (!b2) {
            return false;
        }
        final boolean b6 = (b & 0x1) == 0x1;
        if ((b & 0x2) == 0x2) {
            b = 1;
        }
        else {
            b = 0;
        }
        final float n2 = this.f[n] - this.d[n];
        final float n3 = this.g[n] - this.e[n];
        if (b6 && b != 0) {
            b = this.b;
            if (n2 * n2 + n3 * n3 > b * b) {
                b5 = true;
            }
            return b5;
        }
        if (b6) {
            boolean b7 = b3;
            if (Math.abs(n2) > this.b) {
                b7 = true;
            }
            return b7;
        }
        boolean b8 = b4;
        if (b != 0) {
            b8 = b4;
            if (Math.abs(n3) > this.b) {
                b8 = true;
            }
        }
        return b8;
    }
    
    public boolean m(final boolean b) {
        final int a = this.a;
        final boolean b2 = false;
        if (a == 2) {
            final boolean computeScrollOffset = this.r.computeScrollOffset();
            final int currX = this.r.getCurrX();
            final int currY = this.r.getCurrY();
            final int n = currX - this.t.getLeft();
            final int n2 = currY - this.t.getTop();
            if (n != 0) {
                b0.Z(this.t, n);
            }
            if (n2 != 0) {
                b0.a0(this.t, n2);
            }
            if (n != 0 || n2 != 0) {
                this.s.k(this.t, currX, currY, n, n2);
            }
            boolean b3 = computeScrollOffset;
            if (computeScrollOffset) {
                b3 = computeScrollOffset;
                if (currX == this.r.getFinalX()) {
                    b3 = computeScrollOffset;
                    if (currY == this.r.getFinalY()) {
                        this.r.abortAnimation();
                        b3 = false;
                    }
                }
            }
            if (!b3) {
                if (b) {
                    this.v.post(this.w);
                }
                else {
                    this.J(0);
                }
            }
        }
        boolean b4 = b2;
        if (this.a == 2) {
            b4 = true;
        }
        return b4;
    }
    
    public View t(final int n, final int n2) {
        for (int i = this.v.getChildCount() - 1; i >= 0; --i) {
            final View child = this.v.getChildAt(this.s.c(i));
            if (n >= child.getLeft() && n < child.getRight() && n2 >= child.getTop() && n2 < child.getBottom()) {
                return child;
            }
        }
        return null;
    }
    
    public int v() {
        return this.p;
    }
    
    public int w() {
        return this.o;
    }
    
    public int y() {
        return this.b;
    }
    
    public int z() {
        return this.a;
    }
    
    public abstract static class c
    {
        public abstract int a(final View p0, final int p1, final int p2);
        
        public abstract int b(final View p0, final int p1, final int p2);
        
        public int c(final int n) {
            return n;
        }
        
        public int d(final View view) {
            return 0;
        }
        
        public int e(final View view) {
            return 0;
        }
        
        public void f(final int n, final int n2) {
        }
        
        public boolean g(final int n) {
            return false;
        }
        
        public void h(final int n, final int n2) {
        }
        
        public void i(final View view, final int n) {
        }
        
        public abstract void j(final int p0);
        
        public abstract void k(final View p0, final int p1, final int p2, final int p3, final int p4);
        
        public abstract void l(final View p0, final float p1, final float p2);
        
        public abstract boolean m(final View p0, final int p1);
    }
}
