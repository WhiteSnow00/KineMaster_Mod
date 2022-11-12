// 
// Decompiled by Procyon v0.6.0
// 

package o;

public class f extends b
{
    private double[] a;
    private double[][] b;
    private double c;
    private boolean d;
    double[] e;
    
    public f(final double[] a, final double[][] b) {
        this.c = Double.NaN;
        this.d = true;
        final int length = a.length;
        final int length2 = b[0].length;
        this.e = new double[length2];
        this.a = a;
        this.b = b;
        if (length2 > 2) {
            int i = 0;
            double n = 0.0;
            double n2 = 0.0;
            while (i < a.length) {
                final double n3 = b[i][0];
                final double n4 = b[i][0];
                if (i > 0) {
                    Math.hypot(n3 - n, n4 - n2);
                }
                ++i;
                n = n3;
                n2 = n4;
            }
            this.c = 0.0;
        }
    }
    
    @Override
    public double c(double n, final int n2) {
        final double[] a = this.a;
        final int length = a.length;
        final boolean d = this.d;
        int i = 0;
        if (d) {
            if (n <= a[0]) {
                return this.b[0][n2] + (n - a[0]) * this.h(a[0], n2);
            }
            final int n3 = length - 1;
            if (n >= a[n3]) {
                return this.b[n3][n2] + (n - a[n3]) * this.h(a[n3], n2);
            }
        }
        else {
            if (n <= a[0]) {
                return this.b[0][n2];
            }
            final int n4 = length - 1;
            if (n >= a[n4]) {
                return this.b[n4][n2];
            }
        }
        while (i < length - 1) {
            final double[] a2 = this.a;
            if (n == a2[i]) {
                return this.b[i][n2];
            }
            final int n5 = i + 1;
            if (n < a2[n5]) {
                n = (n - a2[i]) / (a2[n5] - a2[i]);
                final double[][] b = this.b;
                return b[i][n2] * (1.0 - n) + b[n5][n2] * n;
            }
            i = n5;
        }
        return 0.0;
    }
    
    @Override
    public void d(double n, final double[] array) {
        final double[] a = this.a;
        final int length = a.length;
        final double[][] b = this.b;
        int i = 0;
        final int n2 = 0;
        final int n3 = 0;
        final int length2 = b[0].length;
        if (this.d) {
            if (n <= a[0]) {
                this.f(a[0], this.e);
                for (int j = 0; j < length2; ++j) {
                    array[j] = this.b[0][j] + (n - this.a[0]) * this.e[j];
                }
                return;
            }
            final int n4 = length - 1;
            if (n >= a[n4]) {
                this.f(a[n4], this.e);
                for (int k = n3; k < length2; ++k) {
                    array[k] = this.b[n4][k] + (n - this.a[n4]) * this.e[k];
                }
                return;
            }
        }
        else {
            if (n <= a[0]) {
                for (int l = 0; l < length2; ++l) {
                    array[l] = this.b[0][l];
                }
                return;
            }
            final int n5 = length - 1;
            if (n >= a[n5]) {
                while (i < length2) {
                    array[i] = this.b[n5][i];
                    ++i;
                }
                return;
            }
        }
        int n8;
        for (int n6 = 0; n6 < length - 1; n6 = n8) {
            if (n == this.a[n6]) {
                for (int n7 = 0; n7 < length2; ++n7) {
                    array[n7] = this.b[n6][n7];
                }
            }
            final double[] a2 = this.a;
            n8 = n6 + 1;
            if (n < a2[n8]) {
                n = (n - a2[n6]) / (a2[n8] - a2[n6]);
                for (int n9 = n2; n9 < length2; ++n9) {
                    final double[][] b2 = this.b;
                    array[n9] = b2[n6][n9] * (1.0 - n) + b2[n8][n9] * n;
                }
                return;
            }
        }
    }
    
    @Override
    public void e(double n, final float[] array) {
        final double[] a = this.a;
        final int length = a.length;
        final double[][] b = this.b;
        int i = 0;
        final int n2 = 0;
        final int n3 = 0;
        final int length2 = b[0].length;
        if (this.d) {
            if (n <= a[0]) {
                this.f(a[0], this.e);
                for (int j = 0; j < length2; ++j) {
                    array[j] = (float)(this.b[0][j] + (n - this.a[0]) * this.e[j]);
                }
                return;
            }
            final int n4 = length - 1;
            if (n >= a[n4]) {
                this.f(a[n4], this.e);
                for (int k = n3; k < length2; ++k) {
                    array[k] = (float)(this.b[n4][k] + (n - this.a[n4]) * this.e[k]);
                }
                return;
            }
        }
        else {
            if (n <= a[0]) {
                for (int l = 0; l < length2; ++l) {
                    array[l] = (float)this.b[0][l];
                }
                return;
            }
            final int n5 = length - 1;
            if (n >= a[n5]) {
                while (i < length2) {
                    array[i] = (float)this.b[n5][i];
                    ++i;
                }
                return;
            }
        }
        int n8;
        for (int n6 = 0; n6 < length - 1; n6 = n8) {
            if (n == this.a[n6]) {
                for (int n7 = 0; n7 < length2; ++n7) {
                    array[n7] = (float)this.b[n6][n7];
                }
            }
            final double[] a2 = this.a;
            n8 = n6 + 1;
            if (n < a2[n8]) {
                n = (n - a2[n6]) / (a2[n8] - a2[n6]);
                for (int n9 = n2; n9 < length2; ++n9) {
                    final double[][] b2 = this.b;
                    array[n9] = (float)(b2[n6][n9] * (1.0 - n) + b2[n8][n9] * n);
                }
                return;
            }
        }
    }
    
    @Override
    public void f(double n, final double[] array) {
        final double[] a = this.a;
        final int length = a.length;
        final double[][] b = this.b;
        int i = 0;
        final int length2 = b[0].length;
        double n2;
        if (n <= a[0]) {
            n2 = a[0];
        }
        else {
            final int n3 = length - 1;
            n2 = n;
            if (n >= a[n3]) {
                n2 = a[n3];
            }
        }
        int n4;
        for (int j = 0; j < length - 1; j = n4) {
            final double[] a2 = this.a;
            n4 = j + 1;
            if (n2 <= a2[n4]) {
                final double n5 = a2[n4];
                n = a2[j];
                final double n6 = a2[j];
                while (i < length2) {
                    final double[][] b2 = this.b;
                    array[i] = (b2[n4][i] - b2[j][i]) / (n5 - n);
                    ++i;
                }
                break;
            }
        }
    }
    
    @Override
    public double[] g() {
        return this.a;
    }
    
    public double h(double n, final int n2) {
        final double[] a = this.a;
        final int length = a.length;
        final int n3 = 0;
        double n4;
        int i;
        if (n < a[0]) {
            n4 = a[0];
            i = n3;
        }
        else {
            final int n5 = length - 1;
            i = n3;
            n4 = n;
            if (n >= a[n5]) {
                n4 = a[n5];
                i = n3;
            }
        }
        while (i < length - 1) {
            final double[] a2 = this.a;
            final int n6 = i + 1;
            if (n4 <= a2[n6]) {
                n = a2[n6];
                final double n7 = a2[i];
                final double n8 = a2[i];
                final double[][] b = this.b;
                return (b[n6][n2] - b[i][n2]) / (n - n7);
            }
            i = n6;
        }
        return 0.0;
    }
}
