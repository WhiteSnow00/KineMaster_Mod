// 
// Decompiled by Procyon v0.6.0
// 

package androidx.constraintlayout.core;

import java.util.Arrays;

public class a implements b.a
{
    private static float l = 0.001f;
    int a;
    private final b b;
    protected final c c;
    private int d;
    private SolverVariable e;
    private int[] f;
    private int[] g;
    private float[] h;
    private int i;
    private int j;
    private boolean k;
    
    a(final b b, final c c) {
        this.a = 0;
        this.d = 8;
        this.e = null;
        this.f = new int[8];
        this.g = new int[8];
        this.h = new float[8];
        this.i = -1;
        this.j = -1;
        this.k = false;
        this.b = b;
        this.c = c;
    }
    
    @Override
    public boolean a(final SolverVariable solverVariable) {
        int i = this.i;
        if (i == -1) {
            return false;
        }
        for (int n = 0; i != -1 && n < this.a; i = this.g[i], ++n) {
            if (this.f[i] == solverVariable.c) {
                return true;
            }
        }
        return false;
    }
    
    @Override
    public SolverVariable b(final int n) {
        for (int i = this.i, n2 = 0; i != -1 && n2 < this.a; i = this.g[i], ++n2) {
            if (n2 == n) {
                return this.c.d[this.f[i]];
            }
        }
        return null;
    }
    
    @Override
    public void c(final SolverVariable solverVariable, float n, final boolean b) {
        final float l = androidx.constraintlayout.core.a.l;
        if (n > -l && n < l) {
            return;
        }
        int i = this.i;
        if (i == -1) {
            this.i = 0;
            this.h[0] = n;
            this.f[0] = solverVariable.c;
            this.g[0] = -1;
            ++solverVariable.x;
            solverVariable.a(this.b);
            ++this.a;
            if (!this.k) {
                final int j = this.j + 1;
                this.j = j;
                final int[] f = this.f;
                if (j >= f.length) {
                    this.k = true;
                    this.j = f.length - 1;
                }
            }
            return;
        }
        int n2 = 0;
        int n3 = -1;
        while (i != -1 && n2 < this.a) {
            final int[] f2 = this.f;
            final int n4 = f2[i];
            final int c = solverVariable.c;
            if (n4 == c) {
                final float[] h = this.h;
                final float n5 = h[i] + n;
                final float k = androidx.constraintlayout.core.a.l;
                n = n5;
                if (n5 > -k) {
                    n = n5;
                    if (n5 < k) {
                        n = 0.0f;
                    }
                }
                h[i] = n;
                if (n == 0.0f) {
                    if (i == this.i) {
                        this.i = this.g[i];
                    }
                    else {
                        final int[] g = this.g;
                        g[n3] = g[i];
                    }
                    if (b) {
                        solverVariable.f(this.b);
                    }
                    if (this.k) {
                        this.j = i;
                    }
                    --solverVariable.x;
                    --this.a;
                }
                return;
            }
            if (f2[i] < c) {
                n3 = i;
            }
            i = this.g[i];
            ++n2;
        }
        int n6 = this.j;
        if (this.k) {
            final int[] f3 = this.f;
            if (f3[n6] != -1) {
                n6 = f3.length;
            }
        }
        else {
            ++n6;
        }
        final int[] f4 = this.f;
        int n7 = n6;
        if (n6 >= f4.length) {
            n7 = n6;
            if (this.a < f4.length) {
                int n8 = 0;
                while (true) {
                    final int[] f5 = this.f;
                    n7 = n6;
                    if (n8 >= f5.length) {
                        break;
                    }
                    if (f5[n8] == -1) {
                        n7 = n8;
                        break;
                    }
                    ++n8;
                }
            }
        }
        final int[] f6 = this.f;
        int length;
        if ((length = n7) >= f6.length) {
            length = f6.length;
            final int d = this.d * 2;
            this.d = d;
            this.k = false;
            this.j = length - 1;
            this.h = Arrays.copyOf(this.h, d);
            this.f = Arrays.copyOf(this.f, this.d);
            this.g = Arrays.copyOf(this.g, this.d);
        }
        this.f[length] = solverVariable.c;
        this.h[length] = n;
        if (n3 != -1) {
            final int[] g2 = this.g;
            g2[length] = g2[n3];
            g2[n3] = length;
        }
        else {
            this.g[length] = this.i;
            this.i = length;
        }
        ++solverVariable.x;
        solverVariable.a(this.b);
        ++this.a;
        if (!this.k) {
            ++this.j;
        }
        final int m = this.j;
        final int[] f7 = this.f;
        if (m >= f7.length) {
            this.k = true;
            this.j = f7.length - 1;
        }
    }
    
    @Override
    public final void clear() {
        for (int i = this.i, n = 0; i != -1 && n < this.a; i = this.g[i], ++n) {
            final SolverVariable solverVariable = this.c.d[this.f[i]];
            if (solverVariable != null) {
                solverVariable.f(this.b);
            }
        }
        this.i = -1;
        this.j = -1;
        this.k = false;
        this.a = 0;
    }
    
    @Override
    public void d() {
        for (int i = this.i, n = 0; i != -1 && n < this.a; i = this.g[i], ++n) {
            final float[] h = this.h;
            h[i] *= -1.0f;
        }
    }
    
    @Override
    public final float e(final SolverVariable solverVariable, final boolean b) {
        if (this.e == solverVariable) {
            this.e = null;
        }
        int i = this.i;
        if (i == -1) {
            return 0.0f;
        }
        int n = 0;
        int n2 = -1;
        while (i != -1 && n < this.a) {
            if (this.f[i] == solverVariable.c) {
                if (i == this.i) {
                    this.i = this.g[i];
                }
                else {
                    final int[] g = this.g;
                    g[n2] = g[i];
                }
                if (b) {
                    solverVariable.f(this.b);
                }
                --solverVariable.x;
                --this.a;
                this.f[i] = -1;
                if (this.k) {
                    this.j = i;
                }
                return this.h[i];
            }
            final int n3 = this.g[i];
            ++n;
            n2 = i;
            i = n3;
        }
        return 0.0f;
    }
    
    @Override
    public int f() {
        return this.a;
    }
    
    @Override
    public float g(final b b, final boolean b2) {
        final float j = this.j(b.a);
        this.e(b.a, b2);
        final b.a e = b.e;
        for (int f = e.f(), i = 0; i < f; ++i) {
            final SolverVariable b3 = e.b(i);
            this.c(b3, e.j(b3) * j, b2);
        }
        return j;
    }
    
    @Override
    public final void h(final SolverVariable solverVariable, final float n) {
        if (n == 0.0f) {
            this.e(solverVariable, true);
            return;
        }
        int i = this.i;
        if (i == -1) {
            this.i = 0;
            this.h[0] = n;
            this.f[0] = solverVariable.c;
            this.g[0] = -1;
            ++solverVariable.x;
            solverVariable.a(this.b);
            ++this.a;
            if (!this.k) {
                final int j = this.j + 1;
                this.j = j;
                final int[] f = this.f;
                if (j >= f.length) {
                    this.k = true;
                    this.j = f.length - 1;
                }
            }
            return;
        }
        int n2 = 0;
        int n3 = -1;
        while (i != -1 && n2 < this.a) {
            final int[] f2 = this.f;
            final int n4 = f2[i];
            final int c = solverVariable.c;
            if (n4 == c) {
                this.h[i] = n;
                return;
            }
            if (f2[i] < c) {
                n3 = i;
            }
            i = this.g[i];
            ++n2;
        }
        int n5 = this.j;
        if (this.k) {
            final int[] f3 = this.f;
            if (f3[n5] != -1) {
                n5 = f3.length;
            }
        }
        else {
            ++n5;
        }
        final int[] f4 = this.f;
        int n6 = n5;
        if (n5 >= f4.length) {
            n6 = n5;
            if (this.a < f4.length) {
                int n7 = 0;
                while (true) {
                    final int[] f5 = this.f;
                    n6 = n5;
                    if (n7 >= f5.length) {
                        break;
                    }
                    if (f5[n7] == -1) {
                        n6 = n7;
                        break;
                    }
                    ++n7;
                }
            }
        }
        final int[] f6 = this.f;
        int length;
        if ((length = n6) >= f6.length) {
            length = f6.length;
            final int d = this.d * 2;
            this.d = d;
            this.k = false;
            this.j = length - 1;
            this.h = Arrays.copyOf(this.h, d);
            this.f = Arrays.copyOf(this.f, this.d);
            this.g = Arrays.copyOf(this.g, this.d);
        }
        this.f[length] = solverVariable.c;
        this.h[length] = n;
        if (n3 != -1) {
            final int[] g = this.g;
            g[length] = g[n3];
            g[n3] = length;
        }
        else {
            this.g[length] = this.i;
            this.i = length;
        }
        ++solverVariable.x;
        solverVariable.a(this.b);
        final int a = this.a + 1;
        this.a = a;
        if (!this.k) {
            ++this.j;
        }
        final int[] f7 = this.f;
        if (a >= f7.length) {
            this.k = true;
        }
        if (this.j >= f7.length) {
            this.k = true;
            this.j = f7.length - 1;
        }
    }
    
    @Override
    public float i(final int n) {
        for (int i = this.i, n2 = 0; i != -1 && n2 < this.a; i = this.g[i], ++n2) {
            if (n2 == n) {
                return this.h[i];
            }
        }
        return 0.0f;
    }
    
    @Override
    public final float j(final SolverVariable solverVariable) {
        for (int i = this.i, n = 0; i != -1 && n < this.a; i = this.g[i], ++n) {
            if (this.f[i] == solverVariable.c) {
                return this.h[i];
            }
        }
        return 0.0f;
    }
    
    @Override
    public void k(final float n) {
        for (int i = this.i, n2 = 0; i != -1 && n2 < this.a; i = this.g[i], ++n2) {
            final float[] h = this.h;
            h[i] /= n;
        }
    }
    
    @Override
    public String toString() {
        int i = this.i;
        String string = "";
        for (int n = 0; i != -1 && n < this.a; i = this.g[i], ++n) {
            final StringBuilder sb = new StringBuilder();
            sb.append(string);
            sb.append(" -> ");
            final String string2 = sb.toString();
            final StringBuilder sb2 = new StringBuilder();
            sb2.append(string2);
            sb2.append(this.h[i]);
            sb2.append(" : ");
            final String string3 = sb2.toString();
            final StringBuilder sb3 = new StringBuilder();
            sb3.append(string3);
            sb3.append(this.c.d[this.f[i]]);
            string = sb3.toString();
        }
        return string;
    }
}
