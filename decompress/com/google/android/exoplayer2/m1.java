// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.exoplayer2;

import com.google.common.collect.ImmutableList;
import com.google.android.exoplayer2.metadata.Metadata;
import java.util.List;
import com.google.android.exoplayer2.trackselection.TrackSelectorResult;
import com.google.android.exoplayer2.source.TrackGroupArray;
import com.google.android.exoplayer2.source.MediaSource;

final class m1
{
    private static final MediaSource.MediaPeriodId s;
    public final Timeline a;
    public final MediaSource.MediaPeriodId b;
    public final long c;
    public final long d;
    public final int e;
    public final ExoPlaybackException f;
    public final boolean g;
    public final TrackGroupArray h;
    public final TrackSelectorResult i;
    public final List<Metadata> j;
    public final MediaSource.MediaPeriodId k;
    public final boolean l;
    public final int m;
    public final PlaybackParameters n;
    public final boolean o;
    public volatile long p;
    public volatile long q;
    public volatile long r;
    
    static {
        s = new MediaSource.MediaPeriodId(new Object());
    }
    
    public m1(final Timeline a, final MediaSource.MediaPeriodId b, final long c, final long d, final int e, final ExoPlaybackException f, final boolean g, final TrackGroupArray h, final TrackSelectorResult i, final List<Metadata> j, final MediaSource.MediaPeriodId k, final boolean l, final int m, final PlaybackParameters n, final long p18, final long q, final long r, final boolean o) {
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
        this.k = k;
        this.l = l;
        this.m = m;
        this.n = n;
        this.p = p18;
        this.q = q;
        this.r = r;
        this.o = o;
    }
    
    public static m1 j(final TrackSelectorResult trackSelectorResult) {
        final Timeline a = Timeline.a;
        final MediaSource.MediaPeriodId s = m1.s;
        return new m1(a, s, -9223372036854775807L, 0L, 1, null, false, TrackGroupArray.d, trackSelectorResult, (List<Metadata>)ImmutableList.of(), s, false, 0, PlaybackParameters.d, 0L, 0L, 0L, false);
    }
    
    public static MediaSource.MediaPeriodId k() {
        return m1.s;
    }
    
    public m1 a(final boolean b) {
        return new m1(this.a, this.b, this.c, this.d, this.e, this.f, b, this.h, this.i, this.j, this.k, this.l, this.m, this.n, this.p, this.q, this.r, this.o);
    }
    
    public m1 b(final MediaSource.MediaPeriodId mediaPeriodId) {
        return new m1(this.a, this.b, this.c, this.d, this.e, this.f, this.g, this.h, this.i, this.j, mediaPeriodId, this.l, this.m, this.n, this.p, this.q, this.r, this.o);
    }
    
    public m1 c(final MediaSource.MediaPeriodId mediaPeriodId, final long n, final long n2, final long n3, final long n4, final TrackGroupArray trackGroupArray, final TrackSelectorResult trackSelectorResult, final List<Metadata> list) {
        return new m1(this.a, mediaPeriodId, n2, n3, this.e, this.f, this.g, trackGroupArray, trackSelectorResult, list, this.k, this.l, this.m, this.n, this.p, n4, n, this.o);
    }
    
    public m1 d(final boolean b, final int n) {
        return new m1(this.a, this.b, this.c, this.d, this.e, this.f, this.g, this.h, this.i, this.j, this.k, b, n, this.n, this.p, this.q, this.r, this.o);
    }
    
    public m1 e(final ExoPlaybackException ex) {
        return new m1(this.a, this.b, this.c, this.d, this.e, ex, this.g, this.h, this.i, this.j, this.k, this.l, this.m, this.n, this.p, this.q, this.r, this.o);
    }
    
    public m1 f(final PlaybackParameters playbackParameters) {
        return new m1(this.a, this.b, this.c, this.d, this.e, this.f, this.g, this.h, this.i, this.j, this.k, this.l, this.m, playbackParameters, this.p, this.q, this.r, this.o);
    }
    
    public m1 g(final int n) {
        return new m1(this.a, this.b, this.c, this.d, n, this.f, this.g, this.h, this.i, this.j, this.k, this.l, this.m, this.n, this.p, this.q, this.r, this.o);
    }
    
    public m1 h(final boolean b) {
        return new m1(this.a, this.b, this.c, this.d, this.e, this.f, this.g, this.h, this.i, this.j, this.k, this.l, this.m, this.n, this.p, this.q, this.r, b);
    }
    
    public m1 i(final Timeline timeline) {
        return new m1(timeline, this.b, this.c, this.d, this.e, this.f, this.g, this.h, this.i, this.j, this.k, this.l, this.m, this.n, this.p, this.q, this.r, this.o);
    }
}
