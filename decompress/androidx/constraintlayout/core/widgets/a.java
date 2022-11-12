// 
// Decompiled by Procyon v0.6.0
// 

package androidx.constraintlayout.core.widgets;

import androidx.constraintlayout.core.SolverVariable;
import androidx.constraintlayout.core.d;
import r.b;

public class a extends b
{
    private int N0;
    private boolean O0;
    private int P0;
    boolean Q0;
    
    public a() {
        this.N0 = 0;
        this.O0 = true;
        this.P0 = 0;
        this.Q0 = false;
    }
    
    @Override
    public void g(final d d, final boolean b) {
        final ConstraintAnchor[] w = super.W;
        w[0] = super.O;
        w[2] = super.P;
        w[1] = super.Q;
        w[3] = super.R;
        int n = 0;
        ConstraintAnchor[] w2;
        while (true) {
            w2 = super.W;
            if (n >= w2.length) {
                break;
            }
            w2[n].i = d.q(w2[n]);
            ++n;
        }
        final int n2 = this.N0;
        if (n2 >= 0 && n2 < 4) {
            final ConstraintAnchor constraintAnchor = w2[n2];
            if (!this.Q0) {
                this.q1();
            }
            if (this.Q0) {
                this.Q0 = false;
                final int n3 = this.N0;
                if (n3 != 0 && n3 != 1) {
                    if (n3 == 2 || n3 == 3) {
                        d.f(super.P.i, super.g0);
                        d.f(super.R.i, super.g0);
                    }
                }
                else {
                    d.f(super.O.i, super.f0);
                    d.f(super.Q.i, super.f0);
                }
                return;
            }
            while (true) {
                for (int i = 0; i < super.M0; ++i) {
                    final ConstraintWidget constraintWidget = super.L0[i];
                    if (this.O0 || constraintWidget.h()) {
                        final int n4 = this.N0;
                        if ((n4 != 0 && n4 != 1) || constraintWidget.y() != DimensionBehaviour.MATCH_CONSTRAINT || constraintWidget.O.f == null || constraintWidget.Q.f == null) {
                            final int n5 = this.N0;
                            if ((n5 != 2 && n5 != 3) || constraintWidget.R() != DimensionBehaviour.MATCH_CONSTRAINT || constraintWidget.P.f == null || constraintWidget.R.f == null) {
                                continue;
                            }
                        }
                        final boolean b2 = true;
                        final boolean b3 = super.O.k() || super.Q.k();
                        final boolean b4 = super.P.k() || super.R.k();
                        boolean b5 = false;
                        Label_0484: {
                            if (!b2) {
                                final int n6 = this.N0;
                                if ((n6 == 0 && b3) || (n6 == 2 && b4) || (n6 == 1 && b3) || (n6 == 3 && b4)) {
                                    b5 = true;
                                    break Label_0484;
                                }
                            }
                            b5 = false;
                        }
                        int n7 = 5;
                        if (!b5) {
                            n7 = 4;
                        }
                        for (int j = 0; j < super.M0; ++j) {
                            final ConstraintWidget constraintWidget2 = super.L0[j];
                            if (this.O0 || constraintWidget2.h()) {
                                final SolverVariable q = d.q(constraintWidget2.W[this.N0]);
                                final ConstraintAnchor[] w3 = constraintWidget2.W;
                                final int n8 = this.N0;
                                w3[n8].i = q;
                                int n9;
                                if (w3[n8].f != null && w3[n8].f.d == this) {
                                    n9 = w3[n8].g + 0;
                                }
                                else {
                                    n9 = 0;
                                }
                                if (n8 != 0 && n8 != 2) {
                                    d.g(constraintAnchor.i, q, this.P0 + n9, b2);
                                }
                                else {
                                    d.i(constraintAnchor.i, q, this.P0 - n9, b2);
                                }
                                d.e(constraintAnchor.i, q, this.P0 + n9, n7);
                            }
                        }
                        final int n10 = this.N0;
                        if (n10 == 0) {
                            d.e(super.Q.i, super.O.i, 0, 8);
                            d.e(super.O.i, super.a0.Q.i, 0, 4);
                            d.e(super.O.i, super.a0.O.i, 0, 0);
                            return;
                        }
                        if (n10 == 1) {
                            d.e(super.O.i, super.Q.i, 0, 8);
                            d.e(super.O.i, super.a0.O.i, 0, 4);
                            d.e(super.O.i, super.a0.Q.i, 0, 0);
                            return;
                        }
                        if (n10 == 2) {
                            d.e(super.R.i, super.P.i, 0, 8);
                            d.e(super.P.i, super.a0.R.i, 0, 4);
                            d.e(super.P.i, super.a0.P.i, 0, 0);
                            return;
                        }
                        if (n10 == 3) {
                            d.e(super.P.i, super.R.i, 0, 8);
                            d.e(super.P.i, super.a0.P.i, 0, 4);
                            d.e(super.P.i, super.a0.R.i, 0, 0);
                        }
                        return;
                    }
                }
                final boolean b2 = false;
                continue;
            }
        }
    }
    
    @Override
    public boolean h() {
        return true;
    }
    
    @Override
    public boolean l0() {
        return this.Q0;
    }
    
    @Override
    public boolean m0() {
        return this.Q0;
    }
    
    public boolean q1() {
        int i = 0;
        int n = 0;
        int n2 = 1;
        int m0;
        while (true) {
            m0 = super.M0;
            if (n >= m0) {
                break;
            }
            final ConstraintWidget constraintWidget = super.L0[n];
            int n3 = 0;
            Label_0105: {
                if (!this.O0 && !constraintWidget.h()) {
                    n3 = n2;
                }
                else {
                    final int n4 = this.N0;
                    if ((n4 != 0 && n4 != 1) || constraintWidget.l0()) {
                        final int n5 = this.N0;
                        if (n5 != 2) {
                            n3 = n2;
                            if (n5 != 3) {
                                break Label_0105;
                            }
                        }
                        n3 = n2;
                        if (constraintWidget.m0()) {
                            break Label_0105;
                        }
                    }
                    n3 = 0;
                }
            }
            ++n;
            n2 = n3;
        }
        if (n2 != 0 && m0 > 0) {
            int n6 = 0;
            int n7 = 0;
            while (i < super.M0) {
                final ConstraintWidget constraintWidget2 = super.L0[i];
                if (this.O0 || constraintWidget2.h()) {
                    int n8 = n6;
                    int n9;
                    if ((n9 = n7) == 0) {
                        final int n10 = this.N0;
                        if (n10 == 0) {
                            n6 = constraintWidget2.m(ConstraintAnchor.Type.LEFT).d();
                        }
                        else if (n10 == 1) {
                            n6 = constraintWidget2.m(ConstraintAnchor.Type.RIGHT).d();
                        }
                        else if (n10 == 2) {
                            n6 = constraintWidget2.m(ConstraintAnchor.Type.TOP).d();
                        }
                        else if (n10 == 3) {
                            n6 = constraintWidget2.m(ConstraintAnchor.Type.BOTTOM).d();
                        }
                        n9 = 1;
                        n8 = n6;
                    }
                    final int n11 = this.N0;
                    if (n11 == 0) {
                        n6 = Math.min(n8, constraintWidget2.m(ConstraintAnchor.Type.LEFT).d());
                        n7 = n9;
                    }
                    else if (n11 == 1) {
                        n6 = Math.max(n8, constraintWidget2.m(ConstraintAnchor.Type.RIGHT).d());
                        n7 = n9;
                    }
                    else if (n11 == 2) {
                        n6 = Math.min(n8, constraintWidget2.m(ConstraintAnchor.Type.TOP).d());
                        n7 = n9;
                    }
                    else {
                        n6 = n8;
                        n7 = n9;
                        if (n11 == 3) {
                            n6 = Math.max(n8, constraintWidget2.m(ConstraintAnchor.Type.BOTTOM).d());
                            n7 = n9;
                        }
                    }
                }
                ++i;
            }
            final int n12 = n6 + this.P0;
            final int n13 = this.N0;
            if (n13 != 0 && n13 != 1) {
                this.F0(n12, n12);
            }
            else {
                this.C0(n12, n12);
            }
            return this.Q0 = true;
        }
        return false;
    }
    
    public boolean r1() {
        return this.O0;
    }
    
    public int s1() {
        return this.N0;
    }
    
    public int t1() {
        return this.P0;
    }
    
    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append("[Barrier] ");
        sb.append(this.r());
        sb.append(" {");
        String s = sb.toString();
        for (int i = 0; i < super.M0; ++i) {
            final ConstraintWidget constraintWidget = super.L0[i];
            String string = s;
            if (i > 0) {
                final StringBuilder sb2 = new StringBuilder();
                sb2.append(s);
                sb2.append(", ");
                string = sb2.toString();
            }
            final StringBuilder sb3 = new StringBuilder();
            sb3.append(string);
            sb3.append(constraintWidget.r());
            s = sb3.toString();
        }
        final StringBuilder sb4 = new StringBuilder();
        sb4.append(s);
        sb4.append("}");
        return sb4.toString();
    }
    
    public int u1() {
        final int n0 = this.N0;
        if (n0 == 0 || n0 == 1) {
            return 0;
        }
        if (n0 != 2 && n0 != 3) {
            return -1;
        }
        return 1;
    }
    
    protected void v1() {
        for (int i = 0; i < super.M0; ++i) {
            final ConstraintWidget constraintWidget = super.L0[i];
            if (this.O0 || constraintWidget.h()) {
                final int n0 = this.N0;
                if (n0 != 0 && n0 != 1) {
                    if (n0 == 2 || n0 == 3) {
                        constraintWidget.P0(1, true);
                    }
                }
                else {
                    constraintWidget.P0(0, true);
                }
            }
        }
    }
    
    public void w1(final boolean o0) {
        this.O0 = o0;
    }
    
    public void x1(final int n0) {
        this.N0 = n0;
    }
    
    public void y1(final int p) {
        this.P0 = p;
    }
}
