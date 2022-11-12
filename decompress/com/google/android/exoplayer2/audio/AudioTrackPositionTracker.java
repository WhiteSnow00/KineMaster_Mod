// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.exoplayer2.audio;

import android.os.SystemClock;
import com.google.android.exoplayer2.util.Util;
import com.google.android.exoplayer2.util.Assertions;
import java.lang.reflect.Method;
import android.media.AudioTrack;

final class AudioTrackPositionTracker
{
    private long A;
    private long B;
    private long C;
    private boolean D;
    private long E;
    private long F;
    private final Listener a;
    private final long[] b;
    private AudioTrack c;
    private int d;
    private int e;
    private l f;
    private int g;
    private boolean h;
    private long i;
    private float j;
    private boolean k;
    private long l;
    private long m;
    private Method n;
    private long o;
    private boolean p;
    private boolean q;
    private long r;
    private long s;
    private long t;
    private long u;
    private int v;
    private int w;
    private long x;
    private long y;
    private long z;
    
    public AudioTrackPositionTracker(final Listener listener) {
        this.a = Assertions.e(listener);
        while (true) {
            if (Util.a < 18) {
                break Label_0035;
            }
            try {
                this.n = AudioTrack.class.getMethod("getLatency", (Class<?>[])null);
                this.b = new long[10];
            }
            catch (final NoSuchMethodException ex) {
                continue;
            }
            break;
        }
    }
    
    private boolean a() {
        return this.h && Assertions.e(this.c).getPlayState() == 2 && this.e() == 0L;
    }
    
    private long b(final long n) {
        return n * 1000000L / this.g;
    }
    
    private long e() {
        final AudioTrack audioTrack = Assertions.e(this.c);
        if (this.x != -9223372036854775807L) {
            return Math.min(this.A, this.z + (SystemClock.elapsedRealtime() * 1000L - this.x) * this.g / 1000000L);
        }
        final int playState = audioTrack.getPlayState();
        if (playState == 1) {
            return 0L;
        }
        long s;
        final long n = s = (0xFFFFFFFFL & (long)audioTrack.getPlaybackHeadPosition());
        if (this.h) {
            if (playState == 2 && n == 0L) {
                this.u = this.s;
            }
            s = n + this.u;
        }
        if (Util.a <= 29) {
            if (s == 0L && this.s > 0L && playState == 3) {
                if (this.y == -9223372036854775807L) {
                    this.y = SystemClock.elapsedRealtime();
                }
                return this.s;
            }
            this.y = -9223372036854775807L;
        }
        if (this.s > s) {
            ++this.t;
        }
        this.s = s;
        return s + (this.t << 32);
    }
    
    private long f() {
        return this.b(this.e());
    }
    
    private void l(final long n, final long n2) {
        final l l = Assertions.e(this.f);
        if (!l.e(n)) {
            return;
        }
        final long c = l.c();
        final long b = l.b();
        if (Math.abs(c - n) > 5000000L) {
            this.a.e(b, c, n, n2);
            l.f();
        }
        else if (Math.abs(this.b(b) - n2) > 5000000L) {
            this.a.d(b, c, n, n2);
            l.f();
        }
        else {
            l.a();
        }
    }
    
    private void m() {
        final long f = this.f();
        if (f == 0L) {
            return;
        }
        final long m = System.nanoTime() / 1000L;
        if (m - this.m >= 30000L) {
            final long[] b = this.b;
            final int v = this.v;
            b[v] = f - m;
            this.v = (v + 1) % 10;
            final int w = this.w;
            if (w < 10) {
                this.w = w + 1;
            }
            this.m = m;
            this.l = 0L;
            int n = 0;
            while (true) {
                final int w2 = this.w;
                if (n >= w2) {
                    break;
                }
                this.l += this.b[n] / w2;
                ++n;
            }
        }
        if (this.h) {
            return;
        }
        this.l(m, f);
        this.n(m);
    }
    
    private void n(final long r) {
        if (this.q) {
            final Method n = this.n;
            if (n != null && r - this.r >= 500000L) {
                try {
                    final long o = Util.j(n.invoke(Assertions.e(this.c), new Object[0])) * 1000L - this.i;
                    this.o = o;
                    final long max = Math.max(o, 0L);
                    this.o = max;
                    if (max > 5000000L) {
                        this.a.c(max);
                        this.o = 0L;
                    }
                }
                catch (final Exception ex) {
                    this.n = null;
                }
                this.r = r;
            }
        }
    }
    
    private static boolean o(final int n) {
        return Util.a < 23 && (n == 5 || n == 6);
    }
    
    private void r() {
        this.l = 0L;
        this.w = 0;
        this.v = 0;
        this.m = 0L;
        this.C = 0L;
        this.F = 0L;
        this.k = false;
    }
    
    public int c(final long n) {
        return this.e - (int)(n - this.e() * this.d);
    }
    
    public long d(final boolean b) {
        if (Assertions.e(this.c).getPlayState() == 3) {
            this.m();
        }
        final long c = System.nanoTime() / 1000L;
        final l l = Assertions.e(this.f);
        final boolean d = l.d();
        long max;
        if (d) {
            max = this.b(l.b()) + Util.a0(c - l.c(), this.j);
        }
        else {
            long f;
            if (this.w == 0) {
                f = this.f();
            }
            else {
                f = this.l + c;
            }
            max = f;
            if (!b) {
                max = Math.max(0L, f - this.o);
            }
        }
        if (this.D != d) {
            this.F = this.C;
            this.E = this.B;
        }
        final long n = c - this.F;
        long b2 = max;
        if (n < 1000000L) {
            final long e = this.E;
            final long a0 = Util.a0(n, this.j);
            final long n2 = n * 1000L / 1000000L;
            b2 = (max * n2 + (1000L - n2) * (e + a0)) / 1000L;
        }
        if (!this.k) {
            final long b3 = this.B;
            if (b2 > b3) {
                this.k = true;
                this.a.b(System.currentTimeMillis() - Util.f1(Util.f0(Util.f1(b2 - b3), this.j)));
            }
        }
        this.C = c;
        this.B = b2;
        this.D = d;
        return b2;
    }
    
    public void g(final long a) {
        this.z = this.e();
        this.x = SystemClock.elapsedRealtime() * 1000L;
        this.A = a;
    }
    
    public boolean h(final long n) {
        return n > this.e() || this.a();
    }
    
    public boolean i() {
        return Assertions.e(this.c).getPlayState() == 3;
    }
    
    public boolean j(final long n) {
        return this.y != -9223372036854775807L && n > 0L && SystemClock.elapsedRealtime() - this.y >= 200L;
    }
    
    public boolean k(final long n) {
        final int playState = Assertions.e(this.c).getPlayState();
        if (this.h) {
            if (playState == 2) {
                return this.p = false;
            }
            if (playState == 1 && this.e() == 0L) {
                return false;
            }
        }
        final boolean p = this.p;
        final boolean h = this.h(n);
        this.p = h;
        if (p && !h && playState != 1) {
            this.a.a(this.e, Util.f1(this.i));
        }
        return true;
    }
    
    public boolean p() {
        this.r();
        if (this.x == -9223372036854775807L) {
            Assertions.e(this.f).g();
            return true;
        }
        return false;
    }
    
    public void q() {
        this.r();
        this.c = null;
        this.f = null;
    }
    
    public void s(final AudioTrack c, final boolean b, final int n, final int d, final int e) {
        this.c = c;
        this.d = d;
        this.e = e;
        this.f = new l(c);
        this.g = c.getSampleRate();
        this.h = (b && o(n));
        final boolean u0 = Util.u0(n);
        this.q = u0;
        long b2;
        if (u0) {
            b2 = this.b(e / d);
        }
        else {
            b2 = -9223372036854775807L;
        }
        this.i = b2;
        this.s = 0L;
        this.t = 0L;
        this.u = 0L;
        this.p = false;
        this.x = -9223372036854775807L;
        this.y = -9223372036854775807L;
        this.r = 0L;
        this.o = 0L;
        this.j = 1.0f;
    }
    
    public void t(final float j) {
        this.j = j;
        final l f = this.f;
        if (f != null) {
            f.g();
        }
    }
    
    public void u() {
        Assertions.e(this.f).g();
    }
    
    public interface Listener
    {
        void a(final int p0, final long p1);
        
        void b(final long p0);
        
        void c(final long p0);
        
        void d(final long p0, final long p1, final long p2, final long p3);
        
        void e(final long p0, final long p1, final long p2, final long p3);
    }
}
