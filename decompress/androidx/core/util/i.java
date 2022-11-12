// 
// Decompiled by Procyon v0.6.0
// 

package androidx.core.util;

import java.io.PrintWriter;

public final class i
{
    private static final Object a;
    private static char[] b;
    
    static {
        a = new Object();
        i.b = new char[24];
    }
    
    private static int a(final int n, final int n2, final boolean b, final int n3) {
        if (n > 99 || (b && n3 >= 3)) {
            return n2 + 3;
        }
        if (n > 9 || (b && n3 >= 2)) {
            return n2 + 2;
        }
        if (!b && n <= 0) {
            return 0;
        }
        return n2 + 1;
    }
    
    public static void b(final long n, final long n2, final PrintWriter printWriter) {
        if (n == 0L) {
            printWriter.print("--");
            return;
        }
        d(n - n2, printWriter, 0);
    }
    
    public static void c(final long n, final PrintWriter printWriter) {
        d(n, printWriter, 0);
    }
    
    public static void d(final long n, final PrintWriter printWriter, int e) {
        synchronized (i.a) {
            e = e(n, e);
            printWriter.print(new String(i.b, 0, e));
        }
    }
    
    private static int e(long n, int f) {
        if (i.b.length < f) {
            i.b = new char[f];
        }
        final char[] b = i.b;
        final long n2 = lcmp(n, 0L);
        if (n2 == 0) {
            while (f - 1 > 0) {
                b[0] = ' ';
            }
            b[0] = '0';
            return 1;
        }
        char c;
        if (n2 > 0) {
            c = '+';
        }
        else {
            c = '-';
            n = -n;
        }
        final int n3 = (int)(n % 1000L);
        int n4 = (int)Math.floor((double)(n / 1000L));
        int n5;
        if (n4 > 86400) {
            n5 = n4 / 86400;
            n4 -= 86400 * n5;
        }
        else {
            n5 = 0;
        }
        int n6;
        if (n4 > 3600) {
            n6 = n4 / 3600;
            n4 -= n6 * 3600;
        }
        else {
            n6 = 0;
        }
        int n7;
        int n8;
        if (n4 > 60) {
            n7 = n4 / 60;
            n8 = n4 - n7 * 60;
        }
        else {
            n7 = 0;
            n8 = n4;
        }
        int n15;
        if (f != 0) {
            final int a = a(n5, 1, false, 0);
            final int n9 = a + a(n6, 1, a > 0, 2);
            final int n10 = n9 + a(n7, 1, n9 > 0, 2);
            final int n11 = n10 + a(n8, 1, n10 > 0, 2);
            int n12;
            if (n11 > 0) {
                n12 = 3;
            }
            else {
                n12 = 0;
            }
            int n13 = n11 + (a(n3, 2, true, n12) + 1);
            int n14 = 0;
            while (true) {
                n15 = n14;
                if (n13 >= f) {
                    break;
                }
                b[n14] = ' ';
                ++n14;
                ++n13;
            }
        }
        else {
            n15 = 0;
        }
        b[n15] = c;
        final int n16 = n15 + 1;
        if (f != 0) {
            f = 1;
        }
        else {
            f = 0;
        }
        final int f2 = f(b, n5, 'd', n16, false, 0);
        final boolean b2 = f2 != n16;
        int n17;
        if (f != 0) {
            n17 = 2;
        }
        else {
            n17 = 0;
        }
        final int f3 = f(b, n6, 'h', f2, b2, n17);
        final boolean b3 = f3 != n16;
        int n18;
        if (f != 0) {
            n18 = 2;
        }
        else {
            n18 = 0;
        }
        final int f4 = f(b, n7, 'm', f3, b3, n18);
        final boolean b4 = f4 != n16;
        int n19;
        if (f != 0) {
            n19 = 2;
        }
        else {
            n19 = 0;
        }
        final int f5 = f(b, n8, 's', f4, b4, n19);
        if (f != 0 && f5 != n16) {
            f = 3;
        }
        else {
            f = 0;
        }
        f = f(b, n3, 'm', f5, true, f);
        b[f] = 's';
        return f + 1;
    }
    
    private static int f(final char[] array, int n, final char c, int n2, final boolean b, int n3) {
        if (!b) {
            final int n4 = n2;
            if (n <= 0) {
                return n4;
            }
        }
        int n6;
        if ((b && n3 >= 3) || n > 99) {
            final int n5 = n / 100;
            array[n2] = (char)(n5 + 48);
            n6 = n2 + 1;
            n -= n5 * 100;
        }
        else {
            n6 = n2;
        }
        int n7 = 0;
        Label_0121: {
            if ((!b || n3 < 2) && n <= 9) {
                n7 = n6;
                n3 = n;
                if (n2 == n6) {
                    break Label_0121;
                }
            }
            n2 = n / 10;
            array[n6] = (char)(n2 + 48);
            n7 = n6 + 1;
            n3 = n - n2 * 10;
        }
        array[n7] = (char)(n3 + 48);
        n = n7 + 1;
        array[n] = c;
        return n + 1;
    }
}
