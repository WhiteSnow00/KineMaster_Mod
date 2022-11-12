// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.exoplayer2.video;

import com.google.android.exoplayer2.ParserException;
import com.google.android.exoplayer2.util.NalUnitUtil;
import java.util.ArrayList;
import com.google.android.exoplayer2.util.CodecSpecificDataUtil;
import com.google.android.exoplayer2.util.ParsableByteArray;
import java.util.List;

public final class AvcConfig
{
    public final List<byte[]> a;
    public final int b;
    public final int c;
    public final int d;
    public final float e;
    public final String f;
    
    private AvcConfig(final List<byte[]> a, final int b, final int c, final int d, final float e, final String f) {
        this.a = a;
        this.b = b;
        this.c = c;
        this.d = d;
        this.e = e;
        this.f = f;
    }
    
    private static byte[] a(final ParsableByteArray parsableByteArray) {
        final int j = parsableByteArray.J();
        final int e = parsableByteArray.e();
        parsableByteArray.Q(j);
        return CodecSpecificDataUtil.d(parsableByteArray.d(), e, j);
    }
    
    public static AvcConfig b(final ParsableByteArray parsableByteArray) throws ParserException {
        try {
            parsableByteArray.Q(4);
            final int n = (parsableByteArray.D() & 0x3) + 1;
            if (n != 3) {
                final ArrayList list = new ArrayList();
                final int n2 = parsableByteArray.D() & 0x1F;
                for (int i = 0; i < n2; ++i) {
                    list.add(a(parsableByteArray));
                }
                for (int d = parsableByteArray.D(), j = 0; j < d; ++j) {
                    list.add(a(parsableByteArray));
                }
                int f = -1;
                int g;
                float h;
                String a;
                if (n2 > 0) {
                    final NalUnitUtil.SpsData l = NalUnitUtil.l((byte[])list.get(0), n, ((byte[])list.get(0)).length);
                    f = l.f;
                    g = l.g;
                    h = l.h;
                    a = CodecSpecificDataUtil.a(l.a, l.b, l.c);
                }
                else {
                    h = 1.0f;
                    a = null;
                    g = -1;
                }
                return new AvcConfig(list, n, f, g, h, a);
            }
            throw new IllegalStateException();
        }
        catch (final ArrayIndexOutOfBoundsException ex) {
            throw ParserException.createForMalformedContainer("Error parsing AVC config", ex);
        }
    }
}
