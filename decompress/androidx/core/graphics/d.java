// 
// Decompiled by Procyon v0.6.0
// 

package androidx.core.graphics;

import android.graphics.Color;

public final class d
{
    private static final ThreadLocal<double[]> a;
    
    static {
        a = new ThreadLocal<double[]>();
    }
    
    public static void a(final int n, final int n2, final int n3, final double[] array) {
        if (array.length == 3) {
            final double n4 = n / 255.0;
            double pow;
            if (n4 < 0.04045) {
                pow = n4 / 12.92;
            }
            else {
                pow = Math.pow((n4 + 0.055) / 1.055, 2.4);
            }
            final double n5 = n2 / 255.0;
            double pow2;
            if (n5 < 0.04045) {
                pow2 = n5 / 12.92;
            }
            else {
                pow2 = Math.pow((n5 + 0.055) / 1.055, 2.4);
            }
            final double n6 = n3 / 255.0;
            double pow3;
            if (n6 < 0.04045) {
                pow3 = n6 / 12.92;
            }
            else {
                pow3 = Math.pow((n6 + 0.055) / 1.055, 2.4);
            }
            array[0] = (0.4124 * pow + 0.3576 * pow2 + 0.1805 * pow3) * 100.0;
            array[1] = (0.2126 * pow + 0.7152 * pow2 + 0.0722 * pow3) * 100.0;
            array[2] = (pow * 0.0193 + pow2 * 0.1192 + pow3 * 0.9505) * 100.0;
            return;
        }
        throw new IllegalArgumentException("outXyz must have a length of 3.");
    }
    
    public static int b(double n, double n2, double n3) {
        final double n4 = (3.2406 * n + -1.5372 * n2 + -0.4986 * n3) / 100.0;
        final double n5 = (-0.9689 * n + 1.8758 * n2 + 0.0415 * n3) / 100.0;
        n3 = (0.0557 * n + -0.204 * n2 + 1.057 * n3) / 100.0;
        if (n4 > 0.0031308) {
            n = Math.pow(n4, 0.4166666666666667) * 1.055 - 0.055;
        }
        else {
            n = n4 * 12.92;
        }
        if (n5 > 0.0031308) {
            n2 = Math.pow(n5, 0.4166666666666667) * 1.055 - 0.055;
        }
        else {
            n2 = n5 * 12.92;
        }
        if (n3 > 0.0031308) {
            n3 = Math.pow(n3, 0.4166666666666667) * 1.055 - 0.055;
        }
        else {
            n3 *= 12.92;
        }
        return Color.rgb(h((int)Math.round(n * 255.0), 0, 255), h((int)Math.round(n2 * 255.0), 0, 255), h((int)Math.round(n3 * 255.0), 0, 255));
    }
    
    public static double c(final int n) {
        final double[] i = i();
        d(n, i);
        return i[1] / 100.0;
    }
    
    public static void d(final int n, final double[] array) {
        a(Color.red(n), Color.green(n), Color.blue(n), array);
    }
    
    private static int e(final int n, final int n2) {
        return 255 - (255 - n2) * (255 - n) / 255;
    }
    
    public static int f(final int n, final int n2) {
        final int alpha = Color.alpha(n2);
        final int alpha2 = Color.alpha(n);
        final int e = e(alpha2, alpha);
        return Color.argb(e, g(Color.red(n), alpha2, Color.red(n2), alpha, e), g(Color.green(n), alpha2, Color.green(n2), alpha, e), g(Color.blue(n), alpha2, Color.blue(n2), alpha, e));
    }
    
    private static int g(final int n, final int n2, final int n3, final int n4, final int n5) {
        if (n5 == 0) {
            return 0;
        }
        return (n * 255 * n2 + n3 * n4 * (255 - n2)) / (n5 * 255);
    }
    
    private static int h(final int n, int min, final int n2) {
        if (n >= min) {
            min = Math.min(n, n2);
        }
        return min;
    }
    
    private static double[] i() {
        final ThreadLocal<double[]> a = d.a;
        double[] array;
        if ((array = a.get()) == null) {
            array = new double[3];
            a.set(array);
        }
        return array;
    }
    
    public static int j(final int n, final int n2) {
        if (n2 >= 0 && n2 <= 255) {
            return (n & 0xFFFFFF) | n2 << 24;
        }
        throw new IllegalArgumentException("alpha must be between 0 and 255.");
    }
}
