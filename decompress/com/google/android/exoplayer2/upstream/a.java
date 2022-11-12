// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.exoplayer2.upstream;

public final class a implements Runnable
{
    public final BandwidthMeter.EventListener.EventDispatcher.a a;
    public final int b;
    public final long c;
    public final long d;
    
    public a(final BandwidthMeter.EventListener.EventDispatcher.a a, final int b, final long c, final long d) {
        this.a = a;
        this.b = b;
        this.c = c;
        this.d = d;
    }
    
    @Override
    public final void run() {
        BandwidthMeter.EventListener.EventDispatcher.a(this.a, this.b, this.c, this.d);
    }
}
