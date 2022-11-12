// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.exoplayer2.util;

import com.google.android.exoplayer2.PlaybackParameters;

public final class StandaloneMediaClock implements MediaClock
{
    private final Clock a;
    private boolean b;
    private long c;
    private long d;
    private PlaybackParameters e;
    
    public StandaloneMediaClock(final Clock a) {
        this.a = a;
        this.e = PlaybackParameters.d;
    }
    
    public void a(final long c) {
        this.c = c;
        if (this.b) {
            this.d = this.a.c();
        }
    }
    
    @Override
    public PlaybackParameters b() {
        return this.e;
    }
    
    public void c() {
        if (!this.b) {
            this.d = this.a.c();
            this.b = true;
        }
    }
    
    @Override
    public void d(final PlaybackParameters e) {
        if (this.b) {
            this.a(this.w());
        }
        this.e = e;
    }
    
    public void e() {
        if (this.b) {
            this.a(this.w());
            this.b = false;
        }
    }
    
    @Override
    public long w() {
        long c = this.c;
        if (this.b) {
            final long n = this.a.c() - this.d;
            final PlaybackParameters e = this.e;
            long n2;
            if (e.a == 1.0f) {
                n2 = Util.C0(n);
            }
            else {
                n2 = e.b(n);
            }
            c += n2;
        }
        return c;
    }
}
