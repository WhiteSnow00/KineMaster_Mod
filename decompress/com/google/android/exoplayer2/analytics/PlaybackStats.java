// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.exoplayer2.analytics;

import com.google.android.exoplayer2.Format;
import java.util.Collections;
import java.util.List;

public final class PlaybackStats
{
    public static final PlaybackStats O;
    public final int A;
    public final long B;
    public final int C;
    public final long D;
    public final long E;
    public final long F;
    public final long G;
    public final long H;
    public final int I;
    public final int J;
    public final int K;
    public final List<EventTimeAndException> L;
    public final List<EventTimeAndException> M;
    private final long[] N;
    public final int a;
    public final List<EventTimeAndPlaybackState> b;
    public final List<long[]> c;
    public final long d;
    public final int e;
    public final int f;
    public final int g;
    public final int h;
    public final long i;
    public final int j;
    public final int k;
    public final int l;
    public final int m;
    public final int n;
    public final long o;
    public final int p;
    public final List<EventTimeAndFormat> q;
    public final List<EventTimeAndFormat> r;
    public final long s;
    public final long t;
    public final long u;
    public final long v;
    public final long w;
    public final long x;
    public final int y;
    public final int z;
    
    static {
        O = a(new PlaybackStats[0]);
    }
    
    PlaybackStats(final int a, final long[] n, final List<EventTimeAndPlaybackState> list, final List<long[]> list2, final long d, final int e, final int f, final int g, final int h, final long i, final int j, final int k, final int l, final int m, final int n2, final long o, final int p40, final List<EventTimeAndFormat> list3, final List<EventTimeAndFormat> list4, final long s, final long t, final long u, final long v, final long w, final long x, final int y, final int z, final int a2, final long b, final int c, final long d2, final long e2, final long f2, final long g2, final long h2, final int i2, final int j2, final int k2, final List<EventTimeAndException> list5, final List<EventTimeAndException> list6) {
        this.a = a;
        this.N = n;
        this.b = Collections.unmodifiableList((List<? extends EventTimeAndPlaybackState>)list);
        this.c = Collections.unmodifiableList((List<? extends long[]>)list2);
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
        this.n = n2;
        this.o = o;
        this.p = p40;
        this.q = Collections.unmodifiableList((List<? extends EventTimeAndFormat>)list3);
        this.r = Collections.unmodifiableList((List<? extends EventTimeAndFormat>)list4);
        this.s = s;
        this.t = t;
        this.u = u;
        this.v = v;
        this.w = w;
        this.x = x;
        this.y = y;
        this.z = z;
        this.A = a2;
        this.B = b;
        this.C = c;
        this.D = d2;
        this.E = e2;
        this.F = f2;
        this.G = g2;
        this.H = h2;
        this.I = i2;
        this.J = j2;
        this.K = k2;
        this.L = Collections.unmodifiableList((List<? extends EventTimeAndException>)list5);
        this.M = Collections.unmodifiableList((List<? extends EventTimeAndException>)list6);
    }
    
    public static PlaybackStats a(final PlaybackStats... array) {
        final long[] array2 = new long[16];
        final int length = array.length;
        long n = 0L;
        long n2 = 0L;
        final long n4;
        final long n3 = n4 = n2;
        final long n6;
        final long n5 = n6 = n4;
        long n8;
        final long n7 = n8 = n6;
        long n10;
        long n9 = n10 = n8;
        long n11 = -9223372036854775807L;
        int n12 = 0;
        int n13 = 0;
        int i = 0;
        long n14 = -9223372036854775807L;
        int n15 = 0;
        int n16 = 0;
        int n17 = 0;
        final long n18 = -9223372036854775807L;
        int n19 = 0;
        int n20 = 0;
        int n21 = 0;
        int n22 = 0;
        int n23 = 0;
        int n24 = 0;
        int n25 = 0;
        int n26 = 0;
        long n27 = -1L;
        int n28 = 0;
        long n29 = -1L;
        int n30 = 0;
        int n31 = 0;
        int a = -1;
        int n32 = 0;
        long n33 = n7;
        long n34 = n6;
        long n35 = n5;
        long n36 = n4;
        long n37 = n3;
        long n38 = n18;
        while (i < length) {
            final PlaybackStats playbackStats = array[i];
            final int n39 = n12 + playbackStats.a;
            for (int j = 0; j < 16; ++j) {
                array2[j] += playbackStats.N[j];
            }
            long n40;
            if (n14 == -9223372036854775807L) {
                n40 = playbackStats.d;
            }
            else {
                final long d = playbackStats.d;
                n40 = n14;
                if (d != -9223372036854775807L) {
                    n40 = Math.min(n14, d);
                }
            }
            n13 += playbackStats.e;
            n15 += playbackStats.f;
            n16 += playbackStats.g;
            n17 += playbackStats.h;
            long k;
            if (n38 == -9223372036854775807L) {
                k = playbackStats.i;
            }
            else {
                final long l = playbackStats.i;
                k = n38;
                if (l != -9223372036854775807L) {
                    k = n38 + l;
                }
            }
            n19 += playbackStats.j;
            n20 += playbackStats.k;
            n21 += playbackStats.l;
            n22 += playbackStats.m;
            n23 += playbackStats.n;
            long n41;
            if (n11 == -9223372036854775807L) {
                n41 = playbackStats.o;
            }
            else {
                final long o = playbackStats.o;
                n41 = n11;
                if (o != -9223372036854775807L) {
                    n41 = Math.max(n11, o);
                }
            }
            n24 += playbackStats.p;
            n += playbackStats.s;
            n2 += playbackStats.t;
            n37 += playbackStats.u;
            n36 += playbackStats.v;
            n35 += playbackStats.w;
            n34 += playbackStats.x;
            n25 += playbackStats.y;
            final int n42 = n26 + playbackStats.z;
            final int n43 = a;
            if (n43 == -1) {
                a = playbackStats.A;
            }
            else {
                final int a2 = playbackStats.A;
                a = n43;
                if (a2 != -1) {
                    a = n43 + a2;
                }
            }
            long b;
            if (n27 == -1L) {
                b = playbackStats.B;
            }
            else {
                final long b2 = playbackStats.B;
                b = n27;
                if (b2 != -1L) {
                    b = n27 + b2;
                }
            }
            n28 += playbackStats.C;
            long d2;
            if (n29 == -1L) {
                d2 = playbackStats.D;
            }
            else {
                final long d3 = playbackStats.D;
                d2 = n29;
                if (d3 != -1L) {
                    d2 = n29 + d3;
                }
            }
            n33 += playbackStats.E;
            n8 += playbackStats.F;
            n9 += playbackStats.G;
            n10 += playbackStats.H;
            n30 += playbackStats.I;
            n31 += playbackStats.J;
            n32 += playbackStats.K;
            ++i;
            n12 = n39;
            n11 = n41;
            n14 = n40;
            n38 = k;
            n26 = n42;
            n27 = b;
            n29 = d2;
        }
        return new PlaybackStats(n12, array2, Collections.emptyList(), Collections.emptyList(), n14, n13, n15, n16, n17, n38, n19, n20, n21, n22, n23, n11, n24, Collections.emptyList(), Collections.emptyList(), n, n2, n37, n36, n35, n34, n25, n26, a, n27, n28, n29, n33, n8, n9, n10, n30, n31, n32, Collections.emptyList(), Collections.emptyList());
    }
    
    public static final class EventTimeAndException
    {
        public final AnalyticsListener.EventTime a;
        public final Exception b;
        
        public EventTimeAndException(final AnalyticsListener.EventTime a, final Exception b) {
            this.a = a;
            this.b = b;
        }
        
        @Override
        public boolean equals(final Object o) {
            if (this == o) {
                return true;
            }
            if (o != null && EventTimeAndException.class == o.getClass()) {
                final EventTimeAndException ex = (EventTimeAndException)o;
                return this.a.equals(ex.a) && this.b.equals(ex.b);
            }
            return false;
        }
        
        @Override
        public int hashCode() {
            return this.a.hashCode() * 31 + this.b.hashCode();
        }
    }
    
    public static final class EventTimeAndFormat
    {
        public final AnalyticsListener.EventTime a;
        public final Format b;
        
        public EventTimeAndFormat(final AnalyticsListener.EventTime a, final Format b) {
            this.a = a;
            this.b = b;
        }
        
        @Override
        public boolean equals(final Object o) {
            boolean equals = true;
            if (this == o) {
                return true;
            }
            if (o == null || EventTimeAndFormat.class != o.getClass()) {
                return false;
            }
            final EventTimeAndFormat eventTimeAndFormat = (EventTimeAndFormat)o;
            if (!this.a.equals(eventTimeAndFormat.a)) {
                return false;
            }
            final Format b = this.b;
            final Format b2 = eventTimeAndFormat.b;
            if (b != null) {
                equals = b.equals(b2);
            }
            else if (b2 != null) {
                equals = false;
            }
            return equals;
        }
        
        @Override
        public int hashCode() {
            final int hashCode = this.a.hashCode();
            final Format b = this.b;
            int hashCode2;
            if (b != null) {
                hashCode2 = b.hashCode();
            }
            else {
                hashCode2 = 0;
            }
            return hashCode * 31 + hashCode2;
        }
    }
    
    public static final class EventTimeAndPlaybackState
    {
        public final AnalyticsListener.EventTime a;
        public final int b;
        
        public EventTimeAndPlaybackState(final AnalyticsListener.EventTime a, final int b) {
            this.a = a;
            this.b = b;
        }
        
        @Override
        public boolean equals(final Object o) {
            if (this == o) {
                return true;
            }
            if (o != null && EventTimeAndPlaybackState.class == o.getClass()) {
                final EventTimeAndPlaybackState eventTimeAndPlaybackState = (EventTimeAndPlaybackState)o;
                return this.b == eventTimeAndPlaybackState.b && this.a.equals(eventTimeAndPlaybackState.a);
            }
            return false;
        }
        
        @Override
        public int hashCode() {
            return this.a.hashCode() * 31 + this.b;
        }
    }
}
