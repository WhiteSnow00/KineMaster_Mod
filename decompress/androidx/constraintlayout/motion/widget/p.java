// 
// Decompiled by Procyon v0.6.0
// 

package androidx.constraintlayout.motion.widget;

import android.view.View$MeasureSpec;
import java.util.Arrays;
import android.view.View;
import androidx.constraintlayout.widget.ConstraintAttribute;
import java.util.LinkedHashMap;
import o.c;

class p implements Comparable<p>
{
    static String[] D;
    int A;
    double[] B;
    double[] C;
    c a;
    int b;
    float c;
    float d;
    float e;
    float f;
    float g;
    float h;
    float i;
    float j;
    int p;
    int w;
    float x;
    m y;
    LinkedHashMap<String, ConstraintAttribute> z;
    
    static {
        p.D = new String[] { "position", "x", "y", "width", "height", "pathRotate" };
    }
    
    public p() {
        this.b = 0;
        this.i = Float.NaN;
        this.j = Float.NaN;
        final int f = androidx.constraintlayout.motion.widget.d.f;
        this.p = f;
        this.w = f;
        this.x = Float.NaN;
        this.y = null;
        this.z = new LinkedHashMap<String, ConstraintAttribute>();
        this.A = 0;
        this.B = new double[18];
        this.C = new double[18];
    }
    
    public p(final int n, final int n2, final h h, final p p5, final p p6) {
        this.b = 0;
        this.i = Float.NaN;
        this.j = Float.NaN;
        final int f = androidx.constraintlayout.motion.widget.d.f;
        this.p = f;
        this.w = f;
        this.x = Float.NaN;
        this.y = null;
        this.z = new LinkedHashMap<String, ConstraintAttribute>();
        this.A = 0;
        this.B = new double[18];
        this.C = new double[18];
        if (p5.w != androidx.constraintlayout.motion.widget.d.f) {
            this.p(n, n2, h, p5, p6);
            return;
        }
        final int q = h.q;
        if (q == 1) {
            this.o(h, p5, p6);
            return;
        }
        if (q != 2) {
            this.n(h, p5, p6);
            return;
        }
        this.q(n, n2, h, p5, p6);
    }
    
    private boolean c(final float n, final float n2) {
        final boolean naN = Float.isNaN(n);
        final boolean b = true;
        boolean b2 = true;
        if (!naN && !Float.isNaN(n2)) {
            if (Math.abs(n - n2) <= 1.0E-6f) {
                b2 = false;
            }
            return b2;
        }
        return Float.isNaN(n) != Float.isNaN(n2) && b;
    }
    
    public int a(final p p) {
        return Float.compare(this.d, p.d);
    }
    
    @Override
    public /* bridge */ int compareTo(final Object o) {
        return this.a((p)o);
    }
    
    void d(final p p4, final boolean[] array, final String[] array2, final boolean b) {
        final boolean c = this.c(this.e, p4.e);
        final boolean c2 = this.c(this.f, p4.f);
        array[0] |= this.c(this.d, p4.d);
        final boolean b2 = array[1];
        final boolean b3 = c | c2 | b;
        array[1] = (b2 | b3);
        array[2] |= b3;
        array[3] |= this.c(this.g, p4.g);
        array[4] |= this.c(this.h, p4.h);
    }
    
    void f(final double[] array, final int[] array2) {
        final float d = this.d;
        int i = 0;
        final float e = this.e;
        final float f = this.f;
        final float g = this.g;
        final float h = this.h;
        final float j = this.i;
        int n = 0;
        while (i < array2.length) {
            int n2 = n;
            if (array2[i] < 6) {
                array[n] = (new float[] { d, e, f, g, h, j })[array2[i]];
                n2 = n + 1;
            }
            ++i;
            n = n2;
        }
    }
    
    void g(double n, final int[] array, final double[] array2, final float[] array3, final int n2) {
        float e = this.e;
        float f = this.f;
        float g = this.g;
        float h = this.h;
        for (int i = 0; i < array.length; ++i) {
            final float n3 = (float)array2[i];
            final int n4 = array[i];
            if (n4 != 1) {
                if (n4 != 2) {
                    if (n4 != 3) {
                        if (n4 == 4) {
                            h = n3;
                        }
                    }
                    else {
                        g = n3;
                    }
                }
                else {
                    f = n3;
                }
            }
            else {
                e = n3;
            }
        }
        final m y = this.y;
        float n5 = e;
        float n6 = f;
        if (y != null) {
            final float[] array4 = new float[2];
            y.h(n, array4, new float[2]);
            final float n7 = array4[0];
            final float n8 = array4[1];
            final double n9 = n7;
            final double n10 = e;
            n = f;
            final float n11 = (float)(n9 + Math.sin(n) * n10 - g / 2.0f);
            n6 = (float)(n8 - n10 * Math.cos(n) - h / 2.0f);
            n5 = n11;
        }
        array3[n2] = n5 + g / 2.0f + 0.0f;
        array3[n2 + 1] = n6 + h / 2.0f + 0.0f;
    }
    
    void h(double n, final int[] array, final double[] array2, final float[] array3, final double[] array4, final float[] array5) {
        float e = this.e;
        float f = this.f;
        float g = this.g;
        float h = this.h;
        int i = 0;
        float n2 = 0.0f;
        float n3 = 0.0f;
        float n4 = 0.0f;
        float n5 = 0.0f;
        while (i < array.length) {
            final float n6 = (float)array2[i];
            final float n7 = (float)array4[i];
            final int n8 = array[i];
            if (n8 != 1) {
                if (n8 != 2) {
                    if (n8 != 3) {
                        if (n8 == 4) {
                            h = n6;
                            n5 = n7;
                        }
                    }
                    else {
                        g = n6;
                        n3 = n7;
                    }
                }
                else {
                    f = n6;
                    n4 = n7;
                }
            }
            else {
                n2 = n7;
                e = n6;
            }
            ++i;
        }
        float n9 = n3 / 2.0f + n2;
        float n10 = n5 / 2.0f + n4;
        final m y = this.y;
        if (y != null) {
            final float[] array6 = new float[2];
            final float[] array7 = new float[2];
            y.h(n, array6, array7);
            final float n11 = array6[0];
            final float n12 = array6[1];
            final float n13 = array7[0];
            final float n14 = array7[1];
            final double n15 = n11;
            final double n16 = e;
            n = f;
            e = (float)(n15 + Math.sin(n) * n16 - g / 2.0f);
            f = (float)(n12 - n16 * Math.cos(n) - h / 2.0f);
            final double n17 = n13;
            final double n18 = n2;
            final double sin = Math.sin(n);
            final double cos = Math.cos(n);
            final double n19 = n4;
            final float n20 = (float)(n17 + sin * n18 + cos * n19);
            final float n21 = (float)(n14 - n18 * Math.cos(n) + Math.sin(n) * n19);
            n9 = n20;
            n10 = n21;
        }
        array3[0] = e + g / 2.0f + 0.0f;
        array3[1] = f + h / 2.0f + 0.0f;
        array5[0] = n9;
        array5[1] = n10;
    }
    
    int i(final String s, final double[] array, int n) {
        final ConstraintAttribute constraintAttribute = this.z.get(s);
        int i = 0;
        if (constraintAttribute == null) {
            return 0;
        }
        if (constraintAttribute.g() == 1) {
            array[n] = constraintAttribute.e();
            return 1;
        }
        final int g = constraintAttribute.g();
        final float[] array2 = new float[g];
        constraintAttribute.f(array2);
        while (i < g) {
            array[n] = array2[i];
            ++i;
            ++n;
        }
        return g;
    }
    
    int k(final String s) {
        final ConstraintAttribute constraintAttribute = this.z.get(s);
        if (constraintAttribute == null) {
            return 0;
        }
        return constraintAttribute.g();
    }
    
    void l(final int[] array, final double[] array2, final float[] array3, int n) {
        float e = this.e;
        float f = this.f;
        float g = this.g;
        float h = this.h;
        for (int i = 0; i < array.length; ++i) {
            final float n2 = (float)array2[i];
            final int n3 = array[i];
            if (n3 != 1) {
                if (n3 != 2) {
                    if (n3 != 3) {
                        if (n3 == 4) {
                            h = n2;
                        }
                    }
                    else {
                        g = n2;
                    }
                }
                else {
                    f = n2;
                }
            }
            else {
                e = n2;
            }
        }
        final m y = this.y;
        float n4 = e;
        float n5 = f;
        if (y != null) {
            final float j = y.i();
            final float k = this.y.j();
            final double n6 = j;
            final double n7 = e;
            final double n8 = f;
            n4 = (float)(n6 + Math.sin(n8) * n7 - g / 2.0f);
            n5 = (float)(k - n7 * Math.cos(n8) - h / 2.0f);
        }
        final float n9 = g + n4;
        final float n10 = h + n5;
        Float.isNaN(Float.NaN);
        Float.isNaN(Float.NaN);
        final int n11 = n + 1;
        array3[n] = n4 + 0.0f;
        n = n11 + 1;
        array3[n11] = n5 + 0.0f;
        final int n12 = n + 1;
        array3[n] = n9 + 0.0f;
        final int n13 = n12 + 1;
        array3[n12] = n5 + 0.0f;
        n = n13 + 1;
        array3[n13] = n9 + 0.0f;
        final int n14 = n + 1;
        array3[n] = n10 + 0.0f;
        array3[n14] = n4 + 0.0f;
        array3[n14 + 1] = n10 + 0.0f;
    }
    
    boolean m(final String s) {
        return this.z.containsKey(s);
    }
    
    void n(final h h, final p p3, final p p4) {
        float n = h.a / 100.0f;
        this.c = n;
        this.b = h.j;
        float k;
        if (Float.isNaN(h.k)) {
            k = n;
        }
        else {
            k = h.k;
        }
        float l;
        if (Float.isNaN(h.l)) {
            l = n;
        }
        else {
            l = h.l;
        }
        final float g = p4.g;
        final float g2 = p3.g;
        final float h2 = p4.h;
        final float h3 = p3.h;
        this.d = this.c;
        final float e = p3.e;
        final float n2 = g2 / 2.0f;
        final float f = p3.f;
        final float n3 = h3 / 2.0f;
        final float e2 = p4.e;
        final float n4 = g / 2.0f;
        final float f2 = p4.f;
        final float n5 = h2 / 2.0f;
        final float n6 = e2 + n4 - (n2 + e);
        final float n7 = f2 + n5 - (f + n3);
        final float n8 = (g - g2) * k;
        final float n9 = n8 / 2.0f;
        this.e = (float)(int)(e + n6 * n - n9);
        final float n10 = (h2 - h3) * l;
        final float n11 = n10 / 2.0f;
        this.f = (float)(int)(f + n7 * n - n11);
        this.g = (float)(int)(g2 + n8);
        this.h = (float)(int)(h3 + n10);
        float m;
        if (Float.isNaN(h.m)) {
            m = n;
        }
        else {
            m = h.m;
        }
        final boolean naN = Float.isNaN(h.p);
        float o = 0.0f;
        float p5;
        if (naN) {
            p5 = 0.0f;
        }
        else {
            p5 = h.p;
        }
        if (!Float.isNaN(h.n)) {
            n = h.n;
        }
        if (!Float.isNaN(h.o)) {
            o = h.o;
        }
        this.A = 0;
        this.e = (float)(int)(p3.e + m * n6 + o * n7 - n9);
        this.f = (float)(int)(p3.f + n6 * p5 + n7 * n - n11);
        this.a = o.c.c(h.h);
        this.p = h.i;
    }
    
    void o(final h h, final p p3, final p p4) {
        float m = h.a / 100.0f;
        this.c = m;
        this.b = h.j;
        float k;
        if (Float.isNaN(h.k)) {
            k = m;
        }
        else {
            k = h.k;
        }
        float l;
        if (Float.isNaN(h.l)) {
            l = m;
        }
        else {
            l = h.l;
        }
        final float g = p4.g;
        final float g2 = p3.g;
        final float h2 = p4.h;
        final float h3 = p3.h;
        this.d = this.c;
        if (!Float.isNaN(h.m)) {
            m = h.m;
        }
        final float e = p3.e;
        final float g3 = p3.g;
        final float n = g3 / 2.0f;
        final float f = p3.f;
        final float h4 = p3.h;
        final float n2 = h4 / 2.0f;
        final float e2 = p4.e;
        final float n3 = p4.g / 2.0f;
        final float f2 = p4.f;
        final float n4 = p4.h / 2.0f;
        final float n5 = e2 + n3 - (n + e);
        final float n6 = f2 + n4 - (n2 + f);
        final float n7 = n5 * m;
        final float n8 = (g - g2) * k;
        final float n9 = n8 / 2.0f;
        this.e = (float)(int)(e + n7 - n9);
        final float n10 = m * n6;
        final float n11 = (h2 - h3) * l;
        final float n12 = n11 / 2.0f;
        this.f = (float)(int)(f + n10 - n12);
        this.g = (float)(int)(g3 + n8);
        this.h = (float)(int)(h4 + n11);
        float n13;
        if (Float.isNaN(h.n)) {
            n13 = 0.0f;
        }
        else {
            n13 = h.n;
        }
        final float n14 = -n6;
        this.A = 1;
        final float n15 = (float)(int)(p3.e + n7 - n9);
        final float n16 = (float)(int)(p3.f + n10 - n12);
        this.e = n15 + n14 * n13;
        this.f = n16 + n5 * n13;
        this.w = this.w;
        this.a = o.c.c(h.h);
        this.p = h.i;
    }
    
    void p(int q, final int n, final h h, final p p5, final p p6) {
        float c = h.a / 100.0f;
        this.c = c;
        this.b = h.j;
        this.A = h.q;
        float k;
        if (Float.isNaN(h.k)) {
            k = c;
        }
        else {
            k = h.k;
        }
        float l;
        if (Float.isNaN(h.l)) {
            l = c;
        }
        else {
            l = h.l;
        }
        final float g = p6.g;
        final float g2 = p5.g;
        final float h2 = p6.h;
        final float h3 = p5.h;
        this.d = this.c;
        this.g = (float)(int)(g2 + (g - g2) * k);
        this.h = (float)(int)(h3 + (h2 - h3) * l);
        q = h.q;
        if (q != 1) {
            if (q != 2) {
                float m;
                if (Float.isNaN(h.m)) {
                    m = c;
                }
                else {
                    m = h.m;
                }
                final float e = p6.e;
                final float e2 = p5.e;
                this.e = m * (e - e2) + e2;
                if (!Float.isNaN(h.n)) {
                    c = h.n;
                }
                final float f = p6.f;
                final float f2 = p5.f;
                this.f = c * (f - f2) + f2;
            }
            else {
                float e5;
                if (Float.isNaN(h.m)) {
                    final float e3 = p6.e;
                    final float e4 = p5.e;
                    e5 = (e3 - e4) * c + e4;
                }
                else {
                    e5 = Math.min(l, k) * h.m;
                }
                this.e = e5;
                float n2;
                if (Float.isNaN(h.n)) {
                    final float f3 = p6.f;
                    final float f4 = p5.f;
                    n2 = c * (f3 - f4) + f4;
                }
                else {
                    n2 = h.n;
                }
                this.f = n2;
            }
        }
        else {
            float i;
            if (Float.isNaN(h.m)) {
                i = c;
            }
            else {
                i = h.m;
            }
            final float e6 = p6.e;
            final float e7 = p5.e;
            this.e = i * (e6 - e7) + e7;
            if (!Float.isNaN(h.n)) {
                c = h.n;
            }
            final float f5 = p6.f;
            final float f6 = p5.f;
            this.f = c * (f5 - f6) + f6;
        }
        this.w = p5.w;
        this.a = o.c.c(h.h);
        this.p = h.i;
    }
    
    void q(int n, final int n2, final h h, final p p5, final p p6) {
        final float c = h.a / 100.0f;
        this.c = c;
        this.b = h.j;
        float k;
        if (Float.isNaN(h.k)) {
            k = c;
        }
        else {
            k = h.k;
        }
        float l;
        if (Float.isNaN(h.l)) {
            l = c;
        }
        else {
            l = h.l;
        }
        final float g = p6.g;
        final float g2 = p5.g;
        final float h2 = p6.h;
        final float h3 = p5.h;
        this.d = this.c;
        final float e = p5.e;
        final float n3 = g2 / 2.0f;
        final float f = p5.f;
        final float n4 = h3 / 2.0f;
        final float e2 = p6.e;
        final float n5 = g / 2.0f;
        final float f2 = p6.f;
        final float n6 = h2 / 2.0f;
        final float n7 = (g - g2) * k;
        this.e = (float)(int)(e + (e2 + n5 - (n3 + e)) * c - n7 / 2.0f);
        final float n8 = (h2 - h3) * l;
        this.f = (float)(int)(f + (f2 + n6 - (f + n4)) * c - n8 / 2.0f);
        this.g = (float)(int)(g2 + n7);
        this.h = (float)(int)(h3 + n8);
        this.A = 2;
        if (!Float.isNaN(h.m)) {
            n -= (int)this.g;
            this.e = (float)(int)(h.m * n);
        }
        if (!Float.isNaN(h.n)) {
            n = (int)(n2 - this.h);
            this.f = (float)(int)(h.n * n);
        }
        this.w = this.w;
        this.a = o.c.c(h.h);
        this.p = h.i;
    }
    
    void r(final float e, final float f, final float g, final float h) {
        this.e = e;
        this.f = f;
        this.g = g;
        this.h = h;
    }
    
    void s(final float n, final float n2, final float[] array, final int[] array2, final double[] array3, final double[] array4) {
        int i = 0;
        float n3 = 0.0f;
        float n4 = 0.0f;
        float n6;
        float n5 = n6 = n4;
        while (i < array2.length) {
            final float n7 = (float)array3[i];
            final double n8 = array4[i];
            final int n9 = array2[i];
            if (n9 != 1) {
                if (n9 != 2) {
                    if (n9 != 3) {
                        if (n9 == 4) {
                            n5 = n7;
                        }
                    }
                    else {
                        n4 = n7;
                    }
                }
                else {
                    n6 = n7;
                }
            }
            else {
                n3 = n7;
            }
            ++i;
        }
        final float n10 = n3 - 0.0f * n4 / 2.0f;
        final float n11 = n6 - 0.0f * n5 / 2.0f;
        array[0] = n10 * (1.0f - n) + (n4 * 1.0f + n10) * n + 0.0f;
        array[1] = n11 * (1.0f - n2) + (n5 * 1.0f + n11) * n2 + 0.0f;
    }
    
    void t(float n, final View view, final int[] array, final double[] array2, final double[] array3, final double[] array4, final boolean b) {
        float e = this.e;
        float f = this.f;
        float g = this.g;
        float h = this.h;
        if (array.length != 0 && this.B.length <= array[array.length - 1]) {
            final int n2 = array[array.length - 1] + 1;
            this.B = new double[n2];
            this.C = new double[n2];
        }
        Arrays.fill(this.B, Double.NaN);
        for (int i = 0; i < array.length; ++i) {
            this.B[array[i]] = array2[i];
            this.C[array[i]] = array3[i];
        }
        float n3 = Float.NaN;
        int n4 = 0;
        float n5 = 0.0f;
        float n6 = 0.0f;
        float n7 = 0.0f;
        float n8 = 0.0f;
        while (true) {
            final double[] b2 = this.B;
            if (n4 >= b2.length) {
                break;
            }
            final boolean naN = Double.isNaN(b2[n4]);
            double n9 = 0.0;
            if (!naN || (array4 != null && array4[n4] != 0.0)) {
                if (array4 != null) {
                    n9 = array4[n4];
                }
                if (!Double.isNaN(this.B[n4])) {
                    n9 += this.B[n4];
                }
                final float n10 = (float)n9;
                final float n11 = (float)this.C[n4];
                if (n4 != 1) {
                    if (n4 != 2) {
                        if (n4 != 3) {
                            if (n4 != 4) {
                                if (n4 == 5) {
                                    n3 = n10;
                                }
                            }
                            else {
                                h = n10;
                                n8 = n11;
                            }
                        }
                        else {
                            g = n10;
                            n7 = n11;
                        }
                    }
                    else {
                        f = n10;
                        n6 = n11;
                    }
                }
                else {
                    n5 = n11;
                    e = n10;
                }
            }
            ++n4;
        }
        final m y = this.y;
        float n18;
        if (y != null) {
            final float[] array5 = new float[2];
            final float[] array6 = new float[2];
            y.h(n, array5, array6);
            n = array5[0];
            final float n12 = array5[1];
            final float n13 = array6[0];
            final float n14 = array6[1];
            final double n15 = n;
            final double n16 = e;
            final double n17 = f;
            n = (float)(n15 + Math.sin(n17) * n16 - g / 2.0f);
            n18 = (float)(n12 - Math.cos(n17) * n16 - h / 2.0f);
            final double n19 = n13;
            final double n20 = n5;
            final double sin = Math.sin(n17);
            final double cos = Math.cos(n17);
            final double n21 = n6;
            final float n22 = (float)(n19 + sin * n20 + cos * n16 * n21);
            final float n23 = (float)(n14 - n20 * Math.cos(n17) + n16 * Math.sin(n17) * n21);
            if (array3.length >= 2) {
                array3[0] = n22;
                array3[1] = n23;
            }
            if (!Float.isNaN(n3)) {
                view.setRotation((float)(n3 + Math.toDegrees(Math.atan2(n23, n22))));
            }
        }
        else {
            n = e;
            n18 = f;
            if (!Float.isNaN(n3)) {
                n = n7 / 2.0f;
                view.setRotation((float)(0.0f + (n3 + Math.toDegrees(Math.atan2(n6 + n8 / 2.0f, n5 + n)))));
                n18 = f;
                n = e;
            }
        }
        boolean b3 = false;
        if (view instanceof androidx.constraintlayout.motion.widget.c) {
            ((androidx.constraintlayout.motion.widget.c)view).a(n, n18, g + n, n18 + h);
            return;
        }
        n += 0.5f;
        final int n24 = (int)n;
        final float n25 = n18 + 0.5f;
        final int n26 = (int)n25;
        final int n27 = (int)(n + g);
        final int n28 = (int)(n25 + h);
        final int n29 = n27 - n24;
        final int n30 = n28 - n26;
        if (n29 != view.getMeasuredWidth() || n30 != view.getMeasuredHeight()) {
            b3 = true;
        }
        if (b3 || b) {
            view.measure(View$MeasureSpec.makeMeasureSpec(n29, 1073741824), View$MeasureSpec.makeMeasureSpec(n30, 1073741824));
        }
        view.layout(n24, n26, n27, n28);
    }
}
