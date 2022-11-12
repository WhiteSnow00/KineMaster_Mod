// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.exoplayer2.upstream;

import com.google.android.exoplayer2.util.Util;
import java.util.Arrays;
import com.google.android.exoplayer2.util.Assertions;

public final class DefaultAllocator implements Allocator
{
    private final boolean a;
    private final int b;
    private final byte[] c;
    private int d;
    private int e;
    private int f;
    private Allocation[] g;
    
    public DefaultAllocator(final boolean b, final int n) {
        this(b, n, 0);
    }
    
    public DefaultAllocator(final boolean a, final int b, final int f) {
        final boolean b2 = true;
        int i = 0;
        Assertions.a(b > 0);
        Assertions.a(f >= 0 && b2);
        this.a = a;
        this.b = b;
        this.f = f;
        this.g = new Allocation[f + 100];
        if (f > 0) {
            this.c = new byte[f * b];
            while (i < f) {
                this.g[i] = new Allocation(this.c, i * b);
                ++i;
            }
        }
        else {
            this.c = null;
        }
    }
    
    @Override
    public void a(AllocationNode next) {
        monitorenter(this);
        while (true) {
            Label_0052: {
                if (next == null) {
                    break Label_0052;
                }
                try {
                    this.g[this.f++] = ((AllocationNode)next).a();
                    --this.e;
                    next = ((AllocationNode)next).next();
                    continue;
                    this.notifyAll();
                }
                finally {
                    monitorexit(this);
                }
            }
        }
    }
    
    @Override
    public Allocation b() {
        synchronized (this) {
            ++this.e;
            int f = this.f;
            Allocation allocation;
            if (f > 0) {
                final Allocation[] g = this.g;
                --f;
                this.f = f;
                allocation = Assertions.e(g[f]);
                this.g[this.f] = null;
            }
            else {
                final Allocation allocation2 = new Allocation(new byte[this.b], 0);
                final int e = this.e;
                final Allocation[] g2 = this.g;
                allocation = allocation2;
                if (e > g2.length) {
                    this.g = Arrays.copyOf(g2, g2.length * 2);
                    allocation = allocation2;
                }
            }
            return allocation;
        }
    }
    
    @Override
    public void c(final Allocation allocation) {
        synchronized (this) {
            this.g[this.f++] = allocation;
            --this.e;
            this.notifyAll();
        }
    }
    
    @Override
    public void d() {
        synchronized (this) {
            final int l = Util.l(this.d, this.b);
            final int e = this.e;
            int i = 0;
            final int max = Math.max(0, l - e);
            final int f = this.f;
            if (max >= f) {
                return;
            }
            int max2 = max;
            if (this.c != null) {
                int n = f - 1;
                while (i <= n) {
                    final Allocation allocation = Assertions.e(this.g[i]);
                    if (allocation.a == this.c) {
                        ++i;
                    }
                    else {
                        final Allocation allocation2 = Assertions.e(this.g[n]);
                        if (allocation2.a != this.c) {
                            --n;
                        }
                        else {
                            final Allocation[] g = this.g;
                            g[i] = allocation2;
                            g[n] = allocation;
                            --n;
                            ++i;
                        }
                    }
                }
                if ((max2 = Math.max(max, i)) >= this.f) {
                    return;
                }
            }
            Arrays.fill(this.g, max2, this.f, null);
            this.f = max2;
        }
    }
    
    @Override
    public int e() {
        return this.b;
    }
    
    public int f() {
        synchronized (this) {
            return this.e * this.b;
        }
    }
    
    public void g() {
        synchronized (this) {
            if (this.a) {
                this.h(0);
            }
        }
    }
    
    public void h(final int d) {
        synchronized (this) {
            final boolean b = d < this.d;
            this.d = d;
            if (b) {
                this.d();
            }
        }
    }
}
