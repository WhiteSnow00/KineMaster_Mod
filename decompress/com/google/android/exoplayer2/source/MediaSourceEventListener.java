// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.exoplayer2.source;

import android.os.Handler;
import com.google.android.exoplayer2.util.Assertions;
import java.util.Iterator;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.util.Util;
import java.util.concurrent.CopyOnWriteArrayList;
import java.io.IOException;

public interface MediaSourceEventListener
{
    default void M(final int n, final MediaSource.MediaPeriodId mediaPeriodId, final MediaLoadData mediaLoadData) {
    }
    
    default void Y(final int n, final MediaSource.MediaPeriodId mediaPeriodId, final LoadEventInfo loadEventInfo, final MediaLoadData mediaLoadData) {
    }
    
    default void b0(final int n, final MediaSource.MediaPeriodId mediaPeriodId, final LoadEventInfo loadEventInfo, final MediaLoadData mediaLoadData, final IOException ex, final boolean b) {
    }
    
    default void k(final int n, final MediaSource.MediaPeriodId mediaPeriodId, final MediaLoadData mediaLoadData) {
    }
    
    default void t(final int n, final MediaSource.MediaPeriodId mediaPeriodId, final LoadEventInfo loadEventInfo, final MediaLoadData mediaLoadData) {
    }
    
    default void w(final int n, final MediaSource.MediaPeriodId mediaPeriodId, final LoadEventInfo loadEventInfo, final MediaLoadData mediaLoadData) {
    }
    
    public static class EventDispatcher
    {
        public final int a;
        public final MediaSource.MediaPeriodId b;
        private final CopyOnWriteArrayList<a> c;
        private final long d;
        
        public EventDispatcher() {
            this(new CopyOnWriteArrayList<a>(), 0, null, 0L);
        }
        
        private EventDispatcher(final CopyOnWriteArrayList<a> c, final int a, final MediaSource.MediaPeriodId b, final long d) {
            this.c = c;
            this.a = a;
            this.b = b;
            this.d = d;
        }
        
        public static void a(final EventDispatcher eventDispatcher, final MediaSourceEventListener mediaSourceEventListener, final MediaSource.MediaPeriodId mediaPeriodId, final MediaLoadData mediaLoadData) {
            eventDispatcher.p(mediaSourceEventListener, mediaPeriodId, mediaLoadData);
        }
        
        public static void b(final EventDispatcher eventDispatcher, final MediaSourceEventListener mediaSourceEventListener, final LoadEventInfo loadEventInfo, final MediaLoadData mediaLoadData, final IOException ex, final boolean b) {
            eventDispatcher.n(mediaSourceEventListener, loadEventInfo, mediaLoadData, ex, b);
        }
        
        public static void c(final EventDispatcher eventDispatcher, final MediaSourceEventListener mediaSourceEventListener, final LoadEventInfo loadEventInfo, final MediaLoadData mediaLoadData) {
            eventDispatcher.m(mediaSourceEventListener, loadEventInfo, mediaLoadData);
        }
        
        public static void d(final EventDispatcher eventDispatcher, final MediaSourceEventListener mediaSourceEventListener, final MediaLoadData mediaLoadData) {
            eventDispatcher.k(mediaSourceEventListener, mediaLoadData);
        }
        
        public static void e(final EventDispatcher eventDispatcher, final MediaSourceEventListener mediaSourceEventListener, final LoadEventInfo loadEventInfo, final MediaLoadData mediaLoadData) {
            eventDispatcher.o(mediaSourceEventListener, loadEventInfo, mediaLoadData);
        }
        
        public static void f(final EventDispatcher eventDispatcher, final MediaSourceEventListener mediaSourceEventListener, final LoadEventInfo loadEventInfo, final MediaLoadData mediaLoadData) {
            eventDispatcher.l(mediaSourceEventListener, loadEventInfo, mediaLoadData);
        }
        
        private long h(long n) {
            final long f1 = Util.f1(n);
            n = -9223372036854775807L;
            if (f1 != -9223372036854775807L) {
                n = this.d + f1;
            }
            return n;
        }
        
        private void k(final MediaSourceEventListener mediaSourceEventListener, final MediaLoadData mediaLoadData) {
            mediaSourceEventListener.k(this.a, this.b, mediaLoadData);
        }
        
        private void l(final MediaSourceEventListener mediaSourceEventListener, final LoadEventInfo loadEventInfo, final MediaLoadData mediaLoadData) {
            mediaSourceEventListener.t(this.a, this.b, loadEventInfo, mediaLoadData);
        }
        
        private void m(final MediaSourceEventListener mediaSourceEventListener, final LoadEventInfo loadEventInfo, final MediaLoadData mediaLoadData) {
            mediaSourceEventListener.Y(this.a, this.b, loadEventInfo, mediaLoadData);
        }
        
        private void n(final MediaSourceEventListener mediaSourceEventListener, final LoadEventInfo loadEventInfo, final MediaLoadData mediaLoadData, final IOException ex, final boolean b) {
            mediaSourceEventListener.b0(this.a, this.b, loadEventInfo, mediaLoadData, ex, b);
        }
        
        private void o(final MediaSourceEventListener mediaSourceEventListener, final LoadEventInfo loadEventInfo, final MediaLoadData mediaLoadData) {
            mediaSourceEventListener.w(this.a, this.b, loadEventInfo, mediaLoadData);
        }
        
        private void p(final MediaSourceEventListener mediaSourceEventListener, final MediaSource.MediaPeriodId mediaPeriodId, final MediaLoadData mediaLoadData) {
            mediaSourceEventListener.M(this.a, mediaPeriodId, mediaLoadData);
        }
        
        public void A(final LoadEventInfo loadEventInfo, final int n, final int n2, final Format format, final int n3, final Object o, final long n4, final long n5) {
            this.B(loadEventInfo, new MediaLoadData(n, n2, format, n3, o, this.h(n4), this.h(n5)));
        }
        
        public void B(final LoadEventInfo loadEventInfo, final MediaLoadData mediaLoadData) {
            for (final a a : this.c) {
                Util.L0(a.a, new k(this, a.b, loadEventInfo, mediaLoadData));
            }
        }
        
        public void C(final MediaSourceEventListener mediaSourceEventListener) {
            for (final a a : this.c) {
                if (a.b == mediaSourceEventListener) {
                    this.c.remove(a);
                }
            }
        }
        
        public void D(final int n, final long n2, final long n3) {
            this.E(new MediaLoadData(1, n, null, 3, null, this.h(n2), this.h(n3)));
        }
        
        public void E(final MediaLoadData mediaLoadData) {
            final MediaSource.MediaPeriodId mediaPeriodId = Assertions.e(this.b);
            for (final a a : this.c) {
                Util.L0(a.a, new o(this, a.b, mediaPeriodId, mediaLoadData));
            }
        }
        
        public EventDispatcher F(final int n, final MediaSource.MediaPeriodId mediaPeriodId, final long n2) {
            return new EventDispatcher(this.c, n, mediaPeriodId, n2);
        }
        
        public void g(final Handler handler, final MediaSourceEventListener mediaSourceEventListener) {
            Assertions.e(handler);
            Assertions.e(mediaSourceEventListener);
            this.c.add(new a(handler, mediaSourceEventListener));
        }
        
        public void i(final int n, final Format format, final int n2, final Object o, final long n3) {
            this.j(new MediaLoadData(1, n, format, n2, o, this.h(n3), -9223372036854775807L));
        }
        
        public void j(final MediaLoadData mediaLoadData) {
            for (final a a : this.c) {
                Util.L0(a.a, new n(this, a.b, mediaLoadData));
            }
        }
        
        public void q(final LoadEventInfo loadEventInfo, final int n) {
            this.r(loadEventInfo, n, -1, null, 0, null, -9223372036854775807L, -9223372036854775807L);
        }
        
        public void r(final LoadEventInfo loadEventInfo, final int n, final int n2, final Format format, final int n3, final Object o, final long n4, final long n5) {
            this.s(loadEventInfo, new MediaLoadData(n, n2, format, n3, o, this.h(n4), this.h(n5)));
        }
        
        public void s(final LoadEventInfo loadEventInfo, final MediaLoadData mediaLoadData) {
            for (final a a : this.c) {
                Util.L0(a.a, new l(this, a.b, loadEventInfo, mediaLoadData));
            }
        }
        
        public void t(final LoadEventInfo loadEventInfo, final int n) {
            this.u(loadEventInfo, n, -1, null, 0, null, -9223372036854775807L, -9223372036854775807L);
        }
        
        public void u(final LoadEventInfo loadEventInfo, final int n, final int n2, final Format format, final int n3, final Object o, final long n4, final long n5) {
            this.v(loadEventInfo, new MediaLoadData(n, n2, format, n3, o, this.h(n4), this.h(n5)));
        }
        
        public void v(final LoadEventInfo loadEventInfo, final MediaLoadData mediaLoadData) {
            for (final a a : this.c) {
                Util.L0(a.a, new j(this, a.b, loadEventInfo, mediaLoadData));
            }
        }
        
        public void w(final LoadEventInfo loadEventInfo, final int n, final int n2, final Format format, final int n3, final Object o, final long n4, final long n5, final IOException ex, final boolean b) {
            this.y(loadEventInfo, new MediaLoadData(n, n2, format, n3, o, this.h(n4), this.h(n5)), ex, b);
        }
        
        public void x(final LoadEventInfo loadEventInfo, final int n, final IOException ex, final boolean b) {
            this.w(loadEventInfo, n, -1, null, 0, null, -9223372036854775807L, -9223372036854775807L, ex, b);
        }
        
        public void y(final LoadEventInfo loadEventInfo, final MediaLoadData mediaLoadData, final IOException ex, final boolean b) {
            for (final a a : this.c) {
                Util.L0(a.a, new m(this, a.b, loadEventInfo, mediaLoadData, ex, b));
            }
        }
        
        public void z(final LoadEventInfo loadEventInfo, final int n) {
            this.A(loadEventInfo, n, -1, null, 0, null, -9223372036854775807L, -9223372036854775807L);
        }
        
        private static final class a
        {
            public Handler a;
            public MediaSourceEventListener b;
            
            public a(final Handler a, final MediaSourceEventListener b) {
                this.a = a;
                this.b = b;
            }
        }
    }
}
