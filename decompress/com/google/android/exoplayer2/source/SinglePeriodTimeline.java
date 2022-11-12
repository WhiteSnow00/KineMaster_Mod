// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.exoplayer2.source;

import com.google.android.exoplayer2.Bundleable;
import com.google.android.exoplayer2.util.Assertions;
import android.net.Uri;
import com.google.android.exoplayer2.MediaItem;
import com.google.android.exoplayer2.Timeline;

public final class SinglePeriodTimeline extends Timeline
{
    private static final Object A;
    private static final MediaItem B;
    private final long c;
    private final long d;
    private final long e;
    private final long f;
    private final long g;
    private final long h;
    private final long i;
    private final boolean j;
    private final boolean p;
    private final boolean w;
    private final Object x;
    private final MediaItem y;
    private final MediaItem.LiveConfiguration z;
    
    static {
        A = new Object();
        B = new MediaItem.Builder().e("SinglePeriodTimeline").i(Uri.EMPTY).a();
    }
    
    public SinglePeriodTimeline(final long c, final long d, final long e, final long f, final long g, final long h, final long i, final boolean j, final boolean p13, final boolean w, final Object x, final MediaItem mediaItem, final MediaItem.LiveConfiguration z) {
        this.c = c;
        this.d = d;
        this.e = e;
        this.f = f;
        this.g = g;
        this.h = h;
        this.i = i;
        this.j = j;
        this.p = p13;
        this.w = w;
        this.x = x;
        this.y = Assertions.e(mediaItem);
        this.z = z;
    }
    
    public SinglePeriodTimeline(final long n, final long n2, final long n3, final long n4, final boolean b, final boolean b2, final boolean b3, final Object o, final MediaItem mediaItem) {
        Bundleable d;
        if (b3) {
            d = mediaItem.d;
        }
        else {
            d = null;
        }
        this(-9223372036854775807L, -9223372036854775807L, -9223372036854775807L, n, n2, n3, n4, b, b2, false, o, mediaItem, (MediaItem.LiveConfiguration)d);
    }
    
    public SinglePeriodTimeline(final long n, final boolean b, final boolean b2, final boolean b3, final Object o, final MediaItem mediaItem) {
        this(n, n, 0L, 0L, b, b2, b3, o, mediaItem);
    }
    
    @Override
    public int f(final Object o) {
        int n;
        if (SinglePeriodTimeline.A.equals(o)) {
            n = 0;
        }
        else {
            n = -1;
        }
        return n;
    }
    
    @Override
    public Period k(final int n, final Period period, final boolean b) {
        Assertions.c(n, 0, 1);
        Object a;
        if (b) {
            a = SinglePeriodTimeline.A;
        }
        else {
            a = null;
        }
        return period.w(null, a, 0, this.f, -this.h);
    }
    
    @Override
    public int m() {
        return 1;
    }
    
    @Override
    public Object q(final int n) {
        Assertions.c(n, 0, 1);
        return SinglePeriodTimeline.A;
    }
    
    @Override
    public Window s(final int n, final Window window, long n2) {
        Assertions.c(n, 0, 1);
        final long i = this.i;
        final boolean p3 = this.p;
        long n3 = i;
        if (p3) {
            n3 = i;
            if (!this.w) {
                n3 = i;
                if (n2 != 0L) {
                    final long g = this.g;
                    if (g != -9223372036854775807L) {
                        n2 = (n3 = i + n2);
                        if (n2 <= g) {
                            return window.k(Window.C, this.y, this.x, this.c, this.d, this.e, this.j, p3, this.z, n3, this.g, 0, 0, this.h);
                        }
                    }
                    n3 = -9223372036854775807L;
                }
            }
        }
        return window.k(Window.C, this.y, this.x, this.c, this.d, this.e, this.j, p3, this.z, n3, this.g, 0, 0, this.h);
    }
    
    @Override
    public int t() {
        return 1;
    }
}
