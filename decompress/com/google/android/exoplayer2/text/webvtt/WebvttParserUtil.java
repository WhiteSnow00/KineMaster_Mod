// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.exoplayer2.text.webvtt;

import com.google.android.exoplayer2.ParserException;
import com.google.android.exoplayer2.util.Util;
import java.util.regex.Matcher;
import com.google.android.exoplayer2.util.ParsableByteArray;
import java.util.regex.Pattern;

public final class WebvttParserUtil
{
    private static final Pattern a;
    
    static {
        a = Pattern.compile("^NOTE([ \t].*)?$");
    }
    
    private WebvttParserUtil() {
    }
    
    public static Matcher a(final ParsableByteArray parsableByteArray) {
        while (true) {
            final String p = parsableByteArray.p();
            if (p == null) {
                return null;
            }
            if (WebvttParserUtil.a.matcher(p).matches()) {
                String p2;
                do {
                    p2 = parsableByteArray.p();
                } while (p2 != null && !p2.isEmpty());
            }
            else {
                final Matcher matcher = WebvttCueParser.a.matcher(p);
                if (matcher.matches()) {
                    return matcher;
                }
                continue;
            }
        }
    }
    
    public static boolean b(final ParsableByteArray parsableByteArray) {
        final String p = parsableByteArray.p();
        return p != null && p.startsWith("WEBVTT");
    }
    
    public static float c(final String s) throws NumberFormatException {
        if (s.endsWith("%")) {
            return Float.parseFloat(s.substring(0, s.length() - 1)) / 100.0f;
        }
        throw new NumberFormatException("Percentages must end with %");
    }
    
    public static long d(final String s) throws NumberFormatException {
        final String[] u0 = Util.U0(s, "\\.");
        int i = 0;
        final String[] t0 = Util.T0(u0[0], ":");
        final int length = t0.length;
        long n = 0L;
        while (i < length) {
            n = n * 60L + Long.parseLong(t0[i]);
            ++i;
        }
        long n2 = n * 1000L;
        if (u0.length == 2) {
            n2 += Long.parseLong(u0[1]);
        }
        return n2 * 1000L;
    }
    
    public static void e(final ParsableByteArray parsableByteArray) throws ParserException {
        final int e = parsableByteArray.e();
        if (b(parsableByteArray)) {
            return;
        }
        parsableByteArray.P(e);
        final StringBuilder sb = new StringBuilder();
        sb.append("Expected WEBVTT. Got ");
        sb.append(parsableByteArray.p());
        throw ParserException.createForMalformedContainer(sb.toString(), null);
    }
}
