// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.exoplayer2;

import java.io.IOException;
import com.google.android.exoplayer2.source.LoadEventInfo;
import com.google.android.exoplayer2.source.MediaLoadData;
import com.google.android.exoplayer2.util.Log;
import java.util.Collection;
import com.google.android.exoplayer2.source.MaskingMediaPeriod;
import com.google.android.exoplayer2.upstream.Allocator;
import com.google.android.exoplayer2.source.MaskingMediaSource;
import com.google.android.exoplayer2.util.Util;
import com.google.android.exoplayer2.util.Assertions;
import java.util.Iterator;
import com.google.android.exoplayer2.source.MediaSource;
import java.util.HashSet;
import java.util.ArrayList;
import android.os.Handler;
import com.google.android.exoplayer2.analytics.AnalyticsCollector;
import com.google.android.exoplayer2.upstream.TransferListener;
import com.google.android.exoplayer2.source.ShuffleOrder;
import java.util.Set;
import java.util.HashMap;
import com.google.android.exoplayer2.drm.DrmSessionEventListener;
import com.google.android.exoplayer2.source.MediaSourceEventListener;
import java.util.Map;
import com.google.android.exoplayer2.source.MediaPeriod;
import java.util.IdentityHashMap;
import java.util.List;
import com.google.android.exoplayer2.analytics.PlayerId;

final class MediaSourceList
{
    private final PlayerId a;
    private final List<c> b;
    private final IdentityHashMap<MediaPeriod, c> c;
    private final Map<Object, c> d;
    private final MediaSourceListInfoRefreshListener e;
    private final MediaSourceEventListener.EventDispatcher f;
    private final DrmSessionEventListener.EventDispatcher g;
    private final HashMap<c, b> h;
    private final Set<c> i;
    private ShuffleOrder j;
    private boolean k;
    private TransferListener l;
    
    public MediaSourceList(final MediaSourceListInfoRefreshListener e, final AnalyticsCollector analyticsCollector, final Handler handler, final PlayerId a) {
        this.a = a;
        this.e = e;
        this.j = new ShuffleOrder.DefaultShuffleOrder(0);
        this.c = new IdentityHashMap<MediaPeriod, c>();
        this.d = new HashMap<Object, c>();
        this.b = new ArrayList<c>();
        final MediaSourceEventListener.EventDispatcher f = new MediaSourceEventListener.EventDispatcher();
        this.f = f;
        final DrmSessionEventListener.EventDispatcher g = new DrmSessionEventListener.EventDispatcher();
        this.g = g;
        this.h = new HashMap<c, b>();
        this.i = new HashSet<c>();
        f.g(handler, analyticsCollector);
        g.g(handler, analyticsCollector);
    }
    
    private void B(final int n, int i) {
        --i;
        while (i >= n) {
            final c c = this.b.remove(i);
            this.d.remove(c.b);
            this.g(i, -c.a.D0().t());
            c.e = true;
            if (this.k) {
                this.u(c);
            }
            --i;
        }
    }
    
    public static void a(final MediaSourceList list, final MediaSource mediaSource, final Timeline timeline) {
        list.t(mediaSource, timeline);
    }
    
    static MediaSourceEventListener.EventDispatcher b(final MediaSourceList list) {
        return list.f;
    }
    
    static DrmSessionEventListener.EventDispatcher c(final MediaSourceList list) {
        return list.g;
    }
    
    static MediaSource.MediaPeriodId d(final c c, final MediaSource.MediaPeriodId mediaPeriodId) {
        return n(c, mediaPeriodId);
    }
    
    static int e(final c c, final int n) {
        return r(c, n);
    }
    
    private void g(int i, final int n) {
        while (i < this.b.size()) {
            final c c = this.b.get(i);
            c.d += n;
            ++i;
        }
    }
    
    private void j(final c c) {
        final b b = this.h.get(c);
        if (b != null) {
            b.a.Q(b.b);
        }
    }
    
    private void k() {
        final Iterator<c> iterator = this.i.iterator();
        while (iterator.hasNext()) {
            final c c = iterator.next();
            if (c.c.isEmpty()) {
                this.j(c);
                iterator.remove();
            }
        }
    }
    
    private void l(final c c) {
        this.i.add(c);
        final b b = this.h.get(c);
        if (b != null) {
            b.a.K(b.b);
        }
    }
    
    private static Object m(final Object o) {
        return AbstractConcatenatedTimeline.B(o);
    }
    
    private static MediaSource.MediaPeriodId n(final c c, final MediaSource.MediaPeriodId mediaPeriodId) {
        for (int i = 0; i < c.c.size(); ++i) {
            if (c.c.get(i).d == mediaPeriodId.d) {
                return mediaPeriodId.c(p(c, mediaPeriodId.a));
            }
        }
        return null;
    }
    
    private static Object o(final Object o) {
        return AbstractConcatenatedTimeline.C(o);
    }
    
    private static Object p(final c c, final Object o) {
        return AbstractConcatenatedTimeline.E(c.b, o);
    }
    
    private static int r(final c c, final int n) {
        return n + c.d;
    }
    
    private void t(final MediaSource mediaSource, final Timeline timeline) {
        this.e.b();
    }
    
    private void u(final c c) {
        if (c.e && c.c.isEmpty()) {
            final b b = Assertions.e(this.h.remove(c));
            b.a.x(b.b);
            b.a.C(b.c);
            b.a.T(b.c);
            this.i.remove(c);
        }
    }
    
    private void x(final c c) {
        final MaskingMediaSource a = c.a;
        final j1 j1 = new j1(this);
        final a a2 = new a(c);
        this.h.put(c, new b(a, j1, a2));
        a.B(Util.y(), a2);
        a.S(Util.y(), a2);
        a.E((MediaSource.MediaSourceCaller)j1, this.l, this.a);
    }
    
    public Timeline A(final int n, final int n2, final ShuffleOrder j) {
        Assertions.a(n >= 0 && n <= n2 && n2 <= this.q());
        this.j = j;
        this.B(n, n2);
        return this.i();
    }
    
    public Timeline C(final List<c> list, final ShuffleOrder shuffleOrder) {
        this.B(0, this.b.size());
        return this.f(this.b.size(), list, shuffleOrder);
    }
    
    public Timeline D(final ShuffleOrder shuffleOrder) {
        final int q = this.q();
        ShuffleOrder g = shuffleOrder;
        if (shuffleOrder.getLength() != q) {
            g = shuffleOrder.e().g(0, q);
        }
        this.j = g;
        return this.i();
    }
    
    public Timeline f(final int n, final List<c> list, final ShuffleOrder j) {
        if (!list.isEmpty()) {
            this.j = j;
            for (int i = n; i < list.size() + n; ++i) {
                final c c = list.get(i - n);
                if (i > 0) {
                    final c c2 = this.b.get(i - 1);
                    c.c(c2.d + c2.a.D0().t());
                }
                else {
                    c.c(0);
                }
                this.g(i, c.a.D0().t());
                this.b.add(i, c);
                this.d.put(c.b, c);
                if (this.k) {
                    this.x(c);
                    if (this.c.isEmpty()) {
                        this.i.add(c);
                    }
                    else {
                        this.j(c);
                    }
                }
            }
        }
        return this.i();
    }
    
    public MediaPeriod h(MediaSource.MediaPeriodId c, final Allocator allocator, final long n) {
        final Object o = o(c.a);
        c = c.c(m(c.a));
        final c c2 = Assertions.e(this.d.get(o));
        this.l(c2);
        c2.c.add(c);
        final MaskingMediaPeriod z0 = c2.a.z0(c, allocator, n);
        this.c.put(z0, c2);
        this.k();
        return z0;
    }
    
    public Timeline i() {
        if (this.b.isEmpty()) {
            return Timeline.a;
        }
        int i = 0;
        int d = 0;
        while (i < this.b.size()) {
            final c c = this.b.get(i);
            c.d = d;
            d += c.a.D0().t();
            ++i;
        }
        return new q1(this.b, this.j);
    }
    
    public int q() {
        return this.b.size();
    }
    
    public boolean s() {
        return this.k;
    }
    
    public Timeline v(int i, int d, final int n, final ShuffleOrder j) {
        Assertions.a(i >= 0 && i <= d && d <= this.q() && n >= 0);
        this.j = j;
        if (i != d && i != n) {
            final int min = Math.min(i, n);
            final int max = Math.max(d - i + n - 1, d - 1);
            final int d2 = this.b.get(min).d;
            Util.B0(this.b, i, d, n);
            i = min;
            d = d2;
            while (i <= max) {
                final c c = this.b.get(i);
                c.d = d;
                d += c.a.D0().t();
                ++i;
            }
            return this.i();
        }
        return this.i();
    }
    
    public void w(final TransferListener l) {
        Assertions.g(this.k ^ true);
        this.l = l;
        for (int i = 0; i < this.b.size(); ++i) {
            final c c = this.b.get(i);
            this.x(c);
            this.i.add(c);
        }
        this.k = true;
    }
    
    public void y() {
        for (final b b : this.h.values()) {
            try {
                b.a.x(b.b);
            }
            catch (final RuntimeException ex) {
                Log.d("MediaSourceList", "Failed to release child source.", ex);
            }
            b.a.C(b.c);
            b.a.T(b.c);
        }
        this.h.clear();
        this.i.clear();
        this.k = false;
    }
    
    public void z(final MediaPeriod mediaPeriod) {
        final c c = Assertions.e(this.c.remove(mediaPeriod));
        c.a.I(mediaPeriod);
        c.c.remove(((MaskingMediaPeriod)mediaPeriod).a);
        if (!this.c.isEmpty()) {
            this.k();
        }
        this.u(c);
    }
    
    public interface MediaSourceListInfoRefreshListener
    {
        void b();
    }
    
    private final class a implements MediaSourceEventListener, DrmSessionEventListener
    {
        private final c a;
        private MediaSourceEventListener.EventDispatcher b;
        private DrmSessionEventListener.EventDispatcher c;
        final MediaSourceList d;
        
        public a(final MediaSourceList d, final c a) {
            this.d = d;
            this.b = MediaSourceList.b(d);
            this.c = MediaSourceList.c(d);
            this.a = a;
        }
        
        private boolean u(int e, MediaSource.MediaPeriodId d) {
            if (d != null) {
                if ((d = MediaSourceList.d(this.a, d)) == null) {
                    return false;
                }
            }
            else {
                d = null;
            }
            e = MediaSourceList.e(this.a, e);
            final MediaSourceEventListener.EventDispatcher b = this.b;
            if (b.a != e || !Util.c(b.b, d)) {
                this.b = MediaSourceList.b(this.d).F(e, d, 0L);
            }
            final DrmSessionEventListener.EventDispatcher c = this.c;
            if (c.a != e || !Util.c(c.b, d)) {
                this.c = MediaSourceList.c(this.d).u(e, d);
            }
            return true;
        }
        
        @Override
        public void G(final int n, final MediaSource.MediaPeriodId mediaPeriodId) {
            if (this.u(n, mediaPeriodId)) {
                this.c.i();
            }
        }
        
        @Override
        public void M(final int n, final MediaSource.MediaPeriodId mediaPeriodId, final MediaLoadData mediaLoadData) {
            if (this.u(n, mediaPeriodId)) {
                this.b.E(mediaLoadData);
            }
        }
        
        @Override
        public void O(final int n, final MediaSource.MediaPeriodId mediaPeriodId, final Exception ex) {
            if (this.u(n, mediaPeriodId)) {
                this.c.l(ex);
            }
        }
        
        @Override
        public void X(final int n, final MediaSource.MediaPeriodId mediaPeriodId) {
            if (this.u(n, mediaPeriodId)) {
                this.c.h();
            }
        }
        
        @Override
        public void Y(final int n, final MediaSource.MediaPeriodId mediaPeriodId, final LoadEventInfo loadEventInfo, final MediaLoadData mediaLoadData) {
            if (this.u(n, mediaPeriodId)) {
                this.b.v(loadEventInfo, mediaLoadData);
            }
        }
        
        @Override
        public void Z(final int n, final MediaSource.MediaPeriodId mediaPeriodId, final int n2) {
            if (this.u(n, mediaPeriodId)) {
                this.c.k(n2);
            }
        }
        
        @Override
        public void a0(final int n, final MediaSource.MediaPeriodId mediaPeriodId) {
            if (this.u(n, mediaPeriodId)) {
                this.c.m();
            }
        }
        
        @Override
        public void b0(final int n, final MediaSource.MediaPeriodId mediaPeriodId, final LoadEventInfo loadEventInfo, final MediaLoadData mediaLoadData, final IOException ex, final boolean b) {
            if (this.u(n, mediaPeriodId)) {
                this.b.y(loadEventInfo, mediaLoadData, ex, b);
            }
        }
        
        @Override
        public void c0(final int n, final MediaSource.MediaPeriodId mediaPeriodId) {
            if (this.u(n, mediaPeriodId)) {
                this.c.j();
            }
        }
        
        @Override
        public void k(final int n, final MediaSource.MediaPeriodId mediaPeriodId, final MediaLoadData mediaLoadData) {
            if (this.u(n, mediaPeriodId)) {
                this.b.j(mediaLoadData);
            }
        }
        
        @Override
        public void t(final int n, final MediaSource.MediaPeriodId mediaPeriodId, final LoadEventInfo loadEventInfo, final MediaLoadData mediaLoadData) {
            if (this.u(n, mediaPeriodId)) {
                this.b.s(loadEventInfo, mediaLoadData);
            }
        }
        
        @Override
        public void w(final int n, final MediaSource.MediaPeriodId mediaPeriodId, final LoadEventInfo loadEventInfo, final MediaLoadData mediaLoadData) {
            if (this.u(n, mediaPeriodId)) {
                this.b.B(loadEventInfo, mediaLoadData);
            }
        }
    }
    
    private static final class b
    {
        public final MediaSource a;
        public final MediaSource.MediaSourceCaller b;
        public final a c;
        
        public b(final MediaSource a, final MediaSource.MediaSourceCaller b, final a c) {
            this.a = a;
            this.b = b;
            this.c = c;
        }
    }
    
    static final class c implements i1
    {
        public final MaskingMediaSource a;
        public final Object b;
        public final List<MediaSource.MediaPeriodId> c;
        public int d;
        public boolean e;
        
        public c(final MediaSource mediaSource, final boolean b) {
            this.a = new MaskingMediaSource(mediaSource, b);
            this.c = new ArrayList<MediaSource.MediaPeriodId>();
            this.b = new Object();
        }
        
        @Override
        public Object a() {
            return this.b;
        }
        
        @Override
        public Timeline b() {
            return this.a.D0();
        }
        
        public void c(final int d) {
            this.d = d;
            this.e = false;
            this.c.clear();
        }
    }
}
