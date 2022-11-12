// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.exoplayer2.source;

import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.AbstractConcatenatedTimeline;
import com.google.android.exoplayer2.upstream.Allocator;
import com.google.android.exoplayer2.upstream.TransferListener;
import com.google.android.exoplayer2.MediaItem;
import com.google.android.exoplayer2.Timeline;
import java.util.Map;

@Deprecated
public final class LoopingMediaSource extends CompositeMediaSource<Void>
{
    private final MaskingMediaSource p;
    private final int w;
    private final Map<MediaPeriodId, MediaPeriodId> x;
    private final Map<MediaPeriod, MediaPeriodId> y;
    
    protected void A0(final Void void1, final MediaSource mediaSource, final Timeline timeline) {
        Timeline timeline2;
        if (this.w != Integer.MAX_VALUE) {
            timeline2 = new b(timeline, this.w);
        }
        else {
            timeline2 = new a(timeline);
        }
        this.n0(timeline2);
    }
    
    @Override
    public MediaItem F() {
        return this.p.F();
    }
    
    @Override
    public void I(final MediaPeriod mediaPeriod) {
        this.p.I(mediaPeriod);
        final MediaPeriodId mediaPeriodId = this.y.remove(mediaPeriod);
        if (mediaPeriodId != null) {
            this.x.remove(mediaPeriodId);
        }
    }
    
    @Override
    public boolean V() {
        return false;
    }
    
    @Override
    public Timeline W() {
        Timeline timeline;
        if (this.w != Integer.MAX_VALUE) {
            timeline = new b(this.p.D0(), this.w);
        }
        else {
            timeline = new a(this.p.D0());
        }
        return timeline;
    }
    
    @Override
    protected void m0(final TransferListener transferListener) {
        super.m0(transferListener);
        this.x0(null, this.p);
    }
    
    @Override
    protected /* bridge */ MediaPeriodId s0(final Object o, final MediaPeriodId mediaPeriodId) {
        return this.z0((Void)o, mediaPeriodId);
    }
    
    @Override
    public MediaPeriod u(final MediaPeriodId mediaPeriodId, final Allocator allocator, final long n) {
        if (this.w == Integer.MAX_VALUE) {
            return this.p.z0(mediaPeriodId, allocator, n);
        }
        final MediaSource.MediaPeriodId c = mediaPeriodId.c(AbstractConcatenatedTimeline.B(mediaPeriodId.a));
        this.x.put(c, mediaPeriodId);
        final MaskingMediaPeriod z0 = this.p.z0(c, allocator, n);
        this.y.put(z0, c);
        return z0;
    }
    
    @Override
    protected /* bridge */ void w0(final Object o, final MediaSource mediaSource, final Timeline timeline) {
        this.A0((Void)o, mediaSource, timeline);
    }
    
    protected MediaPeriodId z0(final Void void1, final MediaPeriodId mediaPeriodId) {
        MediaPeriodId mediaPeriodId2 = mediaPeriodId;
        if (this.w != Integer.MAX_VALUE) {
            mediaPeriodId2 = this.x.get(mediaPeriodId);
        }
        return mediaPeriodId2;
    }
    
    private static final class a extends ForwardingTimeline
    {
        public a(final Timeline timeline) {
            super(timeline);
        }
        
        @Override
        public int i(int n, int n2, final boolean b) {
            n2 = (n = super.c.i(n, n2, b));
            if (n2 == -1) {
                n = this.e(b);
            }
            return n;
        }
        
        @Override
        public int p(int n, int n2, final boolean b) {
            n2 = (n = super.c.p(n, n2, b));
            if (n2 == -1) {
                n = this.g(b);
            }
            return n;
        }
    }
    
    private static final class b extends AbstractConcatenatedTimeline
    {
        private final Timeline f;
        private final int g;
        private final int h;
        private final int i;
        
        public b(final Timeline f, final int i) {
            final ShuffleOrder.UnshuffledShuffleOrder unshuffledShuffleOrder = new ShuffleOrder.UnshuffledShuffleOrder(i);
            boolean b = false;
            super(false, unshuffledShuffleOrder);
            this.f = f;
            final int m = f.m();
            this.g = m;
            this.h = f.t();
            this.i = i;
            if (m > 0) {
                if (i <= Integer.MAX_VALUE / m) {
                    b = true;
                }
                Assertions.h(b, "LoopingMediaSource contains too many periods");
            }
        }
        
        @Override
        protected int A(final int n) {
            return n / this.h;
        }
        
        @Override
        protected Object D(final int n) {
            return n;
        }
        
        @Override
        protected int F(final int n) {
            return n * this.g;
        }
        
        @Override
        protected int G(final int n) {
            return n * this.h;
        }
        
        @Override
        protected Timeline J(final int n) {
            return this.f;
        }
        
        @Override
        public int m() {
            return this.g * this.i;
        }
        
        @Override
        public int t() {
            return this.h * this.i;
        }
        
        @Override
        protected int y(final Object o) {
            if (!(o instanceof Integer)) {
                return -1;
            }
            return (int)o;
        }
        
        @Override
        protected int z(final int n) {
            return n / this.g;
        }
    }
}
