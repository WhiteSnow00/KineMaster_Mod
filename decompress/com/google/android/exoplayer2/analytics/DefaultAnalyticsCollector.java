// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.exoplayer2.analytics;

import java.util.AbstractCollection;
import java.util.Collection;
import com.google.common.collect.Iterables;
import com.google.common.base.Objects;
import com.google.common.collect.ImmutableMap$Builder;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableList;
import j3.i1;
import j3.f0;
import j3.g;
import j3.e0;
import j3.m;
import j3.h1;
import j3.h;
import j3.n0;
import j3.b0;
import j3.j1;
import j3.m0;
import j3.x;
import j3.l0;
import j3.d;
import j3.e;
import j3.a1;
import j3.z0;
import j3.h0;
import j3.k1;
import j3.i;
import j3.e1;
import j3.t;
import j3.s;
import j3.c;
import j3.b;
import j3.u;
import j3.c1;
import j3.c0;
import j3.r;
import j3.q;
import j3.y0;
import j3.b1;
import j3.j;
import j3.n;
import j3.x0;
import j3.k0;
import j3.v;
import j3.r0;
import j3.p;
import j3.f;
import j3.z;
import j3.i0;
import j3.y;
import j3.o0;
import j3.k;
import j3.o;
import j3.v0;
import j3.u0;
import j3.w0;
import j3.d1;
import j3.a0;
import j3.g0;
import j3.t0;
import j3.a;
import j3.p0;
import j3.l1;
import j3.d0;
import j3.w;
import j3.q0;
import j3.j0;
import j3.s0;
import j3.f1;
import android.os.Handler$Callback;
import android.os.Looper;
import com.google.android.exoplayer2.text.CueGroup;
import com.google.android.exoplayer2.text.Cue;
import j3.l;
import com.google.android.exoplayer2.source.MediaPeriodId;
import com.google.android.exoplayer2.ExoPlaybackException;
import com.google.android.exoplayer2.source.MediaSource;
import java.util.List;
import com.google.android.exoplayer2.PlaybackException;
import com.google.android.exoplayer2.PlaybackParameters;
import com.google.android.exoplayer2.DeviceInfo;
import com.google.android.exoplayer2.metadata.Metadata;
import com.google.android.exoplayer2.util.FlagSet;
import com.google.android.exoplayer2.MediaMetadata;
import com.google.android.exoplayer2.MediaItem;
import java.io.IOException;
import com.google.android.exoplayer2.source.MediaLoadData;
import com.google.android.exoplayer2.source.LoadEventInfo;
import com.google.android.exoplayer2.decoder.DecoderCounters;
import com.google.android.exoplayer2.video.VideoSize;
import com.google.android.exoplayer2.Tracks;
import com.google.android.exoplayer2.trackselection.TrackSelectionParameters;
import com.google.android.exoplayer2.decoder.DecoderReuseEvaluation;
import com.google.android.exoplayer2.Format;
import j3.g1;
import com.google.android.exoplayer2.util.Util;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.HandlerWrapper;
import com.google.android.exoplayer2.Player;
import com.google.android.exoplayer2.util.ListenerSet;
import android.util.SparseArray;
import com.google.android.exoplayer2.Timeline;
import com.google.android.exoplayer2.util.Clock;

public class DefaultAnalyticsCollector implements AnalyticsCollector
{
    private final Clock a;
    private final Timeline.Period b;
    private final Timeline.Window c;
    private final a d;
    private final SparseArray<AnalyticsListener.EventTime> e;
    private ListenerSet<AnalyticsListener> f;
    private Player g;
    private HandlerWrapper h;
    private boolean i;
    
    public DefaultAnalyticsCollector(final Clock clock) {
        this.a = Assertions.e(clock);
        this.f = new ListenerSet<AnalyticsListener>(Util.Q(), clock, (ListenerSet.IterationFinishedEvent<AnalyticsListener>)g1.a);
        final Timeline.Period b = new Timeline.Period();
        this.b = b;
        this.c = new Timeline.Window();
        this.d = new a(b);
        this.e = (SparseArray<AnalyticsListener.EventTime>)new SparseArray();
    }
    
    public static void A(final AnalyticsListener.EventTime eventTime, final Format format, final DecoderReuseEvaluation decoderReuseEvaluation, final AnalyticsListener analyticsListener) {
        k2(eventTime, format, decoderReuseEvaluation, analyticsListener);
    }
    
    public static void A0(final AnalyticsListener.EventTime eventTime, final AnalyticsListener analyticsListener) {
        x1(eventTime, analyticsListener);
    }
    
    private static void A1(final AnalyticsListener.EventTime eventTime, final Exception ex, final AnalyticsListener analyticsListener) {
        analyticsListener.d(eventTime, ex);
    }
    
    public static void B(final DefaultAnalyticsCollector defaultAnalyticsCollector) {
        defaultAnalyticsCollector.p2();
    }
    
    public static void B0(final AnalyticsListener.EventTime eventTime, final boolean b, final int n, final AnalyticsListener analyticsListener) {
        M1(eventTime, b, n, analyticsListener);
    }
    
    private static void B1(final AnalyticsListener.EventTime eventTime, final AnalyticsListener analyticsListener) {
        analyticsListener.V(eventTime);
    }
    
    public static void C(final AnalyticsListener.EventTime eventTime, final TrackSelectionParameters trackSelectionParameters, final AnalyticsListener analyticsListener) {
        b2(eventTime, trackSelectionParameters, analyticsListener);
    }
    
    public static void C0(final AnalyticsListener.EventTime eventTime, final int n, final AnalyticsListener analyticsListener) {
        O1(eventTime, n, analyticsListener);
    }
    
    private static void C1(final AnalyticsListener.EventTime eventTime, final int n, final long n2, final AnalyticsListener analyticsListener) {
        analyticsListener.v(eventTime, n, n2);
    }
    
    public static void D0(final AnalyticsListener.EventTime eventTime, final Tracks tracks, final AnalyticsListener analyticsListener) {
        c2(eventTime, tracks, analyticsListener);
    }
    
    private static void D1(final AnalyticsListener.EventTime eventTime, final boolean b, final AnalyticsListener analyticsListener) {
        analyticsListener.g(eventTime, b);
        analyticsListener.y0(eventTime, b);
    }
    
    public static void E(final AnalyticsListener.EventTime eventTime, final VideoSize videoSize, final AnalyticsListener analyticsListener) {
        l2(eventTime, videoSize, analyticsListener);
    }
    
    public static void E0(final AnalyticsListener.EventTime eventTime, final DecoderCounters decoderCounters, final AnalyticsListener analyticsListener) {
        j1(eventTime, decoderCounters, analyticsListener);
    }
    
    private static void E1(final AnalyticsListener.EventTime eventTime, final boolean b, final AnalyticsListener analyticsListener) {
        analyticsListener.k0(eventTime, b);
    }
    
    public static void F(final AnalyticsListener.EventTime eventTime, final int n, final AnalyticsListener analyticsListener) {
        V1(eventTime, n, analyticsListener);
    }
    
    public static void F0(final AnalyticsListener.EventTime eventTime, final int n, final AnalyticsListener analyticsListener) {
        P1(eventTime, n, analyticsListener);
    }
    
    private static void F1(final AnalyticsListener.EventTime eventTime, final LoadEventInfo loadEventInfo, final MediaLoadData mediaLoadData, final AnalyticsListener analyticsListener) {
        analyticsListener.j0(eventTime, loadEventInfo, mediaLoadData);
    }
    
    public static void G0(final AnalyticsListener.EventTime eventTime, final boolean b, final int n, final AnalyticsListener analyticsListener) {
        S1(eventTime, b, n, analyticsListener);
    }
    
    private static void G1(final AnalyticsListener.EventTime eventTime, final LoadEventInfo loadEventInfo, final MediaLoadData mediaLoadData, final AnalyticsListener analyticsListener) {
        analyticsListener.n0(eventTime, loadEventInfo, mediaLoadData);
    }
    
    public static void H0(final AnalyticsListener.EventTime eventTime, final LoadEventInfo loadEventInfo, final MediaLoadData mediaLoadData, final AnalyticsListener analyticsListener) {
        I1(eventTime, loadEventInfo, mediaLoadData, analyticsListener);
    }
    
    private static void H1(final AnalyticsListener.EventTime eventTime, final LoadEventInfo loadEventInfo, final MediaLoadData mediaLoadData, final IOException ex, final boolean b, final AnalyticsListener analyticsListener) {
        analyticsListener.k(eventTime, loadEventInfo, mediaLoadData, ex, b);
    }
    
    public static void I(final AnalyticsListener.EventTime eventTime, final MediaLoadData mediaLoadData, final AnalyticsListener analyticsListener) {
        v1(eventTime, mediaLoadData, analyticsListener);
    }
    
    public static void I0(final AnalyticsListener.EventTime eventTime, final DecoderCounters decoderCounters, final AnalyticsListener analyticsListener) {
        k1(eventTime, decoderCounters, analyticsListener);
    }
    
    private static void I1(final AnalyticsListener.EventTime eventTime, final LoadEventInfo loadEventInfo, final MediaLoadData mediaLoadData, final AnalyticsListener analyticsListener) {
        analyticsListener.Q(eventTime, loadEventInfo, mediaLoadData);
    }
    
    public static void J0(final AnalyticsListener.EventTime eventTime, final int n, final AnalyticsListener analyticsListener) {
        a2(eventTime, n, analyticsListener);
    }
    
    private static void J1(final AnalyticsListener.EventTime eventTime, final MediaItem mediaItem, final int n, final AnalyticsListener analyticsListener) {
        analyticsListener.F(eventTime, mediaItem, n);
    }
    
    public static void K(final AnalyticsListener.EventTime eventTime, final long n, final int n2, final AnalyticsListener analyticsListener) {
        j2(eventTime, n, n2, analyticsListener);
    }
    
    public static void K0(final AnalyticsListener.EventTime eventTime, final boolean b, final AnalyticsListener analyticsListener) {
        D1(eventTime, b, analyticsListener);
    }
    
    private static void K1(final AnalyticsListener.EventTime eventTime, final MediaMetadata mediaMetadata, final AnalyticsListener analyticsListener) {
        analyticsListener.h(eventTime, mediaMetadata);
    }
    
    public static void L(final AnalyticsListener.EventTime eventTime, final DecoderCounters decoderCounters, final AnalyticsListener analyticsListener) {
        h2(eventTime, decoderCounters, analyticsListener);
    }
    
    public static void L0(final DefaultAnalyticsCollector defaultAnalyticsCollector, final Player player, final AnalyticsListener analyticsListener, final FlagSet set) {
        defaultAnalyticsCollector.o2(player, analyticsListener, set);
    }
    
    private static void L1(final AnalyticsListener.EventTime eventTime, final Metadata metadata, final AnalyticsListener analyticsListener) {
        analyticsListener.n(eventTime, metadata);
    }
    
    public static void M0(final AnalyticsListener analyticsListener, final FlagSet set) {
        e1(analyticsListener, set);
    }
    
    private static void M1(final AnalyticsListener.EventTime eventTime, final boolean b, final int n, final AnalyticsListener analyticsListener) {
        analyticsListener.z(eventTime, b, n);
    }
    
    public static void N(final AnalyticsListener.EventTime eventTime, final DeviceInfo deviceInfo, final AnalyticsListener analyticsListener) {
        t1(eventTime, deviceInfo, analyticsListener);
    }
    
    public static void N0(final AnalyticsListener.EventTime eventTime, final AnalyticsListener analyticsListener) {
        y1(eventTime, analyticsListener);
    }
    
    private static void N1(final AnalyticsListener.EventTime eventTime, final PlaybackParameters playbackParameters, final AnalyticsListener analyticsListener) {
        analyticsListener.W(eventTime, playbackParameters);
    }
    
    public static void O0(final AnalyticsListener.EventTime eventTime, final long n, final AnalyticsListener analyticsListener) {
        m1(eventTime, n, analyticsListener);
    }
    
    private static void O1(final AnalyticsListener.EventTime eventTime, final int n, final AnalyticsListener analyticsListener) {
        analyticsListener.q(eventTime, n);
    }
    
    public static void P0(final AnalyticsListener.EventTime eventTime, final DecoderCounters decoderCounters, final AnalyticsListener analyticsListener) {
        i2(eventTime, decoderCounters, analyticsListener);
    }
    
    private static void P1(final AnalyticsListener.EventTime eventTime, final int n, final AnalyticsListener analyticsListener) {
        analyticsListener.f(eventTime, n);
    }
    
    public static void Q(final AnalyticsListener.EventTime eventTime, final boolean b, final AnalyticsListener analyticsListener) {
        X1(eventTime, b, analyticsListener);
    }
    
    public static void Q0(final AnalyticsListener.EventTime eventTime, final String s, final AnalyticsListener analyticsListener) {
        i1(eventTime, s, analyticsListener);
    }
    
    private static void Q1(final AnalyticsListener.EventTime eventTime, final PlaybackException ex, final AnalyticsListener analyticsListener) {
        analyticsListener.S(eventTime, ex);
    }
    
    public static void R(final AnalyticsListener.EventTime eventTime, final float n, final AnalyticsListener analyticsListener) {
        m2(eventTime, n, analyticsListener);
    }
    
    public static void R0(final AnalyticsListener.EventTime eventTime, final Object o, final long n, final AnalyticsListener analyticsListener) {
        U1(eventTime, o, n, analyticsListener);
    }
    
    private static void R1(final AnalyticsListener.EventTime eventTime, final PlaybackException ex, final AnalyticsListener analyticsListener) {
        analyticsListener.i(eventTime, ex);
    }
    
    public static void S(final AnalyticsListener.EventTime eventTime, final boolean b, final AnalyticsListener analyticsListener) {
        Y1(eventTime, b, analyticsListener);
    }
    
    public static void S0(final AnalyticsListener.EventTime eventTime, final Exception ex, final AnalyticsListener analyticsListener) {
        A1(eventTime, ex, analyticsListener);
    }
    
    private static void S1(final AnalyticsListener.EventTime eventTime, final boolean b, final int n, final AnalyticsListener analyticsListener) {
        analyticsListener.p(eventTime, b, n);
    }
    
    public static void T(final AnalyticsListener.EventTime eventTime, final AnalyticsListener analyticsListener) {
        B1(eventTime, analyticsListener);
    }
    
    public static void T0(final AnalyticsListener.EventTime eventTime, final AnalyticsListener analyticsListener) {
        f1(eventTime, analyticsListener);
    }
    
    private static void T1(final AnalyticsListener.EventTime eventTime, final int n, final PositionInfo positionInfo, final PositionInfo positionInfo2, final AnalyticsListener analyticsListener) {
        analyticsListener.T(eventTime, n);
        analyticsListener.p0(eventTime, positionInfo, positionInfo2, n);
    }
    
    public static void U(final AnalyticsListener.EventTime eventTime, final List list, final AnalyticsListener analyticsListener) {
        r1(eventTime, list, analyticsListener);
    }
    
    public static void U0(final AnalyticsListener.EventTime eventTime, final String s, final long n, final long n2, final AnalyticsListener analyticsListener) {
        f2(eventTime, s, n, n2, analyticsListener);
    }
    
    private static void U1(final AnalyticsListener.EventTime eventTime, final Object o, final long n, final AnalyticsListener analyticsListener) {
        analyticsListener.v0(eventTime, o, n);
    }
    
    public static void V(final AnalyticsListener.EventTime eventTime, final PlaybackParameters playbackParameters, final AnalyticsListener analyticsListener) {
        N1(eventTime, playbackParameters, analyticsListener);
    }
    
    public static void V0(final AnalyticsListener.EventTime eventTime, final PlaybackException ex, final AnalyticsListener analyticsListener) {
        R1(eventTime, ex, analyticsListener);
    }
    
    private static void V1(final AnalyticsListener.EventTime eventTime, final int n, final AnalyticsListener analyticsListener) {
        analyticsListener.b0(eventTime, n);
    }
    
    public static void W(final AnalyticsListener.EventTime eventTime, final MediaItem mediaItem, final int n, final AnalyticsListener analyticsListener) {
        J1(eventTime, mediaItem, n, analyticsListener);
    }
    
    private static void W1(final AnalyticsListener.EventTime eventTime, final AnalyticsListener analyticsListener) {
        analyticsListener.P(eventTime);
    }
    
    private static void X1(final AnalyticsListener.EventTime eventTime, final boolean b, final AnalyticsListener analyticsListener) {
        analyticsListener.u(eventTime, b);
    }
    
    private AnalyticsListener.EventTime Y0(final MediaSource.MediaPeriodId mediaPeriodId) {
        Assertions.e(this.g);
        Timeline f;
        if (mediaPeriodId == null) {
            f = null;
        }
        else {
            f = this.d.f(mediaPeriodId);
        }
        if (mediaPeriodId != null && f != null) {
            return this.X0(f, f.l(mediaPeriodId.a, this.b).c, mediaPeriodId);
        }
        final int y = this.g.Y();
        Timeline timeline = this.g.w();
        if (y >= timeline.t()) {
            timeline = Timeline.a;
        }
        return this.X0(timeline, y, null);
    }
    
    private static void Y1(final AnalyticsListener.EventTime eventTime, final boolean b, final AnalyticsListener analyticsListener) {
        analyticsListener.x(eventTime, b);
    }
    
    private AnalyticsListener.EventTime Z0() {
        return this.Y0(this.d.e());
    }
    
    private static void Z1(final AnalyticsListener.EventTime eventTime, final int n, final int n2, final AnalyticsListener analyticsListener) {
        analyticsListener.t(eventTime, n, n2);
    }
    
    private AnalyticsListener.EventTime a1(final int n, final MediaSource.MediaPeriodId mediaPeriodId) {
        Assertions.e(this.g);
        final int n2 = 1;
        boolean b = true;
        if (mediaPeriodId != null) {
            if (this.d.f(mediaPeriodId) == null) {
                b = false;
            }
            AnalyticsListener.EventTime eventTime;
            if (b) {
                eventTime = this.Y0(mediaPeriodId);
            }
            else {
                eventTime = this.X0(Timeline.a, n, mediaPeriodId);
            }
            return eventTime;
        }
        Timeline timeline = this.g.w();
        int n3;
        if (n < timeline.t()) {
            n3 = n2;
        }
        else {
            n3 = 0;
        }
        if (n3 == 0) {
            timeline = Timeline.a;
        }
        return this.X0(timeline, n, null);
    }
    
    private static void a2(final AnalyticsListener.EventTime eventTime, final int n, final AnalyticsListener analyticsListener) {
        analyticsListener.D(eventTime, n);
    }
    
    private AnalyticsListener.EventTime b1() {
        return this.Y0(this.d.g());
    }
    
    private static void b2(final AnalyticsListener.EventTime eventTime, final TrackSelectionParameters trackSelectionParameters, final AnalyticsListener analyticsListener) {
        analyticsListener.H(eventTime, trackSelectionParameters);
    }
    
    private AnalyticsListener.EventTime c1() {
        return this.Y0(this.d.h());
    }
    
    private static void c2(final AnalyticsListener.EventTime eventTime, final Tracks tracks, final AnalyticsListener analyticsListener) {
        analyticsListener.G(eventTime, tracks);
    }
    
    public static void d0(final AnalyticsListener.EventTime eventTime, final PlaybackException ex, final AnalyticsListener analyticsListener) {
        Q1(eventTime, ex, analyticsListener);
    }
    
    private AnalyticsListener.EventTime d1(final PlaybackException ex) {
        if (ex instanceof ExoPlaybackException) {
            final MediaPeriodId mediaPeriodId = ((ExoPlaybackException)ex).mediaPeriodId;
            if (mediaPeriodId != null) {
                return this.Y0(new MediaSource.MediaPeriodId(mediaPeriodId));
            }
        }
        return this.W0();
    }
    
    private static void d2(final AnalyticsListener.EventTime eventTime, final MediaLoadData mediaLoadData, final AnalyticsListener analyticsListener) {
        analyticsListener.o0(eventTime, mediaLoadData);
    }
    
    public static void e0(final AnalyticsListener.EventTime eventTime, final Exception ex, final AnalyticsListener analyticsListener) {
        e2(eventTime, ex, analyticsListener);
    }
    
    private static void e1(final AnalyticsListener analyticsListener, final FlagSet set) {
    }
    
    private static void e2(final AnalyticsListener.EventTime eventTime, final Exception ex, final AnalyticsListener analyticsListener) {
        analyticsListener.C(eventTime, ex);
    }
    
    public static void f0(final AnalyticsListener.EventTime eventTime, final LoadEventInfo loadEventInfo, final MediaLoadData mediaLoadData, final AnalyticsListener analyticsListener) {
        G1(eventTime, loadEventInfo, mediaLoadData, analyticsListener);
    }
    
    private static void f1(final AnalyticsListener.EventTime eventTime, final AnalyticsListener analyticsListener) {
        analyticsListener.E(eventTime);
    }
    
    private static void f2(final AnalyticsListener.EventTime eventTime, final String s, final long n, final long n2, final AnalyticsListener analyticsListener) {
        analyticsListener.s0(eventTime, s, n);
        analyticsListener.A(eventTime, s, n2, n);
        analyticsListener.R(eventTime, 2, s, n);
    }
    
    public static void g0(final AnalyticsListener.EventTime eventTime, final AnalyticsListener analyticsListener) {
        n2(eventTime, analyticsListener);
    }
    
    private static void g1(final AnalyticsListener.EventTime eventTime, final Exception ex, final AnalyticsListener analyticsListener) {
        analyticsListener.l0(eventTime, ex);
    }
    
    private static void g2(final AnalyticsListener.EventTime eventTime, final String s, final AnalyticsListener analyticsListener) {
        analyticsListener.a(eventTime, s);
    }
    
    public static void h0(final AnalyticsListener.EventTime eventTime, final int n, final int n2, final AnalyticsListener analyticsListener) {
        Z1(eventTime, n, n2, analyticsListener);
    }
    
    private static void h1(final AnalyticsListener.EventTime eventTime, final String s, final long n, final long n2, final AnalyticsListener analyticsListener) {
        analyticsListener.m(eventTime, s, n);
        analyticsListener.a0(eventTime, s, n2, n);
        analyticsListener.R(eventTime, 1, s, n);
    }
    
    private static void h2(final AnalyticsListener.EventTime eventTime, final DecoderCounters decoderCounters, final AnalyticsListener analyticsListener) {
        analyticsListener.J(eventTime, decoderCounters);
        analyticsListener.w0(eventTime, 2, decoderCounters);
    }
    
    public static void i0(final AnalyticsListener.EventTime eventTime, final MediaLoadData mediaLoadData, final AnalyticsListener analyticsListener) {
        d2(eventTime, mediaLoadData, analyticsListener);
    }
    
    private static void i1(final AnalyticsListener.EventTime eventTime, final String s, final AnalyticsListener analyticsListener) {
        analyticsListener.q0(eventTime, s);
    }
    
    private static void i2(final AnalyticsListener.EventTime eventTime, final DecoderCounters decoderCounters, final AnalyticsListener analyticsListener) {
        analyticsListener.Z(eventTime, decoderCounters);
        analyticsListener.l(eventTime, 2, decoderCounters);
    }
    
    public static void j0(final AnalyticsListener.EventTime eventTime, final Metadata metadata, final AnalyticsListener analyticsListener) {
        L1(eventTime, metadata, analyticsListener);
    }
    
    private static void j1(final AnalyticsListener.EventTime eventTime, final DecoderCounters decoderCounters, final AnalyticsListener analyticsListener) {
        analyticsListener.Y(eventTime, decoderCounters);
        analyticsListener.w0(eventTime, 1, decoderCounters);
    }
    
    private static void j2(final AnalyticsListener.EventTime eventTime, final long n, final int n2, final AnalyticsListener analyticsListener) {
        analyticsListener.b(eventTime, n, n2);
    }
    
    public static void k0(final AnalyticsListener.EventTime eventTime, final int n, final AnalyticsListener analyticsListener) {
        z1(eventTime, n, analyticsListener);
    }
    
    private static void k1(final AnalyticsListener.EventTime eventTime, final DecoderCounters decoderCounters, final AnalyticsListener analyticsListener) {
        analyticsListener.j(eventTime, decoderCounters);
        analyticsListener.l(eventTime, 1, decoderCounters);
    }
    
    private static void k2(final AnalyticsListener.EventTime eventTime, final Format format, final DecoderReuseEvaluation decoderReuseEvaluation, final AnalyticsListener analyticsListener) {
        analyticsListener.r(eventTime, format);
        analyticsListener.B(eventTime, format, decoderReuseEvaluation);
        analyticsListener.O(eventTime, 2, format);
    }
    
    public static void l0(final AnalyticsListener.EventTime eventTime, final Format format, final DecoderReuseEvaluation decoderReuseEvaluation, final AnalyticsListener analyticsListener) {
        l1(eventTime, format, decoderReuseEvaluation, analyticsListener);
    }
    
    private static void l1(final AnalyticsListener.EventTime eventTime, final Format format, final DecoderReuseEvaluation decoderReuseEvaluation, final AnalyticsListener analyticsListener) {
        analyticsListener.g0(eventTime, format);
        analyticsListener.t0(eventTime, format, decoderReuseEvaluation);
        analyticsListener.O(eventTime, 1, format);
    }
    
    private static void l2(final AnalyticsListener.EventTime eventTime, final VideoSize videoSize, final AnalyticsListener analyticsListener) {
        analyticsListener.d0(eventTime, videoSize);
        analyticsListener.N(eventTime, videoSize.a, videoSize.b, videoSize.c, videoSize.d);
    }
    
    public static void m0(final AnalyticsListener.EventTime eventTime, final AnalyticsListener analyticsListener) {
        w1(eventTime, analyticsListener);
    }
    
    private static void m1(final AnalyticsListener.EventTime eventTime, final long n, final AnalyticsListener analyticsListener) {
        analyticsListener.s(eventTime, n);
    }
    
    private static void m2(final AnalyticsListener.EventTime eventTime, final float n, final AnalyticsListener analyticsListener) {
        analyticsListener.i0(eventTime, n);
    }
    
    public static void n0(final AnalyticsListener.EventTime eventTime, final AnalyticsListener analyticsListener) {
        W1(eventTime, analyticsListener);
    }
    
    private static void n1(final AnalyticsListener.EventTime eventTime, final Exception ex, final AnalyticsListener analyticsListener) {
        analyticsListener.w(eventTime, ex);
    }
    
    private static void n2(final AnalyticsListener.EventTime eventTime, final AnalyticsListener analyticsListener) {
        analyticsListener.c0(eventTime);
    }
    
    public static void o0(final AnalyticsListener.EventTime eventTime, final LoadEventInfo loadEventInfo, final MediaLoadData mediaLoadData, final AnalyticsListener analyticsListener) {
        F1(eventTime, loadEventInfo, mediaLoadData, analyticsListener);
    }
    
    private static void o1(final AnalyticsListener.EventTime eventTime, final int n, final long n2, final long n3, final AnalyticsListener analyticsListener) {
        analyticsListener.X(eventTime, n, n2, n3);
    }
    
    private void o2(final Player player, final AnalyticsListener analyticsListener, final FlagSet set) {
        analyticsListener.o(player, new AnalyticsListener.Events(set, this.e));
    }
    
    public static void p0(final AnalyticsListener.EventTime eventTime, final int n, final long n2, final long n3, final AnalyticsListener analyticsListener) {
        q1(eventTime, n, n2, n3, analyticsListener);
    }
    
    private static void p1(final AnalyticsListener.EventTime eventTime, final Commands commands, final AnalyticsListener analyticsListener) {
        analyticsListener.u0(eventTime, commands);
    }
    
    private void p2() {
        final AnalyticsListener.EventTime w0 = this.W0();
        this.q2(w0, 1028, (ListenerSet.Event<AnalyticsListener>)new l(w0));
        this.f.j();
    }
    
    public static void q0(final AnalyticsListener.EventTime eventTime, final int n, final PositionInfo positionInfo, final PositionInfo positionInfo2, final AnalyticsListener analyticsListener) {
        T1(eventTime, n, positionInfo, positionInfo2, analyticsListener);
    }
    
    private static void q1(final AnalyticsListener.EventTime eventTime, final int n, final long n2, final long n3, final AnalyticsListener analyticsListener) {
        analyticsListener.L(eventTime, n, n2, n3);
    }
    
    public static void r0(final AnalyticsListener.EventTime eventTime, final LoadEventInfo loadEventInfo, final MediaLoadData mediaLoadData, final IOException ex, final boolean b, final AnalyticsListener analyticsListener) {
        H1(eventTime, loadEventInfo, mediaLoadData, ex, b, analyticsListener);
    }
    
    private static void r1(final AnalyticsListener.EventTime eventTime, final List list, final AnalyticsListener analyticsListener) {
        analyticsListener.y(eventTime, list);
    }
    
    public static void s0(final AnalyticsListener.EventTime eventTime, final CueGroup cueGroup, final AnalyticsListener analyticsListener) {
        s1(eventTime, cueGroup, analyticsListener);
    }
    
    private static void s1(final AnalyticsListener.EventTime eventTime, final CueGroup cueGroup, final AnalyticsListener analyticsListener) {
        analyticsListener.U(eventTime, cueGroup);
    }
    
    public static void t0(final AnalyticsListener.EventTime eventTime, final MediaMetadata mediaMetadata, final AnalyticsListener analyticsListener) {
        K1(eventTime, mediaMetadata, analyticsListener);
    }
    
    private static void t1(final AnalyticsListener.EventTime eventTime, final DeviceInfo deviceInfo, final AnalyticsListener analyticsListener) {
        analyticsListener.x0(eventTime, deviceInfo);
    }
    
    public static void u0(final AnalyticsListener.EventTime eventTime, final int n, final long n2, final AnalyticsListener analyticsListener) {
        C1(eventTime, n, n2, analyticsListener);
    }
    
    private static void u1(final AnalyticsListener.EventTime eventTime, final int n, final boolean b, final AnalyticsListener analyticsListener) {
        analyticsListener.M(eventTime, n, b);
    }
    
    public static void v(final AnalyticsListener.EventTime eventTime, final Exception ex, final AnalyticsListener analyticsListener) {
        g1(eventTime, ex, analyticsListener);
    }
    
    public static void v0(final AnalyticsListener.EventTime eventTime, final Exception ex, final AnalyticsListener analyticsListener) {
        n1(eventTime, ex, analyticsListener);
    }
    
    private static void v1(final AnalyticsListener.EventTime eventTime, final MediaLoadData mediaLoadData, final AnalyticsListener analyticsListener) {
        analyticsListener.m0(eventTime, mediaLoadData);
    }
    
    public static void w0(final AnalyticsListener.EventTime eventTime, final String s, final long n, final long n2, final AnalyticsListener analyticsListener) {
        h1(eventTime, s, n, n2, analyticsListener);
    }
    
    private static void w1(final AnalyticsListener.EventTime eventTime, final AnalyticsListener analyticsListener) {
        analyticsListener.h0(eventTime);
    }
    
    public static void x(final AnalyticsListener.EventTime eventTime, final int n, final boolean b, final AnalyticsListener analyticsListener) {
        u1(eventTime, n, b, analyticsListener);
    }
    
    public static void x0(final AnalyticsListener.EventTime eventTime, final Commands commands, final AnalyticsListener analyticsListener) {
        p1(eventTime, commands, analyticsListener);
    }
    
    private static void x1(final AnalyticsListener.EventTime eventTime, final AnalyticsListener analyticsListener) {
        analyticsListener.K(eventTime);
    }
    
    public static void y(final AnalyticsListener.EventTime eventTime, final boolean b, final AnalyticsListener analyticsListener) {
        E1(eventTime, b, analyticsListener);
    }
    
    public static void y0(final AnalyticsListener.EventTime eventTime, final String s, final AnalyticsListener analyticsListener) {
        g2(eventTime, s, analyticsListener);
    }
    
    private static void y1(final AnalyticsListener.EventTime eventTime, final AnalyticsListener analyticsListener) {
        analyticsListener.e(eventTime);
    }
    
    public static void z0(final AnalyticsListener.EventTime eventTime, final int n, final long n2, final long n3, final AnalyticsListener analyticsListener) {
        o1(eventTime, n, n2, n3, analyticsListener);
    }
    
    private static void z1(final AnalyticsListener.EventTime eventTime, final int n, final AnalyticsListener analyticsListener) {
        analyticsListener.I(eventTime);
        analyticsListener.c(eventTime, n);
    }
    
    @Override
    public void D(final Player player, final Looper looper) {
        Assertions.g(this.g == null || ((AbstractCollection)DefaultAnalyticsCollector.a.a(this.d)).isEmpty());
        this.g = Assertions.e(player);
        this.h = this.a.e(looper, null);
        this.f = this.f.e(looper, (ListenerSet.IterationFinishedEvent<AnalyticsListener>)new f1(this, player));
    }
    
    @Override
    public final void G(final int n, final MediaSource.MediaPeriodId mediaPeriodId) {
        final AnalyticsListener.EventTime a1 = this.a1(n, mediaPeriodId);
        this.q2(a1, 1026, (ListenerSet.Event<AnalyticsListener>)new s0(a1));
    }
    
    @Override
    public void J(final AnalyticsListener analyticsListener) {
        Assertions.e(analyticsListener);
        this.f.c(analyticsListener);
    }
    
    @Override
    public final void M(final int n, final MediaSource.MediaPeriodId mediaPeriodId, final MediaLoadData mediaLoadData) {
        final AnalyticsListener.EventTime a1 = this.a1(n, mediaPeriodId);
        this.q2(a1, 1005, (ListenerSet.Event<AnalyticsListener>)new j0(a1, mediaLoadData));
    }
    
    @Override
    public final void O(final int n, final MediaSource.MediaPeriodId mediaPeriodId, final Exception ex) {
        final AnalyticsListener.EventTime a1 = this.a1(n, mediaPeriodId);
        this.q2(a1, 1024, (ListenerSet.Event<AnalyticsListener>)new q0(a1, ex));
    }
    
    @Override
    public final void P(final List<MediaSource.MediaPeriodId> list, final MediaSource.MediaPeriodId mediaPeriodId) {
        this.d.k(list, mediaPeriodId, Assertions.e(this.g));
    }
    
    protected final AnalyticsListener.EventTime W0() {
        return this.Y0(this.d.d());
    }
    
    @Override
    public final void X(final int n, final MediaSource.MediaPeriodId mediaPeriodId) {
        final AnalyticsListener.EventTime a1 = this.a1(n, mediaPeriodId);
        this.q2(a1, 1023, (ListenerSet.Event<AnalyticsListener>)new w(a1));
    }
    
    protected final AnalyticsListener.EventTime X0(final Timeline timeline, final int n, MediaSource.MediaPeriodId mediaPeriodId) {
        if (timeline.u()) {
            mediaPeriodId = null;
        }
        final long c = this.a.c();
        final boolean equals = timeline.equals(this.g.w());
        final int n2 = 1;
        final boolean b = equals && n == this.g.Y();
        long n3 = 0L;
        if (mediaPeriodId != null && mediaPeriodId.b()) {
            int n4;
            if (b && this.g.s() == mediaPeriodId.b && this.g.N() == mediaPeriodId.c) {
                n4 = n2;
            }
            else {
                n4 = 0;
            }
            if (n4 != 0) {
                n3 = this.g.g0();
            }
        }
        else if (b) {
            n3 = this.g.R();
        }
        else if (!timeline.u()) {
            n3 = timeline.r(n, this.c).e();
        }
        return new AnalyticsListener.EventTime(c, timeline, n, mediaPeriodId, n3, this.g.w(), this.g.Y(), this.d.d(), this.g.g0(), this.g.f());
    }
    
    @Override
    public final void Y(final int n, final MediaSource.MediaPeriodId mediaPeriodId, final LoadEventInfo loadEventInfo, final MediaLoadData mediaLoadData) {
        final AnalyticsListener.EventTime a1 = this.a1(n, mediaPeriodId);
        this.q2(a1, 1001, (ListenerSet.Event<AnalyticsListener>)new d0(a1, loadEventInfo, mediaLoadData));
    }
    
    @Override
    public final void Z(final int n, final MediaSource.MediaPeriodId mediaPeriodId, final int n2) {
        final AnalyticsListener.EventTime a1 = this.a1(n, mediaPeriodId);
        this.q2(a1, 1022, (ListenerSet.Event<AnalyticsListener>)new l1(a1, n2));
    }
    
    @Override
    public final void a(final Exception ex) {
        final AnalyticsListener.EventTime c1 = this.c1();
        this.q2(c1, 1014, (ListenerSet.Event<AnalyticsListener>)new p0(c1, ex));
    }
    
    @Override
    public final void a0(final int n, final MediaSource.MediaPeriodId mediaPeriodId) {
        final AnalyticsListener.EventTime a1 = this.a1(n, mediaPeriodId);
        this.q2(a1, 1027, (ListenerSet.Event<AnalyticsListener>)new j3.a(a1));
    }
    
    @Override
    public final void b(final String s) {
        final AnalyticsListener.EventTime c1 = this.c1();
        this.q2(c1, 1019, (ListenerSet.Event<AnalyticsListener>)new t0(c1, s));
    }
    
    @Override
    public final void b0(final int n, final MediaSource.MediaPeriodId mediaPeriodId, final LoadEventInfo loadEventInfo, final MediaLoadData mediaLoadData, final IOException ex, final boolean b) {
        final AnalyticsListener.EventTime a1 = this.a1(n, mediaPeriodId);
        this.q2(a1, 1003, (ListenerSet.Event<AnalyticsListener>)new g0(a1, loadEventInfo, mediaLoadData, ex, b));
    }
    
    @Override
    public final void c(final DecoderCounters decoderCounters) {
        final AnalyticsListener.EventTime c1 = this.c1();
        this.q2(c1, 1007, (ListenerSet.Event<AnalyticsListener>)new a0(c1, decoderCounters));
    }
    
    @Override
    public final void c0(final int n, final MediaSource.MediaPeriodId mediaPeriodId) {
        final AnalyticsListener.EventTime a1 = this.a1(n, mediaPeriodId);
        this.q2(a1, 1025, (ListenerSet.Event<AnalyticsListener>)new d1(a1));
    }
    
    @Override
    public final void d(final String s, final long n, final long n2) {
        final AnalyticsListener.EventTime c1 = this.c1();
        this.q2(c1, 1016, (ListenerSet.Event<AnalyticsListener>)new w0(c1, s, n2, n));
    }
    
    @Override
    public final void e(final String s) {
        final AnalyticsListener.EventTime c1 = this.c1();
        this.q2(c1, 1012, (ListenerSet.Event<AnalyticsListener>)new u0(c1, s));
    }
    
    @Override
    public final void f(final String s, final long n, final long n2) {
        final AnalyticsListener.EventTime c1 = this.c1();
        this.q2(c1, 1008, (ListenerSet.Event<AnalyticsListener>)new v0(c1, s, n2, n));
    }
    
    @Override
    public final void g(final Format format, final DecoderReuseEvaluation decoderReuseEvaluation) {
        final AnalyticsListener.EventTime c1 = this.c1();
        this.q2(c1, 1017, (ListenerSet.Event<AnalyticsListener>)new o(c1, format, decoderReuseEvaluation));
    }
    
    @Override
    public final void h(final long n) {
        final AnalyticsListener.EventTime c1 = this.c1();
        this.q2(c1, 1010, (ListenerSet.Event<AnalyticsListener>)new k(c1, n));
    }
    
    @Override
    public final void i(final Exception ex) {
        final AnalyticsListener.EventTime c1 = this.c1();
        this.q2(c1, 1030, (ListenerSet.Event<AnalyticsListener>)new o0(c1, ex));
    }
    
    @Override
    public final void j(final DecoderCounters decoderCounters) {
        final AnalyticsListener.EventTime b1 = this.b1();
        this.q2(b1, 1020, (ListenerSet.Event<AnalyticsListener>)new y(b1, decoderCounters));
    }
    
    @Override
    public final void k(final int n, final MediaSource.MediaPeriodId mediaPeriodId, final MediaLoadData mediaLoadData) {
        final AnalyticsListener.EventTime a1 = this.a1(n, mediaPeriodId);
        this.q2(a1, 1004, (ListenerSet.Event<AnalyticsListener>)new i0(a1, mediaLoadData));
    }
    
    @Override
    public final void l(final DecoderCounters decoderCounters) {
        final AnalyticsListener.EventTime b1 = this.b1();
        this.q2(b1, 1013, (ListenerSet.Event<AnalyticsListener>)new z(b1, decoderCounters));
    }
    
    @Override
    public final void m(final int n, final long n2) {
        final AnalyticsListener.EventTime b1 = this.b1();
        this.q2(b1, 1018, (ListenerSet.Event<AnalyticsListener>)new f(b1, n, n2));
    }
    
    @Override
    public final void n(final Format format, final DecoderReuseEvaluation decoderReuseEvaluation) {
        final AnalyticsListener.EventTime c1 = this.c1();
        this.q2(c1, 1009, (ListenerSet.Event<AnalyticsListener>)new p(c1, format, decoderReuseEvaluation));
    }
    
    @Override
    public final void o(final Object o, final long n) {
        final AnalyticsListener.EventTime c1 = this.c1();
        this.q2(c1, 26, (ListenerSet.Event<AnalyticsListener>)new r0(c1, o, n));
    }
    
    @Override
    public void onAvailableCommandsChanged(final Commands commands) {
        final AnalyticsListener.EventTime w0 = this.W0();
        this.q2(w0, 13, (ListenerSet.Event<AnalyticsListener>)new v(w0, commands));
    }
    
    @Override
    public void onCues(final CueGroup cueGroup) {
        final AnalyticsListener.EventTime w0 = this.W0();
        this.q2(w0, 27, (ListenerSet.Event<AnalyticsListener>)new k0(w0, cueGroup));
    }
    
    @Override
    public void onCues(final List<Cue> list) {
        final AnalyticsListener.EventTime w0 = this.W0();
        this.q2(w0, 27, (ListenerSet.Event<AnalyticsListener>)new x0(w0, (List)list));
    }
    
    @Override
    public void onDeviceInfoChanged(final DeviceInfo deviceInfo) {
        final AnalyticsListener.EventTime w0 = this.W0();
        this.q2(w0, 29, (ListenerSet.Event<AnalyticsListener>)new n(w0, deviceInfo));
    }
    
    @Override
    public void onDeviceVolumeChanged(final int n, final boolean b) {
        final AnalyticsListener.EventTime w0 = this.W0();
        this.q2(w0, 30, (ListenerSet.Event<AnalyticsListener>)new j(w0, n, b));
    }
    
    @Override
    public void onEvents(final Player player, final Events events) {
    }
    
    @Override
    public final void onIsLoadingChanged(final boolean b) {
        final AnalyticsListener.EventTime w0 = this.W0();
        this.q2(w0, 3, (ListenerSet.Event<AnalyticsListener>)new b1(w0, b));
    }
    
    @Override
    public void onIsPlayingChanged(final boolean b) {
        final AnalyticsListener.EventTime w0 = this.W0();
        this.q2(w0, 7, (ListenerSet.Event<AnalyticsListener>)new y0(w0, b));
    }
    
    @Override
    public void onLoadingChanged(final boolean b) {
    }
    
    @Override
    public final void onMediaItemTransition(final MediaItem mediaItem, final int n) {
        final AnalyticsListener.EventTime w0 = this.W0();
        this.q2(w0, 1, (ListenerSet.Event<AnalyticsListener>)new q(w0, mediaItem, n));
    }
    
    @Override
    public void onMediaMetadataChanged(final MediaMetadata mediaMetadata) {
        final AnalyticsListener.EventTime w0 = this.W0();
        this.q2(w0, 14, (ListenerSet.Event<AnalyticsListener>)new r(w0, mediaMetadata));
    }
    
    @Override
    public final void onMetadata(final Metadata metadata) {
        final AnalyticsListener.EventTime w0 = this.W0();
        this.q2(w0, 28, (ListenerSet.Event<AnalyticsListener>)new c0(w0, metadata));
    }
    
    @Override
    public final void onPlayWhenReadyChanged(final boolean b, final int n) {
        final AnalyticsListener.EventTime w0 = this.W0();
        this.q2(w0, 5, (ListenerSet.Event<AnalyticsListener>)new c1(w0, b, n));
    }
    
    @Override
    public final void onPlaybackParametersChanged(final PlaybackParameters playbackParameters) {
        final AnalyticsListener.EventTime w0 = this.W0();
        this.q2(w0, 12, (ListenerSet.Event<AnalyticsListener>)new u(w0, playbackParameters));
    }
    
    @Override
    public final void onPlaybackStateChanged(final int n) {
        final AnalyticsListener.EventTime w0 = this.W0();
        this.q2(w0, 4, (ListenerSet.Event<AnalyticsListener>)new b(w0, n));
    }
    
    @Override
    public final void onPlaybackSuppressionReasonChanged(final int n) {
        final AnalyticsListener.EventTime w0 = this.W0();
        this.q2(w0, 6, (ListenerSet.Event<AnalyticsListener>)new c(w0, n));
    }
    
    @Override
    public final void onPlayerError(final PlaybackException ex) {
        final AnalyticsListener.EventTime d1 = this.d1(ex);
        this.q2(d1, 10, (ListenerSet.Event<AnalyticsListener>)new s(d1, ex));
    }
    
    @Override
    public void onPlayerErrorChanged(final PlaybackException ex) {
        final AnalyticsListener.EventTime d1 = this.d1(ex);
        this.q2(d1, 10, (ListenerSet.Event<AnalyticsListener>)new t(d1, ex));
    }
    
    @Override
    public final void onPlayerStateChanged(final boolean b, final int n) {
        final AnalyticsListener.EventTime w0 = this.W0();
        this.q2(w0, -1, (ListenerSet.Event<AnalyticsListener>)new e1(w0, b, n));
    }
    
    @Override
    public void onPositionDiscontinuity(final int n) {
    }
    
    @Override
    public final void onPositionDiscontinuity(final PositionInfo positionInfo, final PositionInfo positionInfo2, final int n) {
        if (n == 1) {
            this.i = false;
        }
        this.d.j(Assertions.e(this.g));
        final AnalyticsListener.EventTime w0 = this.W0();
        this.q2(w0, 11, (ListenerSet.Event<AnalyticsListener>)new i(w0, n, positionInfo, positionInfo2));
    }
    
    @Override
    public void onRenderedFirstFrame() {
    }
    
    @Override
    public final void onRepeatModeChanged(final int n) {
        final AnalyticsListener.EventTime w0 = this.W0();
        this.q2(w0, 8, (ListenerSet.Event<AnalyticsListener>)new k1(w0, n));
    }
    
    @Override
    public final void onSeekProcessed() {
        final AnalyticsListener.EventTime w0 = this.W0();
        this.q2(w0, -1, (ListenerSet.Event<AnalyticsListener>)new h0(w0));
    }
    
    @Override
    public final void onShuffleModeEnabledChanged(final boolean b) {
        final AnalyticsListener.EventTime w0 = this.W0();
        this.q2(w0, 9, (ListenerSet.Event<AnalyticsListener>)new z0(w0, b));
    }
    
    @Override
    public final void onSkipSilenceEnabledChanged(final boolean b) {
        final AnalyticsListener.EventTime c1 = this.c1();
        this.q2(c1, 23, (ListenerSet.Event<AnalyticsListener>)new a1(c1, b));
    }
    
    @Override
    public final void onSurfaceSizeChanged(final int n, final int n2) {
        final AnalyticsListener.EventTime c1 = this.c1();
        this.q2(c1, 24, (ListenerSet.Event<AnalyticsListener>)new e(c1, n, n2));
    }
    
    @Override
    public final void onTimelineChanged(final Timeline timeline, final int n) {
        this.d.l(Assertions.e(this.g));
        final AnalyticsListener.EventTime w0 = this.W0();
        this.q2(w0, 0, (ListenerSet.Event<AnalyticsListener>)new d(w0, n));
    }
    
    @Override
    public void onTrackSelectionParametersChanged(final TrackSelectionParameters trackSelectionParameters) {
        final AnalyticsListener.EventTime w0 = this.W0();
        this.q2(w0, 19, (ListenerSet.Event<AnalyticsListener>)new l0(w0, trackSelectionParameters));
    }
    
    @Override
    public void onTracksChanged(final Tracks tracks) {
        final AnalyticsListener.EventTime w0 = this.W0();
        this.q2(w0, 2, (ListenerSet.Event<AnalyticsListener>)new x(w0, tracks));
    }
    
    @Override
    public final void onVideoSizeChanged(final VideoSize videoSize) {
        final AnalyticsListener.EventTime c1 = this.c1();
        this.q2(c1, 25, (ListenerSet.Event<AnalyticsListener>)new m0(c1, videoSize));
    }
    
    @Override
    public final void onVolumeChanged(final float n) {
        final AnalyticsListener.EventTime c1 = this.c1();
        this.q2(c1, 22, (ListenerSet.Event<AnalyticsListener>)new j1(c1, n));
    }
    
    @Override
    public final void p(final DecoderCounters decoderCounters) {
        final AnalyticsListener.EventTime c1 = this.c1();
        this.q2(c1, 1015, (ListenerSet.Event<AnalyticsListener>)new b0(c1, decoderCounters));
    }
    
    @Override
    public final void q(final Exception ex) {
        final AnalyticsListener.EventTime c1 = this.c1();
        this.q2(c1, 1029, (ListenerSet.Event<AnalyticsListener>)new n0(c1, ex));
    }
    
    protected final void q2(final AnalyticsListener.EventTime eventTime, final int n, final ListenerSet.Event<AnalyticsListener> event) {
        this.e.put(n, (Object)eventTime);
        this.f.l(n, event);
    }
    
    @Override
    public final void r(final int n, final long n2, final long n3) {
        final AnalyticsListener.EventTime c1 = this.c1();
        this.q2(c1, 1011, (ListenerSet.Event<AnalyticsListener>)new h(c1, n, n2, n3));
    }
    
    @Override
    public void release() {
        Assertions.i(this.h).h((Runnable)new h1(this));
    }
    
    @Override
    public final void s(final long n, final int n2) {
        final AnalyticsListener.EventTime b1 = this.b1();
        this.q2(b1, 1021, (ListenerSet.Event<AnalyticsListener>)new m(b1, n, n2));
    }
    
    @Override
    public final void t(final int n, final MediaSource.MediaPeriodId mediaPeriodId, final LoadEventInfo loadEventInfo, final MediaLoadData mediaLoadData) {
        final AnalyticsListener.EventTime a1 = this.a1(n, mediaPeriodId);
        this.q2(a1, 1002, (ListenerSet.Event<AnalyticsListener>)new e0(a1, loadEventInfo, mediaLoadData));
    }
    
    @Override
    public final void u(final int n, final long n2, final long n3) {
        final AnalyticsListener.EventTime z0 = this.Z0();
        this.q2(z0, 1006, (ListenerSet.Event<AnalyticsListener>)new g(z0, n, n2, n3));
    }
    
    @Override
    public final void w(final int n, final MediaSource.MediaPeriodId mediaPeriodId, final LoadEventInfo loadEventInfo, final MediaLoadData mediaLoadData) {
        final AnalyticsListener.EventTime a1 = this.a1(n, mediaPeriodId);
        this.q2(a1, 1000, (ListenerSet.Event<AnalyticsListener>)new f0(a1, loadEventInfo, mediaLoadData));
    }
    
    @Override
    public final void z() {
        if (!this.i) {
            final AnalyticsListener.EventTime w0 = this.W0();
            this.i = true;
            this.q2(w0, -1, (ListenerSet.Event<AnalyticsListener>)new i1(w0));
        }
    }
    
    private static final class a
    {
        private final Timeline.Period a;
        private ImmutableList<MediaSource.MediaPeriodId> b;
        private ImmutableMap<MediaSource.MediaPeriodId, Timeline> c;
        private MediaSource.MediaPeriodId d;
        private MediaSource.MediaPeriodId e;
        private MediaSource.MediaPeriodId f;
        
        public a(final Timeline.Period a) {
            this.a = a;
            this.b = (ImmutableList<MediaSource.MediaPeriodId>)ImmutableList.of();
            this.c = (ImmutableMap<MediaSource.MediaPeriodId, Timeline>)ImmutableMap.of();
        }
        
        static ImmutableList a(final a a) {
            return a.b;
        }
        
        private void b(final ImmutableMap$Builder<MediaSource.MediaPeriodId, Timeline> immutableMap$Builder, final MediaSource.MediaPeriodId mediaPeriodId, Timeline timeline) {
            if (mediaPeriodId == null) {
                return;
            }
            if (timeline.f(mediaPeriodId.a) != -1) {
                immutableMap$Builder.d((Object)mediaPeriodId, (Object)timeline);
            }
            else {
                timeline = (Timeline)this.c.get((Object)mediaPeriodId);
                if (timeline != null) {
                    immutableMap$Builder.d((Object)mediaPeriodId, (Object)timeline);
                }
            }
        }
        
        private static MediaSource.MediaPeriodId c(final Player player, final ImmutableList<MediaSource.MediaPeriodId> list, final MediaSource.MediaPeriodId mediaPeriodId, final Timeline.Period period) {
            final Timeline w = player.w();
            final int j = player.J();
            Object q;
            if (w.u()) {
                q = null;
            }
            else {
                q = w.q(j);
            }
            int g;
            if (!player.e() && !w.u()) {
                g = w.j(j, period).g(Util.C0(player.g0()) - period.r());
            }
            else {
                g = -1;
            }
            for (int i = 0; i < ((AbstractCollection)list).size(); ++i) {
                final MediaSource.MediaPeriodId mediaPeriodId2 = ((List<MediaSource.MediaPeriodId>)list).get(i);
                if (i(mediaPeriodId2, q, player.e(), player.s(), player.N(), g)) {
                    return mediaPeriodId2;
                }
            }
            if (((AbstractCollection)list).isEmpty() && mediaPeriodId != null && i(mediaPeriodId, q, player.e(), player.s(), player.N(), g)) {
                return mediaPeriodId;
            }
            return null;
        }
        
        private static boolean i(final MediaSource.MediaPeriodId mediaPeriodId, final Object o, final boolean b, final int n, final int n2, final int n3) {
            final boolean equals = mediaPeriodId.a.equals(o);
            final boolean b2 = false;
            if (!equals) {
                return false;
            }
            if (!b || mediaPeriodId.b != n || mediaPeriodId.c != n2) {
                boolean b3 = b2;
                if (b) {
                    return b3;
                }
                b3 = b2;
                if (mediaPeriodId.b != -1) {
                    return b3;
                }
                b3 = b2;
                if (mediaPeriodId.e != n3) {
                    return b3;
                }
            }
            return true;
        }
        
        private void m(final Timeline timeline) {
            final ImmutableMap$Builder builder = ImmutableMap.builder();
            if (((AbstractCollection)this.b).isEmpty()) {
                this.b((ImmutableMap$Builder<MediaSource.MediaPeriodId, Timeline>)builder, this.e, timeline);
                if (!Objects.a((Object)this.f, (Object)this.e)) {
                    this.b((ImmutableMap$Builder<MediaSource.MediaPeriodId, Timeline>)builder, this.f, timeline);
                }
                if (!Objects.a((Object)this.d, (Object)this.e) && !Objects.a((Object)this.d, (Object)this.f)) {
                    this.b((ImmutableMap$Builder<MediaSource.MediaPeriodId, Timeline>)builder, this.d, timeline);
                }
            }
            else {
                for (int i = 0; i < ((AbstractCollection)this.b).size(); ++i) {
                    this.b((ImmutableMap$Builder<MediaSource.MediaPeriodId, Timeline>)builder, this.b.get(i), timeline);
                }
                if (!this.b.contains((Object)this.d)) {
                    this.b((ImmutableMap$Builder<MediaSource.MediaPeriodId, Timeline>)builder, this.d, timeline);
                }
            }
            this.c = (ImmutableMap<MediaSource.MediaPeriodId, Timeline>)builder.b();
        }
        
        public MediaSource.MediaPeriodId d() {
            return this.d;
        }
        
        public MediaSource.MediaPeriodId e() {
            MediaSource.MediaPeriodId mediaPeriodId;
            if (((AbstractCollection)this.b).isEmpty()) {
                mediaPeriodId = null;
            }
            else {
                mediaPeriodId = (MediaSource.MediaPeriodId)Iterables.h((Iterable)this.b);
            }
            return mediaPeriodId;
        }
        
        public Timeline f(final MediaSource.MediaPeriodId mediaPeriodId) {
            return (Timeline)this.c.get((Object)mediaPeriodId);
        }
        
        public MediaSource.MediaPeriodId g() {
            return this.e;
        }
        
        public MediaSource.MediaPeriodId h() {
            return this.f;
        }
        
        public void j(final Player player) {
            this.d = c(player, this.b, this.e, this.a);
        }
        
        public void k(final List<MediaSource.MediaPeriodId> list, final MediaSource.MediaPeriodId mediaPeriodId, final Player player) {
            this.b = (ImmutableList<MediaSource.MediaPeriodId>)ImmutableList.copyOf((Collection)list);
            if (!list.isEmpty()) {
                this.e = list.get(0);
                this.f = Assertions.e(mediaPeriodId);
            }
            if (this.d == null) {
                this.d = c(player, this.b, this.e, this.a);
            }
            this.m(player.w());
        }
        
        public void l(final Player player) {
            this.d = c(player, this.b, this.e, this.a);
            this.m(player.w());
        }
    }
}
