// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.exoplayer2.audio;

import com.google.android.exoplayer2.util.Util;

public final class WavUtil
{
    private WavUtil() {
    }
    
    public static int a(int n, final int n2) {
        if (n != 1) {
            final int n3 = 0;
            if (n == 3) {
                n = n3;
                if (n2 == 32) {
                    n = 4;
                }
                return n;
            }
            if (n != 65534) {
                return 0;
            }
        }
        return Util.c0(n2);
    }
    
    public static int b(final int n) {
        if (n != 2 && n != 3) {
            if (n == 4) {
                return 3;
            }
            if (n != 536870912) {
                if (n != 805306368) {
                    throw new IllegalArgumentException();
                }
            }
        }
        return 1;
    }
}
