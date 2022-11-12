// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.exoplayer2.metadata.id3;

import java.util.List;
import com.google.android.exoplayer2.metadata.Metadata;
import java.nio.ByteBuffer;
import com.google.android.exoplayer2.metadata.MetadataInputBuffer;
import java.util.Locale;
import com.google.android.exoplayer2.util.ParsableBitArray;
import com.google.android.exoplayer2.util.Log;
import java.util.ArrayList;
import java.io.UnsupportedEncodingException;
import com.google.common.base.Ascii;
import java.util.Arrays;
import com.google.android.exoplayer2.util.Util;
import com.google.android.exoplayer2.util.ParsableByteArray;
import t3.a;
import com.google.android.exoplayer2.metadata.SimpleMetadataDecoder;

public final class Id3Decoder extends SimpleMetadataDecoder
{
    public static final FramePredicate b;
    private final FramePredicate a;
    
    static {
        b = (FramePredicate)t3.a.a;
    }
    
    public Id3Decoder() {
        this(null);
    }
    
    public Id3Decoder(final FramePredicate a) {
        this.a = a;
    }
    
    private static int A(final ParsableByteArray parsableByteArray, int n) {
        final byte[] d = parsableByteArray.d();
        int e;
        final int n2 = e = parsableByteArray.e();
        while (true) {
            final int n3 = e + 1;
            if (n3 >= n2 + n) {
                break;
            }
            int n4 = n;
            if ((d[e] & 0xFF) == 0xFF) {
                n4 = n;
                if (d[n3] == 0) {
                    System.arraycopy(d, e + 2, d, n3, n - (e - n2) - 2);
                    n4 = n - 1;
                }
            }
            e = n3;
            n = n4;
        }
        return n;
    }
    
    private static boolean B(final ParsableByteArray parsableByteArray, final int n, final int n2, final boolean b) {
        final int e = parsableByteArray.e();
        try {
            while (true) {
                final int a = parsableByteArray.a();
                final boolean b2 = true;
                if (a < n2) {
                    return true;
                }
                int n3;
                long f;
                int j;
                if (n >= 3) {
                    n3 = parsableByteArray.n();
                    f = parsableByteArray.F();
                    j = parsableByteArray.J();
                }
                else {
                    n3 = parsableByteArray.G();
                    f = parsableByteArray.G();
                    j = 0;
                }
                if (n3 == 0 && f == 0L && j == 0) {
                    return true;
                }
                long n4 = f;
                if (n == 4) {
                    n4 = f;
                    if (!b) {
                        if ((0x808080L & f) != 0x0L) {
                            return false;
                        }
                        n4 = ((f >> 24 & 0xFFL) << 21 | ((f & 0xFFL) | (f >> 8 & 0xFFL) << 7 | (f >> 16 & 0xFFL) << 14));
                    }
                }
                int n5 = 0;
                int n7 = 0;
                Label_0277: {
                    int n6;
                    if (n == 4) {
                        if ((j & 0x40) != 0x0) {
                            n5 = 1;
                        }
                        else {
                            n5 = 0;
                        }
                        n6 = n5;
                        if ((j & 0x1) != 0x0) {
                            n7 = (b2 ? 1 : 0);
                            break Label_0277;
                        }
                    }
                    else {
                        if (n != 3) {
                            n5 = 0;
                            n7 = 0;
                            break Label_0277;
                        }
                        if ((j & 0x20) != 0x0) {
                            n5 = 1;
                        }
                        else {
                            n5 = 0;
                        }
                        n6 = n5;
                        if ((j & 0x80) != 0x0) {
                            n7 = (b2 ? 1 : 0);
                            break Label_0277;
                        }
                    }
                    final int n8 = 0;
                    n5 = n6;
                    n7 = n8;
                }
                int n9 = n5;
                if (n7 != 0) {
                    n9 = n5 + 4;
                }
                if (n4 < n9) {
                    return false;
                }
                if (parsableByteArray.a() < n4) {
                    return false;
                }
                parsableByteArray.Q((int)n4);
            }
        }
        finally {
            parsableByteArray.P(e);
        }
    }
    
    public static boolean c(final int n, final int n2, final int n3, final int n4, final int n5) {
        return z(n, n2, n3, n4, n5);
    }
    
    private static byte[] d(final byte[] array, final int n, final int n2) {
        if (n2 <= n) {
            return Util.f;
        }
        return Arrays.copyOfRange(array, n, n2);
    }
    
    private static ApicFrame f(final ParsableByteArray parsableByteArray, int n, int n2) throws UnsupportedEncodingException {
        final int d = parsableByteArray.D();
        final String v = v(d);
        final int n3 = n - 1;
        final byte[] array = new byte[n3];
        parsableByteArray.j(array, 0, n3);
        String s;
        if (n2 == 2) {
            final StringBuilder sb = new StringBuilder();
            sb.append("image/");
            sb.append(Ascii.e(new String(array, 0, 3, "ISO-8859-1")));
            if ("image/jpg".equals(s = sb.toString())) {
                s = "image/jpeg";
            }
            n = 2;
        }
        else {
            n = y(array, 0);
            s = Ascii.e(new String(array, 0, n, "ISO-8859-1"));
            if (s.indexOf(47) == -1) {
                final StringBuilder sb2 = new StringBuilder();
                sb2.append("image/");
                sb2.append(s);
                s = sb2.toString();
            }
        }
        n2 = array[n + 1];
        final int n4 = n + 2;
        n = x(array, n4, d);
        return new ApicFrame(s, new String(array, n4, n - n4, v), n2 & 0xFF, d(array, n + u(d), n3));
    }
    
    private static BinaryFrame g(final ParsableByteArray parsableByteArray, final int n, final String s) {
        final byte[] array = new byte[n];
        parsableByteArray.j(array, 0, n);
        return new BinaryFrame(s, array);
    }
    
    private static ChapterFrame h(final ParsableByteArray parsableByteArray, final int n, final int n2, final boolean b, final int n3, final FramePredicate framePredicate) throws UnsupportedEncodingException {
        final int e = parsableByteArray.e();
        final int y = y(parsableByteArray.d(), e);
        final String s = new String(parsableByteArray.d(), e, y - e, "ISO-8859-1");
        parsableByteArray.P(y + 1);
        final int n4 = parsableByteArray.n();
        final int n5 = parsableByteArray.n();
        long f = parsableByteArray.F();
        if (f == 4294967295L) {
            f = -1L;
        }
        long f2 = parsableByteArray.F();
        if (f2 == 4294967295L) {
            f2 = -1L;
        }
        final ArrayList<Id3Frame> list = new ArrayList<Id3Frame>();
        while (parsableByteArray.e() < e + n) {
            final Id3Frame k = k(n2, parsableByteArray, b, n3, framePredicate);
            if (k != null) {
                list.add(k);
            }
        }
        return new ChapterFrame(s, n4, n5, f, f2, list.toArray(new Id3Frame[0]));
    }
    
    private static ChapterTocFrame i(final ParsableByteArray parsableByteArray, final int n, final int n2, final boolean b, final int n3, final FramePredicate framePredicate) throws UnsupportedEncodingException {
        final int e = parsableByteArray.e();
        final int y = y(parsableByteArray.d(), e);
        final String s = new String(parsableByteArray.d(), e, y - e, "ISO-8859-1");
        parsableByteArray.P(y + 1);
        final int d = parsableByteArray.D();
        final boolean b2 = (d & 0x2) != 0x0;
        final boolean b3 = (d & 0x1) != 0x0;
        final int d2 = parsableByteArray.D();
        final String[] array = new String[d2];
        for (int i = 0; i < d2; ++i) {
            final int e2 = parsableByteArray.e();
            final int y2 = y(parsableByteArray.d(), e2);
            array[i] = new String(parsableByteArray.d(), e2, y2 - e2, "ISO-8859-1");
            parsableByteArray.P(y2 + 1);
        }
        final ArrayList<Id3Frame> list = new ArrayList<Id3Frame>();
        while (parsableByteArray.e() < e + n) {
            final Id3Frame k = k(n2, parsableByteArray, b, n3, framePredicate);
            if (k != null) {
                list.add(k);
            }
        }
        return new ChapterTocFrame(s, b2, b3, array, list.toArray(new Id3Frame[0]));
    }
    
    private static CommentFrame j(final ParsableByteArray parsableByteArray, int x) throws UnsupportedEncodingException {
        if (x < 4) {
            return null;
        }
        final int d = parsableByteArray.D();
        final String v = v(d);
        final byte[] array = new byte[3];
        parsableByteArray.j(array, 0, 3);
        final String s = new String(array, 0, 3);
        x -= 4;
        final byte[] array2 = new byte[x];
        parsableByteArray.j(array2, 0, x);
        x = x(array2, 0, d);
        final String s2 = new String(array2, 0, x, v);
        x += u(d);
        return new CommentFrame(s, s2, p(array2, x, x(array2, x, d), v));
    }
    
    private static Id3Frame k(final int n, final ParsableByteArray parsableByteArray, final boolean b, final int n2, final FramePredicate framePredicate) {
        final int d = parsableByteArray.D();
        final int d2 = parsableByteArray.D();
        final int d3 = parsableByteArray.D();
        int d4;
        if (n >= 3) {
            d4 = parsableByteArray.D();
        }
        else {
            d4 = 0;
        }
        int n4;
        if (n == 4) {
            final int n3 = n4 = parsableByteArray.H();
            if (!b) {
                n4 = ((n3 >> 24 & 0xFF) << 21 | ((n3 & 0xFF) | (n3 >> 8 & 0xFF) << 7 | (n3 >> 16 & 0xFF) << 14));
            }
        }
        else if (n == 3) {
            n4 = parsableByteArray.H();
        }
        else {
            n4 = parsableByteArray.G();
        }
        final int n5 = n4;
        int j;
        if (n >= 3) {
            j = parsableByteArray.J();
        }
        else {
            j = 0;
        }
        if (d == 0 && d2 == 0 && d3 == 0 && d4 == 0 && n5 == 0 && j == 0) {
            parsableByteArray.P(parsableByteArray.f());
            return null;
        }
        final int n6 = parsableByteArray.e() + n5;
        if (n6 > parsableByteArray.f()) {
            Log.i("Id3Decoder", "Frame size exceeds remaining tag data");
            parsableByteArray.P(parsableByteArray.f());
            return null;
        }
        if (framePredicate != null && !framePredicate.a(n, d, d2, d3, d4)) {
            parsableByteArray.P(n6);
            return null;
        }
        boolean b3;
        int n7;
        int n8;
        int n10;
        int n11;
        if (n == 3) {
            final boolean b2 = (j & 0x80) != 0x0;
            b3 = ((j & 0x40) != 0x0);
            if ((j & 0x20) != 0x0) {
                n7 = 1;
            }
            else {
                n7 = 0;
            }
            n8 = (b2 ? 1 : 0);
            final int n9 = 0;
            n10 = (b2 ? 1 : 0);
            n11 = n9;
        }
        else if (n == 4) {
            final boolean b4 = (j & 0x40) != 0x0;
            final boolean b5 = (j & 0x8) != 0x0;
            b3 = ((j & 0x4) != 0x0);
            if ((j & 0x2) != 0x0) {
                n11 = 1;
            }
            else {
                n11 = 0;
            }
            final boolean b6 = (j & 0x1) != 0x0;
            n8 = (b5 ? 1 : 0);
            n7 = (b4 ? 1 : 0);
            n10 = (b6 ? 1 : 0);
        }
        else {
            n7 = 0;
            n10 = 0;
            b3 = false;
            n11 = 0;
            n8 = 0;
        }
        if (n8 != 0 || b3) {
            Log.i("Id3Decoder", "Skipping unsupported compressed or encrypted frame");
            parsableByteArray.P(n6);
            return null;
        }
        int n12 = n5;
        if (n7 != 0) {
            n12 = n5 - 1;
            parsableByteArray.Q(1);
        }
        int n13 = n12;
        if (n10 != 0) {
            n13 = n12 - 4;
            parsableByteArray.Q(4);
        }
        int a = n13;
        if (n11 != 0) {
            a = A(parsableByteArray, n13);
        }
        Label_0565: {
            if (d != 84 || d2 != 88 || d3 != 88) {
                break Label_0565;
            }
            if (n != 2) {
                if (d4 != 88) {
                    break Label_0565;
                }
            }
            try {
                Id3Frame id3Frame = null;
                Label_1017: {
                    try {
                        r(parsableByteArray, a);
                        break Label_1017;
                        iftrue(Label_0600:)(d != 84);
                        q(parsableByteArray, a, w(n, d, d2, d3, d4));
                        break Label_1017;
                    }
                    finally {
                        break Label_0565;
                    }
                    Label_0600: {
                        if (d == 87 && d2 == 88 && d3 == 88 && (n == 2 || d4 == 88)) {
                            id3Frame = t(parsableByteArray, a);
                        }
                        else if (d == 87) {
                            id3Frame = s(parsableByteArray, a, w(n, d, d2, d3, d4));
                        }
                        else if (d == 80 && d2 == 82 && d3 == 73 && d4 == 86) {
                            id3Frame = o(parsableByteArray, a);
                        }
                        else if (d == 71 && d2 == 69 && d3 == 79 && (d4 == 66 || n == 2)) {
                            id3Frame = l(parsableByteArray, a);
                        }
                        else {
                            Label_0826: {
                                if (n == 2) {
                                    if (d != 80 || d2 != 73 || d3 != 67) {
                                        break Label_0826;
                                    }
                                }
                                else if (d != 65 || d2 != 80 || d3 != 73 || d4 != 67) {
                                    break Label_0826;
                                }
                                id3Frame = f(parsableByteArray, a, n);
                                break Label_1017;
                            }
                            if (d == 67 && d2 == 79 && d3 == 77 && (d4 == 77 || n == 2)) {
                                id3Frame = j(parsableByteArray, a);
                            }
                            else if (d == 67 && d2 == 72 && d3 == 65 && d4 == 80) {
                                id3Frame = h(parsableByteArray, a, n, b, n2, (FramePredicate)id3Frame);
                            }
                            else if (d == 67 && d2 == 84 && d3 == 79 && d4 == 67) {
                                id3Frame = i(parsableByteArray, a, n, b, n2, (FramePredicate)id3Frame);
                            }
                            else if (d == 77 && d2 == 76 && d3 == 76 && d4 == 84) {
                                id3Frame = n(parsableByteArray, a);
                            }
                            else {
                                id3Frame = g(parsableByteArray, a, w(n, d, d2, d3, d4));
                            }
                        }
                    }
                }
                if (id3Frame == null) {
                    final StringBuilder sb = new StringBuilder();
                    sb.append("Failed to decode frame: id=");
                    sb.append(w(n, d, d2, d3, d4));
                    sb.append(", frameSize=");
                    sb.append(a);
                    Log.i("Id3Decoder", sb.toString());
                }
                parsableByteArray.P(n6);
                return id3Frame;
            }
            catch (final UnsupportedEncodingException ex) {
                Log.i("Id3Decoder", "Unsupported character encoding");
                parsableByteArray.P(n6);
                return null;
            }
        }
        parsableByteArray.P(n6);
    }
    
    private static GeobFrame l(final ParsableByteArray parsableByteArray, int n) throws UnsupportedEncodingException {
        final int d = parsableByteArray.D();
        final String v = v(d);
        final byte[] array = new byte[--n];
        parsableByteArray.j(array, 0, n);
        final int y = y(array, 0);
        final String s = new String(array, 0, y, "ISO-8859-1");
        final int n2 = y + 1;
        final int x = x(array, n2, d);
        final String p2 = p(array, n2, x, v);
        final int n3 = x + u(d);
        final int x2 = x(array, n3, d);
        return new GeobFrame(s, p2, p(array, n3, x2, v), d(array, x2 + u(d), n));
    }
    
    private static a m(final ParsableByteArray parsableByteArray) {
        if (parsableByteArray.a() < 10) {
            Log.i("Id3Decoder", "Data too short to be an ID3 tag");
            return null;
        }
        final int g = parsableByteArray.G();
        final boolean b = false;
        if (g != 4801587) {
            final StringBuilder sb = new StringBuilder();
            sb.append("Unexpected first three bytes of ID3 tag header: 0x");
            sb.append(String.format("%06X", g));
            Log.i("Id3Decoder", sb.toString());
            return null;
        }
        final int d = parsableByteArray.D();
        parsableByteArray.Q(1);
        final int d2 = parsableByteArray.D();
        final int c = parsableByteArray.C();
        int n;
        if (d == 2) {
            final boolean b2 = (d2 & 0x40) != 0x0;
            n = c;
            if (b2) {
                Log.i("Id3Decoder", "Skipped ID3 tag with majorVersion=2 and undefined compression scheme");
                return null;
            }
        }
        else if (d == 3) {
            final boolean b3 = (d2 & 0x40) != 0x0;
            n = c;
            if (b3) {
                final int n2 = parsableByteArray.n();
                parsableByteArray.Q(n2);
                n = c - (n2 + 4);
            }
        }
        else {
            if (d != 4) {
                final StringBuilder sb2 = new StringBuilder();
                sb2.append("Skipped ID3 tag with unsupported majorVersion=");
                sb2.append(d);
                Log.i("Id3Decoder", sb2.toString());
                return null;
            }
            final boolean b4 = (d2 & 0x40) != 0x0;
            int n3 = c;
            if (b4) {
                final int c2 = parsableByteArray.C();
                parsableByteArray.Q(c2 - 4);
                n3 = c - c2;
            }
            final boolean b5 = (d2 & 0x10) != 0x0;
            n = n3;
            if (b5) {
                n = n3 - 10;
            }
        }
        boolean b6 = b;
        if (d < 4) {
            b6 = b;
            if ((d2 & 0x80) != 0x0) {
                b6 = true;
            }
        }
        return new a(d, b6, n);
    }
    
    private static MlltFrame n(final ParsableByteArray parsableByteArray, int i) {
        final int j = parsableByteArray.J();
        final int g = parsableByteArray.G();
        final int g2 = parsableByteArray.G();
        final int d = parsableByteArray.D();
        final int d2 = parsableByteArray.D();
        final ParsableBitArray parsableBitArray = new ParsableBitArray();
        parsableBitArray.m(parsableByteArray);
        final int n = (i - 10) * 8 / (d + d2);
        final int[] array = new int[n];
        final int[] array2 = new int[n];
        int h;
        int h2;
        for (i = 0; i < n; ++i) {
            h = parsableBitArray.h(d);
            h2 = parsableBitArray.h(d2);
            array[i] = h;
            array2[i] = h2;
        }
        return new MlltFrame(j, g, g2, array, array2);
    }
    
    private static PrivFrame o(final ParsableByteArray parsableByteArray, final int n) throws UnsupportedEncodingException {
        final byte[] array = new byte[n];
        parsableByteArray.j(array, 0, n);
        final int y = y(array, 0);
        return new PrivFrame(new String(array, 0, y, "ISO-8859-1"), d(array, y + 1, n));
    }
    
    private static String p(final byte[] array, final int n, final int n2, final String s) throws UnsupportedEncodingException {
        if (n2 > n && n2 <= array.length) {
            return new String(array, n, n2 - n, s);
        }
        return "";
    }
    
    private static TextInformationFrame q(final ParsableByteArray parsableByteArray, int n, final String s) throws UnsupportedEncodingException {
        if (n < 1) {
            return null;
        }
        final int d = parsableByteArray.D();
        final String v = v(d);
        final byte[] array = new byte[--n];
        parsableByteArray.j(array, 0, n);
        return new TextInformationFrame(s, null, new String(array, 0, x(array, 0, d), v));
    }
    
    private static TextInformationFrame r(final ParsableByteArray parsableByteArray, int x) throws UnsupportedEncodingException {
        if (x < 1) {
            return null;
        }
        final int d = parsableByteArray.D();
        final String v = v(d);
        final byte[] array = new byte[--x];
        parsableByteArray.j(array, 0, x);
        x = x(array, 0, d);
        final String s = new String(array, 0, x, v);
        x += u(d);
        return new TextInformationFrame("TXXX", s, p(array, x, x(array, x, d), v));
    }
    
    private static UrlLinkFrame s(final ParsableByteArray parsableByteArray, final int n, final String s) throws UnsupportedEncodingException {
        final byte[] array = new byte[n];
        parsableByteArray.j(array, 0, n);
        return new UrlLinkFrame(s, null, new String(array, 0, y(array, 0), "ISO-8859-1"));
    }
    
    private static UrlLinkFrame t(final ParsableByteArray parsableByteArray, int x) throws UnsupportedEncodingException {
        if (x < 1) {
            return null;
        }
        final int d = parsableByteArray.D();
        final String v = v(d);
        final byte[] array = new byte[--x];
        parsableByteArray.j(array, 0, x);
        x = x(array, 0, d);
        final String s = new String(array, 0, x, v);
        x += u(d);
        return new UrlLinkFrame("WXXX", s, p(array, x, y(array, x), "ISO-8859-1"));
    }
    
    private static int u(int n) {
        if (n != 0 && n != 3) {
            n = 2;
        }
        else {
            n = 1;
        }
        return n;
    }
    
    private static String v(final int n) {
        if (n == 1) {
            return "UTF-16";
        }
        if (n == 2) {
            return "UTF-16BE";
        }
        if (n != 3) {
            return "ISO-8859-1";
        }
        return "UTF-8";
    }
    
    private static String w(final int n, final int n2, final int n3, final int n4, final int n5) {
        String s;
        if (n == 2) {
            s = String.format(Locale.US, "%c%c%c", n2, n3, n4);
        }
        else {
            s = String.format(Locale.US, "%c%c%c%c", n2, n3, n4, n5);
        }
        return s;
    }
    
    private static int x(final byte[] array, final int n, final int n2) {
        final int y = y(array, n);
        if (n2 != 0) {
            int i = y;
            if (n2 != 3) {
                while (i < array.length - 1) {
                    if ((i - n) % 2 == 0 && array[i + 1] == 0) {
                        return i;
                    }
                    i = y(array, i + 1);
                }
                return array.length;
            }
        }
        return y;
    }
    
    private static int y(final byte[] array, int i) {
        while (i < array.length) {
            if (array[i] == 0) {
                return i;
            }
            ++i;
        }
        return array.length;
    }
    
    private static boolean z(final int n, final int n2, final int n3, final int n4, final int n5) {
        return false;
    }
    
    @Override
    protected Metadata b(final MetadataInputBuffer metadataInputBuffer, final ByteBuffer byteBuffer) {
        return this.e(byteBuffer.array(), byteBuffer.limit());
    }
    
    public Metadata e(final byte[] array, int n) {
        final ArrayList list = new ArrayList();
        final ParsableByteArray parsableByteArray = new ParsableByteArray(array, n);
        final a m = m(parsableByteArray);
        if (m == null) {
            return null;
        }
        final int e = parsableByteArray.e();
        if (Id3Decoder.a.a(m) == 2) {
            n = 6;
        }
        else {
            n = 10;
        }
        int n2 = Id3Decoder.a.b(m);
        if (Id3Decoder.a.c(m)) {
            n2 = A(parsableByteArray, Id3Decoder.a.b(m));
        }
        parsableByteArray.O(e + n2);
        final int a = Id3Decoder.a.a(m);
        boolean b = false;
        if (!B(parsableByteArray, a, n, false)) {
            if (Id3Decoder.a.a(m) != 4 || !B(parsableByteArray, 4, n, true)) {
                final StringBuilder sb = new StringBuilder();
                sb.append("Failed to validate ID3 tag with majorVersion=");
                sb.append(Id3Decoder.a.a(m));
                Log.i("Id3Decoder", sb.toString());
                return null;
            }
            b = true;
        }
        while (parsableByteArray.a() >= n) {
            final Id3Frame k = k(Id3Decoder.a.a(m), parsableByteArray, b, n, this.a);
            if (k != null) {
                list.add(k);
            }
        }
        return new Metadata(list);
    }
    
    public interface FramePredicate
    {
        boolean a(final int p0, final int p1, final int p2, final int p3, final int p4);
    }
    
    private static final class a
    {
        private final int a;
        private final boolean b;
        private final int c;
        
        public a(final int a, final boolean b, final int c) {
            this.a = a;
            this.b = b;
            this.c = c;
        }
        
        static int a(final a a) {
            return a.a;
        }
        
        static int b(final a a) {
            return a.c;
        }
        
        static boolean c(final a a) {
            return a.b;
        }
    }
}
