// 
// Decompiled by Procyon v0.6.0
// 

package androidx.constraintlayout.core.widgets;

public class f
{
    static boolean[] a;
    
    static {
        f.a = new boolean[3];
    }
    
    static void a(final d d, final androidx.constraintlayout.core.d d2, final ConstraintWidget constraintWidget) {
        constraintWidget.t = -1;
        constraintWidget.u = -1;
        final ConstraintWidget.DimensionBehaviour dimensionBehaviour = d.Z[0];
        final ConstraintWidget.DimensionBehaviour wrap_CONTENT = ConstraintWidget.DimensionBehaviour.WRAP_CONTENT;
        if (dimensionBehaviour != wrap_CONTENT && constraintWidget.Z[0] == ConstraintWidget.DimensionBehaviour.MATCH_PARENT) {
            final int g = constraintWidget.O.g;
            final int n = d.U() - constraintWidget.Q.g;
            final ConstraintAnchor o = constraintWidget.O;
            o.i = d2.q(o);
            final ConstraintAnchor q = constraintWidget.Q;
            q.i = d2.q(q);
            d2.f(constraintWidget.O.i, g);
            d2.f(constraintWidget.Q.i, n);
            constraintWidget.t = 2;
            constraintWidget.L0(g, n);
        }
        if (d.Z[1] != wrap_CONTENT && constraintWidget.Z[1] == ConstraintWidget.DimensionBehaviour.MATCH_PARENT) {
            final int g2 = constraintWidget.P.g;
            final int n2 = d.v() - constraintWidget.R.g;
            final ConstraintAnchor p3 = constraintWidget.P;
            p3.i = d2.q(p3);
            final ConstraintAnchor r = constraintWidget.R;
            r.i = d2.q(r);
            d2.f(constraintWidget.P.i, g2);
            d2.f(constraintWidget.R.i, n2);
            if (constraintWidget.l0 > 0 || constraintWidget.T() == 8) {
                final ConstraintAnchor s = constraintWidget.S;
                s.i = d2.q(s);
                d2.f(constraintWidget.S.i, constraintWidget.l0 + g2);
            }
            constraintWidget.u = 2;
            constraintWidget.c1(g2, n2);
        }
    }
    
    public static final boolean b(final int n, final int n2) {
        return (n & n2) == n2;
    }
}
