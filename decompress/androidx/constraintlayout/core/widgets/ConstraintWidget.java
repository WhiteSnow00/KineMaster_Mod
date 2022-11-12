// 
// Decompiled by Procyon v0.6.0
// 

package androidx.constraintlayout.core.widgets;

import androidx.constraintlayout.core.widgets.analyzer.DependencyNode;
import java.util.Iterator;
import java.util.HashSet;
import androidx.constraintlayout.core.SolverVariable;
import androidx.constraintlayout.core.d;
import q.a;
import androidx.constraintlayout.core.widgets.analyzer.l;
import androidx.constraintlayout.core.widgets.analyzer.j;
import androidx.constraintlayout.core.widgets.analyzer.c;
import androidx.constraintlayout.core.widgets.analyzer.WidgetRun;
import java.util.ArrayList;

public class ConstraintWidget
{
    public static float K0 = 0.5f;
    public int A;
    int A0;
    public float B;
    boolean B0;
    public int C;
    boolean C0;
    public int D;
    public float[] D0;
    public float E;
    protected ConstraintWidget[] E0;
    int F;
    protected ConstraintWidget[] F0;
    float G;
    ConstraintWidget G0;
    private int[] H;
    ConstraintWidget H0;
    private float I;
    public int I0;
    private boolean J;
    public int J0;
    private boolean K;
    private boolean L;
    private int M;
    private int N;
    public ConstraintAnchor O;
    public ConstraintAnchor P;
    public ConstraintAnchor Q;
    public ConstraintAnchor R;
    public ConstraintAnchor S;
    ConstraintAnchor T;
    ConstraintAnchor U;
    public ConstraintAnchor V;
    public ConstraintAnchor[] W;
    protected ArrayList<ConstraintAnchor> X;
    private boolean[] Y;
    public DimensionBehaviour[] Z;
    public boolean a;
    public ConstraintWidget a0;
    public WidgetRun[] b;
    int b0;
    public c c;
    int c0;
    public c d;
    public float d0;
    public j e;
    protected int e0;
    public l f;
    protected int f0;
    public boolean[] g;
    protected int g0;
    boolean h;
    int h0;
    private boolean i;
    int i0;
    private boolean j;
    protected int j0;
    private boolean k;
    protected int k0;
    private int l;
    int l0;
    private int m;
    protected int m0;
    public a n;
    protected int n0;
    public String o;
    float o0;
    private boolean p;
    float p0;
    private boolean q;
    private Object q0;
    private boolean r;
    private int r0;
    private boolean s;
    private int s0;
    public int t;
    private boolean t0;
    public int u;
    private String u0;
    private int v;
    private String v0;
    public int w;
    boolean w0;
    public int x;
    boolean x0;
    public int[] y;
    boolean y0;
    public int z;
    int z0;
    
    public ConstraintWidget() {
        this.a = false;
        this.b = new WidgetRun[2];
        this.e = null;
        this.f = null;
        this.g = new boolean[] { true, true };
        this.h = false;
        this.i = true;
        this.j = false;
        this.k = true;
        this.l = -1;
        this.m = -1;
        this.n = new a(this);
        this.p = false;
        this.q = false;
        this.r = false;
        this.s = false;
        this.t = -1;
        this.u = -1;
        this.v = 0;
        this.w = 0;
        this.x = 0;
        this.y = new int[2];
        this.z = 0;
        this.A = 0;
        this.B = 1.0f;
        this.C = 0;
        this.D = 0;
        this.E = 1.0f;
        this.F = -1;
        this.G = 1.0f;
        this.H = new int[] { Integer.MAX_VALUE, Integer.MAX_VALUE };
        this.I = 0.0f;
        this.J = false;
        this.L = false;
        this.M = 0;
        this.N = 0;
        this.O = new ConstraintAnchor(this, ConstraintAnchor.Type.LEFT);
        this.P = new ConstraintAnchor(this, ConstraintAnchor.Type.TOP);
        this.Q = new ConstraintAnchor(this, ConstraintAnchor.Type.RIGHT);
        this.R = new ConstraintAnchor(this, ConstraintAnchor.Type.BOTTOM);
        this.S = new ConstraintAnchor(this, ConstraintAnchor.Type.BASELINE);
        this.T = new ConstraintAnchor(this, ConstraintAnchor.Type.CENTER_X);
        this.U = new ConstraintAnchor(this, ConstraintAnchor.Type.CENTER_Y);
        final ConstraintAnchor v = new ConstraintAnchor(this, ConstraintAnchor.Type.CENTER);
        this.V = v;
        this.W = new ConstraintAnchor[] { this.O, this.Q, this.P, this.R, this.S, v };
        this.X = new ArrayList<ConstraintAnchor>();
        this.Y = new boolean[2];
        final DimensionBehaviour fixed = DimensionBehaviour.FIXED;
        this.Z = new DimensionBehaviour[] { fixed, fixed };
        this.a0 = null;
        this.b0 = 0;
        this.c0 = 0;
        this.d0 = 0.0f;
        this.e0 = -1;
        this.f0 = 0;
        this.g0 = 0;
        this.h0 = 0;
        this.i0 = 0;
        this.j0 = 0;
        this.k0 = 0;
        this.l0 = 0;
        final float k0 = ConstraintWidget.K0;
        this.o0 = k0;
        this.p0 = k0;
        this.r0 = 0;
        this.s0 = 0;
        this.t0 = false;
        this.u0 = null;
        this.v0 = null;
        this.y0 = false;
        this.z0 = 0;
        this.A0 = 0;
        this.D0 = new float[] { -1.0f, -1.0f };
        this.E0 = new ConstraintWidget[] { null, null };
        this.F0 = new ConstraintWidget[] { null, null };
        this.G0 = null;
        this.H0 = null;
        this.I0 = -1;
        this.J0 = -1;
        this.d();
    }
    
    private void N(final StringBuilder sb, final String s, final int n, final int n2, final int n3, final int n4, final int n5, final int n6, final float n7, final float n8) {
        sb.append(s);
        sb.append(" :  {\n");
        this.v0(sb, "      size", n, 0);
        this.v0(sb, "      min", n2, 0);
        this.v0(sb, "      max", n3, Integer.MAX_VALUE);
        this.v0(sb, "      matchMin", n5, 0);
        this.v0(sb, "      matchDef", n6, 0);
        this.u0(sb, "      matchPercent", n7, 1.0f);
        sb.append("    },\n");
    }
    
    private void O(final StringBuilder sb, final String s, final ConstraintAnchor constraintAnchor) {
        if (constraintAnchor.f == null) {
            return;
        }
        sb.append("    ");
        sb.append(s);
        sb.append(" : [ '");
        sb.append(constraintAnchor.f);
        sb.append("'");
        if (constraintAnchor.h != Integer.MIN_VALUE || constraintAnchor.g != 0) {
            sb.append(",");
            sb.append(constraintAnchor.g);
            if (constraintAnchor.h != Integer.MIN_VALUE) {
                sb.append(",");
                sb.append(constraintAnchor.h);
                sb.append(",");
            }
        }
        sb.append(" ] ,\n");
    }
    
    private void d() {
        this.X.add(this.O);
        this.X.add(this.P);
        this.X.add(this.Q);
        this.X.add(this.R);
        this.X.add(this.T);
        this.X.add(this.U);
        this.X.add(this.V);
        this.X.add(this.S);
    }
    
    private boolean d0(int n) {
        n *= 2;
        final ConstraintAnchor[] w = this.W;
        final ConstraintAnchor f = w[n].f;
        boolean b = true;
        if (f != null && w[n].f.f != w[n]) {
            ++n;
            if (w[n].f != null && w[n].f.f == w[n]) {
                return b;
            }
        }
        b = false;
        return b;
    }
    
    private void i(final d d, final boolean b, boolean b2, final boolean b3, boolean b4, final SolverVariable solverVariable, final SolverVariable solverVariable2, DimensionBehaviour dimensionBehaviour, final boolean b5, final ConstraintAnchor constraintAnchor, final ConstraintAnchor constraintAnchor2, int n, int n2, final int n3, int n4, final float n5, final boolean b6, final boolean b7, final boolean b8, final boolean b9, final boolean b10, int n6, int n7, int n8, int n9, final float n10, final boolean b11) {
        final SolverVariable q = d.q(constraintAnchor);
        final SolverVariable q2 = d.q(constraintAnchor2);
        final SolverVariable q3 = d.q(constraintAnchor.i());
        final SolverVariable q4 = d.q(constraintAnchor2.i());
        d.x();
        final int n11 = constraintAnchor.n() ? 1 : 0;
        final boolean n12 = constraintAnchor2.n();
        final boolean n13 = this.V.n();
        int n14;
        if (n12) {
            n14 = n11 + 1;
        }
        else {
            n14 = n11;
        }
        int n15 = n14;
        if (n13) {
            n15 = n14 + 1;
        }
        int n16;
        if (b6) {
            n16 = 3;
        }
        else {
            n16 = n6;
        }
        n6 = ConstraintWidget$a.b[dimensionBehaviour.ordinal()];
        int n17;
        if (n6 != 1 && n6 != 2 && n6 != 3 && n6 == 4 && n16 != 4) {
            n17 = 1;
        }
        else {
            n17 = 0;
        }
        final int l = this.l;
        n6 = n17;
        int n18 = n2;
        if (l != -1) {
            n6 = n17;
            n18 = n2;
            if (b) {
                this.l = -1;
                n18 = l;
                n6 = 0;
            }
        }
        n2 = this.m;
        if (n2 != -1 && !b) {
            this.m = -1;
            final int n19 = 0;
            n6 = n2;
            n2 = n19;
        }
        else {
            n2 = n6;
            n6 = n18;
        }
        if (this.s0 == 8) {
            n6 = 0;
            n2 = 0;
        }
        if (b11) {
            if (n11 == 0 && !n12 && !n13) {
                d.f(q, n);
            }
            else if (n11 != 0 && !n12) {
                d.e(q, q3, constraintAnchor.e(), 8);
            }
        }
        int n20 = 0;
        Label_0891: {
            if (n2 == 0) {
                if (b5) {
                    d.e(q2, q, 0, 3);
                    if (n3 > 0) {
                        d.h(q2, q, n3, 8);
                    }
                    if (n4 < Integer.MAX_VALUE) {
                        d.j(q2, q, n4, 8);
                    }
                }
                else {
                    d.e(q2, q, n6, 8);
                }
                n20 = n2;
            }
            else if (n15 != 2 && !b6 && (n16 == 1 || n16 == 0)) {
                n2 = (n = Math.max(n8, n6));
                if (n9 > 0) {
                    n = Math.min(n9, n2);
                }
                d.e(q2, q, n, 8);
                n20 = 0;
            }
            else {
                if (n8 == -2) {
                    n = n6;
                }
                else {
                    n = n8;
                }
                if (n9 == -2) {
                    n4 = n6;
                }
                else {
                    n4 = n9;
                }
                n8 = n6;
                if (n6 > 0) {
                    n8 = n6;
                    if (n16 != 1) {
                        n8 = 0;
                    }
                }
                n6 = n8;
                if (n > 0) {
                    d.h(q2, q, n, 8);
                    n6 = Math.max(n8, n);
                }
                if (n4 > 0) {
                    if (b2 && n16 == 1) {
                        n8 = 0;
                    }
                    else {
                        n8 = 1;
                    }
                    if (n8 != 0) {
                        d.j(q2, q, n4, 8);
                    }
                    n6 = Math.min(n6, n4);
                }
                if (n16 == 1) {
                    if (b2) {
                        d.e(q2, q, n6, 8);
                    }
                    else if (b8) {
                        d.e(q2, q, n6, 5);
                        d.j(q2, q, n6, 8);
                    }
                    else {
                        d.e(q2, q, n6, 5);
                        d.j(q2, q, n6, 8);
                    }
                    n9 = n;
                    n = n4;
                    n20 = n2;
                    break Label_0891;
                }
                if (n16 == 2) {
                    final ConstraintAnchor.Type j = constraintAnchor.j();
                    final ConstraintAnchor.Type top = ConstraintAnchor.Type.TOP;
                    SolverVariable solverVariable3;
                    SolverVariable solverVariable4;
                    if (j != top && constraintAnchor.j() != ConstraintAnchor.Type.BOTTOM) {
                        solverVariable3 = d.q(this.a0.m(ConstraintAnchor.Type.LEFT));
                        solverVariable4 = d.q(this.a0.m(ConstraintAnchor.Type.RIGHT));
                    }
                    else {
                        solverVariable3 = d.q(this.a0.m(top));
                        solverVariable4 = d.q(this.a0.m(ConstraintAnchor.Type.BOTTOM));
                    }
                    d.d(d.r().k(q2, q, solverVariable4, solverVariable3, n10));
                    if (b2) {
                        n2 = 0;
                    }
                    n9 = n;
                    n = n4;
                    n20 = n2;
                    break Label_0891;
                }
                b4 = true;
                n20 = n2;
                n9 = n;
                n = n4;
                break Label_0891;
            }
            n = n9;
            n9 = n8;
        }
        if (b11 && !b8) {
            Label_2300: {
                Label_0919: {
                    if (n11 != 0 || n12 || n13) {
                        boolean b12;
                        if (n11 != 0 && !n12) {
                            final ConstraintWidget d2 = constraintAnchor.f.d;
                            if (b2 && d2 instanceof androidx.constraintlayout.core.widgets.a) {
                                n = 8;
                            }
                            else {
                                n = 5;
                            }
                            b12 = b2;
                            n2 = n;
                        }
                        else if (n11 == 0 && n12) {
                            d.e(q2, q4, -constraintAnchor2.e(), 8);
                            if (b2) {
                                if (this.j && q.g) {
                                    final ConstraintWidget a0 = this.a0;
                                    if (a0 != null) {
                                        final androidx.constraintlayout.core.widgets.d d3 = (androidx.constraintlayout.core.widgets.d)a0;
                                        if (b) {
                                            d3.w1(constraintAnchor);
                                            break Label_0919;
                                        }
                                        d3.B1(constraintAnchor);
                                        break Label_0919;
                                    }
                                }
                                d.h(q, solverVariable, 0, 5);
                            }
                            break Label_0919;
                        }
                        else {
                            if (n11 == 0 || !n12) {
                                break Label_0919;
                            }
                            final ConstraintWidget d4 = constraintAnchor.f.d;
                            final ConstraintWidget d5 = constraintAnchor2.f.d;
                            final ConstraintWidget i = this.I();
                            Label_1702: {
                                Label_1689: {
                                    if (n20 != 0) {
                                        if (n16 == 0) {
                                            if (n == 0 && n9 == 0) {
                                                if (q3.g && q4.g) {
                                                    d.e(q, q3, constraintAnchor.e(), 8);
                                                    d.e(q2, q4, -constraintAnchor2.e(), 8);
                                                    return;
                                                }
                                                n = 8;
                                                n7 = 8;
                                                n4 = 0;
                                                n2 = 0;
                                                n6 = 1;
                                            }
                                            else {
                                                n6 = 0;
                                                n = 5;
                                                n7 = 5;
                                                n4 = 1;
                                                n2 = 1;
                                            }
                                            if (d4 instanceof androidx.constraintlayout.core.widgets.a || d5 instanceof androidx.constraintlayout.core.widgets.a) {
                                                n7 = 4;
                                            }
                                            final int n21 = n6;
                                            n8 = n4;
                                            n6 = n2;
                                            n4 = 6;
                                            n2 = n7;
                                            n7 = n21;
                                            break Label_1702;
                                        }
                                        if (n16 == 2) {
                                            if (!(d4 instanceof androidx.constraintlayout.core.widgets.a) && !(d5 instanceof androidx.constraintlayout.core.widgets.a)) {
                                                n2 = 5;
                                            }
                                            else {
                                                n2 = 4;
                                            }
                                            n = 5;
                                        }
                                        else if (n16 == 1) {
                                            n = 8;
                                            n2 = 4;
                                        }
                                        else {
                                            if (n16 != 3) {
                                                n6 = 0;
                                                n8 = 0;
                                                break Label_1689;
                                            }
                                            if (this.F == -1) {
                                                if (b9) {
                                                    if (b2) {
                                                        n4 = 5;
                                                    }
                                                    else {
                                                        n4 = 4;
                                                    }
                                                }
                                                else {
                                                    n4 = 8;
                                                }
                                                n = 8;
                                                n2 = 5;
                                                n6 = 1;
                                                n8 = 1;
                                                n7 = 1;
                                                break Label_1702;
                                            }
                                            if (b6) {
                                                if (n7 != 2 && n7 != 1) {
                                                    n = 0;
                                                }
                                                else {
                                                    n = 1;
                                                }
                                                if (n == 0) {
                                                    n2 = 8;
                                                    n = 5;
                                                }
                                                else {
                                                    n2 = 5;
                                                    n = 4;
                                                }
                                                n6 = n2;
                                                final int n22 = 1;
                                                n8 = (n7 = 1);
                                                n4 = 6;
                                                n2 = n;
                                                n = n6;
                                                n6 = n22;
                                                break Label_1702;
                                            }
                                            if (n > 0) {
                                                n2 = 5;
                                            }
                                            else if (n == 0 && n9 == 0) {
                                                if (b9) {
                                                    if (d4 != i && d5 != i) {
                                                        n = 4;
                                                    }
                                                    else {
                                                        n = 5;
                                                    }
                                                    n6 = 1;
                                                    n8 = (n7 = 1);
                                                    n4 = 6;
                                                    n2 = 4;
                                                    break Label_1702;
                                                }
                                                n2 = 8;
                                            }
                                            else {
                                                n2 = 4;
                                            }
                                            n7 = 1;
                                            n8 = 1;
                                            n6 = 1;
                                            n4 = 6;
                                            n = 5;
                                            break Label_1702;
                                        }
                                        n7 = 0;
                                        n4 = 6;
                                        n6 = 1;
                                        n8 = 1;
                                        break Label_1702;
                                    }
                                    else {
                                        if (q3.g && q4.g) {
                                            d.c(q, q3, constraintAnchor.e(), n5, q4, q2, constraintAnchor2.e(), 8);
                                            if (b2 && b4) {
                                                if (constraintAnchor2.f != null) {
                                                    n = constraintAnchor2.e();
                                                }
                                                else {
                                                    n = 0;
                                                }
                                                if (q4 != solverVariable2) {
                                                    d.h(solverVariable2, q2, n, 5);
                                                }
                                            }
                                            return;
                                        }
                                        n6 = 1;
                                        n8 = 1;
                                    }
                                }
                                n = 5;
                                n2 = 4;
                                n4 = 6;
                                n7 = 0;
                            }
                            boolean b13;
                            if (n6 != 0 && q3 == q4 && d4 != i) {
                                n6 = 0;
                                b13 = false;
                            }
                            else {
                                b13 = true;
                            }
                            if (n8 != 0) {
                                if (n20 == 0 && !b7 && !b9 && q3 == solverVariable && q4 == solverVariable2) {
                                    n = 8;
                                    n4 = 8;
                                    b2 = false;
                                    b13 = false;
                                }
                                d.c(q, q3, constraintAnchor.e(), n5, q4, q2, constraintAnchor2.e(), n4);
                            }
                            if (this.s0 == 8 && !constraintAnchor2.l()) {
                                return;
                            }
                            if (n6 != 0) {
                                if (b2 && q3 != q4 && n20 == 0 && (d4 instanceof androidx.constraintlayout.core.widgets.a || d5 instanceof androidx.constraintlayout.core.widgets.a)) {
                                    n = 6;
                                }
                                d.h(q, q3, constraintAnchor.e(), n);
                                d.j(q2, q4, -constraintAnchor2.e(), n);
                            }
                            if (b2 && b10 && !(d4 instanceof androidx.constraintlayout.core.widgets.a) && !(d5 instanceof androidx.constraintlayout.core.widgets.a) && d5 != i) {
                                n = 6;
                                n4 = 6;
                                b13 = true;
                            }
                            else {
                                n4 = n;
                                n = n2;
                            }
                            if (b13) {
                                if (n7 != 0 && (!b9 || b3)) {
                                    if (d4 != i && d5 != i) {
                                        n2 = n;
                                    }
                                    else {
                                        n2 = 6;
                                    }
                                    if (d4 instanceof e || d5 instanceof e) {
                                        n2 = 5;
                                    }
                                    if (d4 instanceof androidx.constraintlayout.core.widgets.a || d5 instanceof androidx.constraintlayout.core.widgets.a) {
                                        n2 = 5;
                                    }
                                    if (b9) {
                                        n2 = 5;
                                    }
                                    n2 = Math.max(n2, n);
                                }
                                else {
                                    n2 = n;
                                }
                                n = n2;
                                Label_2131: {
                                    if (b2) {
                                        n2 = (n = Math.min(n4, n2));
                                        if (b6) {
                                            n = n2;
                                            if (!b9) {
                                                if (d4 != i) {
                                                    n = n2;
                                                    if (d5 != i) {
                                                        break Label_2131;
                                                    }
                                                }
                                                n = 4;
                                            }
                                        }
                                    }
                                }
                                d.e(q, q3, constraintAnchor.e(), n);
                                d.e(q2, q4, -constraintAnchor2.e(), n);
                            }
                            if (b2) {
                                if (solverVariable == q3) {
                                    n = constraintAnchor.e();
                                }
                                else {
                                    n = 0;
                                }
                                if (q3 != solverVariable) {
                                    d.h(q, solverVariable, n, 5);
                                }
                            }
                            n = (n2 = 5);
                            if (b12 = b2) {
                                n2 = n;
                                b12 = b2;
                                if (n20 != 0) {
                                    n2 = n;
                                    b12 = b2;
                                    if (n3 == 0) {
                                        n2 = n;
                                        b12 = b2;
                                        if (n9 == 0) {
                                            if (n20 != 0 && n16 == 3) {
                                                d.h(q2, q, 0, 8);
                                                break Label_2300;
                                            }
                                            d.h(q2, q, 0, 5);
                                            break Label_2300;
                                        }
                                    }
                                }
                            }
                        }
                        n = n2;
                        b2 = b12;
                        break Label_2300;
                    }
                }
                n = 5;
            }
            n2 = 0;
            if (b2 && b4) {
                if (constraintAnchor2.f != null) {
                    n2 = constraintAnchor2.e();
                }
                if (q4 != solverVariable2) {
                    if (this.j && q2.g) {
                        final ConstraintWidget a2 = this.a0;
                        if (a2 != null) {
                            final androidx.constraintlayout.core.widgets.d d6 = (androidx.constraintlayout.core.widgets.d)a2;
                            if (b) {
                                d6.v1(constraintAnchor2);
                            }
                            else {
                                d6.A1(constraintAnchor2);
                            }
                            return;
                        }
                    }
                    d.h(solverVariable2, q2, n2, n);
                }
            }
            return;
        }
        if (n15 < 2 && b2 && b4) {
            d.h(q, solverVariable, 0, 8);
            if (!b && this.S.f != null) {
                n = 0;
            }
            else {
                n = 1;
            }
            n2 = n;
            Label_2537: {
                if (!b) {
                    final ConstraintAnchor f = this.S.f;
                    n2 = n;
                    if (f != null) {
                        final ConstraintWidget d7 = f.d;
                        if (d7.d0 != 0.0f) {
                            final DimensionBehaviour[] z = d7.Z;
                            dimensionBehaviour = z[0];
                            final DimensionBehaviour match_CONSTRAINT = DimensionBehaviour.MATCH_CONSTRAINT;
                            if (dimensionBehaviour == match_CONSTRAINT && z[1] == match_CONSTRAINT) {
                                n2 = 1;
                                break Label_2537;
                            }
                        }
                        n2 = 0;
                    }
                }
            }
            if (n2 != 0) {
                d.h(solverVariable2, q2, 0, 8);
            }
        }
    }
    
    private void u0(final StringBuilder sb, final String s, final float n, final float n2) {
        if (n == n2) {
            return;
        }
        sb.append(s);
        sb.append(" :   ");
        sb.append(n);
        sb.append(",\n");
    }
    
    private void v0(final StringBuilder sb, final String s, final int n, final int n2) {
        if (n == n2) {
            return;
        }
        sb.append(s);
        sb.append(" :   ");
        sb.append(n);
        sb.append(",\n");
    }
    
    private void w0(final StringBuilder sb, final String s, final float n, final int n2) {
        if (n == 0.0f) {
            return;
        }
        sb.append(s);
        sb.append(" :  [");
        sb.append(n);
        sb.append(",");
        sb.append(n2);
        sb.append("");
        sb.append("],\n");
    }
    
    public int A() {
        return this.M;
    }
    
    public void A0(String s) {
        Label_0261: {
            if (s == null || s.length() == 0) {
                break Label_0261;
            }
            final int n = -1;
            final int length = s.length();
            final int index = s.indexOf(44);
            final int n2 = 0;
            int e0 = n;
            int n3 = n2;
            if (index > 0) {
                e0 = n;
                n3 = n2;
                if (index < length - 1) {
                    final String substring = s.substring(0, index);
                    if (substring.equalsIgnoreCase("W")) {
                        e0 = 0;
                    }
                    else {
                        e0 = n;
                        if (substring.equalsIgnoreCase("H")) {
                            e0 = 1;
                        }
                    }
                    n3 = index + 1;
                }
            }
            final int index2 = s.indexOf(58);
            Label_0219: {
                if (index2 < 0 || index2 >= length - 1) {
                    break Label_0219;
                }
                final String substring2 = s.substring(n3, index2);
                s = s.substring(index2 + 1);
                while (true) {
                    if (substring2.length() <= 0 || s.length() <= 0) {
                        break Label_0241;
                    }
                    try {
                        final float float1 = Float.parseFloat(substring2);
                        final float float2 = Float.parseFloat(s);
                        while (true) {
                            if (float1 > 0.0f && float2 > 0.0f) {
                                if (e0 == 1) {
                                    final float d0 = Math.abs(float2 / float1);
                                    break Label_0243;
                                }
                                final float d0 = Math.abs(float1 / float2);
                                break Label_0243;
                            }
                            float d0 = 0.0f;
                            if (d0 > 0.0f) {
                                this.d0 = d0;
                                this.e0 = e0;
                            }
                            return;
                            s = s.substring(n3);
                            iftrue(Label_0241:)(s.length() <= 0);
                            Block_15: {
                                break Block_15;
                                this.d0 = 0.0f;
                                return;
                            }
                            d0 = Float.parseFloat(s);
                            continue;
                        }
                    }
                    catch (final NumberFormatException ex) {
                        continue;
                    }
                    break;
                }
            }
        }
    }
    
    public int B() {
        return this.N;
    }
    
    public void B0(final int n) {
        if (!this.J) {
            return;
        }
        final int g0 = n - this.l0;
        final int c0 = this.c0;
        this.g0 = g0;
        this.P.s(g0);
        this.R.s(c0 + g0);
        this.S.s(n);
        this.q = true;
    }
    
    public int C(final int n) {
        if (n == 0) {
            return this.U();
        }
        if (n == 1) {
            return this.v();
        }
        return 0;
    }
    
    public void C0(final int f0, final int n) {
        if (this.p) {
            return;
        }
        this.O.s(f0);
        this.Q.s(n);
        this.f0 = f0;
        this.b0 = n - f0;
        this.p = true;
    }
    
    public int D() {
        return this.H[1];
    }
    
    public void D0(final int f0) {
        this.O.s(f0);
        this.f0 = f0;
    }
    
    public int E() {
        return this.H[0];
    }
    
    public void E0(final int g0) {
        this.P.s(g0);
        this.g0 = g0;
    }
    
    public int F() {
        return this.n0;
    }
    
    public void F0(final int g0, final int n) {
        if (this.q) {
            return;
        }
        this.P.s(g0);
        this.R.s(n);
        this.g0 = g0;
        this.c0 = n - g0;
        if (this.J) {
            this.S.s(g0 + this.l0);
        }
        this.q = true;
    }
    
    public int G() {
        return this.m0;
    }
    
    public void G0(int c0, int b0, int l, int c2) {
        final int n = l - c0;
        l = c2 - b0;
        this.f0 = c0;
        this.g0 = b0;
        if (this.s0 == 8) {
            this.b0 = 0;
            this.c0 = 0;
            return;
        }
        final DimensionBehaviour[] z = this.Z;
        final DimensionBehaviour dimensionBehaviour = z[0];
        final DimensionBehaviour fixed = DimensionBehaviour.FIXED;
        c0 = n;
        if (dimensionBehaviour == fixed) {
            b0 = this.b0;
            if ((c0 = n) < b0) {
                c0 = b0;
            }
        }
        b0 = l;
        if (z[1] == fixed) {
            c2 = this.c0;
            if ((b0 = l) < c2) {
                b0 = c2;
            }
        }
        this.b0 = c0;
        this.c0 = b0;
        l = this.n0;
        if (b0 < l) {
            this.c0 = l;
        }
        l = this.m0;
        if (c0 < l) {
            this.b0 = l;
        }
        l = this.A;
        if (l > 0 && z[0] == DimensionBehaviour.MATCH_CONSTRAINT) {
            this.b0 = Math.min(this.b0, l);
        }
        l = this.D;
        if (l > 0 && this.Z[1] == DimensionBehaviour.MATCH_CONSTRAINT) {
            this.c0 = Math.min(this.c0, l);
        }
        l = this.b0;
        if (c0 != l) {
            this.l = l;
        }
        c0 = this.c0;
        if (b0 != c0) {
            this.m = c0;
        }
    }
    
    public ConstraintWidget H(final int n) {
        if (n == 0) {
            final ConstraintAnchor q = this.Q;
            final ConstraintAnchor f = q.f;
            if (f != null && f.f == q) {
                return f.d;
            }
        }
        else if (n == 1) {
            final ConstraintAnchor r = this.R;
            final ConstraintAnchor f2 = r.f;
            if (f2 != null && f2.f == r) {
                return f2.d;
            }
        }
        return null;
    }
    
    public void H0(final boolean j) {
        this.J = j;
    }
    
    public ConstraintWidget I() {
        return this.a0;
    }
    
    public void I0(final int c0) {
        this.c0 = c0;
        final int n0 = this.n0;
        if (c0 < n0) {
            this.c0 = n0;
        }
    }
    
    public ConstraintWidget J(final int n) {
        if (n == 0) {
            final ConstraintAnchor o = this.O;
            final ConstraintAnchor f = o.f;
            if (f != null && f.f == o) {
                return f.d;
            }
        }
        else if (n == 1) {
            final ConstraintAnchor p = this.P;
            final ConstraintAnchor f2 = p.f;
            if (f2 != null && f2.f == p) {
                return f2.d;
            }
        }
        return null;
    }
    
    public void J0(final float o0) {
        this.o0 = o0;
    }
    
    public int K() {
        return this.V() + this.b0;
    }
    
    public void K0(final int z0) {
        this.z0 = z0;
    }
    
    public WidgetRun L(final int n) {
        if (n == 0) {
            return this.e;
        }
        if (n == 1) {
            return this.f;
        }
        return null;
    }
    
    public void L0(int m0, int b0) {
        this.f0 = m0;
        b0 -= m0;
        this.b0 = b0;
        m0 = this.m0;
        if (b0 < m0) {
            this.b0 = m0;
        }
    }
    
    public void M(final StringBuilder sb) {
        final StringBuilder sb2 = new StringBuilder();
        sb2.append("  ");
        sb2.append(this.o);
        sb2.append(":{\n");
        sb.append(sb2.toString());
        final StringBuilder sb3 = new StringBuilder();
        sb3.append("    actualWidth:");
        sb3.append(this.b0);
        sb.append(sb3.toString());
        sb.append("\n");
        final StringBuilder sb4 = new StringBuilder();
        sb4.append("    actualHeight:");
        sb4.append(this.c0);
        sb.append(sb4.toString());
        sb.append("\n");
        final StringBuilder sb5 = new StringBuilder();
        sb5.append("    actualLeft:");
        sb5.append(this.f0);
        sb.append(sb5.toString());
        sb.append("\n");
        final StringBuilder sb6 = new StringBuilder();
        sb6.append("    actualTop:");
        sb6.append(this.g0);
        sb.append(sb6.toString());
        sb.append("\n");
        this.O(sb, "left", this.O);
        this.O(sb, "top", this.P);
        this.O(sb, "right", this.Q);
        this.O(sb, "bottom", this.R);
        this.O(sb, "baseline", this.S);
        this.O(sb, "centerX", this.T);
        this.O(sb, "centerY", this.U);
        this.N(sb, "    width", this.b0, this.m0, this.H[0], this.l, this.z, this.w, this.B, this.D0[0]);
        this.N(sb, "    height", this.c0, this.n0, this.H[1], this.m, this.C, this.x, this.E, this.D0[1]);
        this.w0(sb, "    dimensionRatio", this.d0, this.e0);
        this.u0(sb, "    horizontalBias", this.o0, ConstraintWidget.K0);
        this.u0(sb, "    verticalBias", this.p0, ConstraintWidget.K0);
        this.v0(sb, "    horizontalChainStyle", this.z0, 0);
        this.v0(sb, "    verticalChainStyle", this.A0, 0);
        sb.append("  }");
    }
    
    public void M0(final DimensionBehaviour dimensionBehaviour) {
        this.Z[0] = dimensionBehaviour;
    }
    
    public void N0(final int w, int n, final int n2, final float b) {
        this.w = w;
        this.z = n;
        n = n2;
        if (n2 == Integer.MAX_VALUE) {
            n = 0;
        }
        this.A = n;
        this.B = b;
        if (b > 0.0f && b < 1.0f && w == 0) {
            this.w = 2;
        }
    }
    
    public void O0(final float n) {
        this.D0[0] = n;
    }
    
    public float P() {
        return this.p0;
    }
    
    protected void P0(final int n, final boolean b) {
        this.Y[n] = b;
    }
    
    public int Q() {
        return this.A0;
    }
    
    public void Q0(final boolean k) {
        this.K = k;
    }
    
    public DimensionBehaviour R() {
        return this.Z[1];
    }
    
    public void R0(final boolean l) {
        this.L = l;
    }
    
    public int S() {
        final ConstraintAnchor o = this.O;
        int n = 0;
        if (o != null) {
            n = 0 + this.P.g;
        }
        int n2 = n;
        if (this.Q != null) {
            n2 = n + this.R.g;
        }
        return n2;
    }
    
    public void S0(final int m, final int n) {
        this.M = m;
        this.N = n;
        this.V0(false);
    }
    
    public int T() {
        return this.s0;
    }
    
    public void T0(final int n) {
        this.H[1] = n;
    }
    
    public int U() {
        if (this.s0 == 8) {
            return 0;
        }
        return this.b0;
    }
    
    public void U0(final int n) {
        this.H[0] = n;
    }
    
    public int V() {
        final ConstraintWidget a0 = this.a0;
        if (a0 != null && a0 instanceof androidx.constraintlayout.core.widgets.d) {
            return ((androidx.constraintlayout.core.widgets.d)a0).S0 + this.f0;
        }
        return this.f0;
    }
    
    public void V0(final boolean i) {
        this.i = i;
    }
    
    public int W() {
        final ConstraintWidget a0 = this.a0;
        if (a0 != null && a0 instanceof androidx.constraintlayout.core.widgets.d) {
            return ((androidx.constraintlayout.core.widgets.d)a0).T0 + this.g0;
        }
        return this.g0;
    }
    
    public void W0(final int n0) {
        if (n0 < 0) {
            this.n0 = 0;
        }
        else {
            this.n0 = n0;
        }
    }
    
    public boolean X() {
        return this.J;
    }
    
    public void X0(final int m0) {
        if (m0 < 0) {
            this.m0 = 0;
        }
        else {
            this.m0 = m0;
        }
    }
    
    public boolean Y(int n) {
        boolean b = true;
        final boolean b2 = true;
        if (n == 0) {
            if (this.O.f != null) {
                n = 1;
            }
            else {
                n = 0;
            }
            int n2;
            if (this.Q.f != null) {
                n2 = 1;
            }
            else {
                n2 = 0;
            }
            return n + n2 < 2 && b2;
        }
        if (this.P.f != null) {
            n = 1;
        }
        else {
            n = 0;
        }
        int n3;
        if (this.R.f != null) {
            n3 = 1;
        }
        else {
            n3 = 0;
        }
        int n4;
        if (this.S.f != null) {
            n4 = 1;
        }
        else {
            n4 = 0;
        }
        if (n + n3 + n4 >= 2) {
            b = false;
        }
        return b;
    }
    
    public void Y0(final int f0, final int g0) {
        this.f0 = f0;
        this.g0 = g0;
    }
    
    public boolean Z() {
        for (int size = this.X.size(), i = 0; i < size; ++i) {
            if (this.X.get(i).l()) {
                return true;
            }
        }
        return false;
    }
    
    public void Z0(final ConstraintWidget a0) {
        this.a0 = a0;
    }
    
    public boolean a0() {
        return this.l != -1 || this.m != -1;
    }
    
    public void a1(final float p) {
        this.p0 = p;
    }
    
    public boolean b0(final int n, final int n2) {
        final boolean b = true;
        boolean b2 = true;
        if (n == 0) {
            final ConstraintAnchor f = this.O.f;
            if (f != null && f.m()) {
                final ConstraintAnchor f2 = this.Q.f;
                if (f2 != null && f2.m()) {
                    if (this.Q.f.d() - this.Q.e() - (this.O.f.d() + this.O.e()) < n2) {
                        b2 = false;
                    }
                    return b2;
                }
            }
        }
        else {
            final ConstraintAnchor f3 = this.P.f;
            if (f3 != null && f3.m()) {
                final ConstraintAnchor f4 = this.R.f;
                if (f4 != null && f4.m()) {
                    return this.R.f.d() - this.R.e() - (this.P.f.d() + this.P.e()) >= n2 && b;
                }
            }
        }
        return false;
    }
    
    public void b1(final int a0) {
        this.A0 = a0;
    }
    
    public void c0(final ConstraintAnchor.Type type, final ConstraintWidget constraintWidget, final ConstraintAnchor.Type type2, final int n, final int n2) {
        this.m(type).a(constraintWidget.m(type2), n, n2, true);
    }
    
    public void c1(int n0, int c0) {
        this.g0 = n0;
        c0 -= n0;
        this.c0 = c0;
        n0 = this.n0;
        if (c0 < n0) {
            this.c0 = n0;
        }
    }
    
    public void d1(final DimensionBehaviour dimensionBehaviour) {
        this.Z[1] = dimensionBehaviour;
    }
    
    public void e(final androidx.constraintlayout.core.widgets.d d, final d d2, final HashSet<ConstraintWidget> set, final int n, final boolean b) {
        if (b) {
            if (!set.contains(this)) {
                return;
            }
            androidx.constraintlayout.core.widgets.f.a(d, d2, this);
            set.remove(this);
            this.g(d2, d.Q1(64));
        }
        if (n == 0) {
            final HashSet<ConstraintAnchor> c = this.O.c();
            if (c != null) {
                final Iterator<ConstraintAnchor> iterator = c.iterator();
                while (iterator.hasNext()) {
                    iterator.next().d.e(d, d2, set, n, true);
                }
            }
            final HashSet<ConstraintAnchor> c2 = this.Q.c();
            if (c2 != null) {
                final Iterator<ConstraintAnchor> iterator2 = c2.iterator();
                while (iterator2.hasNext()) {
                    iterator2.next().d.e(d, d2, set, n, true);
                }
            }
        }
        else {
            final HashSet<ConstraintAnchor> c3 = this.P.c();
            if (c3 != null) {
                final Iterator<ConstraintAnchor> iterator3 = c3.iterator();
                while (iterator3.hasNext()) {
                    iterator3.next().d.e(d, d2, set, n, true);
                }
            }
            final HashSet<ConstraintAnchor> c4 = this.R.c();
            if (c4 != null) {
                final Iterator<ConstraintAnchor> iterator4 = c4.iterator();
                while (iterator4.hasNext()) {
                    iterator4.next().d.e(d, d2, set, n, true);
                }
            }
            final HashSet<ConstraintAnchor> c5 = this.S.c();
            if (c5 != null) {
                final Iterator<ConstraintAnchor> iterator5 = c5.iterator();
                while (iterator5.hasNext()) {
                    iterator5.next().d.e(d, d2, set, n, true);
                }
            }
        }
    }
    
    public boolean e0() {
        return this.r;
    }
    
    public void e1(final int x, int n, final int n2, final float e) {
        this.x = x;
        this.C = n;
        n = n2;
        if (n2 == Integer.MAX_VALUE) {
            n = 0;
        }
        this.D = n;
        this.E = e;
        if (e > 0.0f && e < 1.0f && x == 0) {
            this.x = 2;
        }
    }
    
    boolean f() {
        return this instanceof g || this instanceof e;
    }
    
    public boolean f0(final int n) {
        return this.Y[n];
    }
    
    public void f1(final float n) {
        this.D0[1] = n;
    }
    
    public void g(final d d, final boolean b) {
        final SolverVariable q = d.q(this.O);
        final SolverVariable q2 = d.q(this.Q);
        final SolverVariable q3 = d.q(this.P);
        final SolverVariable q4 = d.q(this.R);
        final SolverVariable q5 = d.q(this.S);
        final ConstraintWidget a0 = this.a0;
        boolean b2 = false;
        boolean b3 = false;
        Label_0160: {
            if (a0 != null) {
                b2 = (a0 != null && a0.Z[0] == DimensionBehaviour.WRAP_CONTENT);
                b3 = (a0 != null && a0.Z[1] == DimensionBehaviour.WRAP_CONTENT);
                final int v = this.v;
                if (v == 1) {
                    b3 = false;
                    break Label_0160;
                }
                if (v == 2) {
                    b2 = false;
                    break Label_0160;
                }
                if (v != 3) {
                    break Label_0160;
                }
            }
            b2 = false;
            b3 = false;
        }
        if (this.s0 == 8 && !this.t0 && !this.Z()) {
            final boolean[] y = this.Y;
            if (!y[0] && !y[1]) {
                return;
            }
        }
        final boolean p2 = this.p;
        if (p2 || this.q) {
            if (p2) {
                d.f(q, this.f0);
                d.f(q2, this.f0 + this.b0);
                if (b2) {
                    final ConstraintWidget a2 = this.a0;
                    if (a2 != null) {
                        if (this.k) {
                            final androidx.constraintlayout.core.widgets.d d2 = (androidx.constraintlayout.core.widgets.d)a2;
                            d2.w1(this.O);
                            d2.v1(this.Q);
                        }
                        else {
                            d.h(d.q(a2.Q), q2, 0, 5);
                        }
                    }
                }
            }
            if (this.q) {
                d.f(q3, this.g0);
                d.f(q4, this.g0 + this.c0);
                if (this.S.l()) {
                    d.f(q5, this.g0 + this.l0);
                }
                if (b3) {
                    final ConstraintWidget a3 = this.a0;
                    if (a3 != null) {
                        if (this.k) {
                            final androidx.constraintlayout.core.widgets.d d3 = (androidx.constraintlayout.core.widgets.d)a3;
                            d3.B1(this.P);
                            d3.A1(this.R);
                        }
                        else {
                            d.h(d.q(a3.R), q4, 0, 5);
                        }
                    }
                }
            }
            if (this.p && this.q) {
                this.p = false;
                this.q = false;
                return;
            }
        }
        final boolean r = d.r;
        if (b) {
            final j e = this.e;
            if (e != null) {
                final l f = this.f;
                if (f != null) {
                    final DependencyNode h = e.h;
                    if (h.j && e.i.j && f.h.j && f.i.j) {
                        d.f(q, h.g);
                        d.f(q2, this.e.i.g);
                        d.f(q3, this.f.h.g);
                        d.f(q4, this.f.i.g);
                        d.f(q5, this.f.k.g);
                        if (this.a0 != null) {
                            if (b2 && this.g[0] && !this.g0()) {
                                d.h(d.q(this.a0.Q), q2, 0, 8);
                            }
                            if (b3 && this.g[1] && !this.i0()) {
                                d.h(d.q(this.a0.R), q4, 0, 8);
                            }
                        }
                        this.p = false;
                        this.q = false;
                        return;
                    }
                }
            }
        }
        int n;
        int n2;
        if (this.a0 != null) {
            int g0;
            if (this.d0(0)) {
                ((androidx.constraintlayout.core.widgets.d)this.a0).s1(this, 0);
                g0 = 1;
            }
            else {
                g0 = (this.g0() ? 1 : 0);
            }
            int i0;
            if (this.d0(1)) {
                ((androidx.constraintlayout.core.widgets.d)this.a0).s1(this, 1);
                i0 = 1;
            }
            else {
                i0 = (this.i0() ? 1 : 0);
            }
            if (g0 == 0 && b2 && this.s0 != 8 && this.O.f == null && this.Q.f == null) {
                d.h(d.q(this.a0.Q), q2, 0, 1);
            }
            if (i0 == 0 && b3 && this.s0 != 8 && this.P.f == null && this.R.f == null && this.S == null) {
                d.h(d.q(this.a0.R), q4, 0, 1);
            }
            n = i0;
            n2 = g0;
        }
        else {
            n = 0;
            n2 = 0;
        }
        final int b4 = this.b0;
        int m0 = this.m0;
        if (b4 >= m0) {
            m0 = b4;
        }
        final int c0 = this.c0;
        int n3 = this.n0;
        if (c0 >= n3) {
            n3 = c0;
        }
        final DimensionBehaviour[] z = this.Z;
        final DimensionBehaviour dimensionBehaviour = z[0];
        final DimensionBehaviour match_CONSTRAINT = DimensionBehaviour.MATCH_CONSTRAINT;
        final boolean b5 = dimensionBehaviour != match_CONSTRAINT;
        final boolean b6 = z[1] != match_CONSTRAINT;
        final int e2 = this.e0;
        this.F = e2;
        final float d4 = this.d0;
        this.G = d4;
        int w = this.w;
        final int x = this.x;
        boolean h2 = false;
        int n8 = 0;
        int n9 = 0;
        int n10 = 0;
        Label_1388: {
            if (d4 > 0.0f && this.s0 != 8) {
                int n4 = w;
                if (z[0] == match_CONSTRAINT && (n4 = w) == 0) {
                    n4 = 3;
                }
                int n5 = x;
                if (z[1] == match_CONSTRAINT && (n5 = x) == 0) {
                    n5 = 3;
                }
                int n11 = 0;
                Label_1343: {
                    if (z[0] == match_CONSTRAINT && z[1] == match_CONSTRAINT && n4 == 3 && n5 == 3) {
                        this.l1(b2, b3, b5, b6);
                    }
                    else {
                        if (z[0] == match_CONSTRAINT && n4 == 3) {
                            this.F = 0;
                            final int n6 = (int)(d4 * c0);
                            int n7;
                            if (z[1] != match_CONSTRAINT) {
                                n7 = 4;
                                h2 = false;
                            }
                            else {
                                h2 = true;
                                n7 = n4;
                            }
                            n8 = n5;
                            n9 = n3;
                            n10 = n6;
                            w = n7;
                            break Label_1388;
                        }
                        if (z[1] == match_CONSTRAINT && n5 == 3) {
                            this.F = 1;
                            if (e2 == -1) {
                                this.G = 1.0f / d4;
                            }
                            n11 = (int)(this.G * b4);
                            final DimensionBehaviour dimensionBehaviour2 = z[0];
                            final int n12 = n4;
                            if (dimensionBehaviour2 != match_CONSTRAINT) {
                                h2 = false;
                                n8 = 4;
                                n10 = m0;
                                n9 = n11;
                                w = n12;
                                break Label_1388;
                            }
                            break Label_1343;
                        }
                    }
                    n11 = n3;
                }
                final int n13 = n4;
                n8 = n5;
                h2 = true;
                n10 = m0;
                n9 = n11;
                w = n13;
            }
            else {
                n8 = x;
                h2 = false;
                final int n14 = m0;
                n9 = n3;
                n10 = n14;
            }
        }
        final int[] y2 = this.y;
        y2[0] = w;
        y2[1] = n8;
        this.h = h2;
        boolean b7 = false;
        Label_1443: {
            if (h2) {
                final int f2 = this.F;
                if (f2 == 0 || f2 == -1) {
                    b7 = true;
                    break Label_1443;
                }
            }
            b7 = false;
        }
        boolean b8 = false;
        Label_1475: {
            if (h2) {
                final int f3 = this.F;
                if (f3 == 1 || f3 == -1) {
                    b8 = true;
                    break Label_1475;
                }
            }
            b8 = false;
        }
        final DimensionBehaviour dimensionBehaviour3 = this.Z[0];
        final DimensionBehaviour wrap_CONTENT = DimensionBehaviour.WRAP_CONTENT;
        final boolean b9 = dimensionBehaviour3 == wrap_CONTENT && this instanceof androidx.constraintlayout.core.widgets.d;
        if (b9) {
            n10 = 0;
        }
        final boolean b10 = this.V.n() ^ true;
        final boolean[] y3 = this.Y;
        final boolean b11 = y3[0];
        final boolean b12 = y3[1];
        Label_1890: {
            if (this.t != 2 && !this.p) {
                if (b) {
                    final j e3 = this.e;
                    if (e3 != null) {
                        final DependencyNode h3 = e3.h;
                        if (h3.j) {
                            if (e3.i.j) {
                                if (b) {
                                    d.f(q, h3.g);
                                    d.f(q2, this.e.i.g);
                                    if (this.a0 != null && b2 && this.g[0] && !this.g0()) {
                                        d.h(d.q(this.a0.Q), q2, 0, 8);
                                    }
                                }
                                break Label_1890;
                            }
                        }
                    }
                }
                final ConstraintWidget a4 = this.a0;
                SolverVariable q6;
                if (a4 != null) {
                    q6 = d.q(a4.Q);
                }
                else {
                    q6 = null;
                }
                final ConstraintWidget a5 = this.a0;
                SolverVariable q7;
                if (a5 != null) {
                    q7 = d.q(a5.O);
                }
                else {
                    q7 = null;
                }
                final boolean b13 = this.g[0];
                final DimensionBehaviour[] z2 = this.Z;
                this.i(d, true, b2, b3, b13, q7, q6, z2[0], b9, this.O, this.Q, this.f0, n10, this.m0, this.H[0], this.o0, b7, z2[1] == match_CONSTRAINT, (boolean)(n2 != 0), (boolean)(n != 0), b11, w, n8, this.z, this.A, this.B, b10);
            }
        }
        boolean b14 = false;
        Label_2048: {
            if (b) {
                final l f4 = this.f;
                if (f4 != null) {
                    final DependencyNode h4 = f4.h;
                    if (h4.j && f4.i.j) {
                        d.f(q3, h4.g);
                        d.f(q4, this.f.i.g);
                        d.f(q5, this.f.k.g);
                        final ConstraintWidget a6 = this.a0;
                        if (a6 != null && n == 0 && b3) {
                            if (this.g[1]) {
                                d.h(d.q(a6.R), q4, 0, 8);
                            }
                        }
                        b14 = false;
                        break Label_2048;
                    }
                }
            }
            b14 = true;
        }
        if (this.u == 2) {
            b14 = false;
        }
        if (b14 && !this.q) {
            final boolean b15 = this.Z[1] == wrap_CONTENT && this instanceof androidx.constraintlayout.core.widgets.d;
            if (b15) {
                n9 = 0;
            }
            final ConstraintWidget a7 = this.a0;
            SolverVariable q8;
            if (a7 != null) {
                q8 = d.q(a7.R);
            }
            else {
                q8 = null;
            }
            final ConstraintWidget a8 = this.a0;
            SolverVariable q9;
            if (a8 != null) {
                q9 = d.q(a8.P);
            }
            else {
                q9 = null;
            }
            boolean b16 = false;
            Label_2308: {
                if (this.l0 > 0 || this.s0 == 8) {
                    final ConstraintAnchor s = this.S;
                    if (s.f != null) {
                        d.e(q5, q3, this.n(), 8);
                        d.e(q5, d.q(this.S.f), this.S.e(), 8);
                        if (b3) {
                            d.h(q8, d.q(this.R), 0, 5);
                        }
                        b16 = false;
                        break Label_2308;
                    }
                    if (this.s0 == 8) {
                        d.e(q5, q3, s.e(), 8);
                    }
                    else {
                        d.e(q5, q3, this.n(), 8);
                    }
                }
                b16 = b10;
            }
            final boolean b17 = this.g[1];
            final DimensionBehaviour[] z3 = this.Z;
            this.i(d, false, b3, b2, b17, q9, q8, z3[1], b15, this.P, this.R, this.g0, n9, this.n0, this.H[1], this.p0, b8, z3[0] == match_CONSTRAINT, (boolean)(n != 0), (boolean)(n2 != 0), b12, n8, w, this.C, this.D, this.E, b16);
        }
        if (h2) {
            if (this.F == 1) {
                d.k(q4, q3, q2, q, this.G, 8);
            }
            else {
                d.k(q2, q, q4, q3, this.G, 8);
            }
        }
        if (this.V.n()) {
            d.b(this, this.V.i().g(), (float)Math.toRadians(this.I + 90.0f), this.V.e());
        }
        this.p = false;
        this.q = false;
    }
    
    public boolean g0() {
        final ConstraintAnchor o = this.O;
        final ConstraintAnchor f = o.f;
        if (f == null || f.f != o) {
            final ConstraintAnchor q = this.Q;
            final ConstraintAnchor f2 = q.f;
            if (f2 == null || f2.f != q) {
                return false;
            }
        }
        return true;
    }
    
    public void g1(final int s0) {
        this.s0 = s0;
    }
    
    public boolean h() {
        return this.s0 != 8;
    }
    
    public boolean h0() {
        return this.K;
    }
    
    public void h1(final int b0) {
        this.b0 = b0;
        final int m0 = this.m0;
        if (b0 < m0) {
            this.b0 = m0;
        }
    }
    
    public boolean i0() {
        final ConstraintAnchor p = this.P;
        final ConstraintAnchor f = p.f;
        if (f == null || f.f != p) {
            final ConstraintAnchor r = this.R;
            final ConstraintAnchor f2 = r.f;
            if (f2 == null || f2.f != r) {
                return false;
            }
        }
        return true;
    }
    
    public void i1(final int v) {
        if (v >= 0 && v <= 3) {
            this.v = v;
        }
    }
    
    public void j(final ConstraintWidget constraintWidget, final float i, final int n) {
        final ConstraintAnchor.Type center = ConstraintAnchor.Type.CENTER;
        this.c0(center, constraintWidget, center, n, 0);
        this.I = i;
    }
    
    public boolean j0() {
        return this.L;
    }
    
    public void j1(final int f0) {
        this.f0 = f0;
    }
    
    public void k(final d d) {
        d.q(this.O);
        d.q(this.P);
        d.q(this.Q);
        d.q(this.R);
        if (this.l0 > 0) {
            d.q(this.S);
        }
    }
    
    public boolean k0() {
        return this.i && this.s0 != 8;
    }
    
    public void k1(final int g0) {
        this.g0 = g0;
    }
    
    public void l() {
        if (this.e == null) {
            this.e = new j(this);
        }
        if (this.f == null) {
            this.f = new l(this);
        }
    }
    
    public boolean l0() {
        return this.p || (this.O.m() && this.Q.m());
    }
    
    public void l1(final boolean b, final boolean b2, final boolean b3, final boolean b4) {
        if (this.F == -1) {
            if (b3 && !b4) {
                this.F = 0;
            }
            else if (!b3 && b4) {
                this.F = 1;
                if (this.e0 == -1) {
                    this.G = 1.0f / this.G;
                }
            }
        }
        if (this.F == 0 && (!this.P.n() || !this.R.n())) {
            this.F = 1;
        }
        else if (this.F == 1 && (!this.O.n() || !this.Q.n())) {
            this.F = 0;
        }
        if (this.F == -1 && (!this.P.n() || !this.R.n() || !this.O.n() || !this.Q.n())) {
            if (this.P.n() && this.R.n()) {
                this.F = 0;
            }
            else if (this.O.n() && this.Q.n()) {
                this.G = 1.0f / this.G;
                this.F = 1;
            }
        }
        if (this.F == -1) {
            final int z = this.z;
            if (z > 0 && this.C == 0) {
                this.F = 0;
            }
            else if (z == 0 && this.C > 0) {
                this.G = 1.0f / this.G;
                this.F = 1;
            }
        }
    }
    
    public ConstraintAnchor m(final ConstraintAnchor.Type type) {
        switch (ConstraintWidget$a.a[type.ordinal()]) {
            default: {
                throw new AssertionError((Object)type.name());
            }
            case 9: {
                return null;
            }
            case 8: {
                return this.U;
            }
            case 7: {
                return this.T;
            }
            case 6: {
                return this.V;
            }
            case 5: {
                return this.S;
            }
            case 4: {
                return this.R;
            }
            case 3: {
                return this.Q;
            }
            case 2: {
                return this.P;
            }
            case 1: {
                return this.O;
            }
        }
    }
    
    public boolean m0() {
        return this.q || (this.P.m() && this.R.m());
    }
    
    public void m1(final boolean b, final boolean b2) {
        final boolean b3 = b & this.e.k();
        final boolean b4 = b2 & this.f.k();
        final j e = this.e;
        int g = e.h.g;
        final l f = this.f;
        int g2 = f.h.g;
        int g3 = e.i.g;
        final int g4 = f.i.g;
        int n;
        if (g3 - g < 0 || g4 - g2 < 0 || g == Integer.MIN_VALUE || g == Integer.MAX_VALUE || g2 == Integer.MIN_VALUE || g2 == Integer.MAX_VALUE || g3 == Integer.MIN_VALUE || g3 == Integer.MAX_VALUE || g4 == Integer.MIN_VALUE || (n = g4) == Integer.MAX_VALUE) {
            g3 = 0;
            g = 0;
            n = (g2 = g);
        }
        final int n2 = g3 - g;
        final int n3 = n - g2;
        if (b3) {
            this.f0 = g;
        }
        if (b4) {
            this.g0 = g2;
        }
        if (this.s0 == 8) {
            this.b0 = 0;
            this.c0 = 0;
            return;
        }
        if (b3) {
            int b5 = n2;
            if (this.Z[0] == DimensionBehaviour.FIXED) {
                final int b6 = this.b0;
                if ((b5 = n2) < b6) {
                    b5 = b6;
                }
            }
            this.b0 = b5;
            final int m0 = this.m0;
            if (b5 < m0) {
                this.b0 = m0;
            }
        }
        if (b4) {
            int c0 = n3;
            if (this.Z[1] == DimensionBehaviour.FIXED) {
                final int c2 = this.c0;
                if ((c0 = n3) < c2) {
                    c0 = c2;
                }
            }
            this.c0 = c0;
            final int n4 = this.n0;
            if (c0 < n4) {
                this.c0 = n4;
            }
        }
    }
    
    public int n() {
        return this.l0;
    }
    
    public boolean n0() {
        return this.s;
    }
    
    public void n1(final d d, final boolean b) {
        final int y = d.y(this.O);
        final int y2 = d.y(this.P);
        final int y3 = d.y(this.Q);
        final int y4 = d.y(this.R);
        int g = y;
        int g2 = y3;
        if (b) {
            final j e = this.e;
            g = y;
            g2 = y3;
            if (e != null) {
                final DependencyNode h = e.h;
                g = y;
                g2 = y3;
                if (h.j) {
                    final DependencyNode i = e.i;
                    g = y;
                    g2 = y3;
                    if (i.j) {
                        g = h.g;
                        g2 = i.g;
                    }
                }
            }
        }
        int g3 = y2;
        int g4 = y4;
        if (b) {
            final l f = this.f;
            g3 = y2;
            g4 = y4;
            if (f != null) {
                final DependencyNode h2 = f.h;
                g3 = y2;
                g4 = y4;
                if (h2.j) {
                    final DependencyNode j = f.i;
                    g3 = y2;
                    g4 = y4;
                    if (j.j) {
                        g3 = h2.g;
                        g4 = j.g;
                    }
                }
            }
        }
        int n = 0;
        int n2 = 0;
        int n3 = 0;
        int n4 = 0;
        Label_0318: {
            if (g2 - g >= 0 && g4 - g3 >= 0 && g != Integer.MIN_VALUE && g != Integer.MAX_VALUE && g3 != Integer.MIN_VALUE && g3 != Integer.MAX_VALUE && g2 != Integer.MIN_VALUE && g2 != Integer.MAX_VALUE && g4 != Integer.MIN_VALUE) {
                n = g;
                n2 = g3;
                n3 = g2;
                if ((n4 = g4) != Integer.MAX_VALUE) {
                    break Label_0318;
                }
            }
            n4 = 0;
            final int n5 = 0;
            n3 = (n2 = n5);
            n = n5;
        }
        this.G0(n, n2, n3, n4);
    }
    
    public float o(final int n) {
        if (n == 0) {
            return this.o0;
        }
        if (n == 1) {
            return this.p0;
        }
        return -1.0f;
    }
    
    public void o0() {
        this.r = true;
    }
    
    public int p() {
        return this.W() + this.c0;
    }
    
    public void p0() {
        this.s = true;
    }
    
    public Object q() {
        return this.q0;
    }
    
    public boolean q0() {
        final DimensionBehaviour[] z = this.Z;
        final boolean b = false;
        final DimensionBehaviour dimensionBehaviour = z[0];
        final DimensionBehaviour match_CONSTRAINT = DimensionBehaviour.MATCH_CONSTRAINT;
        boolean b2 = b;
        if (dimensionBehaviour == match_CONSTRAINT) {
            b2 = b;
            if (z[1] == match_CONSTRAINT) {
                b2 = true;
            }
        }
        return b2;
    }
    
    public String r() {
        return this.u0;
    }
    
    public void r0() {
        this.O.p();
        this.P.p();
        this.Q.p();
        this.R.p();
        this.S.p();
        this.T.p();
        this.U.p();
        this.V.p();
        this.a0 = null;
        this.I = 0.0f;
        this.b0 = 0;
        this.c0 = 0;
        this.d0 = 0.0f;
        this.e0 = -1;
        this.f0 = 0;
        this.g0 = 0;
        this.j0 = 0;
        this.k0 = 0;
        this.l0 = 0;
        this.m0 = 0;
        this.n0 = 0;
        final float k0 = ConstraintWidget.K0;
        this.o0 = k0;
        this.p0 = k0;
        final DimensionBehaviour[] z = this.Z;
        z[1] = (z[0] = DimensionBehaviour.FIXED);
        this.q0 = null;
        this.r0 = 0;
        this.s0 = 0;
        this.v0 = null;
        this.w0 = false;
        this.x0 = false;
        this.z0 = 0;
        this.A0 = 0;
        this.B0 = false;
        this.C0 = false;
        final float[] d0 = this.D0;
        d0[1] = (d0[0] = -1.0f);
        this.t = -1;
        this.u = -1;
        final int[] h = this.H;
        h[1] = (h[0] = Integer.MAX_VALUE);
        this.w = 0;
        this.x = 0;
        this.B = 1.0f;
        this.E = 1.0f;
        this.A = Integer.MAX_VALUE;
        this.D = Integer.MAX_VALUE;
        this.z = 0;
        this.C = 0;
        this.h = false;
        this.F = -1;
        this.G = 1.0f;
        this.y0 = false;
        final boolean[] g = this.g;
        g[1] = (g[0] = true);
        this.L = false;
        final boolean[] y = this.Y;
        y[1] = (y[0] = false);
        this.i = true;
        final int[] y2 = this.y;
        y2[1] = (y2[0] = 0);
        this.l = -1;
        this.m = -1;
    }
    
    public DimensionBehaviour s(final int n) {
        if (n == 0) {
            return this.y();
        }
        if (n == 1) {
            return this.R();
        }
        return null;
    }
    
    public void s0() {
        int i = 0;
        this.p = false;
        this.q = false;
        this.r = false;
        this.s = false;
        while (i < this.X.size()) {
            this.X.get(i).q();
            ++i;
        }
    }
    
    public float t() {
        return this.d0;
    }
    
    public void t0(final androidx.constraintlayout.core.c c) {
        this.O.r(c);
        this.P.r(c);
        this.Q.r(c);
        this.R.r(c);
        this.S.r(c);
        this.V.r(c);
        this.T.r(c);
        this.U.r(c);
    }
    
    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        final String v0 = this.v0;
        final String s = "";
        String string;
        if (v0 != null) {
            final StringBuilder sb2 = new StringBuilder();
            sb2.append("type: ");
            sb2.append(this.v0);
            sb2.append(" ");
            string = sb2.toString();
        }
        else {
            string = "";
        }
        sb.append(string);
        String string2 = s;
        if (this.u0 != null) {
            final StringBuilder sb3 = new StringBuilder();
            sb3.append("id: ");
            sb3.append(this.u0);
            sb3.append(" ");
            string2 = sb3.toString();
        }
        sb.append(string2);
        sb.append("(");
        sb.append(this.f0);
        sb.append(", ");
        sb.append(this.g0);
        sb.append(") - (");
        sb.append(this.b0);
        sb.append(" x ");
        sb.append(this.c0);
        sb.append(")");
        return sb.toString();
    }
    
    public int u() {
        return this.e0;
    }
    
    public int v() {
        if (this.s0 == 8) {
            return 0;
        }
        return this.c0;
    }
    
    public float w() {
        return this.o0;
    }
    
    public int x() {
        return this.z0;
    }
    
    public void x0(final int l0) {
        this.l0 = l0;
        this.J = (l0 > 0);
    }
    
    public DimensionBehaviour y() {
        return this.Z[0];
    }
    
    public void y0(final Object q0) {
        this.q0 = q0;
    }
    
    public int z() {
        final ConstraintAnchor o = this.O;
        int n = 0;
        if (o != null) {
            n = 0 + o.g;
        }
        final ConstraintAnchor q = this.Q;
        int n2 = n;
        if (q != null) {
            n2 = n + q.g;
        }
        return n2;
    }
    
    public void z0(final String u0) {
        this.u0 = u0;
    }
    
    public enum DimensionBehaviour
    {
        private static final DimensionBehaviour[] $VALUES;
        
        FIXED, 
        MATCH_CONSTRAINT, 
        MATCH_PARENT, 
        WRAP_CONTENT;
    }
}
