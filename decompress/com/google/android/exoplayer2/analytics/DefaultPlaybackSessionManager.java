// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.exoplayer2.analytics;

import com.google.android.exoplayer2.util.Assertions;
import java.util.Iterator;
import com.google.android.exoplayer2.util.Util;
import com.google.android.exoplayer2.source.MediaSource;
import android.util.Base64;
import j3.m1;
import java.util.HashMap;
import com.google.android.exoplayer2.Timeline;
import java.util.Random;
import com.google.common.base.Supplier;

public final class DefaultPlaybackSessionManager implements PlaybackSessionManager
{
    public static final Supplier<String> h;
    private static final Random i;
    private final Timeline.Window a;
    private final Timeline.Period b;
    private final HashMap<String, a> c;
    private final Supplier<String> d;
    private Listener e;
    private Timeline f;
    private String g;
    
    static {
        h = (Supplier)m1.a;
        i = new Random();
    }
    
    public DefaultPlaybackSessionManager() {
        this(DefaultPlaybackSessionManager.h);
    }
    
    public DefaultPlaybackSessionManager(final Supplier<String> d) {
        this.d = d;
        this.a = new Timeline.Window();
        this.b = new Timeline.Period();
        this.c = new HashMap<String, a>();
        this.f = Timeline.a;
    }
    
    public static String i() {
        return l();
    }
    
    static Timeline.Window j(final DefaultPlaybackSessionManager defaultPlaybackSessionManager) {
        return defaultPlaybackSessionManager.a;
    }
    
    static Timeline.Period k(final DefaultPlaybackSessionManager defaultPlaybackSessionManager) {
        return defaultPlaybackSessionManager.b;
    }
    
    private static String l() {
        final byte[] array = new byte[12];
        DefaultPlaybackSessionManager.i.nextBytes(array);
        return Base64.encodeToString(array, 10);
    }
    
    private a m(final int n, final MediaSource.MediaPeriodId mediaPeriodId) {
        final Iterator<a> iterator = this.c.values().iterator();
        a a = null;
        long n2 = Long.MAX_VALUE;
        while (iterator.hasNext()) {
            final a a2 = iterator.next();
            a2.k(n, mediaPeriodId);
            if (a2.i(n, mediaPeriodId)) {
                final long b = DefaultPlaybackSessionManager.a.b(a2);
                if (b != -1L) {
                    final long n3 = lcmp(b, n2);
                    if (n3 >= 0) {
                        if (n3 == 0 && DefaultPlaybackSessionManager.a.h(Util.j(a)) != null && DefaultPlaybackSessionManager.a.h(a2) != null) {
                            a = a2;
                            continue;
                        }
                        continue;
                    }
                }
                a = a2;
                n2 = b;
            }
        }
        a a3;
        if ((a3 = a) == null) {
            final String s = (String)this.d.get();
            a3 = new a(s, n, mediaPeriodId);
            this.c.put(s, a3);
        }
        return a3;
    }
    
    private void n(final AnalyticsListener.EventTime eventTime) {
        if (eventTime.b.u()) {
            this.g = null;
            return;
        }
        final a a = this.c.get(this.g);
        final a m = this.m(eventTime.c, eventTime.d);
        this.g = DefaultPlaybackSessionManager.a.a(m);
        this.d(eventTime);
        final MediaSource.MediaPeriodId d = eventTime.d;
        if (d != null && d.b() && (a == null || DefaultPlaybackSessionManager.a.b(a) != eventTime.d.d || DefaultPlaybackSessionManager.a.h(a) == null || DefaultPlaybackSessionManager.a.h(a).b != eventTime.d.b || DefaultPlaybackSessionManager.a.h(a).c != eventTime.d.c)) {
            final MediaSource.MediaPeriodId d2 = eventTime.d;
            this.e.z0(eventTime, DefaultPlaybackSessionManager.a.a(this.m(eventTime.c, new MediaSource.MediaPeriodId(d2.a, d2.d))), DefaultPlaybackSessionManager.a.a(m));
        }
    }
    
    @Override
    public String a() {
        synchronized (this) {
            return this.g;
        }
    }
    
    @Override
    public void b(final Listener e) {
        this.e = e;
    }
    
    @Override
    public void c(final AnalyticsListener.EventTime eventTime) {
        synchronized (this) {
            this.g = null;
            final Iterator<a> iterator = this.c.values().iterator();
            while (iterator.hasNext()) {
                final a a = iterator.next();
                iterator.remove();
                if (DefaultPlaybackSessionManager.a.d(a)) {
                    final Listener e = this.e;
                    if (e == null) {
                        continue;
                    }
                    e.e0(eventTime, DefaultPlaybackSessionManager.a.a(a), false);
                }
            }
        }
    }
    
    @Override
    public void d(final AnalyticsListener.EventTime eventTime) {
        synchronized (this) {
            Assertions.e(this.e);
            if (eventTime.b.u()) {
                return;
            }
            final a a = this.c.get(this.g);
            if (eventTime.d != null && a != null) {
                final long b = DefaultPlaybackSessionManager.a.b(a);
                boolean b2 = false;
                Label_0115: {
                    if (b == -1L) {
                        if (DefaultPlaybackSessionManager.a.c(a) == eventTime.c) {
                            break Label_0115;
                        }
                    }
                    else if (eventTime.d.d >= DefaultPlaybackSessionManager.a.b(a)) {
                        break Label_0115;
                    }
                    b2 = true;
                }
                if (b2) {
                    return;
                }
            }
            final a m = this.m(eventTime.c, eventTime.d);
            if (this.g == null) {
                this.g = DefaultPlaybackSessionManager.a.a(m);
            }
            final MediaSource.MediaPeriodId d = eventTime.d;
            if (d != null && d.b()) {
                final MediaSource.MediaPeriodId d2 = eventTime.d;
                final MediaSource.MediaPeriodId mediaPeriodId = new MediaSource.MediaPeriodId(d2.a, d2.d, d2.b);
                final a i = this.m(eventTime.c, mediaPeriodId);
                if (!DefaultPlaybackSessionManager.a.d(i)) {
                    DefaultPlaybackSessionManager.a.e(i, true);
                    eventTime.b.l(eventTime.d.a, this.b);
                    this.e.r0(new AnalyticsListener.EventTime(eventTime.a, eventTime.b, eventTime.c, mediaPeriodId, Math.max(0L, Util.f1(this.b.i(eventTime.d.b)) + this.b.q()), eventTime.f, eventTime.g, eventTime.h, eventTime.i, eventTime.j), DefaultPlaybackSessionManager.a.a(i));
                }
            }
            if (!DefaultPlaybackSessionManager.a.d(m)) {
                DefaultPlaybackSessionManager.a.e(m, true);
                this.e.r0(eventTime, DefaultPlaybackSessionManager.a.a(m));
            }
            if (DefaultPlaybackSessionManager.a.a(m).equals(this.g) && !DefaultPlaybackSessionManager.a.f(m)) {
                DefaultPlaybackSessionManager.a.g(m, true);
                this.e.f0(eventTime, DefaultPlaybackSessionManager.a.a(m));
            }
        }
    }
    
    @Override
    public boolean e(final AnalyticsListener.EventTime eventTime, final String s) {
        synchronized (this) {
            final a a = this.c.get(s);
            if (a == null) {
                return false;
            }
            a.k(eventTime.c, eventTime.d);
            return a.i(eventTime.c, eventTime.d);
        }
    }
    
    @Override
    public void f(final AnalyticsListener.EventTime eventTime, int n) {
        synchronized (this) {
            Assertions.e(this.e);
            if (n == 0) {
                n = 1;
            }
            else {
                n = 0;
            }
            final Iterator<a> iterator = this.c.values().iterator();
            while (iterator.hasNext()) {
                final a a = iterator.next();
                if (a.j(eventTime)) {
                    iterator.remove();
                    if (!DefaultPlaybackSessionManager.a.d(a)) {
                        continue;
                    }
                    final boolean equals = DefaultPlaybackSessionManager.a.a(a).equals(this.g);
                    final boolean b = n != 0 && equals && DefaultPlaybackSessionManager.a.f(a);
                    if (equals) {
                        this.g = null;
                    }
                    this.e.e0(eventTime, DefaultPlaybackSessionManager.a.a(a), b);
                }
            }
            this.n(eventTime);
        }
    }
    
    @Override
    public void g(final AnalyticsListener.EventTime eventTime) {
        synchronized (this) {
            Assertions.e(this.e);
            final Timeline f = this.f;
            this.f = eventTime.b;
            final Iterator<a> iterator = this.c.values().iterator();
            while (iterator.hasNext()) {
                final a a = iterator.next();
                if (!a.m(f, this.f) || a.j(eventTime)) {
                    iterator.remove();
                    if (!DefaultPlaybackSessionManager.a.d(a)) {
                        continue;
                    }
                    if (DefaultPlaybackSessionManager.a.a(a).equals(this.g)) {
                        this.g = null;
                    }
                    this.e.e0(eventTime, DefaultPlaybackSessionManager.a.a(a), false);
                }
            }
            this.n(eventTime);
        }
    }
    
    @Override
    public String h(final Timeline timeline, final MediaSource.MediaPeriodId mediaPeriodId) {
        synchronized (this) {
            return DefaultPlaybackSessionManager.a.a(this.m(timeline.l(mediaPeriodId.a, this.b).c, mediaPeriodId));
        }
    }
    
    private final class a
    {
        private final String a;
        private int b;
        private long c;
        private MediaSource.MediaPeriodId d;
        private boolean e;
        private boolean f;
        final DefaultPlaybackSessionManager g;
        
        public a(final DefaultPlaybackSessionManager g, final String a, final int b, final MediaSource.MediaPeriodId d) {
            this.g = g;
            this.a = a;
            this.b = b;
            long d2;
            if (d == null) {
                d2 = -1L;
            }
            else {
                d2 = d.d;
            }
            this.c = d2;
            if (d != null && d.b()) {
                this.d = d;
            }
        }
        
        static String a(final a a) {
            return a.a;
        }
        
        static long b(final a a) {
            return a.c;
        }
        
        static int c(final a a) {
            return a.b;
        }
        
        static boolean d(final a a) {
            return a.e;
        }
        
        static boolean e(final a a, final boolean e) {
            return a.e = e;
        }
        
        static boolean f(final a a) {
            return a.f;
        }
        
        static boolean g(final a a, final boolean f) {
            return a.f = f;
        }
        
        static MediaSource.MediaPeriodId h(final a a) {
            return a.d;
        }
        
        private int l(final Timeline timeline, final Timeline timeline2, int i) {
            if (i >= timeline.t()) {
                if (i >= timeline2.t()) {
                    i = -1;
                }
                return i;
            }
            timeline.r(i, DefaultPlaybackSessionManager.j(this.g));
            int f;
            for (i = DefaultPlaybackSessionManager.j(this.g).z; i <= DefaultPlaybackSessionManager.j(this.g).A; ++i) {
                f = timeline2.f(timeline.q(i));
                if (f != -1) {
                    return timeline2.j(f, DefaultPlaybackSessionManager.k(this.g)).c;
                }
            }
            return -1;
        }
        
        public boolean i(final int n, final MediaSource.MediaPeriodId mediaPeriodId) {
            boolean b = true;
            final boolean b2 = true;
            final boolean b3 = true;
            if (mediaPeriodId == null) {
                return n == this.b && b3;
            }
            final MediaSource.MediaPeriodId d = this.d;
            if (d == null) {
                if (mediaPeriodId.b() || mediaPeriodId.d != this.c) {
                    b = false;
                }
                return b;
            }
            return mediaPeriodId.d == d.d && mediaPeriodId.b == d.b && mediaPeriodId.c == d.c && b2;
        }
        
        public boolean j(final AnalyticsListener.EventTime eventTime) {
            final long c = this.c;
            final boolean b = false;
            final boolean b2 = false;
            boolean b3 = false;
            if (c == -1L) {
                return false;
            }
            final MediaSource.MediaPeriodId d = eventTime.d;
            if (d == null) {
                if (this.b != eventTime.c) {
                    b3 = true;
                }
                return b3;
            }
            if (d.d > c) {
                return true;
            }
            if (this.d == null) {
                return false;
            }
            final int f = eventTime.b.f(d.a);
            final int f2 = eventTime.b.f(this.d.a);
            final MediaSource.MediaPeriodId d2 = eventTime.d;
            boolean b4 = b2;
            if (d2.d >= this.d.d) {
                if (f < f2) {
                    b4 = b2;
                }
                else {
                    if (f > f2) {
                        return true;
                    }
                    if (d2.b()) {
                        final MediaSource.MediaPeriodId d3 = eventTime.d;
                        final int b5 = d3.b;
                        final int c2 = d3.c;
                        final MediaSource.MediaPeriodId d4 = this.d;
                        final int b6 = d4.b;
                        if (b5 <= b6) {
                            boolean b7 = b;
                            if (b5 != b6) {
                                return b7;
                            }
                            b7 = b;
                            if (c2 <= d4.c) {
                                return b7;
                            }
                        }
                        return true;
                    }
                    final int e = eventTime.d.e;
                    if (e != -1) {
                        b4 = b2;
                        if (e <= this.d.b) {
                            return b4;
                        }
                    }
                    b4 = true;
                }
            }
            return b4;
        }
        
        public void k(final int n, final MediaSource.MediaPeriodId mediaPeriodId) {
            if (this.c == -1L && n == this.b && mediaPeriodId != null) {
                this.c = mediaPeriodId.d;
            }
        }
        
        public boolean m(final Timeline timeline, final Timeline timeline2) {
            final int l = this.l(timeline, timeline2, this.b);
            this.b = l;
            boolean b = false;
            if (l == -1) {
                return false;
            }
            final MediaSource.MediaPeriodId d = this.d;
            if (d == null) {
                return true;
            }
            if (timeline2.f(d.a) != -1) {
                b = true;
            }
            return b;
        }
    }
}
