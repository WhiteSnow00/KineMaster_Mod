// 
// Decompiled by Procyon v0.6.0
// 

package androidx.constraintlayout.core.widgets;

import java.util.ArrayList;
import androidx.constraintlayout.core.SolverVariable;

public class b
{
    static void a(final d d, final androidx.constraintlayout.core.d d2, int n, int e, final c c) {
        final ConstraintWidget a = c.a;
        final ConstraintWidget c2 = c.c;
        final ConstraintWidget b = c.b;
        final ConstraintWidget d3 = c.d;
        final ConstraintWidget e2 = c.e;
        final float k = c.k;
        final boolean b2 = d.Z[n] == ConstraintWidget.DimensionBehaviour.WRAP_CONTENT;
        int n4 = 0;
        int n5 = 0;
        boolean b3 = false;
        Label_0187: {
            Label_0184: {
                int n2;
                int n3;
                if (n == 0) {
                    final int z0 = e2.z0;
                    if (z0 == 0) {
                        n2 = 1;
                    }
                    else {
                        n2 = 0;
                    }
                    if (z0 == 1) {
                        n3 = 1;
                    }
                    else {
                        n3 = 0;
                    }
                    n4 = n2;
                    n5 = n3;
                    if (z0 != 2) {
                        break Label_0184;
                    }
                }
                else {
                    final int a2 = e2.A0;
                    if (a2 == 0) {
                        n2 = 1;
                    }
                    else {
                        n2 = 0;
                    }
                    if (a2 == 1) {
                        n3 = 1;
                    }
                    else {
                        n3 = 0;
                    }
                    n4 = n2;
                    n5 = n3;
                    if (a2 != 2) {
                        break Label_0184;
                    }
                }
                b3 = true;
                n4 = n2;
                n5 = n3;
                break Label_0187;
            }
            b3 = false;
        }
        ConstraintWidget constraintWidget = a;
        int n6 = 0;
        final int n7 = n4;
        SolverVariable solverVariable;
        while (true) {
            solverVariable = null;
            final ConstraintWidget constraintWidget2 = null;
            if (n6 != 0) {
                break;
            }
            final ConstraintAnchor constraintAnchor = constraintWidget.W[e];
            int n8;
            if (b3) {
                n8 = 1;
            }
            else {
                n8 = 4;
            }
            final int e3 = constraintAnchor.e();
            final ConstraintWidget.DimensionBehaviour dimensionBehaviour = constraintWidget.Z[n];
            final ConstraintWidget.DimensionBehaviour match_CONSTRAINT = ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT;
            final boolean b4 = dimensionBehaviour == match_CONSTRAINT && constraintWidget.y[n] == 0;
            final ConstraintAnchor f = constraintAnchor.f;
            int n9 = e3;
            if (f != null) {
                n9 = e3;
                if (constraintWidget != a) {
                    n9 = e3 + f.e();
                }
            }
            int n10;
            if (b3 && constraintWidget != a && constraintWidget != b) {
                n10 = 8;
            }
            else {
                n10 = n8;
            }
            final ConstraintAnchor f2 = constraintAnchor.f;
            if (f2 != null) {
                if (constraintWidget == b) {
                    d2.h(constraintAnchor.i, f2.i, n9, 6);
                }
                else {
                    d2.h(constraintAnchor.i, f2.i, n9, 8);
                }
                int n11 = n10;
                if (b4) {
                    n11 = n10;
                    if (!b3) {
                        n11 = 5;
                    }
                }
                if (constraintWidget == b && b3 && constraintWidget.f0(n)) {
                    n11 = 5;
                }
                d2.e(constraintAnchor.i, constraintAnchor.f.i, n9, n11);
            }
            if (b2) {
                if (constraintWidget.T() != 8 && constraintWidget.Z[n] == match_CONSTRAINT) {
                    final ConstraintAnchor[] w = constraintWidget.W;
                    d2.h(w[e + 1].i, w[e].i, 0, 5);
                }
                d2.h(constraintWidget.W[e].i, d.W[e].i, 0, 8);
            }
            final ConstraintAnchor f3 = constraintWidget.W[e + 1].f;
            ConstraintWidget constraintWidget3 = constraintWidget2;
            if (f3 != null) {
                final ConstraintWidget d4 = f3.d;
                final ConstraintAnchor[] w2 = d4.W;
                constraintWidget3 = constraintWidget2;
                if (w2[e].f != null) {
                    if (w2[e].f.d != constraintWidget) {
                        constraintWidget3 = constraintWidget2;
                    }
                    else {
                        constraintWidget3 = d4;
                    }
                }
            }
            if (constraintWidget3 != null) {
                constraintWidget = constraintWidget3;
            }
            else {
                n6 = 1;
            }
        }
        if (d3 != null) {
            final ConstraintAnchor[] w3 = c2.W;
            final int n12 = e + 1;
            if (w3[n12].f != null) {
                final ConstraintAnchor constraintAnchor2 = d3.W[n12];
                Label_0821: {
                    if (d3.Z[n] == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT && d3.y[n] == 0 && !b3) {
                        final ConstraintAnchor f4 = constraintAnchor2.f;
                        if (f4.d == d) {
                            d2.e(constraintAnchor2.i, f4.i, -constraintAnchor2.e(), 5);
                            break Label_0821;
                        }
                    }
                    if (b3) {
                        final ConstraintAnchor f5 = constraintAnchor2.f;
                        if (f5.d == d) {
                            d2.e(constraintAnchor2.i, f5.i, -constraintAnchor2.e(), 4);
                        }
                    }
                }
                d2.j(constraintAnchor2.i, c2.W[n12].f.i, -constraintAnchor2.e(), 6);
            }
        }
        if (b2) {
            final ConstraintAnchor[] w4 = d.W;
            final int n13 = e + 1;
            final SolverVariable i = w4[n13].i;
            final ConstraintAnchor[] w5 = c2.W;
            d2.h(i, w5[n13].i, w5[n13].e(), 8);
        }
        final ArrayList<ConstraintWidget> h = c.h;
        if (h != null) {
            final int size = h.size();
            if (size > 1) {
                float n14;
                if (c.r && !c.t) {
                    n14 = (float)c.j;
                }
                else {
                    n14 = k;
                }
                float n15 = 0.0f;
                ConstraintWidget constraintWidget4 = null;
                for (int j = 0; j < size; ++j) {
                    final ConstraintWidget constraintWidget5 = h.get(j);
                    float n16 = constraintWidget5.D0[n];
                    if (n16 < 0.0f) {
                        if (c.t) {
                            final ConstraintAnchor[] w6 = constraintWidget5.W;
                            d2.e(w6[e + 1].i, w6[e].i, 0, 4);
                            continue;
                        }
                        n16 = 1.0f;
                    }
                    if (n16 == 0.0f) {
                        final ConstraintAnchor[] w7 = constraintWidget5.W;
                        d2.e(w7[e + 1].i, w7[e].i, 0, 8);
                    }
                    else {
                        if (constraintWidget4 != null) {
                            final ConstraintAnchor[] w8 = constraintWidget4.W;
                            final SolverVariable l = w8[e].i;
                            final int n17 = e + 1;
                            final SolverVariable m = w8[n17].i;
                            final ConstraintAnchor[] w9 = constraintWidget5.W;
                            final SolverVariable i2 = w9[e].i;
                            final SolverVariable i3 = w9[n17].i;
                            final androidx.constraintlayout.core.b r = d2.r();
                            r.l(n15, n14, n16, l, m, i2, i3);
                            d2.d(r);
                        }
                        constraintWidget4 = constraintWidget5;
                        n15 = n16;
                    }
                }
            }
        }
        if (b != null && (b == d3 || b3)) {
            final ConstraintAnchor constraintAnchor3 = a.W[e];
            final ConstraintAnchor[] w10 = c2.W;
            final int n18 = e + 1;
            ConstraintAnchor constraintAnchor4 = w10[n18];
            final ConstraintAnchor f6 = constraintAnchor3.f;
            SolverVariable i4;
            if (f6 != null) {
                i4 = f6.i;
            }
            else {
                i4 = null;
            }
            final ConstraintAnchor f7 = constraintAnchor4.f;
            SolverVariable i5;
            if (f7 != null) {
                i5 = f7.i;
            }
            else {
                i5 = null;
            }
            final ConstraintAnchor constraintAnchor5 = b.W[e];
            if (d3 != null) {
                constraintAnchor4 = d3.W[n18];
            }
            if (i4 != null && i5 != null) {
                float n19;
                if (n == 0) {
                    n19 = e2.o0;
                }
                else {
                    n19 = e2.p0;
                }
                n = constraintAnchor5.e();
                d2.c(constraintAnchor5.i, i4, n, n19, i5, constraintAnchor4.i, constraintAnchor4.e(), 7);
            }
        }
        else if (n7 != 0 && b != null) {
            final int j2 = c.j;
            final boolean b5 = j2 > 0 && c.i == j2;
            ConstraintWidget constraintWidget7;
            ConstraintWidget constraintWidget8;
            for (ConstraintWidget constraintWidget6 = constraintWidget7 = b; constraintWidget7 != null; constraintWidget7 = constraintWidget8) {
                for (constraintWidget8 = constraintWidget7.F0[n]; constraintWidget8 != null && constraintWidget8.T() == 8; constraintWidget8 = constraintWidget8.F0[n]) {}
                if (constraintWidget8 != null || constraintWidget7 == d3) {
                    final ConstraintAnchor constraintAnchor6 = constraintWidget7.W[e];
                    final SolverVariable i6 = constraintAnchor6.i;
                    final ConstraintAnchor f8 = constraintAnchor6.f;
                    SolverVariable solverVariable2;
                    if (f8 != null) {
                        solverVariable2 = f8.i;
                    }
                    else {
                        solverVariable2 = null;
                    }
                    if (constraintWidget6 != constraintWidget7) {
                        solverVariable2 = constraintWidget6.W[e + 1].i;
                    }
                    else if (constraintWidget7 == b) {
                        final ConstraintAnchor[] w11 = a.W;
                        if (w11[e].f != null) {
                            solverVariable2 = w11[e].f.i;
                        }
                        else {
                            solverVariable2 = null;
                        }
                    }
                    final int e4 = constraintAnchor6.e();
                    final ConstraintAnchor[] w12 = constraintWidget7.W;
                    final int n20 = e + 1;
                    final int e5 = w12[n20].e();
                    ConstraintAnchor f9;
                    SolverVariable solverVariable3;
                    if (constraintWidget8 != null) {
                        f9 = constraintWidget8.W[e];
                        solverVariable3 = f9.i;
                    }
                    else {
                        f9 = c2.W[n20].f;
                        if (f9 != null) {
                            solverVariable3 = f9.i;
                        }
                        else {
                            solverVariable3 = null;
                        }
                    }
                    final SolverVariable i7 = constraintWidget7.W[n20].i;
                    int e6 = e5;
                    if (f9 != null) {
                        e6 = e5 + f9.e();
                    }
                    int e7 = e4 + constraintWidget6.W[n20].e();
                    if (i6 != null && solverVariable2 != null && solverVariable3 != null && i7 != null) {
                        if (constraintWidget7 == b) {
                            e7 = b.W[e].e();
                        }
                        if (constraintWidget7 == d3) {
                            e6 = d3.W[n20].e();
                        }
                        int n21;
                        if (b5) {
                            n21 = 8;
                        }
                        else {
                            n21 = 5;
                        }
                        d2.c(i6, solverVariable2, e7, 0.5f, solverVariable3, i7, e6, n21);
                    }
                }
                if (constraintWidget7.T() == 8) {
                    constraintWidget7 = constraintWidget6;
                }
                constraintWidget6 = constraintWidget7;
            }
        }
        else {
            int n22 = 8;
            if (n5 != 0 && b != null) {
                final int j3 = c.j;
                final boolean b6 = j3 > 0 && c.i == j3;
                ConstraintWidget constraintWidget10;
                ConstraintWidget constraintWidget11;
                for (ConstraintWidget constraintWidget9 = constraintWidget10 = b; constraintWidget10 != null; constraintWidget10 = constraintWidget11) {
                    for (constraintWidget11 = constraintWidget10.F0[n]; constraintWidget11 != null && constraintWidget11.T() == n22; constraintWidget11 = constraintWidget11.F0[n]) {}
                    if (constraintWidget10 != b && constraintWidget10 != d3 && constraintWidget11 != null) {
                        if (constraintWidget11 == d3) {
                            constraintWidget11 = null;
                        }
                        final ConstraintAnchor constraintAnchor7 = constraintWidget10.W[e];
                        final SolverVariable i8 = constraintAnchor7.i;
                        final ConstraintAnchor f10 = constraintAnchor7.f;
                        if (f10 != null) {
                            final SolverVariable i9 = f10.i;
                        }
                        final ConstraintAnchor[] w13 = constraintWidget9.W;
                        final int n23 = e + 1;
                        final SolverVariable i10 = w13[n23].i;
                        final int e8 = constraintAnchor7.e();
                        final int e9 = constraintWidget10.W[n23].e();
                        ConstraintAnchor constraintAnchor8;
                        SolverVariable i11;
                        SolverVariable i13;
                        if (constraintWidget11 != null) {
                            constraintAnchor8 = constraintWidget11.W[e];
                            i11 = constraintAnchor8.i;
                            final ConstraintAnchor f11 = constraintAnchor8.f;
                            SolverVariable i12;
                            if (f11 != null) {
                                i12 = f11.i;
                            }
                            else {
                                i12 = null;
                            }
                            i13 = i12;
                        }
                        else {
                            constraintAnchor8 = d3.W[e];
                            SolverVariable i14;
                            if (constraintAnchor8 != null) {
                                i14 = constraintAnchor8.i;
                            }
                            else {
                                i14 = null;
                            }
                            i13 = constraintWidget10.W[n23].i;
                            i11 = i14;
                        }
                        int n24 = e9;
                        if (constraintAnchor8 != null) {
                            n24 = e9 + constraintAnchor8.e();
                        }
                        final int e10 = constraintWidget9.W[n23].e();
                        int n25;
                        if (b6) {
                            n25 = 8;
                        }
                        else {
                            n25 = 4;
                        }
                        if (i8 != null && i10 != null && i11 != null && i13 != null) {
                            d2.c(i8, i10, e10 + e8, 0.5f, i11, i13, n24, n25);
                        }
                        n22 = 8;
                    }
                    if (constraintWidget10.T() != n22) {
                        constraintWidget9 = constraintWidget10;
                    }
                }
                final ConstraintAnchor constraintAnchor9 = b.W[e];
                final ConstraintAnchor f12 = a.W[e].f;
                final ConstraintAnchor[] w14 = d3.W;
                n = e + 1;
                final ConstraintAnchor constraintAnchor10 = w14[n];
                final ConstraintAnchor f13 = c2.W[n].f;
                if (f12 != null) {
                    if (b != d3) {
                        d2.e(constraintAnchor9.i, f12.i, constraintAnchor9.e(), 5);
                    }
                    else if (f13 != null) {
                        d2.c(constraintAnchor9.i, f12.i, constraintAnchor9.e(), 0.5f, constraintAnchor10.i, f13.i, constraintAnchor10.e(), 5);
                    }
                }
                if (f13 != null && b != d3) {
                    d2.e(constraintAnchor10.i, f13.i, -constraintAnchor10.e(), 5);
                }
            }
        }
        if ((n7 != 0 || n5 != 0) && b != null && b != d3) {
            final ConstraintAnchor[] w15 = b.W;
            ConstraintAnchor constraintAnchor11 = w15[e];
            ConstraintWidget constraintWidget12;
            if ((constraintWidget12 = d3) == null) {
                constraintWidget12 = b;
            }
            final ConstraintAnchor[] w16 = constraintWidget12.W;
            final int n26 = e + 1;
            ConstraintAnchor constraintAnchor12 = w16[n26];
            final ConstraintAnchor f14 = constraintAnchor11.f;
            SolverVariable i15;
            if (f14 != null) {
                i15 = f14.i;
            }
            else {
                i15 = null;
            }
            final ConstraintAnchor f15 = constraintAnchor12.f;
            SolverVariable solverVariable4;
            if (f15 != null) {
                solverVariable4 = f15.i;
            }
            else {
                solverVariable4 = null;
            }
            if (c2 != constraintWidget12) {
                final ConstraintAnchor f16 = c2.W[n26].f;
                solverVariable4 = solverVariable;
                if (f16 != null) {
                    solverVariable4 = f16.i;
                }
            }
            if (b == constraintWidget12) {
                constraintAnchor11 = w15[e];
                constraintAnchor12 = w15[n26];
            }
            if (i15 != null && solverVariable4 != null) {
                n = constraintAnchor11.e();
                e = constraintWidget12.W[n26].e();
                d2.c(constraintAnchor11.i, i15, n, 0.5f, solverVariable4, constraintAnchor12.i, e, 5);
            }
        }
    }
    
    public static void b(final d d, final androidx.constraintlayout.core.d d2, final ArrayList<ConstraintWidget> list, final int n) {
        int i = 0;
        int n2;
        c[] array;
        int n3;
        if (n == 0) {
            n2 = d.W0;
            array = d.Z0;
            n3 = 0;
        }
        else {
            n2 = d.X0;
            array = d.Y0;
            n3 = 2;
        }
        while (i < n2) {
            final c c = array[i];
            c.a();
            if (list == null || list.contains(c.a)) {
                a(d, d2, n, n3, c);
            }
            ++i;
        }
    }
}
