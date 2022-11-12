// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.exoplayer2.source.ads;

import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.Timeline;
import com.google.android.exoplayer2.source.ForwardingTimeline;

public final class SinglePeriodAdTimeline extends ForwardingTimeline
{
    private final AdPlaybackState d;
    
    public SinglePeriodAdTimeline(final Timeline timeline, final AdPlaybackState d) {
        super(timeline);
        final int m = timeline.m();
        final boolean b = false;
        Assertions.g(m == 1);
        boolean b2 = b;
        if (timeline.t() == 1) {
            b2 = true;
        }
        Assertions.g(b2);
        this.d = d;
    }
    
    @Override
    public Period k(final int n, final Period period, final boolean b) {
        super.c.k(n, period, b);
        long n2;
        if ((n2 = period.d) == -9223372036854775807L) {
            n2 = this.d.d;
        }
        period.x(period.a, period.b, period.c, n2, period.r(), this.d, period.f);
        return period;
    }
}
