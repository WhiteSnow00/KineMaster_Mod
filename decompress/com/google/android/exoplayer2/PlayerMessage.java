// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.exoplayer2;

import java.util.concurrent.TimeoutException;
import com.google.android.exoplayer2.util.Assertions;
import android.os.Looper;
import com.google.android.exoplayer2.util.Clock;

public final class PlayerMessage
{
    private final Target a;
    private final Sender b;
    private final Clock c;
    private final Timeline d;
    private int e;
    private Object f;
    private Looper g;
    private int h;
    private long i;
    private boolean j;
    private boolean k;
    private boolean l;
    private boolean m;
    private boolean n;
    
    public PlayerMessage(final Sender b, final Target a, final Timeline d, final int h, final Clock c, final Looper g) {
        this.b = b;
        this.a = a;
        this.d = d;
        this.g = g;
        this.c = c;
        this.h = h;
        this.i = -9223372036854775807L;
        this.j = true;
    }
    
    public boolean a(final long n) throws InterruptedException, TimeoutException {
        synchronized (this) {
            Assertions.g(this.k);
            Assertions.g(this.g.getThread() != Thread.currentThread());
            final long c = this.c.c();
            long n2 = n;
            boolean m;
            while (true) {
                m = this.m;
                if (m || n2 <= 0L) {
                    break;
                }
                this.c.f();
                this.wait(n2);
                n2 = c + n - this.c.c();
            }
            if (m) {
                return this.l;
            }
            throw new TimeoutException("Message delivery timed out.");
        }
    }
    
    public boolean b() {
        return this.j;
    }
    
    public Looper c() {
        return this.g;
    }
    
    public int d() {
        return this.h;
    }
    
    public Object e() {
        return this.f;
    }
    
    public long f() {
        return this.i;
    }
    
    public Target g() {
        return this.a;
    }
    
    public Timeline h() {
        return this.d;
    }
    
    public int i() {
        return this.e;
    }
    
    public boolean j() {
        synchronized (this) {
            return this.n;
        }
    }
    
    public void k(final boolean b) {
        synchronized (this) {
            this.l |= b;
            this.m = true;
            this.notifyAll();
        }
    }
    
    public PlayerMessage l() {
        Assertions.g(this.k ^ true);
        if (this.i == -9223372036854775807L) {
            Assertions.a(this.j);
        }
        this.k = true;
        this.b.c(this);
        return this;
    }
    
    public PlayerMessage m(final Object f) {
        Assertions.g(this.k ^ true);
        this.f = f;
        return this;
    }
    
    public PlayerMessage n(final int e) {
        Assertions.g(this.k ^ true);
        this.e = e;
        return this;
    }
    
    public interface Sender
    {
        void c(final PlayerMessage p0);
    }
    
    public interface Target
    {
        void p(final int p0, final Object p1) throws ExoPlaybackException;
    }
}
