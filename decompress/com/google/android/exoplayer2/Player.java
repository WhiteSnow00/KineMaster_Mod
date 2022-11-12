// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.exoplayer2;

import com.google.common.base.Objects;
import com.google.android.exoplayer2.metadata.Metadata;
import com.google.android.exoplayer2.text.Cue;
import com.google.android.exoplayer2.audio.AudioAttributes;
import java.util.ArrayList;
import android.os.Bundle;
import com.google.android.exoplayer2.util.FlagSet;
import java.lang.annotation.ElementType;
import java.lang.annotation.Target;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Retention;
import java.lang.annotation.Documented;
import android.os.Looper;
import com.google.android.exoplayer2.text.CueGroup;
import android.view.SurfaceView;
import com.google.android.exoplayer2.trackselection.TrackSelectionParameters;
import java.util.List;
import com.google.android.exoplayer2.video.VideoSize;
import android.view.TextureView;

public interface Player
{
    void A(final TextureView p0);
    
    void B(final int p0, final long p1);
    
    Commands C();
    
    void D(final MediaItem p0);
    
    boolean E();
    
    void F(final boolean p0);
    
    MediaItem G(final int p0);
    
    long H();
    
    long I();
    
    int J();
    
    void K(final TextureView p0);
    
    VideoSize L();
    
    boolean M();
    
    int N();
    
    void O(final MediaItem p0, final boolean p1);
    
    void P(final int p0);
    
    long Q();
    
    long R();
    
    void S(final Listener p0);
    
    void T(final int p0, final List<MediaItem> p1);
    
    long U();
    
    boolean V();
    
    void W(final TrackSelectionParameters p0);
    
    boolean X();
    
    int Y();
    
    void Z(final SurfaceView p0);
    
    PlaybackException a();
    
    void a0(final List<MediaItem> p0);
    
    PlaybackParameters b();
    
    boolean b0();
    
    long c0();
    
    void d(final PlaybackParameters p0);
    
    void d0();
    
    boolean e();
    
    void e0();
    
    long f();
    
    MediaMetadata f0();
    
    void g(final Listener p0);
    
    long g0();
    
    long getDuration();
    
    int getPlaybackState();
    
    int getRepeatMode();
    
    void h();
    
    long h0();
    
    void i(final List<MediaItem> p0, final boolean p1);
    
    boolean i0();
    
    void j(final SurfaceView p0);
    
    void k(final int p0);
    
    int l();
    
    void m(final int p0, final int p1);
    
    void n();
    
    void o(final boolean p0);
    
    Tracks p();
    
    void pause();
    
    void play();
    
    void prepare();
    
    boolean q();
    
    CueGroup r();
    
    void release();
    
    int s();
    
    void seekTo(final long p0);
    
    void setRepeatMode(final int p0);
    
    void setVolume(final float p0);
    
    void stop();
    
    boolean t(final int p0);
    
    boolean u();
    
    int v();
    
    Timeline w();
    
    Looper x();
    
    TrackSelectionParameters y();
    
    void z();
    
    @Documented
    @Retention(RetentionPolicy.SOURCE)
    @Target({ ElementType.FIELD, ElementType.METHOD, ElementType.PARAMETER, ElementType.LOCAL_VARIABLE, ElementType.TYPE_USE })
    public @interface Command {
    }
    
    public static final class Commands implements Bundleable
    {
        public static final Commands b;
        public static final Creator<Commands> c;
        private final FlagSet a;
        
        static {
            b = new Builder().e();
            c = o1.a;
        }
        
        private Commands(final FlagSet a) {
            this.a = a;
        }
        
        Commands(final FlagSet set, final Player$a object) {
            this(set);
        }
        
        public static Commands a(final Bundle bundle) {
            return d(bundle);
        }
        
        static FlagSet b(final Commands commands) {
            return commands.a;
        }
        
        private static Commands d(final Bundle bundle) {
            int i = 0;
            final ArrayList integerArrayList = bundle.getIntegerArrayList(e(0));
            if (integerArrayList == null) {
                return Commands.b;
            }
            final Builder builder = new Builder();
            while (i < integerArrayList.size()) {
                builder.a(integerArrayList.get(i));
                ++i;
            }
            return builder.e();
        }
        
        private static String e(final int n) {
            return Integer.toString(n, 36);
        }
        
        public boolean c(final int n) {
            return this.a.a(n);
        }
        
        @Override
        public boolean equals(final Object o) {
            return this == o || (o instanceof Commands && this.a.equals(((Commands)o).a));
        }
        
        @Override
        public int hashCode() {
            return this.a.hashCode();
        }
        
        @Override
        public Bundle toBundle() {
            final Bundle bundle = new Bundle();
            final ArrayList list = new ArrayList();
            for (int i = 0; i < this.a.d(); ++i) {
                list.add(this.a.c(i));
            }
            bundle.putIntegerArrayList(e(0), list);
            return bundle;
        }
        
        public static final class Builder
        {
            private static final int[] b;
            private final FlagSet.Builder a;
            
            static {
                b = new int[] { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 31, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30 };
            }
            
            public Builder() {
                this.a = new FlagSet.Builder();
            }
            
            public Builder a(final int n) {
                this.a.a(n);
                return this;
            }
            
            public Builder b(final Commands commands) {
                this.a.b(Commands.b(commands));
                return this;
            }
            
            public Builder c(final int... array) {
                this.a.c(array);
                return this;
            }
            
            public Builder d(final int n, final boolean b) {
                this.a.d(n, b);
                return this;
            }
            
            public Commands e() {
                return new Commands(this.a.e(), null);
            }
        }
    }
    
    @Documented
    @Retention(RetentionPolicy.SOURCE)
    @Target({ ElementType.FIELD, ElementType.METHOD, ElementType.PARAMETER, ElementType.LOCAL_VARIABLE, ElementType.TYPE_USE })
    public @interface DiscontinuityReason {
    }
    
    @Documented
    @Retention(RetentionPolicy.SOURCE)
    @Target({ ElementType.FIELD, ElementType.METHOD, ElementType.PARAMETER, ElementType.LOCAL_VARIABLE, ElementType.TYPE_USE })
    public @interface Event {
    }
    
    public static final class Events
    {
        private final FlagSet a;
        
        public Events(final FlagSet a) {
            this.a = a;
        }
        
        public boolean a(final int n) {
            return this.a.a(n);
        }
        
        public boolean b(final int... array) {
            return this.a.b(array);
        }
        
        @Override
        public boolean equals(final Object o) {
            return this == o || (o instanceof Events && this.a.equals(((Events)o).a));
        }
        
        @Override
        public int hashCode() {
            return this.a.hashCode();
        }
    }
    
    public interface Listener
    {
        default void onAudioAttributesChanged(final AudioAttributes audioAttributes) {
        }
        
        default void onAudioSessionIdChanged(final int n) {
        }
        
        default void onAvailableCommandsChanged(final Commands commands) {
        }
        
        default void onCues(final CueGroup cueGroup) {
        }
        
        @Deprecated
        default void onCues(final List<Cue> list) {
        }
        
        default void onDeviceInfoChanged(final DeviceInfo deviceInfo) {
        }
        
        default void onDeviceVolumeChanged(final int n, final boolean b) {
        }
        
        default void onEvents(final Player player, final Events events) {
        }
        
        default void onIsLoadingChanged(final boolean b) {
        }
        
        default void onIsPlayingChanged(final boolean b) {
        }
        
        @Deprecated
        default void onLoadingChanged(final boolean b) {
        }
        
        default void onMaxSeekToPreviousPositionChanged(final long n) {
        }
        
        default void onMediaItemTransition(final MediaItem mediaItem, final int n) {
        }
        
        default void onMediaMetadataChanged(final MediaMetadata mediaMetadata) {
        }
        
        default void onMetadata(final Metadata metadata) {
        }
        
        default void onPlayWhenReadyChanged(final boolean b, final int n) {
        }
        
        default void onPlaybackParametersChanged(final PlaybackParameters playbackParameters) {
        }
        
        default void onPlaybackStateChanged(final int n) {
        }
        
        default void onPlaybackSuppressionReasonChanged(final int n) {
        }
        
        default void onPlayerError(final PlaybackException ex) {
        }
        
        default void onPlayerErrorChanged(final PlaybackException ex) {
        }
        
        @Deprecated
        default void onPlayerStateChanged(final boolean b, final int n) {
        }
        
        default void onPlaylistMetadataChanged(final MediaMetadata mediaMetadata) {
        }
        
        @Deprecated
        default void onPositionDiscontinuity(final int n) {
        }
        
        default void onPositionDiscontinuity(final PositionInfo positionInfo, final PositionInfo positionInfo2, final int n) {
        }
        
        default void onRenderedFirstFrame() {
        }
        
        default void onRepeatModeChanged(final int n) {
        }
        
        default void onSeekBackIncrementChanged(final long n) {
        }
        
        default void onSeekForwardIncrementChanged(final long n) {
        }
        
        @Deprecated
        default void onSeekProcessed() {
        }
        
        default void onShuffleModeEnabledChanged(final boolean b) {
        }
        
        default void onSkipSilenceEnabledChanged(final boolean b) {
        }
        
        default void onSurfaceSizeChanged(final int n, final int n2) {
        }
        
        default void onTimelineChanged(final Timeline timeline, final int n) {
        }
        
        default void onTrackSelectionParametersChanged(final TrackSelectionParameters trackSelectionParameters) {
        }
        
        default void onTracksChanged(final Tracks tracks) {
        }
        
        default void onVideoSizeChanged(final VideoSize videoSize) {
        }
        
        default void onVolumeChanged(final float n) {
        }
    }
    
    @Documented
    @Retention(RetentionPolicy.SOURCE)
    @Target({ ElementType.FIELD, ElementType.METHOD, ElementType.PARAMETER, ElementType.LOCAL_VARIABLE, ElementType.TYPE_USE })
    public @interface MediaItemTransitionReason {
    }
    
    @Documented
    @Retention(RetentionPolicy.SOURCE)
    @Target({ ElementType.FIELD, ElementType.METHOD, ElementType.PARAMETER, ElementType.LOCAL_VARIABLE, ElementType.TYPE_USE })
    public @interface PlayWhenReadyChangeReason {
    }
    
    @Documented
    @Retention(RetentionPolicy.SOURCE)
    @Target({ ElementType.FIELD, ElementType.METHOD, ElementType.PARAMETER, ElementType.LOCAL_VARIABLE, ElementType.TYPE_USE })
    public @interface PlaybackSuppressionReason {
    }
    
    public static final class PositionInfo implements Bundleable
    {
        public static final Creator<PositionInfo> p;
        public final Object a;
        @Deprecated
        public final int b;
        public final int c;
        public final MediaItem d;
        public final Object e;
        public final int f;
        public final long g;
        public final long h;
        public final int i;
        public final int j;
        
        static {
            p = p1.a;
        }
        
        public PositionInfo(final Object a, final int n, final MediaItem d, final Object e, final int f, final long g, final long h, final int i, final int j) {
            this.a = a;
            this.b = n;
            this.c = n;
            this.d = d;
            this.e = e;
            this.f = f;
            this.g = g;
            this.h = h;
            this.i = i;
            this.j = j;
        }
        
        public static PositionInfo a(final Bundle bundle) {
            return b(bundle);
        }
        
        private static PositionInfo b(final Bundle bundle) {
            final int int1 = bundle.getInt(c(0), -1);
            final Bundle bundle2 = bundle.getBundle(c(1));
            MediaItem mediaItem;
            if (bundle2 == null) {
                mediaItem = null;
            }
            else {
                mediaItem = MediaItem.j.a(bundle2);
            }
            return new PositionInfo(null, int1, mediaItem, null, bundle.getInt(c(2), -1), bundle.getLong(c(3), -9223372036854775807L), bundle.getLong(c(4), -9223372036854775807L), bundle.getInt(c(5), -1), bundle.getInt(c(6), -1));
        }
        
        private static String c(final int n) {
            return Integer.toString(n, 36);
        }
        
        @Override
        public boolean equals(final Object o) {
            boolean b = true;
            if (this == o) {
                return true;
            }
            if (o != null && PositionInfo.class == o.getClass()) {
                final PositionInfo positionInfo = (PositionInfo)o;
                if (this.c != positionInfo.c || this.f != positionInfo.f || this.g != positionInfo.g || this.h != positionInfo.h || this.i != positionInfo.i || this.j != positionInfo.j || !Objects.a(this.a, positionInfo.a) || !Objects.a(this.e, positionInfo.e) || !Objects.a((Object)this.d, (Object)positionInfo.d)) {
                    b = false;
                }
                return b;
            }
            return false;
        }
        
        @Override
        public int hashCode() {
            return Objects.b(new Object[] { this.a, this.c, this.d, this.e, this.f, this.g, this.h, this.i, this.j });
        }
        
        @Override
        public Bundle toBundle() {
            final Bundle bundle = new Bundle();
            bundle.putInt(c(0), this.c);
            if (this.d != null) {
                bundle.putBundle(c(1), this.d.toBundle());
            }
            bundle.putInt(c(2), this.f);
            bundle.putLong(c(3), this.g);
            bundle.putLong(c(4), this.h);
            bundle.putInt(c(5), this.i);
            bundle.putInt(c(6), this.j);
            return bundle;
        }
    }
    
    @Documented
    @Retention(RetentionPolicy.SOURCE)
    @Target({ ElementType.FIELD, ElementType.METHOD, ElementType.PARAMETER, ElementType.LOCAL_VARIABLE, ElementType.TYPE_USE })
    public @interface RepeatMode {
    }
    
    @Documented
    @Retention(RetentionPolicy.SOURCE)
    @Target({ ElementType.FIELD, ElementType.METHOD, ElementType.PARAMETER, ElementType.LOCAL_VARIABLE, ElementType.TYPE_USE })
    public @interface State {
    }
    
    @Documented
    @Retention(RetentionPolicy.SOURCE)
    @Target({ ElementType.FIELD, ElementType.METHOD, ElementType.PARAMETER, ElementType.LOCAL_VARIABLE, ElementType.TYPE_USE })
    public @interface TimelineChangeReason {
    }
}
