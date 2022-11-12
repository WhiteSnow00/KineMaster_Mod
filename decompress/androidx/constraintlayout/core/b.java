// 
// Decompiled by Procyon v0.6.0
// 

package androidx.constraintlayout.core;

import java.util.ArrayList;

public class b implements d.a
{
    SolverVariable a;
    float b;
    boolean c;
    ArrayList<SolverVariable> d;
    public a e;
    boolean f;
    
    public b() {
        this.a = null;
        this.b = 0.0f;
        this.c = false;
        this.d = new ArrayList<SolverVariable>();
        this.f = false;
    }
    
    public b(final c c) {
        this.a = null;
        this.b = 0.0f;
        this.c = false;
        this.d = new ArrayList<SolverVariable>();
        this.f = false;
        this.e = (a)new androidx.constraintlayout.core.a(this, c);
    }
    
    private boolean u(final SolverVariable solverVariable, final d d) {
        final int x = solverVariable.x;
        boolean b = true;
        if (x > 1) {
            b = false;
        }
        return b;
    }
    
    private SolverVariable w(final boolean[] array, final SolverVariable solverVariable) {
        final int f = this.e.f();
        SolverVariable solverVariable2 = null;
        int i = 0;
        float n = 0.0f;
        while (i < f) {
            final float j = this.e.i(i);
            SolverVariable solverVariable3 = solverVariable2;
            float n2 = n;
            Label_0153: {
                if (j < 0.0f) {
                    final SolverVariable b = this.e.b(i);
                    if (array != null) {
                        solverVariable3 = solverVariable2;
                        n2 = n;
                        if (array[b.c]) {
                            break Label_0153;
                        }
                    }
                    solverVariable3 = solverVariable2;
                    n2 = n;
                    if (b != solverVariable) {
                        final SolverVariable.Type k = b.j;
                        if (k != SolverVariable.Type.SLACK) {
                            solverVariable3 = solverVariable2;
                            n2 = n;
                            if (k != SolverVariable.Type.ERROR) {
                                break Label_0153;
                            }
                        }
                        solverVariable3 = solverVariable2;
                        n2 = n;
                        if (j < n) {
                            n2 = j;
                            solverVariable3 = b;
                        }
                    }
                }
            }
            ++i;
            solverVariable2 = solverVariable3;
            n = n2;
        }
        return solverVariable2;
    }
    
    public void A(final d d, final SolverVariable solverVariable, final boolean b) {
        if (solverVariable != null) {
            if (solverVariable.g) {
                this.b += solverVariable.f * this.e.j(solverVariable);
                this.e.e(solverVariable, b);
                if (b) {
                    solverVariable.f(this);
                }
                if (d.t && this.e.f() == 0) {
                    this.f = true;
                    d.a = true;
                }
            }
        }
    }
    
    public void B(final d d, final b b, final boolean b2) {
        this.b += b.b * this.e.g(b, b2);
        if (b2) {
            b.a.f(this);
        }
        if (d.t && this.a != null && this.e.f() == 0) {
            this.f = true;
            d.a = true;
        }
    }
    
    public void C(final d d, final SolverVariable solverVariable, final boolean b) {
        if (solverVariable != null) {
            if (solverVariable.y) {
                final float j = this.e.j(solverVariable);
                this.b += solverVariable.A * j;
                this.e.e(solverVariable, b);
                if (b) {
                    solverVariable.f(this);
                }
                this.e.c(d.n.d[solverVariable.z], j, b);
                if (d.t && this.e.f() == 0) {
                    this.f = true;
                    d.a = true;
                }
            }
        }
    }
    
    public void D(final d d) {
        if (d.g.length == 0) {
            return;
        }
        int i = 0;
        while (i == 0) {
            for (int f = this.e.f(), j = 0; j < f; ++j) {
                final SolverVariable b = this.e.b(j);
                if (b.d != -1 || b.g || b.y) {
                    this.d.add(b);
                }
            }
            final int size = this.d.size();
            if (size > 0) {
                for (int k = 0; k < size; ++k) {
                    final SolverVariable solverVariable = this.d.get(k);
                    if (solverVariable.g) {
                        this.A(d, solverVariable, true);
                    }
                    else if (solverVariable.y) {
                        this.C(d, solverVariable, true);
                    }
                    else {
                        this.B(d, d.g[solverVariable.d], true);
                    }
                }
                this.d.clear();
            }
            else {
                i = 1;
            }
        }
        if (d.t && this.a != null && this.e.f() == 0) {
            this.f = true;
            d.a = true;
        }
    }
    
    @Override
    public void a(final d.a a) {
        if (a instanceof b) {
            final b b = (b)a;
            this.a = null;
            this.e.clear();
            for (int i = 0; i < b.e.f(); ++i) {
                this.e.c(b.e.b(i), b.e.i(i), true);
            }
        }
    }
    
    @Override
    public SolverVariable b(final d d, final boolean[] array) {
        return this.w(array, null);
    }
    
    @Override
    public void c(final SolverVariable solverVariable) {
        final int e = solverVariable.e;
        float n = 1.0f;
        if (e != 1) {
            if (e == 2) {
                n = 1000.0f;
            }
            else if (e == 3) {
                n = 1000000.0f;
            }
            else if (e == 4) {
                n = 1.0E9f;
            }
            else if (e == 5) {
                n = 1.0E12f;
            }
        }
        this.e.h(solverVariable, n);
    }
    
    @Override
    public void clear() {
        this.e.clear();
        this.a = null;
        this.b = 0.0f;
    }
    
    public b d(final d d, final int n) {
        this.e.h(d.o(n, "ep"), 1.0f);
        this.e.h(d.o(n, "em"), -1.0f);
        return this;
    }
    
    b e(final SolverVariable solverVariable, final int n) {
        this.e.h(solverVariable, (float)n);
        return this;
    }
    
    boolean f(final d d) {
        final SolverVariable g = this.g(d);
        boolean b;
        if (g == null) {
            b = true;
        }
        else {
            this.x(g);
            b = false;
        }
        if (this.e.f() == 0) {
            this.f = true;
        }
        return b;
    }
    
    SolverVariable g(final d d) {
        final int f = this.e.f();
        SolverVariable solverVariable = null;
        int i = 0;
        int n2;
        int n = n2 = 0;
        float n3 = 0.0f;
        float n4 = 0.0f;
        SolverVariable solverVariable2 = null;
        while (i < f) {
            final float j = this.e.i(i);
            final SolverVariable b = this.e.b(i);
            int n5 = 0;
            SolverVariable solverVariable3 = null;
            SolverVariable solverVariable4 = null;
            int n6 = 0;
            float n7 = 0.0f;
            float n8 = 0.0f;
            Label_0412: {
                if (b.j == SolverVariable.Type.UNRESTRICTED) {
                    if (solverVariable == null) {
                        n5 = (this.u(b, d) ? 1 : 0);
                    }
                    else if (n3 > j) {
                        n5 = (this.u(b, d) ? 1 : 0);
                    }
                    else {
                        solverVariable3 = solverVariable;
                        solverVariable4 = solverVariable2;
                        n5 = n;
                        n6 = n2;
                        n7 = n3;
                        n8 = n4;
                        if (n != 0) {
                            break Label_0412;
                        }
                        solverVariable3 = solverVariable;
                        solverVariable4 = solverVariable2;
                        n5 = n;
                        n6 = n2;
                        n7 = n3;
                        n8 = n4;
                        if (this.u(b, d)) {
                            n5 = 1;
                            solverVariable3 = b;
                            solverVariable4 = solverVariable2;
                            n6 = n2;
                            n7 = j;
                            n8 = n4;
                        }
                        break Label_0412;
                    }
                    solverVariable3 = b;
                    solverVariable4 = solverVariable2;
                    n6 = n2;
                    n7 = j;
                    n8 = n4;
                }
                else {
                    solverVariable3 = solverVariable;
                    solverVariable4 = solverVariable2;
                    n5 = n;
                    n6 = n2;
                    n7 = n3;
                    n8 = n4;
                    if (solverVariable == null) {
                        solverVariable3 = solverVariable;
                        solverVariable4 = solverVariable2;
                        n5 = n;
                        n6 = n2;
                        n7 = n3;
                        n8 = n4;
                        if (j < 0.0f) {
                            boolean b2;
                            if (solverVariable2 == null) {
                                b2 = this.u(b, d);
                            }
                            else if (n4 > j) {
                                b2 = this.u(b, d);
                            }
                            else {
                                solverVariable3 = solverVariable;
                                solverVariable4 = solverVariable2;
                                n5 = n;
                                n6 = n2;
                                n7 = n3;
                                n8 = n4;
                                if (n2 != 0) {
                                    break Label_0412;
                                }
                                solverVariable3 = solverVariable;
                                solverVariable4 = solverVariable2;
                                n5 = n;
                                n6 = n2;
                                n7 = n3;
                                n8 = n4;
                                if (this.u(b, d)) {
                                    n6 = 1;
                                    n8 = j;
                                    n7 = n3;
                                    n5 = n;
                                    solverVariable4 = b;
                                    solverVariable3 = solverVariable;
                                }
                                break Label_0412;
                            }
                            n6 = (b2 ? 1 : 0);
                            solverVariable3 = solverVariable;
                            solverVariable4 = b;
                            n5 = n;
                            n7 = n3;
                            n8 = j;
                        }
                    }
                }
            }
            ++i;
            solverVariable = solverVariable3;
            solverVariable2 = solverVariable4;
            n = n5;
            n2 = n6;
            n3 = n7;
            n4 = n8;
        }
        if (solverVariable != null) {
            return solverVariable;
        }
        return solverVariable2;
    }
    
    @Override
    public SolverVariable getKey() {
        return this.a;
    }
    
    b h(final SolverVariable solverVariable, final SolverVariable solverVariable2, final int n, final float n2, final SolverVariable solverVariable3, final SolverVariable solverVariable4, final int n3) {
        if (solverVariable2 == solverVariable3) {
            this.e.h(solverVariable, 1.0f);
            this.e.h(solverVariable4, 1.0f);
            this.e.h(solverVariable2, -2.0f);
            return this;
        }
        if (n2 == 0.5f) {
            this.e.h(solverVariable, 1.0f);
            this.e.h(solverVariable2, -1.0f);
            this.e.h(solverVariable3, -1.0f);
            this.e.h(solverVariable4, 1.0f);
            if (n > 0 || n3 > 0) {
                this.b = (float)(-n + n3);
            }
        }
        else if (n2 <= 0.0f) {
            this.e.h(solverVariable, -1.0f);
            this.e.h(solverVariable2, 1.0f);
            this.b = (float)n;
        }
        else if (n2 >= 1.0f) {
            this.e.h(solverVariable4, -1.0f);
            this.e.h(solverVariable3, 1.0f);
            this.b = (float)(-n3);
        }
        else {
            final a e = this.e;
            final float n4 = 1.0f - n2;
            e.h(solverVariable, n4 * 1.0f);
            this.e.h(solverVariable2, n4 * -1.0f);
            this.e.h(solverVariable3, -1.0f * n2);
            this.e.h(solverVariable4, 1.0f * n2);
            if (n > 0 || n3 > 0) {
                this.b = -n * n4 + n3 * n2;
            }
        }
        return this;
    }
    
    b i(final SolverVariable a, final int n) {
        this.a = a;
        final float n2 = (float)n;
        a.f = n2;
        this.b = n2;
        this.f = true;
        return this;
    }
    
    @Override
    public boolean isEmpty() {
        return this.a == null && this.b == 0.0f && this.e.f() == 0;
    }
    
    b j(final SolverVariable solverVariable, final SolverVariable solverVariable2, final float n) {
        this.e.h(solverVariable, -1.0f);
        this.e.h(solverVariable2, n);
        return this;
    }
    
    public b k(final SolverVariable solverVariable, final SolverVariable solverVariable2, final SolverVariable solverVariable3, final SolverVariable solverVariable4, final float n) {
        this.e.h(solverVariable, -1.0f);
        this.e.h(solverVariable2, 1.0f);
        this.e.h(solverVariable3, n);
        this.e.h(solverVariable4, -n);
        return this;
    }
    
    public b l(float n, final float n2, final float n3, final SolverVariable solverVariable, final SolverVariable solverVariable2, final SolverVariable solverVariable3, final SolverVariable solverVariable4) {
        this.b = 0.0f;
        if (n2 != 0.0f && n != n3) {
            if (n == 0.0f) {
                this.e.h(solverVariable, 1.0f);
                this.e.h(solverVariable2, -1.0f);
            }
            else if (n3 == 0.0f) {
                this.e.h(solverVariable3, 1.0f);
                this.e.h(solverVariable4, -1.0f);
            }
            else {
                n = n / n2 / (n3 / n2);
                this.e.h(solverVariable, 1.0f);
                this.e.h(solverVariable2, -1.0f);
                this.e.h(solverVariable4, n);
                this.e.h(solverVariable3, -n);
            }
        }
        else {
            this.e.h(solverVariable, 1.0f);
            this.e.h(solverVariable2, -1.0f);
            this.e.h(solverVariable4, 1.0f);
            this.e.h(solverVariable3, -1.0f);
        }
        return this;
    }
    
    public b m(final SolverVariable solverVariable, final int n) {
        if (n < 0) {
            this.b = (float)(n * -1);
            this.e.h(solverVariable, 1.0f);
        }
        else {
            this.b = (float)n;
            this.e.h(solverVariable, -1.0f);
        }
        return this;
    }
    
    public b n(final SolverVariable solverVariable, final SolverVariable solverVariable2, final int n) {
        int n2 = 0;
        final int n3 = 0;
        if (n != 0) {
            n2 = n3;
            int n4;
            if ((n4 = n) < 0) {
                n4 = n * -1;
                n2 = 1;
            }
            this.b = (float)n4;
        }
        if (n2 == 0) {
            this.e.h(solverVariable, -1.0f);
            this.e.h(solverVariable2, 1.0f);
        }
        else {
            this.e.h(solverVariable, 1.0f);
            this.e.h(solverVariable2, -1.0f);
        }
        return this;
    }
    
    public b o(final SolverVariable solverVariable, final SolverVariable solverVariable2, final SolverVariable solverVariable3, final int n) {
        int n2 = 0;
        final int n3 = 0;
        if (n != 0) {
            n2 = n3;
            int n4;
            if ((n4 = n) < 0) {
                n4 = n * -1;
                n2 = 1;
            }
            this.b = (float)n4;
        }
        if (n2 == 0) {
            this.e.h(solverVariable, -1.0f);
            this.e.h(solverVariable2, 1.0f);
            this.e.h(solverVariable3, 1.0f);
        }
        else {
            this.e.h(solverVariable, 1.0f);
            this.e.h(solverVariable2, -1.0f);
            this.e.h(solverVariable3, -1.0f);
        }
        return this;
    }
    
    public b p(final SolverVariable solverVariable, final SolverVariable solverVariable2, final SolverVariable solverVariable3, final int n) {
        int n2 = 0;
        final int n3 = 0;
        if (n != 0) {
            n2 = n3;
            int n4;
            if ((n4 = n) < 0) {
                n4 = n * -1;
                n2 = 1;
            }
            this.b = (float)n4;
        }
        if (n2 == 0) {
            this.e.h(solverVariable, -1.0f);
            this.e.h(solverVariable2, 1.0f);
            this.e.h(solverVariable3, -1.0f);
        }
        else {
            this.e.h(solverVariable, 1.0f);
            this.e.h(solverVariable2, -1.0f);
            this.e.h(solverVariable3, 1.0f);
        }
        return this;
    }
    
    public b q(final SolverVariable solverVariable, final SolverVariable solverVariable2, final SolverVariable solverVariable3, final SolverVariable solverVariable4, final float n) {
        this.e.h(solverVariable3, 0.5f);
        this.e.h(solverVariable4, 0.5f);
        this.e.h(solverVariable, -0.5f);
        this.e.h(solverVariable2, -0.5f);
        this.b = -n;
        return this;
    }
    
    void r() {
        final float b = this.b;
        if (b < 0.0f) {
            this.b = b * -1.0f;
            this.e.d();
        }
    }
    
    boolean s() {
        final SolverVariable a = this.a;
        return a != null && (a.j == SolverVariable.Type.UNRESTRICTED || this.b >= 0.0f);
    }
    
    boolean t(final SolverVariable solverVariable) {
        return this.e.a(solverVariable);
    }
    
    @Override
    public String toString() {
        return this.z();
    }
    
    public SolverVariable v(final SolverVariable solverVariable) {
        return this.w(null, solverVariable);
    }
    
    void x(final SolverVariable a) {
        final SolverVariable a2 = this.a;
        if (a2 != null) {
            this.e.h(a2, -1.0f);
            this.a.d = -1;
            this.a = null;
        }
        final float n = this.e.e(a, true) * -1.0f;
        this.a = a;
        if (n == 1.0f) {
            return;
        }
        this.b /= n;
        this.e.k(n);
    }
    
    public void y() {
        this.a = null;
        this.e.clear();
        this.b = 0.0f;
        this.f = false;
    }
    
    String z() {
        String s;
        if (this.a == null) {
            final StringBuilder sb = new StringBuilder();
            sb.append("");
            sb.append("0");
            s = sb.toString();
        }
        else {
            final StringBuilder sb2 = new StringBuilder();
            sb2.append("");
            sb2.append(this.a);
            s = sb2.toString();
        }
        final StringBuilder sb3 = new StringBuilder();
        sb3.append(s);
        sb3.append(" = ");
        String s2 = sb3.toString();
        final float b = this.b;
        int i = 0;
        int n;
        if (b != 0.0f) {
            final StringBuilder sb4 = new StringBuilder();
            sb4.append(s2);
            sb4.append(this.b);
            s2 = sb4.toString();
            n = 1;
        }
        else {
            n = 0;
        }
        while (i < this.e.f()) {
            final SolverVariable b2 = this.e.b(i);
            if (b2 != null) {
                final float j = this.e.i(i);
                final float n2 = fcmpl(j, 0.0f);
                if (n2 != 0) {
                    final String string = b2.toString();
                    String s3 = null;
                    float n3 = 0.0f;
                    Label_0365: {
                        if (n == 0) {
                            s3 = s2;
                            n3 = j;
                            if (j >= 0.0f) {
                                break Label_0365;
                            }
                            final StringBuilder sb5 = new StringBuilder();
                            sb5.append(s2);
                            sb5.append("- ");
                            s3 = sb5.toString();
                        }
                        else {
                            if (n2 > 0) {
                                final StringBuilder sb6 = new StringBuilder();
                                sb6.append(s2);
                                sb6.append(" + ");
                                s3 = sb6.toString();
                                n3 = j;
                                break Label_0365;
                            }
                            final StringBuilder sb7 = new StringBuilder();
                            sb7.append(s2);
                            sb7.append(" - ");
                            s3 = sb7.toString();
                        }
                        n3 = j * -1.0f;
                    }
                    if (n3 == 1.0f) {
                        final StringBuilder sb8 = new StringBuilder();
                        sb8.append(s3);
                        sb8.append(string);
                        s2 = sb8.toString();
                    }
                    else {
                        final StringBuilder sb9 = new StringBuilder();
                        sb9.append(s3);
                        sb9.append(n3);
                        sb9.append(" ");
                        sb9.append(string);
                        s2 = sb9.toString();
                    }
                    n = 1;
                }
            }
            ++i;
        }
        String string2 = s2;
        if (n == 0) {
            final StringBuilder sb10 = new StringBuilder();
            sb10.append(s2);
            sb10.append("0.0");
            string2 = sb10.toString();
        }
        return string2;
    }
    
    public interface a
    {
        boolean a(final SolverVariable p0);
        
        SolverVariable b(final int p0);
        
        void c(final SolverVariable p0, final float p1, final boolean p2);
        
        void clear();
        
        void d();
        
        float e(final SolverVariable p0, final boolean p1);
        
        int f();
        
        float g(final b p0, final boolean p1);
        
        void h(final SolverVariable p0, final float p1);
        
        float i(final int p0);
        
        float j(final SolverVariable p0);
        
        void k(final float p0);
    }
}
