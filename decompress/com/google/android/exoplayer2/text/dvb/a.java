// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.exoplayer2.text.dvb;

import java.util.ArrayList;
import android.graphics.Bitmap$Config;
import java.util.Collections;
import com.google.android.exoplayer2.text.Cue;
import java.util.List;
import com.google.android.exoplayer2.util.Log;
import android.util.SparseArray;
import com.google.android.exoplayer2.util.Util;
import com.google.android.exoplayer2.util.ParsableBitArray;
import android.graphics.PathEffect;
import android.graphics.Xfermode;
import android.graphics.PorterDuffXfermode;
import android.graphics.PorterDuff$Mode;
import android.graphics.Paint$Style;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;

final class a
{
    private static final byte[] h;
    private static final byte[] i;
    private static final byte[] j;
    private final Paint a;
    private final Paint b;
    private final Canvas c;
    private final b d;
    private final a e;
    private final h f;
    private Bitmap g;
    
    static {
        h = new byte[] { 0, 7, 8, 15 };
        i = new byte[] { 0, 119, -120, -1 };
        j = new byte[] { 0, 17, 34, 51, 68, 85, 102, 119, -120, -103, -86, -69, -52, -35, -18, -1 };
    }
    
    public a(final int n, final int n2) {
        final Paint a = new Paint();
        (this.a = a).setStyle(Paint$Style.FILL_AND_STROKE);
        a.setXfermode((Xfermode)new PorterDuffXfermode(PorterDuff$Mode.SRC));
        a.setPathEffect((PathEffect)null);
        final Paint b = new Paint();
        (this.b = b).setStyle(Paint$Style.FILL);
        b.setXfermode((Xfermode)new PorterDuffXfermode(PorterDuff$Mode.DST_OVER));
        b.setPathEffect((PathEffect)null);
        this.c = new Canvas();
        this.d = new b(719, 575, 0, 719, 0, 575);
        this.e = new a(0, c(), d(), e());
        this.f = new h(n, n2);
    }
    
    private static byte[] a(final int n, final int n2, final ParsableBitArray parsableBitArray) {
        final byte[] array = new byte[n];
        for (int i = 0; i < n; ++i) {
            array[i] = (byte)parsableBitArray.h(n2);
        }
        return array;
    }
    
    private static int[] c() {
        return new int[] { 0, -1, -16777216, -8421505 };
    }
    
    private static int[] d() {
        final int[] array = new int[16];
        array[0] = 0;
        for (int i = 1; i < 16; ++i) {
            if (i < 8) {
                int n;
                if ((i & 0x1) != 0x0) {
                    n = 255;
                }
                else {
                    n = 0;
                }
                int n2;
                if ((i & 0x2) != 0x0) {
                    n2 = 255;
                }
                else {
                    n2 = 0;
                }
                int n3;
                if ((i & 0x4) != 0x0) {
                    n3 = 255;
                }
                else {
                    n3 = 0;
                }
                array[i] = f(255, n, n2, n3);
            }
            else {
                int n4 = 127;
                int n5;
                if ((i & 0x1) != 0x0) {
                    n5 = 127;
                }
                else {
                    n5 = 0;
                }
                int n6;
                if ((i & 0x2) != 0x0) {
                    n6 = 127;
                }
                else {
                    n6 = 0;
                }
                if ((i & 0x4) == 0x0) {
                    n4 = 0;
                }
                array[i] = f(255, n5, n6, n4);
            }
        }
        return array;
    }
    
    private static int[] e() {
        final int[] array = new int[256];
        array[0] = 0;
        for (int i = 0; i < 256; ++i) {
            int n = 255;
            if (i < 8) {
                int n2;
                if ((i & 0x1) != 0x0) {
                    n2 = 255;
                }
                else {
                    n2 = 0;
                }
                int n3;
                if ((i & 0x2) != 0x0) {
                    n3 = 255;
                }
                else {
                    n3 = 0;
                }
                if ((i & 0x4) == 0x0) {
                    n = 0;
                }
                array[i] = f(63, n2, n3, n);
            }
            else {
                final int n4 = i & 0x88;
                int n5 = 170;
                int n6 = 85;
                if (n4 != 0) {
                    if (n4 != 8) {
                        int n7 = 43;
                        if (n4 != 128) {
                            if (n4 == 136) {
                                int n8;
                                if ((i & 0x1) != 0x0) {
                                    n8 = 43;
                                }
                                else {
                                    n8 = 0;
                                }
                                int n9;
                                if ((i & 0x10) != 0x0) {
                                    n9 = 85;
                                }
                                else {
                                    n9 = 0;
                                }
                                int n10;
                                if ((i & 0x2) != 0x0) {
                                    n10 = 43;
                                }
                                else {
                                    n10 = 0;
                                }
                                int n11;
                                if ((i & 0x20) != 0x0) {
                                    n11 = 85;
                                }
                                else {
                                    n11 = 0;
                                }
                                if ((i & 0x4) == 0x0) {
                                    n7 = 0;
                                }
                                if ((i & 0x40) == 0x0) {
                                    n6 = 0;
                                }
                                array[i] = f(255, n8 + n9, n10 + n11, n7 + n6);
                            }
                        }
                        else {
                            int n12;
                            if ((i & 0x1) != 0x0) {
                                n12 = 43;
                            }
                            else {
                                n12 = 0;
                            }
                            int n13;
                            if ((i & 0x10) != 0x0) {
                                n13 = 85;
                            }
                            else {
                                n13 = 0;
                            }
                            int n14;
                            if ((i & 0x2) != 0x0) {
                                n14 = 43;
                            }
                            else {
                                n14 = 0;
                            }
                            int n15;
                            if ((i & 0x20) != 0x0) {
                                n15 = 85;
                            }
                            else {
                                n15 = 0;
                            }
                            if ((i & 0x4) == 0x0) {
                                n7 = 0;
                            }
                            if ((i & 0x40) == 0x0) {
                                n6 = 0;
                            }
                            array[i] = f(255, n12 + 127 + n13, n14 + 127 + n15, n7 + 127 + n6);
                        }
                    }
                    else {
                        int n16;
                        if ((i & 0x1) != 0x0) {
                            n16 = 85;
                        }
                        else {
                            n16 = 0;
                        }
                        int n17;
                        if ((i & 0x10) != 0x0) {
                            n17 = 170;
                        }
                        else {
                            n17 = 0;
                        }
                        int n18;
                        if ((i & 0x2) != 0x0) {
                            n18 = 85;
                        }
                        else {
                            n18 = 0;
                        }
                        int n19;
                        if ((i & 0x20) != 0x0) {
                            n19 = 170;
                        }
                        else {
                            n19 = 0;
                        }
                        if ((i & 0x4) == 0x0) {
                            n6 = 0;
                        }
                        if ((i & 0x40) == 0x0) {
                            n5 = 0;
                        }
                        array[i] = f(127, n16 + n17, n18 + n19, n6 + n5);
                    }
                }
                else {
                    int n20;
                    if ((i & 0x1) != 0x0) {
                        n20 = 85;
                    }
                    else {
                        n20 = 0;
                    }
                    int n21;
                    if ((i & 0x10) != 0x0) {
                        n21 = 170;
                    }
                    else {
                        n21 = 0;
                    }
                    int n22;
                    if ((i & 0x2) != 0x0) {
                        n22 = 85;
                    }
                    else {
                        n22 = 0;
                    }
                    int n23;
                    if ((i & 0x20) != 0x0) {
                        n23 = 170;
                    }
                    else {
                        n23 = 0;
                    }
                    if ((i & 0x4) == 0x0) {
                        n6 = 0;
                    }
                    if ((i & 0x40) == 0x0) {
                        n5 = 0;
                    }
                    array[i] = f(255, n20 + n21, n22 + n23, n6 + n5);
                }
            }
        }
        return array;
    }
    
    private static int f(final int n, final int n2, final int n3, final int n4) {
        return n << 24 | n2 << 16 | n3 << 8 | n4;
    }
    
    private static int g(final ParsableBitArray parsableBitArray, final int[] array, final byte[] array2, int n, final int n2, final Paint paint, final Canvas canvas) {
        final int n3 = 0;
        int n4 = n;
        n = n3;
        while (true) {
            final int h = parsableBitArray.h(2);
            int n5 = 0;
            int n6 = 0;
            Label_0181: {
                if (h != 0) {
                    n5 = n;
                    n6 = 1;
                    n = h;
                }
                else {
                    int n7 = 0;
                    Label_0056: {
                        if (!parsableBitArray.g()) {
                            Label_0079: {
                                if (!parsableBitArray.g()) {
                                    final int h2 = parsableBitArray.h(2);
                                    if (h2 != 0) {
                                        if (h2 == 1) {
                                            n6 = 2;
                                            break Label_0079;
                                        }
                                        if (h2 == 2) {
                                            n6 = parsableBitArray.h(4) + 12;
                                            n7 = parsableBitArray.h(2);
                                            break Label_0056;
                                        }
                                        if (h2 == 3) {
                                            n6 = parsableBitArray.h(8) + 29;
                                            n7 = parsableBitArray.h(2);
                                            break Label_0056;
                                        }
                                        n5 = n;
                                    }
                                    else {
                                        n5 = 1;
                                    }
                                    n = 0;
                                    n6 = 0;
                                    break Label_0181;
                                }
                                n6 = 1;
                            }
                            n5 = n;
                            n = 0;
                            break Label_0181;
                        }
                        n6 = parsableBitArray.h(3) + 3;
                        n7 = parsableBitArray.h(2);
                    }
                    final int n8 = n;
                    n = n7;
                    n5 = n8;
                }
            }
            if (n6 != 0 && paint != null) {
                int n9 = n;
                if (array2 != null) {
                    n9 = array2[n];
                }
                paint.setColor(array[n9]);
                canvas.drawRect((float)n4, (float)n2, (float)(n4 + n6), (float)(n2 + 1), paint);
            }
            n4 += n6;
            if (n5 != 0) {
                break;
            }
            n = n5;
        }
        return n4;
    }
    
    private static int h(final ParsableBitArray parsableBitArray, final int[] array, final byte[] array2, int n, final int n2, final Paint paint, final Canvas canvas) {
        final int n3 = 0;
        int n4 = n;
        n = n3;
        while (true) {
            final int h = parsableBitArray.h(4);
            int h2 = 2;
            int n5 = 0;
            int n6 = 0;
            Label_0200: {
                if (h != 0) {
                    n5 = n;
                    n6 = 1;
                    n = h;
                }
                else {
                    Label_0145: {
                        Label_0062: {
                            Label_0058: {
                                if (parsableBitArray.g()) {
                                    int n7;
                                    if (!parsableBitArray.g()) {
                                        n6 = parsableBitArray.h(2) + 4;
                                        n7 = parsableBitArray.h(4);
                                    }
                                    else {
                                        final int h3 = parsableBitArray.h(2);
                                        if (h3 == 0) {
                                            n6 = 1;
                                            break Label_0062;
                                        }
                                        if (h3 == 1) {
                                            break Label_0058;
                                        }
                                        if (h3 != 2) {
                                            if (h3 != 3) {
                                                n5 = n;
                                                break Label_0145;
                                            }
                                            n6 = parsableBitArray.h(8) + 25;
                                            n7 = parsableBitArray.h(4);
                                        }
                                        else {
                                            n6 = parsableBitArray.h(4) + 9;
                                            n7 = parsableBitArray.h(4);
                                        }
                                    }
                                    final int n8 = n;
                                    n = n7;
                                    n5 = n8;
                                    break Label_0200;
                                }
                                h2 = parsableBitArray.h(3);
                                if (h2 == 0) {
                                    n5 = 1;
                                    break Label_0145;
                                }
                                h2 += 2;
                            }
                            n6 = h2;
                        }
                        n5 = n;
                        n = 0;
                        break Label_0200;
                    }
                    n = 0;
                    n6 = 0;
                }
            }
            if (n6 != 0 && paint != null) {
                int n9 = n;
                if (array2 != null) {
                    n9 = array2[n];
                }
                paint.setColor(array[n9]);
                canvas.drawRect((float)n4, (float)n2, (float)(n4 + n6), (float)(n2 + 1), paint);
            }
            n4 += n6;
            if (n5 != 0) {
                break;
            }
            n = n5;
        }
        return n4;
    }
    
    private static int i(final ParsableBitArray parsableBitArray, final int[] array, final byte[] array2, int n, final int n2, final Paint paint, final Canvas canvas) {
        final int n3 = 0;
        int n4 = n;
        n = n3;
        while (true) {
            final int h = parsableBitArray.h(8);
            int n5;
            int n6;
            if (h != 0) {
                n5 = n;
                n6 = 1;
                n = h;
            }
            else if (!parsableBitArray.g()) {
                n6 = parsableBitArray.h(7);
                if (n6 != 0) {
                    n5 = n;
                    n = 0;
                }
                else {
                    n5 = 1;
                    n = 0;
                    n6 = 0;
                }
            }
            else {
                n6 = parsableBitArray.h(7);
                final int h2 = parsableBitArray.h(8);
                n5 = n;
                n = h2;
            }
            if (n6 != 0 && paint != null) {
                int n7 = n;
                if (array2 != null) {
                    n7 = array2[n];
                }
                paint.setColor(array[n7]);
                canvas.drawRect((float)n4, (float)n2, (float)(n4 + n6), (float)(n2 + 1), paint);
            }
            n4 += n6;
            if (n5 != 0) {
                break;
            }
            n = n5;
        }
        return n4;
    }
    
    private static void j(byte[] array, final int[] array2, final int n, final int n2, int n3, final Paint paint, final Canvas canvas) {
        final ParsableBitArray parsableBitArray = new ParsableBitArray(array);
        byte[] a = null;
        byte[] a3;
        byte[] a2 = a3 = null;
        int n4 = n3;
        n3 = n2;
        while (parsableBitArray.b() != 0) {
            final int h = parsableBitArray.h(8);
            if (h != 240) {
                switch (h) {
                    default: {
                        switch (h) {
                            default: {
                                continue;
                            }
                            case 34: {
                                a2 = a(16, 8, parsableBitArray);
                                continue;
                            }
                            case 33: {
                                a = a(4, 8, parsableBitArray);
                                continue;
                            }
                            case 32: {
                                a3 = a(4, 4, parsableBitArray);
                                continue;
                            }
                        }
                        break;
                    }
                    case 18: {
                        n3 = i(parsableBitArray, array2, null, n3, n4, paint, canvas);
                        continue;
                    }
                    case 17: {
                        if (n == 3) {
                            if (a2 == null) {
                                array = com.google.android.exoplayer2.text.dvb.a.j;
                            }
                            else {
                                array = a2;
                            }
                        }
                        else {
                            array = null;
                        }
                        n3 = h(parsableBitArray, array2, array, n3, n4, paint, canvas);
                        parsableBitArray.c();
                        continue;
                    }
                    case 16: {
                        if (n == 3) {
                            if (a == null) {
                                array = com.google.android.exoplayer2.text.dvb.a.i;
                            }
                            else {
                                array = a;
                            }
                        }
                        else if (n == 2) {
                            if (a3 == null) {
                                array = com.google.android.exoplayer2.text.dvb.a.h;
                            }
                            else {
                                array = a3;
                            }
                        }
                        else {
                            array = null;
                        }
                        n3 = g(parsableBitArray, array2, array, n3, n4, paint, canvas);
                        parsableBitArray.c();
                        continue;
                    }
                }
            }
            else {
                n4 += 2;
                n3 = n2;
            }
        }
    }
    
    private static void k(final c c, final a a, final int n, final int n2, final int n3, final Paint paint, final Canvas canvas) {
        int[] array;
        if (n == 3) {
            array = a.d;
        }
        else if (n == 2) {
            array = a.c;
        }
        else {
            array = a.b;
        }
        j(c.c, array, n, n2, n3, paint, canvas);
        j(c.d, array, n, n2, n3 + 1, paint, canvas);
    }
    
    private static a l(final ParsableBitArray parsableBitArray, int i) {
        final int h = parsableBitArray.h(8);
        parsableBitArray.r(8);
        i -= 2;
        final int[] c = c();
        final int[] d = d();
        final int[] e = e();
        while (i > 0) {
            final int h2 = parsableBitArray.h(8);
            final int h3 = parsableBitArray.h(8);
            i -= 2;
            int[] array;
            if ((h3 & 0x80) != 0x0) {
                array = c;
            }
            else if ((h3 & 0x40) != 0x0) {
                array = d;
            }
            else {
                array = e;
            }
            int h4;
            int h5;
            int h6;
            int h7;
            if ((h3 & 0x1) != 0x0) {
                h4 = parsableBitArray.h(8);
                h5 = parsableBitArray.h(8);
                h6 = parsableBitArray.h(8);
                h7 = parsableBitArray.h(8);
                i -= 4;
            }
            else {
                final int h8 = parsableBitArray.h(6);
                final int h9 = parsableBitArray.h(4);
                h6 = parsableBitArray.h(4) << 4;
                final int h10 = parsableBitArray.h(2);
                i -= 2;
                h7 = h10 << 6;
                h4 = h8 << 2;
                h5 = h9 << 4;
            }
            if (h4 == 0) {
                h7 = 255;
                h5 = 0;
                h6 = 0;
            }
            final byte b = (byte)(255 - (h7 & 0xFF));
            final double n = h4;
            final double n2 = h5 - 128;
            final int n3 = (int)(n + 1.402 * n2);
            final double n4 = h6 - 128;
            array[h2] = f(b, Util.q(n3, 0, 255), Util.q((int)(n - 0.34414 * n4 - n2 * 0.71414), 0, 255), Util.q((int)(n + n4 * 1.772), 0, 255));
        }
        return new a(h, c, d, e);
    }
    
    private static b m(final ParsableBitArray parsableBitArray) {
        parsableBitArray.r(4);
        final boolean g = parsableBitArray.g();
        parsableBitArray.r(3);
        final int h = parsableBitArray.h(16);
        final int h2 = parsableBitArray.h(16);
        int h3;
        int h4;
        int h5;
        int h6;
        if (g) {
            h3 = parsableBitArray.h(16);
            h4 = parsableBitArray.h(16);
            h5 = parsableBitArray.h(16);
            h6 = parsableBitArray.h(16);
        }
        else {
            h3 = 0;
            h5 = 0;
            h4 = h;
            h6 = h2;
        }
        return new b(h, h2, h3, h4, h5, h6);
    }
    
    private static c n(final ParsableBitArray parsableBitArray) {
        final int h = parsableBitArray.h(16);
        parsableBitArray.r(4);
        final int h2 = parsableBitArray.h(2);
        final boolean g = parsableBitArray.g();
        parsableBitArray.r(1);
        byte[] f = Util.f;
        byte[] array;
        if (h2 == 1) {
            parsableBitArray.r(parsableBitArray.h(8) * 16);
            array = f;
        }
        else {
            array = f;
            if (h2 == 0) {
                final int h3 = parsableBitArray.h(16);
                final int h4 = parsableBitArray.h(16);
                if (h3 > 0) {
                    f = new byte[h3];
                    parsableBitArray.k(f, 0, h3);
                }
                array = f;
                if (h4 > 0) {
                    final byte[] array2 = new byte[h4];
                    parsableBitArray.k(array2, 0, h4);
                    final byte[] array3 = array2;
                    return new c(h, g, f, array3);
                }
            }
        }
        final byte[] array3 = array;
        f = array;
        return new c(h, g, f, array3);
    }
    
    private static d o(final ParsableBitArray parsableBitArray, int i) {
        final int h = parsableBitArray.h(8);
        final int h2 = parsableBitArray.h(4);
        final int h3 = parsableBitArray.h(2);
        parsableBitArray.r(2);
        i -= 2;
        final SparseArray sparseArray = new SparseArray();
        while (i > 0) {
            final int h4 = parsableBitArray.h(8);
            parsableBitArray.r(8);
            final int h5 = parsableBitArray.h(16);
            final int h6 = parsableBitArray.h(16);
            i -= 6;
            sparseArray.put(h4, (Object)new e(h5, h6));
        }
        return new d(h, h2, h3, (SparseArray<e>)sparseArray);
    }
    
    private static f p(final ParsableBitArray parsableBitArray, int i) {
        final int h = parsableBitArray.h(8);
        parsableBitArray.r(4);
        final boolean g = parsableBitArray.g();
        parsableBitArray.r(3);
        final int h2 = parsableBitArray.h(16);
        final int h3 = parsableBitArray.h(16);
        final int h4 = parsableBitArray.h(3);
        final int h5 = parsableBitArray.h(3);
        parsableBitArray.r(2);
        final int h6 = parsableBitArray.h(8);
        final int h7 = parsableBitArray.h(8);
        final int h8 = parsableBitArray.h(4);
        final int h9 = parsableBitArray.h(2);
        parsableBitArray.r(2);
        i -= 10;
        final SparseArray sparseArray = new SparseArray();
        while (i > 0) {
            final int h10 = parsableBitArray.h(16);
            final int h11 = parsableBitArray.h(2);
            final int h12 = parsableBitArray.h(2);
            final int h13 = parsableBitArray.h(12);
            parsableBitArray.r(4);
            final int h14 = parsableBitArray.h(12);
            i -= 6;
            int n;
            int h15;
            if (h11 != 1 && h11 != 2) {
                n = 0;
                h15 = 0;
            }
            else {
                final int h16 = parsableBitArray.h(8);
                h15 = parsableBitArray.h(8);
                final int n2 = i - 2;
                i = (n = h16);
                i = n2;
            }
            sparseArray.put(h10, (Object)new g(h11, h12, h13, h14, n, h15));
        }
        return new f(h, g, h2, h3, h4, h5, h6, h7, h8, h9, (SparseArray<g>)sparseArray);
    }
    
    private static void q(final ParsableBitArray parsableBitArray, final h h) {
        final int h2 = parsableBitArray.h(8);
        final int h3 = parsableBitArray.h(16);
        final int h4 = parsableBitArray.h(16);
        final int d = parsableBitArray.d();
        if (h4 * 8 > parsableBitArray.b()) {
            Log.i("DvbParser", "Data field length exceeds limit");
            parsableBitArray.r(parsableBitArray.b());
            return;
        }
        switch (h2) {
            case 20: {
                if (h3 == h.a) {
                    h.h = m(parsableBitArray);
                    break;
                }
                break;
            }
            case 19: {
                if (h3 == h.a) {
                    final c n = n(parsableBitArray);
                    h.e.put(n.a, (Object)n);
                    break;
                }
                if (h3 == h.b) {
                    final c n2 = n(parsableBitArray);
                    h.g.put(n2.a, (Object)n2);
                    break;
                }
                break;
            }
            case 18: {
                if (h3 == h.a) {
                    final a l = l(parsableBitArray, h4);
                    h.d.put(l.a, (Object)l);
                    break;
                }
                if (h3 == h.b) {
                    final a i = l(parsableBitArray, h4);
                    h.f.put(i.a, (Object)i);
                    break;
                }
                break;
            }
            case 17: {
                final d j = h.i;
                if (h3 == h.a && j != null) {
                    final f p2 = p(parsableBitArray, h4);
                    if (j.c == 0) {
                        final f f = (f)h.c.get(p2.a);
                        if (f != null) {
                            p2.a(f);
                        }
                    }
                    h.c.put(p2.a, (Object)p2);
                    break;
                }
                break;
            }
            case 16: {
                if (h3 != h.a) {
                    break;
                }
                final d k = h.i;
                final d o = o(parsableBitArray, h4);
                if (o.c != 0) {
                    h.i = o;
                    h.c.clear();
                    h.d.clear();
                    h.e.clear();
                    break;
                }
                if (k != null && k.b != o.b) {
                    h.i = o;
                    break;
                }
                break;
            }
        }
        parsableBitArray.s(d + h4 - parsableBitArray.d());
    }
    
    public List<Cue> b(final byte[] array, int i) {
        final ParsableBitArray parsableBitArray = new ParsableBitArray(array, i);
        while (parsableBitArray.b() >= 48 && parsableBitArray.h(8) == 15) {
            q(parsableBitArray, this.f);
        }
        final h f = this.f;
        final d j = f.i;
        if (j == null) {
            return Collections.emptyList();
        }
        Object o = f.h;
        if (o == null) {
            o = this.d;
        }
        final Bitmap g = this.g;
        if (g == null || ((b)o).a + 1 != g.getWidth() || ((b)o).b + 1 != this.g.getHeight()) {
            final Bitmap bitmap = Bitmap.createBitmap(((b)o).a + 1, ((b)o).b + 1, Bitmap$Config.ARGB_8888);
            this.g = bitmap;
            this.c.setBitmap(bitmap);
        }
        final ArrayList list = new ArrayList();
        final SparseArray<e> d = j.d;
        for (int k = 0; k < d.size(); ++k) {
            this.c.save();
            final e e = (e)d.valueAt(k);
            i = d.keyAt(k);
            final f f2 = (f)this.f.c.get(i);
            final int n = e.a + ((b)o).c;
            final int n2 = e.b + ((b)o).e;
            final int min = Math.min(f2.c + n, ((b)o).d);
            i = Math.min(f2.d + n2, ((b)o).f);
            this.c.clipRect(n, n2, min, i);
            a e2;
            if ((e2 = (a)this.f.d.get(f2.g)) == null && (e2 = (a)this.f.f.get(f2.g)) == null) {
                e2 = this.e;
            }
            SparseArray<g> l;
            int key;
            g g2;
            c c;
            Paint a;
            for (l = f2.k, i = 0; i < l.size(); ++i) {
                key = l.keyAt(i);
                g2 = (g)l.valueAt(i);
                c = (c)this.f.e.get(key);
                if (c == null) {
                    c = (c)this.f.g.get(key);
                }
                if (c != null) {
                    if (c.b) {
                        a = null;
                    }
                    else {
                        a = this.a;
                    }
                    k(c, e2, f2.f, g2.c + n, n2 + g2.d, a, this.c);
                }
            }
            if (f2.b) {
                i = f2.f;
                if (i == 3) {
                    i = e2.d[f2.h];
                }
                else if (i == 2) {
                    i = e2.c[f2.i];
                }
                else {
                    i = e2.b[f2.j];
                }
                this.b.setColor(i);
                this.c.drawRect((float)n, (float)n2, (float)(f2.c + n), (float)(f2.d + n2), this.b);
            }
            list.add(new Cue.Builder().f(Bitmap.createBitmap(this.g, n, n2, f2.c, f2.d)).k(n / (float)((b)o).a).l(0).h(n2 / (float)((b)o).b, 0).i(0).n(f2.c / (float)((b)o).a).g(f2.d / (float)((b)o).b).a());
            this.c.drawColor(0, PorterDuff$Mode.CLEAR);
            this.c.restore();
        }
        return (List<Cue>)Collections.unmodifiableList((List<?>)list);
    }
    
    public void r() {
        this.f.a();
    }
    
    private static final class a
    {
        public final int a;
        public final int[] b;
        public final int[] c;
        public final int[] d;
        
        public a(final int a, final int[] b, final int[] c, final int[] d) {
            this.a = a;
            this.b = b;
            this.c = c;
            this.d = d;
        }
    }
    
    private static final class b
    {
        public final int a;
        public final int b;
        public final int c;
        public final int d;
        public final int e;
        public final int f;
        
        public b(final int a, final int b, final int c, final int d, final int e, final int f) {
            this.a = a;
            this.b = b;
            this.c = c;
            this.d = d;
            this.e = e;
            this.f = f;
        }
    }
    
    private static final class c
    {
        public final int a;
        public final boolean b;
        public final byte[] c;
        public final byte[] d;
        
        public c(final int a, final boolean b, final byte[] c, final byte[] d) {
            this.a = a;
            this.b = b;
            this.c = c;
            this.d = d;
        }
    }
    
    private static final class d
    {
        public final int a;
        public final int b;
        public final int c;
        public final SparseArray<e> d;
        
        public d(final int a, final int b, final int c, final SparseArray<e> d) {
            this.a = a;
            this.b = b;
            this.c = c;
            this.d = d;
        }
    }
    
    private static final class e
    {
        public final int a;
        public final int b;
        
        public e(final int a, final int b) {
            this.a = a;
            this.b = b;
        }
    }
    
    private static final class f
    {
        public final int a;
        public final boolean b;
        public final int c;
        public final int d;
        public final int e;
        public final int f;
        public final int g;
        public final int h;
        public final int i;
        public final int j;
        public final SparseArray<g> k;
        
        public f(final int a, final boolean b, final int c, final int d, final int e, final int f, final int g, final int h, final int i, final int j, final SparseArray<g> k) {
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
        }
        
        public void a(final f f) {
            final SparseArray<g> k = f.k;
            for (int i = 0; i < k.size(); ++i) {
                this.k.put(k.keyAt(i), (Object)k.valueAt(i));
            }
        }
    }
    
    private static final class g
    {
        public final int a;
        public final int b;
        public final int c;
        public final int d;
        public final int e;
        public final int f;
        
        public g(final int a, final int b, final int c, final int d, final int e, final int f) {
            this.a = a;
            this.b = b;
            this.c = c;
            this.d = d;
            this.e = e;
            this.f = f;
        }
    }
    
    private static final class h
    {
        public final int a;
        public final int b;
        public final SparseArray<f> c;
        public final SparseArray<a> d;
        public final SparseArray<c> e;
        public final SparseArray<a> f;
        public final SparseArray<c> g;
        public b h;
        public d i;
        
        public h(final int a, final int b) {
            this.a = a;
            this.b = b;
            this.c = (SparseArray<f>)new SparseArray();
            this.d = (SparseArray<a>)new SparseArray();
            this.e = (SparseArray<c>)new SparseArray();
            this.f = (SparseArray<a>)new SparseArray();
            this.g = (SparseArray<c>)new SparseArray();
        }
        
        public void a() {
            this.c.clear();
            this.d.clear();
            this.e.clear();
            this.f.clear();
            this.g.clear();
            this.h = null;
            this.i = null;
        }
    }
}
