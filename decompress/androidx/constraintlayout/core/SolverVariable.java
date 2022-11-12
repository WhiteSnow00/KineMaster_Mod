// 
// Decompiled by Procyon v0.6.0
// 

package androidx.constraintlayout.core;

import java.util.Arrays;
import java.util.HashSet;

public class SolverVariable implements Comparable<SolverVariable>
{
    private static int C = 1;
    float A;
    HashSet<b> B;
    public boolean a;
    private String b;
    public int c;
    int d;
    public int e;
    public float f;
    public boolean g;
    float[] h;
    float[] i;
    Type j;
    b[] p;
    int w;
    public int x;
    boolean y;
    int z;
    
    public SolverVariable(final Type j, final String s) {
        this.c = -1;
        this.d = -1;
        this.e = 0;
        this.g = false;
        this.h = new float[9];
        this.i = new float[9];
        this.p = new b[16];
        this.w = 0;
        this.x = 0;
        this.y = false;
        this.z = -1;
        this.A = 0.0f;
        this.B = null;
        this.j = j;
    }
    
    static void d() {
        ++SolverVariable.C;
    }
    
    public final void a(final b b) {
        int n = 0;
        while (true) {
            final int w = this.w;
            if (n >= w) {
                final b[] p = this.p;
                if (w >= p.length) {
                    this.p = Arrays.copyOf(p, p.length * 2);
                }
                final b[] p2 = this.p;
                final int w2 = this.w;
                p2[w2] = b;
                this.w = w2 + 1;
                return;
            }
            if (this.p[n] == b) {
                return;
            }
            ++n;
        }
    }
    
    public int c(final SolverVariable solverVariable) {
        return this.c - solverVariable.c;
    }
    
    @Override
    public /* bridge */ int compareTo(final Object o) {
        return this.c((SolverVariable)o);
    }
    
    public final void f(final b b) {
        for (int w = this.w, i = 0; i < w; ++i) {
            if (this.p[i] == b) {
                while (i < w - 1) {
                    final b[] p = this.p;
                    final int n = i + 1;
                    p[i] = p[n];
                    i = n;
                }
                --this.w;
                return;
            }
        }
    }
    
    public void g() {
        this.b = null;
        this.j = Type.UNKNOWN;
        this.e = 0;
        this.c = -1;
        this.d = -1;
        this.f = 0.0f;
        this.g = false;
        this.y = false;
        this.z = -1;
        this.A = 0.0f;
        for (int w = this.w, i = 0; i < w; ++i) {
            this.p[i] = null;
        }
        this.w = 0;
        this.x = 0;
        this.a = false;
        Arrays.fill(this.i, 0.0f);
    }
    
    public void h(final d d, final float f) {
        this.f = f;
        this.g = true;
        this.y = false;
        this.z = -1;
        this.A = 0.0f;
        final int w = this.w;
        this.d = -1;
        for (int i = 0; i < w; ++i) {
            this.p[i].A(d, this, false);
        }
        this.w = 0;
    }
    
    public void i(final Type j, final String s) {
        this.j = j;
    }
    
    public final void k(final d d, final b b) {
        for (int w = this.w, i = 0; i < w; ++i) {
            this.p[i].B(d, b, false);
        }
        this.w = 0;
    }
    
    @Override
    public String toString() {
        String s;
        if (this.b != null) {
            final StringBuilder sb = new StringBuilder();
            sb.append("");
            sb.append(this.b);
            s = sb.toString();
        }
        else {
            final StringBuilder sb2 = new StringBuilder();
            sb2.append("");
            sb2.append(this.c);
            s = sb2.toString();
        }
        return s;
    }
    
    public enum Type
    {
        private static final Type[] $VALUES;
        
        CONSTANT, 
        ERROR, 
        SLACK, 
        UNKNOWN, 
        UNRESTRICTED;
    }
}
