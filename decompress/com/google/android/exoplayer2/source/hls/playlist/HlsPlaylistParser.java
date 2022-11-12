// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.exoplayer2.source.hls.playlist;

import java.util.NoSuchElementException;
import java.util.Queue;
import java.io.Closeable;
import java.util.ArrayDeque;
import java.io.Reader;
import java.io.InputStreamReader;
import java.io.InputStream;
import android.text.TextUtils;
import com.google.android.exoplayer2.util.Log;
import com.google.android.exoplayer2.util.MimeTypes;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.source.hls.HlsTrackMetadataEntry;
import com.google.android.exoplayer2.metadata.Metadata;
import java.util.HashSet;
import com.google.common.collect.Iterables;
import java.util.List;
import android.net.Uri;
import com.google.android.exoplayer2.util.UriUtil;
import com.google.android.exoplayer2.util.Assertions;
import java.util.TreeMap;
import java.util.HashMap;
import java.util.UUID;
import com.google.android.exoplayer2.extractor.mp4.PsshAtomUtil;
import android.util.Base64;
import com.google.android.exoplayer2.C;
import java.util.ArrayList;
import com.google.android.exoplayer2.drm.DrmInitData;
import java.io.IOException;
import com.google.android.exoplayer2.util.Util;
import java.io.BufferedReader;
import java.util.regex.Matcher;
import java.util.Map;
import com.google.android.exoplayer2.ParserException;
import java.math.BigDecimal;
import java.util.Collections;
import java.util.regex.Pattern;
import com.google.android.exoplayer2.upstream.ParsingLoadable;

public final class HlsPlaylistParser implements Parser<HlsPlaylist>
{
    private static final Pattern A;
    private static final Pattern B;
    private static final Pattern C;
    private static final Pattern D;
    private static final Pattern E;
    private static final Pattern F;
    private static final Pattern G;
    private static final Pattern H;
    private static final Pattern I;
    private static final Pattern J;
    private static final Pattern K;
    private static final Pattern L;
    private static final Pattern M;
    private static final Pattern N;
    private static final Pattern O;
    private static final Pattern P;
    private static final Pattern Q;
    private static final Pattern R;
    private static final Pattern S;
    private static final Pattern T;
    private static final Pattern U;
    private static final Pattern V;
    private static final Pattern W;
    private static final Pattern X;
    private static final Pattern Y;
    private static final Pattern Z;
    private static final Pattern a0;
    private static final Pattern b0;
    private static final Pattern c;
    private static final Pattern d;
    private static final Pattern e;
    private static final Pattern f;
    private static final Pattern g;
    private static final Pattern h;
    private static final Pattern i;
    private static final Pattern j;
    private static final Pattern k;
    private static final Pattern l;
    private static final Pattern m;
    private static final Pattern n;
    private static final Pattern o;
    private static final Pattern p;
    private static final Pattern q;
    private static final Pattern r;
    private static final Pattern s;
    private static final Pattern t;
    private static final Pattern u;
    private static final Pattern v;
    private static final Pattern w;
    private static final Pattern x;
    private static final Pattern y;
    private static final Pattern z;
    private final HlsMultivariantPlaylist a;
    private final HlsMediaPlaylist b;
    
    static {
        c = Pattern.compile("AVERAGE-BANDWIDTH=(\\d+)\\b");
        d = Pattern.compile("VIDEO=\"(.+?)\"");
        e = Pattern.compile("AUDIO=\"(.+?)\"");
        f = Pattern.compile("SUBTITLES=\"(.+?)\"");
        g = Pattern.compile("CLOSED-CAPTIONS=\"(.+?)\"");
        h = Pattern.compile("[^-]BANDWIDTH=(\\d+)\\b");
        i = Pattern.compile("CHANNELS=\"(.+?)\"");
        j = Pattern.compile("CODECS=\"(.+?)\"");
        k = Pattern.compile("RESOLUTION=(\\d+x\\d+)");
        l = Pattern.compile("FRAME-RATE=([\\d\\.]+)\\b");
        m = Pattern.compile("#EXT-X-TARGETDURATION:(\\d+)\\b");
        n = Pattern.compile("DURATION=([\\d\\.]+)\\b");
        o = Pattern.compile("PART-TARGET=([\\d\\.]+)\\b");
        p = Pattern.compile("#EXT-X-VERSION:(\\d+)\\b");
        q = Pattern.compile("#EXT-X-PLAYLIST-TYPE:(.+)\\b");
        r = Pattern.compile("CAN-SKIP-UNTIL=([\\d\\.]+)\\b");
        s = c("CAN-SKIP-DATERANGES");
        t = Pattern.compile("SKIPPED-SEGMENTS=(\\d+)\\b");
        u = Pattern.compile("[:|,]HOLD-BACK=([\\d\\.]+)\\b");
        v = Pattern.compile("PART-HOLD-BACK=([\\d\\.]+)\\b");
        w = c("CAN-BLOCK-RELOAD");
        x = Pattern.compile("#EXT-X-MEDIA-SEQUENCE:(\\d+)\\b");
        y = Pattern.compile("#EXTINF:([\\d\\.]+)\\b");
        z = Pattern.compile("#EXTINF:[\\d\\.]+\\b,(.+)");
        A = Pattern.compile("LAST-MSN=(\\d+)\\b");
        B = Pattern.compile("LAST-PART=(\\d+)\\b");
        C = Pattern.compile("TIME-OFFSET=(-?[\\d\\.]+)\\b");
        D = Pattern.compile("#EXT-X-BYTERANGE:(\\d+(?:@\\d+)?)\\b");
        E = Pattern.compile("BYTERANGE=\"(\\d+(?:@\\d+)?)\\b\"");
        F = Pattern.compile("BYTERANGE-START=(\\d+)\\b");
        G = Pattern.compile("BYTERANGE-LENGTH=(\\d+)\\b");
        H = Pattern.compile("METHOD=(NONE|AES-128|SAMPLE-AES|SAMPLE-AES-CENC|SAMPLE-AES-CTR)\\s*(?:,|$)");
        I = Pattern.compile("KEYFORMAT=\"(.+?)\"");
        J = Pattern.compile("KEYFORMATVERSIONS=\"(.+?)\"");
        K = Pattern.compile("URI=\"(.+?)\"");
        L = Pattern.compile("IV=([^,.*]+)");
        M = Pattern.compile("TYPE=(AUDIO|VIDEO|SUBTITLES|CLOSED-CAPTIONS)");
        N = Pattern.compile("TYPE=(PART|MAP)");
        O = Pattern.compile("LANGUAGE=\"(.+?)\"");
        P = Pattern.compile("NAME=\"(.+?)\"");
        Q = Pattern.compile("GROUP-ID=\"(.+?)\"");
        R = Pattern.compile("CHARACTERISTICS=\"(.+?)\"");
        S = Pattern.compile("INSTREAM-ID=\"((?:CC|SERVICE)\\d+)\"");
        T = c("AUTOSELECT");
        U = c("DEFAULT");
        V = c("FORCED");
        W = c("INDEPENDENT");
        X = c("GAP");
        Y = c("PRECISE");
        Z = Pattern.compile("VALUE=\"(.+?)\"");
        a0 = Pattern.compile("IMPORT=\"(.+?)\"");
        b0 = Pattern.compile("\\{\\$([a-zA-Z0-9\\-_]+)\\}");
    }
    
    public HlsPlaylistParser() {
        this(HlsMultivariantPlaylist.n, null);
    }
    
    public HlsPlaylistParser(final HlsMultivariantPlaylist a, final HlsMediaPlaylist b) {
        this.a = a;
        this.b = b;
    }
    
    private static long A(final String s, final Pattern pattern) throws ParserException {
        return new BigDecimal(z(s, pattern, Collections.emptyMap())).multiply(new BigDecimal(1000000L)).longValue();
    }
    
    private static String B(String group, final Map<String, String> map) {
        final Matcher matcher = HlsPlaylistParser.b0.matcher(group);
        final StringBuffer sb = new StringBuffer();
        while (matcher.find()) {
            group = matcher.group(1);
            if (map.containsKey(group)) {
                matcher.appendReplacement(sb, Matcher.quoteReplacement(map.get(group)));
            }
        }
        matcher.appendTail(sb);
        return sb.toString();
    }
    
    private static int C(final BufferedReader bufferedReader, final boolean b, int read) throws IOException {
        while (read != -1 && Character.isWhitespace(read) && (b || !Util.v0(read))) {
            read = bufferedReader.read();
        }
        return read;
    }
    
    private static boolean b(final BufferedReader bufferedReader) throws IOException {
        int n;
        if ((n = bufferedReader.read()) == 239) {
            if (bufferedReader.read() != 187 || bufferedReader.read() != 191) {
                return false;
            }
            n = bufferedReader.read();
        }
        int n2 = C(bufferedReader, true, n);
        for (int i = 0; i < 7; ++i) {
            if (n2 != "#EXTM3U".charAt(i)) {
                return false;
            }
            n2 = bufferedReader.read();
        }
        return Util.v0(C(bufferedReader, false, n2));
    }
    
    private static Pattern c(final String s) {
        final StringBuilder sb = new StringBuilder();
        sb.append(s);
        sb.append("=(");
        sb.append("NO");
        sb.append("|");
        sb.append("YES");
        sb.append(")");
        return Pattern.compile(sb.toString());
    }
    
    private static DrmInitData d(final String s, final DrmInitData.SchemeData[] array) {
        final DrmInitData.SchemeData[] array2 = new DrmInitData.SchemeData[array.length];
        for (int i = 0; i < array.length; ++i) {
            array2[i] = array[i].b(null);
        }
        return new DrmInitData(s, array2);
    }
    
    private static String e(final long n, final String s, final String s2) {
        if (s == null) {
            return null;
        }
        if (s2 != null) {
            return s2;
        }
        return Long.toHexString(n);
    }
    
    private static HlsMultivariantPlaylist.Variant f(final ArrayList<HlsMultivariantPlaylist.Variant> list, final String s) {
        for (int i = 0; i < list.size(); ++i) {
            final HlsMultivariantPlaylist.Variant variant = list.get(i);
            if (s.equals(variant.d)) {
                return variant;
            }
        }
        return null;
    }
    
    private static HlsMultivariantPlaylist.Variant g(final ArrayList<HlsMultivariantPlaylist.Variant> list, final String s) {
        for (int i = 0; i < list.size(); ++i) {
            final HlsMultivariantPlaylist.Variant variant = list.get(i);
            if (s.equals(variant.e)) {
                return variant;
            }
        }
        return null;
    }
    
    private static HlsMultivariantPlaylist.Variant h(final ArrayList<HlsMultivariantPlaylist.Variant> list, final String s) {
        for (int i = 0; i < list.size(); ++i) {
            final HlsMultivariantPlaylist.Variant variant = list.get(i);
            if (s.equals(variant.c)) {
                return variant;
            }
        }
        return null;
    }
    
    private static double j(final String s, final Pattern pattern) throws ParserException {
        return Double.parseDouble(z(s, pattern, Collections.emptyMap()));
    }
    
    private static DrmInitData.SchemeData k(String s, final String s2, final Map<String, String> map) throws ParserException {
        final String u = u(s, HlsPlaylistParser.J, "1", map);
        if ("urn:uuid:edef8ba9-79d6-4ace-a3c8-27dcd51d21ed".equals(s2)) {
            s = z(s, HlsPlaylistParser.K, map);
            return new DrmInitData.SchemeData(com.google.android.exoplayer2.C.d, "video/mp4", Base64.decode(s.substring(s.indexOf(44)), 0));
        }
        if ("com.widevine".equals(s2)) {
            return new DrmInitData.SchemeData(com.google.android.exoplayer2.C.d, "hls", Util.n0(s));
        }
        if ("com.microsoft.playready".equals(s2) && "1".equals(u)) {
            s = z(s, HlsPlaylistParser.K, map);
            final byte[] decode = Base64.decode(s.substring(s.indexOf(44)), 0);
            final UUID e = com.google.android.exoplayer2.C.e;
            return new DrmInitData.SchemeData(e, "video/mp4", PsshAtomUtil.a(e, decode));
        }
        return null;
    }
    
    private static String l(String s) {
        if (!"SAMPLE-AES-CENC".equals(s) && !"SAMPLE-AES-CTR".equals(s)) {
            s = "cbcs";
        }
        else {
            s = "cenc";
        }
        return s;
    }
    
    private static int m(final String s, final Pattern pattern) throws ParserException {
        return Integer.parseInt(z(s, pattern, Collections.emptyMap()));
    }
    
    private static long n(final String s, final Pattern pattern) throws ParserException {
        return Long.parseLong(z(s, pattern, Collections.emptyMap()));
    }
    
    private static HlsMediaPlaylist o(final HlsMultivariantPlaylist hlsMultivariantPlaylist, final HlsMediaPlaylist hlsMediaPlaylist, final a a, final String s) throws IOException {
        HlsMultivariantPlaylist hlsMultivariantPlaylist2 = hlsMultivariantPlaylist;
        HlsMediaPlaylist hlsMediaPlaylist2 = hlsMediaPlaylist;
        boolean c = hlsMultivariantPlaylist2.c;
        final HashMap hashMap = new HashMap();
        final HashMap hashMap2 = new HashMap();
        ArrayList list = new ArrayList();
        ArrayList list2 = new ArrayList();
        final ArrayList list3 = new ArrayList();
        final ArrayList list4 = new ArrayList();
        HlsMediaPlaylist.ServerControl y = new HlsMediaPlaylist.ServerControl(-9223372036854775807L, false, -9223372036854775807L, -9223372036854775807L, false);
        final TreeMap treeMap = new TreeMap();
        final String s2 = "";
        String u = "";
        final int n = 0;
        int q = 0;
        final int n3;
        final int n2 = n3 = q;
        int n5;
        final int n4 = n5 = n3;
        int n6;
        int d = n6 = n5;
        long n7 = 0L;
        long n8 = 0L;
        long n9;
        long long1 = n9 = n8;
        long n11;
        long n10 = n11 = n9;
        long long2;
        long a2 = long2 = n11;
        long n12 = -9223372036854775807L;
        final int n13 = 1;
        long n14 = -9223372036854775807L;
        long n15 = -9223372036854775807L;
        DrmInitData drmInitData = null;
        Object o = null;
        String z = null;
        long n16 = -1L;
        String s3 = null;
        String l = null;
        HlsMediaPlaylist.SegmentBase b = null;
        Object o2 = null;
        int n17 = n4;
        int m = n13;
        int int1 = n3;
        int n18 = n2;
        int n19 = n;
        while (a.a()) {
            final String b2 = a.b();
            if (b2.startsWith("#EXT")) {
                list4.add(b2);
            }
            if (b2.startsWith("#EXT-X-PLAYLIST-TYPE")) {
                final String z2 = z(b2, HlsPlaylistParser.q, hashMap);
                if ("VOD".equals(z2)) {
                    n19 = 1;
                }
                else {
                    if (!"EVENT".equals(z2)) {
                        continue;
                    }
                    n19 = 2;
                }
            }
            else if (b2.equals("#EXT-X-I-FRAMES-ONLY")) {
                n6 = 1;
            }
            else if (b2.startsWith("#EXT-X-START")) {
                n12 = (long)(j(b2, HlsPlaylistParser.C) * 1000000.0);
                q = (q(b2, HlsPlaylistParser.Y, false) ? 1 : 0);
            }
            else {
                final ArrayList list5 = list;
                if (b2.startsWith("#EXT-X-SERVER-CONTROL")) {
                    y = y(b2);
                }
                else if (b2.startsWith("#EXT-X-PART-INF")) {
                    n15 = (long)(j(b2, HlsPlaylistParser.o) * 1000000.0);
                }
                else if (b2.startsWith("#EXT-X-MAP")) {
                    final String z3 = z(b2, HlsPlaylistParser.K, hashMap);
                    final String v = v(b2, HlsPlaylistParser.E, hashMap);
                    long long3 = long1;
                    if (v != null) {
                        final String[] t0 = Util.T0(v, "@");
                        final long long4 = Long.parseLong(t0[0]);
                        long3 = long1;
                        n16 = long4;
                        if (t0.length > 1) {
                            long3 = Long.parseLong(t0[1]);
                            n16 = long4;
                        }
                    }
                    final long n20 = lcmp(n16, -1L);
                    if (n20 == 0) {
                        long3 = 0L;
                    }
                    if (z != null && s3 == null) {
                        throw ParserException.createForMalformedManifest("The encryption IV attribute must be present when an initialization segment is encrypted with METHOD=AES-128.", null);
                    }
                    b = new HlsMediaPlaylist.Segment(z3, long3, n16, z, s3);
                    long1 = long3;
                    if (n20 != 0) {
                        long1 = long3 + n16;
                    }
                    list = list5;
                    n16 = -1L;
                }
                else {
                    String g = z;
                    Label_0637: {
                        if (b2.startsWith("#EXT-X-TARGETDURATION")) {
                            n14 = 1000000L * m(b2, HlsPlaylistParser.m);
                        }
                        else if (b2.startsWith("#EXT-X-MEDIA-SEQUENCE")) {
                            n11 = (n8 = n(b2, HlsPlaylistParser.x));
                        }
                        else {
                            if (!b2.startsWith("#EXT-X-VERSION")) {
                                Label_2660: {
                                    Label_2640: {
                                        if (b2.startsWith("#EXT-X-DEFINE")) {
                                            final String v2 = v(b2, HlsPlaylistParser.a0, hashMap);
                                            if (v2 != null) {
                                                final String s4 = hlsMultivariantPlaylist2.l.get(v2);
                                                if (s4 != null) {
                                                    hashMap.put(v2, s4);
                                                }
                                            }
                                            else {
                                                hashMap.put(z(b2, HlsPlaylistParser.P, hashMap), z(b2, HlsPlaylistParser.Z, hashMap));
                                            }
                                        }
                                        else {
                                            if (b2.startsWith("#EXTINF")) {
                                                a2 = A(b2, HlsPlaylistParser.y);
                                                u = u(b2, HlsPlaylistParser.z, s2, hashMap);
                                                break Label_0637;
                                            }
                                            if (b2.startsWith("#EXT-X-SKIP")) {
                                                final int i = m(b2, HlsPlaylistParser.t);
                                                Assertions.g(hlsMediaPlaylist2 != null && list5.isEmpty());
                                                int j = (int)(n8 - Util.j(hlsMediaPlaylist).k);
                                                final int n21 = i + j;
                                                if (j >= 0 && n21 <= hlsMediaPlaylist2.r.size()) {
                                                    while (j < n21) {
                                                        HlsMediaPlaylist.SegmentBase c2;
                                                        final HlsMediaPlaylist.Segment segment = (HlsMediaPlaylist.Segment)(c2 = hlsMediaPlaylist2.r.get(j));
                                                        if (n8 != hlsMediaPlaylist2.k) {
                                                            c2 = segment.c(n10, hlsMediaPlaylist2.j - int1 + segment.d);
                                                        }
                                                        list5.add(c2);
                                                        final long c3 = c2.c;
                                                        final long k = c2.j;
                                                        if (k != -1L) {
                                                            long1 = c2.i + k;
                                                        }
                                                        d = c2.d;
                                                        b = c2.b;
                                                        final DrmInitData f = c2.f;
                                                        g = c2.g;
                                                        final String h = c2.h;
                                                        if (h == null || !h.equals(Long.toHexString(n11))) {
                                                            s3 = c2.h;
                                                        }
                                                        ++n11;
                                                        ++j;
                                                        o = f;
                                                        n10 = (n9 = n10 + c3);
                                                        hlsMediaPlaylist2 = hlsMediaPlaylist;
                                                    }
                                                    hlsMultivariantPlaylist2 = hlsMultivariantPlaylist;
                                                    hlsMediaPlaylist2 = hlsMediaPlaylist;
                                                    z = g;
                                                    list = list5;
                                                    continue;
                                                }
                                                throw new DeltaUpdateException();
                                            }
                                            else {
                                                if (b2.startsWith("#EXT-X-KEY")) {
                                                    final String z4 = z(b2, HlsPlaylistParser.H, hashMap);
                                                    final String u2 = u(b2, HlsPlaylistParser.I, "identity", hashMap);
                                                    Label_1324: {
                                                        if ("NONE".equals(z4)) {
                                                            treeMap.clear();
                                                            z = null;
                                                            o = (s3 = null);
                                                        }
                                                        else {
                                                            s3 = v(b2, HlsPlaylistParser.L, hashMap);
                                                            String s5;
                                                            if ("identity".equals(u2)) {
                                                                s5 = l;
                                                                if ("AES-128".equals(z4)) {
                                                                    z = z(b2, HlsPlaylistParser.K, hashMap);
                                                                    break Label_1324;
                                                                }
                                                            }
                                                            else {
                                                                if (l == null) {
                                                                    l = l(z4);
                                                                }
                                                                final DrmInitData.SchemeData k2 = k(b2, u2, hashMap);
                                                                s5 = l;
                                                                if (k2 != null) {
                                                                    treeMap.put(u2, k2);
                                                                    z = null;
                                                                    o = null;
                                                                    break Label_1324;
                                                                }
                                                            }
                                                            z = null;
                                                            l = s5;
                                                        }
                                                    }
                                                    break Label_2660;
                                                }
                                                Label_1461: {
                                                    long n22 = 0L;
                                                    int n23 = 0;
                                                    Label_1417: {
                                                        if (b2.startsWith("#EXT-X-BYTERANGE")) {
                                                            final String[] t2 = Util.T0(z(b2, HlsPlaylistParser.D, hashMap), "@");
                                                            final long long5 = Long.parseLong(t2[0]);
                                                            n22 = n7;
                                                            n16 = long5;
                                                            n23 = d;
                                                            if (t2.length > 1) {
                                                                long1 = Long.parseLong(t2[1]);
                                                                n23 = d;
                                                                n16 = long5;
                                                                n22 = n7;
                                                            }
                                                        }
                                                        else {
                                                            if (b2.startsWith("#EXT-X-DISCONTINUITY-SEQUENCE")) {
                                                                int1 = Integer.parseInt(b2.substring(b2.indexOf(58) + 1));
                                                                n18 = 1;
                                                                break Label_1461;
                                                            }
                                                            if (!b2.equals("#EXT-X-DISCONTINUITY")) {
                                                                if (b2.startsWith("#EXT-X-PROGRAM-DATE-TIME")) {
                                                                    if (n7 == 0L) {
                                                                        n22 = Util.C0(Util.J0(b2.substring(b2.indexOf(58) + 1))) - n10;
                                                                        n23 = d;
                                                                        break Label_1417;
                                                                    }
                                                                }
                                                                else {
                                                                    if (b2.equals("#EXT-X-GAP")) {
                                                                        n5 = 1;
                                                                        break Label_1461;
                                                                    }
                                                                    if (b2.equals("#EXT-X-INDEPENDENT-SEGMENTS")) {
                                                                        c = true;
                                                                        break Label_1461;
                                                                    }
                                                                    if (b2.equals("#EXT-X-ENDLIST")) {
                                                                        n17 = 1;
                                                                        break Label_1461;
                                                                    }
                                                                    if (b2.startsWith("#EXT-X-RENDITION-REPORT")) {
                                                                        list3.add(new HlsMediaPlaylist.RenditionReport(Uri.parse(UriUtil.d(s, z(b2, HlsPlaylistParser.K, hashMap))), t(b2, HlsPlaylistParser.A, -1L), s(b2, HlsPlaylistParser.B, -1)));
                                                                    }
                                                                    else if (b2.startsWith("#EXT-X-PRELOAD-HINT")) {
                                                                        if (o2 == null && "PART".equals(z(b2, HlsPlaylistParser.N, hashMap))) {
                                                                            final String z5 = z(b2, HlsPlaylistParser.K, hashMap);
                                                                            long t3 = t(b2, HlsPlaylistParser.F, -1L);
                                                                            final long t4 = t(b2, HlsPlaylistParser.G, -1L);
                                                                            final String e = e(n11, g, s3);
                                                                            DrmInitData d2 = drmInitData;
                                                                            DrmInitData drmInitData2;
                                                                            if ((drmInitData2 = (DrmInitData)o) == null) {
                                                                                d2 = drmInitData;
                                                                                drmInitData2 = (DrmInitData)o;
                                                                                if (!treeMap.isEmpty()) {
                                                                                    final DrmInitData.SchemeData[] array = (DrmInitData.SchemeData[])treeMap.values().toArray(new DrmInitData.SchemeData[0]);
                                                                                    drmInitData2 = new DrmInitData(l, array);
                                                                                    if ((d2 = drmInitData) == null) {
                                                                                        d2 = d(l, array);
                                                                                    }
                                                                                }
                                                                            }
                                                                            final long n24 = lcmp(t3, -1L);
                                                                            if (n24 == 0 || t4 != -1L) {
                                                                                if (n24 == 0) {
                                                                                    t3 = 0L;
                                                                                }
                                                                                o2 = new HlsMediaPlaylist.Part(z5, (HlsMediaPlaylist.Segment)b, 0L, d, n9, drmInitData2, g, e, t3, t4, false, false, true);
                                                                            }
                                                                            drmInitData = d2;
                                                                            o = drmInitData2;
                                                                            break Label_1461;
                                                                        }
                                                                    }
                                                                    else {
                                                                        if (b2.startsWith("#EXT-X-PART")) {
                                                                            final String e2 = e(n11, g, s3);
                                                                            final String z6 = z(b2, HlsPlaylistParser.K, hashMap);
                                                                            final long n25 = (long)(j(b2, HlsPlaylistParser.n) * 1000000.0);
                                                                            final boolean q2 = q(b2, HlsPlaylistParser.W, false);
                                                                            final boolean b3 = c && list2.isEmpty();
                                                                            final boolean q3 = q(b2, HlsPlaylistParser.X, false);
                                                                            final String v3 = v(b2, HlsPlaylistParser.E, hashMap);
                                                                            long n26;
                                                                            if (v3 != null) {
                                                                                final String[] t5 = Util.T0(v3, "@");
                                                                                final long long6 = Long.parseLong(t5[0]);
                                                                                final int length = t5.length;
                                                                                n26 = long6;
                                                                                if (length > 1) {
                                                                                    long2 = Long.parseLong(t5[1]);
                                                                                    n26 = long6;
                                                                                }
                                                                            }
                                                                            else {
                                                                                n26 = -1L;
                                                                            }
                                                                            final long n27 = lcmp(n26, -1L);
                                                                            long n28 = long2;
                                                                            if (n27 == 0) {
                                                                                n28 = 0L;
                                                                            }
                                                                            DrmInitData d3 = drmInitData;
                                                                            DrmInitData drmInitData3;
                                                                            if ((drmInitData3 = (DrmInitData)o) == null) {
                                                                                d3 = drmInitData;
                                                                                drmInitData3 = (DrmInitData)o;
                                                                                if (!treeMap.isEmpty()) {
                                                                                    final DrmInitData.SchemeData[] array2 = (DrmInitData.SchemeData[])treeMap.values().toArray(new DrmInitData.SchemeData[0]);
                                                                                    drmInitData3 = new DrmInitData(l, array2);
                                                                                    if ((d3 = drmInitData) == null) {
                                                                                        d3 = d(l, array2);
                                                                                    }
                                                                                }
                                                                            }
                                                                            list2.add(new HlsMediaPlaylist.Part(z6, (HlsMediaPlaylist.Segment)b, n25, d, n9, drmInitData3, g, e2, n28, n26, q3, q2 | b3, false));
                                                                            n9 += n25;
                                                                            long2 = n28;
                                                                            if (n27 != 0) {
                                                                                long2 = n28 + n26;
                                                                            }
                                                                            hlsMultivariantPlaylist2 = hlsMultivariantPlaylist;
                                                                            hlsMediaPlaylist2 = hlsMediaPlaylist;
                                                                            list = list5;
                                                                            drmInitData = d3;
                                                                            o = drmInitData3;
                                                                            z = g;
                                                                            continue;
                                                                        }
                                                                        final int n29 = n19;
                                                                        if (!b2.startsWith("#")) {
                                                                            final String e3 = e(n11, g, s3);
                                                                            final long n30 = n11 + 1L;
                                                                            final String b4 = B(b2, hashMap);
                                                                            final HlsMediaPlaylist.Segment segment2 = hashMap2.get(b4);
                                                                            final long n31 = lcmp(n16, -1L);
                                                                            long n32;
                                                                            HlsMediaPlaylist.SegmentBase segmentBase;
                                                                            if (n31 == 0) {
                                                                                n32 = 0L;
                                                                                segmentBase = segment2;
                                                                            }
                                                                            else {
                                                                                segmentBase = segment2;
                                                                                if (n6 != 0) {
                                                                                    segmentBase = segment2;
                                                                                    if (b == null && (segmentBase = segment2) == null) {
                                                                                        segmentBase = new HlsMediaPlaylist.Segment(b4, 0L, long1, null, null);
                                                                                        hashMap2.put(b4, segmentBase);
                                                                                    }
                                                                                }
                                                                                n32 = long1;
                                                                            }
                                                                            DrmInitData d4;
                                                                            if (o == null && !treeMap.isEmpty()) {
                                                                                final DrmInitData.SchemeData[] array3 = (DrmInitData.SchemeData[])treeMap.values().toArray(new DrmInitData.SchemeData[0]);
                                                                                final DrmInitData drmInitData4 = (DrmInitData)(o = new DrmInitData(l, array3));
                                                                                if ((d4 = drmInitData) == null) {
                                                                                    d4 = d(l, array3);
                                                                                    o = drmInitData4;
                                                                                }
                                                                            }
                                                                            else {
                                                                                d4 = drmInitData;
                                                                            }
                                                                            if (b != null) {
                                                                                segmentBase = b;
                                                                            }
                                                                            list5.add(new HlsMediaPlaylist.Segment(b4, (HlsMediaPlaylist.Segment)segmentBase, u, a2, d, n10, (DrmInitData)o, g, e3, n32, n16, (boolean)(n5 != 0), list2));
                                                                            n9 = n10 + a2;
                                                                            list2 = new ArrayList();
                                                                            long1 = n32;
                                                                            if (n31 != 0) {
                                                                                long1 = n32 + n16;
                                                                            }
                                                                            n5 = (false ? 1 : 0);
                                                                            a2 = 0L;
                                                                            n10 = n9;
                                                                            n11 = n30;
                                                                            n19 = n29;
                                                                            u = s2;
                                                                            n16 = -1L;
                                                                            hlsMultivariantPlaylist2 = hlsMultivariantPlaylist;
                                                                            list = list5;
                                                                            hlsMediaPlaylist2 = hlsMediaPlaylist;
                                                                            drmInitData = d4;
                                                                            z = g;
                                                                            continue;
                                                                        }
                                                                    }
                                                                }
                                                                break Label_2640;
                                                            }
                                                            n23 = d + 1;
                                                            n22 = n7;
                                                        }
                                                    }
                                                    n7 = n22;
                                                    d = n23;
                                                }
                                                hlsMediaPlaylist2 = hlsMediaPlaylist;
                                                hlsMultivariantPlaylist2 = hlsMultivariantPlaylist;
                                                list = list5;
                                                continue;
                                            }
                                        }
                                    }
                                    z = g;
                                }
                                hlsMediaPlaylist2 = hlsMediaPlaylist;
                                hlsMultivariantPlaylist2 = hlsMultivariantPlaylist;
                                continue;
                            }
                            m = m(b2, HlsPlaylistParser.p);
                        }
                    }
                    list = list5;
                }
            }
        }
        final HashMap<Uri, HlsMediaPlaylist.RenditionReport> hashMap3 = new HashMap<Uri, HlsMediaPlaylist.RenditionReport>();
        for (int n33 = 0; n33 < list3.size(); ++n33) {
            final HlsMediaPlaylist.RenditionReport renditionReport = (HlsMediaPlaylist.RenditionReport)list3.get(n33);
            long b5;
            if ((b5 = renditionReport.b) == -1L) {
                b5 = n8 + list.size() - (list2.isEmpty() ? 1 : 0);
            }
            int c4 = renditionReport.c;
            if (c4 == -1) {
                if (n15 != -9223372036854775807L) {
                    List<HlsMediaPlaylist.Part> x;
                    if (list2.isEmpty()) {
                        x = ((HlsMediaPlaylist.Segment)Iterables.h((Iterable)list)).x;
                    }
                    else {
                        x = list2;
                    }
                    c4 = x.size() - 1;
                }
            }
            final Uri a3 = renditionReport.a;
            hashMap3.put(a3, new HlsMediaPlaylist.RenditionReport(a3, b5, c4));
        }
        if (o2 != null) {
            list2.add(o2);
        }
        return new HlsMediaPlaylist(n19, s, list4, n12, (boolean)(q != 0), n7, (boolean)(n18 != 0), int1, n8, m, n14, n15, c, (boolean)(n17 != 0), n7 != 0L, drmInitData, list, list2, y, hashMap3);
    }
    
    private static HlsMultivariantPlaylist p(final a a, final String s) throws IOException {
        final HashMap hashMap = new HashMap();
        final HashMap hashMap2 = new HashMap();
        final ArrayList list = new ArrayList();
        final ArrayList list2 = new ArrayList();
        final ArrayList list3 = new ArrayList();
        final ArrayList list4 = new ArrayList();
        final ArrayList list5 = new ArrayList();
        final ArrayList list6 = new ArrayList();
        final ArrayList list7 = new ArrayList();
        final ArrayList list8 = new ArrayList();
        boolean b = false;
        int n = 0;
        while (true) {
            final boolean a2 = a.a();
            final String s2 = "application/x-mpegURL";
            if (!a2) {
                final ArrayList list9 = list6;
                final ArrayList list10 = list3;
                final ArrayList<HlsMultivariantPlaylist.Variant> list11 = new ArrayList<HlsMultivariantPlaylist.Variant>();
                final HashSet<Uri> set = new HashSet<Uri>();
                for (int i = 0; i < list.size(); ++i) {
                    final HlsMultivariantPlaylist.Variant variant = list.get(i);
                    if (set.add(variant.a)) {
                        Assertions.g(variant.b.j == null);
                        list11.add(variant.a(variant.b.b().X(new Metadata(new Metadata.Entry[] { new HlsTrackMetadataEntry(null, null, Assertions.e(hashMap.get(variant.a))) })).E()));
                    }
                }
                final List list12 = null;
                final Format format = null;
                int j = 0;
                ArrayList list13 = list9;
                final ArrayList list14 = list4;
                Format e = format;
                List<Format> emptyList = list12;
                while (j < list13.size()) {
                    final String s3 = list13.get(j);
                    final String z = z(s3, HlsPlaylistParser.Q, hashMap2);
                    final String z2 = z(s3, HlsPlaylistParser.P, hashMap2);
                    final Format.Builder builder = new Format.Builder();
                    final StringBuilder sb = new StringBuilder();
                    sb.append(z);
                    sb.append(":");
                    sb.append(z2);
                    final Format.Builder v = builder.S(sb.toString()).U(z2).K(s2).g0(x(s3)).c0(w(s3, hashMap2)).V(v(s3, HlsPlaylistParser.O, hashMap2));
                    final String v2 = v(s3, HlsPlaylistParser.K, hashMap2);
                    Uri e2;
                    if (v2 == null) {
                        e2 = null;
                    }
                    else {
                        e2 = UriUtil.e(s, v2);
                    }
                    final ArrayList list15 = list13;
                    final Metadata metadata = new Metadata(new Metadata.Entry[] { new HlsTrackMetadataEntry(z, z2, Collections.emptyList()) });
                    final String z3 = z(s3, HlsPlaylistParser.M, hashMap2);
                    z3.hashCode();
                    int n2 = 0;
                    Label_1286: {
                        switch (z3) {
                            case "VIDEO": {
                                n2 = 3;
                                break Label_1286;
                            }
                            case "AUDIO": {
                                n2 = 2;
                                break Label_1286;
                            }
                            case "CLOSED-CAPTIONS": {
                                n2 = 1;
                                break Label_1286;
                            }
                            case "SUBTITLES": {
                                n2 = 0;
                                break Label_1286;
                            }
                            default:
                                break;
                        }
                        n2 = -1;
                    }
                    Label_1867: {
                        List<Format> list16 = null;
                        Label_1744: {
                            switch (n2) {
                                case 3: {
                                    final HlsMultivariantPlaylist.Variant h = h(list, z);
                                    if (h != null) {
                                        final Format b2 = h.b;
                                        final String l = Util.L(b2.i, 2);
                                        v.I(l).e0(MimeTypes.g(l)).j0(b2.B).Q(b2.C).P(b2.D);
                                    }
                                    if (e2 == null) {
                                        break;
                                    }
                                    v.X(metadata);
                                    list2.add(new HlsMultivariantPlaylist.Rendition(e2, v.E(), z, z2));
                                    break;
                                }
                                case 2: {
                                    final HlsMultivariantPlaylist.Variant f = f(list, z);
                                    String g;
                                    if (f != null) {
                                        final String k = Util.L(f.b.i, 1);
                                        v.I(k);
                                        g = MimeTypes.g(k);
                                    }
                                    else {
                                        g = null;
                                    }
                                    final String v3 = v(s3, HlsPlaylistParser.i, hashMap2);
                                    String s4;
                                    if (v3 != null) {
                                        v.H(Integer.parseInt(Util.U0(v3, "/")[0]));
                                        s4 = g;
                                        if ("audio/eac3".equals(g)) {
                                            s4 = g;
                                            if (v3.endsWith("/JOC")) {
                                                v.I("ec+3");
                                                s4 = "audio/eac3-joc";
                                            }
                                        }
                                    }
                                    else {
                                        s4 = g;
                                    }
                                    v.e0(s4);
                                    if (e2 != null) {
                                        v.X(metadata);
                                        list10.add(new HlsMultivariantPlaylist.Rendition(e2, v.E(), z, z2));
                                        list16 = emptyList;
                                        break Label_1744;
                                    }
                                    list16 = emptyList;
                                    if (f != null) {
                                        e = v.E();
                                        list16 = emptyList;
                                    }
                                    break Label_1744;
                                }
                                case 1: {
                                    final String z4 = z(s3, HlsPlaylistParser.S, hashMap2);
                                    int n3;
                                    String s5;
                                    if (z4.startsWith("CC")) {
                                        n3 = Integer.parseInt(z4.substring(2));
                                        s5 = "application/cea-608";
                                    }
                                    else {
                                        n3 = Integer.parseInt(z4.substring(7));
                                        s5 = "application/cea-708";
                                    }
                                    list16 = emptyList;
                                    if (emptyList == null) {
                                        list16 = new ArrayList<Format>();
                                    }
                                    v.e0(s5).F(n3);
                                    list16.add(v.E());
                                    break Label_1744;
                                }
                                case 0: {
                                    final Format format2 = e;
                                    final HlsMultivariantPlaylist.Variant g2 = g(list, z);
                                    String g3;
                                    if (g2 != null) {
                                        final String m = Util.L(g2.b.i, 3);
                                        v.I(m);
                                        g3 = MimeTypes.g(m);
                                    }
                                    else {
                                        g3 = null;
                                    }
                                    String s6 = g3;
                                    if (g3 == null) {
                                        s6 = "text/vtt";
                                    }
                                    v.e0(s6).X(metadata);
                                    if (e2 != null) {
                                        list14.add(new HlsMultivariantPlaylist.Rendition(e2, v.E(), z, z2));
                                        e = format2;
                                        break;
                                    }
                                    Log.i("HlsPlaylistParser", "EXT-X-MEDIA tag with missing mandatory URI attribute: skipping");
                                    e = format2;
                                    break;
                                }
                            }
                            break Label_1867;
                        }
                        emptyList = list16;
                    }
                    ++j;
                    list13 = list15;
                }
                if (n != 0) {
                    emptyList = Collections.emptyList();
                }
                return new HlsMultivariantPlaylist(s, list8, list11, list2, list10, list14, list5, e, emptyList, b, hashMap2, list7);
            }
            final String b3 = a.b();
            if (b3.startsWith("#EXT")) {
                list8.add(b3);
            }
            final boolean startsWith = b3.startsWith("#EXT-X-I-FRAME-STREAM-INF");
            int n4 = 0;
            Label_0733: {
                if (b3.startsWith("#EXT-X-DEFINE")) {
                    hashMap2.put(z(b3, HlsPlaylistParser.P, hashMap2), z(b3, HlsPlaylistParser.Z, hashMap2));
                }
                else {
                    if (b3.equals("#EXT-X-INDEPENDENT-SEGMENTS")) {
                        b = true;
                        n4 = n;
                        break Label_0733;
                    }
                    if (b3.startsWith("#EXT-X-MEDIA")) {
                        list6.add(b3);
                    }
                    else if (b3.startsWith("#EXT-X-SESSION-KEY")) {
                        final DrmInitData.SchemeData k2 = k(b3, u(b3, HlsPlaylistParser.I, "identity", hashMap2), hashMap2);
                        if (k2 != null) {
                            list7.add(new DrmInitData(l(z(b3, HlsPlaylistParser.H, hashMap2)), new DrmInitData.SchemeData[] { k2 }));
                        }
                    }
                    else if (b3.startsWith("#EXT-X-STREAM-INF") || startsWith) {
                        final boolean b4 = (n | (b3.contains("CLOSED-CAPTIONS=NONE") ? 1 : 0)) != 0x0;
                        int n5;
                        if (startsWith) {
                            n5 = 16384;
                        }
                        else {
                            n5 = 0;
                        }
                        final int m2 = m(b3, HlsPlaylistParser.h);
                        final int s7 = s(b3, HlsPlaylistParser.c, -1);
                        final String v4 = v(b3, HlsPlaylistParser.j, hashMap2);
                        final String v5 = v(b3, HlsPlaylistParser.k, hashMap2);
                        int int1;
                        int int2;
                        if (v5 != null) {
                            final String[] t0 = Util.T0(v5, "x");
                            int1 = Integer.parseInt(t0[0]);
                            int2 = Integer.parseInt(t0[1]);
                            if (int1 <= 0 || int2 <= 0) {
                                int2 = -1;
                                int1 = -1;
                            }
                        }
                        else {
                            int1 = -1;
                            int2 = -1;
                        }
                        float float1 = -1.0f;
                        final String v6 = v(b3, HlsPlaylistParser.l, hashMap2);
                        if (v6 != null) {
                            float1 = Float.parseFloat(v6);
                        }
                        final String v7 = v(b3, HlsPlaylistParser.d, hashMap2);
                        final String v8 = v(b3, HlsPlaylistParser.e, hashMap2);
                        final String v9 = v(b3, HlsPlaylistParser.f, hashMap2);
                        final String v10 = v(b3, HlsPlaylistParser.g, hashMap2);
                        Uri uri;
                        if (startsWith) {
                            uri = UriUtil.e(s, z(b3, HlsPlaylistParser.K, hashMap2));
                        }
                        else {
                            if (!a.a()) {
                                throw ParserException.createForMalformedManifest("#EXT-X-STREAM-INF must be followed by another line", null);
                            }
                            uri = UriUtil.e(s, B(a.b(), hashMap2));
                        }
                        list.add(new HlsMultivariantPlaylist.Variant(uri, new Format.Builder().R(list.size()).K("application/x-mpegURL").I(v4).G(s7).Z(m2).j0(int1).Q(int2).P(float1).c0(n5).E(), v7, v8, v9, v10));
                        ArrayList list17;
                        if ((list17 = hashMap.get(uri)) == null) {
                            list17 = new ArrayList();
                            hashMap.put(uri, list17);
                        }
                        list17.add(new HlsTrackMetadataEntry.VariantInfo(s7, m2, v7, v8, v9, v10));
                        n4 = (b4 ? 1 : 0);
                        break Label_0733;
                    }
                }
                n4 = n;
            }
            n = n4;
        }
    }
    
    private static boolean q(final String s, final Pattern pattern, final boolean b) {
        final Matcher matcher = pattern.matcher(s);
        if (matcher.find()) {
            return "YES".equals(matcher.group(1));
        }
        return b;
    }
    
    private static double r(final String s, final Pattern pattern, final double n) {
        final Matcher matcher = pattern.matcher(s);
        if (matcher.find()) {
            return Double.parseDouble(Assertions.e(matcher.group(1)));
        }
        return n;
    }
    
    private static int s(final String s, final Pattern pattern, final int n) {
        final Matcher matcher = pattern.matcher(s);
        if (matcher.find()) {
            return Integer.parseInt(Assertions.e(matcher.group(1)));
        }
        return n;
    }
    
    private static long t(final String s, final Pattern pattern, final long n) {
        final Matcher matcher = pattern.matcher(s);
        if (matcher.find()) {
            return Long.parseLong(Assertions.e(matcher.group(1)));
        }
        return n;
    }
    
    private static String u(String b, final Pattern pattern, String s, final Map<String, String> map) {
        final Matcher matcher = pattern.matcher(b);
        if (matcher.find()) {
            s = Assertions.e(matcher.group(1));
        }
        b = s;
        if (!map.isEmpty()) {
            if (s == null) {
                b = s;
            }
            else {
                b = B(s, map);
            }
        }
        return b;
    }
    
    private static String v(final String s, final Pattern pattern, final Map<String, String> map) {
        return u(s, pattern, null, map);
    }
    
    private static int w(String v, final Map<String, String> map) {
        v = v(v, HlsPlaylistParser.R, map);
        final boolean empty = TextUtils.isEmpty((CharSequence)v);
        int n = 0;
        if (empty) {
            return 0;
        }
        final String[] t0 = Util.T0(v, ",");
        if (Util.s(t0, "public.accessibility.describes-video")) {
            n = 512;
        }
        int n2 = n;
        if (Util.s(t0, "public.accessibility.transcribes-spoken-dialog")) {
            n2 = (n | 0x1000);
        }
        int n3 = n2;
        if (Util.s(t0, "public.accessibility.describes-music-and-sound")) {
            n3 = (n2 | 0x400);
        }
        int n4 = n3;
        if (Util.s(t0, "public.easy-to-read")) {
            n4 = (n3 | 0x2000);
        }
        return n4;
    }
    
    private static int x(final String s) {
        int q;
        final boolean b = (q = (q(s, HlsPlaylistParser.U, (boolean)(0 != 0)) ? 1 : 0)) != 0;
        if (q(s, HlsPlaylistParser.V, false)) {
            q = ((b ? 1 : 0) | 0x2);
        }
        int n = q;
        if (q(s, HlsPlaylistParser.T, false)) {
            n = (q | 0x4);
        }
        return n;
    }
    
    private static HlsMediaPlaylist.ServerControl y(final String s) {
        final double r = r(s, HlsPlaylistParser.r, -9.223372036854776E18);
        long n = -9223372036854775807L;
        long n2;
        if (r == -9.223372036854776E18) {
            n2 = -9223372036854775807L;
        }
        else {
            n2 = (long)(r * 1000000.0);
        }
        final boolean q = q(s, HlsPlaylistParser.s, false);
        final double r2 = r(s, HlsPlaylistParser.u, -9.223372036854776E18);
        long n3;
        if (r2 == -9.223372036854776E18) {
            n3 = -9223372036854775807L;
        }
        else {
            n3 = (long)(r2 * 1000000.0);
        }
        final double r3 = r(s, HlsPlaylistParser.v, -9.223372036854776E18);
        if (r3 != -9.223372036854776E18) {
            n = (long)(r3 * 1000000.0);
        }
        return new HlsMediaPlaylist.ServerControl(n2, q, n3, n, q(s, HlsPlaylistParser.w, false));
    }
    
    private static String z(final String s, final Pattern pattern, final Map<String, String> map) throws ParserException {
        final String v = v(s, pattern, map);
        if (v != null) {
            return v;
        }
        final StringBuilder sb = new StringBuilder();
        sb.append("Couldn't match ");
        sb.append(pattern.pattern());
        sb.append(" in ");
        sb.append(s);
        throw ParserException.createForMalformedManifest(sb.toString(), null);
    }
    
    @Override
    public /* bridge */ Object a(final Uri uri, final InputStream inputStream) throws IOException {
        return this.i(uri, inputStream);
    }
    
    public HlsPlaylist i(final Uri uri, InputStream inputStream) throws IOException {
        inputStream = (InputStream)new BufferedReader(new InputStreamReader(inputStream));
        final ArrayDeque arrayDeque = new ArrayDeque();
        try {
            if (!b((BufferedReader)inputStream)) {
                throw ParserException.createForMalformedManifest("Input does not start with the #EXTM3U header.", null);
            }
            while (true) {
                final String line = ((BufferedReader)inputStream).readLine();
                if (line == null) {
                    Util.n(inputStream);
                    throw ParserException.createForMalformedManifest("Failed to parse the playlist, could not identify any tags.", null);
                }
                final String trim = line.trim();
                if (trim.isEmpty()) {
                    continue;
                }
                if (trim.startsWith("#EXT-X-STREAM-INF")) {
                    arrayDeque.add(trim);
                    return p(new a(arrayDeque, (BufferedReader)inputStream), uri.toString());
                }
                if (trim.startsWith("#EXT-X-TARGETDURATION") || trim.startsWith("#EXT-X-MEDIA-SEQUENCE") || trim.startsWith("#EXTINF") || trim.startsWith("#EXT-X-KEY") || trim.startsWith("#EXT-X-BYTERANGE") || trim.equals("#EXT-X-DISCONTINUITY") || trim.equals("#EXT-X-DISCONTINUITY-SEQUENCE") || trim.equals("#EXT-X-ENDLIST")) {
                    arrayDeque.add(trim);
                    return o(this.a, this.b, new a(arrayDeque, (BufferedReader)inputStream), uri.toString());
                }
                arrayDeque.add(trim);
            }
        }
        finally {
            Util.n(inputStream);
        }
    }
    
    public static final class DeltaUpdateException extends IOException
    {
    }
    
    private static class a
    {
        private final BufferedReader a;
        private final Queue<String> b;
        private String c;
        
        public a(final Queue<String> b, final BufferedReader a) {
            this.b = b;
            this.a = a;
        }
        
        public boolean a() throws IOException {
            if (this.c != null) {
                return true;
            }
            if (!this.b.isEmpty()) {
                this.c = Assertions.e(this.b.poll());
                return true;
            }
            String trim;
            do {
                final String line = this.a.readLine();
                if ((this.c = line) == null) {
                    return false;
                }
                trim = line.trim();
                this.c = trim;
            } while (trim.isEmpty());
            return true;
        }
        
        public String b() throws IOException {
            if (this.a()) {
                final String c = this.c;
                this.c = null;
                return c;
            }
            throw new NoSuchElementException();
        }
    }
}
