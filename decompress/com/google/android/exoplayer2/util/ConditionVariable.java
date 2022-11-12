// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.exoplayer2.util;

public class ConditionVariable
{
    private final Clock a;
    private boolean b;
    
    public ConditionVariable() {
        this(Clock.a);
    }
    
    public ConditionVariable(final Clock a) {
        this.a = a;
    }
    
    public void a() throws InterruptedException {
        synchronized (this) {
            while (!this.b) {
                this.wait();
            }
        }
    }
    
    public boolean b(long c) throws InterruptedException {
        monitorenter(this);
        Label_0017: {
            if (c > 0L) {
                break Label_0017;
            }
            try {
                return this.b;
                final long c2 = this.a.c();
                final long n = c + c2;
                c = c2;
                iftrue(Label_0052:)(n >= c2);
                while (true) {
                    Block_5: {
                        Block_3: {
                            break Block_3;
                            iftrue(Label_0087:)(this.b || c >= n);
                            break Block_5;
                        }
                        this.a();
                        Label_0087: {
                            return this.b;
                        }
                    }
                    this.wait(n - c);
                    c = this.a.c();
                    continue;
                }
            }
            finally {
                monitorexit(this);
            }
        }
    }
    
    public void c() {
        monitorenter(this);
        boolean b = false;
        try {
            while (!this.b) {
                try {
                    this.wait();
                }
                catch (final InterruptedException ex) {
                    b = true;
                }
            }
            if (b) {
                Thread.currentThread().interrupt();
            }
        }
        finally {
            monitorexit(this);
        }
    }
    
    public boolean d() {
        synchronized (this) {
            final boolean b = this.b;
            this.b = false;
            return b;
        }
    }
    
    public boolean e() {
        synchronized (this) {
            return this.b;
        }
    }
    
    public boolean f() {
        synchronized (this) {
            if (this.b) {
                return false;
            }
            this.b = true;
            this.notifyAll();
            return true;
        }
    }
}
