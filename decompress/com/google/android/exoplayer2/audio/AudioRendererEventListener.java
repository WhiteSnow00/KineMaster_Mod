// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.exoplayer2.audio;

import com.google.android.exoplayer2.util.Util;
import com.google.android.exoplayer2.util.Assertions;
import android.os.Handler;
import com.google.android.exoplayer2.decoder.DecoderReuseEvaluation;
import com.google.android.exoplayer2.decoder.DecoderCounters;
import com.google.android.exoplayer2.Format;

public interface AudioRendererEventListener
{
    @Deprecated
    default void B(final Format format) {
    }
    
    default void a(final Exception ex) {
    }
    
    default void c(final DecoderCounters decoderCounters) {
    }
    
    default void e(final String s) {
    }
    
    default void f(final String s, final long n, final long n2) {
    }
    
    default void h(final long n) {
    }
    
    default void l(final DecoderCounters decoderCounters) {
    }
    
    default void n(final Format format, final DecoderReuseEvaluation decoderReuseEvaluation) {
    }
    
    default void onSkipSilenceEnabledChanged(final boolean b) {
    }
    
    default void q(final Exception ex) {
    }
    
    default void r(final int n, final long n2, final long n3) {
    }
    
    public static final class EventDispatcher
    {
        private final Handler a;
        private final AudioRendererEventListener b;
        
        public EventDispatcher(Handler a, final AudioRendererEventListener b) {
            if (b != null) {
                a = Assertions.e(a);
            }
            else {
                a = null;
            }
            this.a = a;
            this.b = b;
        }
        
        private void A(final int n, final long n2, final long n3) {
            Util.j(this.b).r(n, n2, n3);
        }
        
        public static void a(final EventDispatcher eventDispatcher, final boolean b) {
            eventDispatcher.z(b);
        }
        
        public static void b(final EventDispatcher eventDispatcher, final DecoderCounters decoderCounters) {
            eventDispatcher.v(decoderCounters);
        }
        
        public static void c(final EventDispatcher eventDispatcher, final Exception ex) {
            eventDispatcher.r(ex);
        }
        
        public static void d(final EventDispatcher eventDispatcher, final Exception ex) {
            eventDispatcher.s(ex);
        }
        
        public static void e(final EventDispatcher eventDispatcher, final Format format, final DecoderReuseEvaluation decoderReuseEvaluation) {
            eventDispatcher.x(format, decoderReuseEvaluation);
        }
        
        public static void f(final EventDispatcher eventDispatcher, final String s, final long n, final long n2) {
            eventDispatcher.t(s, n, n2);
        }
        
        public static void g(final EventDispatcher eventDispatcher, final String s) {
            eventDispatcher.u(s);
        }
        
        public static void h(final EventDispatcher eventDispatcher, final long n) {
            eventDispatcher.y(n);
        }
        
        public static void i(final EventDispatcher eventDispatcher, final int n, final long n2, final long n3) {
            eventDispatcher.A(n, n2, n3);
        }
        
        public static void j(final EventDispatcher eventDispatcher, final DecoderCounters decoderCounters) {
            eventDispatcher.w(decoderCounters);
        }
        
        private void r(final Exception ex) {
            Util.j(this.b).q(ex);
        }
        
        private void s(final Exception ex) {
            Util.j(this.b).a(ex);
        }
        
        private void t(final String s, final long n, final long n2) {
            Util.j(this.b).f(s, n, n2);
        }
        
        private void u(final String s) {
            Util.j(this.b).e(s);
        }
        
        private void v(final DecoderCounters decoderCounters) {
            decoderCounters.c();
            Util.j(this.b).l(decoderCounters);
        }
        
        private void w(final DecoderCounters decoderCounters) {
            Util.j(this.b).c(decoderCounters);
        }
        
        private void x(final Format format, final DecoderReuseEvaluation decoderReuseEvaluation) {
            Util.j(this.b).B(format);
            Util.j(this.b).n(format, decoderReuseEvaluation);
        }
        
        private void y(final long n) {
            Util.j(this.b).h(n);
        }
        
        private void z(final boolean b) {
            Util.j(this.b).onSkipSilenceEnabledChanged(b);
        }
        
        public void B(final long n) {
            final Handler a = this.a;
            if (a != null) {
                a.post((Runnable)new c(this, n));
            }
        }
        
        public void C(final boolean b) {
            final Handler a = this.a;
            if (a != null) {
                a.post((Runnable)new k(this, b));
            }
        }
        
        public void D(final int n, final long n2, final long n3) {
            final Handler a = this.a;
            if (a != null) {
                a.post((Runnable)new b(this, n, n2, n3));
            }
        }
        
        public void k(final Exception ex) {
            final Handler a = this.a;
            if (a != null) {
                a.post((Runnable)new g(this, ex));
            }
        }
        
        public void l(final Exception ex) {
            final Handler a = this.a;
            if (a != null) {
                a.post((Runnable)new h(this, ex));
            }
        }
        
        public void m(final String s, final long n, final long n2) {
            final Handler a = this.a;
            if (a != null) {
                a.post((Runnable)new j(this, s, n, n2));
            }
        }
        
        public void n(final String s) {
            final Handler a = this.a;
            if (a != null) {
                a.post((Runnable)new i(this, s));
            }
        }
        
        public void o(final DecoderCounters decoderCounters) {
            decoderCounters.c();
            final Handler a = this.a;
            if (a != null) {
                a.post((Runnable)new e(this, decoderCounters));
            }
        }
        
        public void p(final DecoderCounters decoderCounters) {
            final Handler a = this.a;
            if (a != null) {
                a.post((Runnable)new f(this, decoderCounters));
            }
        }
        
        public void q(final Format format, final DecoderReuseEvaluation decoderReuseEvaluation) {
            final Handler a = this.a;
            if (a != null) {
                a.post((Runnable)new d(this, format, decoderReuseEvaluation));
            }
        }
    }
}
