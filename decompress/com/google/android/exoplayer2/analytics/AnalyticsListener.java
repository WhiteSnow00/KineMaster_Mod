// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.exoplayer2.analytics;

import com.google.android.exoplayer2.util.Assertions;
import android.util.SparseArray;
import com.google.android.exoplayer2.util.FlagSet;
import com.google.common.base.Objects;
import com.google.android.exoplayer2.source.MediaSource;
import com.google.android.exoplayer2.Timeline;
import java.lang.annotation.ElementType;
import java.lang.annotation.Target;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Retention;
import java.lang.annotation.Documented;
import com.google.android.exoplayer2.text.Cue;
import java.util.List;
import com.google.android.exoplayer2.DeviceInfo;
import com.google.android.exoplayer2.Player;
import com.google.android.exoplayer2.metadata.Metadata;
import java.io.IOException;
import com.google.android.exoplayer2.MediaMetadata;
import com.google.android.exoplayer2.video.VideoSize;
import com.google.android.exoplayer2.PlaybackParameters;
import com.google.android.exoplayer2.text.CueGroup;
import com.google.android.exoplayer2.PlaybackException;
import com.google.android.exoplayer2.source.MediaLoadData;
import com.google.android.exoplayer2.source.LoadEventInfo;
import com.google.android.exoplayer2.decoder.DecoderCounters;
import com.google.android.exoplayer2.trackselection.TrackSelectionParameters;
import com.google.android.exoplayer2.Tracks;
import com.google.android.exoplayer2.MediaItem;
import com.google.android.exoplayer2.decoder.DecoderReuseEvaluation;
import com.google.android.exoplayer2.Format;

public interface AnalyticsListener
{
    default void A(final EventTime eventTime, final String s, final long n, final long n2) {
    }
    
    default void B(final EventTime eventTime, final Format format, final DecoderReuseEvaluation decoderReuseEvaluation) {
    }
    
    default void C(final EventTime eventTime, final Exception ex) {
    }
    
    default void D(final EventTime eventTime, final int n) {
    }
    
    @Deprecated
    default void E(final EventTime eventTime) {
    }
    
    default void F(final EventTime eventTime, final MediaItem mediaItem, final int n) {
    }
    
    default void G(final EventTime eventTime, final Tracks tracks) {
    }
    
    default void H(final EventTime eventTime, final TrackSelectionParameters trackSelectionParameters) {
    }
    
    @Deprecated
    default void I(final EventTime eventTime) {
    }
    
    default void J(final EventTime eventTime, final DecoderCounters decoderCounters) {
    }
    
    default void K(final EventTime eventTime) {
    }
    
    default void L(final EventTime eventTime, final int n, final long n2, final long n3) {
    }
    
    default void M(final EventTime eventTime, final int n, final boolean b) {
    }
    
    @Deprecated
    default void N(final EventTime eventTime, final int n, final int n2, final int n3, final float n4) {
    }
    
    @Deprecated
    default void O(final EventTime eventTime, final int n, final Format format) {
    }
    
    @Deprecated
    default void P(final EventTime eventTime) {
    }
    
    default void Q(final EventTime eventTime, final LoadEventInfo loadEventInfo, final MediaLoadData mediaLoadData) {
    }
    
    @Deprecated
    default void R(final EventTime eventTime, final int n, final String s, final long n2) {
    }
    
    default void S(final EventTime eventTime, final PlaybackException ex) {
    }
    
    @Deprecated
    default void T(final EventTime eventTime, final int n) {
    }
    
    default void U(final EventTime eventTime, final CueGroup cueGroup) {
    }
    
    default void V(final EventTime eventTime) {
    }
    
    default void W(final EventTime eventTime, final PlaybackParameters playbackParameters) {
    }
    
    default void X(final EventTime eventTime, final int n, final long n2, final long n3) {
    }
    
    default void Y(final EventTime eventTime, final DecoderCounters decoderCounters) {
    }
    
    default void Z(final EventTime eventTime, final DecoderCounters decoderCounters) {
    }
    
    default void a(final EventTime eventTime, final String s) {
    }
    
    default void a0(final EventTime eventTime, final String s, final long n, final long n2) {
    }
    
    default void b(final EventTime eventTime, final long n, final int n2) {
    }
    
    default void b0(final EventTime eventTime, final int n) {
    }
    
    default void c(final EventTime eventTime, final int n) {
    }
    
    default void c0(final EventTime eventTime) {
    }
    
    default void d(final EventTime eventTime, final Exception ex) {
    }
    
    default void d0(final EventTime eventTime, final VideoSize videoSize) {
    }
    
    default void e(final EventTime eventTime) {
    }
    
    default void f(final EventTime eventTime, final int n) {
    }
    
    @Deprecated
    default void g(final EventTime eventTime, final boolean b) {
    }
    
    @Deprecated
    default void g0(final EventTime eventTime, final Format format) {
    }
    
    default void h(final EventTime eventTime, final MediaMetadata mediaMetadata) {
    }
    
    default void h0(final EventTime eventTime) {
    }
    
    default void i(final EventTime eventTime, final PlaybackException ex) {
    }
    
    default void i0(final EventTime eventTime, final float n) {
    }
    
    default void j(final EventTime eventTime, final DecoderCounters decoderCounters) {
    }
    
    default void j0(final EventTime eventTime, final LoadEventInfo loadEventInfo, final MediaLoadData mediaLoadData) {
    }
    
    default void k(final EventTime eventTime, final LoadEventInfo loadEventInfo, final MediaLoadData mediaLoadData, final IOException ex, final boolean b) {
    }
    
    default void k0(final EventTime eventTime, final boolean b) {
    }
    
    @Deprecated
    default void l(final EventTime eventTime, final int n, final DecoderCounters decoderCounters) {
    }
    
    default void l0(final EventTime eventTime, final Exception ex) {
    }
    
    @Deprecated
    default void m(final EventTime eventTime, final String s, final long n) {
    }
    
    default void m0(final EventTime eventTime, final MediaLoadData mediaLoadData) {
    }
    
    default void n(final EventTime eventTime, final Metadata metadata) {
    }
    
    default void n0(final EventTime eventTime, final LoadEventInfo loadEventInfo, final MediaLoadData mediaLoadData) {
    }
    
    default void o(final Player player, final Events events) {
    }
    
    default void o0(final EventTime eventTime, final MediaLoadData mediaLoadData) {
    }
    
    @Deprecated
    default void p(final EventTime eventTime, final boolean b, final int n) {
    }
    
    default void p0(final EventTime eventTime, final Player.PositionInfo positionInfo, final Player.PositionInfo positionInfo2, final int n) {
    }
    
    default void q(final EventTime eventTime, final int n) {
    }
    
    default void q0(final EventTime eventTime, final String s) {
    }
    
    @Deprecated
    default void r(final EventTime eventTime, final Format format) {
    }
    
    default void s(final EventTime eventTime, final long n) {
    }
    
    @Deprecated
    default void s0(final EventTime eventTime, final String s, final long n) {
    }
    
    default void t(final EventTime eventTime, final int n, final int n2) {
    }
    
    default void t0(final EventTime eventTime, final Format format, final DecoderReuseEvaluation decoderReuseEvaluation) {
    }
    
    default void u(final EventTime eventTime, final boolean b) {
    }
    
    default void u0(final EventTime eventTime, final Player.Commands commands) {
    }
    
    default void v(final EventTime eventTime, final int n, final long n2) {
    }
    
    default void v0(final EventTime eventTime, final Object o, final long n) {
    }
    
    default void w(final EventTime eventTime, final Exception ex) {
    }
    
    @Deprecated
    default void w0(final EventTime eventTime, final int n, final DecoderCounters decoderCounters) {
    }
    
    default void x(final EventTime eventTime, final boolean b) {
    }
    
    default void x0(final EventTime eventTime, final DeviceInfo deviceInfo) {
    }
    
    @Deprecated
    default void y(final EventTime eventTime, final List<Cue> list) {
    }
    
    default void y0(final EventTime eventTime, final boolean b) {
    }
    
    default void z(final EventTime eventTime, final boolean b, final int n) {
    }
    
    @Documented
    @Retention(RetentionPolicy.SOURCE)
    @Target({ ElementType.FIELD, ElementType.METHOD, ElementType.PARAMETER, ElementType.LOCAL_VARIABLE, ElementType.TYPE_USE })
    public @interface EventFlags {
    }
    
    public static final class EventTime
    {
        public final long a;
        public final Timeline b;
        public final int c;
        public final MediaSource.MediaPeriodId d;
        public final long e;
        public final Timeline f;
        public final int g;
        public final MediaSource.MediaPeriodId h;
        public final long i;
        public final long j;
        
        public EventTime(final long a, final Timeline b, final int c, final MediaSource.MediaPeriodId d, final long e, final Timeline f, final int g, final MediaSource.MediaPeriodId h, final long i, final long j) {
            this.a = a;
            this.b = b;
            this.c = c;
            this.d = d;
            this.e = e;
            this.f = f;
            this.g = g;
            this.h = h;
            this.i = i;
            this.j = j;
        }
        
        @Override
        public boolean equals(final Object o) {
            boolean b = true;
            if (this == o) {
                return true;
            }
            if (o != null && EventTime.class == o.getClass()) {
                final EventTime eventTime = (EventTime)o;
                if (this.a != eventTime.a || this.c != eventTime.c || this.e != eventTime.e || this.g != eventTime.g || this.i != eventTime.i || this.j != eventTime.j || !Objects.a((Object)this.b, (Object)eventTime.b) || !Objects.a((Object)this.d, (Object)eventTime.d) || !Objects.a((Object)this.f, (Object)eventTime.f) || !Objects.a((Object)this.h, (Object)eventTime.h)) {
                    b = false;
                }
                return b;
            }
            return false;
        }
        
        @Override
        public int hashCode() {
            return Objects.b(new Object[] { this.a, this.b, this.c, this.d, this.e, this.f, this.g, this.h, this.i, this.j });
        }
    }
    
    public static final class Events
    {
        private final FlagSet a;
        private final SparseArray<EventTime> b;
        
        public Events(final FlagSet a, final SparseArray<EventTime> sparseArray) {
            this.a = a;
            final SparseArray b = new SparseArray(a.d());
            for (int i = 0; i < a.d(); ++i) {
                final int c = a.c(i);
                b.append(c, (Object)Assertions.e(sparseArray.get(c)));
            }
            this.b = (SparseArray<EventTime>)b;
        }
        
        public boolean a(final int n) {
            return this.a.a(n);
        }
        
        public int b(final int n) {
            return this.a.c(n);
        }
        
        public EventTime c(final int n) {
            return Assertions.e(this.b.get(n));
        }
        
        public int d() {
            return this.a.d();
        }
    }
}
