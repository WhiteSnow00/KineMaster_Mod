// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.exoplayer2.source;

import java.util.ArrayList;
import java.util.HashMap;
import com.google.android.exoplayer2.upstream.Allocator;
import android.os.Handler$Callback;
import com.google.android.exoplayer2.upstream.TransferListener;
import java.util.HashSet;
import com.google.android.exoplayer2.Timeline;
import com.google.android.exoplayer2.util.Util;
import android.os.Message;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.AbstractConcatenatedTimeline;
import java.util.Iterator;
import java.util.Collection;
import android.net.Uri;
import java.util.IdentityHashMap;
import android.os.Handler;
import java.util.List;
import java.util.Set;
import java.util.Map;
import com.google.android.exoplayer2.MediaItem;

public final class ConcatenatingMediaSource extends CompositeMediaSource<e>
{
    private static final MediaItem H;
    private final Map<Object, e> A;
    private final Set<e> B;
    private final boolean C;
    private final boolean D;
    private boolean E;
    private Set<d> F;
    private ShuffleOrder G;
    private final List<e> p;
    private final Set<d> w;
    private Handler x;
    private final List<e> y;
    private final IdentityHashMap<MediaPeriod, e> z;
    
    static {
        H = new MediaItem.Builder().i(Uri.EMPTY).a();
    }
    
    static MediaItem A0() {
        return ConcatenatingMediaSource.H;
    }
    
    private void B0(final int n, final e e) {
        if (n > 0) {
            final e e2 = this.y.get(n - 1);
            e.a(n, e2.e + e2.a.D0().t());
        }
        else {
            e.a(n, 0);
        }
        this.D0(n, 1, e.a.D0().t());
        this.y.add(n, e);
        this.A.put(e.b, e);
        this.x0(e, e.a);
        if (this.l0() && this.z.isEmpty()) {
            this.B.add(e);
        }
        else {
            this.q0(e);
        }
    }
    
    private void C0(int n, final Collection<e> collection) {
        final Iterator<e> iterator = collection.iterator();
        while (iterator.hasNext()) {
            this.B0(n, iterator.next());
            ++n;
        }
    }
    
    private void D0(int i, final int n, final int n2) {
        while (i < this.y.size()) {
            final e e = this.y.get(i);
            e.d += n;
            e.e += n2;
            ++i;
        }
    }
    
    private void E0() {
        final Iterator<e> iterator = this.B.iterator();
        while (iterator.hasNext()) {
            final e e = iterator.next();
            if (e.c.isEmpty()) {
                this.q0(e);
                iterator.remove();
            }
        }
    }
    
    private void F0(final Set<d> set) {
        synchronized (this) {
            final Iterator<d> iterator = set.iterator();
            while (iterator.hasNext()) {
                iterator.next().a();
            }
            this.w.removeAll(set);
        }
    }
    
    private void G0(final e e) {
        this.B.add(e);
        this.r0(e);
    }
    
    private static Object H0(final Object o) {
        return AbstractConcatenatedTimeline.B(o);
    }
    
    private static Object J0(final Object o) {
        return AbstractConcatenatedTimeline.C(o);
    }
    
    private static Object K0(final e e, final Object o) {
        return AbstractConcatenatedTimeline.E(e.b, o);
    }
    
    private Handler L0() {
        return Assertions.e(this.x);
    }
    
    private boolean N0(final Message message) {
        final int what = message.what;
        if (what != 0) {
            if (what != 1) {
                if (what != 2) {
                    if (what != 3) {
                        if (what != 4) {
                            if (what != 5) {
                                throw new IllegalStateException();
                            }
                            this.F0(Util.j(message.obj));
                        }
                        else {
                            this.V0();
                        }
                    }
                    else {
                        final f f = Util.j(message.obj);
                        this.G = (ShuffleOrder)f.b;
                        this.T0(f.c);
                    }
                }
                else {
                    final f f2 = Util.j(message.obj);
                    final ShuffleOrder g = this.G;
                    final int a = f2.a;
                    final ShuffleOrder a2 = g.a(a, a + 1);
                    this.G = a2;
                    this.G = a2.g((int)f2.b, 1);
                    this.P0(f2.a, (int)f2.b);
                    this.T0(f2.c);
                }
            }
            else {
                final f f3 = Util.j(message.obj);
                final int a3 = f3.a;
                int i = (int)f3.b;
                if (a3 == 0 && i == this.G.getLength()) {
                    this.G = this.G.e();
                }
                else {
                    this.G = this.G.a(a3, i);
                }
                --i;
                while (i >= a3) {
                    this.R0(i);
                    --i;
                }
                this.T0(f3.c);
            }
        }
        else {
            final f f4 = Util.j(message.obj);
            this.G = this.G.g(f4.a, ((Collection)f4.b).size());
            this.C0(f4.a, (Collection<e>)f4.b);
            this.T0(f4.c);
        }
        return true;
    }
    
    private void O0(final e e) {
        if (e.f && e.c.isEmpty()) {
            this.B.remove(e);
            this.y0(e);
        }
    }
    
    private void P0(int e, int i) {
        final int min = Math.min(e, i);
        final int max = Math.max(e, i);
        final int e2 = this.y.get(min).e;
        final List<e> y = this.y;
        y.add(i, y.remove(e));
        e = e2;
        e e3;
        for (i = min; i <= max; ++i) {
            e3 = this.y.get(i);
            e3.d = i;
            e3.e = e;
            e += e3.a.D0().t();
        }
    }
    
    private void R0(final int n) {
        final e e = this.y.remove(n);
        this.A.remove(e.b);
        this.D0(n, -1, -e.a.D0().t());
        e.f = true;
        this.O0(e);
    }
    
    private void S0() {
        this.T0(null);
    }
    
    private void T0(final d d) {
        if (!this.E) {
            this.L0().obtainMessage(4).sendToTarget();
            this.E = true;
        }
        if (d != null) {
            this.F.add(d);
        }
    }
    
    private void U0(final e e, final Timeline timeline) {
        if (e.d + 1 < this.y.size()) {
            final int n = timeline.t() - (this.y.get(e.d + 1).e - e.e);
            if (n != 0) {
                this.D0(e.d + 1, 0, n);
            }
        }
        this.S0();
    }
    
    private void V0() {
        this.E = false;
        final Set<d> f = this.F;
        this.F = new HashSet<d>();
        this.n0(new b(this.y, this.G, this.C));
        this.L0().obtainMessage(5, (Object)f).sendToTarget();
    }
    
    public static boolean z0(final ConcatenatingMediaSource concatenatingMediaSource, final Message message) {
        return concatenatingMediaSource.N0(message);
    }
    
    @Override
    public MediaItem F() {
        return ConcatenatingMediaSource.H;
    }
    
    @Override
    public void I(final MediaPeriod mediaPeriod) {
        final e e = Assertions.e(this.z.remove(mediaPeriod));
        e.a.I(mediaPeriod);
        e.c.remove(((MaskingMediaPeriod)mediaPeriod).a);
        if (!this.z.isEmpty()) {
            this.E0();
        }
        this.O0(e);
    }
    
    protected MediaPeriodId I0(final e e, final MediaPeriodId mediaPeriodId) {
        for (int i = 0; i < e.c.size(); ++i) {
            if (e.c.get(i).d == mediaPeriodId.d) {
                return mediaPeriodId.c(K0(e, mediaPeriodId.a));
            }
        }
        return null;
    }
    
    protected int M0(final e e, final int n) {
        return n + e.e;
    }
    
    protected void Q0(final e e, final MediaSource mediaSource, final Timeline timeline) {
        this.U0(e, timeline);
    }
    
    @Override
    public boolean V() {
        return false;
    }
    
    @Override
    public Timeline W() {
        synchronized (this) {
            ShuffleOrder shuffleOrder;
            if (this.G.getLength() != this.p.size()) {
                shuffleOrder = this.G.e().g(0, this.p.size());
            }
            else {
                shuffleOrder = this.G;
            }
            return new b(this.p, shuffleOrder, this.C);
        }
    }
    
    @Override
    protected void i0() {
        super.i0();
        this.B.clear();
    }
    
    @Override
    protected void j0() {
    }
    
    @Override
    protected void m0(final TransferListener transferListener) {
        synchronized (this) {
            super.m0(transferListener);
            this.x = new Handler((Handler$Callback)new com.google.android.exoplayer2.source.b(this));
            if (this.p.isEmpty()) {
                this.V0();
            }
            else {
                this.G = this.G.g(0, this.p.size());
                this.C0(0, this.p);
                this.S0();
            }
        }
    }
    
    @Override
    protected void o0() {
        synchronized (this) {
            super.o0();
            this.y.clear();
            this.B.clear();
            this.A.clear();
            this.G = this.G.e();
            final Handler x = this.x;
            if (x != null) {
                x.removeCallbacksAndMessages((Object)null);
                this.x = null;
            }
            this.E = false;
            this.F.clear();
            this.F0(this.w);
        }
    }
    
    @Override
    protected /* bridge */ MediaPeriodId s0(final Object o, final MediaPeriodId mediaPeriodId) {
        return this.I0((e)o, mediaPeriodId);
    }
    
    @Override
    public MediaPeriod u(final MediaPeriodId mediaPeriodId, final Allocator allocator, final long n) {
        final Object j0 = J0(mediaPeriodId.a);
        final MediaSource.MediaPeriodId c = mediaPeriodId.c(H0(mediaPeriodId.a));
        e e;
        if ((e = this.A.get(j0)) == null) {
            e = new e(new c(null), this.D);
            e.f = true;
            this.x0(e, e.a);
        }
        this.G0(e);
        e.c.add(c);
        final MaskingMediaPeriod z0 = e.a.z0(c, allocator, n);
        this.z.put(z0, e);
        this.E0();
        return z0;
    }
    
    @Override
    protected /* bridge */ int u0(final Object o, final int n) {
        return this.M0((e)o, n);
    }
    
    @Override
    protected /* bridge */ void w0(final Object o, final MediaSource mediaSource, final Timeline timeline) {
        this.Q0((e)o, mediaSource, timeline);
    }
    
    private static final class b extends AbstractConcatenatedTimeline
    {
        private final int f;
        private final int g;
        private final int[] h;
        private final int[] i;
        private final Timeline[] j;
        private final Object[] p;
        private final HashMap<Object, Integer> w;
        
        public b(final Collection<e> collection, final ShuffleOrder shuffleOrder, final boolean b) {
            super(b, shuffleOrder);
            final int size = collection.size();
            this.h = new int[size];
            this.i = new int[size];
            this.j = new Timeline[size];
            this.p = new Object[size];
            this.w = new HashMap<Object, Integer>();
            final Iterator iterator = collection.iterator();
            int f = 0;
            int g = 0;
            int n = 0;
            while (iterator.hasNext()) {
                final e e = (e)iterator.next();
                this.j[n] = e.a.D0();
                this.i[n] = f;
                this.h[n] = g;
                f += this.j[n].t();
                g += this.j[n].m();
                final Object[] p3 = this.p;
                p3[n] = e.b;
                this.w.put(p3[n], n);
                ++n;
            }
            this.f = f;
            this.g = g;
        }
        
        @Override
        protected int A(final int n) {
            return Util.h(this.i, n + 1, false, false);
        }
        
        @Override
        protected Object D(final int n) {
            return this.p[n];
        }
        
        @Override
        protected int F(final int n) {
            return this.h[n];
        }
        
        @Override
        protected int G(final int n) {
            return this.i[n];
        }
        
        @Override
        protected Timeline J(final int n) {
            return this.j[n];
        }
        
        @Override
        public int m() {
            return this.g;
        }
        
        @Override
        public int t() {
            return this.f;
        }
        
        @Override
        protected int y(final Object o) {
            final Integer n = this.w.get(o);
            int intValue;
            if (n == null) {
                intValue = -1;
            }
            else {
                intValue = n;
            }
            return intValue;
        }
        
        @Override
        protected int z(final int n) {
            return Util.h(this.h, n + 1, false, false);
        }
    }
    
    private static final class c extends BaseMediaSource
    {
        private c() {
        }
        
        c(final ConcatenatingMediaSource$a object) {
            this();
        }
        
        @Override
        public MediaItem F() {
            return ConcatenatingMediaSource.A0();
        }
        
        @Override
        public void I(final MediaPeriod mediaPeriod) {
        }
        
        @Override
        public void U() {
        }
        
        @Override
        protected void m0(final TransferListener transferListener) {
        }
        
        @Override
        protected void o0() {
        }
        
        @Override
        public MediaPeriod u(final MediaPeriodId mediaPeriodId, final Allocator allocator, final long n) {
            throw new UnsupportedOperationException();
        }
    }
    
    private static final class d
    {
        private final Handler a;
        private final Runnable b;
        
        public void a() {
            this.a.post(this.b);
        }
    }
    
    static final class e
    {
        public final MaskingMediaSource a;
        public final Object b;
        public final List<MediaPeriodId> c;
        public int d;
        public int e;
        public boolean f;
        
        public e(final MediaSource mediaSource, final boolean b) {
            this.a = new MaskingMediaSource(mediaSource, b);
            this.c = new ArrayList<MediaPeriodId>();
            this.b = new Object();
        }
        
        public void a(final int d, final int e) {
            this.d = d;
            this.e = e;
            this.f = false;
            this.c.clear();
        }
    }
    
    private static final class f<T>
    {
        public final int a;
        public final T b;
        public final d c;
    }
}
