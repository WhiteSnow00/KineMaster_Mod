// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.exoplayer2.extractor;

import com.google.android.exoplayer2.ParserException;
import java.io.IOException;
import com.google.android.exoplayer2.util.Util;
import com.google.android.exoplayer2.util.ParsableByteArray;

public final class FlacFrameReader
{
    private FlacFrameReader() {
    }
    
    private static boolean a(final ParsableByteArray parsableByteArray, final FlacStreamMetadata flacStreamMetadata, int j) {
        j = j(parsableByteArray, j);
        return j != -1 && j <= flacStreamMetadata.b;
    }
    
    private static boolean b(final ParsableByteArray parsableByteArray, final int n) {
        final int d = parsableByteArray.D();
        final int e = parsableByteArray.e();
        final byte[] d2 = parsableByteArray.d();
        boolean b = true;
        if (d != Util.u(d2, n, e - 1, 0)) {
            b = false;
        }
        return b;
    }
    
    private static boolean c(final ParsableByteArray parsableByteArray, final FlacStreamMetadata flacStreamMetadata, final boolean b, final SampleNumberHolder sampleNumberHolder) {
        try {
            long k = parsableByteArray.K();
            if (!b) {
                k *= flacStreamMetadata.b;
            }
            sampleNumberHolder.a = k;
            return true;
        }
        catch (final NumberFormatException ex) {
            return false;
        }
    }
    
    public static boolean d(final ParsableByteArray parsableByteArray, final FlacStreamMetadata flacStreamMetadata, int n, final SampleNumberHolder sampleNumberHolder) {
        final int e = parsableByteArray.e();
        final long f = parsableByteArray.F();
        final long n2 = f >>> 16;
        final long n3 = n;
        final boolean b = false;
        if (n2 != n3) {
            return false;
        }
        final boolean b2 = (n2 & 0x1L) == 0x1L;
        final int n4 = (int)(f >> 12 & 0xFL);
        final int n5 = (int)(f >> 8 & 0xFL);
        final int n6 = (int)(f >> 4 & 0xFL);
        final int n7 = (int)(f >> 1 & 0x7L);
        if ((f & 0x1L) == 0x1L) {
            n = 1;
        }
        else {
            n = 0;
        }
        boolean b3 = b;
        if (g(n6, flacStreamMetadata)) {
            b3 = b;
            if (f(n7, flacStreamMetadata)) {
                b3 = b;
                if (n == 0) {
                    b3 = b;
                    if (c(parsableByteArray, flacStreamMetadata, b2, sampleNumberHolder)) {
                        b3 = b;
                        if (a(parsableByteArray, flacStreamMetadata, n4)) {
                            b3 = b;
                            if (e(parsableByteArray, flacStreamMetadata, n5)) {
                                b3 = b;
                                if (b(parsableByteArray, e)) {
                                    b3 = true;
                                }
                            }
                        }
                    }
                }
            }
        }
        return b3;
    }
    
    private static boolean e(final ParsableByteArray parsableByteArray, final FlacStreamMetadata flacStreamMetadata, final int n) {
        final int e = flacStreamMetadata.e;
        boolean b = true;
        final boolean b2 = true;
        final boolean b3 = true;
        if (n == 0) {
            return true;
        }
        if (n <= 11) {
            return n == flacStreamMetadata.f && b3;
        }
        if (n == 12) {
            if (parsableByteArray.D() * 1000 != e) {
                b = false;
            }
            return b;
        }
        if (n <= 14) {
            int j = parsableByteArray.J();
            if (n == 14) {
                j *= 10;
            }
            return j == e && b2;
        }
        return false;
    }
    
    private static boolean f(final int n, final FlacStreamMetadata flacStreamMetadata) {
        boolean b = true;
        if (n == 0) {
            return true;
        }
        if (n != flacStreamMetadata.i) {
            b = false;
        }
        return b;
    }
    
    private static boolean g(final int n, final FlacStreamMetadata flacStreamMetadata) {
        final boolean b = false;
        boolean b2 = false;
        if (n <= 7) {
            if (n == flacStreamMetadata.g - 1) {
                b2 = true;
            }
            return b2;
        }
        boolean b3 = b;
        if (n <= 10) {
            b3 = b;
            if (flacStreamMetadata.g == 2) {
                b3 = true;
            }
        }
        return b3;
    }
    
    public static boolean h(final ExtractorInput extractorInput, final FlacStreamMetadata flacStreamMetadata, final int n, final SampleNumberHolder sampleNumberHolder) throws IOException {
        final long k = extractorInput.k();
        final byte[] array = new byte[2];
        extractorInput.r(array, 0, 2);
        if (((array[0] & 0xFF) << 8 | (array[1] & 0xFF)) != n) {
            extractorInput.h();
            extractorInput.m((int)(k - extractorInput.getPosition()));
            return false;
        }
        final ParsableByteArray parsableByteArray = new ParsableByteArray(16);
        System.arraycopy(array, 0, parsableByteArray.d(), 0, 2);
        parsableByteArray.O(ExtractorUtil.c(extractorInput, parsableByteArray.d(), 2, 14));
        extractorInput.h();
        extractorInput.m((int)(k - extractorInput.getPosition()));
        return d(parsableByteArray, flacStreamMetadata, n, sampleNumberHolder);
    }
    
    public static long i(final ExtractorInput extractorInput, final FlacStreamMetadata flacStreamMetadata) throws IOException {
        extractorInput.h();
        boolean b = true;
        extractorInput.m(1);
        final byte[] array = { 0 };
        extractorInput.r(array, 0, 1);
        if ((array[0] & 0x1) != 0x1) {
            b = false;
        }
        extractorInput.m(2);
        int n;
        if (b) {
            n = 7;
        }
        else {
            n = 6;
        }
        final ParsableByteArray parsableByteArray = new ParsableByteArray(n);
        parsableByteArray.O(ExtractorUtil.c(extractorInput, parsableByteArray.d(), 0, n));
        extractorInput.h();
        final SampleNumberHolder sampleNumberHolder = new SampleNumberHolder();
        if (c(parsableByteArray, flacStreamMetadata, b, sampleNumberHolder)) {
            return sampleNumberHolder.a;
        }
        throw ParserException.createForMalformedContainer(null, null);
    }
    
    public static int j(final ParsableByteArray parsableByteArray, final int n) {
        switch (n) {
            default: {
                return -1;
            }
            case 8:
            case 9:
            case 10:
            case 11:
            case 12:
            case 13:
            case 14:
            case 15: {
                return 256 << n - 8;
            }
            case 7: {
                return parsableByteArray.J() + 1;
            }
            case 6: {
                return parsableByteArray.D() + 1;
            }
            case 2:
            case 3:
            case 4:
            case 5: {
                return 576 << n - 2;
            }
            case 1: {
                return 192;
            }
        }
    }
    
    public static final class SampleNumberHolder
    {
        public long a;
    }
}
