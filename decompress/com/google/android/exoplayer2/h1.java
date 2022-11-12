// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.exoplayer2;

import com.google.android.exoplayer2.source.MediaPeriod;
import com.google.android.exoplayer2.trackselection.TrackSelectorResult;
import com.google.android.exoplayer2.upstream.Allocator;
import com.google.android.exoplayer2.trackselection.TrackSelector;
import com.google.common.collect.ImmutableList;
import java.util.List;
import android.util.Pair;
import com.google.common.collect.ImmutableList$Builder;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.source.MediaSource;
import android.os.Handler;
import com.google.android.exoplayer2.analytics.AnalyticsCollector;

final class h1
{
    private final Timeline.Period a;
    private final Timeline.Window b;
    private final AnalyticsCollector c;
    private final Handler d;
    private long e;
    private int f;
    private boolean g;
    private e1 h;
    private e1 i;
    private e1 j;
    private int k;
    private Object l;
    private long m;
    
    public h1(final AnalyticsCollector c, final Handler d) {
        this.c = c;
        this.d = d;
        this.a = new Timeline.Period();
        this.b = new Timeline.Window();
    }
    
    private static MediaSource.MediaPeriodId A(final Timeline timeline, Object e, final long n, final long n2, final Timeline.Window window, final Timeline.Period period) {
        timeline.l(e, period);
        timeline.r(period.c, window);
        int f = timeline.f(e);
        while (period.d == 0L && period.f() > 0 && period.u(period.s()) && period.h(0L) == -1) {
            final int n3 = f + 1;
            if (f >= window.A) {
                break;
            }
            timeline.k(n3, period, true);
            e = Assertions.e(period.b);
            f = n3;
        }
        timeline.l(e, period);
        final int h = period.h(n);
        if (h == -1) {
            return new MediaSource.MediaPeriodId(e, n2, period.g(n));
        }
        return new MediaSource.MediaPeriodId(e, h, period.o(h), n2);
    }
    
    private long C(final Timeline timeline, final Object l) {
        final int c = timeline.l(l, this.a).c;
        final Object i = this.l;
        if (i != null) {
            final int f = timeline.f(i);
            if (f != -1 && timeline.j(f, this.a).c == c) {
                return this.m;
            }
        }
        for (e1 e1 = this.h; e1 != null; e1 = e1.j()) {
            if (e1.b.equals(l)) {
                return e1.f.a.d;
            }
        }
        for (e1 e2 = this.h; e2 != null; e2 = e2.j()) {
            final int f2 = timeline.f(e2.b);
            if (f2 != -1 && timeline.j(f2, this.a).c == c) {
                return e2.f.a.d;
            }
        }
        final long e3 = this.e;
        this.e = 1L + e3;
        if (this.h == null) {
            this.l = l;
            this.m = e3;
        }
        return e3;
    }
    
    private boolean E(final Timeline timeline) {
        e1 e1 = this.h;
        if (e1 == null) {
            return true;
        }
        int n = timeline.f(e1.b);
        while (true) {
            n = timeline.h(n, this.a, this.b, this.f, this.g);
            while (e1.j() != null && !e1.f.g) {
                e1 = e1.j();
            }
            final e1 j = e1.j();
            if (n == -1) {
                break;
            }
            if (j == null) {
                break;
            }
            if (timeline.f(j.b) != n) {
                break;
            }
            e1 = j;
        }
        final boolean z = this.z(e1);
        e1.f = this.r(timeline, e1.f);
        return z ^ true;
    }
    
    public static void a(final h1 h1, final ImmutableList$Builder immutableList$Builder, final MediaSource.MediaPeriodId mediaPeriodId) {
        h1.w(immutableList$Builder, mediaPeriodId);
    }
    
    private boolean d(final long n, final long n2) {
        return n == -9223372036854775807L || n == n2;
    }
    
    private boolean e(final f1 f1, final f1 f2) {
        return f1.b == f2.b && f1.a.equals(f2.a);
    }
    
    private f1 h(final m1 m1) {
        return this.k(m1.a, m1.b, m1.c, m1.r);
    }
    
    private f1 i(final Timeline timeline, e1 j, long n) {
        final f1 f = j.f;
        final long n2 = j.l() + f.e - n;
        final boolean g = f.g;
        boolean b = true;
        if (g) {
            final int h = timeline.h(timeline.f(f.a.a), this.a, this.b, this.f, this.g);
            if (h == -1) {
                return null;
            }
            final int c = timeline.k(h, this.a, true).c;
            final Object e = Assertions.e(this.a.b);
            long d = f.a.d;
            Object o2;
            long c2;
            if (timeline.r(c, this.b).z == h) {
                final Pair<Object, Long> o = timeline.o(this.b, this.a, c, -9223372036854775807L, Math.max(0L, n2));
                if (o == null) {
                    return null;
                }
                final Object first = o.first;
                final long longValue = (long)o.second;
                j = j.j();
                if (j != null && j.b.equals(first)) {
                    n = j.f.a.d;
                }
                else {
                    n = this.e;
                    this.e = 1L + n;
                }
                final long n3 = -9223372036854775807L;
                o2 = first;
                d = n;
                n = longValue;
                c2 = n3;
            }
            else {
                n = 0L;
                c2 = 0L;
                o2 = e;
            }
            final MediaSource.MediaPeriodId a = A(timeline, o2, n, d, this.b, this.a);
            if (c2 != -9223372036854775807L && f.c != -9223372036854775807L) {
                Label_0346: {
                    if (timeline.l(f.a.a, this.a).f() > 0) {
                        final Timeline.Period a2 = this.a;
                        if (a2.u(a2.s())) {
                            break Label_0346;
                        }
                    }
                    b = false;
                }
                if (a.b() && b) {
                    c2 = f.c;
                }
                else if (b) {
                    n = f.c;
                }
            }
            return this.k(timeline, a, c2, n);
        }
        else {
            final MediaSource.MediaPeriodId a3 = f.a;
            timeline.l(a3.a, this.a);
            if (a3.b()) {
                final int b2 = a3.b;
                final int d2 = this.a.d(b2);
                if (d2 == -1) {
                    return null;
                }
                final int p3 = this.a.p(b2, a3.c);
                if (p3 < d2) {
                    return this.l(timeline, a3.a, b2, p3, f.c, a3.d);
                }
                if ((n = f.c) == -9223372036854775807L) {
                    final Timeline.Window b3 = this.b;
                    final Timeline.Period a4 = this.a;
                    final Pair<Object, Long> o3 = timeline.o(b3, a4, a4.c, -9223372036854775807L, Math.max(0L, n2));
                    if (o3 == null) {
                        return null;
                    }
                    n = (long)o3.second;
                }
                return this.m(timeline, a3.a, Math.max(this.n(timeline, a3.a, a3.b), n), f.c, a3.d);
            }
            else {
                final int o4 = this.a.o(a3.e);
                final boolean b4 = this.a.u(a3.e) && this.a.k(a3.e, o4) == 3;
                if (o4 != this.a.d(a3.e) && !b4) {
                    return this.l(timeline, a3.a, a3.e, o4, f.e, a3.d);
                }
                n = this.n(timeline, a3.a, a3.e);
                return this.m(timeline, a3.a, n, f.e, a3.d);
            }
        }
    }
    
    private f1 k(final Timeline timeline, final MediaSource.MediaPeriodId mediaPeriodId, final long n, final long n2) {
        timeline.l(mediaPeriodId.a, this.a);
        if (mediaPeriodId.b()) {
            return this.l(timeline, mediaPeriodId.a, mediaPeriodId.b, mediaPeriodId.c, n, mediaPeriodId.d);
        }
        return this.m(timeline, mediaPeriodId.a, n2, n, mediaPeriodId.d);
    }
    
    private f1 l(final Timeline timeline, final Object o, final int n, final int n2, final long n3, long n4) {
        final MediaSource.MediaPeriodId mediaPeriodId = new MediaSource.MediaPeriodId(o, n, n2, n4);
        final long e = timeline.l(mediaPeriodId.a, this.a).e(mediaPeriodId.b, mediaPeriodId.c);
        if (n2 == this.a.o(n)) {
            n4 = this.a.j();
        }
        else {
            n4 = 0L;
        }
        final boolean u = this.a.u(mediaPeriodId.b);
        if (e != -9223372036854775807L && n4 >= e) {
            n4 = Math.max(0L, e - 1L);
        }
        return new f1(mediaPeriodId, n4, n3, -9223372036854775807L, e, u, false, false, false);
    }
    
    private f1 m(final Timeline timeline, Object o, long n, final long n2, long d) {
        final long n3 = n;
        timeline.l(o, this.a);
        int g = this.a.g(n3);
        final int n4 = 1;
        boolean b = false;
        Label_0128: {
            if (g == -1) {
                if (this.a.f() > 0) {
                    final Timeline.Period a = this.a;
                    if (a.u(a.s())) {
                        b = true;
                        break Label_0128;
                    }
                }
            }
            else if (this.a.u(g)) {
                n = this.a.i(g);
                final Timeline.Period a2 = this.a;
                if (n == a2.d && a2.t(g)) {
                    b = true;
                    g = -1;
                    break Label_0128;
                }
            }
            b = false;
        }
        o = new MediaSource.MediaPeriodId(o, d, g);
        final boolean s = this.s((MediaSource.MediaPeriodId)o);
        final boolean u = this.u(timeline, (MediaSource.MediaPeriodId)o);
        final boolean t = this.t(timeline, (MediaSource.MediaPeriodId)o, s);
        final boolean b2 = g != -1 && this.a.u(g);
        if (g != -1) {
            n = this.a.i(g);
        }
        else if (b) {
            n = this.a.d;
        }
        else {
            n = -9223372036854775807L;
        }
        if (n != -9223372036854775807L && n != Long.MIN_VALUE) {
            d = n;
        }
        else {
            d = this.a.d;
        }
        long max = n3;
        if (d != -9223372036854775807L) {
            max = n3;
            if (n3 >= d) {
                int n5 = n4;
                if (!t) {
                    if (!b) {
                        n5 = n4;
                    }
                    else {
                        n5 = 0;
                    }
                }
                max = Math.max(0L, d - n5);
            }
        }
        return new f1((MediaSource.MediaPeriodId)o, max, n2, n, d, b2, s, u, t);
    }
    
    private long n(final Timeline timeline, final Object o, final int n) {
        timeline.l(o, this.a);
        final long i = this.a.i(n);
        if (i == Long.MIN_VALUE) {
            return this.a.d;
        }
        return i + this.a.l(n);
    }
    
    private boolean s(final MediaSource.MediaPeriodId mediaPeriodId) {
        return !mediaPeriodId.b() && mediaPeriodId.e == -1;
    }
    
    private boolean t(final Timeline timeline, final MediaSource.MediaPeriodId mediaPeriodId, final boolean b) {
        final int f = timeline.f(mediaPeriodId.a);
        return !timeline.r(timeline.j(f, this.a).c, this.b).i && timeline.v(f, this.a, this.b, this.f, this.g) && b;
    }
    
    private boolean u(final Timeline timeline, final MediaSource.MediaPeriodId mediaPeriodId) {
        final boolean s = this.s(mediaPeriodId);
        boolean b = false;
        if (!s) {
            return false;
        }
        if (timeline.r(timeline.l(mediaPeriodId.a, this.a).c, this.b).A == timeline.f(mediaPeriodId.a)) {
            b = true;
        }
        return b;
    }
    
    private void w(final ImmutableList$Builder immutableList$Builder, final MediaSource.MediaPeriodId mediaPeriodId) {
        this.c.P((List<MediaSource.MediaPeriodId>)immutableList$Builder.l(), mediaPeriodId);
    }
    
    private void x() {
        final ImmutableList$Builder builder = ImmutableList.builder();
        for (e1 e1 = this.h; e1 != null; e1 = e1.j()) {
            builder.i((Object)e1.f.a);
        }
        final e1 i = this.i;
        MediaSource.MediaPeriodId a;
        if (i == null) {
            a = null;
        }
        else {
            a = i.f.a;
        }
        this.d.post((Runnable)new g1(this, builder, a));
    }
    
    public MediaSource.MediaPeriodId B(final Timeline timeline, Object e, final long n) {
        final long c = this.C(timeline, e);
        timeline.l(e, this.a);
        timeline.r(this.a.c, this.b);
        int f = timeline.f(e);
        int n2 = 0;
        Object o;
        while (true) {
            o = e;
            if (f < this.b.z) {
                break;
            }
            final Timeline.Period a = this.a;
            int n3 = 1;
            timeline.k(f, a, true);
            if (this.a.f() <= 0) {
                n3 = 0;
            }
            n2 |= n3;
            final Timeline.Period a2 = this.a;
            if (a2.h(a2.d) != -1) {
                e = Assertions.e(this.a.b);
            }
            if (n2 != 0) {
                o = e;
                if (n3 == 0) {
                    break;
                }
                if (this.a.d != 0L) {
                    o = e;
                    break;
                }
            }
            --f;
        }
        return A(timeline, o, n, c, this.b, this.a);
    }
    
    public boolean D() {
        final e1 j = this.j;
        return j == null || (!j.f.i && j.q() && this.j.f.e != -9223372036854775807L && this.k < 100);
    }
    
    public boolean F(final Timeline timeline, long n, final long n2) {
        e1 h = this.h;
        e1 e1 = null;
        while (true) {
            boolean b = true;
            if (h == null) {
                return true;
            }
            final f1 f = h.f;
            f1 r;
            if (e1 == null) {
                r = this.r(timeline, f);
            }
            else {
                final f1 i = this.i(timeline, e1, n);
                if (i == null) {
                    return this.z(e1) ^ true;
                }
                if (!this.e(f, i)) {
                    return this.z(e1) ^ true;
                }
                r = i;
            }
            h.f = r.a(f.c);
            if (!this.d(f.e, r.e)) {
                h.A();
                n = r.e;
                if (n == -9223372036854775807L) {
                    n = Long.MAX_VALUE;
                }
                else {
                    n = h.z(n);
                }
                final boolean b2 = h == this.i && !h.f.f && (n2 == Long.MIN_VALUE || n2 >= n);
                if (this.z(h) || b2) {
                    b = false;
                }
                return b;
            }
            final e1 j = h.j();
            e1 = h;
            h = j;
        }
    }
    
    public boolean G(final Timeline timeline, final int f) {
        this.f = f;
        return this.E(timeline);
    }
    
    public boolean H(final Timeline timeline, final boolean g) {
        this.g = g;
        return this.E(timeline);
    }
    
    public e1 b() {
        final e1 h = this.h;
        if (h == null) {
            return null;
        }
        if (h == this.i) {
            this.i = h.j();
        }
        this.h.t();
        if (--this.k == 0) {
            this.j = null;
            final e1 h2 = this.h;
            this.l = h2.b;
            this.m = h2.f.a.d;
        }
        this.h = this.h.j();
        this.x();
        return this.h;
    }
    
    public e1 c() {
        final e1 i = this.i;
        Assertions.g(i != null && i.j() != null);
        this.i = this.i.j();
        this.x();
        return this.i;
    }
    
    public void f() {
        if (this.k == 0) {
            return;
        }
        e1 j = Assertions.i(this.h);
        this.l = j.b;
        this.m = j.f.a.d;
        while (j != null) {
            j.t();
            j = j.j();
        }
        this.h = null;
        this.j = null;
        this.i = null;
        this.k = 0;
        this.x();
    }
    
    public e1 g(final RendererCapabilities[] array, final TrackSelector trackSelector, final Allocator allocator, final MediaSourceList list, final f1 f1, final TrackSelectorResult trackSelectorResult) {
        final e1 j = this.j;
        long n;
        if (j == null) {
            n = 1000000000000L;
        }
        else {
            n = j.l() + this.j.f.e - f1.b;
        }
        final e1 i = new e1(array, n, trackSelector, allocator, list, f1, trackSelectorResult);
        final e1 k = this.j;
        if (k != null) {
            k.w(i);
        }
        else {
            this.h = i;
            this.i = i;
        }
        this.l = null;
        this.j = i;
        ++this.k;
        this.x();
        return i;
    }
    
    public e1 j() {
        return this.j;
    }
    
    public f1 o(final long n, final m1 m1) {
        final e1 j = this.j;
        f1 f1;
        if (j == null) {
            f1 = this.h(m1);
        }
        else {
            f1 = this.i(m1.a, j, n);
        }
        return f1;
    }
    
    public e1 p() {
        return this.h;
    }
    
    public e1 q() {
        return this.i;
    }
    
    public f1 r(final Timeline timeline, final f1 f1) {
        final MediaSource.MediaPeriodId a = f1.a;
        final boolean s = this.s(a);
        final boolean u = this.u(timeline, a);
        final boolean t = this.t(timeline, a, s);
        timeline.l(f1.a.a, this.a);
        long i = 0L;
        Label_0090: {
            if (!a.b()) {
                final int e = a.e;
                if (e != -1) {
                    i = this.a.i(e);
                    break Label_0090;
                }
            }
            i = -9223372036854775807L;
        }
        long n;
        if (a.b()) {
            n = this.a.e(a.b, a.c);
        }
        else if (i != -9223372036854775807L && i != Long.MIN_VALUE) {
            n = i;
        }
        else {
            n = this.a.n();
        }
        boolean u2;
        if (a.b()) {
            u2 = this.a.u(a.b);
        }
        else {
            final int e2 = a.e;
            u2 = (e2 != -1 && this.a.u(e2));
        }
        return new f1(a, f1.b, f1.c, i, n, u2, s, u, t);
    }
    
    public boolean v(final MediaPeriod mediaPeriod) {
        final e1 j = this.j;
        return j != null && j.a == mediaPeriod;
    }
    
    public void y(final long n) {
        final e1 j = this.j;
        if (j != null) {
            j.s(n);
        }
    }
    
    public boolean z(e1 j) {
        final boolean b = false;
        Assertions.g(j != null);
        if (j.equals(this.j)) {
            return false;
        }
        this.j = j;
        boolean b2 = b;
        while (j.j() != null) {
            j = j.j();
            if (j == this.i) {
                this.i = this.h;
                b2 = true;
            }
            j.t();
            --this.k;
        }
        this.j.w(null);
        this.x();
        return b2;
    }
}
