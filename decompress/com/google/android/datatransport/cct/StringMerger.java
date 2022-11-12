// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.datatransport.cct;

public final class StringMerger
{
    static String a(final String s, final String s2) {
        final int n = s.length() - s2.length();
        if (n >= 0 && n <= 1) {
            final StringBuilder sb = new StringBuilder(s.length() + s2.length());
            for (int i = 0; i < s.length(); ++i) {
                sb.append(s.charAt(i));
                if (s2.length() > i) {
                    sb.append(s2.charAt(i));
                }
            }
            return sb.toString();
        }
        throw new IllegalArgumentException("Invalid input received");
    }
}
