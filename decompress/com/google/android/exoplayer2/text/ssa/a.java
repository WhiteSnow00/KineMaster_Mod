// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.exoplayer2.text.ssa;

import com.google.common.base.Ascii;
import android.text.TextUtils;
import com.google.android.exoplayer2.util.Assertions;

final class a
{
    public final int a;
    public final int b;
    public final int c;
    public final int d;
    public final int e;
    
    private a(final int a, final int b, final int c, final int d, final int e) {
        this.a = a;
        this.b = b;
        this.c = c;
        this.d = d;
        this.e = e;
    }
    
    public static a a(final String s) {
        Assertions.a(s.startsWith("Format:"));
        final String[] split = TextUtils.split(s.substring(7), ",");
        final int n = 0;
        int n2 = -1;
        int n3 = -1;
        int n5;
        int n4 = n5 = n3;
        for (int i = n; i < split.length; ++i) {
            final String e = Ascii.e(split[i].trim());
            e.hashCode();
            int n6 = 0;
            Label_0182: {
                switch (e) {
                    case "style": {
                        n6 = 3;
                        break Label_0182;
                    }
                    case "start": {
                        n6 = 2;
                        break Label_0182;
                    }
                    case "text": {
                        n6 = 1;
                        break Label_0182;
                    }
                    case "end": {
                        n6 = 0;
                        break Label_0182;
                    }
                    default:
                        break;
                }
                n6 = -1;
            }
            switch (n6) {
                case 3: {
                    n5 = i;
                    break;
                }
                case 2: {
                    n2 = i;
                    break;
                }
                case 1: {
                    n4 = i;
                    break;
                }
                case 0: {
                    n3 = i;
                    break;
                }
            }
        }
        a a;
        if (n2 != -1 && n3 != -1 && n4 != -1) {
            a = new a(n2, n3, n5, n4, split.length);
        }
        else {
            a = null;
        }
        return a;
    }
}
