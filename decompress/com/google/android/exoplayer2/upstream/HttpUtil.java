// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.exoplayer2.upstream;

import java.util.regex.Matcher;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.Log;
import android.text.TextUtils;
import java.util.regex.Pattern;

public final class HttpUtil
{
    private static final Pattern a;
    private static final Pattern b;
    
    static {
        a = Pattern.compile("bytes (\\d+)-(\\d+)/(?:\\d+|\\*)");
        b = Pattern.compile("bytes (?:(?:\\d+-\\d+)|\\*)/(\\d+)");
    }
    
    private HttpUtil() {
    }
    
    public static String a(final long n, final long n2) {
        if (n == 0L && n2 == -1L) {
            return null;
        }
        final StringBuilder sb = new StringBuilder();
        sb.append("bytes=");
        sb.append(n);
        sb.append("-");
        if (n2 != -1L) {
            sb.append(n + n2 - 1L);
        }
        return sb.toString();
    }
    
    public static long b(final String s, final String s2) {
        long long1 = 0L;
        Label_0063: {
            if (!TextUtils.isEmpty((CharSequence)s)) {
                try {
                    long1 = Long.parseLong(s);
                    break Label_0063;
                }
                catch (final NumberFormatException ex) {
                    final StringBuilder sb = new StringBuilder();
                    sb.append("Unexpected Content-Length [");
                    sb.append(s);
                    sb.append("]");
                    Log.c("HttpUtil", sb.toString());
                }
            }
            long1 = -1L;
        }
        long max = long1;
        if (!TextUtils.isEmpty((CharSequence)s2)) {
            final Matcher matcher = HttpUtil.a.matcher(s2);
            max = long1;
            if (matcher.matches()) {
                try {
                    final long n = Long.parseLong(Assertions.e(matcher.group(2))) - Long.parseLong(Assertions.e(matcher.group(1))) + 1L;
                    if (long1 < 0L) {
                        max = n;
                    }
                    else {
                        max = long1;
                        if (long1 != n) {
                            final StringBuilder sb2 = new StringBuilder();
                            sb2.append("Inconsistent headers [");
                            sb2.append(s);
                            sb2.append("] [");
                            sb2.append(s2);
                            sb2.append("]");
                            Log.i("HttpUtil", sb2.toString());
                            max = Math.max(long1, n);
                        }
                    }
                }
                catch (final NumberFormatException ex2) {
                    final StringBuilder sb3 = new StringBuilder();
                    sb3.append("Unexpected Content-Range [");
                    sb3.append(s2);
                    sb3.append("]");
                    Log.c("HttpUtil", sb3.toString());
                    max = long1;
                }
            }
        }
        return max;
    }
    
    public static long c(final String s) {
        final boolean empty = TextUtils.isEmpty((CharSequence)s);
        long long1 = -1L;
        if (empty) {
            return -1L;
        }
        final Matcher matcher = HttpUtil.b.matcher(s);
        if (matcher.matches()) {
            long1 = Long.parseLong(Assertions.e(matcher.group(1)));
        }
        return long1;
    }
}
