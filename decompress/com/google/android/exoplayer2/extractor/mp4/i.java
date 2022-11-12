// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.exoplayer2.extractor.mp4;

import com.google.android.exoplayer2.util.Util;
import com.google.android.exoplayer2.util.Assertions;

final class i
{
    public final Track a;
    public final int b;
    public final long[] c;
    public final int[] d;
    public final int e;
    public final long[] f;
    public final int[] g;
    public final long h;
    
    public i(final Track a, final long[] c, final int[] d, int e, final long[] f, final int[] g, final long h) {
        final int length = d.length;
        final int length2 = f.length;
        final boolean b = false;
        Assertions.a(length == length2);
        Assertions.a(c.length == f.length);
        boolean b2 = b;
        if (g.length == f.length) {
            b2 = true;
        }
        Assertions.a(b2);
        this.a = a;
        this.c = c;
        this.d = d;
        this.e = e;
        this.f = f;
        this.g = g;
        this.h = h;
        this.b = c.length;
        if (g.length > 0) {
            e = g.length - 1;
            g[e] |= 0x20000000;
        }
    }
    
    public int a(final long n) {
        for (int i = Util.i(this.f, n, true, false); i >= 0; --i) {
            if ((this.g[i] & 0x1) != 0x0) {
                return i;
            }
        }
        return -1;
    }
    
    public int b(final long n) {
        for (int i = Util.e(this.f, n, true, false); i < this.f.length; ++i) {
            if ((this.g[i] & 0x1) != 0x0) {
                return i;
            }
        }
        return -1;
    }
}
