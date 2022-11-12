// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.exoplayer2.audio;

public final class i implements Runnable
{
    public final AudioRendererEventListener.EventDispatcher a;
    public final String b;
    
    public i(final AudioRendererEventListener.EventDispatcher a, final String b) {
        this.a = a;
        this.b = b;
    }
    
    @Override
    public final void run() {
        AudioRendererEventListener.EventDispatcher.g(this.a, this.b);
    }
}
