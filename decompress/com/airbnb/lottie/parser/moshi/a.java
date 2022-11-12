// 
// Decompiled by Procyon v0.6.0
// 

package com.airbnb.lottie.parser.moshi;

final class a
{
    static String a(final int n, final int[] array, final String[] array2, final int[] array3) {
        final StringBuilder sb = new StringBuilder();
        sb.append('$');
        for (int i = 0; i < n; ++i) {
            final int n2 = array[i];
            if (n2 != 1 && n2 != 2) {
                if (n2 == 3 || n2 == 4 || n2 == 5) {
                    sb.append('.');
                    if (array2[i] != null) {
                        sb.append(array2[i]);
                    }
                }
            }
            else {
                sb.append('[');
                sb.append(array3[i]);
                sb.append(']');
            }
        }
        return sb.toString();
    }
}
