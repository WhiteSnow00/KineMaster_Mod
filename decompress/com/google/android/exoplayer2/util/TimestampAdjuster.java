// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.exoplayer2.util;

public final class TimestampAdjuster
{
    private long a;
    private long b;
    private long c;
    private final ThreadLocal<Long> d;
    
    public TimestampAdjuster(final long n) {
        this.d = new ThreadLocal<Long>();
        this.g(n);
    }
    
    public static long f(final long n) {
        return n * 1000000L / 90000L;
    }
    
    public static long i(final long n) {
        return n * 90000L / 1000000L;
    }
    
    public static long j(final long n) {
        return i(n) % 8589934592L;
    }
    
    public long a(final long c) {
        monitorenter(this);
        if (c == -9223372036854775807L) {
            monitorexit(this);
            return -9223372036854775807L;
        }
        try {
            if (this.b == -9223372036854775807L) {
                long n;
                if ((n = this.a) == 9223372036854775806L) {
                    n = Assertions.e(this.d.get());
                }
                this.b = n - c;
                this.notifyAll();
            }
            this.c = c;
            final long b = this.b;
            monitorexit(this);
            return c + b;
        }
        finally {
            monitorexit(this);
        }
    }
    
    public long b(long a) {
        monitorenter(this);
        if (a == -9223372036854775807L) {
            monitorexit(this);
            return -9223372036854775807L;
        }
        try {
            final long c = this.c;
            long n = a;
            if (c != -9223372036854775807L) {
                final long i = i(c);
                final long n2 = (4294967296L + i) / 8589934592L;
                final long n3 = (n2 - 1L) * 8589934592L + a;
                a = (n = a + n2 * 8589934592L);
                if (Math.abs(n3 - i) < Math.abs(a - i)) {
                    n = n3;
                }
            }
            a = this.a(f(n));
            return a;
        }
        finally {
            monitorexit(this);
        }
    }
    
    public long c() {
        synchronized (this) {
            final long a = this.a;
            if (a != Long.MAX_VALUE) {
                final long n = a;
                if (a != 9223372036854775806L) {
                    return n;
                }
            }
            return -9223372036854775807L;
        }
    }
    
    public long d() {
        synchronized (this) {
            final long c = this.c;
            long c2;
            if (c != -9223372036854775807L) {
                c2 = c + this.b;
            }
            else {
                c2 = this.c();
            }
            return c2;
        }
    }
    
    public long e() {
        synchronized (this) {
            return this.b;
        }
    }
    
    public void g(long n) {
        synchronized (this) {
            this.a = n;
            if (n == Long.MAX_VALUE) {
                n = 0L;
            }
            else {
                n = -9223372036854775807L;
            }
            this.b = n;
            this.c = -9223372036854775807L;
        }
    }
    
    public void h(final boolean b, final long n) throws InterruptedException {
        synchronized (this) {
            Assertions.g(this.a == 9223372036854775806L);
            if (this.b != -9223372036854775807L) {
                return;
            }
            if (b) {
                this.d.set(n);
            }
            else {
                while (this.b == -9223372036854775807L) {
                    this.wait();
                }
            }
        }
    }
}
