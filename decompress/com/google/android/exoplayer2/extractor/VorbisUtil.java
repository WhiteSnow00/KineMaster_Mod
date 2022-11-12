// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.exoplayer2.extractor;

import java.util.Arrays;
import com.google.android.exoplayer2.ParserException;
import com.google.android.exoplayer2.metadata.vorbis.VorbisComment;
import com.google.android.exoplayer2.metadata.flac.PictureFrame;
import com.google.android.exoplayer2.util.ParsableByteArray;
import android.util.Base64;
import com.google.android.exoplayer2.util.Log;
import com.google.android.exoplayer2.util.Util;
import java.util.ArrayList;
import com.google.android.exoplayer2.metadata.Metadata;
import java.util.List;

public final class VorbisUtil
{
    private VorbisUtil() {
    }
    
    public static int a(int i) {
        int n = 0;
        while (i > 0) {
            ++n;
            i >>>= 1;
        }
        return n;
    }
    
    private static long b(final long n, final long n2) {
        return (long)Math.floor(Math.pow((double)n, 1.0 / n2));
    }
    
    public static Metadata c(final List<String> list) {
        final ArrayList list2 = new ArrayList();
        for (int i = 0; i < list.size(); ++i) {
            final String s = list.get(i);
            final String[] u0 = Util.U0(s, "=");
            if (u0.length != 2) {
                final StringBuilder sb = new StringBuilder();
                sb.append("Failed to parse Vorbis comment: ");
                sb.append(s);
                Log.i("VorbisUtil", sb.toString());
            }
            else if (u0[0].equals("METADATA_BLOCK_PICTURE")) {
                try {
                    list2.add(PictureFrame.a(new ParsableByteArray(Base64.decode(u0[1], 0))));
                }
                catch (final RuntimeException ex) {
                    Log.j("VorbisUtil", "Failed to parse vorbis picture", ex);
                }
            }
            else {
                list2.add(new VorbisComment(u0[0], u0[1]));
            }
        }
        Metadata metadata;
        if (list2.isEmpty()) {
            metadata = null;
        }
        else {
            metadata = new Metadata(list2);
        }
        return metadata;
    }
    
    private static a d(final VorbisBitArray vorbisBitArray) throws ParserException {
        if (vorbisBitArray.d(24) != 5653314) {
            final StringBuilder sb = new StringBuilder();
            sb.append("expected code book to start with [0x56, 0x43, 0x42] at ");
            sb.append(vorbisBitArray.b());
            throw ParserException.createForMalformedContainer(sb.toString(), null);
        }
        final int d = vorbisBitArray.d(16);
        final int d2 = vorbisBitArray.d(24);
        final long[] array = new long[d2];
        final boolean c = vorbisBitArray.c();
        long b = 0L;
        int i = 0;
        if (!c) {
            final boolean c2 = vorbisBitArray.c();
            while (i < d2) {
                if (c2) {
                    if (vorbisBitArray.c()) {
                        array[i] = vorbisBitArray.d(5) + 1;
                    }
                    else {
                        array[i] = 0L;
                    }
                }
                else {
                    array[i] = vorbisBitArray.d(5) + 1;
                }
                ++i;
            }
        }
        else {
            int n = vorbisBitArray.d(5) + 1;
            int j = 0;
            while (j < d2) {
                for (int d3 = vorbisBitArray.d(a(d2 - j)), n2 = 0; n2 < d3 && j < d2; ++j, ++n2) {
                    array[j] = n;
                }
                ++n;
            }
        }
        final int d4 = vorbisBitArray.d(4);
        if (d4 <= 2) {
            if (d4 == 1 || d4 == 2) {
                vorbisBitArray.e(32);
                vorbisBitArray.e(32);
                final int d5 = vorbisBitArray.d(4);
                vorbisBitArray.e(1);
                if (d4 == 1) {
                    if (d != 0) {
                        b = b(d2, d);
                    }
                }
                else {
                    b = d2 * (long)d;
                }
                vorbisBitArray.e((int)(b * (d5 + 1)));
            }
            return new a(d, d2, array, d4, c);
        }
        final StringBuilder sb2 = new StringBuilder();
        sb2.append("lookup type greater than 2 not decodable: ");
        sb2.append(d4);
        throw ParserException.createForMalformedContainer(sb2.toString(), null);
    }
    
    private static void e(final VorbisBitArray vorbisBitArray) throws ParserException {
        for (int d = vorbisBitArray.d(6), i = 0; i < d + 1; ++i) {
            final int d2 = vorbisBitArray.d(16);
            if (d2 != 0) {
                if (d2 != 1) {
                    final StringBuilder sb = new StringBuilder();
                    sb.append("floor type greater than 1 not decodable: ");
                    sb.append(d2);
                    throw ParserException.createForMalformedContainer(sb.toString(), null);
                }
                final int d3 = vorbisBitArray.d(5);
                int n = -1;
                final int[] array = new int[d3];
                int n2;
                for (int j = 0; j < d3; ++j, n = n2) {
                    array[j] = vorbisBitArray.d(4);
                    if (array[j] > (n2 = n)) {
                        n2 = array[j];
                    }
                }
                final int n3 = n + 1;
                final int[] array2 = new int[n3];
                for (int k = 0; k < n3; ++k) {
                    array2[k] = vorbisBitArray.d(3) + 1;
                    final int d4 = vorbisBitArray.d(2);
                    if (d4 > 0) {
                        vorbisBitArray.e(8);
                    }
                    for (int l = 0; l < 1 << d4; ++l) {
                        vorbisBitArray.e(8);
                    }
                }
                vorbisBitArray.e(2);
                final int d5 = vorbisBitArray.d(4);
                int n4 = 0;
                int n6;
                int n5 = n6 = 0;
                while (n4 < d3) {
                    for (n5 += array2[array[n4]]; n6 < n5; ++n6) {
                        vorbisBitArray.e(d5);
                    }
                    ++n4;
                }
            }
            else {
                vorbisBitArray.e(8);
                vorbisBitArray.e(16);
                vorbisBitArray.e(16);
                vorbisBitArray.e(6);
                vorbisBitArray.e(8);
                for (int d6 = vorbisBitArray.d(4), n7 = 0; n7 < d6 + 1; ++n7) {
                    vorbisBitArray.e(8);
                }
            }
        }
    }
    
    private static void f(final int n, final VorbisBitArray vorbisBitArray) throws ParserException {
        for (int d = vorbisBitArray.d(6), i = 0; i < d + 1; ++i) {
            final int d2 = vorbisBitArray.d(16);
            if (d2 != 0) {
                final StringBuilder sb = new StringBuilder();
                sb.append("mapping type other than 0 not supported: ");
                sb.append(d2);
                Log.c("VorbisUtil", sb.toString());
            }
            else {
                int n2;
                if (vorbisBitArray.c()) {
                    n2 = vorbisBitArray.d(4) + 1;
                }
                else {
                    n2 = 1;
                }
                if (vorbisBitArray.c()) {
                    for (int d3 = vorbisBitArray.d(8), j = 0; j < d3 + 1; ++j) {
                        final int n3 = n - 1;
                        vorbisBitArray.e(a(n3));
                        vorbisBitArray.e(a(n3));
                    }
                }
                if (vorbisBitArray.d(2) != 0) {
                    throw ParserException.createForMalformedContainer("to reserved bits must be zero after mapping coupling steps", null);
                }
                if (n2 > 1) {
                    for (int k = 0; k < n; ++k) {
                        vorbisBitArray.e(4);
                    }
                }
                for (int l = 0; l < n2; ++l) {
                    vorbisBitArray.e(8);
                    vorbisBitArray.e(8);
                    vorbisBitArray.e(8);
                }
            }
        }
    }
    
    private static Mode[] g(final VorbisBitArray vorbisBitArray) {
        final int n = vorbisBitArray.d(6) + 1;
        final Mode[] array = new Mode[n];
        for (int i = 0; i < n; ++i) {
            array[i] = new Mode(vorbisBitArray.c(), vorbisBitArray.d(16), vorbisBitArray.d(16), vorbisBitArray.d(8));
        }
        return array;
    }
    
    private static void h(final VorbisBitArray vorbisBitArray) throws ParserException {
        for (int d = vorbisBitArray.d(6), i = 0; i < d + 1; ++i) {
            if (vorbisBitArray.d(16) > 2) {
                throw ParserException.createForMalformedContainer("residueType greater than 2 is not decodable", null);
            }
            vorbisBitArray.e(24);
            vorbisBitArray.e(24);
            vorbisBitArray.e(24);
            final int n = vorbisBitArray.d(6) + 1;
            vorbisBitArray.e(8);
            final int[] array = new int[n];
            for (int j = 0; j < n; ++j) {
                final int d2 = vorbisBitArray.d(3);
                int d3;
                if (vorbisBitArray.c()) {
                    d3 = vorbisBitArray.d(5);
                }
                else {
                    d3 = 0;
                }
                array[j] = d3 * 8 + d2;
            }
            for (int k = 0; k < n; ++k) {
                for (int l = 0; l < 8; ++l) {
                    if ((array[k] & 1 << l) != 0x0) {
                        vorbisBitArray.e(8);
                    }
                }
            }
        }
    }
    
    public static CommentHeader i(final ParsableByteArray parsableByteArray) throws ParserException {
        return j(parsableByteArray, true, true);
    }
    
    public static CommentHeader j(final ParsableByteArray parsableByteArray, final boolean b, final boolean b2) throws ParserException {
        int n = 0;
        if (b) {
            m(3, parsableByteArray, false);
        }
        final String a = parsableByteArray.A((int)parsableByteArray.t());
        final int length = a.length();
        final long t = parsableByteArray.t();
        final String[] array = new String[(int)t];
        int n2 = 11 + length + 4;
        while (n < t) {
            array[n] = parsableByteArray.A((int)parsableByteArray.t());
            n2 = n2 + 4 + array[n].length();
            ++n;
        }
        if (b2 && (parsableByteArray.D() & 0x1) == 0x0) {
            throw ParserException.createForMalformedContainer("framing bit expected to be set", null);
        }
        return new CommentHeader(a, array, n2 + 1);
    }
    
    public static VorbisIdHeader k(final ParsableByteArray parsableByteArray) throws ParserException {
        boolean b = true;
        m(1, parsableByteArray, false);
        final int u = parsableByteArray.u();
        final int d = parsableByteArray.D();
        final int u2 = parsableByteArray.u();
        int q;
        if ((q = parsableByteArray.q()) <= 0) {
            q = -1;
        }
        int q2;
        if ((q2 = parsableByteArray.q()) <= 0) {
            q2 = -1;
        }
        int q3;
        if ((q3 = parsableByteArray.q()) <= 0) {
            q3 = -1;
        }
        final int d2 = parsableByteArray.D();
        final int n = (int)Math.pow(2.0, d2 & 0xF);
        final int n2 = (int)Math.pow(2.0, (d2 & 0xF0) >> 4);
        if ((parsableByteArray.D() & 0x1) <= 0) {
            b = false;
        }
        return new VorbisIdHeader(u, d, u2, q, q2, q3, n, n2, b, Arrays.copyOf(parsableByteArray.d(), parsableByteArray.f()));
    }
    
    public static Mode[] l(final ParsableByteArray parsableByteArray, final int n) throws ParserException {
        final int n2 = 0;
        m(5, parsableByteArray, false);
        final int d = parsableByteArray.D();
        final VorbisBitArray vorbisBitArray = new VorbisBitArray(parsableByteArray.d());
        vorbisBitArray.e(parsableByteArray.e() * 8);
        for (int i = 0; i < d + 1; ++i) {
            d(vorbisBitArray);
        }
        for (int d2 = vorbisBitArray.d(6), j = n2; j < d2 + 1; ++j) {
            if (vorbisBitArray.d(16) != 0) {
                throw ParserException.createForMalformedContainer("placeholder of time domain transforms not zeroed out", null);
            }
        }
        e(vorbisBitArray);
        h(vorbisBitArray);
        f(n, vorbisBitArray);
        final Mode[] g = g(vorbisBitArray);
        if (vorbisBitArray.c()) {
            return g;
        }
        throw ParserException.createForMalformedContainer("framing bit after modes not set as expected", null);
    }
    
    public static boolean m(final int n, final ParsableByteArray parsableByteArray, final boolean b) throws ParserException {
        if (parsableByteArray.a() < 7) {
            if (b) {
                return false;
            }
            final StringBuilder sb = new StringBuilder();
            sb.append("too short header: ");
            sb.append(parsableByteArray.a());
            throw ParserException.createForMalformedContainer(sb.toString(), null);
        }
        else if (parsableByteArray.D() != n) {
            if (b) {
                return false;
            }
            final StringBuilder sb2 = new StringBuilder();
            sb2.append("expected header type ");
            sb2.append(Integer.toHexString(n));
            throw ParserException.createForMalformedContainer(sb2.toString(), null);
        }
        else {
            if (parsableByteArray.D() == 118 && parsableByteArray.D() == 111 && parsableByteArray.D() == 114 && parsableByteArray.D() == 98 && parsableByteArray.D() == 105 && parsableByteArray.D() == 115) {
                return true;
            }
            if (b) {
                return false;
            }
            throw ParserException.createForMalformedContainer("expected characters 'vorbis'", null);
        }
    }
    
    public static final class CommentHeader
    {
        public final String a;
        public final String[] b;
        public final int c;
        
        public CommentHeader(final String a, final String[] b, final int c) {
            this.a = a;
            this.b = b;
            this.c = c;
        }
    }
    
    public static final class Mode
    {
        public final boolean a;
        public final int b;
        public final int c;
        public final int d;
        
        public Mode(final boolean a, final int b, final int c, final int d) {
            this.a = a;
            this.b = b;
            this.c = c;
            this.d = d;
        }
    }
    
    public static final class VorbisIdHeader
    {
        public final int a;
        public final int b;
        public final int c;
        public final int d;
        public final int e;
        public final int f;
        public final int g;
        public final int h;
        public final boolean i;
        public final byte[] j;
        
        public VorbisIdHeader(final int a, final int b, final int c, final int d, final int e, final int f, final int g, final int h, final boolean i, final byte[] j) {
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
    
    private static final class a
    {
        public final int a;
        public final int b;
        public final long[] c;
        public final int d;
        public final boolean e;
        
        public a(final int a, final int b, final long[] c, final int d, final boolean e) {
            this.a = a;
            this.b = b;
            this.c = c;
            this.d = d;
            this.e = e;
        }
    }
}
