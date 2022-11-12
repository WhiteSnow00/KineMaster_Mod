// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.exoplayer2.source.ads;

import com.google.common.collect.Multimap;
import com.google.android.exoplayer2.source.SequenceableLoader;
import java.util.Iterator;
import com.google.android.exoplayer2.source.EmptySampleStream;
import java.util.Arrays;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.source.TrackGroup;
import java.util.HashMap;
import java.util.ArrayList;
import java.util.Map;
import com.google.android.exoplayer2.source.ForwardingTimeline;
import com.google.android.exoplayer2.decoder.DecoderInputBuffer;
import com.google.android.exoplayer2.FormatHolder;
import com.google.android.exoplayer2.source.TrackGroupArray;
import com.google.android.exoplayer2.source.SampleStream;
import com.google.android.exoplayer2.trackselection.ExoTrackSelection;
import com.google.android.exoplayer2.SeekParameters;
import com.google.android.exoplayer2.source.MediaPeriodId;
import com.google.android.exoplayer2.upstream.Allocator;
import com.google.android.exoplayer2.upstream.TransferListener;
import com.google.android.exoplayer2.source.LoadEventInfo;
import java.io.IOException;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.MediaItem;
import com.google.android.exoplayer2.source.MediaPeriod;
import java.util.List;
import com.google.common.collect.Iterables;
import com.google.android.exoplayer2.util.Util;
import com.google.android.exoplayer2.source.MediaLoadData;
import com.google.android.exoplayer2.Timeline;
import android.os.Handler;
import android.util.Pair;
import com.google.common.collect.ListMultimap;
import com.google.common.collect.ImmutableMap;
import com.google.android.exoplayer2.drm.DrmSessionEventListener;
import com.google.android.exoplayer2.source.MediaSourceEventListener;
import com.google.android.exoplayer2.source.MediaSource;
import com.google.android.exoplayer2.source.BaseMediaSource;

public final class ServerSideAdInsertionMediaSource extends BaseMediaSource implements MediaSourceCaller, MediaSourceEventListener, DrmSessionEventListener
{
    private ImmutableMap<Object, AdPlaybackState> A;
    private final MediaSource h;
    private final ListMultimap<Pair<Long, Object>, d> i;
    private final MediaSourceEventListener.EventDispatcher j;
    private final DrmSessionEventListener.EventDispatcher p;
    private final AdPlaybackStateUpdater w;
    private Handler x;
    private d y;
    private Timeline z;
    
    static long p0(final a a, final AdPlaybackState adPlaybackState) {
        return t0(a, adPlaybackState);
    }
    
    static MediaLoadData q0(final a a, final MediaLoadData mediaLoadData, final AdPlaybackState adPlaybackState) {
        return r0(a, mediaLoadData, adPlaybackState);
    }
    
    private static MediaLoadData r0(final a a, final MediaLoadData mediaLoadData, final AdPlaybackState adPlaybackState) {
        return new MediaLoadData(mediaLoadData.a, mediaLoadData.b, mediaLoadData.c, mediaLoadData.d, mediaLoadData.e, s0(mediaLoadData.f, a, adPlaybackState), s0(mediaLoadData.g, a, adPlaybackState));
    }
    
    private static long s0(long n, final a a, final AdPlaybackState adPlaybackState) {
        if (n == -9223372036854775807L) {
            return -9223372036854775807L;
        }
        n = Util.C0(n);
        final MediaPeriodId b = a.b;
        if (b.b()) {
            n = ServerSideAdInsertionUtil.c(n, b.b, b.c, adPlaybackState);
        }
        else {
            n = ServerSideAdInsertionUtil.d(n, -1, adPlaybackState);
        }
        return Util.f1(n);
    }
    
    private static long t0(final a a, final AdPlaybackState adPlaybackState) {
        final MediaPeriodId b = a.b;
        if (b.b()) {
            final AdPlaybackState.AdGroup c = adPlaybackState.c(b.b);
            long n;
            if (c.b == -1) {
                n = 0L;
            }
            else {
                n = c.e[b.c];
            }
            return n;
        }
        final int e = b.e;
        long n2 = Long.MAX_VALUE;
        if (e == -1) {
            return Long.MAX_VALUE;
        }
        final long a2 = adPlaybackState.c(e).a;
        if (a2 != Long.MIN_VALUE) {
            n2 = a2;
        }
        return n2;
    }
    
    private a u0(final MediaPeriodId mediaPeriodId, final MediaLoadData mediaLoadData, final boolean b) {
        if (mediaPeriodId == null) {
            return null;
        }
        final List value = this.i.get((Object)new Pair((Object)mediaPeriodId.d, mediaPeriodId.a));
        if (value.isEmpty()) {
            return null;
        }
        if (b) {
            final d d = (d)Iterables.h((Iterable)value);
            MediaPeriod b2;
            if (ServerSideAdInsertionMediaSource.d.b(d) != null) {
                b2 = ServerSideAdInsertionMediaSource.d.b(d);
            }
            else {
                b2 = (a)Iterables.h((Iterable)ServerSideAdInsertionMediaSource.d.c(d));
            }
            return (a)b2;
        }
        for (int i = 0; i < value.size(); ++i) {
            final a k = value.get(i).k(mediaLoadData);
            if (k != null) {
                return k;
            }
        }
        return (a)d.c((d)value.get(0)).get(0);
    }
    
    private void v0() {
        final d y = this.y;
        if (y != null) {
            y.G(this.h);
            this.y = null;
        }
    }
    
    @Override
    public MediaItem F() {
        return this.h.F();
    }
    
    @Override
    public void G(final int n, final MediaPeriodId mediaPeriodId) {
        final a u0 = this.u0(mediaPeriodId, null, false);
        if (u0 == null) {
            this.p.i();
        }
        else {
            u0.d.i();
        }
    }
    
    @Override
    public void I(final MediaPeriod mediaPeriod) {
        final a a = (a)mediaPeriod;
        a.a.H(a);
        if (a.a.u()) {
            ((Multimap)this.i).remove((Object)new Pair((Object)a.b.d, a.b.a), (Object)a.a);
            if (((Multimap)this.i).isEmpty()) {
                this.y = a.a;
            }
            else {
                a.a.G(this.h);
            }
        }
    }
    
    @Override
    public void M(final int n, final MediaPeriodId mediaPeriodId, final MediaLoadData mediaLoadData) {
        final a u0 = this.u0(mediaPeriodId, mediaLoadData, false);
        if (u0 == null) {
            this.j.E(mediaLoadData);
        }
        else {
            u0.c.E(r0(u0, mediaLoadData, Assertions.e(this.A.get(u0.b.a))));
        }
    }
    
    @Override
    public void N(final MediaSource mediaSource, final Timeline z) {
        this.z = z;
        final AdPlaybackStateUpdater w = this.w;
        if ((w == null || !w.a(z)) && !this.A.isEmpty()) {
            this.n0(new c(z, this.A));
        }
    }
    
    @Override
    public void O(final int n, final MediaPeriodId mediaPeriodId, final Exception ex) {
        final a u0 = this.u0(mediaPeriodId, null, false);
        if (u0 == null) {
            this.p.l(ex);
        }
        else {
            u0.d.l(ex);
        }
    }
    
    @Override
    public void U() throws IOException {
        this.h.U();
    }
    
    @Override
    public void X(final int n, final MediaPeriodId mediaPeriodId) {
        final a u0 = this.u0(mediaPeriodId, null, false);
        if (u0 == null) {
            this.p.h();
        }
        else {
            u0.d.h();
        }
    }
    
    @Override
    public void Y(final int n, final MediaPeriodId mediaPeriodId, final LoadEventInfo loadEventInfo, final MediaLoadData mediaLoadData) {
        final a u0 = this.u0(mediaPeriodId, mediaLoadData, true);
        if (u0 == null) {
            this.j.v(loadEventInfo, mediaLoadData);
        }
        else {
            u0.a.A(loadEventInfo);
            u0.c.v(loadEventInfo, r0(u0, mediaLoadData, Assertions.e(this.A.get(u0.b.a))));
        }
    }
    
    @Override
    public void Z(final int n, final MediaPeriodId mediaPeriodId, final int n2) {
        final a u0 = this.u0(mediaPeriodId, null, true);
        if (u0 == null) {
            this.p.k(n2);
        }
        else {
            u0.d.k(n2);
        }
    }
    
    @Override
    public void a0(final int n, final MediaPeriodId mediaPeriodId) {
        final a u0 = this.u0(mediaPeriodId, null, false);
        if (u0 == null) {
            this.p.m();
        }
        else {
            u0.d.m();
        }
    }
    
    @Override
    public void b0(final int n, final MediaPeriodId mediaPeriodId, final LoadEventInfo loadEventInfo, final MediaLoadData mediaLoadData, final IOException ex, final boolean b) {
        final a u0 = this.u0(mediaPeriodId, mediaLoadData, true);
        if (u0 == null) {
            this.j.y(loadEventInfo, mediaLoadData, ex, b);
        }
        else {
            if (b) {
                u0.a.A(loadEventInfo);
            }
            u0.c.y(loadEventInfo, r0(u0, mediaLoadData, Assertions.e(this.A.get(u0.b.a))), ex, b);
        }
    }
    
    @Override
    public void c0(final int n, final MediaPeriodId mediaPeriodId) {
        final a u0 = this.u0(mediaPeriodId, null, false);
        if (u0 == null) {
            this.p.j();
        }
        else {
            u0.d.j();
        }
    }
    
    @Override
    protected void i0() {
        this.v0();
        this.h.Q((MediaSource.MediaSourceCaller)this);
    }
    
    @Override
    protected void j0() {
        this.h.K((MediaSource.MediaSourceCaller)this);
    }
    
    @Override
    public void k(final int n, final MediaPeriodId mediaPeriodId, final MediaLoadData mediaLoadData) {
        final a u0 = this.u0(mediaPeriodId, mediaLoadData, false);
        if (u0 == null) {
            this.j.j(mediaLoadData);
        }
        else {
            u0.a.z(u0, mediaLoadData);
            u0.c.j(r0(u0, mediaLoadData, Assertions.e(this.A.get(u0.b.a))));
        }
    }
    
    @Override
    protected void m0(final TransferListener transferListener) {
        final Handler w = Util.w();
        synchronized (this) {
            this.x = w;
            monitorexit(this);
            this.h.B(w, this);
            this.h.S(w, this);
            this.h.E((MediaSource.MediaSourceCaller)this, transferListener, this.k0());
        }
    }
    
    @Override
    protected void o0() {
        this.v0();
        this.z = null;
        synchronized (this) {
            this.x = null;
            monitorexit(this);
            this.h.x((MediaSource.MediaSourceCaller)this);
            this.h.C(this);
            this.h.T(this);
        }
    }
    
    @Override
    public void t(final int n, final MediaPeriodId mediaPeriodId, final LoadEventInfo loadEventInfo, final MediaLoadData mediaLoadData) {
        final a u0 = this.u0(mediaPeriodId, mediaLoadData, true);
        if (u0 == null) {
            this.j.s(loadEventInfo, mediaLoadData);
        }
        else {
            u0.a.A(loadEventInfo);
            u0.c.s(loadEventInfo, r0(u0, mediaLoadData, Assertions.e(this.A.get(u0.b.a))));
        }
    }
    
    @Override
    public MediaPeriod u(final MediaPeriodId mediaPeriodId, final Allocator allocator, final long n) {
        final Pair pair = new Pair((Object)mediaPeriodId.d, mediaPeriodId.a);
        final d y = this.y;
        int n2 = 0;
        final int n3 = 0;
        d y2;
        if (y != null) {
            if (d.a(y).equals(mediaPeriodId.a)) {
                y2 = this.y;
                ((Multimap)this.i).put((Object)pair, (Object)y2);
                n2 = 1;
            }
            else {
                this.y.G(this.h);
                y2 = null;
                n2 = n3;
            }
            this.y = null;
        }
        else {
            y2 = null;
        }
        Object o = y2;
        if (y2 == null) {
            o = Iterables.i((Iterable)this.i.get((Object)pair), (Object)null);
            if (o == null || !((d)o).e(mediaPeriodId, n)) {
                final AdPlaybackState adPlaybackState = Assertions.e(this.A.get(mediaPeriodId.a));
                o = new d(this.h.u(new MediaSource.MediaPeriodId(mediaPeriodId.a, mediaPeriodId.d), allocator, ServerSideAdInsertionUtil.e(n, mediaPeriodId, adPlaybackState)), mediaPeriodId.a, adPlaybackState);
                ((Multimap)this.i).put((Object)pair, o);
            }
        }
        final a a = new a((d)o, mediaPeriodId, this.g0(mediaPeriodId), this.e0(mediaPeriodId));
        ((d)o).d(a);
        if (n2 != 0 && ((d)o).i.length > 0) {
            a.h(n);
        }
        return a;
    }
    
    @Override
    public void w(final int n, final MediaPeriodId mediaPeriodId, final LoadEventInfo loadEventInfo, final MediaLoadData mediaLoadData) {
        final a u0 = this.u0(mediaPeriodId, mediaLoadData, true);
        if (u0 == null) {
            this.j.B(loadEventInfo, mediaLoadData);
        }
        else {
            u0.a.B(loadEventInfo, mediaLoadData);
            u0.c.B(loadEventInfo, r0(u0, mediaLoadData, Assertions.e(this.A.get(u0.b.a))));
        }
    }
    
    public interface AdPlaybackStateUpdater
    {
        boolean a(final Timeline p0);
    }
    
    private static final class a implements MediaPeriod
    {
        public final d a;
        public final MediaPeriodId b;
        public final MediaSourceEventListener.EventDispatcher c;
        public final DrmSessionEventListener.EventDispatcher d;
        public Callback e;
        public long f;
        public boolean[] g;
        
        public a(final d a, final MediaPeriodId b, final MediaSourceEventListener.EventDispatcher c, final DrmSessionEventListener.EventDispatcher d) {
            this.a = a;
            this.b = b;
            this.c = c;
            this.d = d;
            this.g = new boolean[0];
        }
        
        @Override
        public long b() {
            return this.a.p(this);
        }
        
        @Override
        public long c(final long n, final SeekParameters seekParameters) {
            return this.a.i(this, n, seekParameters);
        }
        
        @Override
        public boolean d(final long n) {
            return this.a.f(this, n);
        }
        
        @Override
        public long f() {
            return this.a.j(this);
        }
        
        @Override
        public void g(final long n) {
            this.a.F(this, n);
        }
        
        @Override
        public long h(final long n) {
            return this.a.I(this, n);
        }
        
        @Override
        public long i() {
            return this.a.E(this);
        }
        
        @Override
        public boolean isLoading() {
            return this.a.s(this);
        }
        
        @Override
        public void j(final Callback e, final long n) {
            this.e = e;
            this.a.C(this, n);
        }
        
        @Override
        public long k(final ExoTrackSelection[] array, final boolean[] array2, final SampleStream[] array3, final boolean[] array4, final long n) {
            if (this.g.length == 0) {
                this.g = new boolean[array3.length];
            }
            return this.a.J(this, array, array2, array3, array4, n);
        }
        
        @Override
        public void n() throws IOException {
            this.a.x();
        }
        
        @Override
        public TrackGroupArray p() {
            return this.a.r();
        }
        
        @Override
        public void q(final long n, final boolean b) {
            this.a.g(this, n, b);
        }
    }
    
    private static final class b implements SampleStream
    {
        private final a a;
        private final int b;
        
        public b(final a a, final int b) {
            this.a = a;
            this.b = b;
        }
        
        @Override
        public void a() throws IOException {
            this.a.a.w(this.b);
        }
        
        @Override
        public int e(final FormatHolder formatHolder, final DecoderInputBuffer decoderInputBuffer, final int n) {
            final a a = this.a;
            return a.a.D(a, this.b, formatHolder, decoderInputBuffer, n);
        }
        
        @Override
        public boolean isReady() {
            return this.a.a.t(this.b);
        }
        
        @Override
        public int l(final long n) {
            final a a = this.a;
            return a.a.K(a, this.b, n);
        }
    }
    
    private static final class c extends ForwardingTimeline
    {
        private final ImmutableMap<Object, AdPlaybackState> d;
        
        public c(final Timeline timeline, final ImmutableMap<Object, AdPlaybackState> d) {
            super(timeline);
            final int t = timeline.t();
            int i = 0;
            Assertions.g(t == 1);
            final Period period = new Period();
            while (i < timeline.m()) {
                timeline.k(i, period, true);
                Assertions.g(d.containsKey(Assertions.e(period.b)));
                ++i;
            }
            this.d = d;
        }
        
        @Override
        public Period k(final int n, final Period period, final boolean b) {
            super.k(n, period, true);
            final AdPlaybackState adPlaybackState = Assertions.e(this.d.get(period.b));
            final long d = period.d;
            long n2;
            if (d == -9223372036854775807L) {
                n2 = adPlaybackState.d;
            }
            else {
                n2 = ServerSideAdInsertionUtil.d(d, -1, adPlaybackState);
            }
            final Period period2 = new Period();
            int i = 0;
            long n3 = 0L;
            while (i < n + 1) {
                super.c.k(i, period2, true);
                final AdPlaybackState adPlaybackState2 = Assertions.e(this.d.get(period2.b));
                if (i == 0) {
                    n3 = -ServerSideAdInsertionUtil.d(-period2.r(), -1, adPlaybackState2);
                }
                long n4 = n3;
                if (i != n) {
                    n4 = n3 + ServerSideAdInsertionUtil.d(period2.d, -1, adPlaybackState2);
                }
                ++i;
                n3 = n4;
            }
            period.x(period.a, period.b, period.c, n2, n3, adPlaybackState, period.f);
            return period;
        }
        
        @Override
        public Window s(final int n, final Window window, long d) {
            super.s(n, window, d);
            final AdPlaybackState adPlaybackState = Assertions.e(this.d.get(Assertions.e(this.k(window.z, new Period(), true).b)));
            final long d2 = ServerSideAdInsertionUtil.d(window.B, -1, adPlaybackState);
            final long y = window.y;
            d = -9223372036854775807L;
            if (y == -9223372036854775807L) {
                d = adPlaybackState.d;
                if (d != -9223372036854775807L) {
                    window.y = d - d2;
                }
            }
            else {
                final Period j = this.j(window.A, new Period());
                final long d3 = j.d;
                if (d3 != -9223372036854775807L) {
                    d = j.e + d3;
                }
                window.y = d;
            }
            window.B = d2;
            return window;
        }
    }
    
    private static final class d implements Callback
    {
        private final MediaPeriod a;
        private final List<a> b;
        private final Map<Long, Pair<LoadEventInfo, MediaLoadData>> c;
        private final Object d;
        private AdPlaybackState e;
        private a f;
        private boolean g;
        private boolean h;
        public ExoTrackSelection[] i;
        public SampleStream[] j;
        public MediaLoadData[] p;
        
        public d(final MediaPeriod a, final Object d, final AdPlaybackState e) {
            this.a = a;
            this.d = d;
            this.e = e;
            this.b = new ArrayList<a>();
            this.c = new HashMap<Long, Pair<LoadEventInfo, MediaLoadData>>();
            this.i = new ExoTrackSelection[0];
            this.j = new SampleStream[0];
            this.p = new MediaLoadData[0];
        }
        
        static Object a(final d d) {
            return d.d;
        }
        
        static a b(final d d) {
            return d.f;
        }
        
        static List c(final d d) {
            return d.b;
        }
        
        private int h(final MediaLoadData mediaLoadData) {
            if (mediaLoadData.c == null) {
                return -1;
            }
            int n = 0;
        Label_0146:
            while (true) {
                final ExoTrackSelection[] i = this.i;
                if (n >= i.length) {
                    return -1;
                }
                if (i[n] != null) {
                    final TrackGroup l = i[n].l();
                    final boolean b = mediaLoadData.b == 0 && l.equals(this.r().b(0));
                    for (int j = 0; j < l.a; ++j) {
                        final Format c = l.c(j);
                        if (c.equals(mediaLoadData.c)) {
                            break Label_0146;
                        }
                        if (b) {
                            final String a = c.a;
                            if (a != null && a.equals(mediaLoadData.c.a)) {
                                break Label_0146;
                            }
                        }
                    }
                }
                ++n;
            }
            return n;
        }
        
        private long n(final a a, long b) {
            final long n = Long.MIN_VALUE;
            if (b == Long.MIN_VALUE) {
                return Long.MIN_VALUE;
            }
            b = ServerSideAdInsertionUtil.b(b, a.b, this.e);
            if (b >= ServerSideAdInsertionMediaSource.p0(a, this.e)) {
                b = n;
            }
            return b;
        }
        
        private long q(final a a, final long n) {
            final long f = a.f;
            if (n < f) {
                return ServerSideAdInsertionUtil.e(f, a.b, this.e) - (a.f - n);
            }
            return ServerSideAdInsertionUtil.e(n, a.b, this.e);
        }
        
        private void v(final a a, final int n) {
            final boolean[] g = a.g;
            if (!g[n]) {
                final MediaLoadData[] p2 = this.p;
                if (p2[n] != null) {
                    g[n] = true;
                    a.c.j(ServerSideAdInsertionMediaSource.q0(a, p2[n], this.e));
                }
            }
        }
        
        public void A(final LoadEventInfo loadEventInfo) {
            this.c.remove(loadEventInfo.a);
        }
        
        public void B(final LoadEventInfo loadEventInfo, final MediaLoadData mediaLoadData) {
            this.c.put(loadEventInfo.a, (Pair<LoadEventInfo, MediaLoadData>)Pair.create((Object)loadEventInfo, (Object)mediaLoadData));
        }
        
        public void C(final a a, long e) {
            a.f = e;
            if (this.g) {
                if (this.h) {
                    Assertions.e(a.e).o(a);
                }
                return;
            }
            this.g = true;
            e = ServerSideAdInsertionUtil.e(e, a.b, this.e);
            this.a.j((MediaPeriod.Callback)this, e);
        }
        
        public int D(final a a, final int n, final FormatHolder formatHolder, final DecoderInputBuffer decoderInputBuffer, final int n2) {
            final int e = Util.j(this.j[n]).e(formatHolder, decoderInputBuffer, n2 | 0x1 | 0x4);
            final long n3 = this.n(a, decoderInputBuffer.f);
            if ((e == -4 && n3 == Long.MIN_VALUE) || (e == -3 && this.j(a) == Long.MIN_VALUE && !decoderInputBuffer.e)) {
                this.v(a, n);
                decoderInputBuffer.h();
                decoderInputBuffer.g(4);
                return -4;
            }
            if (e == -4) {
                this.v(a, n);
                Util.j(this.j[n]).e(formatHolder, decoderInputBuffer, n2);
                decoderInputBuffer.f = n3;
            }
            return e;
        }
        
        public long E(final a a) {
            final boolean equals = a.equals(this.b.get(0));
            long b = -9223372036854775807L;
            if (!equals) {
                return -9223372036854775807L;
            }
            final long i = this.a.i();
            if (i != -9223372036854775807L) {
                b = ServerSideAdInsertionUtil.b(i, a.b, this.e);
            }
            return b;
        }
        
        public void F(final a a, final long n) {
            this.a.g(this.q(a, n));
        }
        
        public void G(final MediaSource mediaSource) {
            mediaSource.I(this.a);
        }
        
        public void H(final a a) {
            if (a.equals(this.f)) {
                this.f = null;
                this.c.clear();
            }
            this.b.remove(a);
        }
        
        public long I(final a a, long e) {
            e = ServerSideAdInsertionUtil.e(e, a.b, this.e);
            return ServerSideAdInsertionUtil.b(this.a.h(e), a.b, this.e);
        }
        
        public long J(final a a, final ExoTrackSelection[] array, final boolean[] array2, final SampleStream[] array3, final boolean[] array4, long f) {
            a.f = f;
            final List<a> b = this.b;
            int i = 0;
            if (a.equals(b.get(0))) {
                this.i = Arrays.copyOf(array, array.length);
                f = ServerSideAdInsertionUtil.e(f, a.b, this.e);
                final SampleStream[] j = this.j;
                SampleStream[] array5;
                if (j.length == 0) {
                    array5 = new SampleStream[array.length];
                }
                else {
                    array5 = Arrays.copyOf(j, j.length);
                }
                f = this.a.k(array, array2, array5, array4, f);
                this.j = Arrays.copyOf(array5, array5.length);
                this.p = Arrays.copyOf(this.p, array5.length);
                while (i < array5.length) {
                    if (array5[i] == null) {
                        array3[i] = null;
                        this.p[i] = null;
                    }
                    else if (array3[i] == null || array4[i]) {
                        array3[i] = new b(a, i);
                        this.p[i] = null;
                    }
                    ++i;
                }
                return ServerSideAdInsertionUtil.b(f, a.b, this.e);
            }
            for (int k = 0; k < array.length; ++k) {
                final ExoTrackSelection exoTrackSelection = array[k];
                final boolean b2 = true;
                if (exoTrackSelection != null) {
                    boolean b3 = b2;
                    if (array2[k]) {
                        b3 = (array3[k] == null && b2);
                    }
                    array4[k] = b3;
                    if (array4[k]) {
                        SampleStream sampleStream;
                        if (Util.c(this.i[k], array[k])) {
                            sampleStream = new b(a, k);
                        }
                        else {
                            sampleStream = new EmptySampleStream();
                        }
                        array3[k] = sampleStream;
                    }
                }
                else {
                    array3[k] = null;
                    array4[k] = true;
                }
            }
            return f;
        }
        
        public int K(final a a, final int n, long e) {
            e = ServerSideAdInsertionUtil.e(e, a.b, this.e);
            return Util.j(this.j[n]).l(e);
        }
        
        public void d(final a a) {
            this.b.add(a);
        }
        
        public boolean e(final MediaPeriodId mediaPeriodId, final long n) {
            final a a = (a)Iterables.h((Iterable)this.b);
            return ServerSideAdInsertionUtil.e(n, mediaPeriodId, this.e) == ServerSideAdInsertionUtil.e(ServerSideAdInsertionMediaSource.p0(a, this.e), a.b, this.e);
        }
        
        public boolean f(final a f, long q) {
            final a f2 = this.f;
            if (f2 != null && !f.equals(f2)) {
                for (final Pair pair : this.c.values()) {
                    f2.c.v((LoadEventInfo)pair.first, ServerSideAdInsertionMediaSource.q0(f2, (MediaLoadData)pair.second, this.e));
                    f.c.B((LoadEventInfo)pair.first, ServerSideAdInsertionMediaSource.q0(f, (MediaLoadData)pair.second, this.e));
                }
            }
            this.f = f;
            q = this.q(f, q);
            return this.a.d(q);
        }
        
        public void g(final a a, long e, final boolean b) {
            e = ServerSideAdInsertionUtil.e(e, a.b, this.e);
            this.a.q(e, b);
        }
        
        public long i(final a a, long e, final SeekParameters seekParameters) {
            e = ServerSideAdInsertionUtil.e(e, a.b, this.e);
            return ServerSideAdInsertionUtil.b(this.a.c(e, seekParameters), a.b, this.e);
        }
        
        public long j(final a a) {
            return this.n(a, this.a.f());
        }
        
        public a k(final MediaLoadData mediaLoadData) {
            if (mediaLoadData != null && mediaLoadData.f != -9223372036854775807L) {
                for (int i = 0; i < this.b.size(); ++i) {
                    final a a = this.b.get(i);
                    final long b = ServerSideAdInsertionUtil.b(Util.C0(mediaLoadData.f), a.b, this.e);
                    final long p = ServerSideAdInsertionMediaSource.p0(a, this.e);
                    if (b >= 0L && b < p) {
                        return a;
                    }
                }
            }
            return null;
        }
        
        @Override
        public /* bridge */ void l(final SequenceableLoader sequenceableLoader) {
            this.y((MediaPeriod)sequenceableLoader);
        }
        
        @Override
        public void o(final MediaPeriod mediaPeriod) {
            this.h = true;
            for (int i = 0; i < this.b.size(); ++i) {
                final a a = this.b.get(i);
                final Callback e = a.e;
                if (e != null) {
                    e.o(a);
                }
            }
        }
        
        public long p(final a a) {
            return this.n(a, this.a.b());
        }
        
        public TrackGroupArray r() {
            return this.a.p();
        }
        
        public boolean s(final a a) {
            return a.equals(this.f) && this.a.isLoading();
        }
        
        public boolean t(final int n) {
            return Util.j(this.j[n]).isReady();
        }
        
        public boolean u() {
            return this.b.isEmpty();
        }
        
        public void w(final int n) throws IOException {
            Util.j(this.j[n]).a();
        }
        
        public void x() throws IOException {
            this.a.n();
        }
        
        public void y(final MediaPeriod mediaPeriod) {
            final a f = this.f;
            if (f == null) {
                return;
            }
            ((SequenceableLoader.Callback<a>)Assertions.e(f.e)).l(this.f);
        }
        
        public void z(final a a, final MediaLoadData mediaLoadData) {
            final int h = this.h(mediaLoadData);
            if (h != -1) {
                this.p[h] = mediaLoadData;
                a.g[h] = true;
            }
        }
    }
}
