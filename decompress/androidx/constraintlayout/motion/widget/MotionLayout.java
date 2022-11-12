// 
// Decompiled by Procyon v0.6.0
// 

package androidx.constraintlayout.motion.widget;

import android.view.VelocityTracker;
import android.graphics.PathEffect;
import android.graphics.Paint$Style;
import android.graphics.Rect;
import android.graphics.DashPathEffect;
import android.graphics.Path;
import android.content.Context;
import android.view.Display;
import java.util.Objects;
import android.os.Bundle;
import android.graphics.Paint;
import android.graphics.Canvas;
import android.util.Log;
import androidx.constraintlayout.widget.c;
import androidx.constraintlayout.widget.j;
import android.util.SparseArray;
import android.view.ViewGroup;
import android.view.MotionEvent;
import java.util.Iterator;
import o.d;
import java.util.HashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import android.view.animation.Interpolator;
import java.util.ArrayList;
import android.graphics.Matrix;
import android.view.View;
import android.graphics.RectF;
import androidx.core.view.t;
import androidx.constraintlayout.widget.ConstraintLayout;

public class MotionLayout extends ConstraintLayout implements t
{
    public static boolean E0;
    private long A;
    private RectF A0;
    float B;
    private View B0;
    private boolean C;
    private Matrix C0;
    boolean D;
    ArrayList<Integer> D0;
    private i E;
    private float F;
    private float G;
    int H;
    e I;
    private boolean J;
    private androidx.constraintlayout.motion.widget.b K;
    int L;
    int M;
    int N;
    int O;
    boolean P;
    float Q;
    float R;
    long S;
    float T;
    private boolean U;
    private ArrayList<n> V;
    private ArrayList<n> W;
    q a;
    private ArrayList<n> a0;
    Interpolator b;
    private CopyOnWriteArrayList<i> b0;
    Interpolator c;
    private int c0;
    float d;
    private long d0;
    private int e;
    private float e0;
    int f;
    private int f0;
    private int g;
    private float g0;
    private int h;
    boolean h0;
    private int i;
    protected boolean i0;
    private boolean j;
    int j0;
    int k0;
    int l0;
    int m0;
    int n0;
    int o0;
    HashMap<View, m> p;
    float p0;
    private d q0;
    private boolean r0;
    private h s0;
    private Runnable t0;
    private int[] u0;
    int v0;
    private long w;
    private int w0;
    private float x;
    private boolean x0;
    float y;
    TransitionState y0;
    float z;
    private boolean z0;
    
    private void A() {
        if (this.E == null) {
            final CopyOnWriteArrayList<i> b0 = this.b0;
            if (b0 == null || b0.isEmpty()) {
                return;
            }
        }
        this.h0 = false;
        for (final Integer n : this.D0) {
            final i e = this.E;
            if (e != null) {
                e.b(this, n);
            }
            final CopyOnWriteArrayList<i> b2 = this.b0;
            if (b2 != null) {
                final Iterator<i> iterator2 = b2.iterator();
                while (iterator2.hasNext()) {
                    iterator2.next().b(this, n);
                }
            }
        }
        this.D0.clear();
    }
    
    private static boolean O(final float n, final float n2, final float n3) {
        final boolean b = true;
        boolean b2 = true;
        if (n > 0.0f) {
            final float n4 = n / n3;
            if (n2 + (n * n4 - n3 * n4 * n4 / 2.0f) <= 1.0f) {
                b2 = false;
            }
            return b2;
        }
        final float n5 = -n / n3;
        return n2 + (n * n5 + n3 * n5 * n5 / 2.0f) < 0.0f && b;
    }
    
    static h a(final MotionLayout motionLayout) {
        return motionLayout.s0;
    }
    
    static int b(final MotionLayout motionLayout) {
        return motionLayout.g;
    }
    
    static int c(final MotionLayout motionLayout) {
        return motionLayout.e;
    }
    
    private boolean f(final View view, MotionEvent obtain, final float n, final float n2) {
        final Matrix matrix = view.getMatrix();
        if (matrix.isIdentity()) {
            obtain.offsetLocation(n, n2);
            final boolean onTouchEvent = view.onTouchEvent(obtain);
            obtain.offsetLocation(-n, -n2);
            return onTouchEvent;
        }
        obtain = MotionEvent.obtain(obtain);
        obtain.offsetLocation(n, n2);
        if (this.C0 == null) {
            this.C0 = new Matrix();
        }
        matrix.invert(this.C0);
        obtain.transform(this.C0);
        final boolean onTouchEvent2 = view.onTouchEvent(obtain);
        obtain.recycle();
        return onTouchEvent2;
    }
    
    private void l() {
        final float signum = Math.signum(this.B - this.z);
        final long nanoTime = this.getNanoTime();
        final Interpolator b = this.b;
        float n = this.z + (nanoTime - this.A) * signum * 1.0E-9f / this.x;
        if (this.C) {
            n = this.B;
        }
        final float n2 = fcmpl(signum, 0.0f);
        final int n3 = 0;
        boolean b2;
        if ((n2 > 0 && n >= this.B) || (signum <= 0.0f && n <= this.B)) {
            n = this.B;
            b2 = true;
        }
        else {
            b2 = false;
        }
        float n4 = n;
        if (b != null) {
            n4 = n;
            if (!b2) {
                if (this.J) {
                    n4 = b.getInterpolation((nanoTime - this.w) * 1.0E-9f);
                }
                else {
                    n4 = b.getInterpolation(n);
                }
            }
        }
        float p0 = 0.0f;
        Label_0204: {
            if (n2 <= 0 || n4 < this.B) {
                p0 = n4;
                if (signum > 0.0f) {
                    break Label_0204;
                }
                p0 = n4;
                if (n4 > this.B) {
                    break Label_0204;
                }
            }
            p0 = this.B;
        }
        this.p0 = p0;
        final int childCount = this.getChildCount();
        final long nanoTime2 = this.getNanoTime();
        final Interpolator c = this.c;
        int i;
        if (c == null) {
            i = n3;
        }
        else {
            p0 = c.getInterpolation(p0);
            i = n3;
        }
        while (i < childCount) {
            final View child = this.getChildAt(i);
            final m m = this.p.get(child);
            if (m != null) {
                m.q(child, p0, nanoTime2, this.q0);
            }
            ++i;
        }
        if (this.i0) {
            this.requestLayout();
        }
    }
    
    private void p() {
        if (this.E == null) {
            final CopyOnWriteArrayList<i> b0 = this.b0;
            if (b0 == null || b0.isEmpty()) {
                return;
            }
        }
        if (this.g0 != this.y) {
            if (this.f0 != -1) {
                final i e = this.E;
                if (e != null) {
                    e.c(this, this.e, this.g);
                }
                final CopyOnWriteArrayList<i> b2 = this.b0;
                if (b2 != null) {
                    final Iterator<i> iterator = b2.iterator();
                    while (iterator.hasNext()) {
                        iterator.next().c(this, this.e, this.g);
                    }
                }
                this.h0 = true;
            }
            this.f0 = -1;
            final float y = this.y;
            this.g0 = y;
            final i e2 = this.E;
            if (e2 != null) {
                e2.a(this, this.e, this.g, y);
            }
            final CopyOnWriteArrayList<i> b3 = this.b0;
            if (b3 != null) {
                final Iterator<i> iterator2 = b3.iterator();
                while (iterator2.hasNext()) {
                    iterator2.next().a(this, this.e, this.g, this.y);
                }
            }
            this.h0 = true;
        }
    }
    
    private boolean w(final float n, final float n2, final View view, final MotionEvent motionEvent) {
        final boolean b = view instanceof ViewGroup;
        final boolean b2 = true;
        boolean b3 = false;
        Label_0097: {
            if (b) {
                final ViewGroup viewGroup = (ViewGroup)view;
                for (int i = viewGroup.getChildCount() - 1; i >= 0; --i) {
                    final View child = viewGroup.getChildAt(i);
                    if (this.w(child.getLeft() + n - view.getScrollX(), child.getTop() + n2 - view.getScrollY(), child, motionEvent)) {
                        b3 = true;
                        break Label_0097;
                    }
                }
            }
            b3 = false;
        }
        if (!b3) {
            this.A0.set(n, n2, view.getRight() + n - view.getLeft(), view.getBottom() + n2 - view.getTop());
            if ((motionEvent.getAction() != 0 || this.A0.contains(motionEvent.getX(), motionEvent.getY())) && this.f(view, motionEvent, -n, -n2)) {
                b3 = b2;
            }
        }
        return b3;
    }
    
    public void B() {
        throw null;
    }
    
    public void C(float progress, float d) {
        if (!this.isAttachedToWindow()) {
            if (this.s0 == null) {
                this.s0 = new h();
            }
            this.s0.e(progress);
            this.s0.h(d);
            return;
        }
        this.setProgress(progress);
        this.setState(TransitionState.MOVING);
        this.d = d;
        final float n = 0.0f;
        final float n2 = 0.0f;
        final float n3 = fcmpl(d, 0.0f);
        if (n3 != 0) {
            progress = n2;
            if (n3 > 0) {
                progress = 1.0f;
            }
            this.d(progress);
        }
        else if (progress != 0.0f && progress != 1.0f) {
            d = n;
            if (progress > 0.5f) {
                d = 1.0f;
            }
            this.d(d);
        }
    }
    
    public void D(final int e, final int g) {
        if (!this.isAttachedToWindow()) {
            if (this.s0 == null) {
                this.s0 = new h();
            }
            this.s0.f(e);
            this.s0.d(g);
            return;
        }
        final q a = this.a;
        if (a == null) {
            return;
        }
        a.T(this.e = e, this.g = g);
        this.a.j(e);
        this.a.j(g);
        throw null;
    }
    
    public void E(final int n, final float b, final float n2) {
        if (this.a == null) {
            return;
        }
        if (this.z == b) {
            return;
        }
        this.J = true;
        this.w = this.getNanoTime();
        this.x = this.a.n() / 1000.0f;
        this.B = b;
        this.D = true;
        if (n != 0 && n != 1 && n != 2) {
            if (n == 4) {
                this.a.r();
                throw null;
            }
            if (n != 5) {
                if (n != 6 && n != 7) {
                    this.C = false;
                    this.w = this.getNanoTime();
                    this.invalidate();
                    return;
                }
            }
            else {
                if (O(n2, this.z, this.a.r())) {
                    this.a.r();
                    throw null;
                }
                this.a.r();
                this.a.s();
                throw null;
            }
        }
        if (this.a.i() == 0) {
            this.a.r();
            this.a.s();
            throw null;
        }
        this.a.y();
        this.a.z();
        this.a.x();
        this.a.A();
        this.a.w();
        throw null;
    }
    
    public void F() {
        this.d(1.0f);
        this.t0 = null;
    }
    
    public void G(final Runnable t0) {
        this.d(1.0f);
        this.t0 = t0;
    }
    
    public void H() {
        this.d(0.0f);
    }
    
    public void I(final int n) {
        if (!this.isAttachedToWindow()) {
            if (this.s0 == null) {
                this.s0 = new h();
            }
            this.s0.d(n);
            return;
        }
        this.J(n, -1, -1);
    }
    
    public void J(final int n, final int n2, final int n3) {
        this.K(n, n2, n3, -1);
    }
    
    public void K(int i, int n, final int n2, final int n3) {
        final q a = this.a;
        int g = i;
        if (a != null) {
            final j b = a.b;
            g = i;
            if (b != null) {
                n = b.a(this.f, i, (float)n, (float)n2);
                g = i;
                if (n != -1) {
                    g = n;
                }
            }
        }
        i = this.f;
        if (i == g) {
            return;
        }
        if (this.e == g) {
            this.d(0.0f);
            if (n3 > 0) {
                this.x = n3 / 1000.0f;
            }
            return;
        }
        if (this.g == g) {
            this.d(1.0f);
            if (n3 > 0) {
                this.x = n3 / 1000.0f;
            }
            return;
        }
        this.g = g;
        if (i != -1) {
            this.D(i, g);
            this.d(1.0f);
            this.z = 0.0f;
            this.F();
            if (n3 > 0) {
                this.x = n3 / 1000.0f;
            }
            return;
        }
        i = 0;
        this.J = false;
        this.B = 1.0f;
        this.y = 0.0f;
        this.z = 0.0f;
        this.A = this.getNanoTime();
        this.w = this.getNanoTime();
        this.C = false;
        this.b = null;
        if (n3 == -1) {
            this.x = this.a.n() / 1000.0f;
        }
        this.e = -1;
        this.a.T(-1, this.g);
        final SparseArray sparseArray = new SparseArray();
        if (n3 == 0) {
            this.x = this.a.n() / 1000.0f;
        }
        else if (n3 > 0) {
            this.x = n3 / 1000.0f;
        }
        n = this.getChildCount();
        this.p.clear();
        while (i < n) {
            final View child = this.getChildAt(i);
            this.p.put(child, new m(child));
            sparseArray.put(child.getId(), (Object)this.p.get(child));
            ++i;
        }
        this.D = true;
        this.a.j(g);
        throw null;
    }
    
    public void L() {
        this.a.j(this.e);
        this.a.j(this.g);
        throw null;
    }
    
    public void M(final int n, final androidx.constraintlayout.widget.c c) {
        final q a = this.a;
        if (a != null) {
            a.Q(n, c);
        }
        this.L();
        if (this.f == n) {
            c.i(this);
        }
    }
    
    public void N(final int n, final View... array) {
        final q a = this.a;
        if (a != null) {
            a.Y(n, array);
        }
        else {
            Log.e("MotionLayout", " no motionScene");
        }
    }
    
    void d(final float b) {
        final q a = this.a;
        if (a == null) {
            return;
        }
        final float z = this.z;
        final float y = this.y;
        if (z != y && this.C) {
            this.z = y;
        }
        final float z2 = this.z;
        if (z2 == b) {
            return;
        }
        this.J = false;
        this.B = b;
        this.x = a.n() / 1000.0f;
        this.setProgress(this.B);
        this.b = null;
        this.c = this.a.q();
        this.C = false;
        this.w = this.getNanoTime();
        this.D = true;
        this.y = z2;
        this.z = z2;
        this.invalidate();
    }
    
    @Override
    protected void dispatchDraw(final Canvas canvas) {
        final ArrayList<n> a0 = this.a0;
        if (a0 != null) {
            final Iterator<n> iterator = a0.iterator();
            while (iterator.hasNext()) {
                iterator.next().j(canvas);
            }
        }
        this.h(false);
        final q a2 = this.a;
        if (a2 != null) {
            final u s = a2.s;
            if (s != null) {
                s.c();
            }
        }
        super.dispatchDraw(canvas);
        if (this.a == null) {
            return;
        }
        if ((this.H & 0x1) == 0x1 && !this.isInEditMode()) {
            ++this.c0;
            final long nanoTime = this.getNanoTime();
            final long d0 = this.d0;
            if (d0 != -1L) {
                final long n = nanoTime - d0;
                if (n > 200000000L) {
                    this.e0 = (int)(this.c0 / (n * 1.0E-9f) * 100.0f) / 100.0f;
                    this.c0 = 0;
                    this.d0 = nanoTime;
                }
            }
            else {
                this.d0 = nanoTime;
            }
            final Paint paint = new Paint();
            paint.setTextSize(42.0f);
            final float n2 = (int)(this.getProgress() * 1000.0f) / 10.0f;
            final StringBuilder sb = new StringBuilder();
            sb.append(this.e0);
            sb.append(" fps ");
            sb.append(androidx.constraintlayout.motion.widget.a.d(this, this.e));
            sb.append(" -> ");
            final String string = sb.toString();
            final StringBuilder sb2 = new StringBuilder();
            sb2.append(string);
            sb2.append(androidx.constraintlayout.motion.widget.a.d(this, this.g));
            sb2.append(" (progress: ");
            sb2.append(n2);
            sb2.append(" ) state=");
            final int f = this.f;
            String d2;
            if (f == -1) {
                d2 = "undefined";
            }
            else {
                d2 = androidx.constraintlayout.motion.widget.a.d(this, f);
            }
            sb2.append(d2);
            final String string2 = sb2.toString();
            paint.setColor(-16777216);
            canvas.drawText(string2, 11.0f, (float)(this.getHeight() - 29), paint);
            paint.setColor(-7864184);
            canvas.drawText(string2, 10.0f, (float)(this.getHeight() - 30), paint);
        }
        if (this.H > 1) {
            if (this.I == null) {
                this.I = new e();
            }
            this.I.a(canvas, this.p, this.a.n(), this.H);
        }
        final ArrayList<n> a3 = this.a0;
        if (a3 != null) {
            final Iterator<n> iterator2 = a3.iterator();
            while (iterator2.hasNext()) {
                iterator2.next().i(canvas);
            }
        }
    }
    
    void g(final boolean b) {
        for (int childCount = this.getChildCount(), i = 0; i < childCount; ++i) {
            final m m = this.p.get(this.getChildAt(i));
            if (m != null) {
                m.e(b);
            }
        }
    }
    
    public int[] getConstraintSetIds() {
        final q a = this.a;
        if (a == null) {
            return null;
        }
        return a.l();
    }
    
    public int getCurrentState() {
        return this.f;
    }
    
    public ArrayList<q.b> getDefinedTransitions() {
        final q a = this.a;
        if (a == null) {
            return null;
        }
        return a.m();
    }
    
    public androidx.constraintlayout.motion.widget.b getDesignTool() {
        if (this.K == null) {
            this.K = new androidx.constraintlayout.motion.widget.b(this);
        }
        return this.K;
    }
    
    public int getEndState() {
        return this.g;
    }
    
    protected long getNanoTime() {
        return System.nanoTime();
    }
    
    public float getProgress() {
        return this.z;
    }
    
    public q getScene() {
        return this.a;
    }
    
    public int getStartState() {
        return this.e;
    }
    
    public float getTargetPosition() {
        return this.B;
    }
    
    public Bundle getTransitionState() {
        if (this.s0 == null) {
            this.s0 = new h();
        }
        this.s0.c();
        return this.s0.b();
    }
    
    public long getTransitionTimeMs() {
        final q a = this.a;
        if (a != null) {
            this.x = a.n() / 1000.0f;
        }
        return (long)(this.x * 1000.0f);
    }
    
    public float getVelocity() {
        return this.d;
    }
    
    void h(final boolean b) {
        if (this.A == -1L) {
            this.A = this.getNanoTime();
        }
        final float z = this.z;
        if (z > 0.0f && z < 1.0f) {
            this.f = -1;
        }
        final boolean u = this.U;
        boolean b2 = false;
        Label_1049: {
            Label_0081: {
                if (!u) {
                    if (this.D) {
                        if (b) {
                            break Label_0081;
                        }
                        if (this.B != z) {
                            break Label_0081;
                        }
                    }
                    break Label_1049;
                }
            }
            final float signum = Math.signum(this.B - z);
            final long nanoTime = this.getNanoTime();
            final Interpolator b3 = this.b;
            float d;
            if (!(b3 instanceof o)) {
                d = (nanoTime - this.A) * signum * 1.0E-9f / this.x;
            }
            else {
                d = 0.0f;
            }
            float n = this.z + d;
            if (this.C) {
                n = this.B;
            }
            final float n2 = fcmpl(signum, 0.0f);
            boolean b4;
            if ((n2 > 0 && n >= this.B) || (signum <= 0.0f && n <= this.B)) {
                n = this.B;
                this.D = false;
                b4 = true;
            }
            else {
                b4 = false;
            }
            this.z = n;
            this.y = n;
            this.A = nanoTime;
            if (b3 != null && !b4) {
                if (this.J) {
                    float interpolation = b3.getInterpolation((nanoTime - this.w) * 1.0E-9f);
                    final Interpolator b5 = this.b;
                    Objects.requireNonNull(b5);
                    this.z = interpolation;
                    this.A = nanoTime;
                    n = interpolation;
                    if (b5 instanceof o) {
                        final float a = ((o)b5).a();
                        Math.abs(this.d = a);
                        final float x = this.x;
                        if (a > 0.0f && interpolation >= 1.0f) {
                            this.z = 1.0f;
                            this.D = false;
                            interpolation = 1.0f;
                        }
                        n = interpolation;
                        if (a < 0.0f) {
                            n = interpolation;
                            if (interpolation <= 0.0f) {
                                this.z = 0.0f;
                                this.D = false;
                                n = 0.0f;
                            }
                        }
                    }
                }
                else {
                    final float interpolation2 = b3.getInterpolation(n);
                    final Interpolator b6 = this.b;
                    if (b6 instanceof o) {
                        this.d = ((o)b6).a();
                        n = interpolation2;
                    }
                    else {
                        this.d = (b6.getInterpolation(n + d) - interpolation2) * signum / d;
                        n = interpolation2;
                    }
                }
            }
            else {
                this.d = d;
            }
            if (Math.abs(this.d) > 1.0E-5f) {
                this.setState(TransitionState.MOVING);
            }
            float b7 = 0.0f;
            Label_0523: {
                if (n2 <= 0 || n < this.B) {
                    b7 = n;
                    if (signum > 0.0f) {
                        break Label_0523;
                    }
                    b7 = n;
                    if (n > this.B) {
                        break Label_0523;
                    }
                }
                b7 = this.B;
                this.D = false;
            }
            if (b7 >= 1.0f || b7 <= 0.0f) {
                this.D = false;
                this.setState(TransitionState.FINISHED);
            }
            final int childCount = this.getChildCount();
            this.U = false;
            final long nanoTime2 = this.getNanoTime();
            this.p0 = b7;
            final Interpolator c = this.c;
            float interpolation3;
            if (c == null) {
                interpolation3 = b7;
            }
            else {
                interpolation3 = c.getInterpolation(b7);
            }
            final Interpolator c2 = this.c;
            if (c2 != null) {
                final float interpolation4 = c2.getInterpolation(signum / this.x + b7);
                this.d = interpolation4;
                this.d = interpolation4 - this.c.getInterpolation(b7);
            }
            for (int i = 0; i < childCount; ++i) {
                final View child = this.getChildAt(i);
                final m m = this.p.get(child);
                if (m != null) {
                    this.U |= m.q(child, interpolation3, nanoTime2, this.q0);
                }
            }
            final boolean b8 = (n2 > 0 && b7 >= this.B) || (signum <= 0.0f && b7 <= this.B);
            if (!this.U && !this.D && b8) {
                this.setState(TransitionState.FINISHED);
            }
            if (this.i0) {
                this.requestLayout();
            }
            this.U |= (b8 ^ true);
            boolean b9 = false;
            Label_0869: {
                if (b7 <= 0.0f) {
                    final int e = this.e;
                    if (e != -1 && this.f != e) {
                        this.f = e;
                        this.a.j(e).g(this);
                        this.setState(TransitionState.FINISHED);
                        b9 = true;
                        break Label_0869;
                    }
                }
                b9 = false;
            }
            boolean b10 = b9;
            if (b7 >= 1.0) {
                final int f = this.f;
                final int g = this.g;
                b10 = b9;
                if (f != g) {
                    this.f = g;
                    this.a.j(g).g(this);
                    this.setState(TransitionState.FINISHED);
                    b10 = true;
                }
            }
            if (!this.U && !this.D) {
                if ((n2 > 0 && b7 == 1.0f) || (signum < 0.0f && b7 == 0.0f)) {
                    this.setState(TransitionState.FINISHED);
                }
            }
            else {
                this.invalidate();
            }
            b2 = b10;
            if (!this.U) {
                b2 = b10;
                if (!this.D) {
                    if (n2 <= 0 || b7 != 1.0f) {
                        b2 = b10;
                        if (signum >= 0.0f) {
                            break Label_1049;
                        }
                        b2 = b10;
                        if (b7 != 0.0f) {
                            break Label_1049;
                        }
                    }
                    this.z();
                    b2 = b10;
                }
            }
        }
        final boolean b11 = true;
        final boolean b12 = true;
        final float z2 = this.z;
        boolean b13 = false;
        Label_1150: {
            if (z2 >= 1.0f) {
                final int f2 = this.f;
                final int g2 = this.g;
                if (f2 != g2) {
                    b2 = b12;
                }
                this.f = g2;
            }
            else {
                b13 = b2;
                if (z2 > 0.0f) {
                    break Label_1150;
                }
                final int f3 = this.f;
                final int e2 = this.e;
                if (f3 != e2) {
                    b2 = b11;
                }
                this.f = e2;
            }
            b13 = b2;
        }
        this.z0 |= b13;
        if (b13 && !this.r0) {
            this.requestLayout();
        }
        this.y = this.z;
    }
    
    public void i(final View view, final View view2, final int n, final int n2) {
        this.S = this.getNanoTime();
        this.T = 0.0f;
        this.Q = 0.0f;
        this.R = 0.0f;
    }
    
    public boolean isAttachedToWindow() {
        return super.isAttachedToWindow();
    }
    
    public void j(final View view, final int n) {
        final q a = this.a;
        if (a != null) {
            final float t = this.T;
            if (t != 0.0f) {
                a.M(this.Q / t, this.R / t);
            }
        }
    }
    
    public void k(final View view, final int n, final int n2, final int[] array, int q) {
        final q a = this.a;
        if (a == null) {
            return;
        }
        final q.b c = a.c;
        if (c != null) {
            if (c.A()) {
                final boolean a2 = c.A();
                final int n3 = -1;
                if (a2) {
                    final r z = c.z();
                    if (z != null) {
                        q = z.q();
                        if (q != -1 && view.getId() != q) {
                            return;
                        }
                    }
                }
                if (a.t()) {
                    final r z2 = c.z();
                    q = n3;
                    if (z2 != null) {
                        q = n3;
                        if ((z2.e() & 0x4) != 0x0) {
                            q = n2;
                        }
                    }
                    final float y = this.y;
                    if ((y == 1.0f || y == 0.0f) && view.canScrollVertically(q)) {
                        return;
                    }
                }
                if (c.z() != null && (c.z().e() & 0x1) != 0x0) {
                    final float u = a.u((float)n, (float)n2);
                    final float z3 = this.z;
                    if ((z3 <= 0.0f && u < 0.0f) || (z3 >= 1.0f && u > 0.0f)) {
                        view.setNestedScrollingEnabled(false);
                        view.post((Runnable)new Runnable(this, view) {
                            final View a;
                            
                            @Override
                            public void run() {
                                this.a.setNestedScrollingEnabled(true);
                            }
                        });
                        return;
                    }
                }
                final float y2 = this.y;
                final long nanoTime = this.getNanoTime();
                final float q2 = (float)n;
                this.Q = q2;
                final float r = (float)n2;
                this.R = r;
                this.T = (float)((nanoTime - this.S) * 1.0E-9);
                this.S = nanoTime;
                a.L(q2, r);
                if (y2 != this.y) {
                    array[0] = n;
                    array[1] = n2;
                }
                this.h(false);
                if (array[0] != 0 || array[1] != 0) {
                    this.P = true;
                }
            }
        }
    }
    
    @Override
    public void loadLayoutDescription(int rotation) {
        if (rotation != 0) {
            try {
                final q a = new q(this.getContext(), this, rotation);
                this.a = a;
                if (this.f == -1) {
                    this.f = a.B();
                    this.e = this.a.B();
                    this.g = this.a.o();
                }
                if (this.isAttachedToWindow()) {
                    try {
                        final Display display = this.getDisplay();
                        if (display == null) {
                            rotation = 0;
                        }
                        else {
                            rotation = display.getRotation();
                        }
                        this.w0 = rotation;
                        final q a2 = this.a;
                        if (a2 != null) {
                            final androidx.constraintlayout.widget.c j = a2.j(this.f);
                            this.a.P(this);
                            final ArrayList<n> a3 = this.a0;
                            if (a3 != null) {
                                final Iterator<n> iterator = a3.iterator();
                                while (iterator.hasNext()) {
                                    iterator.next().h(this);
                                }
                            }
                            if (j != null) {
                                j.i(this);
                            }
                            this.e = this.f;
                        }
                        this.z();
                        final h s0 = this.s0;
                        if (s0 != null) {
                            if (this.x0) {
                                this.post((Runnable)new Runnable(this) {
                                    final MotionLayout a;
                                    
                                    @Override
                                    public void run() {
                                        MotionLayout.a(this.a).a();
                                    }
                                });
                                return;
                            }
                            s0.a();
                            return;
                        }
                        else {
                            final q a4 = this.a;
                            if (a4 == null) {
                                return;
                            }
                            final q.b c = a4.c;
                            if (c != null && c.v() == 4) {
                                this.F();
                                this.setState(TransitionState.SETUP);
                                this.setState(TransitionState.MOVING);
                            }
                            return;
                        }
                    }
                    catch (final Exception ex) {
                        throw new IllegalArgumentException("unable to parse MotionScene file", ex);
                    }
                }
                this.a = null;
                return;
            }
            catch (final Exception ex2) {
                throw new IllegalArgumentException("unable to parse MotionScene file", ex2);
            }
        }
        this.a = null;
    }
    
    @Override
    public void m(final View view, final int n, final int n2, final int n3, final int n4, final int n5, final int[] array) {
        if (this.P || n != 0 || n2 != 0) {
            array[0] += n3;
            array[1] += n4;
        }
        this.P = false;
    }
    
    public void n(final View view, final int n, final int n2, final int n3, final int n4, final int n5) {
    }
    
    public boolean o(final View view, final View view2, final int n, final int n2) {
        final q a = this.a;
        if (a != null) {
            final q.b c = a.c;
            if (c != null && c.z() != null) {
                if ((this.a.c.z().e() & 0x2) == 0x0) {
                    return true;
                }
            }
        }
        return false;
    }
    
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        final Display display = this.getDisplay();
        if (display != null) {
            this.w0 = display.getRotation();
        }
        final q a = this.a;
        if (a != null) {
            final int f = this.f;
            if (f != -1) {
                final androidx.constraintlayout.widget.c j = a.j(f);
                this.a.P(this);
                final ArrayList<n> a2 = this.a0;
                if (a2 != null) {
                    final Iterator<n> iterator = a2.iterator();
                    while (iterator.hasNext()) {
                        iterator.next().h(this);
                    }
                }
                if (j != null) {
                    j.i(this);
                }
                this.e = this.f;
            }
        }
        this.z();
        final h s0 = this.s0;
        if (s0 != null) {
            if (this.x0) {
                this.post((Runnable)new Runnable(this) {
                    final MotionLayout a;
                    
                    @Override
                    public void run() {
                        MotionLayout.a(this.a).a();
                    }
                });
            }
            else {
                s0.a();
            }
        }
        else {
            final q a3 = this.a;
            if (a3 != null) {
                final q.b c = a3.c;
                if (c != null && c.v() == 4) {
                    this.F();
                    this.setState(TransitionState.SETUP);
                    this.setState(TransitionState.MOVING);
                }
            }
        }
    }
    
    public boolean onInterceptTouchEvent(final MotionEvent motionEvent) {
        final q a = this.a;
        if (a != null) {
            if (this.j) {
                final u s = a.s;
                if (s != null) {
                    s.g(motionEvent);
                }
                final q.b c = this.a.c;
                if (c != null && c.A()) {
                    final r z = c.z();
                    if (z != null) {
                        if (motionEvent.getAction() == 0) {
                            final RectF p = z.p(this, new RectF());
                            if (p != null && !p.contains(motionEvent.getX(), motionEvent.getY())) {
                                return false;
                            }
                        }
                        final int q = z.q();
                        if (q != -1) {
                            final View b0 = this.B0;
                            if (b0 == null || b0.getId() != q) {
                                this.B0 = this.findViewById(q);
                            }
                            final View b2 = this.B0;
                            if (b2 != null) {
                                this.A0.set((float)b2.getLeft(), (float)this.B0.getTop(), (float)this.B0.getRight(), (float)this.B0.getBottom());
                                if (this.A0.contains(motionEvent.getX(), motionEvent.getY()) && !this.w((float)this.B0.getLeft(), (float)this.B0.getTop(), this.B0, motionEvent)) {
                                    return this.onTouchEvent(motionEvent);
                                }
                            }
                        }
                    }
                }
            }
        }
        return false;
    }
    
    @Override
    protected void onLayout(final boolean b, int n, int n2, final int n3, final int n4) {
        this.r0 = true;
        try {
            if (this.a == null) {
                super.onLayout(b, n, n2, n3, n4);
                return;
            }
            n = n3 - n;
            n2 = n4 - n2;
            if (this.N != n || this.O != n2) {
                this.B();
                this.h(true);
            }
            this.N = n;
            this.O = n2;
            this.L = n;
            this.M = n2;
        }
        finally {
            this.r0 = false;
        }
    }
    
    @Override
    protected void onMeasure(int h, int i) {
        if (this.a == null) {
            super.onMeasure(h, i);
            return;
        }
        final int h2 = this.h;
        final int n = 1;
        int n2;
        if (h2 == h && this.i == i) {
            n2 = 0;
        }
        else {
            n2 = 1;
        }
        if (this.z0) {
            this.z0 = false;
            this.z();
            this.A();
            n2 = 1;
        }
        if (super.mDirtyHierarchy) {
            n2 = n;
        }
        this.h = h;
        this.i = i;
        final int b = this.a.B();
        final int o = this.a.o();
        if (n2 == 0) {
            throw null;
        }
        if (this.e == -1) {
            if (n2 != 0) {
                super.onMeasure(h, i);
            }
            final boolean i2 = this.i0;
            final int paddingTop = this.getPaddingTop();
            i = this.getPaddingBottom();
            h = this.getPaddingLeft();
            h = super.mLayoutWidget.U() + (h + this.getPaddingRight());
            i = super.mLayoutWidget.v() + (paddingTop + i);
            final int n3 = this.n0;
            if (n3 == Integer.MIN_VALUE || n3 == 0) {
                h = this.j0;
                h += (int)(this.p0 * (this.l0 - h));
                this.requestLayout();
            }
            final int o2 = this.o0;
            if (o2 == Integer.MIN_VALUE || o2 == 0) {
                i = this.k0;
                i += (int)(this.p0 * (this.m0 - i));
                this.requestLayout();
            }
            this.setMeasuredDimension(h, i);
            this.l();
            return;
        }
        super.onMeasure(h, i);
        this.a.j(b);
        this.a.j(o);
        throw null;
    }
    
    public boolean onNestedFling(final View view, final float n, final float n2, final boolean b) {
        return false;
    }
    
    public boolean onNestedPreFling(final View view, final float n, final float n2) {
        return false;
    }
    
    public void onRtlPropertiesChanged(final int n) {
        final q a = this.a;
        if (a != null) {
            a.S(this.isRtl());
        }
    }
    
    public boolean onTouchEvent(final MotionEvent motionEvent) {
        final q a = this.a;
        if (a == null || !this.j || !a.X()) {
            return super.onTouchEvent(motionEvent);
        }
        final q.b c = this.a.c;
        if (c != null && !c.A()) {
            return super.onTouchEvent(motionEvent);
        }
        this.a.N(motionEvent, this.getCurrentState(), this);
        return !this.a.c.B(4) || this.a.c.z().r();
    }
    
    @Override
    public void onViewAdded(final View view) {
        super.onViewAdded(view);
        if (view instanceof n) {
            final n n = (n)view;
            if (this.b0 == null) {
                this.b0 = new CopyOnWriteArrayList<i>();
            }
            this.b0.add((i)n);
            if (n.g()) {
                if (this.V == null) {
                    this.V = new ArrayList<n>();
                }
                this.V.add(n);
            }
            if (n.f()) {
                if (this.W == null) {
                    this.W = new ArrayList<n>();
                }
                this.W.add(n);
            }
            if (n.e()) {
                if (this.a0 == null) {
                    this.a0 = new ArrayList<n>();
                }
                this.a0.add(n);
            }
        }
    }
    
    @Override
    public void onViewRemoved(final View view) {
        super.onViewRemoved(view);
        final ArrayList<n> v = this.V;
        if (v != null) {
            v.remove(view);
        }
        final ArrayList<n> w = this.W;
        if (w != null) {
            w.remove(view);
        }
    }
    
    @Override
    protected void parseLayoutDescription(final int n) {
        super.mConstraintLayoutSpec = null;
    }
    
    protected void q() {
        Label_0103: {
            if (this.E == null) {
                final CopyOnWriteArrayList<i> b0 = this.b0;
                if (b0 == null || b0.isEmpty()) {
                    break Label_0103;
                }
            }
            if (this.f0 == -1) {
                this.f0 = this.f;
                int intValue;
                if (!this.D0.isEmpty()) {
                    final ArrayList<Integer> d0 = this.D0;
                    intValue = d0.get(d0.size() - 1);
                }
                else {
                    intValue = -1;
                }
                final int f = this.f;
                if (intValue != f && f != -1) {
                    this.D0.add(f);
                }
            }
        }
        this.A();
        final Runnable t0 = this.t0;
        if (t0 != null) {
            t0.run();
        }
        final int[] u0 = this.u0;
        if (u0 != null && this.v0 > 0) {
            this.I(u0[0]);
            final int[] u2 = this.u0;
            System.arraycopy(u2, 1, u2, 0, u2.length - 1);
            --this.v0;
        }
    }
    
    public void r(final int n, final boolean b, final float n2) {
        final i e = this.E;
        if (e != null) {
            e.d(this, n, b, n2);
        }
        final CopyOnWriteArrayList<i> b2 = this.b0;
        if (b2 != null) {
            final Iterator<i> iterator = b2.iterator();
            while (iterator.hasNext()) {
                iterator.next().d(this, n, b, n2);
            }
        }
    }
    
    @Override
    public void requestLayout() {
        if (!this.i0 && this.f == -1) {
            final q a = this.a;
            if (a != null) {
                final q.b c = a.c;
                if (c != null) {
                    final int x = c.x();
                    if (x == 0) {
                        return;
                    }
                    if (x == 2) {
                        for (int childCount = this.getChildCount(), i = 0; i < childCount; ++i) {
                            this.p.get(this.getChildAt(i)).r();
                        }
                        return;
                    }
                }
            }
        }
        super.requestLayout();
    }
    
    void s(final int n, final float f, float y, final float n2, final float[] array) {
        final HashMap<View, m> p5 = this.p;
        final View viewById = this.getViewById(n);
        final m m = p5.get(viewById);
        if (m != null) {
            m.k(f, y, n2, array);
            y = viewById.getY();
            this.F = f;
            this.G = y;
        }
        else {
            String s;
            if (viewById == null) {
                final StringBuilder sb = new StringBuilder();
                sb.append("");
                sb.append(n);
                s = sb.toString();
            }
            else {
                s = viewById.getContext().getResources().getResourceName(n);
            }
            final StringBuilder sb2 = new StringBuilder();
            sb2.append("WARNING could not find view id ");
            sb2.append(s);
            Log.w("MotionLayout", sb2.toString());
        }
    }
    
    public void setDebugMode(final int h) {
        this.H = h;
        this.invalidate();
    }
    
    public void setDelayedApplicationOfInitialState(final boolean x0) {
        this.x0 = x0;
    }
    
    public void setInteractionEnabled(final boolean j) {
        this.j = j;
    }
    
    public void setInterpolatedProgress(final float progress) {
        if (this.a != null) {
            this.setState(TransitionState.MOVING);
            final Interpolator q = this.a.q();
            if (q != null) {
                this.setProgress(q.getInterpolation(progress));
                return;
            }
        }
        this.setProgress(progress);
    }
    
    public void setOnHide(final float progress) {
        final ArrayList<n> w = this.W;
        if (w != null) {
            for (int size = w.size(), i = 0; i < size; ++i) {
                this.W.get(i).setProgress(progress);
            }
        }
    }
    
    public void setOnShow(final float progress) {
        final ArrayList<n> v = this.V;
        if (v != null) {
            for (int size = v.size(), i = 0; i < size; ++i) {
                this.V.get(i).setProgress(progress);
            }
        }
    }
    
    public void setProgress(final float n) {
        final float n2 = fcmpg(n, 0.0f);
        if (n2 < 0 || n > 1.0f) {
            Log.w("MotionLayout", "Warning! Progress is defined for values between 0.0 and 1.0 inclusive");
        }
        if (!this.isAttachedToWindow()) {
            if (this.s0 == null) {
                this.s0 = new h();
            }
            this.s0.e(n);
            return;
        }
        if (n2 <= 0) {
            if (this.z == 1.0f && this.f == this.g) {
                this.setState(TransitionState.MOVING);
            }
            this.f = this.e;
            if (this.z == 0.0f) {
                this.setState(TransitionState.FINISHED);
            }
        }
        else if (n >= 1.0f) {
            if (this.z == 0.0f && this.f == this.e) {
                this.setState(TransitionState.MOVING);
            }
            this.f = this.g;
            if (this.z == 1.0f) {
                this.setState(TransitionState.FINISHED);
            }
        }
        else {
            this.f = -1;
            this.setState(TransitionState.MOVING);
        }
        if (this.a == null) {
            return;
        }
        this.C = true;
        this.B = n;
        this.y = n;
        this.A = -1L;
        this.w = -1L;
        this.b = null;
        this.D = true;
        this.invalidate();
    }
    
    public void setScene(final q a) {
        (this.a = a).S(this.isRtl());
        this.B();
    }
    
    void setStartState(final int f) {
        if (!this.isAttachedToWindow()) {
            if (this.s0 == null) {
                this.s0 = new h();
            }
            this.s0.f(f);
            this.s0.d(f);
            return;
        }
        this.f = f;
    }
    
    @Override
    public void setState(final int f, final int n, final int n2) {
        this.setState(TransitionState.SETUP);
        this.f = f;
        this.e = -1;
        this.g = -1;
        final androidx.constraintlayout.widget.b mConstraintLayoutSpec = super.mConstraintLayoutSpec;
        if (mConstraintLayoutSpec != null) {
            mConstraintLayoutSpec.d(f, (float)n, (float)n2);
        }
        else {
            final q a = this.a;
            if (a != null) {
                a.j(f).i(this);
            }
        }
    }
    
    void setState(final TransitionState y0) {
        final TransitionState finished = TransitionState.FINISHED;
        if (y0 == finished && this.f == -1) {
            return;
        }
        final TransitionState y2 = this.y0;
        this.y0 = y0;
        final TransitionState moving = TransitionState.MOVING;
        if (y2 == moving && y0 == moving) {
            this.p();
        }
        final int n = MotionLayout$d.a[y2.ordinal()];
        if (n != 1 && n != 2) {
            if (n == 3) {
                if (y0 == finished) {
                    this.q();
                }
            }
        }
        else {
            if (y0 == moving) {
                this.p();
            }
            if (y0 == finished) {
                this.q();
            }
        }
    }
    
    public void setTransition(int n) {
        if (this.a == null) {
            return;
        }
        final q.b v = this.v(n);
        this.e = v.y();
        this.g = v.w();
        if (!this.isAttachedToWindow()) {
            if (this.s0 == null) {
                this.s0 = new h();
            }
            this.s0.f(this.e);
            this.s0.d(this.g);
            return;
        }
        n = this.f;
        n = this.e;
        this.a.U(v);
        this.a.j(this.e);
        this.a.j(this.g);
        throw null;
    }
    
    protected void setTransition(final q.b b) {
        this.a.U(b);
        this.setState(TransitionState.SETUP);
        if (this.f == this.a.o()) {
            this.z = 1.0f;
            this.y = 1.0f;
            this.B = 1.0f;
        }
        else {
            this.z = 0.0f;
            this.y = 0.0f;
            this.B = 0.0f;
        }
        long nanoTime;
        if (b.B(1)) {
            nanoTime = -1L;
        }
        else {
            nanoTime = this.getNanoTime();
        }
        this.A = nanoTime;
        final int b2 = this.a.B();
        final int o = this.a.o();
        if (b2 == this.e && o == this.g) {
            return;
        }
        this.e = b2;
        this.g = o;
        this.a.T(b2, o);
        this.a.j(this.e);
        this.a.j(this.g);
        throw null;
    }
    
    public void setTransitionDuration(final int n) {
        final q a = this.a;
        if (a == null) {
            Log.e("MotionLayout", "MotionScene not defined");
            return;
        }
        a.R(n);
    }
    
    public void setTransitionListener(final i e) {
        this.E = e;
    }
    
    public void setTransitionState(final Bundle bundle) {
        if (this.s0 == null) {
            this.s0 = new h();
        }
        this.s0.g(bundle);
        if (this.isAttachedToWindow()) {
            this.s0.a();
        }
    }
    
    public androidx.constraintlayout.widget.c t(final int n) {
        final q a = this.a;
        if (a == null) {
            return null;
        }
        return a.j(n);
    }
    
    public String toString() {
        final Context context = this.getContext();
        final StringBuilder sb = new StringBuilder();
        sb.append(androidx.constraintlayout.motion.widget.a.b(context, this.e));
        sb.append("->");
        sb.append(androidx.constraintlayout.motion.widget.a.b(context, this.g));
        sb.append(" (pos:");
        sb.append(this.z);
        sb.append(" Dpos/Dt:");
        sb.append(this.d);
        return sb.toString();
    }
    
    m u(final int n) {
        return this.p.get(this.findViewById(n));
    }
    
    public q.b v(final int n) {
        return this.a.C(n);
    }
    
    public boolean x() {
        return this.j;
    }
    
    protected f y() {
        return (f)MotionLayout.g.a();
    }
    
    void z() {
        final q a = this.a;
        if (a == null) {
            return;
        }
        if (a.g(this, this.f)) {
            this.requestLayout();
            return;
        }
        final int f = this.f;
        if (f != -1) {
            this.a.f(this, f);
        }
        if (this.a.X()) {
            this.a.V();
        }
    }
    
    enum TransitionState
    {
        private static final TransitionState[] $VALUES;
        
        FINISHED, 
        MOVING, 
        SETUP, 
        UNDEFINED;
        
        static {
            $VALUES = a();
        }
        
        private static TransitionState[] a() {
            return new TransitionState[] { TransitionState.UNDEFINED, TransitionState.SETUP, TransitionState.MOVING, TransitionState.FINISHED };
        }
    }
    
    private class e
    {
        float[] a;
        int[] b;
        float[] c;
        Path d;
        Paint e;
        Paint f;
        Paint g;
        Paint h;
        Paint i;
        private float[] j;
        final int k;
        final int l;
        final int m;
        final int n;
        final int o;
        DashPathEffect p;
        int q;
        Rect r;
        boolean s;
        int t;
        final MotionLayout u;
        
        public e(final MotionLayout u) {
            this.u = u;
            this.k = -21965;
            this.l = -2067046;
            this.m = -13391360;
            this.n = 1996488704;
            this.o = 10;
            this.r = new Rect();
            this.s = false;
            this.t = 1;
            (this.e = new Paint()).setAntiAlias(true);
            this.e.setColor(-21965);
            this.e.setStrokeWidth(2.0f);
            this.e.setStyle(Paint$Style.STROKE);
            (this.f = new Paint()).setAntiAlias(true);
            this.f.setColor(-2067046);
            this.f.setStrokeWidth(2.0f);
            this.f.setStyle(Paint$Style.STROKE);
            (this.g = new Paint()).setAntiAlias(true);
            this.g.setColor(-13391360);
            this.g.setStrokeWidth(2.0f);
            this.g.setStyle(Paint$Style.STROKE);
            (this.h = new Paint()).setAntiAlias(true);
            this.h.setColor(-13391360);
            this.h.setTextSize(u.getContext().getResources().getDisplayMetrics().density * 12.0f);
            this.j = new float[8];
            (this.i = new Paint()).setAntiAlias(true);
            final DashPathEffect dashPathEffect = new DashPathEffect(new float[] { 4.0f, 8.0f }, 0.0f);
            this.p = dashPathEffect;
            this.g.setPathEffect((PathEffect)dashPathEffect);
            this.c = new float[100];
            this.b = new int[50];
            if (this.s) {
                this.e.setStrokeWidth(8.0f);
                this.i.setStrokeWidth(8.0f);
                this.f.setStrokeWidth(8.0f);
                this.t = 4;
            }
        }
        
        private void c(final Canvas canvas) {
            canvas.drawLines(this.a, this.e);
        }
        
        private void d(final Canvas canvas) {
            int i = 0;
            boolean b = false;
            boolean b2 = false;
            while (i < this.q) {
                final int[] b3 = this.b;
                if (b3[i] == 1) {
                    b = true;
                }
                if (b3[i] == 0) {
                    b2 = true;
                }
                ++i;
            }
            if (b) {
                this.g(canvas);
            }
            if (b2) {
                this.e(canvas);
            }
        }
        
        private void e(final Canvas canvas) {
            final float[] a = this.a;
            final float n = a[0];
            final float n2 = a[1];
            final float n3 = a[a.length - 2];
            final float n4 = a[a.length - 1];
            canvas.drawLine(Math.min(n, n3), Math.max(n2, n4), Math.max(n, n3), Math.max(n2, n4), this.g);
            canvas.drawLine(Math.min(n, n3), Math.min(n2, n4), Math.min(n, n3), Math.max(n2, n4), this.g);
        }
        
        private void f(final Canvas canvas, final float n, final float n2) {
            final float[] a = this.a;
            final float n3 = a[0];
            final float n4 = a[1];
            final float n5 = a[a.length - 2];
            final float n6 = a[a.length - 1];
            final float min = Math.min(n3, n5);
            final float max = Math.max(n4, n6);
            final float n7 = n - Math.min(n3, n5);
            final float n8 = Math.max(n4, n6) - n2;
            final StringBuilder sb = new StringBuilder();
            sb.append("");
            sb.append((int)(n7 * 100.0f / Math.abs(n5 - n3) + 0.5) / 100.0f);
            final String string = sb.toString();
            this.l(string, this.h);
            canvas.drawText(string, n7 / 2.0f - this.r.width() / 2 + min, n2 - 20.0f, this.h);
            canvas.drawLine(n, n2, Math.min(n3, n5), n2, this.g);
            final StringBuilder sb2 = new StringBuilder();
            sb2.append("");
            sb2.append((int)(n8 * 100.0f / Math.abs(n6 - n4) + 0.5) / 100.0f);
            final String string2 = sb2.toString();
            this.l(string2, this.h);
            canvas.drawText(string2, n + 5.0f, max - (n8 / 2.0f - this.r.height() / 2), this.h);
            canvas.drawLine(n, n2, n, Math.max(n4, n6), this.g);
        }
        
        private void g(final Canvas canvas) {
            final float[] a = this.a;
            canvas.drawLine(a[0], a[1], a[a.length - 2], a[a.length - 1], this.g);
        }
        
        private void h(final Canvas canvas, final float n, final float n2) {
            final float[] a = this.a;
            final float n3 = a[0];
            final float n4 = a[1];
            final float n5 = a[a.length - 2];
            final float n6 = a[a.length - 1];
            final float n7 = (float)Math.hypot(n3 - n5, n4 - n6);
            final float n8 = n5 - n3;
            final float n9 = n6 - n4;
            final float n10 = ((n - n3) * n8 + (n2 - n4) * n9) / (n7 * n7);
            final float n11 = n3 + n8 * n10;
            final float n12 = n4 + n10 * n9;
            final Path path = new Path();
            path.moveTo(n, n2);
            path.lineTo(n11, n12);
            final float n13 = (float)Math.hypot(n11 - n, n12 - n2);
            final StringBuilder sb = new StringBuilder();
            sb.append("");
            sb.append((int)(n13 * 100.0f / n7) / 100.0f);
            final String string = sb.toString();
            this.l(string, this.h);
            canvas.drawTextOnPath(string, path, n13 / 2.0f - this.r.width() / 2, -20.0f, this.h);
            canvas.drawLine(n, n2, n11, n12, this.g);
        }
        
        private void i(final Canvas canvas, final float n, final float n2, final int n3, final int n4) {
            final StringBuilder sb = new StringBuilder();
            sb.append("");
            sb.append((int)((n - n3 / 2) * 100.0f / (this.u.getWidth() - n3) + 0.5) / 100.0f);
            final String string = sb.toString();
            this.l(string, this.h);
            canvas.drawText(string, n / 2.0f - this.r.width() / 2 + 0.0f, n2 - 20.0f, this.h);
            canvas.drawLine(n, n2, Math.min(0.0f, 1.0f), n2, this.g);
            final StringBuilder sb2 = new StringBuilder();
            sb2.append("");
            sb2.append((int)((n2 - n4 / 2) * 100.0f / (this.u.getHeight() - n4) + 0.5) / 100.0f);
            final String string2 = sb2.toString();
            this.l(string2, this.h);
            canvas.drawText(string2, n + 5.0f, 0.0f - (n2 / 2.0f - this.r.height() / 2), this.h);
            canvas.drawLine(n, n2, n, Math.max(0.0f, 1.0f), this.g);
        }
        
        private void j(final Canvas canvas, final m m) {
            this.d.reset();
            for (int i = 0; i <= 50; ++i) {
                m.d(i / (float)50, this.j, 0);
                final Path d = this.d;
                final float[] j = this.j;
                d.moveTo(j[0], j[1]);
                final Path d2 = this.d;
                final float[] k = this.j;
                d2.lineTo(k[2], k[3]);
                final Path d3 = this.d;
                final float[] l = this.j;
                d3.lineTo(l[4], l[5]);
                final Path d4 = this.d;
                final float[] j2 = this.j;
                d4.lineTo(j2[6], j2[7]);
                this.d.close();
            }
            this.e.setColor(1140850688);
            canvas.translate(2.0f, 2.0f);
            canvas.drawPath(this.d, this.e);
            canvas.translate(-2.0f, -2.0f);
            this.e.setColor(-65536);
            canvas.drawPath(this.d, this.e);
        }
        
        private void k(final Canvas canvas, final int n, final int n2, final m m) {
            final View b = m.b;
            int width;
            int height;
            if (b != null) {
                width = b.getWidth();
                height = m.b.getHeight();
            }
            else {
                width = 0;
                height = 0;
            }
            for (int i = 1; i < n2 - 1; ++i) {
                if (n != 4 || this.b[i - 1] != 0) {
                    final float[] c = this.c;
                    final int n3 = i * 2;
                    final float n4 = c[n3];
                    final float n5 = c[n3 + 1];
                    this.d.reset();
                    this.d.moveTo(n4, n5 + 10.0f);
                    this.d.lineTo(n4 + 10.0f, n5);
                    this.d.lineTo(n4, n5 - 10.0f);
                    this.d.lineTo(n4 - 10.0f, n5);
                    this.d.close();
                    final int n6 = i - 1;
                    m.m(n6);
                    if (n == 4) {
                        final int[] b2 = this.b;
                        if (b2[n6] == 1) {
                            this.h(canvas, n4 - 0.0f, n5 - 0.0f);
                        }
                        else if (b2[n6] == 0) {
                            this.f(canvas, n4 - 0.0f, n5 - 0.0f);
                        }
                        else if (b2[n6] == 2) {
                            this.i(canvas, n4 - 0.0f, n5 - 0.0f, width, height);
                        }
                        canvas.drawPath(this.d, this.i);
                    }
                    if (n == 2) {
                        this.h(canvas, n4 - 0.0f, n5 - 0.0f);
                    }
                    if (n == 3) {
                        this.f(canvas, n4 - 0.0f, n5 - 0.0f);
                    }
                    if (n == 6) {
                        this.i(canvas, n4 - 0.0f, n5 - 0.0f, width, height);
                    }
                    canvas.drawPath(this.d, this.i);
                }
            }
            final float[] a = this.a;
            if (a.length > 1) {
                canvas.drawCircle(a[0], a[1], 8.0f, this.f);
                final float[] a2 = this.a;
                canvas.drawCircle(a2[a2.length - 2], a2[a2.length - 1], 8.0f, this.f);
            }
        }
        
        public void a(final Canvas canvas, final HashMap<View, m> hashMap, final int n, final int n2) {
            if (hashMap != null) {
                if (hashMap.size() != 0) {
                    canvas.save();
                    if (!this.u.isInEditMode() && (n2 & 0x1) == 0x2) {
                        final StringBuilder sb = new StringBuilder();
                        sb.append(this.u.getContext().getResources().getResourceName(MotionLayout.b(this.u)));
                        sb.append(":");
                        sb.append(this.u.getProgress());
                        final String string = sb.toString();
                        canvas.drawText(string, 10.0f, (float)(this.u.getHeight() - 30), this.h);
                        canvas.drawText(string, 11.0f, (float)(this.u.getHeight() - 29), this.e);
                    }
                    for (final m m : hashMap.values()) {
                        int l;
                        final int n3 = l = m.l();
                        if (n2 > 0 && (l = n3) == 0) {
                            l = 1;
                        }
                        if (l == 0) {
                            continue;
                        }
                        this.q = m.b(this.c, this.b);
                        if (l < 1) {
                            continue;
                        }
                        final int n4 = n / 16;
                        final float[] a = this.a;
                        if (a == null || a.length != n4 * 2) {
                            this.a = new float[n4 * 2];
                            this.d = new Path();
                        }
                        final int t = this.t;
                        canvas.translate((float)t, (float)t);
                        this.e.setColor(1996488704);
                        this.i.setColor(1996488704);
                        this.f.setColor(1996488704);
                        this.g.setColor(1996488704);
                        m.c(this.a, n4);
                        this.b(canvas, l, this.q, m);
                        this.e.setColor(-21965);
                        this.f.setColor(-2067046);
                        this.i.setColor(-2067046);
                        this.g.setColor(-13391360);
                        final int t2 = this.t;
                        canvas.translate((float)(-t2), (float)(-t2));
                        this.b(canvas, l, this.q, m);
                        if (l != 5) {
                            continue;
                        }
                        this.j(canvas, m);
                    }
                    canvas.restore();
                }
            }
        }
        
        public void b(final Canvas canvas, final int n, final int n2, final m m) {
            if (n == 4) {
                this.d(canvas);
            }
            if (n == 2) {
                this.g(canvas);
            }
            if (n == 3) {
                this.e(canvas);
            }
            this.c(canvas);
            this.k(canvas, n, n2, m);
        }
        
        void l(final String s, final Paint paint) {
            paint.getTextBounds(s, 0, s.length(), this.r);
        }
    }
    
    protected interface f
    {
        void b();
        
        void c(final MotionEvent p0);
        
        float d();
        
        float e();
        
        void f(final int p0);
    }
    
    private static class g implements f
    {
        private static g b;
        VelocityTracker a;
        
        static {
            g.b = new g();
        }
        
        public static g a() {
            g.b.a = VelocityTracker.obtain();
            return g.b;
        }
        
        @Override
        public void b() {
            final VelocityTracker a = this.a;
            if (a != null) {
                a.recycle();
                this.a = null;
            }
        }
        
        @Override
        public void c(final MotionEvent motionEvent) {
            final VelocityTracker a = this.a;
            if (a != null) {
                a.addMovement(motionEvent);
            }
        }
        
        @Override
        public float d() {
            final VelocityTracker a = this.a;
            if (a != null) {
                return a.getYVelocity();
            }
            return 0.0f;
        }
        
        @Override
        public float e() {
            final VelocityTracker a = this.a;
            if (a != null) {
                return a.getXVelocity();
            }
            return 0.0f;
        }
        
        @Override
        public void f(final int n) {
            final VelocityTracker a = this.a;
            if (a != null) {
                a.computeCurrentVelocity(n);
            }
        }
    }
    
    class h
    {
        float a;
        float b;
        int c;
        int d;
        final String e;
        final String f;
        final String g;
        final String h;
        final MotionLayout i;
        
        h(final MotionLayout i) {
            this.i = i;
            this.a = Float.NaN;
            this.b = Float.NaN;
            this.c = -1;
            this.d = -1;
            this.e = "motion.progress";
            this.f = "motion.velocity";
            this.g = "motion.StartState";
            this.h = "motion.EndState";
        }
        
        void a() {
            final int c = this.c;
            if (c != -1 || this.d != -1) {
                if (c == -1) {
                    this.i.I(this.d);
                }
                else {
                    final int d = this.d;
                    if (d == -1) {
                        this.i.setState(c, -1, -1);
                    }
                    else {
                        this.i.D(c, d);
                    }
                }
                this.i.setState(TransitionState.SETUP);
            }
            if (!Float.isNaN(this.b)) {
                this.i.C(this.a, this.b);
                this.a = Float.NaN;
                this.b = Float.NaN;
                this.c = -1;
                this.d = -1;
                return;
            }
            if (Float.isNaN(this.a)) {
                return;
            }
            this.i.setProgress(this.a);
        }
        
        public Bundle b() {
            final Bundle bundle = new Bundle();
            bundle.putFloat("motion.progress", this.a);
            bundle.putFloat("motion.velocity", this.b);
            bundle.putInt("motion.StartState", this.c);
            bundle.putInt("motion.EndState", this.d);
            return bundle;
        }
        
        public void c() {
            this.d = MotionLayout.b(this.i);
            this.c = MotionLayout.c(this.i);
            this.b = this.i.getVelocity();
            this.a = this.i.getProgress();
        }
        
        public void d(final int d) {
            this.d = d;
        }
        
        public void e(final float a) {
            this.a = a;
        }
        
        public void f(final int c) {
            this.c = c;
        }
        
        public void g(final Bundle bundle) {
            this.a = bundle.getFloat("motion.progress");
            this.b = bundle.getFloat("motion.velocity");
            this.c = bundle.getInt("motion.StartState");
            this.d = bundle.getInt("motion.EndState");
        }
        
        public void h(final float b) {
            this.b = b;
        }
    }
    
    public interface i
    {
        void a(final MotionLayout p0, final int p1, final int p2, final float p3);
        
        void b(final MotionLayout p0, final int p1);
        
        void c(final MotionLayout p0, final int p1, final int p2);
        
        void d(final MotionLayout p0, final int p1, final boolean p2, final float p3);
    }
}
