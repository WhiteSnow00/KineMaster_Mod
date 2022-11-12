// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.exoplayer2.audio;

import java.lang.annotation.ElementType;
import java.lang.annotation.Target;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Retention;
import java.lang.annotation.Documented;
import com.google.android.exoplayer2.util.Log;
import com.google.android.exoplayer2.ParserException;
import com.google.android.exoplayer2.util.ParsableBitArray;

public final class AacUtil
{
    private static final int[] a;
    private static final int[] b;
    
    static {
        a = new int[] { 96000, 88200, 64000, 48000, 44100, 32000, 24000, 22050, 16000, 12000, 11025, 8000, 7350 };
        b = new int[] { 0, 1, 2, 3, 4, 5, 6, 8, -1, -1, -1, 7, 8, -1, 8, -1 };
    }
    
    private AacUtil() {
    }
    
    public static byte[] a(final int n, final int n2) {
        final int n3 = 0;
        int n4 = 0;
        int n5 = -1;
        while (true) {
            final int[] a = AacUtil.a;
            if (n4 >= a.length) {
                break;
            }
            if (n == a[n4]) {
                n5 = n4;
            }
            ++n4;
        }
        int n6 = -1;
        int n7 = n3;
        while (true) {
            final int[] b = AacUtil.b;
            if (n7 >= b.length) {
                break;
            }
            if (n2 == b[n7]) {
                n6 = n7;
            }
            ++n7;
        }
        if (n != -1 && n6 != -1) {
            return b(2, n5, n6);
        }
        final StringBuilder sb = new StringBuilder();
        sb.append("Invalid sample rate or number of channels: ");
        sb.append(n);
        sb.append(", ");
        sb.append(n2);
        throw new IllegalArgumentException(sb.toString());
    }
    
    public static byte[] b(final int n, final int n2, final int n3) {
        return new byte[] { (byte)((n << 3 & 0xF8) | (n2 >> 1 & 0x7)), (byte)((n2 << 7 & 0x80) | (n3 << 3 & 0x78)) };
    }
    
    private static int c(final ParsableBitArray parsableBitArray) {
        int h;
        if ((h = parsableBitArray.h(5)) == 31) {
            h = parsableBitArray.h(6) + 32;
        }
        return h;
    }
    
    private static int d(final ParsableBitArray parsableBitArray) throws ParserException {
        final int h = parsableBitArray.h(4);
        int h2;
        if (h == 15) {
            h2 = parsableBitArray.h(24);
        }
        else {
            if (h >= 13) {
                throw ParserException.createForMalformedContainer(null, null);
            }
            h2 = AacUtil.a[h];
        }
        return h2;
    }
    
    public static Config e(final ParsableBitArray parsableBitArray, final boolean b) throws ParserException {
        final int c = c(parsableBitArray);
        int d = d(parsableBitArray);
        final int h = parsableBitArray.h(4);
        final StringBuilder sb = new StringBuilder();
        sb.append("mp4a.40.");
        sb.append(c);
        final String string = sb.toString();
        int c2 = 0;
        int h2 = 0;
        Label_0112: {
            if (c != 5) {
                c2 = c;
                h2 = h;
                if (c != 29) {
                    break Label_0112;
                }
            }
            final int d2 = d(parsableBitArray);
            final int n = c2 = c(parsableBitArray);
            d = d2;
            h2 = h;
            if (n == 22) {
                h2 = parsableBitArray.h(4);
                d = d2;
                c2 = n;
            }
        }
        if (b) {
            if (c2 != 1 && c2 != 2 && c2 != 3 && c2 != 4 && c2 != 6 && c2 != 7 && c2 != 17) {
                switch (c2) {
                    default: {
                        final StringBuilder sb2 = new StringBuilder();
                        sb2.append("Unsupported audio object type: ");
                        sb2.append(c2);
                        throw ParserException.createForUnsupportedContainerFeature(sb2.toString());
                    }
                    case 19:
                    case 20:
                    case 21:
                    case 22:
                    case 23: {
                        break;
                    }
                }
            }
            g(parsableBitArray, c2, h2);
            switch (c2) {
                case 17:
                case 19:
                case 20:
                case 21:
                case 22:
                case 23: {
                    final int h3 = parsableBitArray.h(2);
                    if (h3 != 2 && h3 != 3) {
                        break;
                    }
                    final StringBuilder sb3 = new StringBuilder();
                    sb3.append("Unsupported epConfig: ");
                    sb3.append(h3);
                    throw ParserException.createForUnsupportedContainerFeature(sb3.toString());
                }
            }
        }
        final int n2 = AacUtil.b[h2];
        if (n2 != -1) {
            return new Config(d, n2, string, null);
        }
        throw ParserException.createForMalformedContainer(null, null);
    }
    
    public static Config f(final byte[] array) throws ParserException {
        return e(new ParsableBitArray(array), false);
    }
    
    private static void g(final ParsableBitArray parsableBitArray, final int n, final int n2) {
        if (parsableBitArray.g()) {
            Log.i("AacUtil", "Unexpected frameLengthFlag = 1");
        }
        if (parsableBitArray.g()) {
            parsableBitArray.r(14);
        }
        final boolean g = parsableBitArray.g();
        if (n2 != 0) {
            if (n == 6 || n == 20) {
                parsableBitArray.r(3);
            }
            if (g) {
                if (n == 22) {
                    parsableBitArray.r(16);
                }
                if (n == 17 || n == 19 || n == 20 || n == 23) {
                    parsableBitArray.r(3);
                }
                parsableBitArray.r(1);
            }
            return;
        }
        throw new UnsupportedOperationException();
    }
    
    @Documented
    @Retention(RetentionPolicy.SOURCE)
    @Target({ ElementType.TYPE_USE })
    public @interface AacAudioObjectType {
    }
    
    public static final class Config
    {
        public final int a;
        public final int b;
        public final String c;
        
        private Config(final int a, final int b, final String c) {
            this.a = a;
            this.b = b;
            this.c = c;
        }
        
        Config(final int n, final int n2, final String s, final AacUtil$a object) {
            this(n, n2, s);
        }
    }
}
