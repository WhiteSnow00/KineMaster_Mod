// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.exoplayer2.audio;

import com.google.android.exoplayer2.util.ParsableBitArray;
import java.nio.ByteBuffer;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.drm.DrmInitData;
import com.google.android.exoplayer2.util.ParsableByteArray;

public final class Ac4Util
{
    private static final int[] a;
    
    static {
        a = new int[] { 2002, 2000, 1920, 1601, 1600, 1001, 1000, 960, 800, 800, 480, 400, 400, 2048 };
    }
    
    private Ac4Util() {
    }
    
    public static void a(final int n, final ParsableByteArray parsableByteArray) {
        parsableByteArray.L(7);
        final byte[] d = parsableByteArray.d();
        d[0] = -84;
        d[1] = 64;
        d[3] = (d[2] = -1);
        d[4] = (byte)(n >> 16 & 0xFF);
        d[5] = (byte)(n >> 8 & 0xFF);
        d[6] = (byte)(n & 0xFF);
    }
    
    public static Format b(final ParsableByteArray parsableByteArray, final String s, final String s2, final DrmInitData drmInitData) {
        parsableByteArray.Q(1);
        int n;
        if ((parsableByteArray.D() & 0x20) >> 5 == 1) {
            n = 48000;
        }
        else {
            n = 44100;
        }
        return new Format.Builder().S(s).e0("audio/ac4").H(2).f0(n).M(drmInitData).V(s2).E();
    }
    
    public static int c(final ByteBuffer byteBuffer) {
        final byte[] array = new byte[16];
        final int position = byteBuffer.position();
        byteBuffer.get(array);
        byteBuffer.position(position);
        return d(new ParsableBitArray(array)).e;
    }
    
    public static SyncFrameInfo d(final ParsableBitArray parsableBitArray) {
        final int h = parsableBitArray.h(16);
        int n = parsableBitArray.h(16);
        int n2;
        if (n == 65535) {
            n = parsableBitArray.h(24);
            n2 = 7;
        }
        else {
            n2 = 4;
        }
        int n3 = n + n2;
        if (h == 44097) {
            n3 += 2;
        }
        final int h2 = parsableBitArray.h(2);
        int n4;
        if ((n4 = h2) == 3) {
            n4 = h2 + f(parsableBitArray, 2);
        }
        final int h3 = parsableBitArray.h(10);
        if (parsableBitArray.g() && parsableBitArray.h(3) > 0) {
            parsableBitArray.r(2);
        }
        int n5;
        if (parsableBitArray.g()) {
            n5 = 48000;
        }
        else {
            n5 = 44100;
        }
        final int h4 = parsableBitArray.h(4);
        final int n6 = 0;
        int n7;
        if (n5 == 44100 && h4 == 13) {
            n7 = Ac4Util.a[h4];
        }
        else {
            n7 = n6;
            if (n5 == 48000) {
                final int[] a = Ac4Util.a;
                n7 = n6;
                if (h4 < a.length) {
                    final int n8 = a[h4];
                    final int n9 = h3 % 5;
                    Label_0275: {
                        Label_0259: {
                            if (n9 != 1) {
                                if (n9 != 2) {
                                    if (n9 == 3) {
                                        break Label_0259;
                                    }
                                    if (n9 != 4) {
                                        n7 = n8;
                                        return new SyncFrameInfo(n4, 2, n5, n3, n7, null);
                                    }
                                    if (h4 != 3 && h4 != 8) {
                                        n7 = n8;
                                        if (h4 != 11) {
                                            return new SyncFrameInfo(n4, 2, n5, n3, n7, null);
                                        }
                                    }
                                }
                                else if (h4 != 8) {
                                    n7 = n8;
                                    if (h4 != 11) {
                                        return new SyncFrameInfo(n4, 2, n5, n3, n7, null);
                                    }
                                }
                                break Label_0275;
                            }
                        }
                        if (h4 != 3) {
                            n7 = n8;
                            if (h4 != 8) {
                                return new SyncFrameInfo(n4, 2, n5, n3, n7, null);
                            }
                        }
                    }
                    n7 = n8 + 1;
                }
            }
        }
        return new SyncFrameInfo(n4, 2, n5, n3, n7, null);
    }
    
    public static int e(final byte[] array, final int n) {
        final int length = array.length;
        int n2 = 7;
        if (length < 7) {
            return -1;
        }
        int n3 = (array[2] & 0xFF) << 8 | (array[3] & 0xFF);
        if (n3 == 65535) {
            n3 = ((array[4] & 0xFF) << 16 | (array[5] & 0xFF) << 8 | (array[6] & 0xFF));
        }
        else {
            n2 = 4;
        }
        int n4 = n2;
        if (n == 44097) {
            n4 = n2 + 2;
        }
        return n3 + n4;
    }
    
    private static int f(final ParsableBitArray parsableBitArray, final int n) {
        int n2 = 0;
        int n3;
        while (true) {
            n3 = n2 + parsableBitArray.h(n);
            if (!parsableBitArray.g()) {
                break;
            }
            n2 = n3 + 1 << n;
        }
        return n3;
    }
    
    public static final class SyncFrameInfo
    {
        public final int a;
        public final int b;
        public final int c;
        public final int d;
        public final int e;
        
        private SyncFrameInfo(final int a, final int c, final int b, final int d, final int e) {
            this.a = a;
            this.c = c;
            this.b = b;
            this.d = d;
            this.e = e;
        }
        
        SyncFrameInfo(final int n, final int n2, final int n3, final int n4, final int n5, final Ac4Util$a object) {
            this(n, n2, n3, n4, n5);
        }
    }
}
