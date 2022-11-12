// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.exoplayer2.video;

import android.os.Message;
import android.view.Choreographer;
import android.os.HandlerThread;
import android.os.Handler;
import android.os.Handler$Callback;
import android.view.Choreographer$FrameCallback;
import android.hardware.display.DisplayManager;
import android.hardware.display.DisplayManager$DisplayListener;
import android.view.WindowManager;
import h4.b;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.Log;
import com.google.android.exoplayer2.util.Util;
import android.view.Display;
import android.content.Context;
import android.view.Surface;

public final class VideoFrameReleaseHelper
{
    private final com.google.android.exoplayer2.video.a a;
    private final DisplayHelper b;
    private final d c;
    private boolean d;
    private Surface e;
    private float f;
    private float g;
    private float h;
    private float i;
    private int j;
    private long k;
    private long l;
    private long m;
    private long n;
    private long o;
    private long p;
    private long q;
    
    public VideoFrameReleaseHelper(final Context context) {
        this.a = new com.google.android.exoplayer2.video.a();
        final DisplayHelper f = f(context);
        this.b = f;
        d d;
        if (f != null) {
            d = VideoFrameReleaseHelper.d.d();
        }
        else {
            d = null;
        }
        this.c = d;
        this.k = -9223372036854775807L;
        this.l = -9223372036854775807L;
        this.f = -1.0f;
        this.i = 1.0f;
        this.j = 0;
    }
    
    public static void a(final VideoFrameReleaseHelper videoFrameReleaseHelper, final Display display) {
        videoFrameReleaseHelper.p(display);
    }
    
    private static boolean c(final long n, final long n2) {
        return Math.abs(n - n2) <= 20000000L;
    }
    
    private void d() {
        if (Util.a >= 30) {
            final Surface e = this.e;
            if (e != null && this.j != Integer.MIN_VALUE) {
                if (this.h != 0.0f) {
                    VideoFrameReleaseHelper.a.a(e, this.h = 0.0f);
                }
            }
        }
    }
    
    private static long e(final long n, long n2, long n3) {
        n2 += (n - n2) / n3 * n3;
        if (n <= n2) {
            final long n4 = n2 - n3;
            n3 = n2;
            n2 = n4;
        }
        else {
            n3 += n2;
        }
        if (n3 - n < n - n2) {
            n2 = n3;
        }
        return n2;
    }
    
    private static DisplayHelper f(final Context context) {
        Object c = null;
        final DisplayHelper displayHelper = null;
        if (context != null) {
            final Context applicationContext = context.getApplicationContext();
            Object d = displayHelper;
            if (Util.a >= 17) {
                d = VideoFrameReleaseHelper.c.d(applicationContext);
            }
            if ((c = d) == null) {
                c = b.c(applicationContext);
            }
        }
        return (DisplayHelper)c;
    }
    
    private void n() {
        this.m = 0L;
        this.p = -1L;
        this.n = -1L;
    }
    
    private void p(final Display display) {
        if (display != null) {
            final long k = (long)(1.0E9 / display.getRefreshRate());
            this.k = k;
            this.l = k * 80L / 100L;
        }
        else {
            Log.i("VideoFrameReleaseHelper", "Unable to query display refresh rate");
            this.k = -9223372036854775807L;
            this.l = -9223372036854775807L;
        }
    }
    
    private void q() {
        if (Util.a >= 30) {
            if (this.e != null) {
                float g;
                if (this.a.e()) {
                    g = this.a.b();
                }
                else {
                    g = this.f;
                }
                final float g2 = this.g;
                if (g == g2) {
                    return;
                }
                final float n = fcmpl(g, -1.0f);
                final boolean b = true;
                int n3 = 0;
                Label_0168: {
                    if (n != 0 && g2 != -1.0f) {
                        float n2;
                        if (this.a.e() && this.a.d() >= 5000000000L) {
                            n2 = 0.02f;
                        }
                        else {
                            n2 = 1.0f;
                        }
                        if (Math.abs(g - this.g) >= n2) {
                            n3 = (b ? 1 : 0);
                            break Label_0168;
                        }
                    }
                    else {
                        if (n != 0) {
                            n3 = (b ? 1 : 0);
                            break Label_0168;
                        }
                        if (this.a.c() >= 30) {
                            n3 = (b ? 1 : 0);
                            break Label_0168;
                        }
                    }
                    n3 = 0;
                }
                if (n3 != 0) {
                    this.g = g;
                    this.r(false);
                }
            }
        }
    }
    
    private void r(final boolean b) {
        if (Util.a >= 30) {
            final Surface e = this.e;
            if (e != null) {
                if (this.j != Integer.MIN_VALUE) {
                    float h;
                    final float n = h = 0.0f;
                    if (this.d) {
                        final float g = this.g;
                        h = n;
                        if (g != -1.0f) {
                            h = this.i * g;
                        }
                    }
                    if (!b && this.h == h) {
                        return;
                    }
                    VideoFrameReleaseHelper.a.a(e, this.h = h);
                }
            }
        }
    }
    
    public long b(long o) {
        if (this.p != -1L && this.a.e()) {
            final long n = this.q + (long)(this.a.a() * (this.m - this.p) / this.i);
            if (c(o, n)) {
                o = n;
            }
            else {
                this.n();
            }
        }
        this.n = this.m;
        this.o = o;
        final d c = this.c;
        if (c == null || this.k == -9223372036854775807L) {
            return o;
        }
        final long a = c.a;
        if (a == -9223372036854775807L) {
            return o;
        }
        return e(o, a, this.k) - this.l;
    }
    
    public void g(final float f) {
        this.f = f;
        this.a.g();
        this.q();
    }
    
    public void h(final long n) {
        final long n2 = this.n;
        if (n2 != -1L) {
            this.p = n2;
            this.q = this.o;
        }
        ++this.m;
        this.a.f(n * 1000L);
        this.q();
    }
    
    public void i(final float i) {
        this.i = i;
        this.n();
        this.r(false);
    }
    
    public void j() {
        this.n();
    }
    
    public void k() {
        this.d = true;
        this.n();
        if (this.b != null) {
            Assertions.e(this.c).a();
            this.b.b((DisplayHelper.Listener)new h4.b(this));
        }
        this.r(false);
    }
    
    public void l() {
        this.d = false;
        final DisplayHelper b = this.b;
        if (b != null) {
            b.a();
            Assertions.e(this.c).e();
        }
        this.d();
    }
    
    public void m(final Surface surface) {
        Surface e = surface;
        if (surface instanceof PlaceholderSurface) {
            e = null;
        }
        if (this.e == e) {
            return;
        }
        this.d();
        this.e = e;
        this.r(true);
    }
    
    public void o(final int j) {
        if (this.j == j) {
            return;
        }
        this.j = j;
        this.r(true);
    }
    
    private interface DisplayHelper
    {
        void a();
        
        void b(final Listener p0);
        
        public interface Listener
        {
            void a(final Display p0);
        }
    }
    
    private static final class a
    {
        public static void a(final Surface surface, final float n) {
            int n2;
            if (n == 0.0f) {
                n2 = 0;
            }
            else {
                n2 = 1;
            }
            try {
                surface.setFrameRate(n, n2);
            }
            catch (final IllegalStateException ex) {
                Log.d("VideoFrameReleaseHelper", "Failed to call Surface.setFrameRate", ex);
            }
        }
    }
    
    private static final class b implements DisplayHelper
    {
        private final WindowManager a;
        
        private b(final WindowManager a) {
            this.a = a;
        }
        
        public static DisplayHelper c(final Context context) {
            final WindowManager windowManager = (WindowManager)context.getSystemService("window");
            b b;
            if (windowManager != null) {
                b = new b(windowManager);
            }
            else {
                b = null;
            }
            return b;
        }
        
        @Override
        public void a() {
        }
        
        @Override
        public void b(final Listener listener) {
            listener.a(this.a.getDefaultDisplay());
        }
    }
    
    private static final class c implements DisplayHelper, DisplayManager$DisplayListener
    {
        private final DisplayManager a;
        private Listener b;
        
        private c(final DisplayManager a) {
            this.a = a;
        }
        
        private Display c() {
            return this.a.getDisplay(0);
        }
        
        public static DisplayHelper d(final Context context) {
            final DisplayManager displayManager = (DisplayManager)context.getSystemService("display");
            c c;
            if (displayManager != null) {
                c = new c(displayManager);
            }
            else {
                c = null;
            }
            return c;
        }
        
        @Override
        public void a() {
            this.a.unregisterDisplayListener((DisplayManager$DisplayListener)this);
            this.b = null;
        }
        
        @Override
        public void b(final Listener b) {
            this.b = b;
            this.a.registerDisplayListener((DisplayManager$DisplayListener)this, Util.w());
            b.a(this.c());
        }
        
        public void onDisplayAdded(final int n) {
        }
        
        public void onDisplayChanged(final int n) {
            final Listener b = this.b;
            if (b != null && n == 0) {
                b.a(this.c());
            }
        }
        
        public void onDisplayRemoved(final int n) {
        }
    }
    
    private static final class d implements Choreographer$FrameCallback, Handler$Callback
    {
        private static final d f;
        public volatile long a;
        private final Handler b;
        private final HandlerThread c;
        private Choreographer d;
        private int e;
        
        static {
            f = new d();
        }
        
        private d() {
            this.a = -9223372036854775807L;
            final HandlerThread c = new HandlerThread("ExoPlayer:FrameReleaseChoreographer");
            (this.c = c).start();
            (this.b = Util.v(c.getLooper(), (Handler$Callback)this)).sendEmptyMessage(0);
        }
        
        private void b() {
            final Choreographer d = this.d;
            if (d != null && ++this.e == 1) {
                d.postFrameCallback((Choreographer$FrameCallback)this);
            }
        }
        
        private void c() {
            try {
                this.d = Choreographer.getInstance();
            }
            catch (final RuntimeException ex) {
                Log.j("VideoFrameReleaseHelper", "Vsync sampling disabled due to platform error", ex);
            }
        }
        
        public static d d() {
            return d.f;
        }
        
        private void f() {
            final Choreographer d = this.d;
            if (d != null && --this.e == 0) {
                d.removeFrameCallback((Choreographer$FrameCallback)this);
                this.a = -9223372036854775807L;
            }
        }
        
        public void a() {
            this.b.sendEmptyMessage(1);
        }
        
        public void doFrame(final long a) {
            this.a = a;
            Assertions.e(this.d).postFrameCallbackDelayed((Choreographer$FrameCallback)this, 500L);
        }
        
        public void e() {
            this.b.sendEmptyMessage(2);
        }
        
        public boolean handleMessage(final Message message) {
            final int what = message.what;
            if (what == 0) {
                this.c();
                return true;
            }
            if (what == 1) {
                this.b();
                return true;
            }
            if (what != 2) {
                return false;
            }
            this.f();
            return true;
        }
    }
}
