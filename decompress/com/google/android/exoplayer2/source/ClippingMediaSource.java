// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.exoplayer2.source;

import com.google.android.exoplayer2.util.Util;
import java.lang.annotation.ElementType;
import java.lang.annotation.Target;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Retention;
import java.lang.annotation.Documented;
import com.google.android.exoplayer2.upstream.Allocator;
import com.google.android.exoplayer2.upstream.TransferListener;
import java.io.IOException;
import com.google.android.exoplayer2.MediaItem;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.Timeline;
import java.util.ArrayList;

public final class ClippingMediaSource extends CompositeMediaSource<Void>
{
    private final boolean A;
    private final ArrayList<ClippingMediaPeriod> B;
    private final Timeline.Window C;
    private a D;
    private IllegalClippingException E;
    private long F;
    private long G;
    private final MediaSource p;
    private final long w;
    private final long x;
    private final boolean y;
    private final boolean z;
    
    public ClippingMediaSource(final MediaSource mediaSource, final long w, final long x, final boolean y, final boolean z, final boolean a) {
        Assertions.a(w >= 0L);
        this.p = Assertions.e(mediaSource);
        this.w = w;
        this.x = x;
        this.y = y;
        this.z = z;
        this.A = a;
        this.B = new ArrayList<ClippingMediaPeriod>();
        this.C = new Timeline.Window();
    }
    
    private void A0(final Timeline timeline) {
        final Timeline.Window c = this.C;
        final int n = 0;
        timeline.r(0, c);
        final long h = this.C.h();
        final a d = this.D;
        long g = Long.MIN_VALUE;
        long n2;
        long n3;
        if (d != null && !this.B.isEmpty() && !this.z) {
            final long f = this.F;
            if (this.x == Long.MIN_VALUE) {
                n2 = g;
            }
            else {
                n2 = this.G - h;
            }
            n3 = f - h;
        }
        else {
            final long w = this.w;
            final long x = this.x;
            n3 = w;
            n2 = x;
            if (this.A) {
                final long f2 = this.C.f();
                n3 = w + f2;
                n2 = x + f2;
            }
            this.F = h + n3;
            if (this.x != Long.MIN_VALUE) {
                g = h + n2;
            }
            this.G = g;
            for (int size = this.B.size(), i = 0; i < size; ++i) {
                this.B.get(i).u(this.F, this.G);
            }
        }
        try {
            this.n0(this.D = new a(timeline, n3, n2));
        }
        catch (final IllegalClippingException e) {
            this.E = e;
            for (int j = n; j < this.B.size(); ++j) {
                this.B.get(j).s(this.E);
            }
        }
    }
    
    @Override
    public MediaItem F() {
        return this.p.F();
    }
    
    @Override
    public void I(final MediaPeriod mediaPeriod) {
        Assertions.g(this.B.remove(mediaPeriod));
        this.p.I(((ClippingMediaPeriod)mediaPeriod).a);
        if (this.B.isEmpty() && !this.z) {
            this.A0(Assertions.e(this.D).c);
        }
    }
    
    @Override
    public void U() throws IOException {
        final IllegalClippingException e = this.E;
        if (e == null) {
            super.U();
            return;
        }
        throw e;
    }
    
    @Override
    protected void m0(final TransferListener transferListener) {
        super.m0(transferListener);
        this.x0(null, this.p);
    }
    
    @Override
    protected void o0() {
        super.o0();
        this.E = null;
        this.D = null;
    }
    
    @Override
    public MediaPeriod u(final MediaPeriodId mediaPeriodId, final Allocator allocator, final long n) {
        final ClippingMediaPeriod clippingMediaPeriod = new ClippingMediaPeriod(this.p.u(mediaPeriodId, allocator, n), this.y, this.F, this.G);
        this.B.add(clippingMediaPeriod);
        return clippingMediaPeriod;
    }
    
    @Override
    protected /* bridge */ void w0(final Object o, final MediaSource mediaSource, final Timeline timeline) {
        this.z0((Void)o, mediaSource, timeline);
    }
    
    protected void z0(final Void void1, final MediaSource mediaSource, final Timeline timeline) {
        if (this.E != null) {
            return;
        }
        this.A0(timeline);
    }
    
    public static final class IllegalClippingException extends IOException
    {
        public static final int REASON_INVALID_PERIOD_COUNT = 0;
        public static final int REASON_NOT_SEEKABLE_TO_START = 1;
        public static final int REASON_START_EXCEEDS_END = 2;
        public final int reason;
        
        public IllegalClippingException(final int reason) {
            final StringBuilder sb = new StringBuilder();
            sb.append("Illegal clipping: ");
            sb.append(a(reason));
            super(sb.toString());
            this.reason = reason;
        }
        
        private static String a(final int n) {
            if (n == 0) {
                return "invalid period count";
            }
            if (n == 1) {
                return "not seekable to start";
            }
            if (n != 2) {
                return "unknown";
            }
            return "start exceeds end";
        }
        
        @Documented
        @Retention(RetentionPolicy.SOURCE)
        @Target({ ElementType.TYPE_USE })
        public @interface Reason {
        }
    }
    
    private static final class a extends ForwardingTimeline
    {
        private final long d;
        private final long e;
        private final long f;
        private final boolean g;
        
        public a(final Timeline timeline, long f, long e) throws IllegalClippingException {
            super(timeline);
            final int m = timeline.m();
            final boolean b = false;
            if (m != 1) {
                throw new IllegalClippingException(0);
            }
            final Window r = timeline.r(0, new Window());
            final long max = Math.max(0L, f);
            if (!r.w && max != 0L && !r.h) {
                throw new IllegalClippingException(1);
            }
            if (e == Long.MIN_VALUE) {
                f = r.y;
            }
            else {
                f = Math.max(0L, e);
            }
            final long y = r.y;
            e = f;
            if (y != -9223372036854775807L) {
                e = f;
                if (f > y) {
                    e = y;
                }
                if (max > e) {
                    throw new IllegalClippingException(2);
                }
            }
            this.d = max;
            this.e = e;
            final long n = lcmp(e, -9223372036854775807L);
            if (n == 0) {
                f = -9223372036854775807L;
            }
            else {
                f = e - max;
            }
            this.f = f;
            boolean g = b;
            Label_0236: {
                if (r.i) {
                    if (n != 0) {
                        g = b;
                        if (y == -9223372036854775807L) {
                            break Label_0236;
                        }
                        g = b;
                        if (e != y) {
                            break Label_0236;
                        }
                    }
                    g = true;
                }
            }
            this.g = g;
        }
        
        @Override
        public Period k(final int n, final Period period, final boolean b) {
            super.c.k(0, period, b);
            final long n2 = period.r() - this.d;
            final long f = this.f;
            long n3;
            if (f == -9223372036854775807L) {
                n3 = -9223372036854775807L;
            }
            else {
                n3 = f - n2;
            }
            return period.w(period.a, period.b, 0, n3, n2);
        }
        
        @Override
        public Window s(final int n, final Window window, long x) {
            super.c.s(0, window, 0L);
            final long b = window.B;
            x = this.d;
            window.B = b + x;
            window.y = this.f;
            window.i = this.g;
            final long x2 = window.x;
            if (x2 != -9223372036854775807L) {
                x = Math.max(x2, x);
                window.x = x;
                final long e = this.e;
                if (e != -9223372036854775807L) {
                    x = Math.min(x, e);
                }
                window.x = x - this.d;
            }
            x = Util.f1(this.d);
            final long e2 = window.e;
            if (e2 != -9223372036854775807L) {
                window.e = e2 + x;
            }
            final long f = window.f;
            if (f != -9223372036854775807L) {
                window.f = f + x;
            }
            return window;
        }
    }
}
