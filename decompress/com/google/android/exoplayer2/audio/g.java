// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.exoplayer2.audio;

public final class g implements Runnable
{
    public final AudioRendererEventListener.EventDispatcher a;
    public final Exception b;
    
    public g(final AudioRendererEventListener.EventDispatcher a, final Exception b) {
        this.a = a;
        this.b = b;
    }
    
    @Override
    public final void run() {
        AudioRendererEventListener.EventDispatcher.c(this.a, this.b);
    }
}
