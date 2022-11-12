// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.exoplayer2.source;

import java.lang.annotation.ElementType;
import java.lang.annotation.Target;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Retention;
import java.lang.annotation.Documented;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.upstream.Allocator;
import java.util.Collections;
import com.google.android.exoplayer2.upstream.TransferListener;
import java.io.IOException;
import java.util.Iterator;
import com.google.common.collect.MultimapBuilder;
import java.util.HashMap;
import java.util.Collection;
import java.util.Arrays;
import java.util.ArrayList;
import com.google.android.exoplayer2.Timeline;
import com.google.common.collect.Multimap;
import java.util.Map;
import com.google.android.exoplayer2.MediaItem;

public final class MergingMediaSource extends CompositeMediaSource<Integer>
{
    private static final MediaItem G;
    private final CompositeSequenceableLoaderFactory A;
    private final Map<Object, Long> B;
    private final Multimap<Object, ClippingMediaPeriod> C;
    private int D;
    private long[][] E;
    private IllegalMergeException F;
    private final boolean p;
    private final boolean w;
    private final MediaSource[] x;
    private final Timeline[] y;
    private final ArrayList<MediaSource> z;
    
    static {
        G = new MediaItem.Builder().e("MergingMediaSource").a();
    }
    
    public MergingMediaSource(final boolean p4, final boolean w, final CompositeSequenceableLoaderFactory a, final MediaSource... x) {
        this.p = p4;
        this.w = w;
        this.x = x;
        this.A = a;
        this.z = new ArrayList<MediaSource>(Arrays.asList(x));
        this.D = -1;
        this.y = new Timeline[x.length];
        this.E = new long[0][];
        this.B = new HashMap<Object, Long>();
        this.C = (Multimap<Object, ClippingMediaPeriod>)MultimapBuilder.a().a().e();
    }
    
    public MergingMediaSource(final boolean b, final boolean b2, final MediaSource... array) {
        this(b, b2, new DefaultCompositeSequenceableLoaderFactory(), array);
    }
    
    public MergingMediaSource(final boolean b, final MediaSource... array) {
        this(b, false, array);
    }
    
    public MergingMediaSource(final MediaSource... array) {
        this(false, array);
    }
    
    private void C0() {
        final Timeline.Period period = new Timeline.Period();
        for (int i = 0; i < this.D; ++i) {
            int n = 0;
            long n2 = Long.MIN_VALUE;
            Timeline[] y;
            while (true) {
                y = this.y;
                if (n >= y.length) {
                    break;
                }
                final long n3 = y[n].j(i, period).n();
                long n4 = 0L;
                Label_0103: {
                    if (n3 == -9223372036854775807L) {
                        n4 = n2;
                    }
                    else {
                        final long n5 = n3 + this.E[i][n];
                        if (n2 != Long.MIN_VALUE) {
                            n4 = n2;
                            if (n5 >= n2) {
                                break Label_0103;
                            }
                        }
                        n4 = n5;
                    }
                }
                ++n;
                n2 = n4;
            }
            final Object q = y[0].q(i);
            this.B.put(q, n2);
            final Iterator iterator = this.C.get(q).iterator();
            while (iterator.hasNext()) {
                ((ClippingMediaPeriod)iterator.next()).u(0L, n2);
            }
        }
    }
    
    private void z0() {
        final Timeline.Period period = new Timeline.Period();
        for (int i = 0; i < this.D; ++i) {
            final long n = -this.y[0].j(i, period).r();
            int n2 = 1;
            while (true) {
                final Timeline[] y = this.y;
                if (n2 >= y.length) {
                    break;
                }
                this.E[i][n2] = n - -y[n2].j(i, period).r();
                ++n2;
            }
        }
    }
    
    protected MediaPeriodId A0(final Integer n, MediaPeriodId mediaPeriodId) {
        if (n != 0) {
            mediaPeriodId = null;
        }
        return mediaPeriodId;
    }
    
    protected void B0(final Integer n, final MediaSource mediaSource, final Timeline timeline) {
        if (this.F != null) {
            return;
        }
        if (this.D == -1) {
            this.D = timeline.m();
        }
        else if (timeline.m() != this.D) {
            this.F = new IllegalMergeException(0);
            return;
        }
        if (this.E.length == 0) {
            this.E = new long[this.D][this.y.length];
        }
        this.z.remove(mediaSource);
        this.y[n] = timeline;
        if (this.z.isEmpty()) {
            if (this.p) {
                this.z0();
            }
            Timeline timeline2 = this.y[0];
            if (this.w) {
                this.C0();
                timeline2 = new a(timeline2, this.B);
            }
            this.n0(timeline2);
        }
    }
    
    @Override
    public MediaItem F() {
        final MediaSource[] x = this.x;
        MediaItem mediaItem;
        if (x.length > 0) {
            mediaItem = x[0].F();
        }
        else {
            mediaItem = MergingMediaSource.G;
        }
        return mediaItem;
    }
    
    @Override
    public void I(final MediaPeriod mediaPeriod) {
        MediaPeriod a = mediaPeriod;
        if (this.w) {
            final ClippingMediaPeriod clippingMediaPeriod = (ClippingMediaPeriod)mediaPeriod;
            for (final Map.Entry<K, ClippingMediaPeriod> entry : this.C.entries()) {
                if (entry.getValue().equals(clippingMediaPeriod)) {
                    this.C.remove((Object)entry.getKey(), (Object)entry.getValue());
                    break;
                }
            }
            a = clippingMediaPeriod.a;
        }
        final p p = (p)a;
        int n = 0;
        while (true) {
            final MediaSource[] x = this.x;
            if (n >= x.length) {
                break;
            }
            x[n].I(p.a(n));
            ++n;
        }
    }
    
    @Override
    public void U() throws IOException {
        final IllegalMergeException f = this.F;
        if (f == null) {
            super.U();
            return;
        }
        throw f;
    }
    
    @Override
    protected void m0(final TransferListener transferListener) {
        super.m0(transferListener);
        for (int i = 0; i < this.x.length; ++i) {
            this.x0(i, this.x[i]);
        }
    }
    
    @Override
    protected void o0() {
        super.o0();
        Arrays.fill(this.y, null);
        this.D = -1;
        this.F = null;
        this.z.clear();
        Collections.addAll(this.z, this.x);
    }
    
    @Override
    protected /* bridge */ MediaPeriodId s0(final Object o, final MediaPeriodId mediaPeriodId) {
        return this.A0((Integer)o, mediaPeriodId);
    }
    
    @Override
    public MediaPeriod u(final MediaPeriodId mediaPeriodId, final Allocator allocator, final long n) {
        final int length = this.x.length;
        final MediaPeriod[] array = new MediaPeriod[length];
        final Timeline[] y = this.y;
        int i = 0;
        final int f = y[0].f(mediaPeriodId.a);
        while (i < length) {
            array[i] = this.x[i].u(mediaPeriodId.c(this.y[i].q(f)), allocator, n - this.E[f][i]);
            ++i;
        }
        MediaPeriod mediaPeriod;
        final p p3 = (p)(mediaPeriod = new p(this.A, this.E[f], array));
        if (this.w) {
            mediaPeriod = new ClippingMediaPeriod(p3, true, 0L, Assertions.e(this.B.get(mediaPeriodId.a)));
            this.C.put(mediaPeriodId.a, (Object)mediaPeriod);
        }
        return mediaPeriod;
    }
    
    @Override
    protected /* bridge */ void w0(final Object o, final MediaSource mediaSource, final Timeline timeline) {
        this.B0((Integer)o, mediaSource, timeline);
    }
    
    public static final class IllegalMergeException extends IOException
    {
        public static final int REASON_PERIOD_COUNT_MISMATCH = 0;
        public final int reason;
        
        public IllegalMergeException(final int reason) {
            this.reason = reason;
        }
        
        @Documented
        @Retention(RetentionPolicy.SOURCE)
        @Target({ ElementType.TYPE_USE })
        public @interface Reason {
        }
    }
    
    private static final class a extends ForwardingTimeline
    {
        private final long[] d;
        private final long[] e;
        
        public a(final Timeline timeline, final Map<Object, Long> map) {
            super(timeline);
            final int t = timeline.t();
            this.e = new long[timeline.t()];
            final Window window = new Window();
            final int n = 0;
            for (int i = 0; i < t; ++i) {
                this.e[i] = timeline.r(i, window).y;
            }
            final int m = timeline.m();
            this.d = new long[m];
            final Period period = new Period();
            for (int j = n; j < m; ++j) {
                timeline.k(j, period, true);
                long n2 = Assertions.e(map.get(period.b));
                final long[] d = this.d;
                if (n2 == Long.MIN_VALUE) {
                    n2 = period.d;
                }
                d[j] = n2;
                final long d2 = period.d;
                if (d2 != -9223372036854775807L) {
                    final long[] e = this.e;
                    final int c = period.c;
                    e[c] -= d2 - d[j];
                }
            }
        }
        
        @Override
        public Period k(final int n, final Period period, final boolean b) {
            super.k(n, period, b);
            period.d = this.d[n];
            return period;
        }
        
        @Override
        public Window s(final int n, final Window window, long n2) {
            super.s(n, window, n2);
            n2 = this.e[n];
            window.y = n2;
            Label_0061: {
                if (n2 != -9223372036854775807L) {
                    final long x = window.x;
                    if (x != -9223372036854775807L) {
                        n2 = Math.min(x, n2);
                        break Label_0061;
                    }
                }
                n2 = window.x;
            }
            window.x = n2;
            return window;
        }
    }
}
