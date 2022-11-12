// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.exoplayer2;

import android.os.SystemClock;
import com.google.common.primitives.Longs;
import com.google.android.exoplayer2.util.Util;

public final class DefaultLivePlaybackSpeedControl implements LivePlaybackSpeedControl
{
    private final float a;
    private final float b;
    private final long c;
    private final float d;
    private final long e;
    private final long f;
    private final float g;
    private long h;
    private long i;
    private long j;
    private long k;
    private long l;
    private long m;
    private float n;
    private float o;
    private float p;
    private long q;
    private long r;
    private long s;
    
    private DefaultLivePlaybackSpeedControl(final float n, final float n2, final long c, final float d, final long e, final long f, final float g) {
        this.a = n;
        this.b = n2;
        this.c = c;
        this.d = d;
        this.e = e;
        this.f = f;
        this.g = g;
        this.h = -9223372036854775807L;
        this.i = -9223372036854775807L;
        this.k = -9223372036854775807L;
        this.l = -9223372036854775807L;
        this.o = n;
        this.n = n2;
        this.p = 1.0f;
        this.q = -9223372036854775807L;
        this.j = -9223372036854775807L;
        this.m = -9223372036854775807L;
        this.r = -9223372036854775807L;
        this.s = -9223372036854775807L;
    }
    
    DefaultLivePlaybackSpeedControl(final float n, final float n2, final long n3, final float n4, final long n5, final long n6, final float n7, final DefaultLivePlaybackSpeedControl$a object) {
        this(n, n2, n3, n4, n5, n6, n7);
    }
    
    private void f(long m) {
        final long n = this.r + this.s * 3L;
        if (this.m > n) {
            m = Util.C0(this.c);
            final float p = this.p;
            final float n2 = (float)m;
            final long n3 = (long)((p - 1.0f) * n2);
            m = (long)((this.n - 1.0f) * n2);
            this.m = Longs.h(new long[] { n, this.j, this.m - (n3 + m) });
        }
        else {
            final long r = Util.r(m - (long)(Math.max(0.0f, this.p - 1.0f) / this.d), this.m, n);
            this.m = r;
            m = this.l;
            if (m != -9223372036854775807L && r > m) {
                this.m = m;
            }
        }
    }
    
    private void g() {
        long h = this.h;
        long n2;
        if (h != -9223372036854775807L) {
            final long i = this.i;
            if (i != -9223372036854775807L) {
                h = i;
            }
            final long k = this.k;
            long n = h;
            if (k != -9223372036854775807L) {
                n = h;
                if (h < k) {
                    n = k;
                }
            }
            final long l = this.l;
            n2 = n;
            if (l != -9223372036854775807L) {
                n2 = n;
                if (n > l) {
                    n2 = l;
                }
            }
        }
        else {
            n2 = -9223372036854775807L;
        }
        if (this.j == n2) {
            return;
        }
        this.j = n2;
        this.m = n2;
        this.r = -9223372036854775807L;
        this.s = -9223372036854775807L;
        this.q = -9223372036854775807L;
    }
    
    private static long h(final long n, final long n2, final float n3) {
        return (long)(n * n3 + (1.0f - n3) * n2);
    }
    
    private void i(long abs, long r) {
        abs -= r;
        r = this.r;
        if (r == -9223372036854775807L) {
            this.r = abs;
            this.s = 0L;
        }
        else {
            r = Math.max(abs, h(r, abs, this.g));
            this.r = r;
            abs = Math.abs(abs - r);
            this.s = h(this.s, abs, this.g);
        }
    }
    
    @Override
    public void a(final MediaItem.LiveConfiguration liveConfiguration) {
        this.h = Util.C0(liveConfiguration.a);
        this.k = Util.C0(liveConfiguration.b);
        this.l = Util.C0(liveConfiguration.c);
        float o = liveConfiguration.d;
        if (o == -3.4028235E38f) {
            o = this.a;
        }
        this.o = o;
        float n = liveConfiguration.e;
        if (n == -3.4028235E38f) {
            n = this.b;
        }
        this.n = n;
        if (o == 1.0f && n == 1.0f) {
            this.h = -9223372036854775807L;
        }
        this.g();
    }
    
    @Override
    public float b(long n, final long n2) {
        if (this.h == -9223372036854775807L) {
            return 1.0f;
        }
        this.i(n, n2);
        if (this.q != -9223372036854775807L && SystemClock.elapsedRealtime() - this.q < this.c) {
            return this.p;
        }
        this.q = SystemClock.elapsedRealtime();
        this.f(n);
        n -= this.m;
        if (Math.abs(n) < this.e) {
            this.p = 1.0f;
        }
        else {
            this.p = Util.p(this.d * n + 1.0f, this.o, this.n);
        }
        return this.p;
    }
    
    @Override
    public long c() {
        return this.m;
    }
    
    @Override
    public void d() {
        final long m = this.m;
        if (m == -9223372036854775807L) {
            return;
        }
        final long i = m + this.f;
        this.m = i;
        final long l = this.l;
        if (l != -9223372036854775807L && i > l) {
            this.m = l;
        }
        this.q = -9223372036854775807L;
    }
    
    @Override
    public void e(final long i) {
        this.i = i;
        this.g();
    }
    
    public static final class Builder
    {
        private float a;
        private float b;
        private long c;
        private float d;
        private long e;
        private long f;
        private float g;
        
        public Builder() {
            this.a = 0.97f;
            this.b = 1.03f;
            this.c = 1000L;
            this.d = 1.0E-7f;
            this.e = Util.C0(20L);
            this.f = Util.C0(500L);
            this.g = 0.999f;
        }
        
        public DefaultLivePlaybackSpeedControl a() {
            return new DefaultLivePlaybackSpeedControl(this.a, this.b, this.c, this.d, this.e, this.f, this.g, null);
        }
    }
}
