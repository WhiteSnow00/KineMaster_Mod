// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.exoplayer2.extractor.ts;

import com.google.android.exoplayer2.util.ParsableByteArray;

public final class TsUtil
{
    private TsUtil() {
    }
    
    public static int a(final byte[] array, int n, final int n2) {
        while (n < n2 && array[n] != 71) {
            ++n;
        }
        return n;
    }
    
    public static boolean b(final byte[] array, final int n, final int n2, final int n3) {
        int i = -4;
        int n4 = 0;
        while (i <= 4) {
            final int n5 = i * 188 + n3;
            if (n5 >= n && n5 < n2 && array[n5] == 71) {
                if (++n4 == 5) {
                    return true;
                }
            }
            else {
                n4 = 0;
            }
            ++i;
        }
        return false;
    }
    
    public static long c(final ParsableByteArray parsableByteArray, int n, int n2) {
        parsableByteArray.P(n);
        if (parsableByteArray.a() < 5) {
            return -9223372036854775807L;
        }
        n = parsableByteArray.n();
        if ((0x800000 & n) != 0x0) {
            return -9223372036854775807L;
        }
        if ((0x1FFF00 & n) >> 8 != n2) {
            return -9223372036854775807L;
        }
        n2 = 1;
        if ((n & 0x20) != 0x0) {
            n = 1;
        }
        else {
            n = 0;
        }
        if (n == 0) {
            return -9223372036854775807L;
        }
        if (parsableByteArray.D() >= 7 && parsableByteArray.a() >= 7) {
            if ((parsableByteArray.D() & 0x10) == 0x10) {
                n = n2;
            }
            else {
                n = 0;
            }
            if (n != 0) {
                final byte[] array = new byte[6];
                parsableByteArray.j(array, 0, 6);
                return d(array);
            }
        }
        return -9223372036854775807L;
    }
    
    private static long d(final byte[] array) {
        return ((long)array[0] & 0xFFL) << 25 | ((long)array[1] & 0xFFL) << 17 | ((long)array[2] & 0xFFL) << 9 | ((long)array[3] & 0xFFL) << 1 | (0xFFL & (long)array[4]) >> 7;
    }
}
