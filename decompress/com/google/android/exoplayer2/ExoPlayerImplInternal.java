// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.exoplayer2;

import com.google.android.exoplayer2.source.SequenceableLoader;
import com.google.android.exoplayer2.drm.DrmSession;
import com.google.android.exoplayer2.upstream.DataSourceException;
import com.google.android.exoplayer2.source.BehindLiveWindowException;
import android.os.Message;
import com.google.common.collect.ImmutableList$Builder;
import com.google.common.base.Supplier;
import android.os.SystemClock;
import com.google.android.exoplayer2.util.TraceUtil;
import com.google.android.exoplayer2.trackselection.ExoTrackSelection;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.source.ShuffleOrder;
import com.google.android.exoplayer2.source.SampleStream;
import com.google.android.exoplayer2.metadata.MetadataRenderer;
import java.util.Collection;
import com.google.android.exoplayer2.metadata.Metadata;
import com.google.common.collect.ImmutableList;
import com.google.android.exoplayer2.source.TrackGroupArray;
import java.util.concurrent.atomic.AtomicBoolean;
import com.google.android.exoplayer2.text.TextRenderer;
import java.util.List;
import java.util.Collections;
import com.google.android.exoplayer2.util.Log;
import com.google.android.exoplayer2.source.MediaPeriodId;
import java.io.IOException;
import com.google.android.exoplayer2.util.Util;
import com.google.android.exoplayer2.source.MediaSource;
import android.util.Pair;
import android.os.Handler;
import com.google.common.collect.Sets;
import com.google.android.exoplayer2.analytics.PlayerId;
import com.google.android.exoplayer2.analytics.AnalyticsCollector;
import android.os.Looper;
import android.os.HandlerThread;
import com.google.android.exoplayer2.util.HandlerWrapper;
import com.google.android.exoplayer2.upstream.BandwidthMeter;
import com.google.android.exoplayer2.trackselection.TrackSelectorResult;
import java.util.Set;
import com.google.android.exoplayer2.util.Clock;
import java.util.ArrayList;
import com.google.android.exoplayer2.trackselection.TrackSelector;
import com.google.android.exoplayer2.source.MediaPeriod;
import android.os.Handler$Callback;

final class ExoPlayerImplInternal implements Handler$Callback, Callback, InvalidationListener, MediaSourceListInfoRefreshListener, PlaybackParametersListener, Sender
{
    private final ArrayList<d> A;
    private final Clock B;
    private final PlaybackInfoUpdateListener C;
    private final h1 D;
    private final MediaSourceList E;
    private final LivePlaybackSpeedControl F;
    private final long G;
    private SeekParameters H;
    private m1 I;
    private PlaybackInfoUpdate J;
    private boolean K;
    private boolean L;
    private boolean M;
    private boolean N;
    private boolean O;
    private int P;
    private boolean Q;
    private boolean R;
    private boolean S;
    private boolean T;
    private int U;
    private f V;
    private long W;
    private int X;
    private boolean Y;
    private ExoPlaybackException Z;
    private final Renderer[] a;
    private long a0;
    private final Set<Renderer> b;
    private long b0;
    private final RendererCapabilities[] c;
    private final TrackSelector d;
    private final TrackSelectorResult e;
    private final LoadControl f;
    private final BandwidthMeter g;
    private final HandlerWrapper h;
    private final HandlerThread i;
    private final Looper j;
    private final Timeline.Window p;
    private final Timeline.Period w;
    private final long x;
    private final boolean y;
    private final DefaultMediaClock z;
    
    public ExoPlayerImplInternal(final Renderer[] a, final TrackSelector d, final TrackSelectorResult e, final LoadControl f, final BandwidthMeter g, int i, final boolean q, final AnalyticsCollector analyticsCollector, final SeekParameters h, final LivePlaybackSpeedControl f2, final long n, final boolean l, final Looper looper, final Clock b, final PlaybackInfoUpdateListener c, final PlayerId playerId) {
        this.C = c;
        this.a = a;
        this.d = d;
        this.e = e;
        this.f = f;
        this.g = g;
        this.P = i;
        this.Q = q;
        this.H = h;
        this.F = f2;
        this.G = n;
        this.a0 = n;
        this.L = l;
        this.B = b;
        this.b0 = -9223372036854775807L;
        this.x = f.d();
        this.y = f.c();
        final m1 j = m1.j(e);
        this.I = j;
        this.J = new PlaybackInfoUpdate(j);
        this.c = new RendererCapabilities[a.length];
        for (i = 0; i < a.length; ++i) {
            a[i].l(i, playerId);
            this.c[i] = a[i].u();
        }
        this.z = new DefaultMediaClock((DefaultMediaClock.PlaybackParametersListener)this, b);
        this.A = new ArrayList<d>();
        this.b = Sets.h();
        this.p = new Timeline.Window();
        this.w = new Timeline.Period();
        d.c((TrackSelector.InvalidationListener)this, g);
        this.Y = true;
        final Handler handler = new Handler(looper);
        this.D = new h1(analyticsCollector, handler);
        this.E = new MediaSourceList((MediaSourceList.MediaSourceListInfoRefreshListener)this, analyticsCollector, handler, playerId);
        final HandlerThread k = new HandlerThread("ExoPlayer:Playback", -16);
        (this.i = k).start();
        final Looper looper2 = k.getLooper();
        this.j = looper2;
        this.h = b.e(looper2, (Handler$Callback)this);
    }
    
    private Pair<MediaSource.MediaPeriodId, Long> A(final Timeline timeline) {
        final boolean u = timeline.u();
        final long n = 0L;
        if (u) {
            return (Pair<MediaSource.MediaPeriodId, Long>)Pair.create((Object)m1.k(), (Object)0L);
        }
        final Pair<Object, Long> n2 = timeline.n(this.p, this.w, timeline.e(this.Q), -9223372036854775807L);
        final MediaSource.MediaPeriodId b = this.D.B(timeline, n2.first, 0L);
        long n3 = (long)n2.second;
        if (b.b()) {
            timeline.l(b.a, this.w);
            n3 = n;
            if (b.c == this.w.o(b.b)) {
                n3 = this.w.j();
            }
        }
        return (Pair<MediaSource.MediaPeriodId, Long>)Pair.create((Object)b, (Object)n3);
    }
    
    private void B0(final boolean b) throws ExoPlaybackException {
        final MediaSource.MediaPeriodId a = this.D.p().f.a;
        final long e0 = this.E0(a, this.I.r, true, false);
        if (e0 != this.I.r) {
            final m1 i = this.I;
            this.I = this.L(a, e0, i.c, i.d, b, 5);
        }
    }
    
    private long C() {
        return this.D(this.I.p);
    }
    
    private void C0(final f v) throws ExoPlaybackException {
        final PlaybackInfoUpdate j = this.J;
        int n = 1;
        j.b(1);
        final Pair<Object, Long> x0 = x0(this.I.a, v, true, this.P, this.Q, this.p, this.w);
        MediaSource.MediaPeriodId b = null;
        int n3 = 0;
        long n5 = 0L;
        long n6 = 0L;
        Label_0278: {
            long n2;
            long n4;
            if (x0 == null) {
                final Pair<MediaSource.MediaPeriodId, Long> a = this.A(this.I.a);
                b = (MediaSource.MediaPeriodId)a.first;
                n2 = (long)a.second;
                n3 = ((this.I.a.u() ^ true) ? 1 : 0);
                n4 = -9223372036854775807L;
            }
            else {
                final Object first = x0.first;
                n2 = (long)x0.second;
                if (v.c == -9223372036854775807L) {
                    n4 = -9223372036854775807L;
                }
                else {
                    n4 = n2;
                }
                b = this.D.B(this.I.a, first, n2);
                if (b.b()) {
                    this.I.a.l(b.a, this.w);
                    if (this.w.o(b.b) == b.c) {
                        n2 = this.w.j();
                    }
                    else {
                        n2 = 0L;
                    }
                    n5 = n4;
                    n3 = 1;
                    n6 = n2;
                    break Label_0278;
                }
                if (v.c == -9223372036854775807L) {
                    n3 = 1;
                }
                else {
                    n3 = 0;
                }
            }
            n5 = n4;
            n6 = n2;
            try {
                Label_0555: {
                    Label_0518: {
                        Label_0328: {
                            if (this.I.a.u()) {
                                this.V = v;
                                break Label_0328;
                            }
                            if (x0 == null) {
                                if (this.I.e != 1) {
                                    this.Z0(4);
                                }
                                this.q0(false, true, false, true);
                                break Label_0328;
                            }
                            long n7 = 0L;
                            Label_0473: {
                                if (b.equals(this.I.b)) {
                                    final e1 p = this.D.p();
                                    long c;
                                    if (p != null && p.d && n6 != 0L) {
                                        c = p.a.c(n6, this.H);
                                    }
                                    else {
                                        c = n6;
                                    }
                                    n7 = c;
                                    if (Util.f1(c) == Util.f1(this.I.r)) {
                                        final m1 i = this.I;
                                        final int e = i.e;
                                        if (e != 2) {
                                            n7 = c;
                                            if (e != 3) {
                                                break Label_0473;
                                            }
                                        }
                                        final long r = i.r;
                                        this.I = this.L(b, r, n5, r, (boolean)(n3 != 0), 2);
                                        return;
                                    }
                                }
                                else {
                                    n7 = n6;
                                }
                            }
                            n2 = this.D0(b, n7, this.I.e == 4);
                            if (n6 != n2) {
                                break Label_0518;
                            }
                            n = 0;
                            break Label_0518;
                        }
                        break Label_0555;
                    }
                    n3 |= n;
                    try {
                        final m1 k = this.I;
                        final Timeline a2 = k.a;
                        this.n1(a2, b, a2, k.b, n5);
                        n6 = n2;
                        this.I = this.L(b, n6, n5, n6, (boolean)(n3 != 0), 2);
                        return;
                    }
                    finally {
                        n6 = n2;
                    }
                }
            }
            finally {}
        }
        this.I = this.L(b, n6, n5, n6, (boolean)(n3 != 0), 2);
    }
    
    private long D(final long n) {
        final e1 j = this.D.j();
        if (j == null) {
            return 0L;
        }
        return Math.max(0L, n - j.y(this.W));
    }
    
    private long D0(final MediaSource.MediaPeriodId mediaPeriodId, final long n, final boolean b) throws ExoPlaybackException {
        return this.E0(mediaPeriodId, n, this.D.p() != this.D.q(), b);
    }
    
    private void E(final MediaPeriod mediaPeriod) {
        if (!this.D.v(mediaPeriod)) {
            return;
        }
        this.D.y(this.W);
        this.V();
    }
    
    private long E0(final MediaSource.MediaPeriodId mediaPeriodId, long n, final boolean b, final boolean b2) throws ExoPlaybackException {
        this.i1();
        this.N = false;
        if (b2 || this.I.e == 3) {
            this.Z0(2);
        }
        e1 e2;
        e1 e1;
        for (e1 = (e2 = this.D.p()); e2 != null && !mediaPeriodId.equals(e2.f.a); e2 = e2.j()) {}
        if (b || e1 != e2 || (e2 != null && e2.z(n) < 0L)) {
            final Renderer[] a = this.a;
            for (int length = a.length, i = 0; i < length; ++i) {
                this.n(a[i]);
            }
            if (e2 != null) {
                while (this.D.p() != e2) {
                    this.D.b();
                }
                this.D.z(e2);
                e2.x(1000000000000L);
                this.r();
            }
        }
        if (e2 != null) {
            this.D.z(e2);
            long h;
            if (!e2.d) {
                e2.f = e2.f.b(n);
                h = n;
            }
            else {
                h = n;
                if (e2.e) {
                    h = e2.a.h(n);
                    e2.a.q(h - this.x, this.y);
                }
            }
            this.s0(h);
            this.V();
            n = h;
        }
        else {
            this.D.f();
            this.s0(n);
        }
        this.G(false);
        this.h.i(2);
        return n;
    }
    
    private void F(final IOException ex, final int n) {
        final ExoPlaybackException forSource = ExoPlaybackException.createForSource(ex, n);
        final e1 p2 = this.D.p();
        ExoPlaybackException copyWithMediaPeriodId = forSource;
        if (p2 != null) {
            copyWithMediaPeriodId = forSource.copyWithMediaPeriodId(p2.f.a);
        }
        Log.d("ExoPlayerImplInternal", "Playback error", copyWithMediaPeriodId);
        this.h1(false, false);
        this.I = this.I.e(copyWithMediaPeriodId);
    }
    
    private void F0(final PlayerMessage playerMessage) throws ExoPlaybackException {
        if (playerMessage.f() == -9223372036854775807L) {
            this.G0(playerMessage);
        }
        else if (this.I.a.u()) {
            this.A.add(new d(playerMessage));
        }
        else {
            final d d = new d(playerMessage);
            final Timeline a = this.I.a;
            if (u0(d, a, a, this.P, this.Q, this.p, this.w)) {
                this.A.add(d);
                Collections.sort(this.A);
            }
            else {
                playerMessage.k(false);
            }
        }
    }
    
    private void G(final boolean b) {
        final e1 j = this.D.j();
        MediaSource.MediaPeriodId mediaPeriodId;
        if (j == null) {
            mediaPeriodId = this.I.b;
        }
        else {
            mediaPeriodId = j.f.a;
        }
        final boolean b2 = this.I.k.equals(mediaPeriodId) ^ true;
        if (b2) {
            this.I = this.I.b(mediaPeriodId);
        }
        final m1 i = this.I;
        long p;
        if (j == null) {
            p = i.r;
        }
        else {
            p = j.i();
        }
        i.p = p;
        this.I.q = this.C();
        if ((b2 || b) && j != null && j.d) {
            this.k1(j.n(), j.o());
        }
    }
    
    private void G0(final PlayerMessage playerMessage) throws ExoPlaybackException {
        if (playerMessage.c() == this.j) {
            this.k(playerMessage);
            final int e = this.I.e;
            if (e == 3 || e == 2) {
                this.h.i(2);
            }
        }
        else {
            this.h.e(15, playerMessage).a();
        }
    }
    
    private void H(final Timeline timeline, boolean n) throws ExoPlaybackException {
        Object o = w0(timeline, this.I, this.V, this.D, this.P, this.Q, this.p, this.w);
        final MediaSource.MediaPeriodId a = ((e)o).a;
        final long c = ((e)o).c;
        final boolean d = ((e)o).d;
        long n2 = ((e)o).b;
        final boolean b = !this.I.b.equals(a) || n2 != this.I.r;
        int n3 = 3;
        final long n4 = -9223372036854775807L;
        try {
            if (((e)o).e) {
                if (this.I.e != 1) {
                    this.Z0(4);
                }
                this.q0(false, false, false, true);
            }
            Label_0196: {
                if (b) {
                    break Label_0196;
                }
                final h1 d2 = this.D;
            Label_0216_Outer:
                while (true) {
                    long w;
                    long z;
                    long d3;
                    try {
                        w = this.W;
                        z = this.z();
                        d3 = n2;
                        final h1 h1 = d2;
                        final Timeline timeline2 = timeline;
                        final long n5 = w;
                        final long n6 = z;
                        final boolean b2 = h1.F(timeline2, n5, n6);
                        if (!b2) {
                            final ExoPlayerImplInternal exoPlayerImplInternal = this;
                            final boolean b3 = false;
                            exoPlayerImplInternal.B0(b3);
                            d3 = n2;
                            break Label_0282;
                        }
                        break Label_0282;
                    }
                    finally {}
                    try {
                        final h1 h1 = d2;
                        final Timeline timeline2 = timeline;
                        final long n5 = w;
                        final long n6 = z;
                        final boolean b2 = h1.F(timeline2, n5, n6);
                        if (!b2) {
                            final ExoPlayerImplInternal exoPlayerImplInternal = this;
                            final boolean b3 = false;
                            exoPlayerImplInternal.B0(b3);
                            d3 = n2;
                        }
                        final m1 i = this.I;
                        final Timeline a2 = i.a;
                        final MediaSource.MediaPeriodId b4 = i.b;
                        if (((e)o).f) {
                            n2 = d3;
                        }
                        else {
                            n2 = -9223372036854775807L;
                        }
                        this.n1(timeline, a, a2, b4, n2);
                        if (b || c != this.I.c) {
                            o = this.I;
                            final Object a3 = ((m1)o).b.a;
                            o = ((m1)o).a;
                            if (b && n != 0 && !((Timeline)o).u() && !((Timeline)o).l(a3, this.w).f) {
                                n = 1;
                            }
                            else {
                                n = 0;
                            }
                            n2 = this.I.d;
                            if (timeline.f(a3) == -1) {
                                n3 = 4;
                            }
                            this.I = this.L(a, d3, c, n2, (boolean)(n != 0), n3);
                        }
                        this.r0();
                        this.v0(timeline, this.I.a);
                        this.I = this.I.i(timeline);
                        if (!timeline.u()) {
                            this.V = null;
                        }
                        this.G(false);
                        return;
                        e1 e1 = null;
                        Label_0260: {
                            e1 = e1.j();
                        }
                    Block_25:
                        while (true) {
                            break Label_0216;
                            Label_0270:
                            d3 = this.D0(a, n2, d);
                            continue Label_0216_Outer;
                            iftrue(Label_0270:)(e1 == null);
                            break Block_25;
                            d3 = n2;
                            iftrue(Label_0282:)(timeline.u());
                            e1 = this.D.p();
                            continue;
                        }
                        iftrue(Label_0260:)(!e1.f.a.equals(a));
                        e1.f = this.D.r(timeline, e1.f);
                        e1.A();
                    }
                    finally {}
                    break;
                }
            }
        }
        finally {}
        final m1 j = this.I;
        final Timeline a4 = j.a;
        final MediaSource.MediaPeriodId b5 = j.b;
        long n7 = n4;
        if (((e)o).f) {
            n7 = n2;
        }
        this.n1(timeline, a, a4, b5, n7);
        if (b || c != this.I.c) {
            final m1 k = this.I;
            final Object a5 = k.b.a;
            final Timeline a6 = k.a;
            final boolean b6 = b && n != 0 && !a6.u() && !a6.l(a5, this.w).f;
            final long d4 = this.I.d;
            if (timeline.f(a5) == -1) {
                n3 = 4;
            }
            this.I = this.L(a, n2, c, d4, b6, n3);
        }
        this.r0();
        this.v0(timeline, this.I.a);
        this.I = this.I.i(timeline);
        if (!timeline.u()) {
            this.V = null;
        }
        this.G(false);
    }
    
    private void H0(final PlayerMessage playerMessage) {
        final Looper c = playerMessage.c();
        if (!c.getThread().isAlive()) {
            Log.i("TAG", "Trying to send message on a dead thread.");
            playerMessage.k(false);
            return;
        }
        this.B.e(c, null).h(new w0(this, playerMessage));
    }
    
    private void I(final MediaPeriod mediaPeriod) throws ExoPlaybackException {
        if (!this.D.v(mediaPeriod)) {
            return;
        }
        final e1 j = this.D.j();
        j.p(this.z.b().a, this.I.a);
        this.k1(j.n(), j.o());
        if (j == this.D.p()) {
            this.s0(j.f.b);
            this.r();
            final m1 i = this.I;
            final MediaSource.MediaPeriodId b = i.b;
            final long b2 = j.f.b;
            this.I = this.L(b, b2, i.c, b2, false, 5);
        }
        this.V();
    }
    
    private void I0(final long n) {
        for (final Renderer renderer : this.a) {
            if (renderer.g() != null) {
                this.J0(renderer, n);
            }
        }
    }
    
    private void J(final PlaybackParameters playbackParameters, final float n, final boolean b, final boolean b2) throws ExoPlaybackException {
        if (b) {
            if (b2) {
                this.J.b(1);
            }
            this.I = this.I.f(playbackParameters);
        }
        this.o1(playbackParameters.a);
        for (final Renderer renderer : this.a) {
            if (renderer != null) {
                renderer.x(n, playbackParameters.a);
            }
        }
    }
    
    private void J0(final Renderer renderer, final long n) {
        renderer.j();
        if (renderer instanceof TextRenderer) {
            ((TextRenderer)renderer).f0(n);
        }
    }
    
    private void K(final PlaybackParameters playbackParameters, final boolean b) throws ExoPlaybackException {
        this.J(playbackParameters, playbackParameters.a, true, b);
    }
    
    private void K0(final boolean r, final AtomicBoolean atomicBoolean) {
        if (this.R != r && !(this.R = r)) {
            for (final Renderer renderer : this.a) {
                if (!Q(renderer) && this.b.remove(renderer)) {
                    renderer.reset();
                }
            }
        }
        if (atomicBoolean != null) {
            synchronized (this) {
                atomicBoolean.set(true);
                this.notifyAll();
            }
        }
    }
    
    private m1 L(final MediaSource.MediaPeriodId mediaPeriodId, final long n, final long n2, final long n3, final boolean b, final int n4) {
        this.Y = (this.Y || n != this.I.r || !mediaPeriodId.equals(this.I.b));
        this.r0();
        final m1 i = this.I;
        TrackGroupArray trackGroupArray = i.h;
        TrackSelectorResult trackSelectorResult = i.i;
        Object o = i.j;
        if (this.E.s()) {
            final e1 p6 = this.D.p();
            if (p6 == null) {
                trackGroupArray = TrackGroupArray.d;
            }
            else {
                trackGroupArray = p6.n();
            }
            if (p6 == null) {
                trackSelectorResult = this.e;
            }
            else {
                trackSelectorResult = p6.o();
            }
            o = this.v(trackSelectorResult.c);
            if (p6 != null) {
                final f1 f = p6.f;
                if (f.c != n2) {
                    p6.f = f.a(n2);
                }
            }
        }
        else if (!mediaPeriodId.equals(this.I.b)) {
            trackGroupArray = TrackGroupArray.d;
            trackSelectorResult = this.e;
            o = ImmutableList.of();
        }
        if (b) {
            this.J.e(n4);
        }
        return this.I.c(mediaPeriodId, n, n2, n3, this.C(), trackGroupArray, trackSelectorResult, (List<Metadata>)o);
    }
    
    private void L0(final b b) throws ExoPlaybackException {
        this.J.b(1);
        if (ExoPlayerImplInternal.b.a(b) != -1) {
            this.V = new f(new q1(ExoPlayerImplInternal.b.b(b), ExoPlayerImplInternal.b.c(b)), ExoPlayerImplInternal.b.a(b), ExoPlayerImplInternal.b.d(b));
        }
        this.H(this.E.C(ExoPlayerImplInternal.b.b(b), ExoPlayerImplInternal.b.c(b)), false);
    }
    
    private boolean M(final Renderer renderer, final e1 e1) {
        final e1 j = e1.j();
        return e1.f.f && j.d && (renderer instanceof TextRenderer || renderer instanceof MetadataRenderer || renderer.B() >= j.m());
    }
    
    private boolean N() {
        final e1 q = this.D.q();
        if (!q.d) {
            return false;
        }
        int n = 0;
        while (true) {
            final Renderer[] a = this.a;
            if (n >= a.length) {
                return true;
            }
            final Renderer renderer = a[n];
            final SampleStream sampleStream = q.c[n];
            if (renderer.g() != sampleStream || (sampleStream != null && !renderer.h() && !this.M(renderer, q))) {
                return false;
            }
            ++n;
        }
    }
    
    private void N0(final boolean t) {
        if (t == this.T) {
            return;
        }
        this.T = t;
        if (!t && this.I.o) {
            this.h.i(2);
        }
    }
    
    private static boolean O(final boolean b, final MediaSource.MediaPeriodId mediaPeriodId, final long n, final MediaSource.MediaPeriodId mediaPeriodId2, final Timeline.Period period, final long n2) {
        final boolean b2 = false;
        final boolean b3 = false;
        boolean b4 = b2;
        if (!b) {
            b4 = b2;
            if (n == n2) {
                if (!mediaPeriodId.a.equals(mediaPeriodId2.a)) {
                    b4 = b2;
                }
                else {
                    if (mediaPeriodId.b() && period.u(mediaPeriodId.b)) {
                        boolean b5 = b3;
                        if (period.k(mediaPeriodId.b, mediaPeriodId.c) != 4) {
                            b5 = b3;
                            if (period.k(mediaPeriodId.b, mediaPeriodId.c) != 2) {
                                b5 = true;
                            }
                        }
                        return b5;
                    }
                    b4 = b2;
                    if (mediaPeriodId2.b()) {
                        b4 = b2;
                        if (period.u(mediaPeriodId2.b)) {
                            b4 = true;
                        }
                    }
                }
            }
        }
        return b4;
    }
    
    private void O0(final boolean l) throws ExoPlaybackException {
        this.L = l;
        this.r0();
        if (this.M && this.D.q() != this.D.p()) {
            this.B0(true);
            this.G(false);
        }
    }
    
    private boolean P() {
        final e1 j = this.D.j();
        return j != null && j.k() != Long.MIN_VALUE;
    }
    
    private static boolean Q(final Renderer renderer) {
        return renderer.getState() != 0;
    }
    
    private void Q0(final boolean b, int e, final boolean b2, final int n) throws ExoPlaybackException {
        this.J.b(b2 ? 1 : 0);
        this.J.c(n);
        this.I = this.I.d(b, e);
        this.N = false;
        this.f0(b);
        if (!this.c1()) {
            this.i1();
            this.m1();
        }
        else {
            e = this.I.e;
            if (e == 3) {
                this.f1();
                this.h.i(2);
            }
            else if (e == 2) {
                this.h.i(2);
            }
        }
    }
    
    private boolean R() {
        final e1 p = this.D.p();
        final long e = p.f.e;
        return p.d && (e == -9223372036854775807L || this.I.r < e || !this.c1());
    }
    
    private static boolean S(final m1 m1, final Timeline.Period period) {
        final MediaSource.MediaPeriodId b = m1.b;
        final Timeline a = m1.a;
        return a.u() || a.l(b.a, period).f;
    }
    
    private void S0(final PlaybackParameters playbackParameters) throws ExoPlaybackException {
        this.z.d(playbackParameters);
        this.K(this.z.b(), true);
    }
    
    private Boolean T() {
        return this.K;
    }
    
    private void U(final PlayerMessage playerMessage) {
        try {
            this.k(playerMessage);
        }
        catch (final ExoPlaybackException ex) {
            Log.d("ExoPlayerImplInternal", "Unexpected error delivering message on external thread.", ex);
            throw new RuntimeException(ex);
        }
    }
    
    private void U0(final int p) throws ExoPlaybackException {
        this.P = p;
        if (!this.D.G(this.I.a, p)) {
            this.B0(true);
        }
        this.G(false);
    }
    
    private void V() {
        final boolean b1 = this.b1();
        this.O = b1;
        if (b1) {
            this.D.j().d(this.W);
        }
        this.j1();
    }
    
    private void V0(final SeekParameters h) {
        this.H = h;
    }
    
    private void W() {
        this.J.d(this.I);
        if (PlaybackInfoUpdate.a(this.J)) {
            this.C.a(this.J);
            this.J = new PlaybackInfoUpdate(this.I);
        }
    }
    
    private void X(long c, final long n) throws ExoPlaybackException {
        if (!this.A.isEmpty()) {
            if (!this.I.b.b()) {
                long n2 = c;
                if (this.Y) {
                    n2 = c - 1L;
                    this.Y = false;
                }
                final m1 i = this.I;
                final int f = i.a.f(i.b.a);
                int min;
                final int n3 = min = Math.min(this.X, this.A.size());
                c = n2;
            Label_0251_Outer:
                while (true) {
                    Label_0121: {
                        if (n3 <= 0) {
                            break Label_0121;
                        }
                        d d = this.A.get(n3 - 1);
                        min = n3;
                        while (d != null) {
                            final int b = d.b;
                            if (b <= f && (b != f || d.c <= n2)) {
                                break;
                            }
                            final int n4 = --min;
                            c = n2;
                            if (n4 <= 0) {
                                break Label_0121;
                            }
                            d = this.A.get(n4 - 1);
                            min = n4;
                        }
                        int n5 = min;
                        c = n2;
                        while (true) {
                            Label_0241: {
                                if (min >= this.A.size()) {
                                    break Label_0241;
                                }
                                d d2 = this.A.get(min);
                                int x;
                                d d3;
                                while (true) {
                                    x = min;
                                    d3 = d2;
                                    if (d2 == null) {
                                        break;
                                    }
                                    x = min;
                                    d3 = d2;
                                    if (d2.d == null) {
                                        break;
                                    }
                                    final int b2 = d2.b;
                                    if (b2 >= f) {
                                        x = min;
                                        d3 = d2;
                                        if (b2 != f) {
                                            break;
                                        }
                                        x = min;
                                        d3 = d2;
                                        if (d2.c > n2) {
                                            break;
                                        }
                                    }
                                    n5 = ++min;
                                    c = n2;
                                    if (min >= this.A.size()) {
                                        break Label_0241;
                                    }
                                    d2 = this.A.get(min);
                                }
                                while (d3 != null && d3.d != null && d3.b == f) {
                                    c = d3.c;
                                    if (c > n2 && c <= n) {
                                        try {
                                            this.G0(d3.a);
                                            if (!d3.a.b() && !d3.a.j()) {
                                                ++x;
                                            }
                                            else {
                                                this.A.remove(x);
                                            }
                                            if (x < this.A.size()) {
                                                d3 = this.A.get(x);
                                                continue Label_0251_Outer;
                                            }
                                            d3 = null;
                                            continue Label_0251_Outer;
                                        }
                                        finally {
                                            if (d3.a.b() || d3.a.j()) {
                                                this.A.remove(x);
                                            }
                                        }
                                        break;
                                    }
                                    break;
                                }
                                this.X = x;
                                return;
                            }
                            d d2 = null;
                            n2 = c;
                            min = n5;
                            continue;
                        }
                    }
                    d d = null;
                    n2 = c;
                    continue;
                }
            }
        }
    }
    
    private void X0(final boolean q) throws ExoPlaybackException {
        this.Q = q;
        if (!this.D.H(this.I.a, q)) {
            this.B0(true);
        }
        this.G(false);
    }
    
    private void Y() throws ExoPlaybackException {
        this.D.y(this.W);
        if (this.D.D()) {
            final f1 o = this.D.o(this.W, this.I);
            if (o != null) {
                final e1 g = this.D.g(this.c, this.d, this.f.g(), this.E, o, this.e);
                g.a.j((MediaPeriod.Callback)this, o.b);
                if (this.D.p() == g) {
                    this.s0(o.b);
                }
                this.G(false);
            }
        }
        if (this.O) {
            this.O = this.P();
            this.j1();
        }
        else {
            this.V();
        }
    }
    
    private void Y0(final ShuffleOrder shuffleOrder) throws ExoPlaybackException {
        this.J.b(1);
        this.H(this.E.D(shuffleOrder), false);
    }
    
    private void Z() throws ExoPlaybackException {
        int n = 0;
        while (this.a1()) {
            if (n != 0) {
                this.W();
            }
            final e1 e1 = Assertions.e(this.D.b());
            boolean b2 = false;
            Label_0116: {
                if (this.I.b.a.equals(e1.f.a.a)) {
                    final MediaSource.MediaPeriodId b = this.I.b;
                    if (b.b == -1) {
                        final MediaSource.MediaPeriodId a = e1.f.a;
                        if (a.b == -1 && b.e != a.e) {
                            b2 = true;
                            break Label_0116;
                        }
                    }
                }
                b2 = false;
            }
            final f1 f = e1.f;
            final MediaSource.MediaPeriodId a2 = f.a;
            final long b3 = f.b;
            this.I = this.L(a2, b3, f.c, b3, b2 ^ true, 0);
            this.r0();
            this.m1();
            n = 1;
        }
    }
    
    private void Z0(final int n) {
        final m1 i = this.I;
        if (i.e != n) {
            if (n != 2) {
                this.b0 = -9223372036854775807L;
            }
            this.I = i.g(n);
        }
    }
    
    private void a0() {
        final e1 q = this.D.q();
        if (q == null) {
            return;
        }
        final e1 j = q.j();
        final int n = 0;
        if (j == null || this.M) {
            int n2 = n;
            if (!q.f.i) {
                if (!this.M) {
                    return;
                }
                n2 = n;
            }
            while (true) {
                final Renderer[] a = this.a;
                if (n2 >= a.length) {
                    break;
                }
                final Renderer renderer = a[n2];
                final SampleStream sampleStream = q.c[n2];
                if (sampleStream != null && renderer.g() == sampleStream && renderer.h()) {
                    final long e = q.f.e;
                    long n3;
                    if (e != -9223372036854775807L && e != Long.MIN_VALUE) {
                        n3 = q.l() + q.f.e;
                    }
                    else {
                        n3 = -9223372036854775807L;
                    }
                    this.J0(renderer, n3);
                }
                ++n2;
            }
            return;
        }
        if (!this.N()) {
            return;
        }
        if (!q.j().d && this.W < q.j().m()) {
            return;
        }
        final TrackSelectorResult o = q.o();
        final e1 c = this.D.c();
        final TrackSelectorResult o2 = c.o();
        final Timeline a2 = this.I.a;
        this.n1(a2, c.f.a, a2, q.f.a, -9223372036854775807L);
        if (c.d && c.a.i() != -9223372036854775807L) {
            this.I0(c.m());
            return;
        }
        for (int i = 0; i < this.a.length; ++i) {
            final boolean c2 = o.c(i);
            final boolean c3 = o2.c(i);
            if (c2 && !this.a[i].r()) {
                final boolean b = this.c[i].f() == -2;
                final RendererConfiguration rendererConfiguration = o.b[i];
                final RendererConfiguration rendererConfiguration2 = o2.b[i];
                if (!c3 || !rendererConfiguration2.equals(rendererConfiguration) || b) {
                    this.J0(this.a[i], c.m());
                }
            }
        }
    }
    
    private boolean a1() {
        final boolean c1 = this.c1();
        final boolean b = false;
        if (!c1) {
            return false;
        }
        if (this.M) {
            return false;
        }
        final e1 p = this.D.p();
        if (p == null) {
            return false;
        }
        final e1 j = p.j();
        boolean b2 = b;
        if (j != null) {
            b2 = b;
            if (this.W >= j.m()) {
                b2 = b;
                if (j.g) {
                    b2 = true;
                }
            }
        }
        return b2;
    }
    
    private void b0() throws ExoPlaybackException {
        final e1 q = this.D.q();
        if (q != null && this.D.p() != q) {
            if (!q.g) {
                if (this.o0()) {
                    this.r();
                }
            }
        }
    }
    
    private boolean b1() {
        if (!this.P()) {
            return false;
        }
        final e1 j = this.D.j();
        final long d = this.D(j.k());
        long y;
        if (j == this.D.p()) {
            y = j.y(this.W);
        }
        else {
            y = j.y(this.W) - j.f.b;
        }
        return this.f.i(y, d, this.z.b().a);
    }
    
    private void c0() throws ExoPlaybackException {
        this.H(this.E.i(), true);
    }
    
    private boolean c1() {
        final m1 i = this.I;
        return i.l && i.m == 0;
    }
    
    public static Boolean d(final ExoPlayerImplInternal exoPlayerImplInternal) {
        return exoPlayerImplInternal.T();
    }
    
    private void d0(final c c) throws ExoPlaybackException {
        this.J.b(1);
        this.H(this.E.v(c.a, c.b, c.c, c.d), false);
    }
    
    private boolean d1(final boolean b) {
        if (this.U == 0) {
            return this.R();
        }
        final boolean b2 = false;
        if (!b) {
            return false;
        }
        final m1 i = this.I;
        if (!i.g) {
            return true;
        }
        long c;
        if (this.e1(i.a, this.D.p().f.a)) {
            c = this.F.c();
        }
        else {
            c = -9223372036854775807L;
        }
        final e1 j = this.D.j();
        final boolean b3 = j.q() && j.f.i;
        final boolean b4 = j.f.a.b() && !j.d;
        if (!b3 && !b4) {
            final boolean b5 = b2;
            if (!this.f.f(this.C(), this.z.b().a, this.N, c)) {
                return b5;
            }
        }
        return true;
    }
    
    public static void e(final ExoPlayerImplInternal exoPlayerImplInternal, final PlayerMessage playerMessage) {
        exoPlayerImplInternal.U(playerMessage);
    }
    
    private void e0() {
        for (e1 e1 = this.D.p(); e1 != null; e1 = e1.j()) {
            for (final ExoTrackSelection exoTrackSelection : e1.o().c) {
                if (exoTrackSelection != null) {
                    exoTrackSelection.j();
                }
            }
        }
    }
    
    private boolean e1(final Timeline timeline, final MediaSource.MediaPeriodId mediaPeriodId) {
        final boolean b = mediaPeriodId.b();
        boolean b3;
        final boolean b2 = b3 = false;
        if (!b) {
            if (timeline.u()) {
                b3 = b2;
            }
            else {
                timeline.r(timeline.l(mediaPeriodId.a, this.w).c, this.p);
                b3 = b2;
                if (this.p.i()) {
                    final Timeline.Window p2 = this.p;
                    b3 = b2;
                    if (p2.i) {
                        b3 = b2;
                        if (p2.f != -9223372036854775807L) {
                            b3 = true;
                        }
                    }
                }
            }
        }
        return b3;
    }
    
    static boolean f(final ExoPlayerImplInternal exoPlayerImplInternal, final boolean s) {
        return exoPlayerImplInternal.S = s;
    }
    
    private void f0(final boolean b) {
        for (e1 e1 = this.D.p(); e1 != null; e1 = e1.j()) {
            for (final ExoTrackSelection exoTrackSelection : e1.o().c) {
                if (exoTrackSelection != null) {
                    exoTrackSelection.m(b);
                }
            }
        }
    }
    
    private void f1() throws ExoPlaybackException {
        int i = 0;
        this.N = false;
        this.z.g();
        for (Renderer[] a = this.a; i < a.length; ++i) {
            final Renderer renderer = a[i];
            if (Q(renderer)) {
                renderer.start();
            }
        }
    }
    
    static HandlerWrapper g(final ExoPlayerImplInternal exoPlayerImplInternal) {
        return exoPlayerImplInternal.h;
    }
    
    private void g0() {
        for (e1 e1 = this.D.p(); e1 != null; e1 = e1.j()) {
            for (final ExoTrackSelection exoTrackSelection : e1.o().c) {
                if (exoTrackSelection != null) {
                    exoTrackSelection.u();
                }
            }
        }
    }
    
    private void h(final b b, final int n) throws ExoPlaybackException {
        this.J.b(1);
        final MediaSourceList e = this.E;
        int q = n;
        if (n == -1) {
            q = e.q();
        }
        this.H(e.f(q, ExoPlayerImplInternal.b.b(b), ExoPlayerImplInternal.b.c(b)), false);
    }
    
    private void h1(final boolean b, final boolean b2) {
        this.q0(b || !this.R, false, true, false);
        this.J.b(b2 ? 1 : 0);
        this.f.b();
        this.Z0(1);
    }
    
    private void i1() throws ExoPlaybackException {
        this.z.h();
        for (final Renderer renderer : this.a) {
            if (Q(renderer)) {
                this.t(renderer);
            }
        }
    }
    
    private void j() throws ExoPlaybackException {
        this.B0(true);
    }
    
    private void j0() {
        this.J.b(1);
        this.q0(false, false, false, true);
        this.f.onPrepared();
        int n;
        if (this.I.a.u()) {
            n = 4;
        }
        else {
            n = 2;
        }
        this.Z0(n);
        this.E.w(this.g.c());
        this.h.i(2);
    }
    
    private void j1() {
        final e1 j = this.D.j();
        final boolean b = this.O || (j != null && j.a.isLoading());
        final m1 i = this.I;
        if (b != i.g) {
            this.I = i.a(b);
        }
    }
    
    private void k(final PlayerMessage playerMessage) throws ExoPlaybackException {
        if (playerMessage.j()) {
            return;
        }
        try {
            playerMessage.g().p(playerMessage.i(), playerMessage.e());
        }
        finally {
            playerMessage.k(true);
        }
    }
    
    private void k1(final TrackGroupArray trackGroupArray, final TrackSelectorResult trackSelectorResult) {
        this.f.e(this.a, trackGroupArray, trackSelectorResult.c);
    }
    
    private void l0() {
        this.q0(true, false, true, false);
        this.f.h();
        this.Z0(1);
        this.i.quit();
        synchronized (this) {
            this.K = true;
            this.notifyAll();
        }
    }
    
    private void l1() throws ExoPlaybackException, IOException {
        if (!this.I.a.u()) {
            if (this.E.s()) {
                this.Y();
                this.a0();
                this.b0();
                this.Z();
            }
        }
    }
    
    private void m0(final int n, final int n2, final ShuffleOrder shuffleOrder) throws ExoPlaybackException {
        this.J.b(1);
        this.H(this.E.A(n, n2, shuffleOrder), false);
    }
    
    private void m1() throws ExoPlaybackException {
        final e1 p = this.D.p();
        if (p == null) {
            return;
        }
        long i;
        if (p.d) {
            i = p.a.i();
        }
        else {
            i = -9223372036854775807L;
        }
        if (i != -9223372036854775807L) {
            this.s0(i);
            if (i != this.I.r) {
                final m1 j = this.I;
                this.I = this.L(j.b, i, j.c, i, true, 5);
            }
        }
        else {
            final long k = this.z.i(p != this.D.q());
            this.W = k;
            final long y = p.y(k);
            this.X(this.I.r, y);
            this.I.r = y;
        }
        this.I.p = this.D.j().i();
        this.I.q = this.C();
        final m1 l = this.I;
        if (l.l && l.e == 3 && this.e1(l.a, l.b) && this.I.n.a == 1.0f) {
            final float b = this.F.b(this.w(), this.C());
            if (this.z.b().a != b) {
                this.z.d(this.I.n.e(b));
                this.J(this.I.n, this.z.b().a, false, false);
            }
        }
    }
    
    private void n(final Renderer renderer) throws ExoPlaybackException {
        if (!Q(renderer)) {
            return;
        }
        this.z.a(renderer);
        this.t(renderer);
        renderer.e();
        --this.U;
    }
    
    private void n1(final Timeline timeline, final MediaSource.MediaPeriodId mediaPeriodId, final Timeline timeline2, final MediaSource.MediaPeriodId mediaPeriodId2, final long n) {
        if (!this.e1(timeline, mediaPeriodId)) {
            PlaybackParameters playbackParameters;
            if (mediaPeriodId.b()) {
                playbackParameters = PlaybackParameters.d;
            }
            else {
                playbackParameters = this.I.n;
            }
            if (!this.z.b().equals(playbackParameters)) {
                this.z.d(playbackParameters);
            }
            return;
        }
        timeline.r(timeline.l(mediaPeriodId.a, this.w).c, this.p);
        this.F.a(Util.j(this.p.p));
        if (n != -9223372036854775807L) {
            this.F.e(this.y(timeline, mediaPeriodId.a, n));
        }
        else {
            final Object a = this.p.a;
            Object a2 = null;
            if (!timeline2.u()) {
                a2 = timeline2.r(timeline2.l(mediaPeriodId2.a, this.w).c, this.p).a;
            }
            if (!Util.c(a2, a)) {
                this.F.e(-9223372036854775807L);
            }
        }
    }
    
    private boolean o0() throws ExoPlaybackException {
        final e1 q = this.D.q();
        final TrackSelectorResult o = q.o();
        int n = 0;
        boolean b = false;
        while (true) {
            final Renderer[] a = this.a;
            if (n >= a.length) {
                break;
            }
            final Renderer renderer = a[n];
            if (Q(renderer)) {
                final boolean b2 = renderer.g() != q.c[n];
                if (!o.c(n) || b2) {
                    if (!renderer.r()) {
                        renderer.s(x(o.c[n]), q.c[n], q.m(), q.l());
                    }
                    else if (renderer.c()) {
                        this.n(renderer);
                    }
                    else {
                        b = true;
                    }
                }
            }
            ++n;
        }
        return b ^ true;
    }
    
    private void o1(final float n) {
        for (e1 e1 = this.D.p(); e1 != null; e1 = e1.j()) {
            for (final ExoTrackSelection exoTrackSelection : e1.o().c) {
                if (exoTrackSelection != null) {
                    exoTrackSelection.h(n);
                }
            }
        }
    }
    
    private void p() throws ExoPlaybackException, IOException {
        final long d = this.B.d();
        this.h.k(2);
        this.l1();
        final int e = this.I.e;
        if (e == 1 || e == 4) {
            return;
        }
        final e1 p = this.D.p();
        if (p == null) {
            this.z0(d, 10L);
            return;
        }
        TraceUtil.a("doSomeWork");
        this.m1();
        int n4;
        int n5;
        if (p.d) {
            final long elapsedRealtime = SystemClock.elapsedRealtime();
            p.a.q(this.I.r - this.x, this.y);
            int n = 1;
            int n2 = 1;
            int n3 = 0;
            while (true) {
                final Renderer[] a = this.a;
                n4 = n;
                n5 = n2;
                if (n3 >= a.length) {
                    break;
                }
                final Renderer renderer = a[n3];
                int n6;
                boolean b;
                if (!Q(renderer)) {
                    n6 = n;
                    b = (n2 != 0);
                }
                else {
                    renderer.A(this.W, elapsedRealtime * 1000L);
                    int n7;
                    if (n != 0 && renderer.c()) {
                        n7 = 1;
                    }
                    else {
                        n7 = 0;
                    }
                    final boolean b2 = p.c[n3] != renderer.g();
                    final boolean b3 = !b2 && renderer.h();
                    final boolean b4 = b2 || b3 || renderer.isReady() || renderer.c();
                    final boolean b5 = n2 && b4;
                    n6 = n7;
                    b = b5;
                    if (!b4) {
                        renderer.q();
                        b = b5;
                        n6 = n7;
                    }
                }
                ++n3;
                n = n6;
                n2 = (b ? 1 : 0);
            }
        }
        else {
            p.a.n();
            n4 = 1;
            n5 = 1;
        }
        final long e2 = p.f.e;
        final boolean b6 = n4 != 0 && p.d && (e2 == -9223372036854775807L || e2 <= this.I.r);
        if (b6 && this.M) {
            this.Q0(this.M = false, this.I.m, false, 5);
        }
        Label_0586: {
            if (b6 && p.f.i) {
                this.Z0(4);
                this.i1();
            }
            else if (this.I.e == 2 && this.d1((boolean)(n5 != 0))) {
                this.Z0(3);
                this.Z = null;
                if (this.c1()) {
                    this.f1();
                }
            }
            else if (this.I.e == 3) {
                if (this.U == 0) {
                    if (this.R()) {
                        break Label_0586;
                    }
                }
                else if (n5 != 0) {
                    break Label_0586;
                }
                this.N = this.c1();
                this.Z0(2);
                if (this.N) {
                    this.g0();
                    this.F.d();
                }
                this.i1();
            }
        }
        boolean b7 = false;
        Label_0700: {
            if (this.I.e == 2) {
                int n8 = 0;
                while (true) {
                    final Renderer[] a2 = this.a;
                    if (n8 >= a2.length) {
                        break;
                    }
                    if (Q(a2[n8]) && this.a[n8].g() == p.c[n8]) {
                        this.a[n8].q();
                    }
                    ++n8;
                }
                final m1 i = this.I;
                if (!i.g && i.q < 500000L && this.P()) {
                    b7 = true;
                    break Label_0700;
                }
            }
            b7 = false;
        }
        if (!b7) {
            this.b0 = -9223372036854775807L;
        }
        else if (this.b0 == -9223372036854775807L) {
            this.b0 = this.B.c();
        }
        else if (this.B.c() - this.b0 >= 4000L) {
            throw new IllegalStateException("Playback stuck buffering and not loading");
        }
        final boolean b8 = this.c1() && this.I.e == 3;
        final boolean b9 = this.T && this.S && b8;
        final m1 j = this.I;
        if (j.o != b9) {
            this.I = j.h(b9);
        }
        this.S = false;
        if (!b9) {
            final int e3 = this.I.e;
            if (e3 != 4) {
                if (!b8 && e3 != 2) {
                    if (e3 == 3 && this.U != 0) {
                        this.z0(d, 1000L);
                    }
                }
                else {
                    this.z0(d, 10L);
                }
                TraceUtil.c();
            }
        }
    }
    
    private void p0() throws ExoPlaybackException {
        final float a = this.z.b().a;
        e1 e1 = this.D.p();
        final e1 q = this.D.q();
        int n = 1;
        while (e1 != null && e1.d) {
            final TrackSelectorResult v = e1.v(a, this.I.a);
            if (!v.a(e1.o())) {
                if (n != 0) {
                    final e1 p = this.D.p();
                    final boolean z = this.D.z(p);
                    final boolean[] array = new boolean[this.a.length];
                    final long b = p.b(v, this.I.r, z, array);
                    final m1 i = this.I;
                    final boolean b2 = i.e != 4 && b != i.r;
                    final m1 j = this.I;
                    this.I = this.L(j.b, b, j.c, j.d, b2, 5);
                    if (b2) {
                        this.s0(b);
                    }
                    final boolean[] array2 = new boolean[this.a.length];
                    int n2 = 0;
                    while (true) {
                        final Renderer[] a2 = this.a;
                        if (n2 >= a2.length) {
                            break;
                        }
                        final Renderer renderer = a2[n2];
                        array2[n2] = Q(renderer);
                        final SampleStream sampleStream = p.c[n2];
                        if (array2[n2]) {
                            if (sampleStream != renderer.g()) {
                                this.n(renderer);
                            }
                            else if (array[n2]) {
                                renderer.C(this.W);
                            }
                        }
                        ++n2;
                    }
                    this.s(array2);
                }
                else {
                    this.D.z(e1);
                    if (e1.d) {
                        e1.a(v, Math.max(e1.f.b, e1.y(this.W)), false);
                    }
                }
                this.G(true);
                if (this.I.e != 4) {
                    this.V();
                    this.m1();
                    this.h.i(2);
                }
                return;
            }
            if (e1 == q) {
                n = 0;
            }
            e1 = e1.j();
        }
    }
    
    private void p1(final Supplier<Boolean> supplier, final long n) {
        synchronized (this) {
            final long c = this.B.c();
            boolean b = false;
            for (long n2 = n; !(boolean)supplier.get() && n2 > 0L; n2 = c + n - this.B.c()) {
                try {
                    this.B.f();
                    this.wait(n2);
                }
                catch (final InterruptedException ex) {
                    b = true;
                }
            }
            if (b) {
                Thread.currentThread().interrupt();
            }
        }
    }
    
    private void q(final int n, final boolean b) throws ExoPlaybackException {
        final Renderer renderer = this.a[n];
        if (Q(renderer)) {
            return;
        }
        final e1 q = this.D.q();
        final boolean b2 = q == this.D.p();
        final TrackSelectorResult o = q.o();
        final RendererConfiguration rendererConfiguration = o.b[n];
        final Format[] x = x(o.c[n]);
        final boolean b3 = this.c1() && this.I.e == 3;
        final boolean b4 = !b && b3;
        ++this.U;
        this.b.add(renderer);
        renderer.y(rendererConfiguration, x, q.c[n], this.W, b4, b2, q.m(), q.l());
        ((PlayerMessage.Target)renderer).p(11, new Renderer.WakeupListener(this) {
            final ExoPlayerImplInternal a;
            
            @Override
            public void a() {
                ExoPlayerImplInternal.f(this.a, true);
            }
            
            @Override
            public void b() {
                ExoPlayerImplInternal.g(this.a).i(2);
            }
        });
        this.z.c(renderer);
        if (b3) {
            renderer.start();
        }
    }
    
    private void q0(final boolean b, final boolean b2, final boolean b3, final boolean b4) {
        this.h.k(2);
        final ExoPlaybackException ex = null;
        this.Z = null;
        this.N = false;
        this.z.h();
        this.W = 1000000000000L;
        for (final Renderer renderer : this.a) {
            Label_0092: {
                try {
                    this.n(renderer);
                    break Label_0092;
                }
                catch (final RuntimeException renderer) {}
                catch (final ExoPlaybackException ex2) {}
                Log.d("ExoPlayerImplInternal", "Disable failed.", (Throwable)renderer);
            }
        }
        if (b) {
            for (final Renderer renderer2 : this.a) {
                if (this.b.remove(renderer2)) {
                    try {
                        renderer2.reset();
                    }
                    catch (final RuntimeException ex3) {
                        Log.d("ExoPlayerImplInternal", "Reset failed.", ex3);
                    }
                }
            }
        }
        this.U = 0;
        final m1 k = this.I;
        MediaSource.MediaPeriodId b5 = k.b;
        long r = k.r;
        long n;
        if (!this.I.b.b() && !S(this.I, this.w)) {
            n = this.I.r;
        }
        else {
            n = this.I.c;
        }
        boolean b6 = false;
        Label_0347: {
            if (b2) {
                this.V = null;
                final Pair<MediaSource.MediaPeriodId, Long> a3 = this.A(this.I.a);
                final MediaSource.MediaPeriodId mediaPeriodId = (MediaSource.MediaPeriodId)a3.first;
                final long longValue = (long)a3.second;
                final long n2 = -9223372036854775807L;
                b5 = mediaPeriodId;
                r = longValue;
                n = n2;
                if (!mediaPeriodId.equals(this.I.b)) {
                    b6 = true;
                    b5 = mediaPeriodId;
                    r = longValue;
                    n = n2;
                    break Label_0347;
                }
            }
            b6 = false;
        }
        this.D.f();
        this.O = false;
        final m1 l = this.I;
        final Timeline a4 = l.a;
        final int e = l.e;
        ExoPlaybackException f;
        if (b4) {
            f = ex;
        }
        else {
            f = l.f;
        }
        TrackGroupArray trackGroupArray;
        if (b6) {
            trackGroupArray = TrackGroupArray.d;
        }
        else {
            trackGroupArray = l.h;
        }
        TrackSelectorResult trackSelectorResult;
        if (b6) {
            trackSelectorResult = this.e;
        }
        else {
            trackSelectorResult = l.i;
        }
        Object o;
        if (b6) {
            o = ImmutableList.of();
        }
        else {
            o = l.j;
        }
        final m1 m = this.I;
        this.I = new m1(a4, b5, n, r, e, f, false, trackGroupArray, trackSelectorResult, (List<Metadata>)o, b5, m.l, m.m, m.n, r, 0L, r, false);
        if (b3) {
            this.E.y();
        }
    }
    
    private void r() throws ExoPlaybackException {
        this.s(new boolean[this.a.length]);
    }
    
    private void r0() {
        final e1 p = this.D.p();
        this.M = (p != null && p.f.h && this.L);
    }
    
    private void s(final boolean[] array) throws ExoPlaybackException {
        final e1 q = this.D.q();
        final TrackSelectorResult o = q.o();
        final int n = 0;
        int n2 = 0;
        int i;
        while (true) {
            i = n;
            if (n2 >= this.a.length) {
                break;
            }
            if (!o.c(n2) && this.b.remove(this.a[n2])) {
                this.a[n2].reset();
            }
            ++n2;
        }
        while (i < this.a.length) {
            if (o.c(i)) {
                this.q(i, array[i]);
            }
            ++i;
        }
        q.g = true;
    }
    
    private void s0(long z) throws ExoPlaybackException {
        final e1 p = this.D.p();
        if (p == null) {
            z += 1000000000000L;
        }
        else {
            z = p.z(z);
        }
        this.W = z;
        this.z.e(z);
        for (final Renderer renderer : this.a) {
            if (Q(renderer)) {
                renderer.C(this.W);
            }
        }
        this.e0();
    }
    
    private void t(final Renderer renderer) throws ExoPlaybackException {
        if (renderer.getState() == 2) {
            renderer.stop();
        }
    }
    
    private static void t0(final Timeline timeline, final d d, final Timeline.Window window, final Timeline.Period period) {
        final int a = timeline.r(timeline.l(d.d, period).c, window).A;
        final Object b = timeline.k(a, period, true).b;
        final long d2 = period.d;
        long n;
        if (d2 != -9223372036854775807L) {
            n = d2 - 1L;
        }
        else {
            n = Long.MAX_VALUE;
        }
        d.c(a, n, b);
    }
    
    private static boolean u0(final d d, final Timeline timeline, final Timeline timeline2, int f, final boolean b, final Timeline.Window window, final Timeline.Period period) {
        final Object d2 = d.d;
        if (d2 == null) {
            long c0;
            if (d.a.f() == Long.MIN_VALUE) {
                c0 = -9223372036854775807L;
            }
            else {
                c0 = Util.C0(d.a.f());
            }
            final Pair<Object, Long> x0 = x0(timeline, new f(d.a.h(), d.a.d(), c0), false, f, b, window, period);
            if (x0 == null) {
                return false;
            }
            d.c(timeline.f(x0.first), (long)x0.second, x0.first);
            if (d.a.f() == Long.MIN_VALUE) {
                t0(timeline, d, window, period);
            }
            return true;
        }
        else {
            f = timeline.f(d2);
            if (f == -1) {
                return false;
            }
            if (d.a.f() == Long.MIN_VALUE) {
                t0(timeline, d, window, period);
                return true;
            }
            d.b = f;
            timeline2.l(d.d, period);
            if (period.f && timeline2.r(period.c, window).z == timeline2.f(d.d)) {
                final Pair<Object, Long> n = timeline.n(window, period, timeline.l(d.d, period).c, d.c + period.r());
                d.c(timeline.f(n.first), (long)n.second, n.first);
            }
            return true;
        }
    }
    
    private ImmutableList<Metadata> v(final ExoTrackSelection[] array) {
        final ImmutableList$Builder immutableList$Builder = new ImmutableList$Builder();
        final int length = array.length;
        int i = 0;
        int n = 0;
        while (i < length) {
            final ExoTrackSelection exoTrackSelection = array[i];
            int n2 = n;
            if (exoTrackSelection != null) {
                final Metadata j = exoTrackSelection.f(0).j;
                if (j == null) {
                    immutableList$Builder.i((Object)new Metadata(new Metadata.Entry[0]));
                    n2 = n;
                }
                else {
                    immutableList$Builder.i((Object)j);
                    n2 = 1;
                }
            }
            ++i;
            n = n2;
        }
        ImmutableList list;
        if (n != 0) {
            list = immutableList$Builder.l();
        }
        else {
            list = ImmutableList.of();
        }
        return (ImmutableList<Metadata>)list;
    }
    
    private void v0(final Timeline timeline, final Timeline timeline2) {
        if (timeline.u() && timeline2.u()) {
            return;
        }
        for (int i = this.A.size() - 1; i >= 0; --i) {
            if (!u0(this.A.get(i), timeline, timeline2, this.P, this.Q, this.p, this.w)) {
                this.A.get(i).a.k(false);
                this.A.remove(i);
            }
        }
        Collections.sort(this.A);
    }
    
    private long w() {
        final m1 i = this.I;
        return this.y(i.a, i.b.a, i.r);
    }
    
    private static e w0(final Timeline timeline, final m1 m1, final f f, final h1 h1, int n, final boolean b, final Timeline.Window window, final Timeline.Period period) {
        if (timeline.u()) {
            return new e(m1.k(), 0L, -9223372036854775807L, false, true, false);
        }
        final MediaSource.MediaPeriodId b2 = m1.b;
        Object o = b2.a;
        final boolean s = S(m1, period);
        long n2;
        if (!m1.b.b() && !s) {
            n2 = m1.r;
        }
        else {
            n2 = m1.c;
        }
        final int n3 = 1;
        long n4 = 0L;
        boolean b3 = false;
        boolean b4 = false;
        boolean b5 = false;
        Label_0249: {
            if (f != null) {
                final Pair<Object, Long> x0 = x0(timeline, f, true, n, b, window, period);
                if (x0 == null) {
                    n = timeline.e(b);
                    n4 = n2;
                    b3 = false;
                    b4 = false;
                    b5 = true;
                }
                else {
                    if (f.c == -9223372036854775807L) {
                        n = timeline.l(x0.first, period).c;
                        n4 = n2;
                        b3 = false;
                    }
                    else {
                        o = x0.first;
                        n4 = (long)x0.second;
                        n = -1;
                        b3 = true;
                    }
                    b4 = (m1.e == 4);
                    b5 = false;
                }
            }
            else {
                if (m1.a.u()) {
                    n = timeline.e(b);
                }
                else {
                    if (timeline.f(o) == -1) {
                        final Object y0 = y0(window, period, n, b, o, m1.a, timeline);
                        if (y0 == null) {
                            n = timeline.e(b);
                            b5 = true;
                        }
                        else {
                            n = timeline.l(y0, period).c;
                            b5 = false;
                        }
                        n4 = n2;
                        b4 = false;
                        b3 = false;
                        break Label_0249;
                    }
                    if (n2 == -9223372036854775807L) {
                        n = timeline.l(o, period).c;
                    }
                    else {
                        if (s) {
                            final Timeline a = m1.a;
                            final MediaSource.MediaPeriodId mediaPeriodId = b2;
                            a.l(mediaPeriodId.a, period);
                            if (m1.a.r(period.c, window).z == m1.a.f(mediaPeriodId.a)) {
                                final Pair<Object, Long> n5 = timeline.n(window, period, timeline.l(o, period).c, n2 + period.r());
                                o = n5.first;
                                n4 = (long)n5.second;
                            }
                            else {
                                n4 = n2;
                            }
                            n = -1;
                            b4 = false;
                            b5 = false;
                            b3 = true;
                            break Label_0249;
                        }
                        n = -1;
                        n4 = n2;
                        b4 = false;
                        b5 = (b3 = false);
                        break Label_0249;
                    }
                }
                n4 = n2;
                b4 = false;
                b5 = (b3 = false);
            }
        }
        long n7;
        if (n != -1) {
            final Pair<Object, Long> n6 = timeline.n(window, period, n, -9223372036854775807L);
            o = n6.first;
            n4 = (long)n6.second;
            n7 = -9223372036854775807L;
        }
        else {
            n7 = n4;
        }
        MediaSource.MediaPeriodId b6 = h1.B(timeline, o, n4);
        final int e = b6.e;
        Label_0608: {
            if (e != -1) {
                n = b2.e;
                if (n == -1 || e < n) {
                    n = 0;
                    break Label_0608;
                }
            }
            n = 1;
        }
        if (b2.a.equals(o) && !b2.b() && !b6.b() && n != 0) {
            n = n3;
        }
        else {
            n = 0;
        }
        final boolean o2 = O(s, b2, n2, b6, timeline.l(o, period), n7);
        if (n != 0 || o2) {
            b6 = b2;
        }
        long n8 = n4;
        if (b6.b()) {
            if (b6.equals(b2)) {
                n8 = m1.r;
            }
            else {
                timeline.l(b6.a, period);
                if (b6.c == period.o(b6.b)) {
                    n8 = period.j();
                }
                else {
                    n8 = 0L;
                }
            }
        }
        return new e(b6, n8, n7, b4, b5, b3);
    }
    
    private static Format[] x(final ExoTrackSelection exoTrackSelection) {
        int i = 0;
        int length;
        if (exoTrackSelection != null) {
            length = exoTrackSelection.length();
        }
        else {
            length = 0;
        }
        final Format[] array = new Format[length];
        while (i < length) {
            array[i] = exoTrackSelection.f(i);
            ++i;
        }
        return array;
    }
    
    private static Pair<Object, Long> x0(final Timeline timeline, final f f, final boolean b, final int n, final boolean b2, final Timeline.Window window, final Timeline.Period period) {
        Timeline a = f.a;
        if (timeline.u()) {
            return null;
        }
        if (a.u()) {
            a = timeline;
        }
        try {
            final Pair<Object, Long> n2 = a.n(window, period, f.b, f.c);
            if (timeline.equals(a)) {
                return n2;
            }
            if (timeline.f(n2.first) != -1) {
                Pair<Object, Long> n3 = n2;
                if (a.l(n2.first, period).f) {
                    n3 = n2;
                    if (a.r(period.c, window).z == a.f(n2.first)) {
                        n3 = timeline.n(window, period, timeline.l(n2.first, period).c, f.c);
                    }
                }
                return n3;
            }
            if (b) {
                final Object y0 = y0(window, period, n, b2, n2.first, a, timeline);
                if (y0 != null) {
                    return timeline.n(window, period, timeline.l(y0, period).c, -9223372036854775807L);
                }
            }
            return null;
        }
        catch (final IndexOutOfBoundsException ex) {
            return null;
        }
    }
    
    private long y(final Timeline timeline, final Object o, final long n) {
        timeline.r(timeline.l(o, this.w).c, this.p);
        final Timeline.Window p3 = this.p;
        if (p3.f != -9223372036854775807L && p3.i()) {
            final Timeline.Window p4 = this.p;
            if (p4.i) {
                return Util.C0(p4.d() - this.p.f) - (n + this.w.r());
            }
        }
        return -9223372036854775807L;
    }
    
    static Object y0(final Timeline.Window window, final Timeline.Period period, final int n, final boolean b, final Object o, final Timeline timeline, final Timeline timeline2) {
        int n2;
        int m;
        int n3;
        int f;
        for (n2 = timeline.f(o), m = timeline.m(), n3 = 0, f = -1; n3 < m && f == -1; f = timeline2.f(timeline.q(n2)), ++n3) {
            n2 = timeline.h(n2, period, window, n, b);
            if (n2 == -1) {
                break;
            }
        }
        Object q;
        if (f == -1) {
            q = null;
        }
        else {
            q = timeline2.q(f);
        }
        return q;
    }
    
    private long z() {
        final e1 q = this.D.q();
        if (q == null) {
            return 0L;
        }
        long l = q.l();
        if (!q.d) {
            return l;
        }
        int n = 0;
        while (true) {
            final Renderer[] a = this.a;
            if (n >= a.length) {
                return l;
            }
            long max = l;
            if (Q(a[n])) {
                if (this.a[n].g() != q.c[n]) {
                    max = l;
                }
                else {
                    final long b = this.a[n].B();
                    if (b == Long.MIN_VALUE) {
                        return Long.MIN_VALUE;
                    }
                    max = Math.max(b, l);
                }
            }
            ++n;
            l = max;
        }
    }
    
    private void z0(final long n, final long n2) {
        this.h.j(2, n + n2);
    }
    
    public void A0(final Timeline timeline, final int n, final long n2) {
        this.h.e(3, new f(timeline, n, n2)).a();
    }
    
    public Looper B() {
        return this.j;
    }
    
    public void M0(final List<MediaSourceList.c> list, final int n, final long n2, final ShuffleOrder shuffleOrder) {
        this.h.e(17, new b(list, shuffleOrder, n, n2, null)).a();
    }
    
    public void P0(final boolean b, final int n) {
        this.h.g(1, b ? 1 : 0, n).a();
    }
    
    public void R0(final PlaybackParameters playbackParameters) {
        this.h.e(4, playbackParameters).a();
    }
    
    public void T0(final int n) {
        this.h.g(11, n, 0).a();
    }
    
    public void W0(final boolean b) {
        this.h.g(12, b ? 1 : 0, 0).a();
    }
    
    public void a() {
        this.h.i(10);
    }
    
    public void b() {
        this.h.i(22);
    }
    
    public void c(final PlayerMessage playerMessage) {
        synchronized (this) {
            if (!this.K && this.i.isAlive()) {
                this.h.e(14, playerMessage).a();
                return;
            }
            Log.i("ExoPlayerImplInternal", "Ignoring messages sent after release.");
            playerMessage.k(false);
        }
    }
    
    public void g1() {
        this.h.a(6).a();
    }
    
    public void h0(final MediaPeriod mediaPeriod) {
        this.h.e(9, mediaPeriod).a();
    }
    
    public boolean handleMessage(final Message message) {
        int n = 1000;
        try {
            switch (message.what) {
                default: {
                    return false;
                }
                case 25: {
                    this.j();
                    break;
                }
                case 24: {
                    this.N0(message.arg1 == 1);
                    break;
                }
                case 23: {
                    this.O0(message.arg1 != 0);
                    break;
                }
                case 22: {
                    this.c0();
                    break;
                }
                case 21: {
                    this.Y0((ShuffleOrder)message.obj);
                    break;
                }
                case 20: {
                    this.m0(message.arg1, message.arg2, (ShuffleOrder)message.obj);
                    break;
                }
                case 19: {
                    this.d0((c)message.obj);
                    break;
                }
                case 18: {
                    this.h((b)message.obj, message.arg1);
                    break;
                }
                case 17: {
                    this.L0((b)message.obj);
                    break;
                }
                case 16: {
                    this.K((PlaybackParameters)message.obj, false);
                    break;
                }
                case 15: {
                    this.H0((PlayerMessage)message.obj);
                    break;
                }
                case 14: {
                    this.F0((PlayerMessage)message.obj);
                    break;
                }
                case 13: {
                    this.K0(message.arg1 != 0, (AtomicBoolean)message.obj);
                    break;
                }
                case 12: {
                    this.X0(message.arg1 != 0);
                    break;
                }
                case 11: {
                    this.U0(message.arg1);
                    break;
                }
                case 10: {
                    this.p0();
                    break;
                }
                case 9: {
                    this.E((MediaPeriod)message.obj);
                    break;
                }
                case 8: {
                    this.I((MediaPeriod)message.obj);
                    break;
                }
                case 7: {
                    this.l0();
                    return true;
                }
                case 6: {
                    this.h1(false, true);
                    break;
                }
                case 5: {
                    this.V0((SeekParameters)message.obj);
                    break;
                }
                case 4: {
                    this.S0((PlaybackParameters)message.obj);
                    break;
                }
                case 3: {
                    this.C0((f)message.obj);
                    break;
                }
                case 2: {
                    this.p();
                    break;
                }
                case 1: {
                    this.Q0(message.arg1 != 0, message.arg2, true, 1);
                    break;
                }
                case 0: {
                    this.j0();
                    break;
                }
            }
        }
        catch (final RuntimeException ex) {
            if (ex instanceof IllegalStateException || ex instanceof IllegalArgumentException) {
                n = 1004;
            }
            final ExoPlaybackException forUnexpected = ExoPlaybackException.createForUnexpected(ex, n);
            Log.d("ExoPlayerImplInternal", "Playback error", forUnexpected);
            this.h1(true, false);
            this.I = this.I.e(forUnexpected);
        }
        catch (final IOException ex2) {
            this.F(ex2, 2000);
        }
        catch (final BehindLiveWindowException ex3) {
            this.F(ex3, 1002);
        }
        catch (final DataSourceException ex4) {
            this.F(ex4, ex4.reason);
        }
        catch (final ParserException ex5) {
            final int dataType = ex5.dataType;
            if (dataType == 1) {
                if (ex5.contentIsMalformed) {
                    n = 3001;
                }
                else {
                    n = 3003;
                }
            }
            else if (dataType == 4) {
                if (ex5.contentIsMalformed) {
                    n = 3002;
                }
                else {
                    n = 3004;
                }
            }
            this.F(ex5, n);
        }
        catch (final DrmSession.DrmSessionException ex6) {
            this.F(ex6, ex6.errorCode);
        }
        catch (final ExoPlaybackException ex7) {
            ExoPlaybackException copyWithMediaPeriodId = ex7;
            if (ex7.type == 1) {
                final e1 q = this.D.q();
                copyWithMediaPeriodId = ex7;
                if (q != null) {
                    copyWithMediaPeriodId = ex7.copyWithMediaPeriodId(q.f.a);
                }
            }
            if (copyWithMediaPeriodId.isRecoverable && this.Z == null) {
                Log.j("ExoPlayerImplInternal", "Recoverable renderer error", copyWithMediaPeriodId);
                this.Z = copyWithMediaPeriodId;
                final HandlerWrapper h = this.h;
                h.b(h.e(25, copyWithMediaPeriodId));
            }
            else {
                final ExoPlaybackException z = this.Z;
                ExoPlaybackException z2 = copyWithMediaPeriodId;
                if (z != null) {
                    z.addSuppressed(copyWithMediaPeriodId);
                    z2 = this.Z;
                }
                Log.d("ExoPlayerImplInternal", "Playback error", z2);
                this.h1(true, false);
                this.I = this.I.e(z2);
            }
        }
        this.W();
        return true;
    }
    
    public void i(final int n, final List<MediaSourceList.c> list, final ShuffleOrder shuffleOrder) {
        this.h.d(18, n, 0, new b(list, shuffleOrder, -1, -9223372036854775807L, null)).a();
    }
    
    public void i0() {
        this.h.a(0).a();
    }
    
    public boolean k0() {
        synchronized (this) {
            if (!this.K && this.i.isAlive()) {
                this.h.i(7);
                this.p1((Supplier<Boolean>)new v0(this), this.G);
                return this.K;
            }
            return true;
        }
    }
    
    public /* bridge */ void l(final SequenceableLoader sequenceableLoader) {
        this.h0((MediaPeriod)sequenceableLoader);
    }
    
    public void n0(final int n, final int n2, final ShuffleOrder shuffleOrder) {
        this.h.d(20, n, n2, shuffleOrder).a();
    }
    
    public void o(final MediaPeriod mediaPeriod) {
        this.h.e(8, mediaPeriod).a();
    }
    
    public void onPlaybackParametersChanged(final PlaybackParameters playbackParameters) {
        this.h.e(16, playbackParameters).a();
    }
    
    public void u(final long a0) {
        this.a0 = a0;
    }
    
    public static final class PlaybackInfoUpdate
    {
        private boolean a;
        public m1 b;
        public int c;
        public boolean d;
        public int e;
        public boolean f;
        public int g;
        
        public PlaybackInfoUpdate(final m1 b) {
            this.b = b;
        }
        
        static boolean a(final PlaybackInfoUpdate playbackInfoUpdate) {
            return playbackInfoUpdate.a;
        }
        
        public void b(final int n) {
            this.a |= (n > 0);
            this.c += n;
        }
        
        public void c(final int g) {
            this.a = true;
            this.f = true;
            this.g = g;
        }
        
        public void d(final m1 b) {
            this.a |= (this.b != b);
            this.b = b;
        }
        
        public void e(final int e) {
            final boolean d = this.d;
            boolean b = true;
            if (d && this.e != 5) {
                if (e != 5) {
                    b = false;
                }
                Assertions.a(b);
                return;
            }
            this.a = true;
            this.d = true;
            this.e = e;
        }
    }
    
    public interface PlaybackInfoUpdateListener
    {
        void a(final PlaybackInfoUpdate p0);
    }
    
    private static final class b
    {
        private final List<MediaSourceList.c> a;
        private final ShuffleOrder b;
        private final int c;
        private final long d;
        
        private b(final List<MediaSourceList.c> a, final ShuffleOrder b, final int c, final long d) {
            this.a = a;
            this.b = b;
            this.c = c;
            this.d = d;
        }
        
        b(final List list, final ShuffleOrder shuffleOrder, final int n, final long n2, final ExoPlayerImplInternal$a wakeupListener) {
            this(list, shuffleOrder, n, n2);
        }
        
        static int a(final b b) {
            return b.c;
        }
        
        static List b(final b b) {
            return b.a;
        }
        
        static ShuffleOrder c(final b b) {
            return b.b;
        }
        
        static long d(final b b) {
            return b.d;
        }
    }
    
    private static class c
    {
        public final int a;
        public final int b;
        public final int c;
        public final ShuffleOrder d;
    }
    
    private static final class d implements Comparable<d>
    {
        public final PlayerMessage a;
        public int b;
        public long c;
        public Object d;
        
        public d(final PlayerMessage a) {
            this.a = a;
        }
        
        public int a(final d d) {
            final Object d2 = this.d;
            final int n = 1;
            if (d2 == null != (d.d == null)) {
                int n2 = n;
                if (d2 != null) {
                    n2 = -1;
                }
                return n2;
            }
            if (d2 == null) {
                return 0;
            }
            final int n3 = this.b - d.b;
            if (n3 != 0) {
                return n3;
            }
            return Util.o(this.c, d.c);
        }
        
        public void c(final int b, final long c, final Object d) {
            this.b = b;
            this.c = c;
            this.d = d;
        }
        
        @Override
        public /* bridge */ int compareTo(final Object o) {
            return this.a((d)o);
        }
    }
    
    private static final class e
    {
        public final MediaSource.MediaPeriodId a;
        public final long b;
        public final long c;
        public final boolean d;
        public final boolean e;
        public final boolean f;
        
        public e(final MediaSource.MediaPeriodId a, final long b, final long c, final boolean d, final boolean e, final boolean f) {
            this.a = a;
            this.b = b;
            this.c = c;
            this.d = d;
            this.e = e;
            this.f = f;
        }
    }
    
    private static final class f
    {
        public final Timeline a;
        public final int b;
        public final long c;
        
        public f(final Timeline a, final int b, final long c) {
            this.a = a;
            this.b = b;
            this.c = c;
        }
    }
}
