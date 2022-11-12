// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.exoplayer2.audio;

import com.google.android.exoplayer2.decoder.DecoderCounters;

public final class e implements Runnable
{
    public final AudioRendererEventListener.EventDispatcher a;
    public final DecoderCounters b;
    
    public e(final AudioRendererEventListener.EventDispatcher a, final DecoderCounters b) {
        this.a = a;
        this.b = b;
    }
    
    @Override
    public final void run() {
        AudioRendererEventListener.EventDispatcher.b(this.a, this.b);
    }
}
