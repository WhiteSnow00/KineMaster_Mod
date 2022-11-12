// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.exoplayer2.drm;

import java.util.Iterator;
import com.google.android.exoplayer2.util.Util;
import com.google.android.exoplayer2.util.Assertions;
import android.os.Handler;
import java.util.concurrent.CopyOnWriteArrayList;
import com.google.android.exoplayer2.source.MediaSource;

public interface DrmSessionEventListener
{
    default void G(final int n, final MediaSource.MediaPeriodId mediaPeriodId) {
    }
    
    @Deprecated
    default void H(final int n, final MediaSource.MediaPeriodId mediaPeriodId) {
    }
    
    default void O(final int n, final MediaSource.MediaPeriodId mediaPeriodId, final Exception ex) {
    }
    
    default void X(final int n, final MediaSource.MediaPeriodId mediaPeriodId) {
    }
    
    default void Z(final int n, final MediaSource.MediaPeriodId mediaPeriodId, final int n2) {
    }
    
    default void a0(final int n, final MediaSource.MediaPeriodId mediaPeriodId) {
    }
    
    default void c0(final int n, final MediaSource.MediaPeriodId mediaPeriodId) {
    }
    
    public static class EventDispatcher
    {
        public final int a;
        public final MediaSource.MediaPeriodId b;
        private final CopyOnWriteArrayList<a> c;
        
        public EventDispatcher() {
            this(new CopyOnWriteArrayList<a>(), 0, null);
        }
        
        private EventDispatcher(final CopyOnWriteArrayList<a> c, final int a, final MediaSource.MediaPeriodId b) {
            this.c = c;
            this.a = a;
            this.b = b;
        }
        
        public static void a(final EventDispatcher eventDispatcher, final DrmSessionEventListener drmSessionEventListener) {
            eventDispatcher.s(drmSessionEventListener);
        }
        
        public static void b(final EventDispatcher eventDispatcher, final DrmSessionEventListener drmSessionEventListener) {
            eventDispatcher.o(drmSessionEventListener);
        }
        
        public static void c(final EventDispatcher eventDispatcher, final DrmSessionEventListener drmSessionEventListener) {
            eventDispatcher.n(drmSessionEventListener);
        }
        
        public static void d(final EventDispatcher eventDispatcher, final DrmSessionEventListener drmSessionEventListener) {
            eventDispatcher.p(drmSessionEventListener);
        }
        
        public static void e(final EventDispatcher eventDispatcher, final DrmSessionEventListener drmSessionEventListener, final Exception ex) {
            eventDispatcher.r(drmSessionEventListener, ex);
        }
        
        public static void f(final EventDispatcher eventDispatcher, final DrmSessionEventListener drmSessionEventListener, final int n) {
            eventDispatcher.q(drmSessionEventListener, n);
        }
        
        private void n(final DrmSessionEventListener drmSessionEventListener) {
            drmSessionEventListener.X(this.a, this.b);
        }
        
        private void o(final DrmSessionEventListener drmSessionEventListener) {
            drmSessionEventListener.G(this.a, this.b);
        }
        
        private void p(final DrmSessionEventListener drmSessionEventListener) {
            drmSessionEventListener.c0(this.a, this.b);
        }
        
        private void q(final DrmSessionEventListener drmSessionEventListener, final int n) {
            drmSessionEventListener.H(this.a, this.b);
            drmSessionEventListener.Z(this.a, this.b, n);
        }
        
        private void r(final DrmSessionEventListener drmSessionEventListener, final Exception ex) {
            drmSessionEventListener.O(this.a, this.b, ex);
        }
        
        private void s(final DrmSessionEventListener drmSessionEventListener) {
            drmSessionEventListener.a0(this.a, this.b);
        }
        
        public void g(final Handler handler, final DrmSessionEventListener drmSessionEventListener) {
            Assertions.e(handler);
            Assertions.e(drmSessionEventListener);
            this.c.add(new a(handler, drmSessionEventListener));
        }
        
        public void h() {
            for (final a a : this.c) {
                Util.L0(a.a, new l(this, a.b));
            }
        }
        
        public void i() {
            for (final a a : this.c) {
                Util.L0(a.a, new k(this, a.b));
            }
        }
        
        public void j() {
            for (final a a : this.c) {
                Util.L0(a.a, new m(this, a.b));
            }
        }
        
        public void k(final int n) {
            for (final a a : this.c) {
                Util.L0(a.a, new n(this, a.b, n));
            }
        }
        
        public void l(final Exception ex) {
            for (final a a : this.c) {
                Util.L0(a.a, new o(this, a.b, ex));
            }
        }
        
        public void m() {
            for (final a a : this.c) {
                Util.L0(a.a, new j(this, a.b));
            }
        }
        
        public void t(final DrmSessionEventListener drmSessionEventListener) {
            for (final a a : this.c) {
                if (a.b == drmSessionEventListener) {
                    this.c.remove(a);
                }
            }
        }
        
        public EventDispatcher u(final int n, final MediaSource.MediaPeriodId mediaPeriodId) {
            return new EventDispatcher(this.c, n, mediaPeriodId);
        }
        
        private static final class a
        {
            public Handler a;
            public DrmSessionEventListener b;
            
            public a(final Handler a, final DrmSessionEventListener b) {
                this.a = a;
                this.b = b;
            }
        }
    }
}
