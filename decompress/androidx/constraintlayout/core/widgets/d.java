// 
// Decompiled by Procyon v0.6.0
// 

package androidx.constraintlayout.core.widgets;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Iterator;
import androidx.constraintlayout.core.SolverVariable;
import java.util.Arrays;
import java.util.HashSet;
import java.lang.ref.WeakReference;
import androidx.constraintlayout.core.widgets.analyzer.b;
import r.c;

public class d extends c
{
    b M0;
    public androidx.constraintlayout.core.widgets.analyzer.d N0;
    private int O0;
    protected b.b P0;
    private boolean Q0;
    protected androidx.constraintlayout.core.d R0;
    int S0;
    int T0;
    int U0;
    int V0;
    public int W0;
    public int X0;
    androidx.constraintlayout.core.widgets.c[] Y0;
    androidx.constraintlayout.core.widgets.c[] Z0;
    public boolean a1;
    public boolean b1;
    public boolean c1;
    public int d1;
    public int e1;
    private int f1;
    public boolean g1;
    private boolean h1;
    private boolean i1;
    int j1;
    private WeakReference<ConstraintAnchor> k1;
    private WeakReference<ConstraintAnchor> l1;
    private WeakReference<ConstraintAnchor> m1;
    private WeakReference<ConstraintAnchor> n1;
    HashSet<ConstraintWidget> o1;
    public b.a p1;
    
    public d() {
        this.M0 = new b(this);
        this.N0 = new androidx.constraintlayout.core.widgets.analyzer.d(this);
        this.P0 = null;
        this.Q0 = false;
        this.R0 = new androidx.constraintlayout.core.d();
        this.W0 = 0;
        this.X0 = 0;
        this.Y0 = new androidx.constraintlayout.core.widgets.c[4];
        this.Z0 = new androidx.constraintlayout.core.widgets.c[4];
        this.a1 = false;
        this.b1 = false;
        this.c1 = false;
        this.d1 = 0;
        this.e1 = 0;
        this.f1 = 257;
        this.g1 = false;
        this.h1 = false;
        this.i1 = false;
        this.j1 = 0;
        this.k1 = null;
        this.l1 = null;
        this.m1 = null;
        this.n1 = null;
        this.o1 = new HashSet<ConstraintWidget>();
        this.p1 = new b.a();
    }
    
    public static boolean P1(int n, final ConstraintWidget constraintWidget, final b.b b, final b.a a, int j) {
        if (b == null) {
            return false;
        }
        if (constraintWidget.T() != 8 && !(constraintWidget instanceof e) && !(constraintWidget instanceof a)) {
            a.a = constraintWidget.y();
            a.b = constraintWidget.R();
            a.c = constraintWidget.U();
            a.d = constraintWidget.v();
            a.i = false;
            a.j = j;
            final DimensionBehaviour a2 = a.a;
            final DimensionBehaviour match_CONSTRAINT = DimensionBehaviour.MATCH_CONSTRAINT;
            if (a2 == match_CONSTRAINT) {
                n = 1;
            }
            else {
                n = 0;
            }
            if (a.b == match_CONSTRAINT) {
                j = 1;
            }
            else {
                j = 0;
            }
            final boolean b2 = n != 0 && constraintWidget.d0 > 0.0f;
            final boolean b3 = j != 0 && constraintWidget.d0 > 0.0f;
            int n2 = n;
            if (n != 0) {
                n2 = n;
                if (constraintWidget.Y(0)) {
                    n2 = n;
                    if (constraintWidget.w == 0) {
                        n2 = n;
                        if (!b2) {
                            a.a = DimensionBehaviour.WRAP_CONTENT;
                            if (j != 0 && constraintWidget.x == 0) {
                                a.a = DimensionBehaviour.FIXED;
                            }
                            n2 = 0;
                        }
                    }
                }
            }
            if ((n = j) != 0) {
                n = j;
                if (constraintWidget.Y(1)) {
                    n = j;
                    if (constraintWidget.x == 0) {
                        n = j;
                        if (!b3) {
                            a.b = DimensionBehaviour.WRAP_CONTENT;
                            if (n2 != 0 && constraintWidget.w == 0) {
                                a.b = DimensionBehaviour.FIXED;
                            }
                            n = 0;
                        }
                    }
                }
            }
            if (constraintWidget.l0()) {
                a.a = DimensionBehaviour.FIXED;
                n2 = 0;
            }
            if (constraintWidget.m0()) {
                a.b = DimensionBehaviour.FIXED;
                n = 0;
            }
            if (b2) {
                if (constraintWidget.y[0] == 4) {
                    a.a = DimensionBehaviour.FIXED;
                }
                else if (n == 0) {
                    final DimensionBehaviour b4 = a.b;
                    final DimensionBehaviour fixed = DimensionBehaviour.FIXED;
                    if (b4 == fixed) {
                        n = a.d;
                    }
                    else {
                        a.a = DimensionBehaviour.WRAP_CONTENT;
                        b.b(constraintWidget, a);
                        n = a.f;
                    }
                    a.a = fixed;
                    a.c = (int)(constraintWidget.t() * n);
                }
            }
            if (b3) {
                if (constraintWidget.y[1] == 4) {
                    a.b = DimensionBehaviour.FIXED;
                }
                else if (n2 == 0) {
                    final DimensionBehaviour a3 = a.a;
                    final DimensionBehaviour fixed2 = DimensionBehaviour.FIXED;
                    if (a3 == fixed2) {
                        n = a.c;
                    }
                    else {
                        a.b = DimensionBehaviour.WRAP_CONTENT;
                        b.b(constraintWidget, a);
                        n = a.e;
                    }
                    a.b = fixed2;
                    if (constraintWidget.u() == -1) {
                        a.d = (int)(n / constraintWidget.t());
                    }
                    else {
                        a.d = (int)(constraintWidget.t() * n);
                    }
                }
            }
            b.b(constraintWidget, a);
            constraintWidget.h1(a.e);
            constraintWidget.I0(a.f);
            constraintWidget.H0(a.h);
            constraintWidget.x0(a.g);
            a.j = b.a.k;
            return a.i;
        }
        a.e = 0;
        a.f = 0;
        return false;
    }
    
    private void R1() {
        this.W0 = 0;
        this.X0 = 0;
    }
    
    private void u1(final ConstraintWidget constraintWidget) {
        final int w0 = this.W0;
        final androidx.constraintlayout.core.widgets.c[] z0 = this.Z0;
        if (w0 + 1 >= z0.length) {
            this.Z0 = Arrays.copyOf(z0, z0.length * 2);
        }
        this.Z0[this.W0] = new androidx.constraintlayout.core.widgets.c(constraintWidget, 0, this.M1());
        ++this.W0;
    }
    
    private void x1(final ConstraintAnchor constraintAnchor, final SolverVariable solverVariable) {
        this.R0.h(solverVariable, this.R0.q(constraintAnchor), 0, 5);
    }
    
    private void y1(final ConstraintAnchor constraintAnchor, final SolverVariable solverVariable) {
        this.R0.h(this.R0.q(constraintAnchor), solverVariable, 0, 5);
    }
    
    private void z1(final ConstraintWidget constraintWidget) {
        final int x0 = this.X0;
        final androidx.constraintlayout.core.widgets.c[] y0 = this.Y0;
        if (x0 + 1 >= y0.length) {
            this.Y0 = Arrays.copyOf(y0, y0.length * 2);
        }
        this.Y0[this.X0] = new androidx.constraintlayout.core.widgets.c(constraintWidget, 1, this.M1());
        ++this.X0;
    }
    
    void A1(final ConstraintAnchor constraintAnchor) {
        final WeakReference<ConstraintAnchor> m1 = this.m1;
        if (m1 == null || m1.get() == null || constraintAnchor.d() > this.m1.get().d()) {
            this.m1 = new WeakReference<ConstraintAnchor>(constraintAnchor);
        }
    }
    
    void B1(final ConstraintAnchor constraintAnchor) {
        final WeakReference<ConstraintAnchor> k1 = this.k1;
        if (k1 == null || k1.get() == null || constraintAnchor.d() > this.k1.get().d()) {
            this.k1 = new WeakReference<ConstraintAnchor>(constraintAnchor);
        }
    }
    
    public boolean C1(final boolean b) {
        return this.N0.f(b);
    }
    
    public boolean D1(final boolean b) {
        return this.N0.g(b);
    }
    
    public boolean E1(final boolean b, final int n) {
        return this.N0.h(b, n);
    }
    
    public void F1(final n.a a) {
        this.R0.v(a);
    }
    
    public b.b G1() {
        return this.P0;
    }
    
    public int H1() {
        return this.f1;
    }
    
    public androidx.constraintlayout.core.d I1() {
        return this.R0;
    }
    
    public void J1() {
        this.N0.j();
    }
    
    public void K1() {
        this.N0.k();
    }
    
    public boolean L1() {
        return this.i1;
    }
    
    @Override
    public void M(final StringBuilder sb) {
        final StringBuilder sb2 = new StringBuilder();
        sb2.append(super.o);
        sb2.append(":{\n");
        sb.append(sb2.toString());
        final StringBuilder sb3 = new StringBuilder();
        sb3.append("  actualWidth:");
        sb3.append(super.b0);
        sb.append(sb3.toString());
        sb.append("\n");
        final StringBuilder sb4 = new StringBuilder();
        sb4.append("  actualHeight:");
        sb4.append(super.c0);
        sb.append(sb4.toString());
        sb.append("\n");
        final Iterator<ConstraintWidget> iterator = this.o1().iterator();
        while (iterator.hasNext()) {
            iterator.next().M(sb);
            sb.append(",\n");
        }
        sb.append("}");
    }
    
    public boolean M1() {
        return this.Q0;
    }
    
    public boolean N1() {
        return this.h1;
    }
    
    public long O1(final int n, final int n2, final int n3, final int n4, final int n5, final int n6, final int n7, final int s0, final int t0) {
        this.S0 = s0;
        this.T0 = t0;
        return this.M0.d(this, n, s0, t0, n2, n3, n4, n5, n6, n7);
    }
    
    public boolean Q1(final int n) {
        return (this.f1 & n) == n;
    }
    
    public void S1(final b.b p) {
        this.P0 = p;
        this.N0.n(p);
    }
    
    public void T1(final int f1) {
        this.f1 = f1;
        androidx.constraintlayout.core.d.r = this.Q1(512);
    }
    
    public void U1(final int o0) {
        this.O0 = o0;
    }
    
    public void V1(final boolean q0) {
        this.Q0 = q0;
    }
    
    public boolean W1(final androidx.constraintlayout.core.d d, final boolean[] array) {
        int i = 0;
        array[2] = false;
        final boolean q1 = this.Q1(64);
        this.n1(d, q1);
        final int size = super.L0.size();
        boolean b = false;
        while (i < size) {
            final ConstraintWidget constraintWidget = super.L0.get(i);
            constraintWidget.n1(d, q1);
            if (constraintWidget.a0()) {
                b = true;
            }
            ++i;
        }
        return b;
    }
    
    public void X1() {
        this.M0.e(this);
    }
    
    @Override
    public void m1(final boolean b, final boolean b2) {
        super.m1(b, b2);
        for (int size = super.L0.size(), i = 0; i < size; ++i) {
            super.L0.get(i).m1(b, b2);
        }
    }
    
    @Override
    public void p1() {
        super.f0 = 0;
        super.g0 = 0;
        this.h1 = false;
        this.i1 = false;
        final int size = super.L0.size();
        final int max = Math.max(0, this.U());
        final int max2 = Math.max(0, this.v());
        final DimensionBehaviour[] z = super.Z;
        final DimensionBehaviour dimensionBehaviour = z[1];
        final DimensionBehaviour dimensionBehaviour2 = z[0];
        if (this.O0 == 0 && androidx.constraintlayout.core.widgets.f.b(this.f1, 1)) {
            androidx.constraintlayout.core.widgets.analyzer.f.h(this, this.G1());
            for (int i = 0; i < size; ++i) {
                final ConstraintWidget constraintWidget = super.L0.get(i);
                if (constraintWidget.k0() && !(constraintWidget instanceof e) && !(constraintWidget instanceof a) && !(constraintWidget instanceof g) && !constraintWidget.j0()) {
                    final DimensionBehaviour s = constraintWidget.s(0);
                    final DimensionBehaviour s2 = constraintWidget.s(1);
                    final DimensionBehaviour match_CONSTRAINT = DimensionBehaviour.MATCH_CONSTRAINT;
                    if (s != match_CONSTRAINT || constraintWidget.w == 1 || s2 != match_CONSTRAINT || constraintWidget.x == 1) {
                        P1(0, constraintWidget, this.P0, new b.a(), androidx.constraintlayout.core.widgets.analyzer.b.a.k);
                    }
                }
            }
        }
        int n = 0;
        int n2 = 0;
        int n3 = 0;
        Label_0400: {
            if (size > 2) {
                final DimensionBehaviour wrap_CONTENT = DimensionBehaviour.WRAP_CONTENT;
                if ((dimensionBehaviour2 == wrap_CONTENT || dimensionBehaviour == wrap_CONTENT) && androidx.constraintlayout.core.widgets.f.b(this.f1, 1024) && androidx.constraintlayout.core.widgets.analyzer.g.c(this, this.G1())) {
                    int u = max;
                    if (dimensionBehaviour2 == wrap_CONTENT) {
                        if (max < this.U() && max > 0) {
                            this.h1(max);
                            this.h1 = true;
                            u = max;
                        }
                        else {
                            u = this.U();
                        }
                    }
                    int v = max2;
                    if (dimensionBehaviour == wrap_CONTENT) {
                        if (max2 < this.v() && max2 > 0) {
                            this.I0(max2);
                            this.i1 = true;
                            v = max2;
                        }
                        else {
                            v = this.v();
                        }
                    }
                    n = u;
                    n2 = 1;
                    n3 = v;
                    break Label_0400;
                }
            }
            n2 = 0;
            n3 = max2;
            n = max;
        }
        final boolean b = this.Q1(64) || this.Q1(128);
        final androidx.constraintlayout.core.d r0 = this.R0;
        r0.h = false;
        r0.i = false;
        if (this.f1 != 0 && b) {
            r0.i = true;
        }
        final ArrayList<ConstraintWidget> l0 = super.L0;
        final DimensionBehaviour y = this.y();
        final DimensionBehaviour wrap_CONTENT2 = DimensionBehaviour.WRAP_CONTENT;
        final boolean b2 = y == wrap_CONTENT2 || this.R() == wrap_CONTENT2;
        this.R1();
        for (int j = 0; j < size; ++j) {
            final ConstraintWidget constraintWidget2 = super.L0.get(j);
            if (constraintWidget2 instanceof c) {
                ((c)constraintWidget2).p1();
            }
        }
        final boolean q1 = this.Q1(64);
        int n4 = 0;
        int k = 1;
        while (k != 0) {
            final int n5 = n4 + 1;
            int t1 = k;
            try {
                this.R0.E();
                t1 = k;
                this.R1();
                t1 = k;
                this.k(this.R0);
                for (int n6 = 0; n6 < size; ++n6) {
                    t1 = k;
                    super.L0.get(n6).k(this.R0);
                }
                t1 = k;
                final boolean b3 = (t1 = (this.t1(this.R0) ? 1 : 0)) != 0;
                final WeakReference<ConstraintAnchor> k2 = this.k1;
                if (k2 != null) {
                    t1 = (b3 ? 1 : 0);
                    if (k2.get() != null) {
                        t1 = (b3 ? 1 : 0);
                        this.y1(this.k1.get(), this.R0.q(super.P));
                        t1 = (b3 ? 1 : 0);
                        this.k1 = null;
                    }
                }
                t1 = (b3 ? 1 : 0);
                final WeakReference<ConstraintAnchor> m1 = this.m1;
                if (m1 != null) {
                    t1 = (b3 ? 1 : 0);
                    if (m1.get() != null) {
                        t1 = (b3 ? 1 : 0);
                        this.x1(this.m1.get(), this.R0.q(super.R));
                        t1 = (b3 ? 1 : 0);
                        this.m1 = null;
                    }
                }
                t1 = (b3 ? 1 : 0);
                final WeakReference<ConstraintAnchor> l2 = this.l1;
                if (l2 != null) {
                    t1 = (b3 ? 1 : 0);
                    if (l2.get() != null) {
                        t1 = (b3 ? 1 : 0);
                        this.y1(this.l1.get(), this.R0.q(super.O));
                        t1 = (b3 ? 1 : 0);
                        this.l1 = null;
                    }
                }
                t1 = (b3 ? 1 : 0);
                final WeakReference<ConstraintAnchor> n7 = this.n1;
                if (n7 != null) {
                    t1 = (b3 ? 1 : 0);
                    if (n7.get() != null) {
                        t1 = (b3 ? 1 : 0);
                        this.x1(this.n1.get(), this.R0.q(super.Q));
                        t1 = (b3 ? 1 : 0);
                        this.n1 = null;
                    }
                }
                if ((t1 = (b3 ? 1 : 0)) != 0) {
                    t1 = (b3 ? 1 : 0);
                    this.R0.A();
                    t1 = (b3 ? 1 : 0);
                }
            }
            catch (final Exception ex) {
                ex.printStackTrace();
                final PrintStream out = System.out;
                final StringBuilder sb = new StringBuilder();
                sb.append("EXCEPTION : ");
                sb.append(ex);
                out.println(sb.toString());
            }
            int w1;
            if (t1 != 0) {
                w1 = (this.W1(this.R0, androidx.constraintlayout.core.widgets.f.a) ? 1 : 0);
            }
            else {
                this.n1(this.R0, q1);
                for (int n8 = 0; n8 < size; ++n8) {
                    super.L0.get(n8).n1(this.R0, q1);
                }
                w1 = 0;
            }
            if (b2 && n5 < 8 && androidx.constraintlayout.core.widgets.f.a[2]) {
                int n9 = 0;
                int max3 = 0;
                int max4 = 0;
                while (n9 < size) {
                    final ConstraintWidget constraintWidget3 = super.L0.get(n9);
                    max4 = Math.max(max4, constraintWidget3.f0 + constraintWidget3.U());
                    max3 = Math.max(max3, constraintWidget3.g0 + constraintWidget3.v());
                    ++n9;
                }
                final int max5 = Math.max(super.m0, max4);
                final int max6 = Math.max(super.n0, max3);
                final DimensionBehaviour wrap_CONTENT3 = DimensionBehaviour.WRAP_CONTENT;
                int n10 = n2;
                int n11 = w1;
                if (dimensionBehaviour2 == wrap_CONTENT3) {
                    n10 = n2;
                    n11 = w1;
                    if (this.U() < max5) {
                        this.h1(max5);
                        super.Z[0] = wrap_CONTENT3;
                        n10 = 1;
                        n11 = 1;
                    }
                }
                n2 = n10;
                w1 = n11;
                if (dimensionBehaviour == wrap_CONTENT3) {
                    n2 = n10;
                    w1 = n11;
                    if (this.v() < max6) {
                        this.I0(max6);
                        super.Z[1] = wrap_CONTENT3;
                        n2 = 1;
                        w1 = 1;
                    }
                }
            }
            final int max7 = Math.max(super.m0, this.U());
            if (max7 > this.U()) {
                this.h1(max7);
                super.Z[0] = DimensionBehaviour.FIXED;
                n2 = 1;
                w1 = 1;
            }
            final int max8 = Math.max(super.n0, this.v());
            if (max8 > this.v()) {
                this.I0(max8);
                super.Z[1] = DimensionBehaviour.FIXED;
                n2 = 1;
                w1 = 1;
            }
            int n12 = n2;
            int n13 = w1;
            int n16 = 0;
            Label_1513: {
                if (n2 == 0) {
                    final DimensionBehaviour dimensionBehaviour3 = super.Z[0];
                    final DimensionBehaviour wrap_CONTENT4 = DimensionBehaviour.WRAP_CONTENT;
                    int n14 = n2;
                    int n15 = w1;
                    if (dimensionBehaviour3 == wrap_CONTENT4) {
                        n14 = n2;
                        n15 = w1;
                        if (n > 0) {
                            n14 = n2;
                            n15 = w1;
                            if (this.U() > n) {
                                this.h1 = true;
                                super.Z[0] = DimensionBehaviour.FIXED;
                                this.h1(n);
                                n14 = 1;
                                n15 = 1;
                            }
                        }
                    }
                    n12 = n14;
                    n13 = n15;
                    if (super.Z[1] == wrap_CONTENT4) {
                        n12 = n14;
                        n13 = n15;
                        if (n3 > 0) {
                            n12 = n14;
                            n13 = n15;
                            if (this.v() > n3) {
                                this.i1 = true;
                                super.Z[1] = DimensionBehaviour.FIXED;
                                this.I0(n3);
                                n16 = 1;
                                n2 = 1;
                                break Label_1513;
                            }
                        }
                    }
                }
                n2 = n12;
                n16 = n13;
            }
            if (n5 > 8) {
                k = 0;
            }
            else {
                k = n16;
            }
            n4 = n5;
        }
        super.L0 = l0;
        if (n2 != 0) {
            final DimensionBehaviour[] z2 = super.Z;
            z2[0] = dimensionBehaviour2;
            z2[1] = dimensionBehaviour;
        }
        this.t0(this.R0.w());
    }
    
    @Override
    public void r0() {
        this.R0.E();
        this.S0 = 0;
        this.U0 = 0;
        this.T0 = 0;
        this.V0 = 0;
        this.g1 = false;
        super.r0();
    }
    
    void s1(final ConstraintWidget constraintWidget, final int n) {
        if (n == 0) {
            this.u1(constraintWidget);
        }
        else if (n == 1) {
            this.z1(constraintWidget);
        }
    }
    
    public boolean t1(final androidx.constraintlayout.core.d d) {
        final boolean q1 = this.Q1(64);
        this.g(d, q1);
        final int size = super.L0.size();
        int i = 0;
        boolean b = false;
        while (i < size) {
            final ConstraintWidget constraintWidget = super.L0.get(i);
            constraintWidget.P0(0, false);
            constraintWidget.P0(1, false);
            if (constraintWidget instanceof a) {
                b = true;
            }
            ++i;
        }
        if (b) {
            for (int j = 0; j < size; ++j) {
                final ConstraintWidget constraintWidget2 = super.L0.get(j);
                if (constraintWidget2 instanceof a) {
                    ((a)constraintWidget2).v1();
                }
            }
        }
        this.o1.clear();
        for (int k = 0; k < size; ++k) {
            final ConstraintWidget constraintWidget3 = super.L0.get(k);
            if (constraintWidget3.f()) {
                if (constraintWidget3 instanceof g) {
                    this.o1.add(constraintWidget3);
                }
                else {
                    constraintWidget3.g(d, q1);
                }
            }
        }
        while (this.o1.size() > 0) {
            final int size2 = this.o1.size();
            for (final g g : this.o1) {
                if (g.r1(this.o1)) {
                    g.g(d, q1);
                    this.o1.remove(g);
                    break;
                }
            }
            if (size2 == this.o1.size()) {
                final Iterator<ConstraintWidget> iterator2 = this.o1.iterator();
                while (iterator2.hasNext()) {
                    iterator2.next().g(d, q1);
                }
                this.o1.clear();
            }
        }
        if (androidx.constraintlayout.core.d.r) {
            final HashSet<ConstraintWidget> set = new HashSet<ConstraintWidget>();
            for (int l = 0; l < size; ++l) {
                final ConstraintWidget constraintWidget4 = super.L0.get(l);
                if (!constraintWidget4.f()) {
                    set.add(constraintWidget4);
                }
            }
            int n;
            if (this.y() == DimensionBehaviour.WRAP_CONTENT) {
                n = 0;
            }
            else {
                n = 1;
            }
            this.e(this, d, set, n, false);
            for (final ConstraintWidget constraintWidget5 : set) {
                androidx.constraintlayout.core.widgets.f.a(this, d, constraintWidget5);
                constraintWidget5.g(d, q1);
            }
        }
        else {
            for (int n2 = 0; n2 < size; ++n2) {
                final ConstraintWidget constraintWidget6 = super.L0.get(n2);
                if (constraintWidget6 instanceof d) {
                    final DimensionBehaviour[] z = constraintWidget6.Z;
                    final DimensionBehaviour dimensionBehaviour = z[0];
                    final DimensionBehaviour dimensionBehaviour2 = z[1];
                    final DimensionBehaviour wrap_CONTENT = DimensionBehaviour.WRAP_CONTENT;
                    if (dimensionBehaviour == wrap_CONTENT) {
                        constraintWidget6.M0(DimensionBehaviour.FIXED);
                    }
                    if (dimensionBehaviour2 == wrap_CONTENT) {
                        constraintWidget6.d1(DimensionBehaviour.FIXED);
                    }
                    constraintWidget6.g(d, q1);
                    if (dimensionBehaviour == wrap_CONTENT) {
                        constraintWidget6.M0(dimensionBehaviour);
                    }
                    if (dimensionBehaviour2 == wrap_CONTENT) {
                        constraintWidget6.d1(dimensionBehaviour2);
                    }
                }
                else {
                    androidx.constraintlayout.core.widgets.f.a(this, d, constraintWidget6);
                    if (!constraintWidget6.f()) {
                        constraintWidget6.g(d, q1);
                    }
                }
            }
        }
        if (this.W0 > 0) {
            androidx.constraintlayout.core.widgets.b.b(this, d, null, 0);
        }
        if (this.X0 > 0) {
            androidx.constraintlayout.core.widgets.b.b(this, d, null, 1);
        }
        return true;
    }
    
    public void v1(final ConstraintAnchor constraintAnchor) {
        final WeakReference<ConstraintAnchor> n1 = this.n1;
        if (n1 == null || n1.get() == null || constraintAnchor.d() > this.n1.get().d()) {
            this.n1 = new WeakReference<ConstraintAnchor>(constraintAnchor);
        }
    }
    
    public void w1(final ConstraintAnchor constraintAnchor) {
        final WeakReference<ConstraintAnchor> l1 = this.l1;
        if (l1 == null || l1.get() == null || constraintAnchor.d() > this.l1.get().d()) {
            this.l1 = new WeakReference<ConstraintAnchor>(constraintAnchor);
        }
    }
}
