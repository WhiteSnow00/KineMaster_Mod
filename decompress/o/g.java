// 
// Decompiled by Procyon v0.6.0
// 

package o;

import java.util.Arrays;

public class g extends b
{
    private double[] a;
    private double[][] b;
    private double[][] c;
    private boolean d;
    double[] e;
    
    public g(final double[] a, final double[][] b) {
        this.d = true;
        final int length = a.length;
        final int length2 = b[0].length;
        this.e = new double[length2];
        final int n = length - 1;
        final double[][] array = new double[n][length2];
        final double[][] c = new double[length][length2];
        for (int i = 0; i < length2; ++i) {
            int n2;
            for (int j = 0; j < n; j = n2) {
                n2 = j + 1;
                array[j][i] = (b[n2][i] - b[j][i]) / (a[n2] - a[j]);
                if (j == 0) {
                    c[j][i] = array[j][i];
                }
                else {
                    c[j][i] = (array[j - 1][i] + array[j][i]) * 0.5;
                }
            }
            c[n][i] = array[length - 2][i];
        }
        for (int k = 0; k < n; ++k) {
            for (int l = 0; l < length2; ++l) {
                if (array[k][l] == 0.0) {
                    c[k][l] = 0.0;
                    c[k + 1][l] = 0.0;
                }
                else {
                    final double n3 = c[k][l] / array[k][l];
                    final int n4 = k + 1;
                    final double n5 = c[n4][l] / array[k][l];
                    final double hypot = Math.hypot(n3, n5);
                    if (hypot > 9.0) {
                        final double n6 = 3.0 / hypot;
                        c[k][l] = n3 * n6 * array[k][l];
                        c[n4][l] = n6 * n5 * array[k][l];
                    }
                }
            }
        }
        this.a = a;
        this.b = b;
        this.c = c;
    }
    
    public static g h(final String s) {
        final double[] array = new double[s.length() / 2];
        int n;
        int i;
        int n2;
        for (n = s.indexOf(40) + 1, i = s.indexOf(44, n), n2 = 0; i != -1; i = s.indexOf(44, n), ++n2) {
            array[n2] = Double.parseDouble(s.substring(n, i).trim());
            n = i + 1;
        }
        array[n2] = Double.parseDouble(s.substring(n, s.indexOf(41, n)).trim());
        return i(Arrays.copyOf(array, n2 + 1));
    }
    
    private static g i(final double[] array) {
        final int n = array.length * 3 - 2;
        final int n2 = array.length - 1;
        final double n3 = 1.0 / n2;
        final double[][] array2 = new double[n][1];
        final double[] array3 = new double[n];
        for (int i = 0; i < array.length; ++i) {
            final double n4 = array[i];
            final int n5 = i + n2;
            array2[n5][0] = n4;
            final double n6 = i * n3;
            array3[n5] = n6;
            if (i > 0) {
                final int n7 = n2 * 2 + i;
                array2[n7][0] = n4 + 1.0;
                array3[n7] = n6 + 1.0;
                final int n8 = i - 1;
                array2[n8][0] = n4 - 1.0 - n3;
                array3[n8] = n6 - 1.0 - n3;
            }
        }
        return new g(array3, array2);
    }
    
    private static double j(final double n, final double n2, final double n3, final double n4, final double n5, final double n6) {
        final double n7 = n2 * n2;
        final double n8 = n2 * 6.0;
        final double n9 = 3.0 * n;
        return -6.0 * n7 * n4 + n8 * n4 + 6.0 * n7 * n3 - n8 * n3 + n9 * n6 * n7 + n9 * n5 * n7 - 2.0 * n * n6 * n2 - 4.0 * n * n5 * n2 + n * n5;
    }
    
    private static double l(final double n, final double n2, final double n3, final double n4, final double n5, double n6) {
        final double n7 = n2 * n2;
        final double n8 = n7 * n2;
        final double n9 = 3.0 * n7;
        n6 *= n;
        final double n10 = n * n5;
        return -2.0 * n8 * n4 + n9 * n4 + n8 * 2.0 * n3 - n9 * n3 + n3 + n6 * n8 + n8 * n10 - n6 * n7 - n * 2.0 * n5 * n7 + n10 * n2;
    }
    
    @Override
    public double c(double n, final int n2) {
        final double[] a = this.a;
        final int length = a.length;
        final boolean d = this.d;
        int i = 0;
        if (d) {
            if (n <= a[0]) {
                return this.b[0][n2] + (n - a[0]) * this.k(a[0], n2);
            }
            final int n3 = length - 1;
            if (n >= a[n3]) {
                return this.b[n3][n2] + (n - a[n3]) * this.k(a[n3], n2);
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
                final double n6 = a2[n5] - a2[i];
                final double n7 = (n - a2[i]) / n6;
                final double[][] b = this.b;
                n = b[i][n2];
                final double n8 = b[n5][n2];
                final double[][] c = this.c;
                return l(n6, n7, n, n8, c[i][n2], c[n5][n2]);
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
        final int n2 = 0;
        final int n3 = 0;
        int i = 0;
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
                while (i < length2) {
                    array[i] = this.b[n4][i] + (n - this.a[n4]) * this.e[i];
                    ++i;
                }
                return;
            }
        }
        else {
            if (n <= a[0]) {
                for (int k = 0; k < length2; ++k) {
                    array[k] = this.b[0][k];
                }
                return;
            }
            final int n5 = length - 1;
            if (n >= a[n5]) {
                for (int l = n2; l < length2; ++l) {
                    array[l] = this.b[n5][l];
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
                final double n9 = a2[n8] - a2[n6];
                final double n10 = (n - a2[n6]) / n9;
                for (int n11 = n3; n11 < length2; ++n11) {
                    final double[][] b2 = this.b;
                    final double n12 = b2[n6][n11];
                    n = b2[n8][n11];
                    final double[][] c = this.c;
                    array[n11] = l(n9, n10, n12, n, c[n6][n11], c[n8][n11]);
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
        final int n2 = 0;
        final int n3 = 0;
        int i = 0;
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
                while (i < length2) {
                    array[i] = (float)(this.b[n4][i] + (n - this.a[n4]) * this.e[i]);
                    ++i;
                }
                return;
            }
        }
        else {
            if (n <= a[0]) {
                for (int k = 0; k < length2; ++k) {
                    array[k] = (float)this.b[0][k];
                }
                return;
            }
            final int n5 = length - 1;
            if (n >= a[n5]) {
                for (int l = n2; l < length2; ++l) {
                    array[l] = (float)this.b[n5][l];
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
                final double n9 = a2[n8] - a2[n6];
                n = (n - a2[n6]) / n9;
                for (int n10 = n3; n10 < length2; ++n10) {
                    final double[][] b2 = this.b;
                    final double n11 = b2[n6][n10];
                    final double n12 = b2[n8][n10];
                    final double[][] c = this.c;
                    array[n10] = (float)l(n9, n, n11, n12, c[n6][n10], c[n8][n10]);
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
        if (n <= a[0]) {
            n = a[0];
        }
        else {
            final int n2 = length - 1;
            if (n >= a[n2]) {
                n = a[n2];
            }
        }
        int n3;
        for (int j = 0; j < length - 1; j = n3) {
            final double[] a2 = this.a;
            n3 = j + 1;
            if (n <= a2[n3]) {
                final double n4 = a2[n3] - a2[j];
                final double n5 = (n - a2[j]) / n4;
                while (i < length2) {
                    final double[][] b2 = this.b;
                    final double n6 = b2[j][i];
                    n = b2[n3][i];
                    final double[][] c = this.c;
                    array[i] = j(n4, n5, n6, n, c[j][i], c[n3][i]) / n4;
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
    
    public double k(double n, final int n2) {
        final double[] a = this.a;
        final int length = a.length;
        int i = 0;
        if (n < a[0]) {
            n = a[0];
        }
        else {
            final int n3 = length - 1;
            if (n >= a[n3]) {
                n = a[n3];
            }
        }
        while (i < length - 1) {
            final double[] a2 = this.a;
            final int n4 = i + 1;
            if (n <= a2[n4]) {
                final double n5 = a2[n4] - a2[i];
                final double n6 = (n - a2[i]) / n5;
                final double[][] b = this.b;
                final double n7 = b[i][n2];
                n = b[n4][n2];
                final double[][] c = this.c;
                return j(n5, n6, n7, n, c[i][n2], c[n4][n2]) / n5;
            }
            i = n4;
        }
        return 0.0;
    }
}
