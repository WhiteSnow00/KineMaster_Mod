// 
// Decompiled by Procyon v0.6.0
// 

package androidx.core.content.res;

import androidx.core.graphics.d;

class a
{
    private final float a;
    private final float b;
    private final float c;
    private final float d;
    private final float e;
    private final float f;
    private final float g;
    private final float h;
    private final float i;
    
    a(final float a, final float b, final float c, final float d, final float e, final float f, final float g, final float h, final float i) {
        this.a = a;
        this.b = b;
        this.c = c;
        this.d = d;
        this.e = e;
        this.f = f;
        this.g = g;
        this.h = h;
        this.i = i;
    }
    
    private static a b(final float n, final float n2, final float n3) {
        float n4 = 1000.0f;
        float n5 = 0.0f;
        a a = null;
        float n6 = 100.0f;
        float n7 = 1000.0f;
        a a2;
        while (true) {
            a2 = a;
            if (Math.abs(n5 - n6) <= 0.01f) {
                break;
            }
            final float n8 = (n6 - n5) / 2.0f + n5;
            final int p3 = e(n8, n2, n).p();
            final float b = androidx.core.content.res.b.b(p3);
            final float abs = Math.abs(n3 - b);
            float n9 = n4;
            float n10 = n7;
            a2 = a;
            if (abs < 0.2f) {
                final a c = c(p3);
                final float a3 = c.a(e(c.k(), c.i(), n));
                n9 = n4;
                n10 = n7;
                a2 = a;
                if (a3 <= 1.0f) {
                    a2 = c;
                    n9 = abs;
                    n10 = a3;
                }
            }
            if (n9 == 0.0f && n10 == 0.0f) {
                break;
            }
            if (b < n3) {
                n5 = n8;
                n4 = n9;
                n7 = n10;
                a = a2;
            }
            else {
                n6 = n8;
                n4 = n9;
                n7 = n10;
                a = a2;
            }
        }
        return a2;
    }
    
    static a c(final int n) {
        return d(n, j.k);
    }
    
    static a d(final int n, final j j) {
        final float[] f = b.f(n);
        final float[][] a = b.a;
        final float n2 = f[0];
        final float n3 = a[0][0];
        final float n4 = f[1];
        final float n5 = a[0][1];
        final float n6 = f[2];
        final float n7 = a[0][2];
        final float n8 = f[0];
        final float n9 = a[1][0];
        final float n10 = f[1];
        final float n11 = a[1][1];
        final float n12 = f[2];
        final float n13 = a[1][2];
        final float n14 = f[0];
        final float n15 = a[2][0];
        final float n16 = f[1];
        final float n17 = a[2][1];
        final float n18 = f[2];
        final float n19 = a[2][2];
        final float n20 = j.i()[0] * (n2 * n3 + n4 * n5 + n6 * n7);
        final float n21 = j.i()[1] * (n8 * n9 + n10 * n11 + n12 * n13);
        final float n22 = j.i()[2] * (n14 * n15 + n16 * n17 + n18 * n19);
        final float n23 = (float)Math.pow(j.c() * Math.abs(n20) / 100.0, 0.42);
        final float n24 = (float)Math.pow(j.c() * Math.abs(n21) / 100.0, 0.42);
        final float n25 = (float)Math.pow(j.c() * Math.abs(n22) / 100.0, 0.42);
        final float n26 = Math.signum(n20) * 400.0f * n23 / (n23 + 27.13f);
        final float n27 = Math.signum(n21) * 400.0f * n24 / (n24 + 27.13f);
        final float n28 = Math.signum(n22) * 400.0f * n25 / (n25 + 27.13f);
        final double n29 = n26;
        final double n30 = n27;
        final double n31 = n28;
        final float n32 = (float)(n29 * 11.0 + n30 * -12.0 + n31) / 11.0f;
        final float n33 = (float)(n26 + n27 - n31 * 2.0) / 9.0f;
        final float n34 = n27 * 20.0f;
        final float n35 = (n26 * 20.0f + n34 + 21.0f * n28) / 20.0f;
        final float n36 = (n26 * 40.0f + n34 + n28) / 20.0f;
        final float n37 = (float)Math.atan2(n33, n32) * 180.0f / 3.1415927f;
        float n38;
        if (n37 < 0.0f) {
            n38 = n37 + 360.0f;
        }
        else {
            n38 = n37;
            if (n37 >= 360.0f) {
                n38 = n37 - 360.0f;
            }
        }
        final float n39 = 3.1415927f * n38 / 180.0f;
        final float n40 = (float)Math.pow(n36 * j.f() / j.a(), j.b() * j.j()) * 100.0f;
        final float n41 = 4.0f / j.b();
        final float n42 = (float)Math.sqrt(n40 / 100.0f);
        final float a2 = j.a();
        final float d = j.d();
        float n43;
        if (n38 < 20.14) {
            n43 = 360.0f + n38;
        }
        else {
            n43 = n38;
        }
        final float n44 = (float)Math.pow(1.64 - Math.pow(0.29, j.e()), 0.73) * (float)Math.pow((float)(Math.cos(n43 * 3.141592653589793 / 180.0 + 2.0) + 3.8) * 0.25f * 3846.1538f * j.g() * j.h() * (float)Math.sqrt(n32 * n32 + n33 * n33) / (n35 + 0.305f), 0.9);
        final float n45 = n44 * (float)Math.sqrt(n40 / 100.0);
        final float n46 = n45 * j.d();
        final float n47 = (float)Math.sqrt(n44 * j.b() / (j.a() + 4.0f));
        final float n48 = 1.7f * n40 / (0.007f * n40 + 1.0f);
        final float n49 = (float)Math.log(0.0228f * n46 + 1.0f) * 43.85965f;
        final double n50 = n39;
        return new a(n38, n45, n40, d * (n41 * n42 * (a2 + 4.0f)), n46, n47 * 50.0f, n48, n49 * (float)Math.cos(n50), n49 * (float)Math.sin(n50));
    }
    
    private static a e(final float n, final float n2, final float n3) {
        return f(n, n2, n3, j.k);
    }
    
    private static a f(final float n, final float n2, final float n3, final j j) {
        final float n4 = 4.0f / j.b();
        final double n5 = n / 100.0;
        final float n6 = (float)Math.sqrt(n5);
        final float a = j.a();
        final float d = j.d();
        final float n7 = n2 * j.d();
        final float n8 = (float)Math.sqrt(n2 / (float)Math.sqrt(n5) * j.b() / (j.a() + 4.0f));
        final float n9 = 3.1415927f * n3 / 180.0f;
        final float n10 = 1.7f * n / (0.007f * n + 1.0f);
        final float n11 = (float)Math.log(n7 * 0.0228 + 1.0) * 43.85965f;
        final double n12 = n9;
        return new a(n3, n2, n, n4 * n6 * (a + 4.0f) * d, n7, n8 * 50.0f, n10, n11 * (float)Math.cos(n12), n11 * (float)Math.sin(n12));
    }
    
    static int m(final float n, final float n2, final float n3) {
        return n(n, n2, n3, j.k);
    }
    
    static int n(float n, float n2, final float n3, final j j) {
        if (n2 < 1.0 || Math.round(n3) <= 0.0 || Math.round(n3) >= 100.0) {
            return b.a(n3);
        }
        float min;
        if (n < 0.0f) {
            min = 0.0f;
        }
        else {
            min = Math.min(360.0f, n);
        }
        a a = null;
        int n4 = 1;
        float n5 = 0.0f;
        n = n2;
        while (Math.abs(n5 - n2) >= 0.4f) {
            final a b = b(min, n, n3);
            if (n4 != 0) {
                if (b != null) {
                    return b.o(j);
                }
                n4 = 0;
            }
            else if (b == null) {
                n2 = n;
            }
            else {
                a = b;
                n5 = n;
            }
            n = (n2 - n5) / 2.0f + n5;
        }
        if (a == null) {
            return b.a(n3);
        }
        return a.o(j);
    }
    
    float a(final a a) {
        final float n = this.l() - a.l();
        final float n2 = this.g() - a.g();
        final float n3 = this.h() - a.h();
        return (float)(Math.pow(Math.sqrt(n * n + n2 * n2 + n3 * n3), 0.63) * 1.41);
    }
    
    float g() {
        return this.h;
    }
    
    float h() {
        return this.i;
    }
    
    float i() {
        return this.b;
    }
    
    float j() {
        return this.a;
    }
    
    float k() {
        return this.c;
    }
    
    float l() {
        return this.g;
    }
    
    int o(final j j) {
        float n;
        if (this.i() != 0.0 && this.k() != 0.0) {
            n = this.i() / (float)Math.sqrt(this.k() / 100.0);
        }
        else {
            n = 0.0f;
        }
        final float n2 = (float)Math.pow(n / Math.pow(1.64 - Math.pow(0.29, j.e()), 0.73), 1.1111111111111112);
        final double n3 = this.j() * 3.1415927f / 180.0f;
        final float n4 = (float)(Math.cos(2.0 + n3) + 3.8);
        final float a = j.a();
        final float n5 = (float)Math.pow(this.k() / 100.0, 1.0 / j.b() / j.j());
        final float g = j.g();
        final float h = j.h();
        final float n6 = a * n5 / j.f();
        final float n7 = (float)Math.sin(n3);
        final float n8 = (float)Math.cos(n3);
        final float n9 = (0.305f + n6) * 23.0f * n2 / (n4 * 0.25f * 3846.1538f * g * h * 23.0f + 11.0f * n2 * n8 + n2 * 108.0f * n7);
        final float n10 = n8 * n9;
        final float n11 = n9 * n7;
        final float n12 = n6 * 460.0f;
        final float n13 = (451.0f * n10 + n12 + 288.0f * n11) / 1403.0f;
        final float n14 = (n12 - 891.0f * n10 - 261.0f * n11) / 1403.0f;
        final float n15 = (n12 - n10 * 220.0f - n11 * 6300.0f) / 1403.0f;
        final float n16 = (float)Math.max(0.0, Math.abs(n13) * 27.13 / (400.0 - Math.abs(n13)));
        final float signum = Math.signum(n13);
        final float n17 = 100.0f / j.c();
        final float n18 = (float)Math.pow(n16, 2.380952380952381);
        final float n19 = (float)Math.max(0.0, Math.abs(n14) * 27.13 / (400.0 - Math.abs(n14)));
        final float signum2 = Math.signum(n14);
        final float n20 = 100.0f / j.c();
        final float n21 = (float)Math.pow(n19, 2.380952380952381);
        final float n22 = (float)Math.max(0.0, Math.abs(n15) * 27.13 / (400.0 - Math.abs(n15)));
        final float signum3 = Math.signum(n15);
        final float n23 = 100.0f / j.c();
        final float n24 = (float)Math.pow(n22, 2.380952380952381);
        final float n25 = signum * n17 * n18 / j.i()[0];
        final float n26 = signum2 * n20 * n21 / j.i()[1];
        final float n27 = signum3 * n23 * n24 / j.i()[2];
        final float[][] b = androidx.core.content.res.b.b;
        return androidx.core.graphics.d.b(b[0][0] * n25 + b[0][1] * n26 + b[0][2] * n27, b[1][0] * n25 + b[1][1] * n26 + b[1][2] * n27, n25 * b[2][0] + n26 * b[2][1] + n27 * b[2][2]);
    }
    
    int p() {
        return this.o(j.k);
    }
}
