// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.exoplayer2.extractor;

import com.google.android.exoplayer2.util.Log;
import com.google.android.exoplayer2.util.ParsableByteArray;

public final class CeaUtil
{
    private CeaUtil() {
    }
    
    public static void a(final long n, final ParsableByteArray parsableByteArray, final TrackOutput[] array) {
        while (true) {
            final int a = parsableByteArray.a();
            final boolean b = true;
            if (a <= 1) {
                break;
            }
            final int c = c(parsableByteArray);
            final int c2 = c(parsableByteArray);
            final int n2 = parsableByteArray.e() + c2;
            int f;
            if (c2 != -1 && c2 <= parsableByteArray.a()) {
                f = n2;
                if (c == 4) {
                    f = n2;
                    if (c2 >= 8) {
                        final int d = parsableByteArray.D();
                        final int j = parsableByteArray.J();
                        int n3;
                        if (j == 49) {
                            n3 = parsableByteArray.n();
                        }
                        else {
                            n3 = 0;
                        }
                        final int d2 = parsableByteArray.D();
                        if (j == 47) {
                            parsableByteArray.Q(1);
                        }
                        boolean b2 = d == 181 && (j == 49 || j == 47) && d2 == 3;
                        if (j == 49) {
                            b2 &= (n3 == 1195456820 && b);
                        }
                        f = n2;
                        if (b2) {
                            b(n, parsableByteArray, array);
                            f = n2;
                        }
                    }
                }
            }
            else {
                Log.i("CeaUtil", "Skipping remainder of malformed SEI NAL unit.");
                f = parsableByteArray.f();
            }
            parsableByteArray.P(f);
        }
    }
    
    public static void b(final long n, final ParsableByteArray parsableByteArray, final TrackOutput[] array) {
        final int d = parsableByteArray.D();
        final int n2 = 0;
        if ((d & 0x40) == 0x0) {
            return;
        }
        parsableByteArray.Q(1);
        final int n3 = (d & 0x1F) * 3;
        final int e = parsableByteArray.e();
        for (int length = array.length, i = n2; i < length; ++i) {
            final TrackOutput trackOutput = array[i];
            parsableByteArray.P(e);
            trackOutput.c(parsableByteArray, n3);
            if (n != -9223372036854775807L) {
                trackOutput.e(n, 1, n3, 0, null);
            }
        }
    }
    
    private static int c(final ParsableByteArray parsableByteArray) {
        int n = 0;
        while (parsableByteArray.a() != 0) {
            final int d = parsableByteArray.D();
            n += d;
            if (d != 255) {
                return n;
            }
        }
        return -1;
    }
}
