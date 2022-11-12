// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.exoplayer2.audio;

public final class h implements Runnable
{
    public final AudioRendererEventListener.EventDispatcher a;
    public final Exception b;
    
    public h(final AudioRendererEventListener.EventDispatcher a, final Exception b) {
        this.a = a;
        this.b = b;
    }
    
    @Override
    public final void run() {
        AudioRendererEventListener.EventDispatcher.d(this.a, this.b);
    }
}
