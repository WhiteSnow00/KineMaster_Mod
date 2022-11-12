// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.exoplayer2.video;

import com.google.android.exoplayer2.ParserException;
import java.util.Collections;
import com.google.android.exoplayer2.util.CodecSpecificDataUtil;
import com.google.android.exoplayer2.util.NalUnitUtil;
import com.google.android.exoplayer2.util.ParsableByteArray;
import java.util.List;

public final class HevcConfig
{
    public final List<byte[]> a;
    public final int b;
    public final int c;
    public final int d;
    public final float e;
    public final String f;
    
    private HevcConfig(final List<byte[]> a, final int b, final int c, final int d, final float e, final String f) {
        this.a = a;
        this.b = b;
        this.c = c;
        this.d = d;
        this.e = e;
        this.f = f;
    }
    
    public static HevcConfig a(final ParsableByteArray parsableByteArray) throws ParserException {
        try {
            parsableByteArray.Q(21);
            final int d = parsableByteArray.D();
            final int d2 = parsableByteArray.D();
            final int e = parsableByteArray.e();
            int i = 0;
            int n = 0;
            while (i < d2) {
                parsableByteArray.Q(1);
                for (int j = parsableByteArray.J(), k = 0; k < j; ++k) {
                    final int l = parsableByteArray.J();
                    n += l + 4;
                    parsableByteArray.Q(l);
                }
                ++i;
            }
            parsableByteArray.P(e);
            final byte[] array = new byte[n];
            float m = 1.0f;
            String c = null;
            int h = -1;
            int i2 = -1;
            int n2 = 0;
            int n3 = 0;
            while (n2 < d2) {
                final int n4 = parsableByteArray.D() & 0x7F;
                for (int j2 = parsableByteArray.J(), n5 = 0; n5 < j2; ++n5) {
                    final int j3 = parsableByteArray.J();
                    final byte[] a = NalUnitUtil.a;
                    System.arraycopy(a, 0, array, n3, a.length);
                    final int n6 = n3 + a.length;
                    System.arraycopy(parsableByteArray.d(), parsableByteArray.e(), array, n6, j3);
                    if (n4 == 33 && n5 == 0) {
                        final NalUnitUtil.H265SpsData h2 = NalUnitUtil.h(array, n6, n6 + j3);
                        h = h2.h;
                        i2 = h2.i;
                        m = h2.j;
                        c = CodecSpecificDataUtil.c(h2.a, h2.b, h2.c, h2.d, h2.e, h2.f);
                    }
                    n3 = n6 + j3;
                    parsableByteArray.Q(j3);
                }
                ++n2;
            }
            List<byte[]> list;
            if (n == 0) {
                list = Collections.emptyList();
            }
            else {
                list = Collections.singletonList(array);
            }
            return new HevcConfig(list, (d & 0x3) + 1, h, i2, m, c);
        }
        catch (final ArrayIndexOutOfBoundsException ex) {
            throw ParserException.createForMalformedContainer("Error parsing HEVC config", ex);
        }
    }
}
