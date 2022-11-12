// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.exoplayer2;

import android.os.Looper;
import com.google.android.exoplayer2.text.CueGroup;
import com.google.android.exoplayer2.source.MediaSource;
import android.view.SurfaceView;
import com.google.android.exoplayer2.trackselection.TrackSelectionParameters;
import java.util.List;
import com.google.android.exoplayer2.video.VideoSize;
import android.view.TextureView;
import com.google.android.exoplayer2.util.ConditionVariable;

@Deprecated
public class SimpleExoPlayer extends BasePlayer implements ExoPlayer, AudioComponent, VideoComponent, TextComponent, DeviceComponent
{
    private final l0 b;
    private final ConditionVariable c;
    
    private void q0() {
        this.c.c();
    }
    
    @Override
    public void A(final TextureView textureView) {
        this.q0();
        this.b.A(textureView);
    }
    
    @Override
    public void B(final int n, final long n2) {
        this.q0();
        this.b.B(n, n2);
    }
    
    @Override
    public Commands C() {
        this.q0();
        return this.b.C();
    }
    
    @Override
    public boolean E() {
        this.q0();
        return this.b.E();
    }
    
    @Override
    public void F(final boolean b) {
        this.q0();
        this.b.F(b);
    }
    
    @Override
    public long H() {
        this.q0();
        return this.b.H();
    }
    
    @Override
    public int J() {
        this.q0();
        return this.b.J();
    }
    
    @Override
    public void K(final TextureView textureView) {
        this.q0();
        this.b.K(textureView);
    }
    
    @Override
    public VideoSize L() {
        this.q0();
        return this.b.L();
    }
    
    @Override
    public int N() {
        this.q0();
        return this.b.N();
    }
    
    @Override
    public long Q() {
        this.q0();
        return this.b.Q();
    }
    
    @Override
    public long R() {
        this.q0();
        return this.b.R();
    }
    
    @Override
    public void S(final Listener listener) {
        this.q0();
        this.b.S(listener);
    }
    
    @Override
    public void T(final int n, final List<MediaItem> list) {
        this.q0();
        this.b.T(n, list);
    }
    
    @Override
    public long U() {
        this.q0();
        return this.b.U();
    }
    
    @Override
    public void W(final TrackSelectionParameters trackSelectionParameters) {
        this.q0();
        this.b.W(trackSelectionParameters);
    }
    
    @Override
    public int Y() {
        this.q0();
        return this.b.Y();
    }
    
    @Override
    public void Z(final SurfaceView surfaceView) {
        this.q0();
        this.b.Z(surfaceView);
    }
    
    @Override
    public ExoPlaybackException a() {
        this.q0();
        return this.b.a();
    }
    
    @Override
    public /* bridge */ PlaybackException a() {
        return this.a();
    }
    
    @Override
    public PlaybackParameters b() {
        this.q0();
        return this.b.b();
    }
    
    @Override
    public boolean b0() {
        this.q0();
        return this.b.b0();
    }
    
    @Override
    public void c(final MediaSource mediaSource) {
        this.q0();
        this.b.c(mediaSource);
    }
    
    @Override
    public long c0() {
        this.q0();
        return this.b.c0();
    }
    
    @Override
    public void d(final PlaybackParameters playbackParameters) {
        this.q0();
        this.b.d(playbackParameters);
    }
    
    @Override
    public boolean e() {
        this.q0();
        return this.b.e();
    }
    
    @Override
    public long f() {
        this.q0();
        return this.b.f();
    }
    
    @Override
    public MediaMetadata f0() {
        this.q0();
        return this.b.f0();
    }
    
    @Override
    public void g(final Listener listener) {
        this.q0();
        this.b.g(listener);
    }
    
    @Override
    public long g0() {
        this.q0();
        return this.b.g0();
    }
    
    @Override
    public long getDuration() {
        this.q0();
        return this.b.getDuration();
    }
    
    @Override
    public int getPlaybackState() {
        this.q0();
        return this.b.getPlaybackState();
    }
    
    @Override
    public int getRepeatMode() {
        this.q0();
        return this.b.getRepeatMode();
    }
    
    @Override
    public long h0() {
        this.q0();
        return this.b.h0();
    }
    
    @Override
    public void i(final List<MediaItem> list, final boolean b) {
        this.q0();
        this.b.i(list, b);
    }
    
    @Override
    public void j(final SurfaceView surfaceView) {
        this.q0();
        this.b.j(surfaceView);
    }
    
    @Override
    public void m(final int n, final int n2) {
        this.q0();
        this.b.m(n, n2);
    }
    
    @Override
    public void o(final boolean b) {
        this.q0();
        this.b.o(b);
    }
    
    @Override
    public Tracks p() {
        this.q0();
        return this.b.p();
    }
    
    @Override
    public void prepare() {
        this.q0();
        this.b.prepare();
    }
    
    @Override
    public CueGroup r() {
        this.q0();
        return this.b.r();
    }
    
    @Override
    public void release() {
        this.q0();
        this.b.release();
    }
    
    @Override
    public int s() {
        this.q0();
        return this.b.s();
    }
    
    @Override
    public void setRepeatMode(final int repeatMode) {
        this.q0();
        this.b.setRepeatMode(repeatMode);
    }
    
    @Override
    public void setVolume(final float volume) {
        this.q0();
        this.b.setVolume(volume);
    }
    
    @Override
    public void stop() {
        this.q0();
        this.b.stop();
    }
    
    @Override
    public int v() {
        this.q0();
        return this.b.v();
    }
    
    @Override
    public Timeline w() {
        this.q0();
        return this.b.w();
    }
    
    @Override
    public Looper x() {
        this.q0();
        return this.b.x();
    }
    
    @Override
    public TrackSelectionParameters y() {
        this.q0();
        return this.b.y();
    }
    
    @Deprecated
    public static final class Builder
    {
    }
}
