// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.exoplayer2.source;

import com.google.android.exoplayer2.upstream.DefaultLoadErrorHandlingPolicy;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.upstream.Allocator;
import com.google.common.base.MoreObjects;
import java.util.List;
import com.google.common.collect.ImmutableList;
import android.net.Uri;
import com.google.android.exoplayer2.MediaItem;
import com.google.android.exoplayer2.Timeline;
import com.google.android.exoplayer2.upstream.LoadErrorHandlingPolicy;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.upstream.DataSource;
import com.google.android.exoplayer2.upstream.DataSpec;
import com.google.android.exoplayer2.upstream.TransferListener;

public final class SingleSampleMediaSource extends BaseMediaSource
{
    private TransferListener A;
    private final DataSpec h;
    private final DataSource.Factory i;
    private final Format j;
    private final long p;
    private final LoadErrorHandlingPolicy w;
    private final boolean x;
    private final Timeline y;
    private final MediaItem z;
    
    private SingleSampleMediaSource(String s, final MediaItem.SubtitleConfiguration subtitleConfiguration, final DataSource.Factory i, final long p7, final LoadErrorHandlingPolicy w, final boolean x, final Object o) {
        this.i = i;
        this.p = p7;
        this.w = w;
        this.x = x;
        final MediaItem a = new MediaItem.Builder().i(Uri.EMPTY).e(subtitleConfiguration.a.toString()).g((List<MediaItem.SubtitleConfiguration>)ImmutableList.of((Object)subtitleConfiguration)).h(o).a();
        this.z = a;
        final Format.Builder u = new Format.Builder().e0((String)MoreObjects.a((Object)subtitleConfiguration.b, (Object)"text/x-unknown")).V(subtitleConfiguration.c).g0(subtitleConfiguration.d).c0(subtitleConfiguration.e).U(subtitleConfiguration.f);
        final String g = subtitleConfiguration.g;
        if (g != null) {
            s = g;
        }
        this.j = u.S(s).E();
        this.h = new DataSpec.Builder().i(subtitleConfiguration.a).b(1).a();
        this.y = new SinglePeriodTimeline(p7, true, false, false, null, a);
    }
    
    SingleSampleMediaSource(final String s, final MediaItem.SubtitleConfiguration subtitleConfiguration, final DataSource.Factory factory, final long n, final LoadErrorHandlingPolicy loadErrorHandlingPolicy, final boolean b, final Object o, final SingleSampleMediaSource$a object) {
        this(s, subtitleConfiguration, factory, n, loadErrorHandlingPolicy, b, o);
    }
    
    @Override
    public MediaItem F() {
        return this.z;
    }
    
    @Override
    public void I(final MediaPeriod mediaPeriod) {
        ((y)mediaPeriod).o();
    }
    
    @Override
    public void U() {
    }
    
    @Override
    protected void m0(final TransferListener a) {
        this.A = a;
        this.n0(this.y);
    }
    
    @Override
    protected void o0() {
    }
    
    @Override
    public MediaPeriod u(final MediaPeriodId mediaPeriodId, final Allocator allocator, final long n) {
        return new y(this.h, this.i, this.A, this.j, this.p, this.w, this.g0(mediaPeriodId), this.x);
    }
    
    public static final class Factory
    {
        private final DataSource.Factory a;
        private LoadErrorHandlingPolicy b;
        private boolean c;
        private Object d;
        private String e;
        
        public Factory(final DataSource.Factory factory) {
            this.a = Assertions.e(factory);
            this.b = new DefaultLoadErrorHandlingPolicy();
            this.c = true;
        }
        
        public SingleSampleMediaSource a(final MediaItem.SubtitleConfiguration subtitleConfiguration, final long n) {
            return new SingleSampleMediaSource(this.e, subtitleConfiguration, this.a, n, this.b, this.c, this.d, null);
        }
        
        public Factory b(LoadErrorHandlingPolicy b) {
            if (b == null) {
                b = new DefaultLoadErrorHandlingPolicy();
            }
            this.b = b;
            return this;
        }
    }
}
