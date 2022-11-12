// 
// Decompiled by Procyon v0.6.0
// 

package androidx.constraintlayout.core.widgets.analyzer;

import androidx.constraintlayout.core.widgets.ConstraintAnchor;
import s.a;
import androidx.constraintlayout.core.widgets.ConstraintWidget;

public class l extends WidgetRun
{
    public DependencyNode k;
    e l;
    
    public l(final ConstraintWidget constraintWidget) {
        super(constraintWidget);
        final DependencyNode k = new DependencyNode(this);
        this.k = k;
        this.l = null;
        super.h.e = DependencyNode.Type.TOP;
        super.i.e = DependencyNode.Type.BOTTOM;
        k.e = DependencyNode.Type.BASELINE;
        super.f = 1;
    }
    
    @Override
    public void a(final a a) {
        final int n = l$a.a[super.j.ordinal()];
        if (n != 1) {
            if (n != 2) {
                if (n == 3) {
                    final ConstraintWidget b = super.b;
                    this.n(a, b.P, b.R, 1);
                    return;
                }
            }
            else {
                this.o(a);
            }
        }
        else {
            this.p(a);
        }
        final e e = super.e;
        if (e.c && !e.j && super.d == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) {
            final ConstraintWidget b2 = super.b;
            final int x = b2.x;
            if (x != 2) {
                if (x == 3) {
                    if (b2.e.e.j) {
                        final int u = b2.u();
                        int n3 = 0;
                        Label_0250: {
                            float n2 = 0.0f;
                            Label_0243: {
                                float n4;
                                float n5;
                                if (u != -1) {
                                    if (u == 0) {
                                        final ConstraintWidget b3 = super.b;
                                        n2 = b3.e.e.g * b3.t();
                                        break Label_0243;
                                    }
                                    if (u != 1) {
                                        n3 = 0;
                                        break Label_0250;
                                    }
                                    final ConstraintWidget b4 = super.b;
                                    n4 = (float)b4.e.e.g;
                                    n5 = b4.t();
                                }
                                else {
                                    final ConstraintWidget b5 = super.b;
                                    n4 = (float)b5.e.e.g;
                                    n5 = b5.t();
                                }
                                n2 = n4 / n5;
                            }
                            n3 = (int)(n2 + 0.5f);
                        }
                        super.e.d(n3);
                    }
                }
            }
            else {
                final ConstraintWidget i = b2.I();
                if (i != null) {
                    final e e2 = i.f.e;
                    if (e2.j) {
                        super.e.d((int)(e2.g * super.b.E + 0.5f));
                    }
                }
            }
        }
        final DependencyNode h = super.h;
        if (h.c) {
            final DependencyNode j = super.i;
            if (j.c) {
                if (h.j && j.j && super.e.j) {
                    return;
                }
                if (!super.e.j && super.d == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) {
                    final ConstraintWidget b6 = super.b;
                    if (b6.w == 0 && !b6.i0()) {
                        final DependencyNode dependencyNode = super.h.l.get(0);
                        final DependencyNode dependencyNode2 = super.i.l.get(0);
                        final int g = dependencyNode.g;
                        final DependencyNode h2 = super.h;
                        final int n6 = g + h2.f;
                        final int n7 = dependencyNode2.g + super.i.f;
                        h2.d(n6);
                        super.i.d(n7);
                        super.e.d(n7 - n6);
                        return;
                    }
                }
                if (!super.e.j && super.d == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT && super.a == 1 && super.h.l.size() > 0 && super.i.l.size() > 0) {
                    final int n8 = super.i.l.get(0).g + super.i.f - (super.h.l.get(0).g + super.h.f);
                    final e e3 = super.e;
                    final int m = e3.m;
                    if (n8 < m) {
                        e3.d(n8);
                    }
                    else {
                        e3.d(m);
                    }
                }
                if (!super.e.j) {
                    return;
                }
                if (super.h.l.size() > 0 && super.i.l.size() > 0) {
                    final DependencyNode dependencyNode3 = super.h.l.get(0);
                    final DependencyNode dependencyNode4 = super.i.l.get(0);
                    int g2 = dependencyNode3.g + super.h.f;
                    int g3 = dependencyNode4.g + super.i.f;
                    float p = super.b.P();
                    if (dependencyNode3 == dependencyNode4) {
                        g2 = dependencyNode3.g;
                        g3 = dependencyNode4.g;
                        p = 0.5f;
                    }
                    super.h.d((int)(g2 + 0.5f + (g3 - g2 - super.e.g) * p));
                    super.i.d(super.h.g + super.e.g);
                }
            }
        }
    }
    
    @Override
    void d() {
        final ConstraintWidget b = super.b;
        if (b.a) {
            super.e.d(b.v());
        }
        if (!super.e.j) {
            super.d = super.b.R();
            if (super.b.X()) {
                this.l = new androidx.constraintlayout.core.widgets.analyzer.a(this);
            }
            final ConstraintWidget.DimensionBehaviour d = super.d;
            if (d != ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) {
                if (d == ConstraintWidget.DimensionBehaviour.MATCH_PARENT) {
                    final ConstraintWidget i = super.b.I();
                    if (i != null && i.R() == ConstraintWidget.DimensionBehaviour.FIXED) {
                        final int v = i.v();
                        final int e = super.b.P.e();
                        final int e2 = super.b.R.e();
                        this.b(super.h, i.f.h, super.b.P.e());
                        this.b(super.i, i.f.i, -super.b.R.e());
                        super.e.d(v - e - e2);
                        return;
                    }
                }
                if (super.d == ConstraintWidget.DimensionBehaviour.FIXED) {
                    super.e.d(super.b.v());
                }
            }
        }
        else if (super.d == ConstraintWidget.DimensionBehaviour.MATCH_PARENT) {
            final ConstraintWidget j = super.b.I();
            if (j != null && j.R() == ConstraintWidget.DimensionBehaviour.FIXED) {
                this.b(super.h, j.f.h, super.b.P.e());
                this.b(super.i, j.f.i, -super.b.R.e());
                return;
            }
        }
        final e e3 = super.e;
        final boolean k = e3.j;
        if (k) {
            final ConstraintWidget b2 = super.b;
            if (b2.a) {
                final ConstraintAnchor[] w = b2.W;
                if (w[2].f != null && w[3].f != null) {
                    if (b2.i0()) {
                        super.h.f = super.b.W[2].e();
                        super.i.f = -super.b.W[3].e();
                    }
                    else {
                        final DependencyNode h = this.h(super.b.W[2]);
                        if (h != null) {
                            this.b(super.h, h, super.b.W[2].e());
                        }
                        final DependencyNode h2 = this.h(super.b.W[3]);
                        if (h2 != null) {
                            this.b(super.i, h2, -super.b.W[3].e());
                        }
                        super.h.b = true;
                        super.i.b = true;
                    }
                    if (super.b.X()) {
                        this.b(this.k, super.h, super.b.n());
                    }
                    return;
                }
                else if (w[2].f != null) {
                    final DependencyNode h3 = this.h(w[2]);
                    if (h3 == null) {
                        return;
                    }
                    this.b(super.h, h3, super.b.W[2].e());
                    this.b(super.i, super.h, super.e.g);
                    if (super.b.X()) {
                        this.b(this.k, super.h, super.b.n());
                    }
                    return;
                }
                else if (w[3].f != null) {
                    final DependencyNode h4 = this.h(w[3]);
                    if (h4 != null) {
                        this.b(super.i, h4, -super.b.W[3].e());
                        this.b(super.h, super.i, -super.e.g);
                    }
                    if (super.b.X()) {
                        this.b(this.k, super.h, super.b.n());
                    }
                    return;
                }
                else if (w[4].f != null) {
                    final DependencyNode h5 = this.h(w[4]);
                    if (h5 != null) {
                        this.b(this.k, h5, 0);
                        this.b(super.h, this.k, -super.b.n());
                        this.b(super.i, super.h, super.e.g);
                    }
                    return;
                }
                else {
                    if (b2 instanceof r.a || b2.I() == null || super.b.m(ConstraintAnchor.Type.CENTER).f != null) {
                        return;
                    }
                    this.b(super.h, super.b.I().f.h, super.b.W());
                    this.b(super.i, super.h, super.e.g);
                    if (super.b.X()) {
                        this.b(this.k, super.h, super.b.n());
                    }
                    return;
                }
            }
        }
        if (!k && super.d == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) {
            final ConstraintWidget b3 = super.b;
            final int x = b3.x;
            if (x != 2) {
                if (x == 3) {
                    if (!b3.i0()) {
                        final ConstraintWidget b4 = super.b;
                        if (b4.w != 3) {
                            final e e4 = b4.e.e;
                            super.e.l.add(e4);
                            e4.k.add(super.e);
                            final e e5 = super.e;
                            e5.b = true;
                            e5.k.add(super.h);
                            super.e.k.add(super.i);
                        }
                    }
                }
            }
            else {
                final ConstraintWidget l = b3.I();
                if (l != null) {
                    final e e6 = l.f.e;
                    super.e.l.add(e6);
                    e6.k.add(super.e);
                    final e e7 = super.e;
                    e7.b = true;
                    e7.k.add(super.h);
                    super.e.k.add(super.i);
                }
            }
        }
        else {
            e3.b(this);
        }
        final ConstraintWidget b5 = super.b;
        final ConstraintAnchor[] w2 = b5.W;
        if (w2[2].f != null && w2[3].f != null) {
            if (b5.i0()) {
                super.h.f = super.b.W[2].e();
                super.i.f = -super.b.W[3].e();
            }
            else {
                final DependencyNode h6 = this.h(super.b.W[2]);
                final DependencyNode h7 = this.h(super.b.W[3]);
                if (h6 != null) {
                    h6.b(this);
                }
                if (h7 != null) {
                    h7.b(this);
                }
                super.j = RunType.CENTER;
            }
            if (super.b.X()) {
                this.c(this.k, super.h, 1, this.l);
            }
        }
        else if (w2[2].f != null) {
            final DependencyNode h8 = this.h(w2[2]);
            if (h8 != null) {
                this.b(super.h, h8, super.b.W[2].e());
                this.c(super.i, super.h, 1, super.e);
                if (super.b.X()) {
                    this.c(this.k, super.h, 1, this.l);
                }
                final ConstraintWidget.DimensionBehaviour d2 = super.d;
                final ConstraintWidget.DimensionBehaviour match_CONSTRAINT = ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT;
                if (d2 == match_CONSTRAINT && super.b.t() > 0.0f) {
                    final j e8 = super.b.e;
                    if (e8.d == match_CONSTRAINT) {
                        e8.e.k.add(super.e);
                        super.e.l.add(super.b.e.e);
                        super.e.a = this;
                    }
                }
            }
        }
        else if (w2[3].f != null) {
            final DependencyNode h9 = this.h(w2[3]);
            if (h9 != null) {
                this.b(super.i, h9, -super.b.W[3].e());
                this.c(super.h, super.i, -1, super.e);
                if (super.b.X()) {
                    this.c(this.k, super.h, 1, this.l);
                }
            }
        }
        else if (w2[4].f != null) {
            final DependencyNode h10 = this.h(w2[4]);
            if (h10 != null) {
                this.b(this.k, h10, 0);
                this.c(super.h, this.k, -1, this.l);
                this.c(super.i, super.h, 1, super.e);
            }
        }
        else if (!(b5 instanceof r.a) && b5.I() != null) {
            this.b(super.h, super.b.I().f.h, super.b.W());
            this.c(super.i, super.h, 1, super.e);
            if (super.b.X()) {
                this.c(this.k, super.h, 1, this.l);
            }
            final ConstraintWidget.DimensionBehaviour d3 = super.d;
            final ConstraintWidget.DimensionBehaviour match_CONSTRAINT2 = ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT;
            if (d3 == match_CONSTRAINT2 && super.b.t() > 0.0f) {
                final j e9 = super.b.e;
                if (e9.d == match_CONSTRAINT2) {
                    e9.e.k.add(super.e);
                    super.e.l.add(super.b.e.e);
                    super.e.a = this;
                }
            }
        }
        if (super.e.l.size() == 0) {
            super.e.c = true;
        }
    }
    
    public void e() {
        final DependencyNode h = super.h;
        if (h.j) {
            super.b.k1(h.g);
        }
    }
    
    @Override
    void f() {
        super.c = null;
        super.h.c();
        super.i.c();
        this.k.c();
        super.e.c();
        super.g = false;
    }
    
    @Override
    boolean m() {
        return super.d != ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT || super.b.x == 0;
    }
    
    void q() {
        super.g = false;
        super.h.c();
        super.h.j = false;
        super.i.c();
        super.i.j = false;
        this.k.c();
        this.k.j = false;
        super.e.j = false;
    }
    
    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append("VerticalRun ");
        sb.append(super.b.r());
        return sb.toString();
    }
}
