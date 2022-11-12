// 
// Decompiled by Procyon v0.6.0
// 

package o;

import java.util.Arrays;

public class a extends b
{
    private final double[] a;
    a[] b;
    private boolean c;
    
    public a(final int[] array, final double[] a, final double[][] array2) {
        this.c = true;
        this.a = a;
        this.b = new a[a.length - 1];
        int n = 1;
        int n2 = 1;
        int n3 = 0;
        while (true) {
            final a[] b = this.b;
            if (n3 >= b.length) {
                break;
            }
            final int n4 = array[n3];
            Label_0113: {
                if (n4 != 0) {
                    int n5 = 0;
                    Label_0095: {
                        Label_0092: {
                            if (n4 != 1) {
                                if (n4 != 2) {
                                    if (n4 != 3) {
                                        break Label_0113;
                                    }
                                    if (n != 1) {
                                        break Label_0092;
                                    }
                                }
                                n5 = 2;
                                break Label_0095;
                            }
                        }
                        n5 = 1;
                    }
                    final int n6 = n5;
                    n = n5;
                    n2 = n6;
                }
                else {
                    n2 = 3;
                }
            }
            final double n7 = a[n3];
            final int n8 = n3 + 1;
            b[n3] = new a(n2, n7, a[n8], array2[n3][0], array2[n3][1], array2[n8][0], array2[n8][1]);
            n3 = n8;
        }
    }
    
    @Override
    public double c(double n, final int n2) {
        final boolean c = this.c;
        final int n3 = 0;
        int n7 = 0;
        double n8 = 0.0;
        Label_0372: {
            if (c) {
                final a[] b = this.b;
                double n4;
                double n6;
                if (n < b[0].c) {
                    final double c2 = b[0].c;
                    n4 = n - b[0].c;
                    if (!b[0].r) {
                        b[0].k(c2);
                        double n5;
                        if (n2 == 0) {
                            n = this.b[0].h();
                            n5 = this.b[0].b();
                        }
                        else {
                            n = this.b[0].i();
                            n5 = this.b[0].c();
                        }
                        return n + n4 * n5;
                    }
                    if (n2 == 0) {
                        n6 = b[0].f(c2);
                        n = this.b[0].d(c2);
                    }
                    else {
                        n6 = b[0].g(c2);
                        n = this.b[0].e(c2);
                    }
                }
                else {
                    n7 = n3;
                    n8 = n;
                    if (n <= b[b.length - 1].d) {
                        break Label_0372;
                    }
                    final double d = b[b.length - 1].d;
                    n4 = n - d;
                    final int n9 = b.length - 1;
                    if (n2 == 0) {
                        n6 = b[n9].f(d);
                        n = this.b[n9].d(d);
                    }
                    else {
                        n6 = b[n9].g(d);
                        n = this.b[n9].e(d);
                    }
                }
                return n6 + n4 * n;
            }
            final a[] b2 = this.b;
            if (n < b2[0].c) {
                n8 = b2[0].c;
                n7 = n3;
            }
            else {
                n7 = n3;
                n8 = n;
                if (n > b2[b2.length - 1].d) {
                    n8 = b2[b2.length - 1].d;
                    n7 = n3;
                }
            }
        }
        while (true) {
            final a[] b3 = this.b;
            if (n7 >= b3.length) {
                return Double.NaN;
            }
            if (n8 <= b3[n7].d) {
                if (b3[n7].r) {
                    if (n2 == 0) {
                        return b3[n7].f(n8);
                    }
                    return b3[n7].g(n8);
                }
                else {
                    b3[n7].k(n8);
                    if (n2 == 0) {
                        return this.b[n7].h();
                    }
                    return this.b[n7].i();
                }
            }
            else {
                ++n7;
            }
        }
    }
    
    @Override
    public void d(double n, final double[] array) {
        double d;
        if (this.c) {
            final a[] b = this.b;
            if (n < b[0].c) {
                final double c = b[0].c;
                n -= b[0].c;
                if (b[0].r) {
                    array[0] = b[0].f(c) + this.b[0].d(c) * n;
                    array[1] = this.b[0].g(c) + n * this.b[0].e(c);
                }
                else {
                    b[0].k(c);
                    array[0] = this.b[0].h() + this.b[0].b() * n;
                    array[1] = this.b[0].i() + n * this.b[0].c();
                }
                return;
            }
            d = n;
            if (n > b[b.length - 1].d) {
                final double d2 = b[b.length - 1].d;
                final double n2 = n - d2;
                final int n3 = b.length - 1;
                if (b[n3].r) {
                    array[0] = b[n3].f(d2) + this.b[n3].d(d2) * n2;
                    array[1] = this.b[n3].g(d2) + n2 * this.b[n3].e(d2);
                }
                else {
                    b[n3].k(n);
                    array[0] = this.b[n3].h() + this.b[n3].b() * n2;
                    array[1] = this.b[n3].i() + n2 * this.b[n3].c();
                }
                return;
            }
        }
        else {
            final a[] b2 = this.b;
            double c2 = n;
            if (n < b2[0].c) {
                c2 = b2[0].c;
            }
            d = c2;
            if (c2 > b2[b2.length - 1].d) {
                d = b2[b2.length - 1].d;
            }
        }
        int n4 = 0;
        while (true) {
            final a[] b3 = this.b;
            if (n4 >= b3.length) {
                return;
            }
            if (d <= b3[n4].d) {
                if (b3[n4].r) {
                    array[0] = b3[n4].f(d);
                    array[1] = this.b[n4].g(d);
                    return;
                }
                b3[n4].k(d);
                array[0] = this.b[n4].h();
                array[1] = this.b[n4].i();
            }
            else {
                ++n4;
            }
        }
    }
    
    @Override
    public void e(double n, final float[] array) {
        double n2;
        if (this.c) {
            final a[] b = this.b;
            if (n < b[0].c) {
                final double c = b[0].c;
                n -= b[0].c;
                if (b[0].r) {
                    array[0] = (float)(b[0].f(c) + this.b[0].d(c) * n);
                    array[1] = (float)(this.b[0].g(c) + n * this.b[0].e(c));
                }
                else {
                    b[0].k(c);
                    array[0] = (float)(this.b[0].h() + this.b[0].b() * n);
                    array[1] = (float)(this.b[0].i() + n * this.b[0].c());
                }
                return;
            }
            n2 = n;
            if (n > b[b.length - 1].d) {
                final double d = b[b.length - 1].d;
                final double n3 = n - d;
                final int n4 = b.length - 1;
                if (b[n4].r) {
                    array[0] = (float)(b[n4].f(d) + this.b[n4].d(d) * n3);
                    array[1] = (float)(this.b[n4].g(d) + n3 * this.b[n4].e(d));
                }
                else {
                    b[n4].k(n);
                    array[0] = (float)this.b[n4].h();
                    array[1] = (float)this.b[n4].i();
                }
                return;
            }
        }
        else {
            final a[] b2 = this.b;
            if (n < b2[0].c) {
                n2 = b2[0].c;
            }
            else {
                n2 = n;
                if (n > b2[b2.length - 1].d) {
                    n2 = b2[b2.length - 1].d;
                }
            }
        }
        int n5 = 0;
        while (true) {
            final a[] b3 = this.b;
            if (n5 >= b3.length) {
                return;
            }
            if (n2 <= b3[n5].d) {
                if (b3[n5].r) {
                    array[0] = (float)b3[n5].f(n2);
                    array[1] = (float)this.b[n5].g(n2);
                    return;
                }
                b3[n5].k(n2);
                array[0] = (float)this.b[n5].h();
                array[1] = (float)this.b[n5].i();
            }
            else {
                ++n5;
            }
        }
    }
    
    @Override
    public void f(final double n, final double[] array) {
        final a[] b = this.b;
        double n2;
        if (n < b[0].c) {
            n2 = b[0].c;
        }
        else {
            n2 = n;
            if (n > b[b.length - 1].d) {
                n2 = b[b.length - 1].d;
            }
        }
        int n3 = 0;
        while (true) {
            final a[] b2 = this.b;
            if (n3 >= b2.length) {
                return;
            }
            if (n2 <= b2[n3].d) {
                if (b2[n3].r) {
                    array[0] = b2[n3].d(n2);
                    array[1] = this.b[n3].e(n2);
                    return;
                }
                b2[n3].k(n2);
                array[0] = this.b[n3].b();
                array[1] = this.b[n3].c();
            }
            else {
                ++n3;
            }
        }
    }
    
    @Override
    public double[] g() {
        return this.a;
    }
    
    private static class a
    {
        private static double[] s;
        double[] a;
        double b;
        double c;
        double d;
        double e;
        double f;
        double g;
        double h;
        double i;
        double j;
        double k;
        double l;
        double m;
        double n;
        double o;
        double p;
        boolean q;
        boolean r;
        
        static {
            a.s = new double[91];
        }
        
        a(int n, double m, double d, double n2, double d2, final double f, final double h) {
            boolean q = false;
            this.r = false;
            final int n3 = 1;
            if (n == 1) {
                q = true;
            }
            this.q = q;
            this.c = m;
            this.d = d;
            this.i = 1.0 / (d - m);
            if (3 == n) {
                this.r = true;
            }
            d = f - n2;
            m = h - d2;
            if (!this.r && Math.abs(d) >= 0.001 && Math.abs(m) >= 0.001) {
                this.a = new double[101];
                final boolean q2 = this.q;
                if (q2) {
                    n = -1;
                }
                else {
                    n = 1;
                }
                this.j = d * n;
                if (q2) {
                    n = n3;
                }
                else {
                    n = -1;
                }
                this.k = m * n;
                if (q2) {
                    m = f;
                }
                else {
                    m = n2;
                }
                this.l = m;
                if (q2) {
                    m = d2;
                }
                else {
                    m = h;
                }
                this.m = m;
                this.a(n2, d2, f, h);
                this.n = this.b * this.i;
                return;
            }
            this.r = true;
            this.e = n2;
            this.f = f;
            this.g = d2;
            this.h = h;
            n2 = Math.hypot(m, d);
            this.b = n2;
            this.n = n2 * this.i;
            d2 = this.d;
            n2 = this.c;
            this.l = d / (d2 - n2);
            this.m = m / (d2 - n2);
        }
        
        private void a(double n, double n2, final double n3, final double n4) {
            int n5 = 0;
            double b = 0.0;
            double n6 = 0.0;
            double n7 = 0.0;
            while (true) {
                final double[] s = o.a.a.s;
                if (n5 >= s.length) {
                    break;
                }
                final double radians = Math.toRadians(n5 * 90.0 / (s.length - 1));
                final double sin = Math.sin(radians);
                final double cos = Math.cos(radians);
                final double n8 = sin * (n3 - n);
                final double n9 = cos * (n2 - n4);
                if (n5 > 0) {
                    b += Math.hypot(n8 - n6, n9 - n7);
                    o.a.a.s[n5] = b;
                }
                ++n5;
                n7 = n9;
                n6 = n8;
            }
            this.b = b;
            int n10 = 0;
            while (true) {
                final double[] s2 = o.a.a.s;
                if (n10 >= s2.length) {
                    break;
                }
                s2[n10] /= b;
                ++n10;
            }
            int n11 = 0;
            while (true) {
                final double[] a = this.a;
                if (n11 >= a.length) {
                    break;
                }
                n2 = n11 / (double)(a.length - 1);
                final int binarySearch = Arrays.binarySearch(o.a.a.s, n2);
                if (binarySearch >= 0) {
                    this.a[n11] = binarySearch / (double)(o.a.a.s.length - 1);
                }
                else if (binarySearch == -1) {
                    this.a[n11] = 0.0;
                }
                else {
                    final int n12 = -binarySearch;
                    final int n13 = n12 - 2;
                    n = n13;
                    final double[] s3 = o.a.a.s;
                    n = (n + (n2 - s3[n13]) / (s3[n12 - 1] - s3[n13])) / (s3.length - 1);
                    this.a[n11] = n;
                }
                ++n11;
            }
        }
        
        double b() {
            final double n = this.j * this.p;
            final double n2 = this.n / Math.hypot(n, -this.k * this.o);
            double n3 = n;
            if (this.q) {
                n3 = -n;
            }
            return n3 * n2;
        }
        
        double c() {
            final double j = this.j;
            final double p = this.p;
            final double n = -this.k * this.o;
            final double n2 = this.n / Math.hypot(j * p, n);
            double n3;
            if (this.q) {
                n3 = -n * n2;
            }
            else {
                n3 = n * n2;
            }
            return n3;
        }
        
        public double d(final double n) {
            return this.l;
        }
        
        public double e(final double n) {
            return this.m;
        }
        
        public double f(final double n) {
            final double c = this.c;
            final double i = this.i;
            final double e = this.e;
            return e + (n - c) * i * (this.f - e);
        }
        
        public double g(final double n) {
            final double c = this.c;
            final double i = this.i;
            final double g = this.g;
            return g + (n - c) * i * (this.h - g);
        }
        
        double h() {
            return this.l + this.j * this.o;
        }
        
        double i() {
            return this.m + this.k * this.p;
        }
        
        double j(double n) {
            if (n <= 0.0) {
                return 0.0;
            }
            if (n >= 1.0) {
                return 1.0;
            }
            final double[] a = this.a;
            n *= a.length - 1;
            final int n2 = (int)n;
            return a[n2] + (n - n2) * (a[n2 + 1] - a[n2]);
        }
        
        void k(double n) {
            if (this.q) {
                n = this.d - n;
            }
            else {
                n -= this.c;
            }
            n = this.j(n * this.i) * 1.5707963267948966;
            this.o = Math.sin(n);
            this.p = Math.cos(n);
        }
    }
}
