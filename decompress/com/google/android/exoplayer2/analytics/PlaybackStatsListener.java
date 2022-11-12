// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.exoplayer2.analytics;

import com.google.android.exoplayer2.Tracks;
import java.util.Collection;
import java.util.Arrays;
import android.os.SystemClock;
import java.util.Collections;
import java.util.ArrayList;
import java.util.List;
import com.google.android.exoplayer2.PlaybackException;
import java.util.Iterator;
import com.google.android.exoplayer2.Player;
import java.io.IOException;
import com.google.android.exoplayer2.source.MediaLoadData;
import com.google.android.exoplayer2.source.LoadEventInfo;
import com.google.android.exoplayer2.util.Util;
import com.google.android.exoplayer2.source.MediaSource;
import com.google.android.exoplayer2.util.Assertions;
import android.util.Pair;
import com.google.android.exoplayer2.video.VideoSize;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.Timeline;
import java.util.Map;

public final class PlaybackStatsListener implements AnalyticsListener, Listener
{
    private final PlaybackSessionManager a;
    private final Map<String, a> b;
    private final Map<String, EventTime> c;
    private final Callback d;
    private final boolean e;
    private final Timeline.Period f;
    private PlaybackStats g;
    private String h;
    private long i;
    private int j;
    private int k;
    private Exception l;
    private long m;
    private long n;
    private Format o;
    private Format p;
    private VideoSize q;
    
    private Pair<EventTime, Boolean> A0(final Events events, final String s) {
        int i = 0;
        EventTime eventTime = null;
        int n = 0;
        while (i < events.d()) {
            final EventTime c = events.c(events.b(i));
            final boolean e = this.a.e(c, s);
            int n2 = 0;
            EventTime eventTime2 = null;
            Label_0101: {
                if (eventTime != null && (!e || n)) {
                    n2 = n;
                    eventTime2 = eventTime;
                    if ((e ? 1 : 0) != n) {
                        break Label_0101;
                    }
                    n2 = n;
                    eventTime2 = eventTime;
                    if (c.a <= eventTime.a) {
                        break Label_0101;
                    }
                }
                eventTime2 = c;
                n2 = (e ? 1 : 0);
            }
            ++i;
            n = n2;
            eventTime = eventTime2;
        }
        Assertions.e(eventTime);
        boolean e2 = n != 0;
        Object o = eventTime;
        if (n == 0) {
            final MediaSource.MediaPeriodId d = eventTime.d;
            e2 = (n != 0);
            o = eventTime;
            if (d != null) {
                e2 = (n != 0);
                o = eventTime;
                if (d.b()) {
                    long n3;
                    if ((n3 = eventTime.b.l(eventTime.d.a, this.f).i(eventTime.d.b)) == Long.MIN_VALUE) {
                        n3 = this.f.d;
                    }
                    final long r = this.f.r();
                    final long a = eventTime.a;
                    final Timeline b = eventTime.b;
                    final int c2 = eventTime.c;
                    final MediaSource.MediaPeriodId d2 = eventTime.d;
                    o = new EventTime(a, b, c2, new MediaSource.MediaPeriodId(d2.a, d2.d, d2.b), Util.f1(n3 + r), eventTime.b, eventTime.g, eventTime.h, eventTime.i, eventTime.j);
                    e2 = this.a.e((EventTime)o, s);
                }
            }
        }
        return (Pair<EventTime, Boolean>)Pair.create(o, (Object)e2);
    }
    
    private boolean B0(final Events events, final String s, final int n) {
        return events.a(n) && this.a.e(events.c(n), s);
    }
    
    private void C0(final Events events) {
        for (int i = 0; i < events.d(); ++i) {
            final int b = events.b(i);
            final EventTime c = events.c(b);
            if (b == 0) {
                this.a.g(c);
            }
            else if (b == 11) {
                this.a.f(c, this.j);
            }
            else {
                this.a.d(c);
            }
        }
    }
    
    @Override
    public void L(final EventTime eventTime, final int n, final long n2, final long n3) {
        this.m = n;
        this.n = n2;
    }
    
    @Override
    public void d(final EventTime eventTime, final Exception l) {
        this.l = l;
    }
    
    @Override
    public void d0(final EventTime eventTime, final VideoSize q) {
        this.q = q;
    }
    
    @Override
    public void e0(final EventTime eventTime, final String s, final boolean b) {
        final a a = Assertions.e(this.b.remove(s));
        final EventTime eventTime2 = Assertions.e(this.c.remove(s));
        long i;
        if (s.equals(this.h)) {
            i = this.i;
        }
        else {
            i = -9223372036854775807L;
        }
        a.n(eventTime, b, i);
        final PlaybackStats a2 = a.a(true);
        this.g = PlaybackStats.a(this.g, a2);
        final Callback d = this.d;
        if (d != null) {
            d.a(eventTime2, a2);
        }
    }
    
    @Override
    public void f0(final EventTime eventTime, final String s) {
        Assertions.e(this.b.get(s)).o();
    }
    
    @Override
    public void k(final EventTime eventTime, final LoadEventInfo loadEventInfo, final MediaLoadData mediaLoadData, final IOException l, final boolean b) {
        this.l = l;
    }
    
    @Override
    public void m0(final EventTime eventTime, final MediaLoadData mediaLoadData) {
        final int b = mediaLoadData.b;
        if (b != 2 && b != 0) {
            if (b == 1) {
                this.p = mediaLoadData.c;
            }
        }
        else {
            this.o = mediaLoadData.c;
        }
    }
    
    @Override
    public void o(final Player player, final Events events) {
        if (events.d() == 0) {
            return;
        }
        this.C0(events);
        for (final String s : this.b.keySet()) {
            final Pair<EventTime, Boolean> a0 = this.A0(events, s);
            final a a2 = this.b.get(s);
            final boolean b0 = this.B0(events, s, 11);
            final boolean b2 = this.B0(events, s, 1018);
            final boolean b3 = this.B0(events, s, 1011);
            final boolean b4 = this.B0(events, s, 1000);
            final boolean b5 = this.B0(events, s, 10);
            final boolean b6 = this.B0(events, s, 1003) || this.B0(events, s, 1024);
            final boolean b7 = this.B0(events, s, 1006);
            final boolean b8 = this.B0(events, s, 1004);
            final boolean b9 = this.B0(events, s, 25);
            final EventTime eventTime = (EventTime)a0.first;
            final boolean booleanValue = (boolean)a0.second;
            long i;
            if (s.equals(this.h)) {
                i = this.i;
            }
            else {
                i = -9223372036854775807L;
            }
            int k;
            if (b2) {
                k = this.k;
            }
            else {
                k = 0;
            }
            PlaybackException a3;
            if (b5) {
                a3 = player.a();
            }
            else {
                a3 = null;
            }
            Exception l;
            if (b6) {
                l = this.l;
            }
            else {
                l = null;
            }
            long m;
            if (b7) {
                m = this.m;
            }
            else {
                m = 0L;
            }
            long n;
            if (b7) {
                n = this.n;
            }
            else {
                n = 0L;
            }
            Format o;
            if (b8) {
                o = this.o;
            }
            else {
                o = null;
            }
            Format p2;
            if (b8) {
                p2 = this.p;
            }
            else {
                p2 = null;
            }
            VideoSize q;
            if (b9) {
                q = this.q;
            }
            else {
                q = null;
            }
            a2.m(player, eventTime, booleanValue, i, b0, k, b3, b4, a3, l, m, n, o, p2, q);
        }
        this.o = null;
        this.p = null;
        this.h = null;
        if (events.a(1028)) {
            this.a.c(events.c(1028));
        }
    }
    
    @Override
    public void p0(final EventTime eventTime, final Player.PositionInfo positionInfo, final Player.PositionInfo positionInfo2, final int j) {
        if (this.h == null) {
            this.h = this.a.a();
            this.i = positionInfo.g;
        }
        this.j = j;
    }
    
    @Override
    public void r0(final EventTime eventTime, final String s) {
        this.b.put(s, new a(this.e, eventTime));
        this.c.put(s, eventTime);
    }
    
    @Override
    public void v(final EventTime eventTime, final int k, final long n) {
        this.k = k;
    }
    
    @Override
    public void z0(final EventTime eventTime, final String s, final String s2) {
        Assertions.e(this.b.get(s)).p();
    }
    
    public interface Callback
    {
        void a(final EventTime p0, final PlaybackStats p1);
    }
    
    private static final class a
    {
        private long A;
        private long B;
        private long C;
        private long D;
        private long E;
        private int F;
        private int G;
        private int H;
        private long I;
        private boolean J;
        private boolean K;
        private boolean L;
        private boolean M;
        private boolean N;
        private long O;
        private Format P;
        private Format Q;
        private long R;
        private long S;
        private float T;
        private final boolean a;
        private final long[] b;
        private final List<PlaybackStats.EventTimeAndPlaybackState> c;
        private final List<long[]> d;
        private final List<PlaybackStats.EventTimeAndFormat> e;
        private final List<PlaybackStats.EventTimeAndFormat> f;
        private final List<PlaybackStats.EventTimeAndException> g;
        private final List<PlaybackStats.EventTimeAndException> h;
        private final boolean i;
        private long j;
        private boolean k;
        private boolean l;
        private boolean m;
        private int n;
        private int o;
        private int p;
        private int q;
        private long r;
        private int s;
        private long t;
        private long u;
        private long v;
        private long w;
        private long x;
        private long y;
        private long z;
        
        public a(final boolean a, final EventTime eventTime) {
            this.a = a;
            this.b = new long[16];
            List<Object> emptyList;
            if (a) {
                emptyList = (List<Object>)new ArrayList<PlaybackStats.EventTimeAndPlaybackState>();
            }
            else {
                emptyList = (List<Object>)Collections.emptyList();
            }
            this.c = (List<PlaybackStats.EventTimeAndPlaybackState>)emptyList;
            List<long[]> emptyList2;
            if (a) {
                emptyList2 = new ArrayList<long[]>();
            }
            else {
                emptyList2 = Collections.emptyList();
            }
            this.d = emptyList2;
            List<PlaybackStats.EventTimeAndFormat> emptyList3;
            if (a) {
                emptyList3 = new ArrayList<PlaybackStats.EventTimeAndFormat>();
            }
            else {
                emptyList3 = Collections.emptyList();
            }
            this.e = emptyList3;
            List<PlaybackStats.EventTimeAndFormat> emptyList4;
            if (a) {
                emptyList4 = new ArrayList<PlaybackStats.EventTimeAndFormat>();
            }
            else {
                emptyList4 = Collections.emptyList();
            }
            this.f = emptyList4;
            List<PlaybackStats.EventTimeAndException> emptyList5;
            if (a) {
                emptyList5 = new ArrayList<PlaybackStats.EventTimeAndException>();
            }
            else {
                emptyList5 = Collections.emptyList();
            }
            this.g = emptyList5;
            List<PlaybackStats.EventTimeAndException> emptyList6;
            if (a) {
                emptyList6 = new ArrayList<PlaybackStats.EventTimeAndException>();
            }
            else {
                emptyList6 = Collections.emptyList();
            }
            this.h = emptyList6;
            final boolean b = false;
            this.H = 0;
            this.I = eventTime.a;
            this.j = -9223372036854775807L;
            this.r = -9223372036854775807L;
            final MediaSource.MediaPeriodId d = eventTime.d;
            boolean i = b;
            if (d != null) {
                i = b;
                if (d.b()) {
                    i = true;
                }
            }
            this.i = i;
            this.u = -1L;
            this.t = -1L;
            this.s = -1;
            this.T = 1.0f;
        }
        
        private long[] b(final long n) {
            final List<long[]> d = this.d;
            final long[] array = d.get(d.size() - 1);
            return new long[] { n, array[1] + (long)((n - array[0]) * this.T) };
        }
        
        private static boolean c(final int n, final int n2) {
            final boolean b = false;
            if (n != 1 && n != 2 && n != 14) {
                return false;
            }
            boolean b2 = b;
            if (n2 != 1) {
                b2 = b;
                if (n2 != 2) {
                    b2 = b;
                    if (n2 != 14) {
                        b2 = b;
                        if (n2 != 3) {
                            b2 = b;
                            if (n2 != 4) {
                                b2 = b;
                                if (n2 != 9) {
                                    b2 = b;
                                    if (n2 != 11) {
                                        b2 = true;
                                    }
                                }
                            }
                        }
                    }
                }
            }
            return b2;
        }
        
        private static boolean d(final int n) {
            return n == 4 || n == 7;
        }
        
        private static boolean e(final int n) {
            return n == 3 || n == 4 || n == 9;
        }
        
        private static boolean f(final int n) {
            return n == 6 || n == 7 || n == 10;
        }
        
        private void g(final long s) {
            if (this.H == 3) {
                final Format q = this.Q;
                if (q != null) {
                    final int h = q.h;
                    if (h != -1) {
                        final long n = (long)((s - this.S) * this.T);
                        this.z += n;
                        this.A += n * h;
                    }
                }
            }
            this.S = s;
        }
        
        private void h(final long r) {
            if (this.H == 3) {
                final Format p = this.P;
                if (p != null) {
                    final long n = (long)((r - this.R) * this.T);
                    final int c = p.C;
                    if (c != -1) {
                        this.v += n;
                        this.w += c * n;
                    }
                    final int h = p.h;
                    if (h != -1) {
                        this.x += n;
                        this.y += n * h;
                    }
                }
            }
            this.R = r;
        }
        
        private void i(final EventTime eventTime, final Format q) {
            if (Util.c(this.Q, q)) {
                return;
            }
            this.g(eventTime.a);
            if (q != null && this.u == -1L) {
                final int h = q.h;
                if (h != -1) {
                    this.u = h;
                }
            }
            this.Q = q;
            if (this.a) {
                this.f.add(new PlaybackStats.EventTimeAndFormat(eventTime, q));
            }
        }
        
        private void j(long r) {
            if (f(this.H)) {
                r -= this.O;
                final long r2 = this.r;
                if (r2 == -9223372036854775807L || r > r2) {
                    this.r = r;
                }
            }
        }
        
        private void k(final long n, final long n2) {
            if (!this.a) {
                return;
            }
            if (this.H != 3) {
                if (n2 == -9223372036854775807L) {
                    return;
                }
                if (!this.d.isEmpty()) {
                    final List<long[]> d = this.d;
                    final long n3 = ((long[])d.get(d.size() - 1))[1];
                    if (n3 != n2) {
                        this.d.add(new long[] { n, n3 });
                    }
                }
            }
            if (n2 != -9223372036854775807L) {
                this.d.add(new long[] { n, n2 });
            }
            else if (!this.d.isEmpty()) {
                this.d.add(this.b(n));
            }
        }
        
        private void l(final EventTime eventTime, final Format p2) {
            if (Util.c(this.P, p2)) {
                return;
            }
            this.h(eventTime.a);
            if (p2 != null) {
                if (this.s == -1) {
                    final int c = p2.C;
                    if (c != -1) {
                        this.s = c;
                    }
                }
                if (this.t == -1L) {
                    final int h = p2.h;
                    if (h != -1) {
                        this.t = h;
                    }
                }
            }
            this.P = p2;
            if (this.a) {
                this.e.add(new PlaybackStats.EventTimeAndFormat(eventTime, p2));
            }
        }
        
        private int q(final Player player) {
            final int playbackState = player.getPlaybackState();
            if (this.J && this.K) {
                return 5;
            }
            if (this.M) {
                return 13;
            }
            if (!this.K) {
                return this.N ? 1 : 0;
            }
            if (this.L) {
                return 14;
            }
            if (playbackState == 4) {
                return 11;
            }
            if (playbackState == 2) {
                final int h = this.H;
                if (h == 0 || h == 1 || h == 2 || h == 14) {
                    return 2;
                }
                if (!player.E()) {
                    return 7;
                }
                int n;
                if (player.v() != 0) {
                    n = 10;
                }
                else {
                    n = 6;
                }
                return n;
            }
            else {
                int n2 = 3;
                if (playbackState == 3) {
                    if (!player.E()) {
                        return 4;
                    }
                    if (player.v() != 0) {
                        n2 = 9;
                    }
                    return n2;
                }
                else {
                    if (playbackState == 1 && this.H != 0) {
                        return 12;
                    }
                    return this.H;
                }
            }
        }
        
        private void r(final int h, final EventTime eventTime) {
            final long a = eventTime.a;
            final long i = this.I;
            boolean b = false;
            Assertions.a(a >= i);
            final long a2 = eventTime.a;
            final long j = this.I;
            final long[] b2 = this.b;
            final int h2 = this.H;
            b2[h2] += a2 - j;
            if (this.j == -9223372036854775807L) {
                this.j = a2;
            }
            this.m |= c(h2, h);
            this.k |= e(h);
            final boolean l = this.l;
            if (h == 11) {
                b = true;
            }
            this.l = (l | b);
            if (!d(this.H) && d(h)) {
                ++this.n;
            }
            if (h == 5) {
                ++this.p;
            }
            if (!f(this.H) && f(h)) {
                ++this.q;
                this.O = eventTime.a;
            }
            if (f(this.H) && this.H != 7 && h == 7) {
                ++this.o;
            }
            this.j(eventTime.a);
            this.H = h;
            this.I = eventTime.a;
            if (this.a) {
                this.c.add(new PlaybackStats.EventTimeAndPlaybackState(eventTime, h));
            }
        }
        
        public PlaybackStats a(final boolean b) {
            long[] array = this.b;
            List<long[]> d = this.d;
            if (!b) {
                final long elapsedRealtime = SystemClock.elapsedRealtime();
                array = Arrays.copyOf(this.b, 16);
                final long max = Math.max(0L, elapsedRealtime - this.I);
                final int h = this.H;
                array[h] += max;
                this.j(elapsedRealtime);
                this.h(elapsedRealtime);
                this.g(elapsedRealtime);
                d = new ArrayList<long[]>(this.d);
                if (this.a && this.H == 3) {
                    d.add(this.b(elapsedRealtime));
                }
            }
            final boolean b2 = this.m || !this.k;
            long n;
            if (b2) {
                n = -9223372036854775807L;
            }
            else {
                n = array[2];
            }
            int n2;
            if (array[1] > 0L) {
                n2 = 1;
            }
            else {
                n2 = 0;
            }
            List<PlaybackStats.EventTimeAndFormat> e;
            if (b) {
                e = this.e;
            }
            else {
                e = new ArrayList<PlaybackStats.EventTimeAndFormat>(this.e);
            }
            List<PlaybackStats.EventTimeAndFormat> f;
            if (b) {
                f = this.f;
            }
            else {
                f = new ArrayList<PlaybackStats.EventTimeAndFormat>(this.f);
            }
            List<PlaybackStats.EventTimeAndPlaybackState> c;
            if (b) {
                c = this.c;
            }
            else {
                c = new ArrayList<PlaybackStats.EventTimeAndPlaybackState>(this.c);
            }
            final long j = this.j;
            final boolean k = this.K;
            final boolean i = this.k;
            final boolean l = this.l;
            final int n3 = this.n;
            final int o = this.o;
            final int p = this.p;
            final int q = this.q;
            final long r = this.r;
            final boolean m = this.i;
            final long v = this.v;
            final long w = this.w;
            final long x = this.x;
            final long y = this.y;
            final long z = this.z;
            final long a = this.A;
            final int s = this.s;
            int n4;
            if (s == -1) {
                n4 = 0;
            }
            else {
                n4 = 1;
            }
            final long t = this.t;
            int n5;
            if (t == -1L) {
                n5 = 0;
            }
            else {
                n5 = 1;
            }
            final long u = this.u;
            int n6;
            if (u == -1L) {
                n6 = 0;
            }
            else {
                n6 = 1;
            }
            final long b3 = this.B;
            final long c2 = this.C;
            final long d2 = this.D;
            final long e2 = this.E;
            final int f2 = this.F;
            int n7;
            if (f2 > 0) {
                n7 = 1;
            }
            else {
                n7 = 0;
            }
            return new PlaybackStats(1, array, c, d, j, k ? 1 : 0, (i ^ true) ? 1 : 0, l ? 1 : 0, n2, n, (b2 ^ true) ? 1 : 0, n3, o, p, q, r, m ? 1 : 0, e, f, v, w, x, y, z, a, n4, n5, s, t, n6, u, b3, c2, d2, e2, n7, f2, this.G, this.g, this.h);
        }
        
        public void m(final Player player, final EventTime eventTime, final boolean b, long e, final boolean b2, int q, final boolean b3, final boolean b4, final PlaybackException ex, final Exception ex2, long a, final long n, final Format format, final Format format2, final VideoSize videoSize) {
            final long n2 = -9223372036854775807L;
            if (e != -9223372036854775807L) {
                this.k(eventTime.a, e);
                this.J = true;
            }
            if (player.getPlaybackState() != 2) {
                this.J = false;
            }
            final int playbackState = player.getPlaybackState();
            if (playbackState == 1 || playbackState == 4 || b2) {
                this.L = false;
            }
            if (ex != null) {
                this.M = true;
                ++this.F;
                if (this.a) {
                    this.g.add(new PlaybackStats.EventTimeAndException(eventTime, ex));
                }
            }
            else if (player.a() == null) {
                this.M = false;
            }
            if (this.K && !this.L) {
                final Tracks p15 = player.p();
                if (!p15.d(2)) {
                    this.l(eventTime, null);
                }
                if (!p15.d(1)) {
                    this.i(eventTime, null);
                }
            }
            if (format != null) {
                this.l(eventTime, format);
            }
            if (format2 != null) {
                this.i(eventTime, format2);
            }
            final Format p16 = this.P;
            if (p16 != null && p16.C == -1 && videoSize != null) {
                this.l(eventTime, p16.b().j0(videoSize.a).Q(videoSize.b).E());
            }
            if (b4) {
                this.N = true;
            }
            if (b3) {
                ++this.E;
            }
            this.D += q;
            this.B += a;
            this.C += n;
            if (ex2 != null) {
                ++this.G;
                if (this.a) {
                    this.h.add(new PlaybackStats.EventTimeAndException(eventTime, ex2));
                }
            }
            q = this.q(player);
            final float a2 = player.b().a;
            if (this.H != q || this.T != a2) {
                a = eventTime.a;
                e = n2;
                if (b) {
                    e = eventTime.e;
                }
                this.k(a, e);
                this.h(eventTime.a);
                this.g(eventTime.a);
            }
            this.T = a2;
            if (this.H != q) {
                this.r(q, eventTime);
            }
        }
        
        public void n(final EventTime eventTime, final boolean b, final long n) {
            final int h = this.H;
            int n2 = 11;
            if (h != 11) {
                if (b) {
                    n2 = n2;
                }
                else {
                    n2 = 15;
                }
            }
            this.k(eventTime.a, n);
            this.h(eventTime.a);
            this.g(eventTime.a);
            this.r(n2, eventTime);
        }
        
        public void o() {
            this.K = true;
        }
        
        public void p() {
            this.L = true;
            this.J = false;
        }
    }
}
