// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.exoplayer2.source;

public final class o implements Runnable
{
    public final MediaSourceEventListener.EventDispatcher a;
    public final MediaSourceEventListener b;
    public final MediaSource.MediaPeriodId c;
    public final MediaLoadData d;
    
    public o(final MediaSourceEventListener.EventDispatcher a, final MediaSourceEventListener b, final MediaSource.MediaPeriodId c, final MediaLoadData d) {
        this.a = a;
        this.b = b;
        this.c = c;
        this.d = d;
    }
    
    @Override
    public final void run() {
        MediaSourceEventListener.EventDispatcher.a(this.a, this.b, this.c, this.d);
    }
}
