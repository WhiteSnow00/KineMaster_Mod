// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.exoplayer2.trackselection;

import com.google.common.collect.Multimap;
import java.util.AbstractCollection;
import com.google.android.exoplayer2.Timeline;
import com.google.android.exoplayer2.source.MediaSource;
import com.google.android.exoplayer2.util.Util;
import com.google.common.collect.ListMultimap;
import com.google.common.collect.MultimapBuilder;
import java.util.Arrays;
import com.google.android.exoplayer2.source.chunk.MediaChunkIterator;
import com.google.common.collect.Iterables;
import com.google.common.collect.ImmutableList$Builder;
import java.util.ArrayList;
import com.google.android.exoplayer2.Format;
import java.util.Collection;
import com.google.android.exoplayer2.util.Log;
import java.util.List;
import com.google.android.exoplayer2.source.TrackGroup;
import com.google.android.exoplayer2.source.chunk.MediaChunk;
import com.google.android.exoplayer2.util.Clock;
import com.google.common.collect.ImmutableList;
import com.google.android.exoplayer2.upstream.BandwidthMeter;

public class AdaptiveTrackSelection extends BaseTrackSelection
{
    private final BandwidthMeter h;
    private final long i;
    private final long j;
    private final long k;
    private final int l;
    private final int m;
    private final float n;
    private final float o;
    private final ImmutableList<AdaptationCheckpoint> p;
    private final Clock q;
    private float r;
    private int s;
    private int t;
    private long u;
    private MediaChunk v;
    
    protected AdaptiveTrackSelection(final TrackGroup trackGroup, final int[] array, final int n, final BandwidthMeter h, final long n2, final long n3, long n4, final int l, final int m, final float n5, final float o, final List<AdaptationCheckpoint> list, final Clock q) {
        super(trackGroup, array, n);
        if (n4 < n2) {
            Log.i("AdaptiveTrackSelection", "Adjusting minDurationToRetainAfterDiscardMs to be at least minDurationForQualityIncreaseMs");
            n4 = n2;
        }
        this.h = h;
        this.i = n2 * 1000L;
        this.j = n3 * 1000L;
        this.k = n4 * 1000L;
        this.l = l;
        this.m = m;
        this.n = n5;
        this.o = o;
        this.p = (ImmutableList<AdaptationCheckpoint>)ImmutableList.copyOf((Collection)list);
        this.q = q;
        this.r = 1.0f;
        this.t = 0;
        this.u = -9223372036854775807L;
    }
    
    private int A(final long n, long c) {
        c = this.C(c);
        int i = 0;
        int n2 = 0;
        while (i < super.b) {
            if (n == Long.MIN_VALUE || !this.c(i, n)) {
                final Format f = this.f(i);
                if (this.z(f, f.h, c)) {
                    return i;
                }
                n2 = i;
            }
            ++i;
        }
        return n2;
    }
    
    private static ImmutableList<ImmutableList<AdaptationCheckpoint>> B(final Definition[] array) {
        final ArrayList list = new ArrayList();
        final int n = 0;
        for (int i = 0; i < array.length; ++i) {
            if (array[i] != null && array[i].b.length > 1) {
                final ImmutableList$Builder builder = ImmutableList.builder();
                builder.i((Object)new AdaptationCheckpoint(0L, 0L));
                list.add(builder);
            }
            else {
                list.add(null);
            }
        }
        final long[][] g = G(array);
        final int[] array2 = new int[g.length];
        final long[] array3 = new long[g.length];
        for (int j = 0; j < g.length; ++j) {
            long n2;
            if (g[j].length == 0) {
                n2 = 0L;
            }
            else {
                n2 = g[j][0];
            }
            array3[j] = n2;
        }
        y(list, array3);
        final ImmutableList<Integer> h = H(g);
        for (int k = 0; k < ((AbstractCollection)h).size(); ++k) {
            final int intValue = ((List<Integer>)h).get(k);
            final int n3 = array2[intValue] + 1;
            array2[intValue] = n3;
            array3[intValue] = g[intValue][n3];
            y(list, array3);
        }
        for (int l = 0; l < array.length; ++l) {
            if (list.get(l) != null) {
                array3[l] *= 2L;
            }
        }
        y(list, array3);
        final ImmutableList$Builder builder2 = ImmutableList.builder();
        for (int n4 = n; n4 < list.size(); ++n4) {
            final ImmutableList$Builder immutableList$Builder = (ImmutableList$Builder)list.get(n4);
            ImmutableList list2;
            if (immutableList$Builder == null) {
                list2 = ImmutableList.of();
            }
            else {
                list2 = immutableList$Builder.l();
            }
            builder2.i((Object)list2);
        }
        return (ImmutableList<ImmutableList<AdaptationCheckpoint>>)builder2.l();
    }
    
    private long C(long n) {
        final long i = this.I(n);
        if (((AbstractCollection)this.p).isEmpty()) {
            return i;
        }
        int n2;
        for (n2 = 1; n2 < ((AbstractCollection)this.p).size() - 1 && this.p.get(n2).a < i; ++n2) {}
        final AdaptationCheckpoint adaptationCheckpoint = ((List<AdaptationCheckpoint>)this.p).get(n2 - 1);
        final AdaptationCheckpoint adaptationCheckpoint2 = ((List<AdaptationCheckpoint>)this.p).get(n2);
        n = adaptationCheckpoint.a;
        final float n3 = (i - n) / (float)(adaptationCheckpoint2.a - n);
        n = adaptationCheckpoint.b;
        return n + (long)(n3 * (adaptationCheckpoint2.b - n));
    }
    
    private long D(final List<? extends MediaChunk> list) {
        final boolean empty = list.isEmpty();
        final long n = -9223372036854775807L;
        if (empty) {
            return -9223372036854775807L;
        }
        final MediaChunk mediaChunk = (MediaChunk)Iterables.h((Iterable)list);
        final long g = mediaChunk.g;
        long n2 = n;
        if (g != -9223372036854775807L) {
            final long h = mediaChunk.h;
            n2 = n;
            if (h != -9223372036854775807L) {
                n2 = h - g;
            }
        }
        return n2;
    }
    
    private long F(final MediaChunkIterator[] array, final List<? extends MediaChunk> list) {
        final int s = this.s;
        if (s < array.length && array[s].next()) {
            final MediaChunkIterator mediaChunkIterator = array[this.s];
            return mediaChunkIterator.b() - mediaChunkIterator.a();
        }
        for (final MediaChunkIterator mediaChunkIterator2 : array) {
            if (mediaChunkIterator2.next()) {
                return mediaChunkIterator2.b() - mediaChunkIterator2.a();
            }
        }
        return this.D(list);
    }
    
    private static long[][] G(final Definition[] array) {
        final long[][] array2 = new long[array.length][];
        for (int i = 0; i < array.length; ++i) {
            final Definition definition = array[i];
            if (definition == null) {
                array2[i] = new long[0];
            }
            else {
                array2[i] = new long[definition.b.length];
                int n = 0;
                while (true) {
                    final int[] b = definition.b;
                    if (n >= b.length) {
                        break;
                    }
                    array2[i][n] = definition.a.c(b[n]).h;
                    ++n;
                }
                Arrays.sort(array2[i]);
            }
        }
        return array2;
    }
    
    private static ImmutableList<Integer> H(final long[][] array) {
        final ListMultimap e = MultimapBuilder.c().a().e();
        for (int i = 0; i < array.length; ++i) {
            if (array[i].length > 1) {
                int length = array[i].length;
                final double[] array2 = new double[length];
                int n = 0;
                while (true) {
                    final int length2 = array[i].length;
                    double log = 0.0;
                    if (n >= length2) {
                        break;
                    }
                    if (array[i][n] != -1L) {
                        log = Math.log((double)array[i][n]);
                    }
                    array2[n] = log;
                    ++n;
                }
                --length;
                final double n2 = array2[length] - array2[0];
                int j = 0;
                while (j < length) {
                    final double n3 = array2[j];
                    ++j;
                    final double n4 = array2[j];
                    double n5;
                    if (n2 == 0.0) {
                        n5 = 1.0;
                    }
                    else {
                        n5 = ((n3 + n4) * 0.5 - array2[0]) / n2;
                    }
                    ((Multimap)e).put((Object)n5, (Object)i);
                }
            }
        }
        return (ImmutableList<Integer>)ImmutableList.copyOf(((Multimap)e).values());
    }
    
    private long I(final long n) {
        final long n2 = (long)(this.h.e() * this.n);
        final long a = this.h.a();
        if (a != -9223372036854775807L && n != -9223372036854775807L) {
            final float n3 = (float)n;
            return (long)(n2 * Math.max(n3 / this.r - a, 0.0f) / n3);
        }
        return (long)(n2 / this.r);
    }
    
    private long J(final long n, final long n2) {
        if (n == -9223372036854775807L) {
            return this.i;
        }
        long n3 = n;
        if (n2 != -9223372036854775807L) {
            n3 = n - n2;
        }
        return Math.min((long)(n3 * this.o), this.i);
    }
    
    static ImmutableList x(final Definition[] array) {
        return B(array);
    }
    
    private static void y(final List<ImmutableList$Builder<AdaptationCheckpoint>> list, final long[] array) {
        final int n = 0;
        long n2 = 0L;
        int n3 = 0;
        int i;
        while (true) {
            i = n;
            if (n3 >= array.length) {
                break;
            }
            n2 += array[n3];
            ++n3;
        }
        while (i < list.size()) {
            final ImmutableList$Builder immutableList$Builder = list.get(i);
            if (immutableList$Builder != null) {
                immutableList$Builder.i((Object)new AdaptationCheckpoint(n2, array[i]));
            }
            ++i;
        }
    }
    
    protected long E() {
        return this.k;
    }
    
    protected boolean K(final long n, final List<? extends MediaChunk> list) {
        final long u = this.u;
        return u == -9223372036854775807L || n - u >= 1000L || (!list.isEmpty() && !Iterables.h((Iterable)list).equals(this.v));
    }
    
    @Override
    public int a() {
        return this.s;
    }
    
    @Override
    public void e() {
        this.v = null;
    }
    
    @Override
    public void h(final float r) {
        this.r = r;
    }
    
    @Override
    public Object i() {
        return null;
    }
    
    @Override
    public void n() {
        this.u = -9223372036854775807L;
        this.v = null;
    }
    
    @Override
    public int o(final long n, final List<? extends MediaChunk> list) {
        final long c = this.q.c();
        if (!this.K(c, list)) {
            return list.size();
        }
        this.u = c;
        MediaChunk v;
        if (list.isEmpty()) {
            v = null;
        }
        else {
            v = (MediaChunk)Iterables.h((Iterable)list);
        }
        this.v = v;
        final boolean empty = list.isEmpty();
        int i = 0;
        if (empty) {
            return 0;
        }
        final int size = list.size();
        final long f0 = Util.f0(list.get(size - 1).g - n, this.r);
        final long e = this.E();
        if (f0 < e) {
            return size;
        }
        final Format f2 = this.f(this.A(c, this.D(list)));
        while (i < size) {
            final MediaChunk mediaChunk = list.get(i);
            final Format d = mediaChunk.d;
            if (Util.f0(mediaChunk.g - n, this.r) >= e && d.h < f2.h) {
                final int c2 = d.C;
                if (c2 != -1 && c2 <= this.m) {
                    final int b = d.B;
                    if (b != -1 && b <= this.l && c2 < f2.C) {
                        return i;
                    }
                }
            }
            ++i;
        }
        return size;
    }
    
    @Override
    public void q(long n, final long n2, final long n3, final List<? extends MediaChunk> list, final MediaChunkIterator[] array) {
        final long c = this.q.c();
        n = this.F(array, list);
        int t = this.t;
        if (t == 0) {
            this.t = 1;
            this.s = this.A(c, n);
            return;
        }
        int s = this.s;
        int p5;
        if (list.isEmpty()) {
            p5 = -1;
        }
        else {
            p5 = this.p(((MediaChunk)Iterables.h((Iterable)list)).d);
        }
        if (p5 != -1) {
            t = ((MediaChunk)Iterables.h((Iterable)list)).e;
            s = p5;
        }
        int a;
        final int n4 = a = this.A(c, n);
        Label_0216: {
            if (!this.c(s, c)) {
                final Format f = this.f(s);
                final Format f2 = this.f(n4);
                n = this.J(n3, n);
                final int h = f2.h;
                final int h2 = f.h;
                if (h <= h2 || n2 >= n) {
                    a = n4;
                    if (h >= h2) {
                        break Label_0216;
                    }
                    a = n4;
                    if (n2 < this.j) {
                        break Label_0216;
                    }
                }
                a = s;
            }
        }
        if (a != s) {
            t = 3;
        }
        this.t = t;
        this.s = a;
    }
    
    @Override
    public int t() {
        return this.t;
    }
    
    protected boolean z(final Format format, final int n, final long n2) {
        return n <= n2;
    }
    
    public static final class AdaptationCheckpoint
    {
        public final long a;
        public final long b;
        
        public AdaptationCheckpoint(final long a, final long b) {
            this.a = a;
            this.b = b;
        }
        
        @Override
        public boolean equals(final Object o) {
            boolean b = true;
            if (this == o) {
                return true;
            }
            if (!(o instanceof AdaptationCheckpoint)) {
                return false;
            }
            final AdaptationCheckpoint adaptationCheckpoint = (AdaptationCheckpoint)o;
            if (this.a != adaptationCheckpoint.a || this.b != adaptationCheckpoint.b) {
                b = false;
            }
            return b;
        }
        
        @Override
        public int hashCode() {
            return (int)this.a * 31 + (int)this.b;
        }
    }
    
    public static class Factory implements ExoTrackSelection.Factory
    {
        private final int a;
        private final int b;
        private final int c;
        private final int d;
        private final int e;
        private final float f;
        private final float g;
        private final Clock h;
        
        public Factory() {
            this(10000, 25000, 25000, 0.7f);
        }
        
        public Factory(final int n, final int n2, final int n3, final float n4) {
            this(n, n2, n3, 1279, 719, n4, 0.75f, Clock.a);
        }
        
        public Factory(final int a, final int b, final int c, final int d, final int e, final float f, final float g, final Clock h) {
            this.a = a;
            this.b = b;
            this.c = c;
            this.d = d;
            this.e = e;
            this.f = f;
            this.g = g;
            this.h = h;
        }
        
        @Override
        public final ExoTrackSelection[] a(final Definition[] array, final BandwidthMeter bandwidthMeter, final MediaSource.MediaPeriodId mediaPeriodId, final Timeline timeline) {
            final ImmutableList x = AdaptiveTrackSelection.x(array);
            final ExoTrackSelection[] array2 = new ExoTrackSelection[array.length];
            for (int i = 0; i < array.length; ++i) {
                final Definition definition = array[i];
                if (definition != null) {
                    final int[] b = definition.b;
                    if (b.length != 0) {
                        BaseTrackSelection b2;
                        if (b.length == 1) {
                            b2 = new FixedTrackSelection(definition.a, b[0], definition.c);
                        }
                        else {
                            b2 = this.b(definition.a, b, definition.c, bandwidthMeter, (ImmutableList<AdaptationCheckpoint>)((List<ImmutableList>)x).get(i));
                        }
                        array2[i] = b2;
                    }
                }
            }
            return array2;
        }
        
        protected AdaptiveTrackSelection b(final TrackGroup trackGroup, final int[] array, final int n, final BandwidthMeter bandwidthMeter, final ImmutableList<AdaptationCheckpoint> list) {
            return new AdaptiveTrackSelection(trackGroup, array, n, bandwidthMeter, this.a, this.b, this.c, this.d, this.e, this.f, this.g, (List<AdaptationCheckpoint>)list, this.h);
        }
    }
}
