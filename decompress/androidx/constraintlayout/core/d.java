// 
// Decompiled by Procyon v0.6.0
// 

package androidx.constraintlayout.core;

import androidx.constraintlayout.core.widgets.ConstraintAnchor;
import androidx.constraintlayout.core.widgets.ConstraintWidget;
import n.a;
import java.util.Arrays;
import java.util.HashMap;

public class d
{
    public static boolean r = false;
    public static boolean s = true;
    public static boolean t = true;
    public static boolean u = true;
    public static boolean v = false;
    private static int w = 1000;
    public static long x;
    public static long y;
    public boolean a;
    int b;
    private HashMap<String, SolverVariable> c;
    private a d;
    private int e;
    private int f;
    androidx.constraintlayout.core.b[] g;
    public boolean h;
    public boolean i;
    private boolean[] j;
    int k;
    int l;
    private int m;
    final c n;
    private SolverVariable[] o;
    private int p;
    private a q;
    
    public d() {
        this.a = false;
        this.b = 0;
        this.c = null;
        this.e = 32;
        this.f = 32;
        this.g = null;
        this.h = false;
        this.i = false;
        this.j = new boolean[32];
        this.k = 1;
        this.l = 0;
        this.m = 32;
        this.o = new SolverVariable[androidx.constraintlayout.core.d.w];
        this.p = 0;
        this.g = new androidx.constraintlayout.core.b[32];
        this.D();
        final c n = new c();
        this.n = n;
        this.d = (a)new g(n);
        if (androidx.constraintlayout.core.d.v) {
            this.q = (a)new b(n);
        }
        else {
            this.q = (a)new androidx.constraintlayout.core.b(n);
        }
    }
    
    private final int C(final a a, final boolean b) {
        for (int i = 0; i < this.k; ++i) {
            this.j[i] = false;
        }
        int j = 0;
        int n = 0;
        while (j == 0) {
            final int n2 = n + 1;
            if (n2 >= this.k * 2) {
                return n2;
            }
            if (a.getKey() != null) {
                this.j[a.getKey().c] = true;
            }
            final SolverVariable b2 = a.b(this, this.j);
            if (b2 != null) {
                final boolean[] k = this.j;
                final int c = b2.c;
                if (k[c]) {
                    return n2;
                }
                k[c] = true;
            }
            if (b2 != null) {
                float n3 = Float.MAX_VALUE;
                int l = 0;
                int d = -1;
                while (l < this.l) {
                    final androidx.constraintlayout.core.b b3 = this.g[l];
                    float n4;
                    int n5;
                    if (b3.a.j == SolverVariable.Type.UNRESTRICTED) {
                        n4 = n3;
                        n5 = d;
                    }
                    else if (b3.f) {
                        n4 = n3;
                        n5 = d;
                    }
                    else {
                        n4 = n3;
                        n5 = d;
                        if (b3.t(b2)) {
                            final float m = b3.e.j(b2);
                            n4 = n3;
                            n5 = d;
                            if (m < 0.0f) {
                                final float n6 = -b3.b / m;
                                n4 = n3;
                                n5 = d;
                                if (n6 < n3) {
                                    n5 = l;
                                    n4 = n6;
                                }
                            }
                        }
                    }
                    ++l;
                    n3 = n4;
                    d = n5;
                }
                n = n2;
                if (d <= -1) {
                    continue;
                }
                final androidx.constraintlayout.core.b b4 = this.g[d];
                b4.a.d = -1;
                b4.x(b2);
                final SolverVariable a2 = b4.a;
                a2.d = d;
                a2.k(this, b4);
                n = n2;
            }
            else {
                j = 1;
                n = n2;
            }
        }
        return n;
    }
    
    private void D() {
        final boolean v = androidx.constraintlayout.core.d.v;
        int i = 0;
        final int n = 0;
        if (v) {
            for (int j = n; j < this.l; ++j) {
                final androidx.constraintlayout.core.b b = this.g[j];
                if (b != null) {
                    this.n.a.b(b);
                }
                this.g[j] = null;
            }
        }
        else {
            while (i < this.l) {
                final androidx.constraintlayout.core.b b2 = this.g[i];
                if (b2 != null) {
                    this.n.b.b(b2);
                }
                this.g[i] = null;
                ++i;
            }
        }
    }
    
    private SolverVariable a(final SolverVariable.Type type, final String s) {
        final SolverVariable solverVariable = this.n.c.a();
        SolverVariable solverVariable3;
        if (solverVariable == null) {
            final SolverVariable solverVariable2 = new SolverVariable(type, s);
            solverVariable2.i(type, s);
            solverVariable3 = solverVariable2;
        }
        else {
            solverVariable.g();
            solverVariable.i(type, s);
            solverVariable3 = solverVariable;
        }
        final int p2 = this.p;
        final int w = androidx.constraintlayout.core.d.w;
        if (p2 >= w) {
            this.o = Arrays.copyOf(this.o, androidx.constraintlayout.core.d.w = w * 2);
        }
        return this.o[this.p++] = solverVariable3;
    }
    
    private final void l(androidx.constraintlayout.core.b b) {
        if (androidx.constraintlayout.core.d.t && b.f) {
            b.a.h(this, b.b);
        }
        else {
            final androidx.constraintlayout.core.b[] g = this.g;
            final int l = this.l;
            g[l] = b;
            final SolverVariable a = b.a;
            a.d = l;
            this.l = l + 1;
            a.k(this, b);
        }
        if (androidx.constraintlayout.core.d.t && this.a) {
            int n;
            for (int i = 0; i < this.l; i = n + 1) {
                if (this.g[i] == null) {
                    System.out.println("WTF");
                }
                final androidx.constraintlayout.core.b[] g2 = this.g;
                n = i;
                if (g2[i] != null) {
                    n = i;
                    if (g2[i].f) {
                        b = g2[i];
                        b.a.h(this, b.b);
                        if (androidx.constraintlayout.core.d.v) {
                            this.n.a.b(b);
                        }
                        else {
                            this.n.b.b(b);
                        }
                        this.g[i] = null;
                        int n3;
                        int n2 = n3 = i + 1;
                        int j;
                        while (true) {
                            j = this.l;
                            if (n2 >= j) {
                                break;
                            }
                            final androidx.constraintlayout.core.b[] g3 = this.g;
                            final int d = n2 - 1;
                            g3[d] = g3[n2];
                            if (g3[d].a.d == n2) {
                                g3[d].a.d = d;
                            }
                            n3 = n2;
                            ++n2;
                        }
                        if (n3 < j) {
                            this.g[n3] = null;
                        }
                        this.l = j - 1;
                        n = i - 1;
                    }
                }
            }
            this.a = false;
        }
    }
    
    private void n() {
        for (int i = 0; i < this.l; ++i) {
            final androidx.constraintlayout.core.b b = this.g[i];
            b.a.f = b.b;
        }
    }
    
    public static androidx.constraintlayout.core.b s(final d d, final SolverVariable solverVariable, final SolverVariable solverVariable2, final float n) {
        return d.r().j(solverVariable, solverVariable2, n);
    }
    
    private int u(final a a) throws Exception {
        while (true) {
            for (int i = 0; i < this.l; ++i) {
                final androidx.constraintlayout.core.b[] g = this.g;
                if (g[i].a.j != SolverVariable.Type.UNRESTRICTED) {
                    if (g[i].b < 0.0f) {
                        final boolean b = true;
                        int n;
                        if (b) {
                            int j = 0;
                            n = 0;
                            while (j == 0) {
                                final int n2 = n + 1;
                                float n3 = Float.MAX_VALUE;
                                int k = 0;
                                int d = -1;
                                int n4 = -1;
                                int n5 = 0;
                                while (k < this.l) {
                                    final androidx.constraintlayout.core.b b2 = this.g[k];
                                    float n6;
                                    int n7;
                                    int n8;
                                    int n9;
                                    if (b2.a.j == SolverVariable.Type.UNRESTRICTED) {
                                        n6 = n3;
                                        n7 = d;
                                        n8 = n4;
                                        n9 = n5;
                                    }
                                    else if (b2.f) {
                                        n6 = n3;
                                        n7 = d;
                                        n8 = n4;
                                        n9 = n5;
                                    }
                                    else {
                                        n6 = n3;
                                        n7 = d;
                                        n8 = n4;
                                        n9 = n5;
                                        if (b2.b < 0.0f) {
                                            if (androidx.constraintlayout.core.d.u) {
                                                final int f = b2.e.f();
                                                int n10 = 0;
                                                int n11 = n5;
                                                int c = n4;
                                                while (true) {
                                                    n6 = n3;
                                                    n7 = d;
                                                    n8 = c;
                                                    n9 = n11;
                                                    if (n10 >= f) {
                                                        break;
                                                    }
                                                    final SolverVariable b3 = b2.e.b(n10);
                                                    final float l = b2.e.j(b3);
                                                    float n12;
                                                    int n13;
                                                    int n14;
                                                    int n15;
                                                    if (l <= 0.0f) {
                                                        n12 = n3;
                                                        n13 = d;
                                                        n14 = c;
                                                        n15 = n11;
                                                    }
                                                    else {
                                                        final int n16 = 0;
                                                        int n17 = d;
                                                        int n18 = n16;
                                                        while (true) {
                                                            n12 = n3;
                                                            n13 = n17;
                                                            n14 = c;
                                                            n15 = n11;
                                                            if (n18 >= 9) {
                                                                break;
                                                            }
                                                            final float n19 = b3.h[n18] / l;
                                                            int n20;
                                                            if ((n19 < n3 && n18 == n11) || n18 > (n20 = n11)) {
                                                                c = b3.c;
                                                                n20 = n18;
                                                                n17 = k;
                                                                n3 = n19;
                                                            }
                                                            ++n18;
                                                            n11 = n20;
                                                        }
                                                    }
                                                    ++n10;
                                                    n3 = n12;
                                                    d = n13;
                                                    c = n14;
                                                    n11 = n15;
                                                }
                                            }
                                            else {
                                                int n21 = 1;
                                                while (true) {
                                                    n6 = n3;
                                                    n7 = d;
                                                    n8 = n4;
                                                    n9 = n5;
                                                    if (n21 >= this.k) {
                                                        break;
                                                    }
                                                    final SolverVariable solverVariable = this.n.d[n21];
                                                    final float m = b2.e.j(solverVariable);
                                                    float n22;
                                                    int n23;
                                                    int n24;
                                                    int n25;
                                                    if (m <= 0.0f) {
                                                        n22 = n3;
                                                        n23 = d;
                                                        n24 = n4;
                                                        n25 = n5;
                                                    }
                                                    else {
                                                        int n26 = 0;
                                                        while (true) {
                                                            n22 = n3;
                                                            n23 = d;
                                                            n24 = n4;
                                                            n25 = n5;
                                                            if (n26 >= 9) {
                                                                break;
                                                            }
                                                            final float n27 = solverVariable.h[n26] / m;
                                                            int n28;
                                                            if ((n27 < n3 && n26 == n5) || n26 > (n28 = n5)) {
                                                                n4 = n21;
                                                                d = k;
                                                                n28 = n26;
                                                                n3 = n27;
                                                            }
                                                            ++n26;
                                                            n5 = n28;
                                                        }
                                                    }
                                                    ++n21;
                                                    n3 = n22;
                                                    d = n23;
                                                    n4 = n24;
                                                    n5 = n25;
                                                }
                                            }
                                        }
                                    }
                                    ++k;
                                    n3 = n6;
                                    d = n7;
                                    n4 = n8;
                                    n5 = n9;
                                }
                                if (d != -1) {
                                    final androidx.constraintlayout.core.b b4 = this.g[d];
                                    b4.a.d = -1;
                                    b4.x(this.n.d[n4]);
                                    final SolverVariable a2 = b4.a;
                                    a2.d = d;
                                    a2.k(this, b4);
                                }
                                else {
                                    j = 1;
                                }
                                n = n2;
                                if (n2 > this.k / 2) {
                                    j = 1;
                                    n = n2;
                                }
                            }
                        }
                        else {
                            n = 0;
                        }
                        return n;
                    }
                }
            }
            final boolean b = false;
            continue;
        }
    }
    
    public static n.a x() {
        return null;
    }
    
    private void z() {
        final int e = this.e * 2;
        this.e = e;
        this.g = Arrays.copyOf(this.g, e);
        final c n = this.n;
        n.d = Arrays.copyOf(n.d, this.e);
        final int e2 = this.e;
        this.j = new boolean[e2];
        this.f = e2;
        this.m = e2;
    }
    
    public void A() throws Exception {
        if (this.d.isEmpty()) {
            this.n();
            return;
        }
        if (this.h || this.i) {
            final int n = 0;
            int i = 0;
            while (true) {
                while (i < this.l) {
                    if (!this.g[i].f) {
                        final int n2 = n;
                        if (n2 == 0) {
                            this.B(this.d);
                            return;
                        }
                        this.n();
                        return;
                    }
                    else {
                        ++i;
                    }
                }
                final int n2 = 1;
                continue;
            }
        }
        this.B(this.d);
    }
    
    void B(final a a) throws Exception {
        this.u(a);
        this.C(a, false);
        this.n();
    }
    
    public void E() {
        int n = 0;
        c n2;
        while (true) {
            n2 = this.n;
            final SolverVariable[] d = n2.d;
            if (n >= d.length) {
                break;
            }
            final SolverVariable solverVariable = d[n];
            if (solverVariable != null) {
                solverVariable.g();
            }
            ++n;
        }
        n2.c.c(this.o, this.p);
        this.p = 0;
        Arrays.fill(this.n.d, null);
        final HashMap<String, SolverVariable> c = this.c;
        if (c != null) {
            c.clear();
        }
        this.b = 0;
        this.d.clear();
        this.k = 1;
        for (int i = 0; i < this.l; ++i) {
            final androidx.constraintlayout.core.b[] g = this.g;
            if (g[i] != null) {
                g[i].c = false;
            }
        }
        this.D();
        this.l = 0;
        if (androidx.constraintlayout.core.d.v) {
            this.q = (a)new b(this.n);
        }
        else {
            this.q = (a)new androidx.constraintlayout.core.b(this.n);
        }
    }
    
    public void b(final ConstraintWidget constraintWidget, final ConstraintWidget constraintWidget2, final float n, final int n2) {
        final ConstraintAnchor.Type left = ConstraintAnchor.Type.LEFT;
        final SolverVariable q = this.q(constraintWidget.m(left));
        final ConstraintAnchor.Type top = ConstraintAnchor.Type.TOP;
        final SolverVariable q2 = this.q(constraintWidget.m(top));
        final ConstraintAnchor.Type right = ConstraintAnchor.Type.RIGHT;
        final SolverVariable q3 = this.q(constraintWidget.m(right));
        final ConstraintAnchor.Type bottom = ConstraintAnchor.Type.BOTTOM;
        final SolverVariable q4 = this.q(constraintWidget.m(bottom));
        final SolverVariable q5 = this.q(constraintWidget2.m(left));
        final SolverVariable q6 = this.q(constraintWidget2.m(top));
        final SolverVariable q7 = this.q(constraintWidget2.m(right));
        final SolverVariable q8 = this.q(constraintWidget2.m(bottom));
        final androidx.constraintlayout.core.b r = this.r();
        final double n3 = n;
        final double sin = Math.sin(n3);
        final double n4 = n2;
        r.q(q2, q4, q6, q8, (float)(sin * n4));
        this.d(r);
        final androidx.constraintlayout.core.b r2 = this.r();
        r2.q(q, q3, q5, q7, (float)(Math.cos(n3) * n4));
        this.d(r2);
    }
    
    public void c(final SolverVariable solverVariable, final SolverVariable solverVariable2, final int n, final float n2, final SolverVariable solverVariable3, final SolverVariable solverVariable4, final int n3, final int n4) {
        final androidx.constraintlayout.core.b r = this.r();
        r.h(solverVariable, solverVariable2, n, n2, solverVariable3, solverVariable4, n3);
        if (n4 != 8) {
            r.d(this, n4);
        }
        this.d(r);
    }
    
    public void d(final androidx.constraintlayout.core.b b) {
        if (b == null) {
            return;
        }
        final int l = this.l;
        final boolean b2 = true;
        if (l + 1 >= this.m || this.k + 1 >= this.f) {
            this.z();
        }
        int n = 0;
        if (!b.f) {
            b.D(this);
            if (b.isEmpty()) {
                return;
            }
            b.r();
            Label_0234: {
                if (b.f(this)) {
                    final SolverVariable p = this.p();
                    b.a = p;
                    final int i = this.l;
                    this.l(b);
                    if (this.l == i + 1) {
                        this.q.a((a)b);
                        this.C(this.q, true);
                        n = (b2 ? 1 : 0);
                        if (p.d == -1) {
                            if (b.a == p) {
                                final SolverVariable v = b.v(p);
                                if (v != null) {
                                    b.x(v);
                                }
                            }
                            if (!b.f) {
                                b.a.k(this, b);
                            }
                            if (androidx.constraintlayout.core.d.v) {
                                this.n.a.b(b);
                            }
                            else {
                                this.n.b.b(b);
                            }
                            --this.l;
                            n = (b2 ? 1 : 0);
                        }
                        break Label_0234;
                    }
                }
                n = 0;
            }
            if (!b.s()) {
                return;
            }
        }
        if (n == 0) {
            this.l(b);
        }
    }
    
    public androidx.constraintlayout.core.b e(final SolverVariable solverVariable, final SolverVariable solverVariable2, final int n, final int n2) {
        if (androidx.constraintlayout.core.d.s && n2 == 8 && solverVariable2.g && solverVariable.d == -1) {
            solverVariable.h(this, solverVariable2.f + n);
            return null;
        }
        final androidx.constraintlayout.core.b r = this.r();
        r.n(solverVariable, solverVariable2, n);
        if (n2 != 8) {
            r.d(this, n2);
        }
        this.d(r);
        return r;
    }
    
    public void f(final SolverVariable solverVariable, int i) {
        if (androidx.constraintlayout.core.d.s && solverVariable.d == -1) {
            final float n = (float)i;
            solverVariable.h(this, n);
            SolverVariable solverVariable2;
            for (i = 0; i < this.b + 1; ++i) {
                solverVariable2 = this.n.d[i];
                if (solverVariable2 != null && solverVariable2.y && solverVariable2.z == solverVariable.c) {
                    solverVariable2.h(this, solverVariable2.A + n);
                }
            }
            return;
        }
        final int d = solverVariable.d;
        if (d != -1) {
            final androidx.constraintlayout.core.b b = this.g[d];
            if (b.f) {
                b.b = (float)i;
            }
            else if (b.e.f() == 0) {
                b.f = true;
                b.b = (float)i;
            }
            else {
                final androidx.constraintlayout.core.b r = this.r();
                r.m(solverVariable, i);
                this.d(r);
            }
        }
        else {
            final androidx.constraintlayout.core.b r2 = this.r();
            r2.i(solverVariable, i);
            this.d(r2);
        }
    }
    
    public void g(final SolverVariable solverVariable, final SolverVariable solverVariable2, final int n, final boolean b) {
        final androidx.constraintlayout.core.b r = this.r();
        final SolverVariable t = this.t();
        t.e = 0;
        r.o(solverVariable, solverVariable2, t, n);
        this.d(r);
    }
    
    public void h(final SolverVariable solverVariable, final SolverVariable solverVariable2, final int n, final int n2) {
        final androidx.constraintlayout.core.b r = this.r();
        final SolverVariable t = this.t();
        t.e = 0;
        r.o(solverVariable, solverVariable2, t, n);
        if (n2 != 8) {
            this.m(r, (int)(r.e.j(t) * -1.0f), n2);
        }
        this.d(r);
    }
    
    public void i(final SolverVariable solverVariable, final SolverVariable solverVariable2, final int n, final boolean b) {
        final androidx.constraintlayout.core.b r = this.r();
        final SolverVariable t = this.t();
        t.e = 0;
        r.p(solverVariable, solverVariable2, t, n);
        this.d(r);
    }
    
    public void j(final SolverVariable solverVariable, final SolverVariable solverVariable2, final int n, final int n2) {
        final androidx.constraintlayout.core.b r = this.r();
        final SolverVariable t = this.t();
        t.e = 0;
        r.p(solverVariable, solverVariable2, t, n);
        if (n2 != 8) {
            this.m(r, (int)(r.e.j(t) * -1.0f), n2);
        }
        this.d(r);
    }
    
    public void k(final SolverVariable solverVariable, final SolverVariable solverVariable2, final SolverVariable solverVariable3, final SolverVariable solverVariable4, final float n, final int n2) {
        final androidx.constraintlayout.core.b r = this.r();
        r.k(solverVariable, solverVariable2, solverVariable3, solverVariable4, n);
        if (n2 != 8) {
            r.d(this, n2);
        }
        this.d(r);
    }
    
    void m(final androidx.constraintlayout.core.b b, final int n, final int n2) {
        b.e(this.o(n2, null), n);
    }
    
    public SolverVariable o(final int e, final String s) {
        if (this.k + 1 >= this.f) {
            this.z();
        }
        final SolverVariable a = this.a(SolverVariable.Type.ERROR, s);
        final int n = this.b + 1;
        this.b = n;
        ++this.k;
        a.c = n;
        a.e = e;
        this.n.d[n] = a;
        this.d.c(a);
        return a;
    }
    
    public SolverVariable p() {
        if (this.k + 1 >= this.f) {
            this.z();
        }
        final SolverVariable a = this.a(SolverVariable.Type.SLACK, null);
        final int n = this.b + 1;
        this.b = n;
        ++this.k;
        a.c = n;
        return this.n.d[n] = a;
    }
    
    public SolverVariable q(final Object o) {
        SolverVariable solverVariable = null;
        if (o == null) {
            return null;
        }
        if (this.k + 1 >= this.f) {
            this.z();
        }
        if (o instanceof ConstraintAnchor) {
            final ConstraintAnchor constraintAnchor = (ConstraintAnchor)o;
            SolverVariable solverVariable2;
            if ((solverVariable2 = constraintAnchor.h()) == null) {
                constraintAnchor.r(this.n);
                solverVariable2 = constraintAnchor.h();
            }
            final int c = solverVariable2.c;
            if (c != -1 && c <= this.b) {
                solverVariable = solverVariable2;
                if (this.n.d[c] != null) {
                    return solverVariable;
                }
            }
            if (c != -1) {
                solverVariable2.g();
            }
            final int n = this.b + 1;
            this.b = n;
            ++this.k;
            solverVariable2.c = n;
            solverVariable2.j = SolverVariable.Type.UNRESTRICTED;
            this.n.d[n] = solverVariable2;
            solverVariable = solverVariable2;
        }
        return solverVariable;
    }
    
    public androidx.constraintlayout.core.b r() {
        androidx.constraintlayout.core.b b;
        if (androidx.constraintlayout.core.d.v) {
            b = this.n.a.a();
            if (b == null) {
                b = new b(this.n);
                ++androidx.constraintlayout.core.d.y;
            }
            else {
                b.y();
            }
        }
        else {
            b = this.n.b.a();
            if (b == null) {
                b = new androidx.constraintlayout.core.b(this.n);
                ++androidx.constraintlayout.core.d.x;
            }
            else {
                b.y();
            }
        }
        SolverVariable.d();
        return b;
    }
    
    public SolverVariable t() {
        if (this.k + 1 >= this.f) {
            this.z();
        }
        final SolverVariable a = this.a(SolverVariable.Type.SLACK, null);
        final int n = this.b + 1;
        this.b = n;
        ++this.k;
        a.c = n;
        return this.n.d[n] = a;
    }
    
    public void v(final n.a a) {
    }
    
    public c w() {
        return this.n;
    }
    
    public int y(final Object o) {
        final SolverVariable h = ((ConstraintAnchor)o).h();
        if (h != null) {
            return (int)(h.f + 0.5f);
        }
        return 0;
    }
    
    interface a
    {
        void a(final a p0);
        
        SolverVariable b(final d p0, final boolean[] p1);
        
        void c(final SolverVariable p0);
        
        void clear();
        
        SolverVariable getKey();
        
        boolean isEmpty();
    }
    
    class b extends androidx.constraintlayout.core.b
    {
        final d g;
        
        public b(final d g, final c c) {
            this.g = g;
            super.e = new h(this, c);
        }
    }
}
