// 
// Decompiled by Procyon v0.6.0
// 

package com.google.crypto.tink.subtle;

import java.nio.ShortBuffer;
import java.nio.IntBuffer;
import java.nio.LongBuffer;
import java.nio.ByteOrder;
import java.nio.ByteBuffer;
import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;

public final class Base64
{
    private static final Charset a;
    
    static {
        a = Charset.forName("UTF-8");
    }
    
    private Base64() {
    }
    
    public static byte[] a(final String s) {
        return b(s, 2);
    }
    
    public static byte[] b(final String s, final int n) {
        return c(s.getBytes(Base64.a), n);
    }
    
    public static byte[] c(final byte[] array, final int n) {
        return d(array, 0, array.length, n);
    }
    
    public static byte[] d(byte[] array, int b, final int n, final int n2) {
        final b b2 = new b(n2, new byte[n * 3 / 4]);
        if (!b2.a(array, b, n, true)) {
            throw new IllegalArgumentException("bad base-64");
        }
        b = ((a)b2).b;
        final byte[] a = ((a)b2).a;
        if (b == a.length) {
            return a;
        }
        array = new byte[b];
        System.arraycopy(a, 0, array, 0, b);
        return array;
    }
    
    public static String e(final byte[] array) {
        return h(array, 2);
    }
    
    public static byte[] f(final byte[] array, final int n) {
        return g(array, 0, array.length, n);
    }
    
    public static byte[] g(final byte[] array, final int n, final int n2, int n3) {
        final c c = new c(n3, null);
        final int n4 = n2 / 3 * 4;
        final boolean f = c.f;
        final int n5 = 2;
        if (f) {
            n3 = n4;
            if (n2 % 3 > 0) {
                n3 = n4 + 4;
            }
        }
        else {
            n3 = n2 % 3;
            if (n3 != 1) {
                if (n3 != 2) {
                    n3 = n4;
                }
                else {
                    n3 = n4 + 3;
                }
            }
            else {
                n3 = n4 + 2;
            }
        }
        int n6 = n3;
        if (c.g) {
            n6 = n3;
            if (n2 > 0) {
                final int n7 = (n2 - 1) / 57;
                int n8;
                if (c.h) {
                    n8 = n5;
                }
                else {
                    n8 = 1;
                }
                n6 = n3 + (n7 + 1) * n8;
            }
        }
        ((a)c).a = new byte[n6];
        c.a(array, n, n2, true);
        return ((a)c).a;
    }
    
    public static String h(final byte[] array, final int n) {
        try {
            return new String(f(array, n), "US-ASCII");
        }
        catch (final UnsupportedEncodingException ex) {
            throw new AssertionError((Object)ex);
        }
    }
    
    public static byte[] i(final String s) {
        return b(s, 11);
    }
    
    static class b extends a
    {
        private static final int[] f;
        private static final int[] g;
        private int c;
        private int d;
        private final int[] e;
        
        static {
            f = $d2j$hex$80a87522$decode_I("ffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffff3e000000ffffffffffffffffffffffff3f0000003400000035000000360000003700000038000000390000003a0000003b0000003c0000003d000000fffffffffffffffffffffffffeffffffffffffffffffffffffffffff000000000100000002000000030000000400000005000000060000000700000008000000090000000a0000000b0000000c0000000d0000000e0000000f00000010000000110000001200000013000000140000001500000016000000170000001800000019000000ffffffffffffffffffffffffffffffffffffffffffffffff1a0000001b0000001c0000001d0000001e0000001f000000200000002100000022000000230000002400000025000000260000002700000028000000290000002a0000002b0000002c0000002d0000002e0000002f00000030000000310000003200000033000000ffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffff");
            g = $d2j$hex$80a87522$decode_I("ffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffff3e000000ffffffffffffffff3400000035000000360000003700000038000000390000003a0000003b0000003c0000003d000000fffffffffffffffffffffffffeffffffffffffffffffffffffffffff000000000100000002000000030000000400000005000000060000000700000008000000090000000a0000000b0000000c0000000d0000000e0000000f00000010000000110000001200000013000000140000001500000016000000170000001800000019000000ffffffffffffffffffffffffffffffff3f000000ffffffff1a0000001b0000001c0000001d0000001e0000001f000000200000002100000022000000230000002400000025000000260000002700000028000000290000002a0000002b0000002c0000002d0000002e0000002f00000030000000310000003200000033000000ffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffff");
        }
        
        public b(final int n, final byte[] a) {
            super.a = a;
            int[] e;
            if ((n & 0x8) == 0x0) {
                e = b.f;
            }
            else {
                e = b.g;
            }
            this.e = e;
            this.c = 0;
            this.d = 0;
        }
        
        public boolean a(final byte[] array, int n, int n2, final boolean b) {
            int c = this.c;
            if (c == 6) {
                return false;
            }
            final int n3 = n2 + n;
            final int d = this.d;
            final byte[] a = super.a;
            final int[] e = this.e;
            n2 = 0;
            int n4 = n;
            n = d;
            int d2;
            int n5;
            while (true) {
                d2 = n;
                n5 = n2;
                if (n4 >= n3) {
                    break;
                }
                int n6 = n4;
                int n7 = n;
                int n8 = n2;
                if (c == 0) {
                    while (true) {
                        final int n9 = n4 + 4;
                        if (n9 > n3) {
                            break;
                        }
                        final int n10 = e[array[n4] & 0xFF] << 18 | e[array[n4 + 1] & 0xFF] << 12 | e[array[n4 + 2] & 0xFF] << 6 | e[array[n4 + 3] & 0xFF];
                        if ((n = n10) < 0) {
                            break;
                        }
                        a[n2 + 2] = (byte)n10;
                        a[n2 + 1] = (byte)(n10 >> 8);
                        a[n2] = (byte)(n10 >> 16);
                        n2 += 3;
                        n4 = n9;
                        n = n10;
                    }
                    n6 = n4;
                    n7 = n;
                    n8 = n2;
                    if (n4 >= n3) {
                        d2 = n;
                        n5 = n2;
                        break;
                    }
                }
                final int n11 = e[array[n6] & 0xFF];
                Label_0600: {
                    if (c != 0) {
                        Label_0524: {
                            if (c != 1) {
                                if (c != 2) {
                                    if (c != 3) {
                                        if (c != 4) {
                                            if (c != 5) {
                                                n = c;
                                                n2 = n8;
                                                break Label_0600;
                                            }
                                            n = c;
                                            n2 = n8;
                                            if (n11 == -1) {
                                                break Label_0600;
                                            }
                                            this.c = 6;
                                        }
                                        else {
                                            if (n11 == -2) {
                                                n = c + 1;
                                                n2 = n8;
                                                break Label_0600;
                                            }
                                            n = c;
                                            n2 = n8;
                                            if (n11 != -1) {
                                                this.c = 6;
                                                return false;
                                            }
                                            break Label_0600;
                                        }
                                    }
                                    else {
                                        if (n11 >= 0) {
                                            n7 = (n11 | n7 << 6);
                                            a[n8 + 2] = (byte)n7;
                                            a[n8 + 1] = (byte)(n7 >> 8);
                                            a[n8] = (byte)(n7 >> 16);
                                            n2 = n8 + 3;
                                            n = 0;
                                            break Label_0600;
                                        }
                                        if (n11 == -2) {
                                            a[n8 + 1] = (byte)(n7 >> 2);
                                            a[n8] = (byte)(n7 >> 10);
                                            n2 = n8 + 2;
                                            n = 5;
                                            break Label_0600;
                                        }
                                        n = c;
                                        n2 = n8;
                                        if (n11 != -1) {
                                            this.c = 6;
                                            return false;
                                        }
                                        break Label_0600;
                                    }
                                }
                                else {
                                    if (n11 >= 0) {
                                        break Label_0524;
                                    }
                                    if (n11 == -2) {
                                        a[n8] = (byte)(n7 >> 4);
                                        n2 = n8 + 1;
                                        n = 4;
                                        break Label_0600;
                                    }
                                    n = c;
                                    n2 = n8;
                                    if (n11 == -1) {
                                        break Label_0600;
                                    }
                                    this.c = 6;
                                }
                                return false;
                            }
                            if (n11 < 0) {
                                n = c;
                                n2 = n8;
                                if (n11 != -1) {
                                    this.c = 6;
                                    return false;
                                }
                                break Label_0600;
                            }
                        }
                        n = (n11 | n7 << 6);
                    }
                    else if (n11 >= 0) {
                        n = n11;
                    }
                    else {
                        n = c;
                        n2 = n8;
                        if (n11 != -1) {
                            this.c = 6;
                            return false;
                        }
                        break Label_0600;
                    }
                    n2 = c + 1;
                    n7 = n;
                    n = n2;
                    n2 = n8;
                }
                n4 = n6 + 1;
                c = n;
                n = n7;
            }
            if (!b) {
                this.c = c;
                this.d = d2;
                super.b = n5;
                return true;
            }
            if (c != 1) {
                if (c != 2) {
                    if (c != 3) {
                        if (c == 4) {
                            this.c = 6;
                            return false;
                        }
                    }
                    else {
                        n = n5 + 1;
                        a[n5] = (byte)(d2 >> 10);
                        n5 = n + 1;
                        a[n] = (byte)(d2 >> 2);
                    }
                }
                else {
                    a[n5] = (byte)(d2 >> 4);
                    ++n5;
                }
                this.c = c;
                super.b = n5;
                return true;
            }
            this.c = 6;
            return false;
        }
        
        private static long[] $d2j$hex$80a87522$decode_J(final String src) {
            final byte[] d = $d2j$hex$80a87522$decode_B(src);
            final ByteBuffer b = ByteBuffer.wrap(d);
            b.order(ByteOrder.LITTLE_ENDIAN);
            final LongBuffer s = b.asLongBuffer();
            final long[] data = new long[d.length / 8];
            s.get(data);
            return data;
        }
        
        private static int[] $d2j$hex$80a87522$decode_I(final String src) {
            final byte[] d = $d2j$hex$80a87522$decode_B(src);
            final ByteBuffer b = ByteBuffer.wrap(d);
            b.order(ByteOrder.LITTLE_ENDIAN);
            final IntBuffer s = b.asIntBuffer();
            final int[] data = new int[d.length / 4];
            s.get(data);
            return data;
        }
        
        private static short[] $d2j$hex$80a87522$decode_S(final String src) {
            final byte[] d = $d2j$hex$80a87522$decode_B(src);
            final ByteBuffer b = ByteBuffer.wrap(d);
            b.order(ByteOrder.LITTLE_ENDIAN);
            final ShortBuffer s = b.asShortBuffer();
            final short[] data = new short[d.length / 2];
            s.get(data);
            return data;
        }
        
        private static byte[] $d2j$hex$80a87522$decode_B(final String src) {
            final char[] d = src.toCharArray();
            final byte[] ret = new byte[src.length() / 2];
            for (int i = 0; i < ret.length; ++i) {
                final char h = d[2 * i];
                final char l = d[2 * i + 1];
                int hh;
                if (h >= '0' && h <= '9') {
                    hh = h - '0';
                }
                else if (h >= 'a' && h <= 'f') {
                    hh = h - 'a' + 10;
                }
                else {
                    if (h < 'A' || h > 'F') {
                        throw new RuntimeException();
                    }
                    hh = h - 'A' + 10;
                }
                int ll;
                if (l >= '0' && l <= '9') {
                    ll = l - '0';
                }
                else if (l >= 'a' && l <= 'f') {
                    ll = l - 'a' + 10;
                }
                else {
                    if (l < 'A' || l > 'F') {
                        throw new RuntimeException();
                    }
                    ll = l - 'A' + 10;
                }
                ret[i] = (byte)(hh << 4 | ll);
            }
            return ret;
        }
    }
    
    abstract static class a
    {
        public byte[] a;
        public int b;
    }
    
    static class c extends a
    {
        private static final byte[] j;
        private static final byte[] k;
        private final byte[] c;
        int d;
        private int e;
        public final boolean f;
        public final boolean g;
        public final boolean h;
        private final byte[] i;
        
        static {
            j = new byte[] { 65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 97, 98, 99, 100, 101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, 117, 118, 119, 120, 121, 122, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 43, 47 };
            k = new byte[] { 65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 97, 98, 99, 100, 101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, 117, 118, 119, 120, 121, 122, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 45, 95 };
        }
        
        public c(int e, byte[] array) {
            super.a = array;
            boolean h = true;
            this.f = ((e & 0x1) == 0x0);
            final boolean g = (e & 0x2) == 0x0;
            this.g = g;
            if ((e & 0x4) == 0x0) {
                h = false;
            }
            this.h = h;
            if ((e & 0x8) == 0x0) {
                array = c.j;
            }
            else {
                array = c.k;
            }
            this.i = array;
            this.c = new byte[2];
            this.d = 0;
            if (g) {
                e = 19;
            }
            else {
                e = -1;
            }
            this.e = e;
        }
        
        public boolean a(byte[] c, int n, int d, final boolean b) {
            final byte[] i = this.i;
            final byte[] a = super.a;
            int e = this.e;
            final int n2 = d + n;
            d = this.d;
            final int n3 = 0;
            final int n4 = 0;
            Label_0181: {
                if (d != 1) {
                    if (d == 2) {
                        d = n + 1;
                        if (d <= n2) {
                            final byte[] c2 = this.c;
                            n = ((c2[1] & 0xFF) << 8 | (c2[0] & 0xFF) << 16 | (c[n] & 0xFF));
                            this.d = 0;
                            break Label_0181;
                        }
                    }
                }
                else if (n + 2 <= n2) {
                    final byte b2 = this.c[0];
                    final int n5 = n + 1;
                    n = c[n];
                    d = n5 + 1;
                    n = ((c[n5] & 0xFF) | ((b2 & 0xFF) << 16 | (n & 0xFF) << 8));
                    this.d = 0;
                    break Label_0181;
                }
                final int n6 = -1;
                d = n;
                n = n6;
            }
            while (true) {
                Label_0281: {
                    if (n != -1) {
                        a[0] = i[n >> 18 & 0x3F];
                        a[1] = i[n >> 12 & 0x3F];
                        a[2] = i[n >> 6 & 0x3F];
                        a[3] = i[n & 0x3F];
                        if (--e == 0) {
                            if (this.h) {
                                n = 5;
                                a[4] = 13;
                            }
                            else {
                                n = 4;
                            }
                            final int n7 = n + 1;
                            a[n] = 10;
                            n = n7;
                            break Label_0281;
                        }
                        n = 4;
                    }
                    else {
                        n = 0;
                    }
                    while (true) {
                        final int n8 = d + 3;
                        if (n8 > n2) {
                            int b4 = 0;
                            Label_1025: {
                                if (b) {
                                    final int d2 = this.d;
                                    if (d - d2 == n2 - 1) {
                                        byte b3;
                                        if (d2 > 0) {
                                            b3 = this.c[0];
                                            d = 1;
                                        }
                                        else {
                                            b3 = c[d];
                                            d = n4;
                                        }
                                        final int n9 = (b3 & 0xFF) << 4;
                                        this.d = d2 - d;
                                        final int n10 = n + 1;
                                        a[n] = i[n9 >> 6 & 0x3F];
                                        d = n10 + 1;
                                        a[n10] = i[n9 & 0x3F];
                                        n = d;
                                        if (this.f) {
                                            final int n11 = d + 1;
                                            a[d] = 61;
                                            n = n11 + 1;
                                            a[n11] = 61;
                                        }
                                        b4 = n;
                                        if (!this.g) {
                                            break Label_1025;
                                        }
                                        d = n;
                                        if (this.h) {
                                            a[n] = 13;
                                            d = n + 1;
                                        }
                                        n = d + 1;
                                        a[d] = 10;
                                    }
                                    else {
                                        if (d - d2 == n2 - 2) {
                                            byte b5;
                                            int n12;
                                            if (d2 > 1) {
                                                b5 = this.c[0];
                                                n12 = 1;
                                            }
                                            else {
                                                b5 = c[d];
                                                ++d;
                                                n12 = n3;
                                            }
                                            int n13;
                                            if (d2 > 0) {
                                                c = this.c;
                                                d = n12 + 1;
                                                n13 = c[n12];
                                            }
                                            else {
                                                final byte b6 = c[d];
                                                d = n12;
                                                n13 = b6;
                                            }
                                            final int n14 = (b5 & 0xFF) << 10 | (n13 & 0xFF) << 2;
                                            this.d = d2 - d;
                                            d = n + 1;
                                            a[n] = i[n14 >> 12 & 0x3F];
                                            n = d + 1;
                                            a[d] = i[n14 >> 6 & 0x3F];
                                            d = n + 1;
                                            a[n] = i[n14 & 0x3F];
                                            n = d;
                                            if (this.f) {
                                                a[d] = 61;
                                                n = d + 1;
                                            }
                                            d = n;
                                            if (this.g) {
                                                d = n;
                                                if (this.h) {
                                                    a[n] = 13;
                                                    d = n + 1;
                                                }
                                                a[d] = 10;
                                                ++d;
                                            }
                                            b4 = d;
                                            break Label_1025;
                                        }
                                        b4 = n;
                                        if (!this.g || (b4 = n) <= 0) {
                                            break Label_1025;
                                        }
                                        b4 = n;
                                        if (e == 19) {
                                            break Label_1025;
                                        }
                                        d = n;
                                        if (this.h) {
                                            a[n] = 13;
                                            d = n + 1;
                                        }
                                        n = d + 1;
                                        a[d] = 10;
                                    }
                                    b4 = n;
                                }
                                else if (d == n2 - 1) {
                                    this.c[this.d++] = c[d];
                                    b4 = n;
                                }
                                else {
                                    b4 = n;
                                    if (d == n2 - 2) {
                                        final byte[] c3 = this.c;
                                        final int d3 = this.d;
                                        final int d4 = d3 + 1;
                                        this.d = d4;
                                        c3[d3] = c[d];
                                        this.d = d4 + 1;
                                        c3[d4] = c[d + 1];
                                        b4 = n;
                                    }
                                }
                            }
                            super.b = b4;
                            this.e = e;
                            return true;
                        }
                        d = ((c[d + 1] & 0xFF) << 8 | (c[d] & 0xFF) << 16 | (c[d + 2] & 0xFF));
                        a[n] = i[d >> 18 & 0x3F];
                        a[n + 1] = i[d >> 12 & 0x3F];
                        a[n + 2] = i[d >> 6 & 0x3F];
                        a[n + 3] = i[d & 0x3F];
                        n += 4;
                        if (--e == 0) {
                            d = n;
                            if (this.h) {
                                a[n] = 13;
                                d = n + 1;
                            }
                            a[d] = 10;
                            n = d + 1;
                            d = n8;
                            break;
                        }
                        d = n8;
                    }
                }
                e = 19;
                continue;
            }
        }
    }
}
