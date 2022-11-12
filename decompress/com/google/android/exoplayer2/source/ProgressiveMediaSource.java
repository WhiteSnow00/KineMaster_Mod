// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.exoplayer2.source;

import com.google.android.exoplayer2.analytics.PlayerId;
import com.google.android.exoplayer2.upstream.DefaultLoadErrorHandlingPolicy;
import com.google.android.exoplayer2.drm.DefaultDrmSessionManagerProvider;
import com.google.android.exoplayer2.extractor.ExtractorsFactory;
import com.google.android.exoplayer2.extractor.DefaultExtractorsFactory;
import com.google.android.exoplayer2.drm.DrmSessionManagerProvider;
import com.google.android.exoplayer2.upstream.Allocator;
import android.os.Looper;
import com.google.android.exoplayer2.Timeline;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.upstream.LoadErrorHandlingPolicy;
import com.google.android.exoplayer2.drm.DrmSessionManager;
import com.google.android.exoplayer2.upstream.DataSource;
import com.google.android.exoplayer2.MediaItem;
import com.google.android.exoplayer2.upstream.TransferListener;

public final class ProgressiveMediaSource extends BaseMediaSource implements b
{
    private long A;
    private boolean B;
    private boolean C;
    private TransferListener D;
    private final MediaItem h;
    private final MediaItem.LocalConfiguration i;
    private final DataSource.Factory j;
    private final ProgressiveMediaExtractor.Factory p;
    private final DrmSessionManager w;
    private final LoadErrorHandlingPolicy x;
    private final int y;
    private boolean z;
    
    private ProgressiveMediaSource(final MediaItem h, final DataSource.Factory j, final ProgressiveMediaExtractor.Factory p6, final DrmSessionManager w, final LoadErrorHandlingPolicy x, final int y) {
        this.i = Assertions.e(h.b);
        this.h = h;
        this.j = j;
        this.p = p6;
        this.w = w;
        this.x = x;
        this.y = y;
        this.z = true;
        this.A = -9223372036854775807L;
    }
    
    ProgressiveMediaSource(final MediaItem mediaItem, final DataSource.Factory factory, final ProgressiveMediaExtractor.Factory factory2, final DrmSessionManager drmSessionManager, final LoadErrorHandlingPolicy loadErrorHandlingPolicy, final int n, final ProgressiveMediaSource$a forwardingTimeline) {
        this(mediaItem, factory, factory2, drmSessionManager, loadErrorHandlingPolicy, n);
    }
    
    private void p0() {
        Timeline timeline;
        final SinglePeriodTimeline singlePeriodTimeline = (SinglePeriodTimeline)(timeline = new SinglePeriodTimeline(this.A, this.B, (boolean)(0 != 0), this.C, null, this.h));
        if (this.z) {
            timeline = new ForwardingTimeline(this, singlePeriodTimeline) {
                @Override
                public Period k(final int n, final Period period, final boolean b) {
                    super.k(n, period, b);
                    period.f = true;
                    return period;
                }
                
                @Override
                public Window s(final int n, final Window window, final long n2) {
                    super.s(n, window, n2);
                    window.w = true;
                    return window;
                }
            };
        }
        this.n0(timeline);
    }
    
    @Override
    public MediaItem F() {
        return this.h;
    }
    
    @Override
    public void I(final MediaPeriod mediaPeriod) {
        ((u)mediaPeriod).e0();
    }
    
    @Override
    public void R(final long n, final boolean b, final boolean c) {
        long a = n;
        if (n == -9223372036854775807L) {
            a = this.A;
        }
        if (!this.z && this.A == a && this.B == b && this.C == c) {
            return;
        }
        this.A = a;
        this.B = b;
        this.C = c;
        this.z = false;
        this.p0();
    }
    
    @Override
    public void U() {
    }
    
    @Override
    protected void m0(final TransferListener d) {
        this.D = d;
        this.w.prepare();
        this.w.b(Assertions.e(Looper.myLooper()), this.k0());
        this.p0();
    }
    
    @Override
    protected void o0() {
        this.w.release();
    }
    
    @Override
    public MediaPeriod u(final MediaPeriodId mediaPeriodId, final Allocator allocator, final long n) {
        final DataSource dataSource = this.j.createDataSource();
        final TransferListener d = this.D;
        if (d != null) {
            dataSource.e(d);
        }
        return new u(this.i.a, dataSource, this.p.a(this.k0()), this.w, this.e0(mediaPeriodId), this.x, this.g0(mediaPeriodId), (u.b)this, allocator, this.i.f, this.y);
    }
    
    public static final class Factory implements MediaSourceFactory
    {
        private final DataSource.Factory a;
        private ProgressiveMediaExtractor.Factory b;
        private DrmSessionManagerProvider c;
        private LoadErrorHandlingPolicy d;
        private int e;
        private String f;
        private Object g;
        
        public Factory(final DataSource.Factory factory) {
            this(factory, new DefaultExtractorsFactory());
        }
        
        public Factory(final DataSource.Factory factory, final ExtractorsFactory extractorsFactory) {
            this(factory, new v(extractorsFactory));
        }
        
        public Factory(final DataSource.Factory factory, final ProgressiveMediaExtractor.Factory factory2) {
            this(factory, factory2, new DefaultDrmSessionManagerProvider(), new DefaultLoadErrorHandlingPolicy(), 1048576);
        }
        
        public Factory(final DataSource.Factory a, final ProgressiveMediaExtractor.Factory b, final DrmSessionManagerProvider c, final LoadErrorHandlingPolicy d, final int e) {
            this.a = a;
            this.b = b;
            this.c = c;
            this.d = d;
            this.e = e;
        }
        
        public static ProgressiveMediaExtractor e(final ExtractorsFactory extractorsFactory, final PlayerId playerId) {
            return g(extractorsFactory, playerId);
        }
        
        private static ProgressiveMediaExtractor g(final ExtractorsFactory extractorsFactory, final PlayerId playerId) {
            return new BundledExtractorsAdapter(extractorsFactory);
        }
        
        @Override
        public /* bridge */ MediaSource a(final MediaItem mediaItem) {
            return this.f(mediaItem);
        }
        
        @Override
        public int[] b() {
            return new int[] { 4 };
        }
        
        @Override
        public /* bridge */ MediaSource.Factory c(final DrmSessionManagerProvider drmSessionManagerProvider) {
            return this.h(drmSessionManagerProvider);
        }
        
        @Override
        public /* bridge */ MediaSource.Factory d(final LoadErrorHandlingPolicy loadErrorHandlingPolicy) {
            return this.i(loadErrorHandlingPolicy);
        }
        
        public ProgressiveMediaSource f(final MediaItem mediaItem) {
            Assertions.e(mediaItem.b);
            final MediaItem.LocalConfiguration b = mediaItem.b;
            final Object i = b.i;
            boolean b2 = true;
            final boolean b3 = i == null && this.g != null;
            if (b.f != null || this.f == null) {
                b2 = false;
            }
            MediaItem mediaItem2;
            if (b3 && b2) {
                mediaItem2 = mediaItem.b().h(this.g).b(this.f).a();
            }
            else if (b3) {
                mediaItem2 = mediaItem.b().h(this.g).a();
            }
            else {
                mediaItem2 = mediaItem;
                if (b2) {
                    mediaItem2 = mediaItem.b().b(this.f).a();
                }
            }
            return new ProgressiveMediaSource(mediaItem2, this.a, this.b, this.c.a(mediaItem2), this.d, this.e, null);
        }
        
        public Factory h(final DrmSessionManagerProvider drmSessionManagerProvider) {
            this.c = Assertions.f(drmSessionManagerProvider, "MediaSource.Factory#setDrmSessionManagerProvider no longer handles null by instantiating a new DefaultDrmSessionManagerProvider. Explicitly construct and pass an instance in order to retain the old behavior.");
            return this;
        }
        
        public Factory i(final LoadErrorHandlingPolicy loadErrorHandlingPolicy) {
            this.d = Assertions.f(loadErrorHandlingPolicy, "MediaSource.Factory#setLoadErrorHandlingPolicy no longer handles null by instantiating a new DefaultLoadErrorHandlingPolicy. Explicitly construct and pass an instance in order to retain the old behavior.");
            return this;
        }
    }
}
