// 
// Decompiled by Procyon v0.6.0
// 

package androidx.constraintlayout.core.widgets;

import java.util.ArrayList;

public class c
{
    protected ConstraintWidget a;
    protected ConstraintWidget b;
    protected ConstraintWidget c;
    protected ConstraintWidget d;
    protected ConstraintWidget e;
    protected ConstraintWidget f;
    protected ConstraintWidget g;
    protected ArrayList<ConstraintWidget> h;
    protected int i;
    protected int j;
    protected float k;
    int l;
    int m;
    int n;
    boolean o;
    private int p;
    private boolean q;
    protected boolean r;
    protected boolean s;
    protected boolean t;
    protected boolean u;
    private boolean v;
    
    public c(final ConstraintWidget a, final int p3, final boolean q) {
        this.k = 0.0f;
        this.a = a;
        this.p = p3;
        this.q = q;
    }
    
    private void b() {
        final int n = this.p * 2;
        ConstraintWidget a = this.a;
        boolean t = true;
        this.o = true;
        ConstraintWidget constraintWidget = a;
        int i = 0;
        while (i == 0) {
            ++this.i;
            final ConstraintWidget[] f0 = a.F0;
            final int p = this.p;
            final ConstraintWidget constraintWidget2 = null;
            f0[p] = null;
            a.E0[p] = null;
            if (a.T() != 8) {
                ++this.l;
                final ConstraintWidget.DimensionBehaviour s = a.s(this.p);
                final ConstraintWidget.DimensionBehaviour match_CONSTRAINT = ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT;
                if (s != match_CONSTRAINT) {
                    this.m += a.C(this.p);
                }
                final int m = this.m + a.W[n].e();
                this.m = m;
                final ConstraintAnchor[] w = a.W;
                final int n2 = n + 1;
                this.m = m + w[n2].e();
                final int n3 = this.n + a.W[n].e();
                this.n = n3;
                this.n = n3 + a.W[n2].e();
                if (this.b == null) {
                    this.b = a;
                }
                this.d = a;
                final ConstraintWidget.DimensionBehaviour[] z = a.Z;
                final int p2 = this.p;
                if (z[p2] == match_CONSTRAINT) {
                    final int[] y = a.y;
                    if (y[p2] == 0 || y[p2] == 3 || y[p2] == 2) {
                        ++this.j;
                        final float[] d0 = a.D0;
                        final float n4 = d0[p2];
                        if (n4 > 0.0f) {
                            this.k += d0[p2];
                        }
                        if (c(a, p2)) {
                            if (n4 < 0.0f) {
                                this.r = true;
                            }
                            else {
                                this.s = true;
                            }
                            if (this.h == null) {
                                this.h = new ArrayList<ConstraintWidget>();
                            }
                            this.h.add(a);
                        }
                        if (this.f == null) {
                            this.f = a;
                        }
                        final ConstraintWidget g = this.g;
                        if (g != null) {
                            g.E0[this.p] = a;
                        }
                        this.g = a;
                    }
                    if (this.p == 0) {
                        if (a.w != 0) {
                            this.o = false;
                        }
                        else if (a.z != 0 || a.A != 0) {
                            this.o = false;
                        }
                    }
                    else if (a.x != 0) {
                        this.o = false;
                    }
                    else if (a.C != 0 || a.D != 0) {
                        this.o = false;
                    }
                    if (a.d0 != 0.0f) {
                        this.o = false;
                        this.u = true;
                    }
                }
            }
            if (constraintWidget != a) {
                constraintWidget.F0[this.p] = a;
            }
            final ConstraintAnchor f2 = a.W[n + 1].f;
            ConstraintWidget constraintWidget3 = constraintWidget2;
            if (f2 != null) {
                final ConstraintWidget d2 = f2.d;
                final ConstraintAnchor[] w2 = d2.W;
                constraintWidget3 = constraintWidget2;
                if (w2[n].f != null) {
                    if (w2[n].f.d != a) {
                        constraintWidget3 = constraintWidget2;
                    }
                    else {
                        constraintWidget3 = d2;
                    }
                }
            }
            if (constraintWidget3 == null) {
                constraintWidget3 = a;
                i = 1;
            }
            final ConstraintWidget constraintWidget4 = a;
            a = constraintWidget3;
            constraintWidget = constraintWidget4;
        }
        final ConstraintWidget b = this.b;
        if (b != null) {
            this.m -= b.W[n].e();
        }
        final ConstraintWidget d3 = this.d;
        if (d3 != null) {
            this.m -= d3.W[n + 1].e();
        }
        this.c = a;
        if (this.p == 0 && this.q) {
            this.e = a;
        }
        else {
            this.e = this.a;
        }
        if (!this.s || !this.r) {
            t = false;
        }
        this.t = t;
    }
    
    private static boolean c(final ConstraintWidget constraintWidget, final int n) {
        if (constraintWidget.T() != 8 && constraintWidget.Z[n] == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) {
            final int[] y = constraintWidget.y;
            if (y[n] == 0 || y[n] == 3) {
                return true;
            }
        }
        return false;
    }
    
    public void a() {
        if (!this.v) {
            this.b();
        }
        this.v = true;
    }
}
