// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.exoplayer2.audio;

public final class MpegAudioUtil
{
    private static final String[] a;
    private static final int[] b;
    private static final int[] c;
    private static final int[] d;
    private static final int[] e;
    private static final int[] f;
    private static final int[] g;
    
    static {
        a = new String[] { "audio/mpeg-L1", "audio/mpeg-L2", "audio/mpeg" };
        b = new int[] { 44100, 48000, 32000 };
        c = new int[] { 32000, 64000, 96000, 128000, 160000, 192000, 224000, 256000, 288000, 320000, 352000, 384000, 416000, 448000 };
        d = new int[] { 32000, 48000, 56000, 64000, 80000, 96000, 112000, 128000, 144000, 160000, 176000, 192000, 224000, 256000 };
        e = new int[] { 32000, 48000, 56000, 64000, 80000, 96000, 112000, 128000, 160000, 192000, 224000, 256000, 320000, 384000 };
        f = new int[] { 32000, 40000, 48000, 56000, 64000, 80000, 96000, 112000, 128000, 160000, 192000, 224000, 256000, 320000 };
        g = new int[] { 8000, 16000, 24000, 32000, 40000, 48000, 56000, 64000, 80000, 96000, 112000, 128000, 144000, 160000 };
    }
    
    private MpegAudioUtil() {
    }
    
    static boolean a(final int n) {
        return l(n);
    }
    
    static String[] b() {
        return MpegAudioUtil.a;
    }
    
    static int[] c() {
        return MpegAudioUtil.b;
    }
    
    static int d(final int n, final int n2) {
        return k(n, n2);
    }
    
    static int[] e() {
        return MpegAudioUtil.c;
    }
    
    static int[] f() {
        return MpegAudioUtil.d;
    }
    
    static int[] g() {
        return MpegAudioUtil.e;
    }
    
    static int[] h() {
        return MpegAudioUtil.f;
    }
    
    static int[] i() {
        return MpegAudioUtil.g;
    }
    
    public static int j(int n) {
        if (!l(n)) {
            return -1;
        }
        final int n2 = n >>> 19 & 0x3;
        if (n2 == 1) {
            return -1;
        }
        final int n3 = n >>> 17 & 0x3;
        if (n3 == 0) {
            return -1;
        }
        final int n4 = n >>> 12 & 0xF;
        if (n4 == 0 || n4 == 15) {
            return -1;
        }
        final int n5 = n >>> 10 & 0x3;
        if (n5 == 3) {
            return -1;
        }
        final int n6 = MpegAudioUtil.b[n5];
        int n7;
        if (n2 == 2) {
            n7 = n6 / 2;
        }
        else {
            n7 = n6;
            if (n2 == 0) {
                n7 = n6 / 4;
            }
        }
        final int n8 = n >>> 9 & 0x1;
        if (n3 == 3) {
            if (n2 == 3) {
                n = MpegAudioUtil.c[n4 - 1];
            }
            else {
                n = MpegAudioUtil.d[n4 - 1];
            }
            return (n * 12 / n7 + n8) * 4;
        }
        if (n2 == 3) {
            if (n3 == 2) {
                n = MpegAudioUtil.e[n4 - 1];
            }
            else {
                n = MpegAudioUtil.f[n4 - 1];
            }
        }
        else {
            n = MpegAudioUtil.g[n4 - 1];
        }
        int n9 = 144;
        if (n2 == 3) {
            return n * 144 / n7 + n8;
        }
        if (n3 == 1) {
            n9 = 72;
        }
        return n9 * n / n7 + n8;
    }
    
    private static int k(int n, final int n2) {
        final int n3 = 1152;
        if (n2 == 1) {
            if (n == 3) {
                n = n3;
            }
            else {
                n = 576;
            }
            return n;
        }
        if (n2 == 2) {
            return 1152;
        }
        if (n2 == 3) {
            return 384;
        }
        throw new IllegalArgumentException();
    }
    
    private static boolean l(final int n) {
        return (n & 0xFFE00000) == 0xFFE00000;
    }
    
    public static int m(final int n) {
        if (!l(n)) {
            return -1;
        }
        final int n2 = n >>> 19 & 0x3;
        if (n2 == 1) {
            return -1;
        }
        final int n3 = n >>> 17 & 0x3;
        if (n3 == 0) {
            return -1;
        }
        final int n4 = n >>> 12 & 0xF;
        if (n4 != 0 && n4 != 15 && (n >>> 10 & 0x3) != 0x3) {
            return k(n2, n3);
        }
        return -1;
    }
    
    public static final class Header
    {
        public int a;
        public String b;
        public int c;
        public int d;
        public int e;
        public int f;
        public int g;
        
        public boolean a(final int n) {
            if (!MpegAudioUtil.a(n)) {
                return false;
            }
            final int a = n >>> 19 & 0x3;
            if (a == 1) {
                return false;
            }
            final int n2 = n >>> 17 & 0x3;
            if (n2 == 0) {
                return false;
            }
            final int n3 = n >>> 12 & 0xF;
            if (n3 == 0 || n3 == 15) {
                return false;
            }
            final int n4 = n >>> 10 & 0x3;
            if (n4 == 3) {
                return false;
            }
            this.a = a;
            this.b = MpegAudioUtil.b()[3 - n2];
            final int d = MpegAudioUtil.c()[n4];
            this.d = d;
            final int n5 = 2;
            if (a == 2) {
                this.d = d / 2;
            }
            else if (a == 0) {
                this.d = d / 4;
            }
            final int n6 = n >>> 9 & 0x1;
            this.g = MpegAudioUtil.d(a, n2);
            if (n2 == 3) {
                int f;
                if (a == 3) {
                    f = MpegAudioUtil.e()[n3 - 1];
                }
                else {
                    f = MpegAudioUtil.f()[n3 - 1];
                }
                this.f = f;
                this.c = (f * 12 / this.d + n6) * 4;
            }
            else {
                int n7 = 144;
                if (a == 3) {
                    int f2;
                    if (n2 == 2) {
                        f2 = MpegAudioUtil.g()[n3 - 1];
                    }
                    else {
                        f2 = MpegAudioUtil.h()[n3 - 1];
                    }
                    this.f = f2;
                    this.c = f2 * 144 / this.d + n6;
                }
                else {
                    final int f3 = MpegAudioUtil.i()[n3 - 1];
                    this.f = f3;
                    if (n2 == 1) {
                        n7 = 72;
                    }
                    this.c = n7 * f3 / this.d + n6;
                }
            }
            int e = n5;
            if ((n >> 6 & 0x3) == 0x3) {
                e = 1;
            }
            this.e = e;
            return true;
        }
    }
}
