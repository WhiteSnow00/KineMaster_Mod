// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.exoplayer2.extractor.ogg;

import com.google.android.exoplayer2.ParserException;
import com.google.android.exoplayer2.metadata.Metadata;
import java.util.List;
import com.google.common.collect.ImmutableList;
import com.google.android.exoplayer2.extractor.VorbisUtil;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.audio.OpusUtil;
import java.util.Arrays;
import com.google.android.exoplayer2.util.ParsableByteArray;

final class f extends g
{
    private static final byte[] o;
    private static final byte[] p;
    private boolean n;
    
    static {
        o = new byte[] { 79, 112, 117, 115, 72, 101, 97, 100 };
        p = new byte[] { 79, 112, 117, 115, 84, 97, 103, 115 };
    }
    
    private long n(final byte[] array) {
        final int n = array[0] & 0xFF;
        final int n2 = n & 0x3;
        final int n3 = 2;
        int n4;
        if (n2 != 0) {
            n4 = n3;
            if (n2 != 1) {
                n4 = n3;
                if (n2 != 2) {
                    n4 = (array[1] & 0x3F);
                }
            }
        }
        else {
            n4 = 1;
        }
        final int n5 = n >> 3;
        final int n6 = n5 & 0x3;
        int n7;
        if (n5 >= 16) {
            n7 = 2500 << n6;
        }
        else if (n5 >= 12) {
            n7 = 10000 << (n6 & 0x1);
        }
        else if (n6 == 3) {
            n7 = 60000;
        }
        else {
            n7 = 10000 << n6;
        }
        return n4 * (long)n7;
    }
    
    private static boolean o(final ParsableByteArray parsableByteArray, final byte[] array) {
        if (parsableByteArray.a() < array.length) {
            return false;
        }
        final int e = parsableByteArray.e();
        final byte[] array2 = new byte[array.length];
        parsableByteArray.j(array2, 0, array.length);
        parsableByteArray.P(e);
        return Arrays.equals(array2, array);
    }
    
    public static boolean p(final ParsableByteArray parsableByteArray) {
        return o(parsableByteArray, f.o);
    }
    
    @Override
    protected long f(final ParsableByteArray parsableByteArray) {
        return this.c(this.n(parsableByteArray.d()));
    }
    
    @Override
    protected boolean i(final ParsableByteArray parsableByteArray, final long n, final b b) throws ParserException {
        if (o(parsableByteArray, f.o)) {
            final byte[] copy = Arrays.copyOf(parsableByteArray.d(), parsableByteArray.f());
            final int c = OpusUtil.c(copy);
            final List<byte[]> a = OpusUtil.a(copy);
            if (b.a != null) {
                return true;
            }
            b.a = new Format.Builder().e0("audio/opus").H(c).f0(48000).T(a).E();
            return true;
        }
        else {
            final byte[] p3 = f.p;
            if (!o(parsableByteArray, p3)) {
                Assertions.i(b.a);
                return false;
            }
            Assertions.i(b.a);
            if (this.n) {
                return true;
            }
            this.n = true;
            parsableByteArray.Q(p3.length);
            final Metadata c2 = VorbisUtil.c((List<String>)ImmutableList.copyOf((Object[])VorbisUtil.j(parsableByteArray, false, false).b));
            if (c2 == null) {
                return true;
            }
            b.a = b.a.b().X(c2.b(b.a.j)).E();
            return true;
        }
    }
    
    @Override
    protected void l(final boolean b) {
        super.l(b);
        if (b) {
            this.n = false;
        }
    }
}
