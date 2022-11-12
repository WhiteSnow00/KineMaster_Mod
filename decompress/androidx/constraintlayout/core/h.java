// 
// Decompiled by Procyon v0.6.0
// 

package androidx.constraintlayout.core;

import java.util.Arrays;

public class h implements a
{
    private static float n = 0.001f;
    private final int a;
    private int b;
    private int c;
    int[] d;
    int[] e;
    int[] f;
    float[] g;
    int[] h;
    int[] i;
    int j;
    int k;
    private final b l;
    protected final c m;
    
    h(final b l, final c m) {
        this.a = -1;
        this.b = 16;
        this.c = 16;
        this.d = new int[16];
        this.e = new int[16];
        this.f = new int[16];
        this.g = new float[16];
        this.h = new int[16];
        this.i = new int[16];
        this.j = 0;
        this.k = -1;
        this.l = l;
        this.m = m;
        this.clear();
    }
    
    private void l(final SolverVariable solverVariable, final int n) {
        final int n2 = solverVariable.c % this.c;
        final int[] d = this.d;
        int n3;
        if ((n3 = d[n2]) == -1) {
            d[n2] = n;
        }
        else {
            int[] e;
            while (true) {
                e = this.e;
                if (e[n3] == -1) {
                    break;
                }
                n3 = e[n3];
            }
            e[n3] = n;
        }
        this.e[n] = -1;
    }
    
    private void m(final int n, final SolverVariable solverVariable, final float n2) {
        this.f[n] = solverVariable.c;
        this.g[n] = n2;
        this.h[n] = -1;
        this.i[n] = -1;
        solverVariable.a(this.l);
        ++solverVariable.x;
        ++this.j;
    }
    
    private int n() {
        for (int i = 0; i < this.b; ++i) {
            if (this.f[i] == -1) {
                return i;
            }
        }
        return -1;
    }
    
    private void o() {
        final int b = this.b * 2;
        this.f = Arrays.copyOf(this.f, b);
        this.g = Arrays.copyOf(this.g, b);
        this.h = Arrays.copyOf(this.h, b);
        this.i = Arrays.copyOf(this.i, b);
        this.e = Arrays.copyOf(this.e, b);
        for (int i = this.b; i < b; ++i) {
            this.f[i] = -1;
            this.e[i] = -1;
        }
        this.b = b;
    }
    
    private void q(final int n, final SolverVariable solverVariable, final float n2) {
        final int n3 = this.n();
        this.m(n3, solverVariable, n2);
        if (n != -1) {
            this.h[n3] = n;
            final int[] i = this.i;
            i[n3] = i[n];
            i[n] = n3;
        }
        else {
            this.h[n3] = -1;
            if (this.j > 0) {
                this.i[n3] = this.k;
                this.k = n3;
            }
            else {
                this.i[n3] = -1;
            }
        }
        final int[] j = this.i;
        if (j[n3] != -1) {
            this.h[j[n3]] = n3;
        }
        this.l(solverVariable, n3);
    }
    
    private void r(final SolverVariable solverVariable) {
        final int c = solverVariable.c;
        final int n = c % this.c;
        final int[] d = this.d;
        final int n2 = d[n];
        if (n2 == -1) {
            return;
        }
        int n3 = n2;
        if (this.f[n2] == c) {
            final int[] e = this.e;
            d[n] = e[n2];
            e[n2] = -1;
        }
        else {
            int[] e2;
            while (true) {
                e2 = this.e;
                if (e2[n3] == -1 || this.f[e2[n3]] == c) {
                    break;
                }
                n3 = e2[n3];
            }
            final int n4 = e2[n3];
            if (n4 != -1 && this.f[n4] == c) {
                e2[n3] = e2[n4];
                e2[n4] = -1;
            }
        }
    }
    
    @Override
    public boolean a(final SolverVariable solverVariable) {
        return this.p(solverVariable) != -1;
    }
    
    @Override
    public SolverVariable b(final int n) {
        final int j = this.j;
        if (j == 0) {
            return null;
        }
        int k = this.k;
        for (int i = 0; i < j; ++i) {
            if (i == n && k != -1) {
                return this.m.d[this.f[k]];
            }
            k = this.i[k];
            if (k == -1) {
                break;
            }
        }
        return null;
    }
    
    @Override
    public void c(final SolverVariable solverVariable, float n, final boolean b) {
        final float n2 = androidx.constraintlayout.core.h.n;
        if (n > -n2 && n < n2) {
            return;
        }
        final int p3 = this.p(solverVariable);
        if (p3 == -1) {
            this.h(solverVariable, n);
        }
        else {
            final float[] g = this.g;
            g[p3] += n;
            n = g[p3];
            final float n3 = androidx.constraintlayout.core.h.n;
            if (n > -n3 && g[p3] < n3) {
                g[p3] = 0.0f;
                this.e(solverVariable, b);
            }
        }
    }
    
    @Override
    public void clear() {
        for (int j = this.j, i = 0; i < j; ++i) {
            final SolverVariable b = this.b(i);
            if (b != null) {
                b.f(this.l);
            }
        }
        for (int k = 0; k < this.b; ++k) {
            this.f[k] = -1;
            this.e[k] = -1;
        }
        for (int l = 0; l < this.c; ++l) {
            this.d[l] = -1;
        }
        this.j = 0;
        this.k = -1;
    }
    
    @Override
    public void d() {
        final int j = this.j;
        int k = this.k;
        for (int i = 0; i < j; ++i) {
            final float[] g = this.g;
            g[k] *= -1.0f;
            k = this.i[k];
            if (k == -1) {
                break;
            }
        }
    }
    
    @Override
    public float e(final SolverVariable solverVariable, final boolean b) {
        final int p2 = this.p(solverVariable);
        if (p2 == -1) {
            return 0.0f;
        }
        this.r(solverVariable);
        final float n = this.g[p2];
        if (this.k == p2) {
            this.k = this.i[p2];
        }
        this.f[p2] = -1;
        final int[] h = this.h;
        if (h[p2] != -1) {
            final int[] i = this.i;
            i[h[p2]] = i[p2];
        }
        final int[] j = this.i;
        if (j[p2] != -1) {
            h[j[p2]] = h[p2];
        }
        --this.j;
        --solverVariable.x;
        if (b) {
            solverVariable.f(this.l);
        }
        return n;
    }
    
    @Override
    public int f() {
        return this.j;
    }
    
    @Override
    public float g(final b b, final boolean b2) {
        final float j = this.j(b.a);
        this.e(b.a, b2);
        final h h = (h)b.e;
        final int f = h.f();
        int i = 0;
        int n = 0;
        while (i < f) {
            final int[] f2 = h.f;
            int n2 = i;
            if (f2[n] != -1) {
                this.c(this.m.d[f2[n]], h.g[n] * j, b2);
                n2 = i + 1;
            }
            ++n;
            i = n2;
        }
        return j;
    }
    
    @Override
    public void h(final SolverVariable solverVariable, final float n) {
        final float n2 = androidx.constraintlayout.core.h.n;
        if (n > -n2 && n < n2) {
            this.e(solverVariable, true);
            return;
        }
        final int j = this.j;
        int n3 = 0;
        if (j == 0) {
            this.m(0, solverVariable, n);
            this.l(solverVariable, 0);
            this.k = 0;
        }
        else {
            final int p2 = this.p(solverVariable);
            if (p2 != -1) {
                this.g[p2] = n;
            }
            else {
                if (this.j + 1 >= this.b) {
                    this.o();
                }
                final int i = this.j;
                int k = this.k;
                int n4 = -1;
                int n5;
                while (true) {
                    n5 = n4;
                    if (n3 >= i) {
                        break;
                    }
                    final int[] f = this.f;
                    final int n6 = f[k];
                    final int c = solverVariable.c;
                    if (n6 == c) {
                        this.g[k] = n;
                        return;
                    }
                    if (f[k] < c) {
                        n4 = k;
                    }
                    k = this.i[k];
                    if (k == -1) {
                        n5 = n4;
                        break;
                    }
                    ++n3;
                }
                this.q(n5, solverVariable, n);
            }
        }
    }
    
    @Override
    public float i(final int n) {
        final int j = this.j;
        int k = this.k;
        for (int i = 0; i < j; ++i) {
            if (i == n) {
                return this.g[k];
            }
            k = this.i[k];
            if (k == -1) {
                break;
            }
        }
        return 0.0f;
    }
    
    @Override
    public float j(final SolverVariable solverVariable) {
        final int p = this.p(solverVariable);
        if (p != -1) {
            return this.g[p];
        }
        return 0.0f;
    }
    
    @Override
    public void k(final float n) {
        final int j = this.j;
        int k = this.k;
        for (int i = 0; i < j; ++i) {
            final float[] g = this.g;
            g[k] /= n;
            k = this.i[k];
            if (k == -1) {
                break;
            }
        }
    }
    
    public int p(final SolverVariable solverVariable) {
        if (this.j != 0) {
            if (solverVariable != null) {
                final int c = solverVariable.c;
                final int n = this.d[c % this.c];
                if (n == -1) {
                    return -1;
                }
                int n2 = n;
                if (this.f[n] == c) {
                    return n;
                }
                int[] e;
                while (true) {
                    e = this.e;
                    if (e[n2] == -1 || this.f[e[n2]] == c) {
                        break;
                    }
                    n2 = e[n2];
                }
                if (e[n2] == -1) {
                    return -1;
                }
                if (this.f[e[n2]] == c) {
                    return e[n2];
                }
            }
        }
        return -1;
    }
    
    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append(this.hashCode());
        sb.append(" { ");
        String s = sb.toString();
        for (int j = this.j, i = 0; i < j; ++i) {
            final SolverVariable b = this.b(i);
            if (b != null) {
                final StringBuilder sb2 = new StringBuilder();
                sb2.append(s);
                sb2.append(b);
                sb2.append(" = ");
                sb2.append(this.i(i));
                sb2.append(" ");
                final String string = sb2.toString();
                final int p = this.p(b);
                final StringBuilder sb3 = new StringBuilder();
                sb3.append(string);
                sb3.append("[p: ");
                final String string2 = sb3.toString();
                String s2;
                if (this.h[p] != -1) {
                    final StringBuilder sb4 = new StringBuilder();
                    sb4.append(string2);
                    sb4.append(this.m.d[this.f[this.h[p]]]);
                    s2 = sb4.toString();
                }
                else {
                    final StringBuilder sb5 = new StringBuilder();
                    sb5.append(string2);
                    sb5.append("none");
                    s2 = sb5.toString();
                }
                final StringBuilder sb6 = new StringBuilder();
                sb6.append(s2);
                sb6.append(", n: ");
                final String string3 = sb6.toString();
                String s3;
                if (this.i[p] != -1) {
                    final StringBuilder sb7 = new StringBuilder();
                    sb7.append(string3);
                    sb7.append(this.m.d[this.f[this.i[p]]]);
                    s3 = sb7.toString();
                }
                else {
                    final StringBuilder sb8 = new StringBuilder();
                    sb8.append(string3);
                    sb8.append("none");
                    s3 = sb8.toString();
                }
                final StringBuilder sb9 = new StringBuilder();
                sb9.append(s3);
                sb9.append("]");
                s = sb9.toString();
            }
        }
        final StringBuilder sb10 = new StringBuilder();
        sb10.append(s);
        sb10.append(" }");
        return sb10.toString();
    }
}
