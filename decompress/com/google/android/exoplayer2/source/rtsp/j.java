// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.exoplayer2.source.rtsp;

public final class j implements Runnable
{
    public final h a;
    
    public j(final h a) {
        this.a = a;
    }
    
    @Override
    public final void run() {
        h.b.i(this.a);
    }
}
