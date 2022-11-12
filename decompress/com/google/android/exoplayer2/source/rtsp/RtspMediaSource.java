// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.exoplayer2.source.rtsp;

import java.io.IOException;
import com.google.android.exoplayer2.upstream.LoadErrorHandlingPolicy;
import com.google.android.exoplayer2.drm.DrmSessionManagerProvider;
import com.google.android.exoplayer2.source.MediaSourceFactory;
import com.google.android.exoplayer2.util.Util;
import com.google.android.exoplayer2.upstream.Allocator;
import com.google.android.exoplayer2.source.MediaSource;
import com.google.android.exoplayer2.upstream.TransferListener;
import com.google.android.exoplayer2.source.MediaPeriod;
import com.google.android.exoplayer2.Timeline;
import com.google.android.exoplayer2.source.ForwardingTimeline;
import com.google.android.exoplayer2.source.SinglePeriodTimeline;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.ExoPlayerLibraryInfo;
import javax.net.SocketFactory;
import android.net.Uri;
import com.google.android.exoplayer2.MediaItem;
import com.google.android.exoplayer2.source.BaseMediaSource;

public final class RtspMediaSource extends BaseMediaSource
{
    private boolean A;
    private boolean B;
    private final MediaItem h;
    private final RtpDataChannel.Factory i;
    private final String j;
    private final Uri p;
    private final SocketFactory w;
    private final boolean x;
    private long y;
    private boolean z;
    
    static {
        ExoPlayerLibraryInfo.a("goog.exo.rtsp");
    }
    
    RtspMediaSource(final MediaItem h, final RtpDataChannel.Factory i, final String j, final SocketFactory w, final boolean x) {
        this.h = h;
        this.i = i;
        this.j = j;
        this.p = Assertions.e(h.b).a;
        this.w = w;
        this.x = x;
        this.y = -9223372036854775807L;
        this.B = true;
    }
    
    static long p0(final RtspMediaSource rtspMediaSource, final long y) {
        return rtspMediaSource.y = y;
    }
    
    static boolean q0(final RtspMediaSource rtspMediaSource, final boolean z) {
        return rtspMediaSource.z = z;
    }
    
    static boolean r0(final RtspMediaSource rtspMediaSource, final boolean a) {
        return rtspMediaSource.A = a;
    }
    
    static boolean s0(final RtspMediaSource rtspMediaSource, final boolean b) {
        return rtspMediaSource.B = b;
    }
    
    static void t0(final RtspMediaSource rtspMediaSource) {
        rtspMediaSource.u0();
    }
    
    private void u0() {
        Timeline timeline;
        final SinglePeriodTimeline singlePeriodTimeline = (SinglePeriodTimeline)(timeline = new SinglePeriodTimeline(this.y, this.z, (boolean)(0 != 0), this.A, null, this.h));
        if (this.B) {
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
        ((h)mediaPeriod).V();
    }
    
    @Override
    public void U() {
    }
    
    @Override
    protected void m0(final TransferListener transferListener) {
        this.u0();
    }
    
    @Override
    protected void o0() {
    }
    
    @Override
    public MediaPeriod u(final MediaPeriodId mediaPeriodId, final Allocator allocator, final long n) {
        return new h(allocator, this.i, this.p, (h.c)new h.c(this) {
            final RtspMediaSource a;
            
            @Override
            public void a() {
                RtspMediaSource.q0(this.a, false);
                RtspMediaSource.t0(this.a);
            }
            
            @Override
            public void b(final q q) {
                RtspMediaSource.p0(this.a, Util.C0(q.a()));
                RtspMediaSource.q0(this.a, q.c() ^ true);
                RtspMediaSource.r0(this.a, q.c());
                RtspMediaSource.s0(this.a, false);
                RtspMediaSource.t0(this.a);
            }
        }, this.j, this.w, this.x);
    }
    
    public static final class Factory implements MediaSourceFactory
    {
        private long a;
        private String b;
        private SocketFactory c;
        private boolean d;
        private boolean e;
        
        public Factory() {
            this.a = 8000L;
            this.b = "ExoPlayerLib/2.18.1";
            this.c = SocketFactory.getDefault();
        }
        
        @Override
        public /* bridge */ MediaSource a(final MediaItem mediaItem) {
            return this.e(mediaItem);
        }
        
        @Override
        public int[] b() {
            return new int[] { 3 };
        }
        
        @Override
        public /* bridge */ MediaSource.Factory c(final DrmSessionManagerProvider drmSessionManagerProvider) {
            return this.f(drmSessionManagerProvider);
        }
        
        @Override
        public /* bridge */ MediaSource.Factory d(final LoadErrorHandlingPolicy loadErrorHandlingPolicy) {
            return this.g(loadErrorHandlingPolicy);
        }
        
        public RtspMediaSource e(final MediaItem mediaItem) {
            Assertions.e(mediaItem.b);
            RtpDataChannel.Factory factory;
            if (this.d) {
                factory = new w(this.a);
            }
            else {
                factory = new y(this.a);
            }
            return new RtspMediaSource(mediaItem, factory, this.b, this.c, this.e);
        }
        
        public Factory f(final DrmSessionManagerProvider drmSessionManagerProvider) {
            return this;
        }
        
        public Factory g(final LoadErrorHandlingPolicy loadErrorHandlingPolicy) {
            return this;
        }
    }
    
    public static final class RtspPlaybackException extends IOException
    {
        public RtspPlaybackException(final String s) {
            super(s);
        }
        
        public RtspPlaybackException(final String s, final Throwable t) {
            super(s, t);
        }
        
        public RtspPlaybackException(final Throwable t) {
            super(t);
        }
    }
}
