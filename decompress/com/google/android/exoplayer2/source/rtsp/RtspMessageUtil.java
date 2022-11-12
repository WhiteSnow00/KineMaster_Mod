// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.exoplayer2.source.rtsp;

import com.google.common.collect.ImmutableMultimap;
import java.util.AbstractCollection;
import com.google.common.collect.UnmodifiableIterator;
import com.google.common.collect.ImmutableListMultimap;
import com.google.common.base.Strings;
import android.net.Uri;
import com.google.android.exoplayer2.util.Util;
import com.google.common.collect.ImmutableList$Builder;
import com.google.common.collect.ImmutableList;
import java.util.regex.Matcher;
import com.google.android.exoplayer2.util.Assertions;
import com.google.common.base.Joiner;
import java.util.List;
import com.google.android.exoplayer2.ParserException;
import java.util.regex.Pattern;

final class RtspMessageUtil
{
    private static final Pattern a;
    private static final Pattern b;
    private static final Pattern c;
    private static final Pattern d;
    private static final Pattern e;
    private static final Pattern f;
    private static final String g;
    private static final String h;
    
    static {
        a = Pattern.compile("([A-Z_]+) (.*) RTSP/1\\.0");
        b = Pattern.compile("RTSP/1\\.0 (\\d+) (.+)");
        c = Pattern.compile("Content-Length:\\s?(\\d+)", 2);
        d = Pattern.compile("([\\w$\\-_.+]+)(?:;\\s?timeout=(\\d+))?");
        e = Pattern.compile("Digest realm=\"([^\"\\x00-\\x08\\x0A-\\x1f\\x7f]+)\",\\s?(?:domain=\"(.+)\",\\s?)?nonce=\"([^\"\\x00-\\x08\\x0A-\\x1f\\x7f]+)\"(?:,\\s?opaque=\"([^\"\\x00-\\x08\\x0A-\\x1f\\x7f]+)\")?");
        f = Pattern.compile("Basic realm=\"([^\"\\x00-\\x08\\x0A-\\x1f\\x7f]+)\"");
        g = new String(new byte[] { 10 });
        h = new String(new byte[] { 13, 10 });
    }
    
    public static void a(final boolean b, final String s) throws ParserException {
        if (b) {
            return;
        }
        throw ParserException.createForMalformedManifest(s, null);
    }
    
    public static byte[] b(final List<String> list) {
        return Joiner.i(RtspMessageUtil.h).e((Iterable)list).getBytes(RtspMessageChannel.g);
    }
    
    private static String c(final int n) {
        if (n == 200) {
            return "OK";
        }
        if (n == 461) {
            return "Unsupported Transport";
        }
        if (n == 500) {
            return "Internal Server Error";
        }
        if (n == 505) {
            return "RTSP Version Not Supported";
        }
        if (n == 301) {
            return "Move Permanently";
        }
        if (n == 302) {
            return "Move Temporarily";
        }
        if (n == 400) {
            return "Bad Request";
        }
        if (n == 401) {
            return "Unauthorized";
        }
        if (n == 404) {
            return "Not Found";
        }
        if (n == 405) {
            return "Method Not Allowed";
        }
        switch (n) {
            default: {
                throw new IllegalArgumentException();
            }
            case 457: {
                return "Invalid Range";
            }
            case 456: {
                return "Header Field Not Valid";
            }
            case 455: {
                return "Method Not Valid In This State";
            }
            case 454: {
                return "Session Not Found";
            }
        }
    }
    
    public static byte[] d(final String s) {
        return s.getBytes(RtspMessageChannel.g);
    }
    
    public static boolean e(final List<String> list) {
        return RtspMessageUtil.b.matcher(list.get(0)).matches();
    }
    
    public static boolean f(final String s) {
        return RtspMessageUtil.a.matcher(s).matches() || RtspMessageUtil.b.matcher(s).matches();
    }
    
    public static long g(final String s) throws ParserException {
        try {
            final Matcher matcher = RtspMessageUtil.c.matcher(s);
            if (matcher.find()) {
                return Long.parseLong(Assertions.e(matcher.group(1)));
            }
            return -1L;
        }
        catch (final NumberFormatException ex) {
            throw ParserException.createForMalformedManifest(s, ex);
        }
    }
    
    public static int h(final String s) throws ParserException {
        try {
            return Integer.parseInt(s);
        }
        catch (final NumberFormatException ex) {
            throw ParserException.createForMalformedManifest(s, ex);
        }
    }
    
    private static int i(final String s) {
        s.hashCode();
        final int hashCode = s.hashCode();
        int n = -1;
        switch (hashCode) {
            case 1800840907: {
                if (!s.equals("DESCRIBE")) {
                    break;
                }
                n = 11;
                break;
            }
            case 133006441: {
                if (!s.equals("ANNOUNCE")) {
                    break;
                }
                n = 10;
                break;
            }
            case 78791261: {
                if (!s.equals("SETUP")) {
                    break;
                }
                n = 9;
                break;
            }
            case 75902422: {
                if (!s.equals("PAUSE")) {
                    break;
                }
                n = 8;
                break;
            }
            case 71242700: {
                if (!s.equals("SET_PARAMETER")) {
                    break;
                }
                n = 7;
                break;
            }
            case 6481884: {
                if (!s.equals("REDIRECT")) {
                    break;
                }
                n = 6;
                break;
            }
            case 2458420: {
                if (!s.equals("PLAY")) {
                    break;
                }
                n = 5;
                break;
            }
            case -84360524: {
                if (!s.equals("PLAY_NOTIFY")) {
                    break;
                }
                n = 4;
                break;
            }
            case -531492226: {
                if (!s.equals("OPTIONS")) {
                    break;
                }
                n = 3;
                break;
            }
            case -702888512: {
                if (!s.equals("GET_PARAMETER")) {
                    break;
                }
                n = 2;
                break;
            }
            case -880847356: {
                if (!s.equals("TEARDOWN")) {
                    break;
                }
                n = 1;
                break;
            }
            case -1881579439: {
                if (!s.equals("RECORD")) {
                    break;
                }
                n = 0;
                break;
            }
        }
        switch (n) {
            default: {
                throw new IllegalArgumentException();
            }
            case 11: {
                return 2;
            }
            case 10: {
                return 1;
            }
            case 9: {
                return 10;
            }
            case 8: {
                return 5;
            }
            case 7: {
                return 11;
            }
            case 6: {
                return 9;
            }
            case 5: {
                return 6;
            }
            case 4: {
                return 7;
            }
            case 3: {
                return 4;
            }
            case 2: {
                return 3;
            }
            case 1: {
                return 12;
            }
            case 0: {
                return 8;
            }
        }
    }
    
    public static ImmutableList<Integer> j(final String s) {
        if (s == null) {
            return (ImmutableList<Integer>)ImmutableList.of();
        }
        final ImmutableList$Builder immutableList$Builder = new ImmutableList$Builder();
        final String[] t0 = Util.T0(s, ",\\s?");
        for (int length = t0.length, i = 0; i < length; ++i) {
            immutableList$Builder.i((Object)i(t0[i]));
        }
        return (ImmutableList<Integer>)immutableList$Builder.l();
    }
    
    public static RtspRequest k(final List<String> list) {
        final Pattern a = RtspMessageUtil.a;
        boolean b = false;
        final Matcher matcher = a.matcher(list.get(0));
        Assertions.a(matcher.matches());
        final int i = i(Assertions.e(matcher.group(1)));
        final Uri parse = Uri.parse((String)Assertions.e(matcher.group(2)));
        final int index = list.indexOf("");
        if (index > 0) {
            b = true;
        }
        Assertions.a(b);
        return new RtspRequest(parse, i, new RtspHeaders.Builder().c(list.subList(1, index)).e(), Joiner.i(RtspMessageUtil.h).e((Iterable)list.subList(index + 1, list.size())));
    }
    
    public static p l(final List<String> list) {
        final Pattern b = RtspMessageUtil.b;
        boolean b2 = false;
        final Matcher matcher = b.matcher(list.get(0));
        Assertions.a(matcher.matches());
        final int int1 = Integer.parseInt(Assertions.e(matcher.group(1)));
        final int index = list.indexOf("");
        if (index > 0) {
            b2 = true;
        }
        Assertions.a(b2);
        return new p(int1, new RtspHeaders.Builder().c(list.subList(1, index)).e(), Joiner.i(RtspMessageUtil.h).e((Iterable)list.subList(index + 1, list.size())));
    }
    
    public static RtspSessionHeader m(final String s) throws ParserException {
        final Matcher matcher = RtspMessageUtil.d.matcher(s);
        if (matcher.matches()) {
            final String s2 = Assertions.e(matcher.group(1));
            long n = 60000L;
            final String group = matcher.group(2);
            if (group != null) {
                try {
                    n = Integer.parseInt(group) * 1000L;
                }
                catch (final NumberFormatException ex) {
                    throw ParserException.createForMalformedManifest(s, ex);
                }
            }
            return new RtspSessionHeader(s2, n);
        }
        throw ParserException.createForMalformedManifest(s, null);
    }
    
    public static RtspAuthUserInfo n(final Uri uri) {
        final String userInfo = uri.getUserInfo();
        RtspAuthUserInfo rtspAuthUserInfo = null;
        if (userInfo == null) {
            return null;
        }
        if (userInfo.contains(":")) {
            final String[] u0 = Util.U0(userInfo, ":");
            rtspAuthUserInfo = new RtspAuthUserInfo(u0[0], u0[1]);
        }
        return rtspAuthUserInfo;
    }
    
    public static e o(final String s) throws ParserException {
        final Matcher matcher = RtspMessageUtil.e.matcher(s);
        if (matcher.find()) {
            return new e(2, Assertions.e(matcher.group(1)), Assertions.e(matcher.group(3)), Strings.e(matcher.group(4)));
        }
        final Matcher matcher2 = RtspMessageUtil.f.matcher(s);
        if (matcher2.matches()) {
            return new e(1, Assertions.e(matcher2.group(1)), "", "");
        }
        final StringBuilder sb = new StringBuilder();
        sb.append("Invalid WWW-Authenticate header ");
        sb.append(s);
        throw ParserException.createForMalformedManifest(sb.toString(), null);
    }
    
    public static Uri p(final Uri uri) {
        if (uri.getUserInfo() == null) {
            return uri;
        }
        final String s = Assertions.e(uri.getAuthority());
        Assertions.a(s.contains("@"));
        return uri.buildUpon().encodedAuthority(Util.T0(s, "@")[1]).build();
    }
    
    public static ImmutableList<String> q(final RtspRequest rtspRequest) {
        Assertions.a(rtspRequest.c.d("CSeq") != null);
        final ImmutableList$Builder immutableList$Builder = new ImmutableList$Builder();
        immutableList$Builder.i((Object)Util.C("%s %s %s", t(rtspRequest.b), rtspRequest.a, "RTSP/1.0"));
        final ImmutableListMultimap<String, String> b = rtspRequest.c.b();
        for (final String s : ((ImmutableMultimap)b).keySet()) {
            final ImmutableList value = b.get((Object)s);
            for (int i = 0; i < ((AbstractCollection)value).size(); ++i) {
                immutableList$Builder.i((Object)Util.C("%s: %s", s, ((List<Object>)value).get(i)));
            }
        }
        immutableList$Builder.i((Object)"");
        immutableList$Builder.i((Object)rtspRequest.d);
        return (ImmutableList<String>)immutableList$Builder.l();
    }
    
    public static ImmutableList<String> r(final p p) {
        Assertions.a(p.b.d("CSeq") != null);
        final ImmutableList$Builder immutableList$Builder = new ImmutableList$Builder();
        immutableList$Builder.i((Object)Util.C("%s %s %s", "RTSP/1.0", p.a, c(p.a)));
        final ImmutableListMultimap<String, String> b = p.b.b();
        for (final String s : ((ImmutableMultimap)b).keySet()) {
            final ImmutableList value = b.get((Object)s);
            for (int i = 0; i < ((AbstractCollection)value).size(); ++i) {
                immutableList$Builder.i((Object)Util.C("%s: %s", s, ((List<Object>)value).get(i)));
            }
        }
        immutableList$Builder.i((Object)"");
        immutableList$Builder.i((Object)p.c);
        return (ImmutableList<String>)immutableList$Builder.l();
    }
    
    public static String[] s(final String s) {
        String s2 = RtspMessageUtil.h;
        if (!s.contains(s2)) {
            s2 = RtspMessageUtil.g;
        }
        return Util.T0(s, s2);
    }
    
    public static String t(final int n) {
        switch (n) {
            default: {
                throw new IllegalStateException();
            }
            case 12: {
                return "TEARDOWN";
            }
            case 11: {
                return "SET_PARAMETER";
            }
            case 10: {
                return "SETUP";
            }
            case 9: {
                return "REDIRECT";
            }
            case 8: {
                return "RECORD";
            }
            case 7: {
                return "PLAY_NOTIFY";
            }
            case 6: {
                return "PLAY";
            }
            case 5: {
                return "PAUSE";
            }
            case 4: {
                return "OPTIONS";
            }
            case 3: {
                return "GET_PARAMETER";
            }
            case 2: {
                return "DESCRIBE";
            }
            case 1: {
                return "ANNOUNCE";
            }
        }
    }
    
    public static final class RtspAuthUserInfo
    {
        public final String a;
        public final String b;
        
        public RtspAuthUserInfo(final String a, final String b) {
            this.a = a;
            this.b = b;
        }
    }
    
    public static final class RtspSessionHeader
    {
        public final String a;
        public final long b;
        
        public RtspSessionHeader(final String a, final long b) {
            this.a = a;
            this.b = b;
        }
    }
}
