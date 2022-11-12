// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.exoplayer2.source;

import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.UnknownNull;
import com.google.android.exoplayer2.drm.DrmSessionEventListener;
import com.google.android.exoplayer2.util.Util;
import java.io.IOException;
import java.util.Iterator;
import com.google.android.exoplayer2.Timeline;
import com.google.android.exoplayer2.upstream.TransferListener;
import android.os.Handler;
import java.util.HashMap;

public abstract class CompositeMediaSource<T> extends BaseMediaSource
{
    private final HashMap<T, b<T>> h;
    private Handler i;
    private TransferListener j;
    
    protected CompositeMediaSource() {
        this.h = new HashMap<T, b<T>>();
    }
    
    public static void p0(final CompositeMediaSource compositeMediaSource, final Object o, final MediaSource mediaSource, final Timeline timeline) {
        compositeMediaSource.v0(o, mediaSource, timeline);
    }
    
    private void v0(final Object o, final MediaSource mediaSource, final Timeline timeline) {
        this.w0(o, mediaSource, timeline);
    }
    
    @Override
    public void U() throws IOException {
        final Iterator<b<T>> iterator = this.h.values().iterator();
        while (iterator.hasNext()) {
            iterator.next().a.U();
        }
    }
    
    @Override
    protected void i0() {
        for (final b b : this.h.values()) {
            b.a.Q(b.b);
        }
    }
    
    @Override
    protected void j0() {
        for (final b b : this.h.values()) {
            b.a.K(b.b);
        }
    }
    
    @Override
    protected void m0(final TransferListener j) {
        this.j = j;
        this.i = Util.w();
    }
    
    @Override
    protected void o0() {
        for (final b b : this.h.values()) {
            b.a.x(b.b);
            b.a.C(b.c);
            b.a.T(b.c);
        }
        this.h.clear();
    }
    
    protected final void q0(@UnknownNull final T t) {
        final b b = Assertions.e(this.h.get(t));
        b.a.Q(b.b);
    }
    
    protected final void r0(@UnknownNull final T t) {
        final b b = Assertions.e(this.h.get(t));
        b.a.K(b.b);
    }
    
    protected MediaPeriodId s0(@UnknownNull final T t, final MediaPeriodId mediaPeriodId) {
        return mediaPeriodId;
    }
    
    protected long t0(@UnknownNull final T t, final long n) {
        return n;
    }
    
    protected int u0(@UnknownNull final T t, final int n) {
        return n;
    }
    
    protected abstract void w0(@UnknownNull final T p0, final MediaSource p1, final Timeline p2);
    
    protected final void x0(@UnknownNull final T t, final MediaSource mediaSource) {
        Assertions.a(this.h.containsKey(t) ^ true);
        final com.google.android.exoplayer2.source.a a = new com.google.android.exoplayer2.source.a(this, t);
        final a a2 = new a(t);
        this.h.put(t, new b<T>(mediaSource, a, a2));
        mediaSource.B(Assertions.e(this.i), a2);
        mediaSource.S(Assertions.e(this.i), a2);
        mediaSource.E((MediaSource.MediaSourceCaller)a, this.j, this.k0());
        if (!this.l0()) {
            mediaSource.Q((MediaSource.MediaSourceCaller)a);
        }
    }
    
    protected final void y0(@UnknownNull final T t) {
        final b b = Assertions.e(this.h.remove(t));
        b.a.x(b.b);
        b.a.C(b.c);
        b.a.T(b.c);
    }
    
    private final class a implements MediaSourceEventListener, DrmSessionEventListener
    {
        @UnknownNull
        private final T a;
        private MediaSourceEventListener.EventDispatcher b;
        private DrmSessionEventListener.EventDispatcher c;
        final CompositeMediaSource d;
        
        public a(@UnknownNull final CompositeMediaSource d, final T a) {
            this.d = d;
            this.b = d.g0(null);
            this.c = d.e0(null);
            this.a = a;
        }
        
        private boolean u(int u0, MediaPeriodId s0) {
            if (s0 != null) {
                if ((s0 = this.d.s0(this.a, s0)) == null) {
                    return false;
                }
            }
            else {
                s0 = null;
            }
            u0 = this.d.u0(this.a, u0);
            final MediaSourceEventListener.EventDispatcher b = this.b;
            if (b.a != u0 || !Util.c(b.b, s0)) {
                this.b = this.d.f0(u0, s0, 0L);
            }
            final DrmSessionEventListener.EventDispatcher c = this.c;
            if (c.a != u0 || !Util.c(c.b, s0)) {
                this.c = this.d.d0(u0, s0);
            }
            return true;
        }
        
        private MediaLoadData v(final MediaLoadData mediaLoadData) {
            final long t0 = this.d.t0(this.a, mediaLoadData.f);
            final long t2 = this.d.t0(this.a, mediaLoadData.g);
            if (t0 == mediaLoadData.f && t2 == mediaLoadData.g) {
                return mediaLoadData;
            }
            return new MediaLoadData(mediaLoadData.a, mediaLoadData.b, mediaLoadData.c, mediaLoadData.d, mediaLoadData.e, t0, t2);
        }
        
        @Override
        public void G(final int n, final MediaPeriodId mediaPeriodId) {
            if (this.u(n, mediaPeriodId)) {
                this.c.i();
            }
        }
        
        @Override
        public void M(final int n, final MediaPeriodId mediaPeriodId, final MediaLoadData mediaLoadData) {
            if (this.u(n, mediaPeriodId)) {
                this.b.E(this.v(mediaLoadData));
            }
        }
        
        @Override
        public void O(final int n, final MediaPeriodId mediaPeriodId, final Exception ex) {
            if (this.u(n, mediaPeriodId)) {
                this.c.l(ex);
            }
        }
        
        @Override
        public void X(final int n, final MediaPeriodId mediaPeriodId) {
            if (this.u(n, mediaPeriodId)) {
                this.c.h();
            }
        }
        
        @Override
        public void Y(final int n, final MediaPeriodId mediaPeriodId, final LoadEventInfo loadEventInfo, final MediaLoadData mediaLoadData) {
            if (this.u(n, mediaPeriodId)) {
                this.b.v(loadEventInfo, this.v(mediaLoadData));
            }
        }
        
        @Override
        public void Z(final int n, final MediaPeriodId mediaPeriodId, final int n2) {
            if (this.u(n, mediaPeriodId)) {
                this.c.k(n2);
            }
        }
        
        @Override
        public void a0(final int n, final MediaPeriodId mediaPeriodId) {
            if (this.u(n, mediaPeriodId)) {
                this.c.m();
            }
        }
        
        @Override
        public void b0(final int n, final MediaPeriodId mediaPeriodId, final LoadEventInfo loadEventInfo, final MediaLoadData mediaLoadData, final IOException ex, final boolean b) {
            if (this.u(n, mediaPeriodId)) {
                this.b.y(loadEventInfo, this.v(mediaLoadData), ex, b);
            }
        }
        
        @Override
        public void c0(final int n, final MediaPeriodId mediaPeriodId) {
            if (this.u(n, mediaPeriodId)) {
                this.c.j();
            }
        }
        
        @Override
        public void k(final int n, final MediaPeriodId mediaPeriodId, final MediaLoadData mediaLoadData) {
            if (this.u(n, mediaPeriodId)) {
                this.b.j(this.v(mediaLoadData));
            }
        }
        
        @Override
        public void t(final int n, final MediaPeriodId mediaPeriodId, final LoadEventInfo loadEventInfo, final MediaLoadData mediaLoadData) {
            if (this.u(n, mediaPeriodId)) {
                this.b.s(loadEventInfo, this.v(mediaLoadData));
            }
        }
        
        @Override
        public void w(final int n, final MediaPeriodId mediaPeriodId, final LoadEventInfo loadEventInfo, final MediaLoadData mediaLoadData) {
            if (this.u(n, mediaPeriodId)) {
                this.b.B(loadEventInfo, this.v(mediaLoadData));
            }
        }
    }
    
    private static final class b<T>
    {
        public final MediaSource a;
        public final MediaSourceCaller b;
        public final a c;
        
        public b(final MediaSource a, final MediaSourceCaller b, final a c) {
            this.a = a;
            this.b = b;
            this.c = c;
        }
    }
}
