// 
// Decompiled by Procyon v0.6.0
// 

package androidx.core.content.res;

import android.graphics.Color;
import androidx.core.graphics.d;

final class b
{
    static final float[][] a;
    static final float[][] b;
    static final float[] c;
    static final float[][] d;
    
    static {
        a = new float[][] { { 0.401288f, 0.650173f, -0.051461f }, { -0.250268f, 1.204414f, 0.045854f }, { -0.002079f, 0.048952f, 0.953127f } };
        b = new float[][] { { 1.8620678f, -1.0112547f, 0.14918678f }, { 0.38752654f, 0.62144744f, -0.00897398f }, { -0.0158415f, -0.03412294f, 1.0499644f } };
        c = new float[] { 95.047f, 100.0f, 108.883f };
        d = new float[][] { { 0.41233894f, 0.35762063f, 0.18051042f }, { 0.2126f, 0.7152f, 0.0722f }, { 0.01932141f, 0.11916382f, 0.9503448f } };
    }
    
    static int a(float n) {
        if (n < 1.0f) {
            return -16777216;
        }
        if (n > 99.0f) {
            return -1;
        }
        final float n2 = (n + 16.0f) / 116.0f;
        if (n > 8.0f) {
            n = n2 * n2 * n2;
        }
        else {
            n /= 903.2963f;
        }
        float n3 = n2 * n2 * n2;
        final boolean b = n3 > 0.008856452f;
        float n4;
        if (b) {
            n4 = n3;
        }
        else {
            n4 = (n2 * 116.0f - 16.0f) / 903.2963f;
        }
        if (!b) {
            n3 = (n2 * 116.0f - 16.0f) / 903.2963f;
        }
        final float[] c = androidx.core.content.res.b.c;
        return androidx.core.graphics.d.b(n4 * c[0], n * c[1], n3 * c[2]);
    }
    
    static float b(final int n) {
        return c(g(n));
    }
    
    static float c(float n) {
        n /= 100.0f;
        if (n <= 0.008856452f) {
            return n * 903.2963f;
        }
        return (float)Math.cbrt(n) * 116.0f - 16.0f;
    }
    
    static float d(final float n, final float n2, final float n3) {
        return n + (n2 - n) * n3;
    }
    
    static float e(final int n) {
        final float n2 = n / 255.0f;
        float n3;
        if (n2 <= 0.04045f) {
            n3 = n2 / 12.92f;
        }
        else {
            n3 = (float)Math.pow((n2 + 0.055f) / 1.055f, 2.4000000953674316);
        }
        return n3 * 100.0f;
    }
    
    static float[] f(final int n) {
        final float e = e(Color.red(n));
        final float e2 = e(Color.green(n));
        final float e3 = e(Color.blue(n));
        final float[][] d = androidx.core.content.res.b.d;
        return new float[] { d[0][0] * e + d[0][1] * e2 + d[0][2] * e3, d[1][0] * e + d[1][1] * e2 + d[1][2] * e3, e * d[2][0] + e2 * d[2][1] + e3 * d[2][2] };
    }
    
    static float g(final int n) {
        final float e = e(Color.red(n));
        final float e2 = e(Color.green(n));
        final float e3 = e(Color.blue(n));
        final float[][] d = androidx.core.content.res.b.d;
        return e * d[1][0] + e2 * d[1][1] + e3 * d[1][2];
    }
    
    static float h(float n) {
        if (n > 8.0f) {
            n = (float)Math.pow((n + 16.0) / 116.0, 3.0);
        }
        else {
            n /= 903.2963f;
        }
        return n * 100.0f;
    }
}
