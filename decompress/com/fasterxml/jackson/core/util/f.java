// 
// Decompiled by Procyon v0.6.0
// 

package com.fasterxml.jackson.core.util;

import com.fasterxml.jackson.core.Version;
import java.util.regex.Pattern;

public class f
{
    private static final Pattern a;
    
    static {
        a = Pattern.compile("[-_./;:]");
    }
    
    public static Version a(String trim, final String s, final String s2) {
        if (trim != null) {
            trim = trim.trim();
            if (trim.length() > 0) {
                final String[] split = f.a.split(trim);
                int b = 0;
                final int b2 = b(split[0]);
                int b3;
                if (split.length > 1) {
                    b3 = b(split[1]);
                }
                else {
                    b3 = 0;
                }
                if (split.length > 2) {
                    b = b(split[2]);
                }
                if (split.length > 3) {
                    trim = split[3];
                }
                else {
                    trim = null;
                }
                return new Version(b2, b3, b, trim, s, s2);
            }
        }
        return Version.unknownVersion();
    }
    
    protected static int b(final String s) {
        final int length = s.length();
        int i = 0;
        int n = 0;
        while (i < length) {
            final char char1 = s.charAt(i);
            if (char1 > '9') {
                break;
            }
            if (char1 < '0') {
                break;
            }
            n = n * 10 + (char1 - '0');
            ++i;
        }
        return n;
    }
    
    public static final void c() {
        throw new RuntimeException("Internal error: this code path should never get executed");
    }
}
