// 
// Decompiled by Procyon v0.6.0
// 

package androidx.constraintlayout.core;

import java.util.Comparator;
import java.util.Arrays;

public class g extends androidx.constraintlayout.core.b
{
    private int g;
    private SolverVariable[] h;
    private SolverVariable[] i;
    private int j;
    b k;
    c l;
    
    public g(final c l) {
        super(l);
        this.g = 128;
        this.h = new SolverVariable[128];
        this.i = new SolverVariable[128];
        this.j = 0;
        this.k = new b(this);
        this.l = l;
    }
    
    static void E(final g g, final SolverVariable solverVariable) {
        g.G(solverVariable);
    }
    
    private final void F(final SolverVariable solverVariable) {
        final int j = this.j;
        final SolverVariable[] h = this.h;
        if (j + 1 > h.length) {
            final SolverVariable[] h2 = Arrays.copyOf(h, h.length * 2);
            this.h = h2;
            this.i = Arrays.copyOf(h2, h2.length * 2);
        }
        final SolverVariable[] h3 = this.h;
        int i = this.j;
        h3[i] = solverVariable;
        ++i;
        this.j = i;
        if (i > 1 && h3[i - 1].c > solverVariable.c) {
            final int n = 0;
            int n2 = 0;
            int k;
            while (true) {
                k = this.j;
                if (n2 >= k) {
                    break;
                }
                this.i[n2] = this.h[n2];
                ++n2;
            }
            Arrays.sort(this.i, 0, k, new Comparator<SolverVariable>(this) {
                final g a;
                
                public int a(final SolverVariable solverVariable, final SolverVariable solverVariable2) {
                    return solverVariable.c - solverVariable2.c;
                }
                
                @Override
                public /* bridge */ int compare(final Object o, final Object o2) {
                    return this.a((SolverVariable)o, (SolverVariable)o2);
                }
            });
            for (int l = n; l < this.j; ++l) {
                this.h[l] = this.i[l];
            }
        }
        solverVariable.a = true;
        solverVariable.a(this);
    }
    
    private final void G(final SolverVariable solverVariable) {
        for (int i = 0; i < this.j; ++i) {
            if (this.h[i] == solverVariable) {
                int j;
                while (true) {
                    j = this.j;
                    if (i >= j - 1) {
                        break;
                    }
                    final SolverVariable[] h = this.h;
                    final int n = i + 1;
                    h[i] = h[n];
                    i = n;
                }
                this.j = j - 1;
                solverVariable.a = false;
                return;
            }
        }
    }
    
    @Override
    public void B(final d d, final androidx.constraintlayout.core.b b, final boolean b2) {
        final SolverVariable a = b.a;
        if (a == null) {
            return;
        }
        final a e = b.e;
        for (int f = e.f(), i = 0; i < f; ++i) {
            final SolverVariable b3 = e.b(i);
            final float j = e.i(i);
            this.k.b(b3);
            if (this.k.a(a, j)) {
                this.F(b3);
            }
            super.b += b.b * j;
        }
        this.G(a);
    }
    
    @Override
    public SolverVariable b(final d d, final boolean[] array) {
        int i = 0;
        int n = -1;
        while (i < this.j) {
            final SolverVariable solverVariable = this.h[i];
            int n2 = 0;
            Label_0091: {
                if (array[solverVariable.c]) {
                    n2 = n;
                }
                else {
                    this.k.b(solverVariable);
                    if (n == -1) {
                        n2 = n;
                        if (!this.k.c()) {
                            break Label_0091;
                        }
                    }
                    else {
                        n2 = n;
                        if (!this.k.d(this.h[n])) {
                            break Label_0091;
                        }
                    }
                    n2 = i;
                }
            }
            ++i;
            n = n2;
        }
        if (n == -1) {
            return null;
        }
        return this.h[n];
    }
    
    @Override
    public void c(final SolverVariable solverVariable) {
        this.k.b(solverVariable);
        this.k.e();
        solverVariable.i[solverVariable.e] = 1.0f;
        this.F(solverVariable);
    }
    
    @Override
    public void clear() {
        this.j = 0;
        super.b = 0.0f;
    }
    
    @Override
    public boolean isEmpty() {
        return this.j == 0;
    }
    
    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append("");
        sb.append(" goal -> (");
        sb.append(super.b);
        sb.append(") : ");
        String s = sb.toString();
        for (int i = 0; i < this.j; ++i) {
            this.k.b(this.h[i]);
            final StringBuilder sb2 = new StringBuilder();
            sb2.append(s);
            sb2.append(this.k);
            sb2.append(" ");
            s = sb2.toString();
        }
        return s;
    }
    
    class b
    {
        SolverVariable a;
        g b;
        final g c;
        
        public b(final g c, final g b) {
            this.c = c;
            this.b = b;
        }
        
        public boolean a(final SolverVariable solverVariable, final float n) {
            final boolean a = this.a.a;
            boolean b = true;
            int i = 0;
            if (a) {
                for (int j = 0; j < 9; ++j) {
                    final float[] k = this.a.i;
                    k[j] += solverVariable.i[j] * n;
                    if (Math.abs(k[j]) < 1.0E-4f) {
                        this.a.i[j] = 0.0f;
                    }
                    else {
                        b = false;
                    }
                }
                if (b) {
                    androidx.constraintlayout.core.g.E(this.c, this.a);
                }
                return false;
            }
            while (i < 9) {
                final float n2 = solverVariable.i[i];
                if (n2 != 0.0f) {
                    float n3;
                    if (Math.abs(n3 = n2 * n) < 1.0E-4f) {
                        n3 = 0.0f;
                    }
                    this.a.i[i] = n3;
                }
                else {
                    this.a.i[i] = 0.0f;
                }
                ++i;
            }
            return true;
        }
        
        public void b(final SolverVariable a) {
            this.a = a;
        }
        
        public final boolean c() {
            for (int i = 8; i >= 0; --i) {
                final float n = this.a.i[i];
                if (n > 0.0f) {
                    return false;
                }
                if (n < 0.0f) {
                    return true;
                }
            }
            return false;
        }
        
        public final boolean d(final SolverVariable solverVariable) {
            int i = 8;
            while (i >= 0) {
                final float n = solverVariable.i[i];
                final float n2 = this.a.i[i];
                if (n2 == n) {
                    --i;
                }
                else {
                    if (n2 < n) {
                        return true;
                    }
                    break;
                }
            }
            return false;
        }
        
        public void e() {
            Arrays.fill(this.a.i, 0.0f);
        }
        
        @Override
        public String toString() {
            final SolverVariable a = this.a;
            String s;
            String string = s = "[ ";
            if (a != null) {
                int n = 0;
                while (true) {
                    s = string;
                    if (n >= 9) {
                        break;
                    }
                    final StringBuilder sb = new StringBuilder();
                    sb.append(string);
                    sb.append(this.a.i[n]);
                    sb.append(" ");
                    string = sb.toString();
                    ++n;
                }
            }
            final StringBuilder sb2 = new StringBuilder();
            sb2.append(s);
            sb2.append("] ");
            sb2.append(this.a);
            return sb2.toString();
        }
    }
}
