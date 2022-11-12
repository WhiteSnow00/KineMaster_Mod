// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.exoplayer2.source.hls;

import java.lang.annotation.ElementType;
import java.lang.annotation.Target;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Retention;
import java.lang.annotation.Documented;
import com.google.android.exoplayer2.offline.StreamKey;
import com.google.android.exoplayer2.source.hls.playlist.FilteringHlsPlaylistParserFactory;
import com.google.android.exoplayer2.upstream.DataSource;
import com.google.android.exoplayer2.source.DefaultCompositeSequenceableLoaderFactory;
import com.google.android.exoplayer2.upstream.DefaultLoadErrorHandlingPolicy;
import com.google.android.exoplayer2.source.hls.playlist.DefaultHlsPlaylistTracker;
import com.google.android.exoplayer2.source.hls.playlist.DefaultHlsPlaylistParserFactory;
import com.google.android.exoplayer2.drm.DefaultDrmSessionManagerProvider;
import com.google.android.exoplayer2.drm.DrmSessionManagerProvider;
import com.google.android.exoplayer2.source.hls.playlist.HlsPlaylistParserFactory;
import com.google.android.exoplayer2.source.MediaSourceFactory;
import com.google.android.exoplayer2.Timeline;
import com.google.android.exoplayer2.source.hls.playlist.HlsMultivariantPlaylist;
import com.google.android.exoplayer2.upstream.Allocator;
import com.google.android.exoplayer2.source.MediaSource;
import android.os.Looper;
import java.io.IOException;
import com.google.android.exoplayer2.source.MediaPeriod;
import java.util.List;
import com.google.android.exoplayer2.util.Util;
import com.google.android.exoplayer2.source.SinglePeriodTimeline;
import com.google.android.exoplayer2.source.hls.playlist.HlsMediaPlaylist;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.ExoPlayerLibraryInfo;
import com.google.android.exoplayer2.upstream.LoadErrorHandlingPolicy;
import com.google.android.exoplayer2.drm.DrmSessionManager;
import com.google.android.exoplayer2.source.CompositeSequenceableLoaderFactory;
import com.google.android.exoplayer2.upstream.TransferListener;
import com.google.android.exoplayer2.MediaItem;
import com.google.android.exoplayer2.source.hls.playlist.HlsPlaylistTracker;
import com.google.android.exoplayer2.source.BaseMediaSource;

public final class HlsMediaSource extends BaseMediaSource implements PrimaryPlaylistListener
{
    private final boolean A;
    private final HlsPlaylistTracker B;
    private final long C;
    private final MediaItem D;
    private MediaItem.LiveConfiguration E;
    private TransferListener F;
    private final HlsExtractorFactory h;
    private final MediaItem.LocalConfiguration i;
    private final HlsDataSourceFactory j;
    private final CompositeSequenceableLoaderFactory p;
    private final DrmSessionManager w;
    private final LoadErrorHandlingPolicy x;
    private final boolean y;
    private final int z;
    
    static {
        ExoPlayerLibraryInfo.a("goog.exo.hls");
    }
    
    private HlsMediaSource(final MediaItem d, final HlsDataSourceFactory j, final HlsExtractorFactory h, final CompositeSequenceableLoaderFactory p11, final DrmSessionManager w, final LoadErrorHandlingPolicy x, final HlsPlaylistTracker b, final long c, final boolean y, final int z, final boolean a) {
        this.i = Assertions.e(d.b);
        this.D = d;
        this.E = d.d;
        this.j = j;
        this.h = h;
        this.p = p11;
        this.w = w;
        this.x = x;
        this.B = b;
        this.C = c;
        this.y = y;
        this.z = z;
        this.A = a;
    }
    
    HlsMediaSource(final MediaItem mediaItem, final HlsDataSourceFactory hlsDataSourceFactory, final HlsExtractorFactory hlsExtractorFactory, final CompositeSequenceableLoaderFactory compositeSequenceableLoaderFactory, final DrmSessionManager drmSessionManager, final LoadErrorHandlingPolicy loadErrorHandlingPolicy, final HlsPlaylistTracker hlsPlaylistTracker, final long n, final boolean b, final int n2, final boolean b2, final HlsMediaSource$a object) {
        this(mediaItem, hlsDataSourceFactory, hlsExtractorFactory, compositeSequenceableLoaderFactory, drmSessionManager, loadErrorHandlingPolicy, hlsPlaylistTracker, n, b, n2, b2);
    }
    
    private SinglePeriodTimeline p0(final HlsMediaPlaylist hlsMediaPlaylist, final long n, final long n2, final HlsManifest hlsManifest) {
        final long n3 = hlsMediaPlaylist.h - this.B.c();
        long n4;
        if (hlsMediaPlaylist.o) {
            n4 = n3 + hlsMediaPlaylist.u;
        }
        else {
            n4 = -9223372036854775807L;
        }
        final long t0 = this.t0(hlsMediaPlaylist);
        final long a = this.E.a;
        long n5;
        if (a != -9223372036854775807L) {
            n5 = Util.C0(a);
        }
        else {
            n5 = v0(hlsMediaPlaylist, t0);
        }
        this.w0(hlsMediaPlaylist, Util.r(n5, t0, hlsMediaPlaylist.u + t0));
        return new SinglePeriodTimeline(n, n2, -9223372036854775807L, n4, hlsMediaPlaylist.u, n3, this.u0(hlsMediaPlaylist, t0), true, hlsMediaPlaylist.o ^ true, hlsMediaPlaylist.d == 2 && hlsMediaPlaylist.f, hlsManifest, this.D, this.E);
    }
    
    private SinglePeriodTimeline q0(final HlsMediaPlaylist hlsMediaPlaylist, final long n, final long n2, final HlsManifest hlsManifest) {
        long n3 = 0L;
        Label_0081: {
            if (hlsMediaPlaylist.e != -9223372036854775807L && !hlsMediaPlaylist.r.isEmpty()) {
                if (!hlsMediaPlaylist.g) {
                    final long e = hlsMediaPlaylist.e;
                    if (e != hlsMediaPlaylist.u) {
                        n3 = s0(hlsMediaPlaylist.r, e).e;
                        break Label_0081;
                    }
                }
                n3 = hlsMediaPlaylist.e;
            }
            else {
                n3 = 0L;
            }
        }
        final long u = hlsMediaPlaylist.u;
        return new SinglePeriodTimeline(n, n2, -9223372036854775807L, u, u, 0L, n3, true, false, true, hlsManifest, this.D, null);
    }
    
    private static HlsMediaPlaylist.Part r0(final List<HlsMediaPlaylist.Part> list, final long n) {
        HlsMediaPlaylist.Part part = null;
        HlsMediaPlaylist.Part part2;
        for (int i = 0; i < list.size(); ++i, part = part2) {
            part2 = list.get(i);
            final long e = part2.e;
            if (e > n || !part2.w) {
                part2 = part;
                if (e > n) {
                    break;
                }
            }
        }
        return part;
    }
    
    private static HlsMediaPlaylist.Segment s0(final List<HlsMediaPlaylist.Segment> list, final long n) {
        return list.get(Util.g(list, n, true, true));
    }
    
    private long t0(final HlsMediaPlaylist hlsMediaPlaylist) {
        long n;
        if (hlsMediaPlaylist.p) {
            n = Util.C0(Util.b0(this.C)) - hlsMediaPlaylist.e();
        }
        else {
            n = 0L;
        }
        return n;
    }
    
    private long u0(final HlsMediaPlaylist hlsMediaPlaylist, long n) {
        final long e = hlsMediaPlaylist.e;
        if (e != -9223372036854775807L) {
            n = e;
        }
        else {
            n = hlsMediaPlaylist.u + n - Util.C0(this.E.a);
        }
        if (hlsMediaPlaylist.g) {
            return n;
        }
        final HlsMediaPlaylist.Part r0 = r0(hlsMediaPlaylist.s, n);
        if (r0 != null) {
            return r0.e;
        }
        if (hlsMediaPlaylist.r.isEmpty()) {
            return 0L;
        }
        final HlsMediaPlaylist.Segment s0 = s0(hlsMediaPlaylist.r, n);
        final HlsMediaPlaylist.Part r2 = r0(s0.x, n);
        if (r2 != null) {
            return r2.e;
        }
        return s0.e;
    }
    
    private static long v0(final HlsMediaPlaylist hlsMediaPlaylist, final long n) {
        final HlsMediaPlaylist.ServerControl v = hlsMediaPlaylist.v;
        final long e = hlsMediaPlaylist.e;
        long n2;
        if (e != -9223372036854775807L) {
            n2 = hlsMediaPlaylist.u - e;
        }
        else {
            n2 = v.d;
            if (n2 == -9223372036854775807L || hlsMediaPlaylist.n == -9223372036854775807L) {
                n2 = v.c;
                if (n2 == -9223372036854775807L) {
                    n2 = hlsMediaPlaylist.m * 3L;
                }
            }
        }
        return n2 + n;
    }
    
    private void w0(final HlsMediaPlaylist hlsMediaPlaylist, final long n) {
        final MediaItem.LiveConfiguration d = this.D.d;
        boolean b = false;
        Label_0067: {
            if (d.d == -3.4028235E38f && d.e == -3.4028235E38f) {
                final HlsMediaPlaylist.ServerControl v = hlsMediaPlaylist.v;
                if (v.c == -9223372036854775807L && v.d == -9223372036854775807L) {
                    b = true;
                    break Label_0067;
                }
            }
            b = false;
        }
        final MediaItem.LiveConfiguration.Builder k = new MediaItem.LiveConfiguration.Builder().k(Util.f1(n));
        final float n2 = 1.0f;
        float d2;
        if (b) {
            d2 = 1.0f;
        }
        else {
            d2 = this.E.d;
        }
        final MediaItem.LiveConfiguration.Builder j = k.j(d2);
        float e;
        if (b) {
            e = n2;
        }
        else {
            e = this.E.e;
        }
        this.E = j.h(e).f();
    }
    
    @Override
    public MediaItem F() {
        return this.D;
    }
    
    @Override
    public void I(final MediaPeriod mediaPeriod) {
        ((HlsMediaPeriod)mediaPeriod).z();
    }
    
    @Override
    public void U() throws IOException {
        this.B.k();
    }
    
    @Override
    protected void m0(final TransferListener f) {
        this.F = f;
        this.w.prepare();
        this.w.b(Assertions.e(Looper.myLooper()), this.k0());
        this.B.j(this.i.a, this.g0(null), (HlsPlaylistTracker.PrimaryPlaylistListener)this);
    }
    
    @Override
    protected void o0() {
        this.B.stop();
        this.w.release();
    }
    
    @Override
    public MediaPeriod u(final MediaPeriodId mediaPeriodId, final Allocator allocator, final long n) {
        return new HlsMediaPeriod(this.h, this.B, this.j, this.F, this.w, this.e0(mediaPeriodId), this.x, this.g0(mediaPeriodId), allocator, this.p, this.y, this.z, this.A, this.k0());
    }
    
    @Override
    public void y(final HlsMediaPlaylist hlsMediaPlaylist) {
        long f1;
        if (hlsMediaPlaylist.p) {
            f1 = Util.f1(hlsMediaPlaylist.h);
        }
        else {
            f1 = -9223372036854775807L;
        }
        final int d = hlsMediaPlaylist.d;
        long n;
        if (d != 2 && d != 1) {
            n = -9223372036854775807L;
        }
        else {
            n = f1;
        }
        final HlsManifest hlsManifest = new HlsManifest(Assertions.e(this.B.d()), hlsMediaPlaylist);
        SinglePeriodTimeline singlePeriodTimeline;
        if (this.B.h()) {
            singlePeriodTimeline = this.p0(hlsMediaPlaylist, n, f1, hlsManifest);
        }
        else {
            singlePeriodTimeline = this.q0(hlsMediaPlaylist, n, f1, hlsManifest);
        }
        this.n0(singlePeriodTimeline);
    }
    
    public static final class Factory implements MediaSourceFactory
    {
        private final HlsDataSourceFactory a;
        private HlsExtractorFactory b;
        private HlsPlaylistParserFactory c;
        private HlsPlaylistTracker.Factory d;
        private CompositeSequenceableLoaderFactory e;
        private DrmSessionManagerProvider f;
        private LoadErrorHandlingPolicy g;
        private boolean h;
        private int i;
        private boolean j;
        private long k;
        
        public Factory(final HlsDataSourceFactory hlsDataSourceFactory) {
            this.a = Assertions.e(hlsDataSourceFactory);
            this.f = new DefaultDrmSessionManagerProvider();
            this.c = new DefaultHlsPlaylistParserFactory();
            this.d = DefaultHlsPlaylistTracker.A;
            this.b = HlsExtractorFactory.a;
            this.g = new DefaultLoadErrorHandlingPolicy();
            this.e = new DefaultCompositeSequenceableLoaderFactory();
            this.i = 1;
            this.k = -9223372036854775807L;
            this.h = true;
        }
        
        public Factory(final DataSource.Factory factory) {
            this(new DefaultHlsDataSourceFactory(factory));
        }
        
        @Override
        public /* bridge */ MediaSource a(final MediaItem mediaItem) {
            return this.e(mediaItem);
        }
        
        @Override
        public int[] b() {
            return new int[] { 2 };
        }
        
        @Override
        public /* bridge */ MediaSource.Factory c(final DrmSessionManagerProvider drmSessionManagerProvider) {
            return this.f(drmSessionManagerProvider);
        }
        
        @Override
        public /* bridge */ MediaSource.Factory d(final LoadErrorHandlingPolicy loadErrorHandlingPolicy) {
            return this.g(loadErrorHandlingPolicy);
        }
        
        public HlsMediaSource e(final MediaItem mediaItem) {
            Assertions.e(mediaItem.b);
            final HlsPlaylistParserFactory c = this.c;
            final List<StreamKey> e = mediaItem.b.e;
            HlsPlaylistParserFactory hlsPlaylistParserFactory = c;
            if (!e.isEmpty()) {
                hlsPlaylistParserFactory = new FilteringHlsPlaylistParserFactory(c, e);
            }
            final HlsDataSourceFactory a = this.a;
            final HlsExtractorFactory b = this.b;
            final CompositeSequenceableLoaderFactory e2 = this.e;
            final DrmSessionManager a2 = this.f.a(mediaItem);
            final LoadErrorHandlingPolicy g = this.g;
            return new HlsMediaSource(mediaItem, a, b, e2, a2, g, this.d.a(this.a, g, hlsPlaylistParserFactory), this.k, this.h, this.i, this.j, null);
        }
        
        public Factory f(final DrmSessionManagerProvider drmSessionManagerProvider) {
            this.f = Assertions.f(drmSessionManagerProvider, "MediaSource.Factory#setDrmSessionManagerProvider no longer handles null by instantiating a new DefaultDrmSessionManagerProvider. Explicitly construct and pass an instance in order to retain the old behavior.");
            return this;
        }
        
        public Factory g(final LoadErrorHandlingPolicy loadErrorHandlingPolicy) {
            this.g = Assertions.f(loadErrorHandlingPolicy, "MediaSource.Factory#setLoadErrorHandlingPolicy no longer handles null by instantiating a new DefaultLoadErrorHandlingPolicy. Explicitly construct and pass an instance in order to retain the old behavior.");
            return this;
        }
    }
    
    @Documented
    @Retention(RetentionPolicy.SOURCE)
    @Target({ ElementType.TYPE_USE })
    public @interface MetadataType {
    }
}
