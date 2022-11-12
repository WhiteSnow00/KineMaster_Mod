// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.exoplayer2;

import android.media.MediaFormat;
import com.google.android.exoplayer2.video.spherical.CameraMotionListener;
import com.google.android.exoplayer2.video.VideoFrameMetadataListener;
import com.google.android.exoplayer2.decoder.DecoderReuseEvaluation;
import com.google.android.exoplayer2.text.Cue;
import android.media.metrics.LogSessionId;
import com.google.android.exoplayer2.analytics.MediaMetricsListener;
import com.google.android.exoplayer2.analytics.AnalyticsListener;
import com.google.android.exoplayer2.video.VideoDecoderOutputBufferRenderer;
import java.util.Collections;
import android.view.SurfaceView;
import java.util.concurrent.TimeoutException;
import java.util.Collection;
import android.graphics.Rect;
import android.view.SurfaceHolder$Callback;
import android.view.TextureView$SurfaceTextureListener;
import com.google.android.exoplayer2.metadata.Metadata;
import com.google.common.collect.ImmutableList;
import com.google.android.exoplayer2.source.TrackGroupArray;
import android.graphics.SurfaceTexture;
import com.google.android.exoplayer2.trackselection.TrackSelectionParameters;
import com.google.android.exoplayer2.util.FlagSet;
import java.util.Iterator;
import android.util.Pair;
import com.google.android.exoplayer2.analytics.PlayerId;
import android.os.Handler$Callback;
import com.google.android.exoplayer2.trackselection.ExoTrackSelection;
import java.util.ArrayList;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.metadata.MetadataOutput;
import com.google.android.exoplayer2.text.TextOutput;
import com.google.android.exoplayer2.audio.AudioRendererEventListener;
import com.google.android.exoplayer2.video.VideoRendererEventListener;
import android.os.Handler;
import com.google.android.exoplayer2.util.Log;
import com.google.android.exoplayer2.util.Util;
import com.google.android.exoplayer2.util.Clock;
import com.google.android.exoplayer2.upstream.BandwidthMeter;
import android.os.Looper;
import com.google.android.exoplayer2.video.VideoSize;
import com.google.android.exoplayer2.analytics.AnalyticsCollector;
import com.google.android.exoplayer2.source.MediaSource;
import java.util.List;
import com.google.android.exoplayer2.util.PriorityTaskManager;
import java.util.concurrent.CopyOnWriteArraySet;
import com.google.android.exoplayer2.util.ListenerSet;
import com.google.android.exoplayer2.text.CueGroup;
import com.google.android.exoplayer2.util.HandlerWrapper;
import com.google.android.exoplayer2.audio.AudioAttributes;
import com.google.android.exoplayer2.trackselection.TrackSelector;
import com.google.android.exoplayer2.decoder.DecoderCounters;
import android.content.Context;
import com.google.android.exoplayer2.util.ConditionVariable;
import com.google.android.exoplayer2.trackselection.TrackSelectorResult;
import android.view.TextureView;
import com.google.android.exoplayer2.video.spherical.SphericalGLSurfaceView;
import android.view.SurfaceHolder;
import android.view.Surface;
import android.media.AudioTrack;
import com.google.android.exoplayer2.source.ShuffleOrder;

final class l0 extends BasePlayer implements ExoPlayer, AudioComponent, VideoComponent, TextComponent, DeviceComponent
{
    private final AudioFocusManager A;
    private final StreamVolumeManager B;
    private final a2 C;
    private final b2 D;
    private final long E;
    private int F;
    private boolean G;
    private int H;
    private int I;
    private boolean J;
    private int K;
    private SeekParameters L;
    private ShuffleOrder M;
    private boolean N;
    private Commands O;
    private MediaMetadata P;
    private MediaMetadata Q;
    private Format R;
    private Format S;
    private AudioTrack T;
    private Object U;
    private Surface V;
    private SurfaceHolder W;
    private SphericalGLSurfaceView X;
    private boolean Y;
    private TextureView Z;
    private int a0;
    final TrackSelectorResult b;
    private int b0;
    final Commands c;
    private int c0;
    private final ConditionVariable d;
    private int d0;
    private final Context e;
    private DecoderCounters e0;
    private final Player f;
    private DecoderCounters f0;
    private final Renderer[] g;
    private int g0;
    private final TrackSelector h;
    private AudioAttributes h0;
    private final HandlerWrapper i;
    private float i0;
    private final ExoPlayerImplInternal.PlaybackInfoUpdateListener j;
    private boolean j0;
    private final ExoPlayerImplInternal k;
    private CueGroup k0;
    private final ListenerSet<Listener> l;
    private boolean l0;
    private final CopyOnWriteArraySet<AudioOffloadListener> m;
    private boolean m0;
    private final Timeline.Period n;
    private PriorityTaskManager n0;
    private final List<e> o;
    private boolean o0;
    private final boolean p;
    private boolean p0;
    private final MediaSource.Factory q;
    private DeviceInfo q0;
    private final AnalyticsCollector r;
    private VideoSize r0;
    private final Looper s;
    private MediaMetadata s0;
    private final BandwidthMeter t;
    private m1 t0;
    private final long u;
    private int u0;
    private final long v;
    private int v0;
    private final Clock w;
    private long w0;
    private final c x;
    private final d y;
    private final AudioBecomingNoisyManager z;
    
    static {
        ExoPlayerLibraryInfo.a("goog.exo.exoplayer");
    }
    
    public l0(final Builder builder, Player f) {
        final ConditionVariable d = new ConditionVariable();
        this.d = d;
        try {
            final StringBuilder sb = new StringBuilder();
            sb.append("Init ");
            sb.append(Integer.toHexString(System.identityHashCode(this)));
            sb.append(" [");
            sb.append("ExoPlayerLib/2.18.1");
            sb.append("] [");
            sb.append(Util.e);
            sb.append("]");
            Log.f("ExoPlayerImpl", sb.toString());
            final Context applicationContext = builder.a.getApplicationContext();
            this.e = applicationContext;
            final AnalyticsCollector r = (AnalyticsCollector)builder.i.apply((Object)builder.b);
            this.r = r;
            this.n0 = builder.k;
            this.h0 = builder.l;
            this.a0 = builder.q;
            this.b0 = builder.r;
            this.j0 = builder.p;
            this.E = builder.y;
            final c x = new c(null);
            this.x = x;
            final d y = new d(null);
            this.y = y;
            final Handler handler = new Handler(builder.j);
            final Renderer[] a = ((RenderersFactory)builder.d.get()).a(handler, x, x, x, x);
            this.g = a;
            Assertions.g(a.length > 0);
            final TrackSelector h = (TrackSelector)builder.f.get();
            this.h = h;
            this.q = (MediaSource.Factory)builder.e.get();
            final BandwidthMeter t = (BandwidthMeter)builder.h.get();
            this.t = t;
            this.p = builder.s;
            this.L = builder.t;
            this.u = builder.u;
            this.v = builder.v;
            this.N = builder.z;
            final Looper j = builder.j;
            this.s = j;
            final Clock b = builder.b;
            this.w = b;
            if (f == null) {
                f = this;
            }
            this.f = f;
            this.l = new ListenerSet<Listener>(j, b, new b0(this));
            this.m = new CopyOnWriteArraySet<AudioOffloadListener>();
            this.o = new ArrayList<e>();
            this.M = new ShuffleOrder.DefaultShuffleOrder(0);
            final TrackSelectorResult b2 = new TrackSelectorResult(new RendererConfiguration[a.length], new ExoTrackSelection[a.length], Tracks.b, null);
            this.b = b2;
            this.n = new Timeline.Period();
            final Player.Commands e = new Player.Commands.Builder().c(1, 2, 3, 13, 14, 15, 16, 17, 18, 19, 31, 20, 30, 21, 22, 23, 24, 25, 26, 27, 28).d(29, h.e()).e();
            this.c = e;
            this.O = new Player.Commands.Builder().b(e).a(4).a(10).e();
            this.i = b.e(j, null);
            final l i = new l(this);
            this.j = i;
            this.t0 = m1.j(b2);
            r.D(f, j);
            final int a2 = Util.a;
            PlayerId a3;
            if (a2 < 31) {
                a3 = new PlayerId();
            }
            else {
                a3 = com.google.android.exoplayer2.l0.b.a(applicationContext, this, builder.A);
            }
            final ExoPlayerImplInternal k = new ExoPlayerImplInternal(a, h, b2, (LoadControl)builder.g.get(), t, this.F, this.G, r, this.L, builder.w, builder.x, this.N, j, b, (ExoPlayerImplInternal.PlaybackInfoUpdateListener)i, a3);
            this.k = k;
            this.i0 = 1.0f;
            this.F = 0;
            final MediaMetadata r2 = MediaMetadata.R;
            this.P = r2;
            this.Q = r2;
            this.s0 = r2;
            this.u0 = -1;
            if (a2 < 21) {
                this.g0 = this.L1(0);
            }
            else {
                this.g0 = Util.F(applicationContext);
            }
            this.k0 = CueGroup.b;
            this.l0 = true;
            this.S(r);
            t.g(new Handler(j), (BandwidthMeter.EventListener)r);
            this.r1(x);
            final long c = builder.c;
            if (c > 0L) {
                k.u(c);
            }
            (this.z = new AudioBecomingNoisyManager(builder.a, handler, (AudioBecomingNoisyManager.EventListener)x)).b(builder.o);
            final AudioFocusManager a4 = new AudioFocusManager(builder.a, handler, (AudioFocusManager.PlayerControl)x);
            this.A = a4;
            AudioAttributes h2;
            if (builder.m) {
                h2 = this.h0;
            }
            else {
                h2 = null;
            }
            a4.m(h2);
            final StreamVolumeManager b3 = new StreamVolumeManager(builder.a, handler, (StreamVolumeManager.Listener)x);
            (this.B = b3).h(Util.g0(this.h0.c));
            (this.C = new a2(builder.a)).a(builder.n != 0);
            (this.D = new b2(builder.a)).a(builder.n == 2);
            this.q0 = x1(b3);
            this.r0 = VideoSize.e;
            h.i(this.h0);
            this.s2(1, 10, this.g0);
            this.s2(2, 10, this.g0);
            this.s2(1, 3, this.h0);
            this.s2(2, 4, this.a0);
            this.s2(2, 5, this.b0);
            this.s2(1, 9, this.j0);
            this.s2(2, 7, y);
            this.s2(6, 8, y);
            d.f();
        }
        finally {
            this.d.f();
        }
    }
    
    public static void A0(final m1 m1, final Listener listener) {
        j2(m1, listener);
    }
    
    private PlayerMessage A1(final PlayerMessage.Target target) {
        final int e1 = this.E1();
        final ExoPlayerImplInternal k = this.k;
        final Timeline a = this.t0.a;
        int n = e1;
        if (e1 == -1) {
            n = 0;
        }
        return new PlayerMessage((PlayerMessage.Sender)k, target, a, n, this.w, k.B());
    }
    
    public static void B0(final m1 m1, final Listener listener) {
        b2(m1, listener);
    }
    
    private Pair<Boolean, Integer> B1(final m1 m1, final m1 m2, final boolean b, int n, final boolean b2) {
        final Timeline a = m2.a;
        final Timeline a2 = m1.a;
        final boolean u = a2.u();
        final Integer value = -1;
        if (u && a.u()) {
            return (Pair<Boolean, Integer>)new Pair((Object)Boolean.FALSE, (Object)value);
        }
        final boolean u2 = a2.u();
        final boolean u3 = a.u();
        final int n2 = 3;
        if (u2 != u3) {
            return (Pair<Boolean, Integer>)new Pair((Object)Boolean.TRUE, (Object)3);
        }
        if (!a.r(a.l(m2.b.a, this.n).c, super.a).a.equals(a2.r(a2.l(m1.b.a, this.n).c, super.a).a)) {
            if (b && n == 0) {
                n = 1;
            }
            else if (b && n == 1) {
                n = 2;
            }
            else {
                if (!b2) {
                    throw new IllegalStateException();
                }
                n = n2;
            }
            return (Pair<Boolean, Integer>)new Pair((Object)Boolean.TRUE, (Object)n);
        }
        if (b && n == 0 && m2.b.d < m1.b.d) {
            return (Pair<Boolean, Integer>)new Pair((Object)Boolean.TRUE, (Object)0);
        }
        return (Pair<Boolean, Integer>)new Pair((Object)Boolean.FALSE, (Object)value);
    }
    
    public static void C0(final m1 m1, final Listener listener) {
        f2(m1, listener);
    }
    
    private void C2(final boolean b, final ExoPlaybackException ex) {
        m1 m1;
        if (b) {
            m1 = this.p2(0, this.o.size()).e(null);
        }
        else {
            final m1 t0 = this.t0;
            m1 = t0.b(t0.b);
            m1.p = m1.r;
            m1.q = 0L;
        }
        m1 m3;
        final m1 m2 = m3 = m1.g(1);
        if (ex != null) {
            m3 = m2.e(ex);
        }
        ++this.H;
        this.k.g1();
        this.F2(m3, 0, 1, false, m3.a.u() && !this.t0.a.u(), 4, this.D1(m3), -1);
    }
    
    public static void D0(final l0 l0, final ExoPlayerImplInternal.PlaybackInfoUpdate playbackInfoUpdate) {
        l0.Q1(playbackInfoUpdate);
    }
    
    private long D1(final m1 m1) {
        if (m1.a.u()) {
            return Util.C0(this.w0);
        }
        if (m1.b.b()) {
            return m1.r;
        }
        return this.o2(m1.a, m1.b, m1.r);
    }
    
    private void D2() {
        final Commands o = this.O;
        final Commands h = Util.H(this.f, this.c);
        this.O = h;
        if (!h.equals(o)) {
            this.l.i(13, new g0(this));
        }
    }
    
    public static void E0(final int n, final PositionInfo positionInfo, final PositionInfo positionInfo2, final Listener listener) {
        Y1(n, positionInfo, positionInfo2, listener);
    }
    
    private int E1() {
        if (this.t0.a.u()) {
            return this.u0;
        }
        final m1 t0 = this.t0;
        return t0.a.l(t0.b.a, this.n).c;
    }
    
    private void E2(final boolean b, final int n, final int n2) {
        final int n3 = 0;
        final boolean b2 = b && n != -1;
        int n4 = n3;
        if (b2) {
            n4 = n3;
            if (n != 1) {
                n4 = 1;
            }
        }
        final m1 t0 = this.t0;
        if (t0.l == b2 && t0.m == n4) {
            return;
        }
        ++this.H;
        final m1 d = t0.d(b2, n4);
        this.k.P0(b2, n4);
        this.F2(d, 0, n2, false, false, 5, -9223372036854775807L, -1);
    }
    
    public static void F0(final MediaMetadata mediaMetadata, final Listener listener) {
        d2(mediaMetadata, listener);
    }
    
    private Pair<Object, Long> F1(final Timeline timeline, final Timeline timeline2) {
        long r = this.R();
        final boolean u = timeline.u();
        int e1 = -1;
        if (u || timeline2.u()) {
            final boolean b = !timeline.u() && timeline2.u();
            if (!b) {
                e1 = this.E1();
            }
            if (b) {
                r = -9223372036854775807L;
            }
            return this.m2(timeline2, e1, r);
        }
        final Pair<Object, Long> n = timeline.n(super.a, this.n, this.Y(), Util.C0(r));
        final Object first = Util.j(n).first;
        if (timeline2.f(first) != -1) {
            return n;
        }
        final Object y0 = ExoPlayerImplInternal.y0(super.a, this.n, this.F, this.G, first, timeline, timeline2);
        if (y0 != null) {
            timeline2.l(y0, this.n);
            final int c = this.n.c;
            return this.m2(timeline2, c, timeline2.r(c, super.a).e());
        }
        return this.m2(timeline2, -1, -9223372036854775807L);
    }
    
    private void F2(final m1 t0, final int n, final int n2, final boolean b, final boolean b2, final int n3, final long n4, final int n5) {
        final m1 t2 = this.t0;
        this.t0 = t0;
        final Pair<Boolean, Integer> b3 = this.B1(t0, t2, b2, n3, t2.a.equals(t0.a) ^ true);
        final boolean booleanValue = (boolean)b3.first;
        final int intValue = (int)b3.second;
        MediaMetadata p8 = this.P;
        MediaItem c = null;
        final MediaItem mediaItem = null;
        if (booleanValue) {
            c = mediaItem;
            if (!t0.a.u()) {
                c = t0.a.r(t0.a.l(t0.b.a, this.n).c, super.a).c;
            }
            this.s0 = MediaMetadata.R;
        }
        if (booleanValue || !t2.j.equals(t0.j)) {
            this.s0 = this.s0.b().J(t0.j).F();
            p8 = this.u1();
        }
        final boolean equals = p8.equals(this.P);
        this.P = p8;
        final boolean b4 = t2.l != t0.l;
        final boolean b5 = t2.e != t0.e;
        if (b5 || b4) {
            this.H2();
        }
        final boolean g = t2.g;
        final boolean g2 = t0.g;
        final boolean b6 = g != g2;
        if (b6) {
            this.G2(g2);
        }
        if (!t2.a.equals(t0.a)) {
            this.l.i(0, new u(t0, n));
        }
        if (b2) {
            this.l.i(11, new f0(n3, this.I1(n3, t2, n5), this.H1(n4)));
        }
        if (booleanValue) {
            this.l.i(1, new h0(c, intValue));
        }
        if (t2.f != t0.f) {
            this.l.i(10, new j0(t0));
            if (t0.f != null) {
                this.l.i(10, new q(t0));
            }
        }
        final TrackSelectorResult i = t2.i;
        final TrackSelectorResult j = t0.i;
        if (i != j) {
            this.h.f(j.e);
            this.l.i(2, new m(t0));
        }
        if (equals ^ true) {
            this.l.i(14, new i0(this.P));
        }
        if (b6) {
            this.l.i(3, new t(t0));
        }
        if (b5 || b4) {
            this.l.i(-1, new s(t0));
        }
        if (b5) {
            this.l.i(4, new k0(t0));
        }
        if (b4) {
            this.l.i(5, new v(t0, n2));
        }
        if (t2.m != t0.m) {
            this.l.i(6, new n(t0));
        }
        if (M1(t2) != M1(t0)) {
            this.l.i(7, new p(t0));
        }
        if (!t2.n.equals(t0.n)) {
            this.l.i(12, new o(t0));
        }
        if (b) {
            this.l.i(-1, com.google.android.exoplayer2.a0.a);
        }
        this.D2();
        this.l.f();
        if (t2.o != t0.o) {
            final Iterator<AudioOffloadListener> iterator = this.m.iterator();
            while (iterator.hasNext()) {
                iterator.next().y(t0.o);
            }
        }
    }
    
    public static void G0(final l0 l0, final Listener listener) {
        l0.W1(listener);
    }
    
    private static int G1(final boolean b, final int n) {
        int n2 = 1;
        if (b) {
            n2 = n2;
            if (n != 1) {
                n2 = 2;
            }
        }
        return n2;
    }
    
    private void G2(final boolean b) {
        final PriorityTaskManager n0 = this.n0;
        if (n0 != null) {
            if (b && !this.o0) {
                n0.a(0);
                this.o0 = true;
            }
            else if (!b && this.o0) {
                n0.d(0);
                this.o0 = false;
            }
        }
    }
    
    public static void H0(final int n, final Listener listener) {
        S1(n, listener);
    }
    
    private PositionInfo H1(long f1) {
        final int y = this.Y();
        final boolean u = this.t0.a.u();
        Object a = null;
        Object a2;
        int f2;
        MediaItem c;
        if (!u) {
            final m1 t0 = this.t0;
            a2 = t0.b.a;
            t0.a.l(a2, this.n);
            f2 = this.t0.a.f(a2);
            a = this.t0.a.r(y, super.a).a;
            c = super.a.c;
        }
        else {
            f2 = -1;
            c = null;
            a2 = null;
        }
        final long f3 = Util.f1(f1);
        if (this.t0.b.b()) {
            f1 = Util.f1(J1(this.t0));
        }
        else {
            f1 = f3;
        }
        final MediaSource.MediaPeriodId b = this.t0.b;
        return new Player.PositionInfo(a, y, c, a2, f2, f3, f1, b.b, b.c);
    }
    
    private void H2() {
        final int playbackState = this.getPlaybackState();
        boolean b = true;
        if (playbackState != 1) {
            if (playbackState == 2 || playbackState == 3) {
                final boolean c1 = this.C1();
                final a2 c2 = this.C;
                if (!this.E() || c1) {
                    b = false;
                }
                c2.b(b);
                this.D.b(this.E());
                return;
            }
            if (playbackState != 4) {
                throw new IllegalStateException();
            }
        }
        this.C.b(false);
        this.D.b(false);
    }
    
    public static void I0(final MediaItem mediaItem, final int n, final Listener listener) {
        Z1(mediaItem, n, listener);
    }
    
    private PositionInfo I1(final int n, final m1 m1, int f) {
        final Timeline.Period period = new Timeline.Period();
        Object a;
        int c;
        Object a2;
        Object c2;
        int n2;
        if (!m1.a.u()) {
            a = m1.b.a;
            m1.a.l(a, period);
            c = period.c;
            f = m1.a.f(a);
            a2 = m1.a.r(c, super.a).a;
            c2 = super.a.c;
            n2 = f;
        }
        else {
            n2 = -1;
            a2 = null;
            c2 = (a = null);
            c = f;
        }
        long n3 = 0L;
        long n4 = 0L;
        Label_0232: {
            if (n == 0) {
                if (m1.b.b()) {
                    final MediaSource.MediaPeriodId b = m1.b;
                    n3 = period.e(b.b, b.c);
                    n4 = J1(m1);
                    break Label_0232;
                }
                if (m1.b.e != -1) {
                    n3 = J1(this.t0);
                }
                else {
                    n3 = period.e + period.d;
                }
            }
            else {
                if (m1.b.b()) {
                    n3 = m1.r;
                    n4 = J1(m1);
                    break Label_0232;
                }
                n3 = period.e + m1.r;
            }
            n4 = n3;
        }
        final long f2 = Util.f1(n3);
        final long f3 = Util.f1(n4);
        final MediaSource.MediaPeriodId b2 = m1.b;
        return new Player.PositionInfo(a2, c, (MediaItem)c2, a, n2, f2, f3, b2.b, b2.c);
    }
    
    private void I2() {
        this.d.c();
        if (Thread.currentThread() != this.x().getThread()) {
            final String c = Util.C("Player is accessed on the wrong thread.\nCurrent thread: '%s'\nExpected thread: '%s'\nSee https://exoplayer.dev/issues/player-accessed-on-wrong-thread", Thread.currentThread().getName(), this.x().getThread().getName());
            if (this.l0) {
                throw new IllegalStateException(c);
            }
            Throwable t;
            if (this.m0) {
                t = null;
            }
            else {
                t = new IllegalStateException();
            }
            Log.j("ExoPlayerImpl", c, t);
            this.m0 = true;
        }
    }
    
    public static void J0(final m1 m1, final Listener listener) {
        e2(m1, listener);
    }
    
    private static long J1(final m1 m1) {
        final Timeline.Window window = new Timeline.Window();
        final Timeline.Period period = new Timeline.Period();
        m1.a.l(m1.b.a, period);
        long f;
        if (m1.c == -9223372036854775807L) {
            f = m1.a.r(period.c, window).f();
        }
        else {
            f = period.r() + m1.c;
        }
        return f;
    }
    
    public static void K0(final m1 m1, final int n, final Listener listener) {
        X1(m1, n, listener);
    }
    
    private void K1(final ExoPlayerImplInternal.PlaybackInfoUpdate playbackInfoUpdate) {
        final int h = this.H - playbackInfoUpdate.c;
        this.H = h;
        final boolean d = playbackInfoUpdate.d;
        final boolean b = true;
        if (d) {
            this.I = playbackInfoUpdate.e;
            this.J = true;
        }
        if (playbackInfoUpdate.f) {
            this.K = playbackInfoUpdate.g;
        }
        if (h == 0) {
            final Timeline a = playbackInfoUpdate.b.a;
            if (!this.t0.a.u() && a.u()) {
                this.u0 = -1;
                this.w0 = 0L;
                this.v0 = 0;
            }
            if (!a.u()) {
                final List<Timeline> k = ((q1)a).K();
                Assertions.g(k.size() == this.o.size());
                for (int i = 0; i < k.size(); ++i) {
                    com.google.android.exoplayer2.l0.e.c(this.o.get(i), (Timeline)k.get(i));
                }
            }
            boolean b2;
            long n;
            if (this.J) {
                b2 = b;
                if (playbackInfoUpdate.b.b.equals(this.t0.b)) {
                    b2 = (playbackInfoUpdate.b.d != this.t0.r && b);
                }
                if (b2) {
                    if (!a.u() && !playbackInfoUpdate.b.b.b()) {
                        final m1 b3 = playbackInfoUpdate.b;
                        n = this.o2(a, b3.b, b3.d);
                    }
                    else {
                        n = playbackInfoUpdate.b.d;
                    }
                }
                else {
                    n = -9223372036854775807L;
                }
            }
            else {
                n = -9223372036854775807L;
                b2 = false;
            }
            this.J = false;
            this.F2(playbackInfoUpdate.b, 1, this.K, false, b2, this.I, n, -1);
        }
    }
    
    public static void L0(final Listener listener) {
        R1(listener);
    }
    
    private int L1(final int n) {
        final AudioTrack t = this.T;
        if (t != null && t.getAudioSessionId() != n) {
            this.T.release();
            this.T = null;
        }
        if (this.T == null) {
            this.T = new AudioTrack(3, 4000, 4, 2, 2, 0, n);
        }
        return this.T.getAudioSessionId();
    }
    
    public static void M0(final l0 l0, final ExoPlayerImplInternal.PlaybackInfoUpdate playbackInfoUpdate) {
        l0.P1(playbackInfoUpdate);
    }
    
    private static boolean M1(final m1 m1) {
        return m1.e == 3 && m1.l && m1.m == 0;
    }
    
    public static void N0(final m1 m1, final int n, final Listener listener) {
        h2(m1, n, listener);
    }
    
    private static void N1(final int n, final int n2, final Listener listener) {
        listener.onSurfaceSizeChanged(n, n2);
    }
    
    static Format O0(final l0 l0, final Format s) {
        return l0.S = s;
    }
    
    private void O1(final Listener listener, final FlagSet set) {
        listener.onEvents(this.f, new Player.Events(set));
    }
    
    static boolean P0(final l0 l0) {
        return l0.j0;
    }
    
    private void P1(final ExoPlayerImplInternal.PlaybackInfoUpdate playbackInfoUpdate) {
        this.K1(playbackInfoUpdate);
    }
    
    static boolean Q0(final l0 l0, final boolean j0) {
        return l0.j0 = j0;
    }
    
    private void Q1(final ExoPlayerImplInternal.PlaybackInfoUpdate playbackInfoUpdate) {
        this.i.h(new c0(this, playbackInfoUpdate));
    }
    
    static CueGroup R0(final l0 l0, final CueGroup k0) {
        return l0.k0 = k0;
    }
    
    private static void R1(final Listener listener) {
        listener.onPlayerError(ExoPlaybackException.createForUnexpected(new ExoTimeoutException(1), 1003));
    }
    
    static MediaMetadata S0(final l0 l0) {
        return l0.s0;
    }
    
    private static void S1(final int n, final Listener listener) {
        listener.onRepeatModeChanged(n);
    }
    
    static MediaMetadata T0(final l0 l0, final MediaMetadata s0) {
        return l0.s0 = s0;
    }
    
    private static void T1(final boolean b, final Listener listener) {
        listener.onShuffleModeEnabledChanged(b);
    }
    
    static MediaMetadata U0(final l0 l0) {
        return l0.u1();
    }
    
    private static void U1(final TrackSelectionParameters trackSelectionParameters, final Listener listener) {
        listener.onTrackSelectionParametersChanged(trackSelectionParameters);
    }
    
    static MediaMetadata V0(final l0 l0) {
        return l0.P;
    }
    
    private static void V1(final float n, final Listener listener) {
        listener.onVolumeChanged(n);
    }
    
    static MediaMetadata W0(final l0 l0, final MediaMetadata p2) {
        return l0.P = p2;
    }
    
    private void W1(final Listener listener) {
        listener.onAvailableCommandsChanged(this.O);
    }
    
    static boolean X0(final l0 l0) {
        return l0.Y;
    }
    
    private static void X1(final m1 m1, final int n, final Listener listener) {
        listener.onTimelineChanged(m1.a, n);
    }
    
    static void Y0(final l0 l0, final Object o) {
        l0.z2(o);
    }
    
    private static void Y1(final int n, final PositionInfo positionInfo, final PositionInfo positionInfo2, final Listener listener) {
        listener.onPositionDiscontinuity(n);
        listener.onPositionDiscontinuity(positionInfo, positionInfo2, n);
    }
    
    static void Z0(final l0 l0, final int n, final int n2) {
        l0.n2(n, n2);
    }
    
    private static void Z1(final MediaItem mediaItem, final int n, final Listener listener) {
        listener.onMediaItemTransition(mediaItem, n);
    }
    
    static void a1(final l0 l0, final SurfaceTexture surfaceTexture) {
        l0.y2(surfaceTexture);
    }
    
    private static void a2(final m1 m1, final Listener listener) {
        listener.onPlayerErrorChanged(m1.f);
    }
    
    static void b1(final l0 l0) {
        l0.t2();
    }
    
    private static void b2(final m1 m1, final Listener listener) {
        listener.onPlayerError(m1.f);
    }
    
    static int c1(final boolean b, final int n) {
        return G1(b, n);
    }
    
    private static void c2(final m1 m1, final Listener listener) {
        listener.onTracksChanged(m1.i.d);
    }
    
    static void d1(final l0 l0, final boolean b, final int n, final int n2) {
        l0.E2(b, n, n2);
    }
    
    private static void d2(final MediaMetadata mediaMetadata, final Listener listener) {
        listener.onMediaMetadataChanged(mediaMetadata);
    }
    
    static StreamVolumeManager e1(final l0 l0) {
        return l0.B;
    }
    
    private static void e2(final m1 m1, final Listener listener) {
        listener.onLoadingChanged(m1.g);
        listener.onIsLoadingChanged(m1.g);
    }
    
    static DeviceInfo f1(final StreamVolumeManager streamVolumeManager) {
        return x1(streamVolumeManager);
    }
    
    private static void f2(final m1 m1, final Listener listener) {
        listener.onPlayerStateChanged(m1.l, m1.e);
    }
    
    static DeviceInfo g1(final l0 l0) {
        return l0.q0;
    }
    
    private static void g2(final m1 m1, final Listener listener) {
        listener.onPlaybackStateChanged(m1.e);
    }
    
    static DeviceInfo h1(final l0 l0, final DeviceInfo q0) {
        return l0.q0 = q0;
    }
    
    private static void h2(final m1 m1, final int n, final Listener listener) {
        listener.onPlayWhenReadyChanged(m1.l, n);
    }
    
    static void i1(final l0 l0) {
        l0.H2();
    }
    
    private static void i2(final m1 m1, final Listener listener) {
        listener.onPlaybackSuppressionReasonChanged(m1.m);
    }
    
    static DecoderCounters j1(final l0 l0, final DecoderCounters e0) {
        return l0.e0 = e0;
    }
    
    private static void j2(final m1 m1, final Listener listener) {
        listener.onIsPlayingChanged(M1(m1));
    }
    
    static AnalyticsCollector k1(final l0 l0) {
        return l0.r;
    }
    
    private static void k2(final m1 m1, final Listener listener) {
        listener.onPlaybackParametersChanged(m1.n);
    }
    
    static Format l1(final l0 l0, final Format r) {
        return l0.R = r;
    }
    
    private m1 l2(m1 m1, final Timeline timeline, final Pair<Object, Long> pair) {
        Assertions.a(timeline.u() || pair != null);
        final Timeline a = m1.a;
        final m1 i = m1.i(timeline);
        if (timeline.u()) {
            final MediaSource.MediaPeriodId k = m1.k();
            final long c0 = Util.C0(this.w0);
            m1 = i.c(k, c0, c0, c0, 0L, TrackGroupArray.d, this.b, (List<Metadata>)ImmutableList.of()).b(k);
            m1.p = m1.r;
            return m1;
        }
        final Object a2 = i.b.a;
        final boolean b = a2.equals(Util.j(pair).first) ^ true;
        MediaSource.MediaPeriodId b2;
        if (b) {
            b2 = new MediaSource.MediaPeriodId(pair.first);
        }
        else {
            b2 = i.b;
        }
        final long longValue = (long)pair.second;
        long c2;
        final long n = c2 = Util.C0(this.R());
        if (!a.u()) {
            c2 = n - a.l(a2, this.n).r();
        }
        if (!b) {
            final long n2 = lcmp(longValue, c2);
            if (n2 >= 0) {
                if (n2 == 0) {
                    final int f = timeline.f(i.k.a);
                    if (f != -1) {
                        m1 = i;
                        if (timeline.j(f, this.n).c == timeline.l(b2.a, this.n).c) {
                            return m1;
                        }
                    }
                    timeline.l(b2.a, this.n);
                    long p3;
                    if (b2.b()) {
                        p3 = this.n.e(b2.b, b2.c);
                    }
                    else {
                        p3 = this.n.d;
                    }
                    m1 = i.c(b2, i.r, i.r, i.d, p3 - i.r, i.h, i.i, i.j).b(b2);
                    m1.p = p3;
                }
                else {
                    Assertions.g(b2.b() ^ true);
                    final long max = Math.max(0L, i.q - (longValue - c2));
                    long p4 = i.p;
                    if (i.k.equals(i.b)) {
                        p4 = longValue + max;
                    }
                    m1 = i.c(b2, longValue, longValue, longValue, max, i.h, i.i, i.j);
                    m1.p = p4;
                }
                return m1;
            }
        }
        Assertions.g(b2.b() ^ true);
        TrackGroupArray trackGroupArray;
        if (b) {
            trackGroupArray = TrackGroupArray.d;
        }
        else {
            trackGroupArray = i.h;
        }
        TrackSelectorResult trackSelectorResult;
        if (b) {
            trackSelectorResult = this.b;
        }
        else {
            trackSelectorResult = i.i;
        }
        Object o;
        if (b) {
            o = ImmutableList.of();
        }
        else {
            o = i.j;
        }
        m1 = i.c(b2, longValue, longValue, longValue, 0L, trackGroupArray, trackSelectorResult, (List<Metadata>)o).b(b2);
        m1.p = longValue;
        return m1;
    }
    
    static VideoSize m1(final l0 l0, final VideoSize r0) {
        return l0.r0 = r0;
    }
    
    private Pair<Object, Long> m2(final Timeline timeline, final int u0, long e) {
        if (timeline.u()) {
            this.u0 = u0;
            long w0 = e;
            if (e == -9223372036854775807L) {
                w0 = 0L;
            }
            this.w0 = w0;
            this.v0 = 0;
            return null;
        }
        int e2;
        if (u0 == -1 || (e2 = u0) >= timeline.t()) {
            e2 = timeline.e(this.G);
            e = timeline.r(e2, super.a).e();
        }
        return timeline.n(super.a, this.n, e2, Util.C0(e));
    }
    
    static ListenerSet n1(final l0 l0) {
        return l0.l;
    }
    
    private void n2(final int c0, final int d0) {
        if (c0 != this.c0 || d0 != this.d0) {
            this.c0 = c0;
            this.d0 = d0;
            this.l.l(24, new e0(c0, d0));
        }
    }
    
    static Object o1(final l0 l0) {
        return l0.U;
    }
    
    private long o2(final Timeline timeline, final MediaSource.MediaPeriodId mediaPeriodId, final long n) {
        timeline.l(mediaPeriodId.a, this.n);
        return n + this.n.r();
    }
    
    static DecoderCounters p1(final l0 l0, final DecoderCounters f0) {
        return l0.f0 = f0;
    }
    
    private m1 p2(final int n, final int n2) {
        final boolean b = false;
        Assertions.a(n >= 0 && n2 >= n && n2 <= this.o.size());
        final int y = this.Y();
        final Timeline w = this.w();
        final int size = this.o.size();
        ++this.H;
        this.q2(n, n2);
        final Timeline y2 = this.y1();
        final m1 l2 = this.l2(this.t0, y2, this.F1(w, y2));
        final int e = l2.e;
        int n3 = b ? 1 : 0;
        if (e != 1) {
            n3 = (b ? 1 : 0);
            if (e != 4) {
                n3 = (b ? 1 : 0);
                if (n < n2) {
                    n3 = (b ? 1 : 0);
                    if (n2 == size) {
                        n3 = (b ? 1 : 0);
                        if (y >= l2.a.t()) {
                            n3 = 1;
                        }
                    }
                }
            }
        }
        m1 g = l2;
        if (n3 != 0) {
            g = l2.g(4);
        }
        this.k.n0(n, n2, this.M);
        return g;
    }
    
    public static void q0(final TrackSelectionParameters trackSelectionParameters, final Listener listener) {
        U1(trackSelectionParameters, listener);
    }
    
    private void q2(final int n, final int n2) {
        for (int i = n2 - 1; i >= n; --i) {
            this.o.remove(i);
        }
        this.M = this.M.a(n, n2);
    }
    
    public static void r0(final boolean b, final Listener listener) {
        T1(b, listener);
    }
    
    private void r2() {
        if (this.X != null) {
            this.A1(this.y).n(10000).m(null).l();
            this.X.i((SphericalGLSurfaceView.VideoSurfaceListener)this.x);
            this.X = null;
        }
        final TextureView z = this.Z;
        if (z != null) {
            if (z.getSurfaceTextureListener() != this.x) {
                Log.i("ExoPlayerImpl", "SurfaceTextureListener already unset or replaced.");
            }
            else {
                this.Z.setSurfaceTextureListener((TextureView$SurfaceTextureListener)null);
            }
            this.Z = null;
        }
        final SurfaceHolder w = this.W;
        if (w != null) {
            w.removeCallback((SurfaceHolder$Callback)this.x);
            this.W = null;
        }
    }
    
    public static void s0(final m1 m1, final Listener listener) {
        a2(m1, listener);
    }
    
    private List<MediaSourceList.c> s1(final int n, final List<MediaSource> list) {
        final ArrayList list2 = new ArrayList();
        for (int i = 0; i < list.size(); ++i) {
            final MediaSourceList.c c = new MediaSourceList.c(list.get(i), this.p);
            list2.add(c);
            this.o.add(i + n, new e(c.b, c.a.D0()));
        }
        this.M = this.M.g(n, list2.size());
        return list2;
    }
    
    private void s2(final int n, final int n2, final Object o) {
        for (final Renderer renderer : this.g) {
            if (renderer.f() == n) {
                this.A1(renderer).n(n2).m(o).l();
            }
        }
    }
    
    public static void t0(final l0 l0, final Listener listener, final FlagSet set) {
        l0.O1(listener, set);
    }
    
    private void t2() {
        this.s2(1, 2, this.i0 * this.A.g());
    }
    
    public static void u0(final float n, final Listener listener) {
        V1(n, listener);
    }
    
    private MediaMetadata u1() {
        final Timeline w = this.w();
        if (w.u()) {
            return this.s0;
        }
        return this.s0.b().H(w.r(this.Y(), super.a).c.e).F();
    }
    
    public static void v0(final m1 m1, final Listener listener) {
        g2(m1, listener);
    }
    
    public static void w0(final m1 m1, final Listener listener) {
        c2(m1, listener);
    }
    
    private void w2(final List<MediaSource> list, int e, long n, final boolean b) {
        final int e2 = this.E1();
        final long g0 = this.g0();
        final int h = this.H;
        final boolean b2 = true;
        this.H = h + 1;
        if (!this.o.isEmpty()) {
            this.q2(0, this.o.size());
        }
        final List<MediaSourceList.c> s1 = this.s1(0, list);
        final Timeline y1 = this.y1();
        if (!y1.u() && e >= y1.t()) {
            throw new IllegalSeekPositionException(y1, e, n);
        }
        if (b) {
            e = y1.e(this.G);
            n = -9223372036854775807L;
        }
        else if (e == -1) {
            e = e2;
            n = g0;
        }
        final m1 l2 = this.l2(this.t0, y1, this.m2(y1, e, n));
        int e3 = l2.e;
        if (e != -1 && (e3 = e3) != 1) {
            if (!y1.u() && e < y1.t()) {
                e3 = 2;
            }
            else {
                e3 = 4;
            }
        }
        final m1 g2 = l2.g(e3);
        this.k.M0(s1, e, Util.C0(n), this.M);
        this.F2(g2, 0, 1, false, !this.t0.b.a.equals(g2.b.a) && !this.t0.a.u() && b2, 4, this.D1(g2), -1);
    }
    
    public static void x0(final int n, final int n2, final Listener listener) {
        N1(n, n2, listener);
    }
    
    private static DeviceInfo x1(final StreamVolumeManager streamVolumeManager) {
        return new DeviceInfo(0, streamVolumeManager.d(), streamVolumeManager.c());
    }
    
    private void x2(final SurfaceHolder w) {
        this.Y = false;
        (this.W = w).addCallback((SurfaceHolder$Callback)this.x);
        final Surface surface = this.W.getSurface();
        if (surface != null && surface.isValid()) {
            final Rect surfaceFrame = this.W.getSurfaceFrame();
            this.n2(surfaceFrame.width(), surfaceFrame.height());
        }
        else {
            this.n2(0, 0);
        }
    }
    
    public static void y0(final m1 m1, final Listener listener) {
        i2(m1, listener);
    }
    
    private Timeline y1() {
        return new q1(this.o, this.M);
    }
    
    private void y2(final SurfaceTexture surfaceTexture) {
        final Surface v = new Surface(surfaceTexture);
        this.z2(v);
        this.V = v;
    }
    
    public static void z0(final m1 m1, final Listener listener) {
        k2(m1, listener);
    }
    
    private List<MediaSource> z1(final List<MediaItem> list) {
        final ArrayList list2 = new ArrayList();
        for (int i = 0; i < list.size(); ++i) {
            list2.add(this.q.a((MediaItem)list.get(i)));
        }
        return list2;
    }
    
    private void z2(final Object o) {
        final ArrayList list = new ArrayList();
        final Renderer[] g = this.g;
        final int length = g.length;
        int n = 0;
        while (true) {
            if (n >= length) {
                break;
            }
            final Renderer renderer = g[n];
            if (renderer.f() == 2) {
                list.add(this.A1(renderer).n(1).m(o).l());
            }
            ++n;
        }
        final Object u = this.U;
        if (u == null || u == o) {
            goto Label_0181;
        }
        try {
            final Iterator iterator = list.iterator();
            while (iterator.hasNext()) {
                ((PlayerMessage)iterator.next()).a(this.E);
            }
            goto Label_0143;
        }
        catch (final InterruptedException ex) {
            Thread.currentThread().interrupt();
        }
        catch (final TimeoutException ex2) {
            goto Label_0145;
        }
    }
    
    @Override
    public void A(final TextureView z) {
        this.I2();
        if (z == null) {
            this.v1();
        }
        else {
            this.r2();
            this.Z = z;
            if (z.getSurfaceTextureListener() != null) {
                Log.i("ExoPlayerImpl", "Replacing existing SurfaceTextureListener.");
            }
            z.setSurfaceTextureListener((TextureView$SurfaceTextureListener)this.x);
            SurfaceTexture surfaceTexture;
            if (z.isAvailable()) {
                surfaceTexture = z.getSurfaceTexture();
            }
            else {
                surfaceTexture = null;
            }
            if (surfaceTexture == null) {
                this.z2(null);
                this.n2(0, 0);
            }
            else {
                this.y2(surfaceTexture);
                this.n2(z.getWidth(), z.getHeight());
            }
        }
    }
    
    public void A2(final SurfaceHolder w) {
        this.I2();
        if (w == null) {
            this.v1();
        }
        else {
            this.r2();
            this.Y = true;
            (this.W = w).addCallback((SurfaceHolder$Callback)this.x);
            final Surface surface = w.getSurface();
            if (surface != null && surface.isValid()) {
                this.z2(surface);
                final Rect surfaceFrame = w.getSurfaceFrame();
                this.n2(surfaceFrame.width(), surfaceFrame.height());
            }
            else {
                this.z2(null);
                this.n2(0, 0);
            }
        }
    }
    
    @Override
    public void B(final int n, final long n2) {
        this.I2();
        this.r.z();
        final Timeline a = this.t0.a;
        if (n < 0 || (!a.u() && n >= a.t())) {
            throw new IllegalSeekPositionException(a, n, n2);
        }
        final int h = this.H;
        int n3 = 1;
        this.H = h + 1;
        if (this.e()) {
            Log.i("ExoPlayerImpl", "seekTo ignored because an ad is playing");
            final ExoPlayerImplInternal.PlaybackInfoUpdate playbackInfoUpdate = new ExoPlayerImplInternal.PlaybackInfoUpdate(this.t0);
            playbackInfoUpdate.b(1);
            this.j.a(playbackInfoUpdate);
            return;
        }
        if (this.getPlaybackState() != 1) {
            n3 = 2;
        }
        final int y = this.Y();
        final m1 l2 = this.l2(this.t0.g(n3), a, this.m2(a, n, n2));
        this.k.A0(a, n, Util.C0(n2));
        this.F2(l2, 0, 1, true, true, 1, this.D1(l2), y);
    }
    
    public void B2(final boolean b) {
        this.I2();
        this.A.p(this.E(), 1);
        this.C2(b, null);
        this.k0 = CueGroup.b;
    }
    
    @Override
    public Commands C() {
        this.I2();
        return this.O;
    }
    
    public boolean C1() {
        this.I2();
        return this.t0.o;
    }
    
    @Override
    public boolean E() {
        this.I2();
        return this.t0.l;
    }
    
    @Override
    public void F(final boolean g) {
        this.I2();
        if (this.G != g) {
            this.G = g;
            this.k.W0(g);
            this.l.i(9, new y(g));
            this.D2();
            this.l.f();
        }
    }
    
    @Override
    public long H() {
        this.I2();
        return 3000L;
    }
    
    @Override
    public int J() {
        this.I2();
        if (this.t0.a.u()) {
            return this.v0;
        }
        final m1 t0 = this.t0;
        return t0.a.f(t0.b.a);
    }
    
    @Override
    public void K(final TextureView textureView) {
        this.I2();
        if (textureView != null && textureView == this.Z) {
            this.v1();
        }
    }
    
    @Override
    public VideoSize L() {
        this.I2();
        return this.r0;
    }
    
    @Override
    public int N() {
        this.I2();
        int c;
        if (this.e()) {
            c = this.t0.b.c;
        }
        else {
            c = -1;
        }
        return c;
    }
    
    @Override
    public long Q() {
        this.I2();
        return this.v;
    }
    
    @Override
    public long R() {
        this.I2();
        if (this.e()) {
            final m1 t0 = this.t0;
            t0.a.l(t0.b.a, this.n);
            final m1 t2 = this.t0;
            long e;
            if (t2.c == -9223372036854775807L) {
                e = t2.a.r(this.Y(), super.a).e();
            }
            else {
                e = this.n.q() + Util.f1(this.t0.c);
            }
            return e;
        }
        return this.g0();
    }
    
    @Override
    public void S(final Listener listener) {
        Assertions.e(listener);
        this.l.c(listener);
    }
    
    @Override
    public void T(final int n, final List<MediaItem> list) {
        this.I2();
        this.t1(Math.min(n, this.o.size()), this.z1(list));
    }
    
    @Override
    public long U() {
        this.I2();
        if (this.e()) {
            final m1 t0 = this.t0;
            long n;
            if (t0.k.equals(t0.b)) {
                n = Util.f1(this.t0.p);
            }
            else {
                n = this.getDuration();
            }
            return n;
        }
        return this.c0();
    }
    
    @Override
    public void W(final TrackSelectionParameters trackSelectionParameters) {
        this.I2();
        if (this.h.e()) {
            if (!trackSelectionParameters.equals(this.h.b())) {
                this.h.j(trackSelectionParameters);
                this.l.l(19, new w(trackSelectionParameters));
            }
        }
    }
    
    @Override
    public int Y() {
        this.I2();
        int e1;
        if ((e1 = this.E1()) == -1) {
            e1 = 0;
        }
        return e1;
    }
    
    @Override
    public void Z(final SurfaceView surfaceView) {
        this.I2();
        SurfaceHolder holder;
        if (surfaceView == null) {
            holder = null;
        }
        else {
            holder = surfaceView.getHolder();
        }
        this.w1(holder);
    }
    
    @Override
    public ExoPlaybackException a() {
        this.I2();
        return this.t0.f;
    }
    
    @Override
    public /* bridge */ PlaybackException a() {
        return this.a();
    }
    
    @Override
    public PlaybackParameters b() {
        this.I2();
        return this.t0.n;
    }
    
    @Override
    public boolean b0() {
        this.I2();
        return this.G;
    }
    
    @Override
    public void c(final MediaSource mediaSource) {
        this.I2();
        this.u2(Collections.singletonList(mediaSource));
    }
    
    @Override
    public long c0() {
        this.I2();
        if (this.t0.a.u()) {
            return this.w0;
        }
        final m1 t0 = this.t0;
        if (t0.k.d != t0.b.d) {
            return t0.a.r(this.Y(), super.a).g();
        }
        long n = t0.p;
        if (this.t0.k.b()) {
            final m1 t2 = this.t0;
            final Timeline.Period l = t2.a.l(t2.k.a, this.n);
            n = l.i(this.t0.k.b);
            if (n == Long.MIN_VALUE) {
                n = l.d;
            }
        }
        final m1 t3 = this.t0;
        return Util.f1(this.o2(t3.a, t3.k, n));
    }
    
    @Override
    public void d(final PlaybackParameters playbackParameters) {
        this.I2();
        PlaybackParameters d = playbackParameters;
        if (playbackParameters == null) {
            d = PlaybackParameters.d;
        }
        if (this.t0.n.equals(d)) {
            return;
        }
        final m1 f = this.t0.f(d);
        ++this.H;
        this.k.R0(d);
        this.F2(f, 0, 1, false, false, 5, -9223372036854775807L, -1);
    }
    
    @Override
    public boolean e() {
        this.I2();
        return this.t0.b.b();
    }
    
    @Override
    public long f() {
        this.I2();
        return Util.f1(this.t0.q);
    }
    
    @Override
    public MediaMetadata f0() {
        this.I2();
        return this.P;
    }
    
    @Override
    public void g(final Listener listener) {
        Assertions.e(listener);
        this.l.k(listener);
    }
    
    @Override
    public long g0() {
        this.I2();
        return Util.f1(this.D1(this.t0));
    }
    
    @Override
    public long getDuration() {
        this.I2();
        if (this.e()) {
            final m1 t0 = this.t0;
            final MediaSource.MediaPeriodId b = t0.b;
            t0.a.l(b.a, this.n);
            return Util.f1(this.n.e(b.b, b.c));
        }
        return this.I();
    }
    
    @Override
    public int getPlaybackState() {
        this.I2();
        return this.t0.e;
    }
    
    @Override
    public int getRepeatMode() {
        this.I2();
        return this.F;
    }
    
    @Override
    public long h0() {
        this.I2();
        return this.u;
    }
    
    @Override
    public void i(final List<MediaItem> list, final boolean b) {
        this.I2();
        this.v2(this.z1(list), b);
    }
    
    @Override
    public void j(final SurfaceView surfaceView) {
        this.I2();
        if (surfaceView instanceof VideoDecoderOutputBufferRenderer) {
            this.r2();
            this.z2(surfaceView);
            this.x2(surfaceView.getHolder());
        }
        else if (surfaceView instanceof SphericalGLSurfaceView) {
            this.r2();
            this.X = (SphericalGLSurfaceView)surfaceView;
            this.A1(this.y).n(10000).m(this.X).l();
            this.X.d((SphericalGLSurfaceView.VideoSurfaceListener)this.x);
            this.z2(this.X.getVideoSurface());
            this.x2(surfaceView.getHolder());
        }
        else {
            SurfaceHolder holder;
            if (surfaceView == null) {
                holder = null;
            }
            else {
                holder = surfaceView.getHolder();
            }
            this.A2(holder);
        }
    }
    
    @Override
    public void m(final int n, final int n2) {
        this.I2();
        final m1 p2 = this.p2(n, Math.min(n2, this.o.size()));
        this.F2(p2, 0, 1, false, p2.b.a.equals(this.t0.b.a) ^ true, 4, this.D1(p2), -1);
    }
    
    @Override
    public void o(final boolean b) {
        this.I2();
        final int p = this.A.p(b, this.getPlaybackState());
        this.E2(b, p, G1(b, p));
    }
    
    @Override
    public Tracks p() {
        this.I2();
        return this.t0.i.d;
    }
    
    @Override
    public void prepare() {
        this.I2();
        final boolean e = this.E();
        final AudioFocusManager a = this.A;
        int n = 2;
        final int p = a.p(e, 2);
        this.E2(e, p, G1(e, p));
        final m1 t0 = this.t0;
        if (t0.e != 1) {
            return;
        }
        final m1 e2 = t0.e(null);
        if (e2.a.u()) {
            n = 4;
        }
        final m1 g = e2.g(n);
        ++this.H;
        this.k.i0();
        this.F2(g, 1, 1, false, false, 5, -9223372036854775807L, -1);
    }
    
    public void q1(final AnalyticsListener analyticsListener) {
        Assertions.e(analyticsListener);
        this.r.J(analyticsListener);
    }
    
    @Override
    public CueGroup r() {
        this.I2();
        return this.k0;
    }
    
    public void r1(final AudioOffloadListener audioOffloadListener) {
        this.m.add(audioOffloadListener);
    }
    
    @Override
    public void release() {
        final StringBuilder sb = new StringBuilder();
        sb.append("Release ");
        sb.append(Integer.toHexString(System.identityHashCode(this)));
        sb.append(" [");
        sb.append("ExoPlayerLib/2.18.1");
        sb.append("] [");
        sb.append(Util.e);
        sb.append("] [");
        sb.append(ExoPlayerLibraryInfo.b());
        sb.append("]");
        Log.f("ExoPlayerImpl", sb.toString());
        this.I2();
        if (Util.a < 21) {
            final AudioTrack t = this.T;
            if (t != null) {
                t.release();
                this.T = null;
            }
        }
        this.z.b(false);
        this.B.g();
        this.C.b(false);
        this.D.b(false);
        this.A.i();
        if (!this.k.k0()) {
            this.l.l(10, com.google.android.exoplayer2.z.a);
        }
        this.l.j();
        this.i.f(null);
        this.t.d((BandwidthMeter.EventListener)this.r);
        final m1 g = this.t0.g(1);
        this.t0 = g;
        final m1 b = g.b(g.b);
        this.t0 = b;
        b.p = b.r;
        this.t0.q = 0L;
        this.r.release();
        this.h.g();
        this.r2();
        final Surface v = this.V;
        if (v != null) {
            v.release();
            this.V = null;
        }
        if (this.o0) {
            Assertions.e(this.n0).d(0);
            this.o0 = false;
        }
        this.k0 = CueGroup.b;
        this.p0 = true;
    }
    
    @Override
    public int s() {
        this.I2();
        int b;
        if (this.e()) {
            b = this.t0.b.b;
        }
        else {
            b = -1;
        }
        return b;
    }
    
    @Override
    public void setRepeatMode(final int f) {
        this.I2();
        if (this.F != f) {
            this.F = f;
            this.k.T0(f);
            this.l.i(8, new d0(f));
            this.D2();
            this.l.f();
        }
    }
    
    @Override
    public void setVolume(float p) {
        this.I2();
        p = Util.p(p, 0.0f, 1.0f);
        if (this.i0 == p) {
            return;
        }
        this.i0 = p;
        this.t2();
        this.l.l(22, new x(p));
    }
    
    @Override
    public void stop() {
        this.I2();
        this.B2(false);
    }
    
    public void t1(final int n, final List<MediaSource> list) {
        this.I2();
        Assertions.a(n >= 0);
        final Timeline w = this.w();
        ++this.H;
        final List<MediaSourceList.c> s1 = this.s1(n, list);
        final Timeline y1 = this.y1();
        final m1 l2 = this.l2(this.t0, y1, this.F1(w, y1));
        this.k.i(n, s1, this.M);
        this.F2(l2, 0, 1, false, false, 5, -9223372036854775807L, -1);
    }
    
    public void u2(final List<MediaSource> list) {
        this.I2();
        this.v2(list, true);
    }
    
    @Override
    public int v() {
        this.I2();
        return this.t0.m;
    }
    
    public void v1() {
        this.I2();
        this.r2();
        this.z2(null);
        this.n2(0, 0);
    }
    
    public void v2(final List<MediaSource> list, final boolean b) {
        this.I2();
        this.w2(list, -1, -9223372036854775807L, b);
    }
    
    @Override
    public Timeline w() {
        this.I2();
        return this.t0.a;
    }
    
    public void w1(final SurfaceHolder surfaceHolder) {
        this.I2();
        if (surfaceHolder != null && surfaceHolder == this.W) {
            this.v1();
        }
    }
    
    @Override
    public Looper x() {
        return this.s;
    }
    
    @Override
    public TrackSelectionParameters y() {
        this.I2();
        return this.h.b();
    }
    
    private static final class b
    {
        public static PlayerId a(final Context context, final l0 l0, final boolean b) {
            final MediaMetricsListener b2 = MediaMetricsListener.B0(context);
            if (b2 == null) {
                Log.i("ExoPlayerImpl", "MediaMetricsService unavailable.");
                return new PlayerId(LogSessionId.LOG_SESSION_ID_NONE);
            }
            if (b) {
                l0.q1(b2);
            }
            return new PlayerId(b2.I0());
        }
    }
    
    private final class c implements VideoRendererEventListener, AudioRendererEventListener, TextOutput, MetadataOutput, SurfaceHolder$Callback, TextureView$SurfaceTextureListener, VideoSurfaceListener, PlayerControl, EventListener, StreamVolumeManager.Listener, AudioOffloadListener
    {
        final l0 a;
        
        private c(final l0 a) {
            this.a = a;
        }
        
        c(final l0 l0, final l0$a object) {
            this(l0);
        }
        
        public static void C(final Metadata metadata, final Player.Listener listener) {
            N(metadata, listener);
        }
        
        public static void D(final VideoSize videoSize, final Player.Listener listener) {
            R(videoSize, listener);
        }
        
        public static void E(final int n, final boolean b, final Player.Listener listener) {
            Q(n, b, listener);
        }
        
        public static void F(final CueGroup cueGroup, final Player.Listener listener) {
            L(cueGroup, listener);
        }
        
        public static void G(final List list, final Player.Listener listener) {
            K(list, listener);
        }
        
        public static void H(final c c, final Player.Listener listener) {
            c.M(listener);
        }
        
        public static void I(final DeviceInfo deviceInfo, final Player.Listener listener) {
            P(deviceInfo, listener);
        }
        
        public static void J(final boolean b, final Player.Listener listener) {
            O(b, listener);
        }
        
        private static void K(final List list, final Player.Listener listener) {
            listener.onCues(list);
        }
        
        private static void L(final CueGroup cueGroup, final Player.Listener listener) {
            listener.onCues(cueGroup);
        }
        
        private void M(final Player.Listener listener) {
            listener.onMediaMetadataChanged(com.google.android.exoplayer2.l0.V0(this.a));
        }
        
        private static void N(final Metadata metadata, final Player.Listener listener) {
            listener.onMetadata(metadata);
        }
        
        private static void O(final boolean b, final Player.Listener listener) {
            listener.onSkipSilenceEnabledChanged(b);
        }
        
        private static void P(final DeviceInfo deviceInfo, final Player.Listener listener) {
            listener.onDeviceInfoChanged(deviceInfo);
        }
        
        private static void Q(final int n, final boolean b, final Player.Listener listener) {
            listener.onDeviceVolumeChanged(n, b);
        }
        
        private static void R(final VideoSize videoSize, final Player.Listener listener) {
            listener.onVideoSizeChanged(videoSize);
        }
        
        public void A(final int n) {
            final boolean e = this.a.E();
            com.google.android.exoplayer2.l0.d1(this.a, e, n, com.google.android.exoplayer2.l0.c1(e, n));
        }
        
        @Override
        public void a(final Exception ex) {
            com.google.android.exoplayer2.l0.k1(this.a).a(ex);
        }
        
        @Override
        public void b(final String s) {
            com.google.android.exoplayer2.l0.k1(this.a).b(s);
        }
        
        @Override
        public void c(final DecoderCounters decoderCounters) {
            com.google.android.exoplayer2.l0.p1(this.a, decoderCounters);
            com.google.android.exoplayer2.l0.k1(this.a).c(decoderCounters);
        }
        
        @Override
        public void d(final String s, final long n, final long n2) {
            com.google.android.exoplayer2.l0.k1(this.a).d(s, n, n2);
        }
        
        @Override
        public void e(final String s) {
            com.google.android.exoplayer2.l0.k1(this.a).e(s);
        }
        
        @Override
        public void f(final String s, final long n, final long n2) {
            com.google.android.exoplayer2.l0.k1(this.a).f(s, n, n2);
        }
        
        @Override
        public void g(final Format format, final DecoderReuseEvaluation decoderReuseEvaluation) {
            com.google.android.exoplayer2.l0.l1(this.a, format);
            com.google.android.exoplayer2.l0.k1(this.a).g(format, decoderReuseEvaluation);
        }
        
        @Override
        public void h(final long n) {
            com.google.android.exoplayer2.l0.k1(this.a).h(n);
        }
        
        @Override
        public void i(final Exception ex) {
            com.google.android.exoplayer2.l0.k1(this.a).i(ex);
        }
        
        @Override
        public void j(final DecoderCounters decoderCounters) {
            com.google.android.exoplayer2.l0.k1(this.a).j(decoderCounters);
            com.google.android.exoplayer2.l0.l1(this.a, null);
            com.google.android.exoplayer2.l0.j1(this.a, null);
        }
        
        public void k(final int n) {
            final DeviceInfo f1 = com.google.android.exoplayer2.l0.f1(com.google.android.exoplayer2.l0.e1(this.a));
            if (!f1.equals(com.google.android.exoplayer2.l0.g1(this.a))) {
                com.google.android.exoplayer2.l0.h1(this.a, f1);
                com.google.android.exoplayer2.l0.n1(this.a).l(29, (ListenerSet.Event)new n0(f1));
            }
        }
        
        @Override
        public void l(final DecoderCounters decoderCounters) {
            com.google.android.exoplayer2.l0.k1(this.a).l(decoderCounters);
            com.google.android.exoplayer2.l0.O0(this.a, null);
            com.google.android.exoplayer2.l0.p1(this.a, null);
        }
        
        @Override
        public void m(final int n, final long n2) {
            com.google.android.exoplayer2.l0.k1(this.a).m(n, n2);
        }
        
        @Override
        public void n(final Format format, final DecoderReuseEvaluation decoderReuseEvaluation) {
            com.google.android.exoplayer2.l0.O0(this.a, format);
            com.google.android.exoplayer2.l0.k1(this.a).n(format, decoderReuseEvaluation);
        }
        
        @Override
        public void o(final Object o, final long n) {
            com.google.android.exoplayer2.l0.k1(this.a).o(o, n);
            if (com.google.android.exoplayer2.l0.o1(this.a) == o) {
                com.google.android.exoplayer2.l0.n1(this.a).l(26, (ListenerSet.Event)com.google.android.exoplayer2.u0.a);
            }
        }
        
        @Override
        public void onCues(final CueGroup cueGroup) {
            com.google.android.exoplayer2.l0.R0(this.a, cueGroup);
            com.google.android.exoplayer2.l0.n1(this.a).l(27, (ListenerSet.Event)new q0(cueGroup));
        }
        
        @Override
        public void onCues(final List<Cue> list) {
            com.google.android.exoplayer2.l0.n1(this.a).l(27, (ListenerSet.Event)new s0(list));
        }
        
        @Override
        public void onMetadata(final Metadata metadata) {
            final l0 a = this.a;
            com.google.android.exoplayer2.l0.T0(a, com.google.android.exoplayer2.l0.S0(a).b().I(metadata).F());
            final MediaMetadata u0 = com.google.android.exoplayer2.l0.U0(this.a);
            if (!u0.equals(com.google.android.exoplayer2.l0.V0(this.a))) {
                com.google.android.exoplayer2.l0.W0(this.a, u0);
                com.google.android.exoplayer2.l0.n1(this.a).i(14, (ListenerSet.Event)new o0(this));
            }
            com.google.android.exoplayer2.l0.n1(this.a).i(28, (ListenerSet.Event)new p0(metadata));
            com.google.android.exoplayer2.l0.n1(this.a).f();
        }
        
        @Override
        public void onSkipSilenceEnabledChanged(final boolean b) {
            if (com.google.android.exoplayer2.l0.P0(this.a) == b) {
                return;
            }
            com.google.android.exoplayer2.l0.Q0(this.a, b);
            com.google.android.exoplayer2.l0.n1(this.a).l(23, (ListenerSet.Event)new t0(b));
        }
        
        public void onSurfaceTextureAvailable(final SurfaceTexture surfaceTexture, final int n, final int n2) {
            com.google.android.exoplayer2.l0.a1(this.a, surfaceTexture);
            com.google.android.exoplayer2.l0.Z0(this.a, n, n2);
        }
        
        public boolean onSurfaceTextureDestroyed(final SurfaceTexture surfaceTexture) {
            com.google.android.exoplayer2.l0.Y0(this.a, null);
            com.google.android.exoplayer2.l0.Z0(this.a, 0, 0);
            return true;
        }
        
        public void onSurfaceTextureSizeChanged(final SurfaceTexture surfaceTexture, final int n, final int n2) {
            com.google.android.exoplayer2.l0.Z0(this.a, n, n2);
        }
        
        public void onSurfaceTextureUpdated(final SurfaceTexture surfaceTexture) {
        }
        
        @Override
        public void onVideoSizeChanged(final VideoSize videoSize) {
            com.google.android.exoplayer2.l0.m1(this.a, videoSize);
            com.google.android.exoplayer2.l0.n1(this.a).l(25, (ListenerSet.Event)new r0(videoSize));
        }
        
        @Override
        public void p(final DecoderCounters decoderCounters) {
            com.google.android.exoplayer2.l0.j1(this.a, decoderCounters);
            com.google.android.exoplayer2.l0.k1(this.a).p(decoderCounters);
        }
        
        @Override
        public void q(final Exception ex) {
            com.google.android.exoplayer2.l0.k1(this.a).q(ex);
        }
        
        @Override
        public void r(final int n, final long n2, final long n3) {
            com.google.android.exoplayer2.l0.k1(this.a).r(n, n2, n3);
        }
        
        @Override
        public void s(final long n, final int n2) {
            com.google.android.exoplayer2.l0.k1(this.a).s(n, n2);
        }
        
        public void surfaceChanged(final SurfaceHolder surfaceHolder, final int n, final int n2, final int n3) {
            com.google.android.exoplayer2.l0.Z0(this.a, n2, n3);
        }
        
        public void surfaceCreated(final SurfaceHolder surfaceHolder) {
            if (com.google.android.exoplayer2.l0.X0(this.a)) {
                com.google.android.exoplayer2.l0.Y0(this.a, surfaceHolder.getSurface());
            }
        }
        
        public void surfaceDestroyed(final SurfaceHolder surfaceHolder) {
            if (com.google.android.exoplayer2.l0.X0(this.a)) {
                com.google.android.exoplayer2.l0.Y0(this.a, null);
            }
            com.google.android.exoplayer2.l0.Z0(this.a, 0, 0);
        }
        
        public void t() {
            com.google.android.exoplayer2.l0.d1(this.a, false, -1, 3);
        }
        
        public void u(final Surface surface) {
            com.google.android.exoplayer2.l0.Y0(this.a, null);
        }
        
        public void v(final Surface surface) {
            com.google.android.exoplayer2.l0.Y0(this.a, surface);
        }
        
        public void w(final int n, final boolean b) {
            com.google.android.exoplayer2.l0.n1(this.a).l(30, (ListenerSet.Event)new m0(n, b));
        }
        
        public void y(final boolean b) {
            com.google.android.exoplayer2.l0.i1(this.a);
        }
        
        public void z(final float n) {
            com.google.android.exoplayer2.l0.b1(this.a);
        }
    }
    
    private static final class d implements VideoFrameMetadataListener, CameraMotionListener, Target
    {
        private VideoFrameMetadataListener a;
        private CameraMotionListener b;
        private VideoFrameMetadataListener c;
        private CameraMotionListener d;
        
        private d() {
        }
        
        d(final l0$a object) {
            this();
        }
        
        @Override
        public void a(final long n, final long n2, final Format format, final MediaFormat mediaFormat) {
            final VideoFrameMetadataListener c = this.c;
            if (c != null) {
                c.a(n, n2, format, mediaFormat);
            }
            final VideoFrameMetadataListener a = this.a;
            if (a != null) {
                a.a(n, n2, format, mediaFormat);
            }
        }
        
        @Override
        public void b(final long n, final float[] array) {
            final CameraMotionListener d = this.d;
            if (d != null) {
                d.b(n, array);
            }
            final CameraMotionListener b = this.b;
            if (b != null) {
                b.b(n, array);
            }
        }
        
        @Override
        public void d() {
            final CameraMotionListener d = this.d;
            if (d != null) {
                d.d();
            }
            final CameraMotionListener b = this.b;
            if (b != null) {
                b.d();
            }
        }
        
        @Override
        public void p(final int n, final Object o) {
            if (n != 7) {
                if (n != 8) {
                    if (n == 10000) {
                        final SphericalGLSurfaceView sphericalGLSurfaceView = (SphericalGLSurfaceView)o;
                        if (sphericalGLSurfaceView == null) {
                            this.c = null;
                            this.d = null;
                        }
                        else {
                            this.c = sphericalGLSurfaceView.getVideoFrameMetadataListener();
                            this.d = sphericalGLSurfaceView.getCameraMotionListener();
                        }
                    }
                }
                else {
                    this.b = (CameraMotionListener)o;
                }
            }
            else {
                this.a = (VideoFrameMetadataListener)o;
            }
        }
    }
    
    private static final class e implements i1
    {
        private final Object a;
        private Timeline b;
        
        public e(final Object a, final Timeline b) {
            this.a = a;
            this.b = b;
        }
        
        static Timeline c(final e e, final Timeline b) {
            return e.b = b;
        }
        
        @Override
        public Object a() {
            return this.a;
        }
        
        @Override
        public Timeline b() {
            return this.b;
        }
    }
}
