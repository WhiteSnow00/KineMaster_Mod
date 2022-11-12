// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.exoplayer2.source.rtsp;

import android.util.Pair;
import com.google.android.exoplayer2.util.CodecSpecificDataUtil;
import java.util.List;
import com.google.common.collect.ImmutableList;
import com.google.android.exoplayer2.audio.AacUtil;
import com.google.android.exoplayer2.util.NalUnitUtil;
import android.util.Base64;
import com.google.common.collect.ImmutableMap;
import java.util.Map;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.util.Util;
import com.google.android.exoplayer2.util.Assertions;
import android.net.Uri;

final class l
{
    public final RtpPayloadFormat a;
    public final Uri b;
    
    public l(final MediaDescription mediaDescription, final Uri uri) {
        Assertions.a(mediaDescription.i.containsKey((Object)"control"));
        this.a = b(mediaDescription);
        this.b = a(uri, Util.j(mediaDescription.i.get((Object)"control")));
    }
    
    private static Uri a(final Uri uri, final String s) {
        final Uri parse = Uri.parse(s);
        if (parse.isAbsolute()) {
            return parse;
        }
        if (s.equals("*")) {
            return uri;
        }
        return uri.buildUpon().appendEncodedPath(s).build();
    }
    
    static RtpPayloadFormat b(final MediaDescription mediaDescription) {
        final Format.Builder builder = new Format.Builder();
        final int e = mediaDescription.e;
        if (e > 0) {
            builder.G(e);
        }
        final MediaDescription.RtpMapAttribute j = mediaDescription.j;
        final int a = j.a;
        final String b = j.b;
        final String a2 = RtpPayloadFormat.a(b);
        builder.e0(a2);
        final int c = mediaDescription.j.c;
        int d;
        if ("audio".equals(mediaDescription.a)) {
            d = d(mediaDescription.j.d, a2);
            builder.f0(c).H(d);
        }
        else {
            d = -1;
        }
        final ImmutableMap<String, String> a3 = mediaDescription.a();
        final int hashCode = a2.hashCode();
        final boolean b2 = false;
        int n = 0;
        Label_0471: {
            switch (hashCode) {
                case 1903589369: {
                    if (a2.equals("audio/g711-mlaw")) {
                        n = 13;
                        break Label_0471;
                    }
                    break;
                }
                case 1903231877: {
                    if (a2.equals("audio/g711-alaw")) {
                        n = 12;
                        break Label_0471;
                    }
                    break;
                }
                case 1599127257: {
                    if (a2.equals("video/x-vnd.on2.vp9")) {
                        n = 9;
                        break Label_0471;
                    }
                    break;
                }
                case 1599127256: {
                    if (a2.equals("video/x-vnd.on2.vp8")) {
                        n = 8;
                        break Label_0471;
                    }
                    break;
                }
                case 1504891608: {
                    if (a2.equals("audio/opus")) {
                        n = 3;
                        break Label_0471;
                    }
                    break;
                }
                case 1503095341: {
                    if (a2.equals("audio/3gpp")) {
                        n = 1;
                        break Label_0471;
                    }
                    break;
                }
                case 1331836730: {
                    if (a2.equals("video/avc")) {
                        n = 6;
                        break Label_0471;
                    }
                    break;
                }
                case 1187890754: {
                    if (a2.equals("video/mp4v-es")) {
                        n = 4;
                        break Label_0471;
                    }
                    break;
                }
                case 187094639: {
                    if (a2.equals("audio/raw")) {
                        n = 10;
                        break Label_0471;
                    }
                    break;
                }
                case 187078296: {
                    if (a2.equals("audio/ac3")) {
                        n = 11;
                        break Label_0471;
                    }
                    break;
                }
                case -53558318: {
                    if (a2.equals("audio/mp4a-latm")) {
                        n = 0;
                        break Label_0471;
                    }
                    break;
                }
                case -1606874997: {
                    if (a2.equals("audio/amr-wb")) {
                        n = 2;
                        break Label_0471;
                    }
                    break;
                }
                case -1662541442: {
                    if (a2.equals("video/hevc")) {
                        n = 7;
                        break Label_0471;
                    }
                    break;
                }
                case -1664118616: {
                    if (a2.equals("video/3gpp")) {
                        n = 5;
                        break Label_0471;
                    }
                    break;
                }
            }
            n = -1;
        }
        switch (n) {
            case 10: {
                builder.Y(RtpPayloadFormat.b(b));
                break;
            }
            case 9: {
                builder.j0(320).Q(240);
                break;
            }
            case 8: {
                builder.j0(320).Q(240);
                break;
            }
            case 7: {
                Assertions.a(a3.isEmpty() ^ true);
                g(builder, a3);
                break;
            }
            case 6: {
                Assertions.a(a3.isEmpty() ^ true);
                f(builder, a3);
                break;
            }
            case 5: {
                builder.j0(352).Q(288);
                break;
            }
            case 4: {
                Assertions.a(a3.isEmpty() ^ true);
                h(builder, a3);
                break;
            }
            case 3: {
                Assertions.a(d != -1);
                Assertions.b(c == 48000, "Invalid OPUS clock rate.");
                break;
            }
            case 1:
            case 2: {
                Assertions.b(d == 1, "Multi channel AMR is not currently supported.");
                Assertions.b(a3.isEmpty() ^ true, "fmtp parameters must include octet-align.");
                Assertions.b(a3.containsKey((Object)"octet-align"), "Only octet aligned mode is currently supported.");
                Assertions.b(a3.containsKey((Object)"interleaving") ^ true, "Interleaving mode is not currently supported.");
                break;
            }
            case 0: {
                Assertions.a(d != -1);
                Assertions.a(a3.isEmpty() ^ true);
                e(builder, a3, d, c);
                break;
            }
        }
        boolean b3 = b2;
        if (c > 0) {
            b3 = true;
        }
        Assertions.a(b3);
        return new RtpPayloadFormat(builder.E(), a, c, (Map<String, String>)a3);
    }
    
    private static byte[] c(final String s) {
        final byte[] decode = Base64.decode(s, 0);
        final int length = decode.length;
        final byte[] a = NalUnitUtil.a;
        final byte[] array = new byte[length + a.length];
        System.arraycopy(a, 0, array, 0, a.length);
        System.arraycopy(decode, 0, array, a.length, decode.length);
        return array;
    }
    
    private static int d(final int n, final String s) {
        if (n != -1) {
            return n;
        }
        if (s.equals("audio/ac3")) {
            return 6;
        }
        return 1;
    }
    
    private static void e(final Format.Builder builder, final ImmutableMap<String, String> immutableMap, final int n, final int n2) {
        Assertions.a(immutableMap.containsKey((Object)"profile-level-id"));
        final String s = Assertions.e(immutableMap.get((Object)"profile-level-id"));
        final StringBuilder sb = new StringBuilder();
        sb.append("mp4a.40.");
        sb.append(s);
        builder.I(sb.toString());
        builder.T((List<byte[]>)ImmutableList.of((Object)AacUtil.a(n2, n)));
    }
    
    private static void f(final Format.Builder builder, final ImmutableMap<String, String> immutableMap) {
        Assertions.a(immutableMap.containsKey((Object)"sprop-parameter-sets"));
        final String[] t0 = Util.T0(Assertions.e(immutableMap.get((Object)"sprop-parameter-sets")), ",");
        Assertions.a(t0.length == 2);
        final ImmutableList of = ImmutableList.of((Object)c(t0[0]), (Object)c(t0[1]));
        builder.T((List<byte[]>)of);
        final byte[] array = ((List<byte[]>)of).get(0);
        final NalUnitUtil.SpsData l = NalUnitUtil.l(array, NalUnitUtil.a.length, array.length);
        builder.a0(l.h);
        builder.Q(l.g);
        builder.j0(l.f);
        final String s = (String)immutableMap.get((Object)"profile-level-id");
        if (s != null) {
            final StringBuilder sb = new StringBuilder();
            sb.append("avc1.");
            sb.append(s);
            builder.I(sb.toString());
        }
        else {
            builder.I(CodecSpecificDataUtil.a(l.a, l.b, l.c));
        }
    }
    
    private static void g(final Format.Builder builder, final ImmutableMap<String, String> immutableMap) {
        if (immutableMap.containsKey((Object)"sprop-max-don-diff")) {
            final int int1 = Integer.parseInt(Assertions.e(immutableMap.get((Object)"sprop-max-don-diff")));
            final boolean b = int1 == 0;
            final StringBuilder sb = new StringBuilder();
            sb.append("non-zero sprop-max-don-diff ");
            sb.append(int1);
            sb.append(" is not supported");
            Assertions.b(b, sb.toString());
        }
        Assertions.a(immutableMap.containsKey((Object)"sprop-vps"));
        final String s = Assertions.e(immutableMap.get((Object)"sprop-vps"));
        Assertions.a(immutableMap.containsKey((Object)"sprop-sps"));
        final String s2 = Assertions.e(immutableMap.get((Object)"sprop-sps"));
        Assertions.a(immutableMap.containsKey((Object)"sprop-pps"));
        final ImmutableList of = ImmutableList.of((Object)c(s), (Object)c(s2), (Object)c(Assertions.e(immutableMap.get((Object)"sprop-pps"))));
        builder.T((List<byte[]>)of);
        final byte[] array = ((List<byte[]>)of).get(1);
        final NalUnitUtil.H265SpsData h = NalUnitUtil.h(array, NalUnitUtil.a.length, array.length);
        builder.a0(h.j);
        builder.Q(h.i).j0(h.h);
        builder.I(CodecSpecificDataUtil.c(h.a, h.b, h.c, h.d, h.e, h.f));
    }
    
    private static void h(final Format.Builder builder, final ImmutableMap<String, String> immutableMap) {
        final String s = (String)immutableMap.get((Object)"config");
        if (s != null) {
            final byte[] j = Util.J(s);
            builder.T((List<byte[]>)ImmutableList.of((Object)j));
            final Pair<Integer, Integer> f = CodecSpecificDataUtil.f(j);
            builder.j0((int)f.first).Q((int)f.second);
        }
        else {
            builder.j0(352).Q(288);
        }
        final String s2 = (String)immutableMap.get((Object)"profile-level-id");
        final StringBuilder sb = new StringBuilder();
        sb.append("mp4v.");
        String s3 = s2;
        if (s2 == null) {
            s3 = "1";
        }
        sb.append(s3);
        builder.I(sb.toString());
    }
    
    @Override
    public boolean equals(final Object o) {
        boolean b = true;
        if (this == o) {
            return true;
        }
        if (o != null && l.class == o.getClass()) {
            final l l = (l)o;
            if (!this.a.equals(l.a) || !this.b.equals((Object)l.b)) {
                b = false;
            }
            return b;
        }
        return false;
    }
    
    @Override
    public int hashCode() {
        return (217 + this.a.hashCode()) * 31 + this.b.hashCode();
    }
}
