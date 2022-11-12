// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.exoplayer2.util;

import java.util.ArrayList;
import android.util.Pair;
import java.util.Collections;
import java.util.List;

public final class CodecSpecificDataUtil
{
    private static final byte[] a;
    private static final String[] b;
    
    static {
        a = new byte[] { 0, 0, 0, 1 };
        b = new String[] { "", "A", "B", "C" };
    }
    
    private CodecSpecificDataUtil() {
    }
    
    public static String a(final int n, final int n2, final int n3) {
        return String.format("avc1.%02X%02X%02X", n, n2, n3);
    }
    
    public static List<byte[]> b(final boolean b) {
        byte[] array;
        if (b) {
            array = new byte[] { 1 };
        }
        else {
            array = new byte[] { 0 };
        }
        return Collections.singletonList(array);
    }
    
    public static String c(int length, final boolean b, int i, final int n, final int[] array, final int n2) {
        final String s = CodecSpecificDataUtil.b[length];
        char c;
        if (b) {
            c = 'H';
        }
        else {
            c = 'L';
        }
        final StringBuilder sb = new StringBuilder(Util.C("hvc1.%s%d.%X.%c%d", s, i, n, c, n2));
        for (length = array.length; length > 0 && array[length - 1] == 0; --length) {}
        for (i = 0; i < length; ++i) {
            sb.append(String.format(".%02X", array[i]));
        }
        return sb.toString();
    }
    
    public static byte[] d(final byte[] array, final int n, final int n2) {
        final byte[] a = CodecSpecificDataUtil.a;
        final byte[] array2 = new byte[a.length + n2];
        System.arraycopy(a, 0, array2, 0, a.length);
        System.arraycopy(array, n, array2, a.length, n2);
        return array2;
    }
    
    private static int e(final byte[] array, int i) {
        while (i <= array.length - CodecSpecificDataUtil.a.length) {
            if (g(array, i)) {
                return i;
            }
            ++i;
        }
        return -1;
    }
    
    public static Pair<Integer, Integer> f(final byte[] array) {
        final ParsableByteArray parsableByteArray = new ParsableByteArray(array);
        int n = 0;
        int n2 = 0;
        boolean b;
        while (true) {
            final int n3 = n2 + 3;
            if (n3 >= array.length) {
                b = false;
                break;
            }
            if (parsableByteArray.G() == 1 && (array[n3] & 0xF0) == 0x20) {
                b = true;
                break;
            }
            parsableByteArray.P(parsableByteArray.e() - 2);
            ++n2;
        }
        Assertions.b(b, "Invalid input: VOL not found.");
        final ParsableBitArray parsableBitArray = new ParsableBitArray(array);
        parsableBitArray.r((n2 + 4) * 8);
        parsableBitArray.r(1);
        parsableBitArray.r(8);
        if (parsableBitArray.g()) {
            parsableBitArray.r(4);
            parsableBitArray.r(3);
        }
        if (parsableBitArray.h(4) == 15) {
            parsableBitArray.r(8);
            parsableBitArray.r(8);
        }
        if (parsableBitArray.g()) {
            parsableBitArray.r(2);
            parsableBitArray.r(1);
            if (parsableBitArray.g()) {
                parsableBitArray.r(79);
            }
        }
        Assertions.b(parsableBitArray.h(2) == 0, "Only supports rectangular video object layer shape.");
        Assertions.a(parsableBitArray.g());
        int i = parsableBitArray.h(16);
        Assertions.a(parsableBitArray.g());
        if (parsableBitArray.g()) {
            Assertions.a(i > 0);
            --i;
            while (i > 0) {
                ++n;
                i >>= 1;
            }
            parsableBitArray.r(n);
        }
        Assertions.a(parsableBitArray.g());
        final int h = parsableBitArray.h(13);
        Assertions.a(parsableBitArray.g());
        final int h2 = parsableBitArray.h(13);
        Assertions.a(parsableBitArray.g());
        parsableBitArray.r(1);
        return (Pair<Integer, Integer>)Pair.create((Object)h, (Object)h2);
    }
    
    private static boolean g(final byte[] array, final int n) {
        if (array.length - n <= CodecSpecificDataUtil.a.length) {
            return false;
        }
        int n2 = 0;
        while (true) {
            final byte[] a = CodecSpecificDataUtil.a;
            if (n2 >= a.length) {
                return true;
            }
            if (array[n + n2] != a[n2]) {
                return false;
            }
            ++n2;
        }
    }
    
    public static Pair<Integer, Integer> h(final byte[] array) {
        final ParsableByteArray parsableByteArray = new ParsableByteArray(array);
        parsableByteArray.P(9);
        final int d = parsableByteArray.D();
        parsableByteArray.P(20);
        return (Pair<Integer, Integer>)Pair.create((Object)parsableByteArray.H(), (Object)d);
    }
    
    public static boolean i(final List<byte[]> list) {
        final int size = list.size();
        boolean b2;
        final boolean b = b2 = false;
        if (size == 1) {
            b2 = b;
            if (((byte[])list.get(0)).length == 1) {
                b2 = b;
                if (((byte[])list.get(0))[0] == 1) {
                    b2 = true;
                }
            }
        }
        return b2;
    }
    
    public static byte[][] j(final byte[] array) {
        if (!g(array, 0)) {
            return null;
        }
        final ArrayList list = new ArrayList();
        int e = 0;
        do {
            list.add(e);
        } while ((e = e(array, e + CodecSpecificDataUtil.a.length)) != -1);
        final byte[][] array2 = new byte[list.size()][];
        for (int i = 0; i < list.size(); ++i) {
            final int intValue = (int)list.get(i);
            int n;
            if (i < list.size() - 1) {
                n = (int)list.get(i + 1);
            }
            else {
                n = array.length;
            }
            final int n2 = n - intValue;
            final byte[] array3 = new byte[n2];
            System.arraycopy(array, intValue, array3, 0, n2);
            array2[i] = array3;
        }
        return array2;
    }
}
