// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.exoplayer2.audio;

import com.google.android.exoplayer2.decoder.DecoderReuseEvaluation;
import com.google.android.exoplayer2.Format;

public final class d implements Runnable
{
    public final AudioRendererEventListener.EventDispatcher a;
    public final Format b;
    public final DecoderReuseEvaluation c;
    
    public d(final AudioRendererEventListener.EventDispatcher a, final Format b, final DecoderReuseEvaluation c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }
    
    @Override
    public final void run() {
        AudioRendererEventListener.EventDispatcher.e(this.a, this.b, this.c);
    }
}
