// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.exoplayer2;

import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.Log;
import com.google.android.exoplayer2.trackselection.ExoTrackSelection;
import com.google.android.exoplayer2.source.ClippingMediaPeriod;
import com.google.android.exoplayer2.source.EmptySampleStream;
import com.google.android.exoplayer2.source.MediaSource;
import com.google.android.exoplayer2.upstream.Allocator;
import com.google.android.exoplayer2.trackselection.TrackSelectorResult;
import com.google.android.exoplayer2.source.TrackGroupArray;
import com.google.android.exoplayer2.trackselection.TrackSelector;
import com.google.android.exoplayer2.source.SampleStream;
import com.google.android.exoplayer2.source.MediaPeriod;

final class e1
{
    public final MediaPeriod a;
    public final Object b;
    public final SampleStream[] c;
    public boolean d;
    public boolean e;
    public f1 f;
    public boolean g;
    private final boolean[] h;
    private final RendererCapabilities[] i;
    private final TrackSelector j;
    private final MediaSourceList k;
    private e1 l;
    private TrackGroupArray m;
    private TrackSelectorResult n;
    private long o;
    
    public e1(final RendererCapabilities[] i, final long o, final TrackSelector j, final Allocator allocator, final MediaSourceList k, final f1 f, final TrackSelectorResult n) {
        this.i = i;
        this.o = o;
        this.j = j;
        this.k = k;
        final MediaSource.MediaPeriodId a = f.a;
        this.b = a.a;
        this.f = f;
        this.m = TrackGroupArray.d;
        this.n = n;
        this.c = new SampleStream[i.length];
        this.h = new boolean[i.length];
        this.a = e(a, k, allocator, f.b, f.d);
    }
    
    private void c(final SampleStream[] array) {
        int n = 0;
        while (true) {
            final RendererCapabilities[] i = this.i;
            if (n >= i.length) {
                break;
            }
            if (i[n].f() == -2 && this.n.c(n)) {
                array[n] = new EmptySampleStream();
            }
            ++n;
        }
    }
    
    private static MediaPeriod e(final MediaSource.MediaPeriodId mediaPeriodId, final MediaSourceList list, final Allocator allocator, final long n, final long n2) {
        MediaPeriod h = list.h(mediaPeriodId, allocator, n);
        if (n2 != -9223372036854775807L) {
            h = new ClippingMediaPeriod(h, true, 0L, n2);
        }
        return h;
    }
    
    private void f() {
        if (!this.r()) {
            return;
        }
        int n = 0;
        while (true) {
            final TrackSelectorResult n2 = this.n;
            if (n >= n2.a) {
                break;
            }
            final boolean c = n2.c(n);
            final ExoTrackSelection exoTrackSelection = this.n.c[n];
            if (c && exoTrackSelection != null) {
                exoTrackSelection.e();
            }
            ++n;
        }
    }
    
    private void g(final SampleStream[] array) {
        int n = 0;
        while (true) {
            final RendererCapabilities[] i = this.i;
            if (n >= i.length) {
                break;
            }
            if (i[n].f() == -2) {
                array[n] = null;
            }
            ++n;
        }
    }
    
    private void h() {
        if (!this.r()) {
            return;
        }
        int n = 0;
        while (true) {
            final TrackSelectorResult n2 = this.n;
            if (n >= n2.a) {
                break;
            }
            final boolean c = n2.c(n);
            final ExoTrackSelection exoTrackSelection = this.n.c[n];
            if (c && exoTrackSelection != null) {
                exoTrackSelection.n();
            }
            ++n;
        }
    }
    
    private boolean r() {
        return this.l == null;
    }
    
    private static void u(final MediaSourceList list, final MediaPeriod mediaPeriod) {
        try {
            if (mediaPeriod instanceof ClippingMediaPeriod) {
                list.z(((ClippingMediaPeriod)mediaPeriod).a);
            }
            else {
                list.z(mediaPeriod);
            }
        }
        catch (final RuntimeException ex) {
            Log.d("MediaPeriodHolder", "Period release failed.", ex);
        }
    }
    
    public void A() {
        final MediaPeriod a = this.a;
        if (a instanceof ClippingMediaPeriod) {
            long d;
            if ((d = this.f.d) == -9223372036854775807L) {
                d = Long.MIN_VALUE;
            }
            ((ClippingMediaPeriod)a).u(0L, d);
        }
    }
    
    public long a(final TrackSelectorResult trackSelectorResult, final long n, final boolean b) {
        return this.b(trackSelectorResult, n, b, new boolean[this.i.length]);
    }
    
    public long b(final TrackSelectorResult n, long k, final boolean b, final boolean[] array) {
        int n2 = 0;
        while (true) {
            final int a = n.a;
            boolean b2 = true;
            if (n2 >= a) {
                break;
            }
            final boolean[] h = this.h;
            if (b || !n.b(this.n, n2)) {
                b2 = false;
            }
            h[n2] = b2;
            ++n2;
        }
        this.g(this.c);
        this.f();
        this.n = n;
        this.h();
        k = this.a.k(n.c, this.h, this.c, array, k);
        this.c(this.c);
        this.e = false;
        int n3 = 0;
        while (true) {
            final SampleStream[] c = this.c;
            if (n3 >= c.length) {
                break;
            }
            if (c[n3] != null) {
                Assertions.g(n.c(n3));
                if (this.i[n3].f() != -2) {
                    this.e = true;
                }
            }
            else {
                Assertions.g(n.c[n3] == null);
            }
            ++n3;
        }
        return k;
    }
    
    public void d(long y) {
        Assertions.g(this.r());
        y = this.y(y);
        this.a.d(y);
    }
    
    public long i() {
        if (!this.d) {
            return this.f.b;
        }
        long f;
        if (this.e) {
            f = this.a.f();
        }
        else {
            f = Long.MIN_VALUE;
        }
        long e = f;
        if (f == Long.MIN_VALUE) {
            e = this.f.e;
        }
        return e;
    }
    
    public e1 j() {
        return this.l;
    }
    
    public long k() {
        long b;
        if (!this.d) {
            b = 0L;
        }
        else {
            b = this.a.b();
        }
        return b;
    }
    
    public long l() {
        return this.o;
    }
    
    public long m() {
        return this.f.b + this.o;
    }
    
    public TrackGroupArray n() {
        return this.m;
    }
    
    public TrackSelectorResult o() {
        return this.n;
    }
    
    public void p(final float n, final Timeline timeline) throws ExoPlaybackException {
        this.d = true;
        this.m = this.a.p();
        final TrackSelectorResult v = this.v(n, timeline);
        final f1 f = this.f;
        final long b = f.b;
        final long e = f.e;
        long max = b;
        if (e != -9223372036854775807L) {
            max = b;
            if (b >= e) {
                max = Math.max(0L, e - 1L);
            }
        }
        final long a = this.a(v, max, false);
        final long o = this.o;
        final f1 f2 = this.f;
        this.o = o + (f2.b - a);
        this.f = f2.b(a);
    }
    
    public boolean q() {
        return this.d && (!this.e || this.a.f() == Long.MIN_VALUE);
    }
    
    public void s(final long n) {
        Assertions.g(this.r());
        if (this.d) {
            this.a.g(this.y(n));
        }
    }
    
    public void t() {
        this.f();
        u(this.k, this.a);
    }
    
    public TrackSelectorResult v(final float n, final Timeline timeline) throws ExoPlaybackException {
        final TrackSelectorResult h = this.j.h(this.i, this.n(), this.f.a, timeline);
        for (final ExoTrackSelection exoTrackSelection : h.c) {
            if (exoTrackSelection != null) {
                exoTrackSelection.h(n);
            }
        }
        return h;
    }
    
    public void w(final e1 l) {
        if (l == this.l) {
            return;
        }
        this.f();
        this.l = l;
        this.h();
    }
    
    public void x(final long o) {
        this.o = o;
    }
    
    public long y(final long n) {
        return n - this.l();
    }
    
    public long z(final long n) {
        return n + this.l();
    }
}
