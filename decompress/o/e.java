// 
// Decompiled by Procyon v0.6.0
// 

package o;

import java.text.DecimalFormat;
import java.util.Iterator;
import java.util.List;
import java.util.Collections;
import java.util.Comparator;
import java.util.ArrayList;

public abstract class e
{
    private o.b a;
    private b b;
    private String c;
    private int d;
    private String e;
    public int f;
    ArrayList<c> g;
    
    public e() {
        this.d = 0;
        this.e = null;
        this.f = 0;
        this.g = new ArrayList<c>();
    }
    
    public float a(final float n) {
        return (float)this.b.a(n);
    }
    
    protected void b(final Object o) {
    }
    
    public void c(final int n, final int d, final String e, final int f, final float n2, final float n3, final float n4, final float n5) {
        this.g.add(new c(n, n2, n3, n4, n5));
        if (f != -1) {
            this.f = f;
        }
        this.d = d;
        this.e = e;
    }
    
    public void d(final int n, final int d, final String e, final int f, final float n2, final float n3, final float n4, final float n5, final Object o) {
        this.g.add(new c(n, n2, n3, n4, n5));
        if (f != -1) {
            this.f = f;
        }
        this.d = d;
        this.b(o);
        this.e = e;
    }
    
    public void e(final String c) {
        this.c = c;
    }
    
    public void f(final float n) {
        final int size = this.g.size();
        if (size == 0) {
            return;
        }
        Collections.sort(this.g, (Comparator<? super c>)new Comparator<c>(this) {
            final e a;
            
            public int a(final c c, final c c2) {
                return Integer.compare(c.a, c2.a);
            }
            
            @Override
            public /* bridge */ int compare(final Object o, final Object o2) {
                return this.a((c)o, (c)o2);
            }
        });
        final double[] array = new double[size];
        final double[][] array2 = new double[size][3];
        this.b = new b(this.d, this.e, this.f, size);
        final Iterator<c> iterator = this.g.iterator();
        int n2 = 0;
        while (iterator.hasNext()) {
            final c c = iterator.next();
            final float d = c.d;
            array[n2] = d * 0.01;
            final double[] array3 = array2[n2];
            final float b = c.b;
            array3[0] = b;
            final double[] array4 = array2[n2];
            final float c2 = c.c;
            array4[1] = c2;
            final double[] array5 = array2[n2];
            final float e = c.e;
            array5[2] = e;
            this.b.b(n2, c.a, d, c2, e, b);
            ++n2;
        }
        this.b.c(n);
        this.a = o.b.a(0, array, array2);
    }
    
    public boolean g() {
        final int f = this.f;
        boolean b = true;
        if (f != 1) {
            b = false;
        }
        return b;
    }
    
    @Override
    public String toString() {
        String s = this.c;
        final DecimalFormat decimalFormat = new DecimalFormat("##.##");
        for (final c c : this.g) {
            final StringBuilder sb = new StringBuilder();
            sb.append(s);
            sb.append("[");
            sb.append(c.a);
            sb.append(" , ");
            sb.append(decimalFormat.format(c.b));
            sb.append("] ");
            s = sb.toString();
        }
        return s;
    }
    
    static class b
    {
        private final int a;
        h b;
        private final int c;
        private final int d;
        private final int e;
        float[] f;
        double[] g;
        float[] h;
        float[] i;
        float[] j;
        float[] k;
        int l;
        o.b m;
        double[] n;
        double[] o;
        float p;
        
        b(final int l, final String s, final int a, final int n) {
            final h b = new h();
            this.b = b;
            this.c = 0;
            this.d = 1;
            this.e = 2;
            this.l = l;
            this.a = a;
            b.e(l, s);
            this.f = new float[n];
            this.g = new double[n];
            this.h = new float[n];
            this.i = new float[n];
            this.j = new float[n];
            this.k = new float[n];
        }
        
        public double a(final float n) {
            final o.b m = this.m;
            if (m != null) {
                m.d(n, this.n);
            }
            else {
                final double[] n2 = this.n;
                n2[0] = this.i[0];
                n2[1] = this.j[0];
                n2[2] = this.f[0];
            }
            final double[] n3 = this.n;
            return n3[0] + this.b.c(n, n3[1]) * this.n[2];
        }
        
        public void b(final int n, final int n2, final float n3, final float n4, final float n5, final float n6) {
            this.g[n] = n2 / 100.0;
            this.h[n] = n3;
            this.i[n] = n4;
            this.j[n] = n5;
            this.f[n] = n6;
        }
        
        public void c(final float p) {
            this.p = p;
            final double[][] array = new double[this.g.length][3];
            final float[] f = this.f;
            this.n = new double[f.length + 2];
            this.o = new double[f.length + 2];
            if (this.g[0] > 0.0) {
                this.b.a(0.0, this.h[0]);
            }
            final double[] g = this.g;
            final int n = g.length - 1;
            if (g[n] < 1.0) {
                this.b.a(1.0, this.h[n]);
            }
            for (int i = 0; i < array.length; ++i) {
                array[i][0] = this.i[i];
                array[i][1] = this.j[i];
                array[i][2] = this.f[i];
                this.b.a(this.g[i], this.h[i]);
            }
            this.b.d();
            final double[] g2 = this.g;
            if (g2.length > 1) {
                this.m = o.b.a(0, g2, array);
            }
            else {
                this.m = null;
            }
        }
    }
    
    static class c
    {
        int a;
        float b;
        float c;
        float d;
        float e;
        
        public c(final int a, final float d, final float c, final float e, final float b) {
            this.a = a;
            this.b = b;
            this.c = c;
            this.d = d;
            this.e = e;
        }
    }
}
