// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.exoplayer2.source.dash.manifest;

import java.util.Locale;

public final class UrlTemplate
{
    private final String[] a;
    private final int[] b;
    private final String[] c;
    private final int d;
    
    private UrlTemplate(final String[] a, final int[] b, final String[] c, final int d) {
        this.a = a;
        this.b = b;
        this.c = c;
        this.d = d;
    }
    
    public static UrlTemplate b(final String s) {
        final String[] array = new String[5];
        final int[] array2 = new int[4];
        final String[] array3 = new String[4];
        return new UrlTemplate(array, array2, array3, c(s, array, array2, array3));
    }
    
    private static int c(final String s, final String[] array, final int[] array2, final String[] array3) {
        array[0] = "";
        int i = 0;
        int n = 0;
        while (i < s.length()) {
            final int index = s.indexOf("$", i);
            final int n2 = -1;
            if (index == -1) {
                final StringBuilder sb = new StringBuilder();
                sb.append(array[n]);
                sb.append(s.substring(i));
                array[n] = sb.toString();
                i = s.length();
            }
            else if (index != i) {
                final StringBuilder sb2 = new StringBuilder();
                sb2.append(array[n]);
                sb2.append(s.substring(i, index));
                array[n] = sb2.toString();
                i = index;
            }
            else if (s.startsWith("$$", i)) {
                final StringBuilder sb3 = new StringBuilder();
                sb3.append(array[n]);
                sb3.append("$");
                array[n] = sb3.toString();
                i += 2;
            }
            else {
                ++i;
                final int index2 = s.indexOf("$", i);
                String s2 = s.substring(i, index2);
                if (s2.equals("RepresentationID")) {
                    array2[n] = 1;
                }
                else {
                    final int index3 = s2.indexOf("%0");
                    String s4;
                    if (index3 != -1) {
                        final String s3 = s4 = s2.substring(index3);
                        if (!s3.endsWith("d")) {
                            s4 = s3;
                            if (!s3.endsWith("x")) {
                                s4 = s3;
                                if (!s3.endsWith("X")) {
                                    final StringBuilder sb4 = new StringBuilder();
                                    sb4.append(s3);
                                    sb4.append("d");
                                    s4 = sb4.toString();
                                }
                            }
                        }
                        s2 = s2.substring(0, index3);
                    }
                    else {
                        s4 = "%01d";
                    }
                    s2.hashCode();
                    int n3 = 0;
                    switch (s2.hashCode()) {
                        default: {
                            n3 = n2;
                            break;
                        }
                        case 38199441: {
                            if (!s2.equals("Bandwidth")) {
                                n3 = n2;
                                break;
                            }
                            n3 = 2;
                            break;
                        }
                        case 2606829: {
                            if (!s2.equals("Time")) {
                                n3 = n2;
                                break;
                            }
                            n3 = 1;
                            break;
                        }
                        case -1950496919: {
                            if (!s2.equals("Number")) {
                                n3 = n2;
                                break;
                            }
                            n3 = 0;
                            break;
                        }
                    }
                    switch (n3) {
                        default: {
                            final StringBuilder sb5 = new StringBuilder();
                            sb5.append("Invalid template: ");
                            sb5.append(s);
                            throw new IllegalArgumentException(sb5.toString());
                        }
                        case 2: {
                            array2[n] = 3;
                            break;
                        }
                        case 1: {
                            array2[n] = 4;
                            break;
                        }
                        case 0: {
                            array2[n] = 2;
                            break;
                        }
                    }
                    array3[n] = s4;
                }
                ++n;
                array[n] = "";
                i = index2 + 1;
            }
        }
        return n;
    }
    
    public String a(final String s, final long n, final int n2, final long n3) {
        final StringBuilder sb = new StringBuilder();
        int n4 = 0;
        int d;
        while (true) {
            d = this.d;
            if (n4 >= d) {
                break;
            }
            sb.append(this.a[n4]);
            final int[] b = this.b;
            if (b[n4] == 1) {
                sb.append(s);
            }
            else if (b[n4] == 2) {
                sb.append(String.format(Locale.US, this.c[n4], n));
            }
            else if (b[n4] == 3) {
                sb.append(String.format(Locale.US, this.c[n4], n2));
            }
            else if (b[n4] == 4) {
                sb.append(String.format(Locale.US, this.c[n4], n3));
            }
            ++n4;
        }
        sb.append(this.a[d]);
        return sb.toString();
    }
}
