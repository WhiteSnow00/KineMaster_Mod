// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.exoplayer2.mediacodec;

import android.media.MediaCodecList;
import android.text.TextUtils;
import java.util.regex.Matcher;
import java.util.ArrayList;
import java.util.Collection;
import com.google.common.collect.ImmutableList;
import com.google.android.exoplayer2.video.ColorInfo;
import com.google.android.exoplayer2.util.Log;
import android.util.Pair;
import android.media.MediaCodecInfo$CodecCapabilities;
import java.util.Comparator;
import java.util.Collections;
import android.media.MediaCodecInfo$CodecProfileLevel;
import com.google.android.exoplayer2.Format;
import com.google.common.base.Ascii;
import com.google.android.exoplayer2.util.MimeTypes;
import com.google.android.exoplayer2.util.Util;
import java.util.List;
import java.util.HashMap;
import java.util.regex.Pattern;

public final class MediaCodecUtil
{
    private static final Pattern a;
    private static final HashMap<b, List<MediaCodecInfo>> b;
    private static int c;
    
    static {
        a = Pattern.compile("^\\D?(\\d+)$");
        b = new HashMap<b, List<MediaCodecInfo>>();
        MediaCodecUtil.c = -1;
    }
    
    private MediaCodecUtil() {
    }
    
    private static boolean A(final android.media.MediaCodecInfo mediaCodecInfo) {
        return Util.a >= 29 && B(mediaCodecInfo);
    }
    
    private static boolean B(final android.media.MediaCodecInfo mediaCodecInfo) {
        return mediaCodecInfo.isAlias();
    }
    
    private static boolean C(final android.media.MediaCodecInfo mediaCodecInfo, final String s, final boolean b, final String s2) {
        if (mediaCodecInfo.isEncoder() || (!b && s.endsWith(".secure"))) {
            return false;
        }
        final int a = Util.a;
        if (a < 21 && ("CIPAACDecoder".equals(s) || "CIPMP3Decoder".equals(s) || "CIPVorbisDecoder".equals(s) || "CIPAMRNBDecoder".equals(s) || "AACDecoder".equals(s) || "MP3Decoder".equals(s))) {
            return false;
        }
        if (a < 18 && "OMX.MTK.AUDIO.DECODER.AAC".equals(s)) {
            final String b2 = Util.b;
            if ("a70".equals(b2) || ("Xiaomi".equals(Util.c) && b2.startsWith("HM"))) {
                return false;
            }
        }
        if (a == 16 && "OMX.qcom.audio.decoder.mp3".equals(s)) {
            final String b3 = Util.b;
            if ("dlxu".equals(b3) || "protou".equals(b3) || "ville".equals(b3) || "villeplus".equals(b3) || "villec2".equals(b3) || b3.startsWith("gee") || "C6602".equals(b3) || "C6603".equals(b3) || "C6606".equals(b3) || "C6616".equals(b3) || "L36h".equals(b3) || "SO-02E".equals(b3)) {
                return false;
            }
        }
        if (a == 16 && "OMX.qcom.audio.decoder.aac".equals(s)) {
            final String b4 = Util.b;
            if ("C1504".equals(b4) || "C1505".equals(b4) || "C1604".equals(b4) || "C1605".equals(b4)) {
                return false;
            }
        }
        if (a < 24 && ("OMX.SEC.aac.dec".equals(s) || "OMX.Exynos.AAC.Decoder".equals(s)) && "samsung".equals(Util.c)) {
            final String b5 = Util.b;
            if (b5.startsWith("zeroflte") || b5.startsWith("zerolte") || b5.startsWith("zenlte") || "SC-05G".equals(b5) || "marinelteatt".equals(b5) || "404SC".equals(b5) || "SC-04G".equals(b5) || "SCV31".equals(b5)) {
                return false;
            }
        }
        if (a <= 19 && "OMX.SEC.vp8.dec".equals(s) && "samsung".equals(Util.c)) {
            final String b6 = Util.b;
            if (b6.startsWith("d2") || b6.startsWith("serrano") || b6.startsWith("jflte") || b6.startsWith("santos") || b6.startsWith("t0")) {
                return false;
            }
        }
        return (a > 19 || !Util.b.startsWith("jflte") || !"OMX.qcom.video.decoder.vp8".equals(s)) && (a > 23 || !"audio/eac3-joc".equals(s2) || !"OMX.MTK.AUDIO.DECODER.DSPAC3".equals(s));
    }
    
    private static boolean D(final android.media.MediaCodecInfo mediaCodecInfo, final String s) {
        if (Util.a >= 29) {
            return E(mediaCodecInfo);
        }
        return F(mediaCodecInfo, s) ^ true;
    }
    
    private static boolean E(final android.media.MediaCodecInfo mediaCodecInfo) {
        return mediaCodecInfo.isHardwareAccelerated();
    }
    
    private static boolean F(final android.media.MediaCodecInfo mediaCodecInfo, final String s) {
        if (Util.a >= 29) {
            return G(mediaCodecInfo);
        }
        final boolean o = MimeTypes.o(s);
        final boolean b = true;
        if (o) {
            return true;
        }
        final String e = Ascii.e(mediaCodecInfo.getName());
        if (e.startsWith("arc.")) {
            return false;
        }
        boolean b2 = b;
        if (!e.startsWith("omx.google.")) {
            b2 = b;
            if (!e.startsWith("omx.ffmpeg.")) {
                if (e.startsWith("omx.sec.")) {
                    b2 = b;
                    if (e.contains(".sw.")) {
                        return b2;
                    }
                }
                b2 = b;
                if (!e.equals("omx.qcom.video.decoder.hevcswvdec")) {
                    b2 = b;
                    if (!e.startsWith("c2.android.")) {
                        b2 = b;
                        if (!e.startsWith("c2.google.")) {
                            b2 = (!e.startsWith("omx.") && !e.startsWith("c2.") && b);
                        }
                    }
                }
            }
        }
        return b2;
    }
    
    private static boolean G(final android.media.MediaCodecInfo mediaCodecInfo) {
        return mediaCodecInfo.isSoftwareOnly();
    }
    
    private static boolean H(final android.media.MediaCodecInfo mediaCodecInfo) {
        if (Util.a >= 29) {
            return I(mediaCodecInfo);
        }
        final String e = Ascii.e(mediaCodecInfo.getName());
        return !e.startsWith("omx.google.") && !e.startsWith("c2.android.") && !e.startsWith("c2.google.");
    }
    
    private static boolean I(final android.media.MediaCodecInfo mediaCodecInfo) {
        return mediaCodecInfo.isVendor();
    }
    
    private static int J(final MediaCodecInfo mediaCodecInfo) {
        final String a = mediaCodecInfo.a;
        if (a.startsWith("OMX.google") || a.startsWith("c2.android")) {
            return 1;
        }
        if (Util.a < 26 && a.equals("OMX.MTK.AUDIO.DECODER.RAW")) {
            return -1;
        }
        return 0;
    }
    
    private static int K(final MediaCodecInfo mediaCodecInfo) {
        return mediaCodecInfo.a.startsWith("OMX.google") ? 1 : 0;
    }
    
    private static int L(final Format format, final MediaCodecInfo mediaCodecInfo) {
        try {
            return mediaCodecInfo.m(format) ? 1 : 0;
        }
        catch (final DecoderQueryException ex) {
            return -1;
        }
    }
    
    private static int M(final f f, final Object o, final Object o2) {
        return f.a(o2) - f.a(o);
    }
    
    public static int N() throws DecoderQueryException {
        if (MediaCodecUtil.c == -1) {
            int max = 0;
            int i = 0;
            final MediaCodecInfo r = r("video/avc", false, false);
            if (r != null) {
                final MediaCodecInfo$CodecProfileLevel[] g = r.g();
                final int length = g.length;
                int max2 = 0;
                while (i < length) {
                    max2 = Math.max(h(g[i].level), max2);
                    ++i;
                }
                int n;
                if (Util.a >= 21) {
                    n = 345600;
                }
                else {
                    n = 172800;
                }
                max = Math.max(max2, n);
            }
            MediaCodecUtil.c = max;
        }
        return MediaCodecUtil.c;
    }
    
    private static int O(final int n) {
        int n2 = 17;
        if (n != 17) {
            n2 = 20;
            if (n != 20) {
                n2 = 23;
                if (n != 23) {
                    n2 = 29;
                    if (n != 29) {
                        n2 = 39;
                        if (n != 39) {
                            n2 = 42;
                            if (n != 42) {
                                switch (n) {
                                    default: {
                                        return -1;
                                    }
                                    case 6: {
                                        return 6;
                                    }
                                    case 5: {
                                        return 5;
                                    }
                                    case 4: {
                                        return 4;
                                    }
                                    case 3: {
                                        return 3;
                                    }
                                    case 2: {
                                        return 2;
                                    }
                                    case 1: {
                                        return 1;
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        return n2;
    }
    
    private static <T> void P(final List<T> list, final f<T> f) {
        Collections.sort(list, new n((f)f));
    }
    
    private static int Q(final int n) {
        if (n == 10) {
            return 1;
        }
        if (n == 11) {
            return 2;
        }
        if (n == 20) {
            return 4;
        }
        if (n == 21) {
            return 8;
        }
        if (n == 30) {
            return 16;
        }
        if (n == 31) {
            return 32;
        }
        if (n == 40) {
            return 64;
        }
        if (n == 41) {
            return 128;
        }
        if (n == 50) {
            return 256;
        }
        if (n == 51) {
            return 512;
        }
        switch (n) {
            default: {
                return -1;
            }
            case 62: {
                return 8192;
            }
            case 61: {
                return 4096;
            }
            case 60: {
                return 2048;
            }
        }
    }
    
    private static int R(final int n) {
        if (n == 0) {
            return 1;
        }
        if (n == 1) {
            return 2;
        }
        if (n == 2) {
            return 4;
        }
        if (n != 3) {
            return -1;
        }
        return 8;
    }
    
    public static int a(final MediaCodecInfo mediaCodecInfo) {
        return J(mediaCodecInfo);
    }
    
    public static int b(final MediaCodecInfo mediaCodecInfo) {
        return K(mediaCodecInfo);
    }
    
    public static int c(final Format format, final MediaCodecInfo mediaCodecInfo) {
        return L(format, mediaCodecInfo);
    }
    
    public static int d(final f f, final Object o, final Object o2) {
        return M(f, o, o2);
    }
    
    private static void e(String a, final List<MediaCodecInfo> list) {
        if ("audio/raw".equals(a)) {
            if (Util.a < 26 && Util.b.equals("R9") && list.size() == 1 && ((MediaCodecInfo)list.get(0)).a.equals("OMX.MTK.AUDIO.DECODER.RAW")) {
                list.add(MediaCodecInfo.C("OMX.google.raw.decoder", "audio/raw", "audio/raw", null, false, true, false, false, false));
            }
            P((List<Object>)list, l.a);
        }
        final int a2 = Util.a;
        if (a2 < 21 && list.size() > 1) {
            a = list.get(0).a;
            if ("OMX.SEC.mp3.dec".equals(a) || "OMX.SEC.MP3.Decoder".equals(a) || "OMX.brcm.audio.mp3.decoder".equals(a)) {
                P((List<Object>)list, m.a);
            }
        }
        if (a2 < 32 && list.size() > 1 && "OMX.qti.audio.decoder.flac".equals(list.get(0).a)) {
            list.add(list.remove(0));
        }
    }
    
    private static int f(final int n) {
        switch (n) {
            default: {
                return -1;
            }
            case 23: {
                return 8388608;
            }
            case 22: {
                return 4194304;
            }
            case 21: {
                return 2097152;
            }
            case 20: {
                return 1048576;
            }
            case 19: {
                return 524288;
            }
            case 18: {
                return 262144;
            }
            case 17: {
                return 131072;
            }
            case 16: {
                return 65536;
            }
            case 15: {
                return 32768;
            }
            case 14: {
                return 16384;
            }
            case 13: {
                return 8192;
            }
            case 12: {
                return 4096;
            }
            case 11: {
                return 2048;
            }
            case 10: {
                return 1024;
            }
            case 9: {
                return 512;
            }
            case 8: {
                return 256;
            }
            case 7: {
                return 128;
            }
            case 6: {
                return 64;
            }
            case 5: {
                return 32;
            }
            case 4: {
                return 16;
            }
            case 3: {
                return 8;
            }
            case 2: {
                return 4;
            }
            case 1: {
                return 2;
            }
            case 0: {
                return 1;
            }
        }
    }
    
    private static int g(final int n) {
        switch (n) {
            default: {
                switch (n) {
                    default: {
                        switch (n) {
                            default: {
                                switch (n) {
                                    default: {
                                        switch (n) {
                                            default: {
                                                return -1;
                                            }
                                            case 52: {
                                                return 65536;
                                            }
                                            case 51: {
                                                return 32768;
                                            }
                                            case 50: {
                                                return 16384;
                                            }
                                        }
                                        break;
                                    }
                                    case 42: {
                                        return 8192;
                                    }
                                    case 41: {
                                        return 4096;
                                    }
                                    case 40: {
                                        return 2048;
                                    }
                                }
                                break;
                            }
                            case 32: {
                                return 1024;
                            }
                            case 31: {
                                return 512;
                            }
                            case 30: {
                                return 256;
                            }
                        }
                        break;
                    }
                    case 22: {
                        return 128;
                    }
                    case 21: {
                        return 64;
                    }
                    case 20: {
                        return 32;
                    }
                }
                break;
            }
            case 13: {
                return 16;
            }
            case 12: {
                return 8;
            }
            case 11: {
                return 4;
            }
            case 10: {
                return 1;
            }
        }
    }
    
    private static int h(final int n) {
        if (n == 1 || n == 2) {
            return 25344;
        }
        switch (n) {
            default: {
                return -1;
            }
            case 131072:
            case 262144:
            case 524288: {
                return 35651584;
            }
            case 32768:
            case 65536: {
                return 9437184;
            }
            case 16384: {
                return 5652480;
            }
            case 8192: {
                return 2228224;
            }
            case 2048:
            case 4096: {
                return 2097152;
            }
            case 1024: {
                return 1310720;
            }
            case 512: {
                return 921600;
            }
            case 128:
            case 256: {
                return 414720;
            }
            case 64: {
                return 202752;
            }
            case 8:
            case 16:
            case 32: {
                return 101376;
            }
        }
    }
    
    private static int i(final int n) {
        if (n == 66) {
            return 1;
        }
        if (n == 77) {
            return 2;
        }
        if (n == 88) {
            return 4;
        }
        if (n == 100) {
            return 8;
        }
        if (n == 110) {
            return 16;
        }
        if (n == 122) {
            return 32;
        }
        if (n != 244) {
            return -1;
        }
        return 64;
    }
    
    private static Integer j(final String s) {
        if (s == null) {
            return null;
        }
        int n = -1;
        switch (s) {
            case "13": {
                n = 12;
                break;
            }
            case "12": {
                n = 11;
                break;
            }
            case "11": {
                n = 10;
                break;
            }
            case "10": {
                n = 9;
                break;
            }
            case "09": {
                n = 8;
                break;
            }
            case "08": {
                n = 7;
                break;
            }
            case "07": {
                n = 6;
                break;
            }
            case "06": {
                n = 5;
                break;
            }
            case "05": {
                n = 4;
                break;
            }
            case "04": {
                n = 3;
                break;
            }
            case "03": {
                n = 2;
                break;
            }
            case "02": {
                n = 1;
                break;
            }
            case "01": {
                n = 0;
                break;
            }
            default:
                break;
        }
        switch (n) {
            default: {
                return null;
            }
            case 12: {
                return 4096;
            }
            case 11: {
                return 2048;
            }
            case 10: {
                return 1024;
            }
            case 9: {
                return 512;
            }
            case 8: {
                return 256;
            }
            case 7: {
                return 128;
            }
            case 6: {
                return 64;
            }
            case 5: {
                return 32;
            }
            case 4: {
                return 16;
            }
            case 3: {
                return 8;
            }
            case 2: {
                return 4;
            }
            case 1: {
                return 2;
            }
            case 0: {
                return 1;
            }
        }
    }
    
    private static Integer k(final String s) {
        if (s == null) {
            return null;
        }
        int n = -1;
        switch (s) {
            case "09": {
                n = 9;
                break;
            }
            case "08": {
                n = 8;
                break;
            }
            case "07": {
                n = 7;
                break;
            }
            case "06": {
                n = 6;
                break;
            }
            case "05": {
                n = 5;
                break;
            }
            case "04": {
                n = 4;
                break;
            }
            case "03": {
                n = 3;
                break;
            }
            case "02": {
                n = 2;
                break;
            }
            case "01": {
                n = 1;
                break;
            }
            case "00": {
                n = 0;
                break;
            }
            default:
                break;
        }
        switch (n) {
            default: {
                return null;
            }
            case 9: {
                return 512;
            }
            case 8: {
                return 256;
            }
            case 7: {
                return 128;
            }
            case 6: {
                return 64;
            }
            case 5: {
                return 32;
            }
            case 4: {
                return 16;
            }
            case 3: {
                return 8;
            }
            case 2: {
                return 4;
            }
            case 1: {
                return 2;
            }
            case 0: {
                return 1;
            }
        }
    }
    
    private static Pair<Integer, Integer> l(final String s, final String[] array) {
        if (array.length != 3) {
            final StringBuilder sb = new StringBuilder();
            sb.append("Ignoring malformed MP4A codec string: ");
            sb.append(s);
            Log.i("MediaCodecUtil", sb.toString());
            return null;
        }
        try {
            if ("audio/mp4a-latm".equals(MimeTypes.h(Integer.parseInt(array[1], 16)))) {
                final int o = O(Integer.parseInt(array[2]));
                if (o != -1) {
                    return (Pair<Integer, Integer>)new Pair((Object)o, (Object)0);
                }
            }
        }
        catch (final NumberFormatException ex) {
            final StringBuilder sb2 = new StringBuilder();
            sb2.append("Ignoring malformed MP4A codec string: ");
            sb2.append(s);
            Log.i("MediaCodecUtil", sb2.toString());
        }
        return null;
    }
    
    public static String m(final Format format) {
        if ("audio/eac3-joc".equals(format.w)) {
            return "audio/eac3";
        }
        if ("video/dolby-vision".equals(format.w)) {
            final Pair<Integer, Integer> q = q(format);
            if (q != null) {
                final int intValue = (int)q.first;
                if (intValue == 16 || intValue == 256) {
                    return "video/hevc";
                }
                if (intValue == 512) {
                    return "video/avc";
                }
            }
        }
        return null;
    }
    
    private static Pair<Integer, Integer> n(String s, final String[] array, final ColorInfo colorInfo) {
        if (array.length < 4) {
            final StringBuilder sb = new StringBuilder();
            sb.append("Ignoring malformed AV1 codec string: ");
            sb.append(s);
            Log.i("MediaCodecUtil", sb.toString());
            return null;
        }
        int n = 1;
        try {
            final int int1 = Integer.parseInt(array[1]);
            final int int2 = Integer.parseInt(array[2].substring(0, 2));
            final int int3 = Integer.parseInt(array[3]);
            if (int1 != 0) {
                s = (String)new StringBuilder();
                ((StringBuilder)s).append("Unknown AV1 profile: ");
                ((StringBuilder)s).append(int1);
                Log.i("MediaCodecUtil", ((StringBuilder)s).toString());
                return null;
            }
            if (int3 != 8 && int3 != 10) {
                s = (String)new StringBuilder();
                ((StringBuilder)s).append("Unknown AV1 bit depth: ");
                ((StringBuilder)s).append(int3);
                Log.i("MediaCodecUtil", ((StringBuilder)s).toString());
                return null;
            }
            Label_0207: {
                if (int3 != 8) {
                    Label_0205: {
                        if (colorInfo != null) {
                            if (colorInfo.d == null) {
                                final int c = colorInfo.c;
                                if (c != 7 && c != 6) {
                                    break Label_0205;
                                }
                            }
                            n = 4096;
                            break Label_0207;
                        }
                    }
                    n = 2;
                }
            }
            final int f = f(int2);
            if (f == -1) {
                s = (String)new StringBuilder();
                ((StringBuilder)s).append("Unknown AV1 level: ");
                ((StringBuilder)s).append(int2);
                Log.i("MediaCodecUtil", ((StringBuilder)s).toString());
                return null;
            }
            return (Pair<Integer, Integer>)new Pair((Object)n, (Object)f);
        }
        catch (final NumberFormatException ex) {
            final StringBuilder sb2 = new StringBuilder();
            sb2.append("Ignoring malformed AV1 codec string: ");
            sb2.append(s);
            Log.i("MediaCodecUtil", sb2.toString());
            return null;
        }
    }
    
    private static Pair<Integer, Integer> o(String s, final String[] array) {
        if (array.length < 2) {
            final StringBuilder sb = new StringBuilder();
            sb.append("Ignoring malformed AVC codec string: ");
            sb.append(s);
            Log.i("MediaCodecUtil", sb.toString());
            return null;
        }
        try {
            int n;
            int n2;
            if (array[1].length() == 6) {
                n = Integer.parseInt(array[1].substring(0, 2), 16);
                n2 = Integer.parseInt(array[1].substring(4), 16);
            }
            else {
                if (array.length < 3) {
                    final StringBuilder sb2 = new StringBuilder();
                    sb2.append("Ignoring malformed AVC codec string: ");
                    sb2.append(s);
                    Log.i("MediaCodecUtil", sb2.toString());
                    return null;
                }
                n = Integer.parseInt(array[1]);
                n2 = Integer.parseInt(array[2]);
            }
            final int i = i(n);
            if (i == -1) {
                s = (String)new StringBuilder();
                ((StringBuilder)s).append("Unknown AVC profile: ");
                ((StringBuilder)s).append(n);
                Log.i("MediaCodecUtil", ((StringBuilder)s).toString());
                return null;
            }
            final int g = g(n2);
            if (g == -1) {
                s = (String)new StringBuilder();
                ((StringBuilder)s).append("Unknown AVC level: ");
                ((StringBuilder)s).append(n2);
                Log.i("MediaCodecUtil", ((StringBuilder)s).toString());
                return null;
            }
            return (Pair<Integer, Integer>)new Pair((Object)i, (Object)g);
        }
        catch (final NumberFormatException ex) {
            final StringBuilder sb3 = new StringBuilder();
            sb3.append("Ignoring malformed AVC codec string: ");
            sb3.append(s);
            Log.i("MediaCodecUtil", sb3.toString());
            return null;
        }
    }
    
    private static String p(final android.media.MediaCodecInfo mediaCodecInfo, final String s, final String s2) {
        for (final String s3 : mediaCodecInfo.getSupportedTypes()) {
            if (s3.equalsIgnoreCase(s2)) {
                return s3;
            }
        }
        if (s2.equals("video/dolby-vision")) {
            if ("OMX.MS.HEVCDV.Decoder".equals(s)) {
                return "video/hevcdv";
            }
            if ("OMX.RTK.video.decoder".equals(s) || "OMX.realtek.video.decoder.tunneled".equals(s)) {
                return "video/dv_hevc";
            }
        }
        else {
            if (s2.equals("audio/alac") && "OMX.lge.alac.decoder".equals(s)) {
                return "audio/x-lg-alac";
            }
            if (s2.equals("audio/flac") && "OMX.lge.flac.decoder".equals(s)) {
                return "audio/x-lg-flac";
            }
            if (s2.equals("audio/ac3") && "OMX.lge.ac3.decoder".equals(s)) {
                return "audio/lg-ac3";
            }
        }
        return null;
    }
    
    public static Pair<Integer, Integer> q(final Format format) {
        final String i = format.i;
        if (i == null) {
            return null;
        }
        final String[] split = i.split("\\.");
        if ("video/dolby-vision".equals(format.w)) {
            return w(format.i, split);
        }
        int n = 0;
        final String s = split[0];
        s.hashCode();
        Label_0251: {
            switch (s) {
                case "vp09": {
                    n = 6;
                    break Label_0251;
                }
                case "mp4a": {
                    n = 5;
                    break Label_0251;
                }
                case "hvc1": {
                    n = 4;
                    break Label_0251;
                }
                case "hev1": {
                    n = 3;
                    break Label_0251;
                }
                case "avc2": {
                    n = 2;
                    break Label_0251;
                }
                case "avc1": {
                    n = 1;
                    break Label_0251;
                }
                case "av01": {
                    break Label_0251;
                }
                default:
                    break;
            }
            n = -1;
        }
        switch (n) {
            default: {
                return null;
            }
            case 6: {
                return y(format.i, split);
            }
            case 5: {
                return l(format.i, split);
            }
            case 3:
            case 4: {
                return x(format.i, split);
            }
            case 1:
            case 2: {
                return o(format.i, split);
            }
            case 0: {
                return n(format.i, split, format.I);
            }
        }
    }
    
    public static MediaCodecInfo r(final String s, final boolean b, final boolean b2) throws DecoderQueryException {
        final List<MediaCodecInfo> s2 = s(s, b, b2);
        MediaCodecInfo mediaCodecInfo;
        if (s2.isEmpty()) {
            mediaCodecInfo = null;
        }
        else {
            mediaCodecInfo = s2.get(0);
        }
        return mediaCodecInfo;
    }
    
    public static List<MediaCodecInfo> s(final String s, final boolean b, final boolean b2) throws DecoderQueryException {
        synchronized (MediaCodecUtil.class) {
            final b b3 = new b(s, b, b2);
            final HashMap<b, List<MediaCodecInfo>> b4 = MediaCodecUtil.b;
            final List list = b4.get(b3);
            if (list != null) {
                return list;
            }
            final int a = Util.a;
            c c;
            if (a >= 21) {
                c = new e(b, b2);
            }
            else {
                c = new d(null);
            }
            ArrayList<MediaCodecInfo> list3;
            final ArrayList<MediaCodecInfo> list2 = list3 = t(b3, c);
            if (b) {
                list3 = list2;
                if (list2.isEmpty()) {
                    list3 = list2;
                    if (21 <= a) {
                        list3 = list2;
                        if (a <= 23) {
                            final ArrayList<MediaCodecInfo> list4 = list3 = t(b3, (c)new d(null));
                            if (!list4.isEmpty()) {
                                final StringBuilder sb = new StringBuilder();
                                sb.append("MediaCodecList API didn't list secure decoder for: ");
                                sb.append(s);
                                sb.append(". Assuming: ");
                                sb.append(list4.get(0).a);
                                Log.i("MediaCodecUtil", sb.toString());
                                list3 = list4;
                            }
                        }
                    }
                }
            }
            e(s, list3);
            final ImmutableList copy = ImmutableList.copyOf((Collection)list3);
            b4.put(b3, (List)copy);
            return (List<MediaCodecInfo>)copy;
        }
    }
    
    private static ArrayList<MediaCodecInfo> t(final b b, final c c) throws DecoderQueryException {
        try {
            final ArrayList<MediaCodecInfo> list = new ArrayList<MediaCodecInfo>();
            final String a = b.a;
            final int d = c.d();
            final boolean e = c.e();
            for (int i = 0; i < d; ++i) {
                final android.media.MediaCodecInfo a2 = c.a(i);
                if (!A(a2)) {
                    final String name = a2.getName();
                    if (C(a2, name, e, a)) {
                        final String p2 = p(a2, name, a);
                        if (p2 != null) {
                            Label_0427: {
                                try {
                                    final MediaCodecInfo$CodecCapabilities capabilitiesForType = a2.getCapabilitiesForType(p2);
                                    final boolean b2 = c.b("tunneled-playback", p2, capabilitiesForType);
                                    final boolean c2 = c.c("tunneled-playback", p2, capabilitiesForType);
                                    final boolean c3 = b.c;
                                    if (!c3 && c2) {
                                        continue;
                                    }
                                    if (c3 && !b2) {
                                        continue;
                                    }
                                    final boolean b3 = c.b("secure-playback", p2, capabilitiesForType);
                                    final boolean c4 = c.c("secure-playback", p2, capabilitiesForType);
                                    final boolean b4 = b.b;
                                    if (!b4 && c4) {
                                        continue;
                                    }
                                    if (b4 && !b3) {
                                        continue;
                                    }
                                    final boolean d2 = D(a2, a);
                                    final boolean f = F(a2, a);
                                    final boolean h = H(a2);
                                    Label_0287: {
                                        if (e && b.b == b3) {
                                            break Label_0287;
                                        }
                                        if (e) {
                                            break Label_0287;
                                        }
                                        try {
                                            if (!b.b) {
                                                try {
                                                    list.add(MediaCodecInfo.C(name, a, p2, capabilitiesForType, d2, f, h, false, false));
                                                }
                                                catch (final Exception ex) {}
                                            }
                                        }
                                        catch (final Exception ex) {
                                            break Label_0427;
                                        }
                                    }
                                    if (e || !b3) {
                                        continue;
                                    }
                                    final StringBuilder sb = new StringBuilder();
                                    try {
                                        sb.append(name);
                                        sb.append(".secure");
                                        final String string = sb.toString();
                                        try {
                                            list.add(MediaCodecInfo.C(string, a, p2, capabilitiesForType, d2, f, h, false, true));
                                            return list;
                                        }
                                        catch (final Exception ex) {}
                                    }
                                    catch (final Exception ex) {}
                                }
                                catch (final Exception ex) {}
                            }
                            if (Util.a > 23 || list.isEmpty()) {
                                final StringBuilder sb2 = new StringBuilder();
                                sb2.append("Failed to query codec ");
                                sb2.append(name);
                                sb2.append(" (");
                                sb2.append(p2);
                                sb2.append(")");
                                Log.c("MediaCodecUtil", sb2.toString());
                                throw;
                            }
                            final StringBuilder sb3 = new StringBuilder();
                            sb3.append("Skipping codec ");
                            sb3.append(name);
                            sb3.append(" (failed to query capabilities)");
                            Log.c("MediaCodecUtil", sb3.toString());
                        }
                    }
                }
            }
            return list;
        }
        catch (final Exception ex2) {
            throw new DecoderQueryException(ex2, null);
        }
    }
    
    public static List<MediaCodecInfo> u(final List<MediaCodecInfo> list, final Format format) {
        final ArrayList list2 = new ArrayList((Collection<? extends E>)list);
        P(list2, (f<Object>)new k(format));
        return list2;
    }
    
    public static MediaCodecInfo v() throws DecoderQueryException {
        return r("audio/raw", false, false);
    }
    
    private static Pair<Integer, Integer> w(final String s, final String[] array) {
        if (array.length < 3) {
            final StringBuilder sb = new StringBuilder();
            sb.append("Ignoring malformed Dolby Vision codec string: ");
            sb.append(s);
            Log.i("MediaCodecUtil", sb.toString());
            return null;
        }
        final Matcher matcher = MediaCodecUtil.a.matcher(array[1]);
        if (!matcher.matches()) {
            final StringBuilder sb2 = new StringBuilder();
            sb2.append("Ignoring malformed Dolby Vision codec string: ");
            sb2.append(s);
            Log.i("MediaCodecUtil", sb2.toString());
            return null;
        }
        final String group = matcher.group(1);
        final Integer k = k(group);
        if (k == null) {
            final StringBuilder sb3 = new StringBuilder();
            sb3.append("Unknown Dolby Vision profile string: ");
            sb3.append(group);
            Log.i("MediaCodecUtil", sb3.toString());
            return null;
        }
        final String s2 = array[2];
        final Integer j = j(s2);
        if (j == null) {
            final StringBuilder sb4 = new StringBuilder();
            sb4.append("Unknown Dolby Vision level string: ");
            sb4.append(s2);
            Log.i("MediaCodecUtil", sb4.toString());
            return null;
        }
        return (Pair<Integer, Integer>)new Pair((Object)k, (Object)j);
    }
    
    private static Pair<Integer, Integer> x(String group, final String[] array) {
        if (array.length < 4) {
            final StringBuilder sb = new StringBuilder();
            sb.append("Ignoring malformed HEVC codec string: ");
            sb.append(group);
            Log.i("MediaCodecUtil", sb.toString());
            return null;
        }
        final Pattern a = MediaCodecUtil.a;
        int n = 1;
        final Matcher matcher = a.matcher(array[1]);
        if (!matcher.matches()) {
            final StringBuilder sb2 = new StringBuilder();
            sb2.append("Ignoring malformed HEVC codec string: ");
            sb2.append(group);
            Log.i("MediaCodecUtil", sb2.toString());
            return null;
        }
        group = matcher.group(1);
        if (!"1".equals(group)) {
            if (!"2".equals(group)) {
                final StringBuilder sb3 = new StringBuilder();
                sb3.append("Unknown HEVC profile string: ");
                sb3.append(group);
                Log.i("MediaCodecUtil", sb3.toString());
                return null;
            }
            n = 2;
        }
        group = array[3];
        final Integer z = z(group);
        if (z == null) {
            final StringBuilder sb4 = new StringBuilder();
            sb4.append("Unknown HEVC level string: ");
            sb4.append(group);
            Log.i("MediaCodecUtil", sb4.toString());
            return null;
        }
        return (Pair<Integer, Integer>)new Pair((Object)n, (Object)z);
    }
    
    private static Pair<Integer, Integer> y(String s, final String[] array) {
        if (array.length < 3) {
            final StringBuilder sb = new StringBuilder();
            sb.append("Ignoring malformed VP9 codec string: ");
            sb.append(s);
            Log.i("MediaCodecUtil", sb.toString());
            return null;
        }
        try {
            final int int1 = Integer.parseInt(array[1]);
            final int int2 = Integer.parseInt(array[2]);
            final int r = R(int1);
            if (r == -1) {
                s = (String)new StringBuilder();
                ((StringBuilder)s).append("Unknown VP9 profile: ");
                ((StringBuilder)s).append(int1);
                Log.i("MediaCodecUtil", ((StringBuilder)s).toString());
                return null;
            }
            final int q = Q(int2);
            if (q == -1) {
                s = (String)new StringBuilder();
                ((StringBuilder)s).append("Unknown VP9 level: ");
                ((StringBuilder)s).append(int2);
                Log.i("MediaCodecUtil", ((StringBuilder)s).toString());
                return null;
            }
            return (Pair<Integer, Integer>)new Pair((Object)r, (Object)q);
        }
        catch (final NumberFormatException ex) {
            final StringBuilder sb2 = new StringBuilder();
            sb2.append("Ignoring malformed VP9 codec string: ");
            sb2.append(s);
            Log.i("MediaCodecUtil", sb2.toString());
            return null;
        }
    }
    
    private static Integer z(final String s) {
        if (s == null) {
            return null;
        }
        int n = -1;
        switch (s) {
            case "L186": {
                n = 25;
                break;
            }
            case "L183": {
                n = 24;
                break;
            }
            case "L180": {
                n = 23;
                break;
            }
            case "L156": {
                n = 22;
                break;
            }
            case "L153": {
                n = 21;
                break;
            }
            case "L150": {
                n = 20;
                break;
            }
            case "L123": {
                n = 19;
                break;
            }
            case "L120": {
                n = 18;
                break;
            }
            case "H186": {
                n = 17;
                break;
            }
            case "H183": {
                n = 16;
                break;
            }
            case "H180": {
                n = 15;
                break;
            }
            case "H156": {
                n = 14;
                break;
            }
            case "H153": {
                n = 13;
                break;
            }
            case "H150": {
                n = 12;
                break;
            }
            case "H123": {
                n = 11;
                break;
            }
            case "H120": {
                n = 10;
                break;
            }
            case "L93": {
                n = 9;
                break;
            }
            case "L90": {
                n = 8;
                break;
            }
            case "L63": {
                n = 7;
                break;
            }
            case "L60": {
                n = 6;
                break;
            }
            case "L30": {
                n = 5;
                break;
            }
            case "H93": {
                n = 4;
                break;
            }
            case "H90": {
                n = 3;
                break;
            }
            case "H63": {
                n = 2;
                break;
            }
            case "H60": {
                n = 1;
                break;
            }
            case "H30": {
                n = 0;
                break;
            }
            default:
                break;
        }
        switch (n) {
            default: {
                return null;
            }
            case 25: {
                return 16777216;
            }
            case 24: {
                return 4194304;
            }
            case 23: {
                return 1048576;
            }
            case 22: {
                return 262144;
            }
            case 21: {
                return 65536;
            }
            case 20: {
                return 16384;
            }
            case 19: {
                return 4096;
            }
            case 18: {
                return 1024;
            }
            case 17: {
                return 33554432;
            }
            case 16: {
                return 8388608;
            }
            case 15: {
                return 2097152;
            }
            case 14: {
                return 524288;
            }
            case 13: {
                return 131072;
            }
            case 12: {
                return 32768;
            }
            case 11: {
                return 8192;
            }
            case 10: {
                return 2048;
            }
            case 9: {
                return 256;
            }
            case 8: {
                return 64;
            }
            case 7: {
                return 16;
            }
            case 6: {
                return 4;
            }
            case 5: {
                return 1;
            }
            case 4: {
                return 512;
            }
            case 3: {
                return 128;
            }
            case 2: {
                return 32;
            }
            case 1: {
                return 8;
            }
            case 0: {
                return 2;
            }
        }
    }
    
    public static class DecoderQueryException extends Exception
    {
        private DecoderQueryException(final Throwable t) {
            super("Failed to query underlying media codecs", t);
        }
        
        DecoderQueryException(final Throwable t, final MediaCodecUtil$a object) {
            this(t);
        }
    }
    
    private static final class b
    {
        public final String a;
        public final boolean b;
        public final boolean c;
        
        public b(final String a, final boolean b, final boolean c) {
            this.a = a;
            this.b = b;
            this.c = c;
        }
        
        @Override
        public boolean equals(final Object o) {
            boolean b = true;
            if (this == o) {
                return true;
            }
            if (o != null && o.getClass() == b.class) {
                final b b2 = (b)o;
                if (!TextUtils.equals((CharSequence)this.a, (CharSequence)b2.a) || this.b != b2.b || this.c != b2.c) {
                    b = false;
                }
                return b;
            }
            return false;
        }
        
        @Override
        public int hashCode() {
            final int hashCode = this.a.hashCode();
            final boolean b = this.b;
            int n = 1231;
            int n2;
            if (b) {
                n2 = 1231;
            }
            else {
                n2 = 1237;
            }
            if (!this.c) {
                n = 1237;
            }
            return ((hashCode + 31) * 31 + n2) * 31 + n;
        }
    }
    
    private interface c
    {
        android.media.MediaCodecInfo a(final int p0);
        
        boolean b(final String p0, final String p1, final MediaCodecInfo$CodecCapabilities p2);
        
        boolean c(final String p0, final String p1, final MediaCodecInfo$CodecCapabilities p2);
        
        int d();
        
        boolean e();
    }
    
    private static final class d implements c
    {
        private d() {
        }
        
        d(final MediaCodecUtil$a object) {
            this();
        }
        
        @Override
        public android.media.MediaCodecInfo a(final int n) {
            return MediaCodecList.getCodecInfoAt(n);
        }
        
        @Override
        public boolean b(final String s, final String s2, final MediaCodecInfo$CodecCapabilities mediaCodecInfo$CodecCapabilities) {
            return "secure-playback".equals(s) && "video/avc".equals(s2);
        }
        
        @Override
        public boolean c(final String s, final String s2, final MediaCodecInfo$CodecCapabilities mediaCodecInfo$CodecCapabilities) {
            return false;
        }
        
        @Override
        public int d() {
            return MediaCodecList.getCodecCount();
        }
        
        @Override
        public boolean e() {
            return false;
        }
    }
    
    private static final class e implements c
    {
        private final int a;
        private android.media.MediaCodecInfo[] b;
        
        public e(final boolean b, final boolean b2) {
            this.a = ((b || b2) ? 1 : 0);
        }
        
        private void f() {
            if (this.b == null) {
                this.b = new MediaCodecList(this.a).getCodecInfos();
            }
        }
        
        @Override
        public android.media.MediaCodecInfo a(final int n) {
            this.f();
            return this.b[n];
        }
        
        @Override
        public boolean b(final String s, final String s2, final MediaCodecInfo$CodecCapabilities mediaCodecInfo$CodecCapabilities) {
            return mediaCodecInfo$CodecCapabilities.isFeatureSupported(s);
        }
        
        @Override
        public boolean c(final String s, final String s2, final MediaCodecInfo$CodecCapabilities mediaCodecInfo$CodecCapabilities) {
            return mediaCodecInfo$CodecCapabilities.isFeatureRequired(s);
        }
        
        @Override
        public int d() {
            this.f();
            return this.b.length;
        }
        
        @Override
        public boolean e() {
            return true;
        }
    }
    
    private interface f<T>
    {
        int a(final T p0);
    }
}
