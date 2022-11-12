// 
// Decompiled by Procyon v0.6.0
// 

package o;

import java.text.DecimalFormat;
import java.util.Arrays;

public abstract class j
{
    protected b a;
    protected int[] b;
    protected float[] c;
    private int d;
    private String e;
    
    public j() {
        this.b = new int[10];
        this.c = new float[10];
    }
    
    public float a(final float n) {
        return (float)this.a.c(n, 0);
    }
    
    public void b(final int n, final float n2) {
        final int[] b = this.b;
        if (b.length < this.d + 1) {
            this.b = Arrays.copyOf(b, b.length * 2);
            final float[] c = this.c;
            this.c = Arrays.copyOf(c, c.length * 2);
        }
        final int[] b2 = this.b;
        final int d = this.d;
        b2[d] = n;
        this.c[d] = n2;
        this.d = d + 1;
    }
    
    public void c(final String e) {
        this.e = e;
    }
    
    public void d(final int n) {
        final int d = this.d;
        if (d == 0) {
            return;
        }
        j.a.a(this.b, this.c, 0, d - 1);
        int i = 1;
        int n2 = 1;
        while (i < this.d) {
            final int[] b = this.b;
            int n3 = n2;
            if (b[i - 1] != b[i]) {
                n3 = n2 + 1;
            }
            ++i;
            n2 = n3;
        }
        final double[] array = new double[n2];
        final double[][] array2 = new double[n2][1];
        int j = 0;
        int n4 = 0;
        while (j < this.d) {
            Label_0158: {
                if (j > 0) {
                    final int[] b2 = this.b;
                    if (b2[j] == b2[j - 1]) {
                        break Label_0158;
                    }
                }
                array[n4] = this.b[j] * 0.01;
                array2[n4][0] = this.c[j];
                ++n4;
            }
            ++j;
        }
        this.a = o.b.a(n, array, array2);
    }
    
    @Override
    public String toString() {
        String s = this.e;
        final DecimalFormat decimalFormat = new DecimalFormat("##.##");
        for (int i = 0; i < this.d; ++i) {
            final StringBuilder sb = new StringBuilder();
            sb.append(s);
            sb.append("[");
            sb.append(this.b[i]);
            sb.append(" , ");
            sb.append(decimalFormat.format(this.c[i]));
            sb.append("] ");
            s = sb.toString();
        }
        return s;
    }
    
    private static class a
    {
        static void a(final int[] array, final float[] array2, int i, int n) {
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
        
        private static int b(final int[] array, final float[] array2, int i, final int n) {
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
        
        private static void c(final int[] array, final float[] array2, final int n, final int n2) {
            final int n3 = array[n];
            array[n] = array[n2];
            array[n2] = n3;
            final float n4 = array2[n];
            array2[n] = array2[n2];
            array2[n2] = n4;
        }
    }
}
