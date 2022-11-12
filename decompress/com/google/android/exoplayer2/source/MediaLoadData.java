// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.exoplayer2.source;

import com.google.android.exoplayer2.Format;

public final class MediaLoadData
{
    public final int a;
    public final int b;
    public final Format c;
    public final int d;
    public final Object e;
    public final long f;
    public final long g;
    
    public MediaLoadData(final int n) {
        this(n, -1, null, 0, null, -9223372036854775807L, -9223372036854775807L);
    }
    
    public MediaLoadData(final int a, final int b, final Format c, final int d, final Object e, final long f, final long g) {
        this.a = a;
        this.b = b;
        this.c = c;
        this.d = d;
        this.e = e;
        this.f = f;
        this.g = g;
    }
}
