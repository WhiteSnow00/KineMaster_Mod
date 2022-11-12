// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.exoplayer2;

import com.google.android.exoplayer2.metadata.Metadata;
import com.google.android.exoplayer2.text.Cue;
import java.util.List;
import android.os.Looper;
import com.google.android.exoplayer2.text.CueGroup;
import android.view.SurfaceView;
import com.google.android.exoplayer2.trackselection.TrackSelectionParameters;
import com.google.android.exoplayer2.video.VideoSize;
import android.view.TextureView;

public class ForwardingPlayer implements Player
{
    private final Player a;
    
    @Override
    public void A(final TextureView textureView) {
        this.a.A(textureView);
    }
    
    @Override
    public void B(final int n, final long n2) {
        this.a.B(n, n2);
    }
    
    @Override
    public boolean E() {
        return this.a.E();
    }
    
    @Override
    public void F(final boolean b) {
        this.a.F(b);
    }
    
    @Override
    public int J() {
        return this.a.J();
    }
    
    @Override
    public void K(final TextureView textureView) {
        this.a.K(textureView);
    }
    
    @Override
    public VideoSize L() {
        return this.a.L();
    }
    
    @Override
    public boolean M() {
        return this.a.M();
    }
    
    @Override
    public int N() {
        return this.a.N();
    }
    
    @Override
    public long Q() {
        return this.a.Q();
    }
    
    @Override
    public long R() {
        return this.a.R();
    }
    
    @Override
    public void S(final Listener listener) {
        this.a.S((Listener)new a(this, listener));
    }
    
    @Override
    public boolean V() {
        return this.a.V();
    }
    
    @Override
    public void W(final TrackSelectionParameters trackSelectionParameters) {
        this.a.W(trackSelectionParameters);
    }
    
    @Override
    public boolean X() {
        return this.a.X();
    }
    
    @Override
    public int Y() {
        return this.a.Y();
    }
    
    @Override
    public void Z(final SurfaceView surfaceView) {
        this.a.Z(surfaceView);
    }
    
    @Override
    public PlaybackException a() {
        return this.a.a();
    }
    
    @Override
    public PlaybackParameters b() {
        return this.a.b();
    }
    
    @Override
    public boolean b0() {
        return this.a.b0();
    }
    
    @Override
    public long c0() {
        return this.a.c0();
    }
    
    @Override
    public void d(final PlaybackParameters playbackParameters) {
        this.a.d(playbackParameters);
    }
    
    @Override
    public void d0() {
        this.a.d0();
    }
    
    @Override
    public boolean e() {
        return this.a.e();
    }
    
    @Override
    public void e0() {
        this.a.e0();
    }
    
    @Override
    public long f() {
        return this.a.f();
    }
    
    @Override
    public MediaMetadata f0() {
        return this.a.f0();
    }
    
    @Override
    public void g(final Listener listener) {
        this.a.g((Listener)new a(this, listener));
    }
    
    @Override
    public long g0() {
        return this.a.g0();
    }
    
    @Override
    public int getPlaybackState() {
        return this.a.getPlaybackState();
    }
    
    @Override
    public int getRepeatMode() {
        return this.a.getRepeatMode();
    }
    
    @Override
    public long h0() {
        return this.a.h0();
    }
    
    @Override
    public boolean i0() {
        return this.a.i0();
    }
    
    @Override
    public void j(final SurfaceView surfaceView) {
        this.a.j(surfaceView);
    }
    
    public Player j0() {
        return this.a;
    }
    
    @Override
    public void n() {
        this.a.n();
    }
    
    @Override
    public Tracks p() {
        return this.a.p();
    }
    
    @Override
    public void pause() {
        this.a.pause();
    }
    
    @Override
    public void play() {
        this.a.play();
    }
    
    @Override
    public void prepare() {
        this.a.prepare();
    }
    
    @Override
    public boolean q() {
        return this.a.q();
    }
    
    @Override
    public CueGroup r() {
        return this.a.r();
    }
    
    @Override
    public int s() {
        return this.a.s();
    }
    
    @Override
    public void setRepeatMode(final int repeatMode) {
        this.a.setRepeatMode(repeatMode);
    }
    
    @Override
    public boolean t(final int n) {
        return this.a.t(n);
    }
    
    @Override
    public boolean u() {
        return this.a.u();
    }
    
    @Override
    public int v() {
        return this.a.v();
    }
    
    @Override
    public Timeline w() {
        return this.a.w();
    }
    
    @Override
    public Looper x() {
        return this.a.x();
    }
    
    @Override
    public TrackSelectionParameters y() {
        return this.a.y();
    }
    
    @Override
    public void z() {
        this.a.z();
    }
    
    private static final class a implements Listener
    {
        private final ForwardingPlayer a;
        private final Listener b;
        
        public a(final ForwardingPlayer a, final Listener b) {
            this.a = a;
            this.b = b;
        }
        
        @Override
        public boolean equals(final Object o) {
            if (this == o) {
                return true;
            }
            if (!(o instanceof a)) {
                return false;
            }
            final a a = (a)o;
            return this.a.equals(a.a) && this.b.equals(a.b);
        }
        
        @Override
        public int hashCode() {
            return this.a.hashCode() * 31 + this.b.hashCode();
        }
        
        @Override
        public void onAvailableCommandsChanged(final Commands commands) {
            this.b.onAvailableCommandsChanged(commands);
        }
        
        @Override
        public void onCues(final CueGroup cueGroup) {
            this.b.onCues(cueGroup);
        }
        
        @Override
        public void onCues(final List<Cue> list) {
            this.b.onCues(list);
        }
        
        @Override
        public void onDeviceInfoChanged(final DeviceInfo deviceInfo) {
            this.b.onDeviceInfoChanged(deviceInfo);
        }
        
        @Override
        public void onDeviceVolumeChanged(final int n, final boolean b) {
            this.b.onDeviceVolumeChanged(n, b);
        }
        
        @Override
        public void onEvents(final Player player, final Events events) {
            this.b.onEvents(this.a, events);
        }
        
        @Override
        public void onIsLoadingChanged(final boolean b) {
            this.b.onIsLoadingChanged(b);
        }
        
        @Override
        public void onIsPlayingChanged(final boolean b) {
            this.b.onIsPlayingChanged(b);
        }
        
        @Override
        public void onLoadingChanged(final boolean b) {
            this.b.onIsLoadingChanged(b);
        }
        
        @Override
        public void onMediaItemTransition(final MediaItem mediaItem, final int n) {
            this.b.onMediaItemTransition(mediaItem, n);
        }
        
        @Override
        public void onMediaMetadataChanged(final MediaMetadata mediaMetadata) {
            this.b.onMediaMetadataChanged(mediaMetadata);
        }
        
        @Override
        public void onMetadata(final Metadata metadata) {
            this.b.onMetadata(metadata);
        }
        
        @Override
        public void onPlayWhenReadyChanged(final boolean b, final int n) {
            this.b.onPlayWhenReadyChanged(b, n);
        }
        
        @Override
        public void onPlaybackParametersChanged(final PlaybackParameters playbackParameters) {
            this.b.onPlaybackParametersChanged(playbackParameters);
        }
        
        @Override
        public void onPlaybackStateChanged(final int n) {
            this.b.onPlaybackStateChanged(n);
        }
        
        @Override
        public void onPlaybackSuppressionReasonChanged(final int n) {
            this.b.onPlaybackSuppressionReasonChanged(n);
        }
        
        @Override
        public void onPlayerError(final PlaybackException ex) {
            this.b.onPlayerError(ex);
        }
        
        @Override
        public void onPlayerErrorChanged(final PlaybackException ex) {
            this.b.onPlayerErrorChanged(ex);
        }
        
        @Override
        public void onPlayerStateChanged(final boolean b, final int n) {
            this.b.onPlayerStateChanged(b, n);
        }
        
        @Override
        public void onPositionDiscontinuity(final int n) {
            this.b.onPositionDiscontinuity(n);
        }
        
        @Override
        public void onPositionDiscontinuity(final PositionInfo positionInfo, final PositionInfo positionInfo2, final int n) {
            this.b.onPositionDiscontinuity(positionInfo, positionInfo2, n);
        }
        
        @Override
        public void onRenderedFirstFrame() {
            this.b.onRenderedFirstFrame();
        }
        
        @Override
        public void onRepeatModeChanged(final int n) {
            this.b.onRepeatModeChanged(n);
        }
        
        @Override
        public void onSeekProcessed() {
            this.b.onSeekProcessed();
        }
        
        @Override
        public void onShuffleModeEnabledChanged(final boolean b) {
            this.b.onShuffleModeEnabledChanged(b);
        }
        
        @Override
        public void onSkipSilenceEnabledChanged(final boolean b) {
            this.b.onSkipSilenceEnabledChanged(b);
        }
        
        @Override
        public void onSurfaceSizeChanged(final int n, final int n2) {
            this.b.onSurfaceSizeChanged(n, n2);
        }
        
        @Override
        public void onTimelineChanged(final Timeline timeline, final int n) {
            this.b.onTimelineChanged(timeline, n);
        }
        
        @Override
        public void onTrackSelectionParametersChanged(final TrackSelectionParameters trackSelectionParameters) {
            this.b.onTrackSelectionParametersChanged(trackSelectionParameters);
        }
        
        @Override
        public void onTracksChanged(final Tracks tracks) {
            this.b.onTracksChanged(tracks);
        }
        
        @Override
        public void onVideoSizeChanged(final VideoSize videoSize) {
            this.b.onVideoSizeChanged(videoSize);
        }
        
        @Override
        public void onVolumeChanged(final float n) {
            this.b.onVolumeChanged(n);
        }
    }
}
