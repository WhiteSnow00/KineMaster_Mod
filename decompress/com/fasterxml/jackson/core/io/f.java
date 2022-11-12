// 
// Decompiled by Procyon v0.6.0
// 

package com.fasterxml.jackson.core.io;

import java.math.BigDecimal;

public final class f
{
    static final String a;
    static final String b;
    
    static {
        a = String.valueOf(Long.MIN_VALUE).substring(1);
        b = String.valueOf(Long.MAX_VALUE);
    }
    
    private static NumberFormatException a(final String s) {
        final StringBuilder sb = new StringBuilder();
        sb.append("Value \"");
        sb.append(s);
        sb.append("\" can not be represented as BigDecimal");
        return new NumberFormatException(sb.toString());
    }
    
    public static boolean b(final char[] array, final int n, int i, final boolean b) {
        String s;
        if (b) {
            s = f.a;
        }
        else {
            s = f.b;
        }
        final int length = s.length();
        boolean b2 = true;
        if (i < length) {
            return true;
        }
        if (i > length) {
            return false;
        }
        int n2;
        for (i = 0; i < length; ++i) {
            n2 = array[n + i] - s.charAt(i);
            if (n2 != 0) {
                if (n2 >= 0) {
                    b2 = false;
                }
                return b2;
            }
        }
        return true;
    }
    
    public static BigDecimal c(final String s) throws NumberFormatException {
        try {
            return new BigDecimal(s);
        }
        catch (final NumberFormatException ex) {
            throw a(s);
        }
    }
    
    public static BigDecimal d(final char[] array) throws NumberFormatException {
        return e(array, 0, array.length);
    }
    
    public static BigDecimal e(final char[] array, final int n, final int n2) throws NumberFormatException {
        try {
            return new BigDecimal(array, n, n2);
        }
        catch (final NumberFormatException ex) {
            throw a(new String(array, n, n2));
        }
    }
    
    public static double f(final String s) throws NumberFormatException {
        if ("2.2250738585072012e-308".equals(s)) {
            return Double.MIN_VALUE;
        }
        return Double.parseDouble(s);
    }
    
    public static int g(final char[] array, int n, int n2) {
        int n4;
        final int n3 = n4 = array[n] - 48;
        int n5 = n;
        int n6 = n2;
        if (n2 > 4) {
            final int n7 = n + 1;
            n = array[n7];
            final int n8 = n7 + 1;
            final char c = array[n8];
            final int n9 = n8 + 1;
            final char c2 = array[n9];
            final int n10 = n9 + 1;
            n = (((n3 * 10 + (n - 48)) * 10 + (c - '0')) * 10 + (c2 - '0')) * 10 + (array[n10] - '0');
            n2 -= 4;
            n4 = n;
            n5 = n10;
            if ((n6 = n2) > 4) {
                final int n11 = n10 + 1;
                n2 = array[n11];
                int n12 = n11 + 1;
                final char c3 = array[n12];
                ++n12;
                return (((n * 10 + (n2 - 48)) * 10 + (c3 - '0')) * 10 + (array[n12] - '0')) * 10 + (array[n12 + 1] - '0');
            }
        }
        n = n4;
        if (n6 > 1) {
            ++n5;
            n2 = (n = n4 * 10 + (array[n5] - '0'));
            if (n6 > 2) {
                final int n13 = n5 + 1;
                n2 = (n = n2 * 10 + (array[n13] - '0'));
                if (n6 > 3) {
                    n = n2 * 10 + (array[n13 + 1] - '0');
                }
            }
        }
        return n;
    }
    
    public static long h(final char[] array, final int n, int n2) {
        n2 -= 9;
        return g(array, n, n2) * 1000000000L + g(array, n + n2, 9);
    }
}
