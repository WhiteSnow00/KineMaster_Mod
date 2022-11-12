// 
// Decompiled by Procyon v0.6.0
// 

package o;

import java.io.PrintStream;
import java.util.Arrays;

public class k extends c
{
    g d;
    
    k(final String a) {
        super.a = a;
        final double[] array = new double[a.length() / 2];
        int n;
        int i;
        int n2;
        for (n = a.indexOf(40) + 1, i = a.indexOf(44, n), n2 = 0; i != -1; i = a.indexOf(44, n), ++n2) {
            array[n2] = Double.parseDouble(a.substring(n, i).trim());
            n = i + 1;
        }
        array[n2] = Double.parseDouble(a.substring(n, a.indexOf(41, n)).trim());
        this.d = d(Arrays.copyOf(array, n2 + 1));
    }
    
    private static g d(final double[] array) {
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
        final g g = new g(array3, array2);
        final PrintStream out = System.out;
        final StringBuilder sb = new StringBuilder();
        sb.append(" 0 ");
        sb.append(g.c(0.0, 0));
        out.println(sb.toString());
        final PrintStream out2 = System.out;
        final StringBuilder sb2 = new StringBuilder();
        sb2.append(" 1 ");
        sb2.append(g.c(1.0, 0));
        out2.println(sb2.toString());
        return g;
    }
    
    @Override
    public double a(final double n) {
        return this.d.c(n, 0);
    }
    
    @Override
    public double b(final double n) {
        return this.d.k(n, 0);
    }
}
