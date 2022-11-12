// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.exoplayer2.audio;

public final class k implements Runnable
{
    public final AudioRendererEventListener.EventDispatcher a;
    public final boolean b;
    
    public k(final AudioRendererEventListener.EventDispatcher a, final boolean b) {
        this.a = a;
        this.b = b;
    }
    
    @Override
    public final void run() {
        AudioRendererEventListener.EventDispatcher.a(this.a, this.b);
    }
}
