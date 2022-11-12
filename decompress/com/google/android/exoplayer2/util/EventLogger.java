// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.exoplayer2.util;

import java.util.List;
import java.util.AbstractCollection;
import com.google.android.exoplayer2.Player;
import java.io.IOException;
import com.google.android.exoplayer2.video.VideoSize;
import com.google.android.exoplayer2.PlaybackParameters;
import com.google.android.exoplayer2.source.MediaLoadData;
import com.google.android.exoplayer2.source.LoadEventInfo;
import com.google.android.exoplayer2.decoder.DecoderCounters;
import com.google.common.collect.ImmutableList;
import com.google.android.exoplayer2.Tracks;
import com.google.android.exoplayer2.MediaItem;
import com.google.android.exoplayer2.decoder.DecoderReuseEvaluation;
import com.google.android.exoplayer2.Format;
import android.text.TextUtils;
import com.google.android.exoplayer2.PlaybackException;
import com.google.android.exoplayer2.metadata.Metadata;
import android.os.SystemClock;
import java.util.Locale;
import com.google.android.exoplayer2.Timeline;
import java.text.NumberFormat;
import com.google.android.exoplayer2.analytics.AnalyticsListener;

public class EventLogger implements AnalyticsListener
{
    private static final NumberFormat e;
    private final String a;
    private final Timeline.Window b;
    private final Timeline.Period c;
    private final long d;
    
    static {
        final NumberFormat instance = NumberFormat.getInstance(Locale.US);
        (e = instance).setMinimumFractionDigits(2);
        instance.setMaximumFractionDigits(2);
        instance.setGroupingUsed(false);
    }
    
    public EventLogger() {
        this("EventLogger");
    }
    
    public EventLogger(final String a) {
        this.a = a;
        this.b = new Timeline.Window();
        this.c = new Timeline.Period();
        this.d = SystemClock.elapsedRealtime();
    }
    
    private static String A0(final int n) {
        if (n == 1) {
            return "USER_REQUEST";
        }
        if (n == 2) {
            return "AUDIO_FOCUS_LOSS";
        }
        if (n == 3) {
            return "AUDIO_BECOMING_NOISY";
        }
        if (n == 4) {
            return "REMOTE";
        }
        if (n != 5) {
            return "?";
        }
        return "END_OF_MEDIA_ITEM";
    }
    
    private static String B0(final int n) {
        if (n == 0) {
            return "NONE";
        }
        if (n != 1) {
            return "?";
        }
        return "TRANSIENT_AUDIO_FOCUS_LOSS";
    }
    
    private static String C0(final int n) {
        if (n == 0) {
            return "OFF";
        }
        if (n == 1) {
            return "ONE";
        }
        if (n != 2) {
            return "?";
        }
        return "ALL";
    }
    
    private static String D0(final int n) {
        if (n == 1) {
            return "IDLE";
        }
        if (n == 2) {
            return "BUFFERING";
        }
        if (n == 3) {
            return "READY";
        }
        if (n != 4) {
            return "?";
        }
        return "ENDED";
    }
    
    private static String E0(final long n) {
        String format;
        if (n == -9223372036854775807L) {
            format = "?";
        }
        else {
            format = EventLogger.e.format(n / 1000.0f);
        }
        return format;
    }
    
    private static String F0(final int n) {
        if (n == 0) {
            return "PLAYLIST_CHANGED";
        }
        if (n != 1) {
            return "?";
        }
        return "SOURCE_UPDATE";
    }
    
    private static String G0(final boolean b) {
        String s;
        if (b) {
            s = "[X]";
        }
        else {
            s = "[ ]";
        }
        return s;
    }
    
    private void H0(final EventTime eventTime, final String s) {
        this.J0(this.f0(eventTime, s, null, null));
    }
    
    private void I0(final EventTime eventTime, final String s, final String s2) {
        this.J0(this.f0(eventTime, s, s2, null));
    }
    
    private void K0(final EventTime eventTime, final String s, final String s2, final Throwable t) {
        this.M0(this.f0(eventTime, s, s2, t));
    }
    
    private void L0(final EventTime eventTime, final String s, final Throwable t) {
        this.M0(this.f0(eventTime, s, null, t));
    }
    
    private void N0(final EventTime eventTime, final String s, final Exception ex) {
        this.K0(eventTime, "internalError", s, ex);
    }
    
    private void O0(final Metadata metadata, final String s) {
        for (int i = 0; i < metadata.d(); ++i) {
            final StringBuilder sb = new StringBuilder();
            sb.append(s);
            sb.append(metadata.c(i));
            this.J0(sb.toString());
        }
    }
    
    private static String e0(final int n) {
        if (n == 0) {
            return "AUTO_TRANSITION";
        }
        if (n == 1) {
            return "SEEK";
        }
        if (n == 2) {
            return "SEEK_ADJUSTMENT";
        }
        if (n == 3) {
            return "SKIP";
        }
        if (n == 4) {
            return "REMOVE";
        }
        if (n != 5) {
            return "?";
        }
        return "INTERNAL";
    }
    
    private String f0(final EventTime eventTime, String s, String e, final Throwable t) {
        final StringBuilder sb = new StringBuilder();
        sb.append(s);
        sb.append(" [");
        sb.append(this.r0(eventTime));
        final String s2 = s = sb.toString();
        if (t instanceof PlaybackException) {
            final StringBuilder sb2 = new StringBuilder();
            sb2.append(s2);
            sb2.append(", errorCode=");
            sb2.append(((PlaybackException)t).getErrorCodeName());
            s = sb2.toString();
        }
        String string = s;
        if (e != null) {
            final StringBuilder sb3 = new StringBuilder();
            sb3.append(s);
            sb3.append(", ");
            sb3.append(e);
            string = sb3.toString();
        }
        e = Log.e(t);
        s = string;
        if (!TextUtils.isEmpty((CharSequence)e)) {
            final StringBuilder sb4 = new StringBuilder();
            sb4.append(string);
            sb4.append("\n  ");
            sb4.append(e.replace("\n", "\n  "));
            sb4.append('\n');
            s = sb4.toString();
        }
        final StringBuilder sb5 = new StringBuilder();
        sb5.append(s);
        sb5.append("]");
        return sb5.toString();
    }
    
    private String r0(final EventTime eventTime) {
        final StringBuilder sb = new StringBuilder();
        sb.append("window=");
        sb.append(eventTime.c);
        String s = sb.toString();
        if (eventTime.d != null) {
            final StringBuilder sb2 = new StringBuilder();
            sb2.append(s);
            sb2.append(", period=");
            sb2.append(eventTime.b.f(eventTime.d.a));
            final String s2 = s = sb2.toString();
            if (eventTime.d.b()) {
                final StringBuilder sb3 = new StringBuilder();
                sb3.append(s2);
                sb3.append(", adGroup=");
                sb3.append(eventTime.d.b);
                final String string = sb3.toString();
                final StringBuilder sb4 = new StringBuilder();
                sb4.append(string);
                sb4.append(", ad=");
                sb4.append(eventTime.d.c);
                s = sb4.toString();
            }
        }
        final StringBuilder sb5 = new StringBuilder();
        sb5.append("eventTime=");
        sb5.append(E0(eventTime.a - this.d));
        sb5.append(", mediaPos=");
        sb5.append(E0(eventTime.e));
        sb5.append(", ");
        sb5.append(s);
        return sb5.toString();
    }
    
    private static String z0(final int n) {
        if (n == 0) {
            return "REPEAT";
        }
        if (n == 1) {
            return "AUTO";
        }
        if (n == 2) {
            return "SEEK";
        }
        if (n != 3) {
            return "?";
        }
        return "PLAYLIST_CHANGED";
    }
    
    @Override
    public void B(final EventTime eventTime, final Format format, final DecoderReuseEvaluation decoderReuseEvaluation) {
        this.I0(eventTime, "videoInputFormat", Format.j(format));
    }
    
    @Override
    public void D(final EventTime eventTime, int i) {
        final int m = eventTime.b.m();
        final int t = eventTime.b.t();
        final StringBuilder sb = new StringBuilder();
        sb.append("timeline [");
        sb.append(this.r0(eventTime));
        sb.append(", periodCount=");
        sb.append(m);
        sb.append(", windowCount=");
        sb.append(t);
        sb.append(", reason=");
        sb.append(F0(i));
        this.J0(sb.toString());
        final int n = 0;
        StringBuilder sb2;
        for (i = 0; i < Math.min(m, 3); ++i) {
            eventTime.b.j(i, this.c);
            sb2 = new StringBuilder();
            sb2.append("  period [");
            sb2.append(E0(this.c.m()));
            sb2.append("]");
            this.J0(sb2.toString());
        }
        i = n;
        if (m > 3) {
            this.J0("  ...");
            i = n;
        }
        while (i < Math.min(t, 3)) {
            eventTime.b.r(i, this.b);
            final StringBuilder sb3 = new StringBuilder();
            sb3.append("  window [");
            sb3.append(E0(this.b.g()));
            sb3.append(", seekable=");
            sb3.append(this.b.h);
            sb3.append(", dynamic=");
            sb3.append(this.b.i);
            sb3.append("]");
            this.J0(sb3.toString());
            ++i;
        }
        if (t > 3) {
            this.J0("  ...");
        }
        this.J0("]");
    }
    
    @Override
    public void F(final EventTime eventTime, final MediaItem mediaItem, final int n) {
        final StringBuilder sb = new StringBuilder();
        sb.append("mediaItem [");
        sb.append(this.r0(eventTime));
        sb.append(", reason=");
        sb.append(z0(n));
        sb.append("]");
        this.J0(sb.toString());
    }
    
    @Override
    public void G(final EventTime eventTime, final Tracks tracks) {
        final StringBuilder sb = new StringBuilder();
        sb.append("tracks [");
        sb.append(this.r0(eventTime));
        this.J0(sb.toString());
        final ImmutableList<Tracks.Group> b = tracks.b();
        for (int i = 0; i < ((AbstractCollection)b).size(); ++i) {
            final Tracks.Group group = ((List<Tracks.Group>)b).get(i);
            this.J0("  group [");
            for (int j = 0; j < group.a; ++j) {
                final String g0 = G0(group.h(j));
                final String x = Util.X(group.d(j));
                final StringBuilder sb2 = new StringBuilder();
                sb2.append("    ");
                sb2.append(g0);
                sb2.append(" Track:");
                sb2.append(j);
                sb2.append(", ");
                sb2.append(Format.j(group.c(j)));
                sb2.append(", supported=");
                sb2.append(x);
                this.J0(sb2.toString());
            }
            this.J0("  ]");
        }
        for (int n = 0, n2 = 0; n == 0 && n2 < ((AbstractCollection)b).size(); ++n2) {
            final Tracks.Group group2 = ((List<Tracks.Group>)b).get(n2);
            int n4;
            for (int n3 = 0; n == 0 && n3 < group2.a; ++n3, n = n4) {
                n4 = n;
                if (group2.h(n3)) {
                    final Metadata k = group2.c(n3).j;
                    n4 = n;
                    if (k != null) {
                        n4 = n;
                        if (k.d() > 0) {
                            this.J0("  Metadata [");
                            this.O0(k, "    ");
                            this.J0("  ]");
                            n4 = 1;
                        }
                    }
                }
            }
        }
        this.J0("]");
    }
    
    @Override
    public void J(final EventTime eventTime, final DecoderCounters decoderCounters) {
        this.H0(eventTime, "videoDisabled");
    }
    
    protected void J0(final String s) {
        Log.b(this.a, s);
    }
    
    @Override
    public void K(final EventTime eventTime) {
        this.H0(eventTime, "drmKeysRemoved");
    }
    
    @Override
    public void L(final EventTime eventTime, final int n, final long n2, final long n3) {
    }
    
    protected void M0(final String s) {
        Log.c(this.a, s);
    }
    
    @Override
    public void Q(final EventTime eventTime, final LoadEventInfo loadEventInfo, final MediaLoadData mediaLoadData) {
    }
    
    @Override
    public void S(final EventTime eventTime, final PlaybackException ex) {
        this.L0(eventTime, "playerFailed", ex);
    }
    
    @Override
    public void V(final EventTime eventTime) {
        this.H0(eventTime, "drmSessionReleased");
    }
    
    @Override
    public void W(final EventTime eventTime, final PlaybackParameters playbackParameters) {
        this.I0(eventTime, "playbackParameters", playbackParameters.toString());
    }
    
    @Override
    public void X(final EventTime eventTime, final int n, final long n2, final long n3) {
        final StringBuilder sb = new StringBuilder();
        sb.append(n);
        sb.append(", ");
        sb.append(n2);
        sb.append(", ");
        sb.append(n3);
        this.K0(eventTime, "audioTrackUnderrun", sb.toString(), null);
    }
    
    @Override
    public void Y(final EventTime eventTime, final DecoderCounters decoderCounters) {
        this.H0(eventTime, "audioDisabled");
    }
    
    @Override
    public void Z(final EventTime eventTime, final DecoderCounters decoderCounters) {
        this.H0(eventTime, "videoEnabled");
    }
    
    @Override
    public void a(final EventTime eventTime, final String s) {
        this.I0(eventTime, "videoDecoderReleased", s);
    }
    
    @Override
    public void b0(final EventTime eventTime, final int n) {
        this.I0(eventTime, "repeatMode", C0(n));
    }
    
    @Override
    public void c(final EventTime eventTime, final int n) {
        final StringBuilder sb = new StringBuilder();
        sb.append("state=");
        sb.append(n);
        this.I0(eventTime, "drmSessionAcquired", sb.toString());
    }
    
    @Override
    public void d(final EventTime eventTime, final Exception ex) {
        this.N0(eventTime, "drmSessionManagerError", ex);
    }
    
    @Override
    public void d0(final EventTime eventTime, final VideoSize videoSize) {
        final StringBuilder sb = new StringBuilder();
        sb.append(videoSize.a);
        sb.append(", ");
        sb.append(videoSize.b);
        this.I0(eventTime, "videoSize", sb.toString());
    }
    
    @Override
    public void e(final EventTime eventTime) {
        this.H0(eventTime, "drmKeysRestored");
    }
    
    @Override
    public void f(final EventTime eventTime, final int n) {
        this.I0(eventTime, "playbackSuppressionReason", B0(n));
    }
    
    @Override
    public void h0(final EventTime eventTime) {
        this.H0(eventTime, "drmKeysLoaded");
    }
    
    @Override
    public void i0(final EventTime eventTime, final float n) {
        this.I0(eventTime, "volume", Float.toString(n));
    }
    
    @Override
    public void j(final EventTime eventTime, final DecoderCounters decoderCounters) {
        this.H0(eventTime, "audioEnabled");
    }
    
    @Override
    public void j0(final EventTime eventTime, final LoadEventInfo loadEventInfo, final MediaLoadData mediaLoadData) {
    }
    
    @Override
    public void k(final EventTime eventTime, final LoadEventInfo loadEventInfo, final MediaLoadData mediaLoadData, final IOException ex, final boolean b) {
        this.N0(eventTime, "loadError", ex);
    }
    
    @Override
    public void k0(final EventTime eventTime, final boolean b) {
        this.I0(eventTime, "isPlaying", Boolean.toString(b));
    }
    
    @Override
    public void m(final EventTime eventTime, final String s, final long n) {
        this.I0(eventTime, "audioDecoderInitialized", s);
    }
    
    @Override
    public void m0(final EventTime eventTime, final MediaLoadData mediaLoadData) {
        this.I0(eventTime, "downstreamFormat", Format.j(mediaLoadData.c));
    }
    
    @Override
    public void n(final EventTime eventTime, final Metadata metadata) {
        final StringBuilder sb = new StringBuilder();
        sb.append("metadata [");
        sb.append(this.r0(eventTime));
        this.J0(sb.toString());
        this.O0(metadata, "  ");
        this.J0("]");
    }
    
    @Override
    public void n0(final EventTime eventTime, final LoadEventInfo loadEventInfo, final MediaLoadData mediaLoadData) {
    }
    
    @Override
    public void o0(final EventTime eventTime, final MediaLoadData mediaLoadData) {
        this.I0(eventTime, "upstreamDiscarded", Format.j(mediaLoadData.c));
    }
    
    @Override
    public void p0(final EventTime eventTime, final Player.PositionInfo positionInfo, final Player.PositionInfo positionInfo2, final int n) {
        final StringBuilder sb = new StringBuilder();
        sb.append("reason=");
        sb.append(e0(n));
        sb.append(", PositionInfo:old [");
        sb.append("mediaItem=");
        sb.append(positionInfo.c);
        sb.append(", period=");
        sb.append(positionInfo.f);
        sb.append(", pos=");
        sb.append(positionInfo.g);
        if (positionInfo.i != -1) {
            sb.append(", contentPos=");
            sb.append(positionInfo.h);
            sb.append(", adGroup=");
            sb.append(positionInfo.i);
            sb.append(", ad=");
            sb.append(positionInfo.j);
        }
        sb.append("], PositionInfo:new [");
        sb.append("mediaItem=");
        sb.append(positionInfo2.c);
        sb.append(", period=");
        sb.append(positionInfo2.f);
        sb.append(", pos=");
        sb.append(positionInfo2.g);
        if (positionInfo2.i != -1) {
            sb.append(", contentPos=");
            sb.append(positionInfo2.h);
            sb.append(", adGroup=");
            sb.append(positionInfo2.i);
            sb.append(", ad=");
            sb.append(positionInfo2.j);
        }
        sb.append("]");
        this.I0(eventTime, "positionDiscontinuity", sb.toString());
    }
    
    @Override
    public void q(final EventTime eventTime, final int n) {
        this.I0(eventTime, "state", D0(n));
    }
    
    @Override
    public void q0(final EventTime eventTime, final String s) {
        this.I0(eventTime, "audioDecoderReleased", s);
    }
    
    @Override
    public void s0(final EventTime eventTime, final String s, final long n) {
        this.I0(eventTime, "videoDecoderInitialized", s);
    }
    
    @Override
    public void t(final EventTime eventTime, final int n, final int n2) {
        final StringBuilder sb = new StringBuilder();
        sb.append(n);
        sb.append(", ");
        sb.append(n2);
        this.I0(eventTime, "surfaceSize", sb.toString());
    }
    
    @Override
    public void t0(final EventTime eventTime, final Format format, final DecoderReuseEvaluation decoderReuseEvaluation) {
        this.I0(eventTime, "audioInputFormat", Format.j(format));
    }
    
    @Override
    public void u(final EventTime eventTime, final boolean b) {
        this.I0(eventTime, "shuffleModeEnabled", Boolean.toString(b));
    }
    
    @Override
    public void v(final EventTime eventTime, final int n, final long n2) {
        this.I0(eventTime, "droppedFrames", Integer.toString(n));
    }
    
    @Override
    public void v0(final EventTime eventTime, final Object o, final long n) {
        this.I0(eventTime, "renderedFirstFrame", String.valueOf(o));
    }
    
    @Override
    public void x(final EventTime eventTime, final boolean b) {
        this.I0(eventTime, "skipSilenceEnabled", Boolean.toString(b));
    }
    
    @Override
    public void y0(final EventTime eventTime, final boolean b) {
        this.I0(eventTime, "loading", Boolean.toString(b));
    }
    
    @Override
    public void z(final EventTime eventTime, final boolean b, final int n) {
        final StringBuilder sb = new StringBuilder();
        sb.append(b);
        sb.append(", ");
        sb.append(A0(n));
        this.I0(eventTime, "playWhenReady", sb.toString());
    }
}
