// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.exoplayer2.analytics;

import com.google.android.exoplayer2.source.MediaLoadData;
import com.google.android.exoplayer2.source.LoadEventInfo;
import com.google.android.exoplayer2.video.VideoSize;
import com.google.android.exoplayer2.decoder.DecoderCounters;
import android.media.metrics.LogSessionId;
import android.media.metrics.TrackChangeEvent$Builder;
import com.google.android.exoplayer2.source.MediaSource;
import android.media.metrics.PlaybackStateEvent$Builder;
import com.google.android.exoplayer2.Player;
import android.media.metrics.PlaybackErrorEvent$Builder;
import android.media.metrics.NetworkEvent$Builder;
import com.google.android.exoplayer2.MediaItem;
import android.util.Pair;
import android.media.MediaCodec$CryptoException;
import com.google.android.exoplayer2.audio.AudioSink;
import com.google.android.exoplayer2.mediacodec.MediaCodecDecoderException;
import com.google.android.exoplayer2.mediacodec.MediaCodecRenderer;
import java.net.SocketTimeoutException;
import java.net.UnknownHostException;
import com.google.android.exoplayer2.util.NetworkTypeObserver;
import android.system.OsConstants;
import android.system.ErrnoException;
import java.io.FileNotFoundException;
import com.google.android.exoplayer2.upstream.FileDataSource;
import com.google.android.exoplayer2.drm.DefaultDrmSessionManager;
import com.google.android.exoplayer2.drm.UnsupportedDrmException;
import android.media.DeniedByServerException;
import android.media.NotProvisionedException;
import android.media.MediaDrmResetException;
import android.media.MediaDrm$MediaDrmStateException;
import com.google.android.exoplayer2.drm.DrmSession;
import com.google.android.exoplayer2.upstream.UdpDataSource;
import com.google.android.exoplayer2.ParserException;
import com.google.android.exoplayer2.upstream.HttpDataSource;
import java.io.IOException;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.ExoPlaybackException;
import java.util.UUID;
import com.google.android.exoplayer2.C;
import com.google.common.collect.UnmodifiableIterator;
import com.google.android.exoplayer2.drm.DrmInitData;
import com.google.android.exoplayer2.Tracks;
import com.google.common.collect.ImmutableList;
import com.google.android.exoplayer2.util.Util;
import android.media.metrics.MediaMetricsManager;
import android.os.SystemClock;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.PlaybackException;
import android.media.metrics.PlaybackMetrics$Builder;
import java.util.HashMap;
import com.google.android.exoplayer2.Timeline;
import android.media.metrics.PlaybackSession;
import android.content.Context;

public final class MediaMetricsListener implements AnalyticsListener, Listener
{
    private boolean A;
    private final Context a;
    private final PlaybackSessionManager b;
    private final PlaybackSession c;
    private final long d;
    private final Timeline.Window e;
    private final Timeline.Period f;
    private final HashMap<String, Long> g;
    private final HashMap<String, Long> h;
    private String i;
    private PlaybackMetrics$Builder j;
    private int k;
    private int l;
    private int m;
    private PlaybackException n;
    private b o;
    private b p;
    private b q;
    private Format r;
    private Format s;
    private Format t;
    private boolean u;
    private int v;
    private boolean w;
    private int x;
    private int y;
    private int z;
    
    private MediaMetricsListener(final Context context, final PlaybackSession c) {
        this.a = context.getApplicationContext();
        this.c = c;
        this.e = new Timeline.Window();
        this.f = new Timeline.Period();
        this.h = new HashMap<String, Long>();
        this.g = new HashMap<String, Long>();
        this.d = SystemClock.elapsedRealtime();
        this.l = 0;
        this.m = 0;
        (this.b = new DefaultPlaybackSessionManager()).b((PlaybackSessionManager.Listener)this);
    }
    
    private boolean A0(final b b) {
        return b != null && b.c.equals(this.b.a());
    }
    
    public static MediaMetricsListener B0(final Context context) {
        final MediaMetricsManager mediaMetricsManager = (MediaMetricsManager)context.getSystemService("media_metrics");
        MediaMetricsListener mediaMetricsListener;
        if (mediaMetricsManager == null) {
            mediaMetricsListener = null;
        }
        else {
            mediaMetricsListener = new MediaMetricsListener(context, mediaMetricsManager.createPlaybackSession());
        }
        return mediaMetricsListener;
    }
    
    private void C0() {
        final PlaybackMetrics$Builder j = this.j;
        if (j != null && this.A) {
            j.setAudioUnderrunCount(this.z);
            this.j.setVideoFramesDropped(this.x);
            this.j.setVideoFramesPlayed(this.y);
            final Long n = this.g.get(this.i);
            final PlaybackMetrics$Builder i = this.j;
            long longValue;
            if (n == null) {
                longValue = 0L;
            }
            else {
                longValue = n;
            }
            i.setNetworkTransferDurationMillis(longValue);
            final Long n2 = this.h.get(this.i);
            final PlaybackMetrics$Builder k = this.j;
            long longValue2;
            if (n2 == null) {
                longValue2 = 0L;
            }
            else {
                longValue2 = n2;
            }
            k.setNetworkBytesRead(longValue2);
            final PlaybackMetrics$Builder l = this.j;
            int streamSource;
            if (n2 != null && n2 > 0L) {
                streamSource = 1;
            }
            else {
                streamSource = 0;
            }
            l.setStreamSource(streamSource);
            this.c.reportPlaybackMetrics(this.j.build());
        }
        this.j = null;
        this.i = null;
        this.z = 0;
        this.x = 0;
        this.y = 0;
        this.r = null;
        this.s = null;
        this.t = null;
        this.A = false;
    }
    
    private static int D0(final int n) {
        switch (Util.V(n)) {
            default: {
                return 27;
            }
            case 6005: {
                return 26;
            }
            case 6004: {
                return 25;
            }
            case 6003: {
                return 28;
            }
            case 6002: {
                return 24;
            }
        }
    }
    
    private static DrmInitData E0(final ImmutableList<Tracks.Group> list) {
        for (final Tracks.Group group : list) {
            for (int i = 0; i < group.a; ++i) {
                if (group.h(i)) {
                    final DrmInitData z = group.c(i).z;
                    if (z != null) {
                        return z;
                    }
                }
            }
        }
        return null;
    }
    
    private static int F0(final DrmInitData drmInitData) {
        for (int i = 0; i < drmInitData.d; ++i) {
            final UUID b = drmInitData.e(i).b;
            if (b.equals(C.d)) {
                return 3;
            }
            if (b.equals(C.e)) {
                return 2;
            }
            if (b.equals(C.c)) {
                return 6;
            }
        }
        return 1;
    }
    
    private static a G0(final PlaybackException ex, final Context context, final boolean b) {
        if (ex.errorCode == 1001) {
            return new a(20, 0);
        }
        boolean b2;
        int rendererFormatSupport;
        if (ex instanceof ExoPlaybackException) {
            final ExoPlaybackException ex2 = (ExoPlaybackException)ex;
            b2 = (ex2.type == 1);
            rendererFormatSupport = ex2.rendererFormatSupport;
        }
        else {
            rendererFormatSupport = 0;
            b2 = false;
        }
        final Throwable t = Assertions.e(ex.getCause());
        if (t instanceof IOException) {
            if (t instanceof HttpDataSource.InvalidResponseCodeException) {
                return new a(5, ((HttpDataSource.InvalidResponseCodeException)t).responseCode);
            }
            if (t instanceof HttpDataSource.InvalidContentTypeException || t instanceof ParserException) {
                int n;
                if (b) {
                    n = 10;
                }
                else {
                    n = 11;
                }
                return new a(n, 0);
            }
            if (!(t instanceof HttpDataSource.HttpDataSourceException) && !(t instanceof UdpDataSource.UdpDataSourceException)) {
                if (ex.errorCode == 1002) {
                    return new a(21, 0);
                }
                if (t instanceof DrmSession.DrmSessionException) {
                    final Throwable t2 = Assertions.e(t.getCause());
                    final int a = Util.a;
                    if (a >= 21 && t2 instanceof MediaDrm$MediaDrmStateException) {
                        final int w = Util.W(((MediaDrm$MediaDrmStateException)t2).getDiagnosticInfo());
                        return new a(D0(w), w);
                    }
                    if (a >= 23 && t2 instanceof MediaDrmResetException) {
                        return new a(27, 0);
                    }
                    if (a >= 18 && t2 instanceof NotProvisionedException) {
                        return new a(24, 0);
                    }
                    if (a >= 18 && t2 instanceof DeniedByServerException) {
                        return new a(29, 0);
                    }
                    if (t2 instanceof UnsupportedDrmException) {
                        return new a(23, 0);
                    }
                    if (t2 instanceof DefaultDrmSessionManager.MissingSchemeDataException) {
                        return new a(28, 0);
                    }
                    return new a(30, 0);
                }
                else {
                    if (!(t instanceof FileDataSource.FileDataSourceException) || !(t.getCause() instanceof FileNotFoundException)) {
                        return new a(9, 0);
                    }
                    final Throwable cause = Assertions.e(t.getCause()).getCause();
                    if (Util.a >= 21 && cause instanceof ErrnoException && ((ErrnoException)cause).errno == OsConstants.EACCES) {
                        return new a(32, 0);
                    }
                    return new a(31, 0);
                }
            }
            else {
                if (NetworkTypeObserver.d(context).f() == 1) {
                    return new a(3, 0);
                }
                final Throwable cause2 = t.getCause();
                if (cause2 instanceof UnknownHostException) {
                    return new a(6, 0);
                }
                if (cause2 instanceof SocketTimeoutException) {
                    return new a(7, 0);
                }
                if (t instanceof HttpDataSource.HttpDataSourceException && ((HttpDataSource.HttpDataSourceException)t).type == 1) {
                    return new a(4, 0);
                }
                return new a(8, 0);
            }
        }
        else {
            if (b2 && (rendererFormatSupport == 0 || rendererFormatSupport == 1)) {
                return new a(35, 0);
            }
            if (b2 && rendererFormatSupport == 3) {
                return new a(15, 0);
            }
            if (b2 && rendererFormatSupport == 2) {
                return new a(23, 0);
            }
            if (t instanceof MediaCodecRenderer.DecoderInitializationException) {
                return new a(13, Util.W(((MediaCodecRenderer.DecoderInitializationException)t).diagnosticInfo));
            }
            if (t instanceof MediaCodecDecoderException) {
                return new a(14, Util.W(((MediaCodecDecoderException)t).diagnosticInfo));
            }
            if (t instanceof OutOfMemoryError) {
                return new a(14, 0);
            }
            if (t instanceof AudioSink.InitializationException) {
                return new a(17, ((AudioSink.InitializationException)t).audioTrackState);
            }
            if (t instanceof AudioSink.WriteException) {
                return new a(18, ((AudioSink.WriteException)t).errorCode);
            }
            if (Util.a >= 16 && t instanceof MediaCodec$CryptoException) {
                final int errorCode = ((MediaCodec$CryptoException)t).getErrorCode();
                return new a(D0(errorCode), errorCode);
            }
            return new a(22, 0);
        }
    }
    
    private static Pair<String, String> H0(String s) {
        final String[] t0 = Util.T0(s, "-");
        final String s2 = t0[0];
        if (t0.length >= 2) {
            s = t0[1];
        }
        else {
            s = null;
        }
        return (Pair<String, String>)Pair.create((Object)s2, (Object)s);
    }
    
    private static int J0(final Context context) {
        switch (NetworkTypeObserver.d(context).f()) {
            default: {
                return 1;
            }
            case 10: {
                return 7;
            }
            case 9: {
                return 8;
            }
            case 7: {
                return 3;
            }
            case 5: {
                return 6;
            }
            case 4: {
                return 5;
            }
            case 3: {
                return 4;
            }
            case 2: {
                return 2;
            }
            case 1: {
                return 9;
            }
            case 0: {
                return 0;
            }
        }
    }
    
    private static int K0(final MediaItem mediaItem) {
        final MediaItem.LocalConfiguration b = mediaItem.b;
        if (b == null) {
            return 0;
        }
        final int q0 = Util.q0(b.a, b.b);
        if (q0 == 0) {
            return 3;
        }
        if (q0 == 1) {
            return 5;
        }
        if (q0 != 2) {
            return 1;
        }
        return 4;
    }
    
    private static int L0(final int n) {
        if (n == 1) {
            return 2;
        }
        if (n == 2) {
            return 3;
        }
        if (n != 3) {
            return 1;
        }
        return 4;
    }
    
    private void M0(final Events events) {
        for (int i = 0; i < events.d(); ++i) {
            final int b = events.b(i);
            final EventTime c = events.c(b);
            if (b == 0) {
                this.b.g(c);
            }
            else if (b == 11) {
                this.b.f(c, this.k);
            }
            else {
                this.b.d(c);
            }
        }
    }
    
    private void N0(final long n) {
        final int j0 = J0(this.a);
        if (j0 != this.m) {
            this.m = j0;
            this.c.reportNetworkEvent(new NetworkEvent$Builder().setNetworkType(j0).setTimeSinceCreatedMillis(n - this.d).build());
        }
    }
    
    private void O0(final long n) {
        final PlaybackException n2 = this.n;
        if (n2 == null) {
            return;
        }
        final a g0 = G0(n2, this.a, this.v == 4);
        this.c.reportPlaybackErrorEvent(new PlaybackErrorEvent$Builder().setTimeSinceCreatedMillis(n - this.d).setErrorCode(g0.a).setSubErrorCode(g0.b).setException((Exception)n2).build());
        this.A = true;
        this.n = null;
    }
    
    private void P0(final Player player, final Events events, final long n) {
        if (player.getPlaybackState() != 2) {
            this.u = false;
        }
        if (player.a() == null) {
            this.w = false;
        }
        else if (events.a(10)) {
            this.w = true;
        }
        final int x0 = this.X0(player);
        if (this.l != x0) {
            this.l = x0;
            this.A = true;
            this.c.reportPlaybackStateEvent(new PlaybackStateEvent$Builder().setState(this.l).setTimeSinceCreatedMillis(n - this.d).build());
        }
    }
    
    private void Q0(final Player player, final Events events, final long n) {
        if (events.a(2)) {
            final Tracks p3 = player.p();
            final boolean d = p3.d(2);
            final boolean d2 = p3.d(1);
            final boolean d3 = p3.d(3);
            if (d || d2 || d3) {
                if (!d) {
                    this.V0(n, null, 0);
                }
                if (!d2) {
                    this.R0(n, null, 0);
                }
                if (!d3) {
                    this.T0(n, null, 0);
                }
            }
        }
        if (this.A0(this.o)) {
            final b o = this.o;
            final Format a = o.a;
            if (a.C != -1) {
                this.V0(n, a, o.b);
                this.o = null;
            }
        }
        if (this.A0(this.p)) {
            final b p4 = this.p;
            this.R0(n, p4.a, p4.b);
            this.p = null;
        }
        if (this.A0(this.q)) {
            final b q = this.q;
            this.T0(n, q.a, q.b);
            this.q = null;
        }
    }
    
    private void R0(final long n, final Format s, final int n2) {
        if (Util.c(this.s, s)) {
            return;
        }
        int n3 = n2;
        if (this.s == null && (n3 = n2) == 0) {
            n3 = 1;
        }
        this.W0(0, n, this.s = s, n3);
    }
    
    private void S0(final Player player, final Events events) {
        if (events.a(0)) {
            final EventTime c = events.c(0);
            if (this.j != null) {
                this.U0(c.b, c.d);
            }
        }
        if (events.a(2) && this.j != null) {
            final DrmInitData e0 = E0(player.p().b());
            if (e0 != null) {
                Util.j(this.j).setDrmType(F0(e0));
            }
        }
        if (events.a(1011)) {
            ++this.z;
        }
    }
    
    private void T0(final long n, final Format t, final int n2) {
        if (Util.c(this.t, t)) {
            return;
        }
        int n3 = n2;
        if (this.t == null && (n3 = n2) == 0) {
            n3 = 1;
        }
        this.W0(2, n, this.t = t, n3);
    }
    
    private void U0(final Timeline timeline, final MediaSource.MediaPeriodId mediaPeriodId) {
        final PlaybackMetrics$Builder j = this.j;
        if (mediaPeriodId == null) {
            return;
        }
        final int f = timeline.f(mediaPeriodId.a);
        if (f == -1) {
            return;
        }
        timeline.j(f, this.f);
        timeline.r(this.f.c, this.e);
        j.setStreamType(K0(this.e.c));
        final Timeline.Window e = this.e;
        if (e.y != -9223372036854775807L && !e.w && !e.i && !e.i()) {
            j.setMediaDurationMillis(this.e.g());
        }
        int playbackType;
        if (this.e.i()) {
            playbackType = 2;
        }
        else {
            playbackType = 1;
        }
        j.setPlaybackType(playbackType);
        this.A = true;
    }
    
    private void V0(final long n, final Format r, final int n2) {
        if (Util.c(this.r, r)) {
            return;
        }
        int n3 = n2;
        if (this.r == null && (n3 = n2) == 0) {
            n3 = 1;
        }
        this.W0(1, n, this.r = r, n3);
    }
    
    private void W0(int audioSampleRate, final long n, final Format format, final int n2) {
        final TrackChangeEvent$Builder setTimeSinceCreatedMillis = new TrackChangeEvent$Builder(audioSampleRate).setTimeSinceCreatedMillis(n - this.d);
        if (format != null) {
            setTimeSinceCreatedMillis.setTrackState(1);
            setTimeSinceCreatedMillis.setTrackChangeReason(L0(n2));
            final String p4 = format.p;
            if (p4 != null) {
                setTimeSinceCreatedMillis.setContainerMimeType(p4);
            }
            final String w = format.w;
            if (w != null) {
                setTimeSinceCreatedMillis.setSampleMimeType(w);
            }
            final String i = format.i;
            if (i != null) {
                setTimeSinceCreatedMillis.setCodecName(i);
            }
            audioSampleRate = format.h;
            if (audioSampleRate != -1) {
                setTimeSinceCreatedMillis.setBitrate(audioSampleRate);
            }
            audioSampleRate = format.B;
            if (audioSampleRate != -1) {
                setTimeSinceCreatedMillis.setWidth(audioSampleRate);
            }
            audioSampleRate = format.C;
            if (audioSampleRate != -1) {
                setTimeSinceCreatedMillis.setHeight(audioSampleRate);
            }
            audioSampleRate = format.J;
            if (audioSampleRate != -1) {
                setTimeSinceCreatedMillis.setChannelCount(audioSampleRate);
            }
            audioSampleRate = format.K;
            if (audioSampleRate != -1) {
                setTimeSinceCreatedMillis.setAudioSampleRate(audioSampleRate);
            }
            final String c = format.c;
            if (c != null) {
                final Pair<String, String> h0 = H0(c);
                setTimeSinceCreatedMillis.setLanguage((String)h0.first);
                final Object second = h0.second;
                if (second != null) {
                    setTimeSinceCreatedMillis.setLanguageRegion((String)second);
                }
            }
            final float d = format.D;
            if (d != -1.0f) {
                setTimeSinceCreatedMillis.setVideoFrameRate(d);
            }
        }
        else {
            setTimeSinceCreatedMillis.setTrackState(0);
        }
        this.A = true;
        this.c.reportTrackChangeEvent(setTimeSinceCreatedMillis.build());
    }
    
    private int X0(final Player player) {
        final int playbackState = player.getPlaybackState();
        if (this.u) {
            return 5;
        }
        if (this.w) {
            return 13;
        }
        if (playbackState == 4) {
            return 11;
        }
        if (playbackState == 2) {
            final int l = this.l;
            if (l == 0 || l == 2) {
                return 2;
            }
            if (!player.E()) {
                return 7;
            }
            int n;
            if (player.v() != 0) {
                n = 10;
            }
            else {
                n = 6;
            }
            return n;
        }
        else {
            int n2 = 3;
            if (playbackState == 3) {
                if (!player.E()) {
                    return 4;
                }
                if (player.v() != 0) {
                    n2 = 9;
                }
                return n2;
            }
            else {
                if (playbackState == 1 && this.l != 0) {
                    return 12;
                }
                return this.l;
            }
        }
    }
    
    public LogSessionId I0() {
        return this.c.getSessionId();
    }
    
    @Override
    public void J(final EventTime eventTime, final DecoderCounters decoderCounters) {
        this.x += decoderCounters.g;
        this.y += decoderCounters.e;
    }
    
    @Override
    public void L(final EventTime eventTime, final int n, long longValue, long longValue2) {
        final MediaSource.MediaPeriodId d = eventTime.d;
        if (d != null) {
            final String h = this.b.h(eventTime.b, Assertions.e(d));
            final Long n2 = this.h.get(h);
            final Long n3 = this.g.get(h);
            final HashMap<String, Long> h2 = this.h;
            final long n4 = 0L;
            if (n2 == null) {
                longValue2 = 0L;
            }
            else {
                longValue2 = n2;
            }
            h2.put(h, longValue2 + longValue);
            final HashMap<String, Long> g = this.g;
            if (n3 == null) {
                longValue = n4;
            }
            else {
                longValue = n3;
            }
            g.put(h, longValue + n);
        }
    }
    
    @Override
    public void S(final EventTime eventTime, final PlaybackException n) {
        this.n = n;
    }
    
    @Override
    public void d0(final EventTime eventTime, final VideoSize videoSize) {
        final b o = this.o;
        if (o != null) {
            final Format a = o.a;
            if (a.C == -1) {
                this.o = new b(a.b().j0(videoSize.a).Q(videoSize.b).E(), o.b, o.c);
            }
        }
    }
    
    @Override
    public void e0(final EventTime eventTime, final String s, final boolean b) {
        final MediaSource.MediaPeriodId d = eventTime.d;
        if (d == null || !d.b()) {
            if (s.equals(this.i)) {
                this.C0();
            }
        }
        this.g.remove(s);
        this.h.remove(s);
    }
    
    @Override
    public void f0(final EventTime eventTime, final String i) {
        final MediaSource.MediaPeriodId d = eventTime.d;
        if (d != null && d.b()) {
            return;
        }
        this.C0();
        this.i = i;
        this.j = new PlaybackMetrics$Builder().setPlayerName("ExoPlayerLib").setPlayerVersion("2.18.1");
        this.U0(eventTime.b, eventTime.d);
    }
    
    @Override
    public void k(final EventTime eventTime, final LoadEventInfo loadEventInfo, final MediaLoadData mediaLoadData, final IOException ex, final boolean b) {
        this.v = mediaLoadData.a;
    }
    
    @Override
    public void m0(final EventTime eventTime, final MediaLoadData mediaLoadData) {
        if (eventTime.d == null) {
            return;
        }
        final b o = new b(Assertions.e(mediaLoadData.c), mediaLoadData.d, this.b.h(eventTime.b, Assertions.e(eventTime.d)));
        final int b = mediaLoadData.b;
        if (b != 0) {
            if (b == 1) {
                this.p = o;
                return;
            }
            if (b != 2) {
                if (b != 3) {
                    return;
                }
                this.q = o;
                return;
            }
        }
        this.o = o;
    }
    
    @Override
    public void o(final Player player, final Events events) {
        if (events.d() == 0) {
            return;
        }
        this.M0(events);
        final long elapsedRealtime = SystemClock.elapsedRealtime();
        this.S0(player, events);
        this.O0(elapsedRealtime);
        this.Q0(player, events, elapsedRealtime);
        this.N0(elapsedRealtime);
        this.P0(player, events, elapsedRealtime);
        if (events.a(1028)) {
            this.b.c(events.c(1028));
        }
    }
    
    @Override
    public void p0(final EventTime eventTime, final Player.PositionInfo positionInfo, final Player.PositionInfo positionInfo2, final int k) {
        if (k == 1) {
            this.u = true;
        }
        this.k = k;
    }
    
    @Override
    public void r0(final EventTime eventTime, final String s) {
    }
    
    @Override
    public void z0(final EventTime eventTime, final String s, final String s2) {
    }
    
    private static final class a
    {
        public final int a;
        public final int b;
        
        public a(final int a, final int b) {
            this.a = a;
            this.b = b;
        }
    }
    
    private static final class b
    {
        public final Format a;
        public final int b;
        public final String c;
        
        public b(final Format a, final int b, final String c) {
            this.a = a;
            this.b = b;
            this.c = c;
        }
    }
}
