// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.exoplayer2.source;

import java.util.Iterator;
import com.google.android.exoplayer2.upstream.TransferListener;
import com.google.android.exoplayer2.util.Assertions;
import android.os.Handler;
import com.google.android.exoplayer2.analytics.PlayerId;
import com.google.android.exoplayer2.Timeline;
import android.os.Looper;
import com.google.android.exoplayer2.drm.DrmSessionEventListener;
import java.util.HashSet;
import java.util.ArrayList;

public abstract class BaseMediaSource implements MediaSource
{
    private final ArrayList<MediaSourceCaller> a;
    private final HashSet<MediaSourceCaller> b;
    private final MediaSourceEventListener.EventDispatcher c;
    private final DrmSessionEventListener.EventDispatcher d;
    private Looper e;
    private Timeline f;
    private PlayerId g;
    
    public BaseMediaSource() {
        this.a = new ArrayList<MediaSourceCaller>(1);
        this.b = new HashSet<MediaSourceCaller>(1);
        this.c = new MediaSourceEventListener.EventDispatcher();
        this.d = new DrmSessionEventListener.EventDispatcher();
    }
    
    @Override
    public final void B(final Handler handler, final MediaSourceEventListener mediaSourceEventListener) {
        Assertions.e(handler);
        Assertions.e(mediaSourceEventListener);
        this.c.g(handler, mediaSourceEventListener);
    }
    
    @Override
    public final void C(final MediaSourceEventListener mediaSourceEventListener) {
        this.c.C(mediaSourceEventListener);
    }
    
    @Override
    public final void E(final MediaSourceCaller mediaSourceCaller, final TransferListener transferListener, final PlayerId g) {
        final Looper myLooper = Looper.myLooper();
        final Looper e = this.e;
        Assertions.a(e == null || e == myLooper);
        this.g = g;
        final Timeline f = this.f;
        this.a.add(mediaSourceCaller);
        if (this.e == null) {
            this.e = myLooper;
            this.b.add(mediaSourceCaller);
            this.m0(transferListener);
        }
        else if (f != null) {
            this.K(mediaSourceCaller);
            mediaSourceCaller.N(this, f);
        }
    }
    
    @Override
    public final void K(final MediaSourceCaller mediaSourceCaller) {
        Assertions.e(this.e);
        final boolean empty = this.b.isEmpty();
        this.b.add(mediaSourceCaller);
        if (empty) {
            this.j0();
        }
    }
    
    @Override
    public final void Q(final MediaSourceCaller mediaSourceCaller) {
        final boolean empty = this.b.isEmpty();
        this.b.remove(mediaSourceCaller);
        if ((empty ^ true) && this.b.isEmpty()) {
            this.i0();
        }
    }
    
    @Override
    public final void S(final Handler handler, final DrmSessionEventListener drmSessionEventListener) {
        Assertions.e(handler);
        Assertions.e(drmSessionEventListener);
        this.d.g(handler, drmSessionEventListener);
    }
    
    @Override
    public final void T(final DrmSessionEventListener drmSessionEventListener) {
        this.d.t(drmSessionEventListener);
    }
    
    protected final DrmSessionEventListener.EventDispatcher d0(final int n, final MediaPeriodId mediaPeriodId) {
        return this.d.u(n, mediaPeriodId);
    }
    
    protected final DrmSessionEventListener.EventDispatcher e0(final MediaPeriodId mediaPeriodId) {
        return this.d.u(0, mediaPeriodId);
    }
    
    protected final MediaSourceEventListener.EventDispatcher f0(final int n, final MediaPeriodId mediaPeriodId, final long n2) {
        return this.c.F(n, mediaPeriodId, n2);
    }
    
    protected final MediaSourceEventListener.EventDispatcher g0(final MediaPeriodId mediaPeriodId) {
        return this.c.F(0, mediaPeriodId, 0L);
    }
    
    protected final MediaSourceEventListener.EventDispatcher h0(final MediaPeriodId mediaPeriodId, final long n) {
        Assertions.e(mediaPeriodId);
        return this.c.F(0, mediaPeriodId, n);
    }
    
    protected void i0() {
    }
    
    protected void j0() {
    }
    
    protected final PlayerId k0() {
        return Assertions.i(this.g);
    }
    
    protected final boolean l0() {
        return this.b.isEmpty() ^ true;
    }
    
    protected abstract void m0(final TransferListener p0);
    
    protected final void n0(final Timeline f) {
        this.f = f;
        final Iterator<MediaSourceCaller> iterator = this.a.iterator();
        while (iterator.hasNext()) {
            iterator.next().N(this, f);
        }
    }
    
    protected abstract void o0();
    
    @Override
    public final void x(final MediaSourceCaller mediaSourceCaller) {
        this.a.remove(mediaSourceCaller);
        if (this.a.isEmpty()) {
            this.e = null;
            this.f = null;
            this.g = null;
            this.b.clear();
            this.o0();
        }
        else {
            this.Q(mediaSourceCaller);
        }
    }
}
