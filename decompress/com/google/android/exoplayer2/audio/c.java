// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.exoplayer2.audio;

public final class c implements Runnable
{
    public final AudioRendererEventListener.EventDispatcher a;
    public final long b;
    
    public c(final AudioRendererEventListener.EventDispatcher a, final long b) {
        this.a = a;
        this.b = b;
    }
    
    @Override
    public final void run() {
        AudioRendererEventListener.EventDispatcher.h(this.a, this.b);
    }
}
