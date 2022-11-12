// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.exoplayer2.util;

import java.util.Arrays;
import java.nio.ByteBuffer;

public final class NalUnitUtil
{
    public static final byte[] a;
    public static final float[] b;
    private static final Object c;
    private static int[] d;
    
    static {
        a = new byte[] { 0, 0, 0, 1 };
        b = new float[] { 1.0f, 1.0f, 1.0909091f, 0.90909094f, 1.4545455f, 1.2121212f, 2.1818182f, 1.8181819f, 2.909091f, 2.4242425f, 1.6363636f, 1.3636364f, 1.939394f, 1.6161616f, 1.3333334f, 1.5f, 2.0f };
        c = new Object();
        NalUnitUtil.d = new int[10];
    }
    
    private NalUnitUtil() {
    }
    
    public static void a(final boolean[] array) {
        array[0] = false;
        array[2] = (array[1] = false);
    }
    
    public static void b(final ByteBuffer byteBuffer) {
        final int position = byteBuffer.position();
        int n = 0;
        int n2 = 0;
        while (true) {
            final int n3 = n + 1;
            if (n3 >= position) {
                byteBuffer.clear();
                return;
            }
            final int n4 = byteBuffer.get(n) & 0xFF;
            int n5;
            if (n2 == 3) {
                n5 = n2;
                if (n4 == 1) {
                    n5 = n2;
                    if ((byteBuffer.get(n3) & 0x1F) == 0x7) {
                        final ByteBuffer duplicate = byteBuffer.duplicate();
                        duplicate.position(n - 3);
                        duplicate.limit(position);
                        byteBuffer.position(0);
                        byteBuffer.put(duplicate);
                        return;
                    }
                }
            }
            else {
                n5 = n2;
                if (n4 == 0) {
                    n5 = n2 + 1;
                }
            }
            n2 = n5;
            if (n4 != 0) {
                n2 = 0;
            }
            n = n3;
        }
    }
    
    public static int c(final byte[] array, int i, final int n, final boolean[] array2) {
        final int n2 = n - i;
        final boolean b = false;
        Assertions.g(n2 >= 0);
        if (n2 == 0) {
            return n;
        }
        if (array2[0]) {
            a(array2);
            return i - 3;
        }
        if (n2 > 1 && array2[1] && array[i] == 1) {
            a(array2);
            return i - 2;
        }
        if (n2 > 2 && array2[2] && array[i] == 0 && array[i + 1] == 1) {
            a(array2);
            return i - 1;
        }
        int n3;
        for (n3 = n - 1, i += 2; i < n3; i += 3) {
            if ((array[i] & 0xFE) == 0x0) {
                final int n4 = i - 2;
                if (array[n4] == 0 && array[i - 1] == 0 && array[i] == 1) {
                    a(array2);
                    return n4;
                }
                i -= 2;
            }
        }
        array2[0] = ((n2 <= 2) ? ((n2 != 2) ? (array2[1] && array[n3] == 1) : (array2[2] && array[n - 2] == 0 && array[n3] == 1)) : (array[n - 3] == 0 && array[n - 2] == 0 && array[n3] == 1));
        array2[1] = ((n2 > 1) ? (array[n - 2] == 0 && array[n3] == 0) : (array2[2] && array[n3] == 0));
        boolean b2 = b;
        if (array[n3] == 0) {
            b2 = true;
        }
        array2[2] = b2;
        return n;
    }
    
    private static int d(final byte[] array, int i, final int n) {
        while (i < n - 2) {
            if (array[i] == 0 && array[i + 1] == 0 && array[i + 2] == 3) {
                return i;
            }
            ++i;
        }
        return n;
    }
    
    public static int e(final byte[] array, final int n) {
        return (array[n + 3] & 0x7E) >> 1;
    }
    
    public static int f(final byte[] array, final int n) {
        return array[n + 3] & 0x1F;
    }
    
    public static boolean g(final String s, final byte b) {
        final boolean equals = "video/avc".equals(s);
        final boolean b2 = true;
        if (equals) {
            final boolean b3 = b2;
            if ((b & 0x1F) == 0x6) {
                return b3;
            }
        }
        return "video/hevc".equals(s) && (b & 0x7E) >> 1 == 39 && b2;
    }
    
    public static H265SpsData h(final byte[] array, final int n, final int n2) {
        return i(array, n + 2, n2);
    }
    
    public static H265SpsData i(final byte[] array, int i, int j) {
        final ParsableNalUnitBitArray parsableNalUnitBitArray = new ParsableNalUnitBitArray(array, i, j);
        parsableNalUnitBitArray.l(4);
        final int e = parsableNalUnitBitArray.e(3);
        parsableNalUnitBitArray.k();
        final int e2 = parsableNalUnitBitArray.e(2);
        final boolean d = parsableNalUnitBitArray.d();
        final int e3 = parsableNalUnitBitArray.e(5);
        int n = 0;
        for (i = 0; i < 32; ++i, n = j) {
            j = n;
            if (parsableNalUnitBitArray.d()) {
                j = (n | 1 << i);
            }
        }
        final int[] array2 = new int[6];
        for (i = 0; i < 6; ++i) {
            array2[i] = parsableNalUnitBitArray.e(8);
        }
        final int e4 = parsableNalUnitBitArray.e(8);
        int k = 0;
        i = 0;
        while (k < e) {
            j = i;
            if (parsableNalUnitBitArray.d()) {
                j = i + 89;
            }
            i = j;
            if (parsableNalUnitBitArray.d()) {
                i = j + 8;
            }
            ++k;
        }
        parsableNalUnitBitArray.l(i);
        if (e > 0) {
            parsableNalUnitBitArray.l((8 - e) * 2);
        }
        final int h = parsableNalUnitBitArray.h();
        j = parsableNalUnitBitArray.h();
        if (j == 3) {
            parsableNalUnitBitArray.k();
        }
        final int h2 = parsableNalUnitBitArray.h();
        final int h3 = parsableNalUnitBitArray.h();
        int n2 = h2;
        i = h3;
        if (parsableNalUnitBitArray.d()) {
            final int h4 = parsableNalUnitBitArray.h();
            final int h5 = parsableNalUnitBitArray.h();
            final int h6 = parsableNalUnitBitArray.h();
            final int h7 = parsableNalUnitBitArray.h();
            if (j != 1 && j != 2) {
                i = 1;
            }
            else {
                i = 2;
            }
            if (j == 1) {
                j = 2;
            }
            else {
                j = 1;
            }
            n2 = h2 - i * (h4 + h5);
            i = h3 - j * (h6 + h7);
        }
        parsableNalUnitBitArray.h();
        parsableNalUnitBitArray.h();
        final int h8 = parsableNalUnitBitArray.h();
        if (parsableNalUnitBitArray.d()) {
            j = 0;
        }
        else {
            j = e;
        }
        while (j <= e) {
            parsableNalUnitBitArray.h();
            parsableNalUnitBitArray.h();
            parsableNalUnitBitArray.h();
            ++j;
        }
        parsableNalUnitBitArray.h();
        parsableNalUnitBitArray.h();
        parsableNalUnitBitArray.h();
        parsableNalUnitBitArray.h();
        parsableNalUnitBitArray.h();
        parsableNalUnitBitArray.h();
        if (parsableNalUnitBitArray.d() && parsableNalUnitBitArray.d()) {
            n(parsableNalUnitBitArray);
        }
        parsableNalUnitBitArray.l(2);
        if (parsableNalUnitBitArray.d()) {
            parsableNalUnitBitArray.l(8);
            parsableNalUnitBitArray.h();
            parsableNalUnitBitArray.h();
            parsableNalUnitBitArray.k();
        }
        p(parsableNalUnitBitArray);
        if (parsableNalUnitBitArray.d()) {
            for (j = 0; j < parsableNalUnitBitArray.h(); ++j) {
                parsableNalUnitBitArray.l(h8 + 4 + 1);
            }
        }
        parsableNalUnitBitArray.l(2);
        float n4;
        final float n3 = n4 = 1.0f;
        j = i;
        if (parsableNalUnitBitArray.d()) {
            float n5 = n3;
            if (parsableNalUnitBitArray.d()) {
                j = parsableNalUnitBitArray.e(8);
                if (j == 255) {
                    j = parsableNalUnitBitArray.e(16);
                    final int e5 = parsableNalUnitBitArray.e(16);
                    n5 = n3;
                    if (j != 0) {
                        n5 = n3;
                        if (e5 != 0) {
                            n5 = j / (float)e5;
                        }
                    }
                }
                else {
                    final float[] b = NalUnitUtil.b;
                    if (j < b.length) {
                        n5 = b[j];
                    }
                    else {
                        final StringBuilder sb = new StringBuilder();
                        sb.append("Unexpected aspect_ratio_idc value: ");
                        sb.append(j);
                        Log.i("NalUnitUtil", sb.toString());
                        n5 = n3;
                    }
                }
            }
            if (parsableNalUnitBitArray.d()) {
                parsableNalUnitBitArray.k();
            }
            if (parsableNalUnitBitArray.d()) {
                parsableNalUnitBitArray.l(4);
                if (parsableNalUnitBitArray.d()) {
                    parsableNalUnitBitArray.l(24);
                }
            }
            if (parsableNalUnitBitArray.d()) {
                parsableNalUnitBitArray.h();
                parsableNalUnitBitArray.h();
            }
            parsableNalUnitBitArray.k();
            n4 = n5;
            j = i;
            if (parsableNalUnitBitArray.d()) {
                j = i * 2;
                n4 = n5;
            }
        }
        return new H265SpsData(e2, d, e3, n, array2, e4, h, n2, j, n4);
    }
    
    public static PpsData j(final byte[] array, final int n, final int n2) {
        return k(array, n + 1, n2);
    }
    
    public static PpsData k(final byte[] array, int h, int h2) {
        final ParsableNalUnitBitArray parsableNalUnitBitArray = new ParsableNalUnitBitArray(array, h, h2);
        h = parsableNalUnitBitArray.h();
        h2 = parsableNalUnitBitArray.h();
        parsableNalUnitBitArray.k();
        return new PpsData(h, h2, parsableNalUnitBitArray.d());
    }
    
    public static SpsData l(final byte[] array, final int n, final int n2) {
        return m(array, n + 1, n2);
    }
    
    public static SpsData m(final byte[] array, int h, int n) {
        final ParsableNalUnitBitArray parsableNalUnitBitArray = new ParsableNalUnitBitArray(array, h, n);
        final int e = parsableNalUnitBitArray.e(8);
        final int e2 = parsableNalUnitBitArray.e(8);
        final int e3 = parsableNalUnitBitArray.e(8);
        final int h2 = parsableNalUnitBitArray.h();
        final int n2 = 1;
        int n3;
        boolean b;
        if (e != 100 && e != 110 && e != 122 && e != 244 && e != 44 && e != 83 && e != 86 && e != 118 && e != 128 && e != 138) {
            n3 = 1;
            b = false;
        }
        else {
            final int h3 = parsableNalUnitBitArray.h();
            final boolean b2 = h3 == 3 && parsableNalUnitBitArray.d();
            parsableNalUnitBitArray.h();
            parsableNalUnitBitArray.h();
            parsableNalUnitBitArray.k();
            n3 = h3;
            b = b2;
            if (parsableNalUnitBitArray.d()) {
                if (h3 != 3) {
                    h = 8;
                }
                else {
                    h = 12;
                }
                n = 0;
                while (true) {
                    n3 = h3;
                    b = b2;
                    if (n >= h) {
                        break;
                    }
                    if (parsableNalUnitBitArray.d()) {
                        int n4;
                        if (n < 6) {
                            n4 = 16;
                        }
                        else {
                            n4 = 64;
                        }
                        o(parsableNalUnitBitArray, n4);
                    }
                    ++n;
                }
            }
        }
        final int h4 = parsableNalUnitBitArray.h();
        final int h5 = parsableNalUnitBitArray.h();
        boolean d = false;
        Label_0337: {
            if (h5 == 0) {
                h = parsableNalUnitBitArray.h() + 4;
            }
            else {
                if (h5 == 1) {
                    d = parsableNalUnitBitArray.d();
                    parsableNalUnitBitArray.g();
                    parsableNalUnitBitArray.g();
                    long n5;
                    for (n5 = parsableNalUnitBitArray.h(), h = 0; h < n5; ++h) {
                        parsableNalUnitBitArray.h();
                    }
                    n = 0;
                    break Label_0337;
                }
                h = 0;
            }
            d = false;
            n = h;
        }
        final int h6 = parsableNalUnitBitArray.h();
        parsableNalUnitBitArray.k();
        final int h7 = parsableNalUnitBitArray.h();
        h = parsableNalUnitBitArray.h();
        final int d2 = parsableNalUnitBitArray.d() ? 1 : 0;
        if (d2 == 0) {
            parsableNalUnitBitArray.k();
        }
        parsableNalUnitBitArray.k();
        final int n6 = (h7 + 1) * 16;
        final int n7 = (2 - d2) * (h + 1) * 16;
        int n8 = n6;
        h = n7;
        if (parsableNalUnitBitArray.d()) {
            final int h8 = parsableNalUnitBitArray.h();
            final int h9 = parsableNalUnitBitArray.h();
            final int h10 = parsableNalUnitBitArray.h();
            final int h11 = parsableNalUnitBitArray.h();
            int n9;
            if (n3 == 0) {
                h = 2 - d2;
                n9 = n2;
            }
            else {
                if (n3 == 3) {
                    h = 1;
                }
                else {
                    h = 2;
                }
                int n10 = 1;
                if (n3 == 1) {
                    n10 = 2;
                }
                final int n11 = (2 - d2) * n10;
                n9 = h;
                h = n11;
            }
            n8 = n6 - (h8 + h9) * n9;
            h = n7 - (h10 + h11) * h;
        }
        float n13;
        final float n12 = n13 = 1.0f;
        if (parsableNalUnitBitArray.d()) {
            n13 = n12;
            if (parsableNalUnitBitArray.d()) {
                final int e4 = parsableNalUnitBitArray.e(8);
                if (e4 == 255) {
                    final int e5 = parsableNalUnitBitArray.e(16);
                    final int e6 = parsableNalUnitBitArray.e(16);
                    n13 = n12;
                    if (e5 != 0) {
                        n13 = n12;
                        if (e6 != 0) {
                            n13 = e5 / (float)e6;
                        }
                    }
                }
                else {
                    final float[] b3 = NalUnitUtil.b;
                    if (e4 < b3.length) {
                        n13 = b3[e4];
                    }
                    else {
                        final StringBuilder sb = new StringBuilder();
                        sb.append("Unexpected aspect_ratio_idc value: ");
                        sb.append(e4);
                        Log.i("NalUnitUtil", sb.toString());
                        n13 = n12;
                    }
                }
            }
        }
        return new SpsData(e, e2, e3, h2, h6, n8, h, n13, b, (boolean)(d2 != 0), h4 + 4, h5, n, d);
    }
    
    private static void n(final ParsableNalUnitBitArray parsableNalUnitBitArray) {
        for (int i = 0; i < 4; ++i) {
            int n2;
            for (int j = 0; j < 6; j += n2) {
                final boolean d = parsableNalUnitBitArray.d();
                final int n = 1;
                if (!d) {
                    parsableNalUnitBitArray.h();
                }
                else {
                    final int min = Math.min(64, 1 << (i << 1) + 4);
                    if (i > 1) {
                        parsableNalUnitBitArray.g();
                    }
                    for (int k = 0; k < min; ++k) {
                        parsableNalUnitBitArray.g();
                    }
                }
                n2 = n;
                if (i == 3) {
                    n2 = 3;
                }
            }
        }
    }
    
    private static void o(final ParsableNalUnitBitArray parsableNalUnitBitArray, final int n) {
        int n2 = 8;
        int i = 0;
        int n3 = 8;
        while (i < n) {
            int n4;
            if ((n4 = n2) != 0) {
                n4 = (parsableNalUnitBitArray.g() + n3 + 256) % 256;
            }
            if (n4 != 0) {
                n3 = n4;
            }
            ++i;
            n2 = n4;
        }
    }
    
    private static void p(final ParsableNalUnitBitArray parsableNalUnitBitArray) {
        final int h = parsableNalUnitBitArray.h();
        int[] array = new int[0];
        int[] copy = new int[0];
        int n = -1;
        int i = 0;
        int n2 = -1;
        while (i < h) {
            int n24;
            int h2;
            if (i != 0 && parsableNalUnitBitArray.d()) {
                final int n3 = n + n2;
                final int n4 = (1 - (parsableNalUnitBitArray.d() ? 1 : 0) * 2) * (parsableNalUnitBitArray.h() + 1);
                final int n5 = n3 + 1;
                final boolean[] array2 = new boolean[n5];
                for (int j = 0; j <= n3; ++j) {
                    if (!parsableNalUnitBitArray.d()) {
                        array2[j] = parsableNalUnitBitArray.d();
                    }
                    else {
                        array2[j] = true;
                    }
                }
                final int[] array3 = new int[n5];
                final int[] array4 = new int[n5];
                int k = n2 - 1;
                int n6 = 0;
                while (k >= 0) {
                    final int n7 = copy[k] + n4;
                    int n8 = n6;
                    if (n7 < 0) {
                        n8 = n6;
                        if (array2[n + k]) {
                            array3[n6] = n7;
                            n8 = n6 + 1;
                        }
                    }
                    --k;
                    n6 = n8;
                }
                int n9 = n6;
                if (n4 < 0) {
                    n9 = n6;
                    if (array2[n3]) {
                        array3[n6] = n4;
                        n9 = n6 + 1;
                    }
                }
                final int n10 = 0;
                int n11 = n9;
                int n13;
                for (int l = n10; l < n; ++l, n11 = n13) {
                    final int n12 = array[l] + n4;
                    n13 = n11;
                    if (n12 < 0) {
                        n13 = n11;
                        if (array2[l]) {
                            array3[n11] = n12;
                            n13 = n11 + 1;
                        }
                    }
                }
                final int[] copy2 = Arrays.copyOf(array3, n11);
                int n14 = n - 1;
                int n15 = 0;
                while (n14 >= 0) {
                    final int n16 = array[n14] + n4;
                    int n17 = n15;
                    if (n16 > 0) {
                        n17 = n15;
                        if (array2[n14]) {
                            array4[n15] = n16;
                            n17 = n15 + 1;
                        }
                    }
                    --n14;
                    n15 = n17;
                }
                int n18 = n15;
                if (n4 > 0) {
                    n18 = n15;
                    if (array2[n3]) {
                        array4[n15] = n4;
                        n18 = n15 + 1;
                    }
                }
                int n19 = 0;
                int n20 = n18;
                while (n19 < n2) {
                    final int n21 = copy[n19] + n4;
                    int n22 = n20;
                    if (n21 > 0) {
                        n22 = n20;
                        if (array2[n + n19]) {
                            array4[n20] = n21;
                            n22 = n20 + 1;
                        }
                    }
                    ++n19;
                    n20 = n22;
                }
                copy = Arrays.copyOf(array4, n20);
                array = copy2;
                final int n23 = n11;
                n24 = n20;
                h2 = n23;
            }
            else {
                h2 = parsableNalUnitBitArray.h();
                final int h3 = parsableNalUnitBitArray.h();
                array = new int[h2];
                for (int n25 = 0; n25 < h2; ++n25) {
                    array[n25] = parsableNalUnitBitArray.h() + 1;
                    parsableNalUnitBitArray.k();
                }
                copy = new int[h3];
                for (int n26 = 0; n26 < h3; ++n26) {
                    copy[n26] = parsableNalUnitBitArray.h() + 1;
                    parsableNalUnitBitArray.k();
                }
                n24 = h3;
            }
            ++i;
            n = h2;
            n2 = n24;
        }
    }
    
    public static int q(final byte[] array, int n) {
        final Object c = NalUnitUtil.c;
        monitorenter(c);
        int d = 0;
        int n2 = 0;
        while (true) {
            Label_0081: {
                if (d >= n) {
                    break Label_0081;
                }
                try {
                    final int n3 = d = d(array, d, n);
                    if (n3 >= n) {
                        continue;
                    }
                    final int[] d2 = NalUnitUtil.d;
                    if (d2.length <= n2) {
                        NalUnitUtil.d = Arrays.copyOf(d2, d2.length * 2);
                    }
                    NalUnitUtil.d[n2] = n3;
                    d = n3 + 3;
                    ++n2;
                }
                finally {
                    monitorexit(c);
                    int n6 = 0;
                    int n9;
                    while (true) {
                        int n5 = 0;
                        final int n4 = NalUnitUtil.d[n5] - n;
                        System.arraycopy(array, n, array, n6, n4);
                        final int n7 = n6 + n4;
                        final int n8 = n7 + 1;
                        array[n7] = 0;
                        n6 = n8 + 1;
                        array[n8] = 0;
                        n += n4 + 3;
                        ++n5;
                        Label_0094: {
                            break Label_0094;
                            n9 = n - n2;
                            n5 = 0;
                            n6 = (n = 0);
                        }
                        iftrue(Label_0160:)(n5 >= n2);
                        continue;
                    }
                    Label_0160: {
                        System.arraycopy(array, n, array, n6, n9 - n6);
                    }
                    monitorexit(c);
                    return n9;
                }
            }
        }
    }
    
    public static final class H265SpsData
    {
        public final int a;
        public final boolean b;
        public final int c;
        public final int d;
        public final int[] e;
        public final int f;
        public final int g;
        public final int h;
        public final int i;
        public final float j;
        
        public H265SpsData(final int a, final boolean b, final int c, final int d, final int[] e, final int f, final int g, final int h, final int i, final float j) {
            this.a = a;
            this.b = b;
            this.c = c;
            this.d = d;
            this.e = e;
            this.f = f;
            this.g = g;
            this.h = h;
            this.i = i;
            this.j = j;
        }
    }
    
    public static final class PpsData
    {
        public final int a;
        public final int b;
        public final boolean c;
        
        public PpsData(final int a, final int b, final boolean c) {
            this.a = a;
            this.b = b;
            this.c = c;
        }
    }
    
    public static final class SpsData
    {
        public final int a;
        public final int b;
        public final int c;
        public final int d;
        public final int e;
        public final int f;
        public final int g;
        public final float h;
        public final boolean i;
        public final boolean j;
        public final int k;
        public final int l;
        public final int m;
        public final boolean n;
        
        public SpsData(final int a, final int b, final int c, final int d, final int e, final int f, final int g, final float h, final boolean i, final boolean j, final int k, final int l, final int m, final boolean n) {
            this.a = a;
            this.b = b;
            this.c = c;
            this.d = d;
            this.e = e;
            this.f = f;
            this.g = g;
            this.h = h;
            this.i = i;
            this.j = j;
            this.k = k;
            this.l = l;
            this.m = m;
            this.n = n;
        }
    }
}
