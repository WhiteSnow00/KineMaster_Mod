// 
// Decompiled by Procyon v0.6.0
// 

package o;

import java.text.DecimalFormat;
import java.io.PrintStream;

public abstract class l
{
    protected static float k = 6.2831855f;
    protected b a;
    protected int b;
    protected int[] c;
    protected float[][] d;
    protected int e;
    protected String f;
    protected float[] g;
    protected boolean h;
    protected long i;
    protected float j;
    
    public l() {
        this.b = 0;
        this.c = new int[10];
        this.d = new float[10][3];
        this.g = new float[3];
        this.h = false;
        this.j = Float.NaN;
    }
    
    protected float a(float abs) {
        switch (this.b) {
            default: {
                return (float)Math.sin(abs * l.k);
            }
            case 6: {
                abs = 1.0f - Math.abs(abs * 4.0f % 4.0f - 2.0f);
                abs *= abs;
                break;
            }
            case 5: {
                return (float)Math.cos(abs * l.k);
            }
            case 4: {
                abs = (abs * 2.0f + 1.0f) % 2.0f;
                break;
            }
            case 3: {
                return (abs * 2.0f + 1.0f) % 2.0f - 1.0f;
            }
            case 2: {
                abs = Math.abs(abs);
                break;
            }
            case 1: {
                return Math.signum(abs * l.k);
            }
        }
        return 1.0f - abs;
    }
    
    public void b(final int n, final float n2, final float n3, final int n4, final float n5) {
        final int[] c = this.c;
        final int e = this.e;
        c[e] = n;
        final float[][] d = this.d;
        d[e][0] = n2;
        d[e][1] = n3;
        d[e][2] = n5;
        this.b = Math.max(this.b, n4);
        ++this.e;
    }
    
    protected void c(final long i) {
        this.i = i;
    }
    
    public void d(final String f) {
        this.f = f;
    }
    
    public void e(final int n) {
        final int e = this.e;
        if (e == 0) {
            final PrintStream err = System.err;
            final StringBuilder sb = new StringBuilder();
            sb.append("Error no points added to ");
            sb.append(this.f);
            err.println(sb.toString());
            return;
        }
        l.a.a(this.c, this.d, 0, e - 1);
        int n2 = 1;
        int n3 = 0;
        while (true) {
            final int[] c = this.c;
            if (n2 >= c.length) {
                break;
            }
            int n4 = n3;
            if (c[n2] != c[n2 - 1]) {
                n4 = n3 + 1;
            }
            ++n2;
            n3 = n4;
        }
        int n5;
        if ((n5 = n3) == 0) {
            n5 = 1;
        }
        final double[] array = new double[n5];
        final double[][] array2 = new double[n5][3];
        int i = 0;
        int n6 = 0;
        while (i < this.e) {
            Label_0240: {
                if (i > 0) {
                    final int[] c2 = this.c;
                    if (c2[i] == c2[i - 1]) {
                        break Label_0240;
                    }
                }
                array[n6] = this.c[i] * 0.01;
                final double[] array3 = array2[n6];
                final float[][] d = this.d;
                array3[0] = d[i][0];
                array2[n6][1] = d[i][1];
                array2[n6][2] = d[i][2];
                ++n6;
            }
            ++i;
        }
        this.a = o.b.a(n, array, array2);
    }
    
    @Override
    public String toString() {
        String s = this.f;
        final DecimalFormat decimalFormat = new DecimalFormat("##.##");
        for (int i = 0; i < this.e; ++i) {
            final StringBuilder sb = new StringBuilder();
            sb.append(s);
            sb.append("[");
            sb.append(this.c[i]);
            sb.append(" , ");
            sb.append(decimalFormat.format(this.d[i]));
            sb.append("] ");
            s = sb.toString();
        }
        return s;
    }
    
    protected static class a
    {
        static void a(final int[] array, final float[][] array2, int i, int n) {
            final int[] array3 = new int[array.length + 10];
            array3[0] = n;
            array3[1] = i;
            int n2;
            int n3;
            int b = 0;
            int n4;
            for (i = 2; i > 0; i = n + 1, array3[n] = b - 1, n = i + 1, array3[i] = n2, n4 = n + 1, array3[n] = n3, i = n4 + 1, array3[n4] = b + 1) {
                --i;
                n2 = array3[i];
                n = i - 1;
                n3 = array3[n];
                i = n;
                if (n2 < n3) {
                    b = b(array, array2, n2, n3);
                }
            }
        }
        
        private static int b(final int[] array, final float[][] array2, int i, final int n) {
            final int n2 = array[n];
            int n3 = i;
            while (i < n) {
                int n4 = n3;
                if (array[i] <= n2) {
                    c(array, array2, n3, i);
                    n4 = n3 + 1;
                }
                ++i;
                n3 = n4;
            }
            c(array, array2, n3, n);
            return n3;
        }
        
        private static void c(final int[] array, final float[][] array2, final int n, final int n2) {
            final int n3 = array[n];
            array[n] = array[n2];
            array[n2] = n3;
            final float[] array3 = array2[n];
            array2[n] = array2[n2];
            array2[n2] = array3;
        }
    }
}
