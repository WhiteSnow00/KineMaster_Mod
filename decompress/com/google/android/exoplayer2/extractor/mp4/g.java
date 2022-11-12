// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.exoplayer2.extractor.mp4;

import com.google.android.exoplayer2.util.ParsableByteArray;
import java.io.IOException;
import com.google.android.exoplayer2.extractor.ExtractorInput;

final class g
{
    private static final int[] a;
    
    static {
        a = new int[] { 1769172845, 1769172786, 1769172787, 1769172788, 1769172789, 1769172790, 1769172793, 1635148593, 1752589105, 1751479857, 1635135537, 1836069937, 1836069938, 862401121, 862401122, 862417462, 862417718, 862414134, 862414646, 1295275552, 1295270176, 1714714144, 1801741417, 1295275600, 1903435808, 1297305174, 1684175153, 1769172332, 1885955686 };
    }
    
    private static boolean a(final int n, final boolean b) {
        if (n >>> 8 == 3368816) {
            return true;
        }
        if (n == 1751476579 && b) {
            return true;
        }
        final int[] a = g.a;
        for (int length = a.length, i = 0; i < length; ++i) {
            if (a[i] == n) {
                return true;
            }
        }
        return false;
    }
    
    public static boolean b(final ExtractorInput extractorInput) throws IOException {
        return c(extractorInput, true, false);
    }
    
    private static boolean c(final ExtractorInput extractorInput, final boolean b, final boolean b2) throws IOException {
        long length = extractorInput.getLength();
        final long n = lcmp(length, -1L);
        long n2 = 4096L;
        if (n != 0) {
            if (length > 4096L) {
                n2 = n2;
            }
            else {
                n2 = length;
            }
        }
        int n3 = (int)n2;
        final ParsableByteArray parsableByteArray = new ParsableByteArray(64);
        int n4 = 0;
        int i = 0;
        int n5 = 0;
        while (true) {
            while (i < n3) {
                parsableByteArray.L(8);
                if (!extractorInput.f(parsableByteArray.d(), n4, 8, true)) {
                    break;
                }
                final long f = parsableByteArray.F();
                final int n6 = parsableByteArray.n();
                int n7 = 16;
                long w;
                if (f == 1L) {
                    extractorInput.r(parsableByteArray.d(), 8, 8);
                    parsableByteArray.O(16);
                    w = parsableByteArray.w();
                }
                else {
                    w = f;
                    if (f == 0L) {
                        final long length2 = extractorInput.getLength();
                        w = f;
                        if (length2 != -1L) {
                            w = length2 - extractorInput.k() + 8;
                        }
                    }
                    n7 = 8;
                }
                final long n8 = n7;
                if (w < n8) {
                    return n4 != 0;
                }
                final int n9 = i + n7;
                long n11;
                int n12;
                int n13;
                if (n6 == 1836019574) {
                    final int n10 = n3 + (int)w;
                    n11 = length;
                    n3 = n10;
                    n12 = n4;
                    i = n9;
                    n13 = n5;
                    if (n != 0) {
                        n11 = length;
                        n3 = n10;
                        n12 = n4;
                        i = n9;
                        n13 = n5;
                        if (n10 > length) {
                            n3 = (int)length;
                            n13 = n5;
                            i = n9;
                            n12 = n4;
                            n11 = length;
                        }
                    }
                }
                else {
                    if (n6 == 1836019558 || n6 == 1836475768) {
                        final int n14 = 1;
                        int n15;
                        if (n5 != 0 && (b ? 1 : 0) == n14) {
                            n15 = 1;
                        }
                        else {
                            n15 = n4;
                        }
                        return n15 != 0;
                    }
                    if (n9 + w - n8 >= n3) {
                        n4 = 0;
                        break;
                    }
                    final int n16 = (int)(w - n8);
                    i = n9 + n16;
                    int n18;
                    if (n6 == 1718909296) {
                        if (n16 < 8) {
                            return false;
                        }
                        parsableByteArray.L(n16);
                        extractorInput.r(parsableByteArray.d(), 0, n16);
                        for (int n17 = n16 / 4, j = 0; j < n17; ++j) {
                            if (j == 1) {
                                parsableByteArray.Q(4);
                            }
                            else if (a(parsableByteArray.n(), b2)) {
                                n5 = 1;
                                break;
                            }
                        }
                        if (n5 == 0) {
                            return false;
                        }
                        n18 = n5;
                    }
                    else {
                        n18 = n5;
                        if (n16 != 0) {
                            extractorInput.m(n16);
                            n18 = n5;
                        }
                    }
                    n12 = 0;
                    n11 = length;
                    n13 = n18;
                }
                length = n11;
                n4 = n12;
                n5 = n13;
            }
            final int n14 = n4;
            continue;
        }
    }
    
    public static boolean d(final ExtractorInput extractorInput, final boolean b) throws IOException {
        return c(extractorInput, false, b);
    }
}
