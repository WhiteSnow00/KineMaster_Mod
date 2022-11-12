// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.exoplayer2.audio;

import java.lang.annotation.ElementType;
import java.lang.annotation.Target;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Retention;
import java.lang.annotation.Documented;
import com.google.android.exoplayer2.util.ParsableBitArray;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.drm.DrmInitData;
import com.google.android.exoplayer2.util.ParsableByteArray;
import com.google.android.exoplayer2.util.Util;
import java.nio.ByteBuffer;

public final class Ac3Util
{
    private static final int[] a;
    private static final int[] b;
    private static final int[] c;
    private static final int[] d;
    private static final int[] e;
    private static final int[] f;
    
    static {
        a = new int[] { 1, 2, 3, 6 };
        b = new int[] { 48000, 44100, 32000 };
        c = new int[] { 24000, 22050, 16000 };
        d = new int[] { 2, 1, 2, 3, 3, 4, 4, 5 };
        e = new int[] { 32, 40, 48, 56, 64, 80, 96, 112, 128, 160, 192, 224, 256, 320, 384, 448, 512, 576, 640 };
        f = new int[] { 69, 87, 104, 121, 139, 174, 208, 243, 278, 348, 417, 487, 557, 696, 835, 975, 1114, 1253, 1393 };
    }
    
    private Ac3Util() {
    }
    
    public static int a(final ByteBuffer byteBuffer) {
        final int position = byteBuffer.position();
        for (int limit = byteBuffer.limit(), i = position; i <= limit - 10; ++i) {
            if ((Util.I(byteBuffer, i + 4) & 0xFFFFFFFE) == 0xF8726FBA) {
                return i - position;
            }
        }
        return -1;
    }
    
    private static int b(int n, int n2) {
        final int n3 = n2 / 2;
        if (n >= 0) {
            final int[] b = Ac3Util.b;
            if (n < b.length && n2 >= 0) {
                final int[] f = Ac3Util.f;
                if (n3 < f.length) {
                    n = b[n];
                    if (n == 44100) {
                        return (f[n3] + n2 % 2) * 2;
                    }
                    n2 = Ac3Util.e[n3];
                    if (n == 32000) {
                        return n2 * 6;
                    }
                    return n2 * 4;
                }
            }
        }
        return -1;
    }
    
    public static Format c(final ParsableByteArray parsableByteArray, final String s, final String s2, final DrmInitData drmInitData) {
        final int n = Ac3Util.b[(parsableByteArray.D() & 0xC0) >> 6];
        final int d = parsableByteArray.D();
        int n2 = Ac3Util.d[(d & 0x38) >> 3];
        if ((d & 0x4) != 0x0) {
            ++n2;
        }
        return new Format.Builder().S(s).e0("audio/ac3").H(n2).f0(n).M(drmInitData).V(s2).E();
    }
    
    public static int d(final ByteBuffer byteBuffer) {
        final byte value = byteBuffer.get(byteBuffer.position() + 5);
        final int n = 3;
        if ((value & 0xF8) >> 3 > 10) {
            int n2;
            if ((byteBuffer.get(byteBuffer.position() + 4) & 0xC0) >> 6 == 3) {
                n2 = n;
            }
            else {
                n2 = (byteBuffer.get(byteBuffer.position() + 4) & 0x30) >> 4;
            }
            return Ac3Util.a[n2] * 256;
        }
        return 1536;
    }
    
    public static SyncFrameInfo e(final ParsableBitArray parsableBitArray) {
        final int e = parsableBitArray.e();
        parsableBitArray.r(40);
        final boolean b = parsableBitArray.h(5) > 10;
        parsableBitArray.p(e);
        final int n = -1;
        int n4;
        String s;
        int n8;
        int b2;
        int n9;
        int n10;
        if (b) {
            parsableBitArray.r(16);
            final int h = parsableBitArray.h(2);
            int n2;
            if (h != 0) {
                if (h != 1) {
                    if (h != 2) {
                        n2 = n;
                    }
                    else {
                        n2 = 2;
                    }
                }
                else {
                    n2 = 1;
                }
            }
            else {
                n2 = 0;
            }
            parsableBitArray.r(3);
            final int n3 = (parsableBitArray.h(11) + 1) * 2;
            final int h2 = parsableBitArray.h(2);
            int n5;
            int h3;
            if (h2 == 3) {
                n4 = Ac3Util.c[parsableBitArray.h(2)];
                n5 = 6;
                h3 = 3;
            }
            else {
                h3 = parsableBitArray.h(2);
                n5 = Ac3Util.a[h3];
                n4 = Ac3Util.b[h2];
            }
            final int n6 = n5 * 256;
            final int h4 = parsableBitArray.h(3);
            final int g = parsableBitArray.g() ? 1 : 0;
            final int n7 = Ac3Util.d[h4] + g;
            parsableBitArray.r(10);
            if (parsableBitArray.g()) {
                parsableBitArray.r(8);
            }
            if (h4 == 0) {
                parsableBitArray.r(5);
                if (parsableBitArray.g()) {
                    parsableBitArray.r(8);
                }
            }
            if (n2 == 1 && parsableBitArray.g()) {
                parsableBitArray.r(16);
            }
            if (parsableBitArray.g()) {
                if (h4 > 2) {
                    parsableBitArray.r(2);
                }
                if ((h4 & 0x1) != 0x0 && h4 > 2) {
                    parsableBitArray.r(6);
                }
                if ((h4 & 0x4) != 0x0) {
                    parsableBitArray.r(6);
                }
                if (g != 0 && parsableBitArray.g()) {
                    parsableBitArray.r(5);
                }
                if (n2 == 0) {
                    if (parsableBitArray.g()) {
                        parsableBitArray.r(6);
                    }
                    if (h4 == 0 && parsableBitArray.g()) {
                        parsableBitArray.r(6);
                    }
                    if (parsableBitArray.g()) {
                        parsableBitArray.r(6);
                    }
                    final int h5 = parsableBitArray.h(2);
                    if (h5 == 1) {
                        parsableBitArray.r(5);
                    }
                    else if (h5 == 2) {
                        parsableBitArray.r(12);
                    }
                    else if (h5 == 3) {
                        final int h6 = parsableBitArray.h(5);
                        if (parsableBitArray.g()) {
                            parsableBitArray.r(5);
                            if (parsableBitArray.g()) {
                                parsableBitArray.r(4);
                            }
                            if (parsableBitArray.g()) {
                                parsableBitArray.r(4);
                            }
                            if (parsableBitArray.g()) {
                                parsableBitArray.r(4);
                            }
                            if (parsableBitArray.g()) {
                                parsableBitArray.r(4);
                            }
                            if (parsableBitArray.g()) {
                                parsableBitArray.r(4);
                            }
                            if (parsableBitArray.g()) {
                                parsableBitArray.r(4);
                            }
                            if (parsableBitArray.g()) {
                                parsableBitArray.r(4);
                            }
                            if (parsableBitArray.g()) {
                                if (parsableBitArray.g()) {
                                    parsableBitArray.r(4);
                                }
                                if (parsableBitArray.g()) {
                                    parsableBitArray.r(4);
                                }
                            }
                        }
                        if (parsableBitArray.g()) {
                            parsableBitArray.r(5);
                            if (parsableBitArray.g()) {
                                parsableBitArray.r(7);
                                if (parsableBitArray.g()) {
                                    parsableBitArray.r(8);
                                }
                            }
                        }
                        parsableBitArray.r((h6 + 2) * 8);
                        parsableBitArray.c();
                    }
                    if (h4 < 2) {
                        if (parsableBitArray.g()) {
                            parsableBitArray.r(14);
                        }
                        if (h4 == 0 && parsableBitArray.g()) {
                            parsableBitArray.r(14);
                        }
                    }
                    if (parsableBitArray.g()) {
                        if (h3 == 0) {
                            parsableBitArray.r(5);
                        }
                        else {
                            for (int i = 0; i < n5; ++i) {
                                if (parsableBitArray.g()) {
                                    parsableBitArray.r(5);
                                }
                            }
                        }
                    }
                }
            }
            if (parsableBitArray.g()) {
                parsableBitArray.r(5);
                if (h4 == 2) {
                    parsableBitArray.r(4);
                }
                if (h4 >= 6) {
                    parsableBitArray.r(2);
                }
                if (parsableBitArray.g()) {
                    parsableBitArray.r(8);
                }
                if (h4 == 0 && parsableBitArray.g()) {
                    parsableBitArray.r(8);
                }
                if (h2 < 3) {
                    parsableBitArray.q();
                }
            }
            if (n2 == 0 && h3 != 3) {
                parsableBitArray.q();
            }
            if (n2 == 2 && (h3 == 3 || parsableBitArray.g())) {
                parsableBitArray.r(6);
            }
            if (parsableBitArray.g() && parsableBitArray.h(6) == 1 && parsableBitArray.h(8) == 1) {
                s = "audio/eac3-joc";
            }
            else {
                s = "audio/eac3";
            }
            n8 = n6;
            b2 = n3;
            n9 = n7;
            n10 = n2;
        }
        else {
            parsableBitArray.r(32);
            final int h7 = parsableBitArray.h(2);
            String s2;
            if (h7 == 3) {
                s2 = null;
            }
            else {
                s2 = "audio/ac3";
            }
            b2 = b(h7, parsableBitArray.h(6));
            parsableBitArray.r(8);
            final int h8 = parsableBitArray.h(3);
            if ((h8 & 0x1) != 0x0 && h8 != 1) {
                parsableBitArray.r(2);
            }
            if ((h8 & 0x4) != 0x0) {
                parsableBitArray.r(2);
            }
            if (h8 == 2) {
                parsableBitArray.r(2);
            }
            final int[] b3 = Ac3Util.b;
            int n11;
            if (h7 < b3.length) {
                n11 = b3[h7];
            }
            else {
                n11 = -1;
            }
            n8 = 1536;
            n9 = Ac3Util.d[h8] + (parsableBitArray.g() ? 1 : 0);
            n10 = -1;
            s = s2;
            n4 = n11;
        }
        return new SyncFrameInfo(s, n10, n9, n4, b2, n8, null);
    }
    
    public static int f(final byte[] array) {
        if (array.length < 6) {
            return -1;
        }
        if ((array[5] & 0xF8) >> 3 > 10) {
            return (((array[3] & 0xFF) | (array[2] & 0x7) << 8) + 1) * 2;
        }
        return b((array[4] & 0xC0) >> 6, array[4] & 0x3F);
    }
    
    public static Format g(final ParsableByteArray parsableByteArray, final String s, final String s2, final DrmInitData drmInitData) {
        parsableByteArray.Q(2);
        final int n = Ac3Util.b[(parsableByteArray.D() & 0xC0) >> 6];
        final int d = parsableByteArray.D();
        int n3;
        final int n2 = n3 = Ac3Util.d[(d & 0xE) >> 1];
        if ((d & 0x1) != 0x0) {
            n3 = n2 + 1;
        }
        int n4 = n3;
        if ((parsableByteArray.D() & 0x1E) >> 1 > 0) {
            n4 = n3;
            if ((0x2 & parsableByteArray.D()) != 0x0) {
                n4 = n3 + 2;
            }
        }
        String s3;
        if (parsableByteArray.a() > 0 && (parsableByteArray.D() & 0x1) != 0x0) {
            s3 = "audio/eac3-joc";
        }
        else {
            s3 = "audio/eac3";
        }
        return new Format.Builder().S(s).e0(s3).H(n4).f0(n).M(drmInitData).V(s2).E();
    }
    
    public static int h(final ByteBuffer byteBuffer, final int n) {
        final boolean b = (byteBuffer.get(byteBuffer.position() + n + 7) & 0xFF) == 0xBB;
        final int position = byteBuffer.position();
        int n2;
        if (b) {
            n2 = 9;
        }
        else {
            n2 = 8;
        }
        return 40 << (byteBuffer.get(position + n + n2) >> 4 & 0x7);
    }
    
    public static int i(final byte[] array) {
        final byte b = array[4];
        boolean b2 = false;
        if (b == -8 && array[5] == 114 && array[6] == 111 && (array[7] & 0xFE) == 0xBA) {
            if ((array[7] & 0xFF) == 0xBB) {
                b2 = true;
            }
            int n;
            if (b2) {
                n = 9;
            }
            else {
                n = 8;
            }
            return 40 << (array[n] >> 4 & 0x7);
        }
        return 0;
    }
    
    public static final class SyncFrameInfo
    {
        public final String a;
        public final int b;
        public final int c;
        public final int d;
        public final int e;
        public final int f;
        
        private SyncFrameInfo(final String a, final int b, final int d, final int c, final int e, final int f) {
            this.a = a;
            this.b = b;
            this.d = d;
            this.c = c;
            this.e = e;
            this.f = f;
        }
        
        SyncFrameInfo(final String s, final int n, final int n2, final int n3, final int n4, final int n5, final Ac3Util$a object) {
            this(s, n, n2, n3, n4, n5);
        }
        
        @Documented
        @Retention(RetentionPolicy.SOURCE)
        @Target({ ElementType.TYPE_USE })
        public @interface StreamType {
        }
    }
}
