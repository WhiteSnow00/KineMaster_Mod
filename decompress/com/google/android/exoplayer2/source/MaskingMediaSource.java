// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.exoplayer2.source;

import com.google.android.exoplayer2.util.Util;
import com.google.android.exoplayer2.source.ads.AdPlaybackState;
import com.google.android.exoplayer2.upstream.Allocator;
import com.google.android.exoplayer2.upstream.TransferListener;
import com.google.android.exoplayer2.MediaItem;
import android.util.Pair;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.Timeline;

public final class MaskingMediaSource extends CompositeMediaSource<Void>
{
    private MaskingMediaPeriod A;
    private boolean B;
    private boolean C;
    private boolean D;
    private final MediaSource p;
    private final boolean w;
    private final Timeline.Window x;
    private final Timeline.Period y;
    private a z;
    
    public MaskingMediaSource(final MediaSource p2, final boolean b) {
        this.p = p2;
        this.w = (b && p2.V());
        this.x = new Timeline.Window();
        this.y = new Timeline.Period();
        final Timeline w = p2.W();
        if (w != null) {
            this.z = a.B(w, null, null);
            this.D = true;
        }
        else {
            this.z = a.A(p2.F());
        }
    }
    
    private Object A0(final Object o) {
        Object f = o;
        if (a.y(this.z) != null) {
            f = o;
            if (a.y(this.z).equals(o)) {
                f = a.f;
            }
        }
        return f;
    }
    
    private Object B0(final Object o) {
        Object y = o;
        if (a.y(this.z) != null) {
            y = o;
            if (o.equals(a.f)) {
                y = a.y(this.z);
            }
        }
        return y;
    }
    
    private void F0(final long n) {
        final MaskingMediaPeriod a = this.A;
        final int f = this.z.f(a.a.a);
        if (f == -1) {
            return;
        }
        final long d = this.z.j(f, this.y).d;
        long max = n;
        if (d != -9223372036854775807L) {
            max = n;
            if (n >= d) {
                max = Math.max(0L, d - 1L);
            }
        }
        a.u(max);
    }
    
    protected MediaPeriodId C0(final Void void1, final MediaPeriodId mediaPeriodId) {
        return mediaPeriodId.c(this.A0(mediaPeriodId.a));
    }
    
    public Timeline D0() {
        return this.z;
    }
    
    protected void E0(final Void void1, final MediaSource mediaSource, final Timeline timeline) {
        com.google.android.exoplayer2.source.MediaPeriodId c = null;
        Label_0293: {
            if (this.C) {
                this.z = this.z.z(timeline);
                final MaskingMediaPeriod a = this.A;
                if (a != null) {
                    this.F0(a.e());
                }
            }
            else if (timeline.u()) {
                a z;
                if (this.D) {
                    z = this.z.z(timeline);
                }
                else {
                    z = a.B(timeline, Timeline.Window.C, a.f);
                }
                this.z = z;
            }
            else {
                timeline.r(0, this.x);
                long f = this.x.f();
                final Object a2 = this.x.a;
                final MaskingMediaPeriod a3 = this.A;
                if (a3 != null) {
                    final long r = a3.r();
                    this.z.l(this.A.a.a, this.y);
                    final long n = this.y.r() + r;
                    if (n != this.z.r(0, this.x).f()) {
                        f = n;
                    }
                }
                final Pair<Object, Long> n2 = timeline.n(this.x, this.y, 0, f);
                final Object first = n2.first;
                final long longValue = (long)n2.second;
                a z2;
                if (this.D) {
                    z2 = this.z.z(timeline);
                }
                else {
                    z2 = a.B(timeline, a2, first);
                }
                this.z = z2;
                final MaskingMediaPeriod a4 = this.A;
                if (a4 != null) {
                    this.F0(longValue);
                    final MediaPeriodId a5 = a4.a;
                    c = a5.c(this.B0(a5.a));
                    break Label_0293;
                }
            }
            c = null;
        }
        this.D = true;
        this.C = true;
        this.n0(this.z);
        if (c != null) {
            Assertions.e(this.A).a((MediaPeriodId)c);
        }
    }
    
    @Override
    public MediaItem F() {
        return this.p.F();
    }
    
    @Override
    public void I(final MediaPeriod mediaPeriod) {
        ((MaskingMediaPeriod)mediaPeriod).v();
        if (mediaPeriod == this.A) {
            this.A = null;
        }
    }
    
    @Override
    public void U() {
    }
    
    public void m0(final TransferListener transferListener) {
        super.m0(transferListener);
        if (!this.w) {
            this.B = true;
            this.x0(null, this.p);
        }
    }
    
    public void o0() {
        this.C = false;
        this.B = false;
        super.o0();
    }
    
    @Override
    protected /* bridge */ MediaPeriodId s0(final Object o, final MediaPeriodId mediaPeriodId) {
        return this.C0((Void)o, mediaPeriodId);
    }
    
    @Override
    public /* bridge */ MediaPeriod u(final MediaPeriodId mediaPeriodId, final Allocator allocator, final long n) {
        return this.z0(mediaPeriodId, allocator, n);
    }
    
    @Override
    protected /* bridge */ void w0(final Object o, final MediaSource mediaSource, final Timeline timeline) {
        this.E0((Void)o, mediaSource, timeline);
    }
    
    public MaskingMediaPeriod z0(final MediaPeriodId mediaPeriodId, final Allocator allocator, final long n) {
        final MaskingMediaPeriod a = new MaskingMediaPeriod(mediaPeriodId, allocator, n);
        a.w(this.p);
        if (this.C) {
            a.a(mediaPeriodId.c(this.B0(mediaPeriodId.a)));
        }
        else {
            this.A = a;
            if (!this.B) {
                this.B = true;
                this.x0(null, this.p);
            }
        }
        return a;
    }
    
    public static final class PlaceholderTimeline extends Timeline
    {
        private final MediaItem c;
        
        public PlaceholderTimeline(final MediaItem c) {
            this.c = c;
        }
        
        @Override
        public int f(final Object o) {
            int n;
            if (o == MaskingMediaSource.a.f) {
                n = 0;
            }
            else {
                n = -1;
            }
            return n;
        }
        
        @Override
        public Period k(final int n, final Period period, final boolean b) {
            Object f = null;
            Integer value;
            if (b) {
                value = 0;
            }
            else {
                value = null;
            }
            if (b) {
                f = MaskingMediaSource.a.f;
            }
            period.x(value, f, 0, -9223372036854775807L, 0L, AdPlaybackState.g, true);
            return period;
        }
        
        @Override
        public int m() {
            return 1;
        }
        
        @Override
        public Object q(final int n) {
            return MaskingMediaSource.a.f;
        }
        
        @Override
        public Window s(final int n, final Window window, final long n2) {
            window.k(Window.C, this.c, null, -9223372036854775807L, -9223372036854775807L, -9223372036854775807L, false, true, null, 0L, -9223372036854775807L, 0, 0, 0L);
            window.w = true;
            return window;
        }
        
        @Override
        public int t() {
            return 1;
        }
    }
    
    private static final class a extends ForwardingTimeline
    {
        public static final Object f;
        private final Object d;
        private final Object e;
        
        static {
            f = new Object();
        }
        
        private a(final Timeline timeline, final Object d, final Object e) {
            super(timeline);
            this.d = d;
            this.e = e;
        }
        
        public static a A(final MediaItem mediaItem) {
            return new a(new PlaceholderTimeline(mediaItem), Window.C, a.f);
        }
        
        public static a B(final Timeline timeline, final Object o, final Object o2) {
            return new a(timeline, o, o2);
        }
        
        static Object y(final a a) {
            return a.e;
        }
        
        @Override
        public int f(final Object o) {
            final Timeline c = super.c;
            Object o2 = o;
            if (a.f.equals(o)) {
                final Object e = this.e;
                o2 = o;
                if (e != null) {
                    o2 = e;
                }
            }
            return c.f(o2);
        }
        
        @Override
        public Period k(final int n, final Period period, final boolean b) {
            super.c.k(n, period, b);
            if (Util.c(period.b, this.e) && b) {
                period.b = a.f;
            }
            return period;
        }
        
        @Override
        public Object q(final int n) {
            Object o;
            if (Util.c(o = super.c.q(n), this.e)) {
                o = a.f;
            }
            return o;
        }
        
        @Override
        public Window s(final int n, final Window window, final long n2) {
            super.c.s(n, window, n2);
            if (Util.c(window.a, this.d)) {
                window.a = Window.C;
            }
            return window;
        }
        
        public a z(final Timeline timeline) {
            return new a(timeline, this.d, this.e);
        }
    }
}
