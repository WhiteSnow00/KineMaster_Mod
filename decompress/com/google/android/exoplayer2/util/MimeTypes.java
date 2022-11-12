// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.exoplayer2.util;

import android.text.TextUtils;
import java.util.regex.Matcher;
import com.google.common.base.Ascii;
import java.util.regex.Pattern;
import java.util.ArrayList;

public final class MimeTypes
{
    private static final ArrayList<a> a;
    private static final Pattern b;
    
    static {
        a = new ArrayList<a>();
        b = Pattern.compile("^mp4a\\.([a-zA-Z0-9]{2})(?:\\.([0-9]{1,2}))?$");
    }
    
    private MimeTypes() {
    }
    
    public static boolean a(final String s, final String s2) {
        final boolean b = false;
        if (s == null) {
            return false;
        }
        int n = -1;
        switch (s) {
            case "audio/g711-mlaw": {
                n = 10;
                break;
            }
            case "audio/g711-alaw": {
                n = 9;
                break;
            }
            case "audio/mpeg": {
                n = 8;
                break;
            }
            case "audio/flac": {
                n = 7;
                break;
            }
            case "audio/eac3": {
                n = 6;
                break;
            }
            case "audio/raw": {
                n = 5;
                break;
            }
            case "audio/ac3": {
                n = 4;
                break;
            }
            case "audio/mp4a-latm": {
                n = 3;
                break;
            }
            case "audio/mpeg-L2": {
                n = 2;
                break;
            }
            case "audio/mpeg-L1": {
                n = 1;
                break;
            }
            case "audio/eac3-joc": {
                n = 0;
                break;
            }
            default:
                break;
        }
        switch (n) {
            default: {
                return false;
            }
            case 3: {
                if (s2 == null) {
                    return false;
                }
                final b i = i(s2);
                if (i == null) {
                    return false;
                }
                final int a = i.a();
                boolean b2 = b;
                if (a != 0) {
                    b2 = b;
                    if (a != 16) {
                        b2 = true;
                    }
                }
                return b2;
            }
            case 0:
            case 1:
            case 2:
            case 4:
            case 5:
            case 6:
            case 7:
            case 8:
            case 9:
            case 10: {
                return true;
            }
        }
    }
    
    public static boolean b(final String s, final String s2) {
        return d(s, s2) != null;
    }
    
    public static String c(final String s) {
        if (s == null) {
            return null;
        }
        final String[] v0 = Util.V0(s);
        for (int length = v0.length, i = 0; i < length; ++i) {
            final String g = g(v0[i]);
            if (g != null && o(g)) {
                return g;
            }
        }
        return null;
    }
    
    public static String d(final String s, final String s2) {
        String string;
        final String s3 = string = null;
        if (s != null) {
            if (s2 == null) {
                string = s3;
            }
            else {
                final String[] v0 = Util.V0(s);
                final StringBuilder sb = new StringBuilder();
                for (final String s4 : v0) {
                    if (s2.equals(g(s4))) {
                        if (sb.length() > 0) {
                            sb.append(",");
                        }
                        sb.append(s4);
                    }
                }
                string = s3;
                if (sb.length() > 0) {
                    string = sb.toString();
                }
            }
        }
        return string;
    }
    
    private static String e(final String s) {
        for (int size = MimeTypes.a.size(), i = 0; i < size; ++i) {
            final a a = MimeTypes.a.get(i);
            if (s.startsWith(a.b)) {
                return a.a;
            }
        }
        return null;
    }
    
    public static int f(final String s, final String s2) {
        s.hashCode();
        final int hashCode = s.hashCode();
        int n = -1;
        switch (hashCode) {
            case 1556697186: {
                if (!s.equals("audio/true-hd")) {
                    break;
                }
                n = 8;
                break;
            }
            case 1505942594: {
                if (!s.equals("audio/vnd.dts.hd")) {
                    break;
                }
                n = 7;
                break;
            }
            case 1504831518: {
                if (!s.equals("audio/mpeg")) {
                    break;
                }
                n = 6;
                break;
            }
            case 1504578661: {
                if (!s.equals("audio/eac3")) {
                    break;
                }
                n = 5;
                break;
            }
            case 187078297: {
                if (!s.equals("audio/ac4")) {
                    break;
                }
                n = 4;
                break;
            }
            case 187078296: {
                if (!s.equals("audio/ac3")) {
                    break;
                }
                n = 3;
                break;
            }
            case -53558318: {
                if (!s.equals("audio/mp4a-latm")) {
                    break;
                }
                n = 2;
                break;
            }
            case -1095064472: {
                if (!s.equals("audio/vnd.dts")) {
                    break;
                }
                n = 1;
                break;
            }
            case -2123537834: {
                if (!s.equals("audio/eac3-joc")) {
                    break;
                }
                n = 0;
                break;
            }
        }
        switch (n) {
            default: {
                return 0;
            }
            case 8: {
                return 14;
            }
            case 7: {
                return 8;
            }
            case 6: {
                return 9;
            }
            case 5: {
                return 6;
            }
            case 4: {
                return 17;
            }
            case 3: {
                return 5;
            }
            case 2: {
                if (s2 == null) {
                    return 0;
                }
                final b i = i(s2);
                if (i == null) {
                    return 0;
                }
                return i.a();
            }
            case 1: {
                return 7;
            }
            case 0: {
                return 18;
            }
        }
    }
    
    public static String g(String h) {
        final String s = null;
        if (h == null) {
            return null;
        }
        final String e = Ascii.e(h.trim());
        if (e.startsWith("avc1") || e.startsWith("avc3")) {
            return "video/avc";
        }
        if (e.startsWith("hev1") || e.startsWith("hvc1")) {
            return "video/hevc";
        }
        if (e.startsWith("dvav") || e.startsWith("dva1") || e.startsWith("dvhe") || e.startsWith("dvh1")) {
            return "video/dolby-vision";
        }
        if (e.startsWith("av01")) {
            return "video/av01";
        }
        if (e.startsWith("vp9") || e.startsWith("vp09")) {
            return "video/x-vnd.on2.vp9";
        }
        if (e.startsWith("vp8") || e.startsWith("vp08")) {
            return "video/x-vnd.on2.vp8";
        }
        if (e.startsWith("mp4a")) {
            h = s;
            if (e.startsWith("mp4a.")) {
                final b i = i(e);
                h = s;
                if (i != null) {
                    h = h(i.a);
                }
            }
            String s2;
            if ((s2 = h) == null) {
                s2 = "audio/mp4a-latm";
            }
            return s2;
        }
        if (e.startsWith("mha1")) {
            return "audio/mha1";
        }
        if (e.startsWith("mhm1")) {
            return "audio/mhm1";
        }
        if (e.startsWith("ac-3") || e.startsWith("dac3")) {
            return "audio/ac3";
        }
        if (e.startsWith("ec-3") || e.startsWith("dec3")) {
            return "audio/eac3";
        }
        if (e.startsWith("ec+3")) {
            return "audio/eac3-joc";
        }
        if (e.startsWith("ac-4") || e.startsWith("dac4")) {
            return "audio/ac4";
        }
        if (e.startsWith("dtsc")) {
            return "audio/vnd.dts";
        }
        if (e.startsWith("dtse")) {
            return "audio/vnd.dts.hd;profile=lbr";
        }
        if (e.startsWith("dtsh") || e.startsWith("dtsl")) {
            return "audio/vnd.dts.hd";
        }
        if (e.startsWith("dtsx")) {
            return "audio/vnd.dts.uhd;profile=p2";
        }
        if (e.startsWith("opus")) {
            return "audio/opus";
        }
        if (e.startsWith("vorbis")) {
            return "audio/vorbis";
        }
        if (e.startsWith("flac")) {
            return "audio/flac";
        }
        if (e.startsWith("stpp")) {
            return "application/ttml+xml";
        }
        if (e.startsWith("wvtt")) {
            return "text/vtt";
        }
        if (e.contains("cea708")) {
            return "application/cea-708";
        }
        if (!e.contains("eia608") && !e.contains("cea608")) {
            return e(e);
        }
        return "application/cea-608";
    }
    
    public static String h(final int n) {
        if (n == 32) {
            return "video/mp4v-es";
        }
        if (n == 33) {
            return "video/avc";
        }
        if (n != 35) {
            if (n != 64) {
                if (n == 163) {
                    return "video/wvc1";
                }
                if (n == 177) {
                    return "video/x-vnd.on2.vp9";
                }
                if (n == 165) {
                    return "audio/ac3";
                }
                if (n == 166) {
                    return "audio/eac3";
                }
                switch (n) {
                    default: {
                        switch (n) {
                            default: {
                                return null;
                            }
                            case 174: {
                                return "audio/ac4";
                            }
                            case 173: {
                                return "audio/opus";
                            }
                            case 170:
                            case 171: {
                                return "audio/vnd.dts.hd";
                            }
                            case 169:
                            case 172: {
                                return "audio/vnd.dts";
                            }
                        }
                        break;
                    }
                    case 106: {
                        return "video/mpeg";
                    }
                    case 105:
                    case 107: {
                        return "audio/mpeg";
                    }
                    case 96:
                    case 97:
                    case 98:
                    case 99:
                    case 100:
                    case 101: {
                        return "video/mpeg2";
                    }
                    case 102:
                    case 103:
                    case 104: {
                        break;
                    }
                }
            }
            return "audio/mp4a-latm";
        }
        return "video/hevc";
    }
    
    static b i(String s) {
        final Matcher matcher = MimeTypes.b.matcher(s);
        if (!matcher.matches()) {
            return null;
        }
        s = Assertions.e(matcher.group(1));
        final String group = matcher.group(2);
        int int1 = 0;
        try {
            final int int2 = Integer.parseInt(s, 16);
            if (group != null) {
                int1 = Integer.parseInt(group);
            }
            return new b(int2, int1);
        }
        catch (final NumberFormatException ex) {
            return null;
        }
    }
    
    private static String j(final String s) {
        if (s == null) {
            return null;
        }
        final int index = s.indexOf(47);
        if (index == -1) {
            return null;
        }
        return s.substring(0, index);
    }
    
    public static int k(final String s) {
        if (TextUtils.isEmpty((CharSequence)s)) {
            return -1;
        }
        if (o(s)) {
            return 1;
        }
        if (s(s)) {
            return 2;
        }
        if (r(s)) {
            return 3;
        }
        if (p(s)) {
            return 4;
        }
        if ("application/id3".equals(s) || "application/x-emsg".equals(s) || "application/x-scte35".equals(s)) {
            return 5;
        }
        if ("application/x-camera-motion".equals(s)) {
            return 6;
        }
        return l(s);
    }
    
    private static int l(final String s) {
        for (int size = MimeTypes.a.size(), i = 0; i < size; ++i) {
            final a a = MimeTypes.a.get(i);
            if (s.equals(a.a)) {
                return a.c;
            }
        }
        return -1;
    }
    
    public static int m(final String s) {
        return k(g(s));
    }
    
    public static String n(final String s) {
        if (s == null) {
            return null;
        }
        final String[] v0 = Util.V0(s);
        for (int length = v0.length, i = 0; i < length; ++i) {
            final String g = g(v0[i]);
            if (g != null && s(g)) {
                return g;
            }
        }
        return null;
    }
    
    public static boolean o(final String s) {
        return "audio".equals(j(s));
    }
    
    public static boolean p(final String s) {
        return "image".equals(j(s));
    }
    
    public static boolean q(final String s) {
        boolean b = false;
        if (s == null) {
            return false;
        }
        if (s.startsWith("video/webm") || s.startsWith("audio/webm") || s.startsWith("application/webm") || s.startsWith("video/x-matroska") || s.startsWith("audio/x-matroska") || s.startsWith("application/x-matroska")) {
            b = true;
        }
        return b;
    }
    
    public static boolean r(final String s) {
        return "text".equals(j(s)) || "application/cea-608".equals(s) || "application/cea-708".equals(s) || "application/x-mp4-cea-608".equals(s) || "application/x-subrip".equals(s) || "application/ttml+xml".equals(s) || "application/x-quicktime-tx3g".equals(s) || "application/x-mp4-vtt".equals(s) || "application/x-rawcc".equals(s) || "application/vobsub".equals(s) || "application/pgs".equals(s) || "application/dvbsubs".equals(s);
    }
    
    public static boolean s(final String s) {
        return "video".equals(j(s));
    }
    
    public static String t(final String s) {
        s.hashCode();
        final int hashCode = s.hashCode();
        int n = -1;
        switch (hashCode) {
            case 187090231: {
                if (!s.equals("audio/mp3")) {
                    break;
                }
                n = 2;
                break;
            }
            case -586683234: {
                if (!s.equals("audio/x-wav")) {
                    break;
                }
                n = 1;
                break;
            }
            case -1007807498: {
                if (!s.equals("audio/x-flac")) {
                    break;
                }
                n = 0;
                break;
            }
        }
        switch (n) {
            default: {
                return s;
            }
            case 2: {
                return "audio/mpeg";
            }
            case 1: {
                return "audio/wav";
            }
            case 0: {
                return "audio/flac";
            }
        }
    }
    
    private static final class a
    {
        public final String a;
        public final String b;
        public final int c;
    }
    
    static final class b
    {
        public final int a;
        public final int b;
        
        public b(final int a, final int b) {
            this.a = a;
            this.b = b;
        }
        
        public int a() {
            final int b = this.b;
            if (b == 2) {
                return 10;
            }
            if (b == 5) {
                return 11;
            }
            if (b == 29) {
                return 12;
            }
            if (b == 42) {
                return 16;
            }
            if (b == 22) {
                return 1073741824;
            }
            if (b != 23) {
                return 0;
            }
            return 15;
        }
    }
}
