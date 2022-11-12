// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.gms.common.util;

import com.google.android.gms.common.internal.ShowFirstParty;
import com.google.android.gms.common.annotation.KeepForSdk;

@KeepForSdk
@ShowFirstParty
public class Hex
{
    private static final char[] a;
    private static final char[] b;
    
    static {
        a = new char[] { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F' };
        b = new char[] { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f' };
    }
    
    @KeepForSdk
    public static String a(final byte[] array) {
        final int length = array.length;
        final char[] array2 = new char[length + length];
        int i = 0;
        int n = 0;
        while (i < array.length) {
            final int n2 = array[i] & 0xFF;
            final int n3 = n + 1;
            final char[] b = Hex.b;
            array2[n] = b[n2 >>> 4];
            n = n3 + 1;
            array2[n3] = b[n2 & 0xF];
            ++i;
        }
        return new String(array2);
    }
    
    @KeepForSdk
    public static String b(final byte[] array) {
        return c(array, false);
    }
    
    @KeepForSdk
    public static String c(final byte[] array, final boolean b) {
        final int length = array.length;
        final StringBuilder sb = new StringBuilder(length + length);
        for (int n = 0; n < length && (!b || n != length - 1 || (array[n] & 0xFF) != 0x0); ++n) {
            final char[] a = Hex.a;
            sb.append(a[(array[n] & 0xF0) >>> 4]);
            sb.append(a[array[n] & 0xF]);
        }
        return sb.toString();
    }
    
    @KeepForSdk
    public static byte[] d(final String s) throws IllegalArgumentException {
        final int length = s.length();
        if (length % 2 == 0) {
            final byte[] array = new byte[length / 2];
            int n;
            for (int i = 0; i < length; i = n) {
                n = i + 2;
                array[i / 2] = (byte)Integer.parseInt(s.substring(i, n), 16);
            }
            return array;
        }
        throw new IllegalArgumentException("Hex string has odd number of characters");
    }
}
