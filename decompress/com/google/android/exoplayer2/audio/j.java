// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.exoplayer2.audio;

public final class j implements Runnable
{
    public final AudioRendererEventListener.EventDispatcher a;
    public final String b;
    public final long c;
    public final long d;
    
    public j(final AudioRendererEventListener.EventDispatcher a, final String b, final long c, final long d) {
        this.a = a;
        this.b = b;
        this.c = c;
        this.d = d;
    }
    
    @Override
    public final void run() {
        AudioRendererEventListener.EventDispatcher.f(this.a, this.b, this.c, this.d);
    }
}
