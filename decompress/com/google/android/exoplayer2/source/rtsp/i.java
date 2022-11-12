// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.exoplayer2.source.rtsp;

public final class i implements Runnable
{
    public final h a;
    
    public i(final h a) {
        this.a = a;
    }
    
    @Override
    public final void run() {
        h.b.h(this.a);
    }
}
