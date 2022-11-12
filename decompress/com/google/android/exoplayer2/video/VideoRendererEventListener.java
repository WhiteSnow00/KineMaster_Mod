// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.exoplayer2.video;

import h4.e;
import h4.g;
import h4.c;
import h4.f;
import h4.k;
import h4.l;
import h4.h;
import h4.i;
import h4.d;
import h4.j;
import android.os.SystemClock;
import com.google.android.exoplayer2.util.Util;
import com.google.android.exoplayer2.util.Assertions;
import android.os.Handler;
import com.google.android.exoplayer2.decoder.DecoderCounters;
import com.google.android.exoplayer2.decoder.DecoderReuseEvaluation;
import com.google.android.exoplayer2.Format;

public interface VideoRendererEventListener
{
    default void b(final String s) {
    }
    
    default void d(final String s, final long n, final long n2) {
    }
    
    default void g(final Format format, final DecoderReuseEvaluation decoderReuseEvaluation) {
    }
    
    default void i(final Exception ex) {
    }
    
    default void j(final DecoderCounters decoderCounters) {
    }
    
    default void m(final int n, final long n2) {
    }
    
    default void o(final Object o, final long n) {
    }
    
    default void onVideoSizeChanged(final VideoSize videoSize) {
    }
    
    default void p(final DecoderCounters decoderCounters) {
    }
    
    default void s(final long n, final int n2) {
    }
    
    @Deprecated
    default void x(final Format format) {
    }
    
    public static final class EventDispatcher
    {
        private final Handler a;
        private final VideoRendererEventListener b;
        
        public EventDispatcher(Handler a, final VideoRendererEventListener b) {
            if (b != null) {
                a = Assertions.e(a);
            }
            else {
                a = null;
            }
            this.a = a;
            this.b = b;
        }
        
        public static void a(final EventDispatcher eventDispatcher, final DecoderCounters decoderCounters) {
            eventDispatcher.s(decoderCounters);
        }
        
        public static void b(final EventDispatcher eventDispatcher, final String s) {
            eventDispatcher.r(s);
        }
        
        public static void c(final EventDispatcher eventDispatcher, final Exception ex) {
            eventDispatcher.y(ex);
        }
        
        public static void d(final EventDispatcher eventDispatcher, final DecoderCounters decoderCounters) {
            eventDispatcher.u(decoderCounters);
        }
        
        public static void e(final EventDispatcher eventDispatcher, final Object o, final long n) {
            eventDispatcher.w(o, n);
        }
        
        public static void f(final EventDispatcher eventDispatcher, final int n, final long n2) {
            eventDispatcher.t(n, n2);
        }
        
        public static void g(final EventDispatcher eventDispatcher, final String s, final long n, final long n2) {
            eventDispatcher.q(s, n, n2);
        }
        
        public static void h(final EventDispatcher eventDispatcher, final VideoSize videoSize) {
            eventDispatcher.z(videoSize);
        }
        
        public static void i(final EventDispatcher eventDispatcher, final Format format, final DecoderReuseEvaluation decoderReuseEvaluation) {
            eventDispatcher.v(format, decoderReuseEvaluation);
        }
        
        public static void j(final EventDispatcher eventDispatcher, final long n, final int n2) {
            eventDispatcher.x(n, n2);
        }
        
        private void q(final String s, final long n, final long n2) {
            Util.j(this.b).d(s, n, n2);
        }
        
        private void r(final String s) {
            Util.j(this.b).b(s);
        }
        
        private void s(final DecoderCounters decoderCounters) {
            decoderCounters.c();
            Util.j(this.b).j(decoderCounters);
        }
        
        private void t(final int n, final long n2) {
            Util.j(this.b).m(n, n2);
        }
        
        private void u(final DecoderCounters decoderCounters) {
            Util.j(this.b).p(decoderCounters);
        }
        
        private void v(final Format format, final DecoderReuseEvaluation decoderReuseEvaluation) {
            Util.j(this.b).x(format);
            Util.j(this.b).g(format, decoderReuseEvaluation);
        }
        
        private void w(final Object o, final long n) {
            Util.j(this.b).o(o, n);
        }
        
        private void x(final long n, final int n2) {
            Util.j(this.b).s(n, n2);
        }
        
        private void y(final Exception ex) {
            Util.j(this.b).i(ex);
        }
        
        private void z(final VideoSize videoSize) {
            Util.j(this.b).onVideoSizeChanged(videoSize);
        }
        
        public void A(final Object o) {
            if (this.a != null) {
                this.a.post((Runnable)new j(this, o, SystemClock.elapsedRealtime()));
            }
        }
        
        public void B(final long n, final int n2) {
            final Handler a = this.a;
            if (a != null) {
                a.post((Runnable)new d(this, n, n2));
            }
        }
        
        public void C(final Exception ex) {
            final Handler a = this.a;
            if (a != null) {
                a.post((Runnable)new i(this, ex));
            }
        }
        
        public void D(final VideoSize videoSize) {
            final Handler a = this.a;
            if (a != null) {
                a.post((Runnable)new h(this, videoSize));
            }
        }
        
        public void k(final String s, final long n, final long n2) {
            final Handler a = this.a;
            if (a != null) {
                a.post((Runnable)new l(this, s, n, n2));
            }
        }
        
        public void l(final String s) {
            final Handler a = this.a;
            if (a != null) {
                a.post((Runnable)new k(this, s));
            }
        }
        
        public void m(final DecoderCounters decoderCounters) {
            decoderCounters.c();
            final Handler a = this.a;
            if (a != null) {
                a.post((Runnable)new f(this, decoderCounters));
            }
        }
        
        public void n(final int n, final long n2) {
            final Handler a = this.a;
            if (a != null) {
                a.post((Runnable)new c(this, n, n2));
            }
        }
        
        public void o(final DecoderCounters decoderCounters) {
            final Handler a = this.a;
            if (a != null) {
                a.post((Runnable)new g(this, decoderCounters));
            }
        }
        
        public void p(final Format format, final DecoderReuseEvaluation decoderReuseEvaluation) {
            final Handler a = this.a;
            if (a != null) {
                a.post((Runnable)new e(this, format, decoderReuseEvaluation));
            }
        }
    }
}
