// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.exoplayer2;

import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.upstream.DefaultBandwidthMeter;
import com.google.android.exoplayer2.trackselection.DefaultTrackSelector;
import com.google.android.exoplayer2.extractor.ExtractorsFactory;
import com.google.android.exoplayer2.source.DefaultMediaSourceFactory;
import com.google.android.exoplayer2.extractor.DefaultExtractorsFactory;
import com.google.android.exoplayer2.util.Util;
import com.google.android.exoplayer2.audio.AudioAttributes;
import com.google.android.exoplayer2.util.PriorityTaskManager;
import android.os.Looper;
import com.google.android.exoplayer2.analytics.AnalyticsCollector;
import com.google.common.base.Function;
import com.google.android.exoplayer2.upstream.BandwidthMeter;
import com.google.android.exoplayer2.trackselection.TrackSelector;
import com.google.common.base.Supplier;
import com.google.android.exoplayer2.util.Clock;
import android.content.Context;
import com.google.android.exoplayer2.source.MediaSource;

public interface ExoPlayer extends Player
{
    ExoPlaybackException a();
    
    default /* bridge */ PlaybackException a() {
        return this.a();
    }
    
    void c(final MediaSource p0);
    
    @Deprecated
    public interface AudioComponent
    {
    }
    
    public interface AudioOffloadListener
    {
        default void y(final boolean b) {
        }
    }
    
    public static final class Builder
    {
        boolean A;
        boolean B;
        final Context a;
        Clock b;
        long c;
        Supplier<RenderersFactory> d;
        Supplier<MediaSource.Factory> e;
        Supplier<TrackSelector> f;
        Supplier<LoadControl> g;
        Supplier<BandwidthMeter> h;
        Function<Clock, AnalyticsCollector> i;
        Looper j;
        PriorityTaskManager k;
        AudioAttributes l;
        boolean m;
        int n;
        boolean o;
        boolean p;
        int q;
        int r;
        boolean s;
        SeekParameters t;
        long u;
        long v;
        LivePlaybackSpeedControl w;
        long x;
        long y;
        boolean z;
        
        public Builder(final Context context) {
            this(context, (Supplier<RenderersFactory>)new g(context), (Supplier<MediaSource.Factory>)new i(context));
        }
        
        private Builder(final Context context, final Supplier<RenderersFactory> supplier, final Supplier<MediaSource.Factory> supplier2) {
            this(context, supplier, supplier2, (Supplier<TrackSelector>)new h(context), (Supplier<LoadControl>)k.a, (Supplier<BandwidthMeter>)new f(context), (Function<Clock, AnalyticsCollector>)e.a);
        }
        
        private Builder(final Context a, final Supplier<RenderersFactory> d, final Supplier<MediaSource.Factory> e, final Supplier<TrackSelector> f, final Supplier<LoadControl> g, final Supplier<BandwidthMeter> h, final Function<Clock, AnalyticsCollector> i) {
            this.a = a;
            this.d = d;
            this.e = e;
            this.f = f;
            this.g = g;
            this.h = h;
            this.i = i;
            this.j = Util.Q();
            this.l = AudioAttributes.g;
            this.n = 0;
            this.q = 1;
            this.r = 0;
            this.s = true;
            this.t = SeekParameters.g;
            this.u = 5000L;
            this.v = 15000L;
            this.w = new DefaultLivePlaybackSpeedControl.Builder().a();
            this.b = Clock.a;
            this.x = 500L;
            this.y = 2000L;
            this.A = true;
        }
        
        public static MediaSource.Factory a(final MediaSource.Factory factory) {
            return k(factory);
        }
        
        public static BandwidthMeter b(final Context context) {
            return j(context);
        }
        
        public static RenderersFactory c(final Context context) {
            return g(context);
        }
        
        public static TrackSelector d(final Context context) {
            return i(context);
        }
        
        public static MediaSource.Factory e(final Context context) {
            return h(context);
        }
        
        private static RenderersFactory g(final Context context) {
            return new DefaultRenderersFactory(context);
        }
        
        private static MediaSource.Factory h(final Context context) {
            return new DefaultMediaSourceFactory(context, new DefaultExtractorsFactory());
        }
        
        private static TrackSelector i(final Context context) {
            return new DefaultTrackSelector(context);
        }
        
        private static BandwidthMeter j(final Context context) {
            return DefaultBandwidthMeter.n(context);
        }
        
        private static MediaSource.Factory k(final MediaSource.Factory factory) {
            return factory;
        }
        
        public ExoPlayer f() {
            Assertions.g(this.B ^ true);
            this.B = true;
            return new l0(this, null);
        }
        
        public Builder l(final MediaSource.Factory factory) {
            Assertions.g(this.B ^ true);
            this.e = (Supplier<MediaSource.Factory>)new j(factory);
            return this;
        }
    }
    
    @Deprecated
    public interface DeviceComponent
    {
    }
    
    @Deprecated
    public interface TextComponent
    {
    }
    
    @Deprecated
    public interface VideoComponent
    {
    }
}
