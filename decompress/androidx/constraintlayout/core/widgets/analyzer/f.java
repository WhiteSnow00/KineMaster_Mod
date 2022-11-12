// 
// Decompiled by Procyon v0.6.0
// 

package androidx.constraintlayout.core.widgets.analyzer;

import java.util.ArrayList;
import androidx.constraintlayout.core.widgets.a;
import java.util.Iterator;
import androidx.constraintlayout.core.widgets.e;
import androidx.constraintlayout.core.widgets.ConstraintAnchor;
import androidx.constraintlayout.core.widgets.d;
import androidx.constraintlayout.core.widgets.ConstraintWidget;

public class f
{
    private static b.a a;
    private static int b;
    private static int c;
    
    static {
        f.a = new b.a();
        f.b = 0;
        f.c = 0;
    }
    
    private static boolean a(int n, final ConstraintWidget constraintWidget) {
        final ConstraintWidget.DimensionBehaviour y = constraintWidget.y();
        final ConstraintWidget.DimensionBehaviour r = constraintWidget.R();
        d d;
        if (constraintWidget.I() != null) {
            d = (d)constraintWidget.I();
        }
        else {
            d = null;
        }
        if (d != null) {
            d.y();
            final ConstraintWidget.DimensionBehaviour fixed = ConstraintWidget.DimensionBehaviour.FIXED;
        }
        if (d != null) {
            d.R();
            final ConstraintWidget.DimensionBehaviour fixed2 = ConstraintWidget.DimensionBehaviour.FIXED;
        }
        final ConstraintWidget.DimensionBehaviour fixed3 = ConstraintWidget.DimensionBehaviour.FIXED;
        final boolean b = false;
        Label_0169: {
            if (y != fixed3 && !constraintWidget.l0() && y != ConstraintWidget.DimensionBehaviour.WRAP_CONTENT) {
                final ConstraintWidget.DimensionBehaviour match_CONSTRAINT = ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT;
                if (y != match_CONSTRAINT || constraintWidget.w != 0 || constraintWidget.d0 != 0.0f || !constraintWidget.Y(0)) {
                    if (y != match_CONSTRAINT || constraintWidget.w != 1 || !constraintWidget.b0(0, constraintWidget.U())) {
                        n = 0;
                        break Label_0169;
                    }
                }
            }
            n = 1;
        }
        boolean b2 = false;
        Label_0264: {
            if (r != fixed3 && !constraintWidget.m0() && r != ConstraintWidget.DimensionBehaviour.WRAP_CONTENT) {
                final ConstraintWidget.DimensionBehaviour match_CONSTRAINT2 = ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT;
                if (r != match_CONSTRAINT2 || constraintWidget.x != 0 || constraintWidget.d0 != 0.0f || !constraintWidget.Y(1)) {
                    if (r != match_CONSTRAINT2 || constraintWidget.x != 1 || !constraintWidget.b0(1, constraintWidget.v())) {
                        b2 = false;
                        break Label_0264;
                    }
                }
            }
            b2 = true;
        }
        if (constraintWidget.d0 > 0.0f && (n != 0 || b2)) {
            return true;
        }
        boolean b3 = b;
        if (n != 0) {
            b3 = b;
            if (b2) {
                b3 = true;
            }
        }
        return b3;
    }
    
    private static void b(final int n, final ConstraintWidget constraintWidget, final b.b b, final boolean b2) {
        if (constraintWidget.e0()) {
            return;
        }
        ++f.b;
        if (!(constraintWidget instanceof d) && constraintWidget.k0()) {
            final int n2 = n + 1;
            if (a(n2, constraintWidget)) {
                d.P1(n2, constraintWidget, b, new b.a(), androidx.constraintlayout.core.widgets.analyzer.b.a.k);
            }
        }
        final ConstraintAnchor m = constraintWidget.m(ConstraintAnchor.Type.LEFT);
        final ConstraintAnchor i = constraintWidget.m(ConstraintAnchor.Type.RIGHT);
        final int d = m.d();
        final int d2 = i.d();
        if (m.c() != null && m.m()) {
            for (final ConstraintAnchor constraintAnchor : m.c()) {
                final ConstraintWidget d3 = constraintAnchor.d;
                final int n3 = n + 1;
                final boolean a = a(n3, d3);
                if (d3.k0() && a) {
                    androidx.constraintlayout.core.widgets.d.P1(n3, d3, b, new b.a(), androidx.constraintlayout.core.widgets.analyzer.b.a.k);
                }
                boolean b3 = false;
                Label_0270: {
                    Label_0261: {
                        if (constraintAnchor == d3.O) {
                            final ConstraintAnchor f = d3.Q.f;
                            if (f != null && f.m()) {
                                break Label_0261;
                            }
                        }
                        if (constraintAnchor == d3.Q) {
                            final ConstraintAnchor f2 = d3.O.f;
                            if (f2 != null && f2.m()) {
                                break Label_0261;
                            }
                        }
                        b3 = false;
                        break Label_0270;
                    }
                    b3 = true;
                }
                final ConstraintWidget.DimensionBehaviour y = d3.y();
                final ConstraintWidget.DimensionBehaviour match_CONSTRAINT = ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT;
                if (y == match_CONSTRAINT && !a) {
                    if (d3.y() != match_CONSTRAINT || d3.A < 0 || d3.z < 0 || (d3.T() != 8 && (d3.w != 0 || d3.t() != 0.0f)) || d3.g0() || d3.j0() || !b3 || d3.g0()) {
                        continue;
                    }
                    e(n3, constraintWidget, b, d3, b2);
                }
                else {
                    if (d3.k0()) {
                        continue;
                    }
                    final ConstraintAnchor o = d3.O;
                    if (constraintAnchor == o && d3.Q.f == null) {
                        final int n4 = o.e() + d;
                        d3.C0(n4, d3.U() + n4);
                        b(n3, d3, b, b2);
                    }
                    else {
                        final ConstraintAnchor q = d3.Q;
                        if (constraintAnchor == q && o.f == null) {
                            final int n5 = d - q.e();
                            d3.C0(n5 - d3.U(), n5);
                            b(n3, d3, b, b2);
                        }
                        else {
                            if (!b3 || d3.g0()) {
                                continue;
                            }
                            d(n3, b, d3, b2);
                        }
                    }
                }
            }
        }
        if (constraintWidget instanceof e) {
            return;
        }
        if (i.c() != null && i.m()) {
            for (final ConstraintAnchor constraintAnchor2 : i.c()) {
                final ConstraintWidget d4 = constraintAnchor2.d;
                final int n6 = n + 1;
                final boolean a2 = a(n6, d4);
                if (d4.k0() && a2) {
                    androidx.constraintlayout.core.widgets.d.P1(n6, d4, b, new b.a(), androidx.constraintlayout.core.widgets.analyzer.b.a.k);
                }
                boolean b4 = false;
                Label_0734: {
                    Label_0725: {
                        if (constraintAnchor2 == d4.O) {
                            final ConstraintAnchor f3 = d4.Q.f;
                            if (f3 != null && f3.m()) {
                                break Label_0725;
                            }
                        }
                        if (constraintAnchor2 == d4.Q) {
                            final ConstraintAnchor f4 = d4.O.f;
                            if (f4 != null && f4.m()) {
                                break Label_0725;
                            }
                        }
                        b4 = false;
                        break Label_0734;
                    }
                    b4 = true;
                }
                final ConstraintWidget.DimensionBehaviour y2 = d4.y();
                final ConstraintWidget.DimensionBehaviour match_CONSTRAINT2 = ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT;
                if (y2 == match_CONSTRAINT2 && !a2) {
                    if (d4.y() != match_CONSTRAINT2 || d4.A < 0 || d4.z < 0 || (d4.T() != 8 && (d4.w != 0 || d4.t() != 0.0f)) || d4.g0() || d4.j0() || !b4 || d4.g0()) {
                        continue;
                    }
                    e(n6, constraintWidget, b, d4, b2);
                }
                else {
                    if (d4.k0()) {
                        continue;
                    }
                    final ConstraintAnchor o2 = d4.O;
                    if (constraintAnchor2 == o2 && d4.Q.f == null) {
                        final int n7 = o2.e() + d2;
                        d4.C0(n7, d4.U() + n7);
                        b(n6, d4, b, b2);
                    }
                    else {
                        final ConstraintAnchor q2 = d4.Q;
                        if (constraintAnchor2 == q2 && o2.f == null) {
                            final int n8 = d2 - q2.e();
                            d4.C0(n8 - d4.U(), n8);
                            b(n6, d4, b, b2);
                        }
                        else {
                            if (!b4 || d4.g0()) {
                                continue;
                            }
                            d(n6, b, d4, b2);
                        }
                    }
                }
            }
        }
        constraintWidget.o0();
    }
    
    private static void c(final int n, final a a, final b.b b, final int n2, final boolean b2) {
        if (a.q1()) {
            if (n2 == 0) {
                b(n + 1, a, b, b2);
            }
            else {
                i(n + 1, a, b);
            }
        }
    }
    
    private static void d(final int n, final b.b b, final ConstraintWidget constraintWidget, final boolean b2) {
        float w = constraintWidget.w();
        int d = constraintWidget.O.f.d();
        int d2 = constraintWidget.Q.f.d();
        final int e = constraintWidget.O.e();
        final int e2 = constraintWidget.Q.e();
        if (d == d2) {
            w = 0.5f;
        }
        else {
            d += e;
            d2 -= e2;
        }
        final int u = constraintWidget.U();
        int n2 = d2 - d - u;
        if (d > d2) {
            n2 = d - d2 - u;
        }
        float n3;
        if (n2 > 0) {
            n3 = w * n2 + 0.5f;
        }
        else {
            n3 = w * n2;
        }
        final int n4 = (int)n3 + d;
        int n5 = n4 + u;
        if (d > d2) {
            n5 = n4 - u;
        }
        constraintWidget.C0(n4, n5);
        b(n + 1, constraintWidget, b, b2);
    }
    
    private static void e(final int n, final ConstraintWidget constraintWidget, final b.b b, final ConstraintWidget constraintWidget2, final boolean b2) {
        final float w = constraintWidget2.w();
        final int n2 = constraintWidget2.O.f.d() + constraintWidget2.O.e();
        final int n3 = constraintWidget2.Q.f.d() - constraintWidget2.Q.e();
        if (n3 >= n2) {
            int n5;
            final int n4 = n5 = constraintWidget2.U();
            if (constraintWidget2.T() != 8) {
                final int w2 = constraintWidget2.w;
                int n7;
                if (w2 == 2) {
                    int n6;
                    if (constraintWidget instanceof d) {
                        n6 = constraintWidget.U();
                    }
                    else {
                        n6 = constraintWidget.I().U();
                    }
                    n7 = (int)(constraintWidget2.w() * 0.5f * n6);
                }
                else {
                    n7 = n4;
                    if (w2 == 0) {
                        n7 = n3 - n2;
                    }
                }
                final int max = Math.max(constraintWidget2.z, n7);
                final int a = constraintWidget2.A;
                n5 = max;
                if (a > 0) {
                    n5 = Math.min(a, max);
                }
            }
            final int n8 = n2 + (int)(w * (n3 - n2 - n5) + 0.5f);
            constraintWidget2.C0(n8, n5 + n8);
            b(n + 1, constraintWidget2, b, b2);
        }
    }
    
    private static void f(final int n, final b.b b, final ConstraintWidget constraintWidget) {
        float p3 = constraintWidget.P();
        int d = constraintWidget.P.f.d();
        int d2 = constraintWidget.R.f.d();
        final int e = constraintWidget.P.e();
        final int e2 = constraintWidget.R.e();
        if (d == d2) {
            p3 = 0.5f;
        }
        else {
            d += e;
            d2 -= e2;
        }
        final int v = constraintWidget.v();
        int n2 = d2 - d - v;
        if (d > d2) {
            n2 = d - d2 - v;
        }
        float n3;
        if (n2 > 0) {
            n3 = p3 * n2 + 0.5f;
        }
        else {
            n3 = p3 * n2;
        }
        final int n4 = (int)n3;
        int n5 = d + n4;
        int n6 = n5 + v;
        if (d > d2) {
            n5 = d - n4;
            n6 = n5 - v;
        }
        constraintWidget.F0(n5, n6);
        i(n + 1, constraintWidget, b);
    }
    
    private static void g(final int n, final ConstraintWidget constraintWidget, final b.b b, final ConstraintWidget constraintWidget2) {
        final float p4 = constraintWidget2.P();
        final int n2 = constraintWidget2.P.f.d() + constraintWidget2.P.e();
        final int n3 = constraintWidget2.R.f.d() - constraintWidget2.R.e();
        if (n3 >= n2) {
            int n5;
            final int n4 = n5 = constraintWidget2.v();
            if (constraintWidget2.T() != 8) {
                final int x = constraintWidget2.x;
                int n7;
                if (x == 2) {
                    int n6;
                    if (constraintWidget instanceof d) {
                        n6 = constraintWidget.v();
                    }
                    else {
                        n6 = constraintWidget.I().v();
                    }
                    n7 = (int)(p4 * 0.5f * n6);
                }
                else {
                    n7 = n4;
                    if (x == 0) {
                        n7 = n3 - n2;
                    }
                }
                final int max = Math.max(constraintWidget2.C, n7);
                final int d = constraintWidget2.D;
                n5 = max;
                if (d > 0) {
                    n5 = Math.min(d, max);
                }
            }
            final int n8 = n2 + (int)(p4 * (n3 - n2 - n5) + 0.5f);
            constraintWidget2.F0(n8, n5 + n8);
            i(n + 1, constraintWidget2, b);
        }
    }
    
    public static void h(final d d, final b.b b) {
        final ConstraintWidget.DimensionBehaviour y = d.y();
        final ConstraintWidget.DimensionBehaviour r = d.R();
        f.b = 0;
        f.c = 0;
        d.s0();
        final ArrayList<ConstraintWidget> o1 = d.o1();
        final int size = o1.size();
        for (int i = 0; i < size; ++i) {
            ((ConstraintWidget)o1.get(i)).s0();
        }
        final boolean m1 = d.M1();
        if (y == ConstraintWidget.DimensionBehaviour.FIXED) {
            d.C0(0, d.U());
        }
        else {
            d.D0(0);
        }
        int j = 0;
        int n2;
        int n = n2 = 0;
        while (j < size) {
            final ConstraintWidget constraintWidget = o1.get(j);
            int n3;
            int n4;
            if (constraintWidget instanceof e) {
                final e e = (e)constraintWidget;
                n3 = n;
                n4 = n2;
                if (e.p1() == 1) {
                    if (e.q1() != -1) {
                        e.t1(e.q1());
                    }
                    else if (e.r1() != -1 && d.l0()) {
                        e.t1(d.U() - e.r1());
                    }
                    else if (d.l0()) {
                        e.t1((int)(e.s1() * d.U() + 0.5f));
                    }
                    n3 = 1;
                    n4 = n2;
                }
            }
            else {
                n3 = n;
                n4 = n2;
                if (constraintWidget instanceof a) {
                    n3 = n;
                    n4 = n2;
                    if (((a)constraintWidget).u1() == 0) {
                        n4 = 1;
                        n3 = n;
                    }
                }
            }
            ++j;
            n = n3;
            n2 = n4;
        }
        if (n != 0) {
            for (int k = 0; k < size; ++k) {
                final ConstraintWidget constraintWidget2 = o1.get(k);
                if (constraintWidget2 instanceof e) {
                    final e e2 = (e)constraintWidget2;
                    if (e2.p1() == 1) {
                        b(0, e2, b, m1);
                    }
                }
            }
        }
        b(0, d, b, m1);
        if (n2 != 0) {
            for (int l = 0; l < size; ++l) {
                final ConstraintWidget constraintWidget3 = o1.get(l);
                if (constraintWidget3 instanceof a) {
                    final a a = (a)constraintWidget3;
                    if (a.u1() == 0) {
                        c(0, a, b, 0, m1);
                    }
                }
            }
        }
        if (r == ConstraintWidget.DimensionBehaviour.FIXED) {
            d.F0(0, d.v());
        }
        else {
            d.E0(0);
        }
        int n5 = 0;
        int n7;
        int n6 = n7 = 0;
        while (n5 < size) {
            final ConstraintWidget constraintWidget4 = o1.get(n5);
            int n8;
            int n9;
            if (constraintWidget4 instanceof e) {
                final e e3 = (e)constraintWidget4;
                n8 = n6;
                n9 = n7;
                if (e3.p1() == 0) {
                    if (e3.q1() != -1) {
                        e3.t1(e3.q1());
                    }
                    else if (e3.r1() != -1 && d.m0()) {
                        e3.t1(d.v() - e3.r1());
                    }
                    else if (d.m0()) {
                        e3.t1((int)(e3.s1() * d.v() + 0.5f));
                    }
                    n8 = 1;
                    n9 = n7;
                }
            }
            else {
                n8 = n6;
                n9 = n7;
                if (constraintWidget4 instanceof a) {
                    n8 = n6;
                    n9 = n7;
                    if (((a)constraintWidget4).u1() == 1) {
                        n9 = 1;
                        n8 = n6;
                    }
                }
            }
            ++n5;
            n6 = n8;
            n7 = n9;
        }
        if (n6 != 0) {
            for (int n10 = 0; n10 < size; ++n10) {
                final ConstraintWidget constraintWidget5 = o1.get(n10);
                if (constraintWidget5 instanceof e) {
                    final e e4 = (e)constraintWidget5;
                    if (e4.p1() == 0) {
                        i(1, e4, b);
                    }
                }
            }
        }
        i(0, d, b);
        if (n7 != 0) {
            for (int n11 = 0; n11 < size; ++n11) {
                final ConstraintWidget constraintWidget6 = o1.get(n11);
                if (constraintWidget6 instanceof a) {
                    final a a2 = (a)constraintWidget6;
                    if (a2.u1() == 1) {
                        c(0, a2, b, 1, m1);
                    }
                }
            }
        }
        for (int n12 = 0; n12 < size; ++n12) {
            final ConstraintWidget constraintWidget7 = o1.get(n12);
            if (constraintWidget7.k0() && a(0, constraintWidget7)) {
                d.P1(0, constraintWidget7, b, f.a, androidx.constraintlayout.core.widgets.analyzer.b.a.k);
                if (constraintWidget7 instanceof e) {
                    if (((e)constraintWidget7).p1() == 0) {
                        i(0, constraintWidget7, b);
                    }
                    else {
                        b(0, constraintWidget7, b, m1);
                    }
                }
                else {
                    b(0, constraintWidget7, b, m1);
                    i(0, constraintWidget7, b);
                }
            }
        }
    }
    
    private static void i(final int n, final ConstraintWidget constraintWidget, final b.b b) {
        if (constraintWidget.n0()) {
            return;
        }
        ++f.c;
        if (!(constraintWidget instanceof d) && constraintWidget.k0()) {
            final int n2 = n + 1;
            if (a(n2, constraintWidget)) {
                d.P1(n2, constraintWidget, b, new b.a(), androidx.constraintlayout.core.widgets.analyzer.b.a.k);
            }
        }
        final ConstraintAnchor m = constraintWidget.m(ConstraintAnchor.Type.TOP);
        final ConstraintAnchor i = constraintWidget.m(ConstraintAnchor.Type.BOTTOM);
        final int d = m.d();
        final int d2 = i.d();
        if (m.c() != null && m.m()) {
            for (final ConstraintAnchor constraintAnchor : m.c()) {
                final ConstraintWidget d3 = constraintAnchor.d;
                final int n3 = n + 1;
                final boolean a = a(n3, d3);
                if (d3.k0() && a) {
                    androidx.constraintlayout.core.widgets.d.P1(n3, d3, b, new b.a(), androidx.constraintlayout.core.widgets.analyzer.b.a.k);
                }
                boolean b2 = false;
                Label_0265: {
                    Label_0258: {
                        if (constraintAnchor == d3.P) {
                            final ConstraintAnchor f = d3.R.f;
                            if (f != null && f.m()) {
                                break Label_0258;
                            }
                        }
                        if (constraintAnchor == d3.R) {
                            final ConstraintAnchor f2 = d3.P.f;
                            if (f2 != null && f2.m()) {
                                break Label_0258;
                            }
                        }
                        b2 = false;
                        break Label_0265;
                    }
                    b2 = true;
                }
                final ConstraintWidget.DimensionBehaviour r = d3.R();
                final ConstraintWidget.DimensionBehaviour match_CONSTRAINT = ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT;
                if (r == match_CONSTRAINT && !a) {
                    if (d3.R() != match_CONSTRAINT || d3.D < 0 || d3.C < 0 || (d3.T() != 8 && (d3.x != 0 || d3.t() != 0.0f)) || d3.i0() || d3.j0() || !b2 || d3.i0()) {
                        continue;
                    }
                    g(n3, constraintWidget, b, d3);
                }
                else {
                    if (d3.k0()) {
                        continue;
                    }
                    final ConstraintAnchor p3 = d3.P;
                    if (constraintAnchor == p3 && d3.R.f == null) {
                        final int n4 = p3.e() + d;
                        d3.F0(n4, d3.v() + n4);
                        i(n3, d3, b);
                    }
                    else {
                        final ConstraintAnchor r2 = d3.R;
                        if (constraintAnchor == r2 && p3.f == null) {
                            final int n5 = d - r2.e();
                            d3.F0(n5 - d3.v(), n5);
                            i(n3, d3, b);
                        }
                        else {
                            if (!b2 || d3.i0()) {
                                continue;
                            }
                            f(n3, b, d3);
                        }
                    }
                }
            }
        }
        if (constraintWidget instanceof e) {
            return;
        }
        if (i.c() != null && i.m()) {
            for (final ConstraintAnchor constraintAnchor2 : i.c()) {
                final ConstraintWidget d4 = constraintAnchor2.d;
                final int n6 = n + 1;
                final boolean a2 = a(n6, d4);
                if (d4.k0() && a2) {
                    androidx.constraintlayout.core.widgets.d.P1(n6, d4, b, new b.a(), androidx.constraintlayout.core.widgets.analyzer.b.a.k);
                }
                boolean b3 = false;
                Label_0715: {
                    Label_0708: {
                        if (constraintAnchor2 == d4.P) {
                            final ConstraintAnchor f3 = d4.R.f;
                            if (f3 != null && f3.m()) {
                                break Label_0708;
                            }
                        }
                        if (constraintAnchor2 == d4.R) {
                            final ConstraintAnchor f4 = d4.P.f;
                            if (f4 != null && f4.m()) {
                                break Label_0708;
                            }
                        }
                        b3 = false;
                        break Label_0715;
                    }
                    b3 = true;
                }
                final ConstraintWidget.DimensionBehaviour r3 = d4.R();
                final ConstraintWidget.DimensionBehaviour match_CONSTRAINT2 = ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT;
                if (r3 == match_CONSTRAINT2 && !a2) {
                    if (d4.R() != match_CONSTRAINT2 || d4.D < 0 || d4.C < 0 || (d4.T() != 8 && (d4.x != 0 || d4.t() != 0.0f)) || d4.i0() || d4.j0() || !b3 || d4.i0()) {
                        continue;
                    }
                    g(n6, constraintWidget, b, d4);
                }
                else {
                    if (d4.k0()) {
                        continue;
                    }
                    final ConstraintAnchor p4 = d4.P;
                    if (constraintAnchor2 == p4 && d4.R.f == null) {
                        final int n7 = p4.e() + d2;
                        d4.F0(n7, d4.v() + n7);
                        i(n6, d4, b);
                    }
                    else {
                        final ConstraintAnchor r4 = d4.R;
                        if (constraintAnchor2 == r4 && p4.f == null) {
                            final int n8 = d2 - r4.e();
                            d4.F0(n8 - d4.v(), n8);
                            i(n6, d4, b);
                        }
                        else {
                            if (!b3 || d4.i0()) {
                                continue;
                            }
                            f(n6, b, d4);
                        }
                    }
                }
            }
        }
        final ConstraintAnchor j = constraintWidget.m(ConstraintAnchor.Type.BASELINE);
        if (j.c() != null && j.m()) {
            final int d5 = j.d();
            for (final ConstraintAnchor constraintAnchor3 : j.c()) {
                final ConstraintWidget d6 = constraintAnchor3.d;
                final int n9 = n + 1;
                final boolean a3 = a(n9, d6);
                if (d6.k0() && a3) {
                    androidx.constraintlayout.core.widgets.d.P1(n9, d6, b, new b.a(), androidx.constraintlayout.core.widgets.analyzer.b.a.k);
                }
                if (d6.R() != ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT || a3) {
                    if (d6.k0()) {
                        continue;
                    }
                    if (constraintAnchor3 != d6.S) {
                        continue;
                    }
                    d6.B0(constraintAnchor3.e() + d5);
                    i(n9, d6, b);
                }
            }
        }
        constraintWidget.p0();
    }
}
