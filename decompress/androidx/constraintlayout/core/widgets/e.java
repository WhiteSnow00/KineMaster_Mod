// 
// Decompiled by Procyon v0.6.0
// 

package androidx.constraintlayout.core.widgets;

import androidx.constraintlayout.core.SolverVariable;
import androidx.constraintlayout.core.d;

public class e extends ConstraintWidget
{
    protected float L0;
    protected int M0;
    protected int N0;
    protected boolean O0;
    private ConstraintAnchor P0;
    private int Q0;
    private int R0;
    private boolean S0;
    
    public e() {
        this.L0 = -1.0f;
        this.M0 = -1;
        this.N0 = -1;
        this.O0 = true;
        this.P0 = super.P;
        int i = 0;
        this.Q0 = 0;
        this.R0 = 0;
        super.X.clear();
        super.X.add(this.P0);
        while (i < super.W.length) {
            super.W[i] = this.P0;
            ++i;
        }
    }
    
    @Override
    public void g(final d d, final boolean b) {
        final androidx.constraintlayout.core.widgets.d d2 = (androidx.constraintlayout.core.widgets.d)this.I();
        if (d2 == null) {
            return;
        }
        ConstraintAnchor constraintAnchor = d2.m(ConstraintAnchor.Type.LEFT);
        ConstraintAnchor constraintAnchor2 = d2.m(ConstraintAnchor.Type.RIGHT);
        final ConstraintWidget a0 = super.a0;
        final int n = 1;
        int n2;
        if (a0 != null && a0.Z[0] == DimensionBehaviour.WRAP_CONTENT) {
            n2 = 1;
        }
        else {
            n2 = 0;
        }
        if (this.Q0 == 0) {
            constraintAnchor = d2.m(ConstraintAnchor.Type.TOP);
            constraintAnchor2 = d2.m(ConstraintAnchor.Type.BOTTOM);
            final ConstraintWidget a2 = super.a0;
            if (a2 != null && a2.Z[1] == DimensionBehaviour.WRAP_CONTENT) {
                n2 = n;
            }
            else {
                n2 = 0;
            }
        }
        if (this.S0 && this.P0.m()) {
            final SolverVariable q = d.q(this.P0);
            d.f(q, this.P0.d());
            if (this.M0 != -1) {
                if (n2 != 0) {
                    d.h(d.q(constraintAnchor2), q, 0, 5);
                }
            }
            else if (this.N0 != -1 && n2 != 0) {
                final SolverVariable q2 = d.q(constraintAnchor2);
                d.h(q, d.q(constraintAnchor), 0, 5);
                d.h(q2, q, 0, 5);
            }
            this.S0 = false;
            return;
        }
        if (this.M0 != -1) {
            final SolverVariable q3 = d.q(this.P0);
            d.e(q3, d.q(constraintAnchor), this.M0, 8);
            if (n2 != 0) {
                d.h(d.q(constraintAnchor2), q3, 0, 5);
            }
        }
        else if (this.N0 != -1) {
            final SolverVariable q4 = d.q(this.P0);
            final SolverVariable q5 = d.q(constraintAnchor2);
            d.e(q4, q5, -this.N0, 8);
            if (n2 != 0) {
                d.h(q4, d.q(constraintAnchor), 0, 5);
                d.h(q5, q4, 0, 5);
            }
        }
        else if (this.L0 != -1.0f) {
            d.d(d.s(d, d.q(this.P0), d.q(constraintAnchor2), this.L0));
        }
    }
    
    @Override
    public boolean h() {
        return true;
    }
    
    @Override
    public boolean l0() {
        return this.S0;
    }
    
    @Override
    public ConstraintAnchor m(final ConstraintAnchor.Type type) {
        final int n = e$a.a[type.ordinal()];
        if (n != 1 && n != 2) {
            if (n == 3 || n == 4) {
                if (this.Q0 == 0) {
                    return this.P0;
                }
            }
        }
        else if (this.Q0 == 1) {
            return this.P0;
        }
        return null;
    }
    
    @Override
    public boolean m0() {
        return this.S0;
    }
    
    @Override
    public void n1(final d d, final boolean b) {
        if (this.I() == null) {
            return;
        }
        final int y = d.y(this.P0);
        if (this.Q0 == 1) {
            this.j1(y);
            this.k1(0);
            this.I0(this.I().v());
            this.h1(0);
        }
        else {
            this.j1(0);
            this.k1(y);
            this.h1(this.I().U());
            this.I0(0);
        }
    }
    
    public ConstraintAnchor o1() {
        return this.P0;
    }
    
    public int p1() {
        return this.Q0;
    }
    
    public int q1() {
        return this.M0;
    }
    
    public int r1() {
        return this.N0;
    }
    
    public float s1() {
        return this.L0;
    }
    
    public void t1(final int n) {
        this.P0.s(n);
        this.S0 = true;
    }
    
    public void u1(final int m0) {
        if (m0 > -1) {
            this.L0 = -1.0f;
            this.M0 = m0;
            this.N0 = -1;
        }
    }
    
    public void v1(final int n0) {
        if (n0 > -1) {
            this.L0 = -1.0f;
            this.M0 = -1;
            this.N0 = n0;
        }
    }
    
    public void w1(final float l0) {
        if (l0 > -1.0f) {
            this.L0 = l0;
            this.M0 = -1;
            this.N0 = -1;
        }
    }
    
    public void x1(int i) {
        if (this.Q0 == i) {
            return;
        }
        this.Q0 = i;
        super.X.clear();
        if (this.Q0 == 1) {
            this.P0 = super.O;
        }
        else {
            this.P0 = super.P;
        }
        super.X.add(this.P0);
        int length;
        for (length = super.W.length, i = 0; i < length; ++i) {
            super.W[i] = this.P0;
        }
    }
}
