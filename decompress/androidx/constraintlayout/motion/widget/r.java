// 
// Decompiled by Procyon v0.6.0
// 

package androidx.constraintlayout.motion.widget;

import android.view.View$OnTouchListener;
import androidx.core.widget.NestedScrollView;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.graphics.RectF;
import android.view.ViewGroup;
import android.util.AttributeSet;
import androidx.constraintlayout.widget.h;
import android.content.res.TypedArray;
import android.util.Xml;
import org.xmlpull.v1.XmlPullParser;
import android.content.Context;

class r
{
    private static final float[][] G;
    private static final float[][] H;
    private float A;
    private float B;
    private float C;
    private float D;
    private int E;
    private int F;
    private int a;
    private int b;
    private int c;
    private int d;
    private int e;
    private int f;
    private float g;
    private float h;
    float i;
    float j;
    private int k;
    boolean l;
    private float m;
    private float n;
    private boolean o;
    private float[] p;
    private int[] q;
    private float r;
    private float s;
    private final MotionLayout t;
    private float u;
    private float v;
    private boolean w;
    private float x;
    private int y;
    private float z;
    
    static {
        G = new float[][] { { 0.5f, 0.0f }, { 0.0f, 0.5f }, { 1.0f, 0.5f }, { 0.5f, 1.0f }, { 0.5f, 0.5f }, { 0.0f, 0.5f }, { 1.0f, 0.5f } };
        H = new float[][] { { 0.0f, -1.0f }, { 0.0f, 1.0f }, { -1.0f, 0.0f }, { 1.0f, 0.0f }, { -1.0f, 0.0f }, { 1.0f, 0.0f } };
    }
    
    r(final Context context, final MotionLayout t, final XmlPullParser xmlPullParser) {
        this.a = 0;
        this.b = 0;
        this.c = 0;
        this.d = -1;
        this.e = -1;
        this.f = -1;
        this.g = 0.5f;
        this.h = 0.5f;
        this.i = 0.5f;
        this.j = 0.5f;
        this.k = -1;
        this.l = false;
        this.m = 0.0f;
        this.n = 1.0f;
        this.o = false;
        this.p = new float[2];
        this.q = new int[2];
        this.u = 4.0f;
        this.v = 1.2f;
        this.w = true;
        this.x = 1.0f;
        this.y = 0;
        this.z = 10.0f;
        this.A = 10.0f;
        this.B = 1.0f;
        this.C = Float.NaN;
        this.D = Float.NaN;
        this.E = 0;
        this.F = 0;
        this.t = t;
        this.c(context, Xml.asAttributeSet(xmlPullParser));
    }
    
    private void b(final TypedArray typedArray) {
        for (int indexCount = typedArray.getIndexCount(), i = 0; i < indexCount; ++i) {
            final int index = typedArray.getIndex(i);
            if (index == androidx.constraintlayout.widget.h.J8) {
                this.d = typedArray.getResourceId(index, this.d);
            }
            else if (index == androidx.constraintlayout.widget.h.K8) {
                final int int1 = typedArray.getInt(index, this.a);
                this.a = int1;
                final float[][] g = androidx.constraintlayout.motion.widget.r.G;
                this.h = g[int1][0];
                this.g = g[int1][1];
            }
            else if (index == androidx.constraintlayout.widget.h.u8) {
                final int int2 = typedArray.getInt(index, this.b);
                this.b = int2;
                final float[][] h = androidx.constraintlayout.motion.widget.r.H;
                if (int2 < h.length) {
                    this.m = h[int2][0];
                    this.n = h[int2][1];
                }
                else {
                    this.n = Float.NaN;
                    this.m = Float.NaN;
                    this.l = true;
                }
            }
            else if (index == androidx.constraintlayout.widget.h.z8) {
                this.u = typedArray.getFloat(index, this.u);
            }
            else if (index == androidx.constraintlayout.widget.h.y8) {
                this.v = typedArray.getFloat(index, this.v);
            }
            else if (index == androidx.constraintlayout.widget.h.A8) {
                this.w = typedArray.getBoolean(index, this.w);
            }
            else if (index == androidx.constraintlayout.widget.h.v8) {
                this.x = typedArray.getFloat(index, this.x);
            }
            else if (index == androidx.constraintlayout.widget.h.w8) {
                this.z = typedArray.getFloat(index, this.z);
            }
            else if (index == androidx.constraintlayout.widget.h.L8) {
                this.e = typedArray.getResourceId(index, this.e);
            }
            else if (index == androidx.constraintlayout.widget.h.C8) {
                this.c = typedArray.getInt(index, this.c);
            }
            else if (index == androidx.constraintlayout.widget.h.B8) {
                this.y = typedArray.getInteger(index, 0);
            }
            else if (index == androidx.constraintlayout.widget.h.x8) {
                this.f = typedArray.getResourceId(index, 0);
            }
            else if (index == androidx.constraintlayout.widget.h.D8) {
                this.k = typedArray.getResourceId(index, this.k);
            }
            else if (index == androidx.constraintlayout.widget.h.F8) {
                this.A = typedArray.getFloat(index, this.A);
            }
            else if (index == androidx.constraintlayout.widget.h.G8) {
                this.B = typedArray.getFloat(index, this.B);
            }
            else if (index == androidx.constraintlayout.widget.h.H8) {
                this.C = typedArray.getFloat(index, this.C);
            }
            else if (index == androidx.constraintlayout.widget.h.I8) {
                this.D = typedArray.getFloat(index, this.D);
            }
            else if (index == androidx.constraintlayout.widget.h.E8) {
                this.E = typedArray.getInt(index, this.E);
            }
            else if (index == androidx.constraintlayout.widget.h.t8) {
                this.F = typedArray.getInt(index, this.F);
            }
        }
    }
    
    private void c(final Context context, final AttributeSet set) {
        final TypedArray obtainStyledAttributes = context.obtainStyledAttributes(set, androidx.constraintlayout.widget.h.s8);
        this.b(obtainStyledAttributes);
        obtainStyledAttributes.recycle();
    }
    
    float a(final float n, final float n2) {
        return n * this.m + n2 * this.n;
    }
    
    public int d() {
        return this.F;
    }
    
    public int e() {
        return this.y;
    }
    
    RectF f(final ViewGroup viewGroup, final RectF rectF) {
        final int f = this.f;
        if (f == -1) {
            return null;
        }
        final View viewById = viewGroup.findViewById(f);
        if (viewById == null) {
            return null;
        }
        rectF.set((float)viewById.getLeft(), (float)viewById.getTop(), (float)viewById.getRight(), (float)viewById.getBottom());
        return rectF;
    }
    
    float g() {
        return this.v;
    }
    
    public float h() {
        return this.u;
    }
    
    boolean i() {
        return this.w;
    }
    
    float j(float n, final float n2) {
        this.t.s(this.d, this.t.getProgress(), this.h, this.g, this.p);
        final float m = this.m;
        if (m != 0.0f) {
            final float[] p2 = this.p;
            if (p2[0] == 0.0f) {
                p2[0] = 1.0E-7f;
            }
            n = n * m / p2[0];
        }
        else {
            final float[] p3 = this.p;
            if (p3[1] == 0.0f) {
                p3[1] = 1.0E-7f;
            }
            n = n2 * this.n / p3[1];
        }
        return n;
    }
    
    public int k() {
        return this.E;
    }
    
    public float l() {
        return this.A;
    }
    
    public float m() {
        return this.B;
    }
    
    public float n() {
        return this.C;
    }
    
    public float o() {
        return this.D;
    }
    
    RectF p(final ViewGroup viewGroup, final RectF rectF) {
        final int e = this.e;
        if (e == -1) {
            return null;
        }
        final View viewById = viewGroup.findViewById(e);
        if (viewById == null) {
            return null;
        }
        rectF.set((float)viewById.getLeft(), (float)viewById.getTop(), (float)viewById.getRight(), (float)viewById.getBottom());
        return rectF;
    }
    
    int q() {
        return this.e;
    }
    
    boolean r() {
        return this.o;
    }
    
    void s(final MotionEvent motionEvent, final MotionLayout.f f, int n, final q q) {
        if (this.l) {
            this.t(motionEvent, f, n, q);
            return;
        }
        f.c(motionEvent);
        n = motionEvent.getAction();
        if (n != 0) {
            if (n != 1) {
                if (n == 2) {
                    final float n2 = motionEvent.getRawY() - this.s;
                    final float n3 = motionEvent.getRawX() - this.r;
                    if (Math.abs(this.m * n3 + this.n * n2) > this.z || this.o) {
                        final float progress = this.t.getProgress();
                        if (!this.o) {
                            this.o = true;
                            this.t.setProgress(progress);
                        }
                        n = this.d;
                        if (n != -1) {
                            this.t.s(n, progress, this.h, this.g, this.p);
                        }
                        else {
                            final float n4 = (float)Math.min(this.t.getWidth(), this.t.getHeight());
                            final float[] p4 = this.p;
                            p4[1] = this.n * n4;
                            p4[0] = n4 * this.m;
                        }
                        final float m = this.m;
                        final float[] p5 = this.p;
                        if (Math.abs((m * p5[0] + this.n * p5[1]) * this.x) < 0.01) {
                            final float[] p6 = this.p;
                            p6[1] = (p6[0] = 0.01f);
                        }
                        float n5;
                        if (this.m != 0.0f) {
                            n5 = n3 / this.p[0];
                        }
                        else {
                            n5 = n2 / this.p[1];
                        }
                        float n7;
                        final float n6 = n7 = Math.max(Math.min(progress + n5, 1.0f), 0.0f);
                        if (this.c == 6) {
                            n7 = Math.max(n6, 0.01f);
                        }
                        float min = n7;
                        if (this.c == 7) {
                            min = Math.min(n7, 0.99f);
                        }
                        final float progress2 = this.t.getProgress();
                        if (min != progress2) {
                            n = fcmpl(progress2, 0.0f);
                            if (n == 0 || progress2 == 1.0f) {
                                this.t.g(n == 0);
                            }
                            this.t.setProgress(min);
                            f.f(1000);
                            final float e = f.e();
                            final float d = f.d();
                            float d2;
                            if (this.m != 0.0f) {
                                d2 = e / this.p[0];
                            }
                            else {
                                d2 = d / this.p[1];
                            }
                            this.t.d = d2;
                        }
                        else {
                            this.t.d = 0.0f;
                        }
                        this.r = motionEvent.getRawX();
                        this.s = motionEvent.getRawY();
                    }
                }
            }
            else {
                this.o = false;
                f.f(1000);
                final float e2 = f.e();
                final float d3 = f.d();
                final float progress3 = this.t.getProgress();
                n = this.d;
                if (n != -1) {
                    this.t.s(n, progress3, this.h, this.g, this.p);
                }
                else {
                    final float n8 = (float)Math.min(this.t.getWidth(), this.t.getHeight());
                    final float[] p7 = this.p;
                    p7[1] = this.n * n8;
                    p7[0] = n8 * this.m;
                }
                final float i = this.m;
                final float[] p8 = this.p;
                final float n9 = p8[0];
                final float n10 = p8[1];
                float n11;
                if (i != 0.0f) {
                    n11 = e2 / p8[0];
                }
                else {
                    n11 = d3 / p8[1];
                }
                float n12;
                if (!Float.isNaN(n11)) {
                    n12 = n11 / 3.0f + progress3;
                }
                else {
                    n12 = progress3;
                }
                if (n12 != 0.0f && n12 != 1.0f) {
                    n = this.c;
                    if (n != 3) {
                        float n13;
                        if (n12 < 0.5) {
                            n13 = 0.0f;
                        }
                        else {
                            n13 = 1.0f;
                        }
                        float abs = n11;
                        if (n == 6) {
                            abs = n11;
                            if (progress3 + n11 < 0.0f) {
                                abs = Math.abs(n11);
                            }
                            n13 = 1.0f;
                        }
                        float n14 = abs;
                        if (this.c == 7) {
                            n14 = abs;
                            if (progress3 + abs > 1.0f) {
                                n14 = -Math.abs(abs);
                            }
                            n13 = 0.0f;
                        }
                        this.t.E(this.c, n13, n14);
                        if (0.0f >= progress3 || 1.0f <= progress3) {
                            this.t.setState(MotionLayout.TransitionState.FINISHED);
                        }
                        return;
                    }
                }
                if (0.0f >= n12 || 1.0f <= n12) {
                    this.t.setState(MotionLayout.TransitionState.FINISHED);
                }
            }
        }
        else {
            this.r = motionEvent.getRawX();
            this.s = motionEvent.getRawY();
            this.o = false;
        }
    }
    
    void t(final MotionEvent motionEvent, final MotionLayout.f f, int n, final q q) {
        f.c(motionEvent);
        n = motionEvent.getAction();
        boolean b = false;
        if (n != 0) {
            if (n != 1) {
                if (n == 2) {
                    motionEvent.getRawY();
                    motionEvent.getRawX();
                    final float n2 = this.t.getWidth() / 2.0f;
                    final float n3 = this.t.getHeight() / 2.0f;
                    n = this.k;
                    float n6;
                    float n7;
                    if (n != -1) {
                        final View viewById = this.t.findViewById(n);
                        this.t.getLocationOnScreen(this.q);
                        final float n4 = (float)this.q[0];
                        final float n5 = (viewById.getLeft() + viewById.getRight()) / 2.0f;
                        n6 = (viewById.getTop() + viewById.getBottom()) / 2.0f + this.q[1];
                        n7 = n4 + n5;
                    }
                    else {
                        n = this.d;
                        n7 = n2;
                        n6 = n3;
                        if (n != -1) {
                            final View viewById2 = this.t.findViewById(this.t.u(n).g());
                            if (viewById2 == null) {
                                Log.e("TouchResponse", "could not find view to animate to");
                                n7 = n2;
                                n6 = n3;
                            }
                            else {
                                this.t.getLocationOnScreen(this.q);
                                n7 = this.q[0] + (viewById2.getLeft() + viewById2.getRight()) / 2.0f;
                                n6 = this.q[1] + (viewById2.getTop() + viewById2.getBottom()) / 2.0f;
                            }
                        }
                    }
                    final float rawX = motionEvent.getRawX();
                    final float rawY = motionEvent.getRawY();
                    final double atan2 = Math.atan2(motionEvent.getRawY() - n6, motionEvent.getRawX() - n7);
                    final float n8 = (float)((atan2 - Math.atan2(this.s - n6, this.r - n7)) * 180.0 / 3.141592653589793);
                    float n9;
                    if (n8 > 330.0f) {
                        n9 = n8 - 360.0f;
                    }
                    else {
                        n9 = n8;
                        if (n8 < -330.0f) {
                            n9 = n8 + 360.0f;
                        }
                    }
                    if (Math.abs(n9) > 0.01 || this.o) {
                        final float progress = this.t.getProgress();
                        if (!this.o) {
                            this.o = true;
                            this.t.setProgress(progress);
                        }
                        n = this.d;
                        if (n != -1) {
                            this.t.s(n, progress, this.h, this.g, this.p);
                            final float[] p4 = this.p;
                            p4[1] = (float)Math.toDegrees(p4[1]);
                        }
                        else {
                            this.p[1] = 360.0f;
                        }
                        final float max = Math.max(Math.min(progress + n9 * this.x / this.p[1], 1.0f), 0.0f);
                        final float progress2 = this.t.getProgress();
                        if (max != progress2) {
                            n = fcmpl(progress2, 0.0f);
                            if (n == 0 || progress2 == 1.0f) {
                                final MotionLayout t = this.t;
                                if (n == 0) {
                                    b = true;
                                }
                                t.g(b);
                            }
                            this.t.setProgress(max);
                            f.f(1000);
                            final float e = f.e();
                            final double n10 = f.d();
                            final double n11 = e;
                            this.t.d = (float)Math.toDegrees((float)(Math.hypot(n10, n11) * Math.sin(Math.atan2(n10, n11) - atan2) / Math.hypot(rawX - n7, rawY - n6)));
                        }
                        else {
                            this.t.d = 0.0f;
                        }
                        this.r = motionEvent.getRawX();
                        this.s = motionEvent.getRawY();
                    }
                }
            }
            else {
                this.o = false;
                f.f(16);
                final float e2 = f.e();
                final float d = f.d();
                final float progress3 = this.t.getProgress();
                float n12 = this.t.getWidth() / 2.0f;
                float n13 = this.t.getHeight() / 2.0f;
                n = this.k;
                Label_0947: {
                    float n14;
                    int n15;
                    if (n != -1) {
                        final View viewById3 = this.t.findViewById(n);
                        this.t.getLocationOnScreen(this.q);
                        n12 = this.q[0] + (viewById3.getLeft() + viewById3.getRight()) / 2.0f;
                        n14 = (float)this.q[1];
                        n15 = viewById3.getTop();
                        n = viewById3.getBottom();
                    }
                    else {
                        n = this.d;
                        if (n == -1) {
                            break Label_0947;
                        }
                        final View viewById4 = this.t.findViewById(this.t.u(n).g());
                        this.t.getLocationOnScreen(this.q);
                        n12 = this.q[0] + (viewById4.getLeft() + viewById4.getRight()) / 2.0f;
                        n14 = (float)this.q[1];
                        n15 = viewById4.getTop();
                        n = viewById4.getBottom();
                    }
                    n13 = n14 + (n15 + n) / 2.0f;
                }
                final float n16 = motionEvent.getRawX() - n12;
                final float n17 = motionEvent.getRawY() - n13;
                final double degrees = Math.toDegrees(Math.atan2(n17, n16));
                n = this.d;
                if (n != -1) {
                    this.t.s(n, progress3, this.h, this.g, this.p);
                    final float[] p5 = this.p;
                    p5[1] = (float)Math.toDegrees(p5[1]);
                }
                else {
                    this.p[1] = 360.0f;
                }
                final float n18 = (float)(Math.toDegrees(Math.atan2(d + n17, e2 + n16)) - degrees) * 62.5f;
                float n19;
                if (!Float.isNaN(n18)) {
                    n19 = n18 * 3.0f * this.x / this.p[1] + progress3;
                }
                else {
                    n19 = progress3;
                }
                if (n19 != 0.0f && n19 != 1.0f) {
                    n = this.c;
                    if (n != 3) {
                        final float n20 = n18 * this.x / this.p[1];
                        float n21;
                        if (n19 < 0.5) {
                            n21 = 0.0f;
                        }
                        else {
                            n21 = 1.0f;
                        }
                        float abs = n20;
                        if (n == 6) {
                            abs = n20;
                            if (progress3 + n20 < 0.0f) {
                                abs = Math.abs(n20);
                            }
                            n21 = 1.0f;
                        }
                        float n22 = abs;
                        float n23 = n21;
                        if (this.c == 7) {
                            float n24 = abs;
                            if (progress3 + abs > 1.0f) {
                                n24 = -Math.abs(abs);
                            }
                            n23 = 0.0f;
                            n22 = n24;
                        }
                        this.t.E(this.c, n23, n22 * 3.0f);
                        if (0.0f >= progress3 || 1.0f <= progress3) {
                            this.t.setState(MotionLayout.TransitionState.FINISHED);
                        }
                        return;
                    }
                }
                if (0.0f >= n19 || 1.0f <= n19) {
                    this.t.setState(MotionLayout.TransitionState.FINISHED);
                }
            }
        }
        else {
            this.r = motionEvent.getRawX();
            this.s = motionEvent.getRawY();
            this.o = false;
        }
    }
    
    @Override
    public String toString() {
        String string;
        if (Float.isNaN(this.m)) {
            string = "rotation";
        }
        else {
            final StringBuilder sb = new StringBuilder();
            sb.append(this.m);
            sb.append(" , ");
            sb.append(this.n);
            string = sb.toString();
        }
        return string;
    }
    
    void u(float max, final float n) {
        final float progress = this.t.getProgress();
        if (!this.o) {
            this.o = true;
            this.t.setProgress(progress);
        }
        this.t.s(this.d, progress, this.h, this.g, this.p);
        final float m = this.m;
        final float[] p2 = this.p;
        if (Math.abs(m * p2[0] + this.n * p2[1]) < 0.01) {
            final float[] p3 = this.p;
            p3[1] = (p3[0] = 0.01f);
        }
        final float i = this.m;
        if (i != 0.0f) {
            max = max * i / this.p[0];
        }
        else {
            max = n * this.n / this.p[1];
        }
        max = Math.max(Math.min(progress + max, 1.0f), 0.0f);
        if (max != this.t.getProgress()) {
            this.t.setProgress(max);
        }
    }
    
    void v(float n, float n2) {
        int n3 = 0;
        this.o = false;
        final float progress = this.t.getProgress();
        this.t.s(this.d, progress, this.h, this.g, this.p);
        final float m = this.m;
        final float[] p2 = this.p;
        final float n4 = p2[0];
        final float n5 = this.n;
        final float n6 = p2[1];
        final float n7 = 0.0f;
        if (m != 0.0f) {
            n = n * m / p2[0];
        }
        else {
            n = n2 * n5 / p2[1];
        }
        n2 = progress;
        if (!Float.isNaN(n)) {
            n2 = progress + n / 3.0f;
        }
        if (n2 != 0.0f) {
            final boolean b = n2 != 1.0f;
            final int c = this.c;
            if (c != 3) {
                n3 = 1;
            }
            if ((n3 & (b ? 1 : 0)) != 0x0) {
                final MotionLayout t = this.t;
                if (n2 < 0.5) {
                    n2 = n7;
                }
                else {
                    n2 = 1.0f;
                }
                t.E(c, n2, n);
            }
        }
    }
    
    void w(final float r, final float s) {
        this.r = r;
        this.s = s;
    }
    
    public void x(final boolean b) {
        if (b) {
            final float[][] h = androidx.constraintlayout.motion.widget.r.H;
            h[4] = h[3];
            h[5] = h[2];
            final float[][] g = androidx.constraintlayout.motion.widget.r.G;
            g[5] = g[2];
            g[6] = g[1];
        }
        else {
            final float[][] h2 = androidx.constraintlayout.motion.widget.r.H;
            h2[4] = h2[2];
            h2[5] = h2[3];
            final float[][] g2 = androidx.constraintlayout.motion.widget.r.G;
            g2[5] = g2[1];
            g2[6] = g2[2];
        }
        final float[][] g3 = androidx.constraintlayout.motion.widget.r.G;
        final int a = this.a;
        this.h = g3[a][0];
        this.g = g3[a][1];
        final int b2 = this.b;
        final float[][] h3 = androidx.constraintlayout.motion.widget.r.H;
        if (b2 >= h3.length) {
            return;
        }
        this.m = h3[b2][0];
        this.n = h3[b2][1];
    }
    
    void y(final float r, final float s) {
        this.r = r;
        this.s = s;
        this.o = false;
    }
    
    void z() {
        final int d = this.d;
        Object o;
        if (d != -1) {
            final View viewById = this.t.findViewById(d);
            if ((o = viewById) == null) {
                final StringBuilder sb = new StringBuilder();
                sb.append("cannot find TouchAnchorId @id/");
                sb.append(androidx.constraintlayout.motion.widget.a.b(this.t.getContext(), this.d));
                Log.e("TouchResponse", sb.toString());
                o = viewById;
            }
        }
        else {
            o = null;
        }
        if (o instanceof NestedScrollView) {
            final NestedScrollView nestedScrollView = (NestedScrollView)o;
            nestedScrollView.setOnTouchListener((View$OnTouchListener)new View$OnTouchListener(this) {
                public boolean onTouch(final View view, final MotionEvent motionEvent) {
                    return false;
                }
            });
            nestedScrollView.setOnScrollChangeListener((NestedScrollView.c)new NestedScrollView.c(this) {
                @Override
                public void a(final NestedScrollView nestedScrollView, final int n, final int n2, final int n3, final int n4) {
                }
            });
        }
    }
}
