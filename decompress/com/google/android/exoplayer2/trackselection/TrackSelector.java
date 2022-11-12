// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.exoplayer2.trackselection;

import com.google.android.exoplayer2.audio.AudioAttributes;
import com.google.android.exoplayer2.ExoPlaybackException;
import com.google.android.exoplayer2.Timeline;
import com.google.android.exoplayer2.source.MediaSource;
import com.google.android.exoplayer2.source.TrackGroupArray;
import com.google.android.exoplayer2.RendererCapabilities;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.upstream.BandwidthMeter;

public abstract class TrackSelector
{
    private InvalidationListener a;
    private BandwidthMeter b;
    
    protected final BandwidthMeter a() {
        return Assertions.i(this.b);
    }
    
    public TrackSelectionParameters b() {
        return TrackSelectionParameters.L;
    }
    
    public void c(final InvalidationListener a, final BandwidthMeter b) {
        this.a = a;
        this.b = b;
    }
    
    protected final void d() {
        final InvalidationListener a = this.a;
        if (a != null) {
            a.a();
        }
    }
    
    public boolean e() {
        return false;
    }
    
    public abstract void f(final Object p0);
    
    public void g() {
        this.a = null;
        this.b = null;
    }
    
    public abstract TrackSelectorResult h(final RendererCapabilities[] p0, final TrackGroupArray p1, final MediaSource.MediaPeriodId p2, final Timeline p3) throws ExoPlaybackException;
    
    public void i(final AudioAttributes audioAttributes) {
    }
    
    public void j(final TrackSelectionParameters trackSelectionParameters) {
    }
    
    public interface InvalidationListener
    {
        void a();
    }
}
