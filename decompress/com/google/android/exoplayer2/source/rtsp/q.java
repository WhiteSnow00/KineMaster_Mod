// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.exoplayer2.source.rtsp;

import java.util.regex.Matcher;
import com.google.android.exoplayer2.ParserException;
import com.google.android.exoplayer2.util.Util;
import java.util.regex.Pattern;

final class q
{
    public static final q c;
    private static final Pattern d;
    public final long a;
    public final long b;
    
    static {
        c = new q(0L, -9223372036854775807L);
        d = Pattern.compile("npt[:=]([.\\d]+|now)\\s?-\\s?([.\\d]+)?");
    }
    
    private q(final long a, final long b) {
        this.a = a;
        this.b = b;
    }
    
    public static String b(final long n) {
        return Util.C("npt=%.3f-", n / 1000.0);
    }
    
    public static q d(final String s) throws ParserException {
        final Matcher matcher = q.d.matcher(s);
        RtspMessageUtil.a(matcher.matches(), s);
        final boolean b = true;
        final String group = matcher.group(1);
        RtspMessageUtil.a(group != null, s);
        long n;
        if (Util.j(group).equals("now")) {
            n = 0L;
        }
        else {
            n = (long)(Float.parseFloat(group) * 1000.0f);
        }
        final String group2 = matcher.group(2);
        if (group2 != null) {
            try {
                final long n2 = (long)(Float.parseFloat(group2) * 1000.0f);
                RtspMessageUtil.a(n2 >= n && b, s);
                return new q(n, n2);
            }
            catch (final NumberFormatException ex) {
                throw ParserException.createForMalformedManifest(group2, ex);
            }
        }
        final long n2 = -9223372036854775807L;
        return new q(n, n2);
    }
    
    public long a() {
        return this.b - this.a;
    }
    
    public boolean c() {
        return this.b == -9223372036854775807L;
    }
}
