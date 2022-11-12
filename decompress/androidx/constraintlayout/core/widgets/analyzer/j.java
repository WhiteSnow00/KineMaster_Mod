// 
// Decompiled by Procyon v0.6.0
// 

package androidx.constraintlayout.core.widgets.analyzer;

import androidx.constraintlayout.core.widgets.ConstraintAnchor;
import s.a;
import androidx.constraintlayout.core.widgets.ConstraintWidget;

public class j extends WidgetRun
{
    private static int[] k;
    
    static {
        j.k = new int[2];
    }
    
    public j(final ConstraintWidget constraintWidget) {
        super(constraintWidget);
        super.h.e = DependencyNode.Type.LEFT;
        super.i.e = DependencyNode.Type.RIGHT;
        super.f = 0;
    }
    
    private void q(final int[] array, int n, int n2, int n3, int n4, final float n5, final int n6) {
        n = n2 - n;
        n2 = n4 - n3;
        if (n6 != -1) {
            if (n6 != 0) {
                if (n6 == 1) {
                    n2 = (int)(n * n5 + 0.5f);
                    array[0] = n;
                    array[1] = n2;
                }
            }
            else {
                array[0] = (int)(n2 * n5 + 0.5f);
                array[1] = n2;
            }
        }
        else {
            n4 = (int)(n2 * n5 + 0.5f);
            n3 = (int)(n / n5 + 0.5f);
            if (n4 <= n) {
                array[0] = n4;
                array[1] = n2;
            }
            else if (n3 <= n2) {
                array[0] = n;
                array[1] = n3;
            }
        }
    }
    
    @Override
    public void a(final a a) {
        final int n = j$a.a[super.j.ordinal()];
        if (n != 1) {
            if (n != 2) {
                if (n == 3) {
                    final ConstraintWidget b = super.b;
                    this.n(a, b.O, b.Q, 0);
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
        Label_1576: {
            if (!super.e.j && super.d == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) {
                final ConstraintWidget b2 = super.b;
                final int w = b2.w;
                if (w != 2) {
                    if (w == 3) {
                        final int x = b2.x;
                        if (x != 0 && x != 3) {
                            final int u = b2.u();
                            int n3 = 0;
                            Label_0252: {
                                float n2 = 0.0f;
                                Label_0245: {
                                    float n4;
                                    float n5;
                                    if (u != -1) {
                                        if (u == 0) {
                                            final ConstraintWidget b3 = super.b;
                                            n2 = b3.f.e.g / b3.t();
                                            break Label_0245;
                                        }
                                        if (u != 1) {
                                            n3 = 0;
                                            break Label_0252;
                                        }
                                        final ConstraintWidget b4 = super.b;
                                        n4 = (float)b4.f.e.g;
                                        n5 = b4.t();
                                    }
                                    else {
                                        final ConstraintWidget b5 = super.b;
                                        n4 = (float)b5.f.e.g;
                                        n5 = b5.t();
                                    }
                                    n2 = n4 * n5;
                                }
                                n3 = (int)(n2 + 0.5f);
                            }
                            super.e.d(n3);
                        }
                        else {
                            final l f = b2.f;
                            final DependencyNode h = f.h;
                            final DependencyNode i = f.i;
                            final boolean b6 = b2.O.f != null;
                            final boolean b7 = b2.P.f != null;
                            final boolean b8 = b2.Q.f != null;
                            final boolean b9 = b2.R.f != null;
                            final int u2 = b2.u();
                            if (b6 && b7 && b8 && b9) {
                                final float t = super.b.t();
                                if (h.j && i.j) {
                                    final DependencyNode h2 = super.h;
                                    if (h2.c) {
                                        if (super.i.c) {
                                            this.q(j.k, h2.l.get(0).g + super.h.f, super.i.l.get(0).g - super.i.f, h.g + h.f, i.g - i.f, t, u2);
                                            super.e.d(j.k[0]);
                                            super.b.f.e.d(j.k[1]);
                                        }
                                    }
                                    return;
                                }
                                final DependencyNode h3 = super.h;
                                if (h3.j) {
                                    final DependencyNode j = super.i;
                                    if (j.j) {
                                        if (!h.c || !i.c) {
                                            return;
                                        }
                                        this.q(androidx.constraintlayout.core.widgets.analyzer.j.k, h3.g + h3.f, j.g - j.f, h.l.get(0).g + h.f, i.l.get(0).g - i.f, t, u2);
                                        super.e.d(androidx.constraintlayout.core.widgets.analyzer.j.k[0]);
                                        super.b.f.e.d(androidx.constraintlayout.core.widgets.analyzer.j.k[1]);
                                    }
                                }
                                final DependencyNode h4 = super.h;
                                if (!h4.c || !super.i.c || !h.c || !i.c) {
                                    return;
                                }
                                this.q(j.k, h4.l.get(0).g + super.h.f, super.i.l.get(0).g - super.i.f, h.l.get(0).g + h.f, i.l.get(0).g - i.f, t, u2);
                                super.e.d(j.k[0]);
                                super.b.f.e.d(j.k[1]);
                            }
                            else if (b6 && b8) {
                                if (!super.h.c || !super.i.c) {
                                    return;
                                }
                                final float t2 = super.b.t();
                                final int n6 = super.h.l.get(0).g + super.h.f;
                                final int n7 = super.i.l.get(0).g - super.i.f;
                                if (u2 != -1 && u2 != 0) {
                                    if (u2 == 1) {
                                        int g = this.g(n7 - n6, 0);
                                        final int n8 = (int)(g / t2 + 0.5f);
                                        final int g2 = this.g(n8, 1);
                                        if (n8 != g2) {
                                            g = (int)(g2 * t2 + 0.5f);
                                        }
                                        super.e.d(g);
                                        super.b.f.e.d(g2);
                                    }
                                }
                                else {
                                    int g3 = this.g(n7 - n6, 0);
                                    final int n9 = (int)(g3 * t2 + 0.5f);
                                    final int g4 = this.g(n9, 1);
                                    if (n9 != g4) {
                                        g3 = (int)(g4 / t2 + 0.5f);
                                    }
                                    super.e.d(g3);
                                    super.b.f.e.d(g4);
                                }
                            }
                            else if (b7 && b9) {
                                if (!h.c || !i.c) {
                                    return;
                                }
                                final float t3 = super.b.t();
                                final int n10 = h.l.get(0).g + h.f;
                                final int n11 = i.l.get(0).g - i.f;
                                if (u2 != -1) {
                                    if (u2 == 0) {
                                        int g5 = this.g(n11 - n10, 1);
                                        final int n12 = (int)(g5 * t3 + 0.5f);
                                        final int g6 = this.g(n12, 0);
                                        if (n12 != g6) {
                                            g5 = (int)(g6 / t3 + 0.5f);
                                        }
                                        super.e.d(g6);
                                        super.b.f.e.d(g5);
                                        break Label_1576;
                                    }
                                    if (u2 != 1) {
                                        break Label_1576;
                                    }
                                }
                                int g7 = this.g(n11 - n10, 1);
                                final int n13 = (int)(g7 / t3 + 0.5f);
                                final int g8 = this.g(n13, 0);
                                if (n13 != g8) {
                                    g7 = (int)(g8 * t3 + 0.5f);
                                }
                                super.e.d(g8);
                                super.b.f.e.d(g7);
                            }
                        }
                    }
                }
                else {
                    final ConstraintWidget k = b2.I();
                    if (k != null) {
                        final e e = k.e.e;
                        if (e.j) {
                            super.e.d((int)(e.g * super.b.B + 0.5f));
                        }
                    }
                }
            }
        }
        final DependencyNode h5 = super.h;
        if (h5.c) {
            final DependencyNode l = super.i;
            if (l.c) {
                if (h5.j && l.j && super.e.j) {
                    return;
                }
                if (!super.e.j && super.d == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) {
                    final ConstraintWidget b10 = super.b;
                    if (b10.w == 0 && !b10.g0()) {
                        final DependencyNode dependencyNode = super.h.l.get(0);
                        final DependencyNode dependencyNode2 = super.i.l.get(0);
                        final int g9 = dependencyNode.g;
                        final DependencyNode h6 = super.h;
                        final int n14 = g9 + h6.f;
                        final int n15 = dependencyNode2.g + super.i.f;
                        h6.d(n14);
                        super.i.d(n15);
                        super.e.d(n15 - n14);
                        return;
                    }
                }
                if (!super.e.j && super.d == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT && super.a == 1 && super.h.l.size() > 0 && super.i.l.size() > 0) {
                    final int min = Math.min(super.i.l.get(0).g + super.i.f - (super.h.l.get(0).g + super.h.f), super.e.m);
                    final ConstraintWidget b11 = super.b;
                    final int a2 = b11.A;
                    int n16 = Math.max(b11.z, min);
                    if (a2 > 0) {
                        n16 = Math.min(a2, n16);
                    }
                    super.e.d(n16);
                }
                if (!super.e.j) {
                    return;
                }
                final DependencyNode dependencyNode3 = super.h.l.get(0);
                final DependencyNode dependencyNode4 = super.i.l.get(0);
                int g10 = dependencyNode3.g + super.h.f;
                int g11 = dependencyNode4.g + super.i.f;
                float w2 = super.b.w();
                if (dependencyNode3 == dependencyNode4) {
                    g10 = dependencyNode3.g;
                    g11 = dependencyNode4.g;
                    w2 = 0.5f;
                }
                super.h.d((int)(g10 + 0.5f + (g11 - g10 - super.e.g) * w2));
                super.i.d(super.h.g + super.e.g);
            }
        }
    }
    
    @Override
    void d() {
        final ConstraintWidget b = super.b;
        if (b.a) {
            super.e.d(b.U());
        }
        if (!super.e.j) {
            final ConstraintWidget.DimensionBehaviour y = super.b.y();
            if ((super.d = y) != ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) {
                final ConstraintWidget.DimensionBehaviour match_PARENT = ConstraintWidget.DimensionBehaviour.MATCH_PARENT;
                if (y == match_PARENT) {
                    final ConstraintWidget i = super.b.I();
                    if (i != null && (i.y() == ConstraintWidget.DimensionBehaviour.FIXED || i.y() == match_PARENT)) {
                        final int u = i.U();
                        final int e = super.b.O.e();
                        final int e2 = super.b.Q.e();
                        this.b(super.h, i.e.h, super.b.O.e());
                        this.b(super.i, i.e.i, -super.b.Q.e());
                        super.e.d(u - e - e2);
                        return;
                    }
                }
                if (super.d == ConstraintWidget.DimensionBehaviour.FIXED) {
                    super.e.d(super.b.U());
                }
            }
        }
        else {
            final ConstraintWidget.DimensionBehaviour d = super.d;
            final ConstraintWidget.DimensionBehaviour match_PARENT2 = ConstraintWidget.DimensionBehaviour.MATCH_PARENT;
            if (d == match_PARENT2) {
                final ConstraintWidget j = super.b.I();
                if (j != null && (j.y() == ConstraintWidget.DimensionBehaviour.FIXED || j.y() == match_PARENT2)) {
                    this.b(super.h, j.e.h, super.b.O.e());
                    this.b(super.i, j.e.i, -super.b.Q.e());
                    return;
                }
            }
        }
        final e e3 = super.e;
        if (e3.j) {
            final ConstraintWidget b2 = super.b;
            if (b2.a) {
                final ConstraintAnchor[] w = b2.W;
                if (w[0].f != null && w[1].f != null) {
                    if (b2.g0()) {
                        super.h.f = super.b.W[0].e();
                        super.i.f = -super.b.W[1].e();
                        return;
                    }
                    final DependencyNode h = this.h(super.b.W[0]);
                    if (h != null) {
                        this.b(super.h, h, super.b.W[0].e());
                    }
                    final DependencyNode h2 = this.h(super.b.W[1]);
                    if (h2 != null) {
                        this.b(super.i, h2, -super.b.W[1].e());
                    }
                    super.h.b = true;
                    super.i.b = true;
                    return;
                }
                else if (w[0].f != null) {
                    final DependencyNode h3 = this.h(w[0]);
                    if (h3 != null) {
                        this.b(super.h, h3, super.b.W[0].e());
                        this.b(super.i, super.h, super.e.g);
                    }
                    return;
                }
                else if (w[1].f != null) {
                    final DependencyNode h4 = this.h(w[1]);
                    if (h4 != null) {
                        this.b(super.i, h4, -super.b.W[1].e());
                        this.b(super.h, super.i, -super.e.g);
                    }
                    return;
                }
                else {
                    if (!(b2 instanceof r.a) && b2.I() != null && super.b.m(ConstraintAnchor.Type.CENTER).f == null) {
                        this.b(super.h, super.b.I().e.h, super.b.V());
                        this.b(super.i, super.h, super.e.g);
                    }
                    return;
                }
            }
        }
        if (super.d == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) {
            final ConstraintWidget b3 = super.b;
            final int w2 = b3.w;
            if (w2 != 2) {
                if (w2 == 3) {
                    if (b3.x == 3) {
                        super.h.a = this;
                        super.i.a = this;
                        final l f = b3.f;
                        f.h.a = this;
                        f.i.a = this;
                        e3.a = this;
                        if (b3.i0()) {
                            super.e.l.add(super.b.f.e);
                            super.b.f.e.k.add(super.e);
                            final l f2 = super.b.f;
                            f2.e.a = this;
                            super.e.l.add(f2.h);
                            super.e.l.add(super.b.f.i);
                            super.b.f.h.k.add(super.e);
                            super.b.f.i.k.add(super.e);
                        }
                        else if (super.b.g0()) {
                            super.b.f.e.l.add(super.e);
                            super.e.k.add(super.b.f.e);
                        }
                        else {
                            super.b.f.e.l.add(super.e);
                        }
                    }
                    else {
                        final e e4 = b3.f.e;
                        e3.l.add(e4);
                        e4.k.add(super.e);
                        super.b.f.h.k.add(super.e);
                        super.b.f.i.k.add(super.e);
                        final e e5 = super.e;
                        e5.b = true;
                        e5.k.add(super.h);
                        super.e.k.add(super.i);
                        super.h.l.add(super.e);
                        super.i.l.add(super.e);
                    }
                }
            }
            else {
                final ConstraintWidget k = b3.I();
                if (k != null) {
                    final e e6 = k.f.e;
                    super.e.l.add(e6);
                    e6.k.add(super.e);
                    final e e7 = super.e;
                    e7.b = true;
                    e7.k.add(super.h);
                    super.e.k.add(super.i);
                }
            }
        }
        final ConstraintWidget b4 = super.b;
        final ConstraintAnchor[] w3 = b4.W;
        if (w3[0].f != null && w3[1].f != null) {
            if (b4.g0()) {
                super.h.f = super.b.W[0].e();
                super.i.f = -super.b.W[1].e();
            }
            else {
                final DependencyNode h5 = this.h(super.b.W[0]);
                final DependencyNode h6 = this.h(super.b.W[1]);
                if (h5 != null) {
                    h5.b(this);
                }
                if (h6 != null) {
                    h6.b(this);
                }
                super.j = RunType.CENTER;
            }
        }
        else if (w3[0].f != null) {
            final DependencyNode h7 = this.h(w3[0]);
            if (h7 != null) {
                this.b(super.h, h7, super.b.W[0].e());
                this.c(super.i, super.h, 1, super.e);
            }
        }
        else if (w3[1].f != null) {
            final DependencyNode h8 = this.h(w3[1]);
            if (h8 != null) {
                this.b(super.i, h8, -super.b.W[1].e());
                this.c(super.h, super.i, -1, super.e);
            }
        }
        else if (!(b4 instanceof r.a) && b4.I() != null) {
            this.b(super.h, super.b.I().e.h, super.b.V());
            this.c(super.i, super.h, 1, super.e);
        }
    }
    
    public void e() {
        final DependencyNode h = super.h;
        if (h.j) {
            super.b.j1(h.g);
        }
    }
    
    @Override
    void f() {
        super.c = null;
        super.h.c();
        super.i.c();
        super.e.c();
        super.g = false;
    }
    
    @Override
    boolean m() {
        return super.d != ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT || super.b.w == 0;
    }
    
    void r() {
        super.g = false;
        super.h.c();
        super.h.j = false;
        super.i.c();
        super.i.j = false;
        super.e.j = false;
    }
    
    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append("HorizontalRun ");
        sb.append(super.b.r());
        return sb.toString();
    }
}
