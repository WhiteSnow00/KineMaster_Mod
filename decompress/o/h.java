// 
// Decompiled by Procyon v0.6.0
// 

package o;

import java.util.Arrays;

public class h
{
    float[] a;
    double[] b;
    double[] c;
    String d;
    g e;
    int f;
    double g;
    private boolean h;
    
    public h() {
        this.a = new float[0];
        this.b = new double[0];
        this.g = 6.283185307179586;
        this.h = false;
    }
    
    public void a(final double n, final float n2) {
        final int n3 = this.a.length + 1;
        int binarySearch;
        final int n4 = binarySearch = Arrays.binarySearch(this.b, n);
        if (n4 < 0) {
            binarySearch = -n4 - 1;
        }
        this.b = Arrays.copyOf(this.b, n3);
        this.a = Arrays.copyOf(this.a, n3);
        this.c = new double[n3];
        final double[] b = this.b;
        System.arraycopy(b, binarySearch, b, binarySearch + 1, n3 - binarySearch - 1);
        this.b[binarySearch] = n;
        this.a[binarySearch] = n2;
        this.h = false;
    }
    
    double b(double n) {
        final double n2 = 0.0;
        double n3;
        if (n < 0.0) {
            n3 = 0.0;
        }
        else {
            n3 = n;
            if (n > 1.0) {
                n3 = 1.0;
            }
        }
        final int binarySearch = Arrays.binarySearch(this.b, n3);
        if (binarySearch > 0) {
            n = 1.0;
        }
        else {
            n = n2;
            if (binarySearch != 0) {
                final int n4 = -binarySearch - 1;
                final float[] a = this.a;
                final float n5 = a[n4];
                final int n6 = n4 - 1;
                n = n5 - a[n6];
                final double[] b = this.b;
                n /= b[n4] - b[n6];
                n = this.c[n6] + (a[n6] - b[n6] * n) * (n3 - b[n6]) + n * (n3 * n3 - b[n6] * b[n6]) / 2.0;
            }
        }
        return n;
    }
    
    public double c(double abs, final double n) {
        abs = this.b(abs) + n;
        switch (this.f) {
            default: {
                return Math.sin(this.g * abs);
            }
            case 7: {
                return this.e.c(abs % 1.0, 0);
            }
            case 6: {
                abs = 1.0 - Math.abs(abs * 4.0 % 4.0 - 2.0);
                abs *= abs;
                break;
            }
            case 5: {
                return Math.cos(this.g * (n + abs));
            }
            case 4: {
                abs = (abs * 2.0 + 1.0) % 2.0;
                break;
            }
            case 3: {
                return (abs * 2.0 + 1.0) % 2.0 - 1.0;
            }
            case 2: {
                abs = Math.abs((abs * 4.0 + 1.0) % 4.0 - 2.0);
                break;
            }
            case 1: {
                return Math.signum(0.5 - abs % 1.0);
            }
        }
        return 1.0 - abs;
    }
    
    public void d() {
        int n = 0;
        double n2 = 0.0;
        while (true) {
            final float[] a = this.a;
            if (n >= a.length) {
                break;
            }
            n2 += a[n];
            ++n;
        }
        double n3 = 0.0;
        int n4 = 1;
        while (true) {
            final float[] a2 = this.a;
            if (n4 >= a2.length) {
                break;
            }
            final int n5 = n4 - 1;
            final float n6 = (a2[n5] + a2[n4]) / 2.0f;
            final double[] b = this.b;
            n3 += (b[n4] - b[n5]) * n6;
            ++n4;
        }
        int n7 = 0;
        while (true) {
            final float[] a3 = this.a;
            if (n7 >= a3.length) {
                break;
            }
            a3[n7] *= (float)(n2 / n3);
            ++n7;
        }
        this.c[0] = 0.0;
        int n8 = 1;
        while (true) {
            final float[] a4 = this.a;
            if (n8 >= a4.length) {
                break;
            }
            final int n9 = n8 - 1;
            final float n10 = (a4[n9] + a4[n8]) / 2.0f;
            final double[] b2 = this.b;
            final double n11 = b2[n8];
            final double n12 = b2[n9];
            final double[] c = this.c;
            c[n8] = c[n9] + (n11 - n12) * n10;
            ++n8;
        }
        this.h = true;
    }
    
    public void e(final int f, final String d) {
        this.f = f;
        this.d = d;
        if (d != null) {
            this.e = o.g.h(d);
        }
    }
    
    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append("pos =");
        sb.append(Arrays.toString(this.b));
        sb.append(" period=");
        sb.append(Arrays.toString(this.a));
        return sb.toString();
    }
}
