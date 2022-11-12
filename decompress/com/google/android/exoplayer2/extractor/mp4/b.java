// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.exoplayer2.extractor.mp4;

import com.google.android.exoplayer2.metadata.mp4.SmtaMetadataEntry;
import com.google.android.exoplayer2.metadata.mp4.MdtaMetadataEntry;
import com.google.android.exoplayer2.util.MimeTypes;
import com.google.android.exoplayer2.audio.AacUtil;
import com.google.android.exoplayer2.util.CodecSpecificDataUtil;
import com.google.android.exoplayer2.audio.OpusUtil;
import java.util.Arrays;
import com.google.android.exoplayer2.audio.Ac4Util;
import com.google.android.exoplayer2.audio.Ac3Util;
import java.nio.ByteOrder;
import java.nio.ByteBuffer;
import com.google.common.primitives.Ints;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.video.DolbyVisionConfig;
import com.google.android.exoplayer2.video.ColorInfo;
import com.google.android.exoplayer2.util.Log;
import com.google.common.collect.ImmutableList;
import com.google.android.exoplayer2.video.HevcConfig;
import com.google.android.exoplayer2.video.AvcConfig;
import com.google.android.exoplayer2.extractor.ExtractorUtil;
import com.google.android.exoplayer2.util.ParsableByteArray;
import com.google.android.exoplayer2.metadata.Metadata;
import android.util.Pair;
import com.google.android.exoplayer2.ParserException;
import com.google.android.exoplayer2.util.Assertions;
import java.util.ArrayList;
import java.util.List;
import com.google.common.base.Function;
import com.google.android.exoplayer2.drm.DrmInitData;
import com.google.android.exoplayer2.extractor.GaplessInfoHolder;
import com.google.android.exoplayer2.util.Util;

final class b
{
    private static final byte[] a;
    
    static {
        a = Util.n0("OpusHead");
    }
    
    public static List<i> A(final com.google.android.exoplayer2.extractor.mp4.a.a a, final GaplessInfoHolder gaplessInfoHolder, final long n, final DrmInitData drmInitData, final boolean b, final boolean b2, final Function<Track, Track> function) throws ParserException {
        final ArrayList list = new ArrayList();
        for (int i = 0; i < a.d.size(); ++i) {
            final com.google.android.exoplayer2.extractor.mp4.a.a a2 = a.d.get(i);
            if (a2.a == 1953653099) {
                final Track track = (Track)function.apply((Object)z(a2, Assertions.e(a.g(1836476516)), n, drmInitData, b, b2));
                if (track != null) {
                    list.add(v(track, Assertions.e(Assertions.e(Assertions.e(a2.f(1835297121)).f(1835626086)).f(1937007212)), gaplessInfoHolder));
                }
            }
        }
        return list;
    }
    
    public static Pair<Metadata, Metadata> B(final com.google.android.exoplayer2.extractor.mp4.a.b b) {
        final ParsableByteArray b2 = b.b;
        b2.P(8);
        Metadata metadata = null;
        Object u = null;
        while (b2.a() >= 8) {
            final int e = b2.e();
            final int n = b2.n();
            final int n2 = b2.n();
            Metadata c;
            if (n2 == 1835365473) {
                b2.P(e);
                c = C(b2, e + n);
            }
            else {
                c = metadata;
                if (n2 == 1936553057) {
                    b2.P(e);
                    u = u(b2, e + n);
                    c = metadata;
                }
            }
            b2.P(e + n);
            metadata = c;
        }
        return (Pair<Metadata, Metadata>)Pair.create((Object)metadata, u);
    }
    
    private static Metadata C(final ParsableByteArray parsableByteArray, final int n) {
        parsableByteArray.Q(8);
        e(parsableByteArray);
        while (parsableByteArray.e() < n) {
            final int e = parsableByteArray.e();
            final int n2 = parsableByteArray.n();
            if (parsableByteArray.n() == 1768715124) {
                parsableByteArray.P(e);
                return l(parsableByteArray, e + n2);
            }
            parsableByteArray.P(e + n2);
        }
        return null;
    }
    
    private static void D(final ParsableByteArray parsableByteArray, int n, final int n2, final int n3, final int n4, final int n5, final DrmInitData drmInitData, final d d, int j) throws ParserException {
        parsableByteArray.P(n2 + 8 + 8);
        parsableByteArray.Q(16);
        final int i = parsableByteArray.J();
        final int k = parsableByteArray.J();
        parsableByteArray.Q(50);
        int e = parsableByteArray.e();
        final int n6 = n;
        DrmInitData c = drmInitData;
        n = n6;
        if (n6 == 1701733238) {
            final Pair<Integer, TrackEncryptionBox> s = s(parsableByteArray, n2, n3);
            c = drmInitData;
            n = n6;
            if (s != null) {
                n = (int)s.first;
                if (drmInitData == null) {
                    c = null;
                }
                else {
                    c = drmInitData.c(((TrackEncryptionBox)s.second).b);
                }
                d.a[j] = (TrackEncryptionBox)s.second;
            }
            parsableByteArray.P(e);
        }
        final String s2 = "video/3gpp";
        String a;
        if (n == 1831958048) {
            a = "video/mpeg";
        }
        else if (n == 1211250227) {
            a = "video/3gpp";
        }
        else {
            a = null;
        }
        float n7 = 1.0f;
        byte[] r = null;
        String s3 = null;
        Object o = null;
        int n8 = -1;
        int n9 = -1;
        int n10 = -1;
        j = -1;
        ByteBuffer byteBuffer = null;
        b l = null;
        int n11 = 0;
        final int n12 = n;
        final DrmInitData drmInitData2 = c;
        while (e - n2 < n3) {
            parsableByteArray.P(e);
            n = parsableByteArray.e();
            final int n13 = parsableByteArray.n();
            if (n13 == 0 && parsableByteArray.e() - n2 == n3) {
                break;
            }
            ExtractorUtil.a(n13 > 0, "childAtomSize must be positive");
            final int n14 = parsableByteArray.n();
            Label_0365: {
                if (n14 == 1635148611) {
                    ExtractorUtil.a(a == null, null);
                    parsableByteArray.P(n + 8);
                    final AvcConfig b = AvcConfig.b(parsableByteArray);
                    o = b.a;
                    d.c = b.b;
                    if (n11 == 0) {
                        n7 = b.e;
                    }
                    s3 = b.f;
                    a = "video/avc";
                }
                else if (n14 == 1752589123) {
                    ExtractorUtil.a(a == null, null);
                    parsableByteArray.P(n + 8);
                    final HevcConfig a2 = HevcConfig.a(parsableByteArray);
                    o = a2.a;
                    d.c = a2.b;
                    if (n11 == 0) {
                        n7 = a2.e;
                    }
                    s3 = a2.f;
                    a = "video/hevc";
                }
                else {
                    Label_1429: {
                        String s4;
                        String c2;
                        int b2;
                        int n15;
                        int c3;
                        if (n14 != 1685480259 && n14 != 1685485123) {
                            if (n14 == 1987076931) {
                                ExtractorUtil.a(a == null, null);
                                if (n12 == 1987063864) {
                                    a = "video/x-vnd.on2.vp8";
                                    break Label_0365;
                                }
                                a = "video/x-vnd.on2.vp9";
                                break Label_0365;
                            }
                            else {
                                if (n14 == 1635135811) {
                                    ExtractorUtil.a(a == null, null);
                                    a = "video/av01";
                                    break Label_0365;
                                }
                                if (n14 == 1668050025) {
                                    if (byteBuffer == null) {
                                        byteBuffer = a();
                                    }
                                    byteBuffer.position(21);
                                    byteBuffer.putShort(parsableByteArray.z());
                                    byteBuffer.putShort(parsableByteArray.z());
                                    break Label_0365;
                                }
                                if (n14 == 1835295606) {
                                    if (byteBuffer == null) {
                                        byteBuffer = a();
                                    }
                                    final short z = parsableByteArray.z();
                                    final short z2 = parsableByteArray.z();
                                    final short z3 = parsableByteArray.z();
                                    final short z4 = parsableByteArray.z();
                                    final short z5 = parsableByteArray.z();
                                    final short z6 = parsableByteArray.z();
                                    final short z7 = parsableByteArray.z();
                                    final short z8 = parsableByteArray.z();
                                    final long f = parsableByteArray.F();
                                    final long f2 = parsableByteArray.F();
                                    byteBuffer.position(1);
                                    byteBuffer.putShort(z5);
                                    byteBuffer.putShort(z6);
                                    byteBuffer.putShort(z);
                                    byteBuffer.putShort(z2);
                                    byteBuffer.putShort(z3);
                                    byteBuffer.putShort(z4);
                                    byteBuffer.putShort(z7);
                                    byteBuffer.putShort(z8);
                                    byteBuffer.putShort((short)(f / 10000L));
                                    byteBuffer.putShort((short)(f2 / 10000L));
                                    break Label_0365;
                                }
                                if (n14 == 1681012275) {
                                    ExtractorUtil.a(a == null, null);
                                    s4 = s2;
                                    c2 = s3;
                                    n = n8;
                                    b2 = n9;
                                    n15 = n10;
                                    c3 = j;
                                }
                                else {
                                    if (n14 == 1702061171) {
                                        ExtractorUtil.a(a == null, null);
                                        l = i(parsableByteArray, n);
                                        a = b.a(l);
                                        final byte[] b3 = b.b(l);
                                        if (b3 != null) {
                                            o = ImmutableList.of((Object)b3);
                                        }
                                        n = n8;
                                        break Label_1429;
                                    }
                                    if (n14 == 1885434736) {
                                        n7 = q(parsableByteArray, n);
                                        n11 = 1;
                                        break Label_0365;
                                    }
                                    if (n14 == 1937126244) {
                                        r = r(parsableByteArray, n, n13);
                                        break Label_0365;
                                    }
                                    if (n14 == 1936995172) {
                                        final int d2 = parsableByteArray.D();
                                        parsableByteArray.Q(3);
                                        s4 = a;
                                        c2 = s3;
                                        n = n8;
                                        b2 = n9;
                                        n15 = n10;
                                        c3 = j;
                                        if (d2 == 0) {
                                            n = parsableByteArray.D();
                                            if (n != 0) {
                                                if (n != 1) {
                                                    if (n != 2) {
                                                        if (n != 3) {
                                                            s4 = a;
                                                            c2 = s3;
                                                            n = n8;
                                                            b2 = n9;
                                                            n15 = n10;
                                                            c3 = j;
                                                        }
                                                        else {
                                                            n = 3;
                                                            s4 = a;
                                                            c2 = s3;
                                                            b2 = n9;
                                                            n15 = n10;
                                                            c3 = j;
                                                        }
                                                    }
                                                    else {
                                                        n = 2;
                                                        s4 = a;
                                                        c2 = s3;
                                                        b2 = n9;
                                                        n15 = n10;
                                                        c3 = j;
                                                    }
                                                }
                                                else {
                                                    n = 1;
                                                    s4 = a;
                                                    c2 = s3;
                                                    b2 = n9;
                                                    n15 = n10;
                                                    c3 = j;
                                                }
                                            }
                                            else {
                                                n = 0;
                                                s4 = a;
                                                c2 = s3;
                                                b2 = n9;
                                                n15 = n10;
                                                c3 = j;
                                            }
                                        }
                                    }
                                    else {
                                        s4 = a;
                                        c2 = s3;
                                        n = n8;
                                        b2 = n9;
                                        n15 = n10;
                                        c3 = j;
                                        if (n14 == 1668246642) {
                                            n = parsableByteArray.n();
                                            if (n != 1852009592 && n != 1852009571) {
                                                final StringBuilder sb = new StringBuilder();
                                                sb.append("Unsupported color type: ");
                                                sb.append(com.google.android.exoplayer2.extractor.mp4.a.a(n));
                                                Log.i("AtomParsers", sb.toString());
                                                s4 = a;
                                                c2 = s3;
                                                n = n8;
                                                b2 = n9;
                                                n15 = n10;
                                                c3 = j;
                                            }
                                            else {
                                                final int m = parsableByteArray.J();
                                                j = parsableByteArray.J();
                                                parsableByteArray.Q(2);
                                                if (n13 == 19 && (parsableByteArray.D() & 0x80) != 0x0) {
                                                    n = 1;
                                                }
                                                else {
                                                    n = 0;
                                                }
                                                b2 = ColorInfo.b(m);
                                                if (n != 0) {
                                                    n15 = 1;
                                                }
                                                else {
                                                    n15 = 2;
                                                }
                                                c3 = ColorInfo.c(j);
                                                s4 = a;
                                                c2 = s3;
                                                n = n8;
                                            }
                                        }
                                    }
                                }
                            }
                        }
                        else {
                            final DolbyVisionConfig a3 = DolbyVisionConfig.a(parsableByteArray);
                            s4 = a;
                            c2 = s3;
                            n = n8;
                            b2 = n9;
                            n15 = n10;
                            c3 = j;
                            if (a3 != null) {
                                c2 = a3.c;
                                s4 = "video/dolby-vision";
                                c3 = j;
                                n15 = n10;
                                b2 = n9;
                                n = n8;
                            }
                        }
                        j = c3;
                        n10 = n15;
                        n9 = b2;
                        s3 = c2;
                        a = s4;
                    }
                    n8 = n;
                }
            }
            e += n13;
        }
        if (a == null) {
            return;
        }
        final Format.Builder m2 = new Format.Builder().R(n4).e0(a).I(s3).j0(i).Q(k).a0(n7).d0(n5).b0(r).h0(n8).T((List<byte[]>)o).M(drmInitData2);
        if (n9 != -1 || n10 != -1 || j != -1 || byteBuffer != null) {
            byte[] array;
            if (byteBuffer != null) {
                array = byteBuffer.array();
            }
            else {
                array = null;
            }
            m2.J(new ColorInfo(n9, n10, j, array));
        }
        if (l != null) {
            m2.G(Ints.m(b.d(l))).Z(Ints.m(b.c(l)));
        }
        d.b = m2.E();
    }
    
    private static ByteBuffer a() {
        return ByteBuffer.allocate(25).order(ByteOrder.LITTLE_ENDIAN);
    }
    
    private static boolean b(final long[] array, final long n, final long n2, final long n3) {
        final int length = array.length;
        boolean b = true;
        final int n4 = length - 1;
        final int q = Util.q(4, 0, n4);
        final int q2 = Util.q(array.length - 4, 0, n4);
        if (array[0] > n2 || n2 >= array[q] || array[q2] >= n3 || n3 > n) {
            b = false;
        }
        return b;
    }
    
    private static int c(final ParsableByteArray parsableByteArray, final int n, final int n2, final int n3) throws ParserException {
        int e = parsableByteArray.e();
        ExtractorUtil.a(e >= n2, null);
        while (e - n2 < n3) {
            parsableByteArray.P(e);
            final int n4 = parsableByteArray.n();
            ExtractorUtil.a(n4 > 0, "childAtomSize must be positive");
            if (parsableByteArray.n() == n) {
                return e;
            }
            e += n4;
        }
        return -1;
    }
    
    private static int d(final int n) {
        if (n == 1936684398) {
            return 1;
        }
        if (n == 1986618469) {
            return 2;
        }
        if (n == 1952807028 || n == 1935832172 || n == 1937072756 || n == 1668047728) {
            return 3;
        }
        if (n == 1835365473) {
            return 5;
        }
        return -1;
    }
    
    public static void e(final ParsableByteArray parsableByteArray) {
        final int e = parsableByteArray.e();
        parsableByteArray.Q(4);
        int n = e;
        if (parsableByteArray.n() != 1751411826) {
            n = e + 4;
        }
        parsableByteArray.P(n);
    }
    
    private static void f(final ParsableByteArray parsableByteArray, int n, final int n2, final int n3, final int n4, final String s, final boolean b, final DrmInitData drmInitData, final d d, int a) throws ParserException {
        parsableByteArray.P(n2 + 8 + 8);
        int j;
        if (b) {
            j = parsableByteArray.J();
            parsableByteArray.Q(6);
        }
        else {
            parsableByteArray.Q(8);
            j = 0;
        }
        int e;
        int n5;
        int n6;
        if (j != 0 && j != 1) {
            if (j != 2) {
                return;
            }
            parsableByteArray.Q(16);
            e = (int)Math.round(parsableByteArray.l());
            n5 = parsableByteArray.H();
            parsableByteArray.Q(20);
            n6 = 0;
        }
        else {
            n5 = parsableByteArray.J();
            parsableByteArray.Q(6);
            e = parsableByteArray.E();
            parsableByteArray.P(parsableByteArray.e() - 4);
            n6 = parsableByteArray.n();
            if (j == 1) {
                parsableByteArray.Q(16);
            }
        }
        int e2 = parsableByteArray.e();
        DrmInitData drmInitData2 = drmInitData;
        int n7;
        if ((n7 = n) == 1701733217) {
            final Pair<Integer, TrackEncryptionBox> s2 = s(parsableByteArray, n2, n3);
            DrmInitData c = drmInitData;
            if (s2 != null) {
                n = (int)s2.first;
                if (drmInitData == null) {
                    c = null;
                }
                else {
                    c = drmInitData.c(((TrackEncryptionBox)s2.second).b);
                }
                d.a[a] = (TrackEncryptionBox)s2.second;
            }
            parsableByteArray.P(e2);
            n7 = n;
            drmInitData2 = c;
        }
        String s3 = "audio/raw";
        int n8 = 0;
        Label_0616: {
            if (n7 == 1633889587) {
                s3 = "audio/ac3";
            }
            else if (n7 == 1700998451) {
                s3 = "audio/eac3";
            }
            else if (n7 == 1633889588) {
                s3 = "audio/ac4";
            }
            else if (n7 == 1685353315) {
                s3 = "audio/vnd.dts";
            }
            else if (n7 != 1685353320 && n7 != 1685353324) {
                if (n7 == 1685353317) {
                    s3 = "audio/vnd.dts.hd;profile=lbr";
                }
                else if (n7 == 1685353336) {
                    s3 = "audio/vnd.dts.uhd;profile=p2";
                }
                else if (n7 == 1935764850) {
                    s3 = "audio/3gpp";
                }
                else if (n7 == 1935767394) {
                    s3 = "audio/amr-wb";
                }
                else {
                    if (n7 == 1819304813 || n7 == 1936684916) {
                        n8 = 2;
                        break Label_0616;
                    }
                    if (n7 == 1953984371) {
                        n8 = 268435456;
                        break Label_0616;
                    }
                    if (n7 != 778924082 && n7 != 778924083) {
                        if (n7 == 1835557169) {
                            s3 = "audio/mha1";
                        }
                        else if (n7 == 1835560241) {
                            s3 = "audio/mhm1";
                        }
                        else if (n7 == 1634492771) {
                            s3 = "audio/alac";
                        }
                        else if (n7 == 1634492791) {
                            s3 = "audio/g711-alaw";
                        }
                        else if (n7 == 1970037111) {
                            s3 = "audio/g711-mlaw";
                        }
                        else if (n7 == 1332770163) {
                            s3 = "audio/opus";
                        }
                        else if (n7 == 1716281667) {
                            s3 = "audio/flac";
                        }
                        else {
                            if (n7 != 1835823201) {
                                n8 = -1;
                                s3 = null;
                                break Label_0616;
                            }
                            s3 = "audio/true-hd";
                        }
                    }
                    else {
                        s3 = "audio/mpeg";
                    }
                }
            }
            else {
                s3 = "audio/vnd.dts.hd";
            }
            n8 = -1;
        }
        b b2 = null;
        String c2 = null;
        List<byte[]> list = null;
        String s4 = s3;
        n = n5;
        a = e;
        while (e2 - n2 < n3) {
            parsableByteArray.P(e2);
            final int n9 = parsableByteArray.n();
            ExtractorUtil.a(n9 > 0, "childAtomSize must be positive");
            final int n10 = parsableByteArray.n();
            Object o = null;
            int intValue = 0;
            int intValue2 = 0;
            String s5 = null;
            Label_1396: {
                Label_0729: {
                    if (n10 == 1835557187) {
                        final int n11 = n9 - 13;
                        final byte[] array = new byte[n11];
                        parsableByteArray.P(e2 + 13);
                        parsableByteArray.j(array, 0, n11);
                        o = ImmutableList.of((Object)array);
                    }
                    else {
                        if (n10 != 1702061171 && (!b || n10 != 2002876005)) {
                            if (n10 == 1684103987) {
                                parsableByteArray.P(e2 + 8);
                                d.b = Ac3Util.c(parsableByteArray, Integer.toString(n4), s, drmInitData2);
                            }
                            else if (n10 == 1684366131) {
                                parsableByteArray.P(e2 + 8);
                                d.b = Ac3Util.g(parsableByteArray, Integer.toString(n4), s, drmInitData2);
                            }
                            else if (n10 == 1684103988) {
                                parsableByteArray.P(e2 + 8);
                                d.b = Ac4Util.b(parsableByteArray, Integer.toString(n4), s, drmInitData2);
                            }
                            else if (n10 == 1684892784) {
                                if (n6 > 0) {
                                    a = n6;
                                    n = 2;
                                    o = list;
                                    break Label_0729;
                                }
                                final StringBuilder sb = new StringBuilder();
                                sb.append("Invalid sample rate for Dolby TrueHD MLP stream: ");
                                sb.append(n6);
                                throw ParserException.createForMalformedContainer(sb.toString(), null);
                            }
                            else if (n10 == 1684305011) {
                                d.b = new Format.Builder().R(n4).e0(s4).H(n).f0(a).M(drmInitData2).V(s).E();
                            }
                            else {
                                if (n10 == 1682927731) {
                                    final int n12 = n9 - 8;
                                    final byte[] a2 = b.a;
                                    final byte[] copy = Arrays.copyOf(a2, a2.length + n12);
                                    parsableByteArray.P(e2 + 8);
                                    parsableByteArray.j(copy, a2.length, n12);
                                    o = OpusUtil.a(copy);
                                    break Label_0729;
                                }
                                if (n10 == 1684425825) {
                                    final int n13 = n9 - 12;
                                    final byte[] array2 = new byte[n13 + 4];
                                    array2[0] = 102;
                                    array2[1] = 76;
                                    array2[2] = 97;
                                    array2[3] = 67;
                                    parsableByteArray.P(e2 + 12);
                                    parsableByteArray.j(array2, 4, n13);
                                    o = ImmutableList.of((Object)array2);
                                    break Label_0729;
                                }
                                if (n10 == 1634492771) {
                                    n = n9 - 12;
                                    final byte[] array3 = new byte[n];
                                    parsableByteArray.P(e2 + 12);
                                    parsableByteArray.j(array3, 0, n);
                                    final Pair<Integer, Integer> h = CodecSpecificDataUtil.h(array3);
                                    intValue = (int)h.first;
                                    intValue2 = (int)h.second;
                                    o = ImmutableList.of((Object)array3);
                                    s5 = c2;
                                    break Label_1396;
                                }
                            }
                            intValue = a;
                            intValue2 = n;
                            s5 = c2;
                            o = list;
                            break Label_1396;
                        }
                        int c3;
                        if (n10 == 1702061171) {
                            c3 = e2;
                        }
                        else {
                            c3 = c(parsableByteArray, 1702061171, e2, n9);
                        }
                        intValue = a;
                        intValue2 = n;
                        s5 = c2;
                        o = list;
                        if (c3 == -1) {
                            break Label_1396;
                        }
                        final b i = i(parsableByteArray, c3);
                        final String a3 = b.a(i);
                        final byte[] b3 = b.b(i);
                        intValue = a;
                        intValue2 = n;
                        s4 = a3;
                        b2 = i;
                        s5 = c2;
                        o = list;
                        if (b3 != null) {
                            if ("audio/mp4a-latm".equals(a3)) {
                                final AacUtil.Config f = AacUtil.f(b3);
                                a = f.a;
                                n = f.b;
                                c2 = f.c;
                            }
                            o = ImmutableList.of((Object)b3);
                            s5 = c2;
                            b2 = i;
                            s4 = a3;
                            intValue2 = n;
                            intValue = a;
                        }
                        break Label_1396;
                    }
                }
                intValue = a;
                intValue2 = n;
                s5 = c2;
            }
            e2 += n9;
            a = intValue;
            n = intValue2;
            c2 = s5;
            list = (List<byte[]>)o;
        }
        if (d.b == null && s4 != null) {
            final Format.Builder v = new Format.Builder().R(n4).e0(s4).I(c2).H(n).f0(a).Y(n8).T(list).M(drmInitData2).V(s);
            if (b2 != null) {
                v.G(Ints.m(b.d(b2))).Z(Ints.m(b.c(b2)));
            }
            d.b = v.E();
        }
    }
    
    static Pair<Integer, TrackEncryptionBox> g(final ParsableByteArray parsableByteArray, final int n, final int n2) throws ParserException {
        int n3 = n + 8;
        final boolean b = false;
        int n4 = -1;
        String s = null;
        Integer n5 = null;
        int n6 = 0;
        while (n3 - n < n2) {
            parsableByteArray.P(n3);
            final int n7 = parsableByteArray.n();
            final int n8 = parsableByteArray.n();
            Integer value;
            String a;
            if (n8 == 1718775137) {
                value = parsableByteArray.n();
                a = s;
            }
            else if (n8 == 1935894637) {
                parsableByteArray.Q(4);
                a = parsableByteArray.A(4);
                value = n5;
            }
            else {
                a = s;
                value = n5;
                if (n8 == 1935894633) {
                    n4 = n3;
                    n6 = n7;
                    value = n5;
                    a = s;
                }
            }
            n3 += n7;
            s = a;
            n5 = value;
        }
        if (!"cenc".equals(s) && !"cbc1".equals(s) && !"cens".equals(s) && !"cbcs".equals(s)) {
            return null;
        }
        ExtractorUtil.a(n5 != null, "frma atom is mandatory");
        ExtractorUtil.a(n4 != -1, "schi atom is mandatory");
        final TrackEncryptionBox t = t(parsableByteArray, n4, n6, s);
        boolean b2 = b;
        if (t != null) {
            b2 = true;
        }
        ExtractorUtil.a(b2, "tenc atom is mandatory");
        return (Pair<Integer, TrackEncryptionBox>)Pair.create((Object)n5, (Object)Util.j(t));
    }
    
    private static Pair<long[], long[]> h(final com.google.android.exoplayer2.extractor.mp4.a.a a) {
        final com.google.android.exoplayer2.extractor.mp4.a.b g = a.g(1701606260);
        if (g == null) {
            return null;
        }
        final ParsableByteArray b = g.b;
        b.P(8);
        final int c = a.c(b.n());
        final int h = b.H();
        final long[] array = new long[h];
        final long[] array2 = new long[h];
        for (int i = 0; i < h; ++i) {
            long n;
            if (c == 1) {
                n = b.I();
            }
            else {
                n = b.F();
            }
            array[i] = n;
            long w;
            if (c == 1) {
                w = b.w();
            }
            else {
                w = b.n();
            }
            array2[i] = w;
            if (b.z() != 1) {
                throw new IllegalArgumentException("Unsupported media rate.");
            }
            b.Q(2);
        }
        return (Pair<long[], long[]>)Pair.create((Object)array, (Object)array2);
    }
    
    private static b i(final ParsableByteArray parsableByteArray, int n) {
        parsableByteArray.P(n + 8 + 4);
        parsableByteArray.Q(1);
        j(parsableByteArray);
        parsableByteArray.Q(2);
        n = parsableByteArray.D();
        if ((n & 0x80) != 0x0) {
            parsableByteArray.Q(2);
        }
        if ((n & 0x40) != 0x0) {
            parsableByteArray.Q(parsableByteArray.D());
        }
        if ((n & 0x20) != 0x0) {
            parsableByteArray.Q(2);
        }
        parsableByteArray.Q(1);
        j(parsableByteArray);
        final String h = MimeTypes.h(parsableByteArray.D());
        if (!"audio/mpeg".equals(h) && !"audio/vnd.dts".equals(h) && !"audio/vnd.dts.hd".equals(h)) {
            parsableByteArray.Q(4);
            long f = parsableByteArray.F();
            long f2 = parsableByteArray.F();
            parsableByteArray.Q(1);
            n = j(parsableByteArray);
            final byte[] array = new byte[n];
            parsableByteArray.j(array, 0, n);
            if (f2 <= 0L) {
                f2 = -1L;
            }
            if (f <= 0L) {
                f = -1L;
            }
            return new b(h, array, f2, f);
        }
        return new b(h, null, -1L, -1L);
    }
    
    private static int j(final ParsableByteArray parsableByteArray) {
        int n;
        int n2;
        for (n = parsableByteArray.D(), n2 = (n & 0x7F); (n & 0x80) == 0x80; n = parsableByteArray.D(), n2 = (n2 << 7 | (n & 0x7F))) {}
        return n2;
    }
    
    private static int k(final ParsableByteArray parsableByteArray) {
        parsableByteArray.P(16);
        return parsableByteArray.n();
    }
    
    private static Metadata l(final ParsableByteArray parsableByteArray, final int n) {
        parsableByteArray.Q(8);
        final ArrayList list = new ArrayList();
        while (parsableByteArray.e() < n) {
            final Metadata.Entry c = com.google.android.exoplayer2.extractor.mp4.e.c(parsableByteArray);
            if (c != null) {
                list.add(c);
            }
        }
        Metadata metadata;
        if (list.isEmpty()) {
            metadata = null;
        }
        else {
            metadata = new Metadata(list);
        }
        return metadata;
    }
    
    private static Pair<Long, String> m(final ParsableByteArray parsableByteArray) {
        final int n = 8;
        parsableByteArray.P(8);
        final int c = com.google.android.exoplayer2.extractor.mp4.a.c(parsableByteArray.n());
        int n2;
        if (c == 0) {
            n2 = 8;
        }
        else {
            n2 = 16;
        }
        parsableByteArray.Q(n2);
        final long f = parsableByteArray.F();
        int n3 = n;
        if (c == 0) {
            n3 = 4;
        }
        parsableByteArray.Q(n3);
        final int j = parsableByteArray.J();
        final StringBuilder sb = new StringBuilder();
        sb.append("");
        sb.append((char)((j >> 10 & 0x1F) + 96));
        sb.append((char)((j >> 5 & 0x1F) + 96));
        sb.append((char)((j & 0x1F) + 96));
        return (Pair<Long, String>)Pair.create((Object)f, (Object)sb.toString());
    }
    
    public static Metadata n(final com.google.android.exoplayer2.extractor.mp4.a.a a) {
        final com.google.android.exoplayer2.extractor.mp4.a.b g = a.g(1751411826);
        final com.google.android.exoplayer2.extractor.mp4.a.b g2 = a.g(1801812339);
        final com.google.android.exoplayer2.extractor.mp4.a.b g3 = a.g(1768715124);
        Metadata metadata2;
        final Metadata metadata = metadata2 = null;
        if (g != null) {
            metadata2 = metadata;
            if (g2 != null) {
                metadata2 = metadata;
                if (g3 != null) {
                    if (k(g.b) != 1835299937) {
                        metadata2 = metadata;
                    }
                    else {
                        final ParsableByteArray b = g2.b;
                        b.P(12);
                        final int n = b.n();
                        final String[] array = new String[n];
                        for (int i = 0; i < n; ++i) {
                            final int n2 = b.n();
                            b.Q(4);
                            array[i] = b.A(n2 - 8);
                        }
                        final ParsableByteArray b2 = g3.b;
                        b2.P(8);
                        final ArrayList<Metadata.Entry> list = new ArrayList<Metadata.Entry>();
                        while (b2.a() > 8) {
                            final int e = b2.e();
                            final int n3 = b2.n();
                            final int n4 = b2.n() - 1;
                            if (n4 >= 0 && n4 < n) {
                                final MdtaMetadataEntry f = com.google.android.exoplayer2.extractor.mp4.e.f(b2, e + n3, array[n4]);
                                if (f != null) {
                                    list.add((Metadata.Entry)f);
                                }
                            }
                            else {
                                final StringBuilder sb = new StringBuilder();
                                sb.append("Skipped metadata with unknown key index: ");
                                sb.append(n4);
                                Log.i("AtomParsers", sb.toString());
                            }
                            b2.P(e + n3);
                        }
                        if (list.isEmpty()) {
                            metadata2 = metadata;
                        }
                        else {
                            metadata2 = new Metadata(list);
                        }
                    }
                }
            }
        }
        return metadata2;
    }
    
    private static void o(final ParsableByteArray parsableByteArray, final int n, final int n2, final int n3, final d d) {
        parsableByteArray.P(n2 + 8 + 8);
        if (n == 1835365492) {
            parsableByteArray.x();
            final String x = parsableByteArray.x();
            if (x != null) {
                d.b = new Format.Builder().R(n3).e0(x).E();
            }
        }
    }
    
    private static long p(final ParsableByteArray parsableByteArray) {
        int n = 8;
        parsableByteArray.P(8);
        if (com.google.android.exoplayer2.extractor.mp4.a.c(parsableByteArray.n()) != 0) {
            n = 16;
        }
        parsableByteArray.Q(n);
        return parsableByteArray.F();
    }
    
    private static float q(final ParsableByteArray parsableByteArray, int h) {
        parsableByteArray.P(h + 8);
        h = parsableByteArray.H();
        return h / (float)parsableByteArray.H();
    }
    
    private static byte[] r(final ParsableByteArray parsableByteArray, final int n, final int n2) {
        int n4;
        for (int n3 = n + 8; n3 - n < n2; n3 += n4) {
            parsableByteArray.P(n3);
            n4 = parsableByteArray.n();
            if (parsableByteArray.n() == 1886547818) {
                return Arrays.copyOfRange(parsableByteArray.d(), n3, n4 + n3);
            }
        }
        return null;
    }
    
    private static Pair<Integer, TrackEncryptionBox> s(final ParsableByteArray parsableByteArray, final int n, final int n2) throws ParserException {
        int n3;
        for (int e = parsableByteArray.e(); e - n < n2; e += n3) {
            parsableByteArray.P(e);
            n3 = parsableByteArray.n();
            ExtractorUtil.a(n3 > 0, "childAtomSize must be positive");
            if (parsableByteArray.n() == 1936289382) {
                final Pair<Integer, TrackEncryptionBox> g = g(parsableByteArray, e, n3);
                if (g != null) {
                    return g;
                }
            }
        }
        return null;
    }
    
    private static TrackEncryptionBox t(final ParsableByteArray parsableByteArray, int n, int n2, final String s) {
        int n3 = n + 8;
        while (true) {
            final byte[] array = null;
            if (n3 - n >= n2) {
                return null;
            }
            parsableByteArray.P(n3);
            final int n4 = parsableByteArray.n();
            if (parsableByteArray.n() == 1952804451) {
                n = com.google.android.exoplayer2.extractor.mp4.a.c(parsableByteArray.n());
                parsableByteArray.Q(1);
                if (n == 0) {
                    parsableByteArray.Q(1);
                    n = 0;
                    n2 = 0;
                }
                else {
                    n = parsableByteArray.D();
                    n2 = (n & 0xF);
                    n = (n & 0xF0) >> 4;
                }
                final boolean b = parsableByteArray.D() == 1;
                final int d = parsableByteArray.D();
                final byte[] array2 = new byte[16];
                parsableByteArray.j(array2, 0, 16);
                byte[] array3 = array;
                if (b) {
                    array3 = array;
                    if (d == 0) {
                        final int d2 = parsableByteArray.D();
                        array3 = new byte[d2];
                        parsableByteArray.j(array3, 0, d2);
                    }
                }
                return new TrackEncryptionBox(b, s, d, array2, n, n2, array3);
            }
            n3 += n4;
        }
    }
    
    private static Metadata u(final ParsableByteArray parsableByteArray, int d) {
        parsableByteArray.Q(12);
        while (parsableByteArray.e() < d) {
            final int e = parsableByteArray.e();
            final int n = parsableByteArray.n();
            if (parsableByteArray.n() == 1935766900) {
                if (n < 14) {
                    return null;
                }
                parsableByteArray.Q(5);
                d = parsableByteArray.D();
                if (d != 12 && d != 13) {
                    return null;
                }
                float n2;
                if (d == 12) {
                    n2 = 240.0f;
                }
                else {
                    n2 = 120.0f;
                }
                parsableByteArray.Q(1);
                return new Metadata(new Metadata.Entry[] { new SmtaMetadataEntry(n2, parsableByteArray.D()) });
            }
            else {
                parsableByteArray.P(e + n);
            }
        }
        return null;
    }
    
    private static i v(final Track track, final com.google.android.exoplayer2.extractor.mp4.a.a a, final GaplessInfoHolder gaplessInfoHolder) throws ParserException {
        final com.google.android.exoplayer2.extractor.mp4.a.b g = a.g(1937011578);
        c c;
        if (g != null) {
            c = new e(g, track.f);
        }
        else {
            final com.google.android.exoplayer2.extractor.mp4.a.b g2 = a.g(1937013298);
            if (g2 == null) {
                throw ParserException.createForMalformedContainer("Track has no sample table size information", null);
            }
            c = new f(g2);
        }
        final int c2 = c.c();
        if (c2 == 0) {
            return new i(track, new long[0], new int[0], 0, new long[0], new int[0], 0L);
        }
        com.google.android.exoplayer2.extractor.mp4.a.b g3 = a.g(1937007471);
        boolean b;
        if (g3 == null) {
            g3 = Assertions.e(a.g(1668232756));
            b = true;
        }
        else {
            b = false;
        }
        final ParsableByteArray b2 = g3.b;
        final ParsableByteArray b3 = Assertions.e(a.g(1937011555)).b;
        final ParsableByteArray b4 = Assertions.e(a.g(1937011827)).b;
        final com.google.android.exoplayer2.extractor.mp4.a.b g4 = a.g(1937011571);
        ParsableByteArray b5;
        if (g4 != null) {
            b5 = g4.b;
        }
        else {
            b5 = null;
        }
        final com.google.android.exoplayer2.extractor.mp4.a.b g5 = a.g(1668576371);
        ParsableByteArray b6;
        if (g5 != null) {
            b6 = g5.b;
        }
        else {
            b6 = null;
        }
        final a a2 = new a(b3, b2, b);
        b4.P(12);
        int n = b4.H() - 1;
        final int h = b4.H();
        int h2 = b4.H();
        int h3;
        if (b6 != null) {
            b6.P(12);
            h3 = b6.H();
        }
        else {
            h3 = 0;
        }
        int h4;
        int n2;
        if (b5 != null) {
            b5.P(12);
            h4 = b5.H();
            if (h4 > 0) {
                n2 = b5.H() - 1;
            }
            else {
                n2 = -1;
                b5 = null;
            }
        }
        else {
            n2 = -1;
            h4 = 0;
        }
        final int b7 = c.b();
        final String w = track.f.w;
        int[] array4 = null;
        long[] d2 = null;
        int c4 = 0;
        long f = 0L;
        int[] b10 = null;
        long[] a4 = null;
        int n16 = 0;
        Label_1290: {
            if (b7 == -1 || (!"audio/raw".equals(w) && !"audio/g711-mlaw".equals(w) && !"audio/g711-alaw".equals(w)) || n != 0 || h3 != 0 || h4 != 0) {
                final long[] array = new long[c2];
                final int[] array2 = new int[c2];
                final long[] array3 = new long[c2];
                array4 = new int[c2];
                int n3 = n2;
                final int n4 = 0;
                int n5 = 0;
                final int n6 = 0;
                final int n7 = 0;
                int h5 = 0;
                long n8 = 0L;
                long d = 0L;
                int i = h3;
                int n9 = h;
                int n10 = h4;
                int n11 = n7;
                int c3 = n6;
                while (true) {
                    int n17;
                    int n18;
                    int n19;
                    int n20;
                    int n22;
                    int n23;
                    int h6;
                    int n25;
                    long n26;
                    int n27;
                    for (int n12 = c2, j = n4; j < n12; ++j, d += n26, h2 = n25, --c3, n27 = n18, n3 = n22, n10 = n23, n5 = n20, n9 = h6, i = n17, n11 = n27, h5 = n19) {
                        boolean a3 = true;
                        boolean b8;
                        while (true) {
                            b8 = a3;
                            if (c3 != 0) {
                                break;
                            }
                            a3 = a2.a();
                            if (!(b8 = a3)) {
                                break;
                            }
                            d = a2.d;
                            c3 = a2.c;
                        }
                        final int n13 = n9;
                        if (!b8) {
                            Log.i("AtomParsers", "Unexpected end of chunk data");
                            final long[] copy = Arrays.copyOf(array, j);
                            final int[] copy2 = Arrays.copyOf(array2, j);
                            final long[] copy3 = Arrays.copyOf(array3, j);
                            array4 = Arrays.copyOf(array4, j);
                            n12 = j;
                            final int n14 = c3;
                            final long[] array5 = copy;
                            d2 = copy3;
                            final long n15 = n11;
                            boolean b9 = false;
                            Label_1080: {
                                if (b6 != null) {
                                    while (i > 0) {
                                        if (b6.H() != 0) {
                                            b9 = false;
                                            break Label_1080;
                                        }
                                        b6.n();
                                        --i;
                                    }
                                }
                                b9 = true;
                            }
                            if (n10 != 0 || n13 != 0 || n14 != 0 || n != 0 || h5 != 0 || !b9) {
                                final StringBuilder sb = new StringBuilder();
                                sb.append("Inconsistent stbl box for track ");
                                sb.append(track.a);
                                sb.append(": remainingSynchronizationSamples ");
                                sb.append(n10);
                                sb.append(", remainingSamplesAtTimestampDelta ");
                                sb.append(n13);
                                sb.append(", remainingSamplesInChunk ");
                                sb.append(n14);
                                sb.append(", remainingTimestampDeltaChanges ");
                                sb.append(n);
                                sb.append(", remainingSamplesAtTimestampOffset ");
                                sb.append(h5);
                                String s;
                                if (!b9) {
                                    s = ", ctts invalid";
                                }
                                else {
                                    s = "";
                                }
                                sb.append(s);
                                Log.i("AtomParsers", sb.toString());
                            }
                            final long[] array6 = array5;
                            c4 = n5;
                            f = n8 + n15;
                            b10 = copy2;
                            a4 = array6;
                            n16 = n12;
                            break Label_1290;
                        }
                        n17 = i;
                        n18 = n11;
                        n19 = h5;
                        if (b6 != null) {
                            while (h5 == 0 && i > 0) {
                                h5 = b6.H();
                                n11 = b6.n();
                                --i;
                            }
                            n19 = h5 - 1;
                            n18 = n11;
                            n17 = i;
                        }
                        array[j] = d;
                        array2[j] = c.a();
                        if (array2[j] > (n20 = n5)) {
                            n20 = array2[j];
                        }
                        array3[j] = n8 + n18;
                        int n21;
                        if (b5 == null) {
                            n21 = 1;
                        }
                        else {
                            n21 = 0;
                        }
                        array4[j] = n21;
                        n22 = n3;
                        n23 = n10;
                        if (j == n3) {
                            array4[j] = 1;
                            final int n24 = n10 - 1;
                            n22 = n3;
                            if ((n23 = n24) > 0) {
                                n22 = Assertions.e(b5).H() - 1;
                                n23 = n24;
                            }
                        }
                        n8 += h2;
                        h6 = n13 - 1;
                        if (h6 == 0 && n > 0) {
                            h6 = b4.H();
                            n25 = b4.n();
                            --n;
                        }
                        else {
                            n25 = h2;
                        }
                        n26 = array2[j];
                    }
                    final int n13 = n9;
                    final int n14 = c3;
                    d2 = array3;
                    final int[] copy2 = array2;
                    final long[] array5 = array;
                    continue;
                }
            }
            final int a5 = a2.a;
            final long[] array7 = new long[a5];
            final int[] array8 = new int[a5];
            while (a2.a()) {
                final int b11 = a2.b;
                array7[b11] = a2.d;
                array8[b11] = a2.c;
            }
            final FixedSampleSizeRechunker.Results a6 = FixedSampleSizeRechunker.a(b7, array7, array8, h2);
            a4 = a6.a;
            b10 = a6.b;
            c4 = a6.c;
            d2 = a6.d;
            array4 = a6.e;
            f = a6.f;
            n16 = c2;
        }
        final long o0 = Util.O0(f, 1000000L, track.c);
        final long[] h7 = track.h;
        if (h7 == null) {
            Util.Q0(d2, 1000000L, track.c);
            return new i(track, a4, b10, c4, d2, array4, o0);
        }
        if (h7.length == 1 && track.b == 1 && d2.length >= 2) {
            final long n28 = Assertions.e(track.i)[0];
            final long n29 = n28 + Util.O0(track.h[0], track.c, track.d);
            if (b(d2, f, n28, n29)) {
                final long o2 = Util.O0(n28 - d2[0], track.f.K, track.c);
                final long o3 = Util.O0(f - n29, track.f.K, track.c);
                if ((o2 != 0L || o3 != 0L) && o2 <= 2147483647L && o3 <= 2147483647L) {
                    gaplessInfoHolder.a = (int)o2;
                    gaplessInfoHolder.b = (int)o3;
                    Util.Q0(d2, 1000000L, track.c);
                    return new i(track, a4, b10, c4, d2, array4, Util.O0(track.h[0], 1000000L, track.d));
                }
            }
        }
        final long[] h8 = track.h;
        if (h8.length == 1 && h8[0] == 0L) {
            final long n30 = Assertions.e(track.i)[0];
            for (int k = 0; k < d2.length; ++k) {
                d2[k] = Util.O0(d2[k] - n30, 1000000L, track.c);
            }
            return new i(track, a4, b10, c4, d2, array4, Util.O0(f - n30, 1000000L, track.c));
        }
        final boolean b12 = track.b == 1;
        final int[] array9 = new int[h8.length];
        final int[] array10 = new int[h8.length];
        final long[] array11 = Assertions.e(track.i);
        int n31 = 0;
        int n32 = 0;
        int n33 = 0;
        int n34 = 0;
        final int[] array12 = b10;
        while (true) {
            final long[] h9 = track.h;
            if (n31 >= h9.length) {
                break;
            }
            final long n35 = array11[n31];
            int n36;
            int n37;
            if (n35 != -1L) {
                final long o4 = Util.O0(h9[n31], track.c, track.d);
                array9[n31] = Util.i(d2, n35, true, true);
                array10[n31] = Util.e(d2, n35 + o4, b12, false);
                while (array9[n31] < array10[n31] && (array4[array9[n31]] & 0x1) == 0x0) {
                    ++array9[n31];
                }
                n33 += array10[n31] - array9[n31];
                n36 = (n32 | ((n34 != array9[n31]) ? 1 : 0));
                n37 = array10[n31];
            }
            else {
                final int n38 = n32;
                n37 = n34;
                n36 = n38;
            }
            ++n31;
            final int n39 = n36;
            n34 = n37;
            n32 = n39;
        }
        final int n40 = 0;
        int n41 = 1;
        if (n33 == n16) {
            n41 = 0;
        }
        final int n42 = n32 | n41;
        long[] array13;
        if (n42 != 0) {
            array13 = new long[n33];
        }
        else {
            array13 = a4;
        }
        int[] array14;
        if (n42 != 0) {
            array14 = new int[n33];
        }
        else {
            array14 = array12;
        }
        if (n42 != 0) {
            c4 = 0;
        }
        int[] array15;
        if (n42 != 0) {
            array15 = new int[n33];
        }
        else {
            array15 = array4;
        }
        final long[] array16 = new long[n33];
        long n43 = 0L;
        int n44 = 0;
        final int[] array17 = array12;
        final int[] array18 = array4;
        final int[] array19 = array15;
        int l = n40;
        final int[] array20 = array9;
        final int[] array21 = array10;
        while (l < track.h.length) {
            final long n45 = track.i[l];
            int n46 = array20[l];
            final int n47 = array21[l];
            if (n42 != 0) {
                final int n48 = n47 - n46;
                System.arraycopy(a4, n46, array13, n44, n48);
                System.arraycopy(array17, n46, array14, n44, n48);
                System.arraycopy(array18, n46, array19, n44, n48);
            }
            while (n46 < n47) {
                array16[n44] = Util.O0(n43, 1000000L, track.d) + Util.O0(Math.max(0L, d2[n46] - n45), 1000000L, track.c);
                if (n42 != 0 && array14[n44] > c4) {
                    c4 = array17[n46];
                }
                ++n44;
                ++n46;
            }
            final long n49 = track.h[l];
            ++l;
            n43 += n49;
        }
        return new i(track, array13, array14, c4, array16, array19, Util.O0(n43, 1000000L, track.d));
    }
    
    private static d w(final ParsableByteArray parsableByteArray, final int n, final int n2, final String s, final DrmInitData drmInitData, final boolean b) throws ParserException {
        parsableByteArray.P(12);
        final int n3 = parsableByteArray.n();
        final d d = new d(n3);
        for (int i = 0; i < n3; ++i) {
            final int e = parsableByteArray.e();
            final int n4 = parsableByteArray.n();
            ExtractorUtil.a(n4 > 0, "childAtomSize must be positive");
            final int n5 = parsableByteArray.n();
            if (n5 != 1635148593 && n5 != 1635148595 && n5 != 1701733238 && n5 != 1831958048 && n5 != 1836070006 && n5 != 1752589105 && n5 != 1751479857 && n5 != 1932670515 && n5 != 1211250227 && n5 != 1987063864 && n5 != 1987063865 && n5 != 1635135537 && n5 != 1685479798 && n5 != 1685479729 && n5 != 1685481573 && n5 != 1685481521) {
                if (n5 != 1836069985 && n5 != 1701733217 && n5 != 1633889587 && n5 != 1700998451 && n5 != 1633889588 && n5 != 1835823201 && n5 != 1685353315 && n5 != 1685353317 && n5 != 1685353320 && n5 != 1685353324 && n5 != 1685353336 && n5 != 1935764850 && n5 != 1935767394 && n5 != 1819304813 && n5 != 1936684916 && n5 != 1953984371 && n5 != 778924082 && n5 != 778924083 && n5 != 1835557169 && n5 != 1835560241 && n5 != 1634492771 && n5 != 1634492791 && n5 != 1970037111 && n5 != 1332770163 && n5 != 1716281667) {
                    if (n5 != 1414810956 && n5 != 1954034535 && n5 != 2004251764 && n5 != 1937010800 && n5 != 1664495672) {
                        if (n5 == 1835365492) {
                            o(parsableByteArray, n5, e, n, d);
                        }
                        else if (n5 == 1667329389) {
                            d.b = new Format.Builder().R(n).e0("application/x-camera-motion").E();
                        }
                    }
                    else {
                        x(parsableByteArray, n5, e, n4, n, s, d);
                    }
                }
                else {
                    f(parsableByteArray, n5, e, n4, n, s, b, drmInitData, d, i);
                }
            }
            else {
                D(parsableByteArray, n5, e, n4, n, n2, drmInitData, d, i);
            }
            parsableByteArray.P(e + n4);
        }
        return d;
    }
    
    private static void x(final ParsableByteArray parsableByteArray, int n, final int n2, final int n3, final int n4, final String s, final d d) {
        parsableByteArray.P(n2 + 8 + 8);
        final String s2 = "application/ttml+xml";
        Object of = null;
        long n5 = Long.MAX_VALUE;
        String s3;
        if (n == 1414810956) {
            s3 = s2;
        }
        else if (n == 1954034535) {
            n = n3 - 8 - 8;
            final byte[] array = new byte[n];
            parsableByteArray.j(array, 0, n);
            of = ImmutableList.of((Object)array);
            s3 = "application/x-quicktime-tx3g";
        }
        else if (n == 2004251764) {
            s3 = "application/x-mp4-vtt";
        }
        else if (n == 1937010800) {
            n5 = 0L;
            s3 = s2;
        }
        else {
            if (n != 1664495672) {
                throw new IllegalStateException();
            }
            d.d = 1;
            s3 = "application/x-mp4-cea-608";
        }
        d.b = new Format.Builder().R(n4).e0(s3).V(s).i0(n5).T((List<byte[]>)of).E();
    }
    
    private static g y(final ParsableByteArray parsableByteArray) {
        final int n = 8;
        parsableByteArray.P(8);
        final int c = com.google.android.exoplayer2.extractor.mp4.a.c(parsableByteArray.n());
        int n2;
        if (c == 0) {
            n2 = 8;
        }
        else {
            n2 = 16;
        }
        parsableByteArray.Q(n2);
        final int n3 = parsableByteArray.n();
        parsableByteArray.Q(4);
        final int e = parsableByteArray.e();
        int n4 = n;
        if (c == 0) {
            n4 = 4;
        }
        final int n5 = 0;
        while (true) {
            for (int i = 0; i < n4; ++i) {
                if (parsableByteArray.d()[e + i] != -1) {
                    final boolean b = false;
                    final long n6 = -9223372036854775807L;
                    long n7;
                    if (b) {
                        parsableByteArray.Q(n4);
                        n7 = n6;
                    }
                    else {
                        if (c == 0) {
                            n7 = parsableByteArray.F();
                        }
                        else {
                            n7 = parsableByteArray.I();
                        }
                        if (n7 == 0L) {
                            n7 = n6;
                        }
                    }
                    parsableByteArray.Q(16);
                    final int n8 = parsableByteArray.n();
                    final int n9 = parsableByteArray.n();
                    parsableByteArray.Q(4);
                    final int n10 = parsableByteArray.n();
                    final int n11 = parsableByteArray.n();
                    int n12;
                    if (n8 == 0 && n9 == 65536 && n10 == -65536 && n11 == 0) {
                        n12 = 90;
                    }
                    else if (n8 == 0 && n9 == -65536 && n10 == 65536 && n11 == 0) {
                        n12 = 270;
                    }
                    else {
                        n12 = n5;
                        if (n8 == -65536) {
                            n12 = n5;
                            if (n9 == 0) {
                                n12 = n5;
                                if (n10 == 0) {
                                    n12 = n5;
                                    if (n11 == -65536) {
                                        n12 = 180;
                                    }
                                }
                            }
                        }
                    }
                    return new g(n3, n7, n12);
                }
            }
            final boolean b = true;
            continue;
        }
    }
    
    private static Track z(com.google.android.exoplayer2.extractor.mp4.a.a f, final com.google.android.exoplayer2.extractor.mp4.a.b b, long n, final DrmInitData drmInitData, final boolean b2, final boolean b3) throws ParserException {
        final com.google.android.exoplayer2.extractor.mp4.a.a a = Assertions.e(f.f(1835297121));
        final int d = d(k(Assertions.e(a.g(1751411826)).b));
        final Track track = null;
        if (d == -1) {
            return null;
        }
        final g y = y(Assertions.e(f.g(1953196132)).b);
        final long n2 = -9223372036854775807L;
        if (n == -9223372036854775807L) {
            n = g.a(y);
        }
        final long p6 = p(b.b);
        if (n == -9223372036854775807L) {
            n = n2;
        }
        else {
            n = Util.O0(n, 1000000L, p6);
        }
        final com.google.android.exoplayer2.extractor.mp4.a.a a2 = Assertions.e(Assertions.e(a.f(1835626086)).f(1937007212));
        final Pair<Long, String> m = m(Assertions.e(a.g(1835296868)).b);
        final d w = w(Assertions.e(a2.g(1937011556)).b, g.b(y), g.c(y), (String)m.second, drmInitData, b3);
        long[] array = null;
        long[] array2 = null;
        Label_0265: {
            if (!b2) {
                f = f.f(1701082227);
                if (f != null) {
                    final Pair<long[], long[]> h = h(f);
                    if (h != null) {
                        array = (long[])h.first;
                        array2 = (long[])h.second;
                        break Label_0265;
                    }
                }
            }
            array = null;
            array2 = null;
        }
        Track track2;
        if (w.b == null) {
            track2 = track;
        }
        else {
            track2 = new Track(g.b(y), d, (long)m.first, p6, n, w.b, w.d, w.a, w.c, array, array2);
        }
        return track2;
    }
    
    private static final class a
    {
        public final int a;
        public int b;
        public int c;
        public long d;
        private final boolean e;
        private final ParsableByteArray f;
        private final ParsableByteArray g;
        private int h;
        private int i;
        
        public a(final ParsableByteArray g, final ParsableByteArray f, final boolean e) throws ParserException {
            this.g = g;
            this.f = f;
            this.e = e;
            f.P(12);
            this.a = f.H();
            g.P(12);
            this.i = g.H();
            final int n = g.n();
            boolean b = true;
            if (n != 1) {
                b = false;
            }
            ExtractorUtil.a(b, "first_chunk must be 1");
            this.b = -1;
        }
        
        public boolean a() {
            final int b = this.b + 1;
            this.b = b;
            if (b == this.a) {
                return false;
            }
            long d;
            if (this.e) {
                d = this.f.I();
            }
            else {
                d = this.f.F();
            }
            this.d = d;
            if (this.b == this.h) {
                this.c = this.g.H();
                this.g.Q(4);
                int h;
                if (--this.i > 0) {
                    h = this.g.H() - 1;
                }
                else {
                    h = -1;
                }
                this.h = h;
            }
            return true;
        }
    }
    
    private static final class b
    {
        private final String a;
        private final byte[] b;
        private final long c;
        private final long d;
        
        public b(final String a, final byte[] b, final long c, final long d) {
            this.a = a;
            this.b = b;
            this.c = c;
            this.d = d;
        }
        
        static String a(final b b) {
            return b.a;
        }
        
        static byte[] b(final b b) {
            return b.b;
        }
        
        static long c(final b b) {
            return b.d;
        }
        
        static long d(final b b) {
            return b.c;
        }
    }
    
    private interface c
    {
        int a();
        
        int b();
        
        int c();
    }
    
    private static final class d
    {
        public final TrackEncryptionBox[] a;
        public Format b;
        public int c;
        public int d;
        
        public d(final int n) {
            this.a = new TrackEncryptionBox[n];
            this.d = 0;
        }
    }
    
    static final class e implements c
    {
        private final int a;
        private final int b;
        private final ParsableByteArray c;
        
        public e(final com.google.android.exoplayer2.extractor.mp4.a.b b, final Format format) {
            final ParsableByteArray b2 = b.b;
            (this.c = b2).P(12);
            int h;
            final int n = h = b2.H();
            Label_0118: {
                if ("audio/raw".equals(format.w)) {
                    final int e0 = Util.e0(format.L, format.J);
                    if (n != 0) {
                        h = n;
                        if (n % e0 == 0) {
                            break Label_0118;
                        }
                    }
                    final StringBuilder sb = new StringBuilder();
                    sb.append("Audio sample size mismatch. stsd sample size: ");
                    sb.append(e0);
                    sb.append(", stsz sample size: ");
                    sb.append(n);
                    Log.i("AtomParsers", sb.toString());
                    h = e0;
                }
            }
            int a;
            if ((a = h) == 0) {
                a = -1;
            }
            this.a = a;
            this.b = b2.H();
        }
        
        @Override
        public int a() {
            int n;
            if ((n = this.a) == -1) {
                n = this.c.H();
            }
            return n;
        }
        
        @Override
        public int b() {
            return this.a;
        }
        
        @Override
        public int c() {
            return this.b;
        }
    }
    
    static final class f implements c
    {
        private final ParsableByteArray a;
        private final int b;
        private final int c;
        private int d;
        private int e;
        
        public f(final com.google.android.exoplayer2.extractor.mp4.a.b b) {
            final ParsableByteArray b2 = b.b;
            (this.a = b2).P(12);
            this.c = (b2.H() & 0xFF);
            this.b = b2.H();
        }
        
        @Override
        public int a() {
            final int c = this.c;
            if (c == 8) {
                return this.a.D();
            }
            if (c == 16) {
                return this.a.J();
            }
            if (this.d++ % 2 == 0) {
                return ((this.e = this.a.D()) & 0xF0) >> 4;
            }
            return this.e & 0xF;
        }
        
        @Override
        public int b() {
            return -1;
        }
        
        @Override
        public int c() {
            return this.b;
        }
    }
    
    private static final class g
    {
        private final int a;
        private final long b;
        private final int c;
        
        public g(final int a, final long b, final int c) {
            this.a = a;
            this.b = b;
            this.c = c;
        }
        
        static long a(final g g) {
            return g.b;
        }
        
        static int b(final g g) {
            return g.a;
        }
        
        static int c(final g g) {
            return g.c;
        }
    }
}
