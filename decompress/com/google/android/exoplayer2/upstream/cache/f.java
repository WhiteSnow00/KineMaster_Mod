// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.exoplayer2.upstream.cache;

import com.google.android.exoplayer2.util.Util;
import java.util.regex.Matcher;
import com.google.android.exoplayer2.util.Assertions;
import java.io.File;
import java.util.regex.Pattern;

final class f extends CacheSpan
{
    private static final Pattern g;
    private static final Pattern h;
    private static final Pattern i;
    
    static {
        g = Pattern.compile("^(.+)\\.(\\d+)\\.(\\d+)\\.v1\\.exo$", 32);
        h = Pattern.compile("^(.+)\\.(\\d+)\\.(\\d+)\\.v2\\.exo$", 32);
        i = Pattern.compile("^(\\d+)\\.(\\d+)\\.(\\d+)\\.v3\\.exo$", 32);
    }
    
    private f(final String s, final long n, final long n2, final long n3, final File file) {
        super(s, n, n2, n3, file);
    }
    
    public static f g(File m, long length, long long1, final d d) {
        String s = m.getName();
        if (!s.endsWith(".v3.exo")) {
            m = m(m, d);
            if (m == null) {
                return null;
            }
            s = m.getName();
        }
        final Matcher matcher = f.i.matcher(s);
        if (!matcher.matches()) {
            return null;
        }
        final String k = d.k(Integer.parseInt(Assertions.e(matcher.group(1))));
        if (k == null) {
            return null;
        }
        if (length == -1L) {
            length = m.length();
        }
        if (length == 0L) {
            return null;
        }
        final long long2 = Long.parseLong(Assertions.e(matcher.group(2)));
        if (long1 == -9223372036854775807L) {
            long1 = Long.parseLong(Assertions.e(matcher.group(3)));
        }
        return new f(k, long2, length, long1, m);
    }
    
    public static f h(final File file, final long n, final d d) {
        return g(file, n, -9223372036854775807L, d);
    }
    
    public static f i(final String s, final long n, final long n2) {
        return new f(s, n, n2, -9223372036854775807L, null);
    }
    
    public static f k(final String s, final long n) {
        return new f(s, n, -1L, -9223372036854775807L, null);
    }
    
    public static File l(final File file, final int n, final long n2, final long n3) {
        final StringBuilder sb = new StringBuilder();
        sb.append(n);
        sb.append(".");
        sb.append(n2);
        sb.append(".");
        sb.append(n3);
        sb.append(".v3.exo");
        return new File(file, sb.toString());
    }
    
    private static File m(final File file, final d d) {
        final String name = file.getName();
        Matcher matcher = f.h.matcher(name);
        String e1;
        if (matcher.matches()) {
            e1 = Util.e1(Assertions.e(matcher.group(1)));
        }
        else {
            matcher = f.g.matcher(name);
            if (matcher.matches()) {
                e1 = Assertions.e(matcher.group(1));
            }
            else {
                e1 = null;
            }
        }
        if (e1 == null) {
            return null;
        }
        final File l = l(Assertions.i(file.getParentFile()), d.f(e1), Long.parseLong(Assertions.e(matcher.group(2))), Long.parseLong(Assertions.e(matcher.group(3))));
        if (!file.renameTo(l)) {
            return null;
        }
        return l;
    }
    
    public f f(final File file, final long n) {
        Assertions.g(super.d);
        return new f(super.a, super.b, super.c, n, file);
    }
}
