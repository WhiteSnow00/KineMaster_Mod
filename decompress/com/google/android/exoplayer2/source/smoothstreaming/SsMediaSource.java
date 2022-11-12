// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.exoplayer2.source.smoothstreaming;

import com.google.android.exoplayer2.offline.StreamKey;
import com.google.android.exoplayer2.offline.FilterableManifest;
import com.google.android.exoplayer2.offline.FilteringManifestParser;
import com.google.android.exoplayer2.source.smoothstreaming.manifest.SsManifestParser;
import com.google.android.exoplayer2.source.DefaultCompositeSequenceableLoaderFactory;
import com.google.android.exoplayer2.upstream.DefaultLoadErrorHandlingPolicy;
import com.google.android.exoplayer2.drm.DefaultDrmSessionManagerProvider;
import com.google.android.exoplayer2.drm.DrmSessionManagerProvider;
import com.google.android.exoplayer2.source.MediaSourceFactory;
import com.google.android.exoplayer2.upstream.Allocator;
import com.google.android.exoplayer2.source.MediaLoadData;
import java.util.List;
import java.util.Map;
import android.os.Looper;
import java.io.IOException;
import com.google.android.exoplayer2.source.MediaPeriod;
import com.google.android.exoplayer2.source.LoadEventInfo;
import android.os.SystemClock;
import com.google.android.exoplayer2.Timeline;
import com.google.android.exoplayer2.source.SinglePeriodTimeline;
import com.google.android.exoplayer2.source.MediaSource;
import com.google.android.exoplayer2.util.Util;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.ExoPlayerLibraryInfo;
import com.google.android.exoplayer2.drm.DrmSessionManager;
import com.google.android.exoplayer2.source.CompositeSequenceableLoaderFactory;
import com.google.android.exoplayer2.MediaItem;
import android.net.Uri;
import android.os.Handler;
import com.google.android.exoplayer2.upstream.TransferListener;
import com.google.android.exoplayer2.upstream.LoaderErrorThrower;
import com.google.android.exoplayer2.upstream.DataSource;
import java.util.ArrayList;
import com.google.android.exoplayer2.source.MediaSourceEventListener;
import com.google.android.exoplayer2.upstream.LoadErrorHandlingPolicy;
import com.google.android.exoplayer2.source.smoothstreaming.manifest.SsManifest;
import com.google.android.exoplayer2.upstream.ParsingLoadable;
import com.google.android.exoplayer2.upstream.Loader;
import com.google.android.exoplayer2.source.BaseMediaSource;

public final class SsMediaSource extends BaseMediaSource implements Callback<ParsingLoadable<SsManifest>>
{
    private final LoadErrorHandlingPolicy A;
    private final long B;
    private final MediaSourceEventListener.EventDispatcher C;
    private final ParsingLoadable.Parser<? extends SsManifest> D;
    private final ArrayList<a> E;
    private DataSource F;
    private Loader G;
    private LoaderErrorThrower H;
    private TransferListener I;
    private long J;
    private SsManifest K;
    private Handler L;
    private final boolean h;
    private final Uri i;
    private final MediaItem.LocalConfiguration j;
    private final MediaItem p;
    private final DataSource.Factory w;
    private final SsChunkSource.Factory x;
    private final CompositeSequenceableLoaderFactory y;
    private final DrmSessionManager z;
    
    static {
        ExoPlayerLibraryInfo.a("goog.exo.smoothstreaming");
    }
    
    private SsMediaSource(final MediaItem p9, final SsManifest k, final DataSource.Factory w, final ParsingLoadable.Parser<? extends SsManifest> d, final SsChunkSource.Factory x, final CompositeSequenceableLoaderFactory y, final DrmSessionManager z, final LoadErrorHandlingPolicy a, final long b) {
        final boolean b2 = false;
        Assertions.g(k == null || !k.d);
        this.p = p9;
        final MediaItem.LocalConfiguration j = Assertions.e(p9.b);
        this.j = j;
        this.K = k;
        Uri b3;
        if (j.a.equals((Object)Uri.EMPTY)) {
            b3 = null;
        }
        else {
            b3 = Util.B(j.a);
        }
        this.i = b3;
        this.w = w;
        this.D = d;
        this.x = x;
        this.y = y;
        this.z = z;
        this.A = a;
        this.B = b;
        this.C = this.g0(null);
        boolean h = b2;
        if (k != null) {
            h = true;
        }
        this.h = h;
        this.E = new ArrayList<a>();
    }
    
    SsMediaSource(final MediaItem mediaItem, final SsManifest ssManifest, final DataSource.Factory factory, final ParsingLoadable.Parser parser, final SsChunkSource.Factory factory2, final CompositeSequenceableLoaderFactory compositeSequenceableLoaderFactory, final DrmSessionManager drmSessionManager, final LoadErrorHandlingPolicy loadErrorHandlingPolicy, final long n, final SsMediaSource$a object) {
        this(mediaItem, ssManifest, factory, parser, factory2, compositeSequenceableLoaderFactory, drmSessionManager, loadErrorHandlingPolicy, n);
    }
    
    public static void p0(final SsMediaSource ssMediaSource) {
        ssMediaSource.v0();
    }
    
    private void t0() {
        for (int i = 0; i < this.E.size(); ++i) {
            this.E.get(i).u(this.K);
        }
        long n = Long.MIN_VALUE;
        final SsManifest.StreamElement[] f = this.K.f;
        final int length = f.length;
        int j = 0;
        long n2 = Long.MAX_VALUE;
        while (j < length) {
            final SsManifest.StreamElement streamElement = f[j];
            long max = n;
            long min = n2;
            if (streamElement.k > 0) {
                min = Math.min(n2, streamElement.e(0));
                max = Math.max(n, streamElement.e(streamElement.k - 1) + streamElement.c(streamElement.k - 1));
            }
            ++j;
            n = max;
            n2 = min;
        }
        SinglePeriodTimeline singlePeriodTimeline;
        if (n2 == Long.MAX_VALUE) {
            long n3;
            if (this.K.d) {
                n3 = -9223372036854775807L;
            }
            else {
                n3 = 0L;
            }
            final SsManifest k = this.K;
            final boolean d = k.d;
            singlePeriodTimeline = new SinglePeriodTimeline(n3, 0L, 0L, 0L, true, d, d, k, this.p);
        }
        else {
            final SsManifest l = this.K;
            if (l.d) {
                final long h = l.h;
                long max2 = n2;
                if (h != -9223372036854775807L) {
                    max2 = n2;
                    if (h > 0L) {
                        max2 = Math.max(n2, n - h);
                    }
                }
                final long n4 = n - max2;
                long min2;
                if ((min2 = n4 - Util.C0(this.B)) < 5000000L) {
                    min2 = Math.min(5000000L, n4 / 2L);
                }
                singlePeriodTimeline = new SinglePeriodTimeline(-9223372036854775807L, n4, max2, min2, true, true, true, this.K, this.p);
            }
            else {
                final long g = l.g;
                long n5;
                if (g != -9223372036854775807L) {
                    n5 = g;
                }
                else {
                    n5 = n - n2;
                }
                singlePeriodTimeline = new SinglePeriodTimeline(n2 + n5, n5, n2, 0L, true, false, false, this.K, this.p);
            }
        }
        this.n0(singlePeriodTimeline);
    }
    
    private void u0() {
        if (!this.K.d) {
            return;
        }
        this.L.postDelayed((Runnable)new b4.a(this), Math.max(0L, this.J + 5000L - SystemClock.elapsedRealtime()));
    }
    
    private void v0() {
        if (this.G.i()) {
            return;
        }
        final ParsingLoadable parsingLoadable = new ParsingLoadable(this.F, this.i, 4, (ParsingLoadable.Parser<? extends T>)this.D);
        this.C.z(new LoadEventInfo(parsingLoadable.a, parsingLoadable.b, this.G.n(parsingLoadable, (Loader.Callback<ParsingLoadable>)this, this.A.b(parsingLoadable.c))), parsingLoadable.c);
    }
    
    @Override
    public /* bridge */ void A(final Loadable loadable, final long n, final long n2) {
        this.r0((ParsingLoadable<SsManifest>)loadable, n, n2);
    }
    
    @Override
    public MediaItem F() {
        return this.p;
    }
    
    @Override
    public void I(final MediaPeriod mediaPeriod) {
        ((a)mediaPeriod).t();
        this.E.remove(mediaPeriod);
    }
    
    @Override
    public /* bridge */ LoadErrorAction L(final Loadable loadable, final long n, final long n2, final IOException ex, final int n3) {
        return this.s0((ParsingLoadable<SsManifest>)loadable, n, n2, ex, n3);
    }
    
    @Override
    public void U() throws IOException {
        this.H.a();
    }
    
    @Override
    protected void m0(final TransferListener i) {
        this.I = i;
        this.z.prepare();
        this.z.b(Looper.myLooper(), this.k0());
        if (this.h) {
            this.H = new LoaderErrorThrower.Dummy();
            this.t0();
        }
        else {
            this.F = this.w.createDataSource();
            final Loader loader = new Loader("SsMediaSource");
            this.G = loader;
            this.H = loader;
            this.L = Util.w();
            this.v0();
        }
    }
    
    @Override
    protected void o0() {
        SsManifest k;
        if (this.h) {
            k = this.K;
        }
        else {
            k = null;
        }
        this.K = k;
        this.F = null;
        this.J = 0L;
        final Loader g = this.G;
        if (g != null) {
            g.l();
            this.G = null;
        }
        final Handler l = this.L;
        if (l != null) {
            l.removeCallbacksAndMessages((Object)null);
            this.L = null;
        }
        this.z.release();
    }
    
    public void q0(final ParsingLoadable<SsManifest> parsingLoadable, final long n, final long n2, final boolean b) {
        final LoadEventInfo loadEventInfo = new LoadEventInfo(parsingLoadable.a, parsingLoadable.b, parsingLoadable.f(), parsingLoadable.d(), n, n2, parsingLoadable.b());
        this.A.d(parsingLoadable.a);
        this.C.q(loadEventInfo, parsingLoadable.c);
    }
    
    public void r0(final ParsingLoadable<SsManifest> parsingLoadable, final long n, final long n2) {
        final LoadEventInfo loadEventInfo = new LoadEventInfo(parsingLoadable.a, parsingLoadable.b, parsingLoadable.f(), parsingLoadable.d(), n, n2, parsingLoadable.b());
        this.A.d(parsingLoadable.a);
        this.C.t(loadEventInfo, parsingLoadable.c);
        this.K = (SsManifest)parsingLoadable.e();
        this.J = n - n2;
        this.t0();
        this.u0();
    }
    
    public LoadErrorAction s0(final ParsingLoadable<SsManifest> parsingLoadable, long a, final long n, final IOException ex, final int n2) {
        final LoadEventInfo loadEventInfo = new LoadEventInfo(parsingLoadable.a, parsingLoadable.b, parsingLoadable.f(), parsingLoadable.d(), a, n, parsingLoadable.b());
        a = this.A.a(new LoadErrorHandlingPolicy.LoadErrorInfo(loadEventInfo, new MediaLoadData(parsingLoadable.c), ex, n2));
        Loader.LoadErrorAction loadErrorAction;
        if (a == -9223372036854775807L) {
            loadErrorAction = Loader.g;
        }
        else {
            loadErrorAction = Loader.h(false, a);
        }
        final boolean b = loadErrorAction.c() ^ true;
        this.C.x(loadEventInfo, parsingLoadable.c, ex, b);
        if (b) {
            this.A.d(parsingLoadable.a);
        }
        return loadErrorAction;
    }
    
    @Override
    public MediaPeriod u(final MediaPeriodId mediaPeriodId, final Allocator allocator, final long n) {
        final a a = new a(this.K, this.x, this.I, this.y, this.z, this.e0(mediaPeriodId), this.A, this.g0(mediaPeriodId), this.H, allocator);
        this.E.add(a);
        return a;
    }
    
    @Override
    public /* bridge */ void v(final Loadable loadable, final long n, final long n2, final boolean b) {
        this.q0((ParsingLoadable<SsManifest>)loadable, n, n2, b);
    }
    
    public static final class Factory implements MediaSourceFactory
    {
        private final SsChunkSource.Factory a;
        private final DataSource.Factory b;
        private CompositeSequenceableLoaderFactory c;
        private DrmSessionManagerProvider d;
        private LoadErrorHandlingPolicy e;
        private long f;
        private ParsingLoadable.Parser<? extends SsManifest> g;
        
        public Factory(final SsChunkSource.Factory factory, final DataSource.Factory b) {
            this.a = Assertions.e(factory);
            this.b = b;
            this.d = new DefaultDrmSessionManagerProvider();
            this.e = new DefaultLoadErrorHandlingPolicy();
            this.f = 30000L;
            this.c = new DefaultCompositeSequenceableLoaderFactory();
        }
        
        public Factory(final DataSource.Factory factory) {
            this(new DefaultSsChunkSource.Factory(factory), factory);
        }
        
        @Override
        public /* bridge */ MediaSource a(final MediaItem mediaItem) {
            return this.e(mediaItem);
        }
        
        @Override
        public int[] b() {
            return new int[] { 1 };
        }
        
        @Override
        public /* bridge */ MediaSource.Factory c(final DrmSessionManagerProvider drmSessionManagerProvider) {
            return this.f(drmSessionManagerProvider);
        }
        
        @Override
        public /* bridge */ MediaSource.Factory d(final LoadErrorHandlingPolicy loadErrorHandlingPolicy) {
            return this.g(loadErrorHandlingPolicy);
        }
        
        public SsMediaSource e(final MediaItem mediaItem) {
            Assertions.e(mediaItem.b);
            ParsingLoadable.Parser<? extends SsManifest> g;
            if ((g = this.g) == null) {
                g = new SsManifestParser();
            }
            final List<StreamKey> e = mediaItem.b.e;
            if (!e.isEmpty()) {
                g = new FilteringManifestParser<SsManifest>(g, e);
            }
            return new SsMediaSource(mediaItem, null, this.b, g, this.a, this.c, this.d.a(mediaItem), this.e, this.f, null);
        }
        
        public Factory f(final DrmSessionManagerProvider drmSessionManagerProvider) {
            this.d = Assertions.f(drmSessionManagerProvider, "MediaSource.Factory#setDrmSessionManagerProvider no longer handles null by instantiating a new DefaultDrmSessionManagerProvider. Explicitly construct and pass an instance in order to retain the old behavior.");
            return this;
        }
        
        public Factory g(final LoadErrorHandlingPolicy loadErrorHandlingPolicy) {
            this.e = Assertions.f(loadErrorHandlingPolicy, "MediaSource.Factory#setLoadErrorHandlingPolicy no longer handles null by instantiating a new DefaultLoadErrorHandlingPolicy. Explicitly construct and pass an instance in order to retain the old behavior.");
            return this;
        }
    }
}
