// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.exoplayer2.video;

import com.google.android.exoplayer2.util.ParsableByteArray;

public final class DolbyVisionConfig
{
    public final int a;
    public final int b;
    public final String c;
    
    private DolbyVisionConfig(final int a, final int b, final String c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }
    
    public static DolbyVisionConfig a(final ParsableByteArray parsableByteArray) {
        parsableByteArray.Q(2);
        final int d = parsableByteArray.D();
        final int n = d >> 1;
        final int n2 = (parsableByteArray.D() >> 3 & 0x1F) | (d & 0x1) << 5;
        String s;
        if (n != 4 && n != 5 && n != 7) {
            if (n == 8) {
                s = "hev1";
            }
            else {
                if (n != 9) {
                    return null;
                }
                s = "avc3";
            }
        }
        else {
            s = "dvhe";
        }
        final StringBuilder sb = new StringBuilder();
        sb.append(s);
        String s2 = ".0";
        sb.append(".0");
        sb.append(n);
        if (n2 >= 10) {
            s2 = ".";
        }
        sb.append(s2);
        sb.append(n2);
        return new DolbyVisionConfig(n, n2, sb.toString());
    }
}
