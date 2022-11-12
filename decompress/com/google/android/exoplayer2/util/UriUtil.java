// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.exoplayer2.util;

import android.net.Uri;
import android.text.TextUtils;

public final class UriUtil
{
    private UriUtil() {
    }
    
    private static int[] a(final String s) {
        final int[] array = new int[4];
        if (TextUtils.isEmpty((CharSequence)s)) {
            array[0] = -1;
            return array;
        }
        final int length = s.length();
        int index = s.indexOf(35);
        if (index == -1) {
            index = length;
        }
        final int index2 = s.indexOf(63);
        int n;
        if (index2 == -1 || (n = index2) > index) {
            n = index;
        }
        final int index3 = s.indexOf(47);
        int n2;
        if (index3 == -1 || (n2 = index3) > n) {
            n2 = n;
        }
        int index4;
        if ((index4 = s.indexOf(58)) > n2) {
            index4 = -1;
        }
        final int n3 = index4 + 2;
        int n4;
        if (n3 < n && s.charAt(index4 + 1) == '/' && s.charAt(n3) == '/') {
            final int index5 = s.indexOf(47, index4 + 3);
            if (index5 == -1 || (n4 = index5) > n) {
                n4 = n;
            }
        }
        else {
            n4 = index4 + 1;
        }
        array[0] = index4;
        array[1] = n4;
        array[2] = n;
        array[3] = index;
        return array;
    }
    
    public static boolean b(final String s) {
        boolean b = false;
        if (s != null) {
            b = b;
            if (a(s)[0] != -1) {
                b = true;
            }
        }
        return b;
    }
    
    private static String c(final StringBuilder sb, int i, int n) {
        if (i >= n) {
            return sb.toString();
        }
        int n2 = i;
        if (sb.charAt(i) == '/') {
            n2 = i + 1;
        }
        int n3;
        i = (n3 = n2);
        while (i <= n) {
            int n4;
            if (i == n) {
                n4 = i;
            }
            else {
                if (sb.charAt(i) != '/') {
                    ++i;
                    continue;
                }
                n4 = i + 1;
            }
            final int n5 = n3 + 1;
            if (i == n5 && sb.charAt(n3) == '.') {
                sb.delete(n3, n4);
                n -= n4 - n3;
            }
            else {
                if (i == n3 + 2 && sb.charAt(n3) == '.' && sb.charAt(n5) == '.') {
                    i = sb.lastIndexOf("/", n3 - 2) + 1;
                    int n6;
                    if (i > n2) {
                        n6 = i;
                    }
                    else {
                        n6 = n2;
                    }
                    sb.delete(n6, n4);
                    n -= n4 - n6;
                }
                else {
                    ++i;
                }
                n3 = i;
            }
            i = n3;
        }
        return sb.toString();
    }
    
    public static String d(String s, final String s2) {
        final StringBuilder sb = new StringBuilder();
        String s3 = s;
        if (s == null) {
            s3 = "";
        }
        if ((s = s2) == null) {
            s = "";
        }
        final int[] a = a(s);
        if (a[0] != -1) {
            sb.append(s);
            c(sb, a[1], a[2]);
            return sb.toString();
        }
        final int[] a2 = a(s3);
        if (a[3] == 0) {
            sb.append(s3, 0, a2[3]);
            sb.append(s);
            return sb.toString();
        }
        if (a[2] == 0) {
            sb.append(s3, 0, a2[2]);
            sb.append(s);
            return sb.toString();
        }
        if (a[1] != 0) {
            final int n = a2[0] + 1;
            sb.append(s3, 0, n);
            sb.append(s);
            return c(sb, a[1] + n, n + a[2]);
        }
        if (s.charAt(a[1]) == '/') {
            sb.append(s3, 0, a2[1]);
            sb.append(s);
            return c(sb, a2[1], a2[1] + a[2]);
        }
        if (a2[0] + 2 < a2[1] && a2[1] == a2[2]) {
            sb.append(s3, 0, a2[1]);
            sb.append('/');
            sb.append(s);
            return c(sb, a2[1], a2[1] + a[2] + 1);
        }
        int lastIndex = s3.lastIndexOf(47, a2[2] - 1);
        if (lastIndex == -1) {
            lastIndex = a2[1];
        }
        else {
            ++lastIndex;
        }
        sb.append(s3, 0, lastIndex);
        sb.append(s);
        return c(sb, a2[1], lastIndex + a[2]);
    }
    
    public static Uri e(final String s, final String s2) {
        return Uri.parse(d(s, s2));
    }
}
