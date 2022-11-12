// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.exoplayer2.util;

import java.util.Arrays;

public final class TimedValueQueue<V>
{
    private long[] a;
    private V[] b;
    private int c;
    private int d;
    
    public TimedValueQueue() {
        this(10);
    }
    
    public TimedValueQueue(final int n) {
        this.a = new long[n];
        this.b = f(n);
    }
    
    private void b(final long n, final V v) {
        final int c = this.c;
        final int d = this.d;
        final V[] b = this.b;
        final int n2 = (c + d) % b.length;
        this.a[n2] = n;
        b[n2] = v;
        this.d = d + 1;
    }
    
    private void d(final long n) {
        final int d = this.d;
        if (d > 0 && n <= this.a[(this.c + d - 1) % this.b.length]) {
            this.c();
        }
    }
    
    private void e() {
        final int length = this.b.length;
        if (this.d < length) {
            return;
        }
        final int n = length * 2;
        final long[] a = new long[n];
        final Object[] f = f(n);
        final int c = this.c;
        final int n2 = length - c;
        System.arraycopy(this.a, c, a, 0, n2);
        System.arraycopy(this.b, this.c, f, 0, n2);
        final int c2 = this.c;
        if (c2 > 0) {
            System.arraycopy(this.a, 0, a, n2, c2);
            System.arraycopy(this.b, 0, f, n2, this.c);
        }
        this.a = a;
        this.b = (V[])f;
        this.c = 0;
    }
    
    private static <V> V[] f(final int n) {
        return (V[])new Object[n];
    }
    
    private V h(final long n, final boolean b) {
        V k = null;
        long n2 = Long.MAX_VALUE;
        while (this.d > 0) {
            final long n3 = n - this.a[this.c];
            if (n3 < 0L) {
                if (b) {
                    break;
                }
                if (-n3 >= n2) {
                    break;
                }
            }
            k = this.k();
            n2 = n3;
        }
        return k;
    }
    
    private V k() {
        Assertions.g(this.d > 0);
        final V[] b = this.b;
        final int c = this.c;
        final V v = b[c];
        b[c] = null;
        this.c = (c + 1) % b.length;
        --this.d;
        return v;
    }
    
    public void a(final long n, final V v) {
        synchronized (this) {
            this.d(n);
            this.e();
            this.b(n, v);
        }
    }
    
    public void c() {
        synchronized (this) {
            this.c = 0;
            this.d = 0;
            Arrays.fill(this.b, null);
        }
    }
    
    public V g(final long n) {
        synchronized (this) {
            return this.h(n, false);
        }
    }
    
    public V i() {
        synchronized (this) {
            V k;
            if (this.d == 0) {
                k = null;
            }
            else {
                k = this.k();
            }
            return k;
        }
    }
    
    public V j(final long n) {
        synchronized (this) {
            return this.h(n, true);
        }
    }
    
    public int l() {
        synchronized (this) {
            return this.d;
        }
    }
}
