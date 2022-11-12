// 
// Decompiled by Procyon v0.6.0
// 

package androidx.constraintlayout.core.widgets.analyzer;

import androidx.constraintlayout.core.widgets.ConstraintAnchor;
import androidx.constraintlayout.core.widgets.f;
import androidx.constraintlayout.core.widgets.g;
import androidx.constraintlayout.core.widgets.a;
import androidx.constraintlayout.core.widgets.e;
import androidx.constraintlayout.core.widgets.d;
import androidx.constraintlayout.core.widgets.ConstraintWidget;
import java.util.ArrayList;

public class b
{
    private final ArrayList<ConstraintWidget> a;
    private a b;
    private d c;
    
    public b(final d c) {
        this.a = new ArrayList<ConstraintWidget>();
        this.b = new a();
        this.c = c;
    }
    
    private boolean a(final b b, final ConstraintWidget constraintWidget, int j) {
        this.b.a = constraintWidget.y();
        this.b.b = constraintWidget.R();
        this.b.c = constraintWidget.U();
        this.b.d = constraintWidget.v();
        final a b2 = this.b;
        b2.i = false;
        b2.j = j;
        final ConstraintWidget.DimensionBehaviour a = b2.a;
        final ConstraintWidget.DimensionBehaviour match_CONSTRAINT = ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT;
        final boolean b3 = a == match_CONSTRAINT;
        if (b2.b == match_CONSTRAINT) {
            j = 1;
        }
        else {
            j = 0;
        }
        final boolean b4 = b3 && constraintWidget.d0 > 0.0f;
        if (j != 0 && constraintWidget.d0 > 0.0f) {
            j = 1;
        }
        else {
            j = 0;
        }
        if (b4 && constraintWidget.y[0] == 4) {
            b2.a = ConstraintWidget.DimensionBehaviour.FIXED;
        }
        if (j != 0 && constraintWidget.y[1] == 4) {
            b2.b = ConstraintWidget.DimensionBehaviour.FIXED;
        }
        b.b(constraintWidget, b2);
        constraintWidget.h1(this.b.e);
        constraintWidget.I0(this.b.f);
        constraintWidget.H0(this.b.h);
        constraintWidget.x0(this.b.g);
        final a b5 = this.b;
        b5.j = androidx.constraintlayout.core.widgets.analyzer.b.a.k;
        return b5.i;
    }
    
    private void b(final d d) {
        final int size = d.L0.size();
        final boolean q1 = d.Q1(64);
        final b g1 = d.G1();
        for (int i = 0; i < size; ++i) {
            final ConstraintWidget constraintWidget = d.L0.get(i);
            if (!(constraintWidget instanceof e)) {
                if (!(constraintWidget instanceof androidx.constraintlayout.core.widgets.a)) {
                    if (!constraintWidget.j0()) {
                        if (q1) {
                            final j e = constraintWidget.e;
                            if (e != null) {
                                final l f = constraintWidget.f;
                                if (f != null && e.e.j && f.e.j) {
                                    continue;
                                }
                            }
                        }
                        final ConstraintWidget.DimensionBehaviour s = constraintWidget.s(0);
                        final int n = 1;
                        final ConstraintWidget.DimensionBehaviour s2 = constraintWidget.s(1);
                        final ConstraintWidget.DimensionBehaviour match_CONSTRAINT = ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT;
                        final boolean b = s == match_CONSTRAINT && constraintWidget.w != 1 && s2 == match_CONSTRAINT && constraintWidget.x != 1;
                        int n5 = 0;
                        Label_0339: {
                            int n2 = 0;
                            Label_0337: {
                                if ((n2 = (b ? 1 : 0)) == 0) {
                                    n2 = (b ? 1 : 0);
                                    if (d.Q1(1)) {
                                        n2 = (b ? 1 : 0);
                                        if (!(constraintWidget instanceof g)) {
                                            int n3 = b ? 1 : 0;
                                            if (s == match_CONSTRAINT) {
                                                n3 = (b ? 1 : 0);
                                                if (constraintWidget.w == 0) {
                                                    n3 = (b ? 1 : 0);
                                                    if (s2 != match_CONSTRAINT) {
                                                        n3 = (b ? 1 : 0);
                                                        if (!constraintWidget.g0()) {
                                                            n3 = 1;
                                                        }
                                                    }
                                                }
                                            }
                                            int n4 = n3;
                                            if (s2 == match_CONSTRAINT) {
                                                n4 = n3;
                                                if (constraintWidget.x == 0) {
                                                    n4 = n3;
                                                    if (s != match_CONSTRAINT) {
                                                        n4 = n3;
                                                        if (!constraintWidget.g0()) {
                                                            n4 = 1;
                                                        }
                                                    }
                                                }
                                            }
                                            if (s != match_CONSTRAINT) {
                                                n2 = n4;
                                                if (s2 != match_CONSTRAINT) {
                                                    break Label_0337;
                                                }
                                            }
                                            n2 = n4;
                                            if (constraintWidget.d0 > 0.0f) {
                                                n5 = n;
                                                break Label_0339;
                                            }
                                        }
                                    }
                                }
                            }
                            n5 = n2;
                        }
                        if (n5 == 0) {
                            this.a(g1, constraintWidget, androidx.constraintlayout.core.widgets.analyzer.b.a.k);
                        }
                    }
                }
            }
        }
        g1.a();
    }
    
    private void c(final d d, final String s, final int n, final int n2, final int n3) {
        final int g = d.G();
        final int f = d.F();
        d.X0(0);
        d.W0(0);
        d.h1(n2);
        d.I0(n3);
        d.X0(g);
        d.W0(f);
        this.c.U1(n);
        this.c.p1();
    }
    
    public long d(final d d, int n, int n2, int h1, int n3, int u, int i, int n4, int n5, int size) {
        final b g1 = d.G1();
        size = d.L0.size();
        final int u2 = d.U();
        final int v = d.v();
        final boolean b = f.b(n, 128);
        if (!b && !f.b(n, 64)) {
            n = 0;
        }
        else {
            n = 1;
        }
        h1 = n;
        Label_0238: {
            if (n != 0) {
                n2 = 0;
                while (true) {
                    h1 = n;
                    if (n2 >= size) {
                        break Label_0238;
                    }
                    final ConstraintWidget constraintWidget = d.L0.get(n2);
                    final ConstraintWidget.DimensionBehaviour y = constraintWidget.y();
                    final ConstraintWidget.DimensionBehaviour match_CONSTRAINT = ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT;
                    if (y == match_CONSTRAINT) {
                        h1 = 1;
                    }
                    else {
                        h1 = 0;
                    }
                    if (constraintWidget.R() == match_CONSTRAINT) {
                        n5 = 1;
                    }
                    else {
                        n5 = 0;
                    }
                    if (h1 != 0 && n5 != 0 && constraintWidget.t() > 0.0f) {
                        h1 = 1;
                    }
                    else {
                        h1 = 0;
                    }
                    if (constraintWidget.g0() && h1 != 0) {
                        break;
                    }
                    if (constraintWidget.i0() && h1 != 0) {
                        break;
                    }
                    if (constraintWidget instanceof g) {
                        break;
                    }
                    if (constraintWidget.g0()) {
                        break;
                    }
                    if (constraintWidget.i0()) {
                        break;
                    }
                    ++n2;
                }
                h1 = 0;
            }
        }
        if (h1 != 0) {
            final boolean r = androidx.constraintlayout.core.d.r;
        }
        if ((n3 == 1073741824 && i == 1073741824) || b) {
            n = 1;
        }
        else {
            n = 0;
        }
        final int n6 = h1 & n;
        boolean b3;
        if (n6 != 0) {
            n = Math.min(d.E(), u);
            n2 = Math.min(d.D(), n4);
            if (n3 == 1073741824 && d.U() != n) {
                d.h1(n);
                d.J1();
            }
            if (i == 1073741824 && d.v() != n2) {
                d.I0(n2);
                d.J1();
            }
            boolean b2;
            if (n3 == 1073741824 && i == 1073741824) {
                b2 = d.C1(b);
                n = 2;
            }
            else {
                b2 = d.D1(b);
                if (n3 == 1073741824) {
                    b2 &= d.E1(b, 0);
                    n = 1;
                }
                else {
                    n = 0;
                }
                if (i == 1073741824) {
                    b2 &= d.E1(b, 1);
                    ++n;
                }
            }
            b3 = b2;
            n2 = n;
            if (b2) {
                d.m1(n3 == 1073741824, i == 1073741824);
                b3 = b2;
                n2 = n;
            }
        }
        else {
            b3 = false;
            n2 = 0;
        }
        if (!b3 || n2 != 2) {
            h1 = d.H1();
            if (size > 0) {
                this.b(d);
            }
            this.e(d);
            n4 = this.a.size();
            if (size > 0) {
                this.c(d, "First pass", 0, u2, v);
            }
            if (n4 > 0) {
                final ConstraintWidget.DimensionBehaviour y2 = d.y();
                final ConstraintWidget.DimensionBehaviour wrap_CONTENT = ConstraintWidget.DimensionBehaviour.WRAP_CONTENT;
                if (y2 == wrap_CONTENT) {
                    n5 = 1;
                }
                else {
                    n5 = 0;
                }
                if (d.R() == wrap_CONTENT) {
                    size = 1;
                }
                else {
                    size = 0;
                }
                n2 = Math.max(d.U(), this.c.G());
                n = Math.max(d.v(), this.c.F());
                i = 0;
                n3 = 0;
                while (i < n4) {
                    final ConstraintWidget constraintWidget2 = this.a.get(i);
                    if (!(constraintWidget2 instanceof g)) {
                        u = n3;
                    }
                    else {
                        u = constraintWidget2.U();
                        final int v2 = constraintWidget2.v();
                        final boolean a = this.a(g1, constraintWidget2, androidx.constraintlayout.core.widgets.analyzer.b.a.l);
                        final int u3 = constraintWidget2.U();
                        final int v3 = constraintWidget2.v();
                        if (u3 != u) {
                            constraintWidget2.h1(u3);
                            n3 = n2;
                            if (n5 != 0 && constraintWidget2.K() > (n3 = n2)) {
                                n3 = Math.max(n2, constraintWidget2.K() + constraintWidget2.m(ConstraintAnchor.Type.RIGHT).e());
                            }
                            u = 1;
                            n2 = n3;
                        }
                        else {
                            u = ((a ? 1 : 0) | n3);
                        }
                        n3 = n;
                        if (v3 != v2) {
                            constraintWidget2.I0(v3);
                            n3 = n;
                            if (size != 0 && constraintWidget2.p() > (n3 = n)) {
                                n3 = Math.max(n, constraintWidget2.p() + constraintWidget2.m(ConstraintAnchor.Type.BOTTOM).e());
                            }
                            u = 1;
                        }
                        u |= (((g)constraintWidget2).s1() ? 1 : 0);
                        n = n3;
                    }
                    ++i;
                    n3 = u;
                }
                final int n7 = 0;
                i = n3;
                n3 = n4;
                u = n6;
                int j = n7;
                while (j < 2) {
                    int n9;
                    for (int k = 0; k < n3; ++k, n2 = n9, i = n4) {
                        final ConstraintWidget constraintWidget3 = this.a.get(k);
                        if (!(constraintWidget3 instanceof r.a) || constraintWidget3 instanceof g) {
                            if (!(constraintWidget3 instanceof e)) {
                                if (constraintWidget3.T() != 8) {
                                    if (u == 0 || !constraintWidget3.e.e.j || !constraintWidget3.f.e.j) {
                                        if (!(constraintWidget3 instanceof g)) {
                                            final int u4 = constraintWidget3.U();
                                            final int v4 = constraintWidget3.v();
                                            final int n8 = constraintWidget3.n();
                                            n4 = androidx.constraintlayout.core.widgets.analyzer.b.a.l;
                                            if (j == 1) {
                                                n4 = androidx.constraintlayout.core.widgets.analyzer.b.a.m;
                                            }
                                            n4 = ((this.a(g1, constraintWidget3, n4) ? 1 : 0) | i);
                                            final int u5 = constraintWidget3.U();
                                            final int v5 = constraintWidget3.v();
                                            i = n2;
                                            if (u5 != u4) {
                                                constraintWidget3.h1(u5);
                                                i = n2;
                                                if (n5 != 0 && constraintWidget3.K() > (i = n2)) {
                                                    i = Math.max(n2, constraintWidget3.K() + constraintWidget3.m(ConstraintAnchor.Type.RIGHT).e());
                                                }
                                                n4 = 1;
                                            }
                                            n2 = n;
                                            if (v5 != v4) {
                                                constraintWidget3.I0(v5);
                                                n2 = n;
                                                if (size != 0 && constraintWidget3.p() > (n2 = n)) {
                                                    n2 = Math.max(n, constraintWidget3.p() + constraintWidget3.m(ConstraintAnchor.Type.BOTTOM).e());
                                                }
                                                n4 = 1;
                                            }
                                            if (constraintWidget3.X() && n8 != constraintWidget3.n()) {
                                                n4 = 1;
                                                n9 = i;
                                                n = n2;
                                                continue;
                                            }
                                            n = n2;
                                            n9 = i;
                                            continue;
                                        }
                                    }
                                }
                            }
                        }
                        n9 = n2;
                        n4 = i;
                    }
                    if (i == 0) {
                        break;
                    }
                    ++j;
                    this.c(d, "intermediate pass", j, u2, v);
                    i = 0;
                }
            }
            d.T1(h1);
        }
        return 0L;
    }
    
    public void e(final d d) {
        this.a.clear();
        for (int size = d.L0.size(), i = 0; i < size; ++i) {
            final ConstraintWidget constraintWidget = d.L0.get(i);
            final ConstraintWidget.DimensionBehaviour y = constraintWidget.y();
            final ConstraintWidget.DimensionBehaviour match_CONSTRAINT = ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT;
            if (y == match_CONSTRAINT || constraintWidget.R() == match_CONSTRAINT) {
                this.a.add(constraintWidget);
            }
        }
        d.J1();
    }
    
    public static class a
    {
        public static int k = 0;
        public static int l = 1;
        public static int m = 2;
        public ConstraintWidget.DimensionBehaviour a;
        public ConstraintWidget.DimensionBehaviour b;
        public int c;
        public int d;
        public int e;
        public int f;
        public int g;
        public boolean h;
        public boolean i;
        public int j;
    }
    
    public interface b
    {
        void a();
        
        void b(final ConstraintWidget p0, final a p1);
    }
}
